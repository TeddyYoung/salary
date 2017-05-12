package com.fh.service.station;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.Station;


/**
 * 油站信息维护 Service
 * @author lijn
 *
 */
public interface StationService {
	/**分页查询 油站基本信息
	 * @return
	 */
	public Page findStationsByPage(Page page,String stationName,String stationStatus, String districtCode);
	/**添加油站信息
	 * @param station
	 */
	public void saveOrUpdate(Station station);
	/**根据id查询油站基本信息
	 * @param id
	 * @return
	 */
	public Station queryStationById(String id);
	/**根据id删除油站基本信息
	 * @param id
	 * @return
	 */
	public void deleteStationById(String id);
	/**查询油站列表
	 * @param id
	 * @return
	 */
	public List<Station> queryAll();
	
	/**
	 * 根据查询油站对象
	 * @param stationCode 
	 * @return 油站对象
	 */
	public Station findStationByStationCode(String stationCode);

	/**根据查询油站基本信息
	 * @param id
	 * @return
	 */
	public Station queryStationByStationCode(String stationCode);
	
	/**
	 * 根据员工编号查询员工所属油站(仅仅加载这个油站, 油站所关联的任何对象都不需要)
	 * @param stationCode 员工编号
	 * @return
	 */
	public Station findOnlyStationByStationCode(String stationCode);
	
	/**
	 * 查询所有的油站信息(包含stationTypeName)
	 * @return
	 */
	public List<Station> findAllStationWithStationTypeName();
	public List<Station> findByDistrict(String districtCode);
	
}
