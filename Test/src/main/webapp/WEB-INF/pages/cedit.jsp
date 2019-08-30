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
<c:if test="${cus!=null }">
	<form action="update.action">
		<input name="id" type="hidden" value="${cus.id }">
</c:if>
<c:if test="${cus==null }">
	<form action="insert.action">
</c:if>
	<input name="cus_no" value="${cus.cus_no }">
	<input name="cus_name" value="${cus.cus_name }">
	<input name="cus_sex" value="${cus.cus_sex }">
	<input name="pro_id" value="${cus.pro_id }">
	<input type="submit">
</form>
</body>
</html>