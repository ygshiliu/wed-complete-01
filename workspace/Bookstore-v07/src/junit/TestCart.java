package junit;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;

/**
 * 对购物车进行测试
 * @author Miss 王 
 * @version 创建时间：2017年2月23日 下午1:56:04
 */
public class TestCart {
	
	@Test
	public void testDecimal(){
		
		//BigDecimal是专门用来计算数字
		//可能通过将要计算的数字进行包装，直接调用它的方法，就可以解决数字精度问题
//		BigDecimal d1 = new BigDecimal("0.05");
//		BigDecimal d2 = new BigDecimal("0.01");
		
		BigDecimal d1 = new BigDecimal(0.05);
		BigDecimal d2 = new BigDecimal(0.01);
		
		//做加法运算
		BigDecimal d3 = d1.add(d2);
		System.out.println("+ :"+d3.doubleValue());
		
		//做减法运算
		BigDecimal d4 = d1.subtract(d2);
		System.out.println("- :"+d4.doubleValue());
		
		//作乘法运算
		BigDecimal d5 = d1.multiply(d2);
		System.out.println("* :"+d5.doubleValue());
		
		//作除法运算
		BigDecimal d6 = d1.divide(d2);
		System.out.println("/ :"+ d6.doubleValue());
		
		//double类型本身就有精度问题
//		double d=0.05;
//		double d2=0.01;
//		System.out.println(d+d2);
	}

	@Test
	public void testCart() {
		//创建购物车
		Cart cart = new Cart();
		
		//创建图书类
		Book book = new Book(1, "时间简史", "霍金", 0.05, 100, 100);
		//Book book2 = new Book(1, "时间简史", "霍金", 20.0, 100, 100);
		//Book book1 = new Book(2, "图解机器学习", "杉山将", 0.01, 100, 100);
		
		//将图书添加到购物车
//		cart.addBook2Cart(book1);
		//cart.addBook2Cart(book2);
		cart.addBook2Cart(book);
		
		//删除购物项
		//cart.delCartItem("2");
		
		//清空购物车
		//cart.clear();
		
		//查看cart的总金额
		double amount = cart.getTotalAmount();
		//查看购物车的总数量 
		int count = cart.getTotalCount();
		
		System.out.println("购物车总金额："+amount);
		System.out.println("购物车总数量："+count);
		System.out.println("购物项数量："+cart.getCartItemList().get(0).getTotalCount());
	}

}
