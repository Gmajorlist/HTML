<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%
	//데이터
	request.setCharacterEncoding("UTF-8");

	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	//세션
	//HttpSession session = request.getSession();
	String id = (String)session.getAttribute("memId");
	String name = (String)session.getAttribute("memName");
	String email = (String)session.getAttribute("memEmail");
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("id", id);
	map.put("name", name);
	map.put("email", email);
	map.put("subject", subject);
	map.put("content", content);
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.boardWrite(map);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
window.onload=function(){
	alert("글작성 완료");
	location.href = "./boardList.jsp";
}
</script>
</body>
</html>















