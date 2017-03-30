package com.fh.service.salarymanagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.common.page.Page;
import com.fh.dao.biz.SalaryUploadDao;
import com.fh.entity.biz.SalaryUpload;
import com.fh.entity.biz.SalaryUploadQuery;

/**
 * 薪资上传Service实体类
 * @author zhang_yu
 *
 */
@Service
public class SalaryUploadServiceImpl implements SalaryUploadService {

	@Autowired
	private SalaryUploadDao salaryUploadDao;
	
	/**
	 * 根据月份查询薪资上传列表(支持分页查询, 默认展示所有)
	 */
	public Page findSalaryUploadsByPage(Page page, String yearMonth) {
		
		// 查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = salaryUploadDao.findSalaryUploadCountByCriteriaQuery(yearMonth);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<SalaryUpload> records = salaryUploadDao.findSalaryUploadsByPageCriteriaQuery(yearMonth,
																						  page.getPageSize(), 
																						  page.getStartIndex());

		page.setRecords(records);
		return page;
		
	}

	/**
	 * 将上传成功返回的Excel路径存入数据库中, 并刷新是否上传数据
	 */
	public void uploadSalarySuccess(String ym, String filePath) {
		
//		Date date = new Date();
//		salaryUploadDao.uploadSalarySuccess(ym, filePath, date);
		
		SalaryUpload salaryUpload = new SalaryUpload();
		salaryUpload.setIsUpload("1");
		salaryUpload.setUploadUrl(filePath);
		salaryUpload.setSysUpdateTime(new Date());
		
		SalaryUploadQuery salaryUploadQuery = new SalaryUploadQuery();
		salaryUploadQuery.createCriteria().andYearMonthEqualTo(ym);
		salaryUploadDao.updateByExampleSelective(salaryUpload, salaryUploadQuery);
		
	}

	/**
	 * 根据月份查询相应的薪资上传记录
	 */
	public int findSalaryUploadByYearMonth(String ym) {
		
		return salaryUploadDao.findSalaryUploadByYearMonth(ym);
		
	}

	/**
	 * 根据月份查询薪资上传信息
	 */
	public SalaryUpload findSalaryUploadByYearM(String yearM) {
		
		SalaryUploadQuery salaryUploadQuery = new SalaryUploadQuery();
		salaryUploadQuery.createCriteria().andYearMonthEqualTo(yearM);
		return salaryUploadDao.selectByExample(salaryUploadQuery).get(0);
		
	}

	/**
	 * 根据月份在数据库中自动造一条空记录进库
	 */
	public void autoInsertSalaryUploadByYearMonth(String yearMonth) {
		
		SalaryUpload salaryUpload = new SalaryUpload();
		
		String salaryUploadCode = null;
		int count = salaryUploadDao.findCount();
		if (count < 10) {
			salaryUploadCode = "U_000" + String.valueOf((count + 1));
		}else if (count >= 10 && count<= 99) {
			salaryUploadCode = "U_00" + String.valueOf((count + 1));
		}else if (count >= 100 && count<= 999){
			salaryUploadCode = "U_0" + String.valueOf((count + 1));
		}else if (count >= 1000) {
			salaryUploadCode = "U_" + "" + String.valueOf((count + 1));
		}
		salaryUpload.setSalaryUploadCode(salaryUploadCode);
		salaryUpload.setIsUpload("0");
		salaryUpload.setYearMonth(yearMonth);
		salaryUpload.setSysCreateTime(new Date());
		salaryUpload.setRemark("全公司" + yearMonth.substring(yearMonth.indexOf("-") + 1) + "月薪资上传记录");
		salaryUploadDao.insertSelective(salaryUpload);
		
	}

	
	
}
