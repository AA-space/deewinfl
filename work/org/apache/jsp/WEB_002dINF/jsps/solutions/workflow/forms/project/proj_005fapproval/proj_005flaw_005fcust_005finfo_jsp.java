package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005flaw_005fcust_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<table cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-project-law-cust-info\"></div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.custclass']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("客户信息</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("         <tr class=\"tr-project-y tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content\" >法定代表人:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.legalrepresentative\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.legalrepresentative'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >注册地址:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.taxregadd\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" readonly=\"readonly\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.taxregadd'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-y tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content\" >客户规模:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.custscale\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\" readonly=\"readonly\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.custscale'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >企业性质:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.ownership\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\" readonly=\"readonly\"   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.ownership'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-y tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content\" >高管姓名:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.seniorname\" class=\"td-content-input\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.seniorname'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >职位:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.position\" class=\"td-content-input\"   type=\"text\"    value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.position'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-y tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content\" >学历:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.degree\" class=\"td-content-input\"   type=\"text\"   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.degree'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >从业年限:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"cust_info_company.worklife\" class=\"td-content-input\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.worklife'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-y tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content\" >年龄:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=\"3\">\r\n");
      out.write("\t\t<input name=\"cust_info_company.cage\" class=\"td-content-input\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_company.cage'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("   </table>");
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
