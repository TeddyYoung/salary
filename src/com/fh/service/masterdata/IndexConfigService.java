package com.fh.service.masterdata;

import java.util.List;

import com.fh.entity.biz.IndexConfig;

/**
 * 系数维护Service
 * @author zhang_yu
 *
 */
public interface IndexConfigService {

	/**
	 * 查询出所有的系数维护表中的记录
	 */
	@Deprecated
	List<IndexConfig> findAllIndexConfigs();

	/**
	 * 查询出所有的MMP系数记录
	 */
	public List<IndexConfig> findAllMMPIndexConfigs();

	/**
	 * 查询出所有的损耗系数记录
	 */
	public List<IndexConfig> findAllspoilageIndexConfigs();

	/**
	 * 查询出所有的NPS系数记录
	 */
	public List<IndexConfig> findAllNPSIndexConfigs();

	/**
	 * 查询出所有的IndexConfig信息(包括: MMP系数\NPS系数\耗损系数)
	 * @return
	 */
	public List<IndexConfig> findIndexConfigs();
	
}
