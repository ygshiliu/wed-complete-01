<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//json与js对象类似，不同的是所有的key必须加双引号
	//格式：由键值对组成，键与值之间使用冒号隔开，多个键值对间使用分号隔开，注意最一个键值对后不要加逗号
	/*
		字符串
		数值
		布尔值
		对象
		数组
		null
	
	*/
	var obj = {
			"name":"haha",
			"sex":"男",
			"age":16,
			"istuanyuan":false,
			"address":{
				"city":"北京",
				"street":"北七街"
			},
			"hobby":["lq","zq"]
	}
	alert(obj.hobby[0]);
	
	//使用Json可以很方便的转换成字符串
	var objstr = JSON.stringify(obj);
	alert(objstr);
	
	//还可以从字符串转成json对象
	var obj2 = JSON.parse(objstr);
	alert(obj2.name);
	
	
	
</script>
</head>
<body>

</body>
</html>