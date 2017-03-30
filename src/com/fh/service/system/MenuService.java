package com.fh.service.system;

import java.util.List;

import com.fh.entity.system.Menu;

/**
 *	菜单Service
 */
public interface MenuService {
	
	/**
	 * 通过角色编号查询角色对应的所有的菜单
	 * @param storePart 角色编号
	 * @return
	 */
	public List<Menu> queryMenuByStorePart(String storePart);
	/**查询子菜单
	 * @param pid
	 * @return
	 */
	public List<Menu> querySubMenu(String pid);
	/**查询子菜单  根据权限
	 * @param pid
	 * @return
	 */
	public List<Menu> querySubMenuByStorePart(String pid,String storePart);
	/**查询父菜单
	 * @param pid
	 * @return
	 */
	public List<Menu> queryAllParentMenu();
	/**
	 * 删除菜单
	 * 
	 * @param pid
	 * @return
	 */
	public String deleteMenuById(String id);
	/**
	 * 根据id查询菜单
	 * 
	 * @param pid
	 * @return
	 */
	public Menu queryMenuById(String id); 
	/**
	 * 保存菜单编辑
	 * 
	 * @param pid
	 * @return
	 */
	public void updateMenu(Menu menu,String id); 
	/**
	 * 插入菜单
	 * 
	 * @param pid
	 * @return
	 */
	public void insertMenu(Menu menu);
	/**
	 * 查询所有的菜单
	 * 
	 * @param pid
	 * @return
	 */
	public List<Menu> queryAllMenu();
	
}
