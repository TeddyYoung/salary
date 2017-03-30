package com.fh.dao.biz;

import com.fh.entity.biz.SalaryUpload;
import com.fh.entity.biz.SalaryUploadQuery;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalaryUploadDao {
    int countByExample(SalaryUploadQuery example);

    int deleteByExample(SalaryUploadQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SalaryUpload record);

    int insertSelective(SalaryUpload record);

    List<SalaryUpload> selectByExample(SalaryUploadQuery example);

    SalaryUpload selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalaryUpload record, @Param("example") SalaryUploadQuery example);

    int updateByExample(@Param("record") SalaryUpload record, @Param("example") SalaryUploadQuery example);

    int updateByPrimaryKeySelective(SalaryUpload record);

    int updateByPrimaryKey(SalaryUpload record);
    
    /**
     * 根据月份查询当月薪资上传记录数
     */
	int findSalaryUploadCountByCriteriaQuery(@Param("yearMonth") String yearMonth);

	/**
	 * 根据月份查询薪资上传上传记录
	 */
	List<SalaryUpload> findSalaryUploadsByPageCriteriaQuery(@Param("yearMonth") String yearMonth,
															@Param("pageSize") int pageSize, 
															@Param("startIndex") int startIndex);

	/**
	 * 将上传成功返回的Excel路径存入数据库中, 并刷新是否上传数据
	 */
	@Deprecated
	void uploadSalarySuccess(@Param("ym") String ym, 
							 @Param("filePath") String filePath,
							 @Param("date") Date date);

	/**
	 * 根据月份查询相应的薪资上传记录
	 */
	int findSalaryUploadByYearMonth(@Param("ym") String ym);

	/**
	 * 查询数据表中有多少条记录
	 */
	int findCount();

}