package com.fh.controller.masterdata;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.StandardBonusSetup;
import com.fh.service.masterdata.StandardBonusSetupService;

import net.sf.json.JSONObject;
/**
 * 经理奖金设置基本信息维护 Controller
 * @author lijn
 *
 */
@Controller(value="standardBonusSetupController")
@RequestMapping({"/standardBonusSetup"})
public class StandardBonusSetupController extends BaseController {
	
	@Autowired
	private StandardBonusSetupService standardBonusSetupService;
	
	/**
	 * 查询经理奖金设置列表
	 */
	@RequestMapping("/standardBonusSetupList.do")
	public String list(Page page, Model model) {
		
		List<StandardBonusSetup> standardBonusSetupList = standardBonusSetupService.queryAll();
		model.addAttribute("standardBonusSetupList", standardBonusSetupList);
		return "masterdata/standardBonusSetup/standardBonusSetupList";
	
	}
	/**去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/standardBonusSetupToAdd.do")
	public String toadd(Model model){
		return "masterdata/standardBonusSetup/standardBonusSetupAdd";
	}
	/**去修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/standardBonusSetupToEdit.do")
	public String toEdit(String id,Model model){
		//根据id查询记录
		StandardBonusSetup standardBonusSetup=standardBonusSetupService.findStandardBonusSetupById(id);
		if(standardBonusSetup!=null)
		model.addAttribute("standardBonusSetup", standardBonusSetup);
		return "masterdata/standardBonusSetup/standardBonusSetupEdit";
	}
	/**添加或修改经理奖金设置信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/standardBonusSetupSaveOrUpdate.do")
	public String saveOrUpdate(StandardBonusSetup standardBonusSetup,Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		standardBonusSetupService.saveOrUpdate(standardBonusSetup);
		return "save_result";
	}
	/**去详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/standardBonusSetupToView.do")
	public String toView(String id,Model model){
		//根据id查询记录
		StandardBonusSetup standardBonusSetup=standardBonusSetupService.findStandardBonusSetupById(id);
		if(standardBonusSetup!=null)
		model.addAttribute("standardBonusSetup", standardBonusSetup);
		return "masterdata/standardBonusSetup/standardBonusSetupView";
	}
	/**根据id删除记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/standardBonusSetupDelById.do")
	public void delStandardBonusSetupById(String id,HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			standardBonusSetupService.delete(id);
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
