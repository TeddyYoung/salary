package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 过节费实体类
 * @author Teddy
 */
public class Holiday implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;// 主键ID(自增长)
    private String yearMonth;// 年份月份
    private String holidayName;// 过节费名称
    private BigDecimal holidayMoney;// 住宿补贴
    private Date sysCreateTime;// 创建时间
    private Date sysUpdateTime;// 更新时间
    private String remark;// 备注
    private String type;// 类型： 0-过节费；1-补贴
    
    public static final String  TYPE_HOLIDAY = "0";
    
    public static final String  TYPE_FAMILY_REUNION_DINNER = "1";
    
    public static final String  TYPE_CHINESE_NEW_YEAR = "2";
    
    public static final String  TYPE_HIGH_TEMPERATURE = "3";
    
    public static final String  TYPE_NIGHT_SHIFT = "4";

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

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public BigDecimal getHolidayMoney() {
		return holidayMoney;
	}

	public void setHolidayMoney(BigDecimal holidayMoney) {
		this.holidayMoney = holidayMoney;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}