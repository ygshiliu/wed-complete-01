<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	
	$(function(){
		//获取按钮绑定单击事件
		$("#btn01").click(function(){
/* 			//准备参数
			var url = "/17-web-ajax/AjaxServlet";
			var params = {name:"Lucy",password:"123123"};
			function fun(data){
				//使用jQuery操作ajax，不需要手动创建XMLHttpRequest对象
				//不需要手动设置请求头：Content-Type: application/x-www-form-urlencoded; charset=UTF-8
				//同时请求参数可以是一个json对象
				//返回的响应会自动转成指定的数据格式
				alert(data.name+"--"+data.age);
			}
			//发送post请求
			$.post(url,params,fun,"json"); */
			
			$.post("/17-web-ajax/AjaxServlet",{name:"Lucy",password:"123123"},function(data){
				alert(data.name+"--"+data.age);
			},"json");
		})
		
		//$.get
		$("#btn02").click(function(){
			$.get("/17-web-ajax/AjaxServlet",{name:"Lucy",password:"123123"},function(data){
				alert(data);
			},"text");
		})
		
		//$.getJson
		$("#btn03").click(function(){
			$.getJSON("/17-web-ajax/AjaxServlet",{name:"Lucy",password:"123123"},function(data){
				alert(data.name+"--"+data.phone);
			});
		})
	})
</script>
</head>
<body>
	<button id="btn01">发送$.post</button>
	<button id="btn02">发送$.get</button>
	<button id="btn03">发送$.getJson</button>
</body>
</html>