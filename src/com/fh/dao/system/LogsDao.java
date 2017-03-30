package com.fh.dao.system;

import com.fh.entity.system.Logs;
import com.fh.entity.system.LogsQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogsDao {
    int countByExample(LogsQuery example);

    int deleteByExample(LogsQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Logs record);

    int insertSelective(Logs record);

    List<Logs> selectByExample(LogsQuery example);

    Logs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Logs record, @Param("example") LogsQuery example);

    int updateByExample(@Param("record") Logs record, @Param("example") LogsQuery example);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);
}