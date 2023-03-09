package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		int X = Integer.parseInt(request.getParameter("X"));
		int Y = Integer.parseInt(request.getParameter("Y"));
		//응답
		response.setContentType("text/html;charset=UTF-8");//한글안깨지게
		PrintWriter out = response.getWriter();//생성 웹으로 가버린다 // 출력 스트림 생성
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.println(X + "+" + Y + "=" + (X+Y) + "<br>");
		out.println(X + "-" + Y + "=" + (X-Y) + "<br>");
		out.println(X + "*" + Y + "=" + (X*Y) + "<br>");
		out.println(X + "/" + Y + "=" + ((double)X/Y) + "<br>");
		out.println("<h3>");
		out.println("<input type='button' value='뒤로' onclick='javascript:history.go(-1)'>");//뒤로가기
		out.println("<input type='button' value='뒤로' onclick=location.href='http://localhost:8080/ttestServlet/calc/input.html'>");//파일을 새롭게 다시
		out.println("<input type='button' value='연령제한' onclick=location.href='http://localhost:8080/ttestServlet/param.html'>");//파일을 새롭게 다시
		out.println("</body>");
		out.println("</html>");	
	}
	public void destroy() {}
}
