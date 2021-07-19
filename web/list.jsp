<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<body>
	<%
	     Object message = request.getAttribute("message");
	     if(message!=null && !"".equals(message)){
	 
	%>
	     <script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	     </script>
	<%} %>
	<div align="center">
		<h1 style="color: red;">账单列表</h1>
		<a href="index.jsp">返回主页</a>
		<table class="tb">
			<tr>
				<td>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;</td>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;</td>
				<td>消费总额</td>
				<td>消费时间</td>
				<td align="center" colspan="2">操作</td>
			</tr>
			<c:forEach items="${accounts}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.amount}</td>
					<td>${item.money}</td>
					<td>${item.time}</td>
					<td><a href="AccountServlet?method=getByname2&name=${item.name}">修改</a></td>
					<td><a href="AccountServlet?method=getByname&name=${item.name}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>