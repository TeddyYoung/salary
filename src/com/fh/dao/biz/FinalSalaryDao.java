package com.fh.dao.biz;

import com.fh.entity.biz.FinalSalary;
import com.fh.entity.biz.FinalSalaryQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinalSalaryDao {
    int countByExample(FinalSalaryQuery example);

    int deleteByExample(FinalSalaryQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(FinalSalary record);

    int insertSelective(FinalSalary record);

    List<FinalSalary> selectByExample(FinalSalaryQuery example);

    FinalSalary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FinalSalary record, @Param("example") FinalSalaryQuery example);

    int updateByExample(@Param("record") FinalSalary record, @Param("example") FinalSalaryQuery example);

    int updateByPrimaryKeySelective(FinalSalary record);

    int updateByPrimaryKey(FinalSalary record);
}