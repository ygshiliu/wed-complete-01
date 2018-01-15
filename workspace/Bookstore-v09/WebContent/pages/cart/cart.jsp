<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	
	$(function(){
		//获取购物项并绑定单击响应函数
		$(".delA").click(function(){
			var title = $(this).parents("tr").find("td:first").html();
			if(!confirm("您确认要删除" + title + "图书吗？")){
				return false;
			}
		})
		
		//给清空绑定js代码确认功能
		$("#clearA").click(function(){
			if(!confirm("您确认要清空购物车吗？")){
				return false;
			}
		})
		
		//给购物项绑定数量改变事件
		$(".update_count").change(function(){
			//获取更改的文本值 
			var count = $(this).val();
			var id = this.id;
			
			//对输入的文本进行验证
			var reg = /[0-9]/;
			if(!reg.test(count)){
				var oldValue = this.defaultValue;
				this.value = oldValue;
				alert("您输入的不是正确的数字！");
				return false;
			}
			
			//发送ajax请求
			var url = "Client/CartServlet?method=updateCount";
			var params = {
					count:count,
					bookId:id
			}
			var $update_count = $(this);
			$.post(url,params,function(data){
				//修改的不是本身val值 ，而是它的兄弟td
				$update_count.parents("tr").find("td:eq(3)").html(data.amount);
				//修改购物车中总数量 与总金额
				$(".b_count").html(data.totalCount);
				$(".b_price").html(data.totalAmount);
				
			},"json")
			
			//window.location.href = "Client/CartServlet?method=updateCount&count="+count+"&bookId="+id;
			
		})
		
	});

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>		
			<c:forEach items="${cart.cartItemList }" var="item">
				<tr>
					<td>${item.book.title }</td>
					<td><input type="text" id="${item.book.id }" class="update_count" value="${item.totalCount }" style="width:30px;text-align:center"> </td>
					<td>${item.book.price }</td>
					<td>${item.totalAmount }</td>
					<td><a href="Client/CartServlet?method=delCartItem&bookId=${item.book.id }"  class="delA">删除</a></td>
				</tr>	
			</c:forEach>
			
			
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${cart.totalAmount }</span>元</span>
			<span class="cart_span"><a href="Client/CartServlet?method=clear" id="clearA">清空购物车</a></span>
			<span class="cart_span"><a href="Client/OrderClientServlet?method=checkout">去结账</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>