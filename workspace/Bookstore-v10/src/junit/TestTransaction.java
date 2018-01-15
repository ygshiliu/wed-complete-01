package junit;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月27日 上午10:53:03
 */
public class TestTransaction {

	@Test
	public void test() {
		
		//获取数据库连接
		Connection conn = null;
		try {
			//设置事务手动提交
			conn.setAutoCommit(false);
			
			//调用Dao操作数据库
			//...
			
			//没有异常，进行事务提交
			conn.commit();
		} catch (SQLException e) {
			//出现异常，回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//关系数据库连接
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
