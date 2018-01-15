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
 * @author Administrator
 *
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService us = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//对请求参数进行封装
		User user = new User(null,username,password,email);
		
		//调用用户业务层方法进行处理
		Boolean flag = us.regist(user);
		
		//根据返回结果返回不同的页面
		if(flag){
			//返回真，说明注册成功，重定向到首页
			response.sendRedirect(request.getContextPath()+"/index.html");
		}else{
			//如果为假，说明注册重复，转发到注册页面
			request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
		}
	}

}
