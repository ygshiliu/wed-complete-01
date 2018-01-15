package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月25日 下午8:38:56
 */
public class AFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("1.AFilter拦截前。。。");
		//放行请求
		chain.doFilter(request, response);
		System.out.println("2.AFilter拦截后。。。");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
