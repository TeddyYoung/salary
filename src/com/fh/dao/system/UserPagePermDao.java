package com.fh.dao.system;

import com.fh.entity.system.UserPagePerm;
import com.fh.entity.system.UserPagePermQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPagePermDao {
    int countByExample(UserPagePermQuery example);

    int deleteByExample(UserPagePermQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPagePerm record);

    int insertSelective(UserPagePerm record);

    List<UserPagePerm> selectByExample(UserPagePermQuery example);

    UserPagePerm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPagePerm record, @Param("example") UserPagePermQuery example);

    int updateByExample(@Param("record") UserPagePerm record, @Param("example") UserPagePermQuery example);

    int updateByPrimaryKeySelective(UserPagePerm record);

    int updateByPrimaryKey(UserPagePerm record);
}