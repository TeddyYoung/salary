package com.fh.entity.biz;

import java.io.Serializable;
import java.util.Date;

public class SalaryUpload implements Serializable {
	
	/**
	 * 主键id
	 */
    private Long id;

    /**
     * 薪资上传编号
     */
    private String salaryUploadCode;

    /**
     * 薪资是否上传(0-未上传; 1-已上传)
     */
    private String isUpload;
    
    /**
     * 薪资表上传URL
     */
    private String uploadUrl;

    /**
     * 年份月份
     */
    private String yearMonth;

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

    public String getSalaryUploadCode() {
        return salaryUploadCode;
    }

    public void setSalaryUploadCode(String salaryUploadCode) {
        this.salaryUploadCode = salaryUploadCode == null ? null : salaryUploadCode.trim();
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload == null ? null : isUpload.trim();
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl == null ? null : uploadUrl.trim();
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth == null ? null : yearMonth.trim();
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

	public String toString() {
		return "SalaryUpload [id=" + id + ", salaryUploadCode="
				+ salaryUploadCode + ", isUpload=" + isUpload + ", uploadUrl="
				+ uploadUrl + ", yearMonth=" + yearMonth + ", sysCreateTime="
				+ sysCreateTime + ", sysUpdateTime=" + sysUpdateTime
				+ ", remark=" + remark + "]";
	}

}