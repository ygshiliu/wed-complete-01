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
    //创建省dao
	private ProvinceDao pd = new ProvinceDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从数据库中获取省份
		List<Province> list = pd.getProvinceList();
		//创建gson
		Gson gson = new Gson();
		//将省份转成json字符串
		String json = gson.toJson(list);
		System.out.println(json);
		//响应
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
