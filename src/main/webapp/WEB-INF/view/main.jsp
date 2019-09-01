<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MAIN</h1>
	<h2>
		<a href="/auth/joinForm">JOIN</a><BR> <a href="/auth/loginForm">LOGIN</a>
	</h2>

	<form action="/auth/logout" method="POST">
		<input type="submit" value="Logout" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>