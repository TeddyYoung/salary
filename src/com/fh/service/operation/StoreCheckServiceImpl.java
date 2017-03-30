package com.fh.service.operation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationTargetDao;
import com.fh.entity.biz.StationTarget;

/**
 * 便利店考核Service实现类
 * @author zhang_yu
 *
 */
@Service
public class StoreCheckServiceImpl implements StoreCheckService {

	@Autowired
	private StationTargetDao stationTargetDao;
	
	public Page findStoreByPage(Page page, String yearMonth) {
		
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findStoreCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findStoresByPageCriteriaQuery(yearMonth, page.getPageSize(), page.getStartIndex());
		
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 查询上个月的所有便利店考核记录
	 */
	public List<StationTarget> findAllStoreCheckByYearMonth(String yearMonth) {
		
		 List<StationTarget> stationTargets = stationTargetDao.findAllStoreCheckByYearMonth(yearMonth);
		 return stationTargets;
		
	}

	/**
	 * 批量保存或修改便利店考核记录
	 */
	public void saveOrUpdateStoreCheck(List<StationTarget> stationTargetList) {
		
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
	 * 按照年份、区域筛选分页查询便利店考核
	 */
	public Page findStoreCheckByPage(Page page, String yearMonth, String districtCode) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findStoreCheckCountByCriteriaQuery(yearMonth, districtCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findStoreCheckByPageCriteriaQuery(yearMonth, districtCode,
																					     page.getPageSize(), 
																					     page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}

	/**
	 * 根据年月、区域查询便利店考核信息
	 */
	public List<StationTarget> findAllStoreCheckByYearMonthAndDistrictCode(String yearMonth, String districtCode) {
		
		List<StationTarget> stationTargets = stationTargetDao.findAllStoreCheckByYearMonthAndDistrictCode(yearMonth, districtCode);
		return stationTargets;
		
	}

}
