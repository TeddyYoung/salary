package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.DutySalaryDao;
import com.fh.entity.biz.DutySalary;

/**
 * 岗位工资 Service实现类
 * @author Teddy
 */
@Service
public class DutySalaryServiceImpl implements DutySalaryService {

	@Autowired
	private DutySalaryDao dutySalaryDao;
	
	public Page findDutySalaryPage(Page page, DutySalary dutySalary) {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = dutySalaryDao.findCount(dutySalary);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<DutySalary> records = dutySalaryDao.findDutySalaryPage(page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	public void saveOrUpdate(DutySalary dutySalary) {
		if (null != dutySalary.getId() && !"".equals(dutySalary.getId())) {
			dutySalary.setSysUpdateTime(new Date());
			dutySalaryDao.update(dutySalary);
		} else {
			dutySalary.setSysCreateTime(new Date());
			dutySalaryDao.save(dutySalary);
		}
		
	}

	public DutySalary getDutySalary(Long dutySalaryId) {
		return dutySalaryDao.getDutySalary(dutySalaryId);
	}

	public void delete(Long dutySalaryId) {
		dutySalaryDao.delete(dutySalaryId);
	}


}
