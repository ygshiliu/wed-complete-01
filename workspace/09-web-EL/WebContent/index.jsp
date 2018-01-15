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
		pageContext.setAttribute("key", "pageValue");
		request.setAttribute("key", "reqValue");
		session.setAttribute("key", "sessionValue");
		application.setAttribute("key", "appValue");
	%>
	
	<!-- 使用jsp表达式来获取属性 -->
	<%= request.getAttribute("key1") %><br><br>
	
	<!-- 使用EL表达式来代替JSP表达式 -->
	<!-- 使用EL表达式，如果属性不存在，它什么也不输出 -->
	<!-- EL表达式它会自动从4个域中以从小到大的顺序进行查找 ，找到就返回 -->
	<!-- 可能通过指定pageScope requestScope sessionScope applicationScope 来精确获取 -->
	${ key }<br><br>
	${requestScope.key }
	
</body>
</html>