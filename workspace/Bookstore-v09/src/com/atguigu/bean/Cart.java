package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装购物车信息
 * @author Miss 王 
 * @version 创建时间：2017年2月23日 上午10:22:26
 */
public class Cart implements Serializable{
	/**
	 * 保存购物项
	 */
	private Map<String,CartItem> map = new HashMap<>();
	/**
	 * 所有购物项总数量 
	 */
	//private int totalCount;
	/**
	 * 所有购物项的总金额
	 */
	//private double totalAmount;
	
	
	
	/**
	 * 获取所有购物项
	 * @return
	 */
	public List<CartItem> getCartItemList(){
		return new ArrayList(map.values());
	}
	

	public Map<String, CartItem> getMap() {
		return map;
	}


	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}


	/**
	 * 通过计算获得购物项总数量
	 * @return
	 */
	public int getTotalCount() {
		int count = 0;
		for(CartItem item:getCartItemList()){
			count += item.getTotalCount();
		}
		return count;
	}
	/**
	 * 通过计算获得购物项的总金额
	 * @return
	 */
	public double getTotalAmount() {
		//创建一个BigDecimal
		BigDecimal d1 = new BigDecimal("0.0");
		for(CartItem item:getCartItemList()){
			BigDecimal d2 = new BigDecimal(item.getTotalAmount()+"");
			d1 = d1.add(d2);
		}
		return d1.doubleValue();
	}
	/**
	 * 向购物车中添加一本图书
	 * @param book
	 */
	public void addBook2Cart(Book book){
		//先获取图书对应的购物项
		CartItem cartItem = map.get(book.getId()+"");
		//判断购物车中有没有图书对应的购物项
		if(cartItem == null){
			//购物车中还没有添加过此图书,需要创建购物项
			cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setTotalCount(1);
			
			//将购物项添加到购物车中
			map.put(book.getId()+"", cartItem);
		}else{
			//否则说明购物车有此购物项
//			int count = cartItem.getTotalCount();
//			cartItem.setTotalCount(count+1);
			cartItem.setTotalCount(cartItem.getTotalCount()+1);
		}
		
	}
	/**
	 * 删除购物车中的购物项
	 * @param bookId
	 */
	public void delCartItem(String bookId){
		map.remove(bookId);
	}
	/**
	 * 清空购物车
	 */
	public void clear(){
		map.clear();
	}
	/**
	 * 修改购物车某一个购物项的数量
	 * @param bookId
	 * @param count
	 */
	public void updateCount(String bookId,int count){
		//获取购物项
		CartItem cartItem = map.get(bookId);
		//修改购物项数量
		cartItem.setTotalCount(count);
	}
	
	
}
