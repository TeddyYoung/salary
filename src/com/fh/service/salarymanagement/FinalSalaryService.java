package com.fh.service.salarymanagement;

import java.util.List;

import com.fh.entity.biz.FinalSalary;
import com.fh.entity.biz.Staff;

/**
 * 最终薪资表Service接口
 * @author zhang_yu
 *
 */
public interface FinalSalaryService {

	/**
	 * 批量保存FinalSalary记录
	 * @param finalSalaryList FinalSalary集合
	 */
	public void insertFinalSalaryByList(List<FinalSalary> finalSalaryList);

	/**
	 * 批量根据员工编号以及指定月份查询符合记录的FinalSalary记录
	 * @param staffList 员工集合
	 * @return
	 */
	public List<FinalSalary> findFinalSalarysByStaffCode(List<Staff> staffList, String yearM);
	
}
