package com.fh.dao.biz;

import com.fh.entity.biz.StaffTemp;
import com.fh.entity.biz.StaffTempQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffTempDao {
    int countByExample(StaffTempQuery example);

    int deleteByExample(StaffTempQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StaffTemp record);

    int insertSelective(StaffTemp record);

    List<StaffTemp> selectByExample(StaffTempQuery example);

    StaffTemp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaffTemp record, @Param("example") StaffTempQuery example);

    int updateByExample(@Param("record") StaffTemp record, @Param("example") StaffTempQuery example);

    int updateByPrimaryKeySelective(StaffTemp record);

    int updateByPrimaryKey(StaffTemp record);
}