package com.fh.entity.system;

import java.io.Serializable;
import java.util.Date;

public class Seq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
    private Integer id;
    private String seqKey;
    private String seqKeyBegin;
    private String seqKeyEnd;
    private Integer seqCount;
    private Integer seqNo;
    private String seqName;
    private Date sysCreateTime;
    private Date sysUpdateTime;
    private String remark;
    
    public static final String SEQ_KEY_JMZ = "JMZ";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeqKey() {
		return seqKey;
	}

	public void setSeqKey(String seqKey) {
		this.seqKey = seqKey;
	}

	public String getSeqKeyBegin() {
		return seqKeyBegin;
	}

	public void setSeqKeyBegin(String seqKeyBegin) {
		this.seqKeyBegin = seqKeyBegin;
	}

	public String getSeqKeyEnd() {
		return seqKeyEnd;
	}

	public void setSeqKeyEnd(String seqKeyEnd) {
		this.seqKeyEnd = seqKeyEnd;
	}

	public Integer getSeqCount() {
		return seqCount;
	}

	public void setSeqCount(Integer seqCount) {
		this.seqCount = seqCount;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
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

	public Date getSysCreateTime() {
		return sysCreateTime;
	}

	public void setSysCreateTime(Date sysCreateTime) {
		this.sysCreateTime = sysCreateTime;
	}

}