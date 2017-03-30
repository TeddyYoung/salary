package com.fh.service.station;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StaffCost;
import com.fh.entity.biz.StaffCostVO;

/**
 * 员工成本信息Service接口
 * @author lijn
 *
 */
public interface StaffCostService {

	/**
	 * 分页查询员工成本信息信息, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param date 年月时间
	 * @return 分装好员工成本信息信息的分页对象
	 */
	public Page findStaffCostByPage(Page page, String yearMonth, String stationCode, String staffName);
	
	
	/**
	 * 查询上个月的所有员工成本信息记录
	 * @param yearMonth 上个月日期
	 * @return
	 */
	public List<StaffCostVO> findAllStaffCostByYearMonth(String stationCode, String yearMonth);


	/**
	 * 批量保存或修改员工成本信息记录
	 * @param StaffCostList
	 */
	public void saveOrUpdateStaffCost(List<StaffCost> StaffCostList);

	/**
	 * 根据年月份 查询出当月所有的员工成本记录
	 * @param yearMonth 年月份
	 * @return
	 */
	public List<StaffCost> findAllStaffCostsByYearMonth(String yearMonth);

	/**
	 * 根据员工的身份证号查询员工成本信息
	 * @param idCardCellValue 员工身份证号
	 * @return
	 */
	public StaffCost findStaffCostByStaffIdCardAndYearMonth(String idCardCellValue, String yearMonth,String stationCode);

	/**
	 * 更新
	 */
	public void update(StaffCost staffCost);

	/**
	 * 根据年月分查询员工成本信息
	 * @param yearMonth 年月份
	 * @return
	 */
	public List<StaffCost> findStaffCostsByYearMonth(String yearMonth, String districtCode);

	/**
	 * 根据年月份查询员工的成本信息数量
	 * @param yearMonth 年月份
	 * @return
	 */
	public int findAllStaffCostCountByYearMonth(String yearMonth);
	
	public void save(StaffCost staffCost);
	
}
