<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三级联动</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		
		//发送请求获取省份信息的数据
		$.getJSON("${pageContext.request.contextPath}/ProvinceServlet",{t:Math.random()} , function(data){
			
			//遍历服务器返回的JSON数据
			for(var i=0 ; i<data.length ; i++){
				//获取省份名和ID
				var name = data[i].name;
				var id = data[i].id;
				//创建option标签
				$("<option value='"+id+"'>"+name+"</option>").appendTo("[name=province]");
			}
		});
		
		//当省信息发生改变时加载城市信息
		$("[name=province]").change(function(){
			
			//获取省份id
			var pid = this.value;
			
			//清空city下的option
			$("[name=city] option[value]").remove();
			//清空district下的option
			$("[name=district] option[value]").remove();
			
			//发送请求查询信息
			$.getJSON("${pageContext.request.contextPath}/CityServlet",{t:Math.random(),pid:pid} , function(data){
				for(var i=0 ; i<data.length ; i++){
					var name = data[i].name;
					var id = data[i].id;
					$("<option value='"+id+"'>"+name+"</option>").appendTo("[name=city]");
				}
				
			});
			
		});
		
		//当城市信息发生改变时加载城市信息
		$("[name=city]").change(function(){
			
			//获取省份id
			var cid = this.value;
			
			//清空district下的option
			$("[name=district] option[value]").remove();
			
			//发送请求查询信息
			$.getJSON("${pageContext.request.contextPath}/DistrictServlet",{t:Math.random(),cid:cid} , function(data){
				for(var i=0 ; i<data.length ; i++){
					var name = data[i].name;
					var id = data[i].id;
					$("<option value='"+id+"'>"+name+"</option>").appendTo("[name=district]");
				}
				
			});
			
		});
		
	});
</script>
</head>
<body>
<select name="province">
	<option>请选择省...</option>
</select>
<select name="city">
	<option>请选择市...</option>
</select>
<select name="district">
	<option>请选择区县...</option>
</select>
</body>
</html>