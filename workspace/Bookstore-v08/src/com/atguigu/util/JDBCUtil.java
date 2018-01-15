package com.atguigu.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 获取和释放数据库连接
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	private static DataSource dataSource = new ComboPooledDataSource("webDataSource");
	//1)private static Connection conn = null;
	//2)private static Map<Thread,Connection> map = new ConcurrentHashMap<Thread,Connection>();
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	/**
	 * 获取数据连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = threadLocal.get();
		if(conn == null){
			try {
				//如果为空，获取连接
				conn = dataSource.getConnection();
				//将数据库连接放入map中
				threadLocal.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
/*		//直接从map中获取连接
		Connection conn = map.get(Thread.currentThread());
		//判断是否为空
		if(conn == null){
			try {
				//如果为空，获取连接
				conn = dataSource.getConnection();
				//将数据库连接放入map中
				map.put(Thread.currentThread(), conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;*/
		
/*		//判断一下conn是否为null
		if(conn==null){
			try {
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
		*/
		
	/*	Connection conn=null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;*/
	}
	
	/**
	 * 释放数据库连接
	 * @param conn
	 */
	public static void releaseConnection(){
		Connection conn = threadLocal.get();
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
/*	public static void releaseConnection(){
		//从map中获取connection
		Connection conn = map.get(Thread.currentThread());
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			map.remove(Thread.currentThread());
		}
	}
	*/
	/*public static void releaseConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
}
