package com.fh.controller.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.page.Page;
import com.fh.controller.BaseController;
import com.fh.entity.biz.StationTarget;
import com.fh.service.operation.OilBaseDataService;

/**
 * 油站基础数据Controller
 * @author zhang_yu
 *以月作为单位, 加载所有的数据, 但维护只允许维护上个月的信息
 *
 */
@Controller(value="oilBaseDataController")
@RequestMapping({"/oilBaseData"})
public class OilBaseDataController extends BaseController {

	@Autowired
	private OilBaseDataService oilBaseDataService;
	
	/**
	 * 油站基础信息(展示biz_station_target中的全部)
	 */
	@RequestMapping("/oilBaseDataList.do")
	public String storeCheckList(Page page, StationTarget stationTarget, Model model) {
		
		if ("".equals(stationTarget.getYearMonth())) {
			stationTarget.setYearMonth(null);
		}
		Page pageList = oilBaseDataService.findOilBaseDataByPage(page, stationTarget.getYearMonth());
		model.addAttribute("pageList", pageList);
		model.addAttribute("st", stationTarget);
		return "operation/oilbasedata/oilBaseDataList";
		
	}
	
}
