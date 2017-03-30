package com.fh.service.masterdata;

import com.fh.common.page.Page;
import com.fh.entity.biz.District;

/**
 * 区域 Service
 * @author lijn
 *
 */
public interface DistrictService {
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 当前页
	 * @param districtName 区域名称
	 * @param districtLevel 区域级别
	 * @return
	 */
	Page findDistrictsByPage(Page page, String districtName, String districtLevel);

	/**
	 * 修改或新增区域系数记录
	 * @param district
	 */
	public void saveOrUpdate(District district);

	/**
	 * 根据区域系数id查询出对应的记录
	 * @param districtId
	 * @return
	 */
	public District findDistrictById(String districtId);

	/**
	 * 根据区域系数id删除对应的记录
	 * @param districtId
	 */
	public void delete(String districtId);
	
	
}
