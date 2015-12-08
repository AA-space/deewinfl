package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class funds_005flimit_005flimit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t//alert(jQuery(\"#contractid\").val());\r\n");
      out.write("\t\tnew tracywindyMultiTable({\r\n");
      out.write("\t\t    renderTo:'id_table_leasing_contract_limit_list',\r\n");
      out.write("\t\t    //id:'id_table_leasing_contract_limit_list',\r\n");
      out.write("\t\t    loadMode:'ajax',\r\n");
      out.write("\t\t    width:formWidth,\r\n");
      out.write("\t\t    tools:'',\r\n");
      out.write("\t\t    height:350,\r\n");
      out.write("\t\t    xmlFileName:'\\\\eleasing\\\\workflow\\\\contract\\\\contract_put_limit_list.xml',\r\n");
      out.write("\t\t    isFit:true,\r\n");
      out.write("\t\t    params:{\r\n");
      out.write("\t\t\tcontractnumber:jQuery(\"#contractid\").val()\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    columns:[\r\n");
      out.write("\t               {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'custname',  header:'客户名'},\r\n");
      out.write("\t\t\t       {name:'dealername',  header:'经销商名称'},\r\n");
      out.write("\t\t\t       {name:'contractid',  header:'合同编号'},\r\n");
      out.write("\t\t\t       {name:'limitmoney',  header:'合同限额'},\r\n");
      out.write("\t\t\t       {name:'createdate',  header:'申请日期'}\r\n");
      out.write("\t\t     ]\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t\r\n");
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
