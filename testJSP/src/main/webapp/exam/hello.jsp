<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
//선언문- 1번만 실행이됩니다.
	String name ="홍길동";
	int age = 25;
%>
<%
//스크립트릿  = 지역,호출시마다 실행
	age++;
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- LLLLLLLLLLLLL<br>      HTML 주석             주석의 문제 홈페이지에서 우리 눈에만 안보이고 소스보기 하면 다 보임--> 

<%-- BBBBBBBBBBBBB<br>      JSP 주석              이거는 홈페이지에 소스보기해도 안보임--%>



내 이름은 <%=name %>이다 <br>
<% out.println("나의 이름은 " + name + "입니다"); %>

<!-- 내 나이는 <%=age %>살이다 <br>   -->

<%-- 내 나이는 <%=age %>살이다 <br>   --%> 


</body>
</html>