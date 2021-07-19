<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.a{
		margin-top: 20px;
	}
	.b{
		font-size: 20px;
		width: 160px;
		color: white;
		background-color: greenyellow;
	}
	.tb, td {
		border: 1px solid black;
		font-size: 22px;
	}
</style>
</head>
<body background="show.jpg">
	<div align="center">
		<h1 style="color: red;">信息列表</h1>
		<a href="index.jsp">返回主页</a>
		<table class="tb">
			<tr>
				
				<td>名称</td>
				<td>密码</td>
				<td>消费</td>
				<td>时间</td>
			</tr>
			<!-- forEach遍历出adminBeans -->
			<c:forEach items="${accounts}" var="item" varStatus="status">
				<tr>
					<td>${item.name}</td>
					<td><a>${item.amount}</a></td>
					<td>${item.money}</td>
					<td>${item.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>