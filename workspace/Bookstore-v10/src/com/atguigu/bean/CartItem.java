package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 封装购物车中的购物项
 * @author Miss 王 
 * @version 创建时间：2017年2月23日 上午10:23:36
 */
public class CartItem implements Serializable{
	/**
	 * 购买的图书信息
	 */
	private Book book;
	/**
	 * 购买图书的总数据
	 */
	private int totalCount;
	/**
	 * 购买图书的总金额
	 * 需要通过计算获得
	 */
	//private double totalAmount;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 计算获得
	 * 公式：图书的价格*图书数量 = 图书总金额
	 * @return
	 */
	public double getTotalAmount() {
		//创建一个BigDecimal
		BigDecimal d1 = new BigDecimal(getBook().getPrice()+"");
		BigDecimal d2 = new BigDecimal(getTotalCount()+"");
		BigDecimal d3 = d1.multiply(d2);
		return d3.doubleValue();
	}
	
}
