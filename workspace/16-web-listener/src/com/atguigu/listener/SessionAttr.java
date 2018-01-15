package com.atguigu.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * session属性监听器
 * Application Lifecycle Listener implementation class SessionAttr
 *
 */
public class SessionAttr implements HttpSessionAttributeListener {

	/**
	 * 从session域中删除一个属性时被调用
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("有属性从session中移除");
    	
    }
    

	/**
	 * 添加一个属性到session域中时被调用
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("有属性添加到session中");
    	
    	HttpSession session = se.getSession();
    	String name = se.getName();
    	Object value = se.getValue();
    	System.out.println(name+"--"+value);
    }

	/**
	 * 替换一个在session域中已经存在的属性时被调用
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("有属性替换session中已有的属性");
    	String name = se.getName();
    	//这里获取到的是旧值 
    	Object value = se.getValue();
    	//新值 
    	Object newValue = se.getSession().getAttribute(name);
    	System.out.println(name+"*old*"+value+"--new--"+newValue);
    }
	
}
