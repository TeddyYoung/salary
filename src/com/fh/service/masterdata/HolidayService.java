package com.fh.service.masterdata;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.Holiday;

/**
 * 地区系数维护 Service
 * @author zhang_yu
 *
 */
public interface HolidayService {

	/**
	 * 修改或新增地区系数记录
	 * @param area
	 */
	public void saveOrUpdate(Holiday holiday);
	
	/**
	 * 根据地区系数id删除对应的记录
	 * @param areaId
	 */
	public void delete(Long holidayId);

	/**
	 * 根据地区系数id查询出对应的记录
	 * @param holidayId
	 * @return
	 */
	public Holiday getHoliday(Long holidayId);

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param page 分液器
	 * @param holiday entity
	 * @return
	 */
	public Page findHolidayPage(Page page, Holiday holiday);

	public List<Holiday> findByYearMonth(String yearMonth);
	
}
