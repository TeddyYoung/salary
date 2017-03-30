package com.fh.service.operation;

import com.fh.common.page.Page;

/**
 * 油站基础数据Service接口
 * @author zhang_yu
 *
 */
public interface OilBaseDataService {

	/**
	 * 分页查询油站基础信息, 支持按年月过滤查询
	 * @param page 分页对象
	 * @param yearMonth 年月时间
	 * @return 分装好油站基础数据的分页对象
	 */
	public Page findOilBaseDataByPage(Page page, String yearMonth);

}
