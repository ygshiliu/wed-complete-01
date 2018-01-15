package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;

/**
 * 处理与订单相关的业务
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 下午2:07:42
 */
public interface OrderService {
	
	/**
	 * 处理订单，返回订单号
	 * @param session
	 * @return
	 */
	String createOrder(Cart cart ,User user);
	/**
	 * 根据用户id查找所有订单，提供给用户调用
	 * @param id
	 * @return
	 */
	List<Order> getOrderListByUserId(int id);
	/**
	 * 获取所有的订单信息，提供给管理员调用
	 */
	List<Order> getAllOrderList();
	
	/**
	 * 发货
	 * 将订单状态修改为1
	 * 管理员调用
	 * @param orderId
	 * @param state
	 */
	void sendbook(String orderId);
	/**
	 * 确认收货
	 * 将订单状态修改为2
	 * 用户调用
	 * @param orderId
	 * @param state
	 */
	void takeBook(String orderId);
	/**
	 * 获取当前订单所有的订单项
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getOrderInfoByOrderId(String orderId);
}
