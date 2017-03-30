package com.fh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fh.entity.system.Parameter;
import com.fh.service.system.ParameterService;
import com.fh.util.DateUtil;

@Controller
public class BaseController {
	
	@Autowired
	private ParameterService parameterService;
	
	protected boolean checkData() throws Exception {
		List<Parameter> parameterList = this.parameterService.queryParameterByKeyAndType("salaryDay", "1");
		if (parameterList != null && parameterList.size() > 0) {
			Parameter parameter = parameterList.get(0);
			String salaryDay = parameter.getParameterValue();
			String currentDay = DateUtil.getCurrentDay();
			if (Integer.parseInt(salaryDay) > Integer.parseInt(currentDay)) {
				return true;
			}
		}
		return false;
	}
	
	private int getCurrentDay() {
		
		return 0;
	}
	
}
