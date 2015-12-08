package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.rent_005freckon.rent_005freckon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005frent_005fplan_005fframe_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tif(isSubTable){\r\n");
      out.write("\t\t//初次加载控制\r\n");
      out.write("\t\tvar settle_method=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope['framework_condition.settlemethod']?'even_rent':requestScope['framework_condition.settlemethod'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar read=false;\r\n");
      out.write("\t\tif(settle_method=='irregular_rent'){\r\n");
      out.write("\t\t\tread=false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    \tread=true;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    var fundRentPlan=new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_rent_plan_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    tools:'新增|修改|删除',\r\n");
      out.write("\t    isAutoHeight:true,\r\n");
      out.write("\t    otherTools:[\r\n");
      out.write("\t        {html:'<font style=\"color:red;font-weight:BOLD;\">租金测算</font>',iconCls:'icon-reckon',handler:rentPlanReckon},\r\n");
      out.write("\t        {html:'<font style=\"color:red;font-weight:BOLD;\">租金调整</font>',iconCls:'icon-adjust',handler:rentPlanAdjust}\r\n");
      out.write("\t    ],\r\n");
      out.write("\t    isNeedTools:true,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    completeCallBack:function(){\r\n");
      out.write("\t    \trentPlanMultiTable();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fund_rent_plan_str ? \"[]\" : json_fund_rent_plan_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t       {name:'rentlist',  header:'期项',readOnly:read,nullable:false,type:'text'},\r\n");
      out.write("\t       {name:'plandate',  header:'计划日期',readOnly:true,nullable:false,type:'date'},\r\n");
      out.write("\t       {name:'rent',  header:'租金',readOnly:true,nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'corpus',  header:'财务本金',readOnly:read,nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'interest',  header:'财务利息',readOnly:read,nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'corpusoverage',  header:'本金余额',readOnly:true,nullable:false,type:'double',hidden:true},\r\n");
      out.write("\t       {name:'corpusbusiness',  header:'业务本金',readOnly:read,nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'interestbusiness',  header:'业务利息',readOnly:read,nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'yearrate',  header:'年利率',readOnly:true,nullable:false,type:'rate',hidden:true},\r\n");
      out.write("\t       {name:'rentadjust',  header:'租金调整',readOnly:!currentIsNeedTools,type:'double',defaultValue:0}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
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
