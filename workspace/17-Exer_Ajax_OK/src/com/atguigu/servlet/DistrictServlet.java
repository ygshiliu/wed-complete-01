package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.City;
import com.atguigu.bean.District;
import com.atguigu.dao.DistrictDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DistrictServlet
 */
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DistrictDao districtDao = new DistrictDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		//根据城市id返回区县信息
		//获取省份id
		String cid = request.getParameter("cid");
		//查询区县信息
		List<District> list = districtDao.getListByCityId(cid);
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
