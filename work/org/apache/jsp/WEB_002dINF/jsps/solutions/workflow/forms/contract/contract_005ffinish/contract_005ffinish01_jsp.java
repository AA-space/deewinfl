package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005ffinish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005ffinish01_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- 插入样式和JS -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../project/proj_approval/base.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar isSubTable = true;\r\n");
      out.write("\tisViewHistoryTask=true;\r\n");
      out.write("\tfunction formPageReadOnlyCallBack(){  \r\n");
      out.write("\t\tif(!isCompletedTask){\r\n");
      out.write("\t\t\tformJSPInputHideOrShow(\"contract_summary\",\"\",1);\r\n");
      out.write("\t\t\tformJSPInputHideOrShow(\"contract_over\",\"contract_condition.endirr\",1);\r\n");
      out.write("\t\t\tformJSPInputHideOrShow(\"cont_base_info\",\"contract_equip.contractid,contract_info.projectdept\",1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\treturn true;   \r\n");
      out.write("\t}\r\n");
      out.write("\t//保存成功提交后，后台返回\r\n");
      out.write("\tfunction saveCallBack() {\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\t//alert(Validator);\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\tvar submitProcessedForm1 = document.getElementById(\"id_table_leasing_contract_over_info_container\");\r\n");
      out.write("\t\tvar submitProcessedForm2 = document.getElementById(\"id_table_leasing_contract_change_compoment_container\");\r\n");
      out.write("\t\tvar submitProcessedForm3 = document.getElementById(\"id_table_leasing_contract_over_com_container\");\r\n");
      out.write("\t\tif(!Validator.Validate(submitProcessedForm1,1,false)){return false;}\r\n");
      out.write("\t\tif(!Validator.Validate(submitProcessedForm2,1,false)){return false;}\r\n");
      out.write("\t\tif(!Validator.Validate(submitProcessedForm3,1,false)){return false;}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tisSubTable = true;\r\n");
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
      out.write("<!-- 付款计划 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_payfundchargeplan_str\" name=\"json_paychargeplan_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_paychargeplan_str ? \"[]\" : json_paychargeplan_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<!-- 历史付款 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_fund_payment_history_str\" name=\"json_contract_fund_payment_history_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_fund_payment_history_str ? \"[]\" : json_contract_fund_payment_history_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/> \r\n");
      out.write("<!-- 租金计划 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_fund_rent_plans\" name=\"fund_rent_plans\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty fund_rent_plans ? \"[]\" : fund_rent_plans }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<!-- 历史租金收款 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_fund_income_history\" name=\"fund_income_history\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty fund_income_history ? \"[]\" : fund_income_history }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_reg_list\" name=\"json_reg_list_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_reg_list_str ? \"[]\" : json_reg_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t <tr>\r\n");
      out.write("\t\t<td colspan=4>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../contract_approval/contract_base_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-business-condition\"></div>\r\n");
      out.write("\t\t合同结束</td>\r\n");
      out.write("\t</tr> \r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t <tr class=\"tr-project-business-condition\">\r\n");
      out.write("\t\t<td colspan=4 class=\"td-tabs-container\" style=\"text-indent: 0px;\">\r\n");
      out.write("\t\t<div id='id_project_info_tabs_content' style=\"\">\r\n");
      out.write("\t\t<div title=\"租赁物明细\">\r\n");
      out.write("\t\t\t<div id=\"id_table_leasing_proj_equip_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"资金收款计划\">\r\n");
      out.write("\t\t\t\t\t<div id=\"id_table_receiverchargeplan_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t<div title=\"资金付款计划\">\r\n");
      out.write("\t\t\t<div id=\"id_table_leasing_json_paychargeplan_container\" style=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t<div title=\"租金回笼计划\">\r\n");
      out.write("\t\t\t\t<div id=\"id_fund_income_plans_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t<div title=\"资金收款历史\">\r\n");
      out.write("\t\t\t\t\t<div id=\"id_table_receiverchargehistory_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t    <div title=\"资金付款历史\">\r\n");
      out.write("\t\t\t<div id=\"id_table_leasing_contract_fund_payment_history_container\" style=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"租金回笼历史\">\r\n");
      out.write("\t\t\t<div id=\"id_fund_income_history_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"合同结束信息\">\r\n");
      out.write("\t\t\t<div id=\"id_table_leasing_contract_over_info_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t <script language=\"javascript\">\r\n");
      out.write("\t\t\t    jQuery(function() {isViewHistoryTask = isCompletedTask;});\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_over.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t    jQuery(function() {isViewHistoryTask = true;});\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"合同登记资料返还\">\r\n");
      out.write("\t\t\t<div id=\"id_table_leasing_doc_send_info\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t    jQuery(function() {isViewHistoryTask = isCompletedTask;});\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "reg_list.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t    jQuery(function() {isViewHistoryTask = true;});\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>   \r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<!--避免在tabs中的js重复执行-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../contract_terminate/contract_terminate_equip_detail.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../fund/fund_collection/fund_receiverchargeplan.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../fund/fund_payment/fund_paychargeplan.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../fund/fund_collection/fund_receiverchargehistory.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../fund/fund_payment/fund_payment_history.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../assets/fund/fund_income/fund_income_plan.jsp", out, false);
      out.write("<!-- 租金回笼计划 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../assets/fund/fund_income/fund_income_history.jsp", out, false);
      out.write("<!-- 租金回笼历史 -->\r\n");
      out.write("<script>\r\n");
      out.write("\t//隐藏域在提交或保存前的赋值\r\n");
      out.write("\tfunction fillHiddenVal() {\r\n");
      out.write("\t\t//收款计划\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_receiverchargeplan_container');\r\n");
      out.write("\t\tjQuery('#id_json_receiverchargeplan_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//历史收款\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_receiverchargehistory_container');\r\n");
      out.write("\t\tjQuery('#id_json_receiverchargehistory_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//付款计划\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_json_paychargeplan_container');\r\n");
      out.write("\t\tjQuery('#id_json_payfundchargeplan_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//历史付款\r\n");
      out.write("\t\tvar currentTable2 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_history_container');\r\n");
      out.write("\t\tjQuery('#id_json_contract_fund_payment_history_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable2.getRowsJsonData()));\r\n");
      out.write("\t\t//回笼计划\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_fund_income_plans_container');\r\n");
      out.write("\t\tjQuery('#id_json_fund_rent_plans').val(JsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//回笼历史\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_fund_income_history_container');\r\n");
      out.write("\t\tjQuery('#id_json_fund_income_history').val(JsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_doc_send_info');\r\n");
      out.write("\t\tjQuery('#id_json_reg_list').val(JsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t$(\"#id_project_info_tabs_content\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t$(\"#id_project_info_tabs_content\").tabs();\r\n");
      out.write("\t\tisSubTable = false;\r\n");
      out.write("\t\tvar d = $(\"#id_project_info_tabs_content\");\r\n");
      out.write("\t\t$(\"#id_project_fund_rent_plan_tabs_content\").css(\"width\",\r\n");
      out.write("\t\t\t\t(formWidth) + \"px\");\r\n");
      out.write("\t\t$(\"#id_project_fund_rent_plan_tabs_content\").tabs();\r\n");
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
