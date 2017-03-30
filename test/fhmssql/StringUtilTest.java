package fhmssql;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fh.util.StringUtil;

/**
 * 字符串工具类单元测试
 * @author zhang_yu
 *
 */
public class StringUtilTest {

	@Test
	public void strListToStringTest() {
		
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		
		StringUtil strUtil = new StringUtil();
		String string = strUtil.strListToString(strList);
		System.out.println(string);
		
	}
	
	@Test
	public void strIsLetterTest() {
		
		String str = "";
		StringUtil strUtil = new StringUtil();
		boolean is = strUtil.strIsLetter(str);
		System.out.println(is);
	}
	
	@Test
	public void roundTest() {
		
		String str = "17.55555555555555555555555";
		StringUtil strUtil = new StringUtil();
		String round = strUtil.round(str);
		System.out.println(round);
		
	}
	
}
