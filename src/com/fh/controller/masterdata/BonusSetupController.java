package com.fh.controller.masterdata;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.BonusSetup;
import com.fh.service.masterdata.BonusSetupService;

import net.sf.json.JSONObject;

/**
 * 奖金设置基本信息维护 Controller
 * @author lijn
 *
 */
@Controller(value="bonusSetupController")
@RequestMapping({"/bonusSetup"})
public class BonusSetupController extends BaseController {
	
	@Autowired
	private BonusSetupService bonusSetupService;
	
	/**
	 * 查询奖金设置列表
	 */
	@RequestMapping("/bonusSetupList.do")
	public String list(Page page, Model model) {
		
		List<BonusSetup> bonusSetupList = bonusSetupService.queryAll();
		model.addAttribute("bonusSetupList", bonusSetupList);
		return "masterdata/bonusSetup/bonusSetupList";
	
	}
	
	/**
	 * 去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bonusSetupToAdd.do")
	public String toadd(Model model){
		return "masterdata/bonusSetup/bonusSetupAdd";
	}
	
	/**
	 * 去修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bonusSetupToEdit.do")
	public String toEdit(String id,Model model){
		//根据id查询记录
		BonusSetup bonusSetup=bonusSetupService.findBonusSetupById(id);
		if(bonusSetup!=null)
		model.addAttribute("bonusSetup", bonusSetup);
		return "masterdata/bonusSetup/bonusSetupEdit";
	}
	
	/**
	 * 添加或修改奖金设置信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bonusSetupSaveOrUpdate.do")
	public String saveOrUpdate(BonusSetup bonusSetup,Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		bonusSetupService.saveOrUpdate(bonusSetup);
		return "save_result";
	}
	/**去详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bonusSetupToView.do")
	public String toView(String id,Model model){
		//根据id查询记录
		BonusSetup bonusSetup=bonusSetupService.findBonusSetupById(id);
		if(bonusSetup!=null)
		model.addAttribute("bonusSetup", bonusSetup);
		return "masterdata/bonusSetup/bonusSetupView";
	}
	/**根据id删除记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/bonusSetupDelById.do")
	public void delBonusSetupById(String id,HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			bonusSetupService.delete(id);
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
