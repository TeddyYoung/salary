package com.fh.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.dao.biz.DistrictDao;
import com.fh.dao.system.StoreEmployeeDao;
import com.fh.entity.biz.District;
import com.fh.entity.biz.DistrictQuery;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeQuery;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.util.Encrypt;

/**
 * 用户管理Service实现类
 * @author zhang_yu
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private StoreEmployeeDao storeEmployeeDao;
	@Autowired
	private DistrictDao districtDao; 
	
	/**
	 * 分页查询用户列表, 支持模糊查询
	 */
	public Page findUsersByPage(Page page, String username,String subOrganiseIdStr) {
		// 查询总记录条数(需要判断是否带着查询条件进来)
		int totalRecordsNum;
		if (null != username && !"".equals(username)) {
			totalRecordsNum = storeEmployeeDao.findCountByCriteriaQuery(username,subOrganiseIdStr);
		} else {
			StoreEmployeeQuery storeEmployeeQuery = new StoreEmployeeQuery();
			totalRecordsNum = storeEmployeeDao.countByExample(storeEmployeeQuery);
		}
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StoreEmployeeVO> records = storeEmployeeDao.findUsersByPageCriteriaQuery(username,subOrganiseIdStr, page.getPageSize(), page.getStartIndex());
		for (StoreEmployeeVO storeEmployeevo : records) {
			String districtCode = storeEmployeevo.getDistrictCode();
			if (null != districtCode && !"".equals(districtCode)) {
				DistrictQuery districtQuery = new DistrictQuery();
				districtQuery.createCriteria().andDistrictCodeEqualTo(districtCode);
				District district = districtDao.selectByExample(districtQuery).get(0);
				storeEmployeevo.setDistrict(district);
			}
			
		}
		page.setRecords(records);
		return page;
		
	}

	@Override
	public void updateUserById(String id,String userid) {
		StoreEmployee storeEmployee = new StoreEmployee();
		storeEmployee.setId(Long.valueOf(id));
		storeEmployee.setUserpwd(Encrypt.md5(SysConstant.CURRENT_USER_PASSWORD, userid));
		storeEmployeeDao.updateByPrimaryKeySelective(storeEmployee);
	}
	
	@Override
	public void updateUserPWD() {
		StoreEmployeeQuery storeEmployeeQuery = new StoreEmployeeQuery();
		List<StoreEmployee> storeEmployeeList = storeEmployeeDao.selectByExample(storeEmployeeQuery);
		if(storeEmployeeList!=null && storeEmployeeList.size()>0){
			for (StoreEmployee storeEmployee : storeEmployeeList) {
				if(storeEmployee.getUserpwd()==null || "".equals(storeEmployee.getUserpwd())){
				
					storeEmployee.setUserpwd(Encrypt.md5(SysConstant.CURRENT_USER_PASSWORD, storeEmployee.getUserid()));
					storeEmployeeDao.updateByPrimaryKeySelective(storeEmployee);
				}
			}
		}
	}

}
