package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 创建Filter步骤：
 * 1、创建一个类来实现Filter接口
 * 2、需要在web.xml中进行注册
 * @author Miss 王 
 * @version 创建时间：2017年2月25日 下午7:54:00
 */
public class HelloFilter implements Filter {
	
	public HelloFilter() {
		System.out.println("构造器被调用。。");
	}
	
	/**
	 * FilterConfig：封装的是web.xml中Filter标签中的信息
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String name = fConfig.getInitParameter("username");
		System.out.println(name);
		System.out.println("init方法被调用。。");
	}
	/**
	 * Filter的功能：
	 * 1、可以拦截请求
	 * 2、放行请求
	 * 3、可以对响应做预处理
	 * 
	 * ServletRequest：请求报文
	 * ServletResponse：响应报文
	 * FilterChain：作用就是用来放行请求，通过调用doFilter()实现 
	 * 		调用doFilter()方法有两种情况：
	 * 		第1种当前过滤器后没有其它过滤器时，doFilter()方法调用的就是目标资源的service()
	 * 		第2种：当前过滤器后面还有其它过滤器时，doFilter()方法调用的就是下一个过滤器的doFilter()
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
/*		System.out.println("拦截index.jsp");
		//放行请求
		chain.doFilter(request, response);
		//对响应做预处理
		response.getWriter().print("Hello index!");*/
		
		System.out.println("doFilter方法被调用。。");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy方法被调用。。");
	}

}
