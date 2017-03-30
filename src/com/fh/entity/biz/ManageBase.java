package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ManageBase implements Serializable {
	
	/**
     * 主键ID
     */
    private Long id;
    
    /**
     * 员工编号
     */
    private String staffCode;
    
    /**
     * 关联员工姓名
     */
    private String staffName;
    
    /**
     * 附加员工对象
     */
    private Staff staff;
    
    /**
     * 职级
     */
    private String dutyLevel;
    
    /**
     * 职务性质   1-正式；2-兼站；3-见习
     */
    private String dutyNature;
    
    /**
     * 关联职务名称
     */
    private String dutyName;
    
    private String newDutyName;// 职务名称
    
    /**
     * 油站名称
     */
    private String stationName;
    
    private String stationCode;// 油站编号
    
    /**
     * 岗位工资
     */
    private BigDecimal postSalary;
    
    /**
     * 话费扣款
     */
    private BigDecimal phoneCost;
    /**
     * 继续教育扣款
     */
    private BigDecimal educationCost;
    
    /**
     * 月度绩效系数
     */
    private BigDecimal performanceCoefficient;
    
    /**
     * 岗位津贴
     */
    private BigDecimal jobSubsidies;
    
    /**
     * 兼站奖金基数
     */
    private BigDecimal bonusBase;
    
    /**
     * 兼站奖金系数
     */
    private BigDecimal bonusCoefficient;
    
    /**
     * 达标率
     */
    private BigDecimal standardRate;
    
    /**
     * 话费扣款检测   计算话费是否成功扣款;0-不成功；1-成功
     */
    private String phoneCostDetection;

    /**
     * 最后一列, 未命名列(计算兼站人员奖金)
     */
    private BigDecimal stationStaffBonuses;

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
    
    private BigDecimal newPostSalary;// 岗位薪资

    private static final long serialVersionUID = 1L;
    /**
     * 扣款类型-话费扣款
     */
    public static final String DEDUCTIONS_TYPE_PHONE_CHARGE = "0";
    /**
     * 扣款类型-继续教育扣款
     */
    public static final String DEDUCTIONS_TYPE_EDUCATION = "1";

    public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getDutyNature() {
        return dutyNature;
    }

    public void setDutyNature(String dutyNature) {
        this.dutyNature = dutyNature == null ? null : dutyNature.trim();
    }

    public String getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(String dutyLevel) {
        this.dutyLevel = dutyLevel == null ? null : dutyLevel.trim();
    }

    public BigDecimal getPostSalary() {
        return postSalary;
    }

    public void setPostSalary(BigDecimal postSalary) {
        this.postSalary = postSalary;
    }

    public BigDecimal getPhoneCost() {
        return phoneCost;
    }

    public void setPhoneCost(BigDecimal phoneCost) {
        this.phoneCost = phoneCost;
    }

    public BigDecimal getPerformanceCoefficient() {
        return performanceCoefficient;
    }

    public void setPerformanceCoefficient(BigDecimal performanceCoefficient) {
        this.performanceCoefficient = performanceCoefficient;
    }

    public BigDecimal getJobSubsidies() {
        return jobSubsidies;
    }

    public void setJobSubsidies(BigDecimal jobSubsidies) {
        this.jobSubsidies = jobSubsidies;
    }

    public BigDecimal getBonusBase() {
        return bonusBase;
    }

    public void setBonusBase(BigDecimal bonusBase) {
        this.bonusBase = bonusBase;
    }

    public BigDecimal getBonusCoefficient() {
        return bonusCoefficient;
    }

    public void setBonusCoefficient(BigDecimal bonusCoefficient) {
        this.bonusCoefficient = bonusCoefficient;
    }

    public BigDecimal getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(BigDecimal standardRate) {
        this.standardRate = standardRate;
    }

    public String getPhoneCostDetection() {
        return phoneCostDetection;
    }

    public void setPhoneCostDetection(String phoneCostDetection) {
        this.phoneCostDetection = phoneCostDetection == null ? null : phoneCostDetection.trim();
    }

    public BigDecimal getStationStaffBonuses() {
        return stationStaffBonuses;
    }

    public void setStationStaffBonuses(BigDecimal stationStaffBonuses) {
        this.stationStaffBonuses = stationStaffBonuses;
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

	public String getNewDutyName() {
		return newDutyName;
	}

	public void setNewDutyName(String newDutyName) {
		this.newDutyName = newDutyName;
	}

	public BigDecimal getNewPostSalary() {
		return newPostSalary;
	}

	public void setNewPostSalary(BigDecimal newPostSalary) {
		this.newPostSalary = newPostSalary;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public BigDecimal getEducationCost() {
		return educationCost;
	}

	public void setEducationCost(BigDecimal educationCost) {
		this.educationCost = educationCost;
	}

}