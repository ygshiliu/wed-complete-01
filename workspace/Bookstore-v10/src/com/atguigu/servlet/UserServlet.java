package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	protected void checkUsername(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		String username = request.getParameter("username");
		//检查用户
		boolean flag = us.checkUsername(username);
		
		if(flag){
			//如果为真，说明此用户名可以使用
			response.getWriter().print(0);
		}else{
			//否则说明此用户名已经被使用
			response.getWriter().print(1);
		}
	}
	
	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取session对象
		HttpSession session = request.getSession();
		session.invalidate();
		
		//重定向到index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		User user = WEBUtils.params2Bean(request, new User());
		
		// 调用业务逻辑方法
		User login = us.login(user);
		
		// 根据结果返回页面
		if (login != null ) {
			//将用户信息保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
			
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
		
		User user = WEBUtils.params2Bean(request, new User());

		//获取请求参数中的验证码
		String code = request.getParameter("code");
		//获取session中的验证码
		HttpSession session = request.getSession();
		String code1 = (String) session.getAttribute("code");
		//移除session中的验证码
		session.removeAttribute("code");
		
		if(!(code1 != null && code1.equals(code))){
			// 设置错误信息
			request.setAttribute("msg", "请不要重复提交信息！");
			// 如果为假，说明注册重复，转发到注册页面
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(
					request, response);
			return;
		}
		
		// 调用用户业务层方法进行处理
		Boolean flag = us.regist(user);

		// 根据返回结果返回不同的页面
		if (flag) {
			// 返回真，说明注册成功，重定向到首页
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(
					request, response);
		} else {
			// 设置错误信息
			request.setAttribute("msg", "用户名重复，请重新输入！");
			// 如果为假，说明注册重复，转发到注册页面
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(
					request, response);
		}
	}

}
