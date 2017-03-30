package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinalSalary implements Serializable {
	
	/**
	 * 主键id(自增长)
	 */
    private Long id;

    /**
     * 关联数据(A列)
     */
    private String associatedDataOne;

    /**
     * 关联数据(B列)
     */
    private String associatedDataTwo;

    /**
     * 关联数据(C列)
     */
    private String associatedDataThree;

    /**
     * 油站名称
     */
    private String stationName;

    /**
     * 地区系数
     */
    private String areaName;

    /**
     * 油站星级
     */
    private String stationLevelName;

    /**
     * 员工编号
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
     * 银行卡账号
     */
    private String staffBankcard;

    /**
     * 本人银行卡所属开户行
     */
    private String staffBank;

    /**
     * 职务
     */
    private String dutyName;

    /**
     * 入职日期
     */
    private String staffInDate;

    /**
     * 工作日
     */
    private BigDecimal workingDay;

    /**
     * 是否管站/带班
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
    private BigDecimal familyReunionDinnerOn;

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
    private BigDecimal monthDeparture;

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
    private BigDecimal splendorCardBlue;

    /**
     * 精彩卡-绿色版
     */
    private BigDecimal splendorCardGreen;

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
     * 试用期系数
     */
    private BigDecimal probationCoefficient;

    /**
     * 工作系数
     */
    private BigDecimal workingCoefficient;

    /**
     * 绩效系数
     */
    private BigDecimal performanceCoefficient;

    /**
     * 岗位工时
     */
    private BigDecimal postManHour;

    /**
     * 岗位时薪
     */
    private BigDecimal postHourSalary;

    /**
     * 管理岗位油品奖金
     */
    private BigDecimal managePostOilBonus;

    /**
     * 一线员工油品奖金
     */
    private BigDecimal firstTierStaffOilBonus;

    /**
     * 管理岗位非油品奖金
     */
    private BigDecimal managePostNonOilBonus;

    /**
     * 一线员工非油品奖金
     */
    private BigDecimal firstTierStaffNonOilBonus;

    /**
     * 管理岗位管理奖金
     */
    private BigDecimal managePostManageBonus;

    /**
     * 一线员工绩效奖金
     */
    private BigDecimal firstTierStaffPerformanceBonus;

    /**
     * 岗位工资
     */
    private BigDecimal postSalary;

    /**
     * 加班津贴
     */
    private BigDecimal overtimeAllowance;

    /**
     * 油品奖金
     */
    private BigDecimal oilBonus;

    /**
     * 非油品奖金
     */
    private BigDecimal nonOilBonus;

    /**
     * 星级、绩效奖金
     */
    private BigDecimal starLevelPerformanceBonus;

    /**
     * 经理奖金
     */
    private BigDecimal managerBonus;

    /**
     * 业绩挑战奖金
     */
    private BigDecimal performanceChallengeBonus;

    /**
     * 促销品奖金
     */
    private BigDecimal promotionsBonus;

    /**
     * 金点子奖金
     */
    private BigDecimal goldIdeaBonus;

    /**
     * 年度奖金
     */
    private BigDecimal annualBonus;

    /**
     * 精彩卡奖金
     */
    private BigDecimal splendorCardBonus;

    /**
     * 兼职便利店补贴
     */
    private BigDecimal partTimeStoreSubsidy;

    /**
     * 岗位津贴
     */
    private BigDecimal postAllowance;

    /**
     * 高温津贴
     */
    private BigDecimal highTemperatureAllowance;

    /**
     * 司龄补贴
     */
    private BigDecimal serviceYearAllowance;

    /**
     * 应发工资合计
     */
    private BigDecimal totalGrossSalary;

    /**
     * 工作餐补贴
     */
    private BigDecimal workingDinnerSubsidy;

    /**
     * 住宿补贴
     */
    private BigDecimal accommodationSubsidy;

    /**
     * 过节费
     */
    private BigDecimal holidayCosts;

    /**
     * 凉茶费、西瓜时刻
     */
    private BigDecimal herbWatermelonTime;

    /**
     * 应发总合计
     */
    private BigDecimal grossCombinationSalary;

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
     * 应税所得
     */
    private BigDecimal taxableIncome;

    /**
     * 工资所得税
     */
    private BigDecimal wageTax;

    /**
     * 预扣补贴
     */
    private BigDecimal withholdingSubsidies;

    /**
     * 话费扣款
     */
    private BigDecimal phoneCost;

    /**
     * 应扣合计
     */
    private BigDecimal totalCharge;

    /**
     * 应发工资
     */
    private BigDecimal netPay;

    /**
     * 薪资差异调整额（补差）
     * 无论是补差还是扣款, 薪资差异额同意用这个字段
     */
    private BigDecimal salaryDifferencePositive;

    /**
     * 薪资差异调整额（扣款）
     */
    @Deprecated
    private BigDecimal salaryDifferenceNegative;

    /**
     * 差异调整后应发工资
     */
    private BigDecimal salaryDifferenceFinal;

    /**
     * 备注
     */
    private String afterNetPayRemark;

    /**
     * 其他计税事项
     */
    private BigDecimal otherTaxMatters;

    /**
     * 应税总所得
     */
    private BigDecimal totalTaxableIncome;

    /**
     * 所得税
     */
    private BigDecimal incomeTax;

    /**
     * 未命名列(最后一列)
     */
    private Integer unnamedStaffCount;

    /**
     * 年月份
     */
    private String yearMonth;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssociatedDataOne() {
        return associatedDataOne;
    }

    public void setAssociatedDataOne(String associatedDataOne) {
        this.associatedDataOne = associatedDataOne == null ? null : associatedDataOne.trim();
    }

    public String getAssociatedDataTwo() {
        return associatedDataTwo;
    }

    public void setAssociatedDataTwo(String associatedDataTwo) {
        this.associatedDataTwo = associatedDataTwo == null ? null : associatedDataTwo.trim();
    }

    public String getAssociatedDataThree() {
        return associatedDataThree;
    }

    public void setAssociatedDataThree(String associatedDataThree) {
        this.associatedDataThree = associatedDataThree == null ? null : associatedDataThree.trim();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getStationLevelName() {
        return stationLevelName;
    }

    public void setStationLevelName(String stationLevelName) {
        this.stationLevelName = stationLevelName == null ? null : stationLevelName.trim();
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

    public String getStaffBankcard() {
        return staffBankcard;
    }

    public void setStaffBankcard(String staffBankcard) {
        this.staffBankcard = staffBankcard == null ? null : staffBankcard.trim();
    }

    public String getStaffBank() {
        return staffBank;
    }

    public void setStaffBank(String staffBank) {
        this.staffBank = staffBank == null ? null : staffBank.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getStaffInDate() {
        return staffInDate;
    }

    public void setStaffInDate(String staffInDate) {
        this.staffInDate = staffInDate == null ? null : staffInDate.trim();
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

    public BigDecimal getFamilyReunionDinnerOn() {
        return familyReunionDinnerOn;
    }

    public void setFamilyReunionDinnerOn(BigDecimal familyReunionDinnerOn) {
        this.familyReunionDinnerOn = familyReunionDinnerOn;
    }

    public BigDecimal getOnTheSpringFestivaOne() {
        return onTheSpringFestivaOne;
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

    public BigDecimal getMonthDeparture() {
        return monthDeparture;
    }

    public void setMonthDeparture(BigDecimal monthDeparture) {
        this.monthDeparture = monthDeparture;
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

    public BigDecimal getSplendorCardBlue() {
        return splendorCardBlue;
    }

    public void setSplendorCardBlue(BigDecimal splendorCardBlue) {
        this.splendorCardBlue = splendorCardBlue;
    }

    public BigDecimal getSplendorCardGreen() {
        return splendorCardGreen;
    }

    public void setSplendorCardGreen(BigDecimal splendorCardGreen) {
        this.splendorCardGreen = splendorCardGreen;
    }

    public BigDecimal getPartTimeScale() {
        return partTimeScale;
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

    public BigDecimal getProbationCoefficient() {
        return probationCoefficient;
    }

    public void setProbationCoefficient(BigDecimal probationCoefficient) {
        this.probationCoefficient = probationCoefficient;
    }

    public BigDecimal getWorkingCoefficient() {
        return workingCoefficient;
    }

    public void setWorkingCoefficient(BigDecimal workingCoefficient) {
        this.workingCoefficient = workingCoefficient;
    }

    public BigDecimal getPerformanceCoefficient() {
        return performanceCoefficient;
    }

    public void setPerformanceCoefficient(BigDecimal performanceCoefficient) {
        this.performanceCoefficient = performanceCoefficient;
    }

    public BigDecimal getPostManHour() {
        return postManHour;
    }

    public void setPostManHour(BigDecimal postManHour) {
        this.postManHour = postManHour;
    }

    public BigDecimal getPostHourSalary() {
        return postHourSalary;
    }

    public void setPostHourSalary(BigDecimal postHourSalary) {
        this.postHourSalary = postHourSalary;
    }

    public BigDecimal getManagePostOilBonus() {
        return managePostOilBonus;
    }

    public void setManagePostOilBonus(BigDecimal managePostOilBonus) {
        this.managePostOilBonus = managePostOilBonus;
    }

    public BigDecimal getFirstTierStaffOilBonus() {
        return firstTierStaffOilBonus;
    }

    public void setFirstTierStaffOilBonus(BigDecimal firstTierStaffOilBonus) {
        this.firstTierStaffOilBonus = firstTierStaffOilBonus;
    }

    public BigDecimal getManagePostNonOilBonus() {
        return managePostNonOilBonus;
    }

    public void setManagePostNonOilBonus(BigDecimal managePostNonOilBonus) {
        this.managePostNonOilBonus = managePostNonOilBonus;
    }

    public BigDecimal getFirstTierStaffNonOilBonus() {
        return firstTierStaffNonOilBonus;
    }

    public void setFirstTierStaffNonOilBonus(BigDecimal firstTierStaffNonOilBonus) {
        this.firstTierStaffNonOilBonus = firstTierStaffNonOilBonus;
    }

    public BigDecimal getManagePostManageBonus() {
        return managePostManageBonus;
    }

    public void setManagePostManageBonus(BigDecimal managePostManageBonus) {
        this.managePostManageBonus = managePostManageBonus;
    }

    public BigDecimal getFirstTierStaffPerformanceBonus() {
        return firstTierStaffPerformanceBonus;
    }

    public void setFirstTierStaffPerformanceBonus(BigDecimal firstTierStaffPerformanceBonus) {
        this.firstTierStaffPerformanceBonus = firstTierStaffPerformanceBonus;
    }

    public BigDecimal getPostSalary() {
        return postSalary;
    }

    public void setPostSalary(BigDecimal postSalary) {
        this.postSalary = postSalary;
    }

    public BigDecimal getOvertimeAllowance() {
        return overtimeAllowance;
    }

    public void setOvertimeAllowance(BigDecimal overtimeAllowance) {
        this.overtimeAllowance = overtimeAllowance;
    }

    public BigDecimal getOilBonus() {
        return oilBonus;
    }

    public void setOilBonus(BigDecimal oilBonus) {
        this.oilBonus = oilBonus;
    }

    public BigDecimal getNonOilBonus() {
        return nonOilBonus;
    }

    public void setNonOilBonus(BigDecimal nonOilBonus) {
        this.nonOilBonus = nonOilBonus;
    }

    public BigDecimal getStarLevelPerformanceBonus() {
        return starLevelPerformanceBonus;
    }

    public void setStarLevelPerformanceBonus(BigDecimal starLevelPerformanceBonus) {
        this.starLevelPerformanceBonus = starLevelPerformanceBonus;
    }

    public BigDecimal getManagerBonus() {
        return managerBonus;
    }

    public void setManagerBonus(BigDecimal managerBonus) {
        this.managerBonus = managerBonus;
    }

    public BigDecimal getPerformanceChallengeBonus() {
        return performanceChallengeBonus;
    }

    public void setPerformanceChallengeBonus(BigDecimal performanceChallengeBonus) {
        this.performanceChallengeBonus = performanceChallengeBonus;
    }

    public BigDecimal getPromotionsBonus() {
        return promotionsBonus;
    }

    public void setPromotionsBonus(BigDecimal promotionsBonus) {
        this.promotionsBonus = promotionsBonus;
    }

    public BigDecimal getGoldIdeaBonus() {
        return goldIdeaBonus;
    }

    public void setGoldIdeaBonus(BigDecimal goldIdeaBonus) {
        this.goldIdeaBonus = goldIdeaBonus;
    }

    public BigDecimal getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(BigDecimal annualBonus) {
        this.annualBonus = annualBonus;
    }

    public BigDecimal getSplendorCardBonus() {
        return splendorCardBonus;
    }

    public void setSplendorCardBonus(BigDecimal splendorCardBonus) {
        this.splendorCardBonus = splendorCardBonus;
    }

    public BigDecimal getPartTimeStoreSubsidy() {
        return partTimeStoreSubsidy;
    }

    public void setPartTimeStoreSubsidy(BigDecimal partTimeStoreSubsidy) {
        this.partTimeStoreSubsidy = partTimeStoreSubsidy;
    }

    public BigDecimal getPostAllowance() {
        return postAllowance;
    }

    public void setPostAllowance(BigDecimal postAllowance) {
        this.postAllowance = postAllowance;
    }

    public BigDecimal getHighTemperatureAllowance() {
        return highTemperatureAllowance;
    }

    public void setHighTemperatureAllowance(BigDecimal highTemperatureAllowance) {
        this.highTemperatureAllowance = highTemperatureAllowance;
    }

    public BigDecimal getServiceYearAllowance() {
        return serviceYearAllowance;
    }

    public void setServiceYearAllowance(BigDecimal serviceYearAllowance) {
        this.serviceYearAllowance = serviceYearAllowance;
    }

    public BigDecimal getTotalGrossSalary() {
        return totalGrossSalary;
    }

    public void setTotalGrossSalary(BigDecimal totalGrossSalary) {
        this.totalGrossSalary = totalGrossSalary;
    }

    public BigDecimal getWorkingDinnerSubsidy() {
        return workingDinnerSubsidy;
    }

    public void setWorkingDinnerSubsidy(BigDecimal workingDinnerSubsidy) {
        this.workingDinnerSubsidy = workingDinnerSubsidy;
    }

    public BigDecimal getAccommodationSubsidy() {
        return accommodationSubsidy;
    }

    public void setAccommodationSubsidy(BigDecimal accommodationSubsidy) {
        this.accommodationSubsidy = accommodationSubsidy;
    }

    public BigDecimal getHolidayCosts() {
        return holidayCosts;
    }

    public void setHolidayCosts(BigDecimal holidayCosts) {
        this.holidayCosts = holidayCosts;
    }

    public BigDecimal getHerbWatermelonTime() {
        return herbWatermelonTime;
    }

    public void setHerbWatermelonTime(BigDecimal herbWatermelonTime) {
        this.herbWatermelonTime = herbWatermelonTime;
    }

    public BigDecimal getGrossCombinationSalary() {
        return grossCombinationSalary;
    }

    public void setGrossCombinationSalary(BigDecimal grossCombinationSalary) {
        this.grossCombinationSalary = grossCombinationSalary;
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

    public BigDecimal getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(BigDecimal taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public BigDecimal getWageTax() {
        return wageTax;
    }

    public void setWageTax(BigDecimal wageTax) {
        this.wageTax = wageTax;
    }

    public BigDecimal getWithholdingSubsidies() {
        return withholdingSubsidies;
    }

    public void setWithholdingSubsidies(BigDecimal withholdingSubsidies) {
        this.withholdingSubsidies = withholdingSubsidies;
    }

    public BigDecimal getPhoneCost() {
        return phoneCost;
    }

    public void setPhoneCost(BigDecimal phoneCost) {
        this.phoneCost = phoneCost;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
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

    public BigDecimal getSalaryDifferenceFinal() {
        return salaryDifferenceFinal;
    }

    public void setSalaryDifferenceFinal(BigDecimal salaryDifferenceFinal) {
        this.salaryDifferenceFinal = salaryDifferenceFinal;
    }

    public String getAfterNetPayRemark() {
        return afterNetPayRemark;
    }

    public void setAfterNetPayRemark(String afterNetPayRemark) {
        this.afterNetPayRemark = afterNetPayRemark == null ? null : afterNetPayRemark.trim();
    }

    public BigDecimal getOtherTaxMatters() {
        return otherTaxMatters;
    }

    public void setOtherTaxMatters(BigDecimal otherTaxMatters) {
        this.otherTaxMatters = otherTaxMatters;
    }

    public BigDecimal getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public void setTotalTaxableIncome(BigDecimal totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Integer getUnnamedStaffCount() {
        return unnamedStaffCount;
    }

    public void setUnnamedStaffCount(Integer unnamedStaffCount) {
        this.unnamedStaffCount = unnamedStaffCount;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth == null ? null : yearMonth.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", associatedDataOne=").append(associatedDataOne);
        sb.append(", associatedDataTwo=").append(associatedDataTwo);
        sb.append(", associatedDataThree=").append(associatedDataThree);
        sb.append(", stationName=").append(stationName);
        sb.append(", areaName=").append(areaName);
        sb.append(", stationLevelName=").append(stationLevelName);
        sb.append(", staffCode=").append(staffCode);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffIdcard=").append(staffIdcard);
        sb.append(", staffBankcard=").append(staffBankcard);
        sb.append(", staffBank=").append(staffBank);
        sb.append(", dutyName=").append(dutyName);
        sb.append(", staffInDate=").append(staffInDate);
        sb.append(", workingDay=").append(workingDay);
        sb.append(", isStamanageForeman=").append(isStamanageForeman);
        sb.append(", isInternship=").append(isInternship);
        sb.append(", afterIntershipWorking=").append(afterIntershipWorking);
        sb.append(", peacetimeTimeout=").append(peacetimeTimeout);
        sb.append(", holidayOvertime=").append(holidayOvertime);
        sb.append(", familyReunionDinnerOn=").append(familyReunionDinnerOn);
        sb.append(", onTheSpringFestivaOne=").append(onTheSpringFestivaOne);
        sb.append(", onTheSpringFestivaTwo=").append(onTheSpringFestivaTwo);
        sb.append(", monthDeparture=").append(monthDeparture);
        sb.append(", casualLeave=").append(casualLeave);
        sb.append(", absenteeism=").append(absenteeism);
        sb.append(", sickLeave=").append(sickLeave);
        sb.append(", annualLeave=").append(annualLeave);
        sb.append(", marriageLeave=").append(marriageLeave);
        sb.append(", maternityLeave=").append(maternityLeave);
        sb.append(", funeralLeave=").append(funeralLeave);
        sb.append(", daysOff=").append(daysOff);
        sb.append(", verbalWarnings=").append(verbalWarnings);
        sb.append(", writtenWarning=").append(writtenWarning);
        sb.append(", majorAccident=").append(majorAccident);
        sb.append(", isAccomodate=").append(isAccomodate);
        sb.append(", isBoarder=").append(isBoarder);
        sb.append(", splendorCardBlue=").append(splendorCardBlue);
        sb.append(", splendorCardGreen=").append(splendorCardGreen);
        sb.append(", partTimeScale=").append(partTimeScale);
        sb.append(", monthPerformance=").append(monthPerformance);
        sb.append(", managerBonusScale=").append(managerBonusScale);
        sb.append(", remark=").append(remark);
        sb.append(", probationCoefficient=").append(probationCoefficient);
        sb.append(", workingCoefficient=").append(workingCoefficient);
        sb.append(", performanceCoefficient=").append(performanceCoefficient);
        sb.append(", postManHour=").append(postManHour);
        sb.append(", postHourSalary=").append(postHourSalary);
        sb.append(", managePostOilBonus=").append(managePostOilBonus);
        sb.append(", firstTierStaffOilBonus=").append(firstTierStaffOilBonus);
        sb.append(", managePostNonOilBonus=").append(managePostNonOilBonus);
        sb.append(", firstTierStaffNonOilBonus=").append(firstTierStaffNonOilBonus);
        sb.append(", managePostManageBonus=").append(managePostManageBonus);
        sb.append(", firstTierStaffPerformanceBonus=").append(firstTierStaffPerformanceBonus);
        sb.append(", postSalary=").append(postSalary);
        sb.append(", overtimeAllowance=").append(overtimeAllowance);
        sb.append(", oilBonus=").append(oilBonus);
        sb.append(", nonOilBonus=").append(nonOilBonus);
        sb.append(", starLevelPerformanceBonus=").append(starLevelPerformanceBonus);
        sb.append(", managerBonus=").append(managerBonus);
        sb.append(", performanceChallengeBonus=").append(performanceChallengeBonus);
        sb.append(", promotionsBonus=").append(promotionsBonus);
        sb.append(", goldIdeaBonus=").append(goldIdeaBonus);
        sb.append(", annualBonus=").append(annualBonus);
        sb.append(", splendorCardBonus=").append(splendorCardBonus);
        sb.append(", partTimeStoreSubsidy=").append(partTimeStoreSubsidy);
        sb.append(", postAllowance=").append(postAllowance);
        sb.append(", highTemperatureAllowance=").append(highTemperatureAllowance);
        sb.append(", serviceYearAllowance=").append(serviceYearAllowance);
        sb.append(", totalGrossSalary=").append(totalGrossSalary);
        sb.append(", workingDinnerSubsidy=").append(workingDinnerSubsidy);
        sb.append(", accommodationSubsidy=").append(accommodationSubsidy);
        sb.append(", holidayCosts=").append(holidayCosts);
        sb.append(", herbWatermelonTime=").append(herbWatermelonTime);
        sb.append(", grossCombinationSalary=").append(grossCombinationSalary);
        sb.append(", staffCostAccFund=").append(staffCostAccFund);
        sb.append(", staffCostEndowment=").append(staffCostEndowment);
        sb.append(", staffCostUnemployment=").append(staffCostUnemployment);
        sb.append(", staffCostMedical=").append(staffCostMedical);
        sb.append(", taxableIncome=").append(taxableIncome);
        sb.append(", wageTax=").append(wageTax);
        sb.append(", withholdingSubsidies=").append(withholdingSubsidies);
        sb.append(", phoneCost=").append(phoneCost);
        sb.append(", totalCharge=").append(totalCharge);
        sb.append(", netPay=").append(netPay);
        sb.append(", salaryDifferencePositive=").append(salaryDifferencePositive);
        sb.append(", salaryDifferenceNegative=").append(salaryDifferenceNegative);
        sb.append(", salaryDifferenceFinal=").append(salaryDifferenceFinal);
        sb.append(", afterNetPayRemark=").append(afterNetPayRemark);
        sb.append(", otherTaxMatters=").append(otherTaxMatters);
        sb.append(", totalTaxableIncome=").append(totalTaxableIncome);
        sb.append(", incomeTax=").append(incomeTax);
        sb.append(", unnamedStaffCount=").append(unnamedStaffCount);
        sb.append(", yearMonth=").append(yearMonth);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}