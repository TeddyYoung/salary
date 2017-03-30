package com.fh.common.aspect;

import javax.servlet.http.HttpServlet;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

import com.fh.entity.system.Logs;
import com.fh.service.system.LogsService;

/**
 * 通知类, 记录每次对权限/功能的操作(0: 增; 1: 删; 2: 改; 3: 查)
 * @author zhang_yu
 *
 */
@SuppressWarnings("serial")
public class MenuAspect extends HttpServlet implements MethodInterceptor {
	
	@Autowired
	private LogsService logsService;
	
	public Object invoke (MethodInvocation invocation) throws Throwable {
		
		//从RequestFilter过滤器中的线程上获取request对象
//		HttpServletRequest request = RequestFilter.threadLocalRequest.get();
		//取出当前登录的用户信息
//		StoreEmployee storeEmployee = (StoreEmployee) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		
		if ("queryMenuByStorePart".equals(invocation.getMethod().getName())) {
			Object object = invocation.proceed(); //调用目标方法
			
			Logs logs = new Logs();
//			logs.setLogId(UUID.randomUUID().toString());
//			logs.setOperator(storeEmployee.getUsername());
//			logs.setOperationTime(new Date());
//			logs.setOperationMenu(3);
//			logs.setOperationMenuName();
			logsService.insertLog(logs);
			return object;
		}else{
			if ("querySubMenu".equals(invocation.getMethod().getName())) {
				Object object = invocation.proceed(); //调用目标方法
				
				Logs logs = new Logs();
//				logs.setLogId(UUID.randomUUID().toString());
//				logs.setOperator(storeEmployee.getUsername());
//				logs.setOperationTime(new Date());
//				logs.setOperationMenu(3);
//				logs.setOperationMenuName();
				logsService.insertLog(logs);
				return object;
			}else{
				if ("queryAllParentMenu".equals(invocation.getMethod().getName())) {
					Object object = invocation.proceed(); //调用目标方法
					
					Logs logs = new Logs();
//					logs.setLogId(UUID.randomUUID().toString());
//					logs.setOperator(storeEmployee.getUsername());
//					logs.setOperationTime(new Date());
//					logs.setOperationMenu(3);
//					logs.setOperationMenuName();
					logsService.insertLog(logs);
					return object;
				}else{
					if ("deleteMenuById".equals(invocation.getMethod().getName())) {
						Object object = invocation.proceed(); //调用目标方法
						
						Logs logs = new Logs();
//						logs.setLogId(UUID.randomUUID().toString());
//						
//						logs.setOperator(storeEmployee.getUsername());
//						logs.setOperationTime(new Date());
//						logs.setOperationMenu(1);
//						logs.setOperationMenuName();
						logsService.insertLog(logs);
						return object;
					}else{
						if ("queryMenuById".equals(invocation.getMethod().getName())) {
							Object object = invocation.proceed(); //调用目标方法
							
							Logs logs = new Logs();
//							logs.setLogId(UUID.randomUUID().toString());
//							logs.setOperator(storeEmployee.getUsername());
//							logs.setOperationTime(new Date());
//							logs.setOperationMenu(3);
//							logs.setOperationMenuName();
							logsService.insertLog(logs);
							return object;
						}else{
							if("updateMenu".equals(invocation.getMethod().getName())) {
								Object object = invocation.proceed(); //调用目标方法
								
								Logs logs = new Logs();
//								logs.setLogId(UUID.randomUUID().toString());
//								logs.setOperator(storeEmployee.getUsername());
//								logs.setOperationTime(new Date());
//								logs.setOperationMenu(2);
//								logs.setOperationMenuName();
								logsService.insertLog(logs);
								return object;
							}else{
								if ("insertMenu".equals(invocation.getMethod().getName())) {
									Object object = invocation.proceed(); //调用目标方法
									
									Logs logs = new Logs();
//									logs.setLogId(UUID.randomUUID().toString());
//									logs.setOperator(storeEmployee.getUsername());
//									logs.setOperationTime(new Date());
//									logs.setOperationMenu(0);
//									logs.setOperationMenuName();
									logsService.insertLog(logs);
									return object;
								}
							}
						}
					}
				}
			}
		}
		return invocation.proceed();
		
	}
	
}
