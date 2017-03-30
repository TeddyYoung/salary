package com.fh.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffQuery;
import com.fh.entity.biz.StaffVO;

/**员工信息 dao
 * @author lijn
 *
 */
public interface StaffDao {
    /**
     * 根据条件查询出符合条件的总记录数
     * @return
     */
    int findCountByCriteriaQuery(@Param("staffName") String staffName,@Param("staffStatus") String staffStatus,
    		@Param("subOrganiseIdStr") String subOrganiseIdStr, @Param("dutyCode") String dutyCode);
    /**
     * 查询全部
     * @return
     */
    List<StaffVO> queryAll(@Param("subOrganiseIdStr") String subOrganiseIdStr);
    
    /**
     * 根据查询条件分页模糊查询记录列表
     * @param pageSize 每页显示的记录数
     * @param startIndex 每页起始记录的索引
     * @return
     */
    List<StaffVO> findStaffsByPageCriteriaQuery(@Param("staffName") String staffName,@Param("staffStatus") String staffStatus,
    		@Param("subOrganiseIdStr") String subOrganiseIdStr, @Param("dutyCode") String dutyCode,
    		@Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
 
//    int countByExample(StaffQuery example);

//    int deleteByExample(StaffQuery example);

    int deleteByPrimaryKey(Long id);

//    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffQuery example);

    Staff selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffQuery example);

//    int updateByExample(@Param("record") Staff record, @Param("example") StaffQuery example);

    int updateByPrimaryKeySelective(Staff record);

//    int updateByPrimaryKey(Staff record);

//	public List<Staff> findStaffListWithStationNameByStationCode(@Param("organiseId") String organiseId);
	
	/**
	 * 查询所有的员工信息(包含工作日)
	 * @return
	 */
	public List<Staff> findAllStaffWithWorkingDay();
	
	/**
	 * 通过条件获取员工列表
	 * @param staff
	 * @return
	 */
	public List<Staff> getStaffByCondition(Staff record);

	
}