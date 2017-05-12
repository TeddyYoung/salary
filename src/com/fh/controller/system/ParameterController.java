package com.fh.controller.system;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.entity.system.Parameter;
import com.fh.service.system.ParameterService;

/**
 * 参数管理Controller
 * @author zhang_yu
 *
 */
@Controller(value="parameterController")
@RequestMapping({"/parameter"})
public class ParameterController {

	@Autowired
	private ParameterService parameterService;
	
	/**
	 * 参数管理列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/parameterList.do")
	public String parameterList(Page page, Parameter parameter, Model model) {
		
		Page pageList = parameterService.findParametersByPage(page, parameter.getParameterValue(), parameter.getParameterType());
		model.addAttribute("pageList", pageList);
		
		Parameter para = new Parameter();
		para.setParameterValue(parameter.getParameterValue());
		para.setParameterType(parameter.getParameterType());
		model.addAttribute("para", para);
		return "system/parameter/parameterList";
	
	}
	
	/**
	 * 跳转至添加参数管理页面
	 */
	@RequestMapping("/parameterToAdd.do")
	public String parameterToAdd() {
		
		return "system/parameter/parameterAdd";
		
	}
	
	/**
	 * 添加或修改地区系数
	 */
	@RequestMapping("/parameterSaveOrUpdate.do")
	public String parameterAdd(Parameter parameter) {
		parameterService.saveOrUpdate(parameter);
		parameterService.init();
		return "save_result";
		
	}
	
	/**
	 * 跳转至修改员工地区系数
	 */
	@RequestMapping("/parameterToUpdate.do")
	public String parameterToUpdate(String parameterId, Model model) {
		
		model.addAttribute("parameter", parameterService.findAreaById(parameterId));
		return "system/parameter/parameterEdit";
		
	}
	
	/**
	 * 删除地区系数
	 */
	@RequestMapping("/parameterDelete.do")
	public void delete(String parameterId, HttpServletResponse response) {
		
		// json对象
		JSONObject js = new JSONObject();
		try {
			parameterService.delete(parameterId);
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
