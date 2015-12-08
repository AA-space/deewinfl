package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowInnerForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(4);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fn.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
  }

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
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div  style=\"display:block;\" id=\"id_toggle_tabs_form\">\r\n");
      out.write("\t   <!--表单页签1开始-->\r\n");
      out.write("\t   <!--表单处理-->\r\n");
      out.write("\t   <div style=\"\" id=\"id_workflowFormContainer\">\r\n");
      out.write("\t\t <div  id=\"id_workflowFormContainer_inner\" style=\"width:100%;overflow-y:scroll;\">\r\n");
      out.write("\t\t   <iframe name=\"real_submit_frame\" style=\"display:none;\" id=\"id_real_submit_frame\"></iframe>\r\n");
      out.write("\t\t   <form  id=\"id_submitProcessedForm\" enctype=\"multipart/form-data\" target=\"real_submit_frame\" action=\"{pageContext.request.contextPath}/submitProcessedForm/jbpm/submitProcessedForm.action\" method=\"post\">\r\n");
      out.write("\t\t\t   <!-- 流程提交隐藏域 -->\r\n");
      out.write("\t\t\t   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "getWorkflowFormHiddenField.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t   <!-- 当前任务节点表单路径相对于jbpm-core/forms下的jsp页面 -->\r\n");
      out.write("\t\t\t   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("/${empty requestFormPath ? 'errorPages/error404.bi' : requestFormPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false), out, true);
      out.write("\r\n");
      out.write("\t\t\t   <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t  \t\tjQuery(\"#id_loadMaskContainer\").hide();\r\n");
      out.write("\t\t\t   </script>\r\n");
      out.write("\t\t   </form>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t <script>\r\n");
      out.write("\t\t      jQuery(\"#id_workflowFormContainer_inner\").css(\"width\",(all_width-containerWidthAdd-10)+\"px\");\r\n");
      out.write("\t\t\t  jQuery(\"#id_workflowFormContainer_inner\").css(\"height\",(all_height-containerHeightAdd-1)+\"px\");\r\n");
      out.write("\t\t\t  jQuery(\".x-panel-table-toolbar-div\").css(\"width\",(all_width-containerWidthAdd)+\"px\");\r\n");
      out.write("\t\t\t  jQuery(\".x-panel-table-div-title\").css(\"width\",(all_width-containerWidthAdd)+\"px\");\r\n");
      out.write("\t\t\t  jQuery(\"#id_toggle_tabs_advise .x-panel-table-div-title\").css(\"width\",(all_width-containerWidthAdd-20)+\"px\");\r\n");
      out.write("\t\t\t  jQuery(\"#id_toggle_tabs_attachment .x-panel-table-div-title\").css(\"width\",(all_width-containerWidthAdd-20)+\"px\");\r\n");
      out.write("\t\t\t  jQuery(\"#id_content_tabs .tabs-header\").css(\"width\",(all_width-containerWidthAdd+1)+\"px\");\r\n");
      out.write("\t    </script>\r\n");
      out.write("\t  </div>\r\n");
      out.write("</div>");
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
