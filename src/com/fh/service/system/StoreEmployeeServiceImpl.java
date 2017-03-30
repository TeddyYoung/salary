package com.fh.service.system;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.StoreEmployeeDao;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.util.Encrypt;
/**
 * 
 *
 */
@Service
public class StoreEmployeeServiceImpl implements StoreEmployeeService {
	
	@Autowired
	private StoreEmployeeDao storeEmployeeDao;
	/**
	 * 根据用户名查询用户对象
	 */
	@Override
	public StoreEmployee queryStoreEmployeeByUserId(String userId) {
		
		if (null != userId) {
			/*StoreEmployeeQuery storeEmployeeQuery = new StoreEmployeeQuery();
			storeEmployeeQuery.createCriteria().andUseridEqualTo(userId);
			storeEmployeeDao.selectByExample(storeEmployeeQuery).get(0)*/
			StoreEmployee storeEmployee = storeEmployeeDao.queryStoreEmployeeByUserId(userId);
			return storeEmployee;
		}
		return null;
		
	}
	
	/**
	 * 根据父角色id查询VO
	 * @param pStorePart 父角色id
	 * @return
	 */
	public List<StoreEmployeeVO> queryStoreEmployeeVOBypStorePart(String storeParts,String departmentCode){
		return storeEmployeeDao.findListVOCriteriaQuery(storeParts,departmentCode);
	}
	
	public void editPassword(StoreEmployee storeEmployee) throws Exception {
		StoreEmployee oldStoreEmployee = this.storeEmployeeDao.queryStoreEmployeeByUserId(storeEmployee.getUserid());
		if (!oldStoreEmployee.getUserpwd().equals(Encrypt.md5(storeEmployee.getUserpwd()))) {
			throw new Exception("原密码错误");
		}
		oldStoreEmployee.setUserpwd(Encrypt.md5(storeEmployee.getNewPassword()));
		storeEmployeeDao.updateByPrimaryKeySelective(oldStoreEmployee);
	}

}
