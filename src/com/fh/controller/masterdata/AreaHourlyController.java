package com.fh.controller.masterdata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.AreaHourly;
import com.fh.entity.biz.Duty;
import com.fh.service.masterdata.AreaHourlyService;
import com.fh.service.masterdata.DutyService;

import net.sf.json.JSONObject;

/**
 * 时薪设置维护
 * @author lijn
 *
 */
@Controller(value="areaHourlyController")
@RequestMapping({"/areaHourly"})
public class AreaHourlyController extends BaseController {
	
	@Autowired
	private AreaHourlyService areaHourlyService;
	@Autowired
	private DutyService dutyService;
	
	/**
	 * 时薪设置列表查询(支持分页, 支持模糊查询)
	 */
	@RequestMapping("/areaHourlyList.do")
	public String list(Page page, AreaHourly areaHourly, Model model) {
		
		Page pageList = areaHourlyService.findAreaHourlysByPage(page, areaHourly.getAreaCode(), areaHourly.getDutyCode());
		model.addAttribute("pageList", pageList);
		
		AreaHourly ah = new AreaHourly();
		ah.setAreaCode(areaHourly.getAreaCode());
		ah.setDutyCode(areaHourly.getDutyCode());
		model.addAttribute("ah", ah);
		
		return "masterdata/areaHourly/areaHourlyList";
	
	}
	
	/**
	 * 跳转至添加时薪设置页面
	 */
	@RequestMapping("/areaHourlyToAdd.do")
	public String areaHourlyToAdd(Model model) {
		//查询已进行时薪设置的职务
		List<AreaHourly> areaHourlyDutyList = areaHourlyService.queryAreaHourlyDuty();
		List<Object> arrayList = new ArrayList<>();
		if(areaHourlyDutyList!=null && areaHourlyDutyList.size()>0){
			for (AreaHourly areaHourlyDuty : areaHourlyDutyList) { 
				arrayList.add(areaHourlyDuty.getDutyCode());
			}
		}
		Set<Duty> dutyList = new HashSet<Duty>();
		List<Duty> dutys = dutyService.queryAll();
		for (Duty duty : dutys) {
			if(!arrayList.contains(duty.getDutyCode())){
				dutyList.add(duty);
			}
		}
		model.addAttribute("dutyList",dutyList );
		return "masterdata/areaHourly/areaHourlyAdd";
		
	}
	
	/**
	 * 添加或修改时薪设置
	 */
	@RequestMapping("/areaHourlySaveOrUpdate.do")
	public String areaHourlySaveOrUpdate(AreaHourly areaHourly,String[] ids,
			String[] areaCodes,String[] normalHourlys,String[] otHourlys) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		areaHourlyService.saveOrUpdate(areaHourly ,ids , areaCodes , normalHourlys , otHourlys);
		return "save_result";
		
	}
	
	/**
	 * 跳转至查看员工时薪设置
	 */
	@RequestMapping("/areaHourlyToView.do")
	public String areaHourlyToView(String id, Model model) {
		
		model.addAttribute("areaHourly", areaHourlyService.findAreaHourlyBydutyCode(id));
		return "masterdata/areaHourly/areaHourlyView";
		
	}
	/**
	 * 跳转至修改员工时薪设置
	 */
	@RequestMapping("/areaHourlyToEdit.do")
	public String areaHourlyToEdit(String dutyCode, Model model) {
		
		model.addAttribute("areaHourlyList", areaHourlyService.findAreaHourlyBydutyCode(dutyCode));
		return "masterdata/areaHourly/areaHourlyEdit";
		
	}
	
	/**
	 * 删除时薪设置(支持批量删除)
	 */
	@RequestMapping("/areaHourlyDelById.do")
	public void delete(String dutyCode, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			areaHourlyService.delete(dutyCode);
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
