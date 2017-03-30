package com.fh.controller.masterdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.BaseController;
import com.fh.entity.biz.IndexConfig;
import com.fh.service.masterdata.IndexConfigService;

/**
 * 系数维护Controller
 * @author zhang_yu
 *
 */
@Controller(value="indexConfigController")
@RequestMapping({"/indexConfig"})
public class IndexConfigController extends BaseController {

	@Autowired
	private IndexConfigService indexConfigService;
	
	/**
	 * 系数维护列表查询
	 */
	@RequestMapping("/indexConfigList.do")
	public String indexConfigList(Model model) {
		
//		List<IndexConfig> mmpList = new ArrayList<>();
//		List<IndexConfig> spoilageList = new ArrayList<>();
//		List<IndexConfig> npsList = new ArrayList<>();
		
		//查询出系数维表中所有的全部系数数据(包括: MMP系数、耗损系数、NPS系数)
//		List<IndexConfig> indexConfigList = indexConfigService.findAllIndexConfigs();
//		for (IndexConfig indexConfig : indexConfigList) {
//			if ("MMP".equals(indexConfig.getIndexType())) { //筛选出所有的MMP系数
//				mmpList.add(indexConfig);
//			}else{
//				if("spoilage".equals(indexConfig.getIndexType())) { //筛选出所有的损耗系数
//					spoilageList.add(indexConfig);
//				}else{ //剩下的都是NPS系数
//					npsList.add(indexConfig);
//				}
//			}
//		}
		
		/**
		 * 上面的方法是查询数据库一次, 而这里的方法是查询数据库三次
		 * 1: 从性能上来看, 虽然对比上面的方法多查询了数据库两次, 但这个功能一般很少会用到, 即便是查询三次, 查询的频率不高, 依然在数据库的可承受范围之内;
		 * 2: 从代码便捷度上来看, 因为有牵涉到通过index_order字段排序的问题, 通过逆向工程生成的方法自带排序的方法无需再写, 只需调用即可;
		 *    而如果全部加载出来, 再通过字段去筛选出不同的系数, 再一个个去遍历再排序, 过于麻烦.
		 */
		List<IndexConfig> mmpList = indexConfigService.findAllMMPIndexConfigs();
		List<IndexConfig> spoilageList = indexConfigService.findAllspoilageIndexConfigs();
		List<IndexConfig> npsList = indexConfigService.findAllNPSIndexConfigs();
		
		model.addAttribute("mmpList", mmpList);
		model.addAttribute("spoilageList", spoilageList);
		model.addAttribute("npsList", npsList);
		return "masterdata/indexconfig/indexConfigList";
		
	}
	
}
