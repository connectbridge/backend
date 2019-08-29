<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bridge Login</title>
</head>
<body>
<c:out value="${_csrf.parameterName}"/>
	<h1>LOGIN FORM</h1>
	<form:form action="/auth/loginProcess" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type ="text" name="id">
		<input type ="password" name="password">
		<input type ="submit" name="로그인">
	</form:form>
</body>
</html>