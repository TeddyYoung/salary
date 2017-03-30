package com.fh.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.entity.system.Logs;
import com.fh.service.system.LogsService;

@Controller(value="logsController")
@RequestMapping({"/logs"})
public class LogsController {

	@Autowired
	private LogsService logsService;
	
	/**
	 * 查询所有的日志记录列表
	 */
	@RequestMapping("/logsList.do")
	public String findAllLogs(Model model) {
		
		List<Logs> logs = logsService.findAllLogs();
		model.addAttribute("logs", logs);
		return "system/logs/logsList";
		
	}
	
}
