package com.atguigu.filter;

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
 * HttpFilter专门用来被其它Filter继承
 * @author Administrator
 *
 */
public abstract class HttpFilter implements Filter {
	
	private FilterConfig fConfig;
	
	public FilterConfig getfConfig() {
		return fConfig;
	}
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException ;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//将ServletRequest和ServletResponse进行强转成HttpServletRequest和HttpServletResopnse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		doFilter(req,resp,chain);
	}
	
	/**
	 * FilterConfig：封装的是web.xml中Filter标签中的信息
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		init();
	}
	
	public void init(){
		
	}

	public void destroy() {
	}
}
