<%@page import="com.atguigu.bean.Address"%>
<%@page import="com.atguigu.bean.Student"%>
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
		Student stu = new Student();
		stu.setName("哈哈");
		stu.setAge(16);
		stu.setPrice(200.0);
		
		Address addr = new Address();
		addr.setCity("北京");
		addr.setTown("昌平");
		addr.setStreet("七北街");
		
		stu.setAddress(addr);
		
		//向域中设置属性
		request.setAttribute("stu", stu);
		
	%>
	
	<!-- 通过EL表达式来获取属性 -->
	<!-- EL表达式只能用来获取属性，不能用来修改数据 -->
	<!-- EL表达式只能获取域中的属性 -->
	<!-- EL表达式是通过调用对象的getter方法属性来获取值 的，但不能调用属性方法之外的其它方法 -->
	${stu["age"] }<br>
	${stu["name"] }<br>
	${stu}<br>
	<%-- ${stu.info}<br> --%>
	<%-- ${stu.toString }<br> --%>
	
	<!-- EL表达式支持级联操作 -->
	${stu.address.city }
</body>
</html>