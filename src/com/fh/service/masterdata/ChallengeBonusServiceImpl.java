package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.ChallengeBonusDao;
import com.fh.entity.biz.ChallengeBonus;
import com.fh.entity.vo.ChallengeBonusSearchVO;

/**
 * 过节费维护 Service实现类
 * 
 * @author Teddy
 */
@Service
public class ChallengeBonusServiceImpl implements ChallengeBonusService {

	@Autowired
	private ChallengeBonusDao challengeBonusDao;

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findChallengeBonusPage(Page page,
			ChallengeBonusSearchVO searchVO) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = challengeBonusDao.findCount(searchVO);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<ChallengeBonus> records = challengeBonusDao
				.findChallengeBonusPage(searchVO, page.getPageSize(),
						page.getStartIndex());
		page.setRecords(records);
		return page;

	}

	/**
	 * 修改或新增
	 */
	public void saveOrUpdate(ChallengeBonus challengeBonus) {
		if (null != challengeBonus.getId()
				&& !"".equals(challengeBonus.getId())) {
			challengeBonus.setSysUpdateTime(new Date());
			challengeBonusDao.update(challengeBonus);
		} else {
			challengeBonus.setSysCreateTime(new Date());
			challengeBonusDao.save(challengeBonus);
		}

	}

	/**
	 * 根据id查询出对应的记录
	 */
	public ChallengeBonus getChallengeBonus(Long challengeBonusId) {
		return challengeBonusDao.getChallengeBonus(challengeBonusId);
	}

	/**
	 * 根据id删除对应的记录
	 */
	public void delete(Long challengeBonusId) {
		challengeBonusDao.delete(challengeBonusId);
	}

	/**
	 * DELETE相应月份的所有记录, 再将Excel中的全部记录INSERT进去
	 */
	public void updateList(List<ChallengeBonus> challengeBonusList) {
		for (ChallengeBonus challengeBonus : challengeBonusList) {
			List<ChallengeBonus> challengeBonusListTemp = this.challengeBonusDao
					.findChallengeBonusList(challengeBonus);
			if (challengeBonusListTemp != null
					&& challengeBonusListTemp.size() > 0) {// 更新
				ChallengeBonus challengeBonusTemp = challengeBonusListTemp
						.get(0);
				challengeBonus.setId(challengeBonusTemp.getId());
				challengeBonusDao.update(challengeBonus);
			} else {
				challengeBonusDao.save(challengeBonus);
			}
		}

	}

}
