package com.fh.dao.system;

import com.fh.entity.system.ActHiActinst;
import com.fh.entity.system.ActHiActinstQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActHiActinstDao {
    int countByExample(ActHiActinstQuery example);

    int deleteByExample(ActHiActinstQuery example);

    int deleteByPrimaryKey(String id);

    int insert(ActHiActinst record);

    int insertSelective(ActHiActinst record);

    List<ActHiActinst> selectByExample(ActHiActinstQuery example);

    ActHiActinst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActHiActinst record, @Param("example") ActHiActinstQuery example);

    int updateByExample(@Param("record") ActHiActinst record, @Param("example") ActHiActinstQuery example);

    int updateByPrimaryKeySelective(ActHiActinst record);

    int updateByPrimaryKey(ActHiActinst record);
}