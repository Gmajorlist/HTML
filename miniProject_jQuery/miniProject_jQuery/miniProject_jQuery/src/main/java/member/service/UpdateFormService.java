package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		HttpSession session = request.getSession();
		
		/* String id = ;  */ // 세션으로부터 id값을 얻어오기;
		String id = (String) session.getAttribute("memId");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.getMember(id);
		
		return "/member/updateForm.jsp";
	}

}
