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

import com.fh.entity.system.DepPart;
import com.fh.entity.system.Menu;
import com.fh.service.system.DepPartService;
import com.fh.service.system.MenuService;
import com.fh.service.system.PagePermService;

/**
 * 部门角色管理
 */
@Controller(value="depPartController")
@RequestMapping({"/depPart"})
public class DepPartController {
	@Autowired
	private DepPartService depPartService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private PagePermService pagePermService;

	/**
	 * 列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/role.do")
	public String list(Model model, String roleId) {
		// 列出所有部门
		List<DepPart> depParts = depPartService.queryAllDepPart();
		/*if (roleId == null || roleId == "") {
			roleId = "1";
		}
		// 根据id查询部门角色
		DepPart depPart = depPartService.queryDeptPartByRoleId(roleId);
		if(depPart==null || "".equals(depPart)){
			roleId = "1";
			depPart = depPartService.queryDeptPartByRoleId(roleId);
		}
		// 列出此部门的所有下级
		List<DepPart> subDepParts = depPartService.queryAllSubDepPart(depPart.getStorePart());
		depPart.setSubDepPart(subDepParts);
		model.addAttribute("depPart", depPart);*/

		model.addAttribute("depParts", depParts);
		return "system/role/role_list";
	}

	/**
	 * 请求角色菜单授权页面
	 */
	@RequestMapping(value = "/auth.do")
	public String auth(String roleId, Model model) throws Exception {
		try { 
			DepPart depPart = depPartService.queryDeptPartByRoleId(roleId);
			if("0".equals(depPart.getpStorePart())){
				//查询本组角色的下级角色
				List<DepPart> subDepPart = depPartService.queryAllSubDepPart(depPart.getStorePart());
				
				//所有角色的下级角色
				List<DepPart> depParts = depPartService.queryAllParentDepPart();
				
				for (DepPart dp : depParts) {
					
					boolean ischecked=false;
					List<DepPart> subDP = depPartService.queryAllSubDepPart(dp.getStorePart());
					if(subDP!=null &&subDP.size()>0){
						for (DepPart dpt : subDP) {
							if(subDepPart!=null &&subDepPart.size()>0){
								for (DepPart sdpt : subDepPart) {
										if(dpt.getId().equals(sdpt.getId())){
											dpt.setChecked(true);
											ischecked=true;
										}
									}
								}
							}
						}
					if(ischecked){
						dp.setChecked(ischecked);
					}
					dp.setSubDepPart(subDP);
				}
				
				
				JSONArray arr = JSONArray.fromObject(depParts);
				String json = arr.toString();
				json = json.replaceAll("subDepPart", "nodes");
				json = json.replaceAll("storePartName", "name");
				json = json.replaceAll("pStorePart", "pid");
				model.addAttribute("zTreeNodes", json);
				model.addAttribute("identity", "depPart");
				model.addAttribute("storePart", depPart.getStorePart());
			}else{
				List<Menu> menuList = menuService.queryAllParentMenu();
				
				// 查询本角色所拥有的权限
				List<Menu> depPartMenus = pagePermService.queryDepPartMenus(depPart
						.getStorePart());

				if (menuList != null && menuList.size() > 0) {
					
					for (Menu menu : menuList) {
						
						menu.setUrl(null);
						
						boolean ischecked=false;
						List<Menu> subMenu = menuService.querySubMenu(menu.getId());
						if(depPartMenus!=null &&depPartMenus.size()>0){
							for (Menu sdpm : depPartMenus) {
								if(sdpm!=null && !"".equals(sdpm)){
									if(subMenu!=null &&subMenu.size()>0){
										for (Menu sm : subMenu) {
											if(sm.getId().equals(sdpm.getId())){
												sm.setChecked(true);
												ischecked=true;
											}
										}
									}
								}
								
							}
						}
						if(ischecked){
							menu.setChecked(ischecked);
						}
						menu.setSubMenu(subMenu);
					}
				}
				JSONArray arr = JSONArray.fromObject(menuList);
				String json = arr.toString();
				json = json.replaceAll("subMenu", "nodes");
				json = json.replaceAll("icon", "class");
				model.addAttribute("zTreeNodes", json);
				model.addAttribute("identity", "menu");
				model.addAttribute("storePart", depPart.getStorePart());
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		return "authorization";
	}



	/**
	 * 请求新增页面
	 */
	@RequestMapping(value = "/toAdd.do")
	public String toAdd(String pStorePart, Model model) {
		try {
			if(pStorePart==null || "".equals(pStorePart)){
				pStorePart="0";
			}
			model.addAttribute("pStorePart", pStorePart);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return "system/role/role_add";
	}

	/**
	 * 保存角色菜单权限
	 */
	@RequestMapping(value = "/auth/save.do")
	public void saveAuth(String storePart, String Ids, String identity, PrintWriter out)
			throws Exception {
		try {
			if("depPart".equals(identity)){
				//将角色与子角色的连接 设置为null
				depPartService.updateDepPartByStorePart(storePart);
			}else if("menu".equals(identity)){
				//删除角色与菜单之间的联系
				pagePermService.deletePagePermByStorePart(storePart);
			}
			if (null != Ids && !"".equals(Ids.trim())) {
				String[] idArray = Ids.split(",");
				if (idArray != null && idArray.length > 0) {
					for (int i = 0; i < idArray.length; i++) {
						if("depPart".equals(identity)){
							DepPart depPart = depPartService.queryDeptPartByRoleId(idArray[i]);
							depPartService.updateDepPart(depPart);
						}else if("menu".equals(identity)){
							pagePermService.insertPagePerm(storePart, idArray[i]);
						}
						
					}
				}
			}
			out.write("success");
			out.close();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/add.do")
	public String add(DepPart depPart, Model model) {
		try {
			
			String storePart = UUID.randomUUID().toString();
			storePart=storePart.replace("-", "");
			depPart.setStorePart(storePart.substring(6));
			depPartService.insertDepPart(depPart);
			model.addAttribute("msg", "success");
		} catch (Exception e) {
			model.addAttribute("msg", "failed");
			throw new IllegalArgumentException(e);
		}
		return "save_result";
	}

	/**
	 * 请求编辑
	 */
	@RequestMapping(value = "/toEdit.do")
	public String toEdit(String roleId, Model model) throws Exception {
		try {
			DepPart deptPart = depPartService.queryDeptPartByRoleId(roleId);
			model.addAttribute("deptPart", deptPart);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return "system/role/role_edit";
	}

	/**
	 * 保存编辑
	 */
	@RequestMapping(value = "/edit.do")
	public String edit(DepPart depPart, Model model) throws Exception {
		try {
			depPartService.updateDepPart(depPart);
			model.addAttribute("msg", "success");
		} catch (Exception e) {
			model.addAttribute("msg", "failed");
			throw new IllegalArgumentException(e);
		}
		return "save_result";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete.do")
	public void deleteDepPart(String depPartId, HttpServletResponse response)
			throws Exception {
		// json对象
		JSONObject js = new JSONObject();
		try {
			DepPart deptPart = depPartService.queryDeptPartByRoleId(depPartId); 
			if(deptPart!=null && !"".equals(deptPart)){
				if(deptPart.getpStorePart()!=null && !"".equals(deptPart.getpStorePart())){
					List<DepPart> subDepPartList = depPartService.queryAllSubDepPart(deptPart.getStorePart());
					if(subDepPartList!=null && subDepPartList.size()>0){
						js.put("result", "false");
					}else{
						depPartService.deleteDepPartById(Integer.valueOf(depPartId));
						// json中添加 数据 key value 形式
						js.put("result", "success");
					}
				}
			}
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

}
