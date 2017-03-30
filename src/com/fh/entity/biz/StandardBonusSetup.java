package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StandardBonusSetup implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 起始达标率（%）
     */
    private BigDecimal startRate;
    /**
     * 封顶达标率（%）
     */
    private BigDecimal endRate;
    /**
     * 奖金基数
     */
    private BigDecimal bonusAmt;
    /**
     * 奖金系数
     */
    private BigDecimal bonusCoefficient;
    /**
     * 奖金类型
     */
    private String standardBonusType;
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

    public BigDecimal getStartRate() {
        return startRate;
    }

    public void setStartRate(BigDecimal startRate) {
        this.startRate = startRate;
    }

    public BigDecimal getEndRate() {
        return endRate;
    }

    public void setEndRate(BigDecimal endRate) {
        this.endRate = endRate;
    }

    public BigDecimal getBonusAmt() {
        return bonusAmt;
    }

    public void setBonusAmt(BigDecimal bonusAmt) {
        this.bonusAmt = bonusAmt;
    }

    public BigDecimal getBonusCoefficient() {
        return bonusCoefficient;
    }

    public void setBonusCoefficient(BigDecimal bonusCoefficient) {
        this.bonusCoefficient = bonusCoefficient;
    }

    public String getStandardBonusType() {
        return standardBonusType;
    }

    public void setStandardBonusType(String standardBonusType) {
        this.standardBonusType = standardBonusType == null ? null : standardBonusType.trim();
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
        sb.append(", startRate=").append(startRate);
        sb.append(", endRate=").append(endRate);
        sb.append(", bonusAmt=").append(bonusAmt);
        sb.append(", bonusCoefficient=").append(bonusCoefficient);
        sb.append(", standardBonusType=").append(standardBonusType);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}