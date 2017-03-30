package com.fh.controller.station;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.Staff;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.station.StaffService;
import com.fh.service.system.DataDictionaryService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.util.StringUtil;

/**
 * 
 */
@Controller(value="staffLevelController")
@RequestMapping({"/staffLevel"})
public class StaffLevelController extends BaseController {
	
	@Autowired
	private StaffService staffService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private StoreEmployeeService storeEmployeeService;

	/**
	 * 查询列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffList.do")    
	public String list(HttpServletRequest request, String staffName,String staffStatus, Page page, Model model, String dutyCode) {
		if (staffStatus == null || "".equals(staffStatus)) {
			staffStatus = "1";
		}
		if ("all".equals(staffStatus)) {
			staffStatus = null;
		}
		if(StringUtil.isBlank(dutyCode)){
			dutyCode = "'ZW_0012','ZW_0011','ZW_0010','ZW_0008','ZW_0004','ZW_0003'";
		}
		StoreEmployee user = (StoreEmployee)request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		Page pageList = staffService.findStaffsByPage(page, staffName, staffStatus, user.getSubOrganiseIdStr(), dutyCode);
		model.addAttribute("pageList", pageList);
		model.addAttribute("staffName", staffName);
		model.addAttribute("staffStatus", staffStatus);
		model.addAttribute("dutyCode", dutyCode);
		return "station/stafflevel/staffList";
	}

	
	/**
	 * 去修改页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffToEdit.do")
	public String toEdit(String id, Model model) {
		Staff staff = staffService.queryStaffById(id);
		if (staff != null && !"".equals(staff))
			model.addAttribute("staff", staff);
		return "station/stafflevel/staffLevelEdit";
	}

	/**
	 * 添加或修改员工信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffSaveOrUpdate.do")
	public String saveOrUpdate(HttpServletRequest request,String type,
			Staff staff, Model model,String flag,MultipartFile uploadPic) throws Exception {
		if (!this.checkData()) {
			throw new Exception("已经超过了数据可维护日期，数据不可维护！如需修改数据，请联系管理员。");
		}
		if (staff.getId() == null || "".equals(staff.getId())) {// 新增操作
			Staff staffTemp = this.staffService.getStaffByCondition(staff);
			if (staffTemp !=  null && staffTemp.getId() != null && !"".equals(staffTemp.getId())) {
				model.addAttribute("staff", staff);
				model.addAttribute("message", "该员工已经存在，请勿重复添加");
				return "station/staff/staffAdd";
			}
		}
		
		boolean result = staffService.saveOrUpdate(request,type,uploadPic,staff,flag);
		if(result){
			return "save_result";
		}else{
			model.addAttribute("staff", staff);
			model.addAttribute("message", "员工照片必须为.png或.jpg格式！");
			return "station/staff/staffAdd";
		}
		
	}

	/**
	 * 去详情页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staffToView.do")
	public String toView(String id, Model model) {
		// 根据id查询记录
		Staff staff = staffService.queryStaffById(id);
		if (staff != null)
			model.addAttribute("staff", staff);
		return "station/staff/staffView";
	}
	
	
	
}
