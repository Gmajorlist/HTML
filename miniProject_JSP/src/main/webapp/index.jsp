<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a:link {color: magenta; text-decoration: non;}
a:visited{color: pink; text-decoration: non;}
a:hover{color:green; text-decoration: underline;}
a:active{color:orange; text-decoration: non;}
</style>
</head>
<body style="background-color:beige">
<div style="text-align:center;">
<h3>

<img src="../image/vlvlan.png" width="30" height="30" alt="꽃" 
onclick="location.href='../index.jsp'" style="pointer" >
</h3>
<h2>   메인화면   </h2>
<h3>
<% if(session.getAttribute("memId") == null){%>
	<a href="./member/writeForm.jsp">회원가입</a><br>
	<a href="./member/loginForm.jsp">로그인</a><br>
	
<%}else{%>
	<a href="./member/logout.jsp">로그아웃</a><br>
	<a href="./member/updateForm.jsp">회원정보수정</a><br>
	<a href="./member/deleteForm.jsp">회원탈퇴</a><br>
	<a href="./board/boardWriteForm.jsp">글쓰기</a><br>
<%}%>	

<a href="">목록</a><br>


</h3>
</div>
</body>
</html>