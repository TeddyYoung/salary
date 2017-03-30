package com.fh.util.beifu;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/*
 * 商户订单查询请求
 */

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.mypay.merchantutil.Md5Encrypt;
import com.mypay.merchantutil.UrlHelper;
import com.mypay.merchantutil.timestamp.TimestampUtils;


public class QueryMerOrderDel  {
	public String queryDemo(String key,String service,String sign_type,String partner,String out_trade_no) throws Exception {	
		Map<String,String[]> reqMap=new HashMap<String ,String[]>();
		reqMap.put("service",new String[]{service});
		reqMap.put("sign_type",new String[]{sign_type});
		reqMap.put("partner",new String[]{partner});
		reqMap.put("out_trade_no",new String[]{out_trade_no});
 
		String paramStr = UrlHelper.sortParamers(reqMap);
		 
		String plaintext = TimestampUtils.mergePlainTextWithMerKey(paramStr, key);
			
		// 加密(MD5加签)，默认已取UTF-8字符集，如果需要更改，可调用Md5Encrypt.setCharset(inputCharset)
		String sign = Md5Encrypt.encrypt(plaintext); 
		
		String encodedParamString = UrlHelper.encode(reqMap, "UTF-8");
		
		String gateway = "http://www.ebatong.com/gateway.htm"; // ebatong商户网关
		String url = gateway + "?" + encodedParamString + "&sign=" + URLEncoder.encode(sign,  "UTF-8");
		// 通过HttpClient获取响应字符串
		HttpClient httpClient = new HttpClient();
		HttpMethod method = new GetMethod(url);
		
		String queryOrderResponseString = null;
		
		try {
			httpClient.executeMethod(method);
			
			// 如果响应码为200，从响应中获取响应字符串
			if (method.getStatusCode() == 200) {
				
				queryOrderResponseString = method.getResponseBodyAsString();
				
				System.out.println(queryOrderResponseString);
			}	
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection(); // 释放连接
		}
		
		return queryOrderResponseString;
		
	}

}
