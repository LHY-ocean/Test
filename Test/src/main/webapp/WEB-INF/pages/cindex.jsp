<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("是否删除？")){
			open("delete.action?id="+id,"_self")
		}
	};
</script>
</head>
<body>
<form action="index.action" method="post">
	<input type="text" name="txt" value="${txt }">
	<button type="submit">查询</button>
	<button type="button" onclick="window.open('add.action','_self')">新增</button>
</form>


<table> 
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>商品号</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${cusList}" var="row">
	<tr>
		<td>${row.cus_no }</td>
		<td>${row.cus_name }</td>
		<td>${row.cus_sexname }</td>
		<td>${row.pro_no }</td>
		<td><a href="upd.action?id=${row.id }">修改</a></td>
		<td><a href="javascript:del(${row.id })">删除</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>