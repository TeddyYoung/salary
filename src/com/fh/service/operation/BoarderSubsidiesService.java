package com.fh.service.operation;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationTarget;

/**
 * 搭伙补贴Service接口
 * @author zhang_yu
 *
 */
public interface BoarderSubsidiesService {

	/**
	 * 根据年月份、区域编号分页查询搭伙补贴信息
	 * @param page 分页对象
	 * @param yearMonth 年月份
	 * @param districtCode 区域编号
	 * @return
	 */
	Page findBoarderSubsidiesByPage(Page page, StationTarget stationTarget);

	/**
	 * 将Excel中的全部数据UPDATE入库
	 * @param excelStationTargetList
	 */
	void updateExcelDataByStationCode(List<StationTarget> excelStationTargetList);

}
