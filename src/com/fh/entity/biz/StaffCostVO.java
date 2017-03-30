package com.fh.entity.biz;

import java.io.Serializable;
import java.util.List;

/**
 * 员工成本信息VO封装类
 * @author lijn
 *
 */
public class StaffCostVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private StaffCost staffCost;
	private String staffName;
	private String stationCode;
	private String staffCode;
	
	private List<StaffCost> staffCostList;
	public StaffCost getStaffCost() {
		return staffCost;
	}
	public void setStaffCost(StaffCost staffCost) {
		this.staffCost = staffCost;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public List<StaffCost> getStaffCostList() {
		return staffCostList;
	}
	public void setStaffCostList(List<StaffCost> staffCostList) {
		this.staffCostList = staffCostList;
	}
	
	
}
