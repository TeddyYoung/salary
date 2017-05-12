package com.fh.service.attendance;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.AttendanceManagement;
import com.fh.entity.biz.AttendanceSumVO;
import com.fh.entity.vo.AttendanceSearchVO;

/**
 * 考勤管理Service接口
 * 
 * @author zhang_yu
 *
 */
public interface AttendanceManagementService {

	/**
	 * 根据月份查询考勤管理列表(默认查询上个月记录)
	 * 
	 * @param page
	 *            分页对象
	 * @param yearMonth
	 *            年月条件
	 * @param stationCode
	 *            油站编号
	 * @return 分装好对应记录的分页对象
	 */
	Page findAttendanceManagementByPage(Page page, AttendanceSearchVO searchVO);

	/**
	 * 查询上个月所有考勤管理的记录
	 * 
	 * @param yearMonth
	 *            月份条件
	 * @param stationCode
	 *            所属油站
	 * @return 分装好对应记录的List集合
	 */
	List<AttendanceManagement> findAllAttendanceManagementByCriteriaQuery(
			String yearMonth, String stationCode, String status);

	/**
	 * 添加或修改考勤管理信息
	 */
	public void saveOrUpdateAttendanceManagement(
			List<AttendanceManagement> attendanceManagementList, String isSubmit);

	/**
	 * 查询上个月的考勤记录数
	 * 
	 * @param yearMonth
	 */
	int findAllAttendanceManagementByYearMonth(String yearMonth);

	/**
	 * 查询上个月所有考勤数据
	 * 
	 * @param yearMonth
	 * @return
	 */
	List<AttendanceManagement> findAllAttendanceManagementsByYearMonth(
			String yearMonth, String districtCode);

	public boolean checkAttendanceManage(String stationCode, String yearMonth);

	public List<AttendanceManagement> findByCriteriaQuery(String yearMonth,
			String stationCode, String status);

	public void update(AttendanceManagement atten);

	public AttendanceSumVO sumAttendance(AttendanceSearchVO searchVO);

}
