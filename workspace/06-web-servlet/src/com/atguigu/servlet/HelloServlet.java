package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 创建servlet步骤：
 * 第一步：创建一个类，并且实现Servlet接口
 * 第二步：在Tomcat服务器进行注册配置
 * 
 * servlet类是由我们来创建，但是是由Servlet容器（Tomcat服务器）来管理
 * Servlet容器主要负责管理servlet的生命周期
 * 
 * 人的生命周期：是指人从出生到死亡的过程
 * 
 * servlet生命周期：同时是从被创建到被销毁的过程
 * 
 * 我们研究servlet的生命周期，实际就是研究servlet的生命周期方法：
 * 构造器：
 * 		当servlet第1次处理请求时，构造器被调用，仅调用1次
 * 		由于servlet的构造器只调用1次，说明servlet它是一个单例模式，是以多线程的方式来调用service方法
 * 		service方法不是线程安全的，所以我们尽量不要在service方法中出现全局变量
 * init()
 * 		是在构造器被调用后，紧跟着调用，仅调用1次
 * 		主要作用就是用来初始化servlet
 * service()
 * 		每次处理请求时都会被调用的方法，会调用多次
 * destory()
 * 		当项目被卸载时才会调用，仅调用1次
 * 		主要用来做收尾操作
 * 
 * servlet调用描述 ：
 * 当我们第1次访问servlet处理请求：
 * 构造器、init方法、service方法被调用
 * 
 * 第1次之后再访问servlet时：
 * 只有service方法被调用
 * 
 * 当web项目被卸载时：
 * destroy方法被调用
 * 
 * @author Administrator
 *
 */
public class HelloServlet implements Servlet {
	
	public HelloServlet() {
		System.out.println("HelloServlet构造器被调用");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init方法被调用");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig方法被调用");
		return null;
	}
	
	/**
	 * ServletRequest:代表浏览器发送给服务器的请求报文
	 * ServletResponse：代表服务器发送给浏览器的响应报文
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		/*//向控制台输出一句话
		System.out.println("第一个servlet");
		
		//向客户返回信息
		PrintWriter out = res.getWriter();
		out.print("Hello Client!!");*/
		
		System.out.println("service方法被调用");	
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo方法被调用");	
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy方法被调用");	
	}



}
