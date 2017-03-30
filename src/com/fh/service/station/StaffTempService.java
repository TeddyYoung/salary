package com.fh.service.station;

import java.util.List;

import com.fh.entity.biz.StaffTemp;

/**
 * 员工临时表Service接口
 * @author lijn
 *
 */
public interface StaffTempService {

	/**
	 * 批量保存或修改 员工临时表
	 * @param StaffTempList
	 */
	public void saveOrUpdateStaffTemp(List<StaffTemp> StaffTempList);
	/**
	 * 根据编号查询 员工临时表
	 * @param 
	 */
	public StaffTemp findStaffByStaffCode(String StaffCode);
	
}
