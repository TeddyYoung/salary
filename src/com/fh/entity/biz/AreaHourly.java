package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 时新设置  实体类
 * @author lijn
 *
 */
public class AreaHourly implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 所属地区编号
     */
    private String areaCode;

    /**
     * 所属职务编号
     */
    private String dutyCode;

    /**
     * 正常时薪
     */
    private BigDecimal normalHourly;

    /**
     * 加班时薪
     */
    private BigDecimal otHourly;

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

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode == null ? null : dutyCode.trim();
    }

    public BigDecimal getNormalHourly() {
        return normalHourly;
    }

    public void setNormalHourly(BigDecimal normalHourly) {
        this.normalHourly = normalHourly;
    }

    public BigDecimal getOtHourly() {
        return otHourly;
    }

    public void setOtHourly(BigDecimal otHourly) {
        this.otHourly = otHourly;
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
        sb.append(", areaCode=").append(areaCode);
        sb.append(", dutyCode=").append(dutyCode);
        sb.append(", normalHourly=").append(normalHourly);
        sb.append(", otHourly=").append(otHourly);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}