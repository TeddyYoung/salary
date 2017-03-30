package com.fh.dao.biz;

import com.fh.entity.biz.IndexConfig;
import com.fh.entity.biz.IndexConfigQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexConfigDao {
    int countByExample(IndexConfigQuery example);

    int deleteByExample(IndexConfigQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    List<IndexConfig> selectByExample(IndexConfigQuery example);

    IndexConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IndexConfig record, @Param("example") IndexConfigQuery example);

    int updateByExample(@Param("record") IndexConfig record, @Param("example") IndexConfigQuery example);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);
}