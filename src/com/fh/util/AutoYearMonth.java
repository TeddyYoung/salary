package com.fh.util;

import java.util.Calendar;

/**
 * 获取上个月的时间
 * @author zhang_yu
 *
 */
public class AutoYearMonth {

	/**
	 * @return 上个月的年月份日期
	 */
	public String  getAutoYearMonth () {
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		
		//如果跨年的话, 要做特殊处理
		if (0 == month) {
			year = year - 1;
			month = 12;
			String yearMonth = String.valueOf(year) + "-" + month; //得到的月份数是上个月份, 比如: 当前为2016-1, 获取的则为2015-12
			return yearMonth;
		}else{
			String mon = String.valueOf(month);
			if (month < 10) {
				mon = "0" + mon;
			}
			String yearMonth = String.valueOf(year) + "-" + mon; //得到的月份数是上个月份, 比如: 当前为2015-11, 获取的则为2015-10
			return yearMonth;
		}
		
	}
	
}
