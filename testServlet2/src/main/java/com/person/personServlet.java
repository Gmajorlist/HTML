package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dark")
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//데이터
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String color = request.getParameter("color");
		String[]hobby = request.getParameterValues("hobby"); // 배열
		String[]subject = request.getParameterValues("subject");
	// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body style='background: beige;'>");
		out.println("<ul style='border: 1px solid skyblue; color:" + color +"'>");
		out.println("<li>이름 : " + name);
		out.println("<br>");
		out.println("<li>성별 : ");
		if(gender.equals("0")) out.println("남");
		else if(gender.equals("1"))out.println("여");
		out.println("<br>");
		out.println("<li>색깔 : " + color);
		out.println("<br>");
		out.println("<li>취미 : " );
		for(int i=0; i<hobby.length; i++) {
			out.println(hobby[i]);
		}
		out.println("<br>");
		
		out.println("<lib>과목: ");
		for(String data : subject) {
			out.println(data);
		}
		out.println("<br>");
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");	
	
	}

}
