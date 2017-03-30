package com.fh.service.system;

import java.util.List;

import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;

/**
 * 机构信息Service接口
 * @author lijn
 *
 */
public interface OrganiseCOService {

	/**
	 * 根据父机构Id 查询所有的下属部门
	 */
	public List<OrganiseCO> findListOrganiseCOByPOrganiseId(String POrganiseId);
	
	/**
	 * 根据机构Id 查询机构部门
	 */
	public OrganiseCO findOrganiseCOByorganiseId(String organiseId);
	
	/**
	 * 获取用户所属的机构列表
	 * @return
	 */
	public List<OrganiseCO> findOrganiseCOListByUserID(StoreEmployee storeEmployee);
	
}
