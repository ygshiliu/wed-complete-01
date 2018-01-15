<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1.jsp</h1>
	<!-- 使用java代码转发 -->
<%-- 	<%
		request.getRequestDispatcher("2.jsp").forward(request, response);
	%> --%>
	
	<!-- 通过jsp：forword动作标签 -->
	<jsp:forward page="2.jsp">
		<jsp:param value="Gary" name="name"/>
	</jsp:forward>
</body>
</html>