package com.atguigu.json;
/**
 * 封装user信息
 * @author Miss 王 
 * @version 创建时间：2017年3月1日 下午8:15:31
 */
public class User {
	private String name;
	private int age;
	private String phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
	
}
