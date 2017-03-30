package com.fh.entity.system;

import java.io.Serializable;
import java.util.Date;

import org.activiti.engine.task.Task;

/**
 * 用户权限指派表
 * @author MacBook
 *
 */
public class TbWorkflowUserDUser implements Serializable {
	
	/**
	 * 序号
	 */
    private Integer id;
    
    /**
     * 指派用户
     */
    private String userid;
    
    /**
     * 指派授权角色
     */
    private String userPart;
    
    /**
     * 指派授权部门
     */
    private String userDep;

    /**
     * 被指派人
     */
    private String dUserid;
    
    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;
 
    /**
     * 状态
     */
    private String diff;

    /**
     * 流程定义id
     */
    private String processDefinitionId;

    /**
     * 流程类型 
     */
    private String flowType;
    
    /**
     * 拓展属性对象：当前流程任务对象
     */
    private Task task;
    
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getUserPart() {
        return userPart;
    }

    public void setUserPart(String userPart) {
        this.userPart = userPart == null ? null : userPart.trim();
    }

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getUserDep() {
        return userDep;
    }

    public void setUserDep(String userDep) {
        this.userDep = userDep == null ? null : userDep.trim();
    }

    public String getdUserid() {
        return dUserid;
    }

    public void setdUserid(String dUserid) {
        this.dUserid = dUserid == null ? null : dUserid.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff == null ? null : diff.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", userPart=").append(userPart);
        sb.append(", userDep=").append(userDep);
        sb.append(", dUserid=").append(dUserid);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", diff=").append(diff);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}