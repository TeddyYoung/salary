package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位工资配置表实体类
 * 
 * @author Teddy
 */
public class DutySalary implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;// 主键ID(自增长)

	private String dutyCode;// 职务编号

	private String areaCode;// 所属地区类型编号

	private String salaryAmt;// 岗位工资

	private Date sysCreateTime;// 创建时间

	private Date sysUpdateTime;// 更新时间

	private String remark;// 备注
	
	private String jobLevel;

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

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
		this.dutyCode = dutyCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getSalaryAmt() {
		return salaryAmt;
	}

	public void setSalaryAmt(String salaryAmt) {
		this.salaryAmt = salaryAmt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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