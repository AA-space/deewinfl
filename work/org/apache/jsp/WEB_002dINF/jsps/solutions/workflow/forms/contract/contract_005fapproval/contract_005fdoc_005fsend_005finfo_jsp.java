package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fdoc_005fsend_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("   \r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("    var currentIsNeedTools = true;\r\n");
      out.write("    \r\n");
      out.write("    /* if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("    \tcurrentIsNeedTools = false;\r\n");
      out.write("    } */\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("    //合同号\r\n");
      out.write("    var contract_id = document.getElementById(\"contract_info.id\").value;\r\n");
      out.write("    //金额\r\n");
      out.write("    var equipAmt = document.getElementById(\"equipAmt\").value;\r\n");
      out.write("\tnew tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_contract_doc_send_info',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:450,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    tools:'修改',\r\n");
      out.write("\t    otherTools :[\r\n");
      out.write("\t         \t    \r\n");
      out.write("\t         \t    {\r\n");
      out.write("       \t \thtml : '<font color=\"red\">同步合同登记信息</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tvar conditions = {};\r\n");
      out.write("\t\t    \tconditions.contract_id = contract_id;//项目id,必填\r\n");
      out.write("\t\t    \tconditions.equipAmt = equipAmt;\r\n");
      out.write("\t\t        \r\n");
      out.write(" \t\t\t\t$.post('leasing/docSendCheckNew.action', conditions, function(data) {\r\n");
      out.write(" \t\t\t\t\tif(data){\r\n");
      out.write(" \t\t\t\t\t\ttable.tableData = JsonUtil.decode(data);\r\n");
      out.write(" \t\t\t\t\t\tcreateDataTable(table);\r\n");
      out.write(" \t\t\t\t\t\talert(\"更新成功\");\r\n");
      out.write(" \t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}); \r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t    }\r\n");
      out.write("        ,\r\n");
      out.write(" \r\n");
      out.write("        {\r\n");
      out.write("       \t \thtml : '<font color=\"red\">批量修改快递单号</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("    \t\t   var plandata = table.getCheckedRowDatas();\r\n");
      out.write("    \t\t   if(plandata.length<=0){alert(\"请选择合同\")}\r\n");
      out.write("    \t\t   else{\r\n");
      out.write("    \t\t\t   jQuery(\"#id_contract_doc_ems_window\").show();\r\n");
      out.write("        \t\t   jQuery(\"#id_contract_doc_ems_window\").window({top:10});\r\n");
      out.write("        \t\t   jQuery(\"#id_contract_doc_ems_window\").window(\"open\");\r\n");
      out.write("        \t\t  }\r\n");
      out.write("    \t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t    }\r\n");
      out.write("\t    ],\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_doc_send_info_str ? \"[]\" : json_contract_doc_send_info_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t     //xmlFileName:'\\\\eleasing\\\\workflow\\\\contract\\\\doc_send_info.xml',\r\n");
      out.write("\t     //loadMode:'ajax',\r\n");
      out.write("\t     params : {\r\n");
      out.write("\t    \t contract_id : contract_id,\r\n");
      out.write("\t    \t equipAmt : equipAmt\r\n");
      out.write("\t     },\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t       {name:'contractid',  header:'contractid',hidden:true},\r\n");
      out.write("\t       {name:'contractnumber',  header:'合同编号',readOnly:true},\r\n");
      out.write("\t       {name:'businessmode',header:'业务模式',readOnly:true},\r\n");
      out.write("\t       {name:'custname',header:'客户名称',readOnly:true},\r\n");
      out.write("\t       {name:'docname',  header:'docname',hidden:true},\r\n");
      out.write("\t       {name:'rowvalue_docname', header:'合同档案名称',readOnly:true},\r\n");
      out.write("\t       {name:'contractperson',  header:'合同对方'},\r\n");
      out.write("\t       {name:'totalprice',  header:'合同金额',readOnly:true},\r\n");
      out.write("\t       {name:'docpart',  header:'合同份数'},\r\n");
      out.write("\t       {name:'contracta',  header:'我方签约人'},\r\n");
      out.write("\t       {name:'contractb',  header:'对方签约人'},\r\n");
      out.write("\t       {name:'contractdate',  header:'合同生效日期',type:'date'},\r\n");
      out.write("\t       {name:'sendpart',  header:'寄送/不寄送'},\r\n");
      out.write("\t       {name:'sendno',  header:'快递单号'},\r\n");
      out.write("\t       {name:'maincount',  header:'主车台数'},\r\n");
      out.write("\t       {name:'gcount',  header:'挂车台数'},\r\n");
      out.write("\t       {name:'sdy',  header:'是否抵押'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("\t \r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
