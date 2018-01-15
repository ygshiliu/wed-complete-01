package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.District;
import com.atguigu.dao.DistrictDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DistrictServlet
 */
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DistrictDao dd = new DistrictDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取城市id
		String cid = request.getParameter("cid");
		
		//获取区县
		List<District> list = dd.getListByCityId(cid);
		
		//转成json字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		//响应
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
