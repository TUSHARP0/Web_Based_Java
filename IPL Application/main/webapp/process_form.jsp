<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="data"/>
<body>
<h1>Message: ${applicationScope.data.validateAndAddPlayer()}</h1>
</body>
</html>