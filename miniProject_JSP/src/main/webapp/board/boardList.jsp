<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="board.bean.BoardPaging" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%
//데이터
int pg = Integer.parseInt(request.getParameter("pg"));

Map<String, Integer>map = new HashMap<String, Integer>();
//세션
String memId = (String)session.getAttribute("memId");
//1페이지당 5개씩
int endNum = pg*5;
int startNum = endNum -4;

map.put("startNum", startNum);
map.put("endNum", endNum);

//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> list = boardDAO.boardList(map);

// 페이징처리
	int totalA = boardDAO.getTotalA();//총 글수	

	BoardPaging boardPaging = new BoardPaging();
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(totalA);
	
	boardPaging.makePagingHTML();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<style>
.subjectA:link {color: magenta; text-decoration: non;}
.subjectA:visited{color: pink; text-decoration: non;}
.subjectA:hover{color:green; text-decoration: underline;}
.subjectA:active{color:orange; text-decoration: non;}
#currentPaging{
	color:green;
	border:0px solid pink;
	padding: 1px ;  /*top  bottom ///   left right   */
	margin: 5px; /*top right bottom left   */
	cursor: pointer;
}
#paging{
	color:pink;
	padding: 5px;
	margin: 5px;
	cursor: pointer;

}
</style>
</style>
</head>
<body style="background-color:beige">
<center>
<h3>
<img src="../image/vlvlan.png" width="30" height="30" alt="꽃" 
onclick="location.href='../index.jsp'" style="pointer" >목록
</h3>
<table border="1" width="500px" align="center" fram="hsides"rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>	
<%if(list != null){ %>
	<%for(BoardDTO boardDTO : list){ %>
		<tr>
			<td align="center"><%=boardDTO.getSeq() %></td>
			<td><a class="subjectA" href="#" onclick="isLogin('<%=memId %>',<%=boardDTO.getSeq()%>,<%=pg %>)"><%=boardDTO.getSubject() %></a></td>
			<td align="center"><%=boardDTO.getId()%></td>
			<td align="center"><%=boardDTO.getHit()%></td>
			<td align="center">
			<%= new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime()) %></td>
		</tr>
	<%}//for %>
<%}//if %>
</table>
<div style=" margin-top:15px width:850px; text-align:center;">
<%=boardPaging.getPagingHTML() %>
</div>
</center>
<script type="text/javascript">
function boardPaging(pg){
	location.href = "boardList.jsp?pg=" +pg;
}

function isLogin(memId, seq){
	alert(memId +", " + seq)
	if(memId == 'null') alert("먼저 로그인해")
	else
		location.href="boardView.jsp?seq=" +seq + "&pg" + pg;
}
</script>
</body>
</html>