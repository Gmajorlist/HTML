<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
<img src="../image/sample.png" width="300" height="300" alt="마시마로" 
onclick="location.href='../index.do'" style="cursor: pointer;"><br>
<h3>로그아웃</h3>
<input type="button" value="로그인" onclick="location.href='loginForm.do'">
<script type="text/javascript">
window.onload=function() {
	alert("로그아웃");
	location.href = "/mvcMember/member/loginForm.do";
}
</script>
</body>
</html>