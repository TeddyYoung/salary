package com.fh.service.salarymanagement;

import com.fh.common.page.Page;
import com.fh.entity.biz.StationTrial;

/**
 * 薪资试算Service接口
 * @author zhang_yu
 *
 */
public interface StationTrialService {

	/**
	 * 分页查看薪资试算, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param yearMonth 年月时间
	 * @return 分装好薪资试算信息的分页对象
	 */
	public Page findSalaryTrialsByPage(Page page, String yearMonth);
	
	/**
	 * 修改或新增
	 */
	public void saveOrUpdate(StationTrial stationTrial);

}
