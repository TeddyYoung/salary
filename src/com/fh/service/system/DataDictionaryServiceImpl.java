package com.fh.service.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.system.DataDictionaryDao;
import com.fh.entity.system.DataDictionary;
import com.fh.entity.system.DataDictionaryQuery;
import com.fh.entity.system.DataDictionaryQuery.Criteria;

/**
 * DataDictionary业务逻辑层实现类
 * 
 * @author lijn
 *
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Autowired
	private DataDictionaryDao dataDictionaryDao;

	//private static List<DataDictionary> dicList = new ArrayList<DataDictionary>();

	private static Map<String, DataDictionary> dicNameMap = new HashMap<String, DataDictionary>();

	private static Map<String, String> dicValueMap = new HashMap<String, String>();

	/**
	 * 分页查询 数据字典基本信息
	 * 
	 * @return
	 */
	@Override
	public Page findDataDictionarysByPage(Page page, String codename) {
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = dataDictionaryDao
				.findCountByCriteriaQuery(codename);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<DataDictionary> records = dataDictionaryDao
				.findDataDictionarysByPageCriteriaQuery(codename,
						page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
	}

	/**
	 * 添加数据字典信息
	 * 
	 * @param dataDictionary
	 */
	@Override
	public void saveOrUpdate(DataDictionary dataDictionary) {
		if (dataDictionary != null && !"".equals(dataDictionary)) {
			if (dataDictionary.getId() != null
					&& !"".equals(dataDictionary.getId())) {
				// 修改
				dataDictionary.setSysUpdateTime(new Date());
				DataDictionaryQuery dataDictionaryQuery = new DataDictionaryQuery();
				dataDictionaryQuery.createCriteria().andIdEqualTo(
						dataDictionary.getId());
				dataDictionary.setId(null);
				dataDictionaryDao.updateByExampleSelective(dataDictionary,
						dataDictionaryQuery);
			} else {
				// 新增
				dataDictionary.setSysCreateTime(new Date());
				dataDictionaryDao.insertSelective(dataDictionary);
				System.out.println("添加成功");
			}
		}
	}

	/**
	 * 根据id查询数据字典基本信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public DataDictionary queryDataDictionaryById(String id) {
		if (id != null && !"".equals(id)) {
			DataDictionaryQuery dataDictionaryQuery = new DataDictionaryQuery();
			dataDictionaryQuery.createCriteria().andIdEqualTo(
					Integer.valueOf(id));
			List<DataDictionary> dataList = dataDictionaryDao
					.selectByExample(dataDictionaryQuery);
			if (dataList.size() > 0 && dataList != null) {
				return dataList.get(0);
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public List<DataDictionary> queryAll() {
		DataDictionaryQuery dataDictionaryQuery = new DataDictionaryQuery();
		List<DataDictionary> dataList = dataDictionaryDao
				.selectByExample(dataDictionaryQuery);
		return dataList;
	}

	/**
	 * 根据标签类型 和 值烈性查询数据字典基本信息
	 * 
	 * @return
	 */
	@Override
	public DataDictionary queryDataDictionaryByCodeType(String codeType,
			String valueType) {
		// 条件查询
		DataDictionaryQuery dataDictionaryQuery = new DataDictionaryQuery();
		Criteria createCriteria = dataDictionaryQuery.createCriteria();
		if (codeType != null && !"".equals(codeType)) {
			createCriteria.andCodetypeEqualTo(codeType);
		}
		if (valueType != null && !"".equals(valueType)) {
			createCriteria.andValuetypeEqualTo(valueType);
		}
		List<DataDictionary> dataList = dataDictionaryDao
				.selectByExample(dataDictionaryQuery);
		if (dataList != null && dataList.size() > 0) {
			return dataList.get(0);
		} else {
			return null;
		}

	}

	@Override
	public DataDictionary queryByCodeValueName(String codeType, String valueName) {
		if (dicNameMap.size() == 0) {
			init();
		}
		String key = String.format("%s:%s", new Object[] { codeType,
				valueName });
		return dicNameMap.get(key);

	}
	
	@Override
	public String getValueName(String codeType, String valueType) {
		if (dicValueMap.size() == 0) {
			init();
		}
		String key = String.format("%s:%s", new Object[] { codeType,
				valueType });
		return dicValueMap.get(key);

	}
	
	@Override
	public String getValueType(String codeType, String valueName) {
		if (dicNameMap.size() == 0) {
			init();
		}
		String key = String.format("%s:%s", new Object[] { codeType,
				valueName });
		return dicNameMap.get(key).getValuetype();

	}

	/**
	 * 根据id删除数据字典基本信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public void deleteDataDictionaryById(String id) {
		DataDictionaryQuery dataDictionaryQuery = new DataDictionaryQuery();
		dataDictionaryQuery.createCriteria().andIdEqualTo(Integer.valueOf(id));
		dataDictionaryDao.deleteByExample(dataDictionaryQuery);
	}

	@Override
	public void init() {
		List<DataDictionary> list = queryAll();
	//	dicList = list;
		for (DataDictionary dic : list) {
			String key = String.format("%s:%s",
					new Object[] { dic.getCodetype(), dic.getValuename() });
			String valueTypeKey = String.format("%s:%s",
					new Object[] { dic.getCodetype(), dic.getValuetype() });
			dicNameMap.put(key, dic);
			dicValueMap.put(valueTypeKey, dic.getValuename());
		}
	}
}
