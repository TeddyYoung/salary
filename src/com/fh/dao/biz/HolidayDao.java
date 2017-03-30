package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.Holiday;

/**
 * 过节费DAO 
 * @author Teddy
 */
public interface HolidayDao {
	
	/**
	 * 新增过节费
	 * @param holiday
	 * @return
	 */
	public int save(Holiday holiday);
	
	/**
	 * 删除过节费
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 修改过节费
	 * @param holiday
	 * @return
	 */
	public int update(Holiday holiday);
	
	/**
	 * 查看过节费
	 * @param holiday
	 * @return
	 */
	public Holiday getHoliday(Long id);
	
	/**
	 * 获取过节费列表 - 不分页
	 * @param holiday
	 * @return
	 */
	public List<Holiday> findHolidayList(Holiday holiday);
	
	/**
	 * 查询地区系数列表 - 分页
	 * @param holiday entity
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	public List<Holiday> findHolidayPage(@Param("type") String type, @Param("yearMonth") String yearMonth, 
			@Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
	 * 根据筛选条件查询总记录数
	 * @return
	 */
	public int findCount(Holiday holiday);
	
	
	public List<Holiday> findByYearMonth(@Param("yearMonth") String yearMonth,@Param("type") String type);

}