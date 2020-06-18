<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>后台管理</title>
</head>
<body>
	<h1>图书借阅管理</h1>
	<ul class="nav nav-tabs">
	  <li role="presentation"><a href="admin">图书管理</a></li>
	  <li role="presentation"  class="active"><a href="#">借阅管理</a></li>
	</ul>
	<table class="table table-hover">
		<tr>
			<th>图书编号</th>
			<th>图书名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${bookList }" var="book">
			<tr>
				<td>${book.bid }</td>
				<td>${book.bname }</td>
				<td><a href="delRbook?rBid=${book.bid }">归还</a></td>
			</tr>
	  	</c:forEach>
		
	</table>
</body>
</html>