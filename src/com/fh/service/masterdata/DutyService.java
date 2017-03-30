package com.fh.service.masterdata;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.biz.Duty;

/**
 * Duty业务逻辑层接口
 * @author zhang_yu
 *
 */
public interface DutyService {
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 用户在页面上点击的页码
	 * @return
	 */
	Page findDutysByPage(Page page, String dutyName);
	
	/**
	 * 添加或修改员工职务
	 * @param duty
	 */
	public void saveOrUpdate(Duty duty);

	/**
	 * 根据Id查询员工职务信息
	 * @param dutyId
	 */
	public Duty findDutyById(String dutyId);

	/**
	 * 根据Id删除员工职务信息
	 * @param dutyId
	 */
	public void delete(String dutyId);
	
	/**
	 * 查询职位列表
	 * @return
	 * @author lijn
	 */
	public List<Duty> queryAll();
	/**
	 * 根据职务编号查询员工职务信息
	 */
	public Duty findDutyByDutyCode(String dutyCode);
	
}
