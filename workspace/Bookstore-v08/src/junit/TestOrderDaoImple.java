package junit;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;

/**
 * 测试orderDao
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 上午11:32:11
 */
public class TestOrderDaoImple {
	private OrderDao od = new OrderDaoImpl();
	

	/**
	 * 保存订单
	 */
	@Test
	public void testSaveOrder() {
		//订单号规则：时间戳+用户id
		String id = System.currentTimeMillis() + "" + 1;
		//订单生成日期
		Date createDate = new Date();
		//订单状态：0未发货，1已发货，2交易完成
		int state = 0;
		//订单数量 
		int totalCount = 5;
		//订单金额
		double totalAmount = 30.0;
		//用户信息
		int userId = 1;
		//创建订单		
		Order order = new Order(id, createDate, state, totalCount, totalAmount, userId);
		//保存订单
		int count = od.saveOrder(order);
		System.out.println(count);
	}
	//修改订单状态
	@Test
	public void testUpdateState() {
		int count = od.updateState("14879079854971", 1);
		System.out.println(count);
	}
	//根据用户id获取订单
	@Test
	public void testGetOrderListByUserId() {
		List<Order> list = od.getOrderListByUserId(1);
		System.out.println(list);
	}
	//获取全部订单
	@Test
	public void testGetAllOrderList() {
		List<Order> list = od.getAllOrderList();
		System.out.println(list);
	}

}
