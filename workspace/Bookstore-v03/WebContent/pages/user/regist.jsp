<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
<script type="text/javascript">

	$(function(){
		
		//正则表达式，用来检查字符串是否符合规则
		/* var reg = /^a/;
		var flag = reg.test("sdafs");
		alert(flag); */
		
		
		//获取按钮，并为按钮绑定单击响应函数
		$("#sub_btn").click(function(){
			//获取表单项信息
			var name = $("[name=username]").val();
			var password = $("[name=password]").val();
			var pwd = $("[name=repwd]").val();
			var email = $("[name=email]").val();
			var code = $("[name=code]").val();
			
			//对用户输入的表单项信息进行验证
			//对用户名进行验证
			var reg = /^[A-Za-z0-9_-]{3,16}$/;
			var flag = reg.test(name);
			if(!flag){
				alert("您输入的用户名不符合要求，需要输入一个3~16位，且由字母和数字组成");
				return false;
			}
			
			//对密码进行验证
			reg = /^[a-z0-9_-]{6,18}$/;
			flag = reg.test(password);
			if(!flag){
				alert("您输入的密码不符合要求");
				$("[name=password]").val("");
				$("[name=repwd]").val("");
				return false;
			}
			
			//对确认密码验证
			if(!(password == pwd)){
				alert("密码与确认密码不一致，请重新输入！");
				$("[name=password]").val("");
				$("[name=repwd]").val("");
				return false;
			}
			
			//对邮箱进行验证
			reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!reg.test(email)){
				alert("您输入的邮箱信息不符合要求，请重新输入！");
				return false;
			}
			
			//对验证码进行验证
			if(code == ""){
				alert("请输入验证码！！");
			}

			//取消按钮的默认行为
			//return false;
		})
	})
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></span>
							</div>
							<div class="form">
								<!-- <form action="Client/RegistServlet" method="post"> -->
								<form action="Client/UserServlet?method=regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" <%=request.getParameter("username")==null?"":"value="+request.getParameter("username") %> type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>