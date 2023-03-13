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
<form name="boardWriteForm" method="post" action="">
	<h3>
		<img src="../image/vlvlan.png" width="30" height="30" alt="안녕" 
		onclick="location.href='../index.jsp'" style="cursor: pointer;"> 작성한 글확인
	</h3>
	<table width="450" border="2" cellpadding="5" cellspacing="0" fram="hside" rules="rows">
		<tr><!--white -space 먹힐려면 테이블에서 넚이를 잡아줘야합니다  -->
			
			<td colspan=3>
				<h2<%=boardDTO.getSubject()%>"></h2>
				
			</td>
		</tr>
		<tr>
			<td width="150" align="center">글번호 :<%=boardDTO.getSubject()%></td>
			<td width="150" align="center">작성자 :<%=boardDTO.getSubject()%></td>
			<td width="150" align="center">조회수 :<%=boardDTO.getSubject()%></td>
		</tr>	
		
		<tr>
			<td colspan="3" height="250" valign="top">
				<div style="width:100%, hiught: 100%; overflow: auto; " >
					<pre style="white-space: pre-line; word-break: break-all;"><%=boardDTO.getSubject()%></pre>
				</div>
			</td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="history.go(-1)">
</form>
<%} %>
</body>
</html>