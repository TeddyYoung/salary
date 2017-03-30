package com.fh.dao.system;

import com.fh.entity.system.DepPart;
import com.fh.entity.system.DepPartQuery;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.StoreEmployee;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepPartDao {
    int countByExample(DepPartQuery example);

    int deleteByExample(DepPartQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepPart record);

    int insertSelective(DepPart record);

    List<DepPart> selectByExample(DepPartQuery example);

    DepPart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepPart record, @Param("example") DepPartQuery example);

    int updateByExample(@Param("record") DepPart record, @Param("example") DepPartQuery example);

    int updateByPrimaryKeySelective(DepPart record);

    int updateByPrimaryKey(DepPart record);
    
    /**
     * 通过用户和机构获取角色列表
     * @param userId
     * @param organiseId
     * @return
     */
    public List<DepPart> findUserDepPartList(@Param("userId") String userId, @Param("organiseId") String organiseId);
}