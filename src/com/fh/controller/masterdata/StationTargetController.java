package com.fh.controller.masterdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.StationTarget;
import com.fh.entity.biz.StationTargetVO;
import com.fh.entity.vo.SellDataSearchVO;
import com.fh.service.masterdata.StationTargetService;

/**
 * 油站指标系数维护
 * 
 * @author lijn
 * 
 */
@Controller(value = "stationTargetController")
@RequestMapping({ "/stationTarget" })
public class StationTargetController extends BaseController {

	@Autowired
	private StationTargetService stationTargetService;

	/**
	 * 油站指标系数列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/stationTargetList.do")
	public String list(Page page, SellDataSearchVO searchVO, Model model) {

//		if ("".equals(stationTarget.getYearMonth()) || null == stationTarget.getYearMonth()) {
//			AutoYearMonth autoYearMonth = new AutoYearMonth();
//			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
//			stationTarget.setYearMonth(yearMonth);
//		}
		
		Page pageList = stationTargetService.findStationTargetsByPage(page,searchVO);
		model.addAttribute("pageList", pageList);

		// StationTarget st = new StationTarget();
		// st.setStationCode(stationTarget.getStationCode());
		// st.setYearMonth(stationTarget.getYearMonth());
		model.addAttribute("searchVO", searchVO);

		return "masterdata/stationTarget/stationTargetList";

	}

	/**
	 * 跳转至添加油站指标系数页面
	 */
	@RequestMapping("/stationTargetToAdd.do")
	public String stationTargetToAdd() {

		return "masterdata/stationTarget/stationTargetAdd";

	}

	/**
	 * 添加或修改油站指标系数
	 */
	@RequestMapping("/stationTargetSaveOrUpdate.do")
	public String stationTargetSaveOrUpdate(StationTargetVO stationTargetvo) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		if (stationTargetvo.getStationTargetList().size() != 0) {
			stationTargetService.saveOrUpdate(stationTargetvo
					.getStationTargetList());
		}
		return "redirect:/stationTarget/stationTargetList.do";

	}

	/**
	 * 跳转至查看员工油站指标系数
	 */
	@RequestMapping("/stationTargetToView.do")
	public String stationTargetToView(String id, Model model) {

		model.addAttribute("stationTarget",
				stationTargetService.findStationTargetById(id));
		return "masterdata/stationTarget/stationTargetView";

	}

	/**
	 * 跳转至修改员工油站指标系数
	 */
	@RequestMapping("/staffTargetToEdit.do")
	public String stationTargetToEdit(String ids, Model model) {
		List<StationTarget> stationTargetList = new ArrayList<StationTarget>();
		if ("".equals(ids) || ids == null) {
			stationTargetList = stationTargetService.queryAll();
		} else {
			stationTargetList = stationTargetService
					.findStationTargetByIds(ids);
		}
		model.addAttribute("stationTargetList", stationTargetList);
		return "masterdata/stationTarget/stationTargetEdit";
	}

	/**
	 * 跳转至设置员工油站指标系数
	 */
	@RequestMapping("/toStationTargetSettings.do")
	public String toStationTargetSettings(String stationCode, Model model) {
		List<StationTarget> stationTargets = stationTargetService
				.findStationTargetByStationCode(stationCode);
		List<StationTarget> stationTargetList = new ArrayList<StationTarget>();

		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy");
		String year = sDateFormat.format(new Date());
		if (stationTargets != null) {
			for (int i = 1; i < 13; i++) {
				int flag = 0;
				String yearMonth = null;
				if (i < 10) {
					yearMonth = year + "-" + "0" + String.valueOf(i);
				} else {
					yearMonth = year + "-" + String.valueOf(i);
				}
				for (StationTarget stationTarget : stationTargets) {
					if (yearMonth.equals(stationTarget.getYearMonth())) {
						stationTargetList.add(stationTarget);
						flag = 1;
						break;
					}

				}
				if (flag == 0) {
					StationTarget st = new StationTarget();
					st.setStationCode(stationCode);
					st.setYearMonth(yearMonth);
					stationTargetList.add(st);
				}
			}
		}else{
			for (int i = 1; i < 13; i++) {
				String yearMonth = null;
				if (i < 10) {
					yearMonth = year + "-" + "0" + String.valueOf(i);
				} else {
					yearMonth = year + "-" + String.valueOf(i);
				}
				StationTarget st = new StationTarget();
				st.setStationCode(stationCode);
				st.setYearMonth(yearMonth);
				stationTargetList.add(st);
			}
		}
		model.addAttribute("stationCode", stationCode);
		model.addAttribute("stationTargetList", stationTargetList);
		return "masterdata/stationTarget/stationTargetSettings";
	}

	/**
	 * 删除油站指标系数(支持批量删除)
	 */
	@RequestMapping("/stationTargetDelById.do")
	public void delete(String ids, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				stationTargetService.delete(id);
			}
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

}
