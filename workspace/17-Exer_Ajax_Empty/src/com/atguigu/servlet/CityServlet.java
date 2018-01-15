package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.City;
import com.atguigu.dao.CityDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CityDao cd = new CityDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取省份id
		String pid = request.getParameter("pid");
		
		//获取城市数据 
		List<City> list = cd.getCityByProId(pid);
		
		//转json
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		//响应
		//设置响应头
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
