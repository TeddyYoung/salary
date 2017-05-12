package com.fh.service.operation;

import java.util.List;

import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.entity.biz.ManageBase;
import com.fh.entity.vo.ResultVO;

/**
 * 管理岗位基础表维护 Service
 * @author lijn
 *
 */
public interface ManageBaseService {

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 当前页
	 * @param yearMonth 年份月份
	 * @return
	 */
	@Deprecated
	Page findManageBasesByPage(Page page, String yearMonth);

	/**
	 * 修改或新增管理岗位基础表记录
	 * @param ManageBase
	 */
	public void saveOrUpdate(ManageBase ManageBase);

	/**
	 * 根据管理岗位基础表id查询出对应的记录
	 * @param ManageBaseId
	 * @return
	 */
	public ManageBase findManageBaseById(String ManageBaseId);

	/**
	 * 根据管理岗位基础表id删除对应的记录
	 * @param ManageBaseId
	 */
	public void delete(String ManageBaseId);

	/**
	 * 根据年月份删除相应月份的全部记录
	 * @param yearMonth
	 */
	void deleteAllByYearMonth(String yearMonth);

	/**
	 * 批量INSERT管理岗位数据
	 * @param manageBaseList
	 */
	public ResultVO insertAllByYearMonth(List<ManageBase> manageBaseList,boolean submit) throws BizException;

	/**
	 * 查询当月管理岗位数据的数量
	 * @param yearMonth 年月份
	 * @return
	 */
	int findAllManageBaseCountByYearMonth(String yearMonth);

	/**
	 * 查询当月所有管理岗位数据
	 */
	public List<ManageBase> findManageBaseListByYearMonth(String yearMonth, String districtCode);

	/**
	 * 根据年月份分页查询当月的管理岗位数据
	 * @param page
	 * @param yearMonth
	 * @return
	 */
	public Page findManageBaseByPage(Page page, ManageBase manageBase);
	
	/**
	 * 通过条件获取管理岗位数据对象
	 * @param manageBase
	 * @return
	 */
	public ManageBase getManageBaseByCondition(ManageBase manageBase);
	
	/**
	 * 获取管理岗位：油站经理列表数据
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findManageList(String yearMonth, String districtCode);
	
	/**
	 * 获取管理岗位：油站会计列表数据
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findBursarList(String yearMonth, String districtCode);
	
	/**
	 * 获取管理岗位：兼站经理/会计列表数据
	 * @param manageBase
	 * @return
	 */
	List<ManageBase> findPartList(String yearMonth, String districtCode);

}
