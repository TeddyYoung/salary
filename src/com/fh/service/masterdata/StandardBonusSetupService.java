package com.fh.service.masterdata;

import java.util.List;

import com.fh.entity.biz.StandardBonusSetup;

/**
 * 经理奖金设置 Service
 * @author lijn
 *
 */
public interface StandardBonusSetupService {
	
	/**
	 * 修改或新增经理奖金设置记录
	 * @param standardBonusSetup
	 */
	public void saveOrUpdate(StandardBonusSetup standardBonusSetup);

	/**
	 * 根据经理奖金设置id查询出对应的记录
	 * @param standardBonusSetupId
	 * @return
	 */
	public StandardBonusSetup findStandardBonusSetupById(String standardBonusSetupId);

	/**
	 * 根据经理奖金设置id删除对应的记录
	 * @param standardBonusSetupId
	 */
	public void delete(String standardBonusSetupId);
	
	/**
	 * 查询所有经理奖金设置的记录
	 */
	public List<StandardBonusSetup> queryAll();

}
