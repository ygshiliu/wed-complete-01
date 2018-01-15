package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionServlet
 */
public class sessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getClass());
		HttpSession session = request.getSession();
		System.out.println(session.getClass());
		System.out.println(session.getId());
		Cookie cookie = new Cookie("JSESSIONID", "1F220F8A5B3E15278E428C3C6EFE8F45");
		response.addCookie(cookie);
	}


}
