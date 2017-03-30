package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.LossBonus;

/**
 * 油品损耗奖金DAO 
 * @author Teddy
 */
public interface LossBonusDao {
	
	/**
	 * 新增油品损耗奖金
	 * @param lossBonus
	 * @return
	 */
	public int save(LossBonus lossBonus);
	
	/**
	 * 删除油品损耗奖金
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 修改油品损耗奖金
	 * @param lossBonus
	 * @return
	 */
	public int update(LossBonus lossBonus);
	
	/**
	 * 查看油品损耗奖金
	 * @param lossBonus
	 * @return
	 */
	public LossBonus get(Long id);
	
	/**
	 * 获取列表 - 不分页
	 * @param lossBonus
	 * @return
	 */
	public List<LossBonus> queryList(LossBonus lossBonus);
	
	/**
	 * 查询列表 - 分页
	 * @param lossBonus entity
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	public List<LossBonus> queryPage(@Param("lossBonus") LossBonus lossBonus, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
	 * 根据筛选条件查询总记录数
	 * @return
	 */
	public int queryCount(LossBonus lossBonus);
	
}