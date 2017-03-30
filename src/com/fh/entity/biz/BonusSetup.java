package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 奖金设置
 * @author lijn
 *
 */
public class BonusSetup implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 起始销量（升）
     */
    private BigDecimal startVolume;

    /**
     * 封顶销量（升）
     */
    private BigDecimal endVolume;

    /**
     * 奖金基数
     */
    private BigDecimal bonusAmt;

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

    public BigDecimal getStartVolume() {
        return startVolume;
    }

    public void setStartVolume(BigDecimal startVolume) {
        this.startVolume = startVolume;
    }

    public BigDecimal getEndVolume() {
        return endVolume;
    }

    public void setEndVolume(BigDecimal endVolume) {
        this.endVolume = endVolume;
    }

    public BigDecimal getBonusAmt() {
        return bonusAmt;
    }

    public void setBonusAmt(BigDecimal bonusAmt) {
        this.bonusAmt = bonusAmt;
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
        sb.append(", startVolume=").append(startVolume);
        sb.append(", endVolume=").append(endVolume);
        sb.append(", bonusAmt=").append(bonusAmt);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}