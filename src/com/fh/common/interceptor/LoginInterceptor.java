package com.fh.common.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fh.common.SysConstant;
import com.fh.entity.system.Menu;
import com.fh.entity.system.StoreEmployee;
import com.fh.service.system.DepPartService;
import com.fh.service.system.MenuService;

/**
 * 登录拦截, 判断用户是否登录 权限拦截, 判断当前访问的菜单是否在用户的其权限之内 如果用户具有这个权限, 放行; 如果用户不具有这个权限, 不放行,
 * 给予用户权限的提示
 * 
 * @author zhang_yu
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private MenuService menuService;
	@Autowired
	private DepPartService depPartSevice;

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
								Object handler, Exception exception) throws Exception {}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
						   Object handler, ModelAndView exception) throws Exception {}

	// 登录验证
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// 截取URI到".do"的前一段, 防止在".do"后面携带没有权限的窄化请求参数进行访问
		String requestUri = request.getRequestURI().substring(0, request.getRequestURI().indexOf(".do") + 3);

		if (requestUri.indexOf(".do") > 0) {
			if (requestUri.indexOf("login") > 0) { // 如果URI中包含login, 那么这个请求要么是去登录页面, 要么是去验证登录, 放行
				return true;
			}
			if (requestUri.indexOf("logout") > 0) { // 如果URI中包含logout, 那么这个请求去注销登录, 放行
				return true;
			}
			if (requestUri.indexOf("submitRole") > 0) {
				return true;
			}
			if (requestUri.indexOf("common") > 0) {
				return true;
			}
			
			// 判断session中是否有当前登录的用户信息
			StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
			if (null != storeEmployee) {
				// 访问权限过滤
				List<Menu> menuList = new ArrayList<Menu>();
				List<Menu> subMenuList = new ArrayList<Menu>();
				@SuppressWarnings("unchecked")
				List<Menu> menus = (List<Menu>) request.getSession().getAttribute(SysConstant.CURRENT_USER_MENU);
				for (Menu menu : menus) {
					if ("0".equals(menu.getPid()) && !menuList.contains(menu)) {
						List<Menu> menuSubList=menu.getSubMenu();
						if(menuSubList!=null&&menuSubList.size()>0){
							for (Menu subMenu : menu.getSubMenu()) {
								if (menu.getId().equals(subMenu.getPid())) {
									subMenuList.add(subMenu);
								}
							}
						}
						menu.setSubMenu(subMenuList);
						menuList.add(menu);
					}
				}
				// 获取当前登录者所有的权限, 截取这些权限的窄化请求
				List<String> menuSubString = new ArrayList<String>();
				for (Menu menu : subMenuList) {
					if (null != menu.getUrl() && !"".equals(menu.getUrl())) {
						menuSubString.add(menu.getUrl().substring(0, menu.getUrl().indexOf("/")));
					}
				}
				// 判断用户所允许的的窄化请求是否有一个在当前访问的URI中
				for (String string : menuSubString) {
					if (requestUri.indexOf(string) > 0 || requestUri.contains("/tab.do")) {
						return true;
					}
				}
				// 重定向到登录页面
				response.sendRedirect(request.getContextPath() + "/login_toLogin.do");
				return false;
			}
			// 重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/login_toLogin.do");
			return false;
		}
		// 重定向到登录页面
		response.sendRedirect(request.getContextPath() + "/login_toLogin.do");
		return false;
	}

}
