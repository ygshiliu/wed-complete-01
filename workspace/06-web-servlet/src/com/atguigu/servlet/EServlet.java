package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 请求报文格式：
		 * 	请求首部	
		 * 		请求首行
		 * 		请求头
		 *  空行
		 *  请求体
		 *  
		 *  
		 * HttpServletRequest：
		 * 【代表】封装了浏览器发送给服务器的请求报文
		 * 【获取】由服务器创建并作为参数传递给doGet与doPost方法
		 * 【功能】
		 * 		1、获取请求参数
		 * 		2、可以用来获取项目名
		 * 		3、本身就是一个域对象，可以在不同的web资源中共享数据
		 * 		4、可以发起请求的转发
		 * 
		 * 所谓的转发，就是当servlet收到请求后并没有直接处理，而交给服务器中的其它资源来处理
		 * 
		 * 转发的特点：
		 * 		浏览器地址栏没有变化 
		 * 		浏览器发送了1次请求
		 * 		浏览器感知不到转发的发生
		 * 		转发是发生在服务器端
		 * 	
		 */
		//1、获取请求参数
		String name = request.getParameter("name");
		//System.out.println(name);
		
		//2、可以用来获取项目名
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		//4、可以发起请求的转发
		//获取派发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 响应报文格式：
		 * 响应首部
		 * 		响应首行
		 * 		响应头
		 * 空行
		 * 响应体
		 * 
		 * 
		 * HttpServletResponse：
		 * 【代表】封装了服务器发送给浏览器的响应报文
		 * 【获取】由服务器创建，并作为参数传递给doGet与doPost方法，我们可以直接使用
		 * 【功能】
		 * 		1、可以向浏览器输出一个页面或页面片段
		 * 		2、可以实现请求的重定向
		 * 
		 * 重定向：当servlet收到请求后，会向浏览器发送一个特殊的响应
		 * 		这个特殊的响应告诉 浏览器再向另一个url地址发送请求
		 * 	
		 *  HTTP/1.1 302 Found
			Location: http://localhost:8080/06-web-servlet/index.html
			
		 * 通过观察重定向会向浏览器返回一个状态码302，还有一个Location响应头指向一个新的地址
		 * 浏览器收到响应状态码302后会重新向location指向的地址发送请求
		 * 
		 * 重定向的特点：
		 * 	浏览器发送了2次请求
		 *  发生在浏览器端
		 *  浏览器地址栏有变化 
		 *  浏览器有感知
		 * 
		 */
		
		//1、可以向浏览器输出一个页面或页面片段
		PrintWriter out = response.getWriter();
		//out.print("Hello Client");
//		out.print("<!DOCTYPE html>");
//		out.print("<html>");
		
		
		//2、可以实现请求的重定向
		response.sendRedirect("index.html");
	}

}
