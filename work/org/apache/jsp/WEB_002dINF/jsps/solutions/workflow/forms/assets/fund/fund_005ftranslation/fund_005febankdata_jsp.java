package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005ftranslation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005febankdata_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- 网银信息 -->\r\n");
      out.write(" <input name=\"fund_ebank_process\" id=\"id_fund_ebank_process\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_process'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write(" <input name=\"dealer\" id=\"dealer\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write(" <table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 98%; margin-top: 20px;\" id=\"fund_ebank_data\" >\r\n");
      out.write("        <tr class=\"tr-project-condition tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">网银编号：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.ebdataid\" id=\"ebdataid\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.ebdataid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">付款人：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.clientname\" class=\"td-content-input td-content-readonly\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.clientname']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t    <td class=\"td-content-title\">流水号：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.sn\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.sn']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-project-condition tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">本方银行：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.ownbank\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.ownbank']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">本方账户：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.ownaccount\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.ownaccount']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">本方账号：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.ownaccnumber\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.ownaccnumber']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t<tr class=\"tr-project-condition tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">对方银行：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.clientbank\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.clientbank']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">对方账户：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.clientaccount\" class=\"td-content-input td-content-readonly\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.clientaccount']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">对方账号：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.clientaccnumber\" class=\"td-content-input td-content-readonly\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.clientaccnumber']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t<tr class=\"tr-project-condition tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">到账金额：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.factmoney\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.factmoney']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">已核销金额：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\" ><input name=\"fund_ebank_data.hadmoney\" class=\"td-content-input td-content-readonly\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.hadmoney']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">可核销金额：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\" ><input name=\"fund_ebank_data.mayopemoney\" class=\"td-content-input td-content-readonly\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.mayopemoney']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-project-condition tr-even\">\r\n");
      out.write("\t\t    <td class=\"td-content-title\">无关金额：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.nowithmoney\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.nowithmoney']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t    <td class=\"td-content-title\">到账金额类型：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.moneytype\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.moneytype']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">到账时间：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"fund_ebank_data.factdate\" class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.factdate']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t </tr>\r\n");
      out.write("\t\t<tr class=\"tr-project-condition tr-odd\">\r\n");
      out.write("\t\t    <td class=\"td-content-title\">备注：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\" colspan=\"5\">\r\n");
      out.write("\t\t\t<textarea rows=\"5\"    label=\"备注\" class=\"td-content-input\"\r\n");
      out.write("\t\t\tstyle=\"width: 70%;float:left\" name=\"fund_ebank_data.summary\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.summary'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write(" </table>");
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
