<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="page_nav">
		<!-- 向域中设置变量 -->
		<c:choose>
			<c:when test="${requestScope.page.totalPage<5 }">
				<c:set value="1" var="begin"></c:set>
				<c:set value="${requestScope.page.totalPage}" var="end"></c:set>
			</c:when>
			<c:when test="${requestScope.page.pageNo<3 }">
				<c:set value="1" var="begin"></c:set>
				<c:set value="5" var="end"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${requestScope.page.pageNo-2 }"></c:set>
				<c:set var="end" value="${requestScope.page.pageNo+2 }"></c:set>
				<c:if test="${end > requestScope.page.totalPage }">
					<c:set var="begin" value="${requestScope.page.totalPage-4 }"></c:set>
					<c:set var="end" value="${requestScope.page.totalPage }"></c:set>
				</c:if>
			</c:otherwise>
		</c:choose>
		<a href="${requestScope.page.path }&pageNo=1&pageSize=4">首页</a>
		<a href="${requestScope.page.path }&pageNo=${requestScope.page.pageNo-1 }&pageSize=4">上一页</a>
		
		<c:forEach begin="${begin }" end="${end}" var="index">
			<c:choose>
				<c:when test="${requestScope.page.pageNo==index }">
					<span style="color:red;">【${index}】</span>
				</c:when>
				<c:otherwise>
					<a href="${requestScope.page.path }&pageNo=${index}&pageSize=4">${index }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<a href="${requestScope.page.path }&pageNo=${requestScope.page.pageNo+1 }&pageSize=4">下一页</a>
		<a href="${requestScope.page.path }&pageNo=${requestScope.page.totalPage }&pageSize=4">末页</a>
		共${requestScope.page.totalPage }页，${requestScope.page.totalRecord }条记录 到第<input value="${requestScope.page.pageNo }" name="pn" id="pn_input"/>页
		<input type="button" value="确定">
		
		<script type="text/javascript">
			$(":button:last").click(function(){
				var pageNo = $("#pn_input").val();
				//可以通过改变window对象下location的href属性来跳转
				window.location.href="${requestScope.page.path }&pageSize=4&pageNo="+pageNo;
			})
		
		</script>
		
		</div>