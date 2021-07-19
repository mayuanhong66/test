<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<style>
			body{
				margin:0 auto;background:url(taiji.jpg) no-repeat 0 0;
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
<h1 style="color: red;"> 查找 </h1>
		<a href="index.jsp">返回主页</a>
		<form action="AccountServlet?method=getByname" method="post" onsubmit="return check()">
		<div >
				名字<input type="text" id="name" name="name"/>
			</div>
			<div >
				<button type="submit" >查&nbsp;&nbsp;&nbsp;询</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function check() {
			var name = document.getElementById("name");
			
			//非空
			if(name.value == '') {
				alert('名称为空');
				name.focus();
				return false;
			}
		}
	</script>
</body>
</html>