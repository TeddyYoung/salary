package com.fh.entity;

import java.io.Serializable;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;


import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffTemp;
import com.fh.entity.system.ActHiActinst;

/**
 * 离职申请 普通员工
 * @author lijn
 *
 */
@SuppressWarnings("serial")
public class GeneralStaffLeaveOffice implements Serializable {
	/**
	 * 拓展属性：历史
	 */
	private ActHiActinst actHiActinst;
	/**
	 * 拓展属性：员工
	 */
	private Staff staff;
	/**
	 * 拓展属性：员工入职临时表
	 */
	private StaffTemp staffTemp;
	/**
	 * 工作流：任务
	 */
	private Task task;
	/**
	 * 工作流：历史任务实例
	 */
	private HistoricTaskInstance historicTaskInstance;
	/**
	 * 标识：0-离职申请 1-入职申请 2-调动申请 3-升迁申请
	 */
	private String flag;
	private HistoricActivityInstance historicActivityInstance;
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public HistoricTaskInstance getHistoricTaskInstance() {
		return historicTaskInstance;
	}
	public void setHistoricTaskInstance(HistoricTaskInstance historicTaskInstance) {
		this.historicTaskInstance = historicTaskInstance;
	}
	public HistoricActivityInstance getHistoricActivityInstance() {
		return historicActivityInstance;
	}
	public void setHistoricActivityInstance(
			HistoricActivityInstance historicActivityInstance) {
		this.historicActivityInstance = historicActivityInstance;
	}
	public StaffTemp getStaffTemp() {
		return staffTemp;
	}
	public void setStaffTemp(StaffTemp staffTemp) {
		this.staffTemp = staffTemp;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public ActHiActinst getActHiActinst() {
		return actHiActinst;
	}
	public void setActHiActinst(ActHiActinst actHiActinst) {
		this.actHiActinst = actHiActinst;
	}
	
}