package fhmssql.entity;

import java.math.BigDecimal;

/**
 * 销售测试实体类
 * @author lijn
 *
 */
public class SellData {
	/**
	 * 油站编号
	 */
	private String sid;
	/**
	 * 油品本月实际销量
	 */
	private BigDecimal oils;
	/**
	 * 油品日均销量
	 */
	private BigDecimal oild;
	/**
	 * 油品达标率
	 */
	private BigDecimal oilrate;
	/**
	 * 非油品本月实际销量
	 */
	private BigDecimal noils;
	/**
	 * 非油品日均销量
	 */
	private BigDecimal noild;
	/**
	 * 非油品达标率
	 */
	private BigDecimal noilrate;
	/**
	 * 
	 */
	private String yearMonth;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public BigDecimal getOils() {
		return oils;
	}
	public void setOils(BigDecimal oils) {
		this.oils = oils;
	}
	public BigDecimal getOild() {
		return oild;
	}
	public void setOild(BigDecimal oild) {
		this.oild = oild;
	}
	public BigDecimal getOilrate() {
		return oilrate;
	}
	public void setOilrate(BigDecimal oilrate) {
		this.oilrate = oilrate;
	}
	public BigDecimal getNoils() {
		return noils;
	}
	public void setNoils(BigDecimal noils) {
		this.noils = noils;
	}
	public BigDecimal getNoild() {
		return noild;
	}
	public void setNoild(BigDecimal noild) {
		this.noild = noild;
	}
	public BigDecimal getNoilrate() {
		return noilrate;
	}
	public void setNoilrate(BigDecimal noilrate) {
		this.noilrate = noilrate;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	
}
