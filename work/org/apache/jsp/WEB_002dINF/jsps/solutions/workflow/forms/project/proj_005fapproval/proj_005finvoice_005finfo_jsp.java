package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005finvoice_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
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
      out.write("<!--合同租金发票信息 -->\r\n");
      out.write("<table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\" width=\"50%\" id=\"proj_invoice_info\">\r\n");
      out.write("\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">是否开票：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t\t\t<div class=\"leftComboContainer\" id=\"id_kfp\"></div><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\" id=\"fp_title\">发票种类：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\" id=\"fp_content\">\r\n");
      out.write("\t\t\t<div class=\"leftComboContainer\" id=\"id_fptype\"></div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<tr class=\"tr-odd\">\r\n");
      out.write("\t<td class=\"td-content-title\">开户行：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t\t<input name=\"proj_invoice_info.invoiceopenbank\"  class=\"td-content-input\" type=\"text\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.invoiceopenbank'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   label=\"开户行\"/> <font class=\"required-content\">*</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">开户账户：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t\t<input name=\"proj_invoice_info.invoicenumber\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.invoicenumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  label=\"开户账户\"/> <font class=\"required-content\">*</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">地址：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t\t<input name=\"proj_invoice_info.invoiceaddress\"  class=\"td-content-input\" type=\"text\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.invoiceaddress'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   label=\"地址\"/> <font class=\"required-content\">*</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">电话：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t\t<input name=\"proj_invoice_info.invoicetel\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.invoicetel'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   label=\"电话\" /> <font class=\"required-content\">*</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">税号：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t\t<input name=\"proj_invoice_info.taxnumber\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.taxnumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   label=\"税号\"/> <font id=\"taxnumber\" class=\"required-content\">*</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">纳税人类别：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t<div class=\"leftComboContainer\" id=\"id_ns\"></div>\r\n");
      out.write("            </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">开票说明：</td>\r\n");
      out.write("\t\t\t<td style=\"padding-top: 4px;padding-bottom: 4px;\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t<input style=\"width:74%;height: 150px;\" id=\"proj_invoice_info.invoicememo\" name=\"proj_invoice_info.invoicememo\" label=\"开票说明\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.invoicememo'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  label=\"开票说明\" class=\"mini-textarea\" type=\"text\" emptyText=\"请输入开票说明。。。\" /> \r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">开票备注：</td>\r\n");
      out.write("\t\t\t<td colspan=3 style=\"padding-top: 4px;padding-bottom: 4px;\">\r\n");
      out.write("\t\t<input style=\"width:74%;height:150px\" id=\"proj_invoice_info.invoiceremarks\"  name=\"proj_invoice_info.invoiceremarks\" label=\"开票备注\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_invoice_info.invoiceremarks'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  label=\"开票备注\" class=\"mini-textarea\" maxLength=\"500\" type=\"text\" emptyText=\"请输入开票备注。。。\"> \r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<script >\r\n");
      out.write("jQuery(function() {\r\n");
      out.write("\t\r\n");
      out.write("\t/*start 数据字典初始化*/\r\n");
      out.write("\tdict('id_ns','proj_invoice_info.taxregtype','tax_level_name',\r\n");
      out.write("\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_invoice_info.taxregtype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"rawValue_proj_invoice_info.taxregtype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','label=\"纳税人类别\"');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\tdict('id_fptype','proj_invoice_info.invoicetype','invoicetype',\r\n");
      out.write("\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_invoice_info.invoicetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"rawValue_proj_invoice_info.invoicetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','label=\"发票种类\"');\t\t\r\n");
      out.write("\r\n");
      out.write("\tdictYesOrNoByCode('id_kfp','proj_invoice_info.iskfp',\r\n");
      out.write("\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_invoice_info.iskfp\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\tfunction(){\r\n");
      out.write("\t\t\t\tif($(\"#selectOfValue_id_combo_id_kfp\").val() == \"1\"){//否\r\n");
      out.write("\t\t\t\t\t$(\"#proj_invoice_info input[type='text']\").each(function(){\r\n");
      out.write("\t\t\t\t\t\t$(this).attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t  $(\"#selectOfValue_id_combo_invoicetype\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t  $(\"#selectOf_id_combo_tax_level_name\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t  $(\"#proj_invoice_info font\").each(function(){\r\n");
      out.write("\t\t\t\t\t\t$(this).hide();\r\n");
      out.write("\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t var  comb = getTracywindyObject('id_combo_invoicetype');\r\n");
      out.write("\t\t\t\t\t      comb.readOnlyData= false;\r\n");
      out.write("\t\t\t\t\t\t  comb.setValue(\"\");\r\n");
      out.write("\t\t\t\t\t\t  comb.getRawValue(\"\");\r\n");
      out.write("\t\t\t\t\t\t  $(\"#selectOfValue_id_combo_invoicetype\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t  $(\"#selectOfRawValue_id_combo_invoicetype\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t  comb.loadSelect();\r\n");
      out.write("\t\t\t\t}else{//是\r\n");
      out.write("\t\t\t\t\t$(\"#proj_invoice_info input[type='text']\").each(function(){\r\n");
      out.write("\t\t\t\t\t\t$(this).attr(\"require\",true);\r\n");
      out.write("\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t   $(\"#selectOfValue_id_combo_invoicetype\").attr(\"require\",true);\r\n");
      out.write("\t\t\t\t\t   $(\"#selectOf_id_combo_tax_level_name\").attr(\"require\",true);\r\n");
      out.write("\t\t\t\t\t  $(\"#proj_invoice_info font\").each(function(){\r\n");
      out.write("\t\t\t\t\t\t$(this).show();\r\n");
      out.write("\t\t\t\t\t  });  \r\n");
      out.write("\t\t\t\t\t  /*start 非开票的情况隐藏开票种类*/\r\n");
      out.write("\t\t\t\t\t  var custtype =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t\t\t  if(custtype == \"自然人\"){\r\n");
      out.write("\t\t\t\t\t\t   var  comb = getTracywindyObject('id_combo_invoicetype');\r\n");
      out.write("\t\t\t\t\t\t  comb.readOnlyData= true;\r\n");
      out.write("\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\t  $(\"input[name='proj_invoice_info.taxnumber']\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  $(\"input[name='proj_invoice_info.invoiceopenbank']\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  $(\"input[name='proj_invoice_info.invoicenumber']\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  $(\"input[name='proj_invoice_info.invoiceaddress']\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  $(\"input[name='proj_invoice_info.invoicetel']\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  $(\"input[name='proj_invoice_info.invoiceaddress']\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  $(\"#taxnumber\").hide();\r\n");
      out.write("\t\t\t\t\t\t  $(\"#proj_invoice_info font\").each(function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).hide();\r\n");
      out.write("\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t\t\t  $(\"#selectOf_id_combo_tax_level_name\").attr(\"require\",false);\r\n");
      out.write("\t\t\t\t\t\t  comb.setValue(\"invoicetype2\");\r\n");
      out.write("\t\t\t\t\t\t  comb.getRawValue(\"增值税普通发票\");\r\n");
      out.write("\t\t\t\t\t\t  $(\"#selectOfValue_id_combo_invoicetype\").val(\"invoicetype2\");\r\n");
      out.write("\t\t\t\t\t\t  $(\"#selectOfRawValue_id_combo_invoicetype\").val(\"增值税普通发票\");\r\n");
      out.write("\t\t\t\t\t\t  comb.loadSelect();\r\n");
      out.write("\t\t\t\t\t  } \r\n");
      out.write("\t\t\t\t\t  /*end 非开票的情况隐藏开票种类*/\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t $(\"#selectOfValue_id_combo_invoicetype\").attr(\"label\",\"发票种类\");\r\n");
      out.write("\t\t\t\t $(\"#selectOf_id_combo_tax_level_name\").attr(\"label\",\"纳税人类别\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tnull,'label=\"是否开票\"');\r\n");
      out.write("\t \r\n");
      out.write("\t/*end 数据字典初始化*/\r\n");
      out.write("\t \r\n");
      out.write("\t $(\"#selectOfValue_id_combo_invoicetype\").attr(\"label\",\"发票种类\");\r\n");
      out.write("\t $(\"#selectOf_id_combo_tax_level_name\").attr(\"label\",\"纳税人类别\");\r\n");
      out.write("\t $(\"#selectOfValue_id_combo_invoicetype\").attr(\"require\",true);\r\n");
      out.write("\t $(\"#selectOf_id_combo_tax_level_name\").attr(\"require\",true);\r\n");
      out.write("\t \r\n");
      out.write("\t /*设置默认*/\r\n");
      out.write("\t  $(\"#proj_invoice_info input[type='text']\").each(function(){\r\n");
      out.write("\t       $(this).attr(\"require\",true);\r\n");
      out.write("\t  });\r\n");
      out.write("\t  $(\"#proj_invoice_info font\").each(function(){\r\n");
      out.write("\t    $(this).show();\r\n");
      out.write("\t  });\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
