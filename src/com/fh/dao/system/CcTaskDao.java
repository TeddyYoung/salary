package com.fh.dao.system;

import com.fh.entity.system.CcTask;
import com.fh.entity.system.CcTaskQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcTaskDao {
    int countByExample(CcTaskQuery example);

    int deleteByExample(CcTaskQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(CcTask record);

    int insertSelective(CcTask record);

    List<CcTask> selectByExample(CcTaskQuery example);

    CcTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CcTask record, @Param("example") CcTaskQuery example);

    int updateByExample(@Param("record") CcTask record, @Param("example") CcTaskQuery example);

    int updateByPrimaryKeySelective(CcTask record);

    int updateByPrimaryKey(CcTask record);
}