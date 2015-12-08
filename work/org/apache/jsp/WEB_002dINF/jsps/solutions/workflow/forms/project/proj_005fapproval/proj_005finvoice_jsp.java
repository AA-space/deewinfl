package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005finvoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--发票类型 -->\r\n");
      out.write("  <script language=\"javascript\">\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("        var isInit=isSubTable||false;\r\n");
      out.write("        if(isInit==true){\r\n");
      out.write("\t   \t    dict('id_rent_invoice_type','proj_invoice_type.rentinvoicetype','rent_invoice_type','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_invoice_type.rentinvoicetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"rawValue_proj_invoice_type.rentinvoicetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,300);\r\n");
      out.write("\t        //特殊下拉\r\n");
      out.write("\t        dictYesOrNoByCode('id_IsInvoiceRentSplit','proj_invoice_type.isinvoicerentsplit','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_invoice_type.isinvoicerentsplit\"] ? \"0\" : requestScope[\"proj_invoice_type.isinvoicerentsplit\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','',true,null);\r\n");
      out.write("\t        dictYesOrNoByCode('id_BoolInvoice','proj_invoice_type.boolinvoice','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_invoice_type.boolinvoice\"] ? \"0\" : requestScope[\"proj_invoice_type.boolinvoice\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','',true);\r\n");
      out.write("        \r\n");
      out.write("        }\r\n");
      out.write("\t\t\r\n");
      out.write("        \r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    function saveInvoiceType(){\r\n");
      out.write("    \t  //自动判断租金发票类型\r\n");
      out.write("\t\t//租金发票类型\r\n");
      out.write("\t\tvar invoice_type_obj = getTracywindyObject('id_combo_rent_invoice_type');\r\n");
      out.write("\t\tif(!invoice_type_obj.getValue()){\r\n");
      out.write("\t\t\t//租赁形式 直租 回租\r\n");
      out.write("\t\t\tvar leas_form = getTracywindyObject('id_combo_leas_form').getValue();\r\n");
      out.write("\t\t\t//客户模式 \"法人\" \"自然人\r\n");
      out.write("\t\t\tvar cust_type = document.getElementById('proj_info.cust_type').value;\r\n");
      out.write("\t\t\t//是否上牌\r\n");
      out.write("\t\t\tvar is_registration = getTracywindyObject('id_combo_id_is_registration').getValue();\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tif (leas_form == 'lease_form1') {//直租\r\n");
      out.write("\t\t\t\tif (is_registration === 0 || is_registration === '0') {//上牌\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.setValue('invoice_type02');\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.reload();\r\n");
      out.write("\t\t\t\t} else if (is_registration === 1 || is_registration === '1') {//不上牌\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.setValue('invoice_type04');\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.reload();\r\n");
      out.write("\t\t\t\t} else{\r\n");
      out.write("\t\t\t\t\talert(\"上牌模式不对，不能自动选择租金发票类型，请手动选择\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else if (leas_form == 'lease_form2') {//回租\r\n");
      out.write("\t\t\t\tif (cust_type == '法人') {\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.setValue('invoice_type06');\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.reload();\r\n");
      out.write("\t\t\t\t} else if (cust_type == '自然人') {\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.setValue('rent_invoice_type07');\r\n");
      out.write("\t\t\t\t\tinvoice_type_obj.reload();\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"客户类别不对，不能自动选择租金发票类型，请手动选择\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"租赁形式不对，不能自动选择租金发票类型，请手动选择\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("<table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\" id=\"proj_invoice_type_table\">\r\n");
      out.write("\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">租金发票类型：</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=3>\r\n");
      out.write("\t\t<div id=\"id_rent_invoice_type\"></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">租金发票本利金是否拆分：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t<div class=\"leftComboContainer\" id=\"id_IsInvoiceRentSplit\"></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">发票为放款先决条件：</td>\r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t<div class=\"leftComboContainer\" id=\"id_BoolInvoice\"></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
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
