package com.fh.controller.salarymanagement;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.entity.biz.FinalSalary;
import com.fh.entity.biz.SalaryUpload;
import com.fh.entity.biz.Staff;
import com.fh.entity.system.Flag;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.salarymanagement.FinalSalaryService;
import com.fh.service.salarymanagement.SalaryUploadService;
import com.fh.service.station.StaffService;
import com.fh.util.AutoYearMonth;
import com.fh.util.DataTypeConversion;
import com.fh.util.DownloadUtil;
import com.fh.util.ExcelUtil;
import com.fh.util.UploadFile;

/**
 * 薪资上传Controller
 * 以月作为单位, 不区分油站、区域, 加载全公司薪资上传列表
 * 
 * @author zhang_yu 
 *
 */
@Controller(value = "salaryUploadController")
@RequestMapping({ "/salaryUpload" })
public class SalaryUploadController {

	@Autowired
	private SalaryUploadService salaryUploadService;
	@Autowired
	private FinalSalaryService finalSalaryService;
	@Autowired
	private StaffService staffService;
	
	/**
	 * 薪资上传列表
	 */
	@RequestMapping("/salaryUploadList.do")
	public String salaryUploadList(Page page, SalaryUpload salaryUpload, Model model) {

		//判断当前的时间的上一个月的记录是都否在数据库中有存档
		//如果没有, 在数据库中造一条
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String year_month = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
		int count = salaryUploadService.findSalaryUploadByYearMonth(year_month);
		if (0 == count) {
			//没有记录, 造一条未上传的记录
			salaryUploadService.autoInsertSalaryUploadByYearMonth(year_month);
		}
		//查询薪资上传列表
		if ("".equals(salaryUpload.getYearMonth())) {
			salaryUpload.setYearMonth(null);
		}
		Page pageList = salaryUploadService.findSalaryUploadsByPage(page, salaryUpload.getYearMonth());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", salaryUpload);
		return "salarymanagement/salaryupload/salaryUploadList";

	}
	
	/**
	 * 上传薪资Excel表格
	 * 将HR上传的总表的数据全部入库(biz_final_salary), 至此, 基础数据就全都不让修改了 
	 */
	@RequestMapping("/salaryImport.do")
	public String salaryImport(HttpServletRequest request, String type, String ym, 
							   MultipartFile uploadFile, Model model) throws Exception {
		
		//文件所属的月份一定不可为空, 必须得让用户选
		if (null == ym || "".equals(ym)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryupload/salaryUploadFlag";
		}
		
		//判断用户选择的月份是否在可上传的范围之内
		int count = salaryUploadService.findSalaryUploadByYearMonth(ym);
		if (count == 0) {
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryupload/salaryUploadFlag";
		}
		
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryupload/salaryUploadFlag";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryupload/salaryUploadFlag";
		}
		
		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil.uploadFile(request, uploadFile, type, null);
		// 以返回的上传文件的绝对路径构建输入流
		InputStream is = new FileInputStream(filePath);
		//准备解析上传的Excel
		@SuppressWarnings("resource")
		XSSFWorkbook xSFWorkbook = new XSSFWorkbook(is);
		XSSFSheet sheet = xSFWorkbook.getSheet("油站工资表模板");
		if (null == sheet || "".equals(sheet)) {
			Flag flag = new Flag();
			flag.setFlag("7");
			model.addAttribute("Flag", flag);
			return "salarymanagement/salaryupload/salaryUploadFlag";
		}
		
		int cellNum = 0; //从工作簿的第4行开始梳理数据
		XSSFRow row = null;
		XSSFCell cell = null;
		FinalSalary finalSalary = null;
		List<FinalSalary> finalSalaryList = new ArrayList<FinalSalary>();
		ExcelUtil excelUtil = new ExcelUtil();
		for (int rowNum = 3; rowNum < sheet.getLastRowNum(); rowNum++) { //从第4行开始
			cellNum = 0; //从第1列(A列)开始梳理数据
			
			row = sheet.getRow(rowNum); //设置结束循环Excel的时机
			if (null == row || "".equals(row)) {
				break;
			}else{
				cell = row.getCell(cellNum++);
				if (null == cell || "".equals(cell)) {
					break;
				}
			}
			
			//准备将Excel中的数据入库
			finalSalary = new FinalSalary();
			
			//关联数据(A列)
			String cellValueOfA = String.valueOf(cell);
			if (null != cellValueOfA && !"".equals(cellValueOfA)) {
				finalSalary.setAssociatedDataOne(String.valueOf(cell));
			}else{
				break;
			}
			
			//关联数据(B列)
			cell = row.getCell(cellNum++);
			finalSalary.setAssociatedDataOne(excelUtil.getCellStringValue(cell));
			
			//关联数据(C列)
			cell = row.getCell(cellNum++);
			finalSalary.setAssociatedDataTwo(excelUtil.getCellStringValue(cell));
			
			//油站名称
			cell = row.getCell(cellNum++);
			finalSalary.setStationName(excelUtil.getCellStringValue(cell));
			
			//地区系数
			cell = row.getCell(cellNum++);
			finalSalary.setAreaName(excelUtil.getCellStringValue(cell));
			
			//油站星级
			cell = row.getCell(cellNum++);
			finalSalary.setStationLevelName(excelUtil.getCellStringValue(cell));
			
			//跳过Excel中"序号"一列
			cellNum++;
			
			//员工编号
			cell = row.getCell(cellNum++);
			finalSalary.setStaffCode(excelUtil.getCellStringValue(cell));
			
			//员工姓名
			cell = row.getCell(cellNum++);
			finalSalary.setStaffName(excelUtil.getCellStringValue(cell));
			
			//身份证号
			cell = row.getCell(cellNum++);
			finalSalary.setStaffIdcard(excelUtil.getCellStringValue(cell));
			
			//银行卡账号
			cell = row.getCell(cellNum++);
			finalSalary.setStaffBankcard(excelUtil.getCellStringValue(cell));
			
			//本人银行卡所属开户行
			cell = row.getCell(cellNum++);
			finalSalary.setStaffBank(excelUtil.getCellStringValue(cell));
			
			//职务
			cell = row.getCell(cellNum++);
			finalSalary.setDutyName(excelUtil.getCellStringValue(cell));
			
			//入职日期
			cell = row.getCell(cellNum++);
			finalSalary.setStaffInDate(excelUtil.getCellStringValue(cell));
			
			//工作日
			cell = row.getCell(cellNum++);
			finalSalary.setWorkingDay(excelUtil.getBigDecimalValue(cell));
			
			//是否管站/带班
			cell = row.getCell(cellNum++);
			finalSalary.setIsStamanageForeman(excelUtil.getCellStringValue(cell));
			
			//是否实习期内
			cell = row.getCell(cellNum++);
			finalSalary.setIsInternship(excelUtil.getCellStringValue(cell));
			
			//本月实习期满后工作天数
			cell = row.getCell(cellNum++);
			finalSalary.setAfterIntershipWorking(excelUtil.getBigDecimalValue(cell));
			
			//平时超时
			cell = row.getCell(cellNum++);
			finalSalary.setPeacetimeTimeout(excelUtil.getBigDecimalValue(cell));
			
			//节日加班
			cell = row.getCell(cellNum++);
			finalSalary.setHolidayOvertime(excelUtil.getBigDecimalValue(cell));
			
			//年夜饭在岗
			cell = row.getCell(cellNum++);
			finalSalary.setFamilyReunionDinnerOn(excelUtil.getBigDecimalValue(cell));
			
			//春节在岗(阶段一)
			cell = row.getCell(cellNum++);
			finalSalary.setOnTheSpringFestivaOne(excelUtil.getBigDecimalValue(cell));
			
			//春节在岗(阶段二)
			cell = row.getCell(cellNum++);
			finalSalary.setOnTheSpringFestivaTwo(excelUtil.getBigDecimalValue(cell));
			
			//本月离职
			cell = row.getCell(cellNum++);
			finalSalary.setMonthDeparture(excelUtil.getBigDecimalValue(cell));
			
			//事假
			cell = row.getCell(cellNum++);
			finalSalary.setCasualLeave(excelUtil.getBigDecimalValue(cell));
			
			//旷工
			cell = row.getCell(cellNum++);
			finalSalary.setAbsenteeism(excelUtil.getBigDecimalValue(cell));
			
			//病假
			cell = row.getCell(cellNum++);
			finalSalary.setSickLeave(excelUtil.getBigDecimalValue(cell));
			
			//年假
			cell = row.getCell(cellNum++);
			finalSalary.setAnnualLeave(excelUtil.getBigDecimalValue(cell));
			
			//婚假
			cell = row.getCell(cellNum++);
			finalSalary.setMarriageLeave(excelUtil.getBigDecimalValue(cell));
			
			//产假
			cell = row.getCell(cellNum++);
			finalSalary.setMaternityLeave(excelUtil.getBigDecimalValue(cell));
			
			//丧假
			cell = row.getCell(cellNum++);
			finalSalary.setFuneralLeave(excelUtil.getBigDecimalValue(cell));
			
			//调休
			cell = row.getCell(cellNum++);
			finalSalary.setDaysOff(excelUtil.getBigDecimalValue(cell));
			
			//警告
			cell = row.getCell(cellNum++);
			finalSalary.setVerbalWarnings(excelUtil.getBigDecimalValue(cell));
			
			//记过
			cell = row.getCell(cellNum++);
			finalSalary.setWrittenWarning(excelUtil.getBigDecimalValue(cell));
			
			//重大事故
			cell = row.getCell(cellNum++);
			finalSalary.setMajorAccident(excelUtil.getBigDecimalValue(cell));
			
			//是否保留宿舍
			cell = row.getCell(cellNum++);
			finalSalary.setIsAccomodate(excelUtil.getCellStringValue(cell));
			
			//是否搭伙
			cell = row.getCell(cellNum++);
			finalSalary.setIsBoarder(excelUtil.getCellStringValue(cell));
			
			//精彩卡-蓝色版
			cell = row.getCell(cellNum++);
			finalSalary.setSplendorCardBlue(excelUtil.getBigDecimalValue(cell));
			
			//精彩卡-绿色版
			cell = row.getCell(cellNum++);
			finalSalary.setSplendorCardGreen(excelUtil.getBigDecimalValue(cell));
			
			//兼职便利店员比例
			cell = row.getCell(cellNum++);
			finalSalary.setPartTimeScale(excelUtil.getBigDecimalValueFromPercentage(cell));
			
			//月度绩效(100分制)
			cell = row.getCell(cellNum++);
			finalSalary.setMonthPerformance(excelUtil.getBigDecimalValue(cell));
			
			//经理奖金分配比例
			cell = row.getCell(cellNum++);
			finalSalary.setManagePostManageBonus(excelUtil.getBigDecimalValueFromPercentage(cell));
			
			//备注
			cell = row.getCell(cellNum++);
			finalSalary.setRemark(excelUtil.getCellStringValue(cell));
			
			//试用期系数
			cell = row.getCell(cellNum++);
			finalSalary.setProbationCoefficient(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//工作系数
			cell = row.getCell(cellNum++);
			finalSalary.setWorkingCoefficient(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//绩效系数	
			cell = row.getCell(cellNum++);
			finalSalary.setPerformanceCoefficient(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//岗位工时
			cell = row.getCell(cellNum++);
			finalSalary.setPostManHour(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//岗位时薪
			cell = row.getCell(cellNum++);
			finalSalary.setPostHourSalary(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//管理岗位油品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setManagePostOilBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//一线员工油品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setFirstTierStaffOilBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//管理岗位非油品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setManagePostNonOilBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//一线员工非油品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setFirstTierStaffNonOilBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//管理岗位管理奖金
			cell = row.getCell(cellNum++);
			finalSalary.setManagePostManageBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//一线员工绩效奖金
			cell = row.getCell(cellNum++);
			finalSalary.setFirstTierStaffPerformanceBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//岗位工资
			cell = row.getCell(cellNum++);
			finalSalary.setPostSalary(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//加班津贴
			cell = row.getCell(cellNum++);
			finalSalary.setOvertimeAllowance(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//油品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setOilBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//非油品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setNonOilBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//星级、绩效奖金
			cell = row.getCell(cellNum++);
			finalSalary.setStarLevelPerformanceBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//经理奖金
			cell = row.getCell(cellNum++);
			finalSalary.setManagerBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//业绩挑战奖金
			cell = row.getCell(cellNum++);
			finalSalary.setPerformanceChallengeBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//促销品奖金
			cell = row.getCell(cellNum++);
			finalSalary.setPromotionsBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//金点子奖金
			cell = row.getCell(cellNum++);
			finalSalary.setGoldIdeaBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//年度奖金
			cell = row.getCell(cellNum++);
			finalSalary.setAnnualBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//精彩卡奖金
			cell = row.getCell(cellNum++);
			finalSalary.setSplendorCardBonus(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//兼职便利店补贴
			cell = row.getCell(cellNum++);
			finalSalary.setPartTimeStoreSubsidy(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//岗位津贴
			cell = row.getCell(cellNum++);
			finalSalary.setPostAllowance(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//高温津贴
			cell = row.getCell(cellNum++);
			finalSalary.setHighTemperatureAllowance(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//司龄补贴
			cell = row.getCell(cellNum++);
			finalSalary.setServiceYearAllowance(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//应发工资合计
			cell = row.getCell(cellNum++);
			finalSalary.setTotalGrossSalary(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//工作餐补贴
			cell = row.getCell(cellNum++);
			finalSalary.setWorkingDinnerSubsidy(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//住宿补贴
			cell = row.getCell(cellNum++);
			finalSalary.setAccommodationSubsidy(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//过节费
			cell = row.getCell(cellNum++);
			finalSalary.setHolidayCosts(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//凉茶费、西瓜时刻
			cell = row.getCell(cellNum++);
			finalSalary.setHerbWatermelonTime(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//应发总合计
			cell = row.getCell(cellNum++);
			finalSalary.setGrossCombinationSalary(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//公积金
			cell = row.getCell(cellNum++);
			finalSalary.setStaffCostAccFund(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//养老保险
			cell = row.getCell(cellNum++);
			finalSalary.setStaffCostEndowment(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//失业保险
			cell = row.getCell(cellNum++);
			finalSalary.setStaffCostUnemployment(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//医疗保险
			cell = row.getCell(cellNum++);
			finalSalary.setStaffCostMedical(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//应税所得
			cell = row.getCell(cellNum++);
			finalSalary.setTaxableIncome(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//工资所得税
			cell = row.getCell(cellNum++);
			finalSalary.setWageTax(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//预扣补贴
			cell = row.getCell(cellNum++);
			finalSalary.setWithholdingSubsidies(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//话费扣款
			cell = row.getCell(cellNum++);
			finalSalary.setPhoneCost(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//应扣合计
			cell = row.getCell(cellNum++);
			finalSalary.setTotalCharge(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//应发工资
			cell = row.getCell(cellNum++);
			finalSalary.setNetPay(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//跳过 薪资差异额, 先不做设值
			cellNum++;
			
			//跳过 差异调整后应发工资
			cellNum++;
			
			//备注
			cell = row.getCell(cellNum++);
			finalSalary.setAfterNetPayRemark(excelUtil.getCellStringValue(cell));
			
			//其他计税事项
			cell = row.getCell(cellNum++);
			finalSalary.setOtherTaxMatters(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//应税总所得
			cell = row.getCell(cellNum++);
			finalSalary.setTotalTaxableIncome(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//所得税
			cell = row.getCell(cellNum++);
			finalSalary.setIncomeTax(excelUtil.getFormulaCellBigDecimalValue(cell));
			
			//跳过 未命名列, 最后一列, 先不做设值
			cellNum++;
			
			//年月份
			finalSalary.setYearMonth(ym);
			
			//将Excel中每一行的数据加入集合
			finalSalaryList.add(finalSalary);
		}
		
		//将Excel表中的所有数据全部入库
		finalSalaryService.insertFinalSalaryByList(finalSalaryList);
		//将上传的路径存入数据库中等待下载, 并 刷新是否已上传的数据
		salaryUploadService.uploadSalarySuccess(ym, filePath);
		return "redirect:/salaryUpload/salaryUploadList.do";
		
	}
	
	/**
	 * 下载
	 * 获取当前登录者的所属油站, 按照油站下载
	 * 每个油站的登录者只能下载本油站的薪资Excel表格, 权限之内, 不可下载别的油站的薪资Excel数据
	 */
	@RequestMapping("/salaryExport.do")
	public void salaryExport(HttpServletResponse response, HttpServletRequest request, 
							 String yearM, Model model) throws Exception {
		
		//下载前注意事项
		if (null != yearM && !"".equals(yearM)) {
			SalaryUpload salaryUpload = salaryUploadService.findSalaryUploadByYearM(yearM);
			if ("0".equals(salaryUpload.getIsUpload())) {
				Flag flag = new Flag();
				flag.setFlag("6");
				request.setAttribute("Flag", flag);
				request.getRequestDispatcher("/WEB-INF/jsp/salarymanagement/salaryupload/salaryUploadFlag.jsp")
					   .forward(request, response);
			}else{
				//准备下载数据
//				Calendar c = Calendar.getInstance();
//				int year = c.get(Calendar.YEAR);
//				int month = c.get(Calendar.MONTH);
//				//如果跨年的话, 要做特殊处理
//				String yearMonth = null;
//				if (0 == month) {
//					year = year - 1;
//					month = 12;
//					yearMonth = String.valueOf(year) + "-" + month; //得到的月份数是上个月份, 比如: 当前为2016-1, 获取的则为2015-12
//				}else{
//					String mon = String.valueOf(month);
//					if (month < 10) {
//						mon = "0" + mon;
//					}
//					yearMonth = String.valueOf(year) + "-" + mon; //得到的月份数是上个月份, 比如: 当前为2015-11, 获取的则为2015-10
//				}
				
				String year = yearM.substring(0, yearM.indexOf("-"));
				String month = yearM.substring(yearM.indexOf("-") + 1);
				
				//获取当前登录者所属油站信息
				StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
				String subOrganiseIdStr = storeEmployee.getSubOrganiseIdStr();
				if (null == subOrganiseIdStr || "".equals(subOrganiseIdStr)) {
					Flag flag = new Flag();
					flag.setFlag("8");
					request.setAttribute("Flag", flag);
					request.getRequestDispatcher("/WEB-INF/jsp/salarymanagement/salaryupload/salaryUploadFlag.jsp")
						   .forward(request, response);
				}else{
					//查询出stationCode对应的油站下所有的员工
					List<Staff> staffList = staffService.findStaffListByStationCode(subOrganiseIdStr);
					//遍历每一个员工, 将当前油站的员工以及对应月份的所有薪资记录导入至Excel中, 并提供下载
					List<FinalSalary> finalSalaryList = finalSalaryService.findFinalSalarysByStaffCode(staffList, yearM);
					if (null != finalSalaryList && finalSalaryList.size() != 0) {
						//创建Excel文件, 准备将数据循环导入至Excel中
						String excelTemplatePath = request.getSession().getServletContext().getRealPath("/template/GasStationSalaryAttendanceTemplate6.xlsx");
						@SuppressWarnings("resource")
						XSSFWorkbook xSFWorkbook = new XSSFWorkbook(new FileInputStream(excelTemplatePath));
						XSSFSheet sheet = (XSSFSheet) xSFWorkbook.getSheet("油站工资表模板");
						if (null == sheet || "".equals(sheet)) {
							Flag flag = new Flag();
							flag.setFlag("7");
							request.setAttribute("Flag", flag);
							request.getRequestDispatcher("/WEB-INF/jsp/salarymanagement/salaryupload/salaryUploadFlag.jsp")
								   .forward(request, response);
						}else{
							//设置第一行D列----->K列的值(加油站XX年XX月工资)
							XSSFRow xssfRow3 = sheet.getRow(0);
							XSSFCell xssfCell3 = xssfRow3.getCell(3);
							StringBuilder sb = new StringBuilder();
							sb.append("加油站")
							  .append(year).append("年")
						      .append(month).append("月工资");
							xssfCell3.setCellValue(sb.toString());
							
							//设置第二行A列日期(用于核算司龄补贴, 取每个月的最后一天)
							XSSFRow xssfRow2 = sheet.getRow(1);
							XSSFCell xssfCell2 = xssfRow2.getCell(0);
							
							Calendar c = Calendar.getInstance();
							c.set(Calendar.YEAR, Integer.parseInt(year));
							c.set(Calendar.MONTH, Integer.parseInt(month));
							c.set(Calendar.DAY_OF_MONTH, 1);
							c.add(Calendar.DAY_OF_MONTH, -1);
							int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
							
							sb = new StringBuilder();
							sb.append(String.valueOf(year)).append("/")
							  .append(month).append("/").append(String.valueOf(lastDay));
							xssfCell2.setCellValue(sb.toString());
							
							//定义好行数和单元格, 准备循环打印至Excel中
							XSSFRow row = null;
							XSSFCell cell = null;
							FinalSalary finalSalary = null;
							String stationName = finalSalaryList.get(0).getStationName();
							//初始化Excel行数和单元格数
							int rowNum = 3; 
							int cellNum = 0;
							//循环打印至Excel中
							for (int i = 0; i < finalSalaryList.size(); i++) {
								cellNum = 0;
								finalSalary = finalSalaryList.get(i);
								row = sheet.createRow(rowNum++);
								
								//关联数据(A列)
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAssociatedDataOne() && !"".equals(finalSalary.getAssociatedDataOne())) {
									cell.setCellValue(finalSalary.getAssociatedDataOne());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//关联数据(B列)
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAssociatedDataTwo() && !"".equals(finalSalary.getAssociatedDataTwo())) {
									cell.setCellValue(finalSalary.getAssociatedDataTwo());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//关联数据(C列)
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAssociatedDataThree() && !"".equals(finalSalary.getAssociatedDataThree())) {
									cell.setCellValue(finalSalary.getAssociatedDataThree());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//油站名称
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStationName() && !"".equals(finalSalary.getStationName())) {
									cell.setCellValue(finalSalary.getStationName());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//地区系数
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAreaName() && !"".equals(finalSalary.getAreaName())) {
									cell.setCellValue(finalSalary.getAreaName());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//油站星级
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStationLevelName() && !"".equals(finalSalary.getStationLevelName())) {
									cell.setCellValue(finalSalary.getStationLevelName());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//序号
								cell = row.createCell(cellNum++);
								cell.setCellValue(i);
								
								//员工编号
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffCode() && !"".equals(finalSalary.getStaffCode())) {
									cell.setCellValue(finalSalary.getStaffCode());
								}else{
									
								}
								
								//员工姓名
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffName() && !"".equals(finalSalary.getStaffName())) {
									cell.setCellValue(finalSalary.getStaffName());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//身份证号
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffIdcard() && !"".equals(finalSalary.getStaffIdcard())) {
									cell.setCellValue(finalSalary.getStaffIdcard());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//银行卡账号
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffBankcard() && !"".equals(finalSalary.getStaffBankcard())) {
									cell.setCellValue(finalSalary.getStaffBankcard());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//入职日期
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffBank() && !"".equals(finalSalary.getStaffBank())) {
									cell.setCellValue(finalSalary.getStaffBank());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//工作日
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getWorkingDay() && !"".equals(finalSalary.getWorkingDay())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getWorkingDay()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//是否管站/带班
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getIsStamanageForeman() && !"".equals(finalSalary.getIsStamanageForeman())) {
									cell.setCellValue(finalSalary.getIsStamanageForeman());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK); //设置单元格为null
								}
								
								//是否实习期内
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getIsInternship() && !"".equals(finalSalary.getIsInternship())) {
									cell.setCellValue(finalSalary.getIsInternship());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//本月实习期满后工作天数
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAfterIntershipWorking() && !"".equals(finalSalary.getAfterIntershipWorking())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getAfterIntershipWorking()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//平时超时
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPeacetimeTimeout() && !"".equals(finalSalary.getPeacetimeTimeout())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPeacetimeTimeout()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//节日加班
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getHolidayOvertime() && !"".equals(finalSalary.getHolidayOvertime())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getHolidayOvertime()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//年夜饭在岗
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getFamilyReunionDinnerOn() && !"".equals(finalSalary.getFamilyReunionDinnerOn())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getFamilyReunionDinnerOn()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//春节在岗(阶段一)
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getOnTheSpringFestivaOne() && !"".equals(finalSalary.getOnTheSpringFestivaOne())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getOnTheSpringFestivaOne()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//春节在岗(阶段二)
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getOnTheSpringFestivaTwo() && !"".equals(finalSalary.getOnTheSpringFestivaTwo())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getOnTheSpringFestivaTwo()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//本月离职
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getMonthDeparture() && !"".equals(finalSalary.getMonthDeparture())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getMonthDeparture()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//事假
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getCasualLeave() && !"".equals(finalSalary.getCasualLeave())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getCasualLeave()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//旷工
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAbsenteeism() && !"".equals(finalSalary.getAbsenteeism())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getAbsenteeism()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//病假
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getSickLeave() && !"".equals(finalSalary.getSickLeave())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getSickLeave()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//年假
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAnnualLeave() && !"".equals(finalSalary.getAnnualLeave())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getAnnualLeave()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//婚假
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getMarriageLeave() && !"".equals(finalSalary.getMarriageLeave())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getMarriageLeave()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//产假
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getMaternityLeave() && !"".equals(finalSalary.getMaternityLeave())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getMaternityLeave()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//丧假
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getFuneralLeave() && !"".equals(finalSalary.getFuneralLeave())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getFuneralLeave()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//调休
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getDaysOff() && !"".equals(finalSalary.getDaysOff())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getDaysOff()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//警告
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getVerbalWarnings() && !"".equals(finalSalary.getVerbalWarnings())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getVerbalWarnings()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//记过
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getWrittenWarning() && !"".equals(finalSalary.getWrittenWarning())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getWrittenWarning()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//重大事故
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getMajorAccident() && !"".equals(finalSalary.getMajorAccident())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getMajorAccident()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//是否保留宿舍
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getIsAccomodate() && !"".equals(finalSalary.getIsAccomodate())) {
									cell.setCellValue(finalSalary.getIsAccomodate());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								
								//是否搭伙
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getIsBoarder() && !"".equals(finalSalary.getIsBoarder())) {
									cell.setCellValue(finalSalary.getIsBoarder());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//精彩卡-蓝色版
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getSplendorCardBlue() && !"".equals(finalSalary.getSplendorCardBlue())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getSplendorCardBlue()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//精彩卡-绿色版
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getSplendorCardGreen() && !"".equals(finalSalary.getSplendorCardGreen())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getSplendorCardGreen()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//兼职便利店员比例
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPartTimeScale() && !"".equals(finalSalary.getPartTimeScale())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToPercentage(finalSalary.getPartTimeScale()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//月度绩效(100分制)
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getMonthPerformance() && !"".equals(finalSalary.getMonthPerformance())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getMonthPerformance()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//敬礼奖金分配比例
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getManagerBonusScale() && !"".equals(finalSalary.getManagerBonusScale())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToPercentage(finalSalary.getManagerBonusScale()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//备注
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getRemark() && !"".equals(finalSalary.getRemark())) {
									cell.setCellValue(finalSalary.getRemark());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//试用期系数
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getProbationCoefficient() && !"".equals(finalSalary.getProbationCoefficient())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getProbationCoefficient()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//工作系数
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getWorkingCoefficient() && !"".equals(finalSalary.getWorkingCoefficient())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getWorkingCoefficient()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//绩效系数
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPerformanceCoefficient() && !"".equals(finalSalary.getPerformanceCoefficient())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPerformanceCoefficient()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//岗位工时
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPostManHour() && !"".equals(finalSalary.getPostManHour())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPostManHour()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//岗位时薪
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPostHourSalary() && !"".equals(finalSalary.getPostHourSalary())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPostHourSalary()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//管理岗位油品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getManagePostOilBonus() && !"".equals(finalSalary.getManagePostOilBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getManagePostOilBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//一线员工油品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getFirstTierStaffOilBonus() && !"".equals(finalSalary.getFirstTierStaffOilBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getFirstTierStaffOilBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//管理岗位非油品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getManagePostNonOilBonus() && !"".equals(finalSalary.getManagePostNonOilBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getManagePostNonOilBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//一线员工非油品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getFirstTierStaffNonOilBonus() && !"".equals(finalSalary.getFirstTierStaffNonOilBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getFirstTierStaffNonOilBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//管理岗位管理奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getManagePostManageBonus() && !"".equals(finalSalary.getManagePostManageBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getManagePostManageBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//一线员工绩效奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getFirstTierStaffPerformanceBonus() && !"".equals(finalSalary.getFirstTierStaffPerformanceBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getFirstTierStaffPerformanceBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//岗位工资
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPostSalary() && !"".equals(finalSalary.getPostSalary())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPostSalary()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//加班津贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getOvertimeAllowance() && !"".equals(finalSalary.getOvertimeAllowance())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getOvertimeAllowance()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//油品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getOilBonus() && !"".equals(finalSalary.getOilBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getOilBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//非油品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getNonOilBonus() && !"".equals(finalSalary.getNonOilBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getNonOilBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//星级/绩效奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStarLevelPerformanceBonus() && !"".equals(finalSalary.getStarLevelPerformanceBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getStarLevelPerformanceBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//经理奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getManagerBonus() && !"".equals(finalSalary.getManagerBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getManagerBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//业绩挑战奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPerformanceChallengeBonus() && !"".equals(finalSalary.getPerformanceChallengeBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPerformanceChallengeBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//促销品奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPromotionsBonus() && !"".equals(finalSalary.getPromotionsBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPromotionsBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//金点子奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getGoldIdeaBonus() && !"".equals(finalSalary.getGoldIdeaBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getGoldIdeaBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//年度奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAnnualBonus() && !"".equals(finalSalary.getAnnualBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getAnnualBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//精彩卡奖金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getSplendorCardBonus() && !"".equals(finalSalary.getSplendorCardBonus())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getSplendorCardBonus()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//兼职便利店补贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPartTimeStoreSubsidy() && !"".equals(finalSalary.getPartTimeStoreSubsidy())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPartTimeStoreSubsidy()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//岗位津贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPostAllowance() && !"".equals(finalSalary.getPostAllowance())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPostAllowance()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//高温津贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getHighTemperatureAllowance() && !"".equals(finalSalary.getHighTemperatureAllowance())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getHighTemperatureAllowance()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//司龄补贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getServiceYearAllowance() && !"".equals(finalSalary.getServiceYearAllowance())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getServiceYearAllowance()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//应发工资合计
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getTotalGrossSalary() && !"".equals(finalSalary.getTotalGrossSalary())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getTotalGrossSalary()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//工作餐补贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getWorkingDinnerSubsidy() && !"".equals(finalSalary.getWorkingDinnerSubsidy())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getWorkingDinnerSubsidy()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//住宿补贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAccommodationSubsidy() && !"".equals(finalSalary.getAccommodationSubsidy())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getAccommodationSubsidy()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//过节费
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getHolidayCosts() && !"".equals(finalSalary.getHolidayCosts())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getHolidayCosts()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//凉茶费、西瓜时刻
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getHerbWatermelonTime() && !"".equals(finalSalary.getHerbWatermelonTime())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getHerbWatermelonTime()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//应发总合计
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getGrossCombinationSalary() && !"".equals(finalSalary.getGrossCombinationSalary())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getGrossCombinationSalary()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//公积金
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffCostAccFund() && !"".equals(finalSalary.getStaffCostAccFund())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getStaffCostAccFund()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//养老保险
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffCostEndowment() && !"".equals(finalSalary.getStaffCostEndowment())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getStaffCostEndowment()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//失业保险
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffCostUnemployment() && !"".equals(finalSalary.getStaffCostUnemployment())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getStaffCostUnemployment()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//医疗保险
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getStaffCostMedical() && !"".equals(finalSalary.getStaffCostMedical())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getStaffCostMedical()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//应税所得
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getTaxableIncome() && !"".equals(finalSalary.getTaxableIncome())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getTaxableIncome()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//工资所得税
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getWageTax() && !"".equals(finalSalary.getWageTax())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getWageTax()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//预扣补贴
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getWithholdingSubsidies() && !"".equals(finalSalary.getWithholdingSubsidies())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getWithholdingSubsidies()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//话费扣款
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getPhoneCost() && !"".equals(finalSalary.getPhoneCost())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getPhoneCost()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//应扣合计
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getTotalCharge() && !"".equals(finalSalary.getTotalCharge())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getTotalCharge()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//应发工资
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getNetPay() && !"".equals(finalSalary.getNetPay())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getNetPay()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//备注
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getAfterNetPayRemark() && !"".equals(finalSalary.getAfterNetPayRemark())) {
									cell.setCellValue(finalSalary.getAfterNetPayRemark());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//其他计税事项
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getOtherTaxMatters() && !"".equals(finalSalary.getOtherTaxMatters())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getOtherTaxMatters()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//应税总所得
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getTotalTaxableIncome() && !"".equals(finalSalary.getTotalTaxableIncome())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getTotalTaxableIncome()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//所得税
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getIncomeTax() && !"".equals(finalSalary.getIncomeTax())) {
									cell.setCellValue(DataTypeConversion.bigDecimalToString(finalSalary.getIncomeTax()));
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
								
								//最后一列
								cell = row.createCell(cellNum++);
								if (null != finalSalary.getUnnamedStaffCount() && !"".equals(finalSalary.getUnnamedStaffCount())) {
									cell.setCellValue(finalSalary.getUnnamedStaffCount());
								}else{
									cell.setCellType(XSSFCell.CELL_TYPE_BLANK);
								}
							}
							
							// 导出Excel
							DownloadUtil download = new DownloadUtil();
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							xSFWorkbook.write(baos);
							baos.flush();
							baos.close();
							download.download(baos, response, stationName + "分站Excel薪资测试表.xlsx");
//							//下载文件名
//							StringBuilder sb = new StringBuilder();
//							sb.append("中化石油福建分公司").append(yearM.substring(yearM.indexOf("-") + 1)).append("月薪资表.xlsx");
//							String fileName = sb.toString(); 
//							//解决中文乱码问题
//							String userAgent = request.getHeader("User-Agent");
//							if (userAgent.toLowerCase().contains("firefox")) { //火狐浏览器例外
//								fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//							}else{
//								fileName = URLEncoder.encode(fileName, "UTF-8");
//							}
//							
//							//下载文件URL
//							String uploadUrl = salaryUpload.getUploadUrl(); 
//							//构建输入流
//							InputStream in = new FileInputStream(new File(uploadUrl));
//							//下载
//							response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//							OutputStream out = response.getOutputStream();
//							int len = -1;
//							byte buf[] = new byte[1024];
//							while ((len = in.read(buf)) != -1) {
//								out.write(buf, 0, len);
//							}
//							in.close();
						}
					}else{
						Flag flag = new Flag();
						flag.setFlag("8");
						request.setAttribute("Flag", flag);
						request.getRequestDispatcher("/WEB-INF/jsp/salarymanagement/salaryupload/salaryUploadFlag.jsp")
							   .forward(request, response);
					}
				}
			}
		}else{
			Flag flag = new Flag();
			flag.setFlag("5");
			request.setAttribute("Flag", flag);
			request.getRequestDispatcher("/WEB-INF/jsp/salarymanagement/salaryupload/salaryUploadFlag.jsp")
				   .forward(request, response);
		}
		
	}
	
}
