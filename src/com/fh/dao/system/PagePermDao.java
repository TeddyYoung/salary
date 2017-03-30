package com.fh.dao.system;

import com.fh.entity.system.PagePerm;
import com.fh.entity.system.PagePermQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PagePermDao {
    int countByExample(PagePermQuery example);

    int deleteByExample(PagePermQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(PagePerm record);

    int insertSelective(PagePerm record);

    List<PagePerm> selectByExample(PagePermQuery example);

    PagePerm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PagePerm record, @Param("example") PagePermQuery example);

    int updateByExample(@Param("record") PagePerm record, @Param("example") PagePermQuery example);

    int updateByPrimaryKeySelective(PagePerm record);

    int updateByPrimaryKey(PagePerm record);
}