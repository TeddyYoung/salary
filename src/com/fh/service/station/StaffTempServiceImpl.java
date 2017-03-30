package com.fh.service.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.biz.StaffTempDao;
import com.fh.entity.biz.StaffTemp;
import com.fh.entity.biz.StaffTempQuery;

/**
 * 员工成本信息Service实现类
 * @author lijn
 *
 */
@Service
public class StaffTempServiceImpl implements StaffTempService {
	@Autowired
	private StaffTempDao staffTempDao;

	/**
	 * 批量保存或修改员工成本信息记录
	 */
	public void saveOrUpdateStaffTemp(List<StaffTemp> StaffTempList) {
		
		for (StaffTemp StaffTemp : StaffTempList) {
			if (null != StaffTemp.getId() && !"".equals(StaffTemp.getId())) {
				staffTempDao.updateByPrimaryKeySelective(StaffTemp);
			}else{
				staffTempDao.insertSelective(StaffTemp);
			}
		}
		
	}

	@Override
	public StaffTemp findStaffByStaffCode(String StaffCode) {
		StaffTempQuery staffTempQuery = new StaffTempQuery();
		staffTempQuery.createCriteria().andStaffCodeEqualTo(StaffCode);
		List<StaffTemp> selectByExample = staffTempDao.selectByExample(staffTempQuery);
		if(selectByExample!=null && selectByExample.size()>0){
			return selectByExample.get(0);
		}else{
			return null;
		}
	}

}
