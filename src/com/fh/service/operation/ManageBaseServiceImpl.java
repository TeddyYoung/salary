package com.fh.service.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.dao.biz.DutyDao;
import com.fh.dao.biz.ManageBaseDao;
import com.fh.dao.biz.StaffDao;
import com.fh.entity.biz.Duty;
import com.fh.entity.biz.DutyQuery;
import com.fh.entity.biz.ManageBase;
import com.fh.entity.biz.ManageBaseQuery;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffQuery;
import com.fh.entity.vo.ResultVO;
import com.fh.service.masterdata.DutyService;

/**
 * 油站指标系数维护 Service实现类
 * 
 * @author lijn
 *
 */
@Service
public class ManageBaseServiceImpl implements ManageBaseService {

	@Autowired
	private ManageBaseDao manageBaseDao;

	@Autowired
	private StaffDao staffDao;

	@Autowired
	private DutyDao dutyDao;

	@Autowired
	private DutyService dutyService;

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	@Deprecated
	public Page findManageBasesByPage(Page page, String yearMonth) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = manageBaseDao.findCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<ManageBase> records = manageBaseDao
				.findManageBasesByPageCriteriaQuery(yearMonth,
						page.getPageSize(), page.getStartIndex());
		if (records != null && records.size() > 0) {
			for (ManageBase manageBase : records) {
				StaffQuery staffQuery = new StaffQuery();
				staffQuery.createCriteria().andStaffCodeEqualTo(
						manageBase.getStaffCode());
				List<Staff> staffList = staffDao.selectByExample(staffQuery);
				if (staffList != null && staffList.size() > 0) {
					Staff staff = staffList.get(0);
					DutyQuery dutyQuery = new DutyQuery();
					dutyQuery.createCriteria().andDutyCodeEqualTo(
							staff.getDutyCode());
					List<Duty> dutyList = dutyDao.selectByExample(dutyQuery);
					if (dutyList != null && dutyList.size() > 0) {
						staff.setDuty(dutyList.get(0));
					}
					manageBase.setStaff(staff);
				}
			}
		}
		page.setRecords(records);
		return page;

	}

	/**
	 * 修改或新增油站指标系数记录
	 */
	public void saveOrUpdate(ManageBase manageBase) {

		if (null != manageBase.getId() && !"".equals(manageBase.getId())) {
			manageBase.setSysUpdateTime(new Date());
			manageBaseDao.updateByPrimaryKey(manageBase);
		} else {
			manageBase.setSysCreateTime(new Date());
			manageBaseDao.insertSelective(manageBase);
		}

	}

	/**
	 * 根据油站指标系数id查询出对应的记录
	 */
	public ManageBase findManageBaseById(String manageBaseId) {

		return manageBaseDao.selectByPrimaryKey(Long.parseLong(manageBaseId));

	}

	/**
	 * 根据油站指标系数id删除对应的记录
	 */
	public void delete(String manageBaseId) {

		manageBaseDao.deleteByPrimaryKey(Long.parseLong(manageBaseId));

	}

	/**
	 * 根据年月份删除相应月份的全部记录
	 */
	public void deleteAllByYearMonth(String yearMonth) {

		ManageBaseQuery manageBaseQuery = new ManageBaseQuery();
		manageBaseQuery.createCriteria().andYearMonthEqualTo(yearMonth);
		manageBaseDao.deleteByExample(manageBaseQuery);

	}

	/**
	 * 批量INSERT管理岗位数据
	 * 
	 * @throws BizException
	 */
	public ResultVO insertAllByYearMonth(List<ManageBase> manageBaseList,boolean submit)
			throws BizException {
		ResultVO resultVO = new ResultVO();
		String failMes = "";
		int fail = 0;
		List<ManageBase> updateList = new ArrayList<ManageBase>();

		for (ManageBase manageBase : manageBaseList) {
			String staffCode = manageBase.getStaffCode();
			String stationCode = manageBase.getStationCode();

			Staff staff = new Staff();
			staff.setStaffCode(staffCode);
			staff.setStationCode(manageBase.getStationCode());
			List<Staff> staffList = this.staffDao.getStaffByCondition(staff);
			if (staffList == null || staffList.size() == 0) {
				fail++;
				failMes = failMes + "\n" + "员工不存在,请检查油站编号:" + stationCode
						+ ",员工编号：" + staffCode;
				// throw new BizException("员工不存在,请检查油站编号:" + stationCode
				// + ",员工编号：" + staffCode);
				continue;
			}
			staff = staffList.get(0);
			staffCode = staff.getStaffCode();
			String staffName = staff.getStaffName();
			manageBase.setStaffName(staffName);
			manageBase.setStaffCode(staffCode);
			manageBase
					.setDutyName(dutyService.getDutyName(staff.getDutyCode()));

			updateList.add(manageBase);
		}

		if (fail == 0 && submit) {
			try {
				for (ManageBase manageBase : updateList) {
					ManageBase manageBaseTemp = new ManageBase();
					// 通过员工编号和月份获取管理岗位数据
					manageBaseTemp.setStaffCode(manageBase.getStaffCode());
					manageBaseTemp.setYearMonth(manageBase.getYearMonth());
					manageBaseTemp.setStationCode(manageBase.getStationCode());
					manageBaseTemp = this
							.getManageBaseByCondition(manageBaseTemp);
					if (manageBaseTemp != null) {
						manageBaseTemp.setStaffName(manageBase.getStaffName());
						manageBaseTemp.setNewDutyName(manageBase
								.getNewDutyName());
						manageBaseTemp.setDutyName(manageBase.getDutyName());
						manageBaseTemp.setPhoneCost(manageBase.getPhoneCost());
						manageBaseTemp.setJobSubsidies(manageBase
								.getJobSubsidies());
						manageBaseTemp.setPerformanceCoefficient(manageBase
								.getPerformanceCoefficient());
						manageBaseTemp.setDutyName(manageBase.getDutyName());
						manageBaseTemp.setBonusBase(manageBase.getBonusBase());
						manageBaseTemp.setEducationCost(manageBase
								.getEducationCost());
						manageBaseDao
								.updateByPrimaryKeySelective(manageBaseTemp);
					} else {
						manageBaseDao.insertSelective(manageBase);
					}
				}
			} catch (Exception e) {
				throw new BizException(e.getMessage());
			}
		}
		resultVO.setFail(fail);
		resultVO.setFailMes(failMes);
		return resultVO;

	}

	/**
	 * 查询当月管理岗位数据的数量
	 */
	public int findAllManageBaseCountByYearMonth(String yearMonth) {

		if (null != yearMonth && !"".equals(yearMonth)) {
			ManageBase manageBase = new ManageBase();
			manageBase.setYearMonth(yearMonth);
			return manageBaseDao.findAllManageBaseCountByYearMonth(manageBase);
		} else {
			throw new RuntimeException("The yearMonth is Null!");
		}

	}

	/**
	 * 查询当月所有管理岗位数据
	 */
	public List<ManageBase> findManageBaseListByYearMonth(String yearMonth,
			String districtCode) {

		if (null != yearMonth && !"".equals(yearMonth)) {
			return manageBaseDao.findManageBaseListByYearMonth(yearMonth,
					districtCode);
		} else {
			throw new RuntimeException("The yearMonth is Null!");
		}

	}

	/**
	 * 根据年月份分页查询当月的管理岗位数据
	 */
	public Page findManageBaseByPage(Page page, ManageBase manageBase) {

		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = manageBaseDao
				.findAllManageBaseCountByYearMonth(manageBase);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<ManageBase> records = manageBaseDao
				.findStarEvaByPageCriteriaQuery(manageBase, page.getPageSize(),
						page.getStartIndex());
		page.setRecords(records);
		return page;

	}

	public ManageBase getManageBaseByCondition(ManageBase manageBase) {
		List<ManageBase> manageBaseList = this.manageBaseDao
				.findManageBaseListByCondition(manageBase.getYearMonth(),
						manageBase.getStaffCode(), manageBase.getStationCode());
		if (manageBaseList != null && manageBaseList.size() > 0) {
			return manageBaseList.get(0);
		}
		return null;
	}

	/**
	 * 查询当月管理岗位：油站经理数据列表
	 */
	public List<ManageBase> findManageList(String yearMonth, String districtCode) {
		return manageBaseDao.findManageList(yearMonth, districtCode);
	}

	/**
	 * 查询当月管理岗位：油站会计数据列表
	 */
	public List<ManageBase> findBursarList(String yearMonth, String districtCode) {
		return manageBaseDao.findBursarList(yearMonth, districtCode);
	}

	/**
	 * 查询当月管理岗位：兼站经理/会计数据列表
	 */
	public List<ManageBase> findPartList(String yearMonth, String districtCode) {
		return manageBaseDao.findPartList(yearMonth, districtCode);
	}

}
