<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%
//데이터
String id = request.getParameter("id");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
boolean existId = memberDAO.isExistId(id); // 아이디가 있다 /true/ 사용 불가능


%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:beige">
<%if(existId) { %>
<form action="checkId.jsp"> 
	 <h3><%=id %>는 사용 불가능</h3>
	 아이디<input type="text" name="id"> <input type="submit" value="중복체크">
</form>
<%}else{ %>
	<h3><%=id %>는 사용 가능</h3>
	<input type="button" value="사용하기" onclick="checkIdClose('<%=id %>')">
<%} %>
<script type="text/javascript">
function checkIdClose(id){
	opener.writeForm.id.value = id             /*숫자 "문자"    따옴표가없으면 다 숫자로 입력해버림*/
	opener.writeForm.check.value = id  /*  중복체크 보큰눌렀다는 확인 */
	window.close()
	opener.writeForm.pwd.focus()
}
</script>
</body>
</html>