package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();//생성 웹으로 가버린다
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕하세요 이게 뭐예요?<br>");
		out.println("<html>");
		out.println("</body>");
		out.println("</html>");			
		
	}

}














