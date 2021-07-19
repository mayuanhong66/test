<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style >
.a{
		font-size: 26px;
		margin-top: 20px;
	}
</style>
</head>
<body>
<div align="center">
<h1 style="color: red;">家庭记账本</h1>
		<div class="a">
			<a href="add.jsp">创建账本</a>
		</div>
		<div class="a">
			<a href="deleteByname.jsp">账本删除</a>
		</div>
		<div class="a">
			<a href="AccountServlet?method=list">查阅账本</a>
		</div>
</div>
</body>
</html>