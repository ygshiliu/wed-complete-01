<%@page import="com.atguigu.servlet.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<%-- <%=request.getAttribute("list") %> --%>
	<h1>学生列表</h1>
	<table align="center" border="1px" cellpadding="5" cellspacing="0" width="40%">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>地址</th>
			<th colspan="2">操作</th>
		</tr>
		<%
			List<Student> list = (List<Student>)request.getAttribute("list");
			//System.out.print(list);
			if(list != null){
				for(Student s:list){
		%>
					
					<tr>
						<td><%=s.getName() %></td>
						<td><%=s.getSex() %></td>
						<td><%=s.getAddress() %></td>
						<td><a href="#">修改</a></td>
						<td><a href="#">删除</a></td>
					</tr>
					
					
					<%
				}
			}
		%>
	
	</table>
</body>
</html>