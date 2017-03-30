package com.fh.service.salarymanagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationTrialDao;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTrial;

/**
 * 薪资试算Service实现类
 * @author zhang_yu
 *
 */
@Service
public class StationTrialServiceImpl implements StationTrialService {

	@Autowired
	private StationTrialDao stationTrialDao;
	
	/**
	 * 分页查看薪资试算, 支持按年月过滤查询
	 */
	public Page findSalaryTrialsByPage(Page page, String yearMonth) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTrialDao.findStationTrialCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTrialDao.findStationTrialsByPageCriteriaQuery(yearMonth,
																						   page.getPageSize(), 
																						   page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}
	
	/**
	 * 修改或新增
	 */
	public void saveOrUpdate(StationTrial stationTrial) {
		
		if (null != stationTrial.getId() && !"".equals(stationTrial.getId())) {
			stationTrial.setSysUpdateTime(new Date());
			stationTrialDao.updateByPrimaryKeySelective(stationTrial);
		}else{
			stationTrial.setSysCreateTime(new Date());
			stationTrialDao.insertSelective(stationTrial);
		}
		
	}

}
