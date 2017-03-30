package com.fh.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.UserStorePartDao;
import com.fh.entity.system.UserStorePart;
import com.fh.entity.system.UserStorePartQuery;

/**
 * 用户-角色Service实体类
 * @author zhang_yu
 *
 */
@Service
public class UserStorePartServiceImpl implements UserStorePartService {

	@Autowired
	private UserStorePartDao userStorePartDao;
	
	/**
	 * 根据UserId获取对应的角色
	 */
	public UserStorePart findUserStorePartByUserId(String userid) {
		
		UserStorePartQuery userStorePartQuery = new UserStorePartQuery();
		userStorePartQuery.createCriteria().andUseridEqualTo(userid);
		return userStorePartDao.selectByExample(userStorePartQuery).get(0);
		
	}

}
