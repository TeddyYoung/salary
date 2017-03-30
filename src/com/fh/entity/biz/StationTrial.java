package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

public class StationTrial implements Serializable {
	
	/**
	 * 主键id(自增长)
	 */
    private Long id;

    /**
     * 薪资试算编号
     */
    private String stationTrialCode;

    /**
     * 关联油站编号
     */
    private String stationCode;

    /**
     * 关联油站名称
     */
    private String stationName;
    
    /**
     * 附加油站对象
     */
    private Station station;
    
    /**
     * 关联地区编号
     */
    private String areaCode;

    /**
     * 关联地区名称
     */
    private String areaName;
    
    /**
     * 附加地区对象
     */
    private Area area;
    
    /**
     * 是否已薪资试算(0-未试算; 1-已试算)
     */
    private String isTrial;

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

    private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStationTrialCode() {
		return stationTrialCode;
	}

	public void setStationTrialCode(String stationTrialCode) {
		this.stationTrialCode = stationTrialCode;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getIsTrial() {
		return isTrial;
	}

	public void setIsTrial(String isTrial) {
		this.isTrial = isTrial;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
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

	public String toString() {
		return "StationTrial [id=" + id + ", stationTrialCode="
				+ stationTrialCode + ", stationCode=" + stationCode
				+ ", stationName=" + stationName + ", station=" + station
				+ ", areaCode=" + areaCode + ", areaName=" + areaName
				+ ", area=" + area + ", isTrial=" + isTrial + ", yearMonth="
				+ yearMonth + ", sysCreateTime=" + sysCreateTime
				+ ", sysUpdateTime=" + sysUpdateTime + ", remark=" + remark
				+ "]";
	}

}