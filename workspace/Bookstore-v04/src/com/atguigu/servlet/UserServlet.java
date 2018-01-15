package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.WEBUtils;

/**
 * 用户相关操作的servlet
 * 
 * @author Administrator
 *
 */
public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	private UserService us = new UserServiceImpl();

	/*protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取请求标识符
		String methodstr = request.getParameter("method");
		
		//通过反射技术实现方法的调用
		Class class1 = this.getClass();
		try {
			//获取方法对象
			Method method = class1.getDeclaredMethod(methodstr, HttpServletRequest.class,HttpServletResponse.class);
			//设置方法对象的访问权限
			method.setAccessible(true);
			//调用invoke方法执行目标方法
			method.invoke(this, request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据标识符调用不同的方法
		if ("login".equals(method)) {
			login(request, response);
		} else if ("regist".equals(method)) {
			regist(request, response);
		} else if ("addBook".equals(method)) {
			// addBook(request,response);
		} else if ("deleteBook".equals(method)) {
			// deleteBook(request, response);
		}

	}*/

	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		User user = WEBUtils.params2Bean(request, new User());
		
		/*// 获取从页面传来的请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 对请求参数进行封装
		User user = new User(null, username, password, null);*/

		// 调用业务逻辑方法
		User login = us.login(user);

		// 根据结果返回页面
		if (login != null) {
			// 登录成功，重定向到login_success.html、
			response.sendRedirect(request.getContextPath()
					+ "/pages/user/login_success.jsp");
		} else {
			// 设置错误信息
			request.setAttribute("msg", "用户名或密码不正确！");
			// 失败，转发到login.html
			request.getRequestDispatcher("/pages/user/login.jsp").forward(
					request, response);
		}
	}

	protected void regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	/*	// 获取请求参数信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// 对请求参数进行封装
		User user = new User(null, username, password, email);*/
		
		User user = WEBUtils.params2Bean(request, new User());
		
		// 调用用户业务层方法进行处理
		Boolean flag = us.regist(user);

		// 根据返回结果返回不同的页面
		if (flag) {
			// 返回真，说明注册成功，重定向到首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			// 设置错误信息
			request.setAttribute("msg", "用户名重复，请重新输入！");
			// 如果为假，说明注册重复，转发到注册页面
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(
					request, response);
		}
	}

}
