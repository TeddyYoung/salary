package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StaffCost implements Serializable {
    
	/**
     * 主键ID 自增
     */
    private Long id;
    
    private String stationCode;

    /**
     * 关联油站名称
     */
    private String stationName;
    
    /**
     * 姓名
     */
    private String staffName;
    
    /**
     * 关联员工身份证号
     */
    private String staffIdcard;
    
    /**
     * 所属员工编号
     */
    private String staffCode;
    
    /**
     * 所属年份月份
     */
    private String staffCostYearMonth;
    
    /**
     * 公积金
     */
    private BigDecimal staffCostAccFund;
    
    /**
     * 养老保险
     */
    private BigDecimal staffCostEndowment;
    
    /**
     * 失业保险
     */
    private BigDecimal staffCostUnemployment;
    
    /**
     * 医疗保险
     */
    private BigDecimal staffCostMedical;
    
    /**
     * 共计
     */
    private BigDecimal total;
    
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
    
    private BigDecimal lossAmt;// 员工损耗奖罚
    
    /**
     * 拓展属性：员工
     */
    private Staff staff;
    
    private String dutyCode;
	
    private static final long serialVersionUID = 1L;

    public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
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

    public String getStaffCostYearMonth() {
        return staffCostYearMonth;
    }

    public void setStaffCostYearMonth(String staffCostYearMonth) {
        this.staffCostYearMonth = staffCostYearMonth == null ? null : staffCostYearMonth.trim();
    }

    public BigDecimal getStaffCostAccFund() {
        return staffCostAccFund;
    }

    public void setStaffCostAccFund(BigDecimal staffCostAccFund) {
        this.staffCostAccFund = staffCostAccFund;
    }

    public BigDecimal getStaffCostEndowment() {
        return staffCostEndowment;
    }

    public void setStaffCostEndowment(BigDecimal staffCostEndowment) {
        this.staffCostEndowment = staffCostEndowment;
    }

    public BigDecimal getStaffCostUnemployment() {
        return staffCostUnemployment;
    }

    public void setStaffCostUnemployment(BigDecimal staffCostUnemployment) {
        this.staffCostUnemployment = staffCostUnemployment;
    }

    public BigDecimal getStaffCostMedical() {
        return staffCostMedical;
    }

    public void setStaffCostMedical(BigDecimal staffCostMedical) {
        this.staffCostMedical = staffCostMedical;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public BigDecimal getLossAmt() {
		return lossAmt;
	}

	public void setLossAmt(BigDecimal lossAmt) {
		this.lossAmt = lossAmt;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	
}