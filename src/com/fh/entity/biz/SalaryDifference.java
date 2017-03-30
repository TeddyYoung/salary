package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SalaryDifference implements Serializable {
    
	/**
	 * 主键id（自增长）
	 */
    private Long id;
    
    /**
     * 薪资差异编号
     */
    private String salaryDifferenceCode;

    /**
     * 关联员工编号
     */
    private String staffCode;

    /**
     * 关联员工姓名
     */
    private String staffName;
    
    /**
     * 关联员工所属油站
     */
    private String stationName;
    
    /**
     * 薪资汇总（就是没有经过差异处理之前的应发工资）
     */
    private BigDecimal salarySummary;

    /**
     * 薪资差异调整额
     */
    private BigDecimal salaryDifferencePositive;

    /**
     * 薪资差异调整额（扣款）
     */
    @Deprecated
    private BigDecimal salaryDifferenceNegative;

    /**
     * 审批状态(0-未审批; 1-审批中; 2-已审批)
     */
    private String approvalStatus;
    
    /**
     * 年月份
     */
    private String yearMonth;

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

	public String getSalaryDifferenceCode() {
        return salaryDifferenceCode;
    }

    public void setSalaryDifferenceCode(String salaryDifferenceCode) {
        this.salaryDifferenceCode = salaryDifferenceCode == null ? null : salaryDifferenceCode.trim();
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

    public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public BigDecimal getSalarySummary() {
        return salarySummary;
    }

    public void setSalarySummary(BigDecimal salarySummary) {
        this.salarySummary = salarySummary;
    }

    public BigDecimal getSalaryDifferencePositive() {
        return salaryDifferencePositive;
    }

    public void setSalaryDifferencePositive(BigDecimal salaryDifferencePositive) {
        this.salaryDifferencePositive = salaryDifferencePositive;
    }

    public BigDecimal getSalaryDifferenceNegative() {
        return salaryDifferenceNegative;
    }

    public void setSalaryDifferenceNegative(BigDecimal salaryDifferenceNegative) {
        this.salaryDifferenceNegative = salaryDifferenceNegative;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth == null ? null : yearMonth.trim();
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

	public String toString() {
		return "SalaryDifference [id=" + id + ", salaryDifferenceCode="
				+ salaryDifferenceCode + ", staffCode=" + staffCode
				+ ", staffName=" + staffName + ", stationName=" + stationName
				+ ", salarySummary=" + salarySummary
				+ ", salaryDifferencePositive=" + salaryDifferencePositive
				+ ", salaryDifferenceNegative=" + salaryDifferenceNegative
				+ ", approvalStatus=" + approvalStatus + ", yearMonth="
				+ yearMonth + ", sysCreateTime=" + sysCreateTime
				+ ", sysUpdateTime=" + sysUpdateTime + ", remark=" + remark
				+ "]";
	}

}