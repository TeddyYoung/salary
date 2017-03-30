package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.fh.entity.biz.StationTargetVO;
import com.fh.entity.system.Flag;
import com.fh.service.masterdata.StationTargetService;
import com.fh.service.operation.OilBaseInfoService;
import com.fh.util.AutoYearMonth;
import com.fh.util.UploadFile;

/**
 * 油站基础信息Controller
 * @author zhang_yu
 *以月作为单位, 加载所有的信息, 但维护只允许维护上个月的信息
 *
 */
@Controller(value="oilBaseInfoController")
@RequestMapping({"/oilBaseInfo"})
public class OilBaseInfoController extends BaseController {

	@Autowired
	private OilBaseInfoService oilBaseInfoService;
	
	@Autowired
	private StationTargetService stationTargetService;
	
	/**
	 * 油站基础信息(展示biz_station_target中的部分字段: 油站名称、定编人数、浮动编制人数)
	 */
	@RequestMapping("/oilBaseInfoList.do")
	public String oilBaseInfoList(HttpServletRequest request, Page page, StationTarget stationTarget, Model model) {
		
		//当用户点击二级菜单"油站基础信息"的时候, 默认查询上个月的记录
		if ("".equals(stationTarget.getYearMonth()) || null == stationTarget.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
			stationTarget.setYearMonth(yearMonth);
		}

		if ("".equals(stationTarget.getDistrictCode())) {
			stationTarget.setDistrictCode(null);
		}

		Page pageList = oilBaseInfoService.findOilBaseInfoByPage(page, stationTarget.getYearMonth(), 
																	   stationTarget.getDistrictCode());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", stationTarget);
		return "operation/oilbaseinfo/oilBaseInfoList";
		
	}
	
	/**
	 * 去添加或修改油站基础信息页面
	 */
	@RequestMapping("/saveOrUpdateOilBaseInfo.do")
	public String saveOrUpdateOilBaseInfo(String districtCode, Model model) {
		
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
		
		if ("".equals(districtCode)) {
			districtCode = null;
		}
		
		Flag flag2 = new Flag();
		flag2.setFlag(districtCode);
		model.addAttribute("Flag2", flag2);
		
		List<StationTarget> stationTargetList = oilBaseInfoService.findAllOilBaseInfoByYearMonthAndDistrictCode(yearMonth, 
																												districtCode);
		model.addAttribute("stationTargetList", stationTargetList);
		
		Flag flag = new Flag();
		flag.setFlag(yearMonth);
		model.addAttribute("Flag", flag);
		
		return "operation/oilbaseinfo/saveOrUpdateOilBaseInfo";
		
	}
	
	/**
	 * 添加或修改油站基础信息
	 */
	@RequestMapping("/oilBaseInfoRealSaveOrUpdate.do")
	public String oilBaseInfoRealSaveOrUpdate(String districtCode, StationTargetVO stationTargetVO, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		if (stationTargetVO.getStationTargetList().size() != 0) {
			oilBaseInfoService.saveOrUpdateOilBaseInfo(stationTargetVO.getStationTargetList());
		}
		return "redirect:/oilBaseInfo/saveOrUpdateOilBaseInfo.do?districtCode=" + districtCode;
		
	}
	
	/**
	 * 导入Excel中油站编制维护的信息
	 * 根据Excel中的油站的编号和年月份确认一条记录, 然后INSERT或UPDATE到数据库中
	 * 不以区域作为过滤条件
	 */
	@RequestMapping("/importOilBaseInfo.do")
	public String importOilBaseInfo(HttpServletRequest request, HttpServletResponse response, String type,
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
			return "operation/oilbaseinfo/oilBaseInfoList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/oilbaseinfo/oilBaseInfoList";
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
			return "operation/oilbaseinfo/oilBaseInfoList";
		}
		
		//判断上传的是不是油站关键指标Excel
//		XSSFRow row = sheet.getRow(0);
//		XSSFCell cell = row.getCell(1);
//		if (String.valueOf(cell).contains("油") && String.valueOf(cell).contains("标")) {
//			String excelName = String.valueOf(cell).substring(String.valueOf(cell).indexOf("油"), String.valueOf(cell).indexOf("标") + 1);
//			if (!"油站关键指标".equals(excelName)) {
//				Flag flag = new Flag();
//				flag.setFlag("3");
//				model.addAttribute("Flag", flag);
//				return "operation/oilbaseinfo/oilBaseInfoList";
//			}
//		}else{
//			Flag flag = new Flag();
//			flag.setFlag("3");
//			model.addAttribute("Flag", flag);
//			return "operation/oilbaseinfo/oilBaseInfoList";
//		}
		
		//从Excel中获取年月份
//		String yearMonth = cell.getStringCellValue();
//		if (String.valueOf(cell).contains("年")) {
//			String year = String.valueOf(cell).substring(0, String.valueOf(cell).indexOf("年"));
//			year = year.trim(); // 去空, 保证得到的是不掺和空格的阿拉伯数字
//			String month = String.valueOf(cell).substring(String.valueOf(cell).indexOf("年") + 1, String.valueOf(cell).indexOf("月"));
//			month = month.trim(); // 去空, 保证得到的是不掺和空格的阿拉伯数字
//			//如果截取的月份是9, 则  9 -----> 09
//			if (Integer.parseInt(month) < 10) {
//				month = "0" + month;
//			}
//			yearMonth = year +  "-" +month; // 2015年       1   月 油站关键指标（营运部-厦门区域） -----> 2015-01
//		}else{
//			Flag flag = new Flag();
//			flag.setFlag("3");
//			model.addAttribute("Flag", flag);
//			return "operation/oilbaseinfo/oilBaseInfoList";
//		}
		
		//遍历Excel表格, 将所有可用的数据解析出来, 准备对比数据库中数据进行入库或更新
		int cellNum = 0;
		XSSFRow row2 = null;
		List<StationTarget> excelStationTargetList = new ArrayList<StationTarget>();
		StationTarget stationTarget = null;
		//StringUtil strUtil = new StringUtil();
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			cellNum = 0; // 第1列(A列)开始梳理数据
			//判断油站编号是否可用, 如果油站编号不可用, 则弃用整行数据
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				break;
			}
			if (null == row2.getCell(cellNum) || "".equals(row2.getCell(cellNum).getStringCellValue())) {
				break;
			} 
			//油站编号
			stationTarget = new StationTarget(); 
			stationTarget.setStationCode(String.valueOf(row2.getCell(cellNum++)));
			
			//油站名称
//			cellNum = 3;
			stationTarget.setStationName(row2.getCell(cellNum++).getStringCellValue());
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				stationTarget.setStationName(String.valueOf(row2.getCell(cellNum)));
//			}else{
//				stationTarget.setStationName("Excel表格中并没有填写油站名称");
//			}
			//定编人数
			Integer stationStaffNum = 0;
			if(row2.getCell(cellNum) != null){
				stationStaffNum = new Integer(Double.valueOf(row2.getCell(cellNum++).getNumericCellValue()).intValue());
			}
			stationTarget.setStationStaffNum(stationStaffNum);
			//cellNum++;
			// 浮动编制人数
			//stationTarget.setStationStaffNumFloat(new Integer(Double.valueOf(row2.getCell(cellNum++).getNumericCellValue()).intValue()));
			Integer stationStaffNumFloat = 0;
			if(row2.getCell(cellNum) != null){
				stationStaffNumFloat = new Integer(Double.valueOf(row2.getCell(cellNum++).getNumericCellValue()).intValue());
			}
			stationTarget.setStationStaffNumFloat(stationStaffNumFloat);

//			cellNum = 5;
//			System.out.println(String.valueOf(row2.getCell(cellNum)));
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				if (String.valueOf(row2.getCell(cellNum)).contains("#")) {
//					stationTarget.setStationStaffNumFloat(0);
//				}else{
//					String floatNum = String.valueOf(row2.getCell(cellNum)).substring(0, String.valueOf(row2.getCell(cellNum)).indexOf("."));
//					stationTarget.setStationStaffNumFloat(Integer.parseInt(floatNum));
//				}
//			}else{
//				stationTarget.setStationStaffNumFloat(0);
//			}
			
//			//MMP
//			cellNum = 7;
////			System.out.println(String.valueOf(row2.getCell(cellNum)));
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				if (String.valueOf(row2.getCell(cellNum)).contains("#")) {
//					stationTarget.setMmp(0d);
//				}else{
//					stationTarget.setMmp(Double.valueOf(strUtil.round(String.valueOf(row2.getCell(cellNum)))));
//				}
//			}else{
//				stationTarget.setMmp(0d);
//			}
//			
//			//NPS
//			cellNum = 8;
////			System.out.println(String.valueOf(row2.getCell(cellNum)));
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				if (String.valueOf(row2.getCell(cellNum)).contains("#")) {
//					stationTarget.setNps(0d);
//				}else{
//					stationTarget.setNps(Double.valueOf(strUtil.round(String.valueOf(row2.getCell(cellNum)))));
//				}
//			}else{
//				stationTarget.setNps(0d);
//			}
//			
//			//便利店业绩得分
//			cellNum = 18;
////			System.out.println(String.valueOf(row2.getCell(cellNum)));
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				if (String.valueOf(row2.getCell(cellNum)).contains("#")) { //防止"#N/A"
//					BigDecimal storeMarkScore = new BigDecimal("0");
//					stationTarget.setStoreMarkScore(storeMarkScore);
//				}else{
//					BigDecimal storeMarkScore = new BigDecimal(String.valueOf(row2.getCell(cellNum)));
//					stationTarget.setStoreMarkScore(storeMarkScore);
//				}
//			}else{
//				BigDecimal storeMarkScore = new BigDecimal("0");
//				stationTarget.setStoreMarkScore(storeMarkScore);
//			}
//			
//			//便利店管理得分
//			cellNum = 19;
////			System.out.println(String.valueOf(row2.getCell(cellNum)));
//			if (null != String.valueOf(row2.getCell(cellNum)) && !"".equals(String.valueOf(row2.getCell(cellNum)))) {
//				if (String.valueOf(row2.getCell(cellNum)).contains("#")) {
//					BigDecimal storeManageScore = new BigDecimal("0");
//					stationTarget.setStoreManageScore(storeManageScore);
//				}else{
//					BigDecimal storeManageScore = new BigDecimal(String.valueOf(row2.getCell(cellNum)));
//					stationTarget.setStoreManageScore(storeManageScore);
//				}
//			}else{
//				BigDecimal storeManageScore = new BigDecimal("0");
//				stationTarget.setStoreManageScore(storeManageScore);
//			}
			
			//年月份
			stationTarget.setYearMonth(yearMonth);
			
			//将Excel中的每一个StationTarget进入集合中
			excelStationTargetList.add(stationTarget);
		} 
		
		//将Excel中的数据与数据库中数据一一比对, 重复的UPDATE, 没有的INSERT
//		List<StationTarget> stationTargetList = oilBaseInfoService
//												.findAllOilBaseInfoByYearMonthAndDistrictCode(yearMonth, null);
//		将数据库中的数据和Excel中的数据取舍入库
//		stationTargetService.findAndComparisonStationTargetByStationCode(excelStationTargetList);
		// TODO 如果存在则update，如果不存在则insert
		stationTargetService.updateStationTargetByStationCode(excelStationTargetList, yearMonth);
		return "redirect:/oilBaseInfo/oilBaseInfoList.do";
		
	}
	
}
