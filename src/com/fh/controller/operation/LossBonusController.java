package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fh.common.exception.BizException;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.LossBonus;
import com.fh.entity.biz.Staff;
import com.fh.entity.system.Flag;
import com.fh.service.operation.LossBonusService;
import com.fh.service.station.StaffService;
import com.fh.util.AutoYearMonth;
import com.fh.util.UploadFile;

/**
 * 油品损耗奖金 Controller
 * 
 * @author zhoujj
 */
@Controller
@RequestMapping(value = "/lossBonus")
public class LossBonusController extends BaseController {

	@Resource(name = "lossBonusService")
	private LossBonusService lossBonusService;
	
	@Autowired
	private StaffService staffService;

	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(LossBonus lossBonus, Page page, Model model)
			throws Exception {

		// 当用户点击二级菜单"星级评测"的时候, 默认查询上个月的记录
		if ("".equals(lossBonus.getYearMonth())
				|| null == lossBonus.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			lossBonus.setYearMonth(yearMonth);
		}
		lossBonus.setType(LossBonus.TYPE_LOSS);
		Page pageList = this.lossBonusService.queryPage(page, lossBonus);
		model.addAttribute("pageList", pageList);
		model.addAttribute("lossBonus", lossBonus);
		return "operation/lossBonus/lossBonusList";
	}

	/**
	 * 导入管理岗位数据Excel
	 */
	@RequestMapping("/importLossBonus.do")
	public String importLossBonus(HttpServletRequest request, String type,
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
			return "operation/lossBonus/lossBonusList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/lossBonus/lossBonusList";
		}

		// 上传文件工具类
		UploadFile uploadUtil = new UploadFile();
		// 上传文件, 并返回文件上传的绝对目录
		String filePath = uploadUtil
				.uploadFile(request, uploadFile, type, null);
		// 以返回的上传文件的绝对路径构建输入流
		InputStream is = new FileInputStream(filePath);

		// 准备解析上传的Excel, 顺便判断一下是否用的是系统提供的模板
		@SuppressWarnings("resource")
		XSSFWorkbook xSFWorkbook = new XSSFWorkbook(is);
		XSSFSheet sheet = xSFWorkbook.getSheetAt(0);
		if (null == sheet || "".equals(sheet)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "operation/lossBonus/lossBonusList";
		}

		// 准备解析Excel
		int cellNum = 0;
		XSSFRow row2 = null;
		// XSSFCell cell2 = null;
		List<LossBonus> lossBonusList = new ArrayList<LossBonus>();
		LossBonus lossBonus = null;
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		String excMes = "";
		// 解析数据
		for (int rowNum = 2; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
			String cellReference = "";
			cellNum = 0; // 油站编号
			// 以员工编号的有无判断数据的可用性
			row2 = sheet.getRow(rowNum);
			lossBonus = new LossBonus();
			if (null == row2.getCell(cellNum)
					|| "".equals(row2.getCell(cellNum).toString())) {
				continue;
			}
			String stationCode = row2.getCell(cellNum).toString();
			lossBonus.setStationCode(stationCode);
			// 油站名称
			cellNum++;
			// 员工编号
			cellNum++;
			String staffCode = "";
			if (null != row2.getCell(cellNum)
					&& !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				staffCode = String.valueOf(row2.getCell(cellNum));
				lossBonus.setStaffCode(staffCode);
				
				Staff staff = staffService.queryStaffByStaffCode(staffCode,
						stationCode);
				if (staff == null) {
					excMes = excMes + "\n" + "第" + (rowNum + 1) + "行员工不存在，请检查油站编号："+ stationCode
							+ ",员工编号：" + staffCode;
				}
			} else {
				//throw new Exception("第" + (rowNum + 1) + "行【员工编号】未填写！");
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【员工编号】未填写！";
			}
			// 员工姓名
			cellNum++;
			String staffName = "";
			if (null != row2.getCell(cellNum)
					&& !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				staffName = String.valueOf(row2.getCell(cellNum));
				lossBonus.setStaffName(staffName);
			}
			try {
				// 油品损耗奖金
				cellNum++;
				BigDecimal lossBonusAmt = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum)))) {
					cellReference = row2.getCell(cellNum).getReference();
					lossBonusAmt = new BigDecimal(String.valueOf(row2
							.getCell(cellNum)));
					lossBonus.setLossBonusAmt(lossBonusAmt);
				} else {
					// lossBonus.setLossBonusAmt(BigDecimal.ZERO);
					//throw new Exception("第" + (rowNum + 1) + "行【油品损耗奖金】未填写！");
					excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【油品损耗奖金】未填写！";
					continue;
				}
			} catch (NumberFormatException e) {
//				throw new Exception("单元格:" + cellReference + ",数据格式有误(数值型)！");
				excMes = excMes + "\n" + "单元格:" + cellReference + ",数据格式有误(数值型)！";
				continue;
			}
			lossBonus.setType(LossBonus.TYPE_LOSS);
			lossBonus.setYearMonth(yearMonth);
			lossBonusList.add(lossBonus);
		}
		if (!"".equals(excMes)) {
			throw new Exception(excMes);
		}
		// 判断上传的是否是没有数据的空文件模板
		if (null != lossBonusList && lossBonusList.size() != 0) {
			lossBonusService.insertAllByYearMonth(lossBonusList);
			return "redirect:/lossBonus/queryList.do";
		} else {
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/lossBonus/lossBonusList";
		}

	}

}
