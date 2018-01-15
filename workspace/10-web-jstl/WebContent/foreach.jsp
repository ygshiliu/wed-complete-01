<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List list = new ArrayList();
		list.add("宋智孝");
		list.add("金钟国");
		list.add("刘在石");
		list.add("李光洙");
		
		//将list设置到域中
		request.setAttribute("list", list);
		
		HashMap map = new HashMap();
		map.put("name","haha");
		map.put("age",16);
		map.put("gender","male");
		
		request.setAttribute("map", map);
	
	%>
	
	<c:forEach items="${list }" var="user" varStatus="vs">
		${vs.name }
	</c:forEach>
	
	<!-- 遍历一个Map集合 -->
	<!-- 如果是map集合，那每一次遍历的是一个键值对 -->
	<!-- 可以通过 对象.key 来获取键，通过 对象.value 来获取值 -->
	<c:forEach items="${map }" var="user">
		${user.key } &nbsp;:&nbsp; ${user.value }<br>
	</c:forEach>
	
	<!-- 遍历一个list集合 -->
	<!-- forEach遍历多少次取决于items指向的集合数量 -->
	<!-- var用来定义一个属性名并保存每次遍历的值，然后放到域对象中 -->
	<!-- items用来指向要遍历的对象 -->
	<c:forEach items="${list }" var="name">
		<h1>${name}</h1>
	</c:forEach>
	
	<!-- 遍历一组数据 -->
	<!-- c:foreach 用来在页面中对标签体进行循环处理-->
	<!-- begin用来指定开始值 -->
	<!-- end用来指定结束值 -->
	<!-- step用来指定步长 -->
	<!-- var用来保存每次遍历的值，将保存到域里，默认是pageScope域 -->
	<c:forEach begin="1" end="20" step="2" var="index">
		${pageScope.index }	
	</c:forEach>
</body>
</html>