package com.fh.service.system;

import java.util.List;

import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;

public interface StoreEmployeeService {
	
	/**
	 * 根据用户名查询用户对象
	 * @param userId 用户名
	 * @return
	 */
	public StoreEmployee queryStoreEmployeeByUserId(String userId);
	/**
	 * 根据角色id查询VO
	 * @param pStorePart 父角色id
	 * @return
	 */
	public List<StoreEmployeeVO> queryStoreEmployeeVOBypStorePart(String storeParts,String departmentCode);
	
	/**
	 * 修改用户密码
	 * @param storeEmployee
	 */
	public void editPassword(StoreEmployee storeEmployee) throws Exception;
	
}
