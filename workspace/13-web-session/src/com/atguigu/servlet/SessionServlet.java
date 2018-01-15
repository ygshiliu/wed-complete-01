package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建session对象
		//是在第一次调用getSession()时才会被创建
		HttpSession session = request.getSession();
		
		//将数据保存到session中
		session.setAttribute("username", "Jerry");
		
		//获取session的id
		String id = session.getId();
		
		//向页面输出id
		PrintWriter out = response.getWriter();
		out.print("<h1>"+id+"</h1>");
		
	}


}
