<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//데이터
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoard(seq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
	font-size: 8pt;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<%if(boardDTO != null){ %>
<form name="boardWriteForm" method="post" action="boardWrite.jsp">
	<h3>
		<img src="../image/vlvlan.png" width="30" height="30" alt="ㅗㅗ" 
		onclick="location.href='../index.jsp'" style="cursor: pointer;"> 작성한 글확인
	</h3>
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="50" value="<%=boardDTO.getSubject()%>">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="content" cols="50" rows="15"><%=boardDTO.getSubject()%></textarea>  <!-- textarea 벨류값이 없음 쓰면안돼 -->
				<div id="contentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="목록" onclick="">
			</td>
		</tr>
	</table>
</form>
<%} %>
</body>
</html>