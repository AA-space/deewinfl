package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fapproval02_002d1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//只读回调\r\n");
      out.write("\tfunction formPageReadOnlyCallBack(){\r\n");
      out.write("\t   if(!isCompletedTask){\r\n");
      out.write("\t\t     jQuery('#btn_rent_cal').show();\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.equipamt']\").attr({\r\n");
      out.write("                    readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.firstpaymentratio']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.gpsmoney']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.insuremoney']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.cautionmoneyratio']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.handlingchargemoneyratio']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.incomenumber']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.nominalprice']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     jQuery(\"input[name='framework_condition.otherincome']\").attr({\r\n");
      out.write("                 readOnly:false\r\n");
      out.write("\t\t\t     }).removeClass(\"element-readonly\");\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_insurer_type\").readOnlyData = false;\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_insurer_type\").reload();\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_period_type\").readOnlyData = false;\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_period_type\").reload();\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_is_registration\").readOnlyData = false;\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_is_registration\").reload();\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_is_guaranty\").readOnlyData = false;\r\n");
      out.write("\t\t     getTracywindyObject(\"id_combo_id_is_guaranty\").reload();\r\n");
      out.write("\t   }\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否保存   \r\n");
      out.write("\tfunction workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//保存成功提交后，后台返回\r\n");
      out.write("\tfunction saveCallBack(rs) {\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t//是否提交    \r\n");
      out.write("\tfunction workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t{  \r\n");
      out.write("\t\tfillHiddenVal();\r\n");
      out.write("\t\t if(!checkEquipChange()){return  false;};\r\n");
      out.write("\t    if(!validataTotalMoney()){return false;};\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据\r\n");
      out.write("\tisViewHistoryTask = true;//全局变量说是这一个只读页面\r\n");
      out.write("   //验证设备款、起租比例等浮动范围\r\n");
      out.write("\tfunction checkEquipChange()\r\n");
      out.write("\t{\r\n");
      out.write("        var msg_change=\"\";\r\n");
      out.write("        var columnname=[\"equipamt_wu\",\"firstpaymentratio_wu\",\"cautionmoneyratio_wu\",\"handlingchargemoneyratio_wu\",\"leaseterm_wu\"];\r\n");
      out.write("        for(var i=0;i<columnname.length;i++)\r\n");
      out.write("        {\r\n");
      out.write("        \tswitch(columnname[i]){\r\n");
      out.write("    \t\tcase \"equipamt_wu\":\r\n");
      out.write("    \t\t\tif(parseFloat($(\"#equipamt_wu\").val())*0.1<Math.abs(parseFloat($(\"#equipamt_wu\").val())-parseFloat($(\"#equipAmt\").val())))\r\n");
      out.write("        \t    {\r\n");
      out.write("    \t\t\t\tmsg_change+=\"设备款只能原价10%上下调整！\\n\";\r\n");
      out.write("                }\r\n");
      out.write("        \t\tbreak;\r\n");
      out.write("    \t\tcase \"firstpaymentratio_wu\":\t\t\t\t\r\n");
      out.write("    \t\t\tif(parseFloat($(\"#firstpaymentratio_wu\").val())>parseFloat($(\"#firstPaymentRatio\").val()))\r\n");
      out.write("        \t\t{\r\n");
      out.write("    \t\t\t\tmsg_change+=\"起租比例只能上调！\\n\";\r\n");
      out.write("    \t        }\t\t\t\t\r\n");
      out.write("    \t\t\tbreak;\r\n");
      out.write("    \t\tcase \"cautionmoneyratio_wu\":\t\t\t\t\r\n");
      out.write("    \t\t\tif(parseFloat($(\"#cautionmoneyratio_wu\").val())>parseFloat($(\"#cautionMoneyRatio\").val()))\r\n");
      out.write("        \t\t{\r\n");
      out.write("    \t\t\t\tmsg_change+=\"保证金比例只能上调！\\n\";\r\n");
      out.write("    \t        }\t\r\n");
      out.write("    \t\t\tbreak;\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\tcase \"handlingchargemoneyratio_wu\":\r\n");
      out.write("    \t\t\tif(parseFloat($(\"#handlingchargemoneyratio_wu\").val())>parseFloat($(\"#handlingChargeMoneyRatio\").val()))\r\n");
      out.write("        \t\t{\r\n");
      out.write("    \t\t\t\tmsg_change+=\"手续费比例只能上调\\n\";\r\n");
      out.write("    \t        }\t\r\n");
      out.write("    \t\t\tbreak;\r\n");
      out.write("    \t\tcase \"leaseterm_wu\":\r\n");
      out.write("    \t\t\tif(parseFloat($(\"#leaseterm_wu\").val())<parseFloat($(\"#incomeNumber\").val()))\r\n");
      out.write("        \t\t{\r\n");
      out.write("    \t\t\t\tmsg_change+=\"租赁期限只能下调！\\n\";\r\n");
      out.write("    \t        }\r\n");
      out.write("        \t\tbreak;\r\n");
      out.write("    \t\tdefault:\r\n");
      out.write("    \t\t\tbreak;\r\n");
      out.write("    \t\t}\r\n");
      out.write("        }\r\n");
      out.write("        if(\"\"!=msg_change){\r\n");
      out.write("            alert(msg_change);\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        return true;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<!--多行控件  -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_equip_str_r\" name=\"json_proj_equip_str\"  value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str ? \"[]\" : json_proj_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'></input>\r\n");
      out.write("<input type=\"hidden\" id=\"id_json_contract_equip_str\" name=\"json_contract_equip_str\"  value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_equip_str ? \"[]\" : json_contract_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
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
      out.write("    \r\n");
      out.write("\t<!-- 隐藏域，判断修改限定值 -->\r\n");
      out.write("\t<input name=\"equipamt_wu\" id=\"equipamt_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['equipamt_wu'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"firstpaymentratio_wu\" id=\"firstpaymentratio_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['firstpaymentratio_wu'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"gpsmoney_wu\" id=\"gpsmoney_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['gpsmoney_wu'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"cautionmoneyratio_wu\" id=\"cautionmoneyratio_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cautionmoneyratio_wu'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"handlingchargemoneyratio_wu\" id=\"handlingchargemoneyratio_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['handlingchargemoneyratio_wu'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"leaseterm_wu\" id=\"leaseterm_wu\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['leaseterm_wu'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
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
      out.write("\t\t\t<script language=\"javascript\">\r\n");
      out.write("               jQuery(function() {isViewHistoryTask = false;\r\n");
      out.write("                   });\r\n");
      out.write("             </script> \r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">租赁物明细</span>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t<script language=\"javascript\">\r\n");
      out.write("\t\t\t    jQuery(function() {\r\n");
      out.write("\t\t\t\t    isViewHistoryTask = true;\r\n");
      out.write("\t\t\t\t    });\r\n");
      out.write("            </script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t<div title=\"商务报价\">\r\n");
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
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div title=\"担保单位信息\">\r\n");
      out.write("\t\t\t\t<span class=\"print-tabs-title-content\">担保单位信息</span>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_guarantee_method_container\"\tstyle=\"overflow: hidden;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_guarantee_method.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t//隐藏域在提交或保存前的赋值\r\n");
      out.write("\tfunction fillHiddenVal() \r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件\r\n");
      out.write("\t\tjQuery('#id_json_contract_equip_str_r').val(JsonUtil.encode(contractEquip.getRowsJsonData()));\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("\t//初始化调用\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\t//########公共JS事件##########\r\n");
      out.write("\t\tjQuery(\".toggle-icon-expanded\").click(toggleLeasingOperation);\r\n");
      out.write("\t\t//第一个页签集合\r\n");
      out.write("\t\t$(\"#id_contract_info_tabs_content\").css(\"width\", (formWidth) + \"px\");\r\n");
      out.write("\t\t$(\"#id_contract_info_tabs_content\").tabs();\r\n");
      out.write("\t\tisSubTable = false;//标志主页面加载完成\r\n");
      out.write("\t\t//var d = $(\"#id_contract_info_tabs_content\");\r\n");
      out.write("\t\tchenckCondiotn=true;\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval02-1.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("business_type");
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval02-1.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval02-1.jsp(159,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'bussiness_type_car' eq business_type}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<!--修改前页面:project/proj_approval/proj_equip_detail.jsp-->\r\n");
        out.write("\t\t\t\t");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_equip_detail02-1.jsp", out, false);
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
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval02-1.jsp(164,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval02-1.jsp(176,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/workflow/forms/contract/contract_approval/contract_approval02-1.jsp(181,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
