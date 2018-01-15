package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * Book相关的service层
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 上午10:50:50
 */
public interface BookService {
	/**
	 * 保存一本图书信息
	 * @param book
	 * @return
	 */
	public int saveBook(Book book);
	/**
	 * 删除一本图书信息
	 * @param id
	 * @return
	 */
	public int deleteBook(String id);
	/**
	 * 修改图书信息
	 * @param book
	 * @return
	 */
	public int updateBook(Book book);
	/**
	 * 根据id获取一本图书信息
	 * @param id
	 * @return
	 */
	public Book getBook(String id);
	/**
	 * 获取全部图书信息
	 * @return
	 */
	public List<Book> getAllBook();
	/**
	 * 分页相关的操作
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page<Book> findBook(String pageSize,String pageNo);
	/**
	 * 根据价格查询图书
	 * @param pageSize
	 * @param pageNo
	 * @param min
	 * @param max
	 * @return
	 */
	public Page<Book> findBookByPrice(String pageSize,String pageNo,String min,String max);
}
