package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService os = new OrderServiceImpl();
	
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取订单信息
		List<Order> list = os.getAllOrderList();
		//将订单信息放入域中
		request.setAttribute("orders", list);
		//转发
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
	
	protected void sendBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取订单编号
		String orderId = request.getParameter("orderId");
		//修改订单状态
		os.sendbook(orderId);
		//重定向到来源页
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
}
