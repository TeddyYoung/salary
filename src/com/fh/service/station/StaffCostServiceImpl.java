package com.fh.service.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.StaffCostDao;
import com.fh.entity.biz.StaffCost;
import com.fh.entity.biz.StaffCostQuery;
import com.fh.entity.biz.StaffCostVO;

/**
 * 员工成本信息Service实现类
 * 
 * @author lijn
 *
 */
@Service
public class StaffCostServiceImpl implements StaffCostService {

	@Autowired
	private StaffCostDao staffCostDao;

	public Page findStaffCostByPage(Page page, String yearMonth,
			String stationCode, String staffName) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = staffCostDao.findCountByCriteriaQuerySelf(
				yearMonth, stationCode, staffName);
		page.setTotalRecordsNum(totalRecordsNum);
		//String[] stationCodes = stationCode.split(",");
		// 分页查询记录
		List<StaffCostVO> records = staffCostDao
				.findStaffCostByPageCriteriaQuerySelf(yearMonth,
						page.getPageSize(), page.getStartIndex(), stationCode,
						staffName);
		page.setRecords(records);
		return page;

	}

	/**
	 * 查询上个月的所有员工成本信息记录
	 */
	public List<StaffCostVO> findAllStaffCostByYearMonth(String stationCode,
			String yearMonth) {

		List<StaffCostVO> StaffCostVOs = staffCostDao.findStaffCostAll(
				stationCode, yearMonth);
		return StaffCostVOs;

	}

	/**
	 * 批量保存或修改员工成本信息记录
	 */
	public void saveOrUpdateStaffCost(List<StaffCost> StaffCostList) {

		for (StaffCost StaffCost : StaffCostList) {
			if (null != StaffCost.getId() && !"".equals(StaffCost.getId())) {
				staffCostDao.updateByPrimaryKeySelective(StaffCost);
			} else {
				staffCostDao.insertSelective(StaffCost);
			}
		}

	}

	public void save(StaffCost staffCost) {

		staffCostDao.insertSelective(staffCost);

	}

	/**
	 * 根据年月份 查询出当月所有的员工成本记录
	 */
	public List<StaffCost> findAllStaffCostsByYearMonth(String yearMonth) {

		if (null != yearMonth && !"".equals(yearMonth)) {
			StaffCostQuery staffCostQuery = new StaffCostQuery();
			staffCostQuery.createCriteria().andStaffCostYearMonthEqualTo(
					yearMonth);
			List<StaffCost> staffCostList = staffCostDao
					.selectByExample(staffCostQuery);
			return staffCostList;
		} else {
			throw new RuntimeException(
					"Amazing! Why the 'yearMonth' is null or ''!");
		}

	}

	/**
	 * 根据员工的身份证号查询员工成本信息
	 */
	public StaffCost findStaffCostByStaffIdCardAndYearMonth(
			String idCardCellValue, String yearMonth,String stationCode) {
		// modify by yangjj
		// StaffCost staffCost = new StaffCost();
		StaffCost staffCost = null;
		if (null != idCardCellValue && !"".equals(idCardCellValue)) {
			List<StaffCost> staffCostList = staffCostDao
					.findStaffCostByStaffIdCardAndYearMonth(idCardCellValue,
							yearMonth,stationCode);
			if (staffCostList != null && staffCostList.size() > 0) {
				staffCost = staffCostList.get(0);
			}
			return staffCost;
		} else {
			throw new RuntimeException(
					"Sorry! The idCardCellValue is null or ''!Please check your Controller code!");
		}

	}

	/**
	 * 更新
	 */
	public void update(StaffCost staffCost) {

		if (null != staffCost) {
			staffCostDao.updateByPrimaryKeySelective(staffCost);
		}

	}

	/**
	 * 根据年月分查询员工成本信息
	 */
	public List<StaffCost> findStaffCostsByYearMonth(String yearMonth,
			String districtCode) {

		if (null != yearMonth && !"".equals(yearMonth)) {
			return staffCostDao.findStaffCostsByYearMonth(yearMonth,
					districtCode);
		} else {
			return null;
		}

	}

	/**
	 * 根据年月份查询员工的成本信息数量
	 */
	public int findAllStaffCostCountByYearMonth(String yearMonth) {

		if (null != yearMonth && !"".equals(yearMonth)) {
			return staffCostDao.findAllStaffCostCountByYearMonth(yearMonth);
		} else {
			return 0;
		}

	}

}
