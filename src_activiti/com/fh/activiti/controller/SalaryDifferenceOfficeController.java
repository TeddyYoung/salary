package com.fh.activiti.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.activiti.service.Activiti;
import com.fh.common.SysConstant;
import com.fh.dao.biz.SalaryDifferenceDao;
import com.fh.dao.system.ActHiActinstDao;
import com.fh.entity.GeneralStaffLeaveOffice;
import com.fh.entity.biz.SalaryDifference;
import com.fh.entity.biz.SalaryDifferenceQuery;
import com.fh.entity.biz.SalaryDifferenceVO;
import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import com.fh.entity.system.Flag;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.entity.system.UserStorePart;
import com.fh.service.salarymanagement.SalaryDifferenceService;
import com.fh.service.station.StaffService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.service.system.UserStorePartService;
import com.fh.util.DateUtil;

/**
 * 工作流: 薪资差异申请
 * 
 * @author zhang_yu
 *
 */
@Controller
public class SalaryDifferenceOfficeController {

	@Autowired
	private StaffService staffService;
	@Autowired
	private Activiti activiti;
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	@Autowired
	private ActHiActinstDao actHiActinstDao;
	@Autowired
	private SalaryDifferenceService salaryDifferenceService;
	@Autowired
	private SalaryDifferenceDao salaryDifferenceDao;
	@Autowired
	private UserStorePartService userStorePartService;

	@RequestMapping("/activiti/salaryDifferenceToView.do")
	public String activitiToView(HttpServletRequest request, String taskId,
			Model model, String flag) {

		// 获取当前登录者信息
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession()
				.getAttribute(SysConstant.CURRENT_USER_INFO);
		UserStorePart userStorePart = userStorePartService
				.findUserStorePartByUserId(storeEmployee.getUserid());
		if ("R_001".equals(userStorePart.getStorePart())) {
			Flag flag2 = new Flag();
			flag2.setFlag("rlzyb");
			model.addAttribute("Flag", flag2);
		}

		Task task = activiti.getTask(taskId, null, null);
		String yearMonth = DateUtil.getYM(DateUtil.addMonth(
				task.getCreateTime(), -1));
		ProcessInstance pi = activiti.getProcessInstance(task
				.getProcessInstanceId());
		String buniness_key = pi.getBusinessKey();
		// 5: 获取BUSINESS_KEY对应的主键ID, 使用主键ID
		String buninessId = null;
		String id = null;
		String[] ids = null;
		String stationCode = "";
		if (StringUtils.isNotBlank(buniness_key)) {
			buninessId = buniness_key.split("\\.")[1]; // 截取字符串,
														// 取buniness_key小数点的第2个值
			String[] split = buninessId.split(":");
			if (split != null && split.length > 0) {
				id = split[0];
				ids = id.split(",");
				flag = split[1];
				stationCode = split[2];
			}
		}
		// 根据之前的员工编号平成的字符串, 再将员工的薪资差异记录查出来
		List<SalaryDifference> salaryDifferenceList = null;
		if (null != ids && ids.length != 0) {
			salaryDifferenceList = new ArrayList<SalaryDifference>();
			salaryDifferenceList = salaryDifferenceService.findByStaffCodes(
					stationCode, yearMonth, ids);
		}
		if (null != salaryDifferenceList && salaryDifferenceList.size() != 0) {
			List<StoreEmployeeVO> storeEmployeeVOList = new ArrayList<StoreEmployeeVO>();
			ProcessDefinitionEntity def = activiti
					.getProcessDefinitionEntity(task.getProcessDefinitionId());
			// 根据流程定义获得所有的节点
			ActivityImpl activityImpl = def.findActivity(pi.getActivityId());
			String activityId = activityImpl.getId();
			List<PvmTransition> outTransitions = activityImpl
					.getOutgoingTransitions();
			for (PvmTransition tr : outTransitions) {
				String substringActivityId = activityId.substring(activityId
						.length() - 1);
				PvmActivity destination = tr.getDestination();
				String destinationActivityId = destination.getId();
				String destinationSubstringActivityId = destinationActivityId
						.substring(destinationActivityId.length() - 1);
				if (!"endevent".equals(destinationActivityId)
						&& Integer.valueOf(destinationSubstringActivityId) > Integer
								.valueOf(substringActivityId)) {
					// 获取线路的终点节点
					ActivityImpl ac = (ActivityImpl) destination;
					UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac
							.getActivityBehavior();
					TaskDefinition taskDefinition = activityBehavior
							.getTaskDefinition();
					Set<Expression> candidateGroupIdExpressions = taskDefinition
							.getCandidateGroupIdExpressions();
					for (Expression expression : candidateGroupIdExpressions) {
						String departmentCode = null;
						String[] groupRole = expression.toString().split(":");
						// 角色编号
						String groupRoleCode = groupRole[0];
						// 角色类型 0 油站 1 区域 2 总部
						String groupRoleType = groupRole[1];
						if ("0".equals(groupRoleType)) {
							departmentCode = storeEmployee.getOrganiseId();
						}
						// TODO 区域
						List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
								.queryStoreEmployeeVOBypStorePart(
										groupRoleCode, departmentCode);
						if (storeEmployeeVO != null
								&& storeEmployeeVO.size() > 0) {
							storeEmployeeVOList.add(storeEmployeeVO.get(0));
						}
					}
				}
			}
			model.addAttribute("storeEmployeeVOList", storeEmployeeVOList);
			model.addAttribute("salaryDifferenceList", salaryDifferenceList);
			model.addAttribute("taskId", taskId);

			// 返回存放连线的名称集合
			List<String> variableList = new ArrayList<String>();
			String processDefinitionId = task.getProcessDefinitionId();
			// 3：查询ProcessDefinitionEntiy对象
			ProcessDefinitionEntity processDefinitionEntity = activiti
					.getProcessDefinitionEntity(processDefinitionId);
			// 获取当前活动的id
			String aId = pi.getActivityId();
			// 4：获取当前的活动
			ActivityImpl aImpl = processDefinitionEntity.findActivity(aId);
			// 5：获取当前活动完成之后连线的名称
			List<PvmTransition> pvmList = aImpl.getOutgoingTransitions();
			if (pvmList != null && pvmList.size() > 0) {
				for (PvmTransition pvm : pvmList) {
					String name = (String) pvm.getProperty("name");
					if (StringUtils.isNotBlank(name)) {
						variableList.add(name);
					} else {
						variableList.add("提交");
					}
				}
			}
			model.addAttribute("variableList", variableList);
			// 获取批注信息
			List<Comment> list = new ArrayList<Comment>();
			activiti.getComment(task.getProcessInstanceId());
			model.addAttribute("list", list);
			model.addAttribute("task", task);
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();

			@SuppressWarnings("unchecked")
			List<StoreEmployeeVO> storeEmployeeList = (List<StoreEmployeeVO>) session
					.getAttribute(SysConstant.USERS_INFO);
			model.addAttribute("storeEmployeeList", storeEmployeeList);
		}
		return "activiti/activitisalaryDifferenceOffice";

	}

	// 区域经理或人力资源部批准执行或驳回
	@RequestMapping("/activiti/salaryDifferenceExecution.do")
	public String execution(SalaryDifferenceVO salaryDifferenceVO, String id,
			String taskId, String message, String nextUserName, String outcome,
			String storePartNameCC, String sign) {

		/**
		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
		 */
		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = activiti.getTask(taskId, null, null);
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		Map<String, Object> variables = new HashMap<String, Object>();

		if (outcome != null && !outcome.equals("提交")) { // outcome = 批准,驳回
			variables.put("outcome", outcome);
		}
		variables.put("checkUser", nextUserName);
		// 3：使用任务ID，完成当前人的个人任务，同时流程变量
		// 更新 历史记录
		activiti.updateActHiActinst(task, outcome);
		// 检查是否存在抄送任务
		if (storePartNameCC != null && !"".equals(storePartNameCC)) {
			outcome = "发送";
			activiti.ccTask(storePartNameCC, task, outcome, sign);
		}
		activiti.addComment(storeEmployee.getUsername(), taskId,
				processInstanceId, message);
		activiti.complete(taskId, variables);
		/**
		 * 5：在完成任务之后，判断流程是否结束 如果流程结束了（审核中-->审核完成）
		 */
		ProcessInstance pi = activiti.getProcessInstance(processInstanceId);
		/**
		 * 如果流程结束了: 那么, 将审批状态改为已审批, 应发工资和差异工资设置进去, 保存记录等下个月薪资来合并
		 */
		if (null == pi) { // 流程结束
			List<SalaryDifference> salaryDifferenceList = salaryDifferenceVO
					.getSalaryDifferenceList();
			SalaryDifferenceQuery salaryDifferenceQuery = null;
			for (SalaryDifference salaryDifference : salaryDifferenceList) {
				salaryDifference.setApprovalStatus("2");
				salaryDifferenceQuery = new SalaryDifferenceQuery();
				salaryDifferenceQuery.createCriteria().andStaffCodeEqualTo(
						salaryDifference.getStaffCode());
				salaryDifferenceDao.updateByExampleSelective(salaryDifference,
						salaryDifferenceQuery);
			}
		}
		return "redirect:/activiti/activitiTask.do";
	}

	/**
	 * 查看历史薪资差异流程信息
	 */
	@RequestMapping("/activiti/salaryDifferenceToCheck.do")
	public String toCheck(String id, Model model) {
		String flag = "";
		List<GeneralStaffLeaveOffice> generalStaffLeaveOfficeList = new ArrayList<GeneralStaffLeaveOffice>();

		ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
		actHiActinstQuery.createCriteria().andProcInstIdEqualTo(id);
		actHiActinstQuery.setOrderByClause("start_time_ asc");
		List<ActHiActinst> haqs = actHiActinstDao
				.selectByExample(actHiActinstQuery);

		// 遍历查看结果
		String processInstanceId = null;
		for (ActHiActinst haq : haqs) {
			GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
			generalStaffLeaveOffice.setActHiActinst(haq);
			generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
			processInstanceId = haq.getProcInstId();
		}

		HistoricProcessInstance pi = activiti
				.getHistoricProcessInstance(processInstanceId);
		String yearMomth = DateUtil.getYM(DateUtil.addMonth(pi.getStartTime(),
				-1));
		String buniness_key = pi.getBusinessKey();
		String buninessId = "";
		String bid = "";
		String stationCode = "";
		if (StringUtils.isNotBlank(buniness_key)) {
			// 截取字符串，取buniness_key小数点的第2个值
			buninessId = buniness_key.split("\\.")[1];
			if (StringUtils.isNotBlank(buninessId) && buninessId != null) {
				String[] split = buninessId.split(":");
				if (split != null && split.length > 0) {
					bid = split[0];
					flag = split[1];
					stationCode = split[2];
				}
			}
		}
		model.addAttribute("list", generalStaffLeaveOfficeList);
		// 根据ID查询业务
		List<SalaryDifference> salaryDifferenceList = null;
		if (bid != null || !"".equals(bid) || !"null".equals(bid)) {
			String[] split = bid.split(",");
			if (null != split && split.length != 0) {
				salaryDifferenceList = salaryDifferenceService
						.findByStaffCodes(stationCode, yearMomth, split);
			}
		}
		model.addAttribute("salaryDifferenceList", salaryDifferenceList);
		model.addAttribute("flag", flag);
		return "activiti/historicactivitisalaryDifferenceOffice";
	}

}
