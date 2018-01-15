<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include  file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	
	$(function(){
		//给加入购物车按钮绑定单击事件
		$(".add2Cart").click(function(){
			//准备信息
			var url = "${pageContext.request.contextPath}/Client/CartServlet?method=addBook2Cart";
			var param = {bookId:this.name};
			//通过$.get发送请求
			$.post(url,param,function(data){
				$(".showInfo").empty().append("<span>您的购物车中有"+ data.count+"件商品</span>"
						+"<div>您刚刚将<span style='color: red'>"+data.title+"</span>加入到了购物车中</div>");
				
			},"json");
		})
	})

</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/user-info.jsp"%>
	</div>
	
	<div id="main">
		<div id="book">
			<!-- 注意这里需要使用get请求 -->
			<form action="client/BookClientServlet" method="get">
				<input type="hidden" name="method" value="findBookByPrice">
				<div class="book_cond">
					价格：<input type="text" name="min" value="${param.min }"> 元 - 
					<input type="text" name="max" value="${param.max }"> 元
					<input type="submit" value="提交">
				</div>
			</form>
			<div style="text-align: center" class="showInfo">
				<br>
				<span>您的购物车暂时没有商品，赶快去购物吧!</span>
			</div>
			<%-- <c:choose>
				<c:when test="${empty cart.cartItemList }">
				
					<div style="text-align: center" class="showInfo">
						<br>
						<span>您的购物车暂时没有商品，赶快去购物吧!</span>
					</div>
				</c:when>
				<c:otherwise>
					<div style="text-align: center">
						<span>您的购物车中有" ${cart.totalCount } "件商品</span>
						<div>
							您刚刚将<span style="color: red">${title }</span>加入到了购物车中
						</div>
					</div>
				
				</c:otherwise>
			</c:choose> --%>
		<c:forEach items="${requestScope.page.list }" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${pageContext.request.contextPath}${book.imgPath }" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title }</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author }</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${book.price }</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales }</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock }</span>
					</div>
					<div class="book_add">
						<button class="add2Cart" name="${book.id }">加入购物车</button>
						<%-- <a href="Client/CartServlet?method=addBook2Cart&bookId=${book.id }">加入购物车</a> --%>
					</div>
				</div>
			</div>
		
		</c:forEach>	
		</div>
		<%@ include file="/WEB-INF/include/page.jsp" %>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>