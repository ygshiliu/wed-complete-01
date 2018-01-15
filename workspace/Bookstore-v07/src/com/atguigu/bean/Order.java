package com.atguigu.bean;

import java.util.Date;


/**
 * 用来封装订单信息的类
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午10:26:02
 */
public class Order {
	/**
	 * 订单编号
	 */
	String id;
	/**
	 * 订单生成日期
	 */
	Date createDate;
	/**
	 * 订单状态
	 * 0未发货
	 * 1已发货
	 * 2交易完成
	 */
	int state;
	/**
	 * 订单总数量 
	 */
	double totalCount;
	/**
	 * 订单总金额
	 */
	double totalAmount;
	/**
	 * 订单所属用户
	 */
	int userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Order(String id, Date createDate, int state, double totalCount,
			double totalAmount, int userId) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.state = state;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", createDate=" + createDate + ", state="
				+ state + ", totalCount=" + totalCount + ", totalAmount="
				+ totalAmount + ", userId=" + userId + "]";
	}
	
	
	
}
