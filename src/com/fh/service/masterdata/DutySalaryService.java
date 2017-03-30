package com.fh.service.masterdata;

import com.fh.common.page.Page;
import com.fh.entity.biz.DutySalary;

/**
 * 岗位工资维护 Service
 * @author Teddy
 */
public interface DutySalaryService {

	/**
	 * 修改或新增岗位薪资
	 * @param area
	 */
	public void saveOrUpdate(DutySalary dutySalary);
	
	/**
	 * 根据岗位薪资id删除对应的记录
	 * @param areaId
	 */
	public void delete(Long dutySalaryId);

	/**
	 * 根据岗位薪资id查询出对应的记录
	 * @param partStationId
	 * @return
	 */
	public DutySalary getDutySalary(Long dutySalaryId);

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param page 分液器
	 * @param partStation entity
	 * @return
	 */
	public Page findDutySalaryPage(Page page, DutySalary dutySalary);
	
}
