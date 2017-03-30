package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.DistrictDao;
import com.fh.entity.biz.District;
import com.fh.entity.biz.DistrictQuery;

/**
 * 区域 业务逻辑实现
 * @author lijn
 *
 */
@Service
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
	private DistrictDao districtDao;
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findDistrictsByPage(Page page, String districtName, String districtLevel) {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = districtDao.findCountByCriteriaQuery(districtName, districtLevel);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<District> records = districtDao.findDistrictsByPageCriteriaQuery(districtName, districtLevel, page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 修改或新增地区系数记录
	 */
	public void saveOrUpdate(District district) {
		
		if(district!=null && !"".equals(district))
		{
			if(district.getId()!=null && !"".equals(district.getId())){
				//修改
				district.setSysUpdateTime(new Date());
				districtDao.updateByPrimaryKeySelective(district);
			}else{
				//新增
				district.setSysCreateTime(new Date());
				districtDao.insertSelective(district);
				System.out.println("添加成功");
			}
		}
	}

	/**
	 * 根据地区系数id查询出对应的记录
	 */
	public District findDistrictById(String districtCode) {
		
		DistrictQuery districtQuery = new DistrictQuery();
		districtQuery.createCriteria().andDistrictCodeEqualTo(districtCode);
		return districtDao.selectByExample(districtQuery).get(0);
		
	}

	/**
	 * 根据地区系数id删除对应的记录
	 */
	public void delete(String districtId) {
		
		districtDao.deleteByPrimaryKey(Long.parseLong(districtId));
		
	}

}
