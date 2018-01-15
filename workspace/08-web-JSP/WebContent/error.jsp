<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>error.jsp</h1>
	<%=exception.getMessage()%>
	
	<%
		//pageContext主要作用就是用来获取其它隐含对象，同时也是一个域对象
		pageContext.getRequest();
		pageContext.getResponse();
		pageContext.getException();
		
		out.write("你好");
		
	%>
	
	<%="你好" %>
</body>
</html>