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
       
	private CityDao cityDao = new CityDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		//根据省份id返回城市信息
		//获取省份id
		String pid = request.getParameter("pid");
		//查询城市信息
		List<City> list = cityDao.getCityByProId(pid);
		//转换为JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		//将json作为响应发送
		response.getWriter().print(json);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
