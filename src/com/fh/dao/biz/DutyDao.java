package com.fh.dao.biz;

import com.fh.entity.biz.Duty;
import com.fh.entity.biz.DutyQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DutyDao {
	
	/**
	 * 查询记录总条数
	 */
    int countByExample(DutyQuery example);
    
    /**
     * 根据条件查询出符合条件的总记录数
     * @param dutyName 查询条件
     * @return
     */
    int findCountByCriteriaQuery(@Param("dutyName") String dutyName);
    
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param dutyName 查询条件
     * @param pageSize 每页显示的记录数
     * @param startIndex 每页起始记录的索引
     * @return
     */
    List<Duty> findDutysByPageCriteriaQuery(@Param("dutyName") String dutyName, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
 
    int deleteByExample(DutyQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Duty record);

    int insertSelective(Duty record);

    List<Duty> selectByExample(DutyQuery example);

    Duty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Duty record, @Param("example") DutyQuery example);

    int updateByExample(@Param("record") Duty record, @Param("example") DutyQuery example);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);
}