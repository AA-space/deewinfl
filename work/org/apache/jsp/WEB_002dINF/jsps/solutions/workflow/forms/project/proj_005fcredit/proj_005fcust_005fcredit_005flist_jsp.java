package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcust_005fcredit_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTree2Table.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//保存报告\r\n");
      out.write("function saveDocReport(){\r\n");
      out.write("\ttry{\r\n");
      out.write("\t\tvar jsonValue=getTracywindyObject(\"cust_credit\").getTableAllSavedConfigJson();\r\n");
      out.write("\t\tjsonValue=JsonUtil.doEncode(jsonValue);\r\n");
      out.write("\t\tjQuery(\"#id_json_cust_credit_str\").val(jsonValue);\r\n");
      out.write("\t}catch(e){\r\n");
      out.write("\t\talert(e);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("function setCustCreditLevel(grade){\r\n");
      out.write("\tif(grade==\"\"){grade=0;}\r\n");
      out.write("\tvar lastGrade=parseFloat(grade);\r\n");
      out.write("\tvar leave=\"\";\r\n");
      out.write("\tif(lastGrade<=50){leave=\"E\";}\r\n");
      out.write("\telse if(lastGrade<=60){leave=\"D\";}\r\n");
      out.write("\telse if(lastGrade<=70){leave=\"C\";}\r\n");
      out.write("\telse if(lastGrade<=80){leave=\"B\";}\r\n");
      out.write("\telse{leave=\"A\";}\r\n");
      out.write("\t$(\"#id_cust_credit_level\").val(leave);\r\n");
      out.write("}\r\n");
      out.write("//树转表每行必选校验\r\n");
      out.write("function checkRadio(){\r\n");
      out.write("\tvar radioAmaount = $('#id_table_leasing_proj_cust_creidt_container :radio:checked').length;\r\n");
      out.write("\treturn radioAmaount == 15 ;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" id=\"id_cust_cedit_result_info\" >\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div id=\"div-id-custcredit-report\" style=\"\">\r\n");
      out.write("\t\t\t\t<div id=\"div_id_cust_credit\" \tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t<input id=\"id_json_cust_credit_str\"  style=\"display:none\" name=\"json_cust_credit_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_cust_credit_str ? \"[]\" : json_cust_credit_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"\">\r\n");
      out.write("\t\t<td><div style=\"float:left\">经过对该客户信用评分的评测,该客户的综合得分为:</div>\r\n");
      out.write("\t\t\t<input style=\"float:left\" id=\"id_cust_credit_score\" name=\"proj_other_info.custcredit\" onpropertychange=\"setCustCreditLevel(this.value)\" oninput=\"setCustCreditLevel(this.value)\" type=\"text\" size=3 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_other_info.custcredit\"] ? \"0.00\" : requestScope[\"proj_other_info.custcredit\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' readOnly=\"true\" class=\"td-content-readonly\" />\r\n");
      out.write("\t\t\t<div style=\"float:left\">分  建议评级</div><input  style=\"float:left\"id=\"id_cust_credit_level\" name=\"proj_other_info.custcreditlevel\" type=\"text\" size=1 value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_other_info.custcreditlevel\"] ? \"0.00\" : requestScope[\"proj_other_info.custcreditlevel\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' readonly=\"readonly\" class=\"td-content-readonly\" /><div style=\"float:left\">级</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t//第一个页签集合\r\n");
      out.write("// \t\t$(\"#div-id-custcredit-report\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("// \t\t$(\"#div-id-custcredit-report\").tabs();\r\n");
      out.write("\t\tisSubTable = false;//标志主页面加载完成\r\n");
      out.write("\t})\r\n");
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
