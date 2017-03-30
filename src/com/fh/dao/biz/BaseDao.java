package com.fh.dao.biz;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.Area;
import com.fh.entity.biz.AreaQuery;

public interface BaseDao {
    int countByExample(AreaQuery example);

    int deleteByExample(AreaQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaQuery example);

    Area selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaQuery example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaQuery example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}