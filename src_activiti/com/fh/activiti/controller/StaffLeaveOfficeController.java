package com.fh.activiti.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.fh.dao.system.ActHiActinstDao;
import com.fh.entity.GeneralStaffLeaveOffice;
import com.fh.entity.biz.Staff;
import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.service.station.StaffService;
import com.fh.service.system.OrganiseCOService;
import com.fh.service.system.StoreEmployeeService;

/**
 * 工作流  离职申请
 */
@Controller
public class StaffLeaveOfficeController {

	@Autowired 
	private StaffService staffService;
	@Autowired 
	private Activiti activiti;
    @Autowired 
	private StoreEmployeeService storeEmployeeService;
	//历史流程 service
	@Autowired
	private ActHiActinstDao actHiActinstDao;
	@Autowired
	private OrganiseCOService organiseCOService;
	  
	// activiti 查询关联业务
	@RequestMapping("/activiti/staffLeaveOfficeToView.do")
	public String activitiToView(String taskId, Model model,String flag) {
		Task task = activiti.getTask(taskId, null, null);
		ProcessInstance pi = activiti.getProcessInstance(task.getProcessInstanceId());
		String buniness_key = pi.getBusinessKey();
		// 5: 获取BUSINESS_KEY对应的主键ID, 使用主键ID
		String buninessId = "";
		String id = "";
		if (StringUtils.isNotBlank(buniness_key)) {
			buninessId = buniness_key.split("\\.")[1]; // 截取字符串,
														// 取buniness_key小数点的第2个值
			String[] split = buninessId.split(":");
			if (split != null && split.length > 0) {
				id = split[0];
				flag=split[1];
			}
		}
			// 根据ID查询业务
			// 根据id查询记录
			Staff staff =null;
			if(id!=null && !"".equals(id)&&!"null".equals(id)){
				staff = staffService.queryStaffById(id);
			}
			if (null != staff && !"".equals(staff)) {
				List<StoreEmployeeVO> storeEmployeeVOList = new ArrayList<StoreEmployeeVO>();
				ProcessDefinitionEntity def = activiti.getProcessDefinitionEntity(task.getProcessDefinitionId());
				// 根据流程定义获得所有的节点
				ActivityImpl activityImpl = def.findActivity(pi.getActivityId());
				String activityId = activityImpl.getId();
				List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
				for (PvmTransition tr : outTransitions) {
					String substringActivityId = activityId.substring(activityId.length() - 1);
					PvmActivity destination = tr.getDestination();
					String destinationActivityId = destination.getId();
					String destinationSubstringActivityId = destinationActivityId.substring(destinationActivityId.length() - 1);
					if (!"endevent".equals(destinationActivityId) && Integer.valueOf(destinationSubstringActivityId) > Integer.valueOf(substringActivityId)) {
						// 获取线路的终点节点
						ActivityImpl ac = (ActivityImpl) destination;
						UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac.getActivityBehavior();
						TaskDefinition taskDefinition = activityBehavior.getTaskDefinition();
						Set<Expression> candidateGroupIdExpressions = taskDefinition.getCandidateGroupIdExpressions();
						for (Expression expression : candidateGroupIdExpressions) {
							String departmentCode = null;
							String[] groupRole = expression.toString().split(":");
							// 角色编号
							String groupRoleCode = groupRole[0];
							// 角色类型 0 油站 1 区域 2 总部
							String groupRoleType = groupRole[1];
							departmentCode=staff.getStationCode();
							if("1".equals(groupRoleType)){
//								DepPart depPart = depPartService.queryDeptPartByRoleId(groupRoleCode);
//								groupRoleCode=depPart.getpStorePart();
								OrganiseCO organiseCO  = this.organiseCOService.findOrganiseCOByorganiseId(departmentCode);
								departmentCode = organiseCO.getpOrganiseId();
							}
							if ("2".equals(groupRoleType)) {
								departmentCode = null;
							}
//							if("0".equals(groupRoleType)){
//								departmentCode=staff.getStationCode();
//							}
							//TODO 区域
							List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService.queryStoreEmployeeVOBypStorePart(groupRoleCode, departmentCode);
							if (storeEmployeeVO != null && storeEmployeeVO.size() > 0) {
								storeEmployeeVOList.add(storeEmployeeVO.get(0));
							}
						}
					}
				}
				model.addAttribute("storeEmployeeVOList", storeEmployeeVOList);
				model.addAttribute("staff", staff);
				model.addAttribute("taskId", taskId);

				// 返回存放连线的名称集合
				List<String> variableList = new ArrayList<String>();
				String processDefinitionId = task.getProcessDefinitionId();
				// 3：查询ProcessDefinitionEntiy对象
				ProcessDefinitionEntity processDefinitionEntity =activiti.getProcessDefinitionEntity(processDefinitionId);
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
				List<StoreEmployeeVO> storeEmployeeList = (List<StoreEmployeeVO>)session.getAttribute(SysConstant.USERS_INFO);
				model.addAttribute("storeEmployeeList", storeEmployeeList);
		}
		return "activiti/activitistaffLeaveOffice";
	}

	


	// 执行流程
	@RequestMapping("/activiti/staffLeaveOfficeExecution.do")
	public String execution(String id, String taskId, String message,String nextUserName, String outcome,String storePartNameCC,String sign) {

		// 标识
		//Integer flag = 0;

		/**
		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
		 */
		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = activiti.getTask(taskId, null, null);
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		

		Map<String, Object> variables = new HashMap<String, Object>();

		if (outcome != null && !outcome.equals("提交")) {
			variables.put("outcome", outcome);
		}

		/*// 下个节点是否为抄送任务
		if (nextUserName == null || "".equals(nextUserName)
				|| "null".equals(nextUserName)) {
			if (!"驳回".equals(outcome)) {
				ProcessInstance processInstance = activiti.getProcessInstance(processInstanceId);
				ProcessDefinitionEntity def = activiti.getProcessDefinitionEntity(processInstance.getProcessDefinitionId());
				// 根据流程定义获得所有的节点
				ActivityImpl activityImpl = def.findActivity(processInstance
						.getActivityId());
				List<PvmTransition> outTransitions = activityImpl
						.getOutgoingTransitions();
				String activityId = activityImpl.getId();
				for (PvmTransition tr : outTransitions) {
					String substringActivityId = activityId
							.substring(activityId.length() - 1);
					PvmActivity destination = tr.getDestination();
					String destinationActivityId = destination.getId();
					String destinationSubstringActivityId = destinationActivityId
							.substring(destinationActivityId.length() - 1);
					if (!"endevent".equals(destinationActivityId)
							&& Integer.valueOf(destinationSubstringActivityId) > Integer
									.valueOf(substringActivityId)) {
						// 获取线路的终点节点
						ActivityImpl ac = (ActivityImpl) destination;
						String acId = ac.getId();
						String departmentCode = null;
						String[] groupRole = acId.toString().split(
								":");
						// 角色编号
						String groupRoleCode = groupRole[0];
						// 角色类型 0 油站 1 区域 2 总部
						String groupRoleType = groupRole[1];
						if("0".equals(groupRoleType)){
							departmentCode=storeEmployee.getOrganiseId();
						}
						List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
								.queryStoreEmployeeVOBypStorePart(
										groupRoleCode, departmentCode);
						if (storeEmployeeVO != null
								&& storeEmployeeVO.size()>0) {
							nextUserName = storeEmployeeVO.get(0).getUsername();
						}
					}
				}
				flag = 1;
			}
		}*/
		variables.put("checkUser", nextUserName);
		// 3：使用任务ID，完成当前人的个人任务，同时流程变量
		
		//更新 历史记录
		activiti.updateActHiActinst(task,outcome);
		
		//检查是否存在抄送任务
		if(storePartNameCC!=null && !"".equals(storePartNameCC)){
			outcome="发送";
			activiti.ccTask(storePartNameCC, task, outcome, sign);
		}
		
		activiti.addComment(storeEmployee.getUsername(), taskId, processInstanceId, message);
		activiti.complete(taskId, variables);

		/**
		 * 5：在完成任务之后，判断流程是否结束 如果流程结束了（审核中-->审核完成）
		 */
		ProcessInstance pi = activiti.getProcessInstance(processInstanceId);
		/*if (pi != null && flag == 1) {
			Task singleTask = activiti.getTask(null, nextUserName, processInstanceId);
			this.execution(id, singleTask.getId(), null, null, null);
		}*/
		Staff staff = new Staff();
		staff.setId(Long.valueOf(id));
		// 流程结束了
		if (pi == null) {
			staff.setStaffStatus("2");
			staff.setStaffOutStatus(null);
		} else {
			staff.setStaffOutStatus("1");
		}
		staffService.updateStaffById(staff);
		return "redirect:/activiti/activitiTask.do";
	}

	/** 查询历史流程信息 */
	@RequestMapping("/activiti/staffLeaveOfficeToCheck.do")
	public String toCheck(String id, Model model) {
		String flag = "";
		List<GeneralStaffLeaveOffice> generalStaffLeaveOfficeList = new ArrayList<GeneralStaffLeaveOffice>();
		
		ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
		actHiActinstQuery.createCriteria().andProcInstIdEqualTo(id);
		actHiActinstQuery.setOrderByClause("start_time_ asc");
		List<ActHiActinst> haqs =actHiActinstDao.selectByExample(actHiActinstQuery);
		
		//List<HistoricActivityInstance> haqs = activiti.getHistoricActivityInstance(id,null);
		// 遍历查看结果
		String processInstanceId = null;
		for (ActHiActinst haq : haqs) {
			GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
			generalStaffLeaveOffice.setActHiActinst(haq);
			generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
			processInstanceId = haq.getProcInstId();
		}
/*		for (HistoricActivityInstance haq : haqs) {
			GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
			generalStaffLeaveOffice.setHistoricActivityInstance(haq);
			generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
			processInstanceId = haq.getProcessInstanceId();
		}
*/		HistoricProcessInstance pi = activiti.getHistoricProcessInstance(processInstanceId);
		String buniness_key = pi.getBusinessKey();
		String buninessId = "";
		String bid = "";
		if (StringUtils.isNotBlank(buniness_key)) {
			// 截取字符串，取buniness_key小数点的第2个值
			buninessId = buniness_key.split("\\.")[1];
			if (StringUtils.isNotBlank(buninessId) && buninessId != null) {
				String[] split = buninessId.split(":");
				if (split != null && split.length > 0) {
					bid = split[0];
					flag = split[1];
				}
			}
		}
		model.addAttribute("list", generalStaffLeaveOfficeList);
		// 根据ID查询业务
		if (bid != null || !"".equals(bid) || !"null".equals(bid)) {
			if (bid.contains(",")) {
				String[] split = bid.split(",");
				for (String string : split) {
					Staff staff = staffService.queryStaffById(string);
					model.addAttribute("staff", staff);
				}
			}else{
				 Staff staff = staffService.queryStaffById(bid);
				 model.addAttribute("staff", staff);
			}
		}
		model.addAttribute("flag", flag);
		return "activiti/historicactivitistaffLeaveOffice";
	}


}
