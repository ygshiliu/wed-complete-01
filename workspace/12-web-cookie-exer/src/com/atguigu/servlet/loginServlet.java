package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//去数据库根据用户名查询密码
		//如果查询到的密码与输入的密码一致，表示登录成功
		if("123123".equals(password)){
			//在服务器里创建cookie对象
			Cookie cookie = new Cookie("username", username);
			Cookie cookie2 = new Cookie("password", password);
			
			//设置cookie的有效时间
			cookie.setMaxAge(60*2);
			
			//将cookie发送给浏览器
			response.addCookie(cookie);
			response.addCookie(cookie2);
			
			//重定向
			response.sendRedirect(request.getContextPath()+"/login_success.jsp");
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
