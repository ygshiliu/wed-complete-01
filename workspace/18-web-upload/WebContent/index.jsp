<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件上传</h1>

<!-- 文件上传注意事项：
	1、需要使用file表单项
	2、需要更改form标签的enctype属性值（默认值 ："application/x-www-form-urlencoded"） 为multipart/form-data。
	设置后请求信息会以流的形式发送给服务器，在请求报文中“-----------------------------7e12586110d3e”的标记来分隔每一个部分
	3、当以enctype=multipart/form-data来发送请求时，servlet中request.getParameter()方法将失效
 -->
<form action="uploadServlet" method="post" enctype="multipart/form-data">
	文件名：<input type="text" name="name"><br><br>
	<input type="file" name="photo1"><br><br>
	<input type="file" name="photo2"><br><br>
	<input type="file" name="photo3"><br><br>
	<input type="submit" value="提交">

</form>

</body>
</html>