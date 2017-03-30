package com.fh.service.operation;

import java.util.List;

import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.entity.biz.LossBonus;
import com.fh.entity.biz.ManageBase;

/**
 * 油品损耗奖金 Service
 * @author zhoujj
 */
public interface LossBonusService {

	/**
	 * 新增
	 * @param lossBonusAmt
	 * @throws Exception
	 */
	public void save(LossBonus lossBonus) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(Long id) throws Exception;
	
	/**
	 * 修改
	 * @param lossBonusAmt
	 * @throws Exception
	 */
	public void update(LossBonus lossBonus) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public LossBonus get(Long id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, LossBonus lossBonus) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<LossBonus> queryList(LossBonus lossBonus) throws Exception;
	
	/**
	 * 批量INSERT管理岗位数据
	 * @param lossBonusList
	 */
	public void insertAllByYearMonth(List<LossBonus> lossBonusList)
		throws BizException;
	
}
