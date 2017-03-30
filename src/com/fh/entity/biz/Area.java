package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 地区实体类
 * @author lijn
 *
 */
public class Area implements Serializable {
	
	/**
	 * 主键ID(自增长)
	 */
    private Long id;

    /**
     * 地区编号
     */
    private String areaCode;

    /**
     * 地区名称
     */
    private String areaName;

    /**
     * 用餐补贴
     */
    private BigDecimal areaMealSupplement;

    /**
     * 住宿补贴
     */
    private BigDecimal areaHouseSupplement;
    
    /**
     * 地区级别
     */
    private String areaLevel;

    /**
     * 上级地区编号
     */
    private String fatherAreaCode;

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public BigDecimal getAreaMealSupplement() {
		return areaMealSupplement;
	}

	public void setAreaMealSupplement(BigDecimal areaMealSupplement) {
		this.areaMealSupplement = areaMealSupplement;
	}

	public BigDecimal getAreaHouseSupplement() {
		return areaHouseSupplement;
	}

	public void setAreaHouseSupplement(BigDecimal areaHouseSupplement) {
		this.areaHouseSupplement = areaHouseSupplement;
	}

	public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel == null ? null : areaLevel.trim();
    }

    public String getFatherAreaCode() {
        return fatherAreaCode;
    }

    public void setFatherAreaCode(String fatherAreaCode) {
        this.fatherAreaCode = fatherAreaCode == null ? null : fatherAreaCode.trim();
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

	@Override
	public String toString() {
		return "Area [id=" + id + ", areaCode=" + areaCode + ", areaName="
				+ areaName + ", areaMealSupplement=" + areaMealSupplement
				+ ", areaHouseSupplement=" + areaHouseSupplement
				+ ", areaLevel=" + areaLevel + ", fatherAreaCode="
				+ fatherAreaCode + ", sysCreateTime=" + sysCreateTime
				+ ", sysUpdateTime=" + sysUpdateTime + ", remark=" + remark
				+ "]";
	}

}