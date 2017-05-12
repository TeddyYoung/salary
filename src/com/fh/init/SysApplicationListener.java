package com.fh.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fh.service.masterdata.DutyService;
import com.fh.service.system.DataDictionaryService;
import com.fh.service.system.ParameterService;

/**
 * 
 */
@Component
public class SysApplicationListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private DataDictionaryService dataDictionaryService;

	@Autowired
	private ParameterService parameterService;
	
	@Autowired
	private DutyService dutyService;
	

	/**
	 * 在web 项目中(spring mvc),系统会存在两个容器,<br>
	 * 一个是root application context,<br>
	 * 另一个就是我们自己的 projectName-servlet context(作为root application context的子容器).<br>
	 * 这种情况下,就会造成onApplicationEvent方法被执行两次。<br>
	 * 为了避免上面提到的问题,我们可以只在root application
	 * context初始化完成后调用逻辑代码,其他的容器的初始化完成,则不做任何处理<br>
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			// 初始化字典数据
			dataDictionaryService.init();
			// 初始化参数数据
			parameterService.init();
			//初始化职务数据
			dutyService.init();
		}
	}
}
