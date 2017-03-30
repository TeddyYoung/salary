package com.fh.activiti.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.ActHiActinstDao;
import com.fh.dao.system.CcTaskDao;
import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import com.fh.entity.system.CcTask;

/**
 * 流程工具类
 * 
 * @author lijn
 * 
 */
@Service
public class ActivitiImpl implements Activiti {

	/**
	 * 流程部署service
	 */
	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 启动流程service
	 */
	@Autowired
	private  RuntimeService runtimeService;

	/**
	 * 任务service
	 */
	@Autowired
	private TaskService taskService;

	/**
	 * 历史service
	 */
	@Autowired
	private HistoryService historyService;
	
	/**
	 * 历史 dao (针对表进行操作)
	 */
	@Autowired
	private ActHiActinstDao actHiActinstDao;
	
	/**
	 * 抄送 dao (针对表进行操作)
	 */
	@Autowired
	private CcTaskDao ccTaskDao;

	/**
	 * 流程启动
	 * 
	 * @param key
	 *            流程实例的key
	 * @param objId
	 *            业务关联id
	 * @param variablesnew
	 *            变量
	 * @return true 启动成功 false 启动失败
	 */
	public  ProcessInstance runtime(String key, String objId,
			Map<String, Object> variablesnew) {
		try {
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, objId, variablesnew);
			return processInstance;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取正在执行的任务列表
	 * 
	 * @param assignee
	 *            任务执行者
	 * @return 正在执行的任务列表
	 */
	public List<Task> getTaskList(String assignee) {
		TaskQuery taskQuery = taskService.createTaskQuery();
		if (assignee != null) {
			// 任务的执行者
			taskQuery.taskAssignee(assignee);
		}
		// 按照任务创建时间排序
		taskQuery.orderByTaskCreateTime().desc();
		// 查询所有符合条件的记录
		List<Task> list = taskQuery.list();
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 条件查询 唯一的任务
	 * 
	 * @param taskId
	 *            任务id
	 * @param assignee
	 *            任务执行者
	 * @return
	 */
	public Task getTask(String taskId, String assignee,
			String processInstanceId) {
		// 任务查询对象
		TaskQuery taskQuery = taskService.createTaskQuery();
		if (taskId != null) {
			// 任务的id
			taskQuery.taskId(taskId);
		}
		if (assignee != null) {
			// 任务的执行者
			taskQuery.taskAssignee(assignee);
		}
		if (processInstanceId != null) {
			taskQuery.processInstanceId(processInstanceId);
		}
		// 查询唯一符合条件的记录
		Task task = taskQuery.singleResult();
		if (task != null && !"".equals(task)) {
			return task;
		} else {
			return null;
		}
	}

	/**
	 * 根据实例id 查询实例
	 * 
	 * @param processInstanceId
	 *            流程实例的id
	 */
	public  ProcessInstance getProcessInstance(String processInstanceId) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		return pi;
	}

	/**
	 * 查询单个流程实例的历史记录
	 * 
	 * @param processInstanceId
	 * @return
	 */
	public List<HistoricActivityInstance> getHistoricActivityInstance(
			String processInstanceId,String username) {
		// 获取历史流程实例的查询对象（节点）
		HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService
				.createHistoricActivityInstanceQuery();
		// 设置查询参数
		if(processInstanceId!=null && !"".equals(processInstanceId)){
			historicActivityInstanceQuery.processInstanceId(processInstanceId);
		}
		if(username!=null && !"".equals(username)){
			historicActivityInstanceQuery.taskAssignee(username);
		}
		historicActivityInstanceQuery.orderByHistoricActivityInstanceStartTime().desc();
		// 执行查询
		List<HistoricActivityInstance> haqs = historicActivityInstanceQuery
				.list();
		if (haqs != null && haqs.size() > 0) {
			return haqs;
		} else {
			return null;
		}
	}

	/**
	 * 根据用户查询，所参与任务实例列表
	 * 
	 * @param username
	 * @return
	 */
	public List<HistoricTaskInstance> getHistoricTaskInstance(
			String username) {
		// 获取历史流程实例的查询对象（任务）
		HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService
				.createHistoricTaskInstanceQuery();
		// 设置查询参数
		historicTaskInstanceQuery
		// 过滤条件
				.finished().taskAssignee(username)
				// 分页条件
				// .listPage(firstResult, maxResults)
				// 排序条件
				.orderByHistoricTaskInstanceEndTime().desc();
		// 执行查询
		List<HistoricTaskInstance> hpis = historicTaskInstanceQuery.list();
		if (hpis != null && hpis.size() > 0) {
			return hpis;
		} else {
			return null;
		}
	}

	/**
	 * 根据流程实例id查询流程实例
	 * 
	 * @param processInstanceId
	 *            流程实例id
	 * @return
	 */
	public HistoricProcessInstance getHistoricProcessInstance(
			String processInstanceId) {
		HistoricProcessInstance pi = historyService
				.createHistoricProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		return pi;
	}

	/**
	 * 根据流程定义的id 查询流程定义的对象
	 * 
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinition getProcessDefinition(
			String processDefinitionId,String key) {
		// 查询流程定义的对象
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		if(processDefinitionId!=null){
			processDefinitionQuery.processDefinitionId(processDefinitionId);
		}
		if(key!=null){
			processDefinitionQuery.processDefinitionKey(key);
		}
		processDefinitionQuery.orderByProcessDefinitionVersion().desc();
		List<ProcessDefinition> list = processDefinitionQuery.list();
		if(list!=null && list.size()>0){
			ProcessDefinition pd = list.get(0);
			return pd;
		}
		return null;
	}

	/**
	 * 根据流程定义的id 查询流程定义的实体
	 * 
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinitionEntity getProcessDefinitionEntity(
			String processDefinitionId) {
		// 获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		return processDefinitionEntity;
	}

	/**
	 * 添加 批注 信息
	 * 
	 * @param username
	 *            用户名
	 * @param taskId
	 *            任务 id
	 * @param processInstanceId
	 *            流程实例 id
	 * @param message
	 *            批注信息
	 */
	public void addComment(String username, String taskId,
			String processInstanceId, String message) {
		Authentication.setAuthenticatedUserId(username);
		taskService.addComment(taskId, processInstanceId, message);
	}
	
	/**根据流程实例 获取个流程实例上的注解列表
	 * @param processInstanceId 流程实例id
	 */
	public List<Comment> getComment(String processInstanceId) {
		List<Comment> comments = taskService
				.getProcessInstanceComments(processInstanceId);
		if(comments!=null && comments.size()>0){
			return comments;
		}else{
			return comments;
		}
	}
	/**根据当前任务id 完成任务并设置变量
	 * @param taskId
	 * @param variables
	 * @return
	 */
	public boolean complete(String taskId,Map<String,Object> variables) {
		try {
			taskService.complete(taskId, variables);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**任务抄送
	 * @return
	 */
	public void ccTask(String storePartNameCC,Task task,String outcome,String flag) {
		try {
		
			//任务名称
			String taskName="抄送至:"+storePartNameCC;
			
			ActHiActinst actHiActinst = new ActHiActinst();
			actHiActinst.setId(UUID.randomUUID().toString().replace("-", ""));
			actHiActinst.setActName(taskName);
			actHiActinst.setAssignee(task.getAssignee());
			actHiActinst.setProcDefId(task.getProcessDefinitionId());
			actHiActinst.setProcInstId(task.getProcessInstanceId());
			actHiActinst.setOperation(outcome);
			actHiActinst.setStartTime(new Date());
			actHiActinst.setExecutionId(task.getExecutionId());
			actHiActinst.setEndTime(new Date());
			
			/*String[] split = storePartNameCC.split(",");
			StringBuffer sb = new StringBuffer();
			for (String string : split) {
				sb.append(string.substring(string.indexOf("-")+1, string.length()));
				sb.append(",");
			}*/
			
			CcTask ccTask = new CcTask();
			ccTask.setTaskName(taskName);
			ccTask.setCcName(task.getAssignee());
			//ccTask.setByCcName(sb.toString().substring(0,sb.toString().lastIndexOf(",")));
			ccTask.setByCcName(storePartNameCC);
			ccTask.setProcessInstanceId(task.getProcessInstanceId());
			ccTask.setTaskType(flag);
			ccTask.setSysCreateTime(new Date());
			ccTask.setStartTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			ccTask.setEndTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			
			actHiActinstDao.insertSelective(actHiActinst);
			ccTaskDao.insertSelective(ccTask);
			
		} catch (Exception e) {
			throw new  IllegalArgumentException("操作失败！");
		}
	}
	/**更新历史活动信息
	 * @return
	 */
	public void updateActHiActinst(Task task,String outcome) {
		try {
			ActHiActinstQuery actHiActinstQuery = new ActHiActinstQuery();
			actHiActinstQuery.createCriteria().andProcInstIdEqualTo(task.getProcessInstanceId()).andTaskIdEqualTo(task.getId()).andAssigneeEqualTo(task.getAssignee());
			actHiActinstQuery.setOrderByClause("END_TIME_ desc");
			List<ActHiActinst> actHiActinstList = actHiActinstDao.selectByExample(actHiActinstQuery);
			ActHiActinst actHiActinst = new ActHiActinst();
			if(actHiActinstList!=null && actHiActinstList.size()>0){
				actHiActinst=actHiActinstList.get(0);
			}
			
			if(actHiActinst!=null && !"".equals(actHiActinst)){
				actHiActinst.setOperation(outcome);
				actHiActinstDao.updateByPrimaryKeySelective(actHiActinst);
			}
		} catch (Exception e) {
			throw new  IllegalArgumentException("操作失败！");
		}
	}
	
	
}
