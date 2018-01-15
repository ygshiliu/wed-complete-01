package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

/**
 * UserService实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午6:30:07
 */
public class UserServiceImpl implements UserService {
	
	private UserDao ud = new UserDaoImpl();

	@Override
	public Boolean regist(User user) {
		int count = ud.save(user);
		return count>0;
	}

	@Override
	public User login(User user) {
		return ud.getUserByUsernameAndPassword(user);
	}

}
