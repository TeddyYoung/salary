package com.fh.controller.attendance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.AttendanceManagement;
import com.fh.entity.biz.AttendanceManagementVO;
import com.fh.entity.biz.StaffCost;
import com.fh.entity.system.Flag;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.attendance.AttendanceManagementService;
import com.fh.util.AutoYearMonth;
import com.fh.util.DownloadUtil;
import com.fh.util.FileUtil;

/**
 * 考勤管理Controller 
 * @author zhang_yu 
 * 以月作为单位, 加载所有的信息, 但维护只允许维护上个月的信息
 *
 */
@Controller(value="attendanceManagementController")
@RequestMapping({"/attendanceManagement"})
public class AttendanceManagementController extends BaseController {

	@Autowired
	private AttendanceManagementService attendanceManagementService;
	
	/**
	 * 考勤管理列表(展示biz_attendance_management中的全部)
	 */
	@RequestMapping("/attendanceManagementList.do")
	public String attendanceManagementList(HttpServletRequest request, Page page, AttendanceManagement attendanceManagement, Model model) {
		
		//当用户点击二级菜单"考勤管理"的时候, 默认查询上个月的记录
		if ("".equals(attendanceManagement.getYearMonth()) || null == attendanceManagement.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
			attendanceManagement.setYearMonth(yearMonth);
		}
				
		//TODO 当用户点击二级菜单"考勤管理"的时候, 默认加载当前用户所属油站的信息
		//若当前用户无所属油站, 则加载所有
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		if ("".equals(storeEmployee.getOrganiseId()) || null == storeEmployee.getOrganiseId()) {
			attendanceManagement.setStationCode("查不出来");
		}
		Page pageList = attendanceManagementService.findAttendanceManagementByPage(page, 
																			       attendanceManagement.getYearMonth(), 
																			       storeEmployee.getOrganiseId());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", attendanceManagement);
		return "attendanceManagement/attendanceManagement/attendanceManagementList";
		
	}
	
	/**
	 * 跳转至添加或修改考勤管理界面
	 */
	@RequestMapping("/saveOrUpdateattendanceManagement.do")
	public String saveOrUpdateattendanceManagement(HttpServletRequest request, Model model) throws Exception {
		
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
		
		//TODO 当用户点击二级菜单"考勤管理"的时候, 默认加载当前用户所属的区域的信息
		//若当前用户无所在区域信息, 则加载所有信息
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		String stationCode = storeEmployee.getOrganiseId();
		if ("".equals(storeEmployee.getOrganiseId()) || null == storeEmployee.getOrganiseId()) {
			stationCode = "查不出来";
		}
		
		// 判断是否存在正审批中的考勤信息
//		boolean checkFlag = this.attendanceManagementService.checkAttendanceManage(stationCode, yearMonth);
//		if (checkFlag) {
//			throw new Exception("当月考勤信息已经提交审批或已审批通过，不可修改");
//		}
		
//		Flag flag2 = new Flag();
//		flag2.setFlag(stationCode);
//		model.addAttribute("Flag2", flag2);
		
		List<AttendanceManagement> attendanceManagementList = attendanceManagementService
								                			  .findAllAttendanceManagementByCriteriaQuery(yearMonth, 
								                													      stationCode);
		model.addAttribute("attendanceManagementList", attendanceManagementList);
		
		Flag flag = new Flag();
		flag.setFlag(yearMonth);
		model.addAttribute("Flag", flag);
		
		return "attendanceManagement/attendanceManagement/saveOrUpdateattendanceManagement";
		
	}
	
	/**
	 * 添加或修改考勤管理信息
	 */
	@RequestMapping("/attendanceManagementRealSaveOrUpdate.do")
	public String attendanceManagementRealSaveOrUpdate(AttendanceManagementVO attendanceManagementVO,
			Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		if (null != attendanceManagementVO.getAttendanceManagementList()
			&& attendanceManagementVO.getAttendanceManagementList().size() > 0) {
			attendanceManagementService.saveOrUpdateAttendanceManagement(attendanceManagementVO.getAttendanceManagementList());
		}
//		return "redirect:/attendanceManagement/saveOrUpdateattendanceManagement.do?stationCode=" + stationCode;
//		return "redirect:/attendanceManagement/saveOrUpdateattendanceManagement.do";
		return "redirect:/attendanceManagement/attendanceManagementList.do";
		
	}
	
	/**
	 * 导出考勤公示
	 */
	@RequestMapping("/exportExcel.do")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, AttendanceManagement attendanceManagement, Model model) throws Exception {
		try {
			//当用户点击二级菜单"考勤管理"的时候, 默认查询上个月的记录
			if ("".equals(attendanceManagement.getYearMonth()) || null == attendanceManagement.getYearMonth()) {
				AutoYearMonth autoYearMonth = new AutoYearMonth();
				String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
				attendanceManagement.setYearMonth(yearMonth);
			}
			
			//若当前用户无所属油站, 则加载所有
			StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
			if ("".equals(storeEmployee.getOrganiseId()) || null == storeEmployee.getOrganiseId()) {
				attendanceManagement.setStationCode("查不出来");
			}
			List<AttendanceManagement> resultList = this.attendanceManagementService.findAllAttendanceManagementByCriteriaQuery(attendanceManagement.getYearMonth(), storeEmployee.getOrganiseId());
			
			String excelTemplatePath = request.getSession().getServletContext().getRealPath("/template/【模板】油站考勤公示.xlsx");
			XSSFWorkbook xSFWorkbook = new XSSFWorkbook(new FileInputStream(excelTemplatePath));
			this.analyzeSheet(xSFWorkbook.getSheetAt(0), resultList);
//			this.attendanceManagementService.exportExcel();
			
			// 生成excel
			String excelPath = request.getSession().getServletContext().getRealPath("/uploadFiles")  + "/" + attendanceManagement.getYearMonth() + "/";
			FileUtil.createDir(excelPath);
			String fileName = "加油站月度考勤汇总表（公示版）-" + attendanceManagement.getYearMonth()  +".xlsx";
			File file = new File(excelPath + fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file); 
			xSFWorkbook.write(fos);
			xSFWorkbook.close();
			fos.flush();
			fos.close();
			
			DownloadUtil downloadUtil = new DownloadUtil();
			downloadUtil.download(excelPath + "/" + fileName, fileName, response, false);
			
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	// 解析考勤数据
	private void analyzeSheet(XSSFSheet sheet, List<AttendanceManagement> attendanceManagementList) {
		int rowNum = 3; //正式数据, 从第4行开始
		int cellNum = 0;
		XSSFRow row = null;
		//循环打印至Excel中
		AttendanceManagement attendanceManagement = null;
		for (int i = 0; i < attendanceManagementList.size(); i++) {
			row = sheet.getRow(rowNum++);
			cellNum = 0; // 正式数据, 从每一行的第A列开始
			attendanceManagement = attendanceManagementList.get(i);
			// A 油站名称
			row.getCell(cellNum++).setCellValue(attendanceManagement.getStationName() == null ? "" : attendanceManagement.getStationName());
			// B 序号
			row.getCell(cellNum++).setCellValue(i + 1);
			// C 员工姓名
			row.getCell(cellNum++).setCellValue(attendanceManagement.getStaffName() == null ? "" : attendanceManagement.getStaffName());
			// D 工作日
			row.getCell(cellNum++).setCellValue(attendanceManagement.getWorkingDay() == null ? 0 : attendanceManagement.getWorkingDay().doubleValue());
			// E 是否管站/带班 
			String isStamanageForeman = "";
			if (attendanceManagement.getIsStamanageForeman() != null && !"N".equals(attendanceManagement.getIsStamanageForeman())) {
				isStamanageForeman = attendanceManagement.getIsStamanageForeman();
			}
			row.getCell(cellNum++).setCellValue(isStamanageForeman);
			// F 是否实习期内
			row.getCell(cellNum++).setCellValue(attendanceManagement.getIsInternship() == null ? "" : attendanceManagement.getIsInternship());
			// G 本月实习期满后工作天数
			row.getCell(cellNum++).setCellValue(attendanceManagement.getAfterIntershipWorking() == null? 0 : attendanceManagement.getAfterIntershipWorking().doubleValue());
			// H 平时超时
			row.getCell(cellNum++).setCellValue(attendanceManagement.getPeacetimeTimeout() == null? 0 : attendanceManagement.getPeacetimeTimeout().doubleValue());
			// I 节日加班
			row.getCell(cellNum++).setCellValue(attendanceManagement.getHolidayOvertime() == null? 0 : attendanceManagement.getHolidayOvertime().doubleValue());
			// J 年夜饭在岗
			//row.getCell(cellNum++).setCellValue(attendanceManagement.getFamilyReunionDinnerOn() == null? 0 : attendanceManagement.getFamilyReunionDinnerOn().doubleValue());
			row.getCell(cellNum++).setCellValue(attendanceManagement.getIsFamilyReunionDinnerOn() == null? "N" : attendanceManagement.getIsFamilyReunionDinnerOn());
			// K 春节在岗(阶段一)
			row.getCell(cellNum++).setCellValue(attendanceManagement.getOnTheSpringFestivaOne() == null ? 0 : attendanceManagement.getOnTheSpringFestivaOne().doubleValue());
			// L 春节在岗(阶段二)
			row.getCell(cellNum++).setCellValue(attendanceManagement.getOnTheSpringFestivaTwo() == null? 0 : attendanceManagement.getOnTheSpringFestivaTwo().doubleValue());
			// M 本月离职
			row.getCell(cellNum++).setCellValue(attendanceManagement.getIsDeparture());
			// N 事假
			row.getCell(cellNum++).setCellValue(attendanceManagement.getCasualLeave() == null? 0 : attendanceManagement.getCasualLeave().doubleValue());
			// O 旷工
			row.getCell(cellNum++).setCellValue(attendanceManagement.getAbsenteeism() == null? 0 : attendanceManagement.getAbsenteeism().doubleValue());
			// P 病假
			row.getCell(cellNum++).setCellValue(attendanceManagement.getSickLeave() == null? 0 : attendanceManagement.getSickLeave().doubleValue());
			// Q 年假
			row.getCell(cellNum++).setCellValue(attendanceManagement.getAnnualLeave() == null? 0 : attendanceManagement.getAnnualLeave().doubleValue());
			// R 婚假
			row.getCell(cellNum++).setCellValue(attendanceManagement.getMarriageLeave() == null? 0 : attendanceManagement.getMarriageLeave().doubleValue());
			// S 产假
			row.getCell(cellNum++).setCellValue(attendanceManagement.getMaternityLeave() == null? 0 : attendanceManagement.getMaternityLeave().doubleValue());
			// T 丧假
			row.getCell(cellNum++).setCellValue(attendanceManagement.getFuneralLeave() == null? 0 : attendanceManagement.getFuneralLeave().doubleValue());
			// U 调休
			row.getCell(cellNum++).setCellValue(attendanceManagement.getDaysOff() == null? 0 : attendanceManagement.getDaysOff().doubleValue());
			// V 口头警告
			row.getCell(cellNum++).setCellValue(attendanceManagement.getVerbalWarnings() == null? 0 : attendanceManagement.getVerbalWarnings().doubleValue());
			// W 书面警告
			row.getCell(cellNum++).setCellValue(attendanceManagement.getWrittenWarning() == null? 0 : attendanceManagement.getWrittenWarning().doubleValue());
			// X 重大事故
			row.getCell(cellNum++).setCellValue(attendanceManagement.getMajorAccident() == null? 0 : attendanceManagement.getMajorAccident().doubleValue());
		}
	}
	
}
