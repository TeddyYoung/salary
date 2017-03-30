package com.fh.service.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationTargetDao;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTargetQuery;

/**
 * 搭伙补贴Service实现类
 * @author zhang_yu
 *
 */
@Service
public class BoarderSubsidiesServiceImpl implements BoarderSubsidiesService {

	@Autowired
	private StationTargetDao stationTargetDao;
	
	/**
	 * 根据年月份、区域编号分页查询搭伙补贴信息
	 */
	public Page findBoarderSubsidiesByPage(Page page,StationTarget stationTarget) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao.findBoarderSubsidiesCountByCriteriaQuery(stationTarget);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao.findBoarderSubsidiesByPageCriteriaQuery(stationTarget, 
																				               page.getPageSize(), 
																				               page.getStartIndex());

		page.setRecords(records);
		return page;
		
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
