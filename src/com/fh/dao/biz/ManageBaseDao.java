package com.fh.dao.biz;

import com.fh.entity.biz.ManageBase;
import com.fh.entity.biz.ManageBaseQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ManageBaseDao {
    int countByExample(ManageBaseQuery example);

    int deleteByExample(ManageBaseQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(ManageBase record);

    int insertSelective(ManageBase record);

    List<ManageBase> selectByExample(ManageBaseQuery example);

    ManageBase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManageBase record, @Param("example") ManageBaseQuery example);

    int updateByExample(@Param("record") ManageBase record, @Param("example") ManageBaseQuery example);

    int updateByPrimaryKeySelective(ManageBase record);

    int updateByPrimaryKey(ManageBase record);
    
    /**
	 * 根据筛选条件查询总记录数
	 * @param stationCode 油站编号
	 * @param yearMonth	年份月份
	 * @return
	 */
	int findCountByCriteriaQuery(@Param("yearMonth") String yearMonth);
	
	/**
	 * 分页查询管理岗位基础信息列表(支持模糊查询)
	 * @param yearMonth	年份月份
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<ManageBase> findManageBasesByPageCriteriaQuery(@Param("yearMonth") String yearMonth, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
     * 查询当月管理岗位数据的数量
     * @param yearMonth
     * @return
     */
	int findAllManageBaseCountByYearMonth(@Param("manageBase") ManageBase manageBase);

	/**
	 * 查询当月所有管理岗位数据
	 * @param yearMonth
	 */
	List<ManageBase> findManageBaseListByYearMonth(@Param("yearMonth") String yearMonth, @Param("districtCode") String districtCode);

	/**
	 * 根据年月份分页查询当月的管理岗位数据
	 * @param yearMonth
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<ManageBase> findStarEvaByPageCriteriaQuery(@Param("manageBase") ManageBase manageBase,
			@Param("pageSize") int pageSize, 
			@Param("startIndex") int startIndex);
	
	/**
	 * 通过条件获取管理岗位数据列表
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findManageBaseListByCondition(@Param("yearMonth") String yearMonth, @Param("staffCode") String staffCode,@Param("stationCode") String stationCode);
	
	/**
	 * 获取管理岗位：油站经理列表数据
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findManageList(@Param("yearMonth") String yearMonth, @Param("districtCode") String districtCode);
	
	/**
	 * 获取管理岗位：油站会计列表数据
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findBursarList(@Param("yearMonth") String yearMonth, @Param("districtCode") String districtCode);
	
	/**
	 * 获取管理岗位：兼站经理/会计列表数据
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findPartList(@Param("yearMonth") String yearMonth, @Param("districtCode") String districtCode);
    
}