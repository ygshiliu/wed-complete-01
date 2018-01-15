package com.atguigu.servlet;
/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月15日 下午7:25:31
 */
public class Student {
	
	private String name;
	private String sex;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(String name, String sex, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", address="
				+ address + "]";
	}
	
	
}
