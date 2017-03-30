package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.District;
import com.fh.entity.biz.DistrictQuery;

/** 区域 dao
 * @author lijn
 *
 */
public interface DistrictDao {
	/**
	 * 根据筛选条件查询总记录数
	 * @param areaName 地区名称
	 * @param areaLevel 地区级别
	 * @return
	 */
	int findCountByCriteriaQuery(@Param("districtName") String districtName, @Param("districtLevel") String districtLevel);
	
	/**
	 * 分页查询地区系数列表(支持模糊查询)
	 * @param areaName 地区名称(筛选条件)
	 * @param areaLevel 地区级别(筛选条件)
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	List<District> findDistrictsByPageCriteriaQuery(@Param("districtName") String districtName, @Param("districtLevel") String districtLevel, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
    int countByExample(DistrictQuery example);

    int deleteByExample(DistrictQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictQuery example);

    District selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictQuery example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictQuery example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}