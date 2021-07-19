<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
<body background="del.jpg">
<%
	     Object message = request.getAttribute("message");
	     if(message!=null && !"".equals(message)){
	 
%>
	 <script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	     </script>
<%} %>
<div align="center">
		<h1 style="color: red;">账本删除</h1>
		<a href="index.jsp">返回主页</a>
		<table class="tb">
			<tr>
				<td>姓名</td>
				<td>${account.name}</td>
			</tr>
			<tr>
				<td>数量</td>
				<td>${account.amount}</td>
			</tr>
			<tr>
				<td>消费</td>
				<td>${account.money}</td>
			</tr>
			<tr>
				<td>时间</td>
				<td>${account.time}</td>
			</tr>
		</table>
		<div >
			<a onclick="return check()" href="AccountServlet?method=delete&name=${account.name}">删&nbsp;&nbsp;&nbsp;除</a>
		</div>
	</div>
	<script type="text/javascript">
		function check() {
			if (confirm("真的要删除吗？")){
				return true;
			}else{
				return false;
			}
		}
	</script>
</body>
</html>