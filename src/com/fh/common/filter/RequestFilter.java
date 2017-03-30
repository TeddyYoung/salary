package com.fh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在普通Java类中获取request对象和response对象
 * @author zhang_yu
 *
 */
public class RequestFilter implements Filter {

	/**
	 * 创建线程, 为这个线程注入request/response对象
	 */
	public static ThreadLocal<HttpServletRequest> threadLocalRequest = new ThreadLocal<HttpServletRequest>();
	public static ThreadLocal<HttpServletResponse> threadLocalResponse = new ThreadLocal<HttpServletResponse>();
	public static ThreadLocal<HttpServletRequest> getThreadLocalRequest() {
		return threadLocalRequest;
	}
	public static void setThreadLocalRequest(ThreadLocal<HttpServletRequest> threadLocalRequest) {
		RequestFilter.threadLocalRequest = threadLocalRequest;
	}
	public static ThreadLocal<HttpServletResponse> getThreadLocalResponse() {
		return threadLocalResponse;
	}
	public static void setThreadLocalResponse(ThreadLocal<HttpServletResponse> threadLocalResponse) {
		RequestFilter.threadLocalResponse = threadLocalResponse;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		
		threadLocalRequest.set((HttpServletRequest) request);
	    threadLocalResponse.set((HttpServletResponse) response);
	    chain.doFilter(request, response);
		
	}

	
    @Override
	public void destroy() {}
	@Override
	public void init(FilterConfig fCfg) throws ServletException {}

}
