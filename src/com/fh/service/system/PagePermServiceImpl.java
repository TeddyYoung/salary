package com.fh.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.MenuDao;
import com.fh.dao.system.PagePermDao;
import com.fh.entity.system.Menu;
import com.fh.entity.system.PagePerm;
import com.fh.entity.system.PagePermQuery;

/**
 *	角色权限Service实现
 */
@Service
public class PagePermServiceImpl implements PagePermService {
	@Autowired
	private PagePermDao pagePermDao;
	
	@Autowired
	private MenuDao menuDao;
	
	/**根据角色编号，查询角色所拥有的菜单
	 * @param storePart
	 * @return
	 */
	@Override
	public List<Menu> queryDepPartMenus(String storePart){
		PagePermQuery permQuery = new PagePermQuery();
		permQuery.createCriteria().andStorePartEqualTo(storePart);
		List<PagePerm> perms = pagePermDao.selectByExample(permQuery);
		List<Menu> menuList=new ArrayList<Menu>();
		if(perms!=null&&perms.size()>0){
			for (PagePerm perm : perms) {
				Menu menu=new Menu();
				menu=menuDao.selectByPrimaryKey(perm.getPageid());
				menuList.add(menu);
			}
			return menuList;
		}else{
			return null;
		}
	}
	/**保存添加
	 */
	@Override
	public void insertPagePerm(String storePart,String menuPagePerm){
		PagePerm pagePerm = new PagePerm();
		pagePerm.setPageid(menuPagePerm);
		pagePerm.setStorePart(storePart);
		pagePermDao.insertSelective(pagePerm);
	}
	/** 根据角色删除已有对应菜单记录
	 */
	@Override
	public void deletePagePermByStorePart(String storePart){
		PagePermQuery pagePermQuery = new PagePermQuery();
		pagePermQuery.createCriteria().andStorePartEqualTo(storePart);
		pagePermDao.deleteByExample(pagePermQuery);
	}
}
