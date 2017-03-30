package com.fh.controller.masterdata;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Duty;
import com.fh.service.masterdata.DutyService;

import net.sf.json.JSONObject;

/**
 * 员工职务信息维护 Controller
 * @author zhang_yu
 *
 */
@Controller(value="dutyController")
@RequestMapping({"/duty"})
public class DutyController extends BaseController {
	
	@Autowired
	private DutyService dutyService;
	
	/**
	 * 员工职务列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/dutyList.do")
	public String list(Page page, String dutyName, Model model) {
		
		Page pageList = dutyService.findDutysByPage(page, dutyName);
		model.addAttribute("pageList", pageList);
		
		Duty duty = new Duty();
		duty.setDutyName(dutyName);
		model.addAttribute("duty", duty);
		
		return "masterdata/duty/dutyList";
	
	}
	
	/**
	 * 跳转至添加员工职务页面
	 */
	@RequestMapping("/dutyToAdd.do")
	public String dutyToAdd() {
		
		return "masterdata/duty/dutyAdd";
		
	}
	
	/**
	 * 添加或修改员工职务
	 */
	@RequestMapping("/dutySaveOrUpdate.do")
	public String dutyAdd(Duty duty) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		dutyService.saveOrUpdate(duty);
		return "save_result";
		
	}
	
	/**
	 * 跳转至修改员工职务页面
	 */
	@RequestMapping("/dutyToUpdate.do")
	public String duty_toUpdate(String dutyId, Model model) {
		
		model.addAttribute("duty", dutyService.findDutyById(dutyId));
		return "masterdata/duty/dutyEdit";
		
	}
	
	/**
	 * 删除员工职务
	 */
	@RequestMapping("/dutyDelete.do")
	public void delete(String dutyId, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			dutyService.delete(dutyId);
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
