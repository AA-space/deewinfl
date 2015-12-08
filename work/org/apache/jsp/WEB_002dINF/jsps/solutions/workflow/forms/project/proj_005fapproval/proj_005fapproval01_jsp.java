package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fapproval01_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 特殊附件显示公用方法 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/proj_view_file.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目立项附件带到租前业务相关流程 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "initFileListParams.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\tcreateProjectName();\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//保存成功提交后，后台返回\r\n");
      out.write("\tfunction saveCallBack() {\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\t//added by tracywindy 2013-11-22 解决永远提示没有测算的问题开始\r\n");
      out.write("\t\tvar beforeCheckedCondition = chenckCondiotn;\r\n");
      out.write("\t\t//added by tracywindy 2013-11-22 解决永远提示没有测算的问题结束\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcreateProjectName();\r\n");
      out.write("\t\t//必填\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\tvar isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\tif(!isPassed){return isPassed;}\r\n");
      out.write("\t\t//判断\r\n");
      out.write("\t    if(!checkTracywindyTableData(\"table_id_table_leasing_proj_equip_container\",\"租赁物明细\")){return false;}//检查租赁物明细\r\n");
      out.write("\t  //德银不需要验证担保人必填\r\n");
      out.write("\t\t//if(!checkTracywindyTableData(\"table_id_table_leasing_proj_guarantee_method_container\",\"担保单位信息\")){return false;}//担保信息\r\n");
      out.write("\t    if(!checkTracywindyTableData(\"table_id_table_leasing_rent_plan_container\",\"租金计划\")){return false;}//租金计划\r\n");
      out.write("\t    //added by tracywindy 2013-11-22 解决永远提示没有测算的问题开始\r\n");
      out.write("\t    chenckCondiotn = beforeCheckedCondition;\r\n");
      out.write("\t    //added by tracywindy 2013-11-22 解决永远提示没有测算的问题结束\r\n");
      out.write("\t\tif(!validataTotalMoney()){return false;}\r\n");
      out.write("\t    //检查附件\r\n");
      out.write("\t\tif(!checkInvoiceFile()){return false};\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//流程提交是设置条件路由\r\n");
      out.write("\tfunction workflowNextRouteCallBack(buttonText,requestNextRoute){\r\n");
      out.write("        if(buttonText==\"Submit\"){\r\n");
      out.write("        \tvar law=\"TO 02法人客户信用分析师检查资料\";\r\n");
      out.write("    \t\tvar ewlp=\"TO 03个人客户信用分析师检查资料\";\r\n");
      out.write("    \t\tvar oneLevel =\"TO 012一级经销商处理\";\r\n");
      out.write("    \t\tvar twolevelstatus=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.twolevelstatus'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \t\tif(twolevelstatus==\"0\"){\r\n");
      out.write("    \t\t\trequestNextRoute.value=oneLevel;//走   是二级经销商判断\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\telse\r\n");
      out.write("    \t\t{\r\n");
      out.write("\t    \t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"==\"法人\"){\r\n");
      out.write("\t       \t\t\trequestNextRoute.value=law;\r\n");
      out.write("\t    \t\t}else{\r\n");
      out.write("\t    \t\t\trequestNextRoute.value=ewlp;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("    \t\t}\r\n");
      out.write("        }\r\n");
      out.write("   } \r\n");
      out.write("//留购价款=100元*车头数，车头数即非挂车数量\r\n");
      out.write("function countLeaveTheToy(){\r\n");
      out.write("    var liugoujiasum = 0;\r\n");
      out.write("\tvar currentTable = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\tdatas = currentTable.getRowsJsonData();\r\n");
      out.write("\t for (var i = 0; i < datas.length; i++) {\r\n");
      out.write("\t\t\tif (datas[i].equipclass != \"equip_class_2\") {\r\n");
      out.write("\t\t\t\t\tliugoujiasum++;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t }\r\n");
      out.write("\t //修改了商务条件就需要重新测算租金\r\n");
      out.write("     if($(\"#nominalPrice\").val()!=100*liugoujiasum){\r\n");
      out.write("\t    $(\"#nominalPrice\").val(100*liugoujiasum);\r\n");
      out.write("\t    //chenckCondiotn=false;\r\n");
      out.write("\t    //ie以外的浏览器需要不支持js改变值的事件，需重新计算商务条件\r\n");
      out.write("\t\tequipAmt();\r\n");
      out.write("     }\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_equip_str\" name=\"json_proj_equip_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str ? \"[]\" : json_proj_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_guarantee_method_str\" \tname=\"json_proj_guarantee_method_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_guarantee_method_str ? \"[]\" : json_proj_guarantee_method_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_info_forcredit.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目其它基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_other_info.jsp", out, false);
      out.write("</td>\r\n");
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
      out.write("\t\t\t\t\t<div title=\"租赁物明细\">\r\n");
      out.write("\t\t\t\t\t    <span class=\"print-tabs-title-content\">租赁物明细</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_proj_equip_container\" style=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div title=\"拟商务条件\">\r\n");
      out.write("\t\t\t\t\t \t<span class=\"print-tabs-title-content\">拟商务条件</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_proj_condition_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../rent_reckon/rent_reckon/main.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div title=\"担保单位信息\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">保单位信息</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_proj_guarantee_method_container\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t\t\t </div>\r\n");
      out.write("\t\t\t\t\t <div title=\"税号\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">税号</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_contract_invoice_info_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_invoice_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<!--避免在tabs中的js重复执行-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_equip_detail.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_guarantee_method.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t//隐藏域在提交或保存前的赋值\r\n");
      out.write("\tfunction fillHiddenVal() {\r\n");
      out.write("\t\t//租赁物件\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_equip_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//担保单位信息\r\n");
      out.write("\t\tvar currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_guarantee_method_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable4.getRowsJsonData()));\r\n");
      out.write("\r\n");
      out.write("\t\t/*担保单位信息\r\n");
      out.write("\t\tvar currentTable5 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_attachment_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_guarantee_method_attachment_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable5.getRowsJsonData()));*/\r\n");
      out.write("\t\t//留购价计算\r\n");
      out.write("\t\tcountLeaveTheToy();\r\n");
      out.write("\t\t//商务条件数据\r\n");
      out.write("\t\tsaveReckonJsonValue();\r\n");
      out.write("\t}\r\n");
      out.write("\t//生成项目名称\r\n");
      out.write("\tfunction createProjectName() {\r\n");
      out.write("\t\tvar project_name =jQuery('#project_name').val();\r\n");
      out.write("\t\tvar dept_name = getTracywindyObject('id_combo_creatordept').getRawValue();\r\n");
      out.write("\t\tvar proj_id=$(\"#project_id\").val();\r\n");
      out.write("\t\tvar cust_name=$(\"#cust_name\").val();\r\n");
      out.write("\t\tif (project_name == '') {\r\n");
      out.write("\t\t\tproject_name = proj_id+\"-\"+dept_name+\"-\"+cust_name + '项目'+$(\"#id_business_type\").val();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("            var srefix=project_name.substring(project_name.length-2);\r\n");
      out.write("            var stype=$(\"#id_business_type\").val();\r\n");
      out.write("            if(srefix!=stype){\r\n");
      out.write("            \tproject_name=project_name+stype;\r\n");
      out.write("            }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tjQuery('#project_name').val(project_name);\r\n");
      out.write("\t\tjQuery('#project_name').removeAttr('readOnly');\r\n");
      out.write("\t}\r\n");
      out.write("\tvar isSubTable = true;\r\n");
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
      out.write("\tfunction checkInvoiceFile(){\r\n");
      out.write("\t\t\t//法人 开票文件校验\r\n");
      out.write("\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"==\"法人\"\r\n");
      out.write("\t\t\t\t&& ($(\"#selectOfValue_id_combo_id_kfp\").val() ==\"0\")\r\n");
      out.write("\t\t\t\t&&\"invoicetype1\"==getTracywindyObject('id_combo_invoicetype').getValue()){\r\n");
      out.write("\t\t\tvar isPassed = true;\r\n");
      out.write("\t\t\tvar arr = ['税务登记证','增值税一般纳税人认定表','开票信息申请表'];\r\n");
      out.write("\t        loadWorkflowAttachment();\r\n");
      out.write("\t\t\tvar attachmentTable    = getTracywindyObject(\"id_customworkflowattachment\");\r\n");
      out.write("\t\t    var attachmentRowsJsonArrayData = attachmentTable.getRowsData();\r\n");
      out.write("\t\t\tfor(var i=0;i< attachmentRowsJsonArrayData.length;i++){\r\n");
      out.write("\t\t\t\tvar attachmentRowData = attachmentRowsJsonArrayData[i];\r\n");
      out.write("\t\t\t\tvar dictname = attachmentRowData[\"attachmentFileDictFileName\"] ;\r\n");
      out.write("\t\t\t\tvar cname = attachmentRowData[\"attachmentFileUploadInfoDetailChineseFileNames\"] ;\r\n");
      out.write("\t\t\t\tvar uploadtype = attachmentRowData[\"uploadtype\"]; \r\n");
      out.write("\t\t\t\tif(arr.indexOf(dictname)>-1 && \"\"==cname && \"承租人资料\"== uploadtype){\r\n");
      out.write("\t\t\t\t\talert(\"请上传\"+dictname+\"资料!\");\r\n");
      out.write("\t\t\t\t\tisPassed = false;\r\n");
      out.write("\t\t\t\t\treturn isPassed;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn isPassed;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
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
