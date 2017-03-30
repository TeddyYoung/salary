package com.fh.controller.masterdata;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.PartStation;
import com.fh.entity.biz.Staff;
import com.fh.service.masterdata.PartStationService;
import com.fh.service.station.StaffService;

import net.sf.json.JSONObject;

/**
 *	兼站人员维护 Controller
 */
@Controller(value="partStationController")
@RequestMapping({"/partStation"})
public class PartStationController extends BaseController {
	
	@Autowired
	private PartStationService partStationService;
	@Autowired
	private StaffService staffService;
	
	/**
	 * 兼站人员列表
	 */
	@RequestMapping("/partStationList.do")
	public String partStationList(Page page, PartStation partStation, Model model) {
		Page pageList = partStationService.findPartStationPage(page, partStation);
		
		model.addAttribute("pageList", pageList);
		model.addAttribute("partStation", partStation);// 页面查询条件
		
		return "masterdata/partStation/partStationList";
	}
	
	/**
	 * 跳转至添加兼站人员页面
	 */
	@RequestMapping("/partStationToAdd.do")
	public String partStationToAdd() {
		return "masterdata/partStation/partStationAdd";
	}
	
	/**
	 * 添加或修改兼站人员
	 */
	@RequestMapping("/partStationSaveOrUpdate.do")
	public String partStationSaveOrUpdate(PartStation partStation) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		partStationService.saveOrUpdate(partStation);
		return "save_result";
	}
	
	/**
	 * 跳转至修改兼站人员
	 */
	@RequestMapping("/partStationToUpdate.do")
	public String partStationToUpdate(String partStationId, Model model) {
		model.addAttribute("partStation", partStationService.getPartStation(new Long(partStationId)));
		return "masterdata/partStation/partStationEdit";
	}
	
	/**
	 * 删除兼站人员
	 */
	@RequestMapping("/partStationDelete.do")
	public void partStationDelete(String partStationId, HttpServletResponse response) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		// json对象
		JSONObject js = new JSONObject();
		try {
			partStationService.delete(new Long(partStationId));
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
	
	/**
	 * 获取员工信息 - ajax
	 */
	@RequestMapping("/getStaff.do")
	public void getStaff(String staffCode, HttpServletResponse response) {
		
		// json对象
		JSONObject json = new JSONObject();
		try {
			Staff staff = this.staffService.queryStaffByStaffCode(staffCode,null);//TODO
			if (staff == null) {
				staff = new Staff();
			}
			json.put("staff", staff);
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		
	}
	
}
