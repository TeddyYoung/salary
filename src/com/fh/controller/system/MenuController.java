package com.fh.controller.system;

import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.entity.system.Menu;
import com.fh.service.system.MenuService;

/**
 *	菜单管理
 */
@Controller(value="menuController")
@RequestMapping({"/menu"})
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	/**
	 * 显示菜单列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/menu.do")
	public String list(Model model)throws Exception{
		try{
			List<Menu> parentMenu = menuService.queryAllParentMenu();
			model.addAttribute("parentMenu", parentMenu);
		} catch(Exception e){
			throw new IllegalArgumentException(e); 
		}
		
		return "system/menu/menu_list";
	}
	/**
	 * 获取当前菜单的所有子菜单
	 * @param menuId
	 * @param response
	 */
	@RequestMapping(value="/sub.do")
	public void getSub(String id,String gid,HttpServletResponse response)throws Exception{
		try {
			List<Menu> subMenu = menuService.querySubMenu(id);
			JSONArray arr = JSONArray.fromObject(subMenu);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			String json = arr.toString();
			out.write(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			throw new IllegalArgumentException(e); 
		}
	}
	/**
	 * 请求新增菜单页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toAdd.do")
	public String toAdd(Model model)throws Exception{
		try{
			List<Menu> parentMenu = menuService.queryAllParentMenu();
			model.addAttribute("parentMenu", parentMenu);
		} catch(Exception e){
			throw new IllegalArgumentException(e); 
		}
		return "system/menu/menu_add";
	}
	/**
	 * 保存菜单信息
	 * @param menu
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add.do")
	public String add(Menu menu,Model model)throws Exception{
		try{
			String id = UUID.randomUUID().toString();
			id=id.replace("-", "");
			menu.setId(id);
			menuService.insertMenu(menu);
			model.addAttribute("msg","success");
		} catch(Exception e){
			model.addAttribute("msg","failed");
			throw new IllegalArgumentException(e); 
		}
		return "save_result";
		
	}
	/**
	 * 删除菜单
	 * @param menuId
	 * @param out
	 */
	@RequestMapping(value="/del.do")
	public void delete(String id,HttpServletResponse response)throws Exception{
		// json对象
		JSONObject js = new JSONObject();
		try {
			String result = menuService.deleteMenuById(id);
			// json中添加 数据 key value 形式
			js.put("result", result);
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	/**
	 * 请求编辑菜单页面
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/toEdit.do")
	public String toEdit(String id,Model model)throws Exception{
		try{
			Menu menu = menuService.queryMenuById(id);
			List<Menu> parentMenu = menuService.queryAllParentMenu();
			model.addAttribute("parentMenu", parentMenu);
			model.addAttribute("menu", menu);
		} catch(Exception e){
			throw new IllegalArgumentException(e);
		}
		return "system/menu/menu_edit";
	}
	/**
	 * 保存编辑
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/edit.do")
	public String edit(Model model,Menu menu)throws Exception{
		try{
			String pid = menu.getPid();
			if(null == pid || "".equals(pid)){
				pid = "0";
				menu.setPid(pid);
			}
			
			menuService.updateMenu(menu,menu.getId());
			model.addAttribute("msg","success");
		} catch(Exception e){
			model.addAttribute("msg","failed");
			throw new IllegalArgumentException(e);
		}
		return "save_result";
	}
	/**
	 * 请求编辑菜单图标页面
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/toEditicon.do")
	public String toEditicon(String id,Model model)throws Exception{
		try{
			Menu menu = menuService.queryMenuById(id);
			model.addAttribute("menu", menu);
		} catch(Exception e){
			throw new IllegalArgumentException(e);
		}
		return "system/menu/menu_icon";
	}
		/**
		 * 保存菜单图标 (顶部菜单)
		 * @param 
		 * @return
		 */
		@RequestMapping(value="/editicon.do")
		public String editicon(String MENU_ID,String MENU_ICON,Model model)throws Exception{
			try{
				Menu menu = new Menu();
				menu.setIcon(MENU_ICON);
				menuService.updateMenu(menu,MENU_ID);
				model.addAttribute("msg","success");
			} catch(Exception e){
				model.addAttribute("msg","failed");
				throw new IllegalArgumentException(e);
			}
			return "save_result";
		}
	
}
