package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcredit04_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!-- 特殊附件显示公用方法 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/proj_view_file.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../util/flow_condition_select.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目立项附件带到租前业务相关流程 -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "initFileListParams.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 项目信审申请 -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//全局变量说是这一个只读业页\r\n");
      out.write("isViewHistoryTask = true;\r\n");
      out.write("//是否保存   \r\n");
      out.write("function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("{  fillHiddenVal();\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("//是否提交    \r\n");
      out.write("/*\r\n");
      out.write("function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("{  \r\n");
      out.write("\tif(buttonText==\"Submit\"){\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\tvar isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\tif(isPassed){\r\n");
      out.write("\t\t\tif(equipNum1<10){//10台一下必须填写信审结论\r\n");
      out.write("\t\t\t\tif(getTracywindyObject('id_combo_id_credit_result_type').getValue()==\"\"){\r\n");
      out.write("\t\t\t\t\tisPassed=false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(jQuery(\"#id_proj_projcreditpasstime\").val()==\"\"){\r\n");
      out.write("\t\t\t\t\tisPassed=false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(!isPassed){\r\n");
      out.write("\t\t\t\t\talert(\"10台以下必须填写信审结论和时间!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn isPassed;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("var equipNum1=0;//拖车数量\r\n");
      out.write("var equipNum2=0;//挂车数量\r\n");
      out.write("//流程提交是设置条件路由\r\n");
      out.write("function workflowNextRouteCallBack(buttonText,requestNextRoute){\r\n");
      out.write("    if(buttonText==\"Submit\"){\r\n");
      out.write("        //判断是否决\r\n");
      out.write("        var creditResult=getTracywindyObject('id_combo_id_credit_result_type');//.getValue();\r\n");
      out.write("        var creditResultNum=jQuery(\"#id_credit_result_value\").val();\r\n");
      out.write("        if(creditResultNum>100){\r\n");
      out.write("            if(confirm(\"您的信审结论为[\"+creditResult.getRawValue()+\"],点击确认流程将直接结束!\")){\r\n");
      out.write("            \trequestNextRoute.value=\"TO 结束\";\r\n");
      out.write("            \treturn;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    \tvar nextroute05=\"05业务评审委员会(1)评委\";\r\n");
      out.write("    \tvar nextroute06=\"06业务评审委员会(2) 评委\";\r\n");
      out.write("    \tvar nextroute07=\"07业务企划办理\";\r\n");
      out.write("\t\tif(equipNum1<10){\r\n");
      out.write("   \t\t\trequestNextRoute.value=nextroute07;\r\n");
      out.write("\t\t}else if(equipNum1>=10&&equipNum1<20){\r\n");
      out.write("\t\t\trequestNextRoute.value=nextroute05;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\trequestNextRoute.value=nextroute06;\r\n");
      out.write("\t\t}\r\n");
      out.write("    }\r\n");
      out.write("}*/\r\n");
      out.write("\r\n");
      out.write("//是否提交    \r\n");
      out.write("function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("{  \r\n");
      out.write("\tif(buttonText==\"Submit\"){\r\n");
      out.write("\t\tvar submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t\tvar isPassed = Validator.Validate(submitProcessedForm,1,false);\r\n");
      out.write("\t\tif(isPassed){\r\n");
      out.write("\t\t\tif(equipNum1<=10){//10台一下必须填写信审结论\r\n");
      out.write("\t\t\t\tif(getTracywindyObject('id_combo_id_credit_result_type').getValue()==\"\"){\r\n");
      out.write("\t\t\t\t\tisPassed=false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(jQuery(\"#id_proj_projcreditpasstime\").val()==\"\"){\r\n");
      out.write("\t\t\t\t\tisPassed=false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(!isPassed){\r\n");
      out.write("\t\t\t\t\talert(\"10台以下必须填写信审结论和时间!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar creditResult=getTracywindyObject('id_combo_id_credit_result_type');//.getValue();\r\n");
      out.write("        var creditResultNum=jQuery(\"#id_credit_result_value\").val();\r\n");
      out.write("        if(creditResultNum>100){\r\n");
      out.write("            if(confirm(\"您的信审结论为[\"+creditResult.getRawValue()+\"],点击确认流程将直接结束!\")){\r\n");
      out.write("            \tselectRote=\"TO 结束\";\r\n");
      out.write("            \tisPassed=true;\r\n");
      out.write("            }else{\r\n");
      out.write("            \tisPassed=false;\r\n");
      out.write("            }\r\n");
      out.write("        }else{\r\n");
      out.write("           if(parseFloat(equipNum1)<=10){\r\n");
      out.write("               //德银需求，取消业务企划办理 \r\n");
      out.write("               //selectRote=\"07业务企划办理\";\r\n");
      out.write("            \t selectRote=\"TO 结束\";\r\n");
      out.write("\t\t\t     return  isPassed;\r\n");
      out.write("\t\t     }else{\r\n");
      out.write("\t\t    \t var condtion=\"[{condtion:'业务评审委员会(1)评委',rote:'05业务评审委员会(1)评委'},{condtion:'业务评审委员会(2)评委',rote:'06业务评审委员会(2) 评委'}]\";\r\n");
      out.write("\t\t    \t if(!isSelectRote){\r\n");
      out.write("\t\t        \t   selectRoteByCondtion(condtion);\r\n");
      out.write("\t\t        \t    return false;\r\n");
      out.write("\t\t             }else{\r\n");
      out.write("\t\t        \t    return isPassed;\r\n");
      out.write("\t\t          }\r\n");
      out.write("\t\t     }\r\n");
      out.write("        }\r\n");
      out.write("        isSelectRote=false;\r\n");
      out.write("\t\treturn isPassed;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("var equipNum1=0;//拖车数量\r\n");
      out.write("var equipNum2=0;//挂车数量\r\n");
      out.write("var isSelectRote=false; \r\n");
      out.write("var selectRote=\"\"; \r\n");
      out.write("//流程提交是设置条件路由\r\n");
      out.write("function workflowNextRouteCallBack(buttonText,requestNextRoute){\r\n");
      out.write("    if(buttonText==\"Submit\"){\r\n");
      out.write("    \trequestNextRoute.value=selectRote;\r\n");
      out.write("   \t\tisSelectRote=false;\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("function formPageReadOnlyCallBack(){\r\n");
      out.write("\tformJSPInputHideOrShow(\"proj_credit_result\",\"\",1);\r\n");
      out.write(" }\r\n");
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
      out.write("\t <tr>\r\n");
      out.write("       <td colspan=4>\r\n");
      out.write("       ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("       </td>\r\n");
      out.write("    </tr>\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目评审结果 -->\r\n");
      out.write("\t\t ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_credit_result_info.jsp", out, false);
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4><!-- 插入项目信审结论 -->\r\n");
      out.write("\t\t<script language=\"javascript\">\r\n");
      out.write("            jQuery(function() {isViewHistoryTask = isCompletedTask;});\r\n");
      out.write("        </script> \r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_credit_result.jsp", out, false);
      out.write("   \r\n");
      out.write("\t\t <script language=\"javascript\">\r\n");
      out.write("\t\t    jQuery(function() {\r\n");
      out.write("\t\t\t    isViewHistoryTask = true;\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("         </script>\r\n");
      out.write("        </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/proj_equip_detail.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../proj_approval/proj_guarantee_method.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "proj_cust_credit.jsp", out, false);
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t//页面初始化\r\n");
      out.write("\tvar isSubTable=true;\r\n");
      out.write("\t//法人附件上传权限\r\n");
      out.write("\tvar isAttachment=false;\r\n");
      out.write("\t\r\n");
      out.write("\tfunction fillHiddenVal() {\r\n");
      out.write("\t\t//租赁物件\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_equip_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable1.getRowsJsonData()));\r\n");
      out.write("\t\t//担保单位信息\r\n");
      out.write("\t\tvar currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');\r\n");
      out.write("\t\tjQuery('#id_json_proj_guarantee_method_str').val(\r\n");
      out.write("\t\t\t\tJsonUtil.encode(currentTable4.getRowsJsonData()));\r\n");
      out.write("\t\tsaveReckonJsonValue();//保存租金测算结果\r\n");
      out.write("\t}\r\n");
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
      out.write("\tfunction countEquipNum(){//计算租赁物件的数据\r\n");
      out.write("\t\tvar equipJson=jQuery(\"#id_json_proj_equip_str\").val();\r\n");
      out.write("\t\tequipJson=JsonUtil.decode(equipJson);\r\n");
      out.write("    \tfor(var i=0;i<equipJson.length;i++){\r\n");
      out.write("        \tvar equip=equipJson[i];\r\n");
      out.write("        \tif(equip[\"equipclass\"]==\"equip_class_2\"){\r\n");
      out.write("        \t\tequipNum2++;\r\n");
      out.write("        \t}else{\r\n");
      out.write("        \t\tequipNum1++;\r\n");
      out.write("        \t}\r\n");
      out.write("        \t\r\n");
      out.write("    \t}\r\n");
      out.write("    \r\n");
      out.write("\t}\r\n");
      out.write("\tcountEquipNum();\r\n");
      out.write("\tif(equipNum1>10){//台以上不需要填写信审结论\r\n");
      out.write("\t\tjQuery(\"#proj_credit_result\").hide();\r\n");
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
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit04.jsp(156,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit04.jsp(218,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']=='法人'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        out.write("      \r\n");
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
