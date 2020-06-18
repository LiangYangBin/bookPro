<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>会员注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
<link href="http://52bbx.top/bbx/css/style.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
	<center><h1 style="color:red;">${msg }<a href="logon.jsp">${msg1 }</a></h1></center>
		<div class="main-agileinfo">
			<div class="agileits-top"> 
				<form action="login" method="post"> 
					<input class="text" type="text" name="username" placeholder="请输入昵称" required="">
					<input class="text" type="text" name="phone" placeholder="请输入手机号码" required="" maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" />
					<input class="text" type="password" name="password1" placeholder="请输入密码" required="">
					<input class="text" type="password" name="password2" placeholder="请输入确认密码" required="">
					<input type="submit" value="注册">
				</form>
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
</body>
</html>
