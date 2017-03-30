package com.fh.controller.station;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Station;
import com.fh.entity.system.OrganiseCO;
import com.fh.service.station.StationService;

import net.sf.json.JSONObject;

/**
 * 油站基本信息维护 Controller
 * @author lijn
 *
 */
@Controller(value="stationController")
@RequestMapping({"/station"})
public class StationController extends BaseController {
	@Autowired
	private StationService stationService;
	
	/**查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationList.do")
	public String list(Page page,Model model,String stationName,String stationStatus, String districtCode){
		if ("".equals(districtCode)) {
			districtCode = null;
		}
		
		Page pageList = stationService.findStationsByPage(page, stationName, stationStatus, districtCode);
		model.addAttribute("pageList", pageList);
		model.addAttribute("stationName", stationName);
		model.addAttribute("stationStatus", stationStatus);
		model.addAttribute("districtCode", districtCode);
		return "station/base/baseList";
	}
	/**去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationToAdd.do")
	public String toadd(Model model){
		return "station/base/baseAdd";
	}
	/**去修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationToEdit.do")
	public String toEdit(String id,Model model){
		//根据id查询记录
		Station station=stationService.queryStationById(id);
		if(station!=null)
		model.addAttribute("station", station);
		return "station/base/baseEdit";
	}
	/**添加或修改油站信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationSaveOrUpdate.do")
	public String saveOrUpdate(Station station,Model model) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		station.setStationStatus("1");// 油站状态：可用（默认）
		stationService.saveOrUpdate(station);
		return "save_result";
	}
	/**去详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationToView.do")
	public String toView(String id,Model model){
		//根据id查询记录
		Station station=stationService.queryStationById(id);
		if(station!=null)
		model.addAttribute("station", station);
		return "station/base/baseView";
	}
	/**根据id删除记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/stationDelById.do")
	public void delStationById(String id,HttpServletResponse response){
		// json对象
		JSONObject js = new JSONObject();
		try {
			stationService.deleteStationById(id);
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
	/**机构树
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/organiseZtree.do")
	public String organiseZtree(Model model){
		// json对象
		try {
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();
			OrganiseCO organiseCO = (OrganiseCO)session.getAttribute(SysConstant.OrganiseCO_);
			JSONObject jsonArray = JSONObject.fromObject(organiseCO);
			jsonArray.put("open", true);
			String json = jsonArray.toString();
			json = json.replaceAll("organiseName", "name");
			json = json.replaceAll("organiseId", "id");
			json = json.replaceAll("pOrganiseId", "pid");
			json = json.replaceAll("subOrganiseCO", "children");
			model.addAttribute("zTreeNodes", json);
			return "system/organise/organise_ztree";
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
