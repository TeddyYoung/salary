package com.fh.service.masterdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.controller.salarymanagement.StationTrialController;
import com.fh.dao.biz.StationTargetDao;
import com.fh.entity.biz.Station;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTargetQuery;
import com.fh.entity.system.Parameter;
import com.fh.entity.vo.ResultVO;
import com.fh.entity.vo.SellDataSearchVO;
import com.fh.service.station.StationService;
import com.fh.service.system.ParameterService;
import com.fh.util.Constants;

/**
 * 油站指标系数维护 Service实现类
 * 
 * @author lijn
 *
 */
@Service
public class StationTargetServiceImpl implements StationTargetService {

	private static Logger log = LoggerFactory
			.getLogger(StationTargetServiceImpl.class);
	@Autowired
	private StationTargetDao stationTargetDao;

	@Autowired
	private StationService stationService;

	@Autowired
	private ParameterService parameterService;

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findStationTargetsByPage(Page page, SellDataSearchVO searchVO) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = stationTargetDao
				.findCountByCriteriaQuery(searchVO);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<StationTarget> records = stationTargetDao
				.findStationTargetsByPageCriteriaQuery(searchVO,
						page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;

	}

	/**
	 * 修改或新增油站指标系数记录
	 */
	public void saveOrUpdate(List<StationTarget> stationTargetList) {

		for (StationTarget stationTarget : stationTargetList) {
			if (stationTarget.getId() != null
					&& !"".equals(stationTarget.getId())) {
				stationTarget.setSysUpdateTime(new Date());
				stationTargetDao.updateByPrimaryKeySelective(stationTarget);
			} else {
				stationTarget.setSysCreateTime(new Date());
				stationTargetDao.insertSelective(stationTarget);
			}
		}
	}

	/**
	 * 根据油站指标系数ids查询出对应的记录
	 */
	public List<StationTarget> findStationTargetByIds(String ids) {

		return stationTargetDao.findStationTargetByIds(ids);

	}

	/**
	 * 根据油站指标系数id删除对应的记录
	 */
	public void delete(String stationTargetId) {

		stationTargetDao.deleteByPrimaryKey(Long.parseLong(stationTargetId));

	}

	/**
	 * 根据年月份筛选条件查询符合条件的记录
	 */
	public List<StationTarget> findAllStationTargetsByYearMonth(String yearMonth) {

		return stationTargetDao.findAllStationTargetsByYearMonth(yearMonth);

	}

	/**
	 * 根据年月份查询符合筛选条件的记录数
	 */
	public int findStationTargetsCountByYearMonth(String yearMonth) {

		return stationTargetDao.findStationTargetsCountByYearMonth(yearMonth);

	}

	/**
	 * 根据年月份 和 油站编号 查询 符合条件的记录
	 * 
	 * @param stationCodeJson
	 *            油站编号
	 * @param yearMonthJson
	 *            年月份
	 * @return
	 */
	public StationTarget findStationTargetByStationCodeAndYearMonth(
			String stationCodeJson, String yearMonthJson) {
		StationTargetQuery stationTargetQuery = new StationTargetQuery();
		stationTargetQuery.createCriteria()
				.andStationCodeEqualTo(stationCodeJson)
				.andYearMonthEqualTo(yearMonthJson);
		List<StationTarget> stationTargetList = stationTargetDao
				.selectByExample(stationTargetQuery);
		if (stationTargetList != null && stationTargetList.size() > 0) {
			return stationTargetList.get(0);
		} else {
			return null;
		}
	}

	public StationTarget findStationTargetById(String stationTargetId) {
		return stationTargetDao.selectByPrimaryKey(Long
				.valueOf(stationTargetId));
	}

	public void saveOrUpdateStationTarget(StationTarget stationTarget) {
		if (stationTarget != null && !"".equals(stationTarget)) {
			// 达标率上限
			String standardLimitStr = parameterService
					.getBizValue(Parameter.KEY_STANDARD_LIMIT);
			BigDecimal standardLimit = new BigDecimal(standardLimitStr);
			// 非油品达标率上限
			String nonOilStandardLimitStr = parameterService
					.getBizValue(Parameter.KEY_NON_OIL_STANDARD_LIMIT);
			BigDecimal nonOilStandardLimit = new BigDecimal(
					nonOilStandardLimitStr);
			BigDecimal oilTargetVolume = stationTarget.getOilTargetVolume();// 油品本月目标销量;
			BigDecimal oilRealVolume = stationTarget.getOilRealVolume();// 油品本月实际销量

			BigDecimal nonOilTargetVolume = stationTarget
					.getNonOilTargetVolume();// 非油品本月目标销量
			BigDecimal nonOilRealVolume = stationTarget.getNonOilRealVolume();// 非油品本月实际销量
			String isOilStandardRateArtificial = stationTarget
					.getIsOilStandardRateArtificial();
			String isNonOilStandardRateArtificial = stationTarget
					.getIsNonOilStandardRateArtificial();
			BigDecimal oilStandardRate = BigDecimal.ZERO;// 油品达标率
			BigDecimal nonOilStandardRate = BigDecimal.ZERO;// 非油品达标率
			if (Constants.YES_FLAG.equals(isOilStandardRateArtificial)) {
				oilStandardRate = stationTarget.getOilStandardRate().divide(
						new BigDecimal(100));
			} else {
				// 油品达标率 = 实际销量/目标销量，且不大于达标率上限
				if (oilRealVolume.compareTo(BigDecimal.ZERO) > 0
						&& oilTargetVolume.compareTo(BigDecimal.ZERO) > 0) {
					BigDecimal oilStandardRateTmp = oilRealVolume.divide(
							oilTargetVolume, 4, BigDecimal.ROUND_HALF_UP);
					oilStandardRate = oilStandardRateTmp
							.compareTo(standardLimit) > 0 ? standardLimit
							: oilStandardRateTmp;
				}
			}
			stationTarget.setOilStandardRate(oilStandardRate);
			if (Constants.YES_FLAG.equals(isNonOilStandardRateArtificial)) {
				nonOilStandardRate = stationTarget.getNonOilStandardRate()
						.divide(new BigDecimal(100));
			} else {
				if (nonOilRealVolume.compareTo(BigDecimal.ZERO) > 0
						&& nonOilTargetVolume.compareTo(BigDecimal.ZERO) > 0) {
					// 非油品达标率 = 实际销量/目标销量，且不大于达标率上限
					BigDecimal nonOilStandardRateTmp = nonOilRealVolume.divide(
							nonOilTargetVolume, 4, BigDecimal.ROUND_HALF_UP);
					nonOilStandardRate = nonOilStandardRateTmp
							.compareTo(nonOilStandardLimit) > 0 ? nonOilStandardLimit
							: nonOilStandardRateTmp;
				}
			}
			stationTarget.setNonOilStandardRate(nonOilStandardRate);

			if (stationTarget.getId() != null
					&& !"".equals(stationTarget.getId())) {
				stationTargetDao.updateByPrimaryKeySelective(stationTarget);
			} else {
				stationTargetDao.insertSelective(stationTarget);
			}
		}
	}

	public List<StationTarget> queryAll() {
		StationTargetQuery stationTargetQuery = new StationTargetQuery();
		return stationTargetDao.selectByExample(stationTargetQuery);
	}

	public List<StationTarget> findStationTargetByStationCode(String stationCode) {
		StationTargetQuery stationTargetQuery = new StationTargetQuery();
		stationTargetQuery.createCriteria().andStationCodeEqualTo(stationCode);
		List<StationTarget> stationTargetList = stationTargetDao
				.selectByExample(stationTargetQuery);
		if (stationTargetList.size() > 0 && stationTargetList != null) {
			return stationTargetList;
		} else {
			return null;
		}
	}

	/**
	 * 通过statinCode查出对应的StationTarget, 如果有, 则UPDATE到数据库; 如果没有, 则INSERT到数据库;
	 * 
	 * @param stationCode
	 */
	@Deprecated
	public void findAndComparisonStationTargetByStationCode(
			List<StationTarget> excelStationTargetList) {

		for (StationTarget stationTarget : excelStationTargetList) {
			StationTargetQuery stationTargetQuery = new StationTargetQuery();
			stationTargetQuery.createCriteria().andStationCodeEqualTo(
					stationTarget.getStationCode());
			List<StationTarget> stationTargetList = stationTargetDao
					.selectByExample(stationTargetQuery);
			if (stationTargetList.size() == 0) {
				stationTargetDao.insertSelective(stationTarget);
			} else {
				stationTargetDao.updateByExampleSelective(stationTarget,
						stationTargetQuery);
			}
		}

	}

	/**
	 * DELETE相应月份的所有记录, 再将Excel中的全部记录INSERT进去
	 * 
	 * @throws BizException
	 */
	public ResultVO updateStationTargetByStationCode(
			List<StationTarget> excelStationTargetList, String yearMonth,boolean submit)
			throws BizException {
		ResultVO resultVO = new ResultVO();
		int success = 0;
		int fail = 0;
		String excMes = "";
		List<Station> stationList = new ArrayList<Station>();
		List<StationTarget> updateList = new ArrayList<StationTarget>();
		for (StationTarget stationTarget : excelStationTargetList) {
			String stationCode = stationTarget.getStationCode();
			Integer stationStaffNum = stationTarget.getStationStaffNum();
			Integer stationStaffNumFloat = stationTarget
					.getStationStaffNumFloat();
			Station station = stationService
					.findOnlyStationByStationCode(stationCode);
			if (station == null) {
				fail++;
				excMes = excMes + "\n" + "油站编号填写有误:" + stationCode;
				continue;
				// throw new BizException("油站编号填写有误:" + stationCode);
			}
			if (stationStaffNum != null && stationStaffNumFloat != null) {
				station.setStationStaffNum(stationTarget.getStationStaffNum());
				station.setStationStaffNumFloat(stationTarget
						.getStationStaffNumFloat());
				stationList.add(station);
				// stationService.saveOrUpdate(station);
			}
			updateList.add(stationTarget);
			success++;
		}
		if (fail == 0 && submit) {
			for (Station station : stationList) {
				stationService.saveOrUpdate(station);
			}
			for (StationTarget stationTarget : updateList) {
				// 根据油站编号和月份获取数据，如果存在则update，不存在则insert
				List<StationTarget> stationTargetList = this.stationTargetDao
						.findByCondition(stationTarget);
				if (stationTargetList != null && stationTargetList.size() > 0) {// 更新
					StationTarget stationTargetTemp = stationTargetList.get(0);
					stationTarget.setId(stationTargetTemp.getId());
					stationTargetDao.updateByPrimaryKeySelective(stationTarget);
				} else {
					stationTargetDao.insertSelective(stationTarget);
				}
			}

		}
		resultVO.setFailMes(excMes);
		resultVO.setFail(fail);
		resultVO.setSuccess(success);
		return resultVO;
	}

	/**
	 * 根据月份查询油站基础数据信息 (依照油站基础数据Excel中的字段来查询)
	 */
	public List<StationTarget> findStationBaseDataByYearMonth(String yearMonth,
			String districtCode) {

		if (null != yearMonth && !"".equals(yearMonth)) {
			List<StationTarget> staffTargetList = stationTargetDao
					.findStationBaseDataByYearMonth(yearMonth, districtCode);
			return staffTargetList;
		} else {
			throw new RuntimeException(
					"Amazing!The yearMonth is null or ''!Please Check your Controller code!");
		}

	}

	public List<StationTarget> findByCondition(StationTarget stationTarget) {
		List<StationTarget> staffTargetList = stationTargetDao
				.findByCondition(stationTarget);
		return staffTargetList;
	}

	/**
	 * 批量INSERT管理岗位数据
	 */
	public ResultVO insertAllByYearMonth(List<StationTarget> stationTargetList)
			throws Exception {
		ResultVO resultVO = new ResultVO();
		int success = 0;
		int fail = 0;
		try {
			for (StationTarget stationTarget : stationTargetList) {
				String stationCode = stationTarget.getStationCode();
				String yearMonth = stationTarget.getYearMonth();
				StationTarget stationTargetQuery = new StationTarget();
//				Station station = stationService
//						.findOnlyStationByStationCode(stationCode);
//				if (station == null) {
//					fail++;
//					continue;
//					//throw new BizException("油站编号填写有误:" + stationCode);
//				}
				// 达标率上限
				String standardLimitStr = parameterService
						.getBizValue(Parameter.KEY_STANDARD_LIMIT);
				BigDecimal standardLimit = new BigDecimal(standardLimitStr);
				// 非油品达标率上限
				String nonOilStandardLimitStr = parameterService
						.getBizValue(Parameter.KEY_NON_OIL_STANDARD_LIMIT);
				BigDecimal nonOilStandardLimit = new BigDecimal(
						nonOilStandardLimitStr);
				BigDecimal oilTargetVolume = stationTarget.getOilTargetVolume();// 油品本月目标销量;
				BigDecimal oilRealVolume = stationTarget.getOilRealVolume();// 油品本月实际销量
				BigDecimal directSellingBonus = stationTarget
						.getDirectSellingBonus();// 经理小配
				BigDecimal nonOilTargetVolume = stationTarget
						.getNonOilTargetVolume();// 非油品本月目标销量
				BigDecimal nonOilRealVolume = stationTarget
						.getNonOilRealVolume();// 非油品本月实际销量
				BigDecimal oilStandardRate = BigDecimal.ZERO;// 油品达标率
				BigDecimal nonOilStandardRate = BigDecimal.ZERO;// 非油品达标率

				// 油品达标率 = (实际销量+经理小配)/目标销量，且不大于达标率上限
				BigDecimal oilRealVolumeTmp = oilRealVolume
						.add(directSellingBonus);
				if (oilRealVolumeTmp.compareTo(BigDecimal.ZERO) > 0
						&& oilTargetVolume.compareTo(BigDecimal.ZERO) > 0) {
					BigDecimal oilStandardRateTmp = oilRealVolumeTmp.divide(
							oilTargetVolume, 4, BigDecimal.ROUND_HALF_UP);
					oilStandardRate = oilStandardRateTmp
							.compareTo(standardLimit) > 0 ? standardLimit
							: oilStandardRateTmp;
				}
				if (nonOilRealVolume.compareTo(BigDecimal.ZERO) > 0
						&& nonOilTargetVolume.compareTo(BigDecimal.ZERO) > 0) {
					// 非油品达标率 = 实际销量/目标销量，且不大于达标率上限
					BigDecimal nonOilStandardRateTmp = nonOilRealVolume.divide(
							nonOilTargetVolume, 4, BigDecimal.ROUND_HALF_UP);
					nonOilStandardRate = nonOilStandardRateTmp
							.compareTo(nonOilStandardLimit) > 0 ? nonOilStandardLimit
							: nonOilStandardRateTmp;
				}

				stationTargetQuery.setStationCode(stationCode);
				stationTargetQuery.setYearMonth(yearMonth);

				stationTarget.setOilStandardRate(oilStandardRate);
				stationTarget.setNonOilStandardRate(nonOilStandardRate);
				stationTarget
						.setIsNonOilStandardRateArtificial(Constants.NO_FLAG);
				stationTarget.setIsOilStandardRateArtificial(Constants.NO_FLAG);
				// 通过员工编号和月份获取管理岗位数据
				List<StationTarget> stationTargetListTemp = this.stationTargetDao
						.findByCondition(stationTargetQuery);
				if (stationTargetListTemp != null
						&& stationTargetListTemp.size() > 0) {
					StationTarget stationTargetTemp = stationTargetListTemp
							.get(0);
					stationTargetTemp.setOilTargetVolume(oilTargetVolume);
					stationTargetTemp.setOilRealVolume(oilRealVolume);
					stationTargetTemp.setOilDayAverageVolume(stationTarget
							.getOilDayAverageVolume());
					stationTargetTemp.setOilStandardRate(stationTarget
							.getOilStandardRate());

					stationTargetTemp.setNonOilTargetVolume(nonOilTargetVolume);
					stationTargetTemp.setNonOilRealVolume(nonOilRealVolume);
					stationTargetTemp.setNonOilDayAverageVolume(stationTarget
							.getNonOilDayAverageVolume());
					stationTargetTemp.setNonOilStandardRate(stationTarget
							.getNonOilStandardRate());
					stationTargetTemp.setDirectSellingBonus(directSellingBonus);
					stationTargetDao
							.updateByPrimaryKeySelective(stationTargetTemp);
				} else {
					//System.out.println(JSON.toJSONString(stationTarget));
					stationTargetDao.insertSelective(stationTarget);
				}
				success++;

			}
		} catch (Exception e) {
			log.error("销售数据保存异常====="+e.getMessage());
			throw e;
		}
		resultVO.setFail(fail);
		resultVO.setSuccess(success);
		return resultVO;

	}

}
