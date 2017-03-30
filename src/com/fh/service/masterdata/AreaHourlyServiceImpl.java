package com.fh.service.masterdata;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.AreaHourlyDao;
import com.fh.entity.biz.AreaHourly;
import com.fh.entity.biz.AreaHourlyQuery;

/**
 * 时薪设置维护 Service实现类
 * @author lijn
 *
 */
@Service
public class AreaHourlyServiceImpl implements AreaHourlyService {

	@Autowired
	private AreaHourlyDao areaHourlyDao;
	
	/**
	 * 根据页码查询分页记录, 支持模糊查询
	 */
	public Page findAreaHourlysByPage(Page page, String areaCode, String dutyCode) {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = areaHourlyDao.findCountByCriteriaQuery(areaCode, dutyCode);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<AreaHourly> records = areaHourlyDao.findAreaHourlysByPageCriteriaQuery(areaCode, dutyCode, page.getPageSize(), page.getStartIndex());
		page.setRecords(records);
		return page;
		
	}

	/**
	 * 修改或新增时薪设置记录
	 */
	public void saveOrUpdate(AreaHourly areaHourly,String[] ids,String[] areaCodes,String[] normalHourlys,String[] otHourlys) {
		
		for (int i = 0; i < areaCodes.length; i++) {
			if(!"".equals(ids[i]) && ids[i]!=null){
				areaHourly.setId(Long.valueOf(ids[i]));
				areaHourly.setAreaCode(areaCodes[i]);
				areaHourly.setNormalHourly(BigDecimal.valueOf(Double.valueOf(normalHourlys[i])));
				areaHourly.setOtHourly(BigDecimal.valueOf(Double.valueOf(otHourlys[i])));
				areaHourly.setSysUpdateTime(new Date());
				areaHourlyDao.updateByPrimaryKeySelective(areaHourly);
			}else{
				areaHourly.setAreaCode(areaCodes[i]);
				areaHourly.setNormalHourly(BigDecimal.valueOf(Double.valueOf(normalHourlys[i])));
				areaHourly.setOtHourly(BigDecimal.valueOf(Double.valueOf(otHourlys[i])));
				areaHourly.setSysCreateTime(new Date());
				areaHourlyDao.insertSelective(areaHourly);
			}
		}
	}

	/**
	 * 根据时薪设置职务编号查询出对应的记录
	 */
	public List<AreaHourly> findAreaHourlyBydutyCode(String dutyCode) {
		AreaHourlyQuery areaHourlyQuery = new AreaHourlyQuery();
		areaHourlyQuery.createCriteria().andDutyCodeEqualTo(dutyCode);
		return areaHourlyDao.selectByExample(areaHourlyQuery);
		
	}

	/**
	 * 根据时薪设置id删除对应的记录
	 */
	public void delete(String dutyCode) {
		AreaHourlyQuery areaHourlyQuery = new AreaHourlyQuery();
		areaHourlyQuery.createCriteria().andDutyCodeEqualTo(dutyCode);
		areaHourlyDao.deleteByExample(areaHourlyQuery);
		
	}
	/**
	 * 查询已进行时薪设置的职务
	 */
	public List<AreaHourly> queryAreaHourlyDuty() {
		AreaHourlyQuery areaHourlyQuery = new AreaHourlyQuery();
		areaHourlyQuery.setDistinct(true);
		areaHourlyQuery.setFields(" duty_code ");
		List<AreaHourly> areaHourlyList = areaHourlyDao.selectByExample(areaHourlyQuery);
		if(areaHourlyList!=null && areaHourlyList.size()>0){
			return areaHourlyList;
		}else{
			return null;
		}
	}

}
