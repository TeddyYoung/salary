package com.fh.dao.biz;

import com.fh.entity.biz.Area;
import com.fh.entity.biz.AreaQuery;
import com.fh.entity.biz.Duty;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AreaDao {
    int countByExample(AreaQuery example);

    int deleteByExample(AreaQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaQuery example);

    Area selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaQuery example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaQuery example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
    /**
	 * 根据筛选条件查询总记录数
	 * @param areaName 地区名称
	 * @param areaLevel 地区级别
	 * @return
	 */
	int findCountByCriteriaQuery(@Param("areaName") String areaName, @Param("areaLevel") String areaLevel);
	
	/**
	 * 分页查询地区系数列表(支持模糊查询)
	 * @param areaName 地区名称(筛选条件)
	 * @param areaLevel 地区级别(筛选条件)
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	List<Duty> findAreasByPageCriteriaQuery(@Param("areaName") String areaName, @Param("areaLevel") String areaLevel, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
}