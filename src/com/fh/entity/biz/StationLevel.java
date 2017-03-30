package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 油站星级实体类
 * @author lijn
 *
 */
public class StationLevel implements Serializable {
	
	/**
	 * 主键ID(自增长)
	 */
    private Long id;

    /**
     * 星级编号
     */
    private String stationLevelCode;

    /**
     * 星级名称
     */
    private String stationLevelName;
    
    /**
     * 经理奖金
     */
    private BigDecimal managerBonusAmt;

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

    public String getStationLevelCode() {
        return stationLevelCode;
    }

    public void setStationLevelCode(String stationLevelCode) {
        this.stationLevelCode = stationLevelCode == null ? null : stationLevelCode.trim();
    }

    public String getStationLevelName() {
        return stationLevelName;
    }

    public void setStationLevelName(String stationLevelName) {
        this.stationLevelName = stationLevelName == null ? null : stationLevelName.trim();
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
    
    public BigDecimal getManagerBonusAmt() {
		return managerBonusAmt;
	}

	public void setManagerBonusAmt(BigDecimal managerBonusAmt) {
		this.managerBonusAmt = managerBonusAmt;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stationLevelCode=").append(stationLevelCode);
        sb.append(", stationLevelName=").append(stationLevelName);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}