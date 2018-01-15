package com.atguigu.servlet;

import java.io.Serializable;

/**
 * 用户相关的信息
 * @author Miss 王 
 * @version 创建时间：2017年2月21日 下午8:47:11
 */
public class User implements Serializable{
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
