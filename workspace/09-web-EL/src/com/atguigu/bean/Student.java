package com.atguigu.bean;
/**
 * 学生信息的javaBean
 * @author Miss 王 
 * @version 创建时间：2017年2月16日 下午7:48:15
 */
public class Student {
	
	private String name;
	private Integer age;
	private Double price;
	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", price=" + price
				+ "]";
	}

	public String info(){
		return "haha";
	}
	
}
