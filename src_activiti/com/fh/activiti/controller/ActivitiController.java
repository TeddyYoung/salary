package com.fh.activiti.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fh.activiti.service.Activiti;
import com.fh.common.SysConstant;
import com.fh.dao.system.ActHiActinstDao;
import com.fh.dao.system.CcTaskDao;
import com.fh.entity.GeneralStaffLeaveOffice;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.Station;
import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import com.fh.entity.system.CcTask;
import com.fh.entity.system.CcTaskQuery;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.station.StaffService;
import com.fh.service.station.StationService;

/**
 * 工作流
 */
@Controller
public class ActivitiController {

	// 流程部署service
	@Autowired
	private RepositoryService repositoryService;

	//启动流程 service
	@Autowired
	private RuntimeService runtimeService;

	//任务 service
	@Autowired
	private TaskService taskService;

	//员工 service
	@Autowired
	private StaffService staffService;
	
	//抄送 service
	@Autowired
	private CcTaskDao ccTaskDao;
	
	//历史流程 service
	@Autowired
	private ActHiActinstDao actHiActinstDao;
	
	//工作流工具类
	@Autowired
	private Activiti activiti;
	
	@Autowired
	private StationService stationService;

	// 跳转activiti发布页面
	@RequestMapping("/activiti/todeploy.do")
	public String toDeployProcess() {
		return "activiti/deployProcess";
	}

	// 上传dpmn发布
	@RequestMapping("/activiti/deploy.do")
	public String deployProcess(Model model,
			@RequestParam(required = false) MultipartFile resourcebpmn,
			@RequestParam(required = false) MultipartFile resourcepng,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取上传的文件名称
		String bpmnFilename = resourcebpmn.getOriginalFilename();
		String pngFilename = resourcepng.getOriginalFilename();
		Deployment deploy = repositoryService.createDeployment()
				.addInputStream(bpmnFilename, resourcebpmn.getInputStream())
				.addInputStream(pngFilename, resourcepng.getInputStream())
				.deploy();
		System.out.println("流程部署的id：" + deploy.getId());
		System.out.println("流程部署的时间：" + deploy.getDeploymentTime());

		// 流程定义查询
		ProcessDefinitionQuery processDefinitionQuery = repositoryService
				.createProcessDefinitionQuery();
		List<ProcessDefinition> list = processDefinitionQuery.list();
		model.addAttribute("list", list);
		return "activiti/queryProcessDefinition";
	}

	// 查询流程定义列表
	@RequestMapping("/activiti/queryProcessDefinition.do")
	public String deploy(Model model) {
		// 流程定义查询
		ProcessDefinitionQuery processDefinitionQuery = repositoryService
				.createProcessDefinitionQuery();
		List<ProcessDefinition> list = processDefinitionQuery.list();
		model.addAttribute("list", list);
		return "activiti/queryProcessDefinition";
	}

	/**
	 * 查询 流程代办任务
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/activiti/activitiTask.do")
	public String activitiTask(HttpServletRequest request, Model model) {

		StoreEmployee storeEmployee = SysConstant.getCurrentUser();
		String assignee = storeEmployee.getUsername();
		List<Task> list = activiti.getTaskList(assignee);
		List<GeneralStaffLeaveOffice> generalStaffLeaveOfficeList = new ArrayList<GeneralStaffLeaveOffice>();
		if (list != null && list.size() > 0) {
			for (Task task : list) {

				GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
				String processInstanceId = task.getProcessInstanceId();
				// 使用流程实例ID查询
				ProcessInstance pi = activiti
						.getProcessInstance(processInstanceId);
				String buniness_key = pi.getBusinessKey();
				String buninessId = "";
				String flag = "";
				String id = "";
				String stationCode = "";
				String stationName = "";
				Staff staff = new Staff();
				if (StringUtils.isNotBlank(buniness_key)) {
					// 截取字符串，取buniness_key小数点的第2个值
					buninessId = buniness_key.split("\\.")[1];
					if (StringUtils.isNotBlank(buninessId)
							&& buninessId != null) {
						String[] split = buninessId.split(":");
						if (split != null && split.length > 0) {
							id = split[0];
							flag = split[1];
							if(split.length > 2){
								stationCode = split[2];
								Station station = stationService.findOnlyStationByStationCode(stationCode);
								stationName = station.getStationName();
								staff.setStationName(stationName);
							}
						}
					}
				}
				if (id == null || "".equals(id) || "null".equals(id)) {
					staff = staffService.queryStaffById(id);
				}
				generalStaffLeaveOffice.setStaff(staff);
				generalStaffLeaveOffice.setTask(task);
				generalStaffLeaveOffice.setFlag(flag);
				generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
				model.addAttribute("list", generalStaffLeaveOfficeList);
			}
			model.addAttribute("list", generalStaffLeaveOfficeList);
		}
		return "activiti/activiti_list";
	}

	/** 查询历史信息 */
	@RequestMapping("/activiti/queryHistoricTaskInstance.do")
	public String queryHistoricTaskInstance(Model model) {
		String flag = "";

		List<GeneralStaffLeaveOffice> generalStaffLeaveOfficeList = new ArrayList<GeneralStaffLeaveOffice>();
		StoreEmployee currentUser = SysConstant.getCurrentUser();
		// 获取历史流程实例的查询对象
		ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
		actHiActinstQuery.createCriteria().andAssigneeEqualTo(currentUser.getUsername()).andEndTimeIsNotNull();
		actHiActinstQuery.setOrderByClause("end_time_ desc");
		List<ActHiActinst> hpis =actHiActinstDao.selectByExample(actHiActinstQuery);
	/*	List<HistoricActivityInstance> hpis = activiti
				.getHistoricActivityInstance(null,currentUser.getUsername());*/
		// 遍历查看结果
		if (hpis != null && hpis.size() > 0) {

			for (ActHiActinst hpi : hpis) {
				GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
				HistoricProcessInstance pi = activiti
						.getHistoricProcessInstance(hpi.getProcInstId());
				if (pi != null && !"".equals(pi)) {
					String buniness_key = pi.getBusinessKey();
					String buninessId = "";
					String bid = "";
					String stationCode = "";
					String stationName = "";
					Staff staff = new Staff();
					if (StringUtils.isNotBlank(buniness_key)) {
						// 截取字符串，取buniness_key小数点的第2个值
						buninessId = buniness_key.split("\\.")[1];
						if (StringUtils.isNotBlank(buninessId)
								&& buninessId != null) {
							String[] split = buninessId.split(":");
							if (split != null && split.length > 0) {
								bid = split[0];
								flag = split[1];
								if(split.length > 2){
									stationCode = split[2];
									Station station = stationService.findOnlyStationByStationCode(stationCode);
									stationName = station.getStationName();
									staff.setStationName(stationName);
								}
							}
						}
					}
					// 根据ID查询业务
					if (bid == null || "".equals(bid) || "null".equals(bid)) {
						staff = staffService.queryStaffById(bid);
					}
					generalStaffLeaveOffice.setStaff(staff);
					generalStaffLeaveOffice.setFlag(flag);
					generalStaffLeaveOffice.setActHiActinst(hpi);
					generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
				}
			}
			/*for (HistoricActivityInstance hpi : hpis) {
				GeneralStaffLeaveOffice generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
				HistoricProcessInstance pi = activiti
						.getHistoricProcessInstance(hpi.getProcessInstanceId());
				if (pi != null && !"".equals(pi)) {
					String buniness_key = pi.getBusinessKey();
					String buninessId = "";
					String bid = "";
					if (StringUtils.isNotBlank(buniness_key)) {
						// 截取字符串，取buniness_key小数点的第2个值
						buninessId = buniness_key.split("\\.")[1];
						if (StringUtils.isNotBlank(buninessId)
								&& buninessId != null) {
							String[] split = buninessId.split(":");
							if (split != null && split.length > 0) {
								bid = split[0];
								flag = split[1];
							}
						}
					}
					// 根据ID查询业务
					if (bid == null || "".equals(bid) || "null".equals(bid)) {
						Staff staff = staffService.queryStaffById(bid);
						generalStaffLeaveOffice.setStaff(staff);
					}
					generalStaffLeaveOffice.setFlag(flag);
					generalStaffLeaveOffice.setHistoricActivityInstance(hpi);
					generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
				}
			}*/
		}
		model.addAttribute("list", generalStaffLeaveOfficeList);
		return "activiti/activiti_historic";
	}
	
	/** 查询抄送任务信息 */
	@RequestMapping("/activiti/queryActivitiCcTask.do")
	public String queryActivitiCcTask(Model model) {
		StoreEmployee currentUser = SysConstant.getCurrentUser();
		// 获取抄送任务的查询对象
		CcTaskQuery ccTaskQuery = new CcTaskQuery();
		ccTaskQuery.createCriteria().andByCcNameLike("%"+currentUser.getUsername()+"%");
		ccTaskQuery.setOrderByClause("end_time desc");
		List<CcTask> ccTaskList = ccTaskDao.selectByExample(ccTaskQuery);
		if(ccTaskList!=null && ccTaskList.size()>0){
			// 遍历查看结果
			model.addAttribute("list", ccTaskList);
		}
		return "activiti/activiti_cc_task";
	}

	// 查看流程图 页面
	@RequestMapping("/activiti/toCheckFlowDiagram.do")
	public String toCheckFlowDiagram(String id, Model model) throws Exception {
		// 使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
				.taskId(id)// 使用任务ID查询
				.singleResult();
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 查询流程定义的对象
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()// 创建流程定义查询对象，对应表act_re_procdef
				.processDefinitionId(processDefinitionId)// 使用流程定义ID查询
				.singleResult();
		model.addAttribute("pd", pd);
		/**
		 * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
		 * map集合的key：表示坐标x,y,width,height map集合的value：表示坐标对应的值
		 */
		// 存放坐标
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		// 流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()// 创建流程实例查询
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		// 获取当前活动的ID
		String activityId = pi.getActivityId();
		// 获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity
				.findActivity(activityId);// 活动ID
		// 获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		model.addAttribute("map", map);
		return "activiti/checkFlowDiagramImage";
	}

	// 删除流程
	@RequestMapping("/activiti/delDeployment.do")
	public String delDeployment(String id) {
		// 级联删除
		repositoryService.deleteDeployment(id);
		System.out.println("删除流程：" + id + "成功！");
		return "redirect:queryProcessDefinition.do";
	}

	// 查看bpmn图
	@RequestMapping("/activiti/checkBpmn.do")
	public void checkBpmn(HttpServletResponse response, String deploymentId,
			String bpmnFileNam) throws Exception {
		InputStream bpmnInStream = repositoryService.getResourceAsStream(
				deploymentId, bpmnFileNam);
		ServletOutputStream outputStream = response.getOutputStream();
		// 复制输入流给输出流
		IOUtils.copy(bpmnInStream, outputStream);
		bpmnInStream.close();
	}

	// 查看png图
	@RequestMapping("/activiti/checkFlowDiagram.do")
	public void checkFlowDiagram(HttpServletResponse response,
			String deploymentId, String imageName) throws Exception {
		InputStream pngInStream = repositoryService.getResourceAsStream(
				deploymentId, imageName);
		ServletOutputStream outputStream = response.getOutputStream();
		// 复制输入流给输出流
		IOUtils.copy(pngInStream, outputStream);
		pngInStream.close();
	}
	
	/*
	 * @Autowired private StoreEmployeeService storeEmployeeService;
	 * 
	 * @Autowired private StaffService staffService;
	 * 
	 * @Autowired private HistoryService historyService;
	 */
	/*
	 * @Autowired private StationService stationService;
	 * 
	 * @Autowired private SalaryDifferenceService salaryDifferenceService;
	 * 
	 * @Autowired private TbWorkflowUserDUserDao tbWorkflowUserDUserDao;
	 */

	/*
	 * //上传zip格式发布
	 * 
	 * @RequestMapping("/activiti/deploy.do") public String saveNewDeploye(File
	 * file, String filename,Model model) { try {
	 * //2：将File类型的文件转化成ZipInputStream流 ZipInputStream zipInputStream = new
	 * ZipInputStream(new FileInputStream(file));
	 * repositoryService.createDeployment()//创建部署对象 .name(filename)//添加部署名称
	 * .addZipInputStream(zipInputStream)// .deploy();//完成部署 //流程定义查询
	 * ProcessDefinitionQuery processDefinitionQuery =
	 * repositoryService.createProcessDefinitionQuery(); List<ProcessDefinition>
	 * list = processDefinitionQuery.list(); model.addAttribute("list", list); }
	 * catch (Exception e) { e.printStackTrace(); } return
	 * "activiti/queryProcessDefinition"; }
	 */
	
	// activiti 启动流程 （要先有部署）
	/*
	 * @RequestMapping("/activiti/runtime.do") public String runtime(String id)
	 * { // 获取流程实例 根据 key String key = "myProcess"; Map<String, Object>
	 * variablesnew = new HashMap<String, Object>(); ProcessInstance
	 * processInstance = runtimeService .startProcessInstanceByKey(key,
	 * variablesnew); System.out.println("执行id:" + processInstance.getId());
	 * System.out .println("流程定义id:" +
	 * processInstance.getProcessDefinitionId()); System.out.println("流程实例id:" +
	 * processInstance.getProcessInstanceId()); System.out.println("流程活动id:" +
	 * processInstance.getActivityId()); ProcessDefinitionEntity def =
	 * (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
	 * .getDeployedProcessDefinition(processInstance .getProcessDefinitionId());
	 * // 根据流程定义获得所有的节点： List<ActivityImpl> activitiList = def.getActivities();
	 * for (ActivityImpl activityImpl : activitiList) { List<PvmTransition>
	 * outTransitions = activityImpl .getOutgoingTransitions(); for
	 * (PvmTransition tr : outTransitions) { // 获取线路的终点节点 ActivityImpl ac =
	 * (ActivityImpl) tr.getDestination(); UserTaskActivityBehavior
	 * activityBehavior = (UserTaskActivityBehavior) ac .getActivityBehavior();
	 * System.out.println("下一步任务任务：" +
	 * ac.getProperty("activiti:candidateGroups")); // UserTaskActivityBehavior
	 * activityBehavior = // (UserTaskActivityBehavior) ac; //
	 * System.out.println
	 * ("下一步任务任务："+ac.getProperty("activiti:candidateGroups"));
	 * 
	 * TaskDefinition taskDefinition = activityBehavior .getTaskDefinition();
	 * Set<Expression> candidateGroupIdExpressions = taskDefinition
	 * .getCandidateGroupIdExpressions(); for (Expression expression :
	 * candidateGroupIdExpressions) { System.out.println(expression.toString());
	 * } } } return "redirect:/activiti/activitiTask.do"; }
	 */

	/*
	 * // activiti 查询关联业务
	 * 
	 * @RequestMapping("/activiti/activitiToView.do") public String
	 * activitiToView(String taskId, Model model, String tbWorkflowUserDUserId,
	 * String flag) { // 1: 使用任务ID, 查询任务对象Task Task task =
	 * taskService.createTaskQuery().taskId(taskId).singleResult(); // 2:
	 * 使用任务对象Task获取流程实例ID String processInstanceId =
	 * task.getProcessInstanceId(); // 3: 使用流程实例ID查询正在执行的执行对象表, 返回流程实例对象
	 * ProcessInstance pi = runtimeService.createProcessInstanceQuery()
	 * .processInstanceId(processInstanceId).singleResult(); // 4:
	 * 使用流程实例对象获取BUSINESS_KEY String buniness_key = pi.getBusinessKey(); // 5:
	 * 获取BUSINESS_KEY对应的主键ID, 使用主键ID String buninessId = ""; String id = ""; if
	 * (StringUtils.isNotBlank(buniness_key)) { buninessId =
	 * buniness_key.split("\\.")[1]; // 截取字符串, // 取buniness_key小数点的第2个值 String[]
	 * split = buninessId.split(":"); if (split != null && split.length > 0) {
	 * id = split[0]; if (split.length > 1) { flag = split[1]; } else { flag =
	 * "0"; }
	 * 
	 * } } // 根据ID查询业务 // 根据id查询记录 // 根据buninessId判断是离职流程还是薪资差异流程 if
	 * (buninessId.contains(",")) { // 薪资差异流程 String[] buninessIds =
	 * buninessId.split(","); List<Staff> staffList = new ArrayList<Staff>();
	 * for (String bId : buninessIds) { Staff staff =
	 * staffService.queryStaffById(bId); staffList.add(staff); } if
	 * (staffList.size() > 0 && null != staffList.get(0)) { } } else { // 离职流程
	 * Object staff = null; if ("0".equals(flag)) { staff =
	 * staffService.queryStaffById(id); } else if ("1".equals(flag)) { staff =
	 * staffTempService.findStaffByStaffCode(id); }
	 * 
	 * if (null != staff && !"".equals(staff)) { List<StoreEmployeeVO>
	 * storeEmployeeVOList = new ArrayList<StoreEmployeeVO>();
	 * ProcessDefinitionEntity def = (ProcessDefinitionEntity)
	 * ((RepositoryServiceImpl) repositoryService)
	 * .getDeployedProcessDefinition(task .getProcessDefinitionId()); //
	 * 根据流程定义获得所有的节点 ActivityImpl activityImpl = def
	 * .findActivity(pi.getActivityId()); String activityId =
	 * activityImpl.getId(); List<PvmTransition> outTransitions = activityImpl
	 * .getOutgoingTransitions(); for (PvmTransition tr : outTransitions) {
	 * String substringActivityId = activityId .substring(activityId.length() -
	 * 1); PvmActivity destination = tr.getDestination(); String
	 * destinationActivityId = destination.getId(); String
	 * destinationSubstringActivityId = destinationActivityId
	 * .substring(activityId.length() - 1); if
	 * (!"endevent".equals(destinationActivityId) &&
	 * Integer.valueOf(destinationSubstringActivityId) > Integer
	 * .valueOf(substringActivityId)) {
	 * 
	 * // 获取线路的终点节点 ActivityImpl ac = (ActivityImpl) destination;
	 * 
	 * UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) ac
	 * .getActivityBehavior(); TaskDefinition taskDefinition = activityBehavior
	 * .getTaskDefinition(); Set<Expression> candidateGroupIdExpressions =
	 * taskDefinition .getCandidateGroupIdExpressions(); for (Expression
	 * expression : candidateGroupIdExpressions) { String departmentCode = null;
	 * String groupRole1 = expression.toString(); // String groupRole2 =
	 * groupRole[1]; if ("0".equals(flag)) { Staff staff1 = (Staff) staff;
	 * departmentCode = staff1.getStationCode(); } else if ("1".equals(flag)) {
	 * StaffTemp staff2 = (StaffTemp) staff; departmentCode =
	 * staff2.getStationCode(); }
	 * 
	 * StoreEmployeeVO storeEmployeeVO = storeEmployeeService
	 * .queryStoreEmployeeVOBypStorePart( groupRole1, departmentCode); if
	 * (storeEmployeeVO != null && !"".equals(storeEmployeeVO)) {
	 * storeEmployeeVOList.add(storeEmployeeVO); } // 采取 角色.地点标识 地点标识（0-油站 1-地区
	 * 其他 ： HQ-总部）
	 * 
	 * if ("0".equals(groupRole2)) { departmentCode = staff.getStationCode();
	 * StoreEmployeeVO storeEmployeeVO =
	 * storeEmployeeService.queryStoreEmployeeVOBypStorePart (groupRole1); if
	 * (departmentCode.equals(storeEmployeeVO .getStationCode())) {
	 * storeEmployeeVOList.add(storeEmployeeVO); } } else if
	 * ("1".equals(groupRole2)) { Station station =
	 * stationService.findStationByStationCode( staff.getStationCode());
	 * departmentCode = station.getDistrictCode(); StoreEmployeeVO
	 * storeEmployeeVO = storeEmployeeService.queryStoreEmployeeVOBypStorePart
	 * (groupRole1); if (departmentCode.equals(storeEmployeeVO
	 * .getDistrictCode())) { storeEmployeeVOList.add(storeEmployeeVO); } } else
	 * { StoreEmployeeVO storeEmployeeVO = storeEmployeeService
	 * .queryStoreEmployeeVOBypStorePart(groupRole1); if
	 * (storeEmployeeVO.getDistrictCode() == null ||
	 * "".equals(storeEmployeeVO.getDistrictCode())) { if
	 * (storeEmployeeVO.getStationCode() == null ||
	 * "".equals(storeEmployeeV`O.getStationCode())) {
	 * storeEmployeeVOList.add(storeEmployeeVO); } } }
	 * 
	 * } } } model.addAttribute("storeEmployeeVOList", storeEmployeeVOList); if
	 * ("0".equals(flag)) { model.addAttribute("staff", (Staff) staff); } else
	 * if ("1".equals(flag)) { model.addAttribute("staffTemp", (StaffTemp)
	 * staff); } model.addAttribute("taskId", taskId);
	 * model.addAttribute("tbWorkflowUserDUserId", tbWorkflowUserDUserId);
	 * 
	 * // 返回存放连线的名称集合 List<String> variableList = new ArrayList<String>();
	 * String processDefinitionId = task.getProcessDefinitionId(); //
	 * 3：查询ProcessDefinitionEntiy对象 ProcessDefinitionEntity
	 * processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
	 * .getProcessDefinition(processDefinitionId); // 获取当前活动的id String aId =
	 * pi.getActivityId(); // 4：获取当前的活动 ActivityImpl aImpl =
	 * processDefinitionEntity.findActivity(aId); // 5：获取当前活动完成之后连线的名称
	 * List<PvmTransition> pvmList = aImpl.getOutgoingTransitions(); if (pvmList
	 * != null && pvmList.size() > 0) { for (PvmTransition pvm : pvmList) {
	 * String name = (String) pvm.getProperty("name"); if
	 * (StringUtils.isNotBlank(name)) { variableList.add(name); } else {
	 * variableList.add("提交"); } } } model.addAttribute("variableList",
	 * variableList); // 获取批注信息 List<Comment> list = new ArrayList<Comment>();
	 * list = taskService .getProcessInstanceComments(processInstanceId);
	 * model.addAttribute("list", list); } } if ("0".equals(flag)) { return
	 * "activiti/activitistaffLeaveOffice"; } else if ("1".equals(flag)) {
	 * return "activiti/activitiStaffAdd"; } return
	 * "activiti/activitistaffLeaveOffice"; }
	 * 
	 * // activiti 查询代办任务
	 * 
	 * @RequestMapping("/activiti/activitiTask.do") public String
	 * activitiTask(HttpServletRequest request, Model model) {
	 * 
	 * Subject currentUser = SecurityUtils.getSubject(); Session session =
	 * currentUser.getSession(); StoreEmployee storeEmployee = (StoreEmployee)
	 * session .getAttribute(SysConstant.CURRENT_USER_INFO); String assignee =
	 * storeEmployee.getUsername(); // 任务查询对象 TaskQuery taskQuery =
	 * taskService.createTaskQuery(); // 不带任何条件 // taskQuery.list(); // 任务的执行者
	 * taskQuery.taskAssignee(assignee); // 按照任务创建时间排序
	 * taskQuery.orderByTaskCreateTime().asc(); // 查询所有符合条件的记录 List<Task> list =
	 * taskQuery.list(); List<GeneralStaffLeaveOffice>
	 * generalStaffLeaveOfficeList = new ArrayList<GeneralStaffLeaveOffice>();
	 * if (list != null && list.size() > 0) { // List<TbWorkflowUserDUser>
	 * tbWorkflowUserDUserList=new // ArrayList<TbWorkflowUserDUser>(); for
	 * (Task task : list) {
	 * 
	 * GeneralStaffLeaveOffice generalStaffLeaveOffice = new
	 * GeneralStaffLeaveOffice(); String processInstanceId =
	 * task.getProcessInstanceId(); // 使用流程实例ID查询 ProcessInstance pi =
	 * runtimeService .createProcessInstanceQuery()
	 * .processInstanceId(processInstanceId).singleResult(); String buniness_key
	 * = pi.getBusinessKey(); String buninessId = ""; String flag = ""; String
	 * id = ""; if (StringUtils.isNotBlank(buniness_key)) { //
	 * 截取字符串，取buniness_key小数点的第2个值 buninessId = buniness_key.split("\\.")[1]; if
	 * (StringUtils.isNotBlank(buninessId) && buninessId != null) { String[]
	 * split = buninessId.split(":"); if (split != null && split.length > 0) {
	 * id = split[0]; if (split.length > 1) { flag = split[1]; } else { flag =
	 * "0"; } } } }
	 * 
	 * TbWorkflowUserDUserQuery tbWorkflowUserDUserQuery = new
	 * TbWorkflowUserDUserQuery(); tbWorkflowUserDUserQuery.createCriteria
	 * ().andBeginDateEqualTo( task.getCreateTime()).andEndDateEqualTo(null);
	 * List<TbWorkflowUserDUser> tbWorkflowUserDUsers = tbWorkflowUserDUserDao
	 * .selectByExample(tbWorkflowUserDUserQuery); if(tbWorkflowUserDUsers!=null
	 * && tbWorkflowUserDUsers.size()>0){ for (TbWorkflowUserDUser
	 * tbWorkflowUserDUser : tbWorkflowUserDUsers) {
	 * tbWorkflowUserDUser.setTask(task);
	 * tbWorkflowUserDUserList.add(tbWorkflowUserDUser); } }
	 * 
	 * // 根据ID查询业务 // 判断是离职流程还是薪资差异流程
	 * 
	 * if (buninessId.contains(",")) { //薪资差异流程 List<SalaryDifferenceOffice>
	 * salaryDifferenceOfficeList = new ArrayList<SalaryDifferenceOffice>();
	 * SalaryDifferenceOffice salaryDifferenceOffice = new
	 * SalaryDifferenceOffice(); //将最后的一个逗号去掉(1,2,3,4,5, -----> 1,2,3,4,5)
	 * buninessId = buninessId.substring(0, buninessId.lastIndexOf(","));
	 * String[] buninessIds = buninessId.split(","); List<Staff> staffList = new
	 * ArrayList<Staff>(); List<SalaryDifference> salaryDifferenceList = new
	 * ArrayList<SalaryDifference>(); for (String bId : buninessIds) { Staff
	 * staff = staffService.queryStaffById(bId); staffList.add(staff);
	 * //根据staffId查找相应的SalaryDifference SalaryDifference SalaryDifference =
	 * salaryDifferenceService.findSalaryDifferenceByStaffCode
	 * (staff.getStaffCode()); salaryDifferenceList.add(SalaryDifference); }
	 * salaryDifferenceOffice.setStaffList(staffList); salaryDifferenceOffice
	 * .setSalaryDifferenceList(salaryDifferenceList);
	 * salaryDifferenceOffice.setTask(task);
	 * salaryDifferenceOfficeList.add(salaryDifferenceOffice);
	 * model.addAttribute("sdOfficelist", salaryDifferenceOfficeList); }else{
	 * 
	 * // 0 - 离职流程 1- 入职 if ("0".equals(flag)) {
	 * 
	 * Staff staff = null; if (id == null || "".equals(id) || "null".equals(id))
	 * { if (buninessId == null || "".equals(buninessId) ||
	 * "null".equals(buninessId)) { staff = staffService.queryStaffById("0"); }
	 * else { staff = staffService.queryStaffById(buninessId); } } else { staff
	 * = staffService.queryStaffById(id); // 根据ID查询业务 // 判断是离职流程还是薪资差异流程 if
	 * (buninessId.contains(",")) { // 薪资差异流程
	 * 
	 * List<SalaryDifferenceOffice> salaryDifferenceOfficeList = new
	 * ArrayList<SalaryDifferenceOffice>(); SalaryDifferenceOffice
	 * salaryDifferenceOffice = new SalaryDifferenceOffice();
	 * //将最后的一个逗号去掉(1,2,3,4,5, -----> 1,2,3,4,5) buninessId =
	 * buninessId.substring(0, buninessId.lastIndexOf(",")); String[]
	 * buninessIds = buninessId.split(","); List<Staff> staffList = new
	 * ArrayList<Staff>(); List<SalaryDifference> salaryDifferenceList = new
	 * ArrayList<SalaryDifference>(); List<Station> stationList = new
	 * ArrayList<Station>(); for (String bId : buninessIds) { Staff staff =
	 * staffService.queryStaffById(bId); staffList.add(staff);
	 * //根据staffId查找相应的SalaryDifference SalaryDifference SalaryDifference =
	 * salaryDifferenceService. findSalaryDifferenceByStaffCode
	 * (staff.getStaffCode()); salaryDifferenceList.add(SalaryDifference);
	 * //根据station_code查找对应的Station Station station = stationService
	 * .findOnlyStationByStationCode(staff. getStationCode());
	 * stationList.add(station); }
	 * 
	 * if (staff != null && !"".equals(staff)) {
	 * generalStaffLeaveOffice.setStaff(staff);
	 * generalStaffLeaveOffice.setTask(task);
	 * generalStaffLeaveOffice.setFlag(flag); generalStaffLeaveOfficeList
	 * .add(generalStaffLeaveOffice); } } else if ("1".equals(flag)) { StaffTemp
	 * staffTemp = staffTempService .findStaffByStaffCode(id); if (staffTemp !=
	 * null && !"".equals(staffTemp)) {
	 * generalStaffLeaveOffice.setStaffTemp(staffTemp);
	 * generalStaffLeaveOffice.setTask(task);
	 * generalStaffLeaveOffice.setFlag(flag); generalStaffLeaveOfficeList
	 * .add(generalStaffLeaveOffice); }
	 * 
	 * salaryDifferenceOffice.setStaffList(staffList); salaryDifferenceOffice
	 * .setSalaryDifferenceList(salaryDifferenceList); salaryDifferenceOffice
	 * .setStationList(stationList); salaryDifferenceOffice.setTask(task);
	 * salaryDifferenceOfficeList .add(salaryDifferenceOffice);
	 * model.addAttribute("sdOfficelist", salaryDifferenceOfficeList);
	 * 
	 * }
	 * 
	 * else{ //离职流程 List<GeneralStaffLeaveOffice> generalStaffLeaveOfficeList =
	 * new ArrayList<GeneralStaffLeaveOffice>(); Staff staff =
	 * staffService.queryStaffById(buninessId);
	 * generalStaffLeaveOffice.setStaff(staff);
	 * generalStaffLeaveOffice.setTask(task); generalStaffLeaveOfficeList
	 * .add(generalStaffLeaveOffice); model.addAttribute("list",
	 * generalStaffLeaveOfficeList); }
	 * 
	 * 
	 * // } } } } // model.addAttribute("list", tbWorkflowUserDUserList);
	 * model.addAttribute("list", generalStaffLeaveOfficeList); return
	 * "activiti/activiti_list"; } else { return "activiti/activiti_list"; }
	 * 
	 * }
	 * 
	 * // 执行流程
	 * 
	 * @RequestMapping("/activiti/execution.do") public String execution(String
	 * id, String taskId, String message, String flowType, String nextUserName,
	 * String outcome, String nextStorePartName, String nextOrganiseName, String
	 * tbWorkflowUserDUserId) {
	 * 
	 * // 标识 Integer flag = 0;
	 *//**
	 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
	 */
	/*
	 * // 使用任务ID，查询任务对象，获取流程流程实例ID Task task = taskService.createTaskQuery()//
	 * .taskId(taskId)// 使用任务ID查询 .singleResult(); // 获取流程实例ID String
	 * processInstanceId = task.getProcessInstanceId();
	 * 
	 * Subject currentUser = SecurityUtils.getSubject(); Session session =
	 * currentUser.getSession(); StoreEmployee storeEmployee = (StoreEmployee)
	 * session .getAttribute(SysConstant.CURRENT_USER_INFO);
	 * Authentication.setAuthenticatedUserId(storeEmployee.getUsername());
	 * taskService.addComment(taskId, processInstanceId, message);
	 * 
	 * Map<String, Object> variables = new HashMap<String, Object>();
	 * 
	 * if (outcome != null && !outcome.equals("提交")) { variables.put("outcome",
	 * outcome); }
	 * 
	 * TbWorkflowUserDUser tbWorkflowUserDUser = new TbWorkflowUserDUser();
	 * tbWorkflowUserDUser.setId(Integer.valueOf(tbWorkflowUserDUserId));
	 * tbWorkflowUserDUser.setEndDate(new Date());
	 * tbWorkflowUserDUserDao.updateByPrimaryKeySelective (tbWorkflowUserDUser);
	 * 
	 * 
	 * // 下个节点是否为抄送任务 if (nextUserName == null || "".equals(nextUserName) ||
	 * "null".equals(nextUserName)) { if ("驳回".equals(outcome)) {
	 * ProcessInstance pInstance = runtimeService
	 * .createProcessInstanceQuery()// .processInstanceId(processInstanceId)//
	 * 使用流程实例ID查询 .singleResult(); ProcessDefinitionEntity def =
	 * (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
	 * .getDeployedProcessDefinition(task .getProcessDefinitionId()); //
	 * 根据流程定义获得所有的节点 ActivityImpl activityImpl = def.findActivity(pInstance
	 * .getActivityId()); List<PvmTransition> outTransitions = activityImpl
	 * .getOutgoingTransitions(); String activityId = activityImpl.getId(); for
	 * (PvmTransition tr : outTransitions) { String substringActivityId =
	 * activityId .substring(activityId.length() - 1); PvmActivity destination =
	 * tr.getDestination(); String destinationActivityId = destination.getId();
	 * String destinationSubstringActivityId = destinationActivityId
	 * .substring(activityId.length() - 1); if
	 * (!"endevent".equals(destinationActivityId) &&
	 * Integer.valueOf(destinationSubstringActivityId) > Integer
	 * .valueOf(substringActivityId)) { // 获取线路的终点节点 ActivityImpl ac =
	 * (ActivityImpl) destination; String acId = ac.getId(); StoreEmployeeVO
	 * storeEmployeeVO = storeEmployeeService
	 * .queryStoreEmployeeVOBypStorePart(acId, storeEmployee.getOrganiseId());
	 * if (storeEmployeeVO != null && !"".equals(storeEmployeeVO)) {
	 * nextUserName = storeEmployeeVO.getUsername(); } } } flag = 1; } }
	 * variables.put("checkUser", nextUserName); // 3：使用任务ID，完成当前人的个人任务，同时流程变量
	 * taskService.complete(taskId, variables);
	 * 
	 * 
	 * TbWorkflowUserDUser nextTbWorkflowUserDUser = new TbWorkflowUserDUser();
	 * nextTbWorkflowUserDUser.setBeginDate(new Date());
	 * nextTbWorkflowUserDUser.setUserid(storeEmployee.getUsername());
	 * nextTbWorkflowUserDUser.setUserPart(nextStorePartName);
	 * nextTbWorkflowUserDUser.setUserDep(nextOrganiseName);
	 * nextTbWorkflowUserDUser.setdUserid(nextUserName);
	 * nextTbWorkflowUserDUser.setFlowType(flowType);
	 *//**
	 * 5：在完成任务之后，判断流程是否结束 如果流程结束了（审核中-->审核完成）
	 */
	/*
	 * ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
	 * .processInstanceId(processInstanceId)// 使用流程实例ID查询 .singleResult(); if
	 * (pi != null && flag == 1) { TaskQuery taskQuery =
	 * taskService.createTaskQuery(); taskQuery.taskAssignee(nextUserName);
	 * taskQuery.processInstanceId(task.getProcessInstanceId()); Task
	 * singleResult = taskQuery.singleResult(); this.execution(id,
	 * singleResult.getId(), null, null, null, null, null, null, null); } Staff
	 * staff = new Staff(); staff.setId(Long.valueOf(id)); // 流程结束了 if (pi ==
	 * null) { nextTbWorkflowUserDUser.setDiff("2"); staff.setStaffStatus("2");
	 * staff.setStaffOutStatus("2"); } else {
	 * nextTbWorkflowUserDUser.setDiff("1"); staff.setStaffOutStatus("1"); }
	 * staffService.updateStaffById(staff); //
	 * tbWorkflowUserDUserDao.insertSelective(nextTbWorkflowUserDUser); return
	 * "redirect:/activiti/activitiTask.do"; }
	 *//** 查询历史流程信息 */
	/*
	 * @RequestMapping("/activiti/toCheck.do") public String toCheck(String id,
	 * Model model) { List<GeneralStaffLeaveOffice> generalStaffLeaveOfficeList
	 * = new ArrayList<GeneralStaffLeaveOffice>(); // 获取历史流程实例的查询对象
	 * HistoricActivityInstanceQuery historicActivityInstanceQuery =
	 * historyService .createHistoricActivityInstanceQuery(); // 设置查询参数
	 * historicActivityInstanceQuery // 过滤条件 .processInstanceId(id) // 分页条件 //
	 * .listPage(firstResult, maxResults) // 排序条件
	 * .orderByHistoricActivityInstanceStartTime().asc(); // 执行查询
	 * List<HistoricActivityInstance> haqs = historicActivityInstanceQuery
	 * .list(); // 遍历查看结果 String processInstanceId = null; for
	 * (HistoricActivityInstance haq : haqs) { GeneralStaffLeaveOffice
	 * generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
	 * generalStaffLeaveOffice.setHistoricActivityInstance(haq);
	 * generalStaffLeaveOfficeList.add(generalStaffLeaveOffice);
	 * processInstanceId = haq.getProcessInstanceId(); } HistoricProcessInstance
	 * pi = historyService .createHistoricProcessInstanceQuery()//
	 * .processInstanceId(processInstanceId)// 使用流程实例ID查询 .singleResult();
	 * String buniness_key = pi.getBusinessKey(); String buninessId = ""; String
	 * bid = ""; String flag = ""; if (StringUtils.isNotBlank(buniness_key)) {
	 * // 截取字符串，取buniness_key小数点的第2个值 buninessId = buniness_key.split("\\.")[1];
	 * if (StringUtils.isNotBlank(buninessId) && buninessId != null) { String[]
	 * split = buninessId.split(":"); if (split != null && split.length > 0) {
	 * bid = split[0]; if (split.length > 1) { flag = split[1]; } else { flag =
	 * "0"; } } } } model.addAttribute("list", generalStaffLeaveOfficeList); //
	 * 根据ID查询业务 Object staff = null; if ("0".equals(flag)) { staff =
	 * staffService.queryStaffById(bid); model.addAttribute("staff", (Staff)
	 * staff); return "activiti/historicactivitistaffLeaveOffice"; } else if
	 * ("1".equals(flag)) { staff = staffTempService.findStaffByStaffCode(bid);
	 * model.addAttribute("staffTemp", (StaffTemp) staff); return
	 * "activiti/historicActivitiStaffAdd"; } return
	 * "activiti/historicactivitistaffLeaveOffice"; }
	 *//** 查询历史信息 */
	/*
	 * @RequestMapping("/activiti/queryHistoricTaskInstance.do") public String
	 * queryHistoricTaskInstance(Model model) { List<GeneralStaffLeaveOffice>
	 * generalStaffLeaveOfficeList = new ArrayList<GeneralStaffLeaveOffice>();
	 * Subject currentUser = SecurityUtils.getSubject(); Session session =
	 * currentUser.getSession(); StoreEmployee storeEmployee = (StoreEmployee)
	 * session .getAttribute(SysConstant.CURRENT_USER_INFO); // 获取历史流程实例的查询对象
	 * HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService
	 * .createHistoricTaskInstanceQuery(); // 设置查询参数 historicTaskInstanceQuery
	 * // 过滤条件 .finished().taskAssignee(storeEmployee.getUsername()) // 分页条件 //
	 * .listPage(firstResult, maxResults) // 排序条件
	 * .orderByHistoricTaskInstanceEndTime().desc(); // 执行查询
	 * List<HistoricTaskInstance> hpis = historicTaskInstanceQuery.list(); //
	 * 遍历查看结果 for (HistoricTaskInstance hpi : hpis) { GeneralStaffLeaveOffice
	 * generalStaffLeaveOffice = new GeneralStaffLeaveOffice();
	 * HistoricProcessInstance pi = historyService
	 * .createHistoricProcessInstanceQuery()//
	 * .processInstanceId(hpi.getProcessInstanceId())// 使用流程实例ID查询
	 * .singleResult(); if (pi != null && !"".equals(pi)) { String buniness_key
	 * = pi.getBusinessKey(); String buninessId = ""; String bid = ""; String
	 * flag = ""; if (StringUtils.isNotBlank(buniness_key)) { //
	 * 截取字符串，取buniness_key小数点的第2个值 buninessId = buniness_key.split("\\.")[1]; if
	 * (StringUtils.isNotBlank(buninessId) && buninessId != null) { String[]
	 * split = buninessId.split(":"); if (split != null && split.length > 0) {
	 * bid = split[0]; if (split.length > 1) { flag = split[1]; } else { flag =
	 * "0"; } } } } // 根据ID查询业务 Object staff = null; if ("0".equals(flag)) {
	 * staff = staffService.queryStaffById(bid);
	 * generalStaffLeaveOffice.setStaff((Staff) staff); } else if
	 * ("1".equals(flag)) { staff = staffTempService.findStaffByStaffCode(bid);
	 * generalStaffLeaveOffice.setStaffTemp((StaffTemp) staff); }
	 * generalStaffLeaveOffice.setFlag(flag);
	 * generalStaffLeaveOffice.setHistoricTaskInstance(hpi);
	 * generalStaffLeaveOfficeList.add(generalStaffLeaveOffice); } }
	 * 
	 * model.addAttribute("list", generalStaffLeaveOfficeList); return
	 * "activiti/activiti_historic"; }
	 */

	/*
	 * @RequestMapping("activiti/down") public void down(String id,
	 * HttpServletResponse response, HttpServletRequest request) { String
	 * realPath = request.getSession().getServletContext()
	 * .getRealPath("/WEB-INF/upload"); // json对象 JSONObject js = new
	 * JSONObject(); try { Staff staff = staffService.queryStaffById(id); if
	 * (staff != null && !"".equals(staff)) { File file = new File(realPath +
	 * staff.getStaffOutUrl()); String filename = file.getName(); String ext =
	 * filename.substring(filename.lastIndexOf(".") + 1) .toUpperCase(); //
	 * 以流的形式下载文件。 InputStream fis = new BufferedInputStream(new FileInputStream(
	 * realPath + staff.getStaffOutUrl())); byte[] buffer = new
	 * byte[fis.available()]; fis.read(buffer); fis.close(); // 清空response
	 * response.reset(); // 设置response的Header
	 * response.addHeader("Content-Disposition", "attachment;filename=" + new
	 * String(filename.getBytes())); response.addHeader("Content-Length", "" +
	 * file.length()); OutputStream toClient = new BufferedOutputStream(
	 * response.getOutputStream());
	 * response.setContentType("application/octet-stream");
	 * toClient.write(buffer); toClient.flush(); toClient.close(); } else { //
	 * json中添加 数据 key value 形式 js.put("result", "false"); // 更改编码
	 * response.setContentType("application/json;charset=UTF-8"); // 发送数据到页面
	 * response.getWriter().write(js.toString()); } } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
}
