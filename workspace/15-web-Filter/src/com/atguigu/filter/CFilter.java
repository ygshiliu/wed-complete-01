package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月25日 下午9:56:15
 */
public class CFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("被CFilter拦截。。。");
		chain.doFilter(request, response);
	}

}
