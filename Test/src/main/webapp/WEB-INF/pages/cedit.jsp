<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
	margin-left: 20px;
	margin-top: 20px;
}
	select {
	margin-left: 20px;
	margin-top: 20px;
}
</style>
</head>
<body>
<c:if test="${cus!=null }">
	<form action="update.action">
		<input name="id" type="hidden" value="${cus.id }">
</c:if>
<c:if test="${cus==null }">
	<form action="insert.action">
</c:if>
	<span>编号</span>
	<input name="cus_no" value="${cus.cus_no }"><br>
	<span>姓名</span>
	<input name="cus_name" value="${cus.cus_name }"><br>
	<span>性别</span>
	<select name="cus_sex">
		<c:forEach items="${cus_sexList }" var="r" varStatus="v">
			<option value="${v.index }" 
				<c:if test="${cus.cus_sex==v.index }">
					<c:out value="selected='selected'"></c:out>
				</c:if>
				>${r }
			</option>
		</c:forEach>
	</select> <br>
	<span>商品</span>
	<select name="pro_id">
		<c:forEach items="${proList }" var="row">
			<option value="${row.id }" 
				<c:if test="${cus.pro_id==row.id }">
					<c:out value="selected='selected'"></c:out>
				</c:if>
				>${row.pro_no }
			</option>
		</c:forEach>
	</select> <br>
	<input type="submit" style="margin-left: 70px">
</form>
</body>
</html>