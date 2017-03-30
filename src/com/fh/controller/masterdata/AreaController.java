package com.fh.controller.masterdata;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Area;
import com.fh.service.masterdata.AreaService;

import net.sf.json.JSONObject;

/**
 *	地区维护 Controller
 */
@Controller(value="areaController")
@RequestMapping({"/area"})
public class AreaController extends BaseController {
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * 地区维护列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/areaList.do")
	public String areaList(Page page, Area area, Model model) {
		
		Page pageList = areaService.findAreasByPage(page, area.getAreaName(), area.getAreaLevel());
		model.addAttribute("pageList", pageList);
		
		Area are = new Area();
		are.setAreaName(area.getAreaName());
		are.setAreaLevel(area.getAreaLevel());
		model.addAttribute("are", are);
		
		return "masterdata/area/areaList";
	
	}
	
	/**
	 * 跳转至添加地区维护页面
	 */
	@RequestMapping("/areaToAdd.do")
	public String areaToAdd() {
		
		return "masterdata/area/areaAdd";
		
	}
	
	/**
	 * 添加或修改地区维护
	 */
	@RequestMapping("/areaSaveOrUpdate.do")
	public String areaAdd(Area area) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		areaService.saveOrUpdate(area);
		return "save_result";
		
	}
	
	/**
	 * 跳转至修改员工地区维护
	 */
	@RequestMapping("/areaToUpdate.do")
	public String areaToUpdate(String areaId, Model model) {
		
		model.addAttribute("area", areaService.findAreaById(areaId));
		return "masterdata/area/areaEdit";
		
	}
	
	/**
	 * 删除地区维护
	 */
	@RequestMapping("/areaDelete.do")
	public void delete(String areaId, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			areaService.delete(areaId);
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
