<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body background="1.jpg">
<%
	     Object message = request.getAttribute("message");
	     if(message!=null && !"".equals(message)){
	 
%>
	 <script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	     </script>
<%} %>
	<div align="center">
		<h1 style="color: red;">信息录入</h1>
		<a href="index.jsp">返回主页</a>
		<form action="AccountServlet?method=add" method="post" onsubmit="return check()">
			<div >
				名称<input type="text" id="name" name="name"/>
			</div>
			<div >
				数量<input type="text" id="amount" name="amount" />
			</div>
			<div >
				总额<input type="text" id="money" name="money" />
			</div>
			<div >
				时间<input type="text" id="time" name="time" />
			</div>
			<div >
				<button type="submit" >保&nbsp;&nbsp;&nbsp;存</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function check() {
			var a = document.getElementById("name");
			var b= document.getElementById("amount");
			var c = document.getElementById("money");
			//非空
			if(a.value == '') {
				alert('名称为空');
				a.focus();
				return false;
			}
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