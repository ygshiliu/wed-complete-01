package junit;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;

/**
 * 测试OrderItemDao
 * @author Miss 王 
 * @version 创建时间：2017年2月24日 下午12:06:28
 */
public class TestOrderItemDao {
	private OrderItemDao oid = new OrderItemDaoImpl();
	
	@Test
	public void testBatchSave() {
		Object[][] params = new Object[2][];
		//title,author,price,img_path,total_count,total_amount,order_id
		params[0] = new Object[7];
		params[0][0]="时间简史";
		params[0][1]="霍金";
		params[0][2]=30.0;
		params[0][3]="/static/img/default.jpg";
		params[0][4]=5;
		params[0][5]=150.0;
		params[0][6]="14879352076022";
		
		params[1] = new Object[7];
		params[1][0]="看见";
		params[1][1]="柴静";
		params[1][2]=20.0;
		params[1][3]="/static/img/default.jpg";
		params[1][4]=10;
		params[1][5]=200.0;
		params[1][6]="14879352076022";
		
		oid.batchSave(params);
	}
	
	@Test
	public void testSaveOrderItem() {

		OrderItem item = new OrderItem(null, "日子", "本山", 20.0, "/static/img/default.jpg", 10, 20.0, "14879079854971");
		int count = oid.saveOrderItem(item);
		System.out.println(count);
	}

	@Test
	public void testGetOrderItemListByOrderId() {
		List<OrderItem> list = oid.getOrderItemListByOrderId("14879079854971");
		System.out.println(list);
	}

}
