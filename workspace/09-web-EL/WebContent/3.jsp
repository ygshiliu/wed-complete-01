<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- pageContext是PageContext类型 ，就是jsp中的pageContext对象-->
	<!-- 可以使用pageContext对象来获取其它域对象 -->
	${pageContext }
	<!-- 获取项目 -->
	${pageContext.request.contextPath }
	${pageContext.session }
	${pageContext.servletContext }
	
	<br><br>
	${pageScope }<br><br>
	${requestScope }<br><br>
	${sessionScope }<br><br>
	${applicationScope }<br><br>
	
</body>
</html>