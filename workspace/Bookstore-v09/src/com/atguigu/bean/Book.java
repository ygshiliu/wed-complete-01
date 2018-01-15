package com.atguigu.bean;

import java.io.Serializable;

/**
 * 封装与图书相关的信息
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 上午9:53:56
 */
public class Book implements Serializable{
	
	private Integer id;
	/**
	 * 书名
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 销量
	 */
	private int sales;
	/**
	 * 库存
	 */
	private int stock;
	/**
	 * 图书封面路径
	 */
	private String imgPath = "/static/img/default.jpg";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String title, String author, Double price,
			int sales, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", sales=" + sales + ", stock=" + stock
				+ ", imgPath=" + imgPath + "]";
	}
	
	
}
