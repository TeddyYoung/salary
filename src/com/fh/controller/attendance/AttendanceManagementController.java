package com.fh.controller.attendance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
import com.fh.entity.biz.AttendanceSumVO;
import com.fh.entity.system.DepPart;
import com.fh.entity.system.Flag;
import com.fh.entity.system.Parameter;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.vo.AttendanceSearchVO;
import com.fh.service.attendance.AttendanceManagementService;
import com.fh.service.system.DepPartService;
import com.fh.service.system.ParameterService;
import com.fh.util.AutoYearMonth;
import com.fh.util.Constants;
import com.fh.util.DownloadUtil;
import com.fh.util.FileUtil;
import com.fh.util.StringUtil;

/**
 * 考勤管理Controller
 * 
 * @author zhang_yu 以月作为单位, 加载所有的信息, 但维护只允许维护上个月的信息
 *
 */
@Controller(value = "attendanceManagementController")
@RequestMapping({ "/attendanceManagement" })
public class AttendanceManagementController extends BaseController {

	@Autowired
	private AttendanceManagementService attendanceManagementService;

	@Autowired
	private DepPartService depPartService;
	
	@Autowired
	private ParameterService parameterService;

	/**
	 * 考勤管理列表(展示biz_attendance_management中的全部)
	 */
	@RequestMapping("/attendanceManagementList.do")
	public String attendanceManagementList(HttpServletRequest request,
			Page page, AttendanceManagement attendanceManagement,
			AttendanceSearchVO searchVO, Model model) {

		// 当用户点击二级菜单"考勤管理"的时候, 默认查询上个月的记录
		if ("".equals(searchVO.getYearMonth())
				|| null == searchVO.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			searchVO.setYearMonth(yearMonth);
		}
		String stationCode = request.getQueryString();
		// TODO 当用户点击二级菜单"考勤管理"的时候, 默认加载当前用户所属油站的信息
		// 若当前用户无所属油站, 则加载所有
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession()
				.getAttribute(SysConstant.CURRENT_USER_INFO);
		// if ("".equals(storeEmployee.getOrganiseId()) || null ==
		// storeEmployee.getOrganiseId()) {
		// attendanceManagement.setStationCode("查不出来");
		// }
		String isSearchHide = StringUtil.isBlank(searchVO.getIsSearchHide()) ? Constants.NO_FLAG
				: searchVO.getIsSearchHide();
		String isMod = Constants.NO_FLAG;
		String organiseId = null;
		if (StringUtil.isBlank(stationCode)) {
			organiseId = storeEmployee.getOrganiseId();
			stationCode = searchVO.getStationCode();
		} else {
			organiseId = stationCode;
			isSearchHide = Constants.YES_FLAG;
			searchVO.setStationCode(stationCode);
		}
		searchVO.setOrganiseId(organiseId);
		List<DepPart> depPartList = depPartService
				.queryDeptPartByUserId(storeEmployee.getUserid());
		if ("S_001".equals(depPartList.get(0).getStorePart())
				|| "Q_001".equals(depPartList.get(0).getStorePart())) {
			isMod = Constants.YES_FLAG;
		}
		Page pageList = attendanceManagementService
				.findAttendanceManagementByPage(page, searchVO);
		AttendanceSumVO attendanceSumVO = attendanceManagementService
				.sumAttendance(searchVO);
		String status = "";
		if(pageList != null && pageList.getRecords() != null && pageList.getRecords().size() > 0){
			AttendanceManagement attendance = (AttendanceManagement) pageList.getRecords().get(0);
			status = attendance.getStatus();
		}
		searchVO.setStatus(status);
		searchVO.setIsSearchHide(isSearchHide);
		String isResubmit = parameterService
				.getBizValue(Parameter.KEY_ATTEN_RESUBMIT);
		model.addAttribute("isResubmit", isResubmit);
		model.addAttribute("sumVO", attendanceSumVO);
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", attendanceManagement);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("isSearchHide", isSearchHide);
		model.addAttribute("isMod", isMod);
		return "attendanceManagement/attendanceManagement/attendanceManagementList";

	}

	/**
	 * 跳转至添加或修改考勤管理界面
	 */
	@RequestMapping("/saveOrUpdateattendanceManagement.do")
	public String saveOrUpdateattendanceManagement(HttpServletRequest request,
			Model model) throws Exception {
		String isSubmit = request.getParameter("isSubmit");
		if (!this.checkData() && !Constants.NO_FLAG.equals(isSubmit)) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}

		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
		if (Constants.NO_FLAG.equals(isSubmit)) {
			String isSave = Constants.YES_FLAG;
			model.addAttribute("isSave", isSave);
		}
		// TODO 当用户点击二级菜单"考勤管理"的时候, 默认加载当前用户所属的区域的信息
		// 若当前用户无所在区域信息, 则加载所有信息
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession()
				.getAttribute(SysConstant.CURRENT_USER_INFO);
		String stationCode = storeEmployee.getOrganiseId();
		// if ("".equals(storeEmployee.getOrganiseId()) || null ==
		// storeEmployee.getOrganiseId()) {
		// stationCode = "查不出来";
		// }

		// 判断是否存在正审批中的考勤信息
		// boolean checkFlag =
		// this.attendanceManagementService.checkAttendanceManage(stationCode,
		// yearMonth);
		// if (checkFlag) {
		// throw new Exception("当月考勤信息已经提交审批或已审批通过，不可修改");
		// }

		// Flag flag2 = new Flag();
		// flag2.setFlag(stationCode);
		// model.addAttribute("Flag2", flag2);

		List<AttendanceManagement> attendanceManagementList = attendanceManagementService
				.findAllAttendanceManagementByCriteriaQuery(yearMonth,
						stationCode, null);
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
	public String attendanceManagementRealSaveOrUpdate(
			HttpServletRequest request,
			AttendanceManagementVO attendanceManagementVO, Model model)
			throws Exception {
		String isSubmit = request.getParameter("isSubmit");
		if (!this.checkData() && !Constants.NO_FLAG.equals(isSubmit)) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}

		if (null != attendanceManagementVO.getAttendanceManagementList()
				&& attendanceManagementVO.getAttendanceManagementList().size() > 0) {
			attendanceManagementService.saveOrUpdateAttendanceManagement(
					attendanceManagementVO.getAttendanceManagementList(),
					isSubmit);
		}
		// return
		// "redirect:/attendanceManagement/saveOrUpdateattendanceManagement.do?stationCode="
		// + stationCode;
		// return
		// "redirect:/attendanceManagement/saveOrUpdateattendanceManagement.do";
		return "redirect:/attendanceManagement/attendanceManagementList.do";

	}

	@RequestMapping("/attendanceUpdate.do")
	public void attendanceUpdate(HttpServletRequest request,
			AttendanceManagementVO attendanceManagementVO,
			HttpServletResponse response) {
		String isSubmit = request.getParameter("isSubmit");
		JSONObject js = new JSONObject();
		try {
			if (!this.checkData() && !Constants.NO_FLAG.equals(isSubmit)) {
				// throw new Exception("数据维护日期已截止,无法操作!");
				js.put("result", Constants.NO_FLAG);
				js.put("message", "数据维护日期已截止,无法操作!");
			}else
			if (null != attendanceManagementVO.getAttendanceManagementList()
					&& attendanceManagementVO.getAttendanceManagementList()
							.size() > 0) {
				attendanceManagementService.saveOrUpdateAttendanceManagement(
						attendanceManagementVO.getAttendanceManagementList(),
						isSubmit);
				js.put("result", Constants.YES_FLAG);
			}
		} catch (Exception e) {
			js.put("result", Constants.NO_FLAG);
			js.put("message", "保存失败");
		}finally{
			try {
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(js.toString());
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

	@RequestMapping(value = "/checkSubmittedAtten.do")
	public void checkSubmittedAtten(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			String result = Constants.NO_FLAG;
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			StoreEmployee storeEmployee = (StoreEmployee) request.getSession()
					.getAttribute(SysConstant.CURRENT_USER_INFO);
			String stationCode = storeEmployee.getOrganiseId();
			List<AttendanceManagement> attendanceManagementList = attendanceManagementService
					.findByCriteriaQuery(yearMonth, stationCode,
							AttendanceManagement.STATUS_SUBMITTED);
			if (attendanceManagementList != null
					&& attendanceManagementList.size() > 0) {
				result = Constants.YES_FLAG;
			}
			JSONObject Json = new JSONObject();
			Json.put("result", result);
			response.getWriter().write(Json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 导出考勤公示
	 */
	@RequestMapping("/exportExcel.do")
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response,
			AttendanceManagement attendanceManagement, Model model)
			throws Exception {
		try {
			// 当用户点击二级菜单"考勤管理"的时候, 默认查询上个月的记录
			if ("".equals(attendanceManagement.getYearMonth())
					|| null == attendanceManagement.getYearMonth()) {
				AutoYearMonth autoYearMonth = new AutoYearMonth();
				String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
				attendanceManagement.setYearMonth(yearMonth);
			}

			// 若当前用户无所属油站, 则加载所有
			StoreEmployee storeEmployee = (StoreEmployee) request.getSession()
					.getAttribute(SysConstant.CURRENT_USER_INFO);
			if ("".equals(storeEmployee.getOrganiseId())
					|| null == storeEmployee.getOrganiseId()) {
				attendanceManagement.setStationCode("查不出来");
			}
			List<AttendanceManagement> resultList = this.attendanceManagementService
					.findAllAttendanceManagementByCriteriaQuery(
							attendanceManagement.getYearMonth(),
							storeEmployee.getOrganiseId(), null);

			String excelTemplatePath = request.getSession().getServletContext()
					.getRealPath("/template/【模板】油站考勤公示.xlsx");
			XSSFWorkbook xSFWorkbook = new XSSFWorkbook(new FileInputStream(
					excelTemplatePath));
			this.analyzeSheet(xSFWorkbook.getSheetAt(0), resultList);
			// this.attendanceManagementService.exportExcel();

			// 生成excel
			String excelPath = request.getSession().getServletContext()
					.getRealPath("/uploadFiles")
					+ "/" + attendanceManagement.getYearMonth() + "/";
			FileUtil.createDir(excelPath);
			String fileName = "加油站月度考勤汇总表（公示版）-"
					+ attendanceManagement.getYearMonth() + ".xlsx";
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
			downloadUtil.download(excelPath + "/" + fileName, fileName,
					response, false);

		} catch (Exception e) {
			throw e;
		}

	}

	// 解析考勤数据
	private void analyzeSheet(XSSFSheet sheet,
			List<AttendanceManagement> attendanceManagementList) {
		int rowNum = 3; // 正式数据, 从第4行开始
		int cellNum = 0;
		XSSFRow row = null;
		// 循环打印至Excel中
		AttendanceManagement attendanceManagement = null;
		for (int i = 0; i < attendanceManagementList.size(); i++) {
			row = sheet.getRow(rowNum++);
			cellNum = 0; // 正式数据, 从每一行的第A列开始
			attendanceManagement = attendanceManagementList.get(i);
			// A 油站名称
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getStationName() == null ? ""
							: attendanceManagement.getStationName());
			// B 序号
			row.getCell(cellNum++).setCellValue(i + 1);
			// C 员工姓名
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getStaffName() == null ? ""
							: attendanceManagement.getStaffName());
			// D 工作日
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getWorkingDay() == null ? 0
							: attendanceManagement.getWorkingDay()
									.doubleValue());
			// E 是否管站/带班
			String isStamanageForeman = "";
			if (attendanceManagement.getIsStamanageForeman() != null
					&& !"N".equals(attendanceManagement.getIsStamanageForeman())) {
				isStamanageForeman = attendanceManagement
						.getIsStamanageForeman();
			}
			row.getCell(cellNum++).setCellValue(isStamanageForeman);
			// F 是否实习期内
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getIsInternship() == null ? ""
							: attendanceManagement.getIsInternship());
			// G 本月实习期满后工作天数
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getAfterIntershipWorking() == null ? 0
							: attendanceManagement.getAfterIntershipWorking()
									.doubleValue());
			// H 平时超时
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getPeacetimeTimeout() == null ? 0
							: attendanceManagement.getPeacetimeTimeout()
									.doubleValue());
			// I 节日加班
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getHolidayOvertime() == null ? 0
							: attendanceManagement.getHolidayOvertime()
									.doubleValue());
			// J 年夜饭在岗
			// row.getCell(cellNum++).setCellValue(attendanceManagement.getFamilyReunionDinnerOn()
			// == null? 0 :
			// attendanceManagement.getFamilyReunionDinnerOn().doubleValue());
			row.getCell(cellNum++)
					.setCellValue(
							attendanceManagement.getIsFamilyReunionDinnerOn() == null ? "N"
									: attendanceManagement
											.getIsFamilyReunionDinnerOn());
			// K 春节在岗(阶段一)
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getOnTheSpringFestivaOne() == null ? 0
							: attendanceManagement.getOnTheSpringFestivaOne()
									.doubleValue());
			// L 春节在岗(阶段二)
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getOnTheSpringFestivaTwo() == null ? 0
							: attendanceManagement.getOnTheSpringFestivaTwo()
									.doubleValue());
			// M 本月离职
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getIsDeparture());
			// N 事假
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getCasualLeave() == null ? 0
							: attendanceManagement.getCasualLeave()
									.doubleValue());
			// O 旷工
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getAbsenteeism() == null ? 0
							: attendanceManagement.getAbsenteeism()
									.doubleValue());
			// P 病假
			row.getCell(cellNum++)
					.setCellValue(
							attendanceManagement.getSickLeave() == null ? 0
									: attendanceManagement.getSickLeave()
											.doubleValue());
			// Q 年假
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getAnnualLeave() == null ? 0
							: attendanceManagement.getAnnualLeave()
									.doubleValue());
			// R 婚假
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getMarriageLeave() == null ? 0
							: attendanceManagement.getMarriageLeave()
									.doubleValue());
			// S 产假
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getMaternityLeave() == null ? 0
							: attendanceManagement.getMaternityLeave()
									.doubleValue());
			// T 丧假
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getFuneralLeave() == null ? 0
							: attendanceManagement.getFuneralLeave()
									.doubleValue());
			// U 调休
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getDaysOff() == null ? 0
							: attendanceManagement.getDaysOff().doubleValue());
			// V 口头警告
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getVerbalWarnings() == null ? 0
							: attendanceManagement.getVerbalWarnings()
									.doubleValue());
			// W 书面警告
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getWrittenWarning() == null ? 0
							: attendanceManagement.getWrittenWarning()
									.doubleValue());
			// X 重大事故
			row.getCell(cellNum++).setCellValue(
					attendanceManagement.getMajorAccident() == null ? 0
							: attendanceManagement.getMajorAccident()
									.doubleValue());
		}
	}

}
