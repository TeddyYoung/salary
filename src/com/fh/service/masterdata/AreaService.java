package com.fh.service.masterdata;

import com.fh.common.page.Page;
import com.fh.entity.biz.Area;

/**
 * 地区系数维护 Service
 * @author zhang_yu
 *
 */
public interface AreaService {

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 当前页
	 * @param areaName 地区名称
	 * @param areaLevel 地区级别
	 * @return
	 */
	Page findAreasByPage(Page page, String areaName, String areaLevel);

	/**
	 * 修改或新增地区系数记录
	 * @param area
	 */
	public void saveOrUpdate(Area area);

	/**
	 * 根据地区系数id查询出对应的记录
	 * @param areaId
	 * @return
	 */
	public Area findAreaById(String areaId);

	/**
	 * 根据地区系数id删除对应的记录
	 * @param areaId
	 */
	public void delete(String areaId);
	
}
