package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		
		//获取浏览器提交的token
		String token = request.getParameter("token");
		//获取服务器保存的token
		HttpSession session = request.getSession();
		String token1 = (String) session.getAttribute("token");
		
		System.out.println(token +"--"+token1);
		//移除session中的令牌，说明已经处理过了
		session.removeAttribute("token");
		if(token1 !=null && token1.equals(token)){
			//调用service层保存数据
			System.out.println("username:"+username+",password:"+password+",sex:"+sex);
			//转发到regist_success.jsp
			//request.getRequestDispatcher("/form/regist_success.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/form/regist_success.jsp");
			
		}else{
			//重定向到error.jsp
			response.sendRedirect(request.getContextPath()+"/form/error.jsp");
		}
		
		
	}

}
