package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fapproval01_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody != null) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!-- 插入样式和JS -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../project/proj_approval/base.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 特殊附件显示公用方法 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/proj_view_file.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目立项附件带到租前业务相关流程 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "initFileListParams.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t//var isViewHistoryTask = true;//全局变量说是这一个只读页面\r\n");
      out.write("\tvar checkContractId=false;\r\n");
      out.write("\tvar jsonStrCheck=true;//校验多行必须填写\r\n");
      out.write("\tvar jsonStrCheckMSG=\"\";\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//保存成功提交后，后台返回\r\n");
      out.write("\tfunction saveCallBack(rs) {\r\n");
      out.write("\t\tif(rs!=\"\"){\r\n");
      out.write("\t\t\talert(rs);//保存时初步校验合同号是否重复\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//只读反转\r\n");
      out.write("\tfunction formPageReadOnlyCallBack(){\r\n");
      out.write("\t       if(!isCompletedTask){\r\n");
      out.write("\t    \t   jQuery(\"#incomeNumber\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\t  jQuery('#incomeNumber').addClass('td-content-readonly');\r\n");
      out.write("\t       }\r\n");
      out.write("\t   }\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\tif(!saveInvoiceType()){return false;};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(workflowSaveCallBack()&&validataTotalMoney()){\r\n");
      out.write("\t\t\tif(!validateChassisnum()){return false;};//检查车架号是否重复\r\n");
      out.write("\t\t\t//if(!checkContractFlowNext()){return false;}\r\n");
      out.write("\t\t\t//检查租赁物明细\r\n");
      out.write("\t\t\tif(!checkTracywindyTableData(\"table_id_table_leasing_proj_equip_container\",\"租赁物明细\")){return false;}\r\n");
      out.write("\t\t\t//检查合同制作\r\n");
      out.write("\t\t\tif(!checkTracywindyTableData(\"table_id_table_leasing_contract_list_container\",\"合同制作\")){return false;}\r\n");
      out.write("\t\t\t//担保信息\r\n");
      out.write("\t\t\t//德银不需要验证担保人必填 2013-11-8修改\r\n");
      out.write("\t\t\t//if(!checkTracywindyTableData(\"table_id_table_leasing_contract_guarantee_method_container\",\"担保单位信息\")){return false;}\r\n");
      out.write("\t\t\t//租金计划\r\n");
      out.write("\t\t\tif(!checkTracywindyTableData(\"table_id_table_leasing_rent_plan_container\",\"租金计划\")){return false;}\r\n");
      out.write("\t\t\t//前提条件\r\n");
      out.write("\t\t\t//if(!checkTracywindyTableData(\"table_id_table_leasing_contract_premise_container\",\"前提条件\")){return false;}\r\n");
      out.write("\t\t\t//卖方/供应商\r\n");
      out.write("\t\t\t//if(!checkTracywindyTableData(\"table_id_table_leasing_contract_supplier_container\",\"卖方/供应商\")){return false;}\r\n");
      out.write("\t\t\t//担保单位信息必填\r\n");
      out.write("\t\t\t//if(!checkTracywindyTableData(\"table_id_table_leasing_contract_guarantee_method_container\",\"担保单位信息\")){return false;}\r\n");
      out.write("\t\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\t\tif(!Validator.Validate(submitProcessedForm,1,false)){return false;}\r\n");
      out.write("\t\t\tvar contractnumber= $('[name=\"contract_info.contractnumber\"]').val();\r\n");
      out.write("\t\t\tif(contractnumber==\"\"){\r\n");
      out.write("\t\t\t\talert(\"合同号为空,请确认信审通过后重新发起合同审批!\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!validataTotalMoney()){return false;};\r\n");
      out.write("\t\t\tif(!checkContractStatus()){return false;};\r\n");
      out.write("\t\t\tif(!checkContractStart()){return false;};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/* var isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\t\tisPassed = validataTotalMoney();\r\n");
      out.write("\t\t\tisPassed = checkContractStatus(); */\r\n");
      out.write("\t\t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"==\"自然人\"){\r\n");
      out.write("\t\t\t       var clientaccnumber =  $(\"#clientaccnumber\").val();\r\n");
      out.write("\t\t\t      if (clientaccnumber == \"\"  ){\r\n");
      out.write("\t\t\t    \t     alert(\"当前为自然人请维护合同各方中【开户账号】!\");\r\n");
      out.write("\t\t\t    \t     return false;\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t  }else\r\n");
      out.write("\t\t  {\r\n");
      out.write("\t\t\t     $(\"#iscardname\").val(\"\");\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t\t//首付，保证金，手续费，等向上改\r\n");
      out.write("\t\t\tif(parseFloat($(\"#firstPaymentRatio\").val())<parseFloat(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.firstpaymentratio']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"))\r\n");
      out.write("\t\t\t {\r\n");
      out.write("\t\t\t\t alert(\"首付比例不能小于当前首付比例！\");\r\n");
      out.write("\t\t\t\t return false;\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\tif(parseFloat($(\"#cautionMoneyRatio\").val())<parseFloat(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.cautionmoneyratio']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"))\r\n");
      out.write("\t\t\t {\r\n");
      out.write("\t\t\t\t alert(\"保证金比例不能小于当前保证金比例！\");\r\n");
      out.write("\t\t\t\t return false;\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\tif(parseFloat($(\"#handlingChargeMoneyRatio\").val())<parseFloat(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.handlingchargemoneyratio']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"))\r\n");
      out.write("\t\t\t {\r\n");
      out.write("\t\t\t\t alert(\"手续费比例不能小于当前手续费比例！\");\r\n");
      out.write("\t\t\t\t return false;\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//流程提交是设置条件路由\r\n");
      out.write("\tfunction workflowNextRouteCallBack(buttonText,requestNextRoute){\r\n");
      out.write("\t\t//车架号更改之后提交给信审审核。\r\n");
      out.write("\t\t var havChassisnum = true; \r\n");
      out.write("\t\t /*\r\n");
      out.write("\t\tvar  old_eqiup = JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str_for_credit ? \"[]\" : json_proj_equip_str_for_credit }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("\t\t var  new_eqiup = JsonUtil.decode($('#id_json_proj_equip_str').val());\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t var old_eqiup_array = [], new_eqiup_array = [];\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t for ( var i = 0; i < old_eqiup.length; i++) {\r\n");
      out.write("\t\t\t var  equipcontractnum = old_eqiup[i]['equipcontractnum'];\r\n");
      out.write("\t\t\t var chassisnum = old_eqiup[i]['chassisnum'];\r\n");
      out.write("\t\t\t old_eqiup_array.push(equipcontractnum);\r\n");
      out.write("\t\t\t old_eqiup_array.push(chassisnum);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t for ( var j = 0; j < new_eqiup.length; j++) {\r\n");
      out.write("\t\t\t var  equipcontractnum = new_eqiup[j]['equipcontractnum'];\r\n");
      out.write("\t\t\t var chassisnum = new_eqiup[j]['chassisnum'];\r\n");
      out.write("\t\t\t new_eqiup_array.push(equipcontractnum);\r\n");
      out.write("\t\t\t new_eqiup_array.push(chassisnum);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar oldStr = old_eqiup_array.sort().join(\"\");\r\n");
      out.write("\t\tvar newStr =  new_eqiup_array.sort().join(\"\");\r\n");
      out.write("\t\t \r\n");
      out.write("\t\tif(oldStr != newStr){\r\n");
      out.write("\t\t\thavChassisnum =false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t */\r\n");
      out.write("        if(buttonText==\"Submit\"){\r\n");
      out.write("        \tvar law=\"02-2法人信用分析师审核\";\r\n");
      out.write("    \t\tvar ewlp=\"02-1个人信用分析师审核\";\r\n");
      out.write("    \t\tvar projects = \"02业务企划初审\";\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t//if(havChassisnum&&!contract_approval){\r\n");
      out.write("    \t\t\t//requestNextRoute.value=projects;\r\n");
      out.write("    \t\t//} else {\r\n");
      out.write("\t    \t\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"==\"法人\"){\r\n");
      out.write("\t       \t\t\trequestNextRoute.value=law;\r\n");
      out.write("\t    \t\t}else{\r\n");
      out.write("\t    \t\t\trequestNextRoute.value=ewlp;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("    \t\t//}\r\n");
      out.write("        }\r\n");
      out.write("   }\r\n");
      out.write("\t\r\n");
      out.write("\tvar isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据\r\n");
      out.write("</script>\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_equip_str\" name=\"json_proj_equip_str\"  value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str ? \"[]\" : json_proj_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_guarantee_method_str\" name=\"json_contract_guarantee_method_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_guarantee_method_str ? \"[]\" : json_contract_guarantee_method_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_guarantee_equip_str\" name=\"json_contract_guarantee_equip_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_guarantee_equip_str ? \"[]\" : json_contract_guarantee_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_supplier_str\" name=\"json_contract_supplier_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_supplier_str ? \"[]\" : json_contract_supplier_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_premise_str\" name=\"json_contract_premise_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_premise_str ? \"[]\" : json_contract_premise_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_list_str\" name=\"json_contract_list_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_list_str ? \"[]\" : json_contract_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("   <!-- 隐藏域，判断修改限定值 -->\r\n");
      out.write("\t<input name=\"equipamt_wu\" id=\"equipamt_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.equipamt'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"firstpaymentratio_wu\" id=\"firstpaymentratio_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.firstpaymentratio'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"gpsmoney_wu\" id=\"gpsmoney_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.gpsmoney'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"cautionmoneyratio_wu\" id=\"cautionmoneyratio_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.cautionmoneyratio'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"handlingchargemoneyratio_wu\" id=\"handlingchargemoneyratio_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.handlingchargemoneyratio'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"leaseterm_wu\" id=\"leaseterm_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['framework_condition.incomenumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td ><!-- 插入项目基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_base_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目其它基本信息 --> ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_base_other_info.jsp", out, false);
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("   <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr class=\"tr-contract-business-condition\">\r\n");
      out.write("\t\t<td  class=\"td-tabs-container\" style=\"text-indent: 0px;\">\r\n");
      out.write("\t\t<div id='id_contract_info_tabs_content' style=\"\">\r\n");
      out.write("\t\t\t<div title=\"租赁物明细\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">租赁物明细</span>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"商务报价\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">商务报价</span>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"担保单位信息\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">担保单位信息</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_guarantee_method_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"合同各方\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">合同各方</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_signatory_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_signatory.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"前提条件\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">前提条件</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_premise_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"合同制作\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">合同制作</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_make_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_new_word.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"签约信息\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">签约信息</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_sign_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t<table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 98%; margin-top: 20px;\" >\r\n");
      out.write("\t\t\t\t\t\t <tr  class=\"tr-contractect-other-info tr-even\">\r\n");
      out.write("\t\t\t\t\t\t    <td class=\"td-content-title\">签约时间：</td><td class=\"td-content\"><input class=\"Wdate td-content-input\" readonly name=\"contract_other_info.signdate\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_other_info.signdate']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" onClick=\"WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})\"></td>\r\n");
      out.write("\t\t\t\t\t\t    <td class=\"td-content-title\">签约地点：</td><td class=\"td-content\"><input name=\"contract_other_info.signplace\" class=\"td-content-input\" type=\"text\" value=\"西安市幸福北路39号\" ></input></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr  class=\"tr-contractect-other-info tr-odd\">\r\n");
      out.write("\t\t\t\t\t\t    <td class=\"td-content-title\">签约人：</td><td class=\"td-content\" colspan=\"3\"><div class=\"leftComboContainer\" style=\"width: 99%;\"><textarea rows=\"3\"  style=\"width: 95%;float:left;\" name=\"contract_other_info.signperson\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_other_info.signperson']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></div></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"租金发票类型\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">租金发票类型</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_rent_type_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_invoice_type.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"税号\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">税号</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_invoice_info_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_invoice_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_guarantee_method.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_premise_info.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/flow_condition_select.jsp", out, false);
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("//模板上传\r\n");
      out.write("function createTemFile(){\r\n");
      out.write("       /* \r\n");
      out.write("        var currentTable1 = getTracywindyObject('id_table_leasing_contract_signatory_container');\r\n");
      out.write("\t\t//jQuery('#id_json_proj_equip_str').val(\r\n");
      out.write("\t\t\t\talert(JsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t\t\tvar ee=JsonUtil.encode(currentTable1.getRowsJsonData());\r\n");
      out.write("\t\t\t\talert(ee[1]);*/\r\n");
      out.write("        \r\n");
      out.write("    var url=\"/leasing/template/createFileByTemplateClass.action\";\r\n");
      out.write("    attachmentDown({url:url,title:\"\",flowunid:flowUnid,twoClassify:'wordtempletypetwo.22',returnType:'list',modelname:'overduenotice'});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t//隐藏域在提交或保存前的赋值\r\n");
      out.write("\tfunction fillHiddenVal() {\r\n");
      out.write("\t\tvar contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件\r\n");
      out.write("\t\tjQuery('#id_json_proj_equip_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));\r\n");
      out.write("\t\tvar contractGuaranteeMethod = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container');//担保\r\n");
      out.write("\t\tjQuery('#id_json_contract_guarantee_method_str').val(JsonUtil.encode(contractGuaranteeMethod.getRowsJsonData()));\r\n");
      out.write("\t\tif(contractGuaranteeMethod.getRowsJsonData()==''||contractGuaranteeMethod.getRowsJsonData()=='[]'){\r\n");
      out.write("\t\t\tjsonStrCheck=false;\r\n");
      out.write("\t\t\tjsonStrCheckMSG+=\"担保单位信息,\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar contractPremise = getTracywindyObject('table_id_table_leasing_contract_premise_container');//前提条件\r\n");
      out.write("\t\tjQuery('#id_json_contract_premise_str').val(JsonUtil.encode(contractPremise.getRowsJsonData()));\r\n");
      out.write("\t\tvar contractSupplier = getTracywindyObject('table_id_table_leasing_contract_supplier_container');//合同各方中的供应商\r\n");
      out.write("\t\tjQuery('#id_json_contract_supplier_str').val(JsonUtil.encode(contractSupplier.getRowsJsonData()));\r\n");
      out.write("\t\tif(!saveReckonJsonValue()){\r\n");
      out.write("\t\t\tjsonStrCheck=false;\r\n");
      out.write("\t\t\tjsonStrCheckMSG+=\"租金测算信息\";//保存租金测算结果\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//合同清单\r\n");
      out.write("\t\tvar currentTable = getTracywindyObject('table_id_table_leasing_contract_list_container');\r\n");
      out.write("\t\tjQuery('#id_json_contract_list_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable.getRowsJsonData()));\r\n");
      out.write("\t}\r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//合同制作前保存数据\r\n");
      out.write("\t\t$(\"#id_contract_info_tabs_content\").tabs({onSelect:function(title){\r\n");
      out.write("\t\t\t\tif(title=='合同制作')\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tbtn_callBack(saveButtonDisplayText,true);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t//第一个页签集合\r\n");
      out.write("\t\t$(\"#id_contract_info_tabs_content\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t//$(\"#id_contract_info_tabs_content\").tabs();\r\n");
      out.write("\t\tisSubTable = false;//标志主页面加载完成\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t/**\r\n");
      out.write("\t* 是否为信审完毕检查，注:同步ajax。Edit by jason 2012-9-3\r\n");
      out.write("\t*/\r\n");
      out.write("\tfunction checkContractStatus(){\r\n");
      out.write("\t\tvar returnStatus = false;\r\n");
      out.write("    \tparam = {};\r\n");
      out.write("    \tparam.projID = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proj_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\tparam.status  =\"Equal:11\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"leasing/checkWorkFlow.action\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\tdata : param,\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif(data.failreason == 'status'){\r\n");
      out.write("\t\t\t\t\talert(\"当前项目未完成信审流程，不能发起合同，请查证后再提交.\");\r\n");
      out.write("\t\t\t\t} else{\r\n");
      out.write("\t\t\t\t\treturnStatus = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn returnStatus;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkContractStart(){\r\n");
      out.write("\t\tvar returnStatus = false;\r\n");
      out.write("\t\tparam = {};\r\n");
      out.write("    \tparam.projID = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proj_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("    \tparam.currentAmt = $('#equipAmt').val();\r\n");
      out.write("    \t//2013-11-25，增加当前过程表数据\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"leasing/checkContractStart.action\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\tdata : param,\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif (data['result'] == 'error') {\r\n");
      out.write("\t\t\t\t\talert(\"您所选择的项目设备金额为【\"+data['projEquipAmt']+\"】,已经发起【\"+ data['number']+\"】条合同,总共金额为【\" + data['contractEquipAmt'] + \"】。\\n此条项目不能发起流程,请检查。\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\treturnStatus = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn returnStatus;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkContractFlowNext(){\r\n");
      out.write("\t\t//检查租赁物件中的车辆合同小号，车架号，购置税，保费，其他融资额必填\r\n");
      out.write("\t\t//发票信息必填\r\n");
      out.write("\t\tvar returnStatus = false;\r\n");
      out.write("\t\tparam = {};\r\n");
      out.write("    \tparam.projID = $(\"#projid\").val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : getRootPath()+\"/leasing/contractStartFlowCheck.acl\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\tdata : param,\r\n");
      out.write("\t\t\tsuccess : function(rs) {\r\n");
      out.write("\t\t\t   var svote=rs;\r\n");
      out.write("\t\t\t   svote=svote.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t\tif (svote!=\"\") {\r\n");
      out.write("\t\t\t\t\talert(\"请走项目资料补充增加\"+svote+\"\");\r\n");
      out.write("\t\t\t\t\treturnStatus=false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\treturnStatus = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn returnStatus;\r\n");
      out.write("\t}\r\n");
      out.write("\t/* \r\n");
      out.write("\t   function checkContractStatus(){\r\n");
      out.write("\t\t\tvar contractStatus = $(\"#contract_info.projstatus\").val();\r\n");
      out.write("\t\t\tif('11' == contractStatus){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"项目状态不正确,不可提交！\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\tformJSPInputHideOrShow(\"contract_condition_all\",\"\",0);\r\n");
      out.write("\t    jQuery(function(){\r\n");
      out.write("\t    \tgetTracywindyObject(\"id_combo_id_insurer_type\").readOnlyData = true;\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_insurer_type\").reload();\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_income_number_year\").readOnlyData = true;\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_income_number_year\").reload();\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_period_type\").readOnlyData = true;\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_period_type\").reload();\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_is_registration\").readOnlyData = true;\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_is_registration\").reload();\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_is_guaranty\").readOnlyData = true;\r\n");
      out.write("\t\t    getTracywindyObject(\"id_combo_id_is_guaranty\").reload();\r\n");
      out.write("\t\t    jQuery(\"#incomeNumber\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#incomeNumber').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#equipAmt\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#equipAmt').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#firstPaymentRatio\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#firstPaymentRatio').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#insureMoney\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#insureMoney').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#gpsMoney\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#gpsMoney').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#cautionMoneyRatio\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#cautionMoneyRatio').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#handlingChargeMoneyRatio\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#handlingChargeMoneyRatio').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#yearRate\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#yearRate').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#nominalPrice\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#nominalPrice').addClass('td-content-readonly');\r\n");
      out.write("\t\t    jQuery(\"#otherIncome\").attr('readOnly',true);  \r\n");
      out.write("\t   \t\tjQuery('#otherIncome').addClass('td-content-readonly');\r\n");
      out.write("\t\t    renkentoolsShow();\r\n");
      out.write("\t\t    chenckCondiotn=true;\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\tjQuery('#btn_rent_cal').hide();\r\n");
      out.write("\t\tfunction renkentoolsShow()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar fundPlan=getTracywindyObject('table_id_table_leasing_fund_fund_charge_container');\r\n");
      out.write("\t\t\tfundPlan.disabledToolsByText(\"修改\");\r\n");
      out.write("\t\t\tvar rentPlan=getTracywindyObject('table_id_table_leasing_rent_plan_container');\r\n");
      out.write("\t\t\trentPlan.disabledToolsByText(\"新增,修改,删除,租金测算,租金调整\");\r\n");
      out.write("\t    }\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval01.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("business_type");
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval01.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['business_type']}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
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
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval01.jsp(186,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'bussiness_type_car' eq business_type}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_equip_detail01.jsp", out, false);
        out.write("\r\n");
        out.write("\t\t\t\t<div id=\"id_table_leasing_proj_equip_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
        out.write("\t\t\t\t");
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
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval01.jsp(190,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'bussiness_type_equip' eq business_type}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../nocar/nocar_public/thing_detail.jsp", out, false);
        out.write("\r\n");
        out.write("\t\t\t\t<div id=\"id_table_leasing_proj_equip_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
        out.write("\t\t\t\t");
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

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval01.jsp(197,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'bussiness_type_car' eq business_type}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<div id=\"id_table_leasing_contract_condition_container\"\tstyle=\"overflow: hidden;\">\r\n");
        out.write("\t\t\t\t\t");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../rent_reckon/rent_reckon/main.jsp", out, true);
        out.write("\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval01.jsp(202,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'bussiness_type_equip' eq business_type}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<div id=\"id_table_leasing_contract_condition_container\"\tstyle=\"overflow: hidden;\">\r\n");
        out.write("\t\t\t\t\t");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../rent_reckon/rent_reckon/main_4_5.jsp", out, true);
        out.write("\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }
}
