package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.rent_005freckon.rent_005fterminate;

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
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_rent_plan_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    isNeedTools:false,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    isAutoHeight:true,\r\n");
      out.write("\t    checkType:'radio',\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fund_rent_plan_str ? \"[]\" : json_fund_rent_plan_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t       {name:'rentlist',  header:'期项',type:'number'},\r\n");
      out.write("\t       {name:'plandate',  header:'计划日期',type:'date'},\r\n");
      out.write("\t       {name:'planstatusid',  header:'状态ID',hidden:true},\r\n");
      out.write("\t       {name:'planstatusname',  header:'状态',hidden:true},\r\n");
      out.write("\t       {name:'rent',  header:'租金',type:'double'},\r\n");
      out.write("\t       {name:'corpus',  header:'财务本金',type:'double'},\r\n");
      out.write("\t       {name:'interest',  header:'财务利息',type:'double'},\r\n");
      out.write("\t       {name:'corpusoverage',  header:'本金余额',type:'double'},\r\n");
      out.write("\t       {name:'corpusbusiness',  header:'业务本金',type:'double'},\r\n");
      out.write("\t       {name:'interestbusiness',  header:'业务利息',type:'double'},\r\n");
      out.write("\t       {name:'yearrate',  header:'年利率',type:'double'},\r\n");
      out.write("\t       {name:'rentadjust',  header:'租金调整',type:'double'}\r\n");
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
