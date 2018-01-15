<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<c:forEach items="${orders }" var="order">
				<tr>
					<td>${order.id }</td>
					<td><fmt:formatDate value="${order.createDate }" type="both"/> </td>
					<td>${order.totalAmount }</td>
					<td>
						<c:choose>
							<c:when test="${order.state==0 }">
								未发货
							</c:when>
							<c:when test="${order.state==1 }">
								<a href="Client/OrderClientServlet?method=takeBook&orderId=${order.id }">已接收</a>
							</c:when>
							<c:otherwise>
								交易完成
							</c:otherwise>
						</c:choose>
					</td>
					<td><a href="Client/OrderClientServlet?method=orderInfo&orderId=${order.id }">查看详情</a></td>
				</tr>	
			</c:forEach>
		</table>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>