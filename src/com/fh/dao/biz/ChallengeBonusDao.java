package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.ChallengeBonus;

/**
 * 经理挑战奖 DAO 
 * @author Teddy
 */
public interface ChallengeBonusDao {
	
	/**
	 * 新增过节费
	 * @param challengeBonus
	 * @return
	 */
	public int save(ChallengeBonus challengeBonus);
	
	/**
	 * 删除过节费
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 修改过节费
	 * @param challengeBonus
	 * @return
	 */
	public int update(ChallengeBonus challengeBonus);
	
	/**
	 * 查看过节费
	 * @param challengeBonus
	 * @return
	 */
	public ChallengeBonus getChallengeBonus(Long id);
	
	/**
	 * 获取过节费列表 - 不分页
	 * @param challengeBonus
	 * @return
	 */
	public List<ChallengeBonus> findChallengeBonusList(ChallengeBonus challengeBonus);
	
	/**
	 * 查询地区系数列表 - 分页
	 * @param challengeBonus entity
	 * @param pageSize 每页显示多少条记录
	 * @param startIndex 每页开始记录的索引
	 * @return
	 */
	public List<ChallengeBonus> findChallengeBonusPage(@Param("stationCode") String stationCode,@Param("type") String type, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
	 * 根据筛选条件查询总记录数
	 * @return
	 */
	public int findCount(ChallengeBonus challengeBonus);

}