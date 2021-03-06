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
import com.fh.dao.biz.StaffTransferDao;
import com.fh.dao.system.ActHiActinstDao;
import com.fh.entity.biz.AttendanceManagement;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffTransfer;
import com.fh.entity.biz.StaffTransferQuery;
import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.service.attendance.AttendanceManagementService;
import com.fh.service.station.StaffService;
import com.fh.service.system.OrganiseCOService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.util.AutoYearMonth;
import com.fh.util.Constants;

/**
 * 工作流 - 考勤数据审批
 */
@Controller
@RequestMapping({ "/activiti/attendance" })
public class AttendanceManageController {

	@Autowired
	private Activiti activiti;
	@Autowired
	private ActHiActinstDao actHiActinstDao;// 历史流程 service
	@Autowired
	private StaffTransferDao staffTransferDao;
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private OrganiseCOService organiseCOService;
	@Autowired
	private AttendanceManagementService attendanceManagementService;

	// activiti 查询关联业务
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/toView.do")
	public String activitiToView(String taskId, Model model, String flag) {
		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		Task task = activiti.getTask(taskId, null, null);
		ProcessInstance pi = activiti.getProcessInstance(task
				.getProcessInstanceId());
		String buniness_key = pi.getBusinessKey();
		// 5: 获取BUSINESS_KEY对应的主键ID, 使用主键ID
		String buninessId = "";
		// String id = "";
		String stationCode = "";
		String isMod = Constants.NO_FLAG;
		if (StringUtils.isNotBlank(buniness_key)) {
			buninessId = buniness_key.split("\\.")[1]; // 截取字符串,
														// 取buniness_key小数点的第2个值
			String[] split = buninessId.split(":");
			if (split != null && split.length > 0) {
				// id = split[0];
				// flag=split[1];
				stationCode = split[2];
				model.addAttribute("stationCode", stationCode);
			}
		}
		// 根据ID查询业务
		// 根据id查询记录
		// StaffTransfer staffTransfer =null;
		// if(id!=null && !"".equals(id)&&!"null".equals(id)){
		// StaffTransferQuery staffTransferQuery = new StaffTransferQuery();
		// staffTransferQuery.createCriteria().andTransferCodeEqualTo(id);
		// List<StaffTransfer> staffTransferList =
		// staffTransferDao.selectByExample(staffTransferQuery);
		// if(staffTransferList!=null&&staffTransferList.size()>0)
		// staffTransfer = staffTransferList.get(0);
		// }
		// if (null != staffTransfer && !"".equals(staffTransfer)) {
		List<StoreEmployeeVO> storeEmployeeVOList = new ArrayList<StoreEmployeeVO>();
		ProcessDefinitionEntity def = activiti.getProcessDefinitionEntity(task
				.getProcessDefinitionId());
		// 根据流程定义获得所有的节点
		ActivityImpl activityImpl = def.findActivity(pi.getActivityId());
		// String activityId = activityImpl.getId();
		List<PvmTransition> outTransitions = activityImpl
				.getOutgoingTransitions();
		for (PvmTransition tr : outTransitions) {
			// String substringActivityId = activityId
			// .substring(activityId.length() - 1);
			PvmActivity destination = tr.getDestination();
			String destinationActivityId = destination.getId();
			// String destinationSubstringActivityId = destinationActivityId
			// .substring(destinationActivityId.length() - 1);
			// if (!"endevent".equals(destinationActivityId)
			// && Integer.valueOf(destinationSubstringActivityId) > Integer
			// .valueOf(substringActivityId)) {
			if (!"endevent".equals(destinationActivityId)) {
				// 获取线路的终点节点
				ActivityImpl ac = (ActivityImpl) destination;
				UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac
						.getActivityBehavior();
				TaskDefinition taskDefinition = activityBehavior
						.getTaskDefinition();
				Set<Expression> candidateGroupIdExpressions = taskDefinition
						.getCandidateGroupIdExpressions();
				for (Expression expression : candidateGroupIdExpressions) {
					String departmentCode = storeEmployee.getOrganiseId();
					;
					String[] groupRole = expression.toString().split(":");
					// 角色编号
					String groupRoleCode = groupRole[0];
					String groupRoleType = groupRole[1];// 角色类型 0 油站 1 区域 2 总部
					// String groupRoleType = groupRole[1];
					// if("0".equals(groupRoleType)){
					// departmentCode=staffTransfer.getBeforeStationCode();
					// }
					if ("1".equals(groupRoleType)) {
						OrganiseCO organiseCO = this.organiseCOService
								.findOrganiseCOByorganiseId(departmentCode);
						departmentCode = organiseCO.getpOrganiseId();
					}
					List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
							.queryStoreEmployeeVOBypStorePart(groupRoleCode,
									departmentCode);
					if (storeEmployeeVO != null && storeEmployeeVO.size() > 0) {
						storeEmployeeVOList.add(storeEmployeeVO.get(0));
					}
				}
			}
		}
		// Staff
		// staff=staffService.queryStaffByStaffCode(staffTransfer.getStaffCode());
		// if(staff!=null &&!"".equals(staff))
		// staffTransfer.setStaff(staff);
		model.addAttribute("storeEmployeeVOList", storeEmployeeVOList);
		// model.addAttribute("staffTransfer", staffTransfer);
		model.addAttribute("taskId", taskId);
		model.addAttribute("flag", flag);

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
				if (StringUtils.isEmpty(name)) {
					name = "提交";
				}
				variableList.add(name);
				if ("提交".equals(name)) {
					isMod = Constants.YES_FLAG;
				}
			}
		}
		model.addAttribute("isMod", isMod);
		model.addAttribute("variableList", variableList);
		// 获取历史审批信息
		ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
		actHiActinstQuery.createCriteria().andProcInstIdEqualTo(
				task.getProcessInstanceId());
		actHiActinstQuery.setOrderByClause("start_time_ asc");
		List<ActHiActinst> haqs = actHiActinstDao
				.selectByExample(actHiActinstQuery);
		List<Comment> commentlist = activiti.getComment(task.getProcessInstanceId());
		Map<String, String> commentMap = new HashMap<String, String>();
		if(commentlist != null){
			for(Comment comment : commentlist){
				commentMap.put(comment.getTaskId(), comment.getFullMessage());
			}
		}
		model.addAttribute("comment", commentMap);
		model.addAttribute("list", haqs);
		model.addAttribute("task", task);

		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();

		List<StoreEmployeeVO> storeEmployeeList = (List<StoreEmployeeVO>) session
				.getAttribute(SysConstant.USERS_INFO);
		model.addAttribute("storeEmployeeList", storeEmployeeList);
		// }
		return "activiti/activitiAttendance";
	}

	// 执行流程
	@RequestMapping("/execution.do")
	public String execution(String id, String taskId, String message,
			String nextUserName, String outcome, String storePartNameCC,
			String sign) {

		// StaffTransfer staffTransfer =
		// staffTransferDao.selectByPrimaryKey(Long.valueOf(id));
		/**
		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
		 */
		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = activiti.getTask(taskId, null, null);
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		Map<String, Object> variables = new HashMap<String, Object>();

		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		ProcessInstance pi = activiti.getProcessInstance(processInstanceId);

		String buniness_key = pi.getBusinessKey();
		String stationCode = "";
		if (StringUtils.isNotBlank(buniness_key)) {
			String buninessId = buniness_key.split("\\.")[1]; // 截取字符串,
			String[] split = buninessId.split(":");
			if (split != null && split.length > 0) {
				stationCode = split[2];
			}
		}
		if (outcome != null && !outcome.equals("提交")) {
			variables.put("outcome", outcome);
		}

		// 下个节点是否为抄送任务
		/*
		 * if (nextUserName == null || "".equals(nextUserName) ||
		 * "null".equals(nextUserName)) { if (!"驳回".equals(outcome)) {
		 * ProcessInstance processInstance =
		 * activiti.getProcessInstance(processInstanceId);
		 * ProcessDefinitionEntity def =
		 * activiti.getProcessDefinitionEntity(processInstance
		 * .getProcessDefinitionId()); // 根据流程定义获得当前的节点 ActivityImpl
		 * activityImpl = def.findActivity(processInstance .getActivityId());
		 * List<PvmTransition> outTransitions = activityImpl
		 * .getOutgoingTransitions(); PvmTransition tr= null;
		 * if(outTransitions!=null && outTransitions.size()>0){
		 * tr=outTransitions.get(0); PvmActivity destination =
		 * tr.getDestination(); String destinationActivityId =
		 * destination.getId(); if (!"endevent".equals(destinationActivityId)) {
		 * // 获取线路的终点节点 ActivityImpl ac = (ActivityImpl) destination; String
		 * acId = ac.getId(); String departmentCode = null; String[] groupRole =
		 * acId.toString().split( "-"); // 角色编号 String groupRoleCode =
		 * groupRole[0]; // 角色类型 0 油站 1 区域 2 总部 String groupRoleType =
		 * groupRole[1]; if("0".equals(groupRoleType)){
		 * departmentCode=staffTransfer.getAfterStationCode(); }
		 * List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
		 * .queryStoreEmployeeVOBypStorePart( groupRoleCode, departmentCode); if
		 * (storeEmployeeVO != null && storeEmployeeVO.size()>0) { nextUserName
		 * = storeEmployeeVO.get(0).getUsername(); } } } flag = 1; } }else{
		 * activiti.addComment(storeEmployee.getUsername(), taskId,
		 * processInstanceId, message); }
		 */
		activiti.addComment(storeEmployee.getUsername(), taskId,
				processInstanceId, message);
		variables.put("checkUser", nextUserName);

		// 更新 历史记录
		activiti.updateActHiActinst(task, outcome);

		// 检查是否存在抄送任务
		if (storePartNameCC != null && !"".equals(storePartNameCC)) {
			outcome = "发送";
			activiti.ccTask(storePartNameCC, task, outcome, sign);
		}

		// 3：使用任务ID，完成当前人的个人任务，同时流程变量
		activiti.complete(taskId, variables);

		/**
		 * 5：在完成任务之后，判断流程是否结束 如果流程结束了（审核中-->审核完成）
		 */
		/*
		 * if (pi != null && flag == 1) { Task singleTask =
		 * activiti.getTask(null, nextUserName, processInstanceId);
		 * this.execution(id, singleTask.getId(), null, null, null,null,null); }
		 */
		// TODO 这里修改最终的考勤数据
		if ("批准".equals(outcome)) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			List<AttendanceManagement> attendanceManagementList = attendanceManagementService
					.findByCriteriaQuery(yearMonth, stationCode,
							AttendanceManagement.STATUS_SUBMITTED);
			if (attendanceManagementList != null) {
				for (AttendanceManagement atten : attendanceManagementList) {
					atten.setStatus(AttendanceManagement.STATUS_APPROVED);
					attendanceManagementService.update(atten);
				}
			}
		}
		return "redirect:/activiti/activitiTask.do";
	}

	/** 查询历史流程信息 */
	@RequestMapping("/toCheck.do")
	public String toCheck(String id, Model model) {
		String flag = "";
		List<StaffTransfer> staffTransferList = new ArrayList<StaffTransfer>();

		ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
		actHiActinstQuery.createCriteria().andProcInstIdEqualTo(id);
		actHiActinstQuery.setOrderByClause("start_time_ asc");
		List<ActHiActinst> haqs = actHiActinstDao
				.selectByExample(actHiActinstQuery);

		// List<HistoricActivityInstance> haqs =
		// activiti.getHistoricActivityInstance(id,null);
		// 遍历查看结果
		String processInstanceId = null;
		for (ActHiActinst haq : haqs) {
			StaffTransfer staffTransfer = new StaffTransfer();
			staffTransfer.setActHiActinst(haq);
			staffTransferList.add(staffTransfer);
			processInstanceId = haq.getProcInstId();
		}
		/*
		 * for (HistoricActivityInstance haq : haqs) { StaffTransfer
		 * staffTransfer = new StaffTransfer();
		 * staffTransfer.setHistoricActivityInstance(haq);
		 * staffTransferList.add(staffTransfer); processInstanceId =
		 * haq.getProcessInstanceId(); }
		 */HistoricProcessInstance pi = activiti
				.getHistoricProcessInstance(processInstanceId);
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
					if(split.length > 2){
						stationCode = split[2];
					}
				}
			}
		}
		model.addAttribute("stationCode", stationCode);
		model.addAttribute("list", staffTransferList);
		// 根据ID查询业务
		if (bid != null || !"".equals(bid) || !"null".equals(bid)) {
			StaffTransferQuery staffTransferQuery = new StaffTransferQuery();
			staffTransferQuery.createCriteria().andTransferCodeEqualTo(bid);
			List<StaffTransfer> selectByExample = staffTransferDao
					.selectByExample(staffTransferQuery);
			if (selectByExample != null && selectByExample.size() > 0) {
				StaffTransfer staffTransfer = selectByExample.get(0);
				Staff staff = staffService.queryStaffByStaffCode(
						staffTransfer.getStaffCode(),
						staffTransfer.getBeforeStationCode());
				staffTransfer.setStaff(staff);
				model.addAttribute("staffTransfer", staffTransfer);
			}
		}
		model.addAttribute("flag", flag);
		return "activiti/historicActivitiAttendance";
	}

}
