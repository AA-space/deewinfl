package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.distributor.distributor_005freview;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class distributor_005fapproval01_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- 插入样式和JS -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../project/proj_approval/base.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\t\r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!saveDocReport()){\r\n");
      out.write("\t\t\talert(\"保存考察报告出现异常!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\t//var isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\t//if(!isPassed){return isPassed;}\r\n");
      out.write("\t\treturn workflowSaveCallBack();\r\n");
      out.write("\t}\t\r\n");
      out.write("    /*\r\n");
      out.write("\tfunction workflowNextRouteCallBack(buttonText,requestNextRoute){\r\n");
      out.write("        if(buttonText==\"Submit\"){\r\n");
      out.write("          var reportType=$('input:radio[name=reporttype]:checked').val()||\"\";\r\n");
      out.write("          var  selectRote=\"\";\r\n");
      out.write("          if(reportType==\"1\"){\r\n");
      out.write("              selectRote=\"现场考察\";\r\n");
      out.write("          }else{\r\n");
      out.write("              selectRote=\"非现场考察\";\r\n");
      out.write("          }\r\n");
      out.write("          requestNextRoute.value=selectRote;\r\n");
      out.write("        }\r\n");
      out.write("   }\r\n");
      out.write("  */\r\n");
      out.write("\t   \r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("<table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目基本信息 --> \r\n");
      out.write("\t\t ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4>\r\n");
      out.write("\t\t<!-- 插入是否提前准备钱  -->\r\n");
      out.write("\t\t   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_per_money.jsp", out, false);
      out.write("\r\n");
      out.write("\t    </td> \r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目其它基本信息 -->\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_other_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <td colspan=4>\r\n");
      out.write("\t    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_credit_result_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t    </td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>");
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
