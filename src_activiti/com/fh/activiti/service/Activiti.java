package com.fh.activiti.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

/**
 * 流程工具类
 * 
 * @author lijn
 * 
 */
@Service
public  interface  Activiti {

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
			Map<String, Object> variablesnew);

	/**
	 * 获取正在执行的任务列表
	 * 
	 * @param assignee
	 *            任务执行者
	 * @return 正在执行的任务列表
	 */
	public  List<Task> getTaskList(String assignee);

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
			String processInstanceId);

	/**
	 * 根据实例id 查询实例
	 * 
	 * @param processInstanceId
	 *            流程实例的id
	 */
	public  ProcessInstance getProcessInstance(String processInstanceId);

	/**
	 * 查询单个流程实例的历史记录
	 * 
	 * @param processInstanceId
	 * @return
	 */
	public List<HistoricActivityInstance> getHistoricActivityInstance(
			String processInstanceId,String username);

	/**
	 * 根据用户查询，所参与任务实例列表
	 * 
	 * @param username
	 * @return
	 */
	public List<HistoricTaskInstance> getHistoricTaskInstance(
			String username);

	/**
	 * 根据流程实例id查询流程实例
	 * 
	 * @param processInstanceId
	 *            流程实例id
	 * @return
	 */
	public HistoricProcessInstance getHistoricProcessInstance(
			String processInstanceId);

	/**
	 * 根据流程定义的id 查询流程定义的对象
	 * 
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinition getProcessDefinition(
			String processDefinitionId,String key);

	/**
	 * 根据流程定义的id 查询流程定义的实体
	 * 
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinitionEntity getProcessDefinitionEntity(
			String processDefinitionId);

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
			String processInstanceId, String message);
	/**根据流程实例 获取个流程实例上的注解列表
	 * @param processInstanceId 流程实例id
	 */
	public List<Comment> getComment(String processInstanceId);
	
	/**根据当前任务id 完成任务并设置变量
	 * @param taskId
	 * @param variables
	 * @return
	 */
	public boolean complete(String taskId,Map<String,Object> variables);
	/**更新历史活动信息
	 * @return
	 */
	public void updateActHiActinst(Task task,String outcome);
	/**任务抄送
	 * @return
	 */
	public void ccTask(String storePartNameCC,Task task,String outcome,String flag); 
}
