package com.fh.entity.system;

import java.io.Serializable;

/**
 * 角色权限表
 * @author MacBook
 *
 */
public class PagePerm implements Serializable {
	
	/**
	 * 序号
	 */
    private Integer id;
    
    /**
     * 角色编号
     */
    private String storePart;

    /**
     * 菜单编号
     */
    private String pageid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorePart() {
        return storePart;
    }

    public void setStorePart(String storePart) {
        this.storePart = storePart == null ? null : storePart.trim();
    }

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid == null ? null : pageid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storePart=").append(storePart);
        sb.append(", pageid=").append(pageid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}