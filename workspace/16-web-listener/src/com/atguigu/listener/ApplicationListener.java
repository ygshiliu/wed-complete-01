package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext的创建事件与销毁事件
 * 步骤：
 * 1、创建一个类来实现接口
 * 2、在web.xml中进行注册
 * @author Miss 王 
 * @version 创建时间：2017年2月27日 下午6:31:08
 */
public class ApplicationListener implements ServletContextListener{
	
	/**
	 * 由服务器调用
	 * 什么时候调用？在服务器启动时调用
	 * 作用：
	 * 可以用来初始化数据库连接池
	 * 可以用来读取外部文件
	 * 可以用来初始化容器
	 * 
	 * ServletContextEvent 参数：由服务器创建实例且传入
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("application 被创建了");
		//可以获取application
		ServletContext servletContext = sce.getServletContext();
		String encode = servletContext.getInitParameter("encode");
		System.out.println(encode);
	}
	
	/**
	 * 在服务器卸载前调用
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application 被销毁了");
		
	}

}
