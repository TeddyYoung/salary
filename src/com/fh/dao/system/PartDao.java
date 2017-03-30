package com.fh.dao.system;

import com.fh.entity.system.Part;
import com.fh.entity.system.PartQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartDao {
    int countByExample(PartQuery example);

    int deleteByExample(PartQuery example);

    int deleteByPrimaryKey(String partid);

    int insert(Part record);

    int insertSelective(Part record);

    List<Part> selectByExample(PartQuery example);

    Part selectByPrimaryKey(String partid);

    int updateByExampleSelective(@Param("record") Part record, @Param("example") PartQuery example);

    int updateByExample(@Param("record") Part record, @Param("example") PartQuery example);

    int updateByPrimaryKeySelective(Part record);

    int updateByPrimaryKey(Part record);
}