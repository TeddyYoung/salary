package com.fh.service.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.dao.biz.LossBonusDao;
import com.fh.entity.biz.LossBonus;
import com.fh.entity.biz.Staff;
import com.fh.service.station.StaffService;

/**
 * 油品损耗奖金 Service实现类
 * 
 * @author zhoujj
 */
@Service("lossBonusService")
public class LossBonusServiceImpl implements LossBonusService {

	@Autowired
	private LossBonusDao lossBonusDao;

	@Autowired
	private StaffService staffService;

	/**
	 * 新增
	 * 
	 * @param lossBonusAmt
	 * @throws Exception
	 */
	public void save(LossBonus lossBonus) throws Exception {
		this.lossBonusDao.save(lossBonus);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Long id) throws Exception {
		this.lossBonusDao.delete(id);
	}

	/**
	 * 修改
	 * 
	 * @param lossBonusAmt
	 * @throws Exception
	 */
	public void update(LossBonus lossBonus) throws Exception {
		this.lossBonusDao.update(lossBonus);
	}

	/**
	 * 查看
	 * 
	 * @param id
	 * @throws Exception
	 */
	public LossBonus get(Long id) throws Exception {
		return (LossBonus) this.lossBonusDao.get(id);
	}

	/**
	 * 查询列表 - 分页
	 * 
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, LossBonus lossBonus) throws Exception {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = lossBonusDao.queryCount(lossBonus);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<LossBonus> records = lossBonusDao.queryPage(lossBonus,
				page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
	}

	/**
	 * 查询列表 - 不分页
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<LossBonus> queryList(LossBonus lossBonus) throws Exception {
		List<LossBonus> records = lossBonusDao.queryList(lossBonus);
		return records;
	}

	/**
	 * 批量INSERT管理岗位数据
	 * @throws BizException 
	 */
	public void insertAllByYearMonth(List<LossBonus> lossBonusList) throws BizException {

		for (LossBonus lossBonus : lossBonusList) {
			String staffCode = lossBonus.getStaffCode();
			String yearMonth = lossBonus.getYearMonth();
			String stationCode = lossBonus.getStationCode();
			LossBonus lossBonusTemp = new LossBonus();
			lossBonusTemp.setStaffCode(staffCode);
			lossBonusTemp.setYearMonth(yearMonth);
			// lossBonusTemp.setStaffName(staffName);
			lossBonusTemp.setStationCode(stationCode);
			lossBonusTemp.setType(lossBonus.getType());

			Staff staff = staffService.queryStaffByStaffCode(staffCode,
					stationCode);
			if (staff == null) {
				throw new BizException("员工不存在，请检查油站编号：" + stationCode
						+ ",员工编号：" + staffCode);
			}
			// 通过员工编号和月份获取管理岗位数据
			List<LossBonus> lossBonusListTemp = this.lossBonusDao
					.queryList(lossBonusTemp);
			if (lossBonusListTemp != null && lossBonusListTemp.size() > 0) {
				lossBonusTemp = lossBonusListTemp.get(0);
				if (lossBonus.getLossBonusAmt() != null) {
					lossBonusTemp.setLossBonusAmt(lossBonus.getLossBonusAmt());
				}
				if (lossBonus.getOtherBonusAmt() != null) {
					lossBonusTemp
							.setOtherBonusAmt(lossBonus.getOtherBonusAmt());
				}
				if (lossBonus.getStationCode() != null) {
					lossBonusTemp.setStationCode(lossBonus.getStationCode());
				}
				lossBonusDao.update(lossBonusTemp);
			} else {
				lossBonusDao.save(lossBonus);
			}
		}
	}
}
