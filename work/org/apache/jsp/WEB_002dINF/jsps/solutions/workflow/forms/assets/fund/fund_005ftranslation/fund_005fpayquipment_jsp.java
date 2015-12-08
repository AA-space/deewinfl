package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005ftranslation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005fpayquipment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <script language=\"javascript\">\r\n");
      out.write("  \tvar dealer_id='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty dealerid ? \"\" : dealerid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("  \t//console.info(dealer_id);\r\n");
      out.write("  \tvar dealer_name='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty dealername ? \"\" : dealername }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("  \t//console.info(dealer_name);\r\n");
      out.write(" \tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("    \t\r\n");
      out.write("    \t endData =$('#enddate').val(getCurDate());\r\n");
      out.write("    \t\t//经销商\r\n");
      out.write("    \t   var dealer=  new tracywindyComboBox({\r\n");
      out.write("       \t    id:'id_combo_dealer',\r\n");
      out.write("       \t    width:162,\r\n");
      out.write("       \t    renderTo:'id_dealer',\r\n");
      out.write("       \t    xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\comboDealerName.xml',\r\n");
      out.write("       \t    loadMode:'ajax',\r\n");
      out.write("       \t    readOnly:false,\r\n");
      out.write("       \t    isAjaxLenovo:true,\r\n");
      out.write("       \t    isContainEmpty:true,\r\n");
      out.write("       \t    dropListHeight:300,\r\n");
      out.write("       \t    topAdd:0,\r\n");
      out.write("       \t    leftAdd:0,\r\n");
      out.write("       \t    positionDropIconLeftAdd:-1,\r\n");
      out.write("       \t    name:'dealer_name',\r\n");
      out.write("       \t    displayField:'name',\r\n");
      out.write("       \t    valueField:'value',\r\n");
      out.write("       \t \tvalue:dealer_id,\r\n");
      out.write("       \t\trawValue:dealer_name,\r\n");
      out.write("       \t \treadOnlyData:(dealer_id.length>0?true:false),\r\n");
      out.write("       \t    params:{\r\n");
      out.write("       \t    \tuser_id :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("       \t    },\r\n");
      out.write("       \t    onSelect:function(r, v) {\r\n");
      out.write("       \t    \tcustname.setParam(\"dealer_id\",this.getValue());\r\n");
      out.write("       \t    \tcontract.setParam(\"cust_number\",'');\r\n");
      out.write("       \t    \tcontract.reload();\r\n");
      out.write("       \t    \tcustname.reload();\r\n");
      out.write("       \t    }\r\n");
      out.write("       \t });\r\n");
      out.write("    \t\r\n");
      out.write("    \t   //客户名称\r\n");
      out.write("    \t   var custname=  new tracywindyComboBox({\r\n");
      out.write("          \t    id:'id_custname',\r\n");
      out.write("          \t    width:162,\r\n");
      out.write("          \t    renderTo:'id_custname',\r\n");
      out.write("          \t    xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\limitCustSelect.xml',\r\n");
      out.write("          \t    loadMode:'ajax',\r\n");
      out.write("          \t    readOnly:false,\r\n");
      out.write("          \t    isAjaxLenovo:true,\r\n");
      out.write("          \t    isContainEmpty:true,\r\n");
      out.write("          \t    dropListHeight:300,\r\n");
      out.write("          \t    topAdd:0,\r\n");
      out.write("          \t    leftAdd:0,\r\n");
      out.write("          \t    positionDropIconLeftAdd:-1,\r\n");
      out.write("          \t    name:'cust_name',\r\n");
      out.write("          \t    displayField:'name',\r\n");
      out.write("          \t    valueField:'id',\r\n");
      out.write("          \t \t//readOnlyData:(dealer_id.length>0?true:false),\r\n");
      out.write("          \t \tparams:{\r\n");
      out.write("          \t \t\tdealer_id:dealer_id,\r\n");
      out.write("          \t \t\tcust_type: 'cust_type.cust',\r\n");
      out.write("           \t    \tcust_class1:'CUST_INFO_COMPANY',\r\n");
      out.write("           \t    \tcust_class2:'CUST_INFO_COMPANY'\r\n");
      out.write("           \t    },\r\n");
      out.write("          \t    onSelect:function(r, v) {\r\n");
      out.write("          \t    \tcontract.setParam(\"cust_number\",this.getValue());\r\n");
      out.write("          \t    \tcontract.reload();          \t    \t\r\n");
      out.write("          \t    }\r\n");
      out.write("          \t });\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t//合同号\r\n");
      out.write("    \t   var contract=   new tracywindyComboBox({\r\n");
      out.write("       \t    id:'id_combo_contract',\r\n");
      out.write("       \t    width:162,\r\n");
      out.write("       \t    renderTo:'id_contract_id_container',\r\n");
      out.write("       \t    xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\fundfundSelectContract.xml',\r\n");
      out.write("       \t    loadMode:'ajax',\r\n");
      out.write("       \t    readOnly:false,\r\n");
      out.write("       \t    isAjaxLenovo:true,\r\n");
      out.write("       \t    isContainEmpty:true,\r\n");
      out.write("       \t    dropListHeight:300,\r\n");
      out.write("       \t    topAdd:0,\r\n");
      out.write("       \t    leftAdd:0,\r\n");
      out.write("       \t    positionDropIconLeftAdd:-1,\r\n");
      out.write("       \t    name:'contract_number',\r\n");
      out.write("       \t    displayField:'contract_number',\r\n");
      out.write("       \t    valueField:'id',\r\n");
      out.write("       \t params :{\r\n");
      out.write("       \t    \tcust_number : ' '\r\n");
      out.write("       \t    },\r\n");
      out.write("       \t    onSelect:function(combo){\r\n");
      out.write("           \t   \r\n");
      out.write("       \t    }\r\n");
      out.write("       \t });\r\n");
      out.write("    \t\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t//合同号\r\n");
      out.write("/*     \t   var contract=   new tracywindyComboBox({\r\n");
      out.write("       \t    id:'id_combo_contract',\r\n");
      out.write("       \t    width:162,\r\n");
      out.write("       \t    renderTo:'id_contract_id_container',\r\n");
      out.write("       \t    xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\fundrentSelectContract.xml',\r\n");
      out.write("       \t    loadMode:'ajax',\r\n");
      out.write("       \t    readOnly:false,\r\n");
      out.write("       \t    isAjaxLenovo:true,\r\n");
      out.write("       \t    isContainEmpty:true,\r\n");
      out.write("       \t    dropListHeight:300,\r\n");
      out.write("       \t    topAdd:0,\r\n");
      out.write("       \t    leftAdd:0,\r\n");
      out.write("       \t    positionDropIconLeftAdd:-1,\r\n");
      out.write("       \t    name:'contract_number',\r\n");
      out.write("       \t    displayField:'contract_number',\r\n");
      out.write("       \t    valueField:'id',\r\n");
      out.write("       \t    params:{\r\n");
      out.write("       \t    \tdealer_id:dealer_id\r\n");
      out.write("       \t    },\r\n");
      out.write("       \t    onSelect:function(combo){\r\n");
      out.write("           \t   \r\n");
      out.write("       \t    }\r\n");
      out.write("       \t });\r\n");
      out.write("    \t */\r\n");
      out.write("    \t\r\n");
      out.write("    /*     if(isSubTable){\r\n");
      out.write("\t\t ///dict('tablename1','tablename64','root_null_ini','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.projsource\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"经销商\"');\r\n");
      out.write("\t\t dictOnSelect('tablename2','tablename65','root_null_ini','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.leasform\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"合同号\"');\r\n");
      out.write("        } */\r\n");
      out.write("        });\r\n");
      out.write("    \r\n");
      out.write("    function detialCollection(){\r\n");
      out.write("\t\tvar table_rent_plan = getTracywindyObject('table_id_fund_plan_detial');\r\n");
      out.write("\t\t//部门\r\n");
      out.write("\t\t var contract_id =getTracywindyObject('id_combo_contract').getValue();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar cust_id = getTracywindyObject('id_custname').getValue();\r\n");
      out.write("\t\t/* if(cust_id==\"\"){\r\n");
      out.write("\t\t\talert(\"请选择客户名称！！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar dealer_id =  getTracywindyObject('id_combo_dealer').getValue();\r\n");
      out.write("\t\t// var startData = '';\r\n");
      out.write("\t\t var endData = '';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("/* \t\t if($('#startdate').val()){\r\n");
      out.write("\t\t\t startData = $('#startdate').val();\r\n");
      out.write("\t\t\t startData = calculateDate('4',-1, startData,'yyyy-MM-dd');\r\n");
      out.write("\t\t } */\r\n");
      out.write("\t\t endData =$('#enddate').val() || getCurDate();\r\n");
      out.write("\t\t endData = calculateDate('4', 1, endData,'yyyy-MM-dd');\r\n");
      out.write("\t\t/*  if(!contract_id){\r\n");
      out.write("\t\t\t jQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>请选择合同</div>\",'success'); \r\n");
      out.write("\t\t\t return;\r\n");
      out.write("\t\t } */\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t table_rent_plan.setParam('cust_number', cust_id);\r\n");
      out.write("\t\t table_rent_plan.setParam('dealer_number', dealer_id);\r\n");
      out.write("\t\t table_rent_plan.setParam('contract_id', contract_id);\r\n");
      out.write("\t\t //table_rent_plan.setParam('plan_date_start', startData);\r\n");
      out.write("\t \t table_rent_plan.setParam('plan_date_end', endData);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\ttable_rent_plan.reload();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tjQuery(\"#id_fund_plan_detial\").show();\r\n");
      out.write("\t\tjQuery(\"#id_fund_plan_detial\").window({\r\n");
      out.write("\t\t\t   top:15,\r\n");
      out.write("\t\t\t   title:'租金明细'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tjQuery(\"#id_fund_plan_detial\").window(\"open\");\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("<div>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write(".tabs-panels {\r\n");
      out.write("\tborder: 0px solid #ddd;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write(" <table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 98%; margin-top: 20px;\" id=\"fund_ebank_data\" >\r\n");
      out.write("       <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-project-condition\"></div>未付设备款明细</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("       <tr class=\"tr-project-condition tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">经销商：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_dealer\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">结束日期：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><input name=\"tablename67\" id=\"enddate\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projdate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  onClick=\"WdatePicker(this,{readOnly:true})\" readOnly require=\"true\" value= label=\"结束日期\" /></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("      \t<tr class=\"tr-project-condition tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">客户名称：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_custname\"></div></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">合同号：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_contract_id_container\"></div></td>\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\t\t <tr class=\"tr-project-condition tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\" colspan=3></td>\r\n");
      out.write("\t\t\t<td><input style=\"margin-top: 2px; margin-bottom: 2px;\" id=\"btn_rent_cal\" class=\"btn btn-primary\" type=\"button\" value=\"查询设备款明细\" onclick=\"detialCollection();\" /></td>\r\n");
      out.write("\t\t</tr>     \t\r\n");
      out.write(" </table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* \tif (isSubTable) {\r\n");
      out.write("\t\t//var user_id = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope[\"userDeptListSqlStr\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\tvar user_id = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\tvar queryStr = \"select ID_,NAME_ from t_depts where id_ = '\"+ user_id + \"' OR '\"+ user_id + \"' NOT IN (SELECT UD.USER_ID_  FROM DEALER_DEPT_INFO DD LEFT JOIN T_USERS_DEPTS UD   ON (DD.DEALER_DEPT = UD.DEPT_ID_)  WHERE UD.ID_ IS NOT NULL)\";\r\n");
      out.write("\t\tconsole.info(queryStr)*/\r\n");
      out.write("/* \t\tcommonSelect(\r\n");
      out.write("\t\t\t\t'id_dealer',\r\n");
      out.write("\t\t\t\t\"(\"+ queryStr +\")\",\r\n");
      out.write("\t\t\t\t'id_',\r\n");
      out.write("\t\t\t\t'name_',\r\n");
      out.write("\t\t\t\t'dealer.dept',\r\n");
      out.write("\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projdept\"] ? sessionScope[\"loginUserDeptObj\"].id : requestScope[\"dealer.dept\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\tnull, ' require=\"true\" label=\"出单部门\"'); \r\n");
      out.write("\t} */\r\n");
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
