package com.fh.service.masterdata;

import java.util.List;

import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.vo.ResultVO;

/**
 * 油站指标系数维护 Service
 * @author lijn
 *
 */
public interface StationTargetService {

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 当前页
	 * @param stationTargetName 油站指标名称
	 * @param stationTargetLevel 油站指标级别
	 * @return
	 */
	Page findStationTargetsByPage(Page page, String stationTargetName, String stationTargetLevel);

	/**
	 * 修改或新增油站指标系数记录
	 * @param stationTarget
	 */
	public void saveOrUpdate(List<StationTarget> stationTargetList);
	
	/**
	 * 修改或新增油站指标系数记录
	 * @param stationTarget
	 */
	public void saveOrUpdateStationTarget(StationTarget stationTarget);

	/**
	 * 根据油站指标系数id查询出对应的记录
	 * @param stationTargetId
	 * @return
	 */
	public StationTarget findStationTargetById(String stationTargetId);
	
	/**
	 * 根据油站指标系数编号查询出对应的记录
	 * @param stationCode
	 * @return
	 */
	public List<StationTarget> findStationTargetByStationCode(String stationCode);
	
	/**
	 * 根据油站指标系数ids查询出对应的记录
	 * @param stationTargetId
	 * @return
	 */
	public List<StationTarget> findStationTargetByIds(String ids);

	/**
	 * 根据油站指标系数id删除对应的记录
	 * @param stationTargetId
	 */
	public void delete(String stationTargetId);
	
	/**
	 * 根据年月份查询符合筛选条件的记录数
	 * @param yearMonth 年月份筛选条件
	 */
	public int findStationTargetsCountByYearMonth(String yearMonth);

	/**
	 * 根据年月份筛选条件查询符合条件的记录
	 */
	List<StationTarget> findAllStationTargetsByYearMonth(String yearMonth);
	
	
	/**
	 * 查询全部
	 */
	List<StationTarget> queryAll();
	
	/** 根据年月份 和 油站编号 查询 符合条件的记录
	 * @param stationCodeJson 油站编号
	 * @param yearMonthJson  年月份
	 * @return
	 */
	StationTarget findStationTargetByStationCodeAndYearMonth(String stationCodeJson,String yearMonthJson);

	/**
	 * 通过statinCode查出对应的StationTarget, 
	 * 如果有, 则UPDATE到数据库;
	 * 如果没有, 则INSERT到数据库;
	 * @param stationCode
	 */
	public void findAndComparisonStationTargetByStationCode(List<StationTarget> excelStationTargetList);

	/**
	 * DELETE相应月份的所有记录, 再将Excel中的全部记录INSERT进去
	 * @param excelStationTargetList Excel中全部的记录
	 * @param yearMonth 制定月份
	 * @return 
	 */
	public ResultVO updateStationTargetByStationCode(List<StationTarget> excelStationTargetList, String yearMonth)
			throws BizException ;

	/**
	 * 根据月份查询油站基础数据信息
	 * (依照油站基础数据Excel中的字段来查询)
	 */
	public List<StationTarget> findStationBaseDataByYearMonth(String yearMonth, String districtCode);
	
	/**
	 * 根据条件查询油站基础数据信息
	 */
	public List<StationTarget> findByCondition(StationTarget stationTarget);
	
	/**
	 * 导入数据
	 * @param stationTargetList
	 * @return 
	 */
	public ResultVO insertAllByYearMonth(List<StationTarget> stationTargetList) throws Exception;

}
