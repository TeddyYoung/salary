package com.fh.service.salarymanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fh.common.page.Page;
import com.fh.entity.biz.SalaryDifference;

/**
 * 薪资差异处理Service接口
 * @author zhang_yu
 *
 */
public interface SalaryDifferenceService {

	/**
	 * 根据员工姓名和年月份查询薪资差异处理记录(支持分页查询)
	 * @param page 分页对象
	 * @param staffName 员工姓名
	 * @param yearMonth 年月份
	 */
	public Page findSalaryDifferencesByPage(Page page, String staffName, String yearMonth, String subOrganiseIdStr);

	/**
	 * 查询上个月的薪资差异记录
	 * @param yearMonth 上个月月份
	 */
	public List<SalaryDifference> findSalaryDifferenceByYearMonth(String yearMonth);

	/**
	 * 提交薪资差异申请, 启动流程
	 * @param salaryDifferenceList 薪资差异List集合
	 */
	public boolean saveOrUpdateSalaryDifference(List<SalaryDifference> salaryDifferenceCheckedList, HttpServletRequest request,String stationCode);

	/**
	 * 根据员工编号查询相应的薪资差异信息
	 * @param staffCode 员工编号
	 * @return
	 */
	public SalaryDifference findSalaryDifferenceByStaffCode(String staffCode);

	/**
	 * 根据油站编号查询该油站下所有的员工(包含员工所属的油站名称)
	 * @param subOrganiseIdStr
	 * @return
	 */
	public List<SalaryDifference> findStaffListWithStationNameByStationCode(String subOrganiseIdStr, String yearMonth);

	/**
	 * 根据员工编号查询出对应的薪资差异记录(包含员工所属的油站名称)
	 * @param staffCode 员工编号
	 * @return
	 */
	public SalaryDifference findSalaryDifferenceWithStationNameByStaffCode(String staffCode);

	public boolean existsFlow(String stationCode);

	public List<SalaryDifference> findByStaffCodes(String stationCode,
			String yearMomth, String[] staffCodes);

}
