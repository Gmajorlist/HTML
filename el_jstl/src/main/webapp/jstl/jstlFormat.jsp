<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:formatNumber type="number" value="123456789"/><br>
<fmt:formatNumber type="number" value="123456789.88"/><br>
<fmt:formatNumber type="number" value="123456789.88" maxFractionDigits="1"/><br><!--maxFractionDigts 반올림  -->

<fmt:formatNumber type="number" value="123456.78" pattern="#,###"/><br>
<fmt:formatNumber type="number" value="123456.789" pattern=".##"/><br>
<fmt:formatNumber type="number" value="123456.789" pattern="#,##.##"/><br>

<fmt:formatNumber type="number" value="0000.00" pattern="#,##.##"/><br>
<fmt:formatNumber type="number" value="0000.00" pattern="0,00.00"/><br>
<fmt:formatNumber type="number" value="12.3" pattern="000.00"/><br> 
<br>

<!-- 자바코드랑 달러표시랑 같이 쓰는 것을 피해줘 -->
<c:set var="now" value="<%=new java.util.Date() %>"/>
<c:out value="${now }"/><br>
date : <fmt:formatDate value="${now }" type="date" /> <br>
time : <fmt:formatDate value="${now }" type="time" /> <br>
both : <fmt:formatDate value="${now }" type="both" /> <br>
<br>
<fmt:formatDate value="${now }" pattern="yy-MM-dd hh:mm" type="both"/><br>
<fmt:formatDate value="${now }" pattern="yy-MM-dd"  type="date"/><br>
<fmt:formatDate value="${now }" pattern="yy-MM-dd E요일 a" type="date"/><br>
<fmt:formatDate value="${now }" pattern="HH:mm:ss" type="time"/><br>

모든부모는 인터페이스로 설정 - 자식이 통일성을 위해 추상메소드를 쓴다
추상메소드에는 서블릿으로 받은 request 
</body>
</html>
서블릿 jsp - request 
java - 인터페이스(부모)추상메소드
DB - 추상메소드(request)
servelt >(forward) jsp







