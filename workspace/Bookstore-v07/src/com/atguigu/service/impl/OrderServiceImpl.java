package com.atguigu.service.impl;

import java.util.Date;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderService;

/**
 * OrderService实现 类
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 下午2:09:42
 */
public class OrderServiceImpl implements OrderService {
	
	private OrderDao od = new OrderDaoImpl();
	private OrderItemDao oid = new OrderItemDaoImpl();
	private BookDao bd = new BookDaoImpl();

	@Override
	public String createOrder(Cart cart,User user) {
		
		//1）处理购物车中的商品信息，保存到数据库
		//订单号规则：时间戳+用户id
		String id = System.currentTimeMillis()+""+user.getId();
		//订单的生成日期
		Date createDate = new Date();
		//本次订单的总数量 
		int totalCount = cart.getTotalCount();
		//本次订单的总金额
		double totalAmount = cart.getTotalAmount();
		//生成订单
		Order order = new Order(id, createDate, 0, totalCount, totalAmount, user.getId());
		//将订单保存到数据库
		od.saveOrder(order);
		
		//将订单的订单项保存到数据库中
		//获取商品信息
		List<CartItem> list = cart.getCartItemList();
		//定义保存orderItem和book数据的二维数据 
		Object[][] itemParams = new Object[list.size()][];
		Object[][] bookParams = new Object[list.size()][];
		
		for(int i = 0;i<list.size();i++){
			//获取购物项
			CartItem item = list.get(0);
			//获取图书
			Book book = item.getBook();
			
			//获取书名
			String title = book.getTitle();
			//获取作者
			String author = book.getAuthor();
			//获取图书单价
			Double price = book.getPrice();
			//获取图书封面
			String imgPath = book.getImgPath();
			//获取单品种图书的总量
			int totalCount2 = item.getTotalCount();
			//获取单品种图书的总金额
			double totalAmount2 = item.getTotalAmount();
			
			//封装单个购物项信息
			//title,author,price,img_path,total_count,total_amount,order_id
			itemParams[i] = new Object[]{title,author,price,imgPath,totalCount2,totalAmount2,id};
			
			//对图书的库存和销量进行修改
			//获取图书库存
			int stock = book.getStock();
			//获取图书销量
			int sales = book.getSales();
			//对图书的库存我销量进行封装
			//sales=?,stock=? where id=?
			bookParams[0] = new Object[]{sales+totalCount2,stock-totalCount2,book.getId()};
			
		}
		
		//对订单项进行批量保存处理
		oid.batchSave(itemParams);
		
		//对图书进行批量修改处理
		bd.batchUpdateSaleAndStock(bookParams);
		
/*		for(CartItem item:list){
			Book book = item.getBook();
			//获取书名
			String title = book.getTitle();
			//获取作者
			String author = book.getAuthor();
			//获取图书单价
			Double price = book.getPrice();
			//获取图书封面
			String imgPath = book.getImgPath();
			//获取单品种图书的总量
			int totalCount2 = item.getTotalCount();
			//获取单品种图书的总金额
			double totalAmount2 = item.getTotalAmount();
			//创建订单项
			OrderItem orderItem = new OrderItem(null, title, author, price, imgPath, totalCount2, totalAmount2, id);
			
			//将订单项保存到数据库中
			oid.saveOrderItem(orderItem);
			
			//2）修改图书的销量与库存数量 
			book.setSales(book.getSales()+totalCount2);
			book.setStock(book.getStock()-totalCount2);
			bd.saveBook(book);
		}
		*/
		//3）清空购物车
		 cart.clear();
		//4）返回订单号
		return id;
	}

	@Override
	public List<Order> getOrderListByUserId(int id) {
		List<Order> list = od.getOrderListByUserId(id);
		return list;
	}

	@Override
	public List<Order> getAllOrderList() {
		List<Order> list = od.getAllOrderList();
		return list;
	}

	@Override
	public void sendbook(String orderId) {
		od.updateState(orderId, 1);
	}

	@Override
	public void takeBook(String orderId) {
		od.updateState(orderId, 2);
	}

	@Override
	public List<OrderItem> getOrderInfoByOrderId(String orderId) {
		List<OrderItem> list = oid.getOrderItemListByOrderId(orderId);
		return list;
	}

}
