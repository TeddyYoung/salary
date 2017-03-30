package com.fh.dao.biz;

import com.fh.entity.biz.Station;
import com.fh.entity.biz.StationQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StationDao {

    int deleteByExample(StationQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Station record);

    int insertSelective(Station record);

    List<Station> selectByExample(StationQuery example);

    Station selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Station record, @Param("example") StationQuery example);

    int updateByExample(@Param("record") Station record, @Param("example") StationQuery example);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
    
    /**
     * 根据条件查询出符合条件的总记录数
     * @return
     */
    int findCountByCriteriaQuery(@Param("stationName") String stationName
    		,@Param("stationStatus") String stationStatus,@Param("districtCode") String districtCode);
    
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param pageSize 每页显示的记录数
     * @param startIndex 每页起始记录的索引
     * @return
     */
    List<Station> findStationsByPageCriteriaQuery(@Param("stationName") String stationName,
    		@Param("stationStatus") String stationStatus,
    		@Param("districtCode") String districtCode,
    		@Param("pageSize") int pageSize, 
    		@Param("startIndex") int startIndex);
    
    int countByExample(StationQuery example);

    /**
     * 查询所有的油站信息(包含stationTypeName)
     * @return
     */
	List<Station> findAllStationWithStationTypeName();
    
}