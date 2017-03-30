package com.fh.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fhmssql.entity.SellData;

/**
 * 销售数据维护
 * @author lijn
 *
 */
@Controller(value="sellDataControllerTest")
@RequestMapping({"/sellData"})
public class SellDataControllerTest {
	
	/**
	 * 通过链接  获取  json 
	 */
	@RequestMapping("/getJsonData.doc")
	public void getJsonData(String request_data,HttpServletResponse response) {
		//json="{\"response_status\":\"success\",\"response_data\":[{\"sid\":\"2015100001\",\"oils\":\"100.11\",\"oild\":\"10\",\"oilrate\":\"99.1\",\"noils\":\"200.1\",\"noild\":\"10\" ,\"noilrate\":\"95.1\",\"yearMonth\":\"2015-10\"},{\"sid\":\" 2015100002 \",\"oils \":\"100.11\",\"oild\":\"10\" ,\"oilrate\":\"99.1\",\"noils\":\"200.1\",\"noild\":\"10\" ,\"noilrate\":\"99.1\",\"yearMonth\":\"2015-10\"},{\"sid\":\" 2015100003 \",\"oils\":\"100.11\",\"oilrate\":\"99.1\",\"oild\":\"10\",\"noils\":\"200.1\",\"noild\":\"10\" ,\"noilrate\":\"99.1\",\"yearMonth\":\"2015-10\"},{\"sid\":\" 2015100004 \",\"oils\":\"163.74\",\"oilrate\":\"89.6\",\"oild\":\"56\",\"noils\":\"71.4\",\"noild\":\"72.9\" ,\"noilrate\":\"121.3\",\"yearMonth\":\"2015-10\"}]}";
		// json对象
		JSONObject js = new JSONObject();
		try {
			// json中添加 数据 key value 形式
			js.put("response_status", "success");
			List<SellData> sellDataList=new ArrayList<SellData>();
			JSONObject jsonObject =JSONObject.fromObject(request_data.toString());
			String string = jsonObject.getString("request_data");
			String sale_month =JSONObject.fromObject(string.toString()).getString("sale_month");
			/*for (int i = 1; i < 6; i++) {
				SellData sellData = new SellData();
				sellData.setSid("201510000"+i);
				sellData.setOils(BigDecimal.valueOf(100.11+i));
				sellData.setNoild(BigDecimal.valueOf(120.11+i));
				sellData.setNoilrate(BigDecimal.valueOf(132.11+i));
				sellData.setNoils(BigDecimal.valueOf(145.11+i));
				sellData.setOild(BigDecimal.valueOf(154.11+i));
				sellData.setOilrate(BigDecimal.valueOf(175.11+i));
				sellData.setYearMonth("2015-11");
				sellDataList.add(sellData);
			}*/
			SellData sellData1 = new SellData();
			sellData1.setSid("A011"); //油站编号
			sellData1.setOils(BigDecimal.valueOf(637588.92)); //油品本月实际销量
			sellData1.setNoild(BigDecimal.valueOf(3601.64)); //油品日均销量
			sellData1.setNoilrate(BigDecimal.valueOf(156.59)); //油品达标率
			sellData1.setNoils(BigDecimal.valueOf(111650.84)); //非油品本月实际销量
			sellData1.setOild(BigDecimal.valueOf(20567.38452)); //非油品日均销量
			sellData1.setOilrate(BigDecimal.valueOf(100.33)); //非油品达标率
			sellData1.setYearMonth(sale_month);
			sellDataList.add(sellData1);
			
			SellData sellData2 = new SellData();
			sellData2.setSid("A041");
			sellData2.setOils(BigDecimal.valueOf(205387.85));
			sellData2.setOild(BigDecimal.valueOf(6625.414516));
			sellData2.setOilrate(BigDecimal.valueOf(120.46));
			sellData2.setNoils(BigDecimal.valueOf(19906.6));
			sellData2.setNoild(BigDecimal.valueOf(642.1483871));
			sellData2.setNoilrate(BigDecimal.valueOf(142.70));
			sellData2.setYearMonth(sale_month);
			sellDataList.add(sellData2);
			
			
			js.put("response_data", sellDataList);
			// 更改编码
			response.setContentType("application/json;charset=UTF-8");
			// 发送数据到页面
			response.getWriter().write(js.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		
	}
}
