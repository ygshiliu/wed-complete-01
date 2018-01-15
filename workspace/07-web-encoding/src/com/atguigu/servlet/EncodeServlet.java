package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//需要手动设置字符集，服务器默认字符集iso8859-1
		request.setCharacterEncoding("utf-8");
		
		//获取请求参数信息
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		
		
		//向控制台输出参数信息
		System.out.println(name+"--"+sex+"--"+age);
		
		//设置服务器字符集
		//response.setCharacterEncoding("utf-8");
		//设置响应头
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		//向浏览器输出信息
		PrintWriter out = response.getWriter();
		out.print(name);
		out.print(sex);
		out.print(age);
		
		
	}

}
