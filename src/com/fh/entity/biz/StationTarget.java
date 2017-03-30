package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StationTarget implements Serializable {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 关联油站编号
	 */
	private String stationCode;

	/**
	 * 关联油站对象
	 */
	private Station station;

	/**
	 * 关联油站名称
	 */
	private String stationName;

	/**
	 * 关联油站星级名称
	 */
	private String stationLevelName;

	/**
	 * 定编人数
	 */
	private Integer stationStaffNum;

	/**
	 * 浮动编制人数
	 */
	private Integer stationStaffNumFloat;

	/**
	 * 关联油站星级编号
	 */
	private String stationLevelCode;

	/**
	 * 关联油站星级对象
	 */
	private StationLevel stationLevel;

	/**
	 * mmp
	 */
	private Double mmp;

	/**
	 * nps
	 */
	private Double nps;

	/**
	 * 油品本月目标销量
	 */
	private BigDecimal oilTargetVolume;

	/**
	 * 油品本月实际销量
	 */
	private BigDecimal oilRealVolume;

	/**
	 * 油品日均销量
	 */
	private BigDecimal oilDayAverageVolume;

	/**
	 * 非油品本月目标销量
	 */
	private BigDecimal nonOilTargetVolume;

	/**
	 * 非油品本月实际销量
	 */
	private BigDecimal nonOilRealVolume;

	/**
	 * 非油品日均销量
	 */
	private BigDecimal nonOilDayAverageVolume;

	/**
	 * 便利店业绩得分
	 */
	private BigDecimal storeMarkScore;

	/**
	 * 便利店管理得分
	 */
	private BigDecimal storeManageScore;

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

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 本月汽油目标销量
	 */
	private BigDecimal gasolineTargetVolume;

	/**
	 * 本月柴油目标销量
	 */
	private BigDecimal dieselTargetVolume;

	/**
	 * 汽油日均销量
	 */
	private BigDecimal gasolineDayAverageVolume;

	/**
	 * 柴油日均销量
	 */
	private BigDecimal dieselDayAverageVolume;

	/**
	 * 是否保留宿舍(0-是; 1-否)
	 */
	private String isKeepDormitory;

	/**
	 * 宿舍补贴
	 */
	private BigDecimal dormitorySubsidies;

	/**
	 * 月度便利店津贴
	 */
	private BigDecimal monthlyStoreAllowance;

	/**
	 * 油品达标率
	 */
	private BigDecimal oilStandardRate;

	/**
	 * 非油品达标率
	 */
	private BigDecimal nonOilStandardRate;

	/**
	 * 油站经理小配、直销奖金
	 */
	private BigDecimal directSellingBonus;

	/**
	 * 上限
	 */
	private BigDecimal upperLimit;

	/**
	 * MMP系数
	 */
	private BigDecimal mmpCoefficient;

	/**
	 * NPS系数
	 */
	private BigDecimal npsCoefficient;

	/**
	 * 加权系数
	 */
	private BigDecimal weightingCoefficient;

	/**
	 * 月度经理管理奖金
	 */
	private BigDecimal monthlyManagerBonus;

	/**
	 * 月度经理油品达标奖金
	 */
	private BigDecimal monthlyManagerOilStandardBonus;

	/**
	 * 月度经理非油品达标奖金
	 */
	private BigDecimal monthlyManagerNonOilStandardBonus;

	/**
	 * 月度经理奖金合计
	 */
	private BigDecimal totalMonthlyManagerBonus;

	/**
	 * 月度销售油品奖金
	 */
	private BigDecimal monthlySaleOilBonus;

	/**
	 * 月度非油品销售奖金
	 */
	private BigDecimal monthlyNonSaleOilBonus;

	/**
	 * 本月油品奖金
	 */
	private BigDecimal currentMonthOilBonus;

	/**
	 * 本月非油品奖金
	 */
	private BigDecimal currentMonthNonOilBonus;

	/**
	 * 36000L以上保护措施
	 */
	private BigDecimal safeguardProcedures;

	/**
	 * 本月应发油品奖金
	 */
	private BigDecimal currentMonthPayableOilBonus;

	/**
	 * 油站会计对应油站类型数据源(左列)
	 */
	private String stationAccountantDataOne;

	/**
	 * 油站会计对应油站类型数据源(右列)
	 */
	private String stationAccountantDataTwo;

	/**
	 * 油站会计奖金基数
	 */
	private BigDecimal stationAccountantBaseBonus;

	/**
	 * 会计奖金油站类型
	 */
	private String accountantBonusStationType;

	/**
	 * 业绩挑战奖金
	 */
	private BigDecimal performanceChallengeBonus;

	/**
	 * 定编数+管理人员(核定住宿人数）
	 */
	private Integer stationStaffNumAndAdmin;

	/**
	 * 搭伙补贴
	 */
	private BigDecimal boarderSubsidies;

	/**
	 * 本月管理岗位人数
	 */
	private Integer managerialPositionPopulation;

	/**
	 * 实际人数
	 */
	private Integer managerialPositionRealPopulation;

	/**
	 * 本月管理岗位数量计算列(第一列)
	 */
	private String managerialPositionCountBaseOne;

	/**
	 * 本月管理岗位数量计算列(第二列)
	 */
	private String managerialPositionCountBaseTwo;

	/**
	 * 本月管理岗位数量计算列(第三列)
	 */
	private String managerialPositionCountBaseThree;

	/**
	 * 本月管理岗位数量计算列(第四列)
	 */
	private String managerialPositionCountBaseFour;

	/**
	 * 基础目标
	 */
	private BigDecimal baseTarget;

	/**
	 * 挑战目标
	 */
	private BigDecimal challengeTarget;

	/**
	 * 基础奖金
	 */
	private BigDecimal baseBonus;

	/**
	 * 挑战奖金
	 */
	private BigDecimal challengeBonus;

	/**
	 * 本月奖金
	 */
	private BigDecimal currentMonthBonus;

	/**
	 * 关联地区编号
	 */
	private String areaCode;

	/**
	 * 附加地区对象
	 */
	private Area area;

	/**
	 * 关联地区名称
	 */
	private String areaName;

	/**
	 * 关联员工编号
	 */
	private String staffCode;

	/**
	 * 附加员工对象
	 */
	private Staff staff;

	/**
	 * 关联员工姓名
	 */
	private String staffName;

	/**
	 * 关联员工身份证号
	 */
	private String staffIdcard;

	/**
	 * 关联员工入职日期
	 */
	private String staffInDate;

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
	 * 关联职务编号
	 */
	private String dutyCode;

	/**
	 * 关联职务名称
	 */
	private String dutyName;

	/**
	 * 附加职务对象
	 */
	private Duty duty;

	/**
	 * 关联区域编号
	 */
	private String districtCode;

	/**
	 * 关联区域名称
	 */
	private String districtName;

	/**
	 * 附加区域对象
	 */
	private District district;

	/**
	 * 伙食方式
	 */
	private String foodWay;

	/**
	 * (搭伙补贴)备注
	 */
	private String boarderSubsidiesRemark;
	/**
	 * 住宿补贴
	 */
	private BigDecimal accommodationSubsidy;

	private BigDecimal baseBonusAmt;// 基础奖金
	private BigDecimal challengeBonusAmt;// 挑战奖金
	private BigDecimal middleTarget;// 中间指标
	private BigDecimal middleBonusAmt;// 中间奖金
	private BigDecimal nonOilTotalAmt;// 非油品奖励
	private String planDay;// 计划天数

	private Long nonOilBaseTarget;
	private BigDecimal nonOilBaseBonusAmt;// 基础奖金
	private Long nonOilChallengeTarget;
	private BigDecimal nonOilChallengeBonusAmt;// 挑战奖金

	private String stationType;// 油站类型

	private String isOilStandardRateArtificial;

	private String isNonOilStandardRateArtificial;
	
	private String isAccommoSubsidyArti;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStationStaffNum() {
		return stationStaffNum;
	}

	public void setStationStaffNum(Integer stationStaffNum) {
		this.stationStaffNum = stationStaffNum;
	}

	public Integer getStationStaffNumFloat() {
		return stationStaffNumFloat;
	}

	public void setStationStaffNumFloat(Integer stationStaffNumFloat) {
		this.stationStaffNumFloat = stationStaffNumFloat;
	}

	public String getStationLevelCode() {
		return stationLevelCode;
	}

	public void setStationLevelCode(String stationLevelCode) {
		this.stationLevelCode = stationLevelCode == null ? null
				: stationLevelCode.trim();
	}

	public Double getMmp() {
		return mmp;
	}

	public void setMmp(Double mmp) {
		this.mmp = mmp;
	}

	public Double getNps() {
		return nps;
	}

	public void setNps(Double nps) {
		this.nps = nps;
	}

	public BigDecimal getOilTargetVolume() {
		return oilTargetVolume;
	}

	public void setOilTargetVolume(BigDecimal oilTargetVolume) {
		this.oilTargetVolume = oilTargetVolume;
	}

	public BigDecimal getOilRealVolume() {
		return oilRealVolume;
	}

	public void setOilRealVolume(BigDecimal oilRealVolume) {
		this.oilRealVolume = oilRealVolume;
	}

	public BigDecimal getOilDayAverageVolume() {
		return oilDayAverageVolume;
	}

	public void setOilDayAverageVolume(BigDecimal oilDayAverageVolume) {
		this.oilDayAverageVolume = oilDayAverageVolume;
	}

	public BigDecimal getNonOilTargetVolume() {
		return nonOilTargetVolume;
	}

	public void setNonOilTargetVolume(BigDecimal nonOilTargetVolume) {
		this.nonOilTargetVolume = nonOilTargetVolume;
	}

	public BigDecimal getNonOilRealVolume() {
		return nonOilRealVolume;
	}

	public void setNonOilRealVolume(BigDecimal nonOilRealVolume) {
		this.nonOilRealVolume = nonOilRealVolume;
	}

	public BigDecimal getNonOilDayAverageVolume() {
		return nonOilDayAverageVolume;
	}

	public void setNonOilDayAverageVolume(BigDecimal nonOilDayAverageVolume) {
		this.nonOilDayAverageVolume = nonOilDayAverageVolume;
	}

	public BigDecimal getStoreMarkScore() {
		return storeMarkScore;
	}

	public void setStoreMarkScore(BigDecimal storeMarkScore) {
		this.storeMarkScore = storeMarkScore;
	}

	public BigDecimal getStoreManageScore() {
		return storeManageScore;
	}

	public void setStoreManageScore(BigDecimal storeManageScore) {
		this.storeManageScore = storeManageScore;
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

	public BigDecimal getGasolineTargetVolume() {
		return gasolineTargetVolume;
	}

	public void setGasolineTargetVolume(BigDecimal gasolineTargetVolume) {
		this.gasolineTargetVolume = gasolineTargetVolume;
	}

	public BigDecimal getDieselTargetVolume() {
		return dieselTargetVolume;
	}

	public void setDieselTargetVolume(BigDecimal dieselTargetVolume) {
		this.dieselTargetVolume = dieselTargetVolume;
	}

	public BigDecimal getGasolineDayAverageVolume() {
		return gasolineDayAverageVolume;
	}

	public void setGasolineDayAverageVolume(BigDecimal gasolineDayAverageVolume) {
		this.gasolineDayAverageVolume = gasolineDayAverageVolume;
	}

	public BigDecimal getDieselDayAverageVolume() {
		return dieselDayAverageVolume;
	}

	public void setDieselDayAverageVolume(BigDecimal dieselDayAverageVolume) {
		this.dieselDayAverageVolume = dieselDayAverageVolume;
	}

	public String getIsKeepDormitory() {
		return isKeepDormitory;
	}

	public void setIsKeepDormitory(String isKeepDormitory) {
		this.isKeepDormitory = isKeepDormitory == null ? null : isKeepDormitory
				.trim();
	}

	public BigDecimal getDormitorySubsidies() {
		return dormitorySubsidies;
	}

	public void setDormitorySubsidies(BigDecimal dormitorySubsidies) {
		this.dormitorySubsidies = dormitorySubsidies;
	}

	public BigDecimal getMonthlyStoreAllowance() {
		return monthlyStoreAllowance;
	}

	public void setMonthlyStoreAllowance(BigDecimal monthlyStoreAllowance) {
		this.monthlyStoreAllowance = monthlyStoreAllowance;
	}

	public BigDecimal getOilStandardRate() {
		return oilStandardRate;
	}

	public void setOilStandardRate(BigDecimal oilStandardRate) {
		this.oilStandardRate = oilStandardRate;
	}

	public BigDecimal getNonOilStandardRate() {
		return nonOilStandardRate;
	}

	public void setNonOilStandardRate(BigDecimal nonOilStandardRate) {
		this.nonOilStandardRate = nonOilStandardRate;
	}

	public BigDecimal getDirectSellingBonus() {
		return directSellingBonus;
	}

	public void setDirectSellingBonus(BigDecimal directSellingBonus) {
		this.directSellingBonus = directSellingBonus;
	}

	public BigDecimal getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(BigDecimal upperLimit) {
		this.upperLimit = upperLimit;
	}

	public BigDecimal getMmpCoefficient() {
		return mmpCoefficient;
	}

	public void setMmpCoefficient(BigDecimal mmpCoefficient) {
		this.mmpCoefficient = mmpCoefficient;
	}

	public BigDecimal getNpsCoefficient() {
		return npsCoefficient;
	}

	public void setNpsCoefficient(BigDecimal npsCoefficient) {
		this.npsCoefficient = npsCoefficient;
	}

	public BigDecimal getWeightingCoefficient() {
		return weightingCoefficient;
	}

	public void setWeightingCoefficient(BigDecimal weightingCoefficient) {
		this.weightingCoefficient = weightingCoefficient;
	}

	public BigDecimal getMonthlyManagerBonus() {
		return monthlyManagerBonus;
	}

	public void setMonthlyManagerBonus(BigDecimal monthlyManagerBonus) {
		this.monthlyManagerBonus = monthlyManagerBonus;
	}

	public BigDecimal getMonthlyManagerOilStandardBonus() {
		return monthlyManagerOilStandardBonus;
	}

	public void setMonthlyManagerOilStandardBonus(
			BigDecimal monthlyManagerOilStandardBonus) {
		this.monthlyManagerOilStandardBonus = monthlyManagerOilStandardBonus;
	}

	public BigDecimal getMonthlyManagerNonOilStandardBonus() {
		return monthlyManagerNonOilStandardBonus;
	}

	public void setMonthlyManagerNonOilStandardBonus(
			BigDecimal monthlyManagerNonOilStandardBonus) {
		this.monthlyManagerNonOilStandardBonus = monthlyManagerNonOilStandardBonus;
	}

	public BigDecimal getTotalMonthlyManagerBonus() {
		return totalMonthlyManagerBonus;
	}

	public void setTotalMonthlyManagerBonus(BigDecimal totalMonthlyManagerBonus) {
		this.totalMonthlyManagerBonus = totalMonthlyManagerBonus;
	}

	public BigDecimal getMonthlySaleOilBonus() {
		return monthlySaleOilBonus;
	}

	public void setMonthlySaleOilBonus(BigDecimal monthlySaleOilBonus) {
		this.monthlySaleOilBonus = monthlySaleOilBonus;
	}

	public BigDecimal getMonthlyNonSaleOilBonus() {
		return monthlyNonSaleOilBonus;
	}

	public void setMonthlyNonSaleOilBonus(BigDecimal monthlyNonSaleOilBonus) {
		this.monthlyNonSaleOilBonus = monthlyNonSaleOilBonus;
	}

	public BigDecimal getCurrentMonthOilBonus() {
		return currentMonthOilBonus;
	}

	public void setCurrentMonthOilBonus(BigDecimal currentMonthOilBonus) {
		this.currentMonthOilBonus = currentMonthOilBonus;
	}

	public BigDecimal getCurrentMonthNonOilBonus() {
		return currentMonthNonOilBonus;
	}

	public void setCurrentMonthNonOilBonus(BigDecimal currentMonthNonOilBonus) {
		this.currentMonthNonOilBonus = currentMonthNonOilBonus;
	}

	public BigDecimal getSafeguardProcedures() {
		return safeguardProcedures;
	}

	public void setSafeguardProcedures(BigDecimal safeguardProcedures) {
		this.safeguardProcedures = safeguardProcedures;
	}

	public BigDecimal getCurrentMonthPayableOilBonus() {
		return currentMonthPayableOilBonus;
	}

	public void setCurrentMonthPayableOilBonus(
			BigDecimal currentMonthPayableOilBonus) {
		this.currentMonthPayableOilBonus = currentMonthPayableOilBonus;
	}

	public String getStationAccountantDataOne() {
		return stationAccountantDataOne;
	}

	public void setStationAccountantDataOne(String stationAccountantDataOne) {
		this.stationAccountantDataOne = stationAccountantDataOne == null ? null
				: stationAccountantDataOne.trim();
	}

	public String getStationAccountantDataTwo() {
		return stationAccountantDataTwo;
	}

	public void setStationAccountantDataTwo(String stationAccountantDataTwo) {
		this.stationAccountantDataTwo = stationAccountantDataTwo == null ? null
				: stationAccountantDataTwo.trim();
	}

	public BigDecimal getStationAccountantBaseBonus() {
		return stationAccountantBaseBonus;
	}

	public void setStationAccountantBaseBonus(
			BigDecimal stationAccountantBaseBonus) {
		this.stationAccountantBaseBonus = stationAccountantBaseBonus;
	}

	public String getAccountantBonusStationType() {
		return accountantBonusStationType;
	}

	public void setAccountantBonusStationType(String accountantBonusStationType) {
		this.accountantBonusStationType = accountantBonusStationType == null ? null
				: accountantBonusStationType.trim();
	}

	public BigDecimal getPerformanceChallengeBonus() {
		return performanceChallengeBonus;
	}

	public void setPerformanceChallengeBonus(
			BigDecimal performanceChallengeBonus) {
		this.performanceChallengeBonus = performanceChallengeBonus;
	}

	public Integer getStationStaffNumAndAdmin() {
		return stationStaffNumAndAdmin;
	}

	public void setStationStaffNumAndAdmin(Integer stationStaffNumAndAdmin) {
		this.stationStaffNumAndAdmin = stationStaffNumAndAdmin;
	}

	public BigDecimal getBoarderSubsidies() {
		return boarderSubsidies;
	}

	public void setBoarderSubsidies(BigDecimal boarderSubsidies) {
		this.boarderSubsidies = boarderSubsidies;
	}

	public Integer getManagerialPositionPopulation() {
		return managerialPositionPopulation;
	}

	public void setManagerialPositionPopulation(
			Integer managerialPositionPopulation) {
		this.managerialPositionPopulation = managerialPositionPopulation;
	}

	public Integer getManagerialPositionRealPopulation() {
		return managerialPositionRealPopulation;
	}

	public void setManagerialPositionRealPopulation(
			Integer managerialPositionRealPopulation) {
		this.managerialPositionRealPopulation = managerialPositionRealPopulation;
	}

	public String getManagerialPositionCountBaseOne() {
		return managerialPositionCountBaseOne;
	}

	public void setManagerialPositionCountBaseOne(
			String managerialPositionCountBaseOne) {
		this.managerialPositionCountBaseOne = managerialPositionCountBaseOne == null ? null
				: managerialPositionCountBaseOne.trim();
	}

	public String getManagerialPositionCountBaseTwo() {
		return managerialPositionCountBaseTwo;
	}

	public void setManagerialPositionCountBaseTwo(
			String managerialPositionCountBaseTwo) {
		this.managerialPositionCountBaseTwo = managerialPositionCountBaseTwo == null ? null
				: managerialPositionCountBaseTwo.trim();
	}

	public String getManagerialPositionCountBaseThree() {
		return managerialPositionCountBaseThree;
	}

	public void setManagerialPositionCountBaseThree(
			String managerialPositionCountBaseThree) {
		this.managerialPositionCountBaseThree = managerialPositionCountBaseThree == null ? null
				: managerialPositionCountBaseThree.trim();
	}

	public String getManagerialPositionCountBaseFour() {
		return managerialPositionCountBaseFour;
	}

	public void setManagerialPositionCountBaseFour(
			String managerialPositionCountBaseFour) {
		this.managerialPositionCountBaseFour = managerialPositionCountBaseFour == null ? null
				: managerialPositionCountBaseFour.trim();
	}

	public BigDecimal getBaseTarget() {
		return baseTarget;
	}

	public void setBaseTarget(BigDecimal baseTarget) {
		this.baseTarget = baseTarget;
	}

	public BigDecimal getChallengeTarget() {
		return challengeTarget;
	}

	public void setChallengeTarget(BigDecimal challengeTarget) {
		this.challengeTarget = challengeTarget;
	}

	public BigDecimal getBaseBonus() {
		return baseBonus;
	}

	public void setBaseBonus(BigDecimal baseBonus) {
		this.baseBonus = baseBonus;
	}

	public BigDecimal getChallengeBonus() {
		return challengeBonus;
	}

	public void setChallengeBonus(BigDecimal challengeBonus) {
		this.challengeBonus = challengeBonus;
	}

	public BigDecimal getCurrentMonthBonus() {
		return currentMonthBonus;
	}

	public void setCurrentMonthBonus(BigDecimal currentMonthBonus) {
		this.currentMonthBonus = currentMonthBonus;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode == null ? null : stationCode.trim();
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode == null ? null : areaCode.trim();
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode == null ? null : staffCode.trim();
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode == null ? null : dutyCode.trim();
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode == null ? null : districtCode.trim();
	}

	public String getFoodWay() {
		return foodWay;
	}

	public void setFoodWay(String foodWay) {
		this.foodWay = foodWay == null ? null : foodWay.trim();
	}

	public String getBoarderSubsidiesRemark() {
		return boarderSubsidiesRemark;
	}

	public void setBoarderSubsidiesRemark(String boarderSubsidiesRemark) {
		this.boarderSubsidiesRemark = boarderSubsidiesRemark == null ? null
				: boarderSubsidiesRemark.trim();
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

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

	public StationLevel getStationLevel() {
		return stationLevel;
	}

	public void setStationLevel(StationLevel stationLevel) {
		this.stationLevel = stationLevel;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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

	public String getStaffInDate() {
		return staffInDate;
	}

	public void setStaffInDate(String staffInDate) {
		this.staffInDate = staffInDate;
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

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public BigDecimal getBaseBonusAmt() {
		return baseBonusAmt;
	}

	public void setBaseBonusAmt(BigDecimal baseBonusAmt) {
		this.baseBonusAmt = baseBonusAmt;
	}

	public BigDecimal getChallengeBonusAmt() {
		return challengeBonusAmt;
	}

	public void setChallengeBonusAmt(BigDecimal challengeBonusAmt) {
		this.challengeBonusAmt = challengeBonusAmt;
	}

	public BigDecimal getMiddleTarget() {
		return middleTarget;
	}

	public void setMiddleTarget(BigDecimal middleTarget) {
		this.middleTarget = middleTarget;
	}

	public BigDecimal getMiddleBonusAmt() {
		return middleBonusAmt;
	}

	public void setMiddleBonusAmt(BigDecimal middleBonusAmt) {
		this.middleBonusAmt = middleBonusAmt;
	}

	public BigDecimal getNonOilTotalAmt() {
		return nonOilTotalAmt;
	}

	public void setNonOilTotalAmt(BigDecimal nonOilTotalAmt) {
		this.nonOilTotalAmt = nonOilTotalAmt;
	}

	public String getPlanDay() {
		return planDay;
	}

	public void setPlanDay(String planDay) {
		this.planDay = planDay;
	}

	public BigDecimal getNonOilBaseBonusAmt() {
		return nonOilBaseBonusAmt;
	}

	public void setNonOilBaseBonusAmt(BigDecimal nonOilBaseBonusAmt) {
		this.nonOilBaseBonusAmt = nonOilBaseBonusAmt;
	}

	public BigDecimal getNonOilChallengeBonusAmt() {
		return nonOilChallengeBonusAmt;
	}

	public void setNonOilChallengeBonusAmt(BigDecimal nonOilChallengeBonusAmt) {
		this.nonOilChallengeBonusAmt = nonOilChallengeBonusAmt;
	}

	public Long getNonOilBaseTarget() {
		return nonOilBaseTarget;
	}

	public void setNonOilBaseTarget(Long nonOilBaseTarget) {
		this.nonOilBaseTarget = nonOilBaseTarget;
	}

	public Long getNonOilChallengeTarget() {
		return nonOilChallengeTarget;
	}

	public void setNonOilChallengeTarget(Long nonOilChallengeTarget) {
		this.nonOilChallengeTarget = nonOilChallengeTarget;
	}

	public String getIsOilStandardRateArtificial() {
		return isOilStandardRateArtificial;
	}

	public void setIsOilStandardRateArtificial(
			String isOilStandardRateArtificial) {
		this.isOilStandardRateArtificial = isOilStandardRateArtificial;
	}

	public String getIsNonOilStandardRateArtificial() {
		return isNonOilStandardRateArtificial;
	}

	public void setIsNonOilStandardRateArtificial(
			String isNonOilStandardRateArtificial) {
		this.isNonOilStandardRateArtificial = isNonOilStandardRateArtificial;
	}

	public BigDecimal getAccommodationSubsidy() {
		return accommodationSubsidy;
	}

	public void setAccommodationSubsidy(BigDecimal accommodationSubsidy) {
		this.accommodationSubsidy = accommodationSubsidy;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getIsAccommoSubsidyArti() {
		return isAccommoSubsidyArti;
	}

	public void setIsAccommoSubsidyArti(String isAccommoSubsidyArti) {
		this.isAccommoSubsidyArti = isAccommoSubsidyArti;
	}

}