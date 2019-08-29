<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="index.action" method="post">
	<input type="text" name="txt" value="${txt }">
	<input type="submit">
</form>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>操作</th>
		<!-- <th>商品号</th> -->
	</tr>
	<c:forEach items="${cusList }" var="row">
	<tr>
		<td>${row.cus_no }</td>
		<td>${row.cus_name }</td>
		<td>${row.cus_sex }</td>
		<%-- <th>${row.pro_name }</th> --%>
		<td><a href="#">修改</a></td>
		<td><a href="#">删除</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>