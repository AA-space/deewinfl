package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowMainContainer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("\r\n");
      out.write("<div id=\"id_content_tabs\"><!--页签开始-->\r\n");
      out.write("\t<div class=\"tabs-header\">\r\n");
      out.write("\t\t<div style=\"display: none;\" class=\"tabs-scroller-left\"></div><div style=\"display: none;\" class=\"tabs-scroller-right\"></div>\r\n");
      out.write("\t\t<div  class=\"tabs-wrap\">\r\n");
      out.write("\t\t   <ul class=\"tabs\">\r\n");
      out.write("\t\t      <li class=\"tabs-selected\"><a href=\"javascript:void(0)\"  id=\"id_toggle_form_link\" onclick=\"toggleFormDisplay();\" class=\"tabs-inner\"><span class=\"tabs-title\">流程表单</span><span class=\"tabs-icon\"></span></a></li>\r\n");
      out.write("\t\t\t  <li><a href=\"javascript:void(0)\" id=\"id_toggle_advise_link\" href=\"javascript:void(0);\" class=\"tabs-inner\" onClick=\"toggleAdviseDisplay();\"><span class=\"tabs-title\">审批意见</span><span class=\"tabs-icon\"></span></a></li>\r\n");
      out.write("\t\t\t  <li><a href=\"javascript:void(0)\" id=\"id_toggle_attachment_link\" href=\"javascript:void(0);\" class=\"tabs-inner\" onClick=\"toggleAttachmentDisplay();\"><span class=\"tabs-title\">附件一览</span><span class=\"tabs-icon\"></span></a></li>\r\n");
      out.write("\t\t   </ul> \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <!--表单页签1开始-->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "getWorkflowInnerForm.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!--审批意见页签2开始-->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "getWorkflowInnerAdvise.jsp", out, false);
      out.write("\r\n");
      out.write("    <!--附件上传页签3开始-->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "getWorkflowInnerAttachment.jsp", out, false);
      out.write("\r\n");
      out.write("</div><!--页签结束-->  ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
