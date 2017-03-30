package com.fh.service.operation;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationTarget;

/**
 * 便利店考核Service接口
 * @author zhang_yu
 *
 */
public interface StoreCheckService {

	/**
	 * 分页查询便利店考核信息, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param yearMonth 年月时间
	 * @return 分装好便利店考核信息的分页对象
	 */
	public Page findStoreByPage(Page page, String yearMonth);
	
	
	/**
	 * 查询上个月的所有便利店考核记录
	 * @param yearMonth 上个月日期
	 * @return
	 */
	public List<StationTarget> findAllStoreCheckByYearMonth(String yearMonth);


	/**
	 * 批量保存或修改便利店考核记录
	 * @param stationTargetList
	 */
	public void saveOrUpdateStoreCheck(List<StationTarget> stationTargetList);


	/**
	 * 按照年份、区域筛选分页查询便利店考核
	 * @param page
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	public Page findStoreCheckByPage(Page page, String yearMonth, String districtCode);

	/**
	 * 根据年月、区域查询便利店考核信息
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	public List<StationTarget> findAllStoreCheckByYearMonthAndDistrictCode(String yearMonth, String districtCode);
	
}
