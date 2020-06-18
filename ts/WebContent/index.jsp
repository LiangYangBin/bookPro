<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>会员登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
<link href="http://52bbx.top/bbx/css/style.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<center><h1 style="color:red;">${msg }</h1></center>
		<div class="main-agileinfo">
			<div class="agileits-top"> 
				<form action="Logon" method="post"> 
					<input class="text" type="text" name="phone" placeholder="请输入手机号" required="" maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" />
					<input class="text" type="password" name="password" placeholder="请输入密码" required="">
					<div class="wthree-text"> 
						<ul> 
							<li style="color:rgb(255, 255, 255);"><input type="radio" value="1" name="remember">记住密码</li>
						</ul>
						<div class="clear"> </div>
					</div>   
					<input type="submit" value="登录">
				</form>
				<a href="login.jsp"><p>创建一个账号?</p></a>
			</div>	 
		</div>	
		
		<ul class="w3lsg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>	
	<!-- //main --> 
	
</body>
</html>
