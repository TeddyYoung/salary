package com.fh.service.system;


import java.util.List;

import com.fh.common.page.Page;
import com.fh.entity.system.DataDictionary;


/**
 * 数据字典信息维护 Service
 * @author lijn
 *
 */
public interface DataDictionaryService {
	/**分页查询 数据字典基本信息
	 * @return
	 */
	public Page findDataDictionarysByPage(Page page,String codename);
	/**添加或更改数据字典信息
	 * @param dataDictionary
	 */
	public void saveOrUpdate(DataDictionary dataDictionary);
	/**根据id查询数据字典基本信息
	 * @param id
	 * @return
	 */
	public DataDictionary queryDataDictionaryById(String id);
	/**根据id删除数据字典基本信息
	 * @param id
	 * @return
	 */
	public void deleteDataDictionaryById(String id);
	/**根据标签类型  和   值烈性查询数据字典基本信息
	 * @return
	 */
	public DataDictionary queryDataDictionaryByCodeType(String codeType,String valueType);
	
	public DataDictionary queryByCodeValueName(String codeType, String valueName);
	public List<DataDictionary> queryAll();
	public void init();
	public String getValueName(String codeType, String valueType);
	public String getValueType(String codeType, String valueName);
}
