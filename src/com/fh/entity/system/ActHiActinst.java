package com.fh.entity.system;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActHiActinst implements Serializable {
    /**
     * 主键  不自增站长
     */
    private String id;
    /**
     * 流程定义id
     */
    private String procDefId;
    /**
     * 流程实例id
     */
    private String procInstId;
    /**
     * 执行id
     */
    private String executionId;
    /**
     * actId
     */
    private String actId;
    /**
     * 任务id
     */
    private String taskId;
    /**
     * call流程实例的id
     */
    private String callProcInstId;
    /**
     * act名称
     */
    private String actName;
    /**
     * act类型
     */
    private String actType;
    /**
     * 执行者
     */
    private String assignee;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 
     */
    private BigDecimal duration;
    /**
     * 操作
     */
    private String operation;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId == null ? null : procDefId.trim();
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId == null ? null : executionId.trim();
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId == null ? null : actId.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getCallProcInstId() {
        return callProcInstId;
    }

    public void setCallProcInstId(String callProcInstId) {
        this.callProcInstId = callProcInstId == null ? null : callProcInstId.trim();
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName == null ? null : actName.trim();
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType == null ? null : actType.trim();
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee == null ? null : assignee.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", procDefId=").append(procDefId);
        sb.append(", procInstId=").append(procInstId);
        sb.append(", executionId=").append(executionId);
        sb.append(", actId=").append(actId);
        sb.append(", taskId=").append(taskId);
        sb.append(", callProcInstId=").append(callProcInstId);
        sb.append(", actName=").append(actName);
        sb.append(", actType=").append(actType);
        sb.append(", assignee=").append(assignee);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", duration=").append(duration);
        sb.append(", operation=").append(operation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}