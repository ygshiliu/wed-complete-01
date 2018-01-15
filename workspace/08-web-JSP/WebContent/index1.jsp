<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="1.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 学习JSP基本语法的过程就是学习服务器如何将一个JSP文件翻译成java文件的过程 -->
	<!-- Jsp模版元素：就是页面中的html代码，最终会作为out.write()方法的参数输出  -->
	<h1>index.jsp</h1>
	
	<!-- JSP脚本片段:用来在页面中书写java代码 -->
	<!-- jsp脚本片段会原封不动的复制到翻译后的java文件的service()方法的指定位置 -->
	<% 
		//向控制台输出一句话
		System.out.print("Hello,JSP!!");
		
		//定义一个变量
		int count = 5 ;
		
		int i = 5/0;
		
	
	%>
	
	<!-- Jsp表达式 :可以向页面动态输出信息-->
	<!-- 最终会翻译成out.print()方法的参数，也就是说print()可以输出什么类型，这里就可以放什么类型的变量 -->
	<%-- 注意：jsp表达式里不可以加;号的 --%>
	<%= count%>
	
	<!-- HTML注释 -->
	<%-- JSP --%>
	
	<!-- JSP声明 :在类中能做什么在jsp声明里也能做什么-->
	<%!
		//声明一个全局变量
		private String name = "哈哈";
	
		//定义一个方法
		public void getName(){
			System.out.print(name);
		}
		
	%>
	
	<!-- JSP指令 -->
	<%@ page import="java.util.Date" %> 
	<%=new Date() %>
</body>
</html>