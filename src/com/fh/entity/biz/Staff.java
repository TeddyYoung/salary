package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 油站员工实体类
 * @author lijn
 *
 */
public class Staff implements Serializable {
	
	/**
	 * 主键ID
	 */
    private Long id;

    /**
     * 员工编号(业务主键)
     */
    private String staffCode;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 身份证号
     */
    private String staffIdcard;

    /**
     * 联系电话
     */
    private String staffPhone;

    /**
     * 员工性别(0-女, 1-男)
     */
    private String staffSex;

    /**
     * 员工照片
     */
    private String staffPhoto;

    /**
     * 员工状态(1-在职 2-离职)
     */
    private String staffStatus;

    /**
     * 入职日期
     */
    private String staffInDate;

    /**
     * 离职日期
     */
    private String staffOutDate;

    /**
     * 员工所属职务编号(关联职务信息表)
     */
    private String dutyCode;
    
    /**
     * 关联职务名称
     */
    private String dutyName;

    /**
     * 员工所属(关联油站信息表)
     */
    private String stationCode;
    
    /**
     * 油站名称
     */
    private String stationName;
    
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
     * 银行卡账号
     */
    private String staffBankcard;
    
    /**
     * 本人银行卡所属开户行
     */
    private String staffBank;
    
    /**
     * 离职原因
     */
    private String staffOutCause;
    
    /**
     * 离职类型   0 - 合同期满；1 - 单位辞退；2 - 本人辞职；3 - 协议解除
     */
    private String staffOutType;
    
    /**
     * 离职附件
     */
    private String staffOutUrl;
    
    /**
     * 离职前人员类别  0 - 从业人员；1 - 非在岗员工
     */
    private String outStaffCategory;
    
    /**
     * 调动日期
     */
    private String staffTransferDate;
    
    /**
     * 调动前职务编号
     */
    private String transferDutyCode;
    
    /**
     * 调动前油站编号
     */
    private String transferStationCode;
    
    /**
     * 调动状态
     */
    private String staffTransferStatus;
    
    /**
     * 审核状态  0 - 初始录入 1 - 审核中 2- 审核完成 
     */
    private String staffOutStatus;
    
    /**
     * 审核类型  0 - 入职申请 1 - 调动申请 2- 离职申请 3- 升迁申请 
     */
    private String staffCheckType;

    /**
     * 附加对象 职务对象
     */
    private Duty duty;
    
    /**
     * 工作日
     */
    private BigDecimal workingDay;
    
    private String jobLevel;
    
    public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffCode() {
		if (staffCode != null) {
			staffCode = staffCode.trim();
		}
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		if (staffCode != null) {
			staffCode = staffCode.trim();
		}
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffIdcard() {
		return staffIdcard;
	}

	public void setStaffIdcard(String staffIdcard) {
		this.staffIdcard = staffIdcard;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public String getStaffPhoto() {
		return staffPhoto;
	}

	public void setStaffPhoto(String staffPhoto) {
		this.staffPhoto = staffPhoto;
	}

	public String getStaffStatus() {
		return staffStatus;
	}

	public void setStaffStatus(String staffStatus) {
		this.staffStatus = staffStatus;
	}

	public String getStaffInDate() {
		return staffInDate;
	}

	public void setStaffInDate(String staffInDate) {
		this.staffInDate = staffInDate;
	}

	public String getStaffOutDate() {
		return staffOutDate;
	}

	public void setStaffOutDate(String staffOutDate) {
		this.staffOutDate = staffOutDate;
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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
		this.remark = remark;
	}

	public String getStaffBankcard() {
		return staffBankcard;
	}

	public void setStaffBankcard(String staffBankcard) {
		this.staffBankcard = staffBankcard;
	}

	public String getStaffBank() {
		return staffBank;
	}

	public void setStaffBank(String staffBank) {
		this.staffBank = staffBank;
	}

	public String getStaffOutCause() {
		return staffOutCause;
	}

	public void setStaffOutCause(String staffOutCause) {
		this.staffOutCause = staffOutCause;
	}

	public String getStaffOutType() {
		return staffOutType;
	}

	public void setStaffOutType(String staffOutType) {
		this.staffOutType = staffOutType;
	}

	public String getStaffOutUrl() {
		return staffOutUrl;
	}

	public void setStaffOutUrl(String staffOutUrl) {
		this.staffOutUrl = staffOutUrl;
	}

	public String getOutStaffCategory() {
		return outStaffCategory;
	}

	public void setOutStaffCategory(String outStaffCategory) {
		this.outStaffCategory = outStaffCategory;
	}

	public String getStaffTransferDate() {
		return staffTransferDate;
	}

	public void setStaffTransferDate(String staffTransferDate) {
		this.staffTransferDate = staffTransferDate;
	}

	public String getTransferDutyCode() {
		return transferDutyCode;
	}

	public void setTransferDutyCode(String transferDutyCode) {
		this.transferDutyCode = transferDutyCode;
	}

	public String getTransferStationCode() {
		return transferStationCode;
	}

	public void setTransferStationCode(String transferStationCode) {
		this.transferStationCode = transferStationCode;
	}

	public String getStaffTransferStatus() {
		return staffTransferStatus;
	}

	public void setStaffTransferStatus(String staffTransferStatus) {
		this.staffTransferStatus = staffTransferStatus;
	}

	public String getStaffOutStatus() {
		return staffOutStatus;
	}

	public void setStaffOutStatus(String staffOutStatus) {
		this.staffOutStatus = staffOutStatus;
	}

	public String getStaffCheckType() {
		return staffCheckType;
	}

	public void setStaffCheckType(String staffCheckType) {
		this.staffCheckType = staffCheckType;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public BigDecimal getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(BigDecimal workingDay) {
		this.workingDay = workingDay;
	}

	public String toString() {
		return "Staff [id=" + id + ", staffCode=" + staffCode + ", staffName="
				+ staffName + ", staffIdcard=" + staffIdcard + ", staffPhone="
				+ staffPhone + ", staffSex=" + staffSex + ", staffPhoto="
				+ staffPhoto + ", staffStatus=" + staffStatus
				+ ", staffInDate=" + staffInDate + ", staffOutDate="
				+ staffOutDate + ", dutyCode=" + dutyCode + ", dutyName="
				+ dutyName + ", stationCode=" + stationCode + ", stationName="
				+ stationName + ", sysCreateTime=" + sysCreateTime
				+ ", sysUpdateTime=" + sysUpdateTime + ", remark=" + remark
				+ ", staffBankcard=" + staffBankcard + ", staffBank="
				+ staffBank + ", staffOutCause=" + staffOutCause
				+ ", staffOutType=" + staffOutType + ", staffOutUrl="
				+ staffOutUrl + ", outStaffCategory=" + outStaffCategory
				+ ", staffTransferDate=" + staffTransferDate
				+ ", transferDutyCode=" + transferDutyCode
				+ ", transferStationCode=" + transferStationCode
				+ ", staffTransferStatus=" + staffTransferStatus
				+ ", staffOutStatus=" + staffOutStatus + ", staffCheckType="
				+ staffCheckType + ", duty=" + duty + ", workingDay="
				+ workingDay + "]";
	}

}