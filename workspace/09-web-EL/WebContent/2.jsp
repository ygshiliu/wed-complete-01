<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
	Map map = new HashMap();
	map.put("name", "haha");
	map.put("age","16");
	
	request.setAttribute("map", map);
	
	List list = new ArrayList();
	list.add("宋智孝");
	list.add("金钟国");
	list.add("刘在石");
	request.setAttribute("list", list);

%>
<!-- 通过El表达式从map中获取值 -->
${map.key }<br>
${map.age }<br>

<!-- 通过EL表达式获取list中的值 -->
${list[0] }<br>
${list[1] }
</body>
</html>