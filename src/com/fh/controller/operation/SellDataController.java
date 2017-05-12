package com.fh.controller.operation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.fh.entity.biz.Station;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.system.Flag;
import com.fh.entity.vo.SellDataSearchVO;
import com.fh.service.masterdata.StationTargetService;
import com.fh.service.station.StationService;
import com.fh.util.AutoYearMonth;
import com.fh.util.UploadFile;

/**
 * 销售数据维护
 * 
 * @author lijn
 *
 */
@Controller(value = "sellDataController")
@RequestMapping({ "/sellData" })
public class SellDataController extends BaseController {

	@Autowired
	private StationTargetService stationTargetService;
	@Autowired
	private StationService stationService;
	

	/**
	 * 销售数据列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/sellDataList.do")
	public String list(Page page, SellDataSearchVO searchVO, Model model) {

		if ("".equals(searchVO.getYearMonth())
				|| null == searchVO.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			searchVO.setYearMonth(yearMonth);
		}

		Page pageList = stationTargetService.findStationTargetsByPage(page,searchVO);
		model.addAttribute("pageList", pageList);

//		StationTarget st = new StationTarget();
//		st.setStationCode(stationTarget.getStationCode());
//		st.setYearMonth(stationTarget.getYearMonth());
		model.addAttribute("searchVO", searchVO);

		return "operation/sellData/sellDataList";

	}

	/**
	 * 跳转至添加销售数据页面
	 */
	@RequestMapping("/sellDataToAdd.do")
	public String sellDataToAdd() {

		return "operation/sellData/sellDataAdd";

	}

	/**
	 * 添加或修改销售数据
	 */
	@RequestMapping("/sellDataSaveOrUpdate.do")
	public String sellDataSaveOrUpdate(StationTarget stationTarget)
			throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}

		stationTargetService.saveOrUpdateStationTarget(stationTarget);
		return "save_result";

	}

	/**
	 * 跳转至查看员工销售数据
	 */
	@RequestMapping("/sellDataToView.do")
	public String sellDataToView(String id, Model model) {

		model.addAttribute("stationTarget",
				stationTargetService.findStationTargetById(id));
		return "operation/sellData/sellDataView";

	}

	/**
	 * 跳转至修改员工销售数据
	 */
	@RequestMapping("/sellDataToEdit.do")
	public String sellDataToEdit(String id, Model model) {
		StationTarget stationTarget = stationTargetService
				.findStationTargetById(id);
		if (stationTarget.getOilStandardRate().compareTo(BigDecimal.ZERO) > 0) {
			stationTarget.setOilStandardRate(stationTarget.getOilStandardRate()
					.multiply(new BigDecimal(100)));
		}
		if (stationTarget.getNonOilStandardRate().compareTo(BigDecimal.ZERO) > 0) {
			stationTarget.setNonOilStandardRate(stationTarget
					.getNonOilStandardRate().multiply(new BigDecimal(100)));
		}

		model.addAttribute("stationTarget", stationTarget);
		return "operation/sellData/sellDataEdit";

	}

	/**
	 * 删除销售数据(支持批量删除)
	 */
	@RequestMapping("/sellDataDelById.do")
	public void delete(String id, HttpServletResponse response)
			throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			stationTargetService.delete(id);
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
	 * 导入销售数据
	 */
	@RequestMapping("/sellDataImportData.do")
	public void importData(String sale_month, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			JSONObject appendJs = new JSONObject();
			JSONObject subAppendJs = new JSONObject();

			// String app_ident="1123213123123";
			if ("".equals(sale_month) || sale_month == null) {
				Calendar date = Calendar.getInstance();
				date.add(Calendar.MONTH, -1);
				sale_month = new SimpleDateFormat("yyyy-MM").format(date
						.getTime());
			}
			subAppendJs.put("sale_month", sale_month);
			appendJs.put("app_ident", "1123213123123");
			appendJs.put("request_data", subAppendJs.toString());
			JSONObject js = new JSONObject();
			StringBuffer url_buffer = request.getRequestURL();
			String substring = url_buffer.substring(0, url_buffer.toString()
					.lastIndexOf("/sellData/"));
			// String substring="http://120.26.206.74:7001/fhmssql";
			URL url = new URL(substring + "/sellData/getJsonData.doc");
			StringBuffer json = new StringBuffer();
			URLConnection uc = url.openConnection();
			// 设置通用的请求属性
			uc.setRequestProperty("accept", "*/*");
			uc.setRequestProperty("connection", "Keep-Alive");
			uc.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			uc.setDoOutput(true);
			uc.setDoInput(true);
			out = new PrintWriter(uc.getOutputStream());
			// 发送请求参数
			// out.print(app_ident);
			// out.print(request_data.put("sale_month", sale_month));
			out.print("request_data=" + appendJs.toString());
			// flush输出流的缓冲
			out.flush();
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
			System.out.println(json.toString());
			// json="{\"response_status\":\"success\",\"response_data\":[{\"sid\":\"2015100001\",\"oils\":\"100.11\",\"oild\":\"10\",\"oilrate\":\"99.1\",\"noils\":\"200.1\",\"noild\":\"10\" ,\"noilrate\":\"95.1\",\"yearMonth\":\"2015-10\"},{\"sid\":\" 2015100002 \",\"oils \":\"100.11\",\"oild\":\"10\" ,\"oilrate\":\"99.1\",\"noils\":\"200.1\",\"noild\":\"10\" ,\"noilrate\":\"99.1\",\"yearMonth\":\"2015-10\"},{\"sid\":\" 2015100003 \",\"oils\":\"100.11\",\"oilrate\":\"99.1\",\"oild\":\"10\",\"noils\":\"200.1\",\"noild\":\"10\" ,\"noilrate\":\"99.1\",\"yearMonth\":\"2015-10\"},{\"sid\":\" 2015100004 \",\"oils\":\"163.74\",\"oilrate\":\"89.6\",\"oild\":\"56\",\"noils\":\"71.4\",\"noild\":\"72.9\" ,\"noilrate\":\"121.3\",\"yearMonth\":\"2015-10\"}]}";
			/* json=json.replace(" ", ""); */
			JSONObject jsonObject = JSONObject.fromObject(json.toString());
			JSONArray jsonArray = jsonObject.getJSONArray("response_data");
			if (jsonArray != null && jsonArray.size() > 0) {
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObjectToArray = jsonArray.getJSONObject(i);
					String stationCodeJson = jsonObjectToArray.getString("sid");
					String yearMonthJson = jsonObjectToArray
							.getString("yearMonth");
					if (stationCodeJson != null && !"".equals(stationCodeJson)
							&& yearMonthJson != null
							&& !"".equals(yearMonthJson)) {
						StationTarget stationTarget = stationTargetService
								.findStationTargetByStationCodeAndYearMonth(
										stationCodeJson, yearMonthJson);
						if (stationTarget == null || "".equals(stationTarget)) {
							stationTarget = new StationTarget();
						}
						stationTarget.setOilRealVolume(BigDecimal
								.valueOf(jsonObjectToArray.getDouble("oils")));
						stationTarget.setOilDayAverageVolume(BigDecimal
								.valueOf(jsonObjectToArray.getDouble("oild")));
						stationTarget
								.setOilStandardRate(BigDecimal
										.valueOf(jsonObjectToArray
												.getDouble("oilrate")));
						stationTarget.setNonOilRealVolume(BigDecimal
								.valueOf(jsonObjectToArray.getDouble("noils")));
						stationTarget.setNonOilDayAverageVolume(BigDecimal
								.valueOf(jsonObjectToArray.getDouble("noild")));
						stationTarget.setNonOilStandardRate(BigDecimal
								.valueOf(jsonObjectToArray
										.getDouble("noilrate")));
						stationTargetService
								.saveOrUpdateStationTarget(stationTarget);
						js.put("result", "success");
					} else {
						js.put("result", "false");
					}
				}
			} else {
				js.put("result", "false");
			}
			// json中添加 数据 key value 形式
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			throw new IllegalArgumentException(e);
		}// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	/**
	 * 导入Excel数据
	 */
	@RequestMapping("/import.do")
	public String importSellData(HttpServletRequest request, String type,
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
			return "operation/sellData/sellDataList";
		}

		// 判断上传的是否是Excel文件
		String substring = originalFilename.substring(originalFilename
				.lastIndexOf("."));
		if (!".xlsx".equals(substring)) {
			Flag flag = new Flag();
			flag.setFlag("2");
			model.addAttribute("Flag", flag);
			return "operation/sellData/sellDataList";
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
			return "operation/sellData/sellDataList";
		}

		// 准备解析Excel
		int cellNum = 0;
		XSSFRow row2 = null;
		// XSSFCell cell2 = null;
		List<StationTarget> stationTargetList = new ArrayList<StationTarget>();
		StationTarget stationTarget = null;
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		String excMes = "";
		// 解析数据
		for (int rowNum = 3; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
			String cellReference = "";
			cellNum = 0; // 员工编号(油站会计)

			// 以员工编号的有无判断数据的可用性
			row2 = sheet.getRow(rowNum);
			stationTarget = new StationTarget();
			String stationCode = "";
			if (null != row2.getCell(cellNum)
					&& !"".equals(String.valueOf(row2.getCell(cellNum)).trim())) {
				cellReference = row2.getCell(cellNum).getReference();
				stationCode = String.valueOf(row2.getCell(cellNum));
				stationTarget.setStationCode(stationCode);
				
				Station station = stationService
						.findOnlyStationByStationCode(stationCode);
				if (station == null) {
					excMes = excMes + "\n" + "第" + (rowNum + 1) + "行【油站编号】不存在！";
				}
			} else {
				continue;
			}
			// 油站名称
			cellNum++;
			try {
				// 油品目标销量（升）
				cellNum++;
				BigDecimal oilTargetVolume = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					oilTargetVolume = new BigDecimal(row2.getCell(cellNum)
							.getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_CEILING);
				}
				stationTarget.setOilTargetVolume(oilTargetVolume);
				// 油品实际销量（升）
				cellNum++;
				BigDecimal oilRealVolume = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					oilRealVolume = new BigDecimal(row2.getCell(cellNum)
							.getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_CEILING);
				}
				stationTarget.setOilRealVolume(oilRealVolume);
				// 油品日均销量（升）
				cellNum++;
				BigDecimal oilDayAverageVolume = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					oilDayAverageVolume = new BigDecimal(row2.getCell(cellNum)
							.getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_HALF_UP);
				}
				stationTarget.setOilDayAverageVolume(oilDayAverageVolume);

				// 油站经理小配、直销奖金
				cellNum++;
				BigDecimal directSellingBonus = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					directSellingBonus = new BigDecimal(row2.getCell(cellNum)
							.getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_CEILING);
				}
				stationTarget.setDirectSellingBonus(directSellingBonus);
				// 油品达标率
				// cellNum++;
				// BigDecimal oilStandardRate = new BigDecimal(0);
				// if (null != row2.getCell(cellNum) &&
				// !"".equals(String.valueOf(row2.getCell(cellNum)))) {
				// oilStandardRate = new
				// BigDecimal(String.valueOf(row2.getCell(cellNum)));
				// stationTarget.setOilStandardRate(oilStandardRate);
				// }

				// 非油品目标销量
				cellNum++;
				BigDecimal nonOilTargetVolume = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					nonOilTargetVolume = new BigDecimal(row2.getCell(cellNum)
							.getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_CEILING);
				}
				stationTarget.setNonOilTargetVolume(nonOilTargetVolume);
				// 非油品实际销量
				cellNum++;
				BigDecimal nonOilRealVolume = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					nonOilRealVolume = new BigDecimal(row2.getCell(cellNum)
							.getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_CEILING);
				}
				stationTarget.setNonOilRealVolume(nonOilRealVolume);
				// 非油品日均销量
				cellNum++;
				BigDecimal nonOilDayAverageVolume = new BigDecimal(0);
				if (null != row2.getCell(cellNum)
						&& !"".equals(String.valueOf(row2.getCell(cellNum))
								.trim())) {
					cellReference = row2.getCell(cellNum).getReference();
					nonOilDayAverageVolume = new BigDecimal(row2.getCell(
							cellNum).getNumericCellValue()).setScale(2,
							BigDecimal.ROUND_CEILING);
				}
				stationTarget
				.setNonOilDayAverageVolume(nonOilDayAverageVolume);

			} catch (NumberFormatException e) {
				excMes = excMes + "\n" + "单元格:" + cellReference + ",数据格式有误(数值型)！";
				//throw new Exception("单元格:" + cellReference + ",数据格式有误(数值型)！");
			} catch (IllegalStateException e) {
				excMes = excMes + "\n" + "单元格:" + cellReference + ",数据格式有误(数值型)！";
				//throw new Exception("单元格:" + cellReference + ",数据格式有误(数值型)！");
			}

			stationTarget.setYearMonth(yearMonth);
			stationTargetList.add(stationTarget);
		}
		if (!"".equals(excMes)) {
			throw new Exception(excMes);
		}
		// 判断上传的是否是没有数据的空文件模板
		if (null != stationTargetList && stationTargetList.size() != 0) {
			stationTargetService.insertAllByYearMonth(stationTargetList);
			return "redirect:/sellData/sellDataList.do";
		} else {
			Flag flag = new Flag();
			flag.setFlag("4");
			model.addAttribute("Flag", flag);
			return "operation/sellData/sellDataList";
		}

	}
}
