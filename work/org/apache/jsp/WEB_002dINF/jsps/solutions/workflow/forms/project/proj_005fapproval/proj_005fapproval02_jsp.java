package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fapproval02_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- 插入样式和JS -->    \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 特殊附件显示公用方法 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/proj_view_file.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目立项附件带到租前业务相关流程 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "initFileListParams.jsp", out, false);
      out.write("\r\n");
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
      out.write("//保存成功提交后，后台返回\r\n");
      out.write("function saveCallBack() {\r\n");
      out.write("\t var submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("//是否提交    \r\n");
      out.write("function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("{\r\n");
      out.write("\tfillHiddenVal();\r\n");
      out.write("\t//必填\r\n");
      out.write("\t//流程第二部不需要做验证。 edit by jason 2013-11-25\r\n");
      out.write("/* \tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\tvar isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\tif(!isPassed){return isPassed;}\r\n");
      out.write("\t//判断\r\n");
      out.write("    if(!checkTracywindyTableData(\"table_id_table_leasing_proj_equip_container\",\"租赁物明细\")){return false;}//检查租赁物明细\r\n");
      out.write("    //德银不需要验证担保人必填\r\n");
      out.write("\t//if(!checkTracywindyTableData(\"table_id_table_leasing_proj_guarantee_method_container\",\"担保单位信息\")){return false;}//担保信息\r\n");
      out.write("    if(!checkTracywindyTableData(\"table_id_table_leasing_rent_plan_container\",\"租金计划\")){return false;}//租金计划\r\n");
      out.write("\tif(!validataTotalMoney()){return false;} */\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_equip_str\" name=\"json_proj_equip_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str ? \"[]\" : json_proj_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_proj_guarantee_method_str\" \tname=\"json_proj_guarantee_method_str\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_guarantee_method_str ? \"[]\" : json_proj_guarantee_method_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("  <table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          \r\n");
      out.write("          <tr><td colspan=4 >\r\n");
      out.write("          <!-- 插入项目基本信息 -->\r\n");
      out.write("              ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_info_forcredit2.jsp", out, false);
      out.write("\r\n");
      out.write("          </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("\t\t    <td colspan=4><!-- 插入项目其它基本信息 --> \r\n");
      out.write("\t\t    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_base_other_info.jsp", out, false);
      out.write(" \r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t     </tr>\r\n");
      out.write("          <tr class=\"x-panel-table-div-title\">\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-project-business-condition\"></div>项目商务条件 </td>\r\n");
      out.write("          </tr> \r\n");
      out.write("          <tr><td colspan=4></td></tr>\r\n");
      out.write("          <tr class=\"tr-project-business-condition\">\r\n");
      out.write("          <td colspan=4 class=\"td-tabs-container\" style=\"text-indent:0px;\">\r\n");
      out.write("          \t<!-- 标签栏 -->\r\n");
      out.write("          \t<div id='id_project_info_tabs_content' style=\"\">\r\n");
      out.write("\t\t\t\t    \t<div title=\"租赁物明细\"><span class=\"print-tabs-title-content\">租赁物明细</span><div id=\"id_table_leasing_proj_equip_container\" style=\"overflow: hidden;\"></div></div>\r\n");
      out.write("\t\t\t\t    \t<div title=\"拟商务条件\"><span class=\"print-tabs-title-content\">拟商务条件</span><div id=\"id_table_leasing_proj_condition_container\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t    \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../rent_reckon/rent_reckon/main.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t    \t</div></div>\r\n");
      out.write("\t\t\t\t    \t<div title=\"担保单位信息\"><span class=\"print-tabs-title-content\">担保单位信息</span><div id=\"id_table_leasing_proj_guarantee_method_container\" style=\"overflow: hidden;\"></div></div>\r\n");
      out.write("\t\t\t\t    \t<div title=\"租金发票类型\"><span class=\"print-tabs-title-content\">租金发票类型</span><div id=\"id_table_leasing_proj_rent_type_container\"  style=\"height:350px;\">\r\n");
      out.write("\t\t\t\t    \t<script language=\"javascript\">\r\n");
      out.write("\t\t                    jQuery(function() {isViewHistoryTask = isCompletedTask;});\r\n");
      out.write("\t\t                </script> \r\n");
      out.write("\t\t\t\t    \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_invoice.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t    \t<script language=\"javascript\">\r\n");
      out.write("\t\t\t\t\t\tjQuery(function() {isViewHistoryTask = true;});\r\n");
      out.write("\t\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t    \t</div></div>\r\n");
      out.write("\t\t\t\t    \t<div title=\"税号\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"print-tabs-title-content\">税号</span>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"id_table_leasing_contract_invoice_info_container\"\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_invoice_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          </td>\r\n");
      out.write("          </tr> \r\n");
      out.write("    </table>\t\r\n");
      out.write(" </div>\r\n");
      out.write("<!--避免在tabs中的js重复执行-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_equip_detail.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_guarantee_method.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("//隐藏域在提交或保存前的赋值\r\n");
      out.write("\tfunction fillHiddenVal(){\r\n");
      out.write("\t\t//租赁物件\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_equip_str').val(JsonUtil.encode(currentTable1.getRowsJsonData())) ;\r\n");
      out.write("\t\t//担保单位信息\r\n");
      out.write("\t\tvar currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_guarantee_method_str').val(JsonUtil.encode(currentTable4.getRowsJsonData())) ;\r\n");
      out.write("\t\t//商务条件数据\r\n");
      out.write("\t\tsaveReckonJsonValue();\r\n");
      out.write("\t\t}\r\n");
      out.write("\tisSubTable=true;\r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\r\n");
      out.write("\t    //########公共JS事件##########\r\n");
      out.write("\t    jQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation); \r\n");
      out.write("\t    $(\"#id_project_info_tabs_content\").css(\"width\",(formWidth)+\"px\");\r\n");
      out.write("\t    $(\"#id_project_info_tabs_content\").tabs();\r\n");
      out.write("\t    isSubTable=false;\r\n");
      out.write("\t    var d=$(\"#id_project_info_tabs_content\");\r\n");
      out.write("\t    $(\"#id_project_fund_rent_plan_tabs_content\").css(\"width\",(formWidth)+\"px\");\r\n");
      out.write("\t    $(\"#id_project_fund_rent_plan_tabs_content\").tabs();\r\n");
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
