package com.atguigu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
		
		//创建工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//获取解析器
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		try {
			//使用解析器解析request,获取多个部件 
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//准备图书详细信息
			Integer id=null;
			String title=null;
			String author=null;
			Double price=null;
			int sales=0;
			int stock=0;
			String imgPath = "/static/img/default.jpg";
			
			//准备接收请求来源
			String referer = null;
			
			//遍历多部件
			for(FileItem item:list){
				//判断表单项是普通表单项吗？
				if(item.isFormField()){
					//获取表单项的name属性名
					String name = item.getFieldName();
					//获取表单项的value值
					String value = item.getString("utf-8");
					
					//对数据进行摘取处理
					if("id".equals(name)){
						System.out.println(name+"--"+value);
						if(!value.equals("") && value != null){
							id=Integer.parseInt(value);
						}
					}else if("title".equals(name)){
						title=value;
					}else if("author".equals(name)){
						author=value;
					}else if("price".equals(name)){
						price=Double.parseDouble(value);
					}else if("sales".equals(name)){
						sales=Integer.parseInt(value);
					}else if("stock".equals(name)){
						stock=Integer.parseInt(value);
					}else if("referer".equals(name)){
						referer=value;
					}
					
				}else{
					//处理文件表单项
					//获取文件大小
					long size = item.getSize();
					if(size == 0){
						return;
					}
					//获取文件原名
					String name = item.getName();
					name = name.substring(name.lastIndexOf("\\")+1);
					imgPath = "/static/img/"+name;
			System.out.println(imgPath);		
					//获取物理路径
					String path = getServletContext().getRealPath("/static/img");
					//判断路径是否存在
					File file = new File(path);
					if(!file.exists()){
						file.mkdirs();
					}
					
							
					//将文件上传到服务器
					item.write(new File(path+"/"+name));
					
				}
				
			}
			//创建图书
			Book book = new Book(id, title, author, price, sales, stock,imgPath);
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
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
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
*/
}
