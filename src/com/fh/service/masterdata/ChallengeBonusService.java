package com.fh.service.masterdata;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.ChallengeBonus;
import com.fh.entity.vo.ChallengeBonusSearchVO;

/**
 * 地区系数维护 Service
 * @author zhang_yu
 *
 */
public interface ChallengeBonusService {

	/**
	 * 修改或新增地区系数记录
	 * @param area
	 */
	public void saveOrUpdate(ChallengeBonus challengeBonus);
	
	/**
	 * 根据地区系数id删除对应的记录
	 * @param areaId
	 */
	public void delete(Long challengeBonusId);

	/**
	 * 根据地区系数id查询出对应的记录
	 * @param challengeBonusId
	 * @return
	 */
	public ChallengeBonus getChallengeBonus(Long challengeBonusId);

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param page 分液器
	 * @param challengeBonus entity
	 * @return
	 */
	public Page findChallengeBonusPage(Page page, ChallengeBonusSearchVO searchVO);
	
	/**
	 * 批量更新列表
	 * @param challengeBonusList
	 */
	public void updateList(List<ChallengeBonus> challengeBonusList);
	
}
