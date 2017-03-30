package com.fh.entity.system;

import java.io.Serializable;

/**
 * 用户个性权限表
 * @author MacBook
 *
 */
public class UserPagePerm implements Serializable {
	
	/**
	 * 序号
	 */
    private Integer id;
    
    /**
     * 用户编号
     */
    private String userid;

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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
        sb.append(", userid=").append(userid);
        sb.append(", pageid=").append(pageid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}