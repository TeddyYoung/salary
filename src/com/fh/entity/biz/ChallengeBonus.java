package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理挑战奖配置 实体类
 * @author Teddy
 */
public class ChallengeBonus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;// 主键ID(自增长)
    private String yearMonth;// 年份月份
    private Long planDay;// 计划天数
    private String stationCode;// 油站编号
    private Long baseTarget;// 基础目标
    private BigDecimal baseBonusAmt;// 基础奖金
    private Long middleTarget;// 中间指标
    private BigDecimal middleBonusAmt;// 中间奖励
    private Long challengeTarget;// 挑战目标
    private BigDecimal challengeBonusAmt;// 挑战奖金
    private BigDecimal nonOilTotalAmt;// 非油品总额
    
    public static final String TYPE_NONOIL = "0";
    
    public static final String TYPE_OILS = "1";
    
	private Date sysCreateTime;// 创建时间
    private Date sysUpdateTime;// 更新时间
    private String remark;// 备注
    
    private String type;
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public Long getBaseTarget() {
		return baseTarget;
	}

	public void setBaseTarget(Long baseTarget) {
		this.baseTarget = baseTarget;
	}

	public BigDecimal getBaseBonusAmt() {
		return baseBonusAmt;
	}

	public void setBaseBonusAmt(BigDecimal baseBonusAmt) {
		this.baseBonusAmt = baseBonusAmt;
	}

	public Long getChallengeTarget() {
		return challengeTarget;
	}

	public void setChallengeTarget(Long challengeTarget) {
		this.challengeTarget = challengeTarget;
	}

	public BigDecimal getChallengeBonusAmt() {
		return challengeBonusAmt;
	}

	public void setChallengeBonusAmt(BigDecimal challengeBonusAmt) {
		this.challengeBonusAmt = challengeBonusAmt;
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

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Long getPlanDay() {
		return planDay;
	}

	public void setPlanDay(Long planDay) {
		this.planDay = planDay;
	}

	public Long getMiddleTarget() {
		return middleTarget;
	}

	public void setMiddleTarget(Long middleTarget) {
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

}