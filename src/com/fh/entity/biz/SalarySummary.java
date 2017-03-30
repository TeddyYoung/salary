package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SalarySummary implements Serializable {
	
	/**
	 * 主键id（自增长）
	 */
    private Long id;

    /**
     * 薪资汇总编号
     */
    private String salarySummaryCode;

    /**
     * 关联薪资差异编号
     */
    private String salaryDifferenceCode;

    /**
     * 关联员工编号
     */
    private String staffCode;

    /**
     * 薪资汇总（没有经过薪资差异处理之前的应发工资）
     */
    private BigDecimal salarySummary;

    /**
     * 差异调整后薪资汇总（经过薪资差异处理之后的应发工资）
     */
    private BigDecimal salaryDifferenceFinal;

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

    public String getSalarySummaryCode() {
        return salarySummaryCode;
    }

    public void setSalarySummaryCode(String salarySummaryCode) {
        this.salarySummaryCode = salarySummaryCode == null ? null : salarySummaryCode.trim();
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

    public BigDecimal getSalarySummary() {
        return salarySummary;
    }

    public void setSalarySummary(BigDecimal salarySummary) {
        this.salarySummary = salarySummary;
    }

    public BigDecimal getSalaryDifferenceFinal() {
        return salaryDifferenceFinal;
    }

    public void setSalaryDifferenceFinal(BigDecimal salaryDifferenceFinal) {
        this.salaryDifferenceFinal = salaryDifferenceFinal;
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
		return "SalarySummary [id=" + id + ", salarySummaryCode="
				+ salarySummaryCode + ", salaryDifferenceCode="
				+ salaryDifferenceCode + ", staffCode=" + staffCode
				+ ", salarySummary=" + salarySummary
				+ ", salaryDifferenceFinal=" + salaryDifferenceFinal
				+ ", yearMonth=" + yearMonth + ", sysCreateTime="
				+ sysCreateTime + ", sysUpdateTime=" + sysUpdateTime
				+ ", remark=" + remark + "]";
	}

}