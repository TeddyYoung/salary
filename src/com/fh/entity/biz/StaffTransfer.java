package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;

import com.fh.entity.system.ActHiActinst;

/**
 * 调动临时表
 * @author lijn
 *
 */
public class StaffTransfer implements Serializable {
    /**
     * 主键ID  自增
     */
    private Long id;
    /**
     * 调动编号 业务主键
     */
    private String transferCode;
    /**
     * 员工编号
     */
    private String staffCode;
    /**
     * 调动前油站编号
     */
    private String beforeStationCode;
    /**
     * 调动前职务编号
     */
    private String beforeDutyCode;
    /**
     * 调动日期
     */
    private String staffTransferDate;
    /**
     * 调动附件
     */
    private String staffTransferUrl;

    /**
     * 调动后油站编号
     */
    private String afterStationCode;
    /**
     * 调动后职务编号
     */
    private String afterDutyCode;
    /**
     * 调动原因
     */
    private String staffTransferCause;
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
    /**
     * 拓展属性：员工
     */
    private Staff staff;
    
	/**
	 * 历史任务实例
	 */
	private HistoricTaskInstance historicTaskInstance;
	/**
	 * 历史节点实例
	 */
	private HistoricActivityInstance historicActivityInstance;
	/**
	 * 流程历史实体类
	 */
	private ActHiActinst actHiActinst;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HistoricTaskInstance getHistoricTaskInstance() {
		return historicTaskInstance;
	}

	public void setHistoricTaskInstance(HistoricTaskInstance historicTaskInstance) {
		this.historicTaskInstance = historicTaskInstance;
	}

	public ActHiActinst getActHiActinst() {
		return actHiActinst;
	}

	public void setActHiActinst(ActHiActinst actHiActinst) {
		this.actHiActinst = actHiActinst;
	}

	public HistoricActivityInstance getHistoricActivityInstance() {
		return historicActivityInstance;
	}

	public void setHistoricActivityInstance(
			HistoricActivityInstance historicActivityInstance) {
		this.historicActivityInstance = historicActivityInstance;
	}

	public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode == null ? null : transferCode.trim();
    }

    public String getStaffCode() {
        return staffCode;
    }

    public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public String getBeforeStationCode() {
        return beforeStationCode;
    }

    public void setBeforeStationCode(String beforeStationCode) {
        this.beforeStationCode = beforeStationCode == null ? null : beforeStationCode.trim();
    }

    public String getBeforeDutyCode() {
        return beforeDutyCode;
    }

    public void setBeforeDutyCode(String beforeDutyCode) {
        this.beforeDutyCode = beforeDutyCode == null ? null : beforeDutyCode.trim();
    }

    public String getStaffTransferDate() {
        return staffTransferDate;
    }

    public void setStaffTransferDate(String staffTransferDate) {
        this.staffTransferDate = staffTransferDate == null ? null : staffTransferDate.trim();
    }

    public String getStaffTransferUrl() {
        return staffTransferUrl;
    }

    public void setStaffTransferUrl(String staffTransferUrl) {
        this.staffTransferUrl = staffTransferUrl == null ? null : staffTransferUrl.trim();
    }

    public String getAfterStationCode() {
        return afterStationCode;
    }

    public void setAfterStationCode(String afterStationCode) {
        this.afterStationCode = afterStationCode == null ? null : afterStationCode.trim();
    }

    public String getAfterDutyCode() {
        return afterDutyCode;
    }

    public void setAfterDutyCode(String afterDutyCode) {
        this.afterDutyCode = afterDutyCode == null ? null : afterDutyCode.trim();
    }

    public String getStaffTransferCause() {
        return staffTransferCause;
    }

    public void setStaffTransferCause(String staffTransferCause) {
        this.staffTransferCause = staffTransferCause == null ? null : staffTransferCause.trim();
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
        sb.append(", transferCode=").append(transferCode);
        sb.append(", staffCode=").append(staffCode);
        sb.append(", beforeStationCode=").append(beforeStationCode);
        sb.append(", beforeDutyCode=").append(beforeDutyCode);
        sb.append(", staffTransferDate=").append(staffTransferDate);
        sb.append(", staffTransferUrl=").append(staffTransferUrl);
        sb.append(", afterStationCode=").append(afterStationCode);
        sb.append(", afterDutyCode=").append(afterDutyCode);
        sb.append(", staffTransferCause=").append(staffTransferCause);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}