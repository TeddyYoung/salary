package com.fh.common.convertion;

import org.springframework.core.convert.converter.Converter;

/**
 * 判断JSP页面表单提交的值是否为空串或夹杂空串
 * 讲夹杂空串的参数滤空
 * @author zhang_yu
 *
 */

public class CustomTrimConvertion implements Converter<String, String> {

	@Override
	public String convert(String source) { //source: JSP页面传的参数
		
		try {
			
			if (null != source) { 
				source = source.trim(); //返回字符串的副本, 忽略前导空白和尾部空白("  谢逊      " -----> "谢逊")
				if (!"".equals(source)) {  //忽略空白后不为空串则返回, 否则返回空
					return source;
				}
			}
			
		} catch (Exception e) {
		}
		
		return null;
	}
	
}
