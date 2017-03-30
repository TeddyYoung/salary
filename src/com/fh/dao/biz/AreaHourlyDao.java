package com.fh.dao.biz;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.AreaHourly;
import com.fh.entity.biz.AreaHourlyQuery;

public interface AreaHourlyDao {
	/**
	 * 根据筛选条件查询总记录数
	 * @return
	 */
	int findCountByCriteriaQuery(@Param("areaCode") String areaCode, @Param("dutyCode") String dutyCode);
	
	/**
	 * 分页查询油站指标系数列表(支持模糊查询)
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<AreaHourly> findAreaHourlysByPageCriteriaQuery(@Param("areaCode") String areaCode, @Param("dutyCode") String dutyCode, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);

    int countByExample(AreaHourlyQuery example);

    int deleteByExample(AreaHourlyQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(AreaHourly record);

    int insertSelective(AreaHourly record);

    List<AreaHourly> selectByExample(AreaHourlyQuery example);

    AreaHourly selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AreaHourly record, @Param("example") AreaHourlyQuery example);

    int updateByExample(@Param("record") AreaHourly record, @Param("example") AreaHourlyQuery example);

    int updateByPrimaryKeySelective(AreaHourly record);

    int updateByPrimaryKey(AreaHourly record);
}