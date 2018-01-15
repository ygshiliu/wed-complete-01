package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.util.WEBUtils;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Servlet implementation class OrderClientServlet
 */
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderService os = new OrderServiceImpl();
	
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		
		//获取用户信息
		User user = (User) session.getAttribute("user");
		
		//检查用是否登录
		if(user == null){
			//没有登录
			response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
			return;
		}
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//正常处理订单
		String id = os.createOrder(cart, user);
		//将订单号保存到域中
		request.setAttribute("orderId", id);
		//转发到
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
	}

	protected void orderList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取用户信息
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//调用业务获取订单信息
		List<Order> list = os.getOrderListByUserId(user.getId());
		
		//将订单信息放入request域中
		request.setAttribute("orders", list);
		
		//转发
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		
	}
	protected void takeBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取订单编号
		String orderId = request.getParameter("orderId");
		//修改订单状态
		os.takeBook(orderId);
		//重定向到来源页
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}
	
	protected void orderInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取订单号
		String orderId = request.getParameter("orderId");
		//获取订单详情
		List<OrderItem> list = os.getOrderInfoByOrderId(orderId);
		//将订单详情设置进域 
		request.setAttribute("orderItems", list);
		//转发
		request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
		
	}
}
