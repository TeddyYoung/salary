package com.fh.entity.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IndexConfig implements Serializable {
	
	/**
	 * 主键id
	 */
    private Long id;

    /**
     * 系数编号
     */
    private String indexCode;

    /**
     * 系数名称
     */
    private String indexName;

    /**
     * 系数值
     */
    private BigDecimal indexValue;

    /**
     * 系数序号
     */
    private String indexOrder;

    /**
     * 系数类别(spoilage-损耗系数; MMP-MMP系数; NPS-NPS系数)
     */
    private String indexType;

    /**
     * 系数类别名称
     */
    private String indexTypeName;
    
    /**
     * 最小值(用来和标识一起匹配数据)
     */
    private String indexStandard2;

    /**
     * 标值
     */
    private String indexStandard;

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

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode == null ? null : indexCode.trim();
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public BigDecimal getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(BigDecimal indexValue) {
        this.indexValue = indexValue;
    }

    public String getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(String indexOrder) {
        this.indexOrder = indexOrder == null ? null : indexOrder.trim();
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType == null ? null : indexType.trim();
    }

    public String getIndexTypeName() {
        return indexTypeName;
    }

    public void setIndexTypeName(String indexTypeName) {
        this.indexTypeName = indexTypeName == null ? null : indexTypeName.trim();
    }

    public String getIndexStandard2() {
        return indexStandard2;
    }

    public void setIndexStandard2(String indexStandard2) {
        this.indexStandard2 = indexStandard2 == null ? null : indexStandard2.trim();
    }

    public String getIndexStandard() {
        return indexStandard;
    }

    public void setIndexStandard(String indexStandard) {
        this.indexStandard = indexStandard == null ? null : indexStandard.trim();
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
		return "IndexConfig [id=" + id + ", indexCode=" + indexCode
				+ ", indexName=" + indexName + ", indexValue=" + indexValue
				+ ", indexOrder=" + indexOrder + ", indexType=" + indexType
				+ ", indexTypeName=" + indexTypeName + ", indexStandard2="
				+ indexStandard2 + ", indexStandard=" + indexStandard
				+ ", sysCreateTime=" + sysCreateTime + ", sysUpdateTime="
				+ sysUpdateTime + ", remark=" + remark + "]";
	}
    
}