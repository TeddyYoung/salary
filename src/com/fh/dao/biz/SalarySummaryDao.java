package com.fh.dao.biz;

import com.fh.entity.biz.SalarySummary;
import com.fh.entity.biz.SalarySummaryQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalarySummaryDao {
    int countByExample(SalarySummaryQuery example);

    int deleteByExample(SalarySummaryQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SalarySummary record);

    int insertSelective(SalarySummary record);

    List<SalarySummary> selectByExample(SalarySummaryQuery example);

    SalarySummary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SalarySummary record, @Param("example") SalarySummaryQuery example);

    int updateByExample(@Param("record") SalarySummary record, @Param("example") SalarySummaryQuery example);

    int updateByPrimaryKeySelective(SalarySummary record);

    int updateByPrimaryKey(SalarySummary record);
}