package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * 定义用户表基本操作的DAO
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午4:10:37
 */
public interface UserDao {
	/**
	 * 向用户表中插入一条用户信息
	 * @param user
	 * @return
	 */
	int save(User user);
	
	/**
	 * 根据用户名与密码从用户表中查出一个用户对象
	 * @param user
	 * @return
	 */
	User getUserByUsernameAndPassword(User user);
}
