package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.biz.BonusSetupDao;
import com.fh.entity.biz.BonusSetup;
import com.fh.entity.biz.BonusSetupQuery;

/**
 * 奖金设置 业务逻辑实现
 * @author lijn
 *
 */
@Service
public class BonusSetupServiceImpl implements BonusSetupService {
	
	@Autowired
	private BonusSetupDao bonusSetupDao;
	
	/**
	 * 修改或新增奖金设置记录
	 */
	public void saveOrUpdate(BonusSetup bonusSetup) {
		
		if(bonusSetup!=null && !"".equals(bonusSetup))
		{
			if(bonusSetup.getId()!=null && !"".equals(bonusSetup.getId())){
				//修改
				bonusSetup.setSysUpdateTime(new Date());
				bonusSetupDao.updateByPrimaryKeySelective(bonusSetup);
			}else{
				//新增
				bonusSetup.setSysCreateTime(new Date());
				bonusSetupDao.insertSelective(bonusSetup);
				System.out.println("添加成功");
			}
		}
	}

	/**
	 * 根据奖金设置id查询出对应的记录
	 */
	public BonusSetup findBonusSetupById(String bonusSetupId) {
		
		return bonusSetupDao.selectByPrimaryKey(Long.parseLong(bonusSetupId));
		
	}

	/**
	 * 根据奖金设置id删除对应的记录
	 */
	public void delete(String bonusSetupId) {
		
		bonusSetupDao.deleteByPrimaryKey(Long.parseLong(bonusSetupId));
		
	}
	
	/**
	 * 查询所有奖金设置的记录
	 */
	public List<BonusSetup> queryAll() {
		BonusSetupQuery bonusSetupQuery = new BonusSetupQuery();
		return bonusSetupDao.selectByExample(bonusSetupQuery);
	}

}
