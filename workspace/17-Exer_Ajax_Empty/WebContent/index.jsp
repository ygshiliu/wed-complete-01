<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三级联动</title>
<!-- 引入jQuery库 -->
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		//页面加载完成后马上加载省份数据
		$.getJSON("/Exer_Ajax_Empty/ProvinceServlet",function(data){
			//获取省份下拉列表框
			var province = $("[name=province]");
			//遍历响应
			for(var i=0;i<data.length;i++){
				province.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
			}
		})
		
		//给省份下拉列表绑定单击事件
		$("[name=province]").change(function(){
			//发送ajax请求
			//准备信息
			var url = "/17-Exer_Ajax_Empty/CityServlet";
			console.log(this.value);
			var param = {pid:this.value};
			$.get(url,param,function(data){
				//获取city
				var city = $("[name=city]");
				//清空city下拉列表框
				//此处不能使用empty()方法，应使用remove()
				//city.empty();
				$("[name=city] option[value]").remove();
				$("[name=district] option[value]").remove();
				
				for(var i=0;i<data.length;i++){
					//将城市加载到页面
					city.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
				}
			},"json")
		})
		
		
		//给城市列表绑定改变事件
		$("[name=city]").change(function(){
			//发送ajax
			//准备信息
			var url = "/17-Exer_Ajax_Empty/DistrictServlet";
			var params = {cid:this.value};
			$.getJSON(url,params,function(data){
				//加载区县前需要清空之前的
				$("[name=district] option[value]").remove();
				
				for(var i=0;i<data.length;i++){
					$("<option value='"+data[i].id+"'>"+data[i].name+"</option>").appendTo("[name=district]");
				}
				
			})
		})
		
	})

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