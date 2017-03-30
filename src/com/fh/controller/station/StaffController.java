package com.fh.controller.station;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fh.common.SysConstant;
import com.fh.common.export.ExportExcel;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffTransfer;
import com.fh.entity.biz.StaffVO;
import com.fh.entity.biz.Station;
import com.fh.entity.system.DataDictionary;
import com.fh.entity.system.Seq;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.station.StaffService;
import com.fh.service.station.StationService;
import com.fh.service.system.DataDictionaryService;
import com.fh.service.system.SeqService;
import com.fh.service.system.StoreEmployeeService;

/**
 * 员工基本信息维护 Controller
 * 
 * @author lijn
 * 
 */
@Controller(value="staffController")
@RequestMapping({"/staff"})
public class StaffController extends BaseController {
	
	@Autowired
	private StaffService staffService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	@Autowired
	private StationService stationService;
	@Autowired
	private SeqService seqService;
	
	
	
	

	/**
	 * 查询列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffList.do")    
	public String list(HttpServletRequest request, String staffName,String staffStatus, Page page, Model model, String dutyCode) {
		if (staffStatus == null || "".equals(staffStatus)) {
			staffStatus = "1";
		}
		if ("all".equals(staffStatus)) {
			staffStatus = null;
		}
		StoreEmployee user = (StoreEmployee)request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		Page pageList = staffService.findStaffsByPage(page, staffName, staffStatus, user.getSubOrganiseIdStr(), dutyCode);
		model.addAttribute("pageList", pageList);
		model.addAttribute("staffName", staffName);
		model.addAttribute("staffStatus", staffStatus);
		model.addAttribute("dutyCode", dutyCode);
		return "station/staff/staffList";
	}

	/**
	 * 去添加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffToAdd.do")
	public String toadd(Model model) {
		Staff staff = new Staff();
		StoreEmployee currentUser = SysConstant.getCurrentUser();
		String stationCode = currentUser.getOrganiseId();
		staff.setStationCode(stationCode);
		staff.setStaffInDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Station station = stationService.findOnlyStationByStationCode(stationCode);
		if(Station.STATION_NATURE_LEAGUE.equals(station.getStationNature())){//加盟站
			String staffCode = seqService.getSeqNo(Seq.SEQ_KEY_JMZ);
			staff.setStaffCode(staffCode);
		}
		model.addAttribute("staff", staff);
		return "station/staff/staffAdd";
	}
	
	@RequestMapping("/toEditPwd.do")
	public String toEditPwd() {
		return "system/user/editPassword";
	}
	
	@RequestMapping("editPassword.do")
	public String editPassword(StoreEmployee storeEmployee)  throws Exception {
		if (storeEmployee.getUserpwd() == null || "".equals(storeEmployee.getUserpwd())) {
			throw new Exception("请输入原密码");
		} else if (storeEmployee.getNewPassword() == null || "".equals(storeEmployee.getNewPassword())) {
			throw new Exception("请输入新密码");
		} else if (storeEmployee.getCheckPassword() == null || "".equals(storeEmployee.getCheckPassword())) {
			throw new Exception("请输入确认新密码");
		} else if (!storeEmployee.getCheckPassword().equals(storeEmployee.getNewPassword())) {
			throw new Exception("两次新密码不一致");
		}
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		StoreEmployee currentStoreEmployee = (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
		storeEmployee.setUserid(currentStoreEmployee.getUserid());
		this.storeEmployeeService.editPassword(storeEmployee);
		
		return "save_result";
	}

	/**
	 * 去修改页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffToEdit.do")
	public String toEdit(String id, Model model) {
		Staff staff = staffService.queryStaffById(id);
		if (staff != null && !"".equals(staff))
			model.addAttribute("staff", staff);
		return "station/staff/staffEdit";
	}
	/**
	 * 去调动页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toStaffTransfer.do")
	public String toTransfer(String id, String flag,Model model) {
		Staff staff = staffService.queryStaffById(id);
		if (staff != null && !"".equals(staff))
			model.addAttribute("staff", staff);
		model.addAttribute("flag", flag); 
		model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date())); 
		return "station/staff/staffTransfer";
	}

	/**
	 * 添加或修改员工信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffSaveOrUpdate.do")
	public String saveOrUpdate(HttpServletRequest request,String type,
			Staff staff, Model model,String flag,MultipartFile uploadPic) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		if (staff.getId() == null || "".equals(staff.getId())) {// 新增操作
			Staff staffTemp = this.staffService.getStaffByCondition(staff);
			if (staffTemp !=  null && staffTemp.getId() != null && !"".equals(staffTemp.getId())) {
				model.addAttribute("staff", staff);
				model.addAttribute("message", "该员工已经存在，请勿重复添加");
				return "station/staff/staffAdd";
			}
		}
		
		boolean result = staffService.saveOrUpdate(request,type,uploadPic,staff,flag);
		if(result){
			return "save_result";
		}else{
			model.addAttribute("staff", staff);
			model.addAttribute("message", "员工照片必须为.png或.jpg格式！");
			return "station/staff/staffAdd";
		}
		
	}
	/*入职流程
	 * @RequestMapping(value = "/staffSaveOrUpdate.do")
	public String saveOrUpdate(HttpServletRequest request,String type,
			StaffTemp staffTemp, Model model,String flag) {
		staffService.saveOrUpdate(request,type,staffTemp,flag);
		return "save_result";
	}*/
	
	/**
	 * 员工离职信息保存
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffLeaveOffice.do")
	public String staffLeaveOffice(HttpServletRequest request,String type,
			MultipartFile uploadPic,Staff staff, Model model,String sign,String flag) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		staffService.staffLeaveOffice(request,type,uploadPic,staff,sign,flag);
		return "redirect:staffList.do";
	}
	/**
	 * 员工调动信息保存
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffTransfer.do")
	public String staffTransfer(HttpServletRequest request,String type,
			MultipartFile uploadPic,StaffTransfer staffTransfer,String staffId, Model model,String sign,String flag) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		staffService.staffTransfer(request,type,uploadPic,staffTransfer,sign,flag,staffId);
		return "redirect:staffList.do";
	}

	/**
	 * 去详情页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffToView.do")
	public String toView(String id, Model model) {
		// 根据id查询记录
		Staff staff = staffService.queryStaffById(id);
		if (staff != null)
			model.addAttribute("staff", staff);
		return "station/staff/staffView";
	}
	
	/**
	 * 根据id删除记录
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffDelById.do")
	public void delstaffById(String id,HttpServletResponse response) {
		// json对象
		JSONObject js = new JSONObject();
		try {
			staffService.deleteStaffById(id);
			// json中添加 数据 key value 形式
			js.put("result", "success");
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	/**
	 * 根据id 去离职申请页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toLeaveOffice.do")
	public String toLeaveOffice(String id,String flag,HttpServletResponse response,Model model) {
			// 根据id查询记录
			Staff staff = staffService.queryStaffById(id);
			model.addAttribute("flag", flag);
			model.addAttribute("staff", staff);
			model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			return "station/staff/staffLeaveOffice";
	}
	/**
	 * 根据id 去调动申请页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toTransfer.do")
	public String toTransfer(String id,String flag,HttpServletResponse response,Model model) {
		// 根据id查询记录
		Staff staff = staffService.queryStaffById(id);
		model.addAttribute("flag", flag);
		model.addAttribute("staff", staff);
		return "station/staff/staffTransfer";
	}
/*	*//**
	 * 根据id进行离职申请
	 * 
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/staffLeaveOffice.do")
	public String staffLeaveOffice(String id,HttpServletResponse response,Model model) {
		try {
			// 根据id查询记录
			Staff staff = staffService.queryStaffById(id);
			
			// json中添加 数据 key value 形式
			if(staff!=null && !"".equals(staff)){
				
				Subject currentUser = SecurityUtils.getSubject();
				Session session = currentUser.getSession();
				StoreEmployee storeEmployee = (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
				List<DepPart> depParts = storeEmployee.getDepParts();
				List<StoreEmployeeVO> storeEmployeeVOList =null;
				if(depParts!=null && depParts.size()>0){
					//获取角色父ID
					String  pStoreParts= depParts.get(0).getpStorePart();
					storeEmployeeVOList = storeEmployeeService.queryStoreEmployeeVOBypStorePart(pStoreParts);
				}
				model.addAttribute("storeEmployeeVOList", storeEmployeeVOList);
				model.addAttribute("staff", staff);
			}
			return "station/staff/staffLeaveOffice";
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}*/
	
	/**
	 * 导出Excel
	 * @param model
	 * @return
	 */
	//@RequestMapping(value = "/${url}")
	@RequestMapping(value = "/exportExcel.do")
	public void exportExcel(HttpServletResponse response) {
		//新建工作薄
		Workbook wb = new HSSFWorkbook();
		//建立新的sheet对象
		Sheet sheet = wb.createSheet();
		
		Row nRow=null;
		Cell nCell=null;
		
		int rowNo=0;
		int cellNo=1;
		
		//设置列的列宽    0代表列的索引
		sheet.setColumnWidth(0, 4*300);
		sheet.setColumnWidth(1, 10*300);
		sheet.setColumnWidth(2, 10*300);
		sheet.setColumnWidth(3, 10*300);
		sheet.setColumnWidth(4, 10*300);
		sheet.setColumnWidth(5, 10*300);
		sheet.setColumnWidth(6, 10*300);
		sheet.setColumnWidth(7, 10*300);
		sheet.setColumnWidth(8, 10*300);
		sheet.setColumnWidth(9, 10*300);
		sheet.setColumnWidth(10, 10*300);
		sheet.setColumnWidth(11, 10*300);
		sheet.setColumnWidth(12, 15*300);
		
		//打印大标题
		nRow=sheet.createRow(rowNo++);
		//行高
		nRow.setHeightInPoints(36);
		nCell=nRow.createCell(cellNo);
		
		nCell.setCellValue("员工花名册");
		nCell.setCellStyle(ExportExcel.bigTitle(wb));
		
		//第一行 第二列要合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 12));
		
		List<StaffVO> staffList=staffService.queryAll();
		if(staffList!=null){
			//打印小标题
			String titles[]={"序列号","机构编号","机构名称","员工编号","员工姓名","员工性别","身份证号","员工职务","员工状态","入职日期","离职日期","联系电话"};
			
			//第二行
			nRow=sheet.createRow(rowNo++);
			nRow.setHeightInPoints(26);
			
			//循环打印小标题
			for (String title : titles) {
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(title);
				nCell.setCellStyle(ExportExcel.title(wb));
			}
			
			//预定义一个序列号，作为Excel表格中数据的序列号
			int i=1;
			
			DataDictionary dataDictionary = new DataDictionary();
			
			//打印数据
			for (StaffVO staff : staffList) {
				cellNo=1;
				nRow=sheet.createRow(rowNo++);
				nRow.setHeightInPoints(24);
				
				//序列号
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(String.valueOf(i++));
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//
				nCell=nRow.createCell(cellNo++);
				//nCell.setCellValue(staff.getStationCode());
				nCell.setCellValue(staff.getOrganiseId());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//
				nCell=nRow.createCell(cellNo++);
				/*station=null;
				station = stationService.queryStationByStationCode(staff.getStationCode());
				if(station!=null && !"".equals(station)){
					nCell.setCellValue(station.getStationName());
				}else{
					nCell.setCellValue("");
				}*/
				nCell.setCellValue(staff.getOrganiseName());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//员工编号
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(staff.getStaffCode());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//员工姓名
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(staff.getStaffName());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//员工性别
				nCell=nRow.createCell(cellNo++);
				dataDictionary=null;
				dataDictionary = dataDictionaryService.queryDataDictionaryByCodeType("staffSex", staff.getStaffSex());
				if(dataDictionary!=null && !"".equals(dataDictionary)){
					nCell.setCellValue(dataDictionary.getValuename());
				}else{
					nCell.setCellValue("");
				}
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//身份证号
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(staff.getStaffIdcard());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//员工职务
				nCell=nRow.createCell(cellNo++);
				/*duty=null;
				duty=dutyService.findDutyByDutyCode(staff.getDutyCode());
				if(duty!=null && !"".equals(duty)){
					nCell.setCellValue(duty.getDutyName());
				}else{
					nCell.setCellValue("");
				}*/
				nCell.setCellValue(staff.getDutyName());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//员工状态
				nCell=nRow.createCell(cellNo++);
				dataDictionary=null;
				dataDictionary = dataDictionaryService.queryDataDictionaryByCodeType("staffStatus", staff.getStaffStatus());
				if(dataDictionary!=null && !"".equals(dataDictionary)){
					nCell.setCellValue(dataDictionary.getValuename());
				}else{
					nCell.setCellValue("");
				}
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//入职日期
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(staff.getStaffInDate());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//离职日期
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(staff.getStaffOutDate());
				nCell.setCellStyle(ExportExcel.text(wb));
				
				//联系电话
				nCell=nRow.createCell(cellNo++);
				nCell.setCellValue(staff.getStaffPhone());
				nCell.setCellStyle(ExportExcel.text(wb));
				
			}
		}else{
			//第二行
			nRow=sheet.createRow(rowNo++);
			nRow.setHeightInPoints(26);
			nCell=nRow.createCell(cellNo++);
			nCell.setCellValue("相关数据不存在");
			nCell.setCellStyle(ExportExcel.title(wb));
			
		}
		
		try {
			//导出Excel
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			wb.write(byteArrayOutputStream);
			byteArrayOutputStream.flush();
			byteArrayOutputStream.close();
			ExportExcel.download(byteArrayOutputStream, response, "员工花名册.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ajax - 获取员工信息
	 * @param staffCode
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getStaff.do")
	public void getStaff(HttpServletResponse response, String staffCode,String stationCode) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			Staff staff = staffService.queryStaffByStaffCode(staffCode,stationCode);
			if (staff == null) {
				staff = new Staff();
			}
			JSONObject Json = new JSONObject();
			Json.put("staff", staff);
			response.getWriter().write(Json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
