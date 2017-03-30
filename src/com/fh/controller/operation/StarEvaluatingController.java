package com.fh.controller.operation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.fh.service.masterdata.StationTargetService;
import com.fh.service.operation.StarEvaluatingService;
import com.fh.service.operation.StationLevelService;
import com.fh.util.AutoYearMonth;
import com.fh.util.StringUtil;
import com.fh.util.UploadFile;

/**
 * 星级评测Controller
 * 
 * @author zhang_yu 以月作为单位, 加载所有的信息, 但维护只允许维护上个月的信息
 *
 */
@Controller(value = "starEvaluatingController")
@RequestMapping({ "/starEvaluating" })
public class StarEvaluatingController extends BaseController {

	@Autowired
	private StarEvaluatingService starEvaluatingService;
	@Autowired
	private StationLevelService stationLevelService;
	@Autowired
	private StationTargetService stationTargetService;

	/**
	 * 星级评测(展示biz_station_target中的部分字段: 星级站)
	 */
	@RequestMapping("/starEvaluatingList.do")
	public String starEvaluatingList(Page page, StationTarget stationTarget,
			Model model) {

		// 当用户点击二级菜单"星级评测"的时候, 默认查询上个月的记录
		if ("".equals(stationTarget.getYearMonth())
				|| null == stationTarget.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			stationTarget.setYearMonth(yearMonth);
		}

		if ("".equals(stationTarget.getDistrictCode())) {
			stationTarget.setDistrictCode(null);
		}

		Page pageList = starEvaluatingService.findStarEvaluatingByPage(page,
				stationTarget.getYearMonth(), stationTarget.getDistrictCode());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", stationTarget);
		return "operation/starevaluating/starEvaluatingList";

	}

	/**
	 * 去添加或修改星级评测信息页面
	 */
	@RequestMapping("/saveOrUpdatestarEvaluating.do")
	public String saveOrUpdatestarEvaluating(String districtCode, Model model) {

		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期

		// TODO 当用户点击二级菜单"星级评测"的时候, 默认加载当前用户所属的区域的信息
		// 若当前用户无所在区域信息, 则加载所有信息

		if ("".equals(districtCode)) {
			districtCode = null;
		}

		Flag flag2 = new Flag();
		flag2.setFlag(districtCode);
		model.addAttribute("Flag2", flag2);

		List<StationTarget> stationTargetList = starEvaluatingService
				.findAllStarevaluatingByYearMonthAndDistrictCode(yearMonth,
						districtCode);
		model.addAttribute("stationTargetList", stationTargetList);

		List<StationLevel> stationLevels = stationLevelService.queryAll();
		model.addAttribute("stationLevels", stationLevels);

		Flag flag = new Flag();
		flag.setFlag(yearMonth);
		model.addAttribute("Flag", flag);

		return "operation/starevaluating/saveOrUpdateStarEvaluating";

	}

	/**
	 * 添加或修改星级评测信息
	 */
	@RequestMapping("/starEvaluatingRealSaveOrUpdate.do")
	public String starEvaluatingRealSaveOrUpdate(String districtCode,
			StationTargetVO stationTargetVO, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		if (stationTargetVO.getStationTargetList().size() != 0) {
			starEvaluatingService.saveOrUpdateStarEvaluating(stationTargetVO
					.getStationTargetList());
		}
		// return
		// "redirect:/starEvaluating/saveOrUpdatestarEvaluating.do?districtCode="
		// + districtCode;
		return "redirect:/starEvaluating/starEvaluatingList.do";

	}

	/**
	 * 导入Excel中星级评测的信息 根据Excel中的油站的编号和年月份确认一条记录, 然后INSERT或UPDATE到数据库中 不以区域作为过滤条件
	 */
	@RequestMapping("/importOilBaseInfo.do")
	public String importOilBaseInfo(HttpServletRequest request, String type,
			MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// 判断营运部门当月上月数据是否有维护
		// 如果没有维护, 给予提示, 先让营运部门维护营运数据
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		int stationTargets = stationTargetService
				.findStationTargetsCountByYearMonth(yearMonth);
		if (0 == stationTargets) {
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/starevaluating/starEvaluatingList";
		}

		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "operation/starevaluating/starEvaluatingList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/starevaluating/starEvaluatingList";
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
			return "operation/starevaluating/starEvaluatingList";
		}

		// 判断上传的是不是油站星级评测的Excel
		// XSSFRow row = sheet.getRow(0);
		// XSSFCell cell = row.getCell(25);
		// if (String.valueOf(cell).contains("油") &&
		// String.valueOf(cell).contains("级")) {
		// String excelName =
		// String.valueOf(cell).substring(String.valueOf(cell).indexOf("油"),
		// String.valueOf(cell).indexOf("级") + 1);
		// if (!"油站星级".equals(excelName)) {
		// Flag flag = new Flag();
		// flag.setFlag("3");
		// model.addAttribute("Flag", flag);
		// return "operation/starevaluating/starEvaluatingList";
		// }
		// }else{
		// Flag flag = new Flag();
		// flag.setFlag("3");
		// model.addAttribute("Flag", flag);
		// return "operation/starevaluating/starEvaluatingList";
		// }

		// 获取上个月的的年月份
		// AutoYearMonth autoYearMonth = new AutoYearMonth();
		// String yearMonth = autoYearMonth.getAutoYearMonth();

		// 遍历Excel表格, 将所有可用的数据解析出来
		XSSFRow row2 = null;
		List<StationTarget> excelStationTargetList = new ArrayList<StationTarget>();
		StationTarget stationTarget = null;
		List<StationLevel> stationLevelList = this.stationLevelService
				.queryAll();
		Map<String, String> stationLevelMap = new HashMap<String, String>();
		for (StationLevel stationLevel : stationLevelList) {
			stationLevelMap.put(stationLevel.getStationLevelName(),
					stationLevel.getStationLevelCode());
		}
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			int cellNum = 0; // 从第三列(C列)开始梳理数据
			// 判断油站编号是否可用, 如果油站编号不可用, 则弃用整行数据
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				break;
			}
			if (null == row2.getCell(cellNum)
					|| "".equals(row2.getCell(cellNum).getStringCellValue())) {
				//throw new Exception("第" + (rowNum + 1) + "行【油站编号】未填写！");
				break;
			}

			// 油站编号
			stationTarget = new StationTarget();
			stationTarget.setStationCode(row2.getCell(cellNum)
					.getStringCellValue());
			// 油站名称
			cellNum++;
			// 油站星级
			cellNum++;
			if (null == row2.getCell(cellNum)
					&& "".equals(String.valueOf(row2.getCell(cellNum)))) {
				throw new Exception("第" + (rowNum + 1) + "行【油站星级】未填写！");
			}
			String stationLevelName = String.valueOf(row2.getCell(cellNum));
			String stationLevelCode = stationLevelMap.get(stationLevelName);
			if (StringUtil.isEmpty(stationLevelCode)) {
				throw new Exception("第" + (rowNum + 1) + "行【油站星级】填写不正确！");
			}
			stationTarget.setStationLevelName(stationLevelName);
			stationTarget.setStationLevelCode(stationLevelCode);

			// 年月份
			stationTarget.setYearMonth(yearMonth);

			// 将Excel中的每一个StationTarget进入集合中
			excelStationTargetList.add(stationTarget);
		}
		// 将Excel中的全部数据UPDATE入库
		// starEvaluatingService.updateExcelDataByStationCode(excelStationTargetList);
		stationTargetService.updateStationTargetByStationCode(
				excelStationTargetList, yearMonth);
		return "redirect:/starEvaluating/starEvaluatingList.do";

	}

}
