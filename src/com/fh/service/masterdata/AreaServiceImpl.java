package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.AreaDao;
import com.fh.entity.biz.Area;
import com.fh.entity.biz.Duty;

/**
 * 地区系数维护 Service实现类
 * @author zhang_yu
 *
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findAreasByPage(Page page, String areaName, String areaLevel) {
		
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = areaDao.findCountByCriteriaQuery(areaName, areaLevel);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Duty> records = areaDao.findAreasByPageCriteriaQuery(areaName, areaLevel, page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 修改或新增地区系数记录
	 */
	public void saveOrUpdate(Area area) {
		
		if (null != area.getId() && !"".equals(area.getId())) {
			area.setSysUpdateTime(new Date());
			areaDao.updateByPrimaryKeySelective(area);
		}else{
			area.setSysCreateTime(new Date());
			areaDao.insertSelective(area);
		}
		
	}

	/**
	 * 根据地区系数id查询出对应的记录
	 */
	public Area findAreaById(String areaId) {
		
		return areaDao.selectByPrimaryKey(Long.parseLong(areaId));
		
	}

	/**
	 * 根据地区系数id删除对应的记录
	 */
	public void delete(String areaId) {
		
		areaDao.deleteByPrimaryKey(Long.parseLong(areaId));
		
	}

}
