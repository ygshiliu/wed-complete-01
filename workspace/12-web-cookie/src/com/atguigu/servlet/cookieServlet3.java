package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieServlet3
 */
public class cookieServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个cookie对象
		Cookie goods = new Cookie("goods", "shirt");
		
		/**
		 * cookie默认的有效时间是一次会话
		 * 可以通过setMaxAge设置有效时间后，响应头会变成如下：
		 * Set-Cookie: goods=shirt; Expires=Mon, 20-Feb-2017 09:09:21 GMT
		 * 
		 */
		//指定一个正整，代表有效时间长度，单位是秒
		//goods.setMaxAge(60);
		
		//当设置值 为0时，响应头过期时间会设置成：Set-Cookie: goods=shirt; Expires=Thu, 01-Jan-1970 00:00:10 GMT
		//表示立即失效
		//goods.setMaxAge(0);
		
		//设置一个负值
		//响应头与不设置是一样的：Set-Cookie: goods=shirt
		//表示有效时间为一次会话
		goods.setMaxAge(-5);
		
		//交给浏览器
		response.addCookie(goods);
	}


}
