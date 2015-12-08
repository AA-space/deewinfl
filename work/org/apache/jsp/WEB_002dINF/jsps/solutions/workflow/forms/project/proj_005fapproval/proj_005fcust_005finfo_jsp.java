package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcust_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" class=\"fillTable\" >\r\n");
      out.write("          <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-proj-cust-info\"></div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.custclass']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("客户信息</td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-proj-cust-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">身份证号码</td>\r\n");
      out.write("             <td class=\"td-content\"><input name=\"cust_info_person.idcardno\"  class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.idcardno']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("             <td class=\"td-content-title\">民族：</td>\r\n");
      out.write("            <td class=\"td-content\"><input name=\"cust_info_person.custethnic\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.custethnic']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-proj-cust-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">现住址：</td>\r\n");
      out.write("             <td class=\"td-content\" colspan=5><input style=\"width:60%\" name=\"cust_info_person.homeadd\" readOnly  class=\"td-content-input td-content-readonly\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.homeadd']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-cust-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">手机号码：</td>\r\n");
      out.write("             <td class=\"td-content\"><input  name=\"cust_info_person.mobilenumber\" class=\"td-content-input td-content-readonly\" readOnly   type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.mobilenumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\">工作单位：</td>\r\n");
      out.write("             <td class=\"td-content\"><input name=\"cust_info_person.unitname\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.unitname'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("           <tr class=\"tr-proj-cust-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">获取驾照日期：</td>\r\n");
      out.write("             <td class=\"td-content\"><input name=\"cust_info_person.driverlicensedate\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.driverlicensedate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input></td>\r\n");
      out.write("             <td class=\"td-content-title\">配偶姓名：</td>\r\n");
      out.write("             <td class=\"td-content\"><input name=\"cust_info_person.spousename\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info_person.spousename'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          \r\n");
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
