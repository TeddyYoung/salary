package com.fh.controller.masterdata;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.District;
import com.fh.service.masterdata.DistrictService;

import net.sf.json.JSONObject;
/**
 * 区域基本信息维护 Controller
 * @author lijn
 *
 */
@Controller(value="districtController")
@RequestMapping({"/district"})
public class DistrictController extends BaseController {
	
	@Autowired
	private DistrictService districtService;
	
	/**
	 * 查询区域列表
	 */
	@RequestMapping("/districtList.do")
	public String list(Page page, String districtName,String districtLevel, Model model) {
		
		Page pageList = districtService.findDistrictsByPage(page, districtName, districtLevel);
		model.addAttribute("pageList", pageList);
		model.addAttribute("districtName", districtName);
		model.addAttribute("districtLevel", districtLevel);
		return "masterdata/district/districtList";
	
	}
	/**去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/districtToAdd.do")
	public String toadd(Model model){
		return "masterdata/district/districtAdd";
	}
	/**去修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/districtToEdit.do")
	public String toEdit(String id,Model model){
		//根据id查询记录
		District district=districtService.findDistrictById(id);
		if(district!=null)
		model.addAttribute("district", district);
		return "masterdata/district/districtEdit";
	}
	/**添加或修改区域信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/districtSaveOrUpdate.do")
	public String saveOrUpdate(District district,Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		districtService.saveOrUpdate(district);
		return "save_result";
	}
	/**去详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/districtToView.do")
	public String toView(String id,Model model){
		//根据id查询记录
		District district=districtService.findDistrictById(id);
		if(district!=null)
		model.addAttribute("district", district);
		return "masterdata/district/districtView";
	}
	/**根据id删除记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/districtDelById.do")
	public void delDistrictById(String id,HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			districtService.delete(id);
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
