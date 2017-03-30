package com.fh.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.DepPartDao;
import com.fh.dao.system.PagePermDao;
import com.fh.dao.system.UserStorePartDao;
import com.fh.entity.system.DepPart;
import com.fh.entity.system.DepPartQuery;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.PagePermQuery;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.UserStorePart;
import com.fh.entity.system.UserStorePartQuery;

/**
 *	部门角色Service实现
 */
@Service
public class DepPartServiceImpl implements DepPartService {
	
	@Autowired
	private UserStorePartDao userStorePartDao;
	@Autowired
	private DepPartDao depPartDao;
	@Autowired
	private PagePermDao pagePermDao;
	
	/**
	 * 根据用户名查询出用户所有的角色
	 */
	@Override
	public List<DepPart> queryDeptPartByUserId(String userId) {
		
		if (null != userId) {
			List<DepPart> depParts = new ArrayList<DepPart>();
			
			UserStorePartQuery userStorePartQuery = new UserStorePartQuery();
			userStorePartQuery.createCriteria().andUseridEqualTo(userId);
			List<UserStorePart> userStoreParts = userStorePartDao.selectByExample(userStorePartQuery);
			for (UserStorePart userStorePart : userStoreParts) {
				String storePart = userStorePart.getStorePart();
				
				DepPartQuery depPartQuery = new DepPartQuery();
				depPartQuery.createCriteria().andStorePartEqualTo(storePart);
				DepPart depPart = depPartDao.selectByExample(depPartQuery).get(0);
				depPart.setOrganiseId(userStorePart.getStoreid());
				depParts.add(depPart);
			}
			return depParts;
		}
		return null;
		
	}

	/**查询所有的部门角色
	 * @return
	 */
	@Override
	public List<DepPart> queryAllDepPart(){
		DepPartQuery depPartQuery = new DepPartQuery();
		List<DepPart> depParts = depPartDao.selectByExample(depPartQuery);
		if(depParts!=null&&depParts.size()>0){
			return depParts;
		}else{
			return null;
		}
	}
	/**查询所有的父级角色
	 * @return
	 */
	@Override
	public List<DepPart> queryAllParentDepPart(){
		DepPartQuery depPartQuery = new DepPartQuery();
		depPartQuery.createCriteria().andPStorePartEqualTo("0");
		List<DepPart> depParts = depPartDao.selectByExample(depPartQuery);
		if(depParts!=null&&depParts.size()>0){
			return depParts;
		}else{
			return null;
		}
	}
	/**查询下级部门角色
	 * @return
	 */
	@Override
	public List<DepPart> queryAllSubDepPart(String pstorepart){
		DepPartQuery depPartQuery = new DepPartQuery();
		depPartQuery.createCriteria().andPStorePartEqualTo(pstorepart);
		List<DepPart> subDepParts = depPartDao.selectByExample(depPartQuery);
		if(subDepParts!=null&&subDepParts.size()>0){
			return subDepParts;
		}else{
			return null;
		}
	}
	/**根据ID查询部门角色
	 * @return
	 */
	@Override
	public DepPart queryDeptPartByRoleId(String roleId){
		return depPartDao.selectByPrimaryKey(Integer.valueOf(roleId));
	}
	/**新增角色保存
	 * @return
	 */
	@Override
	public void insertDepPart(DepPart depPart){
		depPartDao.insertSelective(depPart);
	}
	/**编辑角色保存
	 * @return
	 */
	@Override
	public void updateDepPart(DepPart depPart){
		depPartDao.updateByPrimaryKeySelective(depPart);
	}
	/**将角色与子角色的连接 设置为null
	 * @return
	 */
	@Override
	public void updateDepPartByStorePart(String storePart){
		DepPartQuery depPartQuery = new DepPartQuery();
		depPartQuery.createCriteria().andPStorePartEqualTo(storePart);
		List<DepPart> depPartList = depPartDao.selectByExample(depPartQuery);
		if(depPartList!=null && depPartList.size()>0){
			for (DepPart depPart : depPartList) {
					depPart.setpStorePart(null);
					depPartDao.updateByPrimaryKey(depPart);
			}
		}
	}
	/**删除角色
	 * @return
	 */
	@Override
	public void deleteDepPartById(Integer depPartId){
		if(depPartId!=null){
			DepPart depPart = depPartDao.selectByPrimaryKey(depPartId);
			if(depPart!=null && !"".equals(depPart)){
				if("0".equals(depPart.getpStorePart())){
					DepPartQuery depPartQuery = new DepPartQuery();
					depPartQuery.createCriteria().andPStorePartEqualTo(depPart.getStorePart());
					depPartDao.deleteByExample(depPartQuery);
				}else{
					PagePermQuery pagePermQuery = new PagePermQuery();
					pagePermQuery.createCriteria().andStorePartEqualTo(depPart.getStorePart());
					pagePermDao.deleteByExample(pagePermQuery);
				}
			}
			depPartDao.deleteByPrimaryKey(depPartId);
		}
	}
	
	public List<DepPart> findUserDepPartList(StoreEmployee storeEmployee, OrganiseCO organiseCO) {
		List<DepPart> depPartList = this.depPartDao.findUserDepPartList(storeEmployee.getUserid(), organiseCO.getOrganiseId());
		return depPartList;
	}
	
}
