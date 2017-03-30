package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.ManageBase;
import com.fh.entity.system.Flag;
import com.fh.service.operation.ManageBaseService;
import com.fh.util.AutoYearMonth;
import com.fh.util.ExcelUtil;
import com.fh.util.UploadFile;

/**
 * 管理岗位数据Controller
 * @author zhang_yu
 *
 *提供管理岗位的Excel文件上传
 */
@Controller(value="manageBaseController")
@RequestMapping({"/manageBase"})
public class ManageBaseController extends BaseController {
	
	@Autowired
	private ManageBaseService manageBaseService;
	
	/**
	 * 管理岗位基础信息列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/manageBaseList.do")
	public String list(Page page, ManageBase manageBase, Model model) {
		
		//当用户点击二级菜单"星级评测"的时候, 默认查询上个月的记录
		if ("".equals(manageBase.getYearMonth()) || null == manageBase.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
			manageBase.setYearMonth(yearMonth);
		}
				
		Page pageList = manageBaseService.findManageBaseByPage(page, manageBase.getYearMonth(),manageBase.getStaffName());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", manageBase);
		return "operation/manageBase/manageBaseList";
		
	}
	
	/**
	 * 导入管理岗位数据Excel
	 */
	@RequestMapping("/importManageBase.do")
	public String importOilBaseInfo(HttpServletRequest request, String type,
									MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "operation/manageBase/manageBaseList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/manageBase/manageBaseList";
		}
		
		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil.uploadFile(request, uploadFile, type, null);
		// 以返回的上传文件的绝对路径构建输入流
		InputStream is = new FileInputStream(filePath);
		
		//准备解析上传的Excel, 顺便判断一下是否用的是系统提供的模板
		@SuppressWarnings("resource")
		XSSFWorkbook xSFWorkbook = new XSSFWorkbook(is);
		XSSFSheet sheet = xSFWorkbook.getSheet("管理岗位数据");
		if (null == sheet || "".equals(sheet)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "operation/manageBase/manageBaseList";
		}
		
		//判断上传的是不是管理岗位数据Excel
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String firstValue = String.valueOf(cell);
		if (!"油站经理".equals(firstValue)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "operation/manageBase/manageBaseList";
		}
		
		//准备解析Excel
		int cellNum = 0;
		XSSFRow row2 = null;
		XSSFCell cell2 = null;
		ExcelUtil excelUtil = new ExcelUtil();
		List<ManageBase> manageBaseList = new ArrayList<ManageBase>();
		ManageBase manageBase = null;
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		
		//取第1部分数据: 油站经理
		for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {
			cellNum = 1; //员工编号(油站经理)
			
			//以员工编号的有无判断数据的可用性
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				break;
			}else{
				cell2 = row2.getCell(cellNum);
				if (null == cell2 || "".equals(cell2) || null == String.valueOf(cell2) || "".equals(String.valueOf(cell2))) {
					break;
				}
			}
			
			manageBase = new ManageBase();
			//员工编号
			if (null != String.valueOf(cell2) && !"".equals(String.valueOf(cell2))) {
				manageBase.setStaffCode(String.valueOf(row2.getCell(cellNum)));
			}
			
			//职务
			cellNum = 3;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setDutyName(String.valueOf(row2.getCell(cellNum)));
			}
			
			//职级
			cellNum = 4;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setDutyLevel(String.valueOf(row2.getCell(cellNum)));
			}
			
			//岗位工资
			cell2 = row2.getCell(5);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setPostSalary(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//话费扣款
			cell2 = row2.getCell(6);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setPhoneCost(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//月度绩效系数
			cell2 = row2.getCell(8);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setPerformanceCoefficient(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			manageBase.setYearMonth(yearMonth);
			manageBaseList.add(manageBase);
		}
		
		//取第2部分数据: 油站会计
		for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {
			cellNum = 10; //员工编号(油站会计)
			
			//以员工编号的有无判断数据的可用性
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				break;
			}else{
				cell2 = row2.getCell(cellNum);
				if (null == cell2 || "".equals(cell2) || null == String.valueOf(cell2) || "".equals(String.valueOf(cell2))) {
					break;
				}
			}
			
			manageBase = new ManageBase();
			//员工编号
			if (null != String.valueOf(cell2) && !"".equals(String.valueOf(cell2))) {
				manageBase.setStaffCode(String.valueOf(row2.getCell(cellNum)));
			}
			
			//职务
			cellNum = 12;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setDutyName(String.valueOf(row2.getCell(cellNum)));
			}
			
			//职级
			cellNum = 13;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setDutyLevel(String.valueOf(row2.getCell(cellNum)));
			}
			
			//岗位工资
			cell2 = row2.getCell(14);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setPostSalary(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//话费扣款
			cell2 = row2.getCell(15);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setPhoneCost(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//岗位津贴
			cellNum = 16;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setJobSubsidies(new BigDecimal(String.valueOf(row2.getCell(cellNum))));
			}
			
			//月度绩效系数
			cellNum = 17;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setPerformanceCoefficient(new BigDecimal(String.valueOf(row2.getCell(cellNum))));
			}
			
			manageBase.setYearMonth(yearMonth);
			manageBaseList.add(manageBase);
		}
		
		//取第3部分数据: 兼站经理/会计
		for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {
			cellNum = 22; //员工编号(兼站经理/会计)
			
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				break;
			}else{
				cell2 = row2.getCell(cellNum);
				if (null == cell2 || "".equals(cell2) || null == String.valueOf(cell2) || "".equals(String.valueOf(cell2))) {
					break;
				}
			}
			
			manageBase = new ManageBase();
			//员工编号
			if (null != String.valueOf(cell2) && !"".equals(String.valueOf(cell2))) {
				manageBase.setStaffCode(String.valueOf(row2.getCell(cellNum)));
			}
			
			//油站
			cellNum = 21;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setStationName(String.valueOf(row2.getCell(cellNum)));
			}
			
			//职务
			cellNum = 25;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setDutyName(String.valueOf(row2.getCell(cellNum)));
			}
			
			//兼站奖金基数
			cellNum = 26;
			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				manageBase.setBonusBase(new BigDecimal(String.valueOf(row2.getCell(cellNum))));
			}
			
			//达标率
			cell2 = row2.getCell(27);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setStandardRate(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//月度绩效系数
			cell2 = row2.getCell(28);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setPerformanceCoefficient(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//兼站奖金系数
			cell2 = row2.getCell(29);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setBonusCoefficient(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			//最后一列, 未命名列(计算R列的油站的油品和非油品达标率的平均值, 被工资表引用来计算兼站人员的奖金)
			cell2 = row2.getCell(30);
			if (null != cell2 && !"".equals(cell2)) {
				manageBase.setStationStaffBonuses(excelUtil.getFormulaCellBigDecimalValue(cell2));
			}
			
			manageBase.setYearMonth(yearMonth);
			manageBaseList.add(manageBase);
		}
		
		//判断上传的是否是没有数据的空文件模板
		if (null != manageBaseList && manageBaseList.size() != 0) {
			//判断当前月份, 先将上个月的相关数据全部DELETE, 然后再INSERT进去
			manageBaseService.deleteAllByYearMonth(yearMonth);
			manageBaseService.insertAllByYearMonth(manageBaseList);
			return "redirect:/manageBase/manageBaseList.do";
		}else{
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/manageBase/manageBaseList";
		}
		
	}
	
}
