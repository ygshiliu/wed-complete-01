package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		String username = request.getParameter("username");
		/**
		 * 如何判断用户是否登录？
		 * 可以将用户信息放入一个域对象中，然后判断域对象中有没有用户信息，如果有说明登录，如果没有说明没有登录
		 * 通常情况是将用户的信息放在session域中，来验证用户是否登录
		 */
		//获取session对象
		HttpSession session = request.getSession();
		
		//将用户信息放到域中
		session.setAttribute("user", username);
		
		//重定向到index.jsp
		response.sendRedirect("index.jsp");
	}

}
