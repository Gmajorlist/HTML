package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		String seq = request.getParameter("seq");
		String pg = request.getParameter("pg");
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("seq", seq);
		request.setAttribute("display", "/board/boardView.jsp");
		return "/index.jsp";
	}

}
