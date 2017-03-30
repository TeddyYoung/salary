package com.fh.service.operation;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationTarget;

/**
 * 油站基础信息Service接口
 * @author zhang_yu
 *
 */
public interface OilBaseInfoService {

	/**
	 * 分页查询油站基础信息, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param yearMonth 年月时间
	 * @return 分装好星际评测信息的分页对象
	 */
	public Page findOilBaseInfoByPage(Page page, String yearMonth);

	/**
	 * 查询上月所有油站基础信息
	 * @param yearMonth
	 * @return
	 */
	public List<StationTarget> findAllOilBaseInfoByYearMonth(String yearMonth);

	/**
	 * 批量保存或修改油站基础信息记录
	 * @param stationTargetList
	 */
	public void saveOrUpdateOilBaseInfo(List<StationTarget> stationTargetList);

	/**
	 * 根据月份和区域查询油站基础信息列表
	 * @param page
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	public Page findOilBaseInfoByPage(Page page, String yearMonth, String districtCode);

	/**
	 * 根据月份和区域查询上个月油站基础数据
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	public List<StationTarget> findAllOilBaseInfoByYearMonthAndDistrictCode(String yearMonth, String districtCode);
	
}
