package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Order;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;

/**
 * OrderDao的实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午11:22:13
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql = "insert into bs_orders (id,create_date,state,total_count,total_amount,user_id )"
				+ " values (?,?,?,?,?,?)";
		return update(sql, order.getId(),order.getCreateDate(),order.getState(),order.getTotalCount(),order.getTotalAmount(),order.getUserId());
	}

	@Override
	public int updateState(String orderId, int state) {
		String sql = "update bs_orders set state=? where id = ?";
		return update(sql, state,orderId);
	}

	@Override
	public List<Order> getOrderListByUserId(int userId) {
		String sql = "select id,create_date createDate,state,total_count totalCount,total_amount totalAmount,user_id userId  from bs_orders where user_id = ? order by create_date desc";
		return getBeanList(sql, userId);
	}

	@Override
	public List<Order> getAllOrderList() {
		String sql = "select id,create_date createDate,state,total_count totalCount,total_amount totalAmount,user_id userId  from bs_orders order by create_date desc";
		return getBeanList(sql);
	}

}
