package com.atguigu.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

/**
 * 测试json
 * @author Miss 王 
 * @version 创建时间：2017年3月1日 下午7:47:54
 */
public class TestJson {
	
	@Test
	public void test03() {
		//创建List
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("haha", 20, "1231321"));
		list.add(new User("刘在石", 22, "1254641"));
//		list.add(new User("Gary", 25, "186251321"));
//		list.add(new User("宋智孝", 20, "12385241"));
		
		//创建Gson
		Gson gson = new Gson();
		
		//将list对象转成json字符串
		String json = gson.toJson(list);
		System.out.println(json);
		
		//将json字符串转成List对象
		List list2 = gson.fromJson(json, List.class);
		System.out.println(list2);
		
		
	}
	
	@Test
	public void test02() {
		//创建map
		Map<String,Object> map = new HashMap<>();
		map.put("name", "Jerry");
		map.put("age", 16);
		map.put("phone", "12312344567");
		
//		创建Gson对象
		Gson gson = new Gson();
		//将map转成json字符串
		String json = gson.toJson(map);
		System.out.println(json);
		
		//将json字符串转成Map对象
		Map map2 = gson.fromJson(json, Map.class);
		System.out.println(map2);
	}

	@Test
	public void test01() {
		User user = new User("wang", 16, "13116141812");
		//String s = "{\"name\":\"wang\",\"age\":16,\"phone\":\"13116141812\"}";
		//创建Gson对象
		Gson gson = new Gson();
		//通过toJson()将对象转换成字符串
		String json = gson.toJson(user);
		System.out.println(json);
		
		//将json字符串转换成对象
		//第一个参数是json字符串
		//第二个参数 是要转换类型的大Class
		User u = gson.fromJson(json, User.class);
		System.out.println(u);
		
	}

}
