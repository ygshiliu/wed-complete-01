package com.atguigu.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * WEB相关操作的工具类
 * @author Miss 王 
 * @version 创建时间：2017年2月16日 下午8:59:54
 */
public class WEBUtils {
	
	/**
	 * 将请求参数封装到对象中
	 */
	public static  <T>T params2Bean(HttpServletRequest request,T t){
		
		//获取请求参数的map对象
		Map map = request.getParameterMap();
		
		try {
			//将请求参数封装到对象中
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	/**
	 * 获取请求资源地址
	 * @param request
	 * @return
	 */
	public static String getPath(HttpServletRequest request) {

		//获取请求资源的uri
		String uri = request.getRequestURI();
		//获取请求参数
		String queryString = request.getQueryString();
		if(queryString.contains("&pageNo")){
			queryString = queryString.substring(0,queryString.indexOf("&pageNo"));
		}
		return uri+"?"+queryString;
	}
}
