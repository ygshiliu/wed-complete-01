package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.json.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向控制台输入一条信息
		System.out.println("接收到ajax请求....");
		
		//接收请求参数
		String name = request.getParameter("name");
		System.out.println(name);
		
		//响应一个文本信息
		//response.getWriter().print("hello Ajax");
		
		//响应JSon
		User user = new User("刘在石", 45, "12312315467");
		Gson gson = new Gson();
		String json = gson.toJson(user);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向控制台输出一条信息
		System.out.println("接收到Post请求");
		
		//获取请求参数
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+"--"+password);
		
		//响应一个文本信息
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter().print("你好，浏览器");
		
		//若响应多个信息,比如user
		/**
		 * <user>
		 * 	<name>haha</name>
		 * 	<age>16</age>
		 * 	<sex>男</sex>
		 * </user>
		 */
	/*	
		response.setContentType("text/xml;charset=utf-8");
	    PrintWriter out = response.getWriter();
		out.println("<user>");
		out.println("<name>haha</name>");
		out.println("<age>16</age>");
		out.println("<sex>男</sex>");
		out.println("</user>");*/
		
//		response.getWriter().print("{\"name\":\"haha\",\"sex\":\"男\",	\"age\":16,\"istuanyuan\":false,\"address\":{\"city\":\"北京\",\"street\":\"北七街\"},	\"hobby\":[\"lq\",\"zq\"]}");
		
		User user = new User("李光洙", 30, "123145655");
		//创建Gson 
		Gson gson = new Gson();
		//将对象转成json字符串
		String json = gson.toJson(user);
		System.out.println(json);
		
		//响应ajax
		response.getWriter().print(json);
	}

}
