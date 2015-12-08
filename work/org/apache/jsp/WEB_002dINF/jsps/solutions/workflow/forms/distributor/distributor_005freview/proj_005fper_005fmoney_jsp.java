package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.distributor.distributor_005freview;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fper_005fmoney_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("    \tcommonSelect('id_proj_dept','t_depts','id_','name_','dealer_approval_info.creditdept','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.creditdept\"] ? sessionScope[\"loginUserDeptObj\"].id : requestScope[\"dealer_approval_info.creditdept\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,' require=\"true\" label=\"登记人部门\"',false);\r\n");
      out.write("    \tcommonSelect('id_proj_registrar','t_users','id_','realname_','dealer_approval_info.credit','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.credit\"] ? sessionScope.loginUser.id : requestScope[\"dealer_approval_info.credit\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,' require=\"true\" label=\"登记人\"',false);\r\n");
      out.write("    });\r\n");
      out.write("\t</script>\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-per_money\"></div>\r\n");
      out.write("\t\t申请信息</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write(" <tr class=\"tr-project-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\" style=\"width:17%\">申请部门：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_proj_dept\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\" style=\"width:17%\">申请人：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_proj_registrar\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr class=\"tr-project-info tr-odd\">\r\n");
      out.write("          <td class=\"td-content-title\"> 申请时间：</td><td class=\"td-content\" colspan=\"3\"><input name=\"dealer_approval_info.credittime\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.credittime\"] ? requestScope[\"current_date\"] : requestScope[\"dealer_approval_info.credittime\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'  onClick=\"WdatePicker(this,{readOnly:true})\" readOnly require=\"true\" label=\"登记时间\" /><font class=\"required-content\">*</font></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("</table>");
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
