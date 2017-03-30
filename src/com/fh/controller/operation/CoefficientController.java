package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.fh.util.UploadFile;

/**
 * 绩效系数 Controller
 * @author Teddy
 * 提供管理岗位的Excel文件上传
 */
@Controller(value="coefficientController")
@RequestMapping({"/coefficient"})
public class CoefficientController extends BaseController {
	
	@Autowired
	private ManageBaseService manageBaseService;
	
	/**
	 * 管理岗位基础信息列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/queryList.do")
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
		return "operation/coefficient/coefficientList";
		
	}
	
	/**
	 * 导入管理岗位数据Excel
	 */
	@RequestMapping("/importCoefficient.do")
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
			return "operation/coefficient/coefficientList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/coefficient/coefficientList";
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
		XSSFSheet sheet = xSFWorkbook.getSheetAt(0);
		if (null == sheet || "".equals(sheet)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "operation/coefficient/coefficientList";
		}
		
		//准备解析Excel
		int cellNum = 0;
		XSSFRow row2 = null;
		//XSSFCell cell2 = null;
		List<ManageBase> manageBaseList = new ArrayList<ManageBase>();
		ManageBase manageBase = null;
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		
		// 解析数据
		for (int rowNum = 2; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
			cellNum = 0; //油站编号
			//以员工编号的有无判断数据的可用性
			row2 = sheet.getRow(rowNum);
			manageBase = new ManageBase();
			String stationCode = "";
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				stationCode = String.valueOf(row2.getCell(cellNum));
				manageBase.setStationCode(stationCode);
			}else{
				break;
			}
			//油站名称
			cellNum++;
			//员工编号
			cellNum++;
			String staffCode = "";
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				staffCode = String.valueOf(row2.getCell(cellNum));
				manageBase.setStaffCode(staffCode);
			}else{
				throw new Exception("第" + (rowNum + 1) + "行【员工编号】未填写！");
			}
			//员工姓名
			cellNum++;
			String staffName = "";
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				staffName = String.valueOf(row2.getCell(cellNum));
				manageBase.setStaffName(staffName);
			}
			//职务
			cellNum++;
			String dutyName = "";
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				dutyName = String.valueOf(row2.getCell(cellNum));
				manageBase.setDutyName(dutyName);
			}
			cellNum++;// 分数
			cellNum++;// 排名
			// 绩效
			cellNum++;
			BigDecimal coefficient = new BigDecimal(0);
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				coefficient = new BigDecimal(String.valueOf(row2.getCell(cellNum)));
				manageBase.setPerformanceCoefficient(coefficient);
			}
			
			manageBase.setYearMonth(yearMonth);
			manageBaseList.add(manageBase);
		}
		
		//判断上传的是否是没有数据的空文件模板
		if (null != manageBaseList && manageBaseList.size() != 0) {
			manageBaseService.insertAllByYearMonth(manageBaseList);
			return "redirect:/coefficient/queryList.do";
		}else{
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/coefficient/coefficientList";
		}
		
	}
	
}
