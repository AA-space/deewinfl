package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fput01_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   var isSubTable = false;\r\n");
      out.write("   isViewHistoryTask = true;\r\n");
      out.write("   isNeedBank = false;\r\n");
      out.write("   isNeedBankEdit = false;\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\tif(!checkTracywindyTableData(\"table_id_table_leasing_contract_fund_payment_now_container\",\"本次投放信息\")){return false;}\r\n");
      out.write("\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');\r\n");
      out.write("\t    var planTable = getTracywindyObject('table_id_table_leasing_delivery_plan');\r\n");
      out.write("\t    //计算合计计划投放金额\r\n");
      out.write("\t    var datas = planTable.tableData;\r\n");
      out.write("\t    var talbedata=currentTable1.getRowsData();\r\n");
      out.write("\t    for(i=0;i<talbedata.length;i++){\r\n");
      out.write("\t    \t//talbedata[i].factmoney;talbedata[i].paymentid\r\n");
      out.write("\t    \tfor(j=0;j<datas.length;j++)\r\n");
      out.write("\t    \t{\r\n");
      out.write("\t\t    \tif(talbedata[i].paymentid==datas[j].paymentid)\r\n");
      out.write("\t\t    \t{\r\n");
      out.write("\t\t\t    \tif(parseFloat(talbedata[i].factmoney)+parseFloat(talbedata[i].creditmoney)>parseFloat(datas[j].planbalance))\r\n");
      out.write("\t\t\t    \t{   \r\n");
      out.write("\t\t\t\t    \talert(\"本次投放金额不能大于计划投放金额\");\r\n");
      out.write("\t\t\t\t    \treturn false;\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    }\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\tvar isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\treturn isPassed;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\t\t\t\t\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_premise_str\" name=\"json_contract_premise_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_premise_str ? \"[]\" : json_contract_premise_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/> <!-- 前提条件 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_leasing_delivery_plan_str\" name=\"json_leasing_delivery_plan_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_leasing_delivery_plan_str ? \"[]\" : json_leasing_delivery_plan_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/> <!-- 投放计划 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_fundfundcharge_str\" name=\"json_fundfundcharge_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fundfundcharge_str ? \"[]\" : json_fundfundcharge_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/> <!-- 资金收款明细 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_fund_payment_history_str\" name=\"json_contract_fund_payment_history_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_fund_payment_history_str ? \"[]\" : json_contract_fund_payment_history_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/> <!-- 历史付款明细 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_fund_payment_now_str\" name=\"json_contract_fund_payment_now_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_fund_payment_now_str ? \"[]\" : json_contract_fund_payment_now_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/> <!-- 本次投放明细 -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入合同基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../contract/contract_approval/contract_base_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-project-business-condition\"></div>\r\n");
      out.write("\t\t项目商务条件</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-business-condition\">\r\n");
      out.write("\t\t<td colspan=4 class=\"td-tabs-container\" style=\"text-indent: 0px;\">\r\n");
      out.write("\t\t\t<!-- 标签栏 -->\r\n");
      out.write("\t\t\t<div id='id_project_info_tabs_content' style=\"\">\r\n");
      out.write("\t\t\t\t\t<div title=\"前提条件\">\r\n");
      out.write("\t\t\t\t\t    <span class=\"print-tabs-title-content\">前提条件</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_contract_premise_container\" style=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div title=\"投放计划\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">投放计划</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_delivery_plan\" style=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t               <div title=\"资金收款明细\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">资金收款明细</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_funds_collection_details\" \tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div title=\"本次投放明细\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">本次投放明细</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_contract_fund_payment_now_container\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"height: 350px;\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div title=\"已投放明细\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">已投放明细</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_contract_fund_payment_history_container\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div title=\"合同额度明细\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">合同额度明细</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_contract_limit_list\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div title=\"租金发票类型\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">租金发票类型</span>\r\n");
      out.write("\t\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../contract/contract_approval/contract_invoice_type.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<!--避免在tabs中的js重复执行-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../contract/contract_approval/contract_premise_info.jsp", out, false);
      out.write(" <!-- 前提条件 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "funds_collection_details.jsp", out, false);
      out.write(" <!-- 资金收款明细 -->\r\n");
      out.write(" <script language=\"javascript\">\r\n");
      out.write("    jQuery(function() {isViewHistoryTask = isCompletedTask;});\r\n");
      out.write("</script>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "delivery_plan.jsp", out, false);
      out.write(" <!-- 投放计划 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fund_payment_history.jsp", out, false);
      out.write(" <!-- 已投放明细 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_put_this_deewinfl.jsp", out, false);
      out.write(" <!-- 本次投放明细 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "funds_limit_limit.jsp", out, false);
      out.write(" <!-- 额度明细 -->\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tjQuery(function() {isViewHistoryTask = true;});\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("//隐藏域在提交或保存前的赋值\r\n");
      out.write("function fillHiddenVal() {\r\n");
      out.write("\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_contract_premise_container');\r\n");
      out.write("\tjQuery('#id_json_contract_premise_str').val(\r\n");
      out.write("\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData())); //前提条件 \r\n");
      out.write("\t\r\n");
      out.write("\tvar currentTable2 = getTracywindyObject('table_id_table_leasing_delivery_plan');\r\n");
      out.write("\tjQuery('#id_json_leasing_delivery_plan_str').val(\r\n");
      out.write("\t\t\tJsonUtil.encode(currentTable2.getRowsJsonData())); //投放计划\r\n");
      out.write("\t\t\t\r\n");
      out.write("\tvar currentTable3 = getTracywindyObject('table_leasing_funds_collection_details'); //资金收款明细\r\n");
      out.write("\tjQuery('#id_json_fundfundcharge_str').val(\r\n");
      out.write("\t\t\tJsonUtil.encode(currentTable3.getRowsJsonData()));\r\n");
      out.write("\t\r\n");
      out.write("\tvar currentTable4 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container'); //本次投放明细\r\n");
      out.write("\tjQuery('#id_json_contract_fund_payment_now_str').val(\r\n");
      out.write("\t\t\tJsonUtil.encode(currentTable4.getRowsJsonData()));\r\n");
      out.write("\t\r\n");
      out.write("\tvar currentTable5 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_history_container'); //已投放明细\r\n");
      out.write("\tjQuery('#id_json_contract_fund_payment_history_str').val(\r\n");
      out.write("\t\t\tJsonUtil.encode(currentTable5.getRowsJsonData()));\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar isSubTable = true;\r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t$(\"#id_project_info_tabs_content\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t$(\"#id_project_info_tabs_content\").tabs();\r\n");
      out.write("\t\tisSubTable = false;\r\n");
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
