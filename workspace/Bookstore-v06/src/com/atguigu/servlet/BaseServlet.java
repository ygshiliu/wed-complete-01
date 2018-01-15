package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 不处理具体请求，主要是提供给其它servlet继承的
 * 
 * @author Miss 王
 * @version 创建时间：2017年2月16日 下午3:59:58
 */
public class BaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//设置解码字符集
		request.setCharacterEncoding("utf-8");
		
		// 获取请求标识符
		String methodstr = request.getParameter("method");

		// 通过反射技术实现方法的调用
		Class class1 = this.getClass();
		try {
			// 获取方法对象
			Method method = class1.getDeclaredMethod(methodstr,
					HttpServletRequest.class, HttpServletResponse.class);
			// 设置方法对象的访问权限
			method.setAccessible(true);
			// 调用invoke方法执行目标方法
			method.invoke(this, request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
