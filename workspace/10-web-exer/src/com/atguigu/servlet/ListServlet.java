package com.atguigu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从数据库中获取学生列表数据
		List<Student> list =new ArrayList<>();
		list.add(new Student("哈哈", "男", "昌平"));
		list.add(new Student("Gary", "男", "海淀"));
		list.add(new Student("Jerry", "男", "朝阳"));
		list.add(new Student("Lucy", "女", "通州"));
		list.add(new Student("Marc", "男", "丰台"));
		
		//将数据放到域对象中
		//使用域对象有一个原则：能使用小的决不使用大的
		request.setAttribute("list", list);
		
		//通过转发方式传到JSP中
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
