package com.atguigu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;



/**
 * 处理上传文件请求
 * Servlet implementation class uploadServlet
 */
public class uploadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 此种方式失效
		 request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String photo = request.getParameter("photo");
		
		System.out.println(name+"--"+photo);*/
		
		//需要通过流的方式来获取
		/*ServletInputStream in = request.getInputStream();
		String str = IOUtils.toString(in);
		System.out.println(str);*/
		
		/*使用工具commons-fileupload
		 * 
		 * 需要导包：commons-fileupload 而此包依赖commons-io
		 * 
		 * DiskFileItemFactory：用来创建工厂类实例
		 * ServletFileUpload：用来解析httpRequestServlet中的流返回FileItem列表
		 * FileItem ：用来封装每个部件信息
		 * 
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		//通过ServletFileUpload来限制文件的大小
		//通过setFileSizeMax()来设置单个文件大小为50KB
		upload.setFileSizeMax(1024*50);
		//可以限制文件总大小
		upload.setSizeMax(1024*150);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			//遍历每一个部件
			for(FileItem item:list){
				//用来判断item是否是一个普通表单项，true为普通表单项，false为文件表单项
				boolean flag = item.isFormField();
				if(flag){
					//处理普通表单项
					//获取普通表单项的name值 
					String name = item.getFieldName();
					//获取普通表单项的value值 
					String value = item.getString("utf-8");
					System.out.println(name+"--"+value);
					
				}else{
					//否则为文件表单项
					
					//获取文件名
					String name = item.getName();
					//获取文件大小
					long size = item.getSize();
					if(size == 0 ){
						return;
					}
					//获取文件类型
					String type = item.getContentType();
					
					System.out.println(name+"---"+size+"---"+type);
					
					//将文件写入服务器
					//http://localhost:8080/18-web-upload/index.jsp
					//物理路径
					String path = getServletContext().getRealPath("/upload");
					//创建文件名
					File file = new File(path);
					//文件如果不存在，则需要先
					if(!file.exists()){
						file.mkdirs();
					}
					//截取文件名
					name = name.substring(name.lastIndexOf("\\")+1);
					//将文件表单项保存到服务器
					/**
					 * 上传文件细节处理：
					 * 1、上传同名文件会有覆盖问题，可以使用UUID
					 * 2、上传文件有大小问题
					 */
					String uuid = UUID.randomUUID().toString().replace("-", "");
					name=uuid+"_"+name;
					item.write(new File(path+"/"+name));
					
				}
				
			}
		}catch (SizeLimitExceededException e) {
			e.printStackTrace();
		}catch (FileSizeLimitExceededException e) {
			e.printStackTrace();
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
		e.printStackTrace();
	}

		
		
	}

}
