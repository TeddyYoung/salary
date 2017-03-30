package com.fh.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**菜单功能表
 * @author lijn
 *
 */
public class Menu implements Serializable {
	
	/**
	 * 功能菜单编号
	 */
    private String id;
    
    /**
     * 上级菜单编号
     */
    private String pid;
    
    /**
     * 菜单功能名称
     */
    private String name;
    
    /**
     * 菜单程序路径
     */
    private String url;
    
    /**
     * 菜单标题
     */
    private String title;
    
    /**
     * 功能显示区域
     */
    private String target;
    
    /**
     * 菜单关闭图标
     */
    private String icon;
    
    /**
     * 菜单展开图标
     */
    private String openicon;
    
    /**
     * 排序
     */
    private Integer orderby;
    
    /**
     * 拓展属性 ： 下级菜单 
     */
    private List<Menu> subMenu=new ArrayList<Menu>();
    
    /**
     * 拓展属性 ： ztree选择
     */
    private boolean checked =false;
    
    public boolean isChecked() {
		return checked;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getOpenicon() {
        return openicon;
    }

    public void setOpenicon(String openicon) {
        this.openicon = openicon == null ? null : openicon.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", title=").append(title);
        sb.append(", target=").append(target);
        sb.append(", icon=").append(icon);
        sb.append(", openicon=").append(openicon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}