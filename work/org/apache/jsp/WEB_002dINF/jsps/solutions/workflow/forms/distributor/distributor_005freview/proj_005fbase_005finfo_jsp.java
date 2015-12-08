package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.distributor.distributor_005freview;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fbase_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"javascript\">\r\n");
      out.write("    function showLawCustInfo(cust_id){\r\n");
      out.write("    \tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/cust_info/cust_info.bi\";\r\n");
      out.write("    \tvar params = {cust_id:cust_id};\r\n");
      out.write("\t    openFullScreenWindow(URL,params);\r\n");
      out.write("        //window.open(getRootPath()+\"/leasing/law_cust/show_template.bi?cust_id=\"+cust_id+\"&jsp=law_cust_all_info\",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');\r\n");
      out.write("    }\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("        var temp=isViewHistoryTask;\r\n");
      out.write("        isViewHistoryTask=true;\r\n");
      out.write("    \tdictYesOrNoByCode('id_is4s','dealer_approval_info.is4s','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"dealer_approval_info.is4s\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("    \tisViewHistoryTask=temp;\r\n");
      out.write("\t\t});\r\n");
      out.write("    </script>\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" id=\"proj_base_info\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-info\"></div>\r\n");
      out.write("\t\t经销商准入申请</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-info tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\" style=\"width:17%\">经销商名称：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t <input name=\"cust_info.id\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.id'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("              <input  name=\"cust_info.custname\" class=\"td-content-input td-content-readonly\" readOnly require=\"true\" label=\"经销商名称\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.custname'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" >\r\n");
      out.write("              <a href=\"javascript:void(0);\"><img alt=\"经销商信息\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/department.png\" onclick=\"showLawCustInfo('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.id'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\"/></a>\r\n");
      out.write("             <font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t<td class=\"td-content-title\" style=\"width:17%\">准入编号：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"dealer_approval_info.creditnum\"\r\n");
      out.write("\t\t\tclass=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.creditnum'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font\r\n");
      out.write("\t\t\tclass=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-info tr-odd\">\r\n");
      out.write("\t\t   <td class=\"td-content-title\">注册时间：</td><td class=\"td-content\"><input name=\"dealer_approval_info.regdate\" class=\"td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.regdate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  readOnly require=\"true\" label=\"注册时间\" /><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">注册资本：</td><td class=\"td-content\"><input name=\"dealer_approval_info.regcapital\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.regcapital'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-info tr-even\">\r\n");
      out.write("\t\t <td class=\"td-content-title\">实收资本：</td><td class=\"td-content\"><input name=\"dealer_approval_info.incomeassets\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.incomeassets'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("            \r\n");
      out.write("\t\t<td class=\"td-content-title\"></td>\r\n");
      out.write("\t\t<td class=\"td-content\" id=\"q_c7\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-survey\"></div>\r\n");
      out.write("\t\t净资产</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-survey tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content\" colspan=6><textarea rows=\"5\" cols=\"150\" label=\"净资产\"\r\n");
      out.write("\t\t\tclass=\"td-content-input td-content-readonly\"  readonly\r\n");
      out.write("\t\t\t\tstyle=\"width: 98%;heigth:100px\" name=\"dealer_approval_info.netassets\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.netassets'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-survey\"></div>\r\n");
      out.write("\t\t近三年销量</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-survey tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content\" colspan=6><textarea rows=\"5\" cols=\"150\"  label=\"近三年销量\"\r\n");
      out.write("\t\t\tclass=\"td-content-input td-content-readonly\"  readonly\r\n");
      out.write("\t\t\t\tstyle=\"width: 98%;heigth:100px\"  name=\"dealer_approval_info.threeyearsales\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.threeyearsales'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<tr class=\"tr-project-info tr-odd\">\r\n");
      out.write("\t\t  <td class=\"td-content-title\" style=\"width:17%\">是否4S店：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_is4s\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("          <td class=\"td-content-title\" style=\"width:17%\">与陕汽合作时间：</td><td class=\"td-content\"><input name=\"dealer_approval_info.cooperationdate\" class=\"td-content-input td-content-readonly\"   type=\"text\"  readonly  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.cooperationdate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
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
