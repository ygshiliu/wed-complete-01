package com.atguigu.bean;
/**
 * 封装订单项的信息
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午10:31:32
 */
public class OrderItem {
	/**
	 * 订单项编号 
	 */
	Integer id;
	/**
	 * 书名
	 */
	String title;
	/**
	 * 作者
	 */
	String author;
	/**
	 * 单价
	 */
	double price;
	/**
	 * 封面
	 */
	String imgPath;
	/**
	 * 订单项数量
	 */
	int totalCount;
	/**
	 * 订单项金额
	 */
	double totalAmount;
	/**
	 * 隶属订单号
	 */
	String orderId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderItem(Integer id, String title, String author, double price,
			String imgPath, int totalCount, double totalAmount, String orderId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.imgPath = imgPath;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.orderId = orderId;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", title=" + title + ", author="
				+ author + ", price=" + price + ", imgPath=" + imgPath
				+ ", totalCount=" + totalCount + ", totalAmount=" + totalAmount
				+ ", orderId=" + orderId + "]";
	}
	
}
