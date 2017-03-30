package com.fh.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串相关工具
 * @author zhang_yu
 *
 */
public class StringUtil extends StringUtils{

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}
	
	/**
	 * 将一组字符串集合拼接成以一个以逗号分隔的字符串: 1,2,3,4,5
	 */
	public String strListToString(List<String> strList) {
	
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strList.size(); i++) {
			sb.append(strList.get(i)).append(",");
		}
		return sb.toString().substring(0, sb.toString().lastIndexOf(","));
	
	}
	
	/**
	 * 将一组字符串集合拼接成以一个以逗号分隔的字符串最后还是会有一个逗号: 1,2,3,4,5,
	 */
	public String strListToStr(List<String> strList) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strList.size(); i++) {
			sb.append(strList.get(i)).append(",");
		}
		return sb.toString();
		
	}
	
	/**
	 * 判断一个字符是否是字母
	 */
	public boolean strIsLetter(String str) {
		
		String reg = "[a-zA-Z]";
		boolean isCract = str.matches(reg);
		return isCract;
		
	}
	
	/**
	 * 将一个字符串的数字保留一位四舍五入
	 */
	public String round(String str) {
		
		String IntegerPart = str.substring(0, str.indexOf(".")); //整数部分
		String decimalsPart = str.substring(str.indexOf(".") + 1); //小数部分
		String firstDecimal = decimalsPart.substring(0, 1);
		if (Integer.parseInt(firstDecimal) >= 5) {
			return IntegerPart + "." + String.valueOf(Integer.parseInt(firstDecimal) + 1);
		}else{
			return IntegerPart + "." + String.valueOf(Integer.parseInt(firstDecimal));
		}
		
	}
	
}
