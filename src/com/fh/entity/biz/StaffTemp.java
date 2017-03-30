package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

public class StaffTemp implements Serializable {
	/**
     * 主键ID
     */
	private Long id;
    /**
     * 录用人员编号
     */
    private String staffCode;
    /**
     * 录用人员姓名
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
     * 员工性别
     */
    private String staffSex;
    /**
     * 到岗日期
     */
    private String entryDate;
    /**
     * 员工所属职务编号
     */
    private String dutyCode;
    /**
     * 员工所属油站编号
     */
    private String stationCode;
    /**
     * 学历
     */
    private String education;
    /**
     * 用工类别
     */
    private String staffCategory;
    /**
     * 合同类型
     */
    private String contractType;

    /**
     * 合同期限
     */
    private String contractPeriod;

    /**
     * 协议期限
     */
    private String agreementDeadline;
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

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffIdcard() {
        return staffIdcard;
    }

    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard == null ? null : staffIdcard.trim();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate == null ? null : entryDate.trim();
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode == null ? null : dutyCode.trim();
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory == null ? null : staffCategory.trim();
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod == null ? null : contractPeriod.trim();
    }

    public String getAgreementDeadline() {
        return agreementDeadline;
    }

    public void setAgreementDeadline(String agreementDeadline) {
        this.agreementDeadline = agreementDeadline == null ? null : agreementDeadline.trim();
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
        sb.append(", staffCode=").append(staffCode);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffIdcard=").append(staffIdcard);
        sb.append(", staffPhone=").append(staffPhone);
        sb.append(", staffSex=").append(staffSex);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", dutyCode=").append(dutyCode);
        sb.append(", stationCode=").append(stationCode);
        sb.append(", education=").append(education);
        sb.append(", staffCategory=").append(staffCategory);
        sb.append(", contractType=").append(contractType);
        sb.append(", contractPeriod=").append(contractPeriod);
        sb.append(", agreementDeadline=").append(agreementDeadline);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}