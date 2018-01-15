package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

/**
 * 与订单表相关的操作
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午11:16:21
 */
public interface OrderDao {
	
/*	Int saveOrder(Order order) 保存订单信息
	Int updateState(String orderId,int state) 修改指定订单的状态
	Order getOrderListByUserId(int userid) 根据用户id获取订单信息，提供给用户使用
	List<Order> getAllOrderList() 获取全部订单，提供给管理员使用*/
	/**
	 * 保存订单信息
	 * @param order
	 * @return
	 */
	int saveOrder(Order order);
	/**
	 * 修改订单的状态
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updateState(String orderId,int state);
	/**
	 * 根据用户名获取订单信息
	 * 提供给用户使用
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(int userId);
	/**
	 * 获取全部订单信息
	 * 提供给管理员使用
	 * @return
	 */
	List<Order> getAllOrderList();
}
