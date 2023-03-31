<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#boardReplyForm div{
	font-size: 8pt;
	color: red;
	font-weight: bold;
} /* boardWriteForm에서 가져왔다 그리고 이름만 바꿈 */
</style>
</head>
<body>

<form id="boardReplyForm">
<input type="text" name="seq" value="${seq }">
<input type="text" name="pg" value="${pg }">
	<h3>답글쓰기</h3>
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="50">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="content" cols="50" rows="15"></textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="답글쓰기" id="boardReplyBtn">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>

 <script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
 <script type="text/javascript"> 
 $(function(){
	 $('#boardReplyBtn').click(function(){
		 $('#submitDiv').empty();
		 $('#contentDiv').empty();
		 
		 if($('#subject').val() == ''){
			 $('#subjectDiv').text('제목을 입력하시오');
			 $('#subject').focus();
		 }else if($('#content').val() == ''){
			 $('#contentDiv').text('내용을 입력하시오');
			 $('#content').focus();
		 }else{
			 $.ajax({
				 type: 'post',
				 url: '/miniProject_jQuery/board/boardReply.do',
				 data: $('#boardReplyForm').serialize(), //seq, pg, subject, content 넘겨줌
				 success: function(){
					 alert('답글작성 완룡!!');
					 location.href='/miniProject_jQuery/board/boardList.do?pg='+${pg};
				 },
				 error: function(err){
					 console.log(err);
				 }
			 });
		 }
	 });
 });
 </script>

<script type="text/javascript">
function checkBoardWrite(){
	/* document.getElementById("subjectDiv").innerText = "";
	document.getElementById("contentDiv").innerText = ""; */
	
	if(document.getElementById("subject").value == ""){
		document.getElementById("subjectDiv").innerText = "제목 입력";
		document.getElementById("subject").focus();
	
	}else if(document.getElementById("content").value == ""){
		document.getElementById("contentDiv").innerText = "내용 입력";
		document.getElementById("content").focus();
	
	}else
		document.boardWriteForm.submit();
}
</script>
</body>
</html>












