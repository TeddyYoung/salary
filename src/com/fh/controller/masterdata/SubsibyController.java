package com.fh.controller.masterdata;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Holiday;
import com.fh.service.masterdata.HolidayService;
import com.fh.util.AutoYearMonth;
import com.fh.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 补贴维护 Controller
 */
@Controller(value = "subsibyController")
@RequestMapping({ "/subsiby" })
public class SubsibyController extends BaseController {

	@Autowired
	private HolidayService holidayService;

	/**
	 * 地区维护列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Page page, Holiday holiday, Model model) {
		if ("".equals(holiday.getYearMonth()) || null == holiday.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); // 获取上个月的年月份日期
			holiday.setYearMonth(yearMonth.substring(0, 4));
		}
		if (StringUtil.isBlank(holiday.getType())) {
			String type = String.format("%s,%s,%s,%s",
					Holiday.TYPE_CHINESE_NEW_YEAR,
					Holiday.TYPE_FAMILY_REUNION_DINNER,
					Holiday.TYPE_HIGH_TEMPERATURE, Holiday.TYPE_NIGHT_SHIFT);
			holiday.setType(type);// 获取补贴配置
		}

		Page pageList = holidayService.findHolidayPage(page, holiday);

		model.addAttribute("pageList", pageList);
		model.addAttribute("holiday", holiday);// 页面查询条件

		return "masterdata/subsiby/subsibyList";
	}

	/**
	 * 跳转至添加地区维护页面
	 */
	@RequestMapping("/subsibyToAdd.do")
	public String subsibyToAdd() {
		return "masterdata/subsiby/subsibyAdd";
	}

	/**
	 * 添加或修改地区维护
	 */
	@RequestMapping("/subsibySaveOrUpdate.do")
	public String subsibySaveOrUpdate(Holiday holiday) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// holiday.setType("1");
		holidayService.saveOrUpdate(holiday);
		return "save_result";
	}

	/**
	 * 跳转至修改员工地区维护
	 */
	@RequestMapping("/subsibyToUpdate.do")
	public String subsibyToUpdate(String holidayId, Model model) {
		model.addAttribute("holiday",
				holidayService.getHoliday(new Long(holidayId)));
		return "masterdata/subsiby/subsibyEdit";
	}

	/**
	 * 删除地区维护
	 */
	@RequestMapping("/subsibyDelete.do")
	public void subsibyDelete(String holidayId, HttpServletResponse response)
			throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			holidayService.delete(new Long(holidayId));
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
