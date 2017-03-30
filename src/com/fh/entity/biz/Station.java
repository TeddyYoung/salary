package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

import com.fh.entity.system.DataDictionary;

public class Station implements Serializable {
	
	/**
	 * 主键ID(自增长)
	 */
    private Long id;

    /**
     * (系统生成)
     */
    private String stationCode;

    /**
     * 油站名称
     */
    private String stationName;

    /**
     * 定编人数
     */
    private Integer stationStaffNum;

    /**
     * 浮动编制
     */
    private Integer stationStaffNumFloat;

    /**
     * 油站状态(1-弃用, 2-可用)
     */
    private String stationStatus;
    
    /**
     * 油站类型
     */
    private String stationType;
    /**
     * 油站性质 0:自营  1：加盟 2：双品牌  3：合资
     */
    private String stationNature;

    /**
     * 油站类型名称
     */
    private String stationTypeName;
    
    /**
     * 所属星级编号
     */
    private String stationLevelCode;

    /**
     * 所属区域编号
     */
    private String districtCode;

    /**
     * 所属地区编号
     */
    private String areaCode;

    /**
     * 创建日期
     */
    private Date sysCreateTime;

    /**
     * 更新日期
     */
    private Date sysUpdateTime;

    /**
     * 备注
     */
    private String remark;
    
    /**
     * 拓展属性 数据字典
     */
    private DataDictionary dataDictionary;
    
    /**
     * 拓展属性 地区
     */
    private Area area;
    
    /**
     * 拓展属性 区域
     */
    private District district;
    
    /**
     * 关联油站星级
     */
    private StationLevel stationLevel;
    
    public static final String STATION_NATURE_AUTOTROPHY = "0";
    /**
     * 油站性质-加盟
     */
    public static final String STATION_NATURE_LEAGUE = "1";

    private static final long serialVersionUID = 1L;

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
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
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

    public String getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(String stationStatus) {
        this.stationStatus = stationStatus == null ? null : stationStatus.trim();
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType == null ? null : stationType.trim();
    }

    public String getStationLevelCode() {
        return stationLevelCode;
    }

    public void setStationLevelCode(String stationLevelCode) {
        this.stationLevelCode = stationLevelCode == null ? null : stationLevelCode.trim();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
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

    public DataDictionary getDataDictionary() {
		return dataDictionary;
	}

	public void setDataDictionary(DataDictionary dataDictionary) {
		this.dataDictionary = dataDictionary;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public StationLevel getStationLevel() {
		return stationLevel;
	}

	public void setStationLevel(StationLevel stationLevel) {
		this.stationLevel = stationLevel;
	}

	public String getStationTypeName() {
		return stationTypeName;
	}

	public void setStationTypeName(String stationTypeName) {
		this.stationTypeName = stationTypeName;
	}

	public String getStationNature() {
		return stationNature;
	}

	public void setStationNature(String stationNature) {
		this.stationNature = stationNature;
	}


}