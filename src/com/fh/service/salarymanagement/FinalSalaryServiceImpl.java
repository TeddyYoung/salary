package com.fh.service.salarymanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.biz.FinalSalaryDao;
import com.fh.entity.biz.FinalSalary;
import com.fh.entity.biz.FinalSalaryQuery;
import com.fh.entity.biz.Staff;

/**
 * 最终薪资表Service实现类
 * @author zhang_yu
 * 
 */
@Service
public class FinalSalaryServiceImpl implements FinalSalaryService {

	@Autowired
	private FinalSalaryDao finalSalaryDao;
	
	/**
	 * 批量保存FinalSalary记录
	 */
	public void insertFinalSalaryByList(List<FinalSalary> finalSalaryList) {
		
		if (finalSalaryList.size() != 0) {
			for (FinalSalary finalSalary : finalSalaryList) {
				finalSalaryDao.insertSelective(finalSalary);
			}
		}

	}

	/**
	 * 批量根据员工编号以及指定月份查询符合记录的FinalSalary记录
	 */
	public List<FinalSalary> findFinalSalarysByStaffCode(List<Staff> staffList, String yearM) {
		
		if (null != staffList && staffList.size() != 0) {
			List<FinalSalary> finalSalaryList = new ArrayList<FinalSalary>();
			for (Staff staff : staffList) {
				FinalSalaryQuery finalSalaryQuery = new FinalSalaryQuery();
				if (null != staff.getStaffCode() && !"".equals(staff.getStaffCode())) {
					finalSalaryQuery.createCriteria().andStaffCodeEqualTo(staff.getStaffCode());
					finalSalaryQuery.createCriteria().andYearMonthEqualTo(yearM);
					FinalSalary finalSalary = finalSalaryDao.selectByExample(finalSalaryQuery).get(0);
					finalSalaryList.add(finalSalary);
				}
			}
			return finalSalaryList;
		}else{
			return null;
		}
	}

}
