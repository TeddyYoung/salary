package com.fh.entity.system;

import java.io.Serializable;

/**
 * 用户部门角色表
 * @author MacBook
 *
 */
public class UserStorePart implements Serializable {
	
	/**
	 * 序号
	 */
    private Integer id;
    
    /**
     * 用户编号
     */
    private String userid;
    
    /**
     * 所属部门编号
     */
    private String storeid;
    
    /**
     * 角色编号
     */
    private String storePart;
    
    /**
     * 状态
     */
    private String diff;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid == null ? null : storeid.trim();
    }

    public String getStorePart() {
        return storePart;
    }

    public void setStorePart(String storePart) {
        this.storePart = storePart == null ? null : storePart.trim();
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff == null ? null : diff.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", storeid=").append(storeid);
        sb.append(", storePart=").append(storePart);
        sb.append(", diff=").append(diff);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}