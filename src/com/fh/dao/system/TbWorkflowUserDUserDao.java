package com.fh.dao.system;

import com.fh.entity.system.TbWorkflowUserDUser;
import com.fh.entity.system.TbWorkflowUserDUserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWorkflowUserDUserDao {
    int countByExample(TbWorkflowUserDUserQuery example);

    int deleteByExample(TbWorkflowUserDUserQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbWorkflowUserDUser record);

    int insertSelective(TbWorkflowUserDUser record);

    List<TbWorkflowUserDUser> selectByExample(TbWorkflowUserDUserQuery example);

    TbWorkflowUserDUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbWorkflowUserDUser record, @Param("example") TbWorkflowUserDUserQuery example);

    int updateByExample(@Param("record") TbWorkflowUserDUser record, @Param("example") TbWorkflowUserDUserQuery example);

    int updateByPrimaryKeySelective(TbWorkflowUserDUser record);

    int updateByPrimaryKey(TbWorkflowUserDUser record);
}