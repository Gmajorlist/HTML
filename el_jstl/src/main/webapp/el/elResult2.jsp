<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="noble" uri="tld" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자바클래스의 메소드를 이용</h3>

${ param['x']} + ${ param['y'] } = ${ noble:sum(param['x'], param['y']) } <br><br>

${ param.x} * ${ param.y } = ${ noble:mul(param.x, param.y) }

</body>
</html>