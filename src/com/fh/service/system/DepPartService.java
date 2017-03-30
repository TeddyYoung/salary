package com.fh.service.system;

import java.util.List;

import com.fh.entity.system.DepPart;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;

/**
 *	部门角色Service
 */
public interface DepPartService {
	
	/**
	 * 根据用户名查询出用户所有角色
	 * @param userId 用户名
	 * @return
	 */
	public List<DepPart> queryDeptPartByUserId(String userId);
	/**查询所有的部门角色
	 * @return
	 */
	public List<DepPart> queryAllDepPart();
	/**查询所有的父级角色
	 * @return
	 */
	public List<DepPart> queryAllParentDepPart();
	/**查询下级部门角色
	 * @return
	 */
	public List<DepPart> queryAllSubDepPart(String pstorepart);
	/**根据ID查询部门角色
	 * @return
	 */
	public DepPart queryDeptPartByRoleId(String roleId);
	/**新增角色保存
	 * @return
	 */
	public void insertDepPart(DepPart depPart);
	/**编辑角色保存
	 * @return
	 */
	public void updateDepPart(DepPart depPart);
	/**删除角色
	 * @return
	 */
	public void deleteDepPartById(Integer depPartId);
	/**将角色与子角色的连接 设置为null
	 * @return
	 */
	public void updateDepPartByStorePart(String storePart);
	
	/**
	 * 根据用户和机构获取所拥有的角色列表
	 * @param storeEmployee
	 * @param organiseCO
	 * @return
	 */
	public List<DepPart> findUserDepPartList(StoreEmployee storeEmployee, OrganiseCO organiseCO);
}
