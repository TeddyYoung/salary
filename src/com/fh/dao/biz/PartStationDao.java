package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.PartStation;

/**
 * 兼站维护 DAO 
 * @author Teddy
 */
public interface PartStationDao {
	
	/**
	 * 新增过节费
	 * @param partStation
	 * @return
	 */
	public int save(PartStation partStation);
	
	/**
	 * 删除过节费
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 修改过节费
	 * @param partStation
	 * @return
	 */
	public int update(PartStation partStation);
	
	/**
	 * 查看过节费
	 * @param partStation
	 * @return
	 */
	public PartStation getPartStation(Long id);
	
	/**
	 * 获取过节费列表 - 不分页
	 * @param partStation
	 * @return
	 */
	public List<PartStation> findPartStationList(PartStation partStation);
	
	/**
	 * 查询地区系数列表 - 分页
	 * @param partStation entity
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	public List<PartStation> findPartStationPage(@Param("stationCode") String stationCode, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
	 * 根据筛选条件查询总记录数
	 * @return
	 */
	public int findCount(PartStation partStation);

}