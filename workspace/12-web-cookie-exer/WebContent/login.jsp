<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录页面</h1>
	<form action="loginServlet" method="post">
		姓名：<input type="text" name="username" value="${cookie.username.value }"><br><br>
		密码：<input type="password" name="password" value="${cookie.password.value }"><br><br>
		<input type="submit" value="登录">
	
	</form>
	
	
</body>
</html>