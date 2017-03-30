package com.fh.dao.biz;

import com.fh.entity.biz.StandardBonusSetup;
import com.fh.entity.biz.StandardBonusSetupQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardBonusSetupDao {
    int countByExample(StandardBonusSetupQuery example);

    int deleteByExample(StandardBonusSetupQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StandardBonusSetup record);

    int insertSelective(StandardBonusSetup record);

    List<StandardBonusSetup> selectByExample(StandardBonusSetupQuery example);

    StandardBonusSetup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StandardBonusSetup record, @Param("example") StandardBonusSetupQuery example);

    int updateByExample(@Param("record") StandardBonusSetup record, @Param("example") StandardBonusSetupQuery example);

    int updateByPrimaryKeySelective(StandardBonusSetup record);

    int updateByPrimaryKey(StandardBonusSetup record);
}