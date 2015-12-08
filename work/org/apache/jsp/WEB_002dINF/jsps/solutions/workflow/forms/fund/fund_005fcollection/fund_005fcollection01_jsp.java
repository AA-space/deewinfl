package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fcollection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005fcollection01_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   var isSubTable = true;\r\n");
      out.write("   isViewHistoryTask = true;\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\t//createProjectName();\r\n");
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
      out.write("\t\t//检查租赁物明细\r\n");
      out.write("\t\tif(!checkTracywindyTableData(\"table_id_table_receivercharge_container\",\"本次收款信息\")){return false;}  \r\n");
      out.write("\t\t if(!checkFundCharge()){return false;};\r\n");
      out.write("\t\t if(!checkLimit()){return false;};\r\n");
      out.write("\t\t \r\n");
      out.write("\t/* \tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\tvar isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\talert(isPassed);\r\n");
      out.write("\t\treturn isPassed; */\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<!-- 收款计划 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_receiverchargeplan_str\" name=\"json_receiverchargeplan_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_receiverchargeplan_str ? \"[]\" : json_receiverchargeplan_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<!-- 历史收款 -->\r\n");
      out.write("<input type=\"hidden\"  id=\"id_json_receiverchargehistory_str\" name=\"json_receiverchargehistory_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_receiverchargehistory_str ? \"[]\" : json_receiverchargehistory_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<!-- 本次收款 -->\r\n");
      out.write("<input  type=\"hidden\" id=\"id_json_receivercharge_str\" name=\"json_receivercharge_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_receivercharge_str ? \"[]\" : json_receivercharge_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<input  type=\"hidden\" id=\"id_json_fund_limit_str\" name=\"json_fund_limit_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fund_limit_str ? \"[]\" : json_fund_limit_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("   <tr>\r\n");
      out.write("\t\t<td ><!-- 插入合同基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../contract/contract_approval/contract_base_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-business-condition\">\r\n");
      out.write("\t\t<td colspan=4 class=\"td-tabs-container\" style=\"text-indent: 0px;\">\r\n");
      out.write("\t\t<!-- 标签栏 -->\r\n");
      out.write("\t\t<div id='id_project_info_tabs_content' style=\"\">\r\n");
      out.write("\t\t <div title=\"网银信息\">\r\n");
      out.write("\t\t    <div id=\"id_table_leasing_fundebankdata_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_ebankdata.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t <div title=\"资金收款计划\">\r\n");
      out.write("\t\t\t<div id=\"id_table_receiverchargeplan_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t     <div title=\"历史收款明细\">\r\n");
      out.write("\t\t    <div id=\"id_table_receiverchargehistory_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t <div title=\"本次收款信息\">\r\n");
      out.write("\t\t    <div id=\"id_table_receivercharge_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t <div title=\"额度管理\">\r\n");
      out.write("\t\t    <div id=\"id_table_limit_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr> \r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write(" <script language=\"javascript\">\r\n");
      out.write("   jQuery(function() {isViewHistoryTask = isCompletedTask;});\r\n");
      out.write("</script>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_receiverchargeplan.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_receiverchargehistory.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_receivercharge.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_limit.jsp", out, false);
      out.write("\r\n");
      out.write(" <script language=\"javascript\">\r\n");
      out.write("   jQuery(function() {isViewHistoryTask = true;});\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("\t//隐藏域在提交或保存前的赋值\r\n");
      out.write("\tfunction fillHiddenVal() {\r\n");
      out.write("\t\t//收款计划\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_receiverchargeplan_container');\r\n");
      out.write("\t\tjQuery('#id_json_receiverchargeplan_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("        //历史收款\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_receiverchargehistory_container');\r\n");
      out.write("\t\tjQuery('#id_json_receiverchargehistory_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//本次实收\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_receivercharge_container');\r\n");
      out.write("\t\tjQuery('#id_json_receivercharge_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//保存额度\r\n");
      out.write("\t\tvar currentTable2 = getTracywindyObject('table_id_table_limit_container');\r\n");
      out.write("\t\tjQuery('#id_json_fund_limit_str').val(JsonUtil.encode(currentTable2.getRowsJsonData()));\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tvar isSubTable = true;\r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#id_project_info_tabs_content\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t$(\"#id_project_info_tabs_content\").tabs();\r\n");
      out.write("\t\tisSubTable = false;\r\n");
      out.write("\t\r\n");
      out.write("\t\tjQuery(\".fillTableContainer\").css(\"width\",formWidth+\"px\");\r\n");
      out.write("\t\t\r\n");
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
