/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.1
 * Generated at: 2018-01-10 06:06:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import core.appui.UtilBean;
import app.appui.AppUtilBean;
import core.util.Constants;

public final class Logout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/jsp/Footer.jsp", Long.valueOf(1515514789048L));
    _jspx_dependants.put("/jsp/Header.jsp", Long.valueOf(1515514789051L));
    _jspx_dependants.put("/jsp/LeaderBoard.jsp", Long.valueOf(1515514789057L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("app.appui.AppUtilBean");
    _jspx_imports_classes.add("core.util.Constants");
    _jspx_imports_classes.add("core.appui.UtilBean");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"Error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n");
      out.write("\n");
      core.appui.UtilBean UtilBean = null;
      synchronized (session) {
        UtilBean = (core.appui.UtilBean) _jspx_page_context.getAttribute("UtilBean", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (UtilBean == null){
          UtilBean = new core.appui.UtilBean();
          _jspx_page_context.setAttribute("UtilBean", UtilBean, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("UtilBean"), request);
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("</head>\n");
      out.write("<title>AppServlet - Logout</title>\n");
      out.write("<link href=\"/aprmarathon/jsp/css/main.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<body text=\"#000000\" bgcolor=\"#FFFFFF\" link=\"#0000EE\" vlink=\"#551A8B\" alink=\"#FF0000\">\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<br>\n");
 UtilBean.logout(request); 
      out.write('\n');
      out.write("<TABLE WIDTH=\"100%\" BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\" STYLE=\"page-break-before: always\">\n");
      out.write("  <COL WIDTH=28*>\n");
      out.write("  <COL WIDTH=171*>\n");
      out.write("  <COL WIDTH=57*>\n");
      out.write("  <TR>\n");
      out.write("\t<TD WIDTH=\"11%\" HEIGHT=\"1 VALIGN=\"top\">\n");
      out.write("\t    <P><IMG SRC=\"/aprmarathon/jsp/images/t.gif\" ALIGN=BOTTOM WIDTH=1 HEIGHT=1 BORDER=0></P>\n");
      out.write("\t</TD>\n");
      out.write("    \t<TD WIDTH=\"78%\"></TD>\n");
      out.write("    \t<TD WIDTH=\"11%\"></TD>\n");
      out.write("  </TR>\n");
      out.write("  <TR>\n");
      out.write("\t  <TD WIDTH=11% VALIGN=TOP>\n");
      out.write("\t    <P><IMG SRC=\"/aprmarathon/jsp/images/header_logo.gif\" ALIGN=BOTTOM WIDTH=\"105\" HEIGHT=\"79\" BORDER=0></P>\n");
      out.write("\t  </TD>\n");
      out.write("\t  <TD WIDTH=78%>\n");
      out.write("\t    ");
      out.write("<center>\n");
      out.write("\t<table border=0 width=100% height=79>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td><P></P></td>\n");
      out.write("\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</center>\n");
      out.write("</TD>\n");
      out.write("\t  <TD WIDTH=11% VALIGN=TOP>\n");
      out.write("\t    <IMG SRC=\"/aprmarathon/jsp/images/small_header_top.gif\" ALIGN=RIGHT>\n");
      out.write("\t  </TD>\n");
      out.write("\t</TR>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<table border=0 cellpadding=0 cellspacing=0 width=100% >\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td width=\"100%\" bgcolor=\"#3368B7\"><img src=\"/aprmarathon/jsp/images/t.gif\" width=5 height=15 border=0</td>\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("<td><img src=\"/aprmarathon/jsp/images/t.gif\" height=\"70\">\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("<center>\n");
      out.write("\t<table border=0>\n");
      out.write("\t<tbody>\n");
      out.write("\t\t<tr width=\"100%\" bgcolor=\"#F4F2F2\">\n");
      out.write("\t\t\t<td><b>Successfully Logged Out</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr width=\"100%\" bgcolor=\"#F4F2F2\">\n");
      out.write("\t\t\t<td>Click to ");
      out.print( AppUtilBean.getLoginUrl() );
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("</center>\n");
      out.write("<br> <table>\n");
      out.write("<tr>\n");
      out.write("<td><img src=\"/aprmarathon/jsp/images/t.gif\" height=\"170\">\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("<td><img src=\"/aprmarathon/jsp/images/t.gif\" height=\"70\">\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("<table border=0 cellpadding=0 cellspacing=0 width=100%>\n");
      out.write(" \t<tr>\n");
      out.write("\t\t<td width=100% height=3 colspan=\"3\" valign=\"top\" background=\"/aprmarathon/jsp/images/bottomline.gif\"><img src=\"/aprmarathon/images/t.gif\" width=\"1\" height=\"1\" border=\"0\"></td>\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td height=\"20\" colspan=\"2\" valign=\"top\" bgcolor=\"#F4F2F2\"><img src=\"/aprmarathon/jsp/images/t.gif\" width=5 height=80 border=0><span class=\"dev_by\">Powered by-</span> <span class=\"dev_by\">APR Charitable Trust</span></td>\n");
      out.write("\t\t<td align=\"left\" valign=\"top\" bgcolor=\"#F4F2F2\" id=\"copyright\"><div align=\"left\"><span class=\"dev_by\"> </span><span class=\"dev_by\"></span></div></td>\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td height=\"25\" bgcolor=\"#3368B7\"><img src=\"/aprmarathon/jsp/images/t.gif\" width=5 height=25 border=0 alt=\"APR Charitable Trust\"></td>\n");
      out.write(" \t\t<td colspan=\"2\" align=\"right\" bgcolor=\"#3368B7\" id=\"copyright\">&copy; 2017 APR Charitable Trust</td>\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
