package com.fh.dao.biz;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTargetQuery;

public interface StationTargetDao {
    int countByExample(StationTargetQuery example);

    int deleteByExample(StationTargetQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StationTarget record);

    int insertSelective(StationTarget record);

    List<StationTarget> selectByExample(StationTargetQuery example);

    StationTarget selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StationTarget record, @Param("example") StationTargetQuery example);

    int updateByExample(@Param("record") StationTarget record, @Param("example") StationTargetQuery example);

    int updateByPrimaryKeySelective(StationTarget record);

    int updateByPrimaryKey(StationTarget record);
    
    /**
	 * 根据筛选条件查询总记录数
	 * @param stationCode 
	 * @param yearMonth	年份月份
	 * @return
	 */
	int findCountByCriteriaQuery(@Param("stationCode") String stationCode, @Param("yearMonth") String yearMonth);
	
	/**
	 * 分页查询油站指标系数列表(支持模糊查询)
	 * @param stationCode 
	 * @param yearMonth	年份月份
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findStationTargetsByPageCriteriaQuery(@Param("stationCode") String stationCode, 
															  @Param("yearMonth") String yearMonth, 
															  @Param("pageSize") int pageSize, 
															  @Param("startIndex") int startIndex);
	
	/**
     * 判读带条件进来的记录数
     * @param yearMonth 年月条件
     * @return
     */
	int findStoreCountByCriteriaQuery(@Param("yearMonth") String yearMonth);

	/**
	 * 根据年月分页查询便利店考核记录
	 * @param yearMonth
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findStoresByPageCriteriaQuery(@Param("yearMonth") String yearMonth, 
													  @Param("pageSize") int pageSize, 
													  @Param("startIndex") int startIndex);

	/**
	 * 查询上个月的所有便利店考核记录
	 * @param yearMonth 上个月日期时间
	 * @return
	 */
	List<StationTarget> findAllStoreCheckByYearMonth(@Param("yearMonth") String yearMonth);

	/**
	 * 根据年月分页查询星级评测记录
	 * @param yearMonth
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findStarEvaluatingByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
															  @Param("pageSize") int pageSize, 
															  @Param("startIndex") int startIndex);

	/**
	 *  查询上个月的所有星级评测记录
	 * @param yearMonth
	 * @return
	 */
	List<StationTarget> findAllStarevaluatingByYearMonth(@Param("yearMonth") String yearMonth);

	/**
	 * 根据年月分页查询油站基础信息记录
	 * @param yearMonth
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findOilBaseInfoByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
														   @Param("pageSize") int pageSize, 
														   @Param("startIndex") int startIndex);

	/**
	 * 查询上个月的所有油站基础信息记录
	 * @param yearMonth
	 * @return
	 */
	List<StationTarget> findAllOilBaseInfoByYearMonth(@Param("yearMonth") String yearMonth);

	/**
	 * 分页查询油站基础数据, 支持按年月过滤查询
	 * @param yearMonth 年月条件
	 * @param pageSize 
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findOilBaseDataByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
														   @Param("pageSize") int pageSize, 
														   @Param("startIndex") int startIndex);

	/**
	 * 根据年月份筛选条件查询符合条件的记录
	 */
	List<StationTarget> findAllStationTargetsByYearMonth(@Param("yearMonth") String yearMonth);

	/**
	 * 根据年月份查询符合筛选条件的记录数
	 */
	int findStationTargetsCountByYearMonth(@Param("yearMonth") String yearMonth);

	/**
	 * 根据年月份和所属区域名称查询符合筛选条件的记录数
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	int findStarEvaCountByCriteriaQuery(@Param("yearMonth") String yearMonth, 
										@Param("districtCode") String districtCode);

	/**
	 * 分页查询油站基础数据, 支持按年月过滤查询和按区域名称
	 * @param yearMonth
	 * @param districtCode
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findStarEvaByPageCriteriaQuery(@Param("yearMonth") String yearMonth, 
													   @Param("districtCode") String districtCode, 
													   @Param("pageSize") int pageSize, 
													   @Param("startIndex") int startIndex);

	/**
	 * 根据区域查询上月所有星级评测信息
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	List<StationTarget> findAllStarevaluatingByYearMonthAndDistrictCode(@Param("yearMonth") String yearMonth, 
																		@Param("districtCode") String districtCode);

	int findStoreCheckCountByCriteriaQuery(@Param("yearMonth") String yearMonth, 
										   @Param("districtCode") String districtCode);

	List<StationTarget> findStoreCheckByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
														  @Param("districtCode") String districtCode, 
														  @Param("pageSize") int pageSize, 
														  @Param("startIndex") int startIndex);

	List<StationTarget> findAllStoreCheckByYearMonthAndDistrictCode(@Param("yearMonth") String yearMonth, 
																	@Param("districtCode") String districtCode);

	int findOilBaseInfoCountByCriteriaQuery(@Param("yearMonth") String yearMonth, 
											@Param("districtCode") String districtCode);

	List<StationTarget> findOilBaseInByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
				                                           @Param("districtCode") String districtCode,
				                                           @Param("pageSize") int pageSize, 
				                                           @Param("startIndex") int startIndex);

	List<StationTarget> findAllOilBaseInfoByYearMonthAndDistrictCode(@Param("yearMonth") String yearMonth, 
																	 @Param("districtCode") String districtCode);
	
	List<StationTarget> findStationTargetByIds(@Param("ids") String ids);

	/**
	 * 根据月份查询油站基础数据信息
	 * (依照油站基础数据Excel中的字段来查询)
	 */
	List<StationTarget> findStationBaseDataByYearMonth(@Param("yearMonth") String yearMonth, @Param("districtCode") String districtCode);

	/**
	 * 
	 * @param yearMonth
	 * @param districtCode
	 * @return
	 */
	int findBoarderSubsidiesCountByCriteriaQuery(@Param("stationTarget") StationTarget stationTarget);

	/**
	 * 
	 * @param yearMonth
	 * @param districtCode
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StationTarget> findBoarderSubsidiesByPageCriteriaQuery(@Param("stationTarget") StationTarget stationTarget, 
															    @Param("pageSize") int pageSize, 
															    @Param("startIndex") int startIndex);
	
	/**
	 * 根据条件查找油站基础数据
	 * @param stationTarget
	 * @return
	 */
	public List<StationTarget> findByCondition(StationTarget stationTarget);
	
}