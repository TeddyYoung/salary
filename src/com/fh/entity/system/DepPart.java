package com.fh.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门角色表
 * @author MacBook
 *
 */
public class DepPart implements Serializable {
	
	/**
	 * 序号
	 */
    private Integer id;
    
    /**
     * 部门类型
     */
    private String storeType;

    /**
     * 所属职位
     */
    private String partid;
    
    /**
     * 角色编号
     */
    private String storePart;

    /**
     * 角色名称
     */
    private String storePartName;
    
    /**
     * 归属上级角色
     */
    private String pStorePart;
    
    /**
     * 排序
     */
    private String orderbyId;
    
    /**
     * 拓展属性：部门编号
     */
    private String organiseId;
    
    /**
     * 拓展属性 ： 下级部门角色
     */
    private List<DepPart> subDepPart=new ArrayList<DepPart>();
    
    /**
     * 拓展属性 ： 菜单
     */
    private List<Menu> menuList=new ArrayList<Menu>();
    
    /**
     * 拓展属性 ： ztree选择
     */
    private boolean checked =false;
    
    public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getOrganiseId() {
		return organiseId;
	}

	public void setOrganiseId(String organiseId) {
		this.organiseId = organiseId;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public List<DepPart> getSubDepPart() {
		return subDepPart;
	}

	public void setSubDepPart(List<DepPart> subDepPart) {
		this.subDepPart = subDepPart;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

    public String getPartid() {
        return partid;
    }

    public void setPartid(String partid) {
        this.partid = partid == null ? null : partid.trim();
    }

    public String getStorePart() {
        return storePart;
    }

    public void setStorePart(String storePart) {
        this.storePart = storePart == null ? null : storePart.trim();
    }

    public String getStorePartName() {
        return storePartName;
    }

    public void setStorePartName(String storePartName) {
        this.storePartName = storePartName == null ? null : storePartName.trim();
    }

    public String getpStorePart() {
        return pStorePart;
    }

    public void setpStorePart(String pStorePart) {
        this.pStorePart = pStorePart == null ? null : pStorePart.trim();
    }

    public String getOrderbyId() {
        return orderbyId;
    }

    public void setOrderbyId(String orderbyId) {
        this.orderbyId = orderbyId == null ? null : orderbyId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storeType=").append(storeType);
        sb.append(", partid=").append(partid);
        sb.append(", storePart=").append(storePart);
        sb.append(", storePartName=").append(storePartName);
        sb.append(", pStorePart=").append(pStorePart);
        sb.append(", orderbyId=").append(orderbyId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}