package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Bservlet implements Servlet {
	
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		/*
		 * ServletContext:它封装了整个web应用的所有配置信息
		 * 【代表】它封装了整个web应用的所有配置信息，说明一个web项目有且仅有一个ServletContext对象
		 * 【获取】通过servletConfig对象获取
		 * 【功能】
		 * 		1、获取web应用的初始化参数 
		 * 		2、用来获取资源的真实路径
		 * 			虚拟路径：http://localhost:8080/06-web-servlet/Bservlet
		 * 			真实路径：D:\workspace\0816\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\06-web-servlet\index.html
		 * 		3、是一个域对象，可以用来在不同的web资源中共享数据
		 */
		//获取servletContext对象
		ServletContext context = config.getServletContext();
		//1、获取web应用的初始化参数 
//		String name = context.getInitParameter("user");
//		String pwd = context.getInitParameter("pwd");
//		System.out.println(name+"--"+pwd);
		
		//用来获取资源的真实路径
		String path = context.getRealPath("index.html");
		System.out.println(path);
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
