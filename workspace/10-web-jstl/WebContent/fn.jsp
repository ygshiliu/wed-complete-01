<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	转大写：${fn:toUpperCase("adfsd") }<br><br>
	转小写：${fn:toLowerCase("asdaWWWWWWd") }<br><br>
	去空格：${fn:trim("  s df  fs ") }<br><br>
	查找索引位置：${fn:indexOf("adarfwerwersfdsf","we")}<br><br>
	查找第一个字符串是否包含第二个字符串：${fn:contains("kljlsdfll","ee")}<br><br>
</body>
</html>