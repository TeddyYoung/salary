package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.InputStream;
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
import com.fh.entity.biz.StationTarget;
import com.fh.entity.system.Flag;
import com.fh.service.masterdata.StationTargetService;
import com.fh.service.operation.AccommodationSubsidyService;
import com.fh.util.AutoYearMonth;
import com.fh.util.Constants;
import com.fh.util.ExcelUtil;
import com.fh.util.UploadFile;

/**
 * 住宿补贴Controller
 *
 */
@Controller(value = "accommodationSubsidyController")
@RequestMapping({ "/accommodationSubsidy" })
public class AccommodationSubsidyController extends BaseController {

	@Autowired
	private AccommodationSubsidyService accommodationSubsidyService;
	
	@Autowired
	private StationTargetService stationTargetService;
	
	/**
	 * "搭伙补贴"上传列表星级评测(展示biz_station_target中的部分字段: 搭伙方式, 搭伙补贴, 搭伙备注)
	 */
	@RequestMapping("/list.do")
	public String boarderSubsidiesList(HttpServletRequest request, Page page, StationTarget stationTarget, Model model) {
		if ("".equals(stationTarget.getYearMonth()) || null == stationTarget.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			stationTarget.setYearMonth(yearMonth);
		}

		if ("".equals(stationTarget.getDistrictCode())) {
			stationTarget.setDistrictCode(null);
		}
		//stationTarget.setAccommodationSubsidy(BigDecimal.ZERO);
		stationTarget.setIsAccommoSubsidyArti(Constants.YES_FLAG);
		Page pageList = accommodationSubsidyService.findBoarderSubsidiesByPage(page, stationTarget);
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", stationTarget);
		return "operation/accommodationSubsidy/accommodationSubsidyList";
		
	}
	
	/**
	 * 导入Excel中搭伙补贴的信息
	 * 根据Excel中的油站的编号和年月份确认一条记录, 然后INSERT或UPDATE到数据库中
	 * 不以区域作为过滤条件
	 */
	@RequestMapping("/importAccommodationSubsidy.do")
	public String importOilBaseInfo(HttpServletRequest request, String type,
									MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		//判断营运部门当月上月数据是否有维护
		//如果没有维护, 给予提示, 先让营运部门维护营运数据
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return"operation/accommodationSubsidy/accommodationSubsidyList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/accommodationSubsidy/accommodationSubsidyList";
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
		XSSFSheet sheet = xSFWorkbook.getSheetAt(0);
		if (null == sheet || "".equals(sheet)) {
			Flag flag = new Flag();
			flag.setFlag("3");
			model.addAttribute("Flag", flag);
			return "operation/accommodationSubsidy/accommodationSubsidyList";
		}
		
		//判断上传的是不是油站星级评测的Excel
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		//遍历Excel表格, 将所有可用的数据解析出来
		XSSFRow row2 = null;
		ExcelUtil excelUtil = new ExcelUtil();
		List<StationTarget> excelStationTargetList = new ArrayList<StationTarget>();
		StationTarget stationTarget = null;
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			int cellNum = 0;
			//判断油站编号是否可用, 如果油站编号不可用, 则弃用整行数据
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				break;
			}
			if (null == row2.getCell(cellNum) || "".equals(String.valueOf(row2.getCell(cellNum)))) {
				break;
			}
			//油站编号
			stationTarget = new StationTarget(); 
			stationTarget.setStationCode(String.valueOf(row2.getCell(cellNum)));
			//油站名称
			cellNum++;
			//住宿补贴
			cellNum++;
			cell = row2.getCell(cellNum);
			if (null != cell && !"".equals(cell.toString())) {
				stationTarget.setAccommodationSubsidy(excelUtil.getBigDecimalValue(cell));
			}else{
				throw new Exception("第" + (rowNum + 1) + "行【住宿补贴】未填写！");
			}
			stationTarget.setIsAccommoSubsidyArti(Constants.YES_FLAG);
			//年月份
			stationTarget.setYearMonth(yearMonth);
			
			//将Excel中的每一个StationTarget进入集合中
			excelStationTargetList.add(stationTarget);
		}
		//将Excel中的全部数据UPDATE入库
		stationTargetService.updateStationTargetByStationCode(excelStationTargetList, yearMonth);
		return "redirect:/accommodationSubsidy/list.do";
		
	}
	
}
