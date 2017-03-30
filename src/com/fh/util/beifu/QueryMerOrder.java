package com.fh.util.beifu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/*
 * 商户订单查询请求
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class QueryMerOrder extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = "9UCKYZ6Q804CO5O43TGHLMDO4YTU10hggixe"; // 商户加密字符串	
		
		String service = "single_direct_query";
		String sign_type = req.getParameter("sign_type");	
		String partner = req.getParameter("partner");
		String out_trade_no = req.getParameter("out_trade_no");

		String s = null;
		QueryMerOrderDel quy = new QueryMerOrderDel();
		try {
			s = quy.queryDemo(key,service,sign_type,partner,out_trade_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(s);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
