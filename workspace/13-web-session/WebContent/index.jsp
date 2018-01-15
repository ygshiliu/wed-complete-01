<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>获取用户名：${sessionScope.username }</h1>
	可以用来检查session对象是否是新创建的：<%=session.isNew() %><br><br>
	<%
		//可以通过指定一个大于0的值来手动设置session的有效时间
		//session.setMaxInactiveInterval(2);
	
		//指定0值 ,表示session会立即失效
		//session.setMaxInactiveInterval(0);
		
		//指定一个负值 ,表示永久有效
		//session.setMaxInactiveInterval(-200);
		
		session.invalidate();
	%>
	默认的有效时间：<%= session.getMaxInactiveInterval() %><br><br>
</body>
</html>