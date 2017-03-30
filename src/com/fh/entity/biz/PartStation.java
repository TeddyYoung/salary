package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 兼站金额 实体类
 * @author Teddy
 */
public class PartStation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;// 主键ID(自增长)

    private String staffCode;// 员工编号

    private String staffName;// 员工姓名
    
    private String stationCode;// 所属油站编号
    
    private String dutyCode;// 所属职务编号

    private BigDecimal baseAmt;// 兼站金额
    
    private Date sysCreateTime;// 创建时间

    private Date sysUpdateTime;// 更新时间

    private String remark;// 备注

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public BigDecimal getBaseAmt() {
		return baseAmt;
	}

	public void setBaseAmt(BigDecimal baseAmt) {
		this.baseAmt = baseAmt;
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

}