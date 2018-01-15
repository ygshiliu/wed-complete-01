package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * 用户相关的一些业务逻辑操作
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午6:13:15
 */
public interface UserService {
	/**
	 * 注册新用户
	 * @param user
	 * @return
	 */
	Boolean regist(User user);
	
	/**
	 * 用户登录操作
	 * @param user
	 * @return
	 */
	User login(User user);
	/**
	 * 根据姓名检查用户是否存在
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);
	
}
