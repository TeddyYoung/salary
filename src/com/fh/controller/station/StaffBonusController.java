package com.fh.controller.station;

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

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Staff;
import com.fh.entity.biz.StaffCost;
import com.fh.entity.biz.StaffCostVO;
import com.fh.entity.system.Flag;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.station.StaffCostService;
import com.fh.service.station.StaffService;
import com.fh.util.AutoYearMonth;
import com.fh.util.ExcelUtil;
import com.fh.util.UploadFile;

/**
 * 员工成本信息Controller
 * 
 * @author lijn 以月作为单位, 加载所有的信息, 但维护只允许维护上个月的信息
 *
 */
@Controller(value = "StaffBonusController")
@RequestMapping({ "/staffBonus" })
public class StaffBonusController extends BaseController {

	@Autowired
	private StaffCostService staffCostService;

	@Autowired
	private StaffService staffService;

	/**
	 * 员工销售提成信息
	 */
	@RequestMapping("/staffBonusList.do")
	public String staffBonusList(HttpServletRequest request, Page page,
			StaffCost staffCost, Model model) throws Exception {
		if ("".equals(staffCost.getStaffCostYearMonth())
				|| staffCost.getStaffCostYearMonth() == null) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			staffCost.setStaffCostYearMonth(yearMonth);
		}
		StoreEmployee user = (StoreEmployee) request.getSession().getAttribute(
				SysConstant.CURRENT_USER_INFO);
		Page pageList = staffCostService.findStaffBonusByPage(page,
				staffCost.getStaffCostYearMonth(), user.getSubOrganiseIdStr(),
				staffCost.getStaffName());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", staffCost);
		return "station/bonus/staffBonusList";
	}

	/**
	 * 去添加或修改员工成本信息信息页面
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/saveOrUpdateStaffBonus.do")
	public String saveOrUpdateStaffCost(HttpServletRequest request, Model model)
			throws Exception {

		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
		StoreEmployee user = (StoreEmployee) request.getSession().getAttribute(
				SysConstant.CURRENT_USER_INFO);
		List<StaffCostVO> staffCostVOs = staffCostService
				.findAllStaffCostByYearMonth(user.getSubOrganiseIdStr(),
						yearMonth);
		List<StaffCostVO> staffCostVOList = new ArrayList<StaffCostVO>();
		for (StaffCostVO staffCostVO : staffCostVOs) {
			if (staffCostVO.getStaffCost() != null) {
				if (yearMonth.equals(staffCostVO.getStaffCost()
						.getStaffCostYearMonth())) {
					staffCostVOList.add(staffCostVO);
				} else {
					staffCostVO.getStaffCost().setStaffCostYearMonth(yearMonth);
					staffCostVOList.add(staffCostVO);
				}
				if ("".equals(staffCostVO.getStaffCost()
						.getStaffCostYearMonth())
						|| staffCostVO.getStaffCost().getStaffCostYearMonth() == null) {
					staffCostVO.getStaffCost().setStaffCostYearMonth(yearMonth);
					staffCostVOList.add(staffCostVO);
				}
			} else {
				StaffCost staffCost = new StaffCost();
				staffCost.setStaffCostYearMonth(yearMonth);
				staffCostVO.setStaffCost(staffCost);
				staffCostVOList.add(staffCostVO);
			}

		}
		model.addAttribute("staffCostVOList", staffCostVOList);

		return "station/bonus/saveOrUpdateStaffBonus";

	}

	/**
	 * 添加或修改员工成本信息信息
	 */
	@RequestMapping("/staffBonusRealSaveOrUpdate.do")
	public String StaffCostRealSaveOrUpdate(StaffCostVO staffCostVO, Model model)
			throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		if (staffCostVO.getStaffCostList() != null
				&& staffCostVO.getStaffCostList().size() > 0) {
			staffCostService.saveOrUpdateStaffCost(staffCostVO
					.getStaffCostList());
		}
		return "redirect:/staffBonus/staffBonusList.do";

	}

	/**
	 * 上传员工数据表 只需要Excel中的一个字段, "共计"
	 */
	@RequestMapping("/importStaffData.do")
	public String importStaffData(HttpServletRequest request, String type,
			String ym, MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}

		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "station/bonus/staffBonusList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "station/bonus/staffBonusList";
		}

		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil
				.uploadFile(request, uploadFile, type, null);
		// 以返回的上传文件的绝对路径构建输入流
		InputStream is = new FileInputStream(filePath);
		// 准备解析上传的Excel
		@SuppressWarnings("resource")
		XSSFWorkbook xSFWorkbook = new XSSFWorkbook(is);
		XSSFSheet sheet = xSFWorkbook.getSheetAt(0);
		if (null == sheet || "".equals(sheet)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "station/bonus/staffBonusList";
		}

		// 获取上个月的年月份
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		// 将上个月所有的staff_cost查询出来准备"共计"的维护
		// List<StaffCost> staffCostList =
		// staffCostService.findAllStaffCostsByYearMonth(yearMonth);

		// Excel表格中只需要两个字段: 身份证号(用来与员工匹配) 和 共计(主要数据)
		int cellNum = 0;
		XSSFRow row = null;
		// XSSFCell cell = null;
		ExcelUtil excelUtil = new ExcelUtil();
		String excMes = "";
		List<StaffCost> staffCostList = new ArrayList<StaffCost>();
		for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) { // 从第2行开始
			row = sheet.getRow(rowNum);
			cellNum = 0; // 读取油站编号
			if (row.getCell(cellNum) == null
					|| "".equals(row.getCell(cellNum).toString())) {
				break;
			}
			String stationCode = row.getCell(cellNum).toString();
			// 油站名称
			cellNum++;
			// 员工编号
			cellNum++;
			String staffCode = "";
			if (row.getCell(cellNum) == null
					|| "".equals(row.getCell(cellNum).toString())) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【员工编号】未填写！";
			} else {
				staffCode = row.getCell(cellNum).toString();
			}
			// 姓名
			cellNum++;
			// 读取员工的身份证号
			// cellNum++;
			// if (row.getCell(cellNum) == null
			// || "".equals(row.getCell(cellNum).toString())) {
			// // continue;
			// //throw new Exception("第" + (rowNum + 1) + "行【身份证号】未填写！");
			// excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【身份证号】未填写！";
			// }
			// String idCardCellValue = row.getCell(cellNum).toString();
			// StaffCost staffCost = staffCostService
			// .findStaffCostByStaffIdCardAndYearMonth(idCardCellValue,
			// yearMonth, stationCode);
			// modyfy by yangjj start
			// if (null != staffCost) { //设置共计的值
			// 销售提成
			cellNum++;
			BigDecimal cellValue = BigDecimal.ZERO;
			if (row.getCell(cellNum) == null
					|| "".equals(row.getCell(cellNum).toString())) {
				// throw new Exception("第" + (rowNum + 1) + "行【销售提成】未填写！");
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【销售提成】未填写！";
			} else {
				cellValue = excelUtil.getBigDecimalValue(row.getCell(cellNum));
			}
			Staff staff = staffService.queryStaffByStaffCode(staffCode,
					stationCode);
			if (staff == null) {
				// throw new Exception("第" + (rowNum + 1) +
				// "行员工不存在,请检查油站编号及身份证号");
				excMes = excMes + "\n" + "第" + (rowNum + 1)
						+ "行员工不存在,请检查油站编号及员工编号";
				continue;
			}
			StaffCost staffCost = staffCostService.findStaffCostByStaffCode(
					stationCode, staffCode, yearMonth);
			if (null != staffCost) {
				staffCost.setTotal(cellValue);
				// staffCostService.update(staffCost);
			} else {
				staffCost = new StaffCost();
				staffCost.setTotal(cellValue);
				staffCost.setStaffCode(staffCode);
				staffCost.setStationCode(stationCode);
				staffCost.setStaffCostYearMonth(yearMonth);
				// staffCostService.save(staffCost);
			}
			staffCostList.add(staffCost);
			// }else{
			// continue;
			// }
			// modyfy by yangjj end
		}
		if (!"".equals(excMes)) {
			throw new Exception(excMes);
		}
		staffCostService.saveOrUpdateStaffCost(staffCostList);
		return "redirect:/staffBonus/staffBonusList.do";

	}

}
