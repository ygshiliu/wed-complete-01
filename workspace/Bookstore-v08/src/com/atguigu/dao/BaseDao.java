package com.atguigu.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.util.JDBCUtil;

/**
 * 定义一个数据库基本的操作，这个类是专门用来被其他DAO继承的
 * @author Miss 王 
 * @version 创建时间：2017年2月14日 下午3:09:13
 * 
 */
public class BaseDao<T> {
	
	private QueryRunner	qr = new QueryRunner();
	private Class<T> type;
	
	public BaseDao() {
		//System.out.println("type:"+type);
		//System.out.println(this);
		//获取当前带泛型的父类
		Type t = this.getClass().getGenericSuperclass();
		//强转为带参数的泛型
		ParameterizedType paramT = (ParameterizedType) t;
		//获取泛型父类的参数类型列表
		Type[] paramList = paramT.getActualTypeArguments();
		type = (Class<T>) paramList[0];
		//System.out.println(type);
	}
	
	public int[] batch(String sql,Object[][] params){
		int[] count= null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			count = qr.batch(conn,sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
//		finally{
//			JDBCUtil.releaseConnection(conn);
//		}
		return count;
	}
	
	/**
	 * 查询数据库中单个值
	 * @return
	 */
	public Object getSingleValue(String sql,Object ...params ){
		
		Object amount = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			amount = qr.query(conn, sql, new ScalarHandler(),params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
//		finally{
//			JDBCUtil.releaseConnection(conn);
//		}
		return amount;
	}
	/**
	 * 查询一组对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql,Object ... params){
		List<T> list = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			list = qr.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
//		finally{
//			JDBCUtil.releaseConnection(conn);
//		}
		return list;
	}
	/**
	 * 查询一个对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql,Object ... params){
		T t = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			t = qr.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
//		finally{
//			JDBCUtil.releaseConnection(conn);
//		}
		
		return t;
	}
	
	/**
	 * 更新数据库操作
	 * @param sql：sql语句
	 * @param params：
	 * @return
	 */
	public int update(String sql,Object ... params){
		int count = 0;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			count = qr.update(conn, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
//		finally{
//			JDBCUtil.releaseConnection(conn);
//		}
		return count;
	}
}
