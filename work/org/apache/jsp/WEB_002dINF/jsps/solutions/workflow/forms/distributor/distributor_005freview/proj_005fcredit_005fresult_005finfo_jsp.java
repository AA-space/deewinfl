package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.distributor.distributor_005freview;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcredit_005fresult_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("jQuery(function(){\r\n");
      out.write(" \tdict('id_dealerapprovalstatus','dealer_approval_info.dealerStatus','dealer_creditStatus','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"dealer_approval_info.dealerStatus\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"选 择是否符合准入的标准\"');    \r\n");
      out.write("\t});\r\n");
      out.write("function setCreditLevel(grade){\r\n");
      out.write("\talert(2);\r\n");
      out.write("\tdebugger;\r\n");
      out.write("\tif(grade==\"\"){grade=0;}\r\n");
      out.write("\tvar lastGrade=parseFloat(grade);\r\n");
      out.write("\tvar leave=\"\";\r\n");
      out.write("\tif(lastGrade<60){leave=\"D\";}\r\n");
      out.write("\telse if(lastGrade<70){leave=\"C\";}\r\n");
      out.write("\telse if(lastGrade<85){leave=\"B\";}\r\n");
      out.write("\telse{leave=\"A\";}\r\n");
      out.write("\t$(\"#id_local_report_result_level\").val(leave);\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" id=\"id_proj_cedit_result_info\" >\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" >\r\n");
      out.write("\t\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-dealer-report-2\"></div>经销商额度授信建议</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"\">\r\n");
      out.write("\t\t<td><div style=\"float:left\">经过对该经销商综合能力的评测,该经销商的综合得分为:</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<input style=\"float:left\" id=\"id_local_report_result\" name=\"dealer_approval_info.reportscore\" onpropertychange=\"setCreditLevel(this.value)\" oninput=\"setCreditLevel(this.value)\" type=\"text\" size=3 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.reportscore\"] ? \"0.00\" : requestScope[\"dealer_approval_info.reportscore\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' readOnly=\"true\" class=\"td-content-readonly\" />\r\n");
      out.write("\t\t\t<div style=\"float:left\">分  建议评级</div><input  style=\"float:left\"id=\"id_local_report_result_level\" name=\"dealer_approval_info.reportscorelevel\" type=\"text\" size=1 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.reportscorelevel\"] ? \"0.00\" : requestScope[\"dealer_approval_info.reportscorelevel\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' readonly=\"readonly\" class=\"td-content-readonly\" /><div style=\"float:left\">级</div>\r\n");
      out.write("\t\t<div style=\"float:left\" id=\"id_dealerapprovalstatus\"></div>准入的标准\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t <tr>\r\n");
      out.write("\t\t<td>综合考虑以下可能对经销商未来履约能力或履约意愿方面的影响因素</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><textarea rows=\"5\" style=\"width: 98%\" id=\"id_coloum1\" name=\"coloum1\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['coloum2'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>综上所述，根据《陕重汽经销商信用等级和授信额度管理 办法(试行)》中的额度制定标准，建议该经销商授信额度为</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t  <td>授信阶段</td><td>建议放大倍数</td><td>建议标准额度</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t   <td>辅导期</td>\r\n");
      out.write("\t\t\t   <td><input id=\"id_1\" name=\"table1\" type=\"text\" size=2 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"table1\"] ? \"\" : requestScope[\"table1\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' class=\"td-content-input\" /></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"id_2\" name=\"table2\" type=\"text\" size=20 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"table2\"] ? \"\" : requestScope[\"table2\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' class=\"td-content-input\" /></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t\t<td>辅导期通过后</td>\r\n");
      out.write("\t\t\t\t<td><input id=\"id_3\" name=\"table3\" type=\"text\" size=2 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"table3\"] ? \"\" : requestScope[\"table3\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' class=\"td-content-input\" /></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"id_4\" name=\"table4\" type=\"text\" size=20 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"table4\"] ? \"\" : requestScope[\"table4\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' class=\"td-content-input\" /></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t <td><textarea rows=\"5\" style=\"width: 98%\" id=\"id_coloum2\" name=\"coloum2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['coloum2'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("</table>\r\n");
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
