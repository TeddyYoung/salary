package com.fh.controller.salarymanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.entity.biz.AttendanceManagement;
import com.fh.entity.biz.Duty;
import com.fh.entity.biz.Holiday;
import com.fh.entity.biz.ManageBase;
import com.fh.entity.biz.StaffCost;
//import com.fh.entity.biz.Station;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTrial;
import com.fh.entity.system.OrganiseCO;
import com.fh.service.attendance.AttendanceManagementService;
import com.fh.service.masterdata.HolidayService;
//import com.fh.service.masterdata.IndexConfigService;
//import com.fh.service.masterdata.StandardBonusSetupService;
import com.fh.service.masterdata.StationTargetService;
import com.fh.service.operation.ManageBaseService;
import com.fh.service.salarymanagement.StationTrialService;
import com.fh.service.station.StaffCostService;
import com.fh.service.system.OrganiseCOService;
import com.fh.util.Constants;
import com.fh.util.DateUtil;
import com.fh.util.FileUtil;
import com.fh.util.ZipUtil;

/**
 * 薪资试算Controller 人力资源部导出全站的薪资试算Excel
 * 
 * @author zhang_yu
 *
 */
@Controller(value = "stationTrialController")
@RequestMapping({ "/stationTrial" })
public class StationTrialController {

	private static Logger log = LoggerFactory
			.getLogger(StationTrialController.class);

	@Autowired
	private StationTrialService stationTrialService;
	@Autowired
	private StationTargetService stationTargetService;
	@Autowired
	private AttendanceManagementService attendanceManagementService;
	// @Autowired
	// private IndexConfigService indexConfigService;
	// @Autowired
	// private StandardBonusSetupService standardBonusSetupService;
	@Autowired
	private StaffCostService staffCostService;
	@Autowired
	private ManageBaseService manageBaseService;
	@Autowired
	private OrganiseCOService organiseCOService;

	@Autowired
	private HolidayService holidayService;

	// @Autowired
	// private StationService stationService;
	// @Autowired
	// private StaffService staffService;

	/**
	 * 薪资试算列表
	 */
	@RequestMapping("/stationTrialList.do")
	public String stationTrialList(Page page, StationTrial stationTrial,
			Model model) {

		// 判断上个月的薪资是否上传记录在数据库中是否有存档
		// 如果没有, 造一条进去

		if ("".equals(stationTrial.getYearMonth())) {
			stationTrial.setYearMonth(null);
		}
		Page pageList = stationTrialService.findSalaryTrialsByPage(page,
				stationTrial.getYearMonth());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", stationTrial);
		return "salarymanagement/stationtrial/stationTrialList";

	}

	/**
	 * 按区域导出最终薪资
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("exportStationTrial.do")
	public String exportStationTrial(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<OrganiseCO> organiseCOList = this.organiseCOService
				.findListOrganiseCOByPOrganiseId("Z001");
		List<File> srcfile = new ArrayList<File>();
		for (OrganiseCO organiseCO : organiseCOList) {
			try {
				if (!"Z001_B".equals(organiseCO.getOrganiseId())) {
					System.out.println("==================:"
							+ organiseCO.getOrganiseId());
					continue;
				}
				// System.out.println("开始计算============"+JSON.toJSONString(organiseCO));
				this.calculateSalary(request, response, organiseCO, srcfile);
			} catch (Exception e) {
				log.error("薪资计算异常===========organiseId："
						+ organiseCO.getOrganiseId());
				throw e;
			}

		}

		String yearMonth = getYearMonth();
		String excelPath = request.getSession().getServletContext()
				.getRealPath("/uploadFiles")
				+ "/" + yearMonth + "/";
		String fileName = "中化福建" + yearMonth + "薪资表.zip";
		File zipfile = new File(excelPath + fileName);
		ZipUtil.zipFiles(srcfile, zipfile);

		// // 下载Zip文件
		// DownloadUtil downloadUtil = new DownloadUtil();
		// downloadUtil.download(excelPath + fileName, fileName, response,
		// false);

		// 保存一条薪资试算信息
		Page page = new Page();
		page = this.stationTrialService.findSalaryTrialsByPage(page, yearMonth);
		StationTrial stationTrial = null;
		if (page == null || page.getRecords() == null
				|| page.getRecords().size() <= 0) {
			stationTrial = new StationTrial();
			stationTrial.setYearMonth(yearMonth);
			stationTrial.setIsTrial("1");
			// stationTrial.setStationTrialCode(excelPath + fileName);
			this.stationTrialService.saveOrUpdate(stationTrial);
		}

		return "redirect:/stationTrial/stationTrialList.do";
	}

	/**
	 * 计算薪资并导出excel - 按区域 Excel中包含三张Sheet: 油站基础数据、员工数据、全站的油站工资表
	 */
	private void calculateSalary(HttpServletRequest request,
			HttpServletResponse response, OrganiseCO organiseCO,
			List<File> srcfile) throws Exception {
		// long beginTime = System.currentTimeMillis();
		String yearMonth = getYearMonth();

		// 校验数据合法性
		String resultStr = checkData(yearMonth);
		if (resultStr != null && !"".equals(resultStr)) {
			// throw new Exception("上月数据录入不完整，无法导出薪资");// TODO 回头把提示信息做得更细
			// return "redirect:/stationTrial/stationTrialList.do?resultStr=" +
			// resultStr;
			return;
		}

		// 查找油站基础数据
		List<StationTarget> stationTargetList = stationTargetService
				.findStationBaseDataByYearMonth(yearMonth,
						organiseCO.getOrganiseId());
		// 查找员工考勤数据
		List<AttendanceManagement> attendanceManagementList = attendanceManagementService
				.findAllAttendanceManagementsByYearMonth(yearMonth,
						organiseCO.getOrganiseId());
		// 查找员工数据
		List<StaffCost> staffCostList = staffCostService
				.findStaffCostsByYearMonth(yearMonth,
						organiseCO.getOrganiseId());
		// 查找管理岗位数据
		List<ManageBase> manageBaseList = manageBaseService
				.findManageBaseListByYearMonth(yearMonth,
						organiseCO.getOrganiseId());
		List<ManageBase> stationManageList = manageBaseService.findManageList(
				yearMonth, organiseCO.getOrganiseId()); // 油站经理
		List<ManageBase> stationAccountantList = manageBaseService
				.findBursarList(yearMonth, organiseCO.getOrganiseId()); // 油站会计
		List<ManageBase> standingMAList = manageBaseService.findPartList(
				yearMonth, organiseCO.getOrganiseId()); // 兼站经理/会计
		// 补贴列表
		List<Holiday> subsibyList = holidayService.findByYearMonth(yearMonth);
		// // 查询油站信息
		// List<Station> stationList =
		// stationService.findAllStationWithStationTypeName();
		// 查询所有的员工数据
		// List<Staff> staffList = staffService.findAllStaffWithWorkingDay(); //
		// TODO
		// 查询IndexConfig, 为MMP和NPS系数做准备
		// List<IndexConfig> indexConfigList =
		// indexConfigService.findIndexConfigs();
		// 查询StandardBonusSetup
		// List<StandardBonusSetup> sbsList =
		// standardBonusSetupService.queryAll();
		String excelTemplatePath = request.getSession().getServletContext()
				.getRealPath("/template/SalaryTrial_Template.xlsx");
		XSSFWorkbook xSFWorkbook = new XSSFWorkbook(new FileInputStream(
				excelTemplatePath));

		// 1、解析油站基础数据Sheet
		this.analyzeSheet1(xSFWorkbook.getSheet("1.2.油站基础数据"),
				stationTargetList);
		// 2、解析员工数据Sheet
		this.analyzeSheet2(xSFWorkbook.getSheet("2.员工数据"), staffCostList);
		// 3、解析管理岗位数据Sheet
		this.analyzeSheet3(xSFWorkbook.getSheet("3.管理岗位数据"), manageBaseList,
				stationManageList, stationAccountantList, standingMAList);
		// 4、解析薪资试算Sheet
		this.analyzeSheet4(xSFWorkbook, attendanceManagementList,
				staffCostList, subsibyList);

		// System.out.println(System.currentTimeMillis() - beginTime);

		// 生成excel
		String excelPath = request.getSession().getServletContext()
				.getRealPath("/uploadFiles")
				+ "/" + yearMonth + "/";
		FileUtil.createDir(excelPath);
		String fileName = "中化福建" + yearMonth + organiseCO.getOrganiseName()
				+ "薪资表.xlsx";
		File file = new File(excelPath + fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		xSFWorkbook.write(fos);
		xSFWorkbook.close();
		fos.flush();
		fos.close();

		srcfile.add(file);

		// System.out.println(System.currentTimeMillis() - beginTime);
	}

	// 校验数据合法性
	private String checkData(String yearMonth) {
		String resultStr = null;
		int stationTargetCount = stationTargetService
				.findStationTargetsCountByYearMonth(yearMonth);
		if (stationTargetCount == 0) {// 校验上月的油站基础数据是否已录入
			resultStr = "请检查营运数据是否完全录入";
			return resultStr;
		}
		int attendanceManagementCount = attendanceManagementService
				.findAllAttendanceManagementByYearMonth(yearMonth);
		if (attendanceManagementCount == 0) {// 校验上月的员工考勤数据是否已录入
			resultStr = "请检查员工考勤数据是否完全录入";
			return resultStr;
		}
		int staffCostCount = staffCostService
				.findAllStaffCostCountByYearMonth(yearMonth);
		if (staffCostCount == 0) {// 校验上月的员工成本数据是否已录入
			resultStr = "请检查员工成本数据是否完全录入";
			return resultStr;
		}
		// int manageBaseCount =
		// manageBaseService.findAllManageBaseCountByYearMonth(yearMonth);
		// if (manageBaseCount == 0){// 校验上月的管理岗位数据是否已录入
		// resultStr = "请检查管理岗位数据是否完全录入";
		// return resultStr;
		// }
		return resultStr;
	}

	// 解析油站基础数据
	private void analyzeSheet1(XSSFSheet sheet,
			List<StationTarget> stationTargetList) {
		System.out.println("sheet1.getSheetName() : " + sheet.getSheetName());
		System.out.println("sheet1.getLastRowNum() : " + sheet.getLastRowNum());

		int lastDay = getLastDayOfMonth();
		XSSFRow row1 = sheet.getRow(0);// 第一行
		row1.getCell(3).setCellValue(lastDay);// 设置第1行D列: xx天（本月天数）

		// 设置起始单元格位置, 准备将数据循环至Excel中
		int rowNum1 = 3;// 起始行： 第4行
		// 循环打印数据
		StationTarget stationTarget = null;
		for (int i = 0; i < stationTargetList.size(); i++) {
			int cellNum1 = 0;// 起始列： A列
			stationTarget = stationTargetList.get(i);
			row1 = sheet.getRow(rowNum1++);// 获取每行
			row1.getCell(cellNum1++);// 隐藏列A
			row1.getCell(cellNum1++);// 隐藏列B
			// 区域
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getDistrictName() == null ? ""
							: stationTarget.getDistrictName());
			// 序号
			row1.getCell(cellNum1++).setCellValue(i + 1);
			// 油站名称
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getStationName() == null ? "" : stationTarget
							.getStationName());
			// 编制数
			if (stationTarget.getStationStaffNumFloat() == null) {
				stationTarget.setStationStaffNumFloat(0);
			}
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getStationStaffNum() == null ? 0
							: stationTarget.getStationStaffNum().doubleValue()
									+ stationTarget.getStationStaffNumFloat()
											.doubleValue());
			// 地区类型
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getAreaName() == null ? "" : stationTarget
							.getAreaName());
			// 本月星站
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getStationLevelName() == null ? ""
							: stationTarget.getStationLevelName());
			// 是否保留宿舍 TODO 需要从数据库中获取
			row1.getCell(cellNum1++).setCellValue("是");
			// 宿舍补贴
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());// 使用excel自带公式
			// 便利店业绩得分
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getStoreMarkScore() == null ? 0
							: stationTarget.getStoreMarkScore().doubleValue());
			// 便利店管理得分
			row1.getCell(cellNum1++)
					.setCellValue(
							stationTarget.getStoreManageScore() == null ? 0
									: stationTarget.getStoreManageScore()
											.doubleValue());
			// 月度便利店津贴
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());// 使用excel自带公式
			// 油品本月目标销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getOilTargetVolume() == null ? 0
							: stationTarget.getOilTargetVolume().doubleValue());
			// 油品本月实际销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getOilRealVolume() == null ? 0
							: stationTarget.getOilRealVolume().doubleValue());
			// 油品日均销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getOilDayAverageVolume() == null ? 0
							: stationTarget.getOilDayAverageVolume()
									.doubleValue());
			// 汽油日均销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getGasolineDayAverageVolume() == null ? 0
							: stationTarget.getGasolineDayAverageVolume()
									.doubleValue());
			// 柴油日均销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getDieselDayAverageVolume() == null ? 0
							: stationTarget.getDieselDayAverageVolume()
									.doubleValue());
			// 油品达标率
			// row1.getCell(cellNum1).setCellFormula(row1.getCell(cellNum1++).getCellFormula());
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getOilStandardRate().doubleValue());
			// 非油品本月目标销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getNonOilTargetVolume() == null ? 0
							: stationTarget.getNonOilTargetVolume()
									.doubleValue());
			// 非油品本月实际销量
			row1.getCell(cellNum1++)
					.setCellValue(
							stationTarget.getNonOilRealVolume() == null ? 0
									: stationTarget.getNonOilRealVolume()
											.doubleValue());
			// 非油品日均销量
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getNonOilDayAverageVolume() == null ? 0
							: stationTarget.getNonOilDayAverageVolume()
									.doubleValue());
			// 非油品达标率
			// row1.getCell(cellNum1).setCellFormula(row1.getCell(cellNum1++).getCellFormula());
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getNonOilStandardRate().doubleValue());
			// 油站经理小配、直销奖金
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getDirectSellingBonus() == null ? 0
							: stationTarget.getDirectSellingBonus()
									.doubleValue());
			// 上限 可直接取模板的值，不做任何处理
			row1.getCell(cellNum1++);
			// MMP
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getMmp() == null ? 0 : stationTarget.getMmp()
							.doubleValue());
			// MMP系数
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// NPS
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getNps() == null ? 0 : stationTarget.getNps()
							.doubleValue());
			// NPS系数
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 加权系数
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 月度经理管理奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 月度经理油品达标奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 月度经理非油品达标奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 月度经理奖金合计
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 月度销售油品奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 月度非油品销售奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 本月油品奖金(月度销售油品奖金 * 加权系数)
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 本月非油品奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 36000以上保护措施
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 本月应发油品奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 油站会计对应油站类型数据源-油站名称
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getStationName() == null ? "" : stationTarget
							.getStationName());
			// 油站会计对应油站类型数据源-油站类型
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getStationType() == null ? "" : stationTarget
							.getStationType());
			// 油站会计奖金基数
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 会计奖金油站类型
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 业绩挑战奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 定编数 + 管理人员
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 搭伙补贴
			row1.getCell(cellNum1++)
					.setCellValue(
							stationTarget.getBoarderSubsidies() == null ? 0
									: stationTarget.getBoarderSubsidies()
											.doubleValue());
			// 本月管理岗位人数
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 实际人数
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 本月管理岗位数量计算列-油站名称 TODO
			row1.getCell(cellNum1++);
			// 本月管理岗位数量计算列-员工名称 TODO
			row1.getCell(cellNum1++);
			// 本月管理岗位数量计算列-员工职务(油站经理、油站会计、见习经理、见习会计)
			row1.getCell(cellNum1++);
			// 本月管理岗位数量计算列-工作日
			row1.getCell(cellNum1++);
			// 业绩挑战奖金-基础目标
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getBaseTarget() == null ? 0 : stationTarget
							.getBaseTarget().doubleValue());
			// 业绩挑战奖金-挑战目标
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getChallengeTarget() == null ? 0
							: stationTarget.getChallengeTarget().doubleValue());
			// 业绩挑战奖金-基础奖金（即中间奖金）
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getBaseBonusAmt() == null ? 0 : stationTarget
							.getBaseBonusAmt().doubleValue());
			// 业绩挑战奖金-挑战奖金
			row1.getCell(cellNum1++).setCellValue(
					stationTarget.getChallengeBonusAmt() == null ? 0
							: stationTarget.getChallengeBonusAmt()
									.doubleValue());
			// 业绩挑战奖金-本月奖金
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 放空一列
			row1.getCell(cellNum1++);
			// 倒2列
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 倒1列
			row1.getCell(cellNum1).setCellFormula(
					row1.getCell(cellNum1++).getCellFormula());
			// 本月天数
			row1.getCell(cellNum1++).setCellValue(DateUtil.getActualMaximum());
			row1.getCell(cellNum1++);
			// 非油品业绩挑战奖金
			// 非油品业绩挑战奖金-基础目标
			// row1.getCell(cellNum1++).setCellValue(stationTarget.getNonOilBaseTarget()
			// == null ? 0 : stationTarget.getNonOilBaseTarget().doubleValue());
			createCell(row1, cellNum1++, stationTarget.getNonOilBaseTarget());
			// 非油品业绩挑战奖金-挑战目标
			// row1.getCell(cellNum1++).setCellValue(stationTarget.getNonOilChallengeTarget()
			// == null? 0:
			// stationTarget.getNonOilChallengeTarget().doubleValue());
			createCell(row1, cellNum1++,
					stationTarget.getNonOilChallengeTarget());
			// 非油品业绩挑战奖金-基础奖金（即中间奖金）
			// row1.getCell(cellNum1++).setCellValue(stationTarget.getNonOilBaseBonusAmt()
			// == null? 0: stationTarget.getNonOilBaseBonusAmt().doubleValue());
			createCell(row1, cellNum1++, stationTarget.getNonOilBaseBonusAmt());
			// 非油品业绩挑战奖金-挑战奖金
			// row1.getCell(cellNum1++).setCellValue(stationTarget.getNonOilChallengeBonusAmt()
			// == null? 0:
			// stationTarget.getNonOilChallengeBonusAmt().doubleValue());
			createCell(row1, cellNum1++,
					stationTarget.getNonOilChallengeBonusAmt());
			// 非油品业绩挑战奖金-本月奖金
			// row1.getCell(cellNum1).setCellFormula(row1.getCell(cellNum1++).getCellFormula());

		}

		sheet.setForceFormulaRecalculation(true);
		// 删除剩下的所有行数据
		for (int i = row1.getRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			sheet.removeRow(sheet.getRow(i));
		}
	}

	private void createCell(XSSFRow row, int cellNum, Object obj) {
		if (row != null) {
			if (obj == null) {
				obj = 0;
			}
			if (row.getCell(cellNum) != null) {
				row.getCell(cellNum).setCellValue(
						Double.valueOf(obj.toString()));
			} else {
				row.createCell(cellNum).setCellValue(
						Double.valueOf(obj.toString()));
			}
		}
	}

	// 解析员工数据
	private void analyzeSheet2(XSSFSheet sheet, List<StaffCost> staffCostList) {
		System.out.println("sheet2.getSheetName() : " + sheet.getSheetName());
		System.out.println("sheet2.getLastRowNum() : " + sheet.getLastRowNum());
		sheet.setForceFormulaRecalculation(true);

		int rowNum2 = 2;
		XSSFRow row2 = sheet.getRow(rowNum2);
		for (int i = 0; i < staffCostList.size(); i++) {
			StaffCost staffCost = staffCostList.get(i);
			int cellNum2 = 0;
			row2 = sheet.getRow(rowNum2++);

			// 关联检索(油站名称 + 姓名)
			row2.getCell(cellNum2).setCellFormula(
					row2.getCell(cellNum2++).getCellFormula());
			// 油站名称
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStationName() == null ? "" : staffCost
							.getStationName());
			// 姓名
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffName() == null ? "" : staffCost
							.getStaffName());
			// 身份证号
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffIdcard() == null ? "" : staffCost
							.getStaffIdcard());
			// 共计
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getTotal() == null ? 0 : staffCost.getTotal()
							.doubleValue());
			// 检测
			row2.getCell(cellNum2).setCellFormula(
					row2.getCell(cellNum2++).getCellFormula());
			// 中间空一格
			row2.getCell(cellNum2).setCellFormula(
					row2.getCell(cellNum2++).getCellFormula());

			// 如果员工成本四项都为0，则不填写到excel中
			if ((staffCost.getStaffCostAccFund() == null || staffCost
					.getStaffCostAccFund().compareTo(BigDecimal.ZERO) == 0)
					&& (staffCost.getStaffCostEndowment() == null || staffCost
							.getStaffCostEndowment().compareTo(BigDecimal.ZERO) == 0)
					&& (staffCost.getStaffCostUnemployment() == null || staffCost
							.getStaffCostUnemployment().compareTo(
									BigDecimal.ZERO) == 0)
					&& (staffCost.getStaffCostMedical() == null || staffCost
							.getStaffCostMedical().compareTo(BigDecimal.ZERO) == 0)) {
				continue;
			}
			// 五险一金
			// 关联检索(油站名称 + 姓名)
			row2.getCell(cellNum2).setCellFormula(
					row2.getCell(cellNum2++).getCellFormula());
			// 油站名称
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStationName() == null ? "" : staffCost
							.getStationName());
			// 姓名
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffName() == null ? "" : staffCost
							.getStaffName());
			// 公积金
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffCostAccFund() == null ? 0 : staffCost
							.getStaffCostAccFund().doubleValue());
			// 养老保险
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffCostEndowment() == null ? 0 : staffCost
							.getStaffCostEndowment().doubleValue());
			// 失业保险
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffCostUnemployment() == null ? 0
							: staffCost.getStaffCostUnemployment()
									.doubleValue());
			// 医疗保险
			row2.getCell(cellNum2++).setCellValue(
					staffCost.getStaffCostMedical() == null ? 0 : staffCost
							.getStaffCostMedical().doubleValue());
		}
		// 删除剩下的所有行数据
		for (int i = row2.getRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			sheet.removeRow(sheet.getRow(i));
		}
	}

	// 解析管理岗位数据
	private void analyzeSheet3(XSSFSheet sheet,
			List<ManageBase> manageBaseList,
			List<ManageBase> stationManageList,
			List<ManageBase> stationAccountantList,
			List<ManageBase> standingMAList) {
		System.out.println("sheet4.getSheetName() : " + sheet.getSheetName());

		// 将3个部分的数据准备好
		// List<ManageBase> stationManageList = new ArrayList<ManageBase>();
		// //油站经理
		// List<ManageBase> stationAccountantList = new ArrayList<ManageBase>();
		// //油站会计
		// List<ManageBase> standingMAList = new ArrayList<ManageBase>();
		// //兼站经理/会计
		// for (ManageBase manageBase : manageBaseList) {
		// if (("油站经理".equals(manageBase.getNewDutyName()) ||
		// "兼站经理".equals(manageBase.getNewDutyName())
		// || "见习经理".equals(manageBase.getNewDutyName())) &&
		// (null == manageBase.getBonusBase() ||
		// "".equals(manageBase.getBonusBase()))) {
		// stationManageList.add(manageBase);
		// }else if (("油站会计".equals(manageBase.getNewDutyName()) ||
		// "兼站会计".equals(manageBase.getNewDutyName())
		// || "见习会计".equals(manageBase.getNewDutyName())) &&
		// (null == manageBase.getBonusBase() ||
		// "".equals(manageBase.getBonusBase()))) {
		// stationAccountantList.add(manageBase);
		// }else if (("兼站经理".equals(manageBase.getNewDutyName()) ||
		// "兼站会计".equals(manageBase.getNewDutyName())) &&
		// (null != manageBase.getBonusBase() &&
		// !"".equals(manageBase.getBonusBase()))) {
		// standingMAList.add(manageBase);
		// }
		// }

		int rowNum4 = 2;
		int cellNum4 = 0;
		XSSFRow row4 = sheet.getRow(rowNum4);
		// 第一部分数据: 油站经理
		if (null != stationManageList && stationManageList.size() > 0) {
			for (int i = 0; i < stationManageList.size(); i++) {
				ManageBase stationManage = stationManageList.get(i);
				cellNum4 = 0;
				row4 = sheet.getRow(rowNum4++);
				// 关联检索(姓名 + 职务)
				row4.getCell(cellNum4).setCellFormula(
						row4.getCell(cellNum4++).getCellFormula());// 直接取公式
				// 姓名
				row4.getCell(cellNum4++).setCellValue(
						stationManage.getStaffName() == null ? ""
								: stationManage.getStaffName());
				// 职务
				row4.getCell(cellNum4++).setCellValue(
						stationManage.getNewDutyName() == null ? ""
								: stationManage.getNewDutyName());
				// 岗位工资
				row4.getCell(cellNum4++).setCellValue(
						stationManage.getNewPostSalary() == null ? 0
								: stationManage.getNewPostSalary()
										.doubleValue());
				// 话费扣款
				row4.getCell(cellNum4).setCellFormula(
						row4.getCell(cellNum4++).getCellFormula());// 直接取公式
				// 岗位津贴
				row4.getCell(cellNum4++)
						.setCellValue(
								stationManage.getJobSubsidies() == null ? 0
										: stationManage.getJobSubsidies()
												.doubleValue());
				// 月度绩效系数
				row4.getCell(cellNum4++).setCellValue(
						stationManage.getPerformanceCoefficient() == null ? 0
								: stationManage.getPerformanceCoefficient()
										.doubleValue());
			}
		}

		// 第二部分数据: 油站会计
		if (null != stationAccountantList && stationAccountantList.size() > 0) {
			rowNum4 = 2;
			for (int i = 0; i < stationAccountantList.size(); i++) {
				row4 = sheet.getRow(rowNum4++);
				ManageBase stationAccount = stationAccountantList.get(i);
				cellNum4 = 7;
				// 关联检索(姓名 + 职务)
				row4.getCell(cellNum4).setCellFormula(
						row4.getCell(cellNum4++).getCellFormula());// 直接取公式
				// // 员工编号
				// row4.getCell(cellNum4++).setCellValue(stationAccount.getStaffCode()
				// == null? "": stationAccount.getStaffCode());
				// 姓名
				row4.getCell(cellNum4++).setCellValue(
						stationAccount.getStaffName() == null ? ""
								: stationAccount.getStaffName());
				// 职务
				row4.getCell(cellNum4++).setCellValue(
						stationAccount.getNewDutyName() == null ? ""
								: stationAccount.getNewDutyName());
				// 岗位工资
				row4.getCell(cellNum4++).setCellValue(
						stationAccount.getNewPostSalary() == null ? 0
								: stationAccount.getNewPostSalary()
										.doubleValue());
				// 话费扣款
				row4.getCell(cellNum4).setCellFormula(
						row4.getCell(cellNum4++).getCellFormula());// 直接取公式
				// 岗位津贴
				row4.getCell(cellNum4++).setCellValue(
						stationAccount.getJobSubsidies() == null ? 0
								: stationAccount.getJobSubsidies()
										.doubleValue());
				// 月度绩效系数
				row4.getCell(cellNum4++).setCellValue(
						stationAccount.getPerformanceCoefficient() == null ? 0
								: stationAccount.getPerformanceCoefficient()
										.doubleValue());
			}
		}

		// 第3部分数据：话费扣款明细
		if (manageBaseList != null && manageBaseList.size() > 0) {
			rowNum4 = 2;
			for (int j = 0; j < manageBaseList.size(); j++) {
				row4 = sheet.getRow(rowNum4++);
				cellNum4 = 15;
				ManageBase manageBase = manageBaseList.get(j);
				if (manageBase.getPhoneCost() != null
						&& manageBase.getPhoneCost().compareTo(
								new BigDecimal(0)) > 0) {// 话费金额大于0 时才写到excel中
					// 员工姓名
					row4.getCell(cellNum4++).setCellValue(
							manageBase.getStaffName() == null ? "" : manageBase
									.getStaffName());
					// 话费明细
					row4.getCell(cellNum4++).setCellValue(
							manageBase.getPhoneCost() == null ? 0 : manageBase
									.getPhoneCost().doubleValue());
				}
			}
		}

		// 第4部分数据: 兼站会计/经理
		if (null != standingMAList && standingMAList.size() != 0) {
			rowNum4 = 2;
			for (int i = 0; i < standingMAList.size(); i++) {
				row4 = sheet.getRow(rowNum4++);
				if (i < standingMAList.size()) {
					ManageBase standingMA = standingMAList.get(i);
					cellNum4 = 17;
					// 油站
					row4.getCell(cellNum4++).setCellValue(
							standingMA.getStationName() == null ? ""
									: standingMA.getStationName());
					// 姓名
					row4.getCell(cellNum4++).setCellValue(
							standingMA.getStaffName() == null ? "" : standingMA
									.getStaffName());
					// 关联检索
					row4.getCell(cellNum4).setCellFormula(
							row4.getCell(cellNum4++).getCellFormula());// 直接取公式
					// 职务
					row4.getCell(cellNum4++).setCellValue(
							standingMA.getNewDutyName() == null ? ""
									: standingMA.getNewDutyName());
					// 兼站奖金基数
					row4.getCell(cellNum4++).setCellValue(
							standingMA.getBonusBase() == null ? 0 : standingMA
									.getBonusBase().doubleValue());
					// 达标率
					row4.getCell(cellNum4).setCellFormula(
							row4.getCell(cellNum4++).getCellFormula());// 直接取公式
					// 月度绩效系数
					// row4.getCell(cellNum4).setCellFormula(row4.getCell(cellNum4++).getCellFormula());//
					// 直接取公式
					row4.getCell(cellNum4).setCellValue(
							standingMA.getPerformanceCoefficient() == null ? 0
									: standingMA.getPerformanceCoefficient()
											.doubleValue());// 直接取公式
					// 兼站奖金系数
					row4.getCell(cellNum4).setCellFormula(
							row4.getCell(cellNum4++).getCellFormula());// 直接取公式
					// 未命名列（检测列）
					row4.getCell(cellNum4).setCellFormula(
							row4.getCell(cellNum4++).getCellFormula());// 直接取公式
				}
			}
		}
		// 删除剩下的所有行数据
		// for (int i = row4.getRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
		// sheet.removeRow(sheet.getRow(i));
		// }
	}

	// 解析导出的薪资数据
	private void analyzeSheet4(XSSFWorkbook wb,
			List<AttendanceManagement> attendanceManagementList,
			List<StaffCost> staffCostList, List<Holiday> subsibyList) {
		XSSFSheet sheet = wb.getSheet("油站工资表");
		System.out.println("sheet3.getSheetName() : " + sheet.getSheetName());
		sheet.setForceFormulaRecalculation(true);

		String yearMonth = this.getYearMonth();

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);

		// 设置第一行C列红色单元格日期(用于核算过节费, 这个日期是指每个月中某一天是节日, 则取节日的日期)
		XSSFRow xssfRow = sheet.getRow(0);
		XSSFCell xssfCell = xssfRow.getCell(2);
		xssfCell.setCellValue(String.valueOf(year) + "/"
				+ String.valueOf(month) + "/"
				+ String.valueOf(c.get(Calendar.DATE)));

		// 设置第一行D列----->K列的值(加油站XX年XX月工资)
		XSSFRow xssfRow3 = sheet.getRow(0);
		XSSFCell xssfCell3 = xssfRow3.getCell(3);
		StringBuilder sb = new StringBuilder();
		sb.append("加油全站").append(String.valueOf(year)).append("年")
				.append(yearMonth.substring(yearMonth.indexOf("-") + 1))
				.append("月工资");
		xssfCell3.setCellValue(sb.toString());

		// 设置第二行A列日期(用于核算司龄补贴, 取每个月的最后一天)
		xssfRow3 = sheet.getRow(1);
		xssfCell3 = xssfRow3.getCell(0);

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		sb = new StringBuilder();
		sb.append(String.valueOf(year)).append("/")
				.append(yearMonth.substring(yearMonth.indexOf("-") + 1))
				.append("/").append(String.valueOf(lastDay));
		xssfCell3.setCellValue(sb.toString());

		// int rowNum3 = 3; // 正式数据, 从第4行开始
		int cellNum3 = 0;
		BigDecimal nightShiftAmt = BigDecimal.ZERO;
		BigDecimal familyReunionDinnerAmt = BigDecimal.ZERO;
		BigDecimal chineseNewYearAmt = BigDecimal.ZERO;
		BigDecimal highTemperatureAmt = BigDecimal.ZERO;
		for (Holiday holiday : subsibyList) {
			String type = holiday.getType();
			BigDecimal holidayMoney = holiday.getHolidayMoney();
			if (Holiday.TYPE_CHINESE_NEW_YEAR.equals(type)) {
				chineseNewYearAmt = holidayMoney;
			} else if (Holiday.TYPE_FAMILY_REUNION_DINNER.equals(type)) {
				familyReunionDinnerAmt = holidayMoney;
			} else if (Holiday.TYPE_HIGH_TEMPERATURE.equals(type)) {
				highTemperatureAmt = holidayMoney;
			} else if (Holiday.TYPE_NIGHT_SHIFT.equals(type)) {
				nightShiftAmt = holidayMoney;
			}
		}
		// 定义好行数和单元格, 准备循环打印至Excel中
		// XSSFRow row3 = sheet.getRow(rowNum3);
		// 循环打印至Excel中
		Map<String, Integer> staffMap = new HashMap<String, Integer>();
		Map<String, List<Integer>> mergeMap = new HashMap<String, List<Integer>>();
		AttendanceManagement attendanceManagement = null;
		String[] total = new String[44];
		String lastStationCode = "";
		int rowNum3 = 3;
		int startCellnum = 56;
		for (int i = 0; i < attendanceManagementList.size(); i++, rowNum3++) {
			cellNum3 = 0; // 正式数据, 从每一行的第A列开始
			attendanceManagement = attendanceManagementList.get(i);
			String dutyNature = attendanceManagement.getDutyNature();// 职务性质
			String staffCode = attendanceManagement.getStaffCode();// 员工编号
			String stationCode = attendanceManagement.getStationCode();
			XSSFRow row3 = sheet.getRow(rowNum3);
			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.PLUM.index);
			// 加总处理
			if (i == 0) {// 第一条
				for (int j = 0, totalCellnum = startCellnum; j < total.length; j++, totalCellnum++) {
					total[j] = row3.getCell(totalCellnum).getReference();
				}
			} else {
				if (!lastStationCode.equals(stationCode)) {// 另起一站：先加总
					for (int j = 0, totalCellnum = startCellnum; j < total.length; j++, totalCellnum++) {
						row3.setRowStyle(cellStyle);
						row3.getCell(cellNum3).setCellFormula(null);
						row3.getCell(cellNum3).setCellValue(
								attendanceManagement.getStationName() + "合计：");
						row3.getCell(totalCellnum).setCellFormula(total[j]);
					}
					total = new String[44];
					rowNum3++;
					row3 = sheet.getRow(rowNum3);
					for (int j = 0, totalCellnum = startCellnum; j < total.length; j++, totalCellnum++) {
						total[j] = row3.getCell(totalCellnum).getReference();
					}
				} else if (i == attendanceManagementList.size() - 1) {// 最后一条
					XSSFRow rowTmp = sheet.getRow(rowNum3 + 1);
					for (int j = 0, totalCellnum = startCellnum; j < total.length; j++, totalCellnum++) {
						total[j] = total[j] + "+"
								+ row3.getCell(totalCellnum).getReference();
					}
					for (int j = 0, totalCellnum = startCellnum; j < total.length; j++, totalCellnum++) {
						rowTmp.setRowStyle(cellStyle);
						rowTmp.getCell(cellNum3).setCellFormula(null);
						rowTmp.getCell(cellNum3).setCellValue(
								attendanceManagement.getStationName() + "合计：");
						rowTmp.getCell(totalCellnum).setCellFormula(total[j]);
						rowTmp.getCell(totalCellnum).setCellFormula(total[j]);
					}
				} else {
					for (int j = 0, totalCellnum = startCellnum; j < total.length; j++, totalCellnum++) {
						total[j] = total[j] + "+"
								+ row3.getCell(totalCellnum).getReference();
					}
				}
			}
			lastStationCode = stationCode;

			if (staffMap.get(staffCode) != null) {
				if (mergeMap.get(staffCode) != null) {
					mergeMap.get(staffCode).add(rowNum3);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(staffMap.get(staffCode));
					list.add(rowNum3);
					mergeMap.put(staffCode, list);
				}
			}
			staffMap.put(staffCode, rowNum3);
			// A 关联数据第一列(油站名称 + 员工姓名) 0
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// B 关联数据第二列(员工姓名 + 职务名称) 1
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// C 关联数据第三列(职务名称 + 是否管站带班) 2
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// D 油站名称 3
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStationName() == null ? ""
							: attendanceManagement.getStationName());
			// E 地区系数 4
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getAreaName() == null ? ""
							: attendanceManagement.getAreaName());
			// F 油站星级 5
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// G 序号 6
			row3.getCell(cellNum3++).setCellValue(i + 1);
			// H 员工编号 7
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffCode() == null ? ""
							: attendanceManagement.getStaffCode());
			// I 姓名 8
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffName() == null ? ""
							: attendanceManagement.getStaffName());
			// J 身份证号 9
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffIdcard() == null ? ""
							: attendanceManagement.getStaffIdcard());
			// K 银行卡账号 10
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffBankcard() == null ? ""
							: attendanceManagement.getStaffBankcard());
			// L 个人银行所属开户行 11
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffBank() == null ? ""
							: attendanceManagement.getStaffBank());
			// M 职务 12
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getDutyName() == null ? ""
							: attendanceManagement.getDutyName());
			// N 入职日期 13
			row3.getCell(cellNum3++).setCellValue(
					DateUtil.fomatDate(attendanceManagement.getStaffInDate()));
			// O 工作日 14
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getWorkingDay() == null ? 0
							: attendanceManagement.getWorkingDay()
									.doubleValue());
			// P 是否管站、带班 15
			String isStamanageForeman = "";
			if (attendanceManagement.getIsStamanageForeman() != null
					&& !"N".equals(attendanceManagement.getIsStamanageForeman())) {
				isStamanageForeman = attendanceManagement
						.getIsStamanageForeman();
			}
			row3.getCell(cellNum3++).setCellValue(isStamanageForeman);
			// Q 是否实习期内 16
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getIsInternship() == null ? ""
							: attendanceManagement.getIsInternship());
			// R 本月实习期满后工作天数 17
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getAfterIntershipWorking() == null ? 0
							: attendanceManagement.getAfterIntershipWorking()
									.doubleValue());
			// S 平时超时 18
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getPeacetimeTimeout() == null ? 0
							: attendanceManagement.getPeacetimeTimeout()
									.doubleValue());
			// T 节日加班 19
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getHolidayOvertime() == null ? 0
							: attendanceManagement.getHolidayOvertime()
									.doubleValue());
			// U 年夜饭在岗 20
			// row3.getCell(cellNum3++).setCellValue(attendanceManagement.getFamilyReunionDinnerOn()
			// == null? 0 :
			// attendanceManagement.getFamilyReunionDinnerOn().doubleValue());
			row3.getCell(cellNum3++)
					.setCellValue(
							attendanceManagement.getIsFamilyReunionDinnerOn() == null ? "N"
									: attendanceManagement
											.getIsFamilyReunionDinnerOn());
			// V 春节在岗(阶段一) 21
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getOnTheSpringFestivaOne() == null ? 0
							: attendanceManagement.getOnTheSpringFestivaOne()
									.doubleValue());
			// //W 春节在岗(阶段二) 22
			// row3.getCell(cellNum3++).setCellValue(attendanceManagement.getOnTheSpringFestivaTwo()
			// == null? 0 :
			// attendanceManagement.getOnTheSpringFestivaTwo().doubleValue());
			// 跨站支援天数
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getSupportDays().doubleValue());
			// 夜班在岗
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getNightShiftDays() == null ? 0
							: attendanceManagement.getNightShiftDays()
									.doubleValue());
			// X 本月离职 23
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getIsDeparture());
			// Y 事假 24
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getCasualLeave() == null ? 0
							: attendanceManagement.getCasualLeave()
									.doubleValue());
			// Z 旷工 25
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getAbsenteeism() == null ? 0
							: attendanceManagement.getAbsenteeism()
									.doubleValue());
			// AA 病假 26
			row3.getCell(cellNum3++)
					.setCellValue(
							attendanceManagement.getSickLeave() == null ? 0
									: attendanceManagement.getSickLeave()
											.doubleValue());
			// AB 年假 27
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getAnnualLeave() == null ? 0
							: attendanceManagement.getAnnualLeave()
									.doubleValue());
			// AC 婚假 28
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getMarriageLeave() == null ? 0
							: attendanceManagement.getMarriageLeave()
									.doubleValue());
			// AD 产假 29
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getMaternityLeave() == null ? 0
							: attendanceManagement.getMaternityLeave()
									.doubleValue());
			// AE 丧假 30
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getFuneralLeave() == null ? 0
							: attendanceManagement.getFuneralLeave()
									.doubleValue());
			// AF 调休 31
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getDaysOff() == null ? 0
							: attendanceManagement.getDaysOff().doubleValue());
			// AG 口头警告 32
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getVerbalWarnings() == null ? 0
							: attendanceManagement.getVerbalWarnings()
									.doubleValue());
			// AH 记过 33
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getWrittenWarning() == null ? 0
							: attendanceManagement.getWrittenWarning()
									.doubleValue());
			// AI 重大事故 34
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getMajorAccident() == null ? 0
							: attendanceManagement.getMajorAccident()
									.doubleValue());
			// AJ 是否保留宿舍 35
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getIsAccomodate() == null ? ""
							: attendanceManagement.getIsAccomodate());
			// AK 是否搭伙 36
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getIsBoarder() == null ? ""
							: attendanceManagement.getIsBoarder());
			// AL 精彩卡-蓝色版 37
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getSplendorCardBlue());
			// AM 精彩卡-绿色版 38
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getSplendorCardGreen());
			// AN 兼职便利店员比例 39
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getPartTimeScale() == null ? ""
							: translatePersent(attendanceManagement
									.getPartTimeScale()));
			// AO 月度绩效 40
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getMonthPerformance() == null ? 0
							: attendanceManagement.getMonthPerformance()
									.doubleValue());
			// AP 经理奖金分配比例 41
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getManagerBonusScale() == null ? ""
							: translatePersent(attendanceManagement
									.getManagerBonusScale()));
			// AQ 备注 42
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getRemark() == null ? ""
							: attendanceManagement.getRemark());
			// AR 调站 43
			row3.getCell(cellNum3++);
			// AS 试用期系数 44
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AT 工作系数 45
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AU 绩效系数 46
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AV 岗位工时 47
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AW 岗位时薪 48
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AX 管理岗位油品奖金 49
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AY 一线员工油品奖金 50
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// AZ 管理岗位非油品奖金 51
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BA 一线员工非油品奖励 52
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BB 管理岗位管理奖金 53
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BC 一线员工绩效奖金 54
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BD 岗位工资 55
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BE 加班津贴 56
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BF 油品奖金 57
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BG 非油品奖金 58
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// 库提奖金
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getInventoryDeductAmt().doubleValue());
			// BH 星级、绩效奖金 59
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BI 经理奖金 60
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BJ 业绩挑战奖金 61
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BK 促销品奖金 62
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BL 金点子奖金 63
			row3.getCell(cellNum3++);
			// BM 年度奖金 64
			row3.getCell(cellNum3++);
			// BN 损耗奖罚 65
			// row3.getCell(cellNum3++).setCellValue(attendanceManagement.getLossAmt()
			// == null? 0 : attendanceManagement.getLossAmt().doubleValue());
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getLossBonusAmt() == null ? 0
							: attendanceManagement.getLossBonusAmt()
									.doubleValue());
			// BO 精彩卡奖金 66
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BP 兼职便利店补贴 67
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BQ 岗位津贴 68
			// row3.getCell(cellNum3++);
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getJobSubsidies().doubleValue());
			// 支援补贴
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// 夜班补贴配额
			row3.getCell(cellNum3++).setCellValue(nightShiftAmt.doubleValue());
			cellNum3++;
			// 年夜饭补贴配额
			row3.getCell(cellNum3++).setCellValue(
					familyReunionDinnerAmt.doubleValue());
			cellNum3++;
			// 春节活动补贴配额
			row3.getCell(cellNum3++).setCellValue(
					chineseNewYearAmt.doubleValue());
			cellNum3++;
			// BR 高温津贴配额 69
			// row3.getCell(cellNum3++).setCellValue(attendanceManagement.getSubsidyMoney()
			// == null? 0 :
			// attendanceManagement.getSubsidyMoney().doubleValue());
			row3.getCell(cellNum3++).setCellValue(
					highTemperatureAmt.doubleValue());
			cellNum3++;
			// 其他补贴
			row3.getCell(cellNum3++);
			// row3.getCell(cellNum3).setCellFormula(row3.getCell(cellNum3++).getCellFormula());//
			// 直接取公式
			// BS 司龄补贴 70
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BT 应发工资合计 71
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BU 工作餐补贴 72
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BV 住宿补贴 73
			if (Constants.YES_FLAG.equals(attendanceManagement
					.getIsAccommoSubsidyArti())) {
				row3.getCell(cellNum3).setCellFormula(null);
				row3.getCell(cellNum3++).setCellValue(
						attendanceManagement.getAccommodationSubsidy()
								.doubleValue());
			} else {
				row3.getCell(cellNum3).setCellFormula(
						row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			}

			// BW 交通补贴 74
			row3.getCell(cellNum3++);
			// BX 过节费 74:兼站无过节费
			row3.getCell(cellNum3++).setCellValue(
					Duty.DUTY_NATURE_PART_TIME.equals(dutyNature) ? 0
							: attendanceManagement.getHolidayMoney()
									.doubleValue());
			// BY 凉茶费、西瓜时刻 75
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// BZ 应发总合计 76
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CA 公积金 77
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffCostAccFund().doubleValue());
			// CB 养老保险 78
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffCostEndowment().doubleValue());
			// CC 失业保险 79
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffCostUnemployment()
							.doubleValue());
			// CD 医疗保险 80
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getStaffCostMedical().doubleValue());
			// CE 应税所得 81
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3).getCellFormula());// 直接取公式
			// FormulaEvaluator evaluator =
			// wb.getCreationHelper().createFormulaEvaluator();
			// CellValue cellValue = evaluator.evaluate(row3.getCell(cellNum3));
			cellNum3++;
			// CF 工资所得税 82
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CG 预扣补贴 83
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CH 继续教育扣款 使用到外部的文件，但此数据以后不需要 84
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getEducationCost().doubleValue());
			// CI 话费扣款 85
			// row3.getCell(cellNum3).setCellFormula(row3.getCell(cellNum3++).getCellFormula());//
			// 直接取公式
			row3.getCell(cellNum3++).setCellValue(
					attendanceManagement.getPhoneCost().doubleValue());
			// CJ 应扣合计 86
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CK 应发工资 87
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CL 签字确认 88
			row3.getCell(cellNum3++);
			// CM 备注 89
			row3.getCell(cellNum3++);
			// CN 其他计税事项 90
			row3.getCell(cellNum3++);
			// CO 应税总所得 91
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CP 所得税 92
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
			// CQ 最后一列 93
			row3.getCell(cellNum3).setCellFormula(
					row3.getCell(cellNum3++).getCellFormula());// 直接取公式
		}

		// 删除剩下的所有行数据
		for (int i = rowNum3 + 1; i <= sheet.getLastRowNum(); i++) {
			sheet.removeRow(sheet.getRow(i));
		}
		// 合并计税
		if (mergeMap.size() > 0) {
			for (List<Integer> list : mergeMap.values()) {
				int cellnum = 91;
				int cellnum1 = 100;
				if (list.size() == 2) {
					XSSFRow row = sheet.getRow(list.get(0));
					row.getCell(cellnum1 + 1).setCellFormula(null);
					row.getCell(cellnum1 + 2).setCellFormula(null);
					XSSFRow row1 = sheet.getRow(list.get(1));
					row1.getCell(cellnum1).setCellFormula(
							row.getCell(cellnum).getReference());
				} else {
					String cellFormula = "";
					for (int i = 0; i < list.size(); i++) {
						XSSFRow row = sheet.getRow(list.get(i));
						if (i == list.size() - 1) {
							row.getCell(cellnum1).setCellFormula(cellFormula);
						} else {
							row.getCell(cellnum1 + 1).setCellFormula(null);
							row.getCell(cellnum1 + 2).setCellFormula(null);
							if (i == 0) {
								cellFormula = row.getCell(cellnum)
										.getReference();
							} else {
								cellFormula = cellFormula + "+" + cellFormula;
							}
						}
					}
				}
			}
		}
	}

	// 获取计算薪资月份
	private String getYearMonth() {

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);

		// 获取上个月的日期, 准备从数据库中查询需要导出的数据
		// 如果跨年的话, 要做特殊处理
		String yearMonth = null;
		String mon = null;
		if (0 == month) {
			year = year - 1;
			month = 12;
			mon = String.valueOf(month);
			yearMonth = String.valueOf(year) + "-" + mon; // 得到的月份数是上个月份, 比如:
															// 当前为2016-1,
															// 获取的则为2015-12
		} else {
			mon = String.valueOf(month);
			if (month < 10) {
				mon = "0" + mon;
			}
			yearMonth = String.valueOf(year) + "-" + mon; // 得到的月份数是上个月份, 比如:
															// 当前为2015-11,
															// 获取的则为2015-10
		}

		return yearMonth;
	}

	private int getLastDayOfMonth() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);

		// 取一个月中的最后一天
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		return lastDay;
	}

	private String translatePersent(BigDecimal param) {
		// BigDecimal persent = new BigDecimal("100");//
		// 数据库维护的就是按%的来存储，不需要再乘以100.
		// param = param.multiply(persent);
		return param.toString() + "%";
	}
}
