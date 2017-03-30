package com.fh.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.SysConstant;
import com.fh.entity.biz.District;
import com.fh.entity.system.DepPart;
import com.fh.entity.system.Flag;
import com.fh.entity.system.Menu;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.Parameter;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.StoreEmployeeVO;
import com.fh.service.masterdata.DistrictService;
import com.fh.service.system.DepPartService;
import com.fh.service.system.MenuService;
import com.fh.service.system.OrganiseCOService;
import com.fh.service.system.ParameterService;
import com.fh.service.system.StoreEmployeeService;
import com.fh.util.UtilFuns;

import net.sf.json.JSONObject;

/**
 * 系统登录
 *
 */
@Controller(value="loginController")
public class LoginController {
	
	@Autowired
	private StoreEmployeeService storeEmployeeService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private ParameterService parameterService;
	@Autowired
	private OrganiseCOService organiseCOService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private DepPartService depPartService;

	//去系统登录页面------------------------------------------------------------------------------------------------
	@RequestMapping(value="/login_toLogin.do")
	public String toLogin() {
		
		return "system/admin/login";
		
	}
	
	//用户登录----------------------------------------------------------------------------------------------------
	//利用Shiro框架登录----->就得需要Shiro中的一个Subject对象----->SecurityUtils.getSubject()得到Subject对象
	@RequestMapping(value="/login_login.do")
	public String login(String loginname, String password, 
						HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		
		if (UtilFuns.isEmpty(loginname)) { //判断用户名是否为空，如果用户名为空，滚回去登录界面重新登录
			return "system/admin/login";
		}
		if (UtilFuns.isEmpty(password)) { //判断密码是否为空，如果密码为空，滚回去登录界面重新登录
			return "system/admin/login";
		}
		
		try{
			
			Subject subject = SecurityUtils.getSubject(); //得到Shiro中的Subject对象
			
			//调用login方法,实现登录功能. Shiro框架会自动调用 AuthRealm.doGetAuthenticationInfo()方法来实现登录的判断
			UsernamePasswordToken upToken = new UsernamePasswordToken(loginname, password);
			subject.login(upToken);
			
			//从Realm中获取用户信息------------------------>此句代码执行完立即进入 AuthRealm.doGetAuthenticationInfo()方法
			//Realm域支持单点登录
			StoreEmployee storeEmployee = (StoreEmployee) subject.getPrincipal();
			
			// 获取用户所属的机构列表
			List<OrganiseCO> userOrganiseCOList = this.findUserOrganiseCOList(storeEmployee);
			// 获取用户默认所属机构对应的角色列表
			List<DepPart> userRoleList = new ArrayList<DepPart>();
			if (userOrganiseCOList != null && userOrganiseCOList.size() > 0) {
				OrganiseCO organiseCO = userOrganiseCOList.get(0);
				userRoleList = this.findUserDepPartList(storeEmployee, organiseCO);
			}
			
			if ((userOrganiseCOList != null && userOrganiseCOList.size() > 1)
					|| userRoleList != null && userRoleList.size() > 1) {// 部门列表或者角色列表不为空，则跳转到角色选择页面
				session.setAttribute("userOrganiseCOList", userOrganiseCOList);
				session.setAttribute("userRoleList", userRoleList);
				session.setAttribute("userId", storeEmployee.getUserid());
				return "system/admin/chooseRole";
			} else {// 跳转到首页
				String districtCode = storeEmployee.getDistrictCode();
				if(districtCode!=null && !"".equals(districtCode)){
					District district = districtService.findDistrictById(districtCode);
					storeEmployee.setDistrict(district);
				}
				StringBuffer organiseId = new StringBuffer();
				StringBuffer depPartCode=new StringBuffer();
				if(storeEmployee!=null&&!"".equals(storeEmployee)){
					organiseId.append(storeEmployee.getOrganiseCO().getOrganiseId());
					List<DepPart> depParts = storeEmployee.getDepParts();
					if(depParts!=null&&depParts.size()>0){
						for (DepPart depPart : depParts) {
							//String storePart = depPart.getStorePart();
							depPartCode.append(depPart.getStorePart());
							List<Menu> menuList = depPart.getMenuList();
							if(menuList!=null && menuList.size()>0){
								for (Menu menu : menuList) {
									List<Menu> subMenu = menuService.querySubMenuByStorePart(menu.getId(),depPart.getStorePart());
									if(subMenu!=null && subMenu.size()>0){
										menu.setSubMenu(subMenu);
									}
								}
							}
							//将用户所拥有的权限菜单全部存在session中
							request.getSession().setAttribute(SysConstant.CURRENT_USER_MENU, menuList);
							organiseId.append(",");
							depPartCode.append(",");
							model.addAttribute("menuList", menuList);
						}
					}
					
				}
				
				List<StoreEmployeeVO> storeEmployeeVOList = storeEmployeeService.queryStoreEmployeeVOBypStorePart(null, null);
				session.setAttribute(SysConstant.USERS_INFO, storeEmployeeVOList);
				//加载所有当前用户所拥有的角色和角色所关联的权限
				//将这些加载的数据放入Shiro的二级缓存中
				//获取用户所有的角色
				/*List<Menu> menuList = new ArrayList<Menu>();
				List<DepPart> depParts = depPartSevice.queryDeptPartByUserId(storeEmployee.getUserid());
				//将角色添加到用户
				storeEmployee.setDepParts(depParts);	
				int i=0;
				for (DepPart depPart : depParts) { //遍历每一个角色, 加载出每个角色对应的每个菜单
						if(i!=0){
							organiseId.append(",");
							depPartCode.append(",");
						}
						organiseId.append(depPart.getOrganiseId());
						depPartCode.append(depPart.getStorePart());
						String storePart = depPart.getStorePart();
						List<Menu> menus = menuService.queryMenuByStorePart(storePart);
						//将用户所拥有的权限菜单全部存在session中
						request.getSession().setAttribute(SysConstant.CURRENT_USER_MENU, menus);
						for (Menu menu : menus) {
							if("0".equals(menu.getPid()) && !menuList.contains(menu)){
								List<Menu> subMenuList = new ArrayList<Menu>();
								for(Menu subMenu : menus){
									if(menu.getId().equals(subMenu.getPid())){
										subMenuList.add(subMenu);
									}
								}
								menu.setSubMenu(subMenuList);
								menuList.add(menu);
							}
						}
						i++;
					}*/
				//将当前登录的用户信息放入session中
				//一定要在代理类的方法执行前先将用户信息放入session中, 否则代理类在session中获取的用户信息为空
				
				String organiseStr=organiseId.toString().substring(0,organiseId.toString().lastIndexOf(","));
				
				storeEmployee.setDepPartCode(depPartCode.toString().substring(0,depPartCode.toString().lastIndexOf(",")));
				storeEmployee.setOrganiseId(organiseStr);
				
				OrganiseCO organise = organiseCOService.findOrganiseCOByorganiseId(organiseStr);
				
				//查寻机构所有下属部门
				List<OrganiseCO> organiseCOList = organiseCOService.findListOrganiseCOByPOrganiseId(organiseStr);
			
				StringBuilder sb = new StringBuilder();
				sb.append("\'").append(organiseStr).append("\'").append(",");
				
				if(organiseCOList!=null && organiseCOList.size()>0){
					for (OrganiseCO organiseCO : organiseCOList) {
						sb.append("\'").append(organiseCO.getOrganiseId()).append("\'").append(",");
						if(organiseCO.getSubOrganiseCO()!=null && organiseCO.getSubOrganiseCO().size()>0){
							String subOrganiseCOListStr = getSubOrganiseCOList(organiseCO.getSubOrganiseCO());
							sb.append(subOrganiseCOListStr);
						}else{
							continue;
						}
					}
					organise.setSubOrganiseCO(organiseCOList);
				}
				storeEmployee.setSubOrganiseIdStr(sb.toString().substring(0, sb.toString().lastIndexOf(",")));
				
				session.setAttribute(SysConstant.CURRENT_USER_INFO, storeEmployee);
				
				session.setAttribute(SysConstant.OrganiseCO_, organise);
				
				List<Parameter> parameterList = parameterService.queryParameterByKeyAndType("systemName","1");
				if(parameterList!=null){
					model.addAttribute("parameter", parameterList.get(0));
				}else{
					model.addAttribute("parameter", null);
				}
			
				return "system/admin/index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Flag flag = new Flag();
			flag.setFlag("对不起, 您输入的用户名或密码错误");
			model.addAttribute("Flag", flag);
			return "system/admin/login";
		}
		
	}
	
	/**
	 * 进入tab标签
	 * 
	 * @return
	 */
	@RequestMapping(value = "tab.do")
	public String tab() {
		return "system/admin/tab";
	}

	/**
	 * 进入首页后的默认页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "login_default.do")
	public String defaultPage() {
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		StoreEmployee storeEmployee = (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
		// 通过客户编号找到客户所属公司
		if (null != storeEmployee) {
			return "redirect:/activiti/activitiTask.do";
		} else {
			return "system/admin/default";
		}
		
	}
	
	//用户注销---------------------------------------------------------------------------------------------------
	@RequestMapping("/logout_logout.do")
	public String logout(HttpServletRequest request) {
		
		request.removeAttribute(SysConstant.CURRENT_USER_INFO);
		return "redirect:/login_toLogin.do";
		
	}
	
	/**
	 * 获取机构下级  机构编号   ，  拼接
	 * @param subOrganiseCO
	 * @return
	 */
	public String getSubOrganiseCOList(List<OrganiseCO> subOrganiseCO){
		StringBuilder sb = new StringBuilder();
		for (OrganiseCO organiseCO : subOrganiseCO) {
			sb.append("\'").append(organiseCO.getOrganiseId()).append("\'").append(",");
			if(organiseCO.getSubOrganiseCO()!=null && organiseCO.getSubOrganiseCO().size()>0){
				String subOrganiseCOListStr = getSubOrganiseCOList(organiseCO.getSubOrganiseCO());
				sb.append(subOrganiseCOListStr);
			}else{
				continue;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 提交角色进行登录
	 * @return
	 */
	@RequestMapping(value = "submitRole.do")
	public String submitRole(String organiseId, String depPartId, String userId,
			HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		StoreEmployee storeEmployee = this.storeEmployeeService.queryStoreEmployeeByUserId(userId);
		DepPart depPart = this.depPartService.queryDeptPartByRoleId(depPartId);
		
		// 1、获取用户所选则的机构和角色对应的权限内容并放到缓存中
		String districtCode = storeEmployee.getDistrictCode();
		if(districtCode != null && !"".equals(districtCode)) {
			District district = districtService.findDistrictById(districtCode);
			storeEmployee.setDistrict(district);
		}
		StringBuffer organiseIdStr = new StringBuffer();
		StringBuffer depPartCode = new StringBuffer();
		if(storeEmployee != null && !"".equals(storeEmployee)) {
//			organiseIdStr.append(storeEmployee.getOrganiseCO().getOrganiseId());// TODO 
			organiseIdStr.append(organiseId);
			
			depPartCode.append(depPart.getStorePart());
//			List<Menu> menuList = depPart.getMenuList();// TODO 再根据角色ID去查找一遍一级菜单列表
			List<Menu> menuList = this.menuService.queryMenuByStorePart(depPart.getStorePart());
			if(menuList != null && menuList.size() > 0) {
				for (Menu menu : menuList) {
					List<Menu> subMenu = menuService.querySubMenuByStorePart(menu.getId(),depPart.getStorePart());
					if(subMenu != null && subMenu.size() > 0) {
						menu.setSubMenu(subMenu);
					}
				}
			}
			// 将用户所拥有的权限菜单全部存在session中
			request.getSession().setAttribute(SysConstant.CURRENT_USER_MENU, menuList);
			organiseIdStr.append(",");
			depPartCode.append(",");
			model.addAttribute("menuList", menuList);
		}
		
		List<StoreEmployeeVO> storeEmployeeVOList = storeEmployeeService.queryStoreEmployeeVOBypStorePart(null, null);
		session.setAttribute(SysConstant.USERS_INFO, storeEmployeeVOList);
		
		String organiseStr = organiseIdStr.toString().substring(0,organiseIdStr.toString().lastIndexOf(","));
		
		storeEmployee.setDepPartCode(depPartCode.toString().substring(0,depPartCode.toString().lastIndexOf(",")));
		storeEmployee.setOrganiseId(organiseStr);
		
		OrganiseCO organise = organiseCOService.findOrganiseCOByorganiseId(organiseStr);
		
		// 查寻机构所有下属部门
		List<OrganiseCO> organiseCOList = organiseCOService.findListOrganiseCOByPOrganiseId(organiseStr);
	
		StringBuilder sb = new StringBuilder();
		sb.append("\'").append(organiseStr).append("\'").append(",");
		
		if(organiseCOList != null && organiseCOList.size() > 0) {
			for (OrganiseCO organiseCO : organiseCOList) {
				sb.append("\'").append(organiseCO.getOrganiseId()).append("\'").append(",");
				if(organiseCO.getSubOrganiseCO()!=null && organiseCO.getSubOrganiseCO().size() > 0) {
					String subOrganiseCOListStr = getSubOrganiseCOList(organiseCO.getSubOrganiseCO());
					sb.append(subOrganiseCOListStr);
				}else{
					continue;
				}
			}
			organise.setSubOrganiseCO(organiseCOList);
		}
		storeEmployee.setSubOrganiseIdStr(sb.toString().substring(0, sb.toString().lastIndexOf(",")));
		
		session.setAttribute(SysConstant.CURRENT_USER_INFO, storeEmployee);
		
		session.setAttribute(SysConstant.OrganiseCO_, organise);
		
		List<Parameter> parameterList = parameterService.queryParameterByKeyAndType("systemName","1");
		if(parameterList!=null){
			model.addAttribute("parameter", parameterList.get(0));
		}else{
			model.addAttribute("parameter", null);
		}
		
		return "system/admin/index";
	}
	
	@RequestMapping("toEditPassword.do")
	public String goEditPassword() {
		return "system/user/editPassword";
	}
	
	/*
	 * 获取用户所属的机构列表（用于下拉列表）
	 */
	private List<OrganiseCO> findUserOrganiseCOList(StoreEmployee storeEmployee) {
		List<OrganiseCO> userOrganiseCOList = this.organiseCOService.findOrganiseCOListByUserID(storeEmployee);
		if (userOrganiseCOList == null) {
			userOrganiseCOList = new ArrayList<OrganiseCO>();
		}
		
		return userOrganiseCOList;
	}
	
	/*
	 * 根据用户和机构获取角色列表
	 */
	private List<DepPart> findUserDepPartList(StoreEmployee storeEmployee, OrganiseCO organiseCO) {
		List<DepPart> userDepPartList = this.depPartService.findUserDepPartList(storeEmployee, organiseCO);
		if (userDepPartList == null) {
			userDepPartList = new ArrayList<DepPart>();
		}
		
		return userDepPartList;
	}
	
	/**
	 * ajax - 根据用户和机构获取角色列表
	 * @param response
	 * @param userId
	 * @param organiseId
	 */
	@RequestMapping(value = "login_default2.do")
	public void login_default2(HttpServletResponse response, String userId, String organiseId) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			StoreEmployee storeEmployee = new StoreEmployee();
			storeEmployee.setUserid(userId);
			OrganiseCO organiseCO = new OrganiseCO();
			organiseCO.setOrganiseId(organiseId);
			
			List<DepPart> userDepPartList = this.depPartService.findUserDepPartList(storeEmployee, organiseCO);
			if (userDepPartList == null) {
				userDepPartList = new ArrayList<DepPart>();
			}
			JSONObject Json = new JSONObject();
			//json中添加  数据   key  value 形式   返回图片路径
			Json.put("userDepPartList", userDepPartList);
			//更改编码
			
			//发送数据到页面
			response.getWriter().write(Json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
