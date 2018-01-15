package com.atguigu.servlet;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

/**
 * UUID
 * @author Miss 王 
 * @version 创建时间：2017年2月21日 下午1:51:25
 */
public class TestUUID {

	@Test
	public void test() {
		//UUID是一个32位的唯一标识符
		//这是根据机器码和时间戳计算出来的
		//也就是说，UUID是一个全世界唯一的标识符，它是不可能重复的
		//作用是用来作为对象的唯一标识符，或数据库表的主键
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID.toString().replace("-", ""));
		
		//时间戳是指从1970年1月1日 0时0分0秒到现在的毫秒数
		long time = System.currentTimeMillis();
		System.out.println(time);
	}

}
