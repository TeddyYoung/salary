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
import com.fh.entity.biz.StationLevel;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTargetVO;
import com.fh.entity.system.Flag;
import com.fh.entity.vo.ResultVO;
import com.fh.service.masterdata.StationTargetService;
import com.fh.service.operation.StarEvaluatingService;
import com.fh.service.operation.StationLevelService;
import com.fh.util.AutoYearMonth;
import com.fh.util.ExcelUtil;
import com.fh.util.UploadFile;

/**
 * 星级评测Controller
 * @author zhang_yu
 * 以月作为单位, 加载所有的信息, 但维护只允许维护上个月的信息
 *
 */
@Controller(value="mmpNpsController")
@RequestMapping({"/mmpNps"})
public class MmpNpsController extends BaseController {

	@Autowired
	private StarEvaluatingService starEvaluatingService;
	@Autowired
	private StationLevelService stationLevelService;
	@Autowired
	private StationTargetService stationTargetService;
	
	/**
	 * 星级评测(展示biz_station_target中的部分字段: MMP、NPS)
	 */
	@RequestMapping("/mmpNpsList.do")
	public String mmpNpsList(HttpServletRequest request, Page page, StationTarget stationTarget, Model model) {
		
		//当用户点击二级菜单"油站基础信息"的时候, 默认查询上个月的记录
		if ("".equals(stationTarget.getYearMonth()) || null == stationTarget.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
			stationTarget.setYearMonth(yearMonth);
		}
		
		//TODO 当用户点击二级菜单"油站基础信息"的时候, 默认加载当前用户所属的区域的信息
		//若当前用户无所在区域信息, 则加载所有信息
//		StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
//		String districtCode = storeEmployee.getDistrictCode();
//		if(null == districtCode) {}
		
		if ("".equals(stationTarget.getDistrictCode())) {
			stationTarget.setDistrictCode(null);
		}
		
		Page pageList = starEvaluatingService.findStarEvaluatingByPage(page, 
																	   stationTarget.getYearMonth(), 
																	   stationTarget.getDistrictCode());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", stationTarget);
		return "operation/mmpnps/mmpNpsList";
		
	}
	
	/**
	 * 去添加或修改星级评测信息页面
	 */
	@RequestMapping("/saveOrUpdateMmpNps.do")
	public String saveOrUpdateMmpNps(String districtCode, Model model) {
		
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
		
		//TODO 当用户点击二级菜单"油站基础信息"的时候, 默认加载当前用户所属的区域的信息
		//若当前用户无所在区域信息, 则加载所有信息
		
		if ("".equals(districtCode)) {
			districtCode = null;
		}
		
		Flag flag2 = new Flag();
		flag2.setFlag(districtCode);
		model.addAttribute("Flag2", flag2);
		
		List<StationTarget> stationTargetList = starEvaluatingService.findAllStarevaluatingByYearMonthAndDistrictCode(yearMonth, districtCode);
		model.addAttribute("stationTargetList", stationTargetList);
		
		List<StationLevel> stationLevels = stationLevelService.queryAll();
		model.addAttribute("stationLevels", stationLevels);
		
		Flag flag = new Flag();
		flag.setFlag(yearMonth);
		model.addAttribute("Flag", flag);
		
		return "operation/mmpnps/saveOrUpdatemmpNps";
		
	}
	
	/**
	 * 添加或修改星级评测信息
	 */
	@RequestMapping("/mmpNpsRealSaveOrUpdate.do")
	public String mmpNpsRealSaveOrUpdate(String districtCode, StationTargetVO stationTargetVO, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		if (stationTargetVO.getStationTargetList().size() != 0) {
			starEvaluatingService.saveOrUpdateStarEvaluating(stationTargetVO.getStationTargetList());
		}
		return "redirect:/mmpNps/saveOrUpdateMmpNps.do?districtCode=" + districtCode;
		
	}
	
	/**
	 * 导入Excel中星级评测的信息
	 * 根据Excel中的油站的编号和年月份确认一条记录, 然后INSERT或UPDATE到数据库中
	 * 不以区域作为过滤条件
	 */
	@RequestMapping("/importList.do")
	public String importList(HttpServletRequest request, String type,
									MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		int stationTargets = stationTargetService.findStationTargetsCountByYearMonth(yearMonth);
		if (0 == stationTargets) {
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/mmpnps/mmpNpsList";
		}
		
		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "operation/mmpnps/mmpNpsList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/mmpnps/mmpNpsList";
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
			return "operation/mmpnps/mmpNpsList";
		}
		int cellNum = 0;
		XSSFRow row2 = null;
		List<StationTarget> excelStationTargetList = new ArrayList<StationTarget>();
		StationTarget stationTarget = null;
		ExcelUtil excelUtil = new ExcelUtil();
		String excMes = "";
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {// 从第二行开始读取数据
			cellNum = 0; // 从第三列(A列)开始梳理数据
			//判断油站编号是否可用, 如果油站编号不可用, 则弃用整行数据
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				continue;
			}
			if (null == row2.getCell(cellNum) || "".equals(row2.getCell(cellNum).getStringCellValue())) {
				continue;
			} 
			
			// 油站编号
			stationTarget = new StationTarget(); 
			stationTarget.setStationCode(String.valueOf(row2.getCell(cellNum++)));
			
			// 油站名称
			String stationName = String.valueOf(row2.getCell(cellNum++));
			stationTarget.setStationName(stationName);
			
			// MMP
			BigDecimal cellValue = excelUtil.getBigDecimalValue(row2.getCell(cellNum++));
			if (null == cellValue || "".equals(cellValue.toString().trim())) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【MMP】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【MMP】未填写！");
			} else {
				stationTarget.setMmp(cellValue.doubleValue());
			}
			
			// NPS
			cellValue = excelUtil.getBigDecimalValue(row2.getCell(cellNum++));
			if (null == cellValue || "".equals(cellValue.toString().trim())) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【NPS】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【NPS】未填写！");
			} else {
				stationTarget.setNps(cellValue.doubleValue());
			}
			
			//年月份
			stationTarget.setYearMonth(yearMonth);
			
			//将Excel中的每一个StationTarget进入集合中
			excelStationTargetList.add(stationTarget);
		}
		boolean submit = true;
		if(!"".equals(excMes)){
			submit = false;
		}
		//将Excel中的全部数据UPDATE入库
		ResultVO resultVO = stationTargetService.updateStationTargetByStationCode(excelStationTargetList, yearMonth,submit);
		if(resultVO.getFail() > 0){
			excMes = excMes + resultVO.getFailMes();
		}
		if (!"".equals(excMes)) {
			throw new Exception(excMes);
		}
		return "redirect:/mmpNps/mmpNpsList.do";
		
	}
	
}
