package junit;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午6:34:53
 */
public class TestUserService {
	
	UserService us = new UserServiceImpl();

	@Test
	public void testRegist() {
		User user = new User(null, "haha", "haha", "haha@163.com");
		Boolean regist = us.regist(user);
		System.out.println(regist);
	}

	@Test
	public void testLogin() {
		User user = new User(null, "haha1", "haha", null);
		User login = us.login(user);
		System.out.println(login);
	}

}
