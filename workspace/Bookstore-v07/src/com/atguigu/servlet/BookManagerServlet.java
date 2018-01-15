package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.WEBUtils;

/**
 * 图书相关请求的servlet
 * Servlet implementation class BookManagerServlet
 */
public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bs = new BookServiceImpl();
	
	/**
	 * 图书分页相关的处理请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求参数信息
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		//调用service层进行业务处理
		Page<Book> page = bs.findBook(pageSize, pageNo);
		
		//获取请求路径
		String path = WEBUtils.getPath(request);
		
		//将路径设置进page
		page.setPath(path);
		
		//将page放到域中
		request.setAttribute("page", page);
		
		//通过转发的方法访问book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	/**
	 * 查看所有图书的请求
	 */
	protected void bookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取所有的图书信息
		List<Book> list = bs.getAllBook();
		
		//将图书信息放到域里
		request.setAttribute("list", list);
		
		//通过转发的方式访问页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	/**
	 * 添加图书的请求
	 */
	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		//以请求参数进行封装
		Book book = WEBUtils.params2Bean(request, new Book());
		
		//调用service层进行保存图书信息
		bs.saveBook(book);
		
		//重定向到book_manager.jsp
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=bookList");
	}
	/**
	 * 删除图书的请求
	 */
	protected void delBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取图书id
		String id = request.getParameter("id");
		
		//获取请求来源
		String referer = request.getHeader("referer");
		System.out.println(referer);
		
		//调用业务层方法
		bs.deleteBook(id);
		
		//重定向到图书列表
		//response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=findBook");
		response.sendRedirect(referer);
	}
	/**
	 * 转发编辑图书页面请求
	 */
	protected void toUpdateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取图书的id
		String id = request.getParameter("id");
		
		//根据id调用service层来获取图书信息
		Book book = bs.getBook(id);
		
		//将图书放到域对象中
		request.setAttribute("book", book);
		
		//通过转发的形式去book_edit.jsp页面
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
		
	}
	/**
	 * 添加 或 修改图书的请求
	 */
	protected void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求头referer
		String referer = request.getParameter("referer");
		
		//获取请求参数
		Book book = WEBUtils.params2Bean(request, new Book());
		System.out.println(book);
		//根据book的id属性值来判断添加或修改功能
		//如果有id值 ，说明是修改功能
		if(book.getId() != null && book.getId() != 0){
			bs.updateBook(book);
			//从哪来的回哪去
			response.sendRedirect(referer);
		}else{
			bs.saveBook(book);
			//重定向到图书列表 
			response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=findBook");
		}
		
	}

}
