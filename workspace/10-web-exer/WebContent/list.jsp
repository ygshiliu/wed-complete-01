<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
	<h1>list.jsp</h1>
	<table width="50%" border="1" cellpadding="5" cellspacing="0" align="center">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>地址</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="stu">
			<tr>
				<td>${stu.name }</td>
				<td>${stu.sex }</td>
				<td>${stu.address }</td>
				<td><a href="#">删除</a></td>
				<td><a href="#">修改</a></td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>