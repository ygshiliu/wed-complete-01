package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderItem;

/**
 * 与orderItem表相关的操作
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午11:52:56
 */
public interface OrderItemDao {
	/**
	 * 保存订单项信息
	 * @param item
	 * @return
	 */
	int saveOrderItem(OrderItem item);
	/**
	 * 根据订单号获取订单项信息
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getOrderItemListByOrderId(String orderId);
	/**
	 * 批量保存订单项信息
	 * @param params
	 * @return
	 */
	int[] batchSave(Object[][] params);
}
