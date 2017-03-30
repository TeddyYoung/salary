package com.fh.entity.system;

import java.io.Serializable;
import java.util.Date;

public class CcTask implements Serializable {
    /**
     * 主键ID (自增)
     */
    private Long id;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 任务类型
     */
    private String taskType;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 抄送人
     */
    private String ccName;
    /**
     * 被抄送人
     */
    private String byCcName;
    /**
     * 任务开始时间
     */
    private String startTime;
    /**
     * 任务结束时间
     */
    private String endTime;
    /**
     * 创建时间
     */
    private Date sysCreateTime;
    /**
     * 更新时间
     */
    private Date sysUpdateTime;
    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName == null ? null : ccName.trim();
    }

    public String getByCcName() {
        return byCcName;
    }

    public void setByCcName(String byCcName) {
        this.byCcName = byCcName == null ? null : byCcName.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Date getSysCreateTime() {
        return sysCreateTime;
    }

    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", processInstanceId=").append(processInstanceId);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskName=").append(taskName);
        sb.append(", ccName=").append(ccName);
        sb.append(", byCcName=").append(byCcName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}