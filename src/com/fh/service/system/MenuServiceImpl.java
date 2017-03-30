package com.fh.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.MenuDao;
import com.fh.dao.system.PagePermDao;
import com.fh.entity.system.Menu;
import com.fh.entity.system.MenuQuery;
import com.fh.entity.system.PagePerm;
import com.fh.entity.system.PagePermQuery;

/**
 * 菜单Service实现
 * 
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private PagePermDao pagePermDao;
	@Autowired
	private MenuDao menuDao;

	/**
	 * 通过角色编号查询角色对应的所有的菜单
	 */
	@Override
	public List<Menu> queryMenuByStorePart(String storePart) {

		if (null != storePart) {
			List<Menu> menus = this.menuDao.queryMenuByStorePart(storePart);

//			PagePermQuery pagePermQuery = new PagePermQuery();
//			pagePermQuery.createCriteria().andStorePartEqualTo(storePart);
//			List<PagePerm> pagePerms = pagePermDao
//					.selectByExample(pagePermQuery);
//			for (PagePerm pagePerm : pagePerms) {
//				String menuId = pagePerm.getPageid();
//				MenuQuery menuQuery = new MenuQuery();
//				menuQuery.createCriteria().andIdEqualTo(menuId);
//				menuQuery.createCriteria().andPidEqualTo("0");
//				menuQuery.setOrderByClause(" OrderBy ");
//				List<Menu> menuList = menuDao.selectByExample(menuQuery);
//				if(menuList!=null && menuList.size()>0){
//					menus.add(menuList.get(0));
//				}
//			}
			return menus;
		}
		return null;

	}

	/**
	 * 查询子菜单
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public List<Menu> querySubMenu(String pid) {
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.createCriteria().andPidEqualTo(pid);
		menuQuery.setOrderByClause(" OrderBy ");
		List<Menu> subMenu = menuDao.selectByExample(menuQuery);
		if (subMenu != null && subMenu.size() > 0) {
			return subMenu;
		} else {
			return null;
		}
	}
	
	/**
	 * 查询子菜单 带权限
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public List<Menu> querySubMenuByStorePart(String pid,String storePart) {
		List<Menu> subMenu = menuDao.querySubMenuByStorePart(pid, storePart);
		if (subMenu != null && subMenu.size() > 0) {
			return subMenu;
		} else {
			return null;
		}
	}

	/**
	 * 查询父菜单
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public List<Menu> queryAllParentMenu() {
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.createCriteria().andPidEqualTo("0");
		menuQuery.setOrderByClause(" OrderBy ");
		List<Menu> parentMenu = menuDao.selectByExample(menuQuery);
		if (parentMenu != null && parentMenu.size() > 0) {
			return parentMenu;
		} else {
			return null;
		}
	}

	/**
	 * 删除菜单
	 * 
	 * @param pid
	 * @return
	 */
	public String deleteMenuById(String id) {
		try {
			Menu menu = menuDao.selectByPrimaryKey(id);
			if ("0".equals(menu.getPid())) {
				List<Menu> subMenu = querySubMenu(id);
				if (subMenu != null && subMenu.size() > 0) {
					/*for (Menu sub : subMenu) {
						menuDao.deleteByPrimaryKey(sub.getId());
					}*/
					return "false2";
				}
			}
			menuDao.deleteByPrimaryKey(id);
			return "success";
		} catch (Exception e) {
			return "false";
		}
	}
	/**
	 * 根据id查询菜单
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public Menu queryMenuById(String id) {
		return menuDao.selectByPrimaryKey(id);
	}
	/**
	 * 保存菜单编辑
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public void updateMenu(Menu menu,String id) {
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.createCriteria().andIdEqualTo(id);
		menu.setId(null);
		menuDao.updateByExampleSelective(menu, menuQuery);
	}
	/**
	 * 插入菜单
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public void insertMenu(Menu menu) {
		menuDao.insertSelective(menu);
	}
	/**
	 * 查询所有的菜单
	 * 
	 * @param pid
	 * @return
	 */
	@Override
	public List<Menu> queryAllMenu() {
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.setOrderByClause(" OrderBy ");
		return menuDao.selectByExample(menuQuery);
	}
}
