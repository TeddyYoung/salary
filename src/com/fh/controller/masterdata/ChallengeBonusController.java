package com.fh.controller.masterdata;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.allinpay.ets.client.StringUtil;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.ChallengeBonus;
import com.fh.entity.biz.Station;
import com.fh.entity.system.DataDictionary;
import com.fh.entity.system.Flag;
import com.fh.entity.vo.ChallengeBonusSearchVO;
import com.fh.service.masterdata.ChallengeBonusService;
import com.fh.service.station.StationService;
import com.fh.service.system.DataDictionaryService;
import com.fh.util.AutoYearMonth;
import com.fh.util.ExcelUtil;
import com.fh.util.UploadFile;

/**
 * 过节费维护 Controller
 */
@Controller(value = "challengeBonusController")
@RequestMapping({ "/challengeBonus" })
public class ChallengeBonusController extends BaseController {

	@Autowired
	private ChallengeBonusService challengeBonusService;

	@Autowired
	private DataDictionaryService dataDictionaryService;

	@Autowired
	private StationService stationService;

	@RequestMapping("/challengeBonusList.do")
	public String challengeBonusList(Page page,
			ChallengeBonusSearchVO searchVO, Model model) {
		if ("".equals(searchVO.getYearMonth())
				|| null == searchVO.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			searchVO.setYearMonth(yearMonth);
		}
		Page pageList = challengeBonusService.findChallengeBonusPage(page,
				searchVO);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchVO", searchVO);// 页面查询条件

		return "masterdata/challengeBonus/challengeBonusList";
	}

	@RequestMapping("/challengeBonusToAdd.do")
	public String challengeBonusToAdd() {
		return "masterdata/challengeBonus/challengeBonusAdd";
	}

	@RequestMapping("/challengeBonusSaveOrUpdate.do")
	public String challengeBonusSaveOrUpdate(ChallengeBonus challengeBonus)
			throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		challengeBonusService.saveOrUpdate(challengeBonus);
		return "save_result";
	}

	@RequestMapping("/challengeBonusToUpdate.do")
	public String challengeBonusToUpdate(String challengeBonusId, Model model) {
		model.addAttribute("challengeBonus", challengeBonusService
				.getChallengeBonus(new Long(challengeBonusId)));
		return "masterdata/challengeBonus/challengeBonusEdit";
	}

	/**
	 * 删除地区维护
	 */
	@RequestMapping("/challengeBonusDelete.do")
	public void challengeBonusDelete(String challengeBonusId,
			HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			challengeBonusService.delete(new Long(challengeBonusId));
			// json中添加 数据 key value 形式
			js.put("result", "success");
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

	}

	/**
	 * 导入Excel中星级评测的信息 根据Excel中的油站的编号和年月份确认一条记录, 然后INSERT或UPDATE到数据库中 不以区域作为过滤条件
	 */
	@RequestMapping("/importList.do")
	public String importList(HttpServletRequest request, String type,
			MultipartFile uploadFile, Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		// int stationTargets =
		// stationTargetService.findStationTargetsCountByYearMonth(yearMonth);
		// if (0 == stationTargets) {
		// Flag flag = new Flag();
		// flag.setFlag("4");
		// model.addAttribute("Flag", flag);
		// return "masterdata/challengeBonus/challengeBonusAdd";
		// }

		// 判断上传的文件是否是空文件
		String originalFilename = uploadFile.getOriginalFilename();
		if ("" == originalFilename) {
			Flag flag = new Flag();
			flag.setFlag("1");
			model.addAttribute("Flag", flag);
			return "masterdata/challengeBonus/challengeBonusAdd";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "masterdata/challengeBonus/challengeBonusAdd";
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
			return "masterdata/challengeBonus/challengeBonusAdd";
		}

		int cellNum = 0;
		XSSFRow row2 = null;
		List<ChallengeBonus> challengeBonusList = new ArrayList<ChallengeBonus>();
		ChallengeBonus challengeBonus = null;
		ExcelUtil excelUtil = new ExcelUtil();
		String excMes = "";
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {// 从第二行开始读取数据
			XSSFCell cell = null;
			cellNum = 0; // 从第三列(A列)开始梳理数据
			// 判断油站编号是否可用, 如果油站编号不可用, 则弃用整行数据
			row2 = sheet.getRow(rowNum);
			if (null == row2 || "".equals(row2)) {
				continue;
			}
			if (null == row2.getCell(cellNum)
					|| "".equals(row2.getCell(cellNum).toString())) {
				continue;
			}
			String stationCode = row2.getCell(cellNum).toString();
			Station station = stationService
					.findOnlyStationByStationCode(stationCode);
			if (station == null) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【油站编号】不存在！";
				//throw new Exception("油站编号填写有误:" + stationCode);
			}
			// 油站编号
			challengeBonus = new ChallengeBonus();
			challengeBonus.setStationCode(stationCode);

			// 油站名称
			cellNum++;
			// String stationName = String.valueOf(row2.getCell(cellNum++));
			// challengeBonus.setStationName(stationName);

			// 计划天数
			// if (null == cellValue || "".equals(cellValue.toString().trim()))
			// {
			// throw new Exception("excel表中有[计划天数]的数据未维护，请仔细检查！");
			// } else {
			// challengeBonus.setPlanDay(cellValue.longValue());
			// }

			// 基础目标
			cellNum++;
			BigDecimal cellValue = excelUtil.getBigDecimalValue(row2
					.getCell(cellNum));
			// cellValue =
			// excelUtil.getBigDecimalValue(row2.getCell(cellNum++));
			if (null == cellValue || "".equals(cellValue.toString().trim())) {
				// challengeBonus.setBaseTarget(0l);
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【基础目标】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【基础目标】未填写！");
			} else {
				challengeBonus.setBaseTarget(cellValue.longValue());
			}
			// 中间目标
			// cellValue =
			// excelUtil.getBigDecimalValue(row2.getCell(cellNum++));
			// if (null == cellValue || "".equals(cellValue.toString().trim()))
			// {
			// throw new Exception("excel表中有[中间目标]的数据未维护，请仔细检查！");
			// } else {
			// challengeBonus.setMiddleTarget(cellValue.longValue());
			// }
			// 基础奖金
			cellNum++;
			cellValue = excelUtil.getBigDecimalValue(row2.getCell(cellNum));
			if (null == cellValue || "".equals(cellValue.toString().trim())) {
				// challengeBonus.setBaseBonusAmt(BigDecimal.ZERO);
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【基础奖金】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【基础奖金】未填写！");
			} else {
				challengeBonus.setBaseBonusAmt(cellValue);
			}
			// 挑战目标
			cellNum++;
			cellValue = excelUtil.getBigDecimalValue(row2.getCell(cellNum));
			if (null == cellValue || "".equals(cellValue.toString().trim())) {
				// challengeBonus.setChallengeTarget(0l);
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【挑战目标】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【挑战目标】未填写！");
			} else {
				challengeBonus.setChallengeTarget(cellValue.longValue());
			}
			// 挑战奖金
			cellNum++;
			cellValue = excelUtil.getBigDecimalValue(row2.getCell(cellNum));
			if (null == cellValue || "".equals(cellValue.toString().trim())) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【挑战奖金】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【挑战奖金】未填写！");
			} else {
				challengeBonus.setChallengeBonusAmt(cellValue);
			}
			// 挑战奖金类型
			cellNum++;
			cell = row2.getCell(cellNum);
			if (null == cell || "".equals(cell.toString().trim())) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【挑战奖金类型】未填写！";
				//throw new Exception("第" + (rowNum + 1) + "行【挑战奖金类型】未填写！");
			}
			String challengeBonusType = dataDictionaryService.getValueType(
					DataDictionary.CT_CHALLENGE_BONUS_TYPE, cell.toString());
			if (StringUtil.isEmpty(challengeBonusType)) {
				excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【挑战奖金类型】填写不正确！";
				//throw new Exception("第" + (rowNum + 1) + "行【挑战奖金类型】填写不正确！");
			}
			challengeBonus.setType(challengeBonusType);
			// 年月份
			challengeBonus.setYearMonth(yearMonth);

			// 将Excel中的每一个StationTarget进入集合中
			challengeBonusList.add(challengeBonus);
		}
		if (!"".equals(excMes)) {
			throw new Exception(excMes);
		}
		// 将Excel中的全部数据UPDATE入库
		challengeBonusService.updateList(challengeBonusList);
		return "redirect:/challengeBonus/challengeBonusList.do";

	}

}
