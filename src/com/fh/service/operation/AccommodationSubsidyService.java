package com.fh.service.operation;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationTarget;

/**
 *
 */
public interface AccommodationSubsidyService {

	Page findBoarderSubsidiesByPage(Page page, StationTarget stationTarget);

	void updateExcelDataByStationCode(List<StationTarget> excelStationTargetList);

}
