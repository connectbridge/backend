<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Personal Page</h1>
	<c:if test="${not empty loginId}">
		${loginId} 님 안녕하세요; <BR>
	</c:if>
${memberId} 님 개인페이지 입니다; <BR> 
<c:set var="memberId2" value="${memberId}" />

</body>
</html>