package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AttendanceManagement implements Serializable {
	
	/**
	 * 主键id
	 */
    private Long id;
    
    /**
     * 关联油站编号
     */
    private String stationCode;
    
    /**
     * 关联油站名称
     */
    private String stationName;
    
    /**
     * 关联油站星级名称
     */
    private String stationLevelName;
    
    /**
     * 关联员工身份证号
     */
    private String staffIdcard;
    
    /**
     * 关联员工银行卡号
     */
    private String staffBankcard;
    
    /**
     * 关联员工银行卡号所属银行
     */
    private String staffBank;
    
    /**
     * 关联员工入职日期
     */
    private String staffInDate;
    
    /**
     * 关联员工编号
     */
    private String staffCode;
    
    /**
     * 关联员工姓名
     */
    private String staffName;
    
    /**
     * 关联地区名称
     */
    private String areaName;
    
    /**
     * 关联职务
     */
    private String dutyName;
    
    /**
     * 工作日
     */
    private BigDecimal workingDay;

    /**
     * 是否管站、带班
     */
    private String isStamanageForeman;

    /**
     * 是否实习期内
     */
    private String isInternship;

    /**
     * 本月实习期满后工作天数
     */
    private BigDecimal afterIntershipWorking;

    /**
     * 平时超时
     */
    private BigDecimal peacetimeTimeout;

    /**
     * 节日加班
     */
    private BigDecimal holidayOvertime;

    /**
     * 年夜饭在岗
     */
   // private BigDecimal familyReunionDinnerOn;
    private String isFamilyReunionDinnerOn;

    /**
     * 春节在岗(阶段一)
     */
    private BigDecimal onTheSpringFestivaOne;

    /**
     * 春节在岗(阶段二)
     */
    private BigDecimal onTheSpringFestivaTwo;

    /**
     * 本月离职
     */
   // private BigDecimal monthDeparture;
    private String isDeparture;

    /**
     * 事假
     */
    private BigDecimal casualLeave;

    /**
     * 旷工
     */
    private BigDecimal absenteeism;

    /**
     * 病假
     */
    private BigDecimal sickLeave;

    /**
     * 年假
     */
    private BigDecimal annualLeave;

    /**
     * 婚假
     */
    private BigDecimal marriageLeave;

    /**
     * 产假
     */
    private BigDecimal maternityLeave;

    /**
     * 丧假
     */
    private BigDecimal funeralLeave;

    /**
     * 调休
     */
    private BigDecimal daysOff;

    /**
     * 警告
     */
    private BigDecimal verbalWarnings;

    /**
     * 记过
     */
    private BigDecimal writtenWarning;

    /**
     * 重大事故
     */
    private BigDecimal majorAccident;

    /**
     * 是否保留宿舍
     */
    private String isAccomodate;

    /**
     * 是否搭伙
     */
    private String isBoarder;

    /**
     * 精彩卡-蓝色版
     */
//    private BigDecimal splendorCardBlue;
    private Integer splendorCardBlue;

    /**
     * 精彩卡-绿色版
     */
    //private BigDecimal splendorCardGreen;
    private Integer splendorCardGreen;

    /**
     * 兼职便利店员比例
     */
    private BigDecimal partTimeScale;

    /**
     * 月度绩效(100分制)
     */
    private BigDecimal monthPerformance;

    /**
     * 经理奖金分配比例
     */
    private BigDecimal managerBonusScale;

    /**
     * 备注
     */
    private String remark;

    /**
     * 年份月份
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
    
    // 考勤状态 0 -提交审批；1-审批通过
    private String status;
    
    private BigDecimal nightShiftDays;
    
    private BigDecimal lossAmt;// 损耗金额
    
    private BigDecimal holidayMoney;// 过节费
    
    private BigDecimal subsidyMoney;// 补贴
    
    private BigDecimal jobSubsidies;// 岗位津贴
    
    /**
     * 话费扣款
     */
    private BigDecimal phoneCost;
    
    private BigDecimal lossBonusAmt;// 油品损耗
    
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
     * 库提奖金
     */
    private BigDecimal inventoryDeductAmt;
    
    /**
     * 医疗保险
     */
    private BigDecimal staffCostMedical;
    
    private String dutyNature;
    
    private BigDecimal accommodationSubsidy;
    
    private String isAccommoSubsidyArti;
    /**
     * 跨站支援天数
     */
    private BigDecimal supportDays;
    
    /**
     * 继续教育扣款
     */
    private BigDecimal educationCost;

    
    private static final long serialVersionUID = 1L;

    public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationLevelName() {
		return stationLevelName;
	}

	public void setStationLevelName(String stationLevelName) {
		this.stationLevelName = stationLevelName;
	}

	public String getStaffIdcard() {
		return staffIdcard;
	}

	public void setStaffIdcard(String staffIdcard) {
		this.staffIdcard = staffIdcard;
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

	public String getStaffInDate() {
		return staffInDate;
	}

	public void setStaffInDate(String staffInDate) {
		this.staffInDate = staffInDate;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
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

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public BigDecimal getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(BigDecimal workingDay) {
        this.workingDay = workingDay;
    }

    public String getIsStamanageForeman() {
        return isStamanageForeman;
    }

    public void setIsStamanageForeman(String isStamanageForeman) {
        this.isStamanageForeman = isStamanageForeman == null ? null : isStamanageForeman.trim();
    }

    public String getIsInternship() {
        return isInternship;
    }

    public void setIsInternship(String isInternship) {
        this.isInternship = isInternship == null ? null : isInternship.trim();
    }

    public BigDecimal getAfterIntershipWorking() {
        return afterIntershipWorking;
    }

    public void setAfterIntershipWorking(BigDecimal afterIntershipWorking) {
        this.afterIntershipWorking = afterIntershipWorking;
    }

    public BigDecimal getPeacetimeTimeout() {
        return peacetimeTimeout;
    }

    public void setPeacetimeTimeout(BigDecimal peacetimeTimeout) {
        this.peacetimeTimeout = peacetimeTimeout;
    }

    public BigDecimal getHolidayOvertime() {
        return holidayOvertime;
    }

    public void setHolidayOvertime(BigDecimal holidayOvertime) {
        this.holidayOvertime = holidayOvertime;
    }

//    public BigDecimal getFamilyReunionDinnerOn() {
//        return familyReunionDinnerOn;
//    }
//
//    public void setFamilyReunionDinnerOn(BigDecimal familyReunionDinnerOn) {
//        this.familyReunionDinnerOn = familyReunionDinnerOn;
//    }

    public BigDecimal getOnTheSpringFestivaOne() {
        return onTheSpringFestivaOne;
    }


	public String getIsFamilyReunionDinnerOn() {
		return isFamilyReunionDinnerOn;
	}

	public void setIsFamilyReunionDinnerOn(String isFamilyReunionDinnerOn) {
		this.isFamilyReunionDinnerOn = isFamilyReunionDinnerOn;
	}

	public void setOnTheSpringFestivaOne(BigDecimal onTheSpringFestivaOne) {
        this.onTheSpringFestivaOne = onTheSpringFestivaOne;
    }

    public BigDecimal getOnTheSpringFestivaTwo() {
        return onTheSpringFestivaTwo;
    }

    public void setOnTheSpringFestivaTwo(BigDecimal onTheSpringFestivaTwo) {
        this.onTheSpringFestivaTwo = onTheSpringFestivaTwo;
    }


    public BigDecimal getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(BigDecimal casualLeave) {
        this.casualLeave = casualLeave;
    }

    public BigDecimal getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(BigDecimal absenteeism) {
        this.absenteeism = absenteeism;
    }

    public BigDecimal getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(BigDecimal sickLeave) {
        this.sickLeave = sickLeave;
    }

    public BigDecimal getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(BigDecimal annualLeave) {
        this.annualLeave = annualLeave;
    }

    public BigDecimal getMarriageLeave() {
        return marriageLeave;
    }

    public void setMarriageLeave(BigDecimal marriageLeave) {
        this.marriageLeave = marriageLeave;
    }

    public BigDecimal getMaternityLeave() {
        return maternityLeave;
    }

    public void setMaternityLeave(BigDecimal maternityLeave) {
        this.maternityLeave = maternityLeave;
    }

    public BigDecimal getFuneralLeave() {
        return funeralLeave;
    }

    public void setFuneralLeave(BigDecimal funeralLeave) {
        this.funeralLeave = funeralLeave;
    }

    public BigDecimal getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(BigDecimal daysOff) {
        this.daysOff = daysOff;
    }

    public BigDecimal getVerbalWarnings() {
        return verbalWarnings;
    }

    public void setVerbalWarnings(BigDecimal verbalWarnings) {
        this.verbalWarnings = verbalWarnings;
    }

    public BigDecimal getWrittenWarning() {
        return writtenWarning;
    }

    public void setWrittenWarning(BigDecimal writtenWarning) {
        this.writtenWarning = writtenWarning;
    }

    public BigDecimal getMajorAccident() {
        return majorAccident;
    }

    public void setMajorAccident(BigDecimal majorAccident) {
        this.majorAccident = majorAccident;
    }

    public String getIsAccomodate() {
        return isAccomodate;
    }

    public void setIsAccomodate(String isAccomodate) {
        this.isAccomodate = isAccomodate == null ? null : isAccomodate.trim();
    }

    public String getIsBoarder() {
        return isBoarder;
    }

    public void setIsBoarder(String isBoarder) {
        this.isBoarder = isBoarder == null ? null : isBoarder.trim();
    }

//    public BigDecimal getSplendorCardBlue() {
//        return splendorCardBlue;
//    }
//
//    public void setSplendorCardBlue(BigDecimal splendorCardBlue) {
//        this.splendorCardBlue = splendorCardBlue;
//    }
//
//    public BigDecimal getSplendorCardGreen() {
//        return splendorCardGreen;
//    }
//
//    public void setSplendorCardGreen(BigDecimal splendorCardGreen) {
//        this.splendorCardGreen = splendorCardGreen;
//    }

    public BigDecimal getPartTimeScale() {
        return partTimeScale;
    }

    public Integer getSplendorCardBlue() {
		return splendorCardBlue;
	}

	public void setSplendorCardBlue(Integer splendorCardBlue) {
		this.splendorCardBlue = splendorCardBlue;
	}

	public Integer getSplendorCardGreen() {
		return splendorCardGreen;
	}

	public void setSplendorCardGreen(Integer splendorCardGreen) {
		this.splendorCardGreen = splendorCardGreen;
	}

	public void setPartTimeScale(BigDecimal partTimeScale) {
        this.partTimeScale = partTimeScale;
    }

    public BigDecimal getMonthPerformance() {
        return monthPerformance;
    }

    public void setMonthPerformance(BigDecimal monthPerformance) {
        this.monthPerformance = monthPerformance;
    }

    public BigDecimal getManagerBonusScale() {
        return managerBonusScale;
    }

    public void setManagerBonusScale(BigDecimal managerBonusScale) {
        this.managerBonusScale = managerBonusScale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

	public BigDecimal getLossAmt() {
		return lossAmt;
	}

	public void setLossAmt(BigDecimal lossAmt) {
		this.lossAmt = lossAmt;
	}

	public BigDecimal getHolidayMoney() {
		return holidayMoney;
	}

	public void setHolidayMoney(BigDecimal holidayMoney) {
		this.holidayMoney = holidayMoney;
	}

	public BigDecimal getSubsidyMoney() {
		return subsidyMoney;
	}

	public void setSubsidyMoney(BigDecimal subsidyMoney) {
		this.subsidyMoney = subsidyMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getLossBonusAmt() {
		return lossBonusAmt;
	}

	public void setLossBonusAmt(BigDecimal lossBonusAmt) {
		this.lossBonusAmt = lossBonusAmt;
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

	public BigDecimal getNightShiftDays() {
		return nightShiftDays;
	}

	public void setNightShiftDays(BigDecimal nightShiftDays) {
		this.nightShiftDays = nightShiftDays;
	}

	public BigDecimal getJobSubsidies() {
		return jobSubsidies;
	}

	public void setJobSubsidies(BigDecimal jobSubsidies) {
		this.jobSubsidies = jobSubsidies;
	}

	public BigDecimal getPhoneCost() {
		return phoneCost;
	}

	public void setPhoneCost(BigDecimal phoneCost) {
		this.phoneCost = phoneCost;
	}

	public String getDutyNature() {
		return dutyNature;
	}

	public void setDutyNature(String dutyNature) {
		this.dutyNature = dutyNature;
	}

	public BigDecimal getInventoryDeductAmt() {
		return inventoryDeductAmt;
	}

	public void setInventoryDeductAmt(BigDecimal inventoryDeductAmt) {
		this.inventoryDeductAmt = inventoryDeductAmt;
	}

	public BigDecimal getAccommodationSubsidy() {
		return accommodationSubsidy;
	}

	public void setAccommodationSubsidy(BigDecimal accommodationSubsidy) {
		this.accommodationSubsidy = accommodationSubsidy;
	}

	public String getIsDeparture() {
		return isDeparture;
	}

	public void setIsDeparture(String isDeparture) {
		this.isDeparture = isDeparture;
	}

	public String getIsAccommoSubsidyArti() {
		return isAccommoSubsidyArti;
	}

	public void setIsAccommoSubsidyArti(String isAccommoSubsidyArti) {
		this.isAccommoSubsidyArti = isAccommoSubsidyArti;
	}

	public BigDecimal getSupportDays() {
		return supportDays;
	}

	public void setSupportDays(BigDecimal supportDays) {
		this.supportDays = supportDays;
	}

	public BigDecimal getEducationCost() {
		return educationCost;
	}

	public void setEducationCost(BigDecimal educationCost) {
		this.educationCost = educationCost;
	}


}