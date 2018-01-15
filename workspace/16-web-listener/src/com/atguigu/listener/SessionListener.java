package com.atguigu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession的创建事件与销毁事件
 * @author Miss 王 
 * @version 创建时间：2017年2月27日 下午6:51:35
 */
public class SessionListener implements HttpSessionListener{
	/**
	 * session对象创建时调用
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
//		System.out.println("Session 被创建 ");
//		System.out.println(HttpSessionEvent.class);
//		System.out.println(se.getSession());
	}
	/**
	 * session对象销毁时调用
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session 被销毁 ");
	}

}
