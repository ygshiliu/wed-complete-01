package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * 与图书表相关的操作
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 上午10:04:21
 */
public interface BookDao {
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
	 * 获取图书分页显示数据
	 * @param page
	 * @return
	 */
	public Page<Book> findBook(Page<Book> page);
	/**
	 * 根据价格查询图书的分页操作
	 * @param page
	 * @param min
	 * @param max
	 * @return
	 */
	public Page<Book> findBookByPrice(Page<Book> page,int min,int max);
}
