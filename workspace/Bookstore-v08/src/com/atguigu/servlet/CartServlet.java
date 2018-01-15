package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.WEBUtils;

/**
 * 购物车相关请求的servlet
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();

	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String bookId = request.getParameter("bookId");
		//获取图书
		Book book = bs.getBook(bookId);
		
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		
		//将图书添加到购物车中
		cart.addBook2Cart(book);

		//获取请求的来源
		String referer = request.getHeader("referer");
		
		//设置图书名称到session域中
		HttpSession session = request.getSession();
		session.setAttribute("title", book.getTitle());
		//重定向到index.jsp
		response.sendRedirect(referer);
		
	}
	
	protected void updateCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		
		//获取请求参数
		String count = request.getParameter("count");
		String bookId = request.getParameter("bookId");
		
		//修改购物项的数量 
		cart.updateCount(bookId, Integer.parseInt(count));
		
		//重定向到来源页
		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
		
	}
	protected void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//清空购物车
		cart.clear();
		//获取请求来源
		String referer = request.getHeader("referer");
		//重定向
		response.sendRedirect(referer);
	}
	protected void delCartItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取图书id
		String bookId = request.getParameter("bookId");
		
		//获取购物车
		Cart cart = WEBUtils.getCart(request);
		//删除购物项
		cart.delCartItem(bookId);
		
		//获取请求来源
		String referer = request.getHeader("referer");
		
		//重定向
		response.sendRedirect(referer);
		
		
	}

}
