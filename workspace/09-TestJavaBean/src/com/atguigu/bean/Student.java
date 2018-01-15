package com.atguigu.bean;
/**
 * 学生信息的javaBean
 * @author Miss 王 
 * @version 创建时间：2017年2月16日 下午7:48:15
 */
public class Student {
	
	private String name1;
	private Integer age;
	private Double price;
	public String getName() {
		return name1;
	}
	public void setName1(String name) {
		this.name1 = name;
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
		return "Student [name=" + name1 + ", age=" + age + ", price=" + price
				+ "]";
	}

	
	
}
