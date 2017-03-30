package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.PartStationDao;
import com.fh.entity.biz.PartStation;

/**
 * 过节费维护 Service实现类
 * @author Teddy
 */
@Service
public class PartStationServiceImpl implements PartStationService {

	@Autowired
	private PartStationDao partStationDao;
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findPartStationPage(Page page, PartStation partStation) {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = partStationDao.findCount(partStation);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<PartStation> records = partStationDao.findPartStationPage(partStation.getStationCode(), 
				page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 修改或新增
	 */
	public void saveOrUpdate(PartStation partStation) {
		if (null != partStation.getId() && !"".equals(partStation.getId())) {
			partStation.setSysUpdateTime(new Date());
			partStationDao.update(partStation);
		} else {
			partStation.setSysCreateTime(new Date());
			partStationDao.save(partStation);
		}
		
	}

	/**
	 * 根据id查询出对应的记录
	 */
	public PartStation getPartStation(Long partStationId) {
		return partStationDao.getPartStation(partStationId);
	}

	/**
	 * 根据id删除对应的记录
	 */
	public void delete(Long partStationId) {
		partStationDao.delete(partStationId);
	}

}
