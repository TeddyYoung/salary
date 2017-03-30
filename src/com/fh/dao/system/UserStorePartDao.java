package com.fh.dao.system;

import com.fh.entity.system.UserStorePart;
import com.fh.entity.system.UserStorePartQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStorePartDao {
    int countByExample(UserStorePartQuery example);

    int deleteByExample(UserStorePartQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserStorePart record);

    int insertSelective(UserStorePart record);

    List<UserStorePart> selectByExample(UserStorePartQuery example);

    UserStorePart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserStorePart record, @Param("example") UserStorePartQuery example);

    int updateByExample(@Param("record") UserStorePart record, @Param("example") UserStorePartQuery example);

    int updateByPrimaryKeySelective(UserStorePart record);

    int updateByPrimaryKey(UserStorePart record);
}