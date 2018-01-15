package com.atguigu.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 用户登录相关的servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取从页面传来的请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//对请求参数进行封装
		User user = new User(null, username, password, null);
		
		//调用业务逻辑方法
		User login = us.login(user);
		
		//根据结果返回页面
		if(login != null){
			//登录成功，重定向到login_success.html、
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
		}else{
			//失败，转发到login_error.html
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}
	}

}
