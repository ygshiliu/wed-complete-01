package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

/**
 * BookService接口的实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 上午10:52:03
 */
public class BookServiceImpl implements BookService {
	
	private BookDao bd = new BookDaoImpl();

	@Override
	public int saveBook(Book book) {
		return bd.saveBook(book);
	}

	@Override
	public int deleteBook(String id) {
		return bd.deleteBook(id);
	}

	@Override
	public int updateBook(Book book) {
		return bd.updateBook(book);
	}

	@Override
	public Book getBook(String id) {
		return bd.getBook(id);
	}

	@Override
	public List<Book> getAllBook() {
		return bd.getAllBook();
	}

	@Override
	public Page<Book> findBook(String pageSize, String pageNo) {
		//设置初始值 
		int pSize = 4;
		int pNo = 1;
		
		try {
			pSize = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {}
		
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {}
		
		//为dao层准备page类
		Page<Book> page = new Page<Book>();
		page.setPageNo(pNo);
		page.setPageSize(pSize);
		
		//调用dao层
		return bd.findBook(page);
	}

	@Override
	public Page<Book> findBookByPrice(String pageSize, String pageNo, String min,
			String max) {
		//设置初始值 
		int pSize = 4;
		int pNo = 1;
		int pmin = 0;
		int pmax = Integer.MAX_VALUE;
		
		try {
			pSize = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {}
		
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {}
		
		try {
			pmin = Integer.parseInt(min);
		} catch (NumberFormatException e) {}
		
		try {
			pmax = Integer.parseInt(max);
		} catch (NumberFormatException e) {}
		
		
		
		//为dao层准备page类
		Page<Book> page = new Page<Book>();
		page.setPageNo(pNo);
		page.setPageSize(pSize);
		
		//调用dao层
		return bd.findBookByPrice(page, pmin, pmax);
	}

}
