package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieServlet
 */
public class cookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有的cookie对象
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length >0){
			//对cookies进行遍历
			for(Cookie c:cookies){
				String name = c.getName();
				//找到JSESSIONID的cookie对象
				if("JSESSIONID".equals(name.toUpperCase())){
					//设置cookie的有效时间
					c.setMaxAge(60);
					//重新发送给浏览器
					response.addCookie(c);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
