package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.WEBUtils;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs = new BookServiceImpl();
	protected void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		
		String path = WEBUtils.getPath(request);
		
		//获取图书信息
		Page<Book> page = bs.findBook(pageSize, pageNo);
		page.setPath(path);
		
		//将page设置到域对象中
		request.setAttribute("page", page);
		
		//转发到页面
		request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
		
	}
	/**
	 * 根据价格查找图书
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findBookByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		
		//获取请求路径
		String path = WEBUtils.getPath(request);
		
		//获取图书信息
		Page<Book> page = bs.findBookByPrice(pageSize, pageNo, min, max);
		page.setPath(path);
		
		//将page设置到域对象中
		request.setAttribute("page", page);
		
		//转发到页面
		request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
	}
		

}
