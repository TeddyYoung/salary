package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.DutySalary;

/**
 * 岗位工资维护 DAO 
 * @author Teddy
 */
public interface DutySalaryDao {
	
	/**
	 * 新增岗位薪资
	 * @param partStation
	 * @return
	 */
	public int save(DutySalary dutySalary);
	
	/**
	 * 删除岗位薪资
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 修改岗位薪资
	 * @param partStation
	 * @return
	 */
	public int update(DutySalary dutySalary);
	
	/**
	 * 查看岗位薪资
	 * @param partStation
	 * @return
	 */
	public DutySalary getDutySalary(Long id);
	
	/**
	 * 获取岗位薪资列表 - 不分页
	 * @param partStation
	 * @return
	 */
	public List<DutySalary> findDutySalaryList(DutySalary dutySalary);
	
	/**
	 * 查询岗位薪资列表 - 分页
	 * @param partStation entity
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	public List<DutySalary> findDutySalaryPage( @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
	 * 根据筛选条件查询总记录数
	 * @return
	 */
	public int findCount(DutySalary dutySalary);

}