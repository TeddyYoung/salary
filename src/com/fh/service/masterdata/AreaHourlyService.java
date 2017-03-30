package com.fh.service.masterdata;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.AreaHourly;

/**
 * 时薪设置维护 Service
 * @author lijn
 *
 */
public interface AreaHourlyService {

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 当前页
	 * @param areaCode 油站编号
	 * @param dutyCode 职务编号
	 * @return
	 */
	Page findAreaHourlysByPage(Page page, String areaCode, String dutyCode);

	/**
	 * 修改或新增时薪设置记录
	 * @param areaHourly
	 */
	public void saveOrUpdate(AreaHourly areaHourly,String[] ids,String[] areaCodes,String[] normalHourlys,String[] otHourlys);

	/**
	 * 根据时薪设置职务编号查询出对应的记录
	 * @param areaHourlyId
	 * @return
	 */
	public List<AreaHourly> findAreaHourlyBydutyCode(String dutyCode);

	/**
	 * 根据时薪设置职务编号删除对应的记录
	 * @param areaHourlyId
	 */
	public void delete(String dutyCode);
	/**
	 * 查询已进行时薪设置的职务
	 */
	public List<AreaHourly> queryAreaHourlyDuty();
}
