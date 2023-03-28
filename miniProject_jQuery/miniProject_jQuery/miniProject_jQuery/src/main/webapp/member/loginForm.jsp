<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form[name="loginForm"] {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 0 auto;
	text-align: left;
}
form[name="loginForm"] div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="loginForm" id="loginForm">
	<img src="../image/sample.png" width="300" height="300" alt="마시마로" 
	onclick="location.href='../index.do'" style="cursor: pointer;"><br>
	<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" id="id">
			<div id=idDiv></div>
		</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="pwd" id="pwd">
			<div id=pwdDiv></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="로그인" id="loginBtn">
			<input type="button" value="회원가입" onclick="location.href='/miniProject_jQuery/member/writeForm.do'">
		</td>
	</tr>
</table>
<br><br>

<div id="loginResult"></div>


</form>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$('#loginBtn').click(function(){ // {코드}
	$('#idDiv').empty(); // empty() 깨끗하게 제거가 된다. = document.getElementById("idDiv").innerText = "";
	$('#pwdDiv').empty();
	
	if( $('#id').val() == '') {
		$('#idDiv').text('아이디 입력');
		$('#id').focus(); // 커서 자동으로 넣어줌
	// if(document.getElementById("id").value == "") document.getElementById("idDiv").innerText="아이디 입력";
	}
	else if($('#pwd').val() == '') {
		$('#pwdDiv').text('비밀번호 입력');
		$('#pwd').focus();
	// else if(document.getElementById("pwd").value == "") document.getElementById("pwdDiv").innerText="비밀번호 입력";
	}
	else {
		$.ajax({ //$ = jQuery
			type: 'post', // 'get' or 'post'
			url: '/miniProject_jQuery/member/login.do',
			data: 'id='+$('#id').val()+'&pwd='+$('#pwd').val(),// 서버로 보낼 데이터(id, pwd) | '변수=값&변수=&값'
			dataType: 'text', //서버로부터 받는 자료형, text, xml, html, json
			success: function(data){
				data = data.trim();
				
				if(data == 'ok') {
					location.href = '../index.jsp';
				} else if (data == 'fail') {
					$('#loginResult').text('아이디 또는 비밀번호가 맞지 않습니다.');
					$('#loginResult').css('font-size', '12pt');
				}
			},
			
			error: function(err){
				console.log(err); // 콘솔에 에러를 팍팍 찍어주세요.
			}
		});
	}
});
</script>
</body>
</head>
</html>