package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcredit_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   \r\n");
      out.write("    <script language=\"javascript\">\r\n");
      out.write("    function getCurrentDate(){\r\n");
      out.write("        var cdate=new Date();\r\n");
      out.write("        var month=(parseFloat(cdate.getMonth())+1);\r\n");
      out.write("        var day=cdate.getDate();\r\n");
      out.write("        if(parseFloat(day)<10){day=\"0\"+day;}\r\n");
      out.write("        if(parseFloat(month)<10){month=\"0\"+month;}\r\n");
      out.write("        return cdate.getFullYear()+\"-\"+month+\"-\"+day;\r\n");
      out.write("    }\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("        //信审结论approveConclusion\r\n");
      out.write("        $('#proj_credit_result_creditresulttype').val(\"credit_type_@11\");//默认值\r\n");
      out.write("    dictOnSelect('id_credit_result_type','proj_info.approvetype','CreditType','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.approvetype\"] ? \"credit_type_@11\" : requestScope[\"proj_info.approvetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',function(i,v){\r\n");
      out.write("    \t\tif(v.value){\r\n");
      out.write("    \t\t\tvar statusVal = v.value.substr(v.value.indexOf(\"@\") + 1);\r\n");
      out.write("    \t\t\t$('#id_credit_result_value').val(statusVal);\r\n");
      out.write("    \t\t\t$('#proj_credit_result_creditresulttype').val(v.value);\r\n");
      out.write("    \t\t} else{\r\n");
      out.write("    \t\t\talert(\"请指定信审结论\");\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t}\r\n");
      out.write("\t    );\r\n");
      out.write("        //信审日期默认当前日期\r\n");
      out.write("        var curdate = getCurrentDate();\r\n");
      out.write("        $(\"#id_proj_projcreditpasstime\").val(curdate);\r\n");
      out.write("      });\r\n");
      out.write("    </script>\r\n");
      out.write("         <!-- 给信审赋值 -->\r\n");
      out.write("<input id=\"proj_credit_result_creditresulttype\" name=\"proj_credit_result.creditresulttype\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_credit_result.creditresulttype'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<input id=\"id_credit_result_value\" name=\"credit_result_value\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['credit_result_value'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    \r\n");
      out.write("         <table cellspacing=\"0\" cellpadding=\"0\"  id=\"proj_credit_result\">\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-proj-credit-result\"></div>审核结论</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">信审结论：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_credit_result_type\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">信审日期：</td><td class=\"td-content\"><input id=\"id_proj_projcreditpasstime\" name=\"proj_credit_result.projcreditpasstime\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" dataType=\"Date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_credit_result.projcreditpasstime'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  onClick=\"WdatePicker(this,{readOnly:true})\" readOnly /><font class=\"required-content\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">备注：</td>\r\n");
      out.write("\t\t    <td class=\"td-content\" colspan=\"3\"><textarea rows=\"5\"  \r\n");
      out.write("\t\t\tstyle=\"width:98.2%;float:left;\" name=\"proj_other_info.approveconclusion\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.approveconclusion'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t     </td>\r\n");
      out.write("\t       </tr> \r\n");
      out.write("        </table>");
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
