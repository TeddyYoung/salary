package com.fh.dao.system;

import com.fh.entity.biz.Duty;
import com.fh.entity.system.Parameter;
import com.fh.entity.system.ParameterQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ParameterDao {
    int countByExample(ParameterQuery example);

    int deleteByExample(ParameterQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Parameter record);

    int insertSelective(Parameter record);

    List<Parameter> selectByExample(ParameterQuery example);

    Parameter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Parameter record, @Param("example") ParameterQuery example);

    int updateByExample(@Param("record") Parameter record, @Param("example") ParameterQuery example);

    int updateByPrimaryKeySelective(Parameter record);

    int updateByPrimaryKey(Parameter record);

    /**
     * 根据筛选条件查询总记录数
     * @param parameterValue 参数值
     * @param parameterType  参数类型
     * @return
     */
	int findCountByCriteriaQuery(@Param("parameterValue") String parameterValue, @Param("parameterType") String parameterType);

	/**
	 * 分页查询参数管理列表(支持模糊查询)
	 * @param parameterValue 参数的值
	 * @param parameterType  参数类型
	 * @param pageSize       每页显示的记录条数
	 * @param startIndex     每页起始数据的索引
	 * @return
	 */
	List<Duty> findParametersByPageCriteriaQuery(@Param("parameterValue") String parameterValue, @Param("parameterType") String parameterType, 
												 @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	
}