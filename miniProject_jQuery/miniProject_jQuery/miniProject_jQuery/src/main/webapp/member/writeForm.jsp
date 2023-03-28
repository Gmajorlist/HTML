<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#writeForm {
	display: inline-block;
	flex-direction: column;
	align-items: center;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
}
#writeForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
	<form id="writeForm" method="post" action="">
	<h2>회원가입</h2>
	<table border="1" cellpadding="5" cellspacing="0" style="margin: 0 auto;">
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name" id="name" style="width: 100px" placeholder="이름 입력">
			<div id="nameDiv"></div>
		</td>
	</tr>
	
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" id="id" size="30" placeholder="아이디 입력" />
			<input type="hidden" id="check" value="">
			<div id="idDiv"></div>
		</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="pwd" id="pwd" size="40">
			<!-- 비밀번호는 input type을 password로 -->
			<div id="pwdDiv"></div>
		</td>
	</tr>
	
	<tr>
	 	<th>재확인</th>
	 	<td>
	 		<input type="password" name="repwd" id="repwd" size="40">
	 	</td>
	 </tr>
	 
	 <tr>
		<th>성별</th>
		<td>
			<input type="radio" name="gender" id="gender_m" value="0" checked/>
			<label for="gender_m">남자</label>
			&nbsp; <!-- 간격을 한칸 떨어트린다. -->
			<input type="radio" name="gender" id="gender_w" value="1" />
			<label for="gender_w">여자</label>
			<!-- 글자를 눌러도 선택되게끔해야 한다. 단 id 속성이 필요하다. -->
		</td>
	</tr>
	 		
	<tr>
		<th>이메일</th>
		<td>
			<input type="text" name="email1" style="width: 120px;"> 
			@
			<input type="text" name="email2" id="email2" style="width: 120px;">
			<select name="email3" id="email3" style="width: 120px;" onchange="select()">
					<!-- 무언가 바뀌었을 때 사용하는 이벤트는 onchange=javascript 함수 호출 -->
					<option value="">직접입력</option> 
					<!-- 직접 입력하겠다고 하는 부분은 공백으로 -->
					<option value="naver.com">naver.com</option>
					<option value="gamil.com">gmail.com</option>
					<option value="nate.com">nate.com</option>
			</select>
			
			<div id="email1"></div>
			<div id="email2"></div>
		</td>
	</tr>
	
	<tr>
		<th>휴대폰</th>
		<td>
			<select name="tel1" style="width: 50px">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="019">019</option>
				<option value="070">070</option>
			</select>
			- 
			<input type="text" name="tel2" style="width: 70px"> 
			- 
			<input type="text" name="tel3" style="width: 70px">
		</td>
	</tr>
	
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="zipcode" id="zipcode" size="5" placeholder="우편번호" readonly>
			<input type="button" value="우편번호검색" onclick="execDaumPostcode()">
			<br>
			<input type="text" name="addr1" id="addr1" style="width: 400px" placeholder="주소" readonly/>
			<div id="addr1"></div>
			<input type="text" name="addr2" id="addr2" style="width: 400px" placeholder="상세주소">	
			<div id="addr2"></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="회원가입" id="writeBtn">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../js/member.js"> /* 상대주소 */</script>
<script type="text/javascript">

//중복 아이디 체크(포커스 기능)
$('#id').focusout(function(){
	if($('#id').val() == '') {
		$('#idDiv').text('먼저 아이디를 입력하세요.')
		$('#idDiv').css('color', 'matenta');
		
	} else {
		//서버 요청
		$.ajax({
			type: 'post',
			url: '/miniProject_jQuery/member/checkId.do',
			data: 'id='+$('#id').val(), //서버로 보내는 데이터
			dataType: "text", //서버로부터 받은 데이터형, "text, "html", "xml", "json"
			success: function(data) {
				data = data.trim();
				
				if(data == 'exist') {
					$('#idDiv').text('사용 불가능');
					$('#idDiv').css('color', 'red');
					
				} else if(data == 'non_exist') {
					$('#idDiv').text('사용 가능');
					$('#idDiv').css('color', 'blue');
				
					// 중복체크 확인용
					$('#check').val($('#id').val());
				}
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
});
</script>
<!-- 중간에 checkid는 창을 여러번 뜨는 것을 방지  -->
<!-- 절대주소 -->
<!-- <script type="text/javascript" src="http://localhost:8080/memberServlet/js/member.js"> -->
<!-- 스크립트 순서가 바뀌면 실행이 안 되니 절대로 순서가 바뀌면 안 된다. -->

</body>
</html>