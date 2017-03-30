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

import net.sf.json.JSONObject;

/**
 *	过节费维护 Controller
 */
@Controller(value="holidayController")
@RequestMapping({"/holiday"})
public class HolidayController extends BaseController {
	
	@Autowired
	private HolidayService holidayService;
	
	/**
	 * 地区维护列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/holidayList.do")
	public String holidayList(Page page, Holiday holiday, Model model) {
		if ("".equals(holiday.getYearMonth()) || null == holiday.getYearMonth()) {
			AutoYearMonth autoYearMonth = new AutoYearMonth();
			String yearMonth = autoYearMonth.getAutoYearMonth(); //获取上个月的年月份日期
			holiday.setYearMonth(yearMonth.substring(0,4));
		}
		
		holiday.setType("0");
		Page pageList = holidayService.findHolidayPage(page, holiday);
		
		model.addAttribute("pageList", pageList);
		model.addAttribute("holiday", holiday);// 页面查询条件
		
		return "masterdata/holiday/holidayList";
	}
	
	/**
	 * 跳转至添加地区维护页面
	 */
	@RequestMapping("/holidayToAdd.do")
	public String holidayToAdd() {
		return "masterdata/holiday/holidayAdd";
	}
	
	/**
	 * 添加或修改地区维护
	 */
	@RequestMapping("/holidaySaveOrUpdate.do")
	public String holidaySaveOrUpdate(Holiday holiday) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		holiday.setType("0");
		holidayService.saveOrUpdate(holiday);
		return "save_result";
	}
	
	/**
	 * 跳转至修改员工地区维护
	 */
	@RequestMapping("/holidayToUpdate.do")
	public String holidayToUpdate(String holidayId, Model model) {
		model.addAttribute("holiday", holidayService.getHoliday(new Long(holidayId)));
		return "masterdata/holiday/holidayEdit";
	}
	
	/**
	 * 删除地区维护
	 */
	@RequestMapping("/holidayDelete.do")
	public void holidayDelete(String holidayId, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
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
