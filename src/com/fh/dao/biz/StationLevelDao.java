package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.StationLevel;
import com.fh.entity.biz.StationLevelQuery;
import com.fh.entity.biz.StationTarget;

/** 油站星级 dao
 * @author lijn
 *
 */
public interface StationLevelDao {
    /**
     * 根据条件查询出符合条件的总记录数
     * @return
     */
    int findCountByCriteriaQuery(@Param("stationLevelName") String stationLevelName);
    
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param pageSize 每页显示的记录数
     * @param startIndex 每页起始记录的索引
     * @return
     */
    List<StationLevel> findStationLevelsByPageCriteriaQuery(@Param("stationLevelName") String stationLevelName,@Param("pageSize") int pageSize, @Param("startIndex") int startIndex);

    int countByExample(StationLevelQuery example);

    int deleteByExample(StationLevelQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StationLevel record);

    int insertSelective(StationLevel record);

    List<StationLevel> selectByExample(StationLevelQuery example);

    StationLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StationLevel record, @Param("example") StationLevelQuery example);

    int updateByExample(@Param("record") StationLevel record, @Param("example") StationLevelQuery example);

    int updateByPrimaryKeySelective(StationLevel record);

    int updateByPrimaryKey(StationLevel record);
    
    /**
	 * 根据条件查找油站基础数据
	 * @param stationLevel
	 * @return
	 */
	public List<StationLevel> findByCondition(StationLevel stationLevel);
}