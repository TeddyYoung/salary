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
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffTransfer;
import com.fh.entity.biz.StaffTransferQuery;
import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.service.station.StaffService;
import com.fh.service.system.StoreEmployeeService;

/**
 * 工作流  调动申请
 */
@Controller
public class StaffTransferController {

	
	  @Autowired 
	  private StaffTransferDao staffTransferDao;
	  
	  @Autowired 
	  private Activiti activiti;
	  
	  @Autowired 
	  private StoreEmployeeService storeEmployeeService;
	  
	  @Autowired 
	  private StaffService staffService;
	  
	  //历史流程 service
	  @Autowired
	  private ActHiActinstDao actHiActinstDao;
	  
	// activiti 查询关联业务
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("/activiti/staffTransferToView.do")
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
				//flag=split[1];
			}
		}
			// 根据ID查询业务
			// 根据id查询记录
			StaffTransfer staffTransfer =null;
			if(id!=null && !"".equals(id)&&!"null".equals(id)){
				StaffTransferQuery staffTransferQuery = new StaffTransferQuery();
				staffTransferQuery.createCriteria().andTransferCodeEqualTo(id);
				List<StaffTransfer> staffTransferList = staffTransferDao.selectByExample(staffTransferQuery);
				if(staffTransferList!=null&&staffTransferList.size()>0)
				staffTransfer = staffTransferList.get(0);
			}
			if (null != staffTransfer && !"".equals(staffTransfer)) {
				List<StoreEmployeeVO> storeEmployeeVOList = new ArrayList<StoreEmployeeVO>();
				ProcessDefinitionEntity def = activiti.getProcessDefinitionEntity(task.getProcessDefinitionId());
				// 根据流程定义获得所有的节点
				ActivityImpl activityImpl = def
						.findActivity(pi.getActivityId());
				String activityId = activityImpl.getId();
				List<PvmTransition> outTransitions = activityImpl
						.getOutgoingTransitions();
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
						UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac
								.getActivityBehavior();
						TaskDefinition taskDefinition = activityBehavior
								.getTaskDefinition();
						Set<Expression> candidateGroupIdExpressions = taskDefinition
								.getCandidateGroupIdExpressions();
						for (Expression expression : candidateGroupIdExpressions) {
							String departmentCode = null;
							String[] groupRole = expression.toString().split(
									":");
							// 角色编号
							String groupRoleCode = groupRole[0];
							// 角色类型 0 油站 1 区域 2 总部
							String groupRoleType = groupRole[1];
							if("0".equals(groupRoleType)){
								departmentCode=staffTransfer.getBeforeStationCode();
							}
							//TODO 区域
							List<StoreEmployeeVO> storeEmployeeVO = storeEmployeeService
									.queryStoreEmployeeVOBypStorePart(
											groupRoleCode, departmentCode);
							if (storeEmployeeVO != null
									&& storeEmployeeVO.size()>0) {
								storeEmployeeVOList.add(storeEmployeeVO.get(0));
							}
						}
					}
				}
				Staff staff=staffService.queryStaffByStaffCode(staffTransfer.getStaffCode(),staffTransfer.getBeforeStationCode());
				if(staff!=null &&!"".equals(staff))
					staffTransfer.setStaff(staff);
				model.addAttribute("storeEmployeeVOList", storeEmployeeVOList);
				model.addAttribute("staffTransfer", staffTransfer);
				model.addAttribute("taskId", taskId);
				model.addAttribute("flag", flag);

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
//							variableList.add("提交");
							variableList.add("批准");// TODO
						}
					}
				}
				model.addAttribute("variableList", variableList);
				// 获取批注信息
				List<Comment> list = new ArrayList<Comment>();
				list = activiti.getComment(task.getProcessInstanceId());
				model.addAttribute("list", list);
				model.addAttribute("task", task);
				
				Subject currentUser = SecurityUtils.getSubject();
				Session session = currentUser.getSession();
				
				List<StoreEmployeeVO> storeEmployeeList = (List<StoreEmployeeVO>)session.getAttribute(SysConstant.USERS_INFO);
				model.addAttribute("storeEmployeeList", storeEmployeeList);
			}
		return "activiti/activitiStaffTransfer";
	}

	


	// 执行流程
	@RequestMapping("/activiti/staffTransferExecution.do")
	public String execution(String id, String taskId, String message,String nextUserName, String outcome,String storePartNameCC,String sign) {

		StaffTransfer staffTransfer = staffTransferDao.selectByPrimaryKey(Long.valueOf(id));
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

		// 下个节点是否为抄送任务
		/*if (nextUserName == null || "".equals(nextUserName)
				|| "null".equals(nextUserName)) {
			if (!"驳回".equals(outcome)) {
				ProcessInstance processInstance = activiti.getProcessInstance(processInstanceId);
				ProcessDefinitionEntity def = activiti.getProcessDefinitionEntity(processInstance.getProcessDefinitionId());
				// 根据流程定义获得当前的节点
				ActivityImpl activityImpl = def.findActivity(processInstance
						.getActivityId());
				List<PvmTransition> outTransitions = activityImpl
						.getOutgoingTransitions();
				PvmTransition tr= null;
				if(outTransitions!=null && outTransitions.size()>0){
					tr=outTransitions.get(0);
					PvmActivity destination = tr.getDestination();
					String destinationActivityId = destination.getId();
					if (!"endevent".equals(destinationActivityId)) {
						// 获取线路的终点节点
						ActivityImpl ac = (ActivityImpl) destination;
						String acId = ac.getId();
						String departmentCode = null;
						String[] groupRole = acId.toString().split(
								"-");
						// 角色编号
						String groupRoleCode = groupRole[0];
						// 角色类型 0 油站 1 区域 2 总部
						String groupRoleType = groupRole[1];
						if("0".equals(groupRoleType)){
							departmentCode=staffTransfer.getAfterStationCode();
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
		}else{
			activiti.addComment(storeEmployee.getUsername(), taskId, processInstanceId, message);
		}*/
		activiti.addComment(storeEmployee.getUsername(), taskId, processInstanceId, message);
		variables.put("checkUser", nextUserName);
		
		
		//更新 历史记录
		activiti.updateActHiActinst(task,outcome);
		
		//检查是否存在抄送任务
		if(storePartNameCC!=null && !"".equals(storePartNameCC)){
			outcome="发送";
			activiti.ccTask(storePartNameCC, task, outcome, sign);
		}
		
		
		
		// 3：使用任务ID，完成当前人的个人任务，同时流程变量
		activiti.complete(taskId, variables);
		
	
		/**
		 * 5：在完成任务之后，判断流程是否结束 如果流程结束了（审核中-->审核完成）
		 */
		ProcessInstance pi = activiti.getProcessInstance(processInstanceId);
		/*if (pi != null && flag == 1) {
			Task singleTask = activiti.getTask(null, nextUserName, processInstanceId);
			this.execution(id, singleTask.getId(), null, null, null,null,null);
		}*/
		
		Staff staff=staffService.queryStaffByStaffCode(staffTransfer.getStaffCode(),staffTransfer.getBeforeStationCode());
		if(staff!=null && !"".equals(staff)){
			staff.setStaffCode(staffTransfer.getStaffCode());
			// 流程结束了
			if (pi == null) {
				staff.setDutyCode(staffTransfer.getAfterDutyCode());
				staff.setStationCode(staffTransfer.getAfterStationCode());
				staff.setStaffOutStatus(null);
			} else {
				staff.setStaffOutStatus("1");
			}
			staffService.saveOrUpdate(null, null, null, staff, null);
		}
		return "redirect:/activiti/activitiTask.do";
	}

	/** 查询历史流程信息 */
	@RequestMapping("/activiti/staffTransferToCheck.do")
	public String toCheck(String id, Model model) {
		String flag = "";
		List<StaffTransfer> staffTransferList = new ArrayList<StaffTransfer>();

		ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
		actHiActinstQuery.createCriteria().andProcInstIdEqualTo(id);
		actHiActinstQuery.setOrderByClause("start_time_ asc");
		List<ActHiActinst> haqs =actHiActinstDao.selectByExample(actHiActinstQuery);
		
		//List<HistoricActivityInstance> haqs = activiti.getHistoricActivityInstance(id,null);
		// 遍历查看结果
		String processInstanceId = null;
		for (ActHiActinst haq : haqs) {
			StaffTransfer staffTransfer = new StaffTransfer();
			staffTransfer.setActHiActinst(haq);
			staffTransferList.add(staffTransfer);
			processInstanceId = haq.getProcInstId();
		}
/*		for (HistoricActivityInstance haq : haqs) {
			StaffTransfer staffTransfer = new StaffTransfer();
			staffTransfer.setHistoricActivityInstance(haq);
			staffTransferList.add(staffTransfer);
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
		model.addAttribute("list", staffTransferList);
		// 根据ID查询业务
		if (bid != null || !"".equals(bid) || !"null".equals(bid)) {
			 StaffTransferQuery staffTransferQuery = new StaffTransferQuery();
			 staffTransferQuery.createCriteria().andTransferCodeEqualTo(bid);
			 List<StaffTransfer> selectByExample = staffTransferDao.selectByExample(staffTransferQuery);
			 if(selectByExample!=null && selectByExample.size()>0){
				 StaffTransfer staffTransfer = selectByExample.get(0);
				 Staff staff = staffService.queryStaffByStaffCode(staffTransfer.getStaffCode(),staffTransfer.getBeforeStationCode());
				 staffTransfer.setStaff(staff);
				 model.addAttribute("staffTransfer",staffTransfer); 
			 }
		}
		model.addAttribute("flag", flag);
		return "activiti/historicActivitiStaffTransfer";
	}


}
