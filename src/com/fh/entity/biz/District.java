package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域实体类
 * @author lijn
 *
 */
public class District implements Serializable {
	
	/**
	 * 主键ID(自增长)
	 */
    private Long id;

    /**
     * 区域编号
     */
    private String districtCode;

    /**
     * 区域名称
     */
    private String districtName;

    /**
     * 区域级别
     */
    private String districtLevel;

    /**
     * 上级区域编号
     */
    private String fatherDistrictCode;

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

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public String getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(String districtLevel) {
        this.districtLevel = districtLevel == null ? null : districtLevel.trim();
    }

    public String getFatherDistrictCode() {
        return fatherDistrictCode;
    }

    public void setFatherDistrictCode(String fatherDistrictCode) {
        this.fatherDistrictCode = fatherDistrictCode == null ? null : fatherDistrictCode.trim();
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", districtCode=").append(districtCode);
        sb.append(", districtName=").append(districtName);
        sb.append(", districtLevel=").append(districtLevel);
        sb.append(", fatherDistrictCode=").append(fatherDistrictCode);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}