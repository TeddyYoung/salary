package com.fh.service.operation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationTargetDao;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTargetQuery;

/**
 * 星级评测Service实现类
 * @author zhang_yu
 *
 */
 @Service
public class StarEvaluatingServiceImpl implements StarEvaluatingService {

	@Autowired
	private StationTargetDao stationTargetDao;

	/**
	 * 分页查询星际评测信息, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param yearMonth 年月时间
	 * @return 分装好星级评测信息的分页对象
	 */
	public Page findStarEvaluatingByPage(Page page, String yearMonth) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findStoreCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findStarEvaluatingByPageCriteriaQuery(yearMonth, page.getPageSize(),
																					 	     page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}

	/**
	 * 查询上月所有星级评测信息
	 */
	public List<StationTarget> findAllStarevaluatingByYearMonth(String yearMonth) {
		List<StationTarget> stationTargets = stationTargetDao.findAllStarevaluatingByYearMonth(yearMonth);
		return stationTargets;
	}

	/**
	 * 批量保存或修改星级评测记录
	 */
	public void saveOrUpdateStarEvaluating(List<StationTarget> stationTargetList) {

		for (StationTarget stationTarget : stationTargetList) {
			if (null != stationTarget.getId() && !"".equals(stationTarget.getId())) {
				stationTarget.setSysUpdateTime(new Date());
				stationTargetDao.updateByPrimaryKeySelective(stationTarget);
			}else{
				if ("".equals(stationTarget.getStationLevelCode()) || null == stationTarget.getStationLevelCode()) {
					stationTarget.setStationLevelCode("LEVEL_002");
				}
				stationTarget.setSysCreateTime(new Date());
				stationTargetDao.insertSelective(stationTarget);
			}
		}
		
	}

	/**
	 * 分页查询星级评测信息, 支持按年月过滤查询和按区域过滤查询
	 */
	public Page findStarEvaluatingByPage(Page page, String yearMonth, String districtCode) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findStarEvaCountByCriteriaQuery(yearMonth, districtCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findStarEvaByPageCriteriaQuery(yearMonth, districtCode,
																					  page.getPageSize(),
																					  page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}

	/**
	 * 根据区域查询上月所有星级评测信息
	 */
	public List<StationTarget> findAllStarevaluatingByYearMonthAndDistrictCode(String yearMonth, String districtCode) {
		
		List<StationTarget> stationTargets = stationTargetDao
											 .findAllStarevaluatingByYearMonthAndDistrictCode(yearMonth, 
													 										  districtCode);
		return stationTargets;
		
	}

	/**
	 * 将Excel中的全部数据UPDATE入库
	 */
	public void updateExcelDataByStationCode(List<StationTarget> excelStationTargetList) {
		
		for (StationTarget stationTarget : excelStationTargetList) {
			StationTargetQuery stationTargetQuery = new StationTargetQuery();
			stationTargetQuery.createCriteria().andStationCodeEqualTo(stationTarget.getStationCode());
			stationTargetDao.updateByExampleSelective(stationTarget, stationTargetQuery);
		}
		
	}
		
}
