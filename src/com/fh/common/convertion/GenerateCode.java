package com.fh.common.convertion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.fh.common.SysConstant;

/**生成编号
 * @author lijn
 *
 */
public class GenerateCode {
	/**日期 + 编号 （设定三位）   根据 session 记录 进行自增
	 * @return
	 */
	public static String getCode(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		Integer code = (Integer)session.getAttribute(SysConstant.CODE);
		String newCode=null;
		code=code++;
		String date = new SimpleDateFormat("yyyymmdd").format(new Date());
		if(code.toString().length()==1){
			newCode=date+"00"+code.toString();
		}
		if(code.toString().length()==2){
			newCode=date+"0"+code.toString();
		}
		session.setAttribute(SysConstant.CODE, code);
		return newCode;
	}
}
