package com.atguigu.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;


/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//下载文件，实际上就是将文件的流传给浏览器
		//获取文件的物理路径
		String path = getServletContext().getRealPath("/WEB-INF/img/憧憬.jpg");
		//创建文件输入流
		FileInputStream in = new FileInputStream(path);
		
		//获取mime值 
		String mimeType = getServletContext().getMimeType(path);
		
		//对下载文件名进行url编码
		String name = "风景图.jpg";
		//可以使用URLEncoder.encode()需要两个参数，第一个参数时要编码的字符串，第二个是编码所采用的字符集
		//name = URLEncoder.encode(name, "utf-8");
		name = new String(name.getBytes("gbk"),"iso-8859-1");
		
		//同时需要设置两个响应头
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", "attachment;filename="+name);
		
		//将文件的输入流发送给浏览
		ServletOutputStream out = response.getOutputStream();
		
		//使用IO工具
		IOUtils.copy(in, out);
		
		in.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
