<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
</head>
<body background="">
	<%
	     Object message = request.getAttribute("message");
	     if(message!=null && !"".equals(message)){
	 
	%>
	     <script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	     </script>
	<%} %>
	<div align="center">
		<h1 style="color: red;">信息修改</h1>
		<a href="index.jsp">返回主页</a>
		<form action="AccountServlet?method=update" method="post" onsubmit="return check()">
			<div class="a">
				名称<input type="text"  name="name" value="${account.name}"/>
			</div>
			<div class="a">
				密码<input type="text" id="amount" name="amount" value="${account.amount}"/>
			</div>
			<div class="a">
				消费<input type="text" id="money" name="money" value="${account.money}"/>
			</div>
			<div class="a">
				时间<input type="text"  name="time" value="${account.time}"/>
			</div>
			<div class="a">
				<button type="submit" class="b">修&nbsp;&nbsp;&nbsp;改</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function check() {
			var b = document.getElementById("amount");
			var c = document.getElementById("money");
			
			//非空
			
			if(b.value == '') {
				alert('数量为空');
				b.focus();
				return false;
			}
			if(c.value == '') {
				alert('消费为空');
				c.focus();
				return false;
			}
		}
	</script>
</body>
</html>