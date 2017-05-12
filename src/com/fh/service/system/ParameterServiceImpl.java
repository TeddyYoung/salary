package com.fh.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.system.ParameterDao;
import com.fh.entity.biz.Duty;
import com.fh.entity.system.Parameter;
import com.fh.entity.system.ParameterQuery;
import com.fh.entity.system.ParameterQuery.Criteria;

@Service
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterDao parameterDao;

	private static Map<String, String> valueMap = new HashMap<String, String>();

	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findParametersByPage(Page page, String parameterValue,
			String parameterType) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = parameterDao.findCountByCriteriaQuery(
				parameterValue, parameterType);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Duty> records = parameterDao.findParametersByPageCriteriaQuery(
				parameterValue, parameterType, page.getPageSize(),
				page.getStartIndex());
		page.setRecords(records);
		return page;

	}

	/**
	 * 添加或修改参数管理记录
	 */
	public void saveOrUpdate(Parameter parameter) {

		if (null != parameter.getId() && !"".equals(parameter.getId())) {
			parameterDao.updateByPrimaryKey(parameter);
		} else {
			parameterDao.insertSelective(parameter);
		}

	}

	/**
	 * 根据参数管理id查询出对象的参数管理记录
	 */
	public Parameter findAreaById(String parameterId) {

		return parameterDao.selectByPrimaryKey(Integer.parseInt(parameterId));

	}

	@Override
	public List<Parameter> queryAll() {
		ParameterQuery query = new ParameterQuery();
		List<Parameter> dataList = parameterDao.selectByExample(query);
		return dataList;
	}

	@Override
	public String getBizValue(String paraKey) {
		if (valueMap.size() == 0) {
			init();
		}
		String key = String.format("%s:%s", new Object[] {
				Parameter.PARAMETER_TYPE_BIZ, paraKey });
		return valueMap.get(key);

	}
	
	@Override
	public String getSysValue(String paraKey) {
		if (valueMap.size() == 0) {
			init();
		}
		String key = String.format("%s:%s", new Object[] {
				Parameter.PARAMETER_TYPE_SYS, paraKey });
		return valueMap.get(key);

	}

	@Override
	public void init() {
		List<Parameter> list = queryAll();
		for (Parameter para : list) {
			String key = String.format(
					"%s:%s",
					new Object[] { para.getParameterType(),
							para.getParameterKey() });
			valueMap.put(key, para.getParameterValue());
		}
	}

	/**
	 * 根据参数的key 和 参数的类型查询出对象的参数管理记录
	 */
	public List<Parameter> queryParameterByKeyAndType(String parameterKey,
			String parameterType) {
		ParameterQuery parameterQuery = new ParameterQuery();
		Criteria createCriteria = parameterQuery.createCriteria();
		if (parameterKey != null && !"".equals(parameterKey)) {
			createCriteria.andParameterKeyEqualTo(parameterKey);
		}
		if (parameterType != null && !"".equals(parameterType)) {
			createCriteria.andParameterTypeEqualTo(parameterType);
		}
		List<Parameter> parameterList = parameterDao
				.selectByExample(parameterQuery);
		if (parameterList != null && parameterList.size() > 0) {
			return parameterList;
		} else {
			return null;
		}
	}

	/**
	 * 根据参数管理id删除对应的参数管理记录
	 */
	public void delete(String parameterId) {

		parameterDao.deleteByPrimaryKey(Integer.parseInt(parameterId));

	}

}
