package com.fh.service.masterdata;

import com.fh.common.page.Page;
import com.fh.entity.biz.PartStation;

/**
 * 兼站维护 Service
 * @author Teddy
 */
public interface PartStationService {

	/**
	 * 修改或新增地区系数记录
	 * @param area
	 */
	public void saveOrUpdate(PartStation partStation);
	
	/**
	 * 根据地区系数id删除对应的记录
	 * @param areaId
	 */
	public void delete(Long partStationId);

	/**
	 * 根据地区系数id查询出对应的记录
	 * @param partStationId
	 * @return
	 */
	public PartStation getPartStation(Long partStationId);

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param page 分液器
	 * @param partStation entity
	 * @return
	 */
	public Page findPartStationPage(Page page, PartStation partStation);
	
}
