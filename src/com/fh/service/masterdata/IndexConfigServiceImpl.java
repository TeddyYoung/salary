package com.fh.service.masterdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.biz.IndexConfigDao;
import com.fh.entity.biz.IndexConfig;
import com.fh.entity.biz.IndexConfigQuery;

/**
 * 系数维护Service实现类
 * @author zhang_yu
 *
 */
@Service
public class IndexConfigServiceImpl implements IndexConfigService {

	@Autowired
	private IndexConfigDao indexConfigDao;
	
	/**
	 * 查询出所有的系数维护表中的记录
	 */
	@Deprecated
	public List<IndexConfig> findAllIndexConfigs() {
		
		IndexConfigQuery indexConfigQuery = new IndexConfigQuery();
		return indexConfigDao.selectByExample(indexConfigQuery);
		
	}

	/**
	 * 查询出所有的MMP系数记录
	 */
	public List<IndexConfig> findAllMMPIndexConfigs() {
		
		IndexConfigQuery indexConfigQuery = new IndexConfigQuery();
		indexConfigQuery.createCriteria().andIndexTypeEqualTo("MMP");
		indexConfigQuery.setOrderByClause("index_order asc");
		return indexConfigDao.selectByExample(indexConfigQuery);
		
	}

	/**
	 * 查询出所有的损耗系数记录
	 */
	public List<IndexConfig> findAllspoilageIndexConfigs() {
		
		IndexConfigQuery indexConfigQuery = new IndexConfigQuery();
		indexConfigQuery.createCriteria().andIndexTypeEqualTo("spoilage");
		indexConfigQuery.setOrderByClause("index_order asc");
		return indexConfigDao.selectByExample(indexConfigQuery);
		
	}

	/**
	 * 查询出所有的NPS系数记录
	 */
	public List<IndexConfig> findAllNPSIndexConfigs() {
		
		IndexConfigQuery indexConfigQuery = new IndexConfigQuery();
		indexConfigQuery.createCriteria().andIndexTypeEqualTo("NPS");
		indexConfigQuery.setOrderByClause("index_order asc");
		return indexConfigDao.selectByExample(indexConfigQuery);
		
	}

	/**
	 * 查询出所有的IndexConfig信息(包括: MMP系数\NPS系数\耗损系数)
	 */
	public List<IndexConfig> findIndexConfigs() {
		
		IndexConfigQuery indexConfigQuery = new IndexConfigQuery();
		return indexConfigDao.selectByExample(indexConfigQuery);
		
	}

}
