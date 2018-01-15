package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Province;
import com.atguigu.dao.ProvinceDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class ProvinceServlet
 */
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProvinceDao provinceDao = new ProvinceDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码为中文
		response.setContentType("text/html;charset=utf-8");
		//查询所有的省信息
		List<Province> list = provinceDao.getProvinceList();
		//将list转换为JSON字符串
		Gson gson = new Gson();
		String proStr = gson.toJson(list);
		//发送包含省份信息的JSON字符串
		response.getWriter().print(proStr);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
