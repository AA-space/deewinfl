package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005ftranslation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005ftranslation02_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../../project/proj_approval/base.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   var isSubTable = true;\r\n");
      out.write("   //isViewHistoryTask = true;\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\t//fillHiddenVal();\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//保存成功提交后，后台返回\r\n");
      out.write("\tfunction saveCallBack() {\r\n");
      out.write("\t\t//var submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\t//alert(Validator);\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\tif(!checkTracywindyTableData(\"table_id_table_leasing_delivery_plan\",\"本次回笼租金明细\")){return false;}  \r\n");
      out.write("\t\t//if(!checkRentCharge()){return false;};\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\t//var isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\t//return isPassed;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\t\t\t\t\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("<!-- 本次实收 -->\r\n");
      out.write("<input  type=\"hidden\" id=\"id_json_id_fund_rent_income\" name=\"json_id_fund_rent_income\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_id_fund_rent_income ? \"[]\" : json_id_fund_rent_income }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t   <tr>\r\n");
      out.write("\t\t\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr_ebank_info\"></div>网银信息</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr_ebank_info\">\r\n");
      out.write("\t\t<td colspan=4><!-- 网银信息--> \r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_ebankdata.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t<tr id=\"fund_money_collectioninfo\" style=\"display: none\">\r\n");
      out.write("\t\t<td colspan=4><!-- 未付租金查询 --> \r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_payquipment.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t    \t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr_project_info\"></div>未回笼租金明细</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\t<tr class=\"tr_project_info\" style=\"display: none\">\r\n");
      out.write("\t\t<td colspan=4 ><!-- 未回笼租金明细 --> \r\n");
      out.write("\t\t<div id=\"id_fund_plan_detial\" ></div>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_detail.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr_project\"></div>本次回笼租金明细</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("\t<tr class=\"tr_project\">\r\n");
      out.write("\t\t<td colspan=4><!-- 本次回笼租金明细 --> <div id=\"id_table_leasing_delivery_plan\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_translationinfo.jsp", out, false);
      out.write("</div></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("//隐藏域在提交或保存前的赋值\r\n");
      out.write("function fillHiddenVal() {\r\n");
      out.write("\tvar currentTable2 = getTracywindyObject('table_id_table_leasing_delivery_plan');\r\n");
      out.write("\tjQuery('#id_json_id_fund_rent_income').val(JsonUtil.encode(currentTable2.getRowsJsonData()));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar isSubTable = true;\r\n");
      out.write("\r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t//$(\"#id_project_info_tabs_content\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t//$(\"#id_project_info_tabs_content\").tabs();\r\n");
      out.write("\t\t//isSubTable = false;\r\n");
      out.write("\t\t//var d = $(\"#id_project_info_tabs_content\");\r\n");
      out.write("\t\t//$(\"#id_project_fund_rent_plan_tabs_content\").css(\"width\",\r\n");
      out.write("\t\t//\t\t(formWidth) + \"px\");\r\n");
      out.write("\t\t//$(\"#id_project_fund_rent_plan_tabs_content\").tabs();\r\n");
      out.write("\t\t//jQuery(\".fillTableContainer\").css(\"width\",formWidth+\"px\");\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
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
