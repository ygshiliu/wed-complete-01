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
	<!-- c:set用来设置或获取域中的属性值 -->
	<!-- name用来向域中定义一个属性名 -->
	<!-- value用来指定属性值 -->
	<!-- scope用来指定域对象，默认为pageScope -->
	<c:set var="name" value="haha" scope="request" ></c:set>
	<%-- ${sessionScope.name } --%>
	
	<!-- c:remove用来移除域中的属性 -->
	<c:remove var="name" scope="request"/>
	

</body>
</html>