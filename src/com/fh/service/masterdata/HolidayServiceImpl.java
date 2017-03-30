package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.HolidayDao;
import com.fh.entity.biz.Holiday;

/**
 * 过节费维护 Service实现类
 * @author Teddy
 */
@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayDao holidayDao;
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findHolidayPage(Page page, Holiday holiday) {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = holidayDao.findCount(holiday);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Holiday> records = holidayDao.findHolidayPage(holiday.getType(), holiday.getYearMonth(), page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 修改或新增
	 */
	public void saveOrUpdate(Holiday holiday) {
		if (null != holiday.getId() && !"".equals(holiday.getId())) {
			holiday.setSysUpdateTime(new Date());
			holidayDao.update(holiday);
		} else {
			holiday.setSysCreateTime(new Date());
			holidayDao.save(holiday);
		}
		
	}

	/**
	 * 根据id查询出对应的记录
	 */
	public Holiday getHoliday(Long holidayId) {
		return holidayDao.getHoliday(holidayId);
	}

	/**
	 * 根据id删除对应的记录
	 */
	public void delete(Long holidayId) {
		holidayDao.delete(holidayId);
	}
	@Override
	public List<Holiday> findByYearMonth(String yearMonth) {
		String type = String.format("%s,%s,%s,%s",
				Holiday.TYPE_CHINESE_NEW_YEAR,
				Holiday.TYPE_FAMILY_REUNION_DINNER,
				Holiday.TYPE_HIGH_TEMPERATURE, Holiday.TYPE_NIGHT_SHIFT);
		return holidayDao.findByYearMonth(yearMonth, type);
	}

}
