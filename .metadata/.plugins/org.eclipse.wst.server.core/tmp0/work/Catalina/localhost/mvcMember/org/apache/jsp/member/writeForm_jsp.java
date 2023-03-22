/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-03-21 08:51:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class writeForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("div {\r\n");
      out.write("	color: red;\r\n");
      out.write("	font-size: 8pt;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"writeForm\" method=\"post\" action=\"write.jsp\">\r\n");
      out.write(" <table border=\"1\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("  	<th>이름</th>\r\n");
      out.write("  	<td>\r\n");
      out.write("  	 <input type=\"text\" name=\"name\" id=\"name\" placeholder=\"이름 입력\">\r\n");
      out.write("  	 <div id=\"nameDiv\"></div>\r\n");
      out.write("  	</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("  	<th>아이디</th>\r\n");
      out.write("  	<td>\r\n");
      out.write("  	 <input type=\"text\" name=\"id\" id=\"id\" size=\"30\" placeholder=\"아이디 입력\">\r\n");
      out.write("  	 \r\n");
      out.write("  	 <input type=\"hidden\" id=\"check\" value=\"\">\r\n");
      out.write("  	 \r\n");
      out.write("  	 <input type=\"button\" value=\"중복체크\" onclick=\"checkId()\">\r\n");
      out.write("  	 \r\n");
      out.write("  	 \r\n");
      out.write("  	 \r\n");
      out.write("  	 <div id=\"idDiv\"></div>\r\n");
      out.write("  	</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("  	<th>비밀번호</th>\r\n");
      out.write("  	<td>\r\n");
      out.write("  	 <input type=\"password\" name=\"pwd\" id=\"pwd\" size=\"40\" >\r\n");
      out.write("  	 <div id=\"pwdDiv\"></div>\r\n");
      out.write("  	</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("  	<th>재확인</th>\r\n");
      out.write("  	<td>\r\n");
      out.write("  	 <input type=\"password\" name=\"rdpwd\" id=\"repwd\" size=\"40\" >\r\n");
      out.write("  	</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("   <th>성별</th>\r\n");
      out.write("    <td>\r\n");
      out.write("     <input type=\"radio\" name=\"gender\" id=\"gender_m\" value=\"0\" checked/>\r\n");
      out.write("     <label for=\"gender_m\">남자</label>			\r\n");
      out.write("     <input type=\"radio\" name=\"gender\" id=\"gender_f\" value=\"1\" />\r\n");
      out.write("     <label for=\"gender_f\">여자</label>	\r\n");
      out.write("    </td>		\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("   <th>이메일</th>\r\n");
      out.write("   <td>\r\n");
      out.write("    <input type=\"text\" name=\"email1\" style=\"width: 120px;\">\r\n");
      out.write("    @\r\n");
      out.write("    <input type=\"text\" name=\"email2\" id=\"email2\" style=\"width: 120px;\">\r\n");
      out.write("    <select name=\"email3\" id=\"email3\" style=\"width: 120px;\" onchange=\"select()\">\r\n");
      out.write("     <option value=\"\">직접입력</option>\r\n");
      out.write("     <option value=\"naver.com\">naver.com</option>\r\n");
      out.write("     <option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("     <option value=\"nate.com\">nate.com</option>\r\n");
      out.write("    </select>\r\n");
      out.write("   </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("   <th>휴대폰</th>\r\n");
      out.write("   <td>\r\n");
      out.write("    <select name=\"tel1\" style=\"width: 70px;\">\r\n");
      out.write("     <option value=\"010\">010</option>\r\n");
      out.write("     <option value=\"011\">011</option>\r\n");
      out.write("     <option value=\"019\">019</option>\r\n");
      out.write("     <option value=\"070\">070</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    -\r\n");
      out.write("    <input type=\"text\" name=\"tel2\" style=\"width: 70px;\">\r\n");
      out.write("    -\r\n");
      out.write("    <input type=\"text\" name=\"tel3\" style=\"width: 70px;\">\r\n");
      out.write("   </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("   <th>주소</th>\r\n");
      out.write("   <td>\r\n");
      out.write("    <input type=\"text\" name=\"zipcode\" id=\"zipcode\" size=\"5\" placeholder=\"우편번호\" readonly>\r\n");
      out.write("    <input type=\"button\" value=\"우편번호검색\" onclick=\"execDaumPostcode()\">\r\n");
      out.write("    <br>\r\n");
      out.write("    <input type=\"text\" name=\"addr1\" id=\"addr1\" style=\"width: 400px;\" placeholder=\"주소\" readonly/>\r\n");
      out.write("    <br>\r\n");
      out.write("    <input type=\"text\" name=\"addr2\" id=\"addr2\" style=\"width: 400px;\" placeholder=\"상세주소\" />\r\n");
      out.write("   </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("  	<td colspan=\"2\" align=\"center\">\r\n");
      out.write("  	 <input type=\"button\" value=\"회원가입\" onclick=\"checkWrite()\">\r\n");
      out.write("  	 <input type=\"reset\" value=\"다시작성\">\r\n");
      out.write("  	</td>\r\n");
      out.write("  </tr>\r\n");
      out.write(" </table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/member.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function checkId(){\r\n");
      out.write("	var id = document.getElementById(\"id\").value;\r\n");
      out.write("	document.getElementById(\"idDiv\").innerText = \"\";\r\n");
      out.write("	\r\n");
      out.write("	if(id == \"\") \r\n");
      out.write("		document.getElementById(\"idDiv\").innerHTML = \"<font color='magenta'>먼저 아이디를 입력하세요</font>\";\r\n");
      out.write("	else\r\n");
      out.write("		window.open(\"/mvcMember/member/check.do?id=\"+id, \"checkId\", \"width=500 height=150 left=900 top=200\")\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
