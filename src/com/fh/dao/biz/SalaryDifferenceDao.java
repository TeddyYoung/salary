package com.fh.dao.biz;

import com.fh.entity.biz.SalaryDifference;
import com.fh.entity.biz.SalaryDifferenceQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalaryDifferenceDao {
    int countByExample(SalaryDifferenceQuery example);

    int deleteByExample(SalaryDifferenceQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SalaryDifference record);

    int insertSelective(SalaryDifference record);

    List<SalaryDifference> selectByExample(SalaryDifferenceQuery example);

    SalaryDifference selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalaryDifference record, @Param("example") SalaryDifferenceQuery example);

    int updateByExample(@Param("record") SalaryDifference record, @Param("example") SalaryDifferenceQuery example);

    int updateByPrimaryKeySelective(SalaryDifference record);

    int updateByPrimaryKey(SalaryDifference record);
    
    /**
     * 根据员工姓名和年月份查询符合条件的记录数
     * @param staffName 员工姓名
     * @param yearMonth 年月份
     */
	int findSalaryDifferenceCountByCriteriaQuery(@Param("staffName") String staffName, @Param("yearMonth") String yearMonth);

	/**
	 * 根据员工姓名和年月份查询符合条件的记录
	 * @param staffName 员工姓名
	 * @param yearMonth 年月份
	 * @param pageSize 每页显示的记录数
	 * @param startIndex 每页开始显示记录的索引
	 */
	List<SalaryDifference> findSalaryDifferencesByPageCriteriaQuery(@Param("staffName") String staffName, 
																    @Param("yearMonth") String yearMonth, 
																    @Param("subOrganiseIdStr") String subOrganiseIdStr,
																	@Param("pageSize") int pageSize, 
																	@Param("startIndex") int startIndex);

	/**
	 * 查询上个月的薪资差异记录
	 * @param yearMonth 上个月月份
	 */
	List<SalaryDifference> findSalaryDifferenceByYearMonth(@Param("yearMonth") String yearMonth);

	/**
	 * 根据油站编号查询该油站下所有的员工(包含员工所属的油站名称)
	 * @param organiseId
	 * @return
	 */
	List<SalaryDifference> findStaffListWithStationNameByStationCode(@Param("organiseId") String organiseId,
																	 @Param("yearMonth") String yearMonth);

	/**
	 * 根据员工编号查询出对应的薪资差异记录(包含员工所属的油站名称)
	 * @param staffCode
	 * @return
	 */
	SalaryDifference findSalaryDifferenceWithStationNameByStaffCode(@Param("staffCode") String staffCode);

	/**
	 * 查询biz_salary_difference表中是否有approvalStatus字段为 "1" 的记录
	 * @return
	 */
	public int findSalaryDifferenceCountByApprovalStatus(@Param("stationCode") String stationCode);
	
	
	List<SalaryDifference> findByStaffCodes(@Param("stationCode") String stationCode,
			@Param("yearMonth") String yearMonth,@Param("staffCodes") String[] staffCodes);
    
}