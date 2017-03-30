package com.fh.dao.system;

import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.OrganiseCOQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 部门表 DAO类
 * @author lijn
 *
 */
public interface OrganiseCODao {
    int countByExample(OrganiseCOQuery example);

    int deleteByExample(OrganiseCOQuery example);

    int deleteByPrimaryKey(String organiseId);

    int insert(OrganiseCO record);

    int insertSelective(OrganiseCO record);

    List<OrganiseCO> selectByExample(OrganiseCOQuery example);

    OrganiseCO selectByPrimaryKey(String organiseId);

    int updateByExampleSelective(@Param("record") OrganiseCO record, @Param("example") OrganiseCOQuery example);

    int updateByExample(@Param("record") OrganiseCO record, @Param("example") OrganiseCOQuery example);

    int updateByPrimaryKeySelective(OrganiseCO record);

    int updateByPrimaryKey(OrganiseCO record);
    
    /**
     * 获取用户所属的机构列表
     * @param userId
     * @return
     */
    public List<OrganiseCO>  findOrganiseCOListByUserID(@Param("userId") String userId);
    
}