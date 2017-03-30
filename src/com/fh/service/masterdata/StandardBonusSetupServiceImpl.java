package com.fh.service.masterdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.biz.StandardBonusSetupDao;
import com.fh.entity.biz.StandardBonusSetup;
import com.fh.entity.biz.StandardBonusSetupQuery;

/**
 * 经理奖金设置 业务逻辑实现
 * @author lijn
 *
 */
@Service
public class StandardBonusSetupServiceImpl implements StandardBonusSetupService {
	
	@Autowired
	private StandardBonusSetupDao standardBonusSetupDao;
	
	/**
	 * 修改或新增经理奖金设置记录
	 */
	public void saveOrUpdate(StandardBonusSetup standardBonusSetup) {
		
		if(standardBonusSetup!=null && !"".equals(standardBonusSetup))
		{
			if(standardBonusSetup.getId()!=null && !"".equals(standardBonusSetup.getId())){
				//修改
				standardBonusSetup.setSysUpdateTime(new Date());
				standardBonusSetupDao.updateByPrimaryKeySelective(standardBonusSetup);
			}else{
				//新增
				standardBonusSetup.setSysCreateTime(new Date());
				standardBonusSetupDao.insertSelective(standardBonusSetup);
				System.out.println("添加成功");
			}
		}
	}

	/**
	 * 根据经理奖金设置id查询出对应的记录
	 */
	public StandardBonusSetup findStandardBonusSetupById(String standardBonusSetupId) {
		
		return standardBonusSetupDao.selectByPrimaryKey(Long.parseLong(standardBonusSetupId));
		
	}

	/**
	 * 根据经理奖金设置id删除对应的记录
	 */
	public void delete(String standardBonusSetupId) {
		
		standardBonusSetupDao.deleteByPrimaryKey(Long.parseLong(standardBonusSetupId));
		
	}
	
	/**
	 * 查询所有经理奖金设置的记录
	 */
	public List<StandardBonusSetup> queryAll() {
		StandardBonusSetupQuery standardBonusSetupQuery = new StandardBonusSetupQuery();
		return standardBonusSetupDao.selectByExample(standardBonusSetupQuery);
	}

}
