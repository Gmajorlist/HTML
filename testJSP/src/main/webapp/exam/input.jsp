<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:beige">
<form name="inputForm" method="get" action="result.jsp">
<center>
<h1>데이터</h1>
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th align="center">X</th>
		<td>
			<input type="text" name="X">
		</td>
	</tr>
	<tr>
		<th align="center">Y</th>
		<td>
			<input type="text" name="Y">
		</td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="계산"> <!-- submit - 입력상자의 데이터를 들고 이동 (action로 쓴 주소) -->
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</body>
</html>