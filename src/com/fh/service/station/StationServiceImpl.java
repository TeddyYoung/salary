package com.fh.service.station;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.AreaDao;
import com.fh.dao.biz.StationDao;
import com.fh.dao.biz.StationLevelDao;
import com.fh.entity.biz.Area;
import com.fh.entity.biz.AreaQuery;
import com.fh.entity.biz.Station;
import com.fh.entity.biz.StationLevel;
import com.fh.entity.biz.StationLevelQuery;
import com.fh.entity.biz.StationQuery;

/**
 * Station业务逻辑层实现类
 * @author lijn
 *
 */
@Service
public class StationServiceImpl implements StationService {
	@Autowired
	private StationDao stationDao;
	@Autowired
	private AreaDao areaDao;
	@Autowired
	private StationLevelDao stationLevelDao;
	
	/**分页查询 油站基本信息
	 * @return
	 */
	@Override
	public Page findStationsByPage(Page page, String stationName, String stationStatus, String districtCode){
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationDao.findCountByCriteriaQuery(stationName, stationStatus, districtCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Station> records = stationDao.findStationsByPageCriteriaQuery(stationName, stationStatus, districtCode, 
				page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
	}
	/**添加油站信息
	 * @param station
	 */
	@Override
	public void saveOrUpdate(Station station){
		if(station!=null && !"".equals(station))
		{
			if(station.getId()!=null && !"".equals(station.getId())){
				//修改
				station.setSysUpdateTime(new Date());
				stationDao.updateByPrimaryKeySelective(station);
			}else{
				//新增
				if("0".equals(station.getStationStatus())){
					station.setStationStatus("1");
				}
				station.setSysCreateTime(new Date());
				stationDao.insertSelective(station);
				//System.out.println("添加成功");
			}
		}
	}
	/**根据id查询油站基本信息
	 * @param id
	 * @return
	 */
	@Override
	public Station queryStationById(String id){
		if(id!=null && !"".equals(id)){
			return stationDao.selectByPrimaryKey(Long.valueOf(id));
		}else{
			return null;
		}
	}
	/**根据查询油站基本信息
	 * @param id
	 * @return
	 */
	@Override
	@Deprecated
	public Station queryStationByStationCode(String stationCode){
		if(stationCode!=null && !"".equals(stationCode)){
			StationQuery stationQuery = new StationQuery();
			List<Station> stationList = stationDao.selectByExample(stationQuery);
			if(stationList!=null && stationList.size()>0){
				return stationList.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	/**根据id删除油站基本信息
	 * @param id
	 * @return
	 */
	@Override
	public void deleteStationById(String id){
		stationDao.deleteByPrimaryKey((Long.valueOf(id)));
	}
	/**查询油站列表
	 * @param id
	 * @return
	 */
	@Override
	public List<Station> queryAll(){
		StationQuery stationQuery = new StationQuery();
		return stationDao.selectByExample(stationQuery);
	}
	
	/**
	 * 根据查询油站对象
	 */
	public Station findStationByStationCode(String stationCode) {
		
		StationQuery stationQuery = new StationQuery();
		stationQuery.createCriteria().andStationCodeEqualTo(stationCode);
		List<Station> stations = stationDao.selectByExample(stationQuery);
		Station station = stations.get(0);
		
		String areaCode = station.getAreaCode();
		AreaQuery areaQuery = new AreaQuery();
		areaQuery.createCriteria().andAreaCodeEqualTo(areaCode);
		List<Area> area = areaDao.selectByExample(areaQuery);
		station.setArea(area.get(0)); //油站关联地区对象
		
		String stationLevelCode = station.getStationLevelCode();
		StationLevelQuery stationLevelQuery = new StationLevelQuery();
		stationLevelQuery.createCriteria().andStationLevelCodeEqualTo(stationLevelCode);
		List<StationLevel> stationLevel = stationLevelDao.selectByExample(stationLevelQuery);
		station.setStationLevel(stationLevel.get(0)); //油站关联油站星级对象
		
		return station;
		
	}
	
	/**
	 * 
	 */
	public Station findOnlyStationByStationCode(String stationCode) {
		StationQuery stationQuery = new StationQuery();
		stationQuery.createCriteria().andStationCodeEqualTo(stationCode);
		List<Station> stationList = stationDao.selectByExample(stationQuery);
		if (stationList.size() != 0 && stationList.size() > 0) {
			return stationList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 查询所有的油站信息(包含stationTypeName)
	 */
	public List<Station> findAllStationWithStationTypeName() {
		
		return stationDao.findAllStationWithStationTypeName();
		
	}

}
