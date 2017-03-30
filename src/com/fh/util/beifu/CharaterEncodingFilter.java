package com.fh.util.beifu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符集过滤器
 * @author 300468
 *
 */
public class CharaterEncodingFilter implements Filter {
	public static final String DEFALUT_ENCODING = "utf-8";
	
	/**
	 * 字符编码方式
	 */
	protected String encoding = DEFALUT_ENCODING;
	
	protected FilterConfig cofig = null;

	@Override
	public void destroy() {
		encoding = null;
		cofig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.cofig = config;
		String configedEncoding = this.cofig.getInitParameter("encoding");
		if (configedEncoding != null) {
			encoding = configedEncoding;
		}
	}

}
