package com.fh.util;

import java.math.BigDecimal;

/**
 * 数据类型转换工具类
 * @author zhang_yu
 *
 */
public class DataTypeConversion {

	/**
	 * 将BigDecimal类型转换为String类型, 去掉小数后面多余的0(1.5200 -----> 1.52)
	 * @param bdData
	 * @return
	 */
	public static String bigDecimalToString(BigDecimal bdData) {
		
		String str = String.valueOf(bdData);
		if (str.contains(".")) {
			String intStr = str.substring(0, str.indexOf(".")); //取小数的整数部分
			String lastStr = str.substring(str.lastIndexOf(".")); //取小数的小数部分, 包含小数点
			try {
				if (!"0".equals(lastStr.subSequence(4, 5))) {
					return str;
				}else if (!"0".equals(lastStr.subSequence(3, 4))) {
					return intStr + lastStr.substring(0, 4);       
				}else if (!"0".equals(lastStr.subSequence(2, 3))) {
					return intStr + lastStr.substring(0, 3);  
				}else if (!"0".equals(lastStr.subSequence(1, 2))) {
					return intStr + lastStr.substring(0, 2);      
				}else{
					return intStr;
				}
			} catch (Exception e) {
				throw new RuntimeException("对不起， 您输入的参数bdData小数点后不足4位！");
			}
		}else{
			return str;
		}
		
	}
	
	/**
	 * 将BigDecimal类型的数据转换为字符串类型的百分数返回
	 */
	public static String bigDecimalToPercentage(BigDecimal bdData) {
		
		BigDecimal bigDecimal = new BigDecimal("100");
		BigDecimal multiply = bdData.multiply(bigDecimal);
		String str = DataTypeConversion.bigDecimalToString(multiply);
		return str + "%";
	
	}
	
}
