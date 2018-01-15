<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- c:if就是java中的if,用来做逻辑判断的 -->
	<!-- test属性用来接收一个boolean值，如果为true则执行标签体，否则不执行 -->
	<c:if test="${empty param.name }">
		<h1>请输入用户名</h1>
	</c:if>
	<c:if test="${!empty param.name }">
		<h1>用户名：${param.name }</h1>
	</c:if>
	
	<!-- c:choose\c:when\c:otherwrise相当于if...else if...else -->
	<!-- c:when与c:otherwise不能脱离c:choose标签使用 -->
	<!-- 注意顺序，c:when标签在c:otherwise标签的前面 -->
	<!-- 多个c:when之间存在逻辑关系，是从上到下依次执行的过程，找到满足条件的就执行，后面的就不再执行.
	当所有c:when都不满足条件时，才会执行c:otherwrise -->
	<c:choose>
		<c:when test="${param.score==100}">
			<h1>成绩优秀</h1>
		</c:when>
		<c:when test="${param.score>=80}">
			<h1>成绩优</h1>
		</c:when>
		<c:when test="${param.score>=70}">
			<h1>成绩良</h1>
		</c:when>
		<c:when test="${param.score>=60}">
			<h1>成绩合格</h1>
		</c:when>
		<c:otherwise>
			<h1>成绩不及格</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>