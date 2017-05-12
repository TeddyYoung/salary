package com.fh.service.system;

import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.system.Parameter;

public interface ParameterService {

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 * @param pageNum 当前页
	 * @param parameterValue 参数的值
	 * @param parameterType  参数类型
	 * @return
	 */
	public Page findParametersByPage(Page page, String parameterValue, String parameterType);

	/**
	 * 添加或修改参数管理记录
	 * @param parameter 参数管理对象
	 */
	public void saveOrUpdate(Parameter parameter);

	/**
	 * 根据参数管理id查询出对象的参数管理记录
	 * @param parameterId 参数管理id
	 * @return
	 */
	public Parameter findAreaById(String parameterId);

	/**
	 * 根据参数管理id删除对应的参数管理记录
	 * @param parameterId 参数管理id
	 */
	public void delete(String parameterId);
	/**
	 * 根据参数的key 和  参数的类型查询出对象的参数管理记录
	 */
	public List<Parameter> queryParameterByKeyAndType(String parameterKey,String parameterType);

	public List<Parameter> queryAll();

	public void init();

	public String getBizValue(String paraKey);

	public String getSysValue(String paraKey);
	
}
