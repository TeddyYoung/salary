package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.AttendanceManagement;
import com.fh.entity.biz.AttendanceManagementQuery;
import com.fh.entity.biz.AttendanceSumVO;

public interface AttendanceManagementDao {
	int countByExample(AttendanceManagementQuery example);

	int deleteByExample(AttendanceManagementQuery example);

	int deleteByPrimaryKey(Long id);

	int insert(AttendanceManagement record);

	int insertSelective(AttendanceManagement record);

	List<AttendanceManagement> selectByExample(AttendanceManagementQuery example);

	AttendanceManagement selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") AttendanceManagement record,
			@Param("example") AttendanceManagementQuery example);

	int updateByExample(@Param("record") AttendanceManagement record,
			@Param("example") AttendanceManagementQuery example);

	int updateByPrimaryKeySelective(AttendanceManagement record);

	int updateByPrimaryKey(AttendanceManagement record);

	/**
	 * 根据年月筛选、油站编号筛选查询相应的记录数
	 * 
	 * @param yearMonth
	 *            年月筛选条件
	 * @param stationCode
	 *            油站编号筛选条件
	 */
	int findAttendanceManagementCountByCriteriaQuery(
			@Param("yearMonth") String yearMonth,
			@Param("stationCode") String stationCode,
			@Param("organiseId") String organiseId,
			@Param("districtCode") String districtCode);

	/**
	 * 根据月份查询考勤管理列表(默认查询上个月记录)
	 * 
	 * @param yearMonth
	 *            年月筛选条件
	 * @param stationCode
	 *            油站编号筛选条件
	 * @param pageSize
	 *            每页显示的条数
	 * @param startIndex
	 *            每页起始记录的索引
	 */
	List<AttendanceManagement> findAttendanceManagementByPageCriteriaQuery(
			@Param("yearMonth") String yearMonth,
			@Param("stationCode") String stationCode,
			@Param("organiseId") String organiseId,
			@Param("districtCode") String districtCode,
			@Param("pageSize") int pageSize, @Param("startIndex") int startIndex);

	AttendanceSumVO sumAttendance(@Param("yearMonth") String yearMonth,
			@Param("stationCode") String stationCode,
			@Param("organiseId") String organiseId,
			@Param("districtCode") String districtCode);

	/**
	 * 查询上个月所有考勤管理的记录
	 */
	List<AttendanceManagement> findAllAttendanceManagementByCriteriaQuery(
			@Param("yearMonth") String yearMonth,
			@Param("stationCode") String stationCode,
			@Param("status") String status);

	List<AttendanceManagement> findByCriteriaQuery(
			@Param("yearMonth") String yearMonth,
			@Param("stationCode") String stationCode,
			@Param("status") String status);

	/**
	 * 查询上个月的考勤记录
	 */
	int findAllAttendanceManagementByYearMonth(
			@Param("yearMonth") String yearMonth);

	/**
	 * 查询上个月所有考勤数据
	 * 
	 * @param yearMonth
	 * @return
	 */
	List<AttendanceManagement> findAllAttendanceManagementsByYearMonth(
			@Param("yearMonth") String yearMonth,
			@Param("districtCode") String districtCode);

	/**
	 * 查找考勤数量
	 * 
	 * @param yearMonth
	 * @return
	 */
	public int countByYearMonth(@Param("stationCode") String stationCode,
			@Param("yearMonth") String yearMonth);

}