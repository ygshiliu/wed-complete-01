package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器创建cookie
		Cookie cookie = new Cookie("username", "Tom");
		Cookie cookie2 = new Cookie("password","123123");
		//将cookie交给浏览器
		//服务器会在响应头中设置   Set-Cookie: username=Tom
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
