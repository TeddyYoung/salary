package com.fh.service.station;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.fh.common.page.Page;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffTransfer;
import com.fh.entity.biz.StaffVO;


/**
 * 员工基本Service
 * @author lijn
 *
 */
public interface StaffService {
	/**查询 所有 员工基本信息
	 * @return
	 */
	public List<StaffVO> queryAll();
	/**分页查询 员工信息
	 * @return
	 */
	public Page findStaffsByPage(Page page,String staffName,String staffStatus, String stationCode, String dufyCode);
	/**添加员工信息
	 * @param station
	 */
	public boolean saveOrUpdate(HttpServletRequest request, String type,MultipartFile uploadPic,
			Staff staff,String flag);
	/*	public void saveOrUpdate(HttpServletRequest request,String type,
			StaffTemp staffTemp,String flag);*/
	/**根据id查询员工基本信息
	 * @param id
	 * @return
	 */
	public Staff queryStaffById(String id);
	/**根据员工编号查询员工基本信息
	 * @param id
	 * @return
	 */
	public Staff queryStaffByStaffCode(String staffCode,String stationCode);
	
	public Staff queryStaffByIdcard(String stataionCode,String idcard);
	/**根据id删除员工基本信息
	 * @param id
	 * @return
	 */
	public void deleteStaffById(String id);

	
	/**
	 * 根据查出油站中所有员工(包含员工所拥有的职务)
	 * @param stationCode 
	 * @return
	 */
	public List<Staff> findStaffsByStationCode(String stationCode);

	/**根据id进行离职申请
	 * @param id
	 * @return
	 */
	public String leaveOffice(String id);
	
	/**保存离职申请信息
	 * @param request 
	 * @param type 上传类型  0 文件 1 图片
	 * @param uploadPic 上传文件对象
	 * @param staff 员工对象
	 * @param sign	标识 1 离职请求 2 调动请求 3 入职请求
	 */
	public boolean staffLeaveOffice(HttpServletRequest request,String type,
			MultipartFile uploadPic,Staff staff,String sign,String flag);
	
	/**保存调动申请信息
	 * @param request 
	 * @param type 上传类型  0 文件 1 图片 5 文件，图片
	 * @param uploadPic 上传文件对象
	 * @param staff 员工调动对象
	 */
	public boolean staffTransfer(HttpServletRequest request,String type,
			MultipartFile uploadPic,StaffTransfer staffTransfer,String sign,String flag,String staffId);
	/**
	 * 根据id更新员工信息
	 */
	public void updateStaffById(Staff staff);
	
	/**
	 * 根据油站编号查询出对应的油站所有的员工(不包含员工所有拥有的职务)
	 * @param stationCode 油站编号
	 * @return
	 */
	public List<Staff> findStaffListByStationCode(String subOrganiseIdStr);
	
	/**
	 * 查询所有的员工信息(油站经理、油站会计、见习经理、见习会计包含工作日)
	 * @return
	 */
	public List<Staff> findAllStaffWithWorkingDay();
	
	/**
	 * 通过条件获取员工信息
	 * @return
	 */
	public Staff getStaffByCondition(Staff staff);
	
}
