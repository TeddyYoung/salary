package com.fh.entity;

import java.io.Serializable;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;

import com.fh.entity.biz.Staff;
import com.fh.entity.system.ActHiActinst;

/**
 * 薪资差异申请
 * @author zhang_yu
 *
 */
@SuppressWarnings("serial")
public class SalaryDifferenceOffice implements Serializable {

	/**
	 * 拓展属性：历史
	 */
	private ActHiActinst actHiActinst;
	
	/**
	 * 拓展属性：员工
	 */
	private Staff staff;
	
	/**
	 * 工作流：任务
	 */
	private Task task;
	
	/**
	 * 工作流：历史任务实例
	 */
	private HistoricTaskInstance historicTaskInstance;
	
	public ActHiActinst getActHiActinst() {
		return actHiActinst;
	}

	public void setActHiActinst(ActHiActinst actHiActinst) {
		this.actHiActinst = actHiActinst;
	}

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

	public String toString() {
		return "SalaryDifferenceOffice [actHiActinst=" + actHiActinst
				+ ", staff=" + staff + ", task=" + task
				+ ", historicTaskInstance=" + historicTaskInstance + "]";
	}
	
}
