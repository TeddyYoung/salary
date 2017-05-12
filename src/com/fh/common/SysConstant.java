package com.fh.common;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.fh.entity.system.StoreEmployee;

/**
 * 系统全局常量配置类
 * @author zhang_yu
 *
 */
public class SysConstant {
	
	private static Logger log = Logger.getLogger(SysConstant.class);

	//当前用户信息的sessionId
	public static String CURRENT_USER_INFO = "_CURRENT_USER";	
	
	//机构树的sessionId
	public static String OrganiseCO_ = "_OrganiseCO";	
	
	//所有用户信息的sessionId
	public static String USERS_INFO = "_USERS";	
	
	//导入Excel表格后解析的数据缓存的sessionId
	public static String CURRENT_EXCEL_CACHE = "_EXCEL_CACHE";
	
	//创建用户默认初始密码
	public static String CURRENT_USER_PASSWORD = "123456";
	
	//分页显示中每页显示的记录条数
	public static Integer CURRENT_PAGE_SIZE = 15;
	
	//上传文件的根目录
	public static String UPLOAD_ROOT_DIRECTORY = "uploadFiles";
	
	//创建编号 自增变量
	public static Integer CODE = 1;
	
	/*//流程发布  起始 油站经理 
	public static String AVTIVITI_STAFF_DUTY_MANAGER = "油站经理,兼站经理,见习经理";
	
	//流程发布  起始 油站会计
	public static String AVTIVITI_STAFF_DUTY_ACCOUNTANT = "油站会计,兼站会计,见习会计";*/
	
	//流程发布  起始 油站经理 
	public static String AVTIVITI_STAFF_DUTY_MANAGER = "ZW_0003,ZW_0004,ZW_0011";
	
	//流程发布  起始 油站会计
	public static String AVTIVITI_STAFF_DUTY_ACCOUNTANT = "ZW_0010,ZW_0008,ZW_0012";
	
	//用户拥有的权限(菜单)的sessionId
	public static String CURRENT_USER_MENU = "_CURRENT_USER_MENU"; 
	
	/** 获取当前用户
	 * @return
	 */
	public static StoreEmployee getCurrentUser(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		StoreEmployee storeEmployee = (StoreEmployee) session.getAttribute(SysConstant.CURRENT_USER_INFO);
		return storeEmployee;
	}
	
	
}