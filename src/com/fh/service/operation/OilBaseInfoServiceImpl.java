package com.fh.service.operation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationTargetDao;
import com.fh.entity.biz.StationTarget;

/**
 * 油站基础信息Service实现类
 * @author zhang_yu
 *
 */
@Service
public class OilBaseInfoServiceImpl implements OilBaseInfoService {

	@Autowired
	private StationTargetDao stationTargetDao;
	
	/**
	 * 分页查询星际评测信息, 支持按年月过滤查询
	 */
	public Page findOilBaseInfoByPage(Page page, String yearMonth) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findStoreCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findOilBaseInfoByPageCriteriaQuery(yearMonth,page.getPageSize(),
																							 page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 查询上月所有星级评测信息
	 */
	public List<StationTarget> findAllOilBaseInfoByYearMonth(String yearMonth) {
		
		List<StationTarget> stationTargets = stationTargetDao.findAllOilBaseInfoByYearMonth(yearMonth);
		return stationTargets;
		
	}

	/**
	 * 批量保存或修改星级评测记录
	 */
	public void saveOrUpdateOilBaseInfo(List<StationTarget> stationTargetList) {

		for (StationTarget stationTarget : stationTargetList) {
			if (null != stationTarget.getId() && !"".equals(stationTarget.getId())) {
				stationTarget.setSysUpdateTime(new Date());
				stationTargetDao.updateByPrimaryKeySelective(stationTarget);
			}else{
				stationTarget.setSysCreateTime(new Date());
				stationTargetDao.insertSelective(stationTarget);
			}
		}
		
	}

	/**
	 * 根据月份和区域查询油站基础信息列表
	 */
	public Page findOilBaseInfoByPage(Page page, String yearMonth, String districtCode) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findOilBaseInfoCountByCriteriaQuery(yearMonth, districtCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findOilBaseInByPageCriteriaQuery(yearMonth, districtCode,
																					  	  page.getPageSize(), 
																					  	  page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}

	/**
	 * 根据月份和区域查询上个月油站基础数据
	 */
	public List<StationTarget> findAllOilBaseInfoByYearMonthAndDistrictCode(String yearMonth, String districtCode) {
		
		List<StationTarget> stationTargets = stationTargetDao.findAllOilBaseInfoByYearMonthAndDistrictCode(yearMonth, districtCode);
		return stationTargets;
		
	}

}
