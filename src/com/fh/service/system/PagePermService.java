package com.fh.service.system;

import java.util.List;

import com.fh.entity.system.Menu;

/**
 *	角色权限Service
 */
public interface PagePermService {
	/**根据角色编号，查询角色所拥有的菜单
	 * @param storePart
	 * @return
	 */
	public List<Menu> queryDepPartMenus(String storePart);
	/**保存添加
	 */
	public void insertPagePerm(String storePart,String menuPagePerm);
	/** 根据角色删除已有对应菜单记录
	 */
	public void deletePagePermByStorePart(String storePart);
}
