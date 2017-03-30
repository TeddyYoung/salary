package com.fh.dao.biz;

import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTrial;
import com.fh.entity.biz.StationTrialQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StationTrialDao {
    int countByExample(StationTrialQuery example);

    int deleteByExample(StationTrialQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StationTrial record);

    int insertSelective(StationTrial record);

    List<StationTrial> selectByExample(StationTrialQuery example);

    StationTrial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StationTrial record, @Param("example") StationTrialQuery example);

    int updateByExample(@Param("record") StationTrial record, @Param("example") StationTrialQuery example);

    int updateByPrimaryKeySelective(StationTrial record);

    int updateByPrimaryKey(StationTrial record);

    /**
     * 根据年份月份筛选符合记录的数量
     * @param yearMonth 年份月份筛选条件
     */
	int findStationTrialCountByCriteriaQuery(@Param("yearMonth") String yearMonth);

	/**
	 * 根据年份月份筛选符合条件的记录
	 * @param yearMonth 年份月份筛选条件
	 */
	List<StationTarget> findStationTrialsByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
															 @Param("pageSize") int pageSize, 
															 @Param("startIndex") int startIndex);

}