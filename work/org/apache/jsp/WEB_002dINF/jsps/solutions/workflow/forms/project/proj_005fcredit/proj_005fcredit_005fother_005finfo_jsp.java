package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcredit_005fother_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" id=\"proj_credit_other_info\">\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-indus\"></div>申请人存款余额</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-indus tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\"  ' require=\"true\" label=\"申请人存款余额\"' style=\"width: 98%;float:left;\" id=\"special_industries\" name=\"proj_other_info.assetsmemo\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.assetsmemo'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    \t\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-equiplist\"></div>申请人自有车辆</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-equiplist tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\"  'label=\"申请人自有车辆\"'\r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_ownervehicle\"\r\n");
      out.write("\t\t\tname=\"proj_other_info.ownervehicle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.ownervehicle'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-ownerestatelist\"></div>申请人房产</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-ownerestatelist tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\"  'label=\"申请人房产\"'\r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_ownerestate\"\r\n");
      out.write("\t\t\tname=\"proj_other_info.ownerestate\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.ownerestate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-ownerlandlist\"></div>申请人土地</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-ownerlandlist tr-ven\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\"  'label=\"申请人土地\"'\r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_ownerland\"\r\n");
      out.write("\t\t\tname=\"proj_other_info.ownerland\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.ownerland'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-ownerotherlist\"></div>申请人其他信息</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-ownerotherlist tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\"   'label=\"申请人其他信息\"'\r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_ownerother\"\r\n");
      out.write("\t\t\tname=\"proj_other_info.ownerother\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.ownerother'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-assetslist\"></div>担保人资产信息</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-assetslist tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\"  ' require=\"true\" label=\"担保人资产信息\"'\r\n");
      out.write("\t\t\tstyle=\"width: 98%;float:left;\" id=\"special_assetslist\"\r\n");
      out.write("\t\t\tname=\"proj_other_info.assetslist\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.assetslist'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-credit_list\"></div>经销商剩余额度</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-credit_list tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">剩余额度：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"lastcredit\" id=\"lastcredit\" class=\"td-content-input \" type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['lastcredit'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" \r\n");
      out.write("\t\t\tlabel=\"剩余额度\" \r\n");
      out.write("\t\t></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<script>\r\n");
      out.write("/*\r\n");
      out.write("jQuery(function() {\r\n");
      out.write("\tvar deptid=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope['proj_info.projdept'] ? sessionScope['loginUserDeptObj'].id : requestScope['proj_info.projdept'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\tgetCreditMoney(deptid);\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("function getCreditMoney(deptid){ \r\n");
      out.write("\t\t//loadMask_oper.show();\r\n");
      out.write("\t\tvar isSubmit = false;\r\n");
      out.write("\t\t var param={};\r\n");
      out.write("\t\t param.deptid=deptid;\r\n");
      out.write("\t\t ajaxRequest({\r\n");
      out.write("  \t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/checkMoney/getCreditMoney.action',\r\n");
      out.write("  \t\t     method:'POST',\r\n");
      out.write("  \t\t     success:function(res){\r\n");
      out.write("  \t   \t\t var scustinfo=res.responseText;\r\n");
      out.write("\t   \t\t scustinfo=scustinfo.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t   \t\t var cust=eval(\"(\"+scustinfo+\")\");\r\n");
      out.write("\t   \t\t $(\"#lastcredit\").val(cust);\r\n");
      out.write("  \t\t     },\r\n");
      out.write("  \t\t     async:false,\r\n");
      out.write("  \t\t     failure:function(res){},\r\n");
      out.write("  \t\t     params:param\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t*/\r\n");
      out.write("</script>");
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
