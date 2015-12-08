package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fcollection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005flimit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction checkLimit() {\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_limit_container');\r\n");
      out.write("\t\tvar tabledata = currentTable1.getRowsData();\r\n");
      out.write("\t\tif (tabledata.length > 0) {\r\n");
      out.write("\t\t\tfor ( var i = 0; i < tabledata.length; i++) {\r\n");
      out.write("\t\t\t\tif(typeof tabledata[i]['limitmoney'] == 'undefined'){\r\n");
      out.write("\t\t\t\t\tloadMask_oper.hide();\r\n");
      out.write("\t\t\t\t\tjQuery.messager.alert('错误提示', \"<div style='font-size:18px;line-height:30px;'>请选择投放额度！</div>\", 'error');\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("    jQuery(function(){\t\r\n");
      out.write("    \t\r\n");
      out.write("    \tvar limitJason = [];\r\n");
      out.write("    \tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${json_fund_limit_str}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'){//后台带出数据，适用于企划添加\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\tlimitJason = JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fund_limit_str ? \"[]\" : json_fund_limit_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("    \t\r\n");
      out.write("    \t} else{//前台导出，适用于经销商\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \tnew tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_limit_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:450,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    tools:'修改',\r\n");
      out.write("\t    //isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    datas:limitJason,\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'uuid',hidden:true},\r\n");
      out.write("\t       {name:'dealername', header:'经销商名称',readOnly:true},\r\n");
      out.write("\t       {name:'custname', header:'客户名称',readOnly:true},\r\n");
      out.write("\t\t   {name:'contractname', header:'合同号',readOnly:true},\r\n");
      out.write("\t\t   {name:'contractid', header:'合同id',hidden:true},\r\n");
      out.write("\t\t   {name:'limitmoney', header:'额度金额',type:'double',nullable:false}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("\r\n");
      out.write("   });\r\n");
      out.write("\r\n");
      out.write("   </script>");
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
