package com.fh.entity.biz;

import java.io.Serializable;
import java.util.List;

/**
 * 油站指标VO封装类
 * @author zhang_yu
 *
 */
public class StationTargetVO implements Serializable {

	List<StationTarget> stationTargetList;

	public List<StationTarget> getStationTargetList() {
		return stationTargetList;
	}

	public void setStationTargetList(List<StationTarget> stationTargetList) {
		this.stationTargetList = stationTargetList;
	}
	
}
