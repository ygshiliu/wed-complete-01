package com.atguigu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.util.JDBCUtil;

/**
 * 统一处理事务
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//获取数据库连接
		Connection conn = JDBCUtil.getConnection();
		
		try {
			//设置事务提交行为
			conn.setAutoCommit(false);
			
			//放行请求
			chain.doFilter(request, response);
			
			//如果没有异常
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//有异常事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			response.sendRedirect(request.getContextPath()+"/pages/user/error.jsp");
		}finally{
			//关闭数据库连接
			//JDBCUtil.releaseConnection(conn);
			JDBCUtil.releaseConnection();
		}
		
	}
	
}
