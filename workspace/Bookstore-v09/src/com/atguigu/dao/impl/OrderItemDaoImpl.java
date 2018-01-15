package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

/**
 * OrderItemDao实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午11:58:29
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements
		OrderItemDao {

	@Override
	public int saveOrderItem(OrderItem item) {
		String sql = "insert into bs_orderItems (title,author,price,img_path,total_count,total_amount,order_id) "
				+ " values (?,?,?,?,?,?,?)";
		return update(sql, item.getTitle(),item.getAuthor(),item.getPrice(),item.getImgPath(),item.getTotalCount(),item.getTotalAmount(),item.getOrderId());
	}

	@Override
	public List<OrderItem> getOrderItemListByOrderId(String orderId) {
		String sql = "select id,title,author,price,img_path imgPath,total_count totalCount,total_amount totalAmount,order_id orderId "
				+ " from bs_orderItems where order_id = ?";
		return getBeanList(sql, orderId);
	}

	@Override
	public int[] batchSave(Object[][] params) {
		String sql = "insert into bs_orderItems(title,author,price,img_path,total_count,total_amount,order_id) "
				+ " values (?,?,?,?,?,?,?)";
		return batch(sql, params);
	}

}
