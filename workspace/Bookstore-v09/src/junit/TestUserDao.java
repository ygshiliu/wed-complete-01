package junit;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;

/**
 * 对userDaoImpl方法进行测试
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午4:43:50
 */
public class TestUserDao {
	
	private UserDao ud = new UserDaoImpl();

	@Test
	public void testSave() {
		User user = new User(null, "admin", "123123", "admin@163.com");
		int save = ud.save(user);
		System.out.println("数量："+save);
	}

	@Test
	public void testGetUserByUsernameAndPassword() {
		User user = new User(null, "admin", "123123", null);
		User u = ud.getUserByUsernameAndPassword(user);
		System.out.println(u);
	}

}
