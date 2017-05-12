package com.fh.controller.masterdata;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.DutySalary;
import com.fh.service.masterdata.DutySalaryService;

import net.sf.json.JSONObject;

/**
 *	岗位工资维护 Controller
 */
@Controller(value="dutySalaryController")
@RequestMapping({"/dutySalary"})
public class DutySalaryController extends BaseController {
	
	@Autowired
	private DutySalaryService dutySalaryService;
	
	/**
	 * 岗位工资列表
	 */
	@RequestMapping("/dutySalaryList.do")
	public String dutySalaryList(Page page, DutySalary dutySalary, Model model) {
		Page pageList = dutySalaryService.findDutySalaryPage(page, dutySalary);
		
		model.addAttribute("pageList", pageList);
		model.addAttribute("dutySalary", dutySalary);// 页面查询条件
		
		return "masterdata/dutySalary/dutySalaryList";
	}
	
	/**
	 * 跳转至添加岗位工资页面
	 */
	@RequestMapping("/dutySalaryToAdd.do")
	public String dutySalaryToAdd() {
		return "masterdata/dutySalary/dutySalaryAdd";
	}
	
	/**
	 * 添加或修改岗位工资
	 */
	@RequestMapping("/dutySalarySaveOrUpdate.do")
	public String dutySalarySaveOrUpdate(DutySalary dutySalary) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		dutySalaryService.saveOrUpdate(dutySalary);
		return "save_result";
	}
	
	/**
	 * 跳转至修改岗位工资
	 */
	@RequestMapping("/dutySalaryToUpdate.do")
	public String dutySalaryToUpdate(String dutySalaryId, Model model) {
		model.addAttribute("dutySalary", dutySalaryService.getDutySalary(new Long(dutySalaryId)));
		return "masterdata/dutySalary/dutySalaryEdit";
	}
	
	/**
	 * 删除岗位工资
	 */
	@RequestMapping("/dutySalaryDelete.do")
	public void dutySalaryDelete(String dutySalaryId, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			dutySalaryService.delete(new Long(dutySalaryId));
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
