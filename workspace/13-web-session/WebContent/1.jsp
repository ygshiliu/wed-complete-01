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
	<%
		session.setAttribute("username", "haha");
		System.out.print(session.getClass());
	%>
	
	<%=response.encodeRedirectURL(request.getContextPath()+"/2.jsp") %><br><br>
	<%=response.encodeURL(request.getContextPath()+"/2.jsp") %><br><br>
	<c:url value="/2.jsp"></c:url>
	<a href="<c:url value='/2.jsp'></c:url>">访问2.jsp</a>
<%-- 	<a href="<%=response.encodeRedirectURL(request.getContextPath()+"/2.jsp") %>">访问2.jsp</a> --%>
<!-- 	<a href="2.jsp">访问2.jsp</a> -->
</body>
</html>