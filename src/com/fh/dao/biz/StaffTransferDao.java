package com.fh.dao.biz;

import com.fh.entity.biz.StaffTransfer;
import com.fh.entity.biz.StaffTransferQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffTransferDao {
    int countByExample(StaffTransferQuery example);

    int deleteByExample(StaffTransferQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StaffTransfer record);

    int insertSelective(StaffTransfer record);

    List<StaffTransfer> selectByExample(StaffTransferQuery example);

    StaffTransfer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaffTransfer record, @Param("example") StaffTransferQuery example);

    int updateByExample(@Param("record") StaffTransfer record, @Param("example") StaffTransferQuery example);

    int updateByPrimaryKeySelective(StaffTransfer record);

    int updateByPrimaryKey(StaffTransfer record);
}