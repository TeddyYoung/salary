package com.fh.service.salarymanagement;

import com.fh.common.page.Page;
import com.fh.entity.biz.SalaryUpload;

/**
 * 薪资上传Service接口
 * @author zhang_yu
 *
 */
public interface SalaryUploadService {

	/**
	 * 根据月份查询薪资上传列表(支持分页查询, 默认展示所有)
	 * @param page
	 * @param yearMonth
	 * @return
	 */
	public Page findSalaryUploadsByPage(Page page, String yearMonth);

	/**
	 * 将上传成功返回的Excel路径存入数据库中, 并刷新是否上传数据
	 * @param ym Excel表格所属月份
	 * @param filePath Excel路径
	 */
	public void uploadSalarySuccess(String ym, String filePath);

	/**
	 * 根据月份查询相应的薪资上传记录
	 * @param ym Excel表格所属月份
	 */
	public int findSalaryUploadByYearMonth(String ym);

	/**
	 * 根据月份查询薪资上传信息
	 * @param yearM 月份
	 */
	public SalaryUpload findSalaryUploadByYearM(String yearM);

	/**
	 * 根据月份在数据库中自动造一条空记录进库
	 * @param yearMonth 上个月月份
	 */
	public void autoInsertSalaryUploadByYearMonth(String yearMonth);

}
