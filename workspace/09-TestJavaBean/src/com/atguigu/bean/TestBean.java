package com.atguigu.bean;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月16日 下午7:51:56
 */
public class TestBean {
	
	@Test
	public void testMap() throws Exception{
		HashMap<String, String> map = new HashMap<String,String>();
		
		map.put("name1", "李光洙");
		map.put("price", "200");
		map.put("age", "30");
		
		Student stu = new Student();
		//BeanUtil底层也是通过调用setter方法来设置属性值 
		BeanUtils.populate(stu, map);
		
		
		System.out.println(stu);
	}

	@Test
	public void test() throws Exception {
		//创建一个Student对象
		Student student = new Student();
		
	/*	//给javaBean设置属性,通过调用setter方法来设置属性值 
		student.setName("哈哈");
		student.setAge(16);
		student.setPrice(200);
		
		//System.out.println(student);
		
		//获取JavaBean属性的值 ，通过getter方法来获取属性值 
		System.out.println(student.getName());*/
		
		/*
		 * BeanUtil是用来设置或获取对象的属性值 。
		 * 使用BeanUtil需要引入以下两个jar包：
		 * commons-beanutils-1.8.0.jar
		 * commons-logging-1.1.1.jar
		 */
		
		//使用setProperty来设置对象的属性值
		//第一个参数指实例对象
		//第二个参数指属性名，是String类型
		//第三个参数指是Object类型的属性值 
		BeanUtils.setProperty(student, "name", "宋智孝");
		//如果属性类型是基本数据类型，beanUtil会自动进行转换
		BeanUtils.setProperty(student, "age", "雨辰");
		BeanUtils.setProperty(student, "gender", "female");
		System.out.println(student);
		
	}

	
}
