package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.distributor.distributor_005freview;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fbase_005fother_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\t/* */new tracywindyTree2Table({\r\n");
      out.write("\t   width:formWidth-1,\r\n");
      out.write("\t   isAutoHeight:true,\r\n");
      out.write("\t   refreshStatisticCallBack:window.setCreditLevel,\r\n");
      out.write(" \t   renderTo:'div_id_dealer_local_report',\r\n");
      out.write(" \t   id:'dealer_local_report_data',\r\n");
      out.write(" \t   rootDictId:'doc_code_1300',\r\n");
      out.write(" \t   savedDataKey:'dealer_local_report_data'+flowUnid,\r\n");
      out.write(" \t   savedDataKey1:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.id'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t   savedDataKey2:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.approvalnum'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t   savedDataKey3:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",  //当前流程的ID\r\n");
      out.write("\t   savedDataKey4:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['currentWorkFlowName']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",//流程名称\r\n");
      out.write(" \t   height:document.documentElement.clientHeight-50,\r\n");
      out.write(" \t   totalScoreGrantValueTo:\"id_local_report_result\",\r\n");
      out.write(" \t   treeTableJson:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_dealer_local_report_str ? \"[]\" : json_dealer_local_report_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("    });\r\n");
      out.write("\t new tracywindyTree2Table({\r\n");
      out.write("\t\t   scoreAllLabel :\"可偿债净资产总额\",\r\n");
      out.write("\t\t   scoreDictLabel:\"可偿债价值\",\r\n");
      out.write("\t\t   grantValueCallback:function(rowIndex,treeTableId,scoreFlag,treeDictId,dataValue,treeTableTdObj_id,refreshSum){\r\n");
      out.write("\t\t\t\tvar treeTableObj = getTracywindyObject(treeTableId);\r\n");
      out.write("\t\t\t\tvar tableConfig  = treeTableObj.tableConfig;\r\n");
      out.write("\t\t\t\tvar treeTableJsonRowData = tableConfig.treeDataMapping;\r\n");
      out.write("\t\t\t\tvar isFound = true;\r\n");
      out.write("\t\t\t\tvar treeTableJsonColumnsData = treeTableJsonRowData[treeTableTdObj_id];\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar $dataDom1 = jQuery(treeTableObj.dom).find(\"[columnId='\"+treeTableJsonColumnsData[0].id+\"']\");\r\n");
      out.write("\t\t\t\t\tvar $dataDom2 = jQuery(treeTableObj.dom).find(\"[columnId='\"+treeTableJsonColumnsData[1].id+\"']\");\r\n");
      out.write("\t\t\t\t\tvar treeTableJsonColumnData1 = parseFloat($dataDom1.val()||$dataDom1.html());\r\n");
      out.write("\t\t\t\t\tvar treeTableJsonColumnData2 = parseFloat($dataDom2.val()||$dataDom2.html());\r\n");
      out.write("\t\t\t\t\tisFound = (!isNaN(treeTableJsonColumnData1)&&!isNaN(treeTableJsonColumnData2));\r\n");
      out.write("\t\t\t\t\ttreeTableJsonColumnData1     = isNaN(treeTableJsonColumnData1) ?  0.0 : treeTableJsonColumnData1;\r\n");
      out.write("\t\t\t\t\ttreeTableJsonColumnData2     = isNaN(treeTableJsonColumnData2) ?  0.0 : treeTableJsonColumnData2;\r\n");
      out.write("\t\t\t\t\tif(isFound){\r\n");
      out.write("\t\t\t\t\t\t$(treeTableObj.dom).find(\"td[scoreFlag='\"+scoreFlag+\"']\").html(decimal(treeTableJsonColumnData1*treeTableJsonColumnData2,2));\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\t$(treeTableObj.dom).find(\"td[scoreFlag='\"+scoreFlag+\"']\").html(\"-\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(refreshSum){\r\n");
      out.write("\t\t\t\t\t   treeTableObj.refreshStatistic(false);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn isFound;\r\n");
      out.write("\t\t   },\r\n");
      out.write("\t\t   width:formWidth-1,\r\n");
      out.write("\t\t   isAutoHeight:true,\r\n");
      out.write("\t \t   renderTo:'div_id_dealer_credit_report',\r\n");
      out.write("\t \t   id:'dealer_credit_report_data',\r\n");
      out.write("\t \t   rootDictId:'doc_code_1200',\r\n");
      out.write("\t \t   savedDataKey:'dealer_credit_report_data'+flowUnid,\r\n");
      out.write("\t \t   savedDataKey1:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.id'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t\t   savedDataKey2:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.approvalnum'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t\t   savedDataKey3:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",  //当前流程的ID\r\n");
      out.write("\t\t   savedDataKey4:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['currentWorkFlowName']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",//流程名称\r\n");
      out.write("\t \t   height:document.documentElement.clientHeight-50,\r\n");
      out.write("\t \t   totalScoreGrantValueTo:\"id_credit_report_result\",\r\n");
      out.write("\t \t   treeTableJson:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_dealer_credit_report_str ? \"[]\" : json_dealer_credit_report_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t    });  \r\n");
      out.write("\t new tracywindyTree2Table({\r\n");
      out.write("\t   width:formWidth-1,\r\n");
      out.write("\t   isAutoHeight:true,\r\n");
      out.write(" \t   renderTo:'div_id_dealer_notlocal_report',\r\n");
      out.write(" \t   id:'dealer_notlocal_report_data',\r\n");
      out.write(" \t   rootDictId:'doc_code_100',\r\n");
      out.write(" \t   savedDataKey:'dealer_notlocal_report_data'+flowUnid,\r\n");
      out.write(" \t   savedDataKey1:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.id'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t   savedDataKey2:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['dealer_approval_info.approvalnum'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t   savedDataKey3:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",  //当前流程的ID\r\n");
      out.write("\t   savedDataKey4:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['currentWorkFlowName']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",//流程名称\r\n");
      out.write(" \t   height:document.documentElement.clientHeight-50,\r\n");
      out.write(" \t   treeTableJson:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_dealer_notlocal_report_str ? \"[]\" : json_dealer_notlocal_report_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t}); \r\n");
      out.write("});\r\n");
      out.write("function checkboxReport(obj){\r\n");
      out.write("\tif(obj==\"1\"){\r\n");
      out.write("\t\t$(\"#id_div_id_dealer_report\").css(\"display\",\"block\");\r\n");
      out.write("\t\t$(\"#div_id_dealer_notlocal_report\").css(\"display\",\"none\"); \r\n");
      out.write("\t\t//iniTreeTable(\"dealer_local_report_data\",\"doc_code_1\");\r\n");
      out.write("    }else{\r\n");
      out.write("    \t$(\"#id_div_id_dealer_report\").css(\"display\",\"none\");\r\n");
      out.write("    \t$(\"#div_id_dealer_notlocal_report\").css(\"display\",\"block\"); \r\n");
      out.write("    \t//iniTreeTable(\"dealer_notlocal_report_data\",\"doc_code_100\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//保存报告\r\n");
      out.write("function saveDocReport(){\r\n");
      out.write("\t//reportResult();\r\n");
      out.write("\ttry{\r\n");
      out.write("\t\tvar jsonValue=getTracywindyObject(\"dealer_local_report_data\").getTableAllSavedConfigJson();\r\n");
      out.write("\t\tjsonValue=JsonUtil.doEncode(jsonValue);\r\n");
      out.write("\t\tjQuery(\"#id_json_dealer_local_report_str\").val(jsonValue);\r\n");
      out.write("\r\n");
      out.write("\t\tjsonValue=getTracywindyObject(\"dealer_credit_report_data\").getTableAllSavedConfigJson();\r\n");
      out.write("\t\tjsonValue=JsonUtil.doEncode(jsonValue);\r\n");
      out.write("\t\tjQuery(\"#id_json_dealer_credit_report_str\").val(jsonValue);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tjsonValue=getTracywindyObject(\"dealer_notlocal_report_data\").getTableAllSavedConfigJson();\r\n");
      out.write("\t\tjsonValue=JsonUtil.doEncode(jsonValue);\r\n");
      out.write("\t\tjQuery(\"#id_json_dealer_notlocal_report_str\").val(jsonValue);\r\n");
      out.write("\t}catch(e){\r\n");
      out.write("\t\talert(e);\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("function changetMoney(){\r\n");
      out.write("\tvar f= parseFloat(parseFloat(jQuery(\"#id_credit_report_result\").val())-parseFloat(jQuery(\"#id_credit_report_result2\").val())).toFixed(2);\r\n");
      out.write("\tjQuery(\"#id_credit_report_result3\").val(f);\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" >\r\n");
      out.write("\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\ttoggleClass=\"tr-dealer-report\"></div>\r\n");
      out.write("\t\t考察报告</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"dealer-report\">\r\n");
      out.write("\t\t<td class=\"td-even-line-separator\">\r\n");
      out.write("\t\t<input name=\"reporttype\" type=\"radio\" checked onclick=\"checkboxReport(this.value)\" value=\"1\" />现场考察经销商评审报告 \r\n");
      out.write("\t\t<input name=\"reporttype\" type=\"radio\" onclick=\"checkboxReport(this.value)\"  value=\"2\"/>非现场考察经销商评审报告\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-dealer-report\">\r\n");
      out.write("\t\t<td class=\"td-even-line-separator\">\r\n");
      out.write("\t\t\t<!-- 现场考察报告页签 -->\r\n");
      out.write("\t\t\t<div id='id_div_id_dealer_report'  class=\"fillTableContainer\">\r\n");
      out.write("\t\t\t   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t<tr class=\"tr-div-id-dealer-report\">\r\n");
      out.write("\t\t\t\t\t<td  class=\"td-tabs-container\" style=\"text-indent: 0px;\">\r\n");
      out.write("\t\t\t\t\t<div id=\"div-id-dealer-report\" style=\"\">\r\n");
      out.write("\t\t\t\t\t\t<div title=\"现场考察经销商评审报告\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"div_id_dealer_local_report\" \tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"id_json_dealer_local_report_str\"  style=\"display:none\" name=\"json_dealer_local_report_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_dealer_local_report_str ? \"[]\" : json_dealer_local_report_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div title=\"经销商综合能力评估及合作建议报告\" style=\"overflow:hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t<table cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"div_id_dealer_credit_report\"  \tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"id_json_dealer_credit_report_str\"  type=\"hidden\"  name=\"json_dealer_credit_report_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_dealer_credit_report_str ? \"[]\" : json_dealer_credit_report_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t可偿债净资产的测算\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t可偿债净资产是指可偿债资产偿还总负债后的余额, 即:\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t可偿债净资产=可偿债资产-负债总额\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t可偿债净资产\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"id_credit_report_result\" name=\"dealer_approval_info.creditmoney1\" class=\"td-content-input td-content-readonly\" readonly=\"readonly\" type=\"text\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.creditmoney1\"] ? \"0.00\" : requestScope[\"dealer_approval_info.creditmoney1\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t负债总额\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"id_credit_report_result2\" name=\"dealer_approval_info.creditmoney2\" type=\"\"text\"\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.creditmoney2\"] ? \"0.00\" : requestScope[\"dealer_approval_info.creditmoney2\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' onblur=\"changetMoney()\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t可偿债净资产\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"id_credit_report_result3\" name=\"dealer_approval_info.creditmoney3\"  class=\"td-content-input td-content-readonly\" readonly=\"readonly\"  type=\"\"text\"\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"dealer_approval_info.creditmoney3\"] ? \"0.00\" : requestScope[\"dealer_approval_info.creditmoney3\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 非现场考察报告页签 -->\r\n");
      out.write("\t\t\t<div id=\"div_id_dealer_notlocal_report\" style=\"display:none\">\r\n");
      out.write("\t\t\t<input id=\"id_json_dealer_notlocal_report_str\"   style=\"display:none\" name=\"json_dealer_notlocal_report_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_dealer_notlocal_report_str ? \"[]\" : json_dealer_notlocal_report_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  </table>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t//第一个页签集合\r\n");
      out.write("\t\t$(\"#div-id-dealer-report\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t$(\"#div-id-dealer-report\").tabs();\r\n");
      out.write("\t\tisSubTable = false;//标志主页面加载完成\r\n");
      out.write("\t});\r\n");
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
