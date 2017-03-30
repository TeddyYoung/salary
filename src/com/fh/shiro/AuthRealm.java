package com.fh.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.fh.entity.system.StoreEmployee;
import com.fh.service.system.StoreEmployeeService;

/**
 *	shiro 认证 授权
 */
public class AuthRealm extends AuthorizingRealm {
	
	@Autowired
	private StoreEmployeeService storeEmployeeService;

	//授权----->判断用户的角色与权限(角色所拥有的模块)--------------------------------------------------------------------
	//那么, 既然进行授权, 前提是必须要知道有哪些权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
//		//获取当前登录的用户信息
//		User user = (User) principals.fromRealm(getName()).iterator().next();
//		//创建一个List用来存放用户的菜单
//		List<String> list = new ArrayList<String>();
//		
//		//获取用户所有的角色
//		String[] roleIds = user.getRoleId().split(",");
//		List<Role> roles = roleService.queryRolesByRoleIds(roleIds);
//		for (Role role : roles) { //遍历所有的角色, 获取对应的菜单
//			String[] menuIds = role.getMenuId().split(",");
//			List<Menu> menus = menuService.queryMenusByMenuIds(menuIds);
//			for (Menu menu : menus) {
////				if (Integer.parseInt(menu.getParentId()) == 0) { //parentId为0, 说明这是主菜单
////					list.add(menu.getMenuName()); //即使菜单名称改动, 但不影响菜单权限的分配
////				}
//				list.add(menu.getMenuName());
//			}
//		}
//		
//		//分配权限列表
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addStringPermissions(list); //将加载过来的权限放入Shiro中, 交给Shiro去分配权限
//		return info;
		return null;
	}

	//认证----->登录----------------------------------------------------------------------------------------------
	//根据用户名查询相应的用户,从而获取该用户在数据库中保存的密码
	//将密码交给CustomCredentialsMatcher这个类(自定义密码加密算法)进行比较
	//程序代码会将登录时用户输入的明文密码通过加密算法加密，再与数据库中获取的密码相比较
	//而这个密码的比较工作就是由CustomCredentialsMatcher这个类进行处理,这样程序员就无需考虑密码的比对问题
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token; //将参数token转换成它的子类, 再获取用户名
		String username = upToken.getUsername(); //获取用户在表单上输入的用户名
		StoreEmployee storeEmployee = storeEmployeeService.queryStoreEmployeeByUserId(username); //根据用户名查询用户对象
		if (null != storeEmployee) { //如果用户不为空, 说明数据库中有此用户
			//user,将查询得到的用户对象传过去
			//getPassword,认证方式，通过密码认证
			//getName得到当前Realm的名字,这个name是它爹(AuthorizingRealm)给的
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(storeEmployee, storeEmployee.getUserpwd(), getName());
			return info;
		}else{
			return null;
		}
		
	}

}
