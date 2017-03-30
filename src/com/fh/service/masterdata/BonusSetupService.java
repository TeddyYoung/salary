package com.fh.service.masterdata;

import java.util.List;

import com.fh.entity.biz.BonusSetup;

/**
 * 奖金设置 Service
 * @author lijn
 *
 */
public interface BonusSetupService {
	
	/**
	 * 修改或新增奖金设置记录
	 * @param bonusSetup
	 */
	public void saveOrUpdate(BonusSetup bonusSetup);

	/**
	 * 根据奖金设置id查询出对应的记录
	 * @param bonusSetupId
	 * @return
	 */
	public BonusSetup findBonusSetupById(String bonusSetupId);

	/**
	 * 根据奖金设置id删除对应的记录
	 * @param bonusSetupId
	 */
	public void delete(String bonusSetupId);
	
	/**
	 * 查询所有奖金设置的记录
	 */
	public List<BonusSetup> queryAll();
	
}
