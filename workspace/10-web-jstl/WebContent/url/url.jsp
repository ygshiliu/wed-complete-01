<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <base href="http://localhost:8080/10-web-jstl/"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  
		设置绝对路径的方式：
		1、base标签:<base href="">
		2. 可以通过<c:url value="/index.jsp"></c:url>
		3. 可以通过c:set在域中设置一个变量
	-->
	<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
	<a href="${ctx }/index.jsp">首页</a><br><br>

	<!-- 主要用来重写url地址 -->
	<!-- scope用来指定重写后的url地址保存在哪个域对象中 -->
	<!-- value指要重写url地址的值  -->
	<!-- var用来保存重写后的url地址，并将其作为属性名保存到域对象中 -->
	<!-- c:param可以自动将中文参数进行url编码 -->
	<!-- 将中文 转成 二进制编码  ，再转成十六进制编码 -->
	<c:url scope="request" value="url.jsp" var="url">
		<c:param name="name" value="张三"></c:param>
	</c:url>
	${requestScope.url }
	
	<%-- <c:redirect url="index.jsp"></c:redirect> --%>
</body>
</html>