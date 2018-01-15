package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Cservlet extends MyGenericServlet{
	
	@Override
	public void init(){
		System.out.println("init初始人操作。。。");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//System.out.println("CServlet!!");
		
		//获取 servletContext对象
		ServletContext context = getServletContext();
		System.out.println(context);
	}

}
