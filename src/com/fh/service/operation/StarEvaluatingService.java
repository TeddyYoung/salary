package com.fh.service.operation;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationTarget;

/**
 * 星级评测Serivice接口
 * @author zhang_yu
 *
 */
public interface StarEvaluatingService {

	/**
	 * 分页查询星级评测信息, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param yearMonth 年月时间
	 * @return 分装好星际评测信息的分页对象
	 */
	public Page findStarEvaluatingByPage(Page page, String yearMonth);

	/**
	 * 查询上月所有星级评测信息
	 * @param yearMonth
	 * @return
	 */
	public List<StationTarget> findAllStarevaluatingByYearMonth(String yearMonth);

	/**
	 * 批量保存或修改星级评测记录
	 * @param stationTargetList
	 */
	public void saveOrUpdateStarEvaluating(List<StationTarget> stationTargetList);

	/**
	 * 分页查询星级评测信息, 支持按年月过滤查询和按区域过滤查询
	 * @param page
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	public Page findStarEvaluatingByPage(Page page, String yearMonth,
										 String districtCode);

	/**
	 * 根据区域查询上月所有星级评测信息
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	public List<StationTarget> findAllStarevaluatingByYearMonthAndDistrictCode(String yearMonth, String districtCode);

	/**
	 * 将Excel中的全部数据UPDATE入库
	 */
	public void updateExcelDataByStationCode(List<StationTarget> excelStationTargetList);
	
}
