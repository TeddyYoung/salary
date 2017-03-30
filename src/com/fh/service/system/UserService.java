package com.fh.service.system;

import com.fh.common.page.Page;

/**
 * 用户管理Service
 * @author zhang_yu
 *
 */
public interface UserService {

	/**
	 * 分页查询用户列表, 支持模糊查询
	 * @param pageNum 当前页(用户想看的那一页)
	 * @param username 用户名(用户在页面输入的筛选条件)
	 * @return
	 */
	Page findUsersByPage(Page page, String username,String subOrganiseIdStr);
	
	/**根据 id 更新用户  密码
	 * @param id
	 * @param userid
	 */
	void updateUserById(String id,String userid);
	
	/**更新 没有密码的 用户  给定初始密码
	 * @param id
	 * @param userid
	 */
	void updateUserPWD();

}
