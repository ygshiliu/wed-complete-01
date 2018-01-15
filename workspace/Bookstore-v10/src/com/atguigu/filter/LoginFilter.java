package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;

/**
 * 针对OrderClientServlet做统一登录功能验证处理
 */
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//获取session
		HttpSession session = request.getSession();
		
		//获取用户信息
		User user = (User) session.getAttribute("user");
		
		//检查用是否登录
		if(user == null){
			//没有登录
			response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
			return;
		}else{
			//放行请求
			chain.doFilter(request, response);
		}
		
	}


}
