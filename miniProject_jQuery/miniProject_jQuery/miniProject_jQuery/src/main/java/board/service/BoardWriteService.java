package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		/* request.setCharacterEncoding("UTF-8"); */

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// 세션
		HttpSession session = request.getSession();
		 
		String id = (String)session.getAttribute("memId"); 
		String name = (String)session.getAttribute("memName"); 
		String email = (String)session.getAttribute("memEmail");
		
		Map<String, String> map = new HashMap<String, String>(); // boardDTO 대신 map에 전달받은 5개의 데이터를 저장 
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content); // map으로 다음과 같은 변수를 집어 넣는다.
		
		// DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		return "/board/boardWrite.jsp";
	}

}
