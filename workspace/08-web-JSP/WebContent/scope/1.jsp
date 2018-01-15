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
	<!-- 分别向域对象中设置对象 -->
	<%
		pageContext.setAttribute("pagekey", "pageValue");
		request.setAttribute("requestkey", "requestValue");
		session.setAttribute("sessionkey", "sessionValue");
		application.setAttribute("applicationkey", "applicationValue");
	%>
	<!-- 获取域中的属性值  -->
	pageKey:<%=pageContext.getAttribute("pagekey") %><br>
	requestKey:<%=request.getAttribute("requestkey") %><br>
	sessionkey:<%=session.getAttribute("sessionkey") %><br>
	applicationkey:<%=application.getAttribute("applicationkey") %><br>
	
	<!-- 通过转发的方式去2.jsp -->
	<%-- <jsp:forward page="2.jsp"></jsp:forward> --%>
	
	<!-- <a href="2.jsp">访问2.jsp</a> -->
	<!-- 通过重定向方式去2.jsp -->
	<%
		response.sendRedirect("2.jsp");
	%>
</body>
</html>