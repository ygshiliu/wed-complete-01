package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Aservlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 * ServletConfig：
		 * 【代表】代表的是当前servlet在web.xml中servlet标签的配置信息
		 * 		也就是说，每一个servlet都有它唯一对应的servletConfig对象
		 * 【获取】它是由服务器创建，并作为参数传递给init方法，我们可以直接使用
		 * 【功能】
		 * 		1、获取servlet名子
		 * 		2、获取servlet的初始化参数
		 * 		3、获取 项目中最大的域对象：ServletContext
		 * 		   域对象的作用就是用来在不同的web资源中共享数据 
		 * 
		 */
		
		//获取servlet名子
//		String name = config.getServletName();
//		System.out.println(name);
		
		//获取servlet的初始化参数
//		String name = config.getInitParameter("name");
//		String pwd = config.getInitParameter("password");
//		System.out.println(name+"--"+pwd);
		
		//获取 项目中最大的域对象：ServletContext
		ServletContext context = config.getServletContext();
		System.out.println(context);
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
