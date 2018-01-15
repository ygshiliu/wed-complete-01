<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	window.onload = function(){
		var btn = document.getElementById("btn");
		btn.onclick = function(){
			//将按钮设置为不可使用
			this.disabled = true;
			
			//按钮设置为不可用后自身的默认行为也会被取消
			//需要我们手动提交表单
			this.parentNode.submit();
		}
	}
	

</script>
</head>
<body>
	<%
	//服务器创建一个token令牌	
	String token = UUID.randomUUID().toString();
	session.setAttribute("token", token);
	%>
	
	<h1>注册页面</h1>
	<%-- <%= token %> --%>
	<form action="${pageContext.request.contextPath }/RegistServlet" method="post">
	<input type="text" name="token" value="<%=token%>"><br><br>
		用户名：<input type="text" name="username"><br><br>
		密码：<input type="text" name="password"><br><br>
		性别：<input type="radio" name="sex" value="male">男
		<input type="radio" name="sex" value="female">女<br><br>
		<input type="submit" value="注册" id="btn">
	</form>
</body>
</html>