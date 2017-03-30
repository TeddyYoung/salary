package com.fh.service.operation;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationLevel;
import com.fh.entity.biz.StationTarget;


/**
 * 油站星级 Service
 * @author lijn
 *
 */
public interface StationLevelService {
	/**
	 * 查询所有油站星级信息
	 * @param station
	 */
	public List<StationLevel> queryAll();
	/**分页查询 油站基本信息
	 * @return
	 */
	public Page findStationLevelsByPage(Page page,String stationLevelName);
	/**添加油站信息
	 * @param station
	 */
	public void saveOrUpdate(StationLevel stationLevel);
	/**根据id查询油站基本信息
	 * @param id
	 * @return
	 */
	public StationLevel queryStationLevelById(String id);
	/**根据id删除油站基本信息
	 * @param id
	 * @return
	 */
	public void deleteStationLevelById(String id);
	
	/**
	 * 根据条件查询油站基础数据信息
	 */
	public List<StationLevel> findByCondition(StationLevel stationLevel);
	
}
