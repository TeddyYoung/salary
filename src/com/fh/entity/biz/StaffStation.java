package com.fh.entity.biz;

import java.io.Serializable;

/**
 * 油站员工油站关系实体类
 * @author Teddy
 *
 */
public class StaffStation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;// 主键ID
    private String staffCode;// 员工编号(业务主键)
    private String dutyCode;
    private String stationCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
    

}