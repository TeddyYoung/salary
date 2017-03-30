package com.fh.controller.system;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.system.StoreEmployeeService;
import com.fh.service.system.UserService;
import com.fh.util.Encrypt;

/**
 * 用户管理Controller
 * @author zhang_yu
 *
 */
@Controller(value="userController")
@RequestMapping({"/user"})
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	
	@RequestMapping("userList.do")
	public String userList(Page page, String username, Model model) {

		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		StoreEmployee currentStoreEmployee = (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
		Page pageList = userService.findUsersByPage(page, username,currentStoreEmployee.getSubOrganiseIdStr());
		model.addAttribute("pageList", pageList);
		
		StoreEmployee storeEmployee = new StoreEmployee();
		storeEmployee.setUsername(username);
		model.addAttribute("storeEmployee", storeEmployee);
		String depPartCode = currentStoreEmployee.getDepPartCode();
		String[] split = depPartCode.split(",");
		int flag=0;
		for (String string : split) {
			if(string.equals("R_000")){
				flag=1;
				break;
			}
		}
		model.addAttribute("flag", flag);
		return "system/user/userList";
		
	}
	
	@RequestMapping("userEditPWD.do")
	public String userEditPWD(String id, Model model,String userid) {
		
		try {
			userService.updateUserById(id,userid);
		} catch (Exception e) {
			throw new IllegalArgumentException("查询出错");
		}
		return "redirect:/user/userList.do";
		
	}
	
	@RequestMapping("batchEditPWD.do")
	public String batchEditPWD() {
		try {
			userService.updateUserPWD();
		} catch (Exception e) {
			throw new IllegalArgumentException("出错了");
		}
		return "redirect:/user/userList.do";
		
	}
	
	@RequestMapping("/toEditPwd.do")
	public String toEditPwd() {
		return "system/user/editPassword";
	}
	
	@RequestMapping("editPassword.do")
	public String editPassword(StoreEmployee storeEmployee)  throws Exception {
		if (storeEmployee.getUserpwd() == null || "".equals(storeEmployee.getUserpwd())) {
			throw new Exception("请输入原密码");
		} else if (storeEmployee.getNewPassword() == null || "".equals(storeEmployee.getNewPassword())) {
			throw new Exception("请输入新密码");
		} else if (storeEmployee.getCheckPassword() == null || "".equals(storeEmployee.getCheckPassword())) {
			throw new Exception("请输入确认新密码");
		} else if (!storeEmployee.getCheckPassword().equals(storeEmployee.getNewPassword())) {
			throw new Exception("两次新密码不一致");
		}
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		StoreEmployee currentStoreEmployee = (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
		storeEmployee.setUserid(currentStoreEmployee.getUserid());
		this.storeEmployeeService.editPassword(storeEmployee);
		
		return "save_result";
	}
	
}
