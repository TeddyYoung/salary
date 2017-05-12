package com.fh.service.masterdata;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.DutyDao;
import com.fh.entity.biz.Duty;
import com.fh.entity.biz.DutyQuery;

/**
 * Duty业务逻辑层实现类
 * @author zhang_yu
 *
 */
@Service
public class DutyServiceImpl implements DutyService {
	
	@Autowired
	private DutyDao dutyDao;
	
	private static Map<String, String> dutyNameMap = new HashMap<String, String>();
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findDutysByPage(Page page, String dutyName) {
		//查询总记录条数(需要判断是否带着查询条件进来)
		int totalRecordsNum;
		if (null != dutyName && !"".equals(dutyName)) {
			totalRecordsNum = dutyDao.findCountByCriteriaQuery(dutyName);
		}else{
			DutyQuery dutyQuery = new DutyQuery();
			totalRecordsNum = dutyDao.countByExample(dutyQuery);
		}
		page.setTotalRecordsNum(totalRecordsNum);
		//分页查询记录
		List<Duty> records = dutyDao.findDutysByPageCriteriaQuery(dutyName, page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
	
	}
	
	/**
	 * 添加或修改员工职务
	 */
	public void saveOrUpdate(Duty duty) {
		
		if (null != duty.getId() && !"".equals(duty.getId())) {
			duty.setSysUpdateTime(new Date());
			dutyDao.updateByPrimaryKey(duty);
		}else{
			duty.setSysCreateTime(new Date());
			dutyDao.insertSelective(duty);
		}
		
	}
	
	/**
	 * 根据Id查询员工职务信息
	 */
	public Duty findDutyById(String dutyId) {
		
		return dutyDao.selectByPrimaryKey(Long.parseLong(dutyId));
		
	}
	/**
	 * 根据职务编号查询员工职务信息
	 */
	public Duty findDutyByDutyCode(String dutyCode) {
		if(dutyCode!=null && !"".equals(dutyCode)){
			DutyQuery dutyQuery=new DutyQuery();
			List<Duty> dutyList=dutyDao.selectByExample(dutyQuery);
			if(dutyList!=null && dutyList.size()>0){
				return dutyList.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	/**
	 * 根据Id删除员工职务信息
	 */
	public void delete(String dutyId) {
		
		dutyDao.deleteByPrimaryKey(Long.parseLong(dutyId));
		
	}

	/**
	 * 查询职位列表
	 * @return
	 * @author lijn
	 */
	public List<Duty> queryAll(){
		DutyQuery dutyQuery=new DutyQuery();
		return dutyDao.selectByExample(dutyQuery);
	}
	
	@Override
	public void init() {
		List<Duty> list = queryAll();
	//	dicList = list;
		for (Duty duty : list) {
			dutyNameMap.put(duty.getDutyCode(), duty.getDutyName());
		}
	}
	
	@Override
	public String getDutyName(String dutyCode) {
		if (dutyNameMap.size() == 0) {
			init();
		}
		return dutyNameMap.get(dutyCode);

	}

}
