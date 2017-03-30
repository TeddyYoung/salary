package com.fh.controller.salarymanagement;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.common.SysConstant;
import com.fh.common.page.Page;
import com.fh.entity.biz.SalaryDifference;
import com.fh.entity.biz.SalaryDifferenceVO;
import com.fh.entity.system.Flag;
import com.fh.entity.system.StoreEmployee;
import com.fh.entity.system.UserStorePart;
import com.fh.service.salarymanagement.SalaryDifferenceService;
import com.fh.service.system.UserStorePartService;
import com.fh.util.AutoYearMonth;

/**
 * 薪资差异处理Controller
 * @author zhang_yu
 *
 */
@Controller(value = "SalaryDifferenceController")
@RequestMapping({ "/salaryDifference" })
public class SalaryDifferenceController {

	@Autowired
	private SalaryDifferenceService salaryDifferenceService;
	@Autowired
	private UserStorePartService userStorePartService;
	
	/**
	 * 薪资差异处理列表
	 * 支持按 员工姓名、年份月份 过滤查询
	 */
	@RequestMapping("/salaryDifferenceList.do")
	public String salaryDifferenceList(HttpServletRequest request, Page page, 
									   SalaryDifference salaryDifference, Model model) {
		
		//判断当前登录者是否是油站会计, 如果不是油站会计, 则对权限进行控制: 薪资差异申请只能由油站会计进行申请
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		
		if("".equals(salaryDifference.getYearMonth())) {
			salaryDifference.setYearMonth(null);
		}
		if("".equals(salaryDifference.getStaffName())) {
			salaryDifference.setStaffName(null);
		}
		Page pageList = salaryDifferenceService.findSalaryDifferencesByPage(page, salaryDifference.getStaffName(), 
																				  salaryDifference.getYearMonth(),
																				  storeEmployee.getSubOrganiseIdStr());
		model.addAttribute("pageList", pageList);
		model.addAttribute("salaryDifference", salaryDifference);
		
		//根据当前登录者的UserId得到其对应的Store_part
		UserStorePart userStorePart = userStorePartService.findUserStorePartByUserId(storeEmployee.getUserid());
		if ("S_003".equals(userStorePart.getStorePart())) {
			Flag flag = new Flag();
			flag.setFlag("yzkj");
			model.addAttribute("Flag", flag);
		}
		return "salarymanagement/salarydifference/salaryDifferenceList";
		
	}
	
	/**
	 * 跳转至薪资差异申请页面
	 * 获取当前登录者所属的油站, 加载该油站下所有的员工
	 * 给这些员工们一个CkeckBox, 油站经理勾选需要进行差异申请的员工
	 * 填写完申请理由, 提交申请
	 */
	@RequestMapping("/salaryDifferenceFillOut.do")
	public String salaryDifferenceList(HttpServletRequest request, Model model) {
		
		//获取上个月的年月份
		AutoYearMonth autoYearMonth = new AutoYearMonth();
		String yearMonth = autoYearMonth.getAutoYearMonth();
		Flag flag = new Flag();
		flag.setFlag(yearMonth);
		model.addAttribute("Flag", flag);
		
		//判断当前登录者是否是油站会计, 如果不是油站会计, 则对权限进行控制: 薪资差异申请只能由油站会计进行申请
		StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		String subOrganiseIdStr = storeEmployee.getSubOrganiseIdStr();
		List<SalaryDifference> salaryDifferenceList = salaryDifferenceService.findStaffListWithStationNameByStationCode(subOrganiseIdStr, yearMonth);
		//将符合记录的员工全部显示在页面上
		model.addAttribute("salaryDifferenceList", salaryDifferenceList);
		
		return "salarymanagement/salarydifference/salaryDifferenceFillOut";
		
	}
	
	/**
	 * 确定薪资差异修改
	 */
	@RequestMapping("/salaryDifferenceSaveOrUpdate.do")
	public String salaryDifferenceSaveOrUpdate(HttpServletRequest request, String ids, SalaryDifferenceVO salaryDifferenceVO, Model model) {
		
		if (null !=salaryDifferenceVO && salaryDifferenceVO.getSalaryDifferenceList().size() != 0) {
			//筛选出页面有勾选的员工
			List<SalaryDifference> salaryDifferenceCheckedList = new ArrayList<SalaryDifference>();
			List<SalaryDifference> salaryDifferenceList = salaryDifferenceVO.getSalaryDifferenceList();
			for (SalaryDifference salaryDifference : salaryDifferenceList) {
				if (ids.contains(salaryDifference.getStaffCode())) {
					salaryDifferenceCheckedList.add(salaryDifference);
				}
			}
			boolean returnValue = salaryDifferenceService.saveOrUpdateSalaryDifference(salaryDifferenceCheckedList, request);
			if (returnValue) {
				return "redirect:/salaryDifference/salaryDifferenceList.do";
			}else{
				Flag flag = new Flag();
				flag.setFlag("wftjsq");
				model.addAttribute("Apply", flag);
				return "salarymanagement/salarydifference/salaryDifferenceFillOut";
			}
		}else{
			throw new RuntimeException("Sorry, SalaryDifferenceVO entity is null or '', please check your page!");
		}
		
	}
	
	
}
