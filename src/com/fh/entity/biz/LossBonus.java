package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 油品损耗奖金实体类
 * @author zhoujj
 */
public class LossBonus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;// 主键ID(自增长)
    private String yearMonth;// 年份月份
    private String staffCode;// 员工编号
    private String staffName;// 员工姓名
    private BigDecimal LossBonusAmt;// 油品损耗奖金
    private BigDecimal otherBonusAmt;// 其他奖金
    private String stationCode;// 员工姓名
    private Date sysCreateDate;// 创建时间
    private Date sysUpdateDate;// 更新时间
    private String remark;// 备注
    private String type;// 类型：
    /**
     * 油耗奖金
     */
    public static final String TYPE_LOSS = "0";
    /**
     * 库提奖金
     */
    public static final String TYPE_DEDUCT = "1";
    /**
     * 其他奖金
     */
    public static final String TYPE_OTHERS = "2";
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public BigDecimal getLossBonusAmt() {
		return LossBonusAmt;
	}
	public void setLossBonusAmt(BigDecimal lossBonusAmt) {
		LossBonusAmt = lossBonusAmt;
	}
	public BigDecimal getOtherBonusAmt() {
		return otherBonusAmt;
	}
	public void setOtherBonusAmt(BigDecimal otherBonusAmt) {
		this.otherBonusAmt = otherBonusAmt;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public Date getSysCreateDate() {
		return sysCreateDate;
	}
	public void setSysCreateDate(Date sysCreateDate) {
		this.sysCreateDate = sysCreateDate;
	}
	public Date getSysUpdateDate() {
		return sysUpdateDate;
	}
	public void setSysUpdateDate(Date sysUpdateDate) {
		this.sysUpdateDate = sysUpdateDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}