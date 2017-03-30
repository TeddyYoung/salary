package com.fh.service.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationTargetDao;
import com.fh.entity.biz.StationTarget;

/**
 * 油站基础数据Service实现类
 * @author zhang_yu
 *
 */
@Service
public class OilBaseDataServiceImpl implements OilBaseDataService {

	@Autowired
	private StationTargetDao stationTargetDao;
	
	/**
	 * 分页查询油站基础数据, 支持按年月过滤查询
	 */
	public Page findOilBaseDataByPage(Page page, String yearMonth) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findStoreCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findOilBaseDataByPageCriteriaQuery(yearMonth, page.getPageSize(),
																						  page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

}
