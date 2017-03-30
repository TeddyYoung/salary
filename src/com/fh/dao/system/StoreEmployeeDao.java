package com.fh.dao.system;

import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeQuery;
import com.fh.entity.system.StoreEmployeeVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreEmployeeDao {
    int countByExample(StoreEmployeeQuery example);

    int deleteByExample(StoreEmployeeQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreEmployee record);

    int insertSelective(StoreEmployee record);

    List<StoreEmployee> selectByExample(StoreEmployeeQuery example);

    StoreEmployee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreEmployee record, @Param("example") StoreEmployeeQuery example);

    int updateByExample(@Param("record") StoreEmployee record, @Param("example") StoreEmployeeQuery example);

    int updateByPrimaryKeySelective(StoreEmployee record);

    int updateByPrimaryKey(StoreEmployee record);
    
    /**
     * 根据条件查询出符合条件的总记录数
     * @param username 查询条件
     */
    int findCountByCriteriaQuery(@Param("username") String username,
			 @Param("subOrganiseIdStr") String subOrganiseIdStr);
    
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param username 查询条件
     * @param pageSize 每页显示的记录数
     * @param startIndex 每页起始记录的索引
     */
    List<StoreEmployeeVO> findUsersByPageCriteriaQuery(@Param("username") String username,
    												 @Param("subOrganiseIdStr") String subOrganiseIdStr,
    												 @Param("pageSize") int pageSize, 
    												 @Param("startIndex") int startIndex);
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param pStoreParts 查询查询
     */
    List<StoreEmployeeVO> findListVOCriteriaQuery(@Param("storeParts") String storeParts,@Param("departmentCode") String departmentCode); 
  
    /**
     * 根据userId查询用户信息
     */
    StoreEmployee queryStoreEmployeeByUserId(@Param("userId") String userId); 
}