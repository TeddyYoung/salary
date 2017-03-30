package com.fh.entity.biz;

import java.io.Serializable;
import java.util.List;

/**
 * 考勤管理VO封装类
 * @author zhang_yu
 *
 */
@SuppressWarnings("serial")
public class AttendanceManagementVO implements Serializable {

	private List<AttendanceManagement> attendanceManagementList;

	public List<AttendanceManagement> getAttendanceManagementList() {
		return attendanceManagementList;
	}

	public void setAttendanceManagementList(
			List<AttendanceManagement> attendanceManagementList) {
		this.attendanceManagementList = attendanceManagementList;
	}

}
