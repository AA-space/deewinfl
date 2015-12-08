package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcredit02_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005fif_0026_005ftest != null) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/base.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/flow_condition_select.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 特殊附件显示公用方法 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/proj_view_file.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目立项附件带到租前业务相关流程 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "initFileListParams.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目信审申请 -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//页面初始化\r\n");
      out.write("var isSubTable=false;\r\n");
      out.write("//全局变量说是这一个只读业页\r\n");
      out.write("isViewHistoryTask = true;\r\n");
      out.write("//是否保存   \r\n");
      out.write("function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("{\r\n");
      out.write("\tfillHiddenVal();\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("//是否提交    \r\n");
      out.write("function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("{\r\n");
      out.write("\tfillHiddenVal();\r\n");
      out.write("\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t//var isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t//if(!isPassed){return isPassed;}\r\n");
      out.write("\t/*if(buttonText==\"Submit\"){\r\n");
      out.write("    \tvar condtion=\"[{condtion:'正常审批',rote:'10台以上资料审核'},{condtion:'直接审批',rote:'10台以上资料齐全'}]\";\r\n");
      out.write("\t\tif(!isSelectRote){\r\n");
      out.write("        \tselectRoteByCondtion(condtion);\r\n");
      out.write("        \treturn false;\r\n");
      out.write("        }else{\r\n");
      out.write("        \treturn isPassed;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\tisSelectRote=false;*/\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("var isSelectRote=false; \r\n");
      out.write("var selectRote=\"\"; \r\n");
      out.write("\r\n");
      out.write("function workflowNextRouteCallBack(buttonText,requestNextRoute){\r\n");
      out.write("    if(buttonText==\"Submit\"){\r\n");
      out.write("   \t\trequestNextRoute.value=\"04信审部经理审核\";\r\n");
      out.write("   \t\t//isSelectRote=false;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_equip_str\" name=\"json_proj_equip_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str ? \"[]\" : json_proj_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_guarantee_method_str\" \tname=\"json_proj_guarantee_method_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_guarantee_method_str ? \"[]\" : json_proj_guarantee_method_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_guarantee_equip_str\" name=\"json_proj_guarantee_equip_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_guarantee_equip_str ? \"[]\" : json_proj_guarantee_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_word_list_str\" name=\"json_word_list_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_word_list_str ? \"[]\" : json_word_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/proj_base_info_forcredit.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目其它基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_other_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目信审其它基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_credit_other_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("       <td colspan=4>\r\n");
      out.write("       <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t    jQuery(function() {\r\n");
      out.write("\t\t\t\t\t\t    isViewHistoryTask = false;\r\n");
      out.write("\t\t\t\t\t\t    });\r\n");
      out.write("\t\t            </script>\r\n");
      out.write("                    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("       <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t    jQuery(function() {\r\n");
      out.write("\t\t\t\t\t\t    //isViewHistoryTask = true;\r\n");
      out.write("\t\t\t\t\t\t    });\r\n");
      out.write("\t\t            </script>\r\n");
      out.write("       </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目评审结果 -->\r\n");
      out.write("\t\t\t<script language=\"javascript\">jQuery(function() {isViewHistoryTask = false;});</script> \r\n");
      out.write("\t\t\t ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_credit_result_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t<script language=\"javascript\">jQuery(function() {isViewHistoryTask = true;});</script>\r\n");
      out.write("        </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-project-business-condition\"></div>\r\n");
      out.write("\t\t\t项目商务条件\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-project-business-condition\">\r\n");
      out.write("\t\t<td colspan=4 class=\"td-tabs-container\" style=\"text-indent: 0px;\">\r\n");
      out.write("\t\t<!-- 标签栏 -->\r\n");
      out.write("\t\t<div id='id_project_info_tabs_content' style=\"\">\r\n");
      out.write("\t\t<div title=\"租赁物明细\">\r\n");
      out.write("\t\t<div id=\"id_table_leasing_proj_equip_container\"\r\n");
      out.write("\t\t\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"拟商务条件\">\r\n");
      out.write("\t\t<div id=\"id_table_leasing_proj_condition_container\"\r\n");
      out.write("\t\t\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../rent_reckon/rent_reckon/main.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"担保单位信息\">\r\n");
      out.write("\t\t<div id=\"id_table_leasing_proj_guarantee_method_container\"\r\n");
      out.write("\t\t\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"租金发票类型\">\r\n");
      out.write("\t\t<div id=\"id_table_leasing_proj_rent_type_container\"\r\n");
      out.write("\t\t\tstyle=\"height: 350px;\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/proj_invoice.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div title=\"客户信用评分表\">\r\n");
      out.write("\t\t\t<div id=\"id_table_leasing_proj_cust_creidt_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_cust_credit_list.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<!--避免在tabs中的js重复执行-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/proj_equip_detail.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/proj_guarantee_method.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_cust_credit.jsp", out, false);
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function createTemFileCredit6()\r\n");
      out.write("{\r\n");
      out.write("\tvar currentTablelist = getTracywindyObject('table_projcreditreport');\r\n");
      out.write("\tvar tabledata11=currentTablelist.getRowsData();\r\n");
      out.write("\tfor(var i=0;i<tabledata11.length;i++){\r\n");
      out.write("\t\t\tif(tabledata11[i].filename=='法人客户信审报告（6-10台).xls')\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t  alert(tabledata11[i].filename+\"已经生成\");\r\n");
      out.write("\t\t\t\t  return false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("    //alert(jQuery(\"#cust_name\").val());\r\n");
      out.write("    //平均租金\r\n");
      out.write("    var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_plan_container');\r\n");
      out.write("\t\tvar tabledata2=currentTable2.getRowsData();\r\n");
      out.write("\t\tvar sumMoney=null;\r\n");
      out.write("\t\tfor(var j=0;j<tabledata2.length;j++)\r\n");
      out.write("\t\t{\r\n");
      out.write("       sumMoney=sumMoney+parseFloat(tabledata2[j].rent);\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tsumMoney=sumMoney/parseInt(tabledata2.length);\r\n");
      out.write("\t \t//alert(sumMoney);\r\n");
      out.write("\t \t//alert(\"按\"+jQuery(\"#firstPaymentRatio\").val()+\"%首付\"+jQuery(\"#cautionMoney\").val()+\"%保证金，\"+jQuery(\"#yearRate\").val()+\"%年利率，\"+jQuery(\"#leaseTerm\").val()+\"个月租赁期，融资额为\"+jQuery(\"#leaseMoney\").val()+\"元，每月还款租金  \"+sumMoney);\r\n");
      out.write("\t \t        \r\n");
      out.write("\t \tvar data=\"按\"+jQuery(\"#firstPaymentRatio\").val()+\"%首付，\"+jQuery(\"#cautionMoneyRatio\").val()+\"%保证金，\"+jQuery(\"#yearRate\").val()+\"%年利率，\"+jQuery(\"#leaseTerm\").val()+\"个月租赁期，融资额为\"+jQuery(\"#leaseMoney\").val()+\"元，每月还款租金  \"+sumMoney+\"元\";\r\n");
      out.write("    //担保人\r\n");
      out.write("\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');\r\n");
      out.write("\t\tvar tabledata=currentTable1.getRowsData();\r\n");
      out.write("\t\tvar assurorname=\"('\";\r\n");
      out.write("\t\tfor(var i=0;i<tabledata.length;i++){\r\n");
      out.write("\t\tassurorname+=tabledata[i].assurorname;\r\n");
      out.write("\t\t  if(i<tabledata.length-1)\r\n");
      out.write("\t\t  {\r\n");
      out.write("\t\t\tassurorname+=\"','\";\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tassurorname+=\"')\";\r\n");
      out.write("\t\t//alert(assurorname);\r\n");
      out.write("\t\tvar test=getTracywindyObject(\"id_combo_creatordept\").getRawValue();\r\n");
      out.write("\t\tvar filename='table_projcreditreport';\r\n");
      out.write("\tvar url=\"/leasing/template/createFileByTemplateClass.action\";\r\n");
      out.write("    attachmentDown({uploadid:filename,url:url,title:\"\",flowunid:flowUnid,twoClassify:'wordtempletypetwo.33',returnType:'listtocurpaget',modelname:'creditreport',assurorname:assurorname,lesseesname:jQuery(\"#cust_name\").val(),projectid:jQuery(\"#project_id\").val(),\"framework_condition.money\":sumMoney,\"condition.array\":data,dealername:test});\r\n");
      out.write("}\r\n");
      out.write("function createTemFileCredit()\r\n");
      out.write("{\r\n");
      out.write("\tvar currentTablelist = getTracywindyObject('table_projcreditreport');\r\n");
      out.write("\tvar tabledata11=currentTablelist.getRowsData();\r\n");
      out.write("\tfor(var i=0;i<tabledata11.length;i++){\r\n");
      out.write("\t\t\tif(tabledata11[i].filename=='法人客户信审报告（10台以上）.xls')\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t  alert(tabledata11[i].filename+\"已经生成\");\r\n");
      out.write("\t\t\t\t  return false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("    //平均租金\r\n");
      out.write("    var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_plan_container');\r\n");
      out.write("\t\tvar tabledata2=currentTable2.getRowsData();\r\n");
      out.write("\t\tvar sumMoney=null;\r\n");
      out.write("\t\tfor(var j=0;j<tabledata2.length;j++)\r\n");
      out.write("\t\t{\r\n");
      out.write("       sumMoney=sumMoney+parseFloat(tabledata2[j].rent);\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tsumMoney=sumMoney/parseInt(tabledata2.length);\r\n");
      out.write("\t \t//alert(sumMoney);\r\n");
      out.write("\t \t\r\n");
      out.write("    //担保人\r\n");
      out.write("\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');\r\n");
      out.write("\t\tvar tabledata=currentTable1.getRowsData();\r\n");
      out.write("\t\tvar assurorname=\"('\";\r\n");
      out.write("\t\tfor(var i=0;i<tabledata.length;i++){\r\n");
      out.write("\t\tassurorname+=tabledata[i].assurorname;\r\n");
      out.write("\t\t if(i<tabledata.length-1)\r\n");
      out.write("\t  {\r\n");
      out.write("\t\tassurorname+=\"','\";\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\tassurorname+=\"')\";\r\n");
      out.write("\t\tvar test=getTracywindyObject(\"id_combo_creatordept\").getRawValue();\r\n");
      out.write("\t\t//alert(test+\"2222\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//alert(\"按\"+jQuery(\"#firstPaymentRatio\").val()+\"%首付\"+jQuery(\"#cautionMoney\").val()+\"%保证金，\"+jQuery(\"#yearRate\").val()+\"%年利率，\"+jQuery(\"#leaseTerm\").val()+\"个月租赁期，融资额为\"+jQuery(\"#leaseMoney\").val()+\"元，每月还款租金  \"+sumMoney);\r\n");
      out.write("\t \tvar data=\"按\"+jQuery(\"#firstPaymentRatio\").val()+\"%首付，\"+jQuery(\"#cautionMoneyRatio\").val()+\"%保证金，\"+jQuery(\"#yearRate\").val()+\"%年利率，\"+jQuery(\"#leaseTerm\").val()+\"个月租赁期，融资额为\"+jQuery(\"#leaseMoney\").val()+\"元，每月还款租金  \"+sumMoney+\"元\";\r\n");
      out.write("\tvar url=\"/leasing/template/createFileByTemplateClass.action\";\r\n");
      out.write("\tvar filename='table_projcreditreport';\r\n");
      out.write("    attachmentDown({uploadid:filename,url:url,title:\"\",flowunid:flowUnid,twoClassify:'wordtempletypetwo.34',returnType:'listtocurpaget',modelname:'creditreport',assurorname:assurorname,lesseesname:jQuery(\"#cust_name\").val(),projectid:jQuery(\"#project_id\").val(),\"framework_condition.money\":sumMoney,\"condition.array\":data,dealername:test});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//页面初始化\r\n");
      out.write("var isSubTable=true;\r\n");
      out.write("//法人附件上传权限\r\n");
      out.write("var isAttachment=false;\r\n");
      out.write("//隐藏域在提交或保存前的赋值\r\n");
      out.write("function fillHiddenVal() {\r\n");
      out.write("\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"=='法人')\r\n");
      out.write("\t{\r\n");
      out.write("\t    var currentTable3 = getTracywindyObject('table_projcreditreport');\r\n");
      out.write("\t    jQuery('#id_json_word_list_str').val(\r\n");
      out.write("\t\t\tJsonUtil.encode(currentTable3.getRowsJsonData()));\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("var tooldata=[{\r\n");
      out.write(" \t html : '<font color=\"blue\">生成法人客户信审报告(6-10台) </font>',\r\n");
      out.write("\t\thandler : function(table) {\r\n");
      out.write("\t     createTemFileCredit6();\r\n");
      out.write("\t\t\t\t//return false;\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ticonCls : 'icon-update'\r\n");
      out.write("},\r\n");
      out.write("{\r\n");
      out.write("\t html : '<font color=\"blue\">生成法人客户信审报告 (10台以上)</font>',\r\n");
      out.write("\t\thandler : function(table) {\r\n");
      out.write("\t\t    createTemFileCredit();\r\n");
      out.write("\t\t\t\t//return false;\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ticonCls : 'icon-update'\r\n");
      out.write("}\r\n");
      out.write("];\r\n");
      out.write("\r\n");
      out.write("/* var tooldata=[{\r\n");
      out.write("  \t html : '<font color=\"blue\">生成法人客户现场考察报告 </font>',\r\n");
      out.write("\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tcreateTemFile();\r\n");
      out.write("\t\t\t\t//return false;\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ticonCls : 'icon-update'\r\n");
      out.write("}]; */\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit02.jsp(80,20) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']=='法人'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                      ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_credit_reportxls.jsp", out, false);
        out.write("\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit02.jsp(137,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']=='法人'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
