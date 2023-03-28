package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response);// jsp를 가져오기 위해서 String형으로 선언
	
}
	

