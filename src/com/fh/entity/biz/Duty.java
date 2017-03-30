package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

/**
 * 职务实体类
 * @author lijn
 *
 */
public class Duty implements Serializable {
	
	/**
	 * 主键ID(自增长)
	 */
    private Long id;

    /**
     * 职务编号
     */
    private String dutyCode;

    /**
     * 职务名称
     */
    private String dutyName;
    
    /**
     * 职务排序
     */
    private Integer sort;

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
    
    /**
     * 职务类型 0-普通岗位；1-管理岗位
     */
    private String dutyType;
    
    private String dutyNature;

    private static final long serialVersionUID = 1L;
    
    public static final String DUTY_NATURE_OFFICIAL = "1";
    
    public static final String DUTY_NATURE_PART_TIME = "2";
    
    public static final String DUTY_NATURE_NOVICIATE = "3";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode == null ? null : dutyCode.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getDutyType() {
		return dutyType;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Duty [id=" + id + ", dutyCode=" + dutyCode + ", dutyName="
				+ dutyName + ", sysCreateTime=" + sysCreateTime
				+ ", sysUpdateTime=" + sysUpdateTime + ", remark=" + remark
				+ ", dutyType=" + dutyType + "]";
	}

	public String getDutyNature() {
		return dutyNature;
	}

	public void setDutyNature(String dutyNature) {
		this.dutyNature = dutyNature;
	}

}