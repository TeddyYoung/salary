package com.fh.service.system;

import com.fh.entity.system.UserStorePart;

/**
 * 用户-角色Service接口
 * @author zhang_yu
 *
 */
public interface UserStorePartService {

	/**
	 * 根据UserId获取对应的角色
	 * @param userid
	 * @return
	 */
	public UserStorePart findUserStorePartByUserId(String userid);

}
