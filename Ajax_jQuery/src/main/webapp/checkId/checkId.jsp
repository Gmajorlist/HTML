<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <!--XML태그 시작전의 공백을 제거  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- DB연동 -> 만약에 user_id가 hong이면 이미DB저장된 아이디로 취급(true)  --%>
<c:set var="result" value="false"/>
<c:if test="${param.user_id == 'hong' }">
	<c:set var="result" value="true"/>
</c:if>

<%-- XML로 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<check_id>
	<result>${result}</result>
</check_id>