package com.fh.controller.system;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.entity.system.DataDictionary;
import com.fh.service.system.DataDictionaryService;
/**
 * 数据字典基本信息维护 Controller
 * @author lijn
 *
 */
@Controller(value="dataDictionaryController")
@RequestMapping({"/dataDictionary"})
public class DataDictionaryController {
	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	/**查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dataDictionaryList.do")
	public String list(Page page,Model model,String codename){
		Page pageList = dataDictionaryService.findDataDictionarysByPage(page, codename);
		model.addAttribute("pageList", pageList);
		model.addAttribute("codename", codename);
		return "system/dataDictionary/dataDictionaryList";
	}
	/**去添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dataDictionaryToAdd.do")
	public String toadd(Model model){
		return "system/dataDictionary/dataDictionaryAdd";
	}
	/**去修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dataDictionaryToEdit.do")
	public String toEdit(String id,Model model){
		//根据id查询记录
		DataDictionary dataDictionary=dataDictionaryService.queryDataDictionaryById(id);
		if(dataDictionary!=null)
		model.addAttribute("dataDictionary", dataDictionary);
		return "system/dataDictionary/dataDictionaryEdit";
	}
	/**添加或修改数据字典信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dataDictionarySaveOrUpdate.do")
	public String saveOrUpdate(DataDictionary dataDictionary,Model model){
		dataDictionaryService.saveOrUpdate(dataDictionary);
		return "save_result";
	}
	/**去详情页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dataDictionaryToView.do")
	public String toView(String id,Model model){
		//根据id查询记录
		DataDictionary dataDictionary=dataDictionaryService.queryDataDictionaryById(id);
		if(dataDictionary!=null)
		model.addAttribute("dataDictionary", dataDictionary);
		return "system/dataDictionary/dataDictionaryView";
	}
	/**根据id删除记录
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dataDictionaryDelById.do")
	public void delDataDictionaryById(String id,HttpServletResponse response){
		// json对象
		JSONObject js = new JSONObject();
		try {
			dataDictionaryService.deleteDataDictionaryById(id);
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
