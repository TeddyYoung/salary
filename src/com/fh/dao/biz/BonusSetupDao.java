package com.fh.dao.biz;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.BonusSetup;
import com.fh.entity.biz.BonusSetupQuery;

public interface BonusSetupDao {
    int countByExample(BonusSetupQuery example);

    int deleteByExample(BonusSetupQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(BonusSetup record);

    int insertSelective(BonusSetup record);

    List<BonusSetup> selectByExample(BonusSetupQuery example);

    BonusSetup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BonusSetup record, @Param("example") BonusSetupQuery example);

    int updateByExample(@Param("record") BonusSetup record, @Param("example") BonusSetupQuery example);

    int updateByPrimaryKeySelective(BonusSetup record);

    int updateByPrimaryKey(BonusSetup record);
}