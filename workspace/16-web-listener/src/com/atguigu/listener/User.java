package com.atguigu.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 封装用户的信息
 * @author Miss 王 
 * @version 创建时间：2017年2月27日 下午10:15:24
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable {
	
	private String name;
	private String password;

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User对象放入session域");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User对象移除session域");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("User对象与session钝化");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("User对象与session从硬盘中活化过来");
		
	}

}
