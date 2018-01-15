package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

/**
 * 用户表DAO的实现类
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午4:37:09
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int save(User user) {
		String sql ="insert into bs_users(username,password,email) values (?,?,?)";
		return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}

	@Override
	public User getUserByUsernameAndPassword(User user) {
		String sql = "select id,username,password,email from bs_users where username = ? and password = ?";
		return getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "select id,username,password,email from bs_users where username = ?";
		return getBean(sql, username);
	}

}
