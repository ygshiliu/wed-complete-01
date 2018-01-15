<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		页面中需要进行国际化的，都需要定义成一个变量
		而变量的值通过要定义在一个.properties的文件中
		且这个文件的位置要放在src目录下，并且文件名也是有要求的，结构为：基础名_语言_国家.properties
		zh代表中文
		CN代表中国
	 -->
	 
<%-- 	 <%
	 	Locale locale = request.getLocale();
	 	ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
	 
	 %>
	<h1><%=bundle.getString("login") %></h1>
	
	<form action="" method="post">
		<%=bundle.getString("username") %><input type="text" name="username"><br><br>
		<%=bundle.getString("password") %><input type="password" name="password"><br><br>
		<input type="submit" value="<%=bundle.getString("login") %>">
	</form> --%>
	
	<fmt:setLocale value="${pageContext.request.locale }"/>
	<fmt:setBundle basename="i18n"/>
	<fmt:formatDate value="<%=new Date() %>" type="both"/>
	
	<h1><fmt:message key="login"></fmt:message></h1>
	
	<form action="" method="post">
		<fmt:message key="username"></fmt:message><input type="text" name="username"><br><br>
		<fmt:message key="password"></fmt:message><input type="password" name="password"><br><br>
		<input type="submit" value="<fmt:message key="login"></fmt:message>">
	</form>
</body>
</html>