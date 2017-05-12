package com.fh.controller.operation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.StationLevel;
import com.fh.service.operation.StationLevelService;

import net.sf.json.JSONObject;

/**
 * 油站星级维护 Controller
 * @author lijn
 *
 */
@Controller(value="stationLevelController")
@RequestMapping({"/stationLevel"})
public class StationLevelController extends BaseController {
	
	@Autowired
	private StationLevelService stationLevelService;
	
	/**查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationlevelList.do")
	public String list(Page page,Model model,String stationLevelName){
		
		Page pageList = stationLevelService.findStationLevelsByPage(page, stationLevelName);
		model.addAttribute("pageList", pageList);
		model.addAttribute("stationLevelName", stationLevelName);
		
		return "operation/stationlevel/stationlevelList";
	}
	/**去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationlevelToAdd.do")
	public String toadd(Model model){
		return "operation/stationlevel/stationlevelAdd";
	}
	/**去修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationlevelToEdit.do")
	public String toEdit(String id,Model model){
		StationLevel stationLevel = stationLevelService.queryStationLevelById(id);
		if(stationLevel!=null && !"".equals(stationLevel))
		model.addAttribute("stationLevel", stationLevel);
		return "operation/stationlevel/stationlevelEdit";
	}
	/**添加或修改油站信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationlevelSaveOrUpdate.do")
	public String saveOrUpdate(StationLevel stationlevel,Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
		stationLevelService.saveOrUpdate(stationlevel);
		return "save_result";
	}
	
	/**
	 * 去详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationlevelToView.do")
	public String toView(String id,Model model){
		//根据id查询记录
		StationLevel stationLevel=stationLevelService.queryStationLevelById(id);
		if(stationLevel!=null)
		model.addAttribute("stationLevel", stationLevel);
		return "operation/stationlevel/stationlevelView";
	}
	
	/**
	 * 根据id删除记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationlevelDelById.do")
	public void delstationlevelById(String id,HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("数据维护日期已截止,无法操作!");
		}
			// json对象
			JSONObject js = new JSONObject();
			try {
				stationLevelService.deleteStationLevelById(id);
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
