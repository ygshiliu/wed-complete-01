package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

/**
 * BookDao的实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 上午10:09:11
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql = "insert into bs_books(title,author,price,sales,stock,img_path) "
				+ " values(?,?,?,?,?,?) ";
		return update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public int deleteBook(String id) {
		String sql = "delete from bs_books where id = ?";
		return update(sql, id);
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update bs_books set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
		return update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public Book getBook(String id) {
		String sql="select id,title,author,price,sales,stock,img_path imgPath from bs_books where id=?";
		return getBean(sql, id);
	}

	@Override
	public List<Book> getAllBook() {
		String sql="select id,title,author,price,sales,stock,img_path imgPath from bs_books";
		return getBeanList(sql);
	}

	@Override
	public Page<Book> findBook(Page<Book> page) {
		//获取图书表中的记录总条数
		String sql = "select count(*) from bs_books ";
		long amount =  (long) getSingleValue(sql);

		//将数据封装到page中
		page.setTotalRecord((int)amount);
		
		//获取图书分页信息
		sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_books order by id desc limit ?,? ";
		List<Book> list = getBeanList(sql, page.getIndex(),page.getPageSize());
		page.setList(list);
		
		return page;
	}

	@Override
	public Page<Book> findBookByPrice(Page<Book> page, int min, int max) {
		//获取图书表中的记录总条数
		String sql = "select count(*) from bs_books where price between ? and ?";
		long amount =  (long) getSingleValue(sql,min,max);

		//将数据封装到page中
		page.setTotalRecord((int)amount);
		
		//获取图书分页信息
		sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_books where price between ? and ? order by id desc limit ?,? ";
		List<Book> list = getBeanList(sql,min,max,page.getIndex(),page.getPageSize());
		page.setList(list);
		
		return page;
	}

	@Override
	public int[] batchUpdateSaleAndStock(Object[][] params) {
		String sql = "update bs_books set sales=?,stock=? where id=?";
		return batch(sql, params);
	}

}
