package org.apache.jsp.WEB_002dINF.jsps.solutions.report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Form_005fReport_005fConfig_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<div id=\"id_form_report\" class=\"mini-window\" modal=\"true\" title=\"报表管理\" style=\"width: 450px\">\n");
      out.write("\t<center>\n");
      out.write("\t\t<form id=\"form_report\">\n");
      out.write("        \t<table style=\"width:90%\">\n");
      out.write("        \t\t<tr>\n");
      out.write("        \t\t\t<td style=\"display: none;\">\n");
      out.write("        \t\t\t\t<input name=\"id\" id=\"id\"  class=\"mini-textbox\"/>\n");
      out.write("        \t\t\t\t<input name=\"position\" id=\"position\" class=\"mini-textbox\" />\n");
      out.write("\t\t\t\t\t\t<input name=\"parentReport\" id=\"parentReport\" class=\"mini-textbox\" />\n");
      out.write("\t\t\t\t\t\t<input name=\"reportMenuRoot\" id=\"reportMenuRoot\" class=\"mini-textbox\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.reportMenuRoot}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("        \t\t\t</td>\n");
      out.write("        \t\t</tr>\n");
      out.write("\t            <tr>\n");
      out.write("\t                    <td class=\"input_label_desc\" style=\"text-align: center;\">名称:</td>\n");
      out.write("\t                <td>\n");
      out.write("\t                    <input name=\"name\" id=\"name\" class=\"mini-textbox\" required=\"true\"  style=\"width:200px;\"  /><span class=\"content_required\">*</span>\n");
      out.write("\t                </td>\n");
      out.write("\t            </tr>\n");
      out.write("\t            <tr>\n");
      out.write("\t                    <td class=\"input_label_desc\" style=\"text-align: center;\">编号:</td>\n");
      out.write("\t                <td>\n");
      out.write("\t                    <input name=\"code\" id=\"code\" class=\"mini-textbox\" style=\"width:200px;\"/><span class=\"content_required\">*</span>\n");
      out.write("\t                </td>\n");
      out.write("\t            </tr>\n");
      out.write("\t            <tr>\n");
      out.write("\t                   <td class=\"input_label_desc\" style=\"text-align: center;\">类型:</td>\n");
      out.write("\t                <td>\n");
      out.write("\t                    <input name=\"reportType\" id=\"reportType\" readonly=\"true\" class=\"mini-textbox\" style=\"width:200px;\"/><span class=\"content_required\">*</span>\n");
      out.write("\t                </td>\n");
      out.write("\t            </tr>\n");
      out.write("           \n");
      out.write("            \t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t<table style=\"width:98%;padding-top: 15px;\">\n");
      out.write("\t\t\t\t\t\t\t<tr>\t\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width:40%\">&nbsp;</td>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td><a id=\"report_saveButton\" class='mini-button'><span>确定</span></a></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td><a id=\"report_closeButton\" class='mini-button'><span>取消</span></a></td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("    \t</form>\n");
      out.write("\t</center>\n");
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
