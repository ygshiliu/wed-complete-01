<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 获取请求参数 -->
	${param.name }<br><br>
	${paramValues.name[1] }
	<br><br>
	<!-- 通过header获取报文头信息 -->
	${header.accept }<br><br>
	${header["User-Agent"]}<br><br>
	
	<!--  -->
	${initParam }<br><br>
	${cookie }<br><br>
	
	<%
		List list =new ArrayList();
		request.setAttribute("list", list);
		
	%>
	<!-- empty可以用来判断字符串、集合、数组的长度是否为0，若为0返回true -->
	${empty "" }<br>
	${empty list }<br>
	${!empty list }
</body>
</html>