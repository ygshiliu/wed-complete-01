package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		//从数据库中获取用户名与密码，并进行验证
		if("admin".equals(name) && "123123".equals(pwd)){
			//验证通过，表示成功登录，重定向login-success.html
			response.sendRedirect("login-success.html");
		}else{
			//否则，登录失败，转发到login-error.html
			request.getRequestDispatcher("login-error.html").forward(request, response);
		}
		
		
	}

}
