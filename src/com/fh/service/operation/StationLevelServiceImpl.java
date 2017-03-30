package com.fh.service.operation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StationLevelDao;
import com.fh.entity.biz.StationLevel;
import com.fh.entity.biz.StationLevelQuery;
import com.fh.entity.biz.StationTarget;

/**
 * StationLevel 业务逻辑层实现类
 * @author lijn
 *
 */
@Service
public class StationLevelServiceImpl implements StationLevelService {
	@Autowired
	private StationLevelDao stationLevelDao;
	/**
	 * 查询所有油站星级信息
	 * @param station
	 */
	@Override
	public List<StationLevel> queryAll() {
		StationLevelQuery stationLevelQuery = new StationLevelQuery();
		return stationLevelDao.selectByExample(stationLevelQuery);
	}
	/**分页查询 油站基本信息
	 * @return
	 */
	@Override
	public Page findStationLevelsByPage(Page page, String stationLevelName){
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationLevelDao.findCountByCriteriaQuery(stationLevelName);
		page.setTotalRecordsNum(totalRecordsNum);
			
		// 分页查询记录
		List<StationLevel> records = stationLevelDao.findStationLevelsByPageCriteriaQuery(stationLevelName, page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
	}
	/**添加油站信息
	 * @param station
	 */
	@Override
	public void saveOrUpdate(StationLevel stationLevel){
		if(stationLevel!=null && !"".equals(stationLevel))
		{
			if(stationLevel.getId()!=null && !"".equals(stationLevel.getId())){
				//修改
				stationLevel.setSysUpdateTime(new Date());
				stationLevelDao.updateByPrimaryKeySelective(stationLevel);
			}else{
				//新增
				stationLevel.setSysCreateTime(new Date());
				stationLevelDao.insertSelective(stationLevel);
				System.out.println("添加成功");
			}
		}
	}
	/**根据id查询油站基本信息
	 * @param id
	 * @return
	 */
	@Override
	public StationLevel queryStationLevelById(String id){
		if(id!=null && !"".equals(id)){ 
			return stationLevelDao.selectByPrimaryKey(Long.valueOf(id));
		}else{
			return null;
		}
	}
	/**根据id删除油站基本信息
	 * @param id
	 * @return
	 */
	@Override
	public void deleteStationLevelById(String id){
		stationLevelDao.deleteByPrimaryKey((Long.valueOf(id)));
	}
	
	public List<StationLevel> findByCondition(StationLevel stationLevel) {
		List<StationLevel> stationLevelList = stationLevelDao.findByCondition(stationLevel);
		return stationLevelList;
	}
	
}
