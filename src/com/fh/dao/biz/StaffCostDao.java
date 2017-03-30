package com.fh.dao.biz;

import com.fh.entity.biz.StaffCost;
import com.fh.entity.biz.StaffCostQuery;
import com.fh.entity.biz.StaffCostVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StaffCostDao {
	
	/**
	 * 根据筛选条件查询总记录数
	 * @param yearMonth	年份月份
	 * @return
	 */
	int findCountByCriteriaQuerySelf(@Param("yearMonth") String yearMonth, @Param("stationCode") String stationCode, @Param("staffName") String staffName);
	
	/**
	 * 分页查询员工成本信息列表(支持模糊查询)
	 * @param yearMonth	年份月份
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StaffCostVO> findStaffCostByPageCriteriaQuerySelf( @Param("yearMonth") String yearMonth, @Param("pageSize") int pageSize, 
			@Param("startIndex") int startIndex, @Param("stationCode") String stationCode, @Param("staffName")String staffName);
	
	/**
	 * 查询员工成本信息列表(不分页)
	 * @param yearMonth	年份月份
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	List<StaffCostVO> findStaffCostAll( @Param("stationCode") String stationCode, @Param("yearMonth") String yearMonth);
	
    int countByExample(StaffCostQuery example);

    int deleteByExample(StaffCostQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StaffCost record);

    int insertSelective(StaffCost record);

    List<StaffCost> selectByExample(StaffCostQuery example);

    StaffCost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaffCost record, @Param("example") StaffCostQuery example);

    int updateByExample(@Param("record") StaffCost record, @Param("example") StaffCostQuery example);

    int updateByPrimaryKeySelective(StaffCost record);

    int updateByPrimaryKey(StaffCost record);

    /**
     * 根据员工的身份证号查询员工成本信息
     * @param idCardCellValue
     * @return
     */
	List<StaffCost> findStaffCostByStaffIdCardAndYearMonth(@Param("idCardCellValue") String idCardCellValue,
													 @Param("yearMonth") String yearMonth,@Param("stationCode") String stationCode);

	/**
	 * 根据年月分查询员工成本信息
	 * @param yearMonth
	 */
	List<StaffCost> findStaffCostsByYearMonth(@Param("yearMonth") String yearMonth, @Param("districtCode") String districtCode);

	/**
	 * 根据年月份查询员工的成本信息数量
	 * @param yearMonth
	 * @return
	 */
	int findAllStaffCostCountByYearMonth(@Param("yearMonth") String yearMonth);
}