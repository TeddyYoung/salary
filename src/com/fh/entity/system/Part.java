package com.fh.entity.system;

import java.io.Serializable;

/**
 * 职位表
 * @author MacBook
 *
 */
public class Part implements Serializable {
	
	/**
	 * 职位编号
	 */
    private String partid;
    
    /**
     * 职位名称
     */
    private String partname;
    
    /**
     * 职位描述
     */
    private String desctiption;
    
    /**
     * 排序
     */
    private String orderbyId;
    
    /**
     * 上级职位编号
     */
    private String pPartid;

    private static final long serialVersionUID = 1L;

    public String getPartid() {
        return partid;
    }

    public void setPartid(String partid) {
        this.partid = partid == null ? null : partid.trim();
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname == null ? null : partname.trim();
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption == null ? null : desctiption.trim();
    }

    public String getOrderbyId() {
        return orderbyId;
    }

    public void setOrderbyId(String orderbyId) {
        this.orderbyId = orderbyId == null ? null : orderbyId.trim();
    }

    public String getpPartid() {
        return pPartid;
    }

    public void setpPartid(String pPartid) {
        this.pPartid = pPartid == null ? null : pPartid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", partid=").append(partid);
        sb.append(", partname=").append(partname);
        sb.append(", desctiption=").append(desctiption);
        sb.append(", orderbyId=").append(orderbyId);
        sb.append(", pPartid=").append(pPartid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}