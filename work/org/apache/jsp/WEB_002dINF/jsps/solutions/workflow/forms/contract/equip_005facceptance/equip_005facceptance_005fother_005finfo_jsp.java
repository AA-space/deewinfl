package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.equip_005facceptance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class equip_005facceptance_005fother_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function reckonStarDate(date){\r\n");
      out.write("\tif(date!=\"\"){\r\n");
      out.write("\t\tjQuery(\"#startDate\").val(date);\r\n");
      out.write("\t\tif(window.OnchangeDate){\r\n");
      out.write("\t\t\tOnchangeDate();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tconditionReckon();//调用测算\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" id=\"equip_accpance_other_info\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=\"4\">\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-y\"></div>\r\n");
      out.write("\t\t设备验收</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-y tr-even\" id=\"accept_date\">\r\n");
      out.write("\t\t<td class=\"td-content-title\" >验收时间:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input class=\"Wdate td-content-input td-content-readonly\" onchange=\"reckonStarDate(this.value)\"  dataType=\"Date\"  readonly=\"readonly\" dataType=\"Date\" name=\"equip_acceptance.acceptdate\" type=\"text\" \r\n");
      out.write("\t\t onClick=\"WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['equip_acceptance.acceptdate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" require=\"true\" label=\"验收时间\">\r\n");
      out.write("\t\t<font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t<td class=\"td-content-title\" >验收人:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" >\r\n");
      out.write("\t\t<input name=\"equip_acceptance.acceptuser\" class=\"td-content-input\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['equip_acceptance.acceptuser'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" label=\"验收人\"  type=\"text\" maxB=\"20\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-y tr-odd\">\r\n");
      out.write("\t \t<td class=\"td-content-title\" >验收地点:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\" \r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_industries\"\r\n");
      out.write("\t\t\tname=\"equip_acceptance.acceptadder\" maxB=\"300\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['equip_acceptance.acceptadder'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t <tr class=\"tr-project-y tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\" >验收备注:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\" \r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_industries\"\r\n");
      out.write("\t\t\tname=\"equip_acceptance.ecmemo\" maxB=\"300\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['equip_acceptance.ecmemo'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>");
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
