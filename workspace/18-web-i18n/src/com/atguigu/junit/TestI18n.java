package com.atguigu.junit;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * 测试国际化
 * @author Miss 王 
 * @version 创建时间：2017年3月3日 下午10:12:58
 */
public class TestI18n {
	

	@Test
	public void test03() {
		
		DateFormat instance = DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALIAN);
		System.out.println(instance.format(new Date()));
	}
	
	
	@Test
	public void test02() {
		
		Locale locale = Locale.SIMPLIFIED_CHINESE;
		//getBundle（基础名，Local对象）
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
		
		String login = bundle.getString("login");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		System.out.println(login+"--"+username+"--"+password);
	}
	

	@Test
	public void test01() {
		//获取默认的local
//		Locale locale = Locale.getDefault();
		
		//通过构造器创建
		//Locale locale = new Locale("zh", "CN");
		
		//直接使用Locale定义的常量
		Locale locale = Locale.SIMPLIFIED_CHINESE;
		System.out.println(locale);
		
	}

}
