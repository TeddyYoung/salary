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
import com.fh.entity.system.DataDictionary;
import com.fh.entity.system.Flag;
import com.fh.entity.vo.ResultVO;
import com.fh.service.operation.ManageBaseService;
import com.fh.service.station.StaffService;
import com.fh.service.system.DataDictionaryService;
import com.fh.util.AutoYearMonth;
import com.fh.util.ExcelUtil;
import com.fh.util.StringUtil;
import com.fh.util.UploadFile;

/**
 * 管理岗位数据Controller
 * @author zhang_yu
 *
 *提供管理岗位的Excel文件上传
 */
@Controller(value="phoneBillController")
@RequestMapping({"/phoneBill"})
public class PhoneBillController extends BaseController {
	
	@Autowired
	private ManageBaseService manageBaseService;
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	/**
	 * 管理岗位基础信息列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/phoneBillList.do")
	public String list(Page page, ManageBase manageBase, Model model) {
		
		//当用户点击二级菜单"星级评测"的时候, 默认查询上个月的记录
		if ("".equals(manageBase.getYearMonth()) || null == manageBase.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
			manageBase.setYearMonth(yearMonth);
		}
		manageBase.setPhoneCost(BigDecimal.ZERO);		
		Page pageList = manageBaseService.findManageBaseByPage(page, manageBase);
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", manageBase);
		return "operation/phoneBill/phoneBillList";
		
	}
	
	/**
	 * 导入管理岗位数据Excel
	 */
	@RequestMapping("/importPhoneBill.do")
	public String importOilBaseInfo(HttpServletRequest request, String type,
									MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "operation/phoneBill/phoneBillList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/phoneBill/phoneBillList";
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
			return "operation/phoneBill/phoneBillList";
		}
		
		//准备解析Excel
		int cellNum = 0;
		XSSFRow row2 = null;
		//XSSFCell cell2 = null;
		ExcelUtil excelUtil = new ExcelUtil();
		List<ManageBase> manageBaseList = new ArrayList<ManageBase>();
		ManageBase manageBase = null;
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		String excMes = "";
		boolean submit = true;
		//取第1部分数据: 油站经理
		for (int rowNum = 2; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
			cellNum = 0; //油站编号
			//以员工编号的有无判断数据的可用性
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				continue;
			} 
			if (null ==  row2.getCell(cellNum) || "".equals(String.valueOf( row2.getCell(cellNum)))) {
				continue;
			}
			manageBase = new ManageBase();
			String stationCode = row2.getCell(cellNum).toString();
			manageBase.setStationCode(stationCode);
			//油站名称
			cellNum++;
			//员工编号
			cellNum++;
			String staffCode = "";
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				staffCode = String.valueOf(row2.getCell(cellNum));
				manageBase.setStaffCode(staffCode);
			}else{
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【员工编号】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【员工编号】未填写！");
			}
			//员工姓名
			cellNum++;
			String staffName = "";
			if (null != row2.getCell(cellNum) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				staffName = String.valueOf(row2.getCell(cellNum));
//				manageBase.setStaffCode(String.valueOf(row2.getCell(cellNum)));
				manageBase.setStaffName(staffName);
			}
			
//			//职务
//			cellNum++;
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				manageBase.setDutyName(String.valueOf(row2.getCell(cellNum)));
//			}
			//扣款金额
			cellNum ++;
			if (null == row2.getCell(cellNum) || "".equals(String.valueOf(row2.getCell(cellNum)))) {
			//	throw new Exception("第" + (rowNum + 1) + "行【扣款金额】未填写！");
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【扣款金额】未填写！";
			}
			BigDecimal deductionsAmt = excelUtil.getFormulaCellBigDecimalValue(row2.getCell(cellNum));
			// 扣款类型
			cellNum++;
			if (null == row2.getCell(cellNum)
					|| "".equals(row2.getCell(cellNum))) {
				//throw new Exception("第" + (rowNum + 1) + "行【扣款类型】未填写！");
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【扣款类型】未填写！";
			}
			String deductionsType = dataDictionaryService.getValueType(
					DataDictionary.CT_DEDUCTIONS_TYPE, row2.getCell(cellNum)
							.toString());
			if (StringUtil.isEmpty(deductionsType)) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【扣款类型】填写不正确！";
				//throw new Exception("第" + (rowNum + 1) + "行【扣款类型】填写不正确！");
			}
			if(ManageBase.DEDUCTIONS_TYPE_PHONE_CHARGE.equals(deductionsType)){
				manageBase.setPhoneCost(deductionsAmt);
			}else if(ManageBase.DEDUCTIONS_TYPE_EDUCATION.equals(deductionsType)){
				manageBase.setEducationCost(deductionsAmt);
			}
			
//			// 通过员工姓名查找员工编号
//			Staff staff = new Staff();
//			staff.setStaffName(staffName);
//			staff = this.staffService.getStaffByCondition(staff);
//			manageBase.setStaffCode(staff.getStaffCode());
			manageBase.setYearMonth(yearMonth);
			manageBaseList.add(manageBase);
		}
		//判断上传的是否是没有数据的空文件模板
		if (null != manageBaseList && manageBaseList.size() != 0) {
//			//判断当前月份, 先将上个月的相关数据全部DELETE, 然后再INSERT进去
//			manageBaseService.deleteAllByYearMonth(yearMonth);
//			// 通过月份和员工编号判断记录是否存在，如果存在则执行更新操作，如果不存在则执行新增操作
			if(!"".equals(excMes)){
				submit = false;
			}
			ResultVO resultVO = manageBaseService.insertAllByYearMonth(manageBaseList,submit);
			if(resultVO.getFail() > 0){
				excMes = excMes + resultVO.getFailMes();
			}
			if (!"".equals(excMes)) {
				throw new Exception(excMes);
			}
			return "redirect:/phoneBill/phoneBillList.do";
		}else{
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/phoneBill/phoneBillList";
		}
		
	}
	
}
