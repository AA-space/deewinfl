package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fonhire;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005falready_005fthrow_005fin_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_already_throw_in_list_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_already_throw_in_list_str ? \"[]\" : json_already_throw_in_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t       {name:'fundfundchargeplan',  header:'投放编号',type:'String'},\r\n");
      out.write("\t       {name:'settlemethod',  header:'结算方式'},\r\n");
      out.write("\t       {name:'factobject',  header:'投放对象'/*,otherAttributes:\" onpropertychange='document.all.price.value=document.all.equip_num.value*this.value' \"*/},\r\n");
      out.write("\t       {name:'factmoney',  header:'投放金额',nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'factdate',  header:'实际投放日期',nullable:false,type:'date'},\r\n");
      out.write("\t       {name:'invoiceno', header:'单据号'},\r\n");
      out.write("\t       {name:'clientbank',  header:'客户开户银行'},\r\n");
      out.write("\t       {name:'clientaccnumber',  header:'客户开户账号'},\r\n");
      out.write("\t       {name:'clientaccount',  header:'客户开户账户'},\r\n");
      out.write("\t       {name:'accnumber',  header:'本方账号'},\r\n");
      out.write("\t       {name:'account',  header:'本方账户'},\r\n");
      out.write("\t       {name:'accountbank',  header:'本方银行'},\r\n");
      out.write("\t       {name:'accountingdate',  header:'会计处理日',nullable:false,type:'date'},\r\n");
      out.write("\t       {name:'ffcmemo',  header:'备注',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\proj_approval\\\\simpleCustSelect.xml',\r\n");
      out.write("\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t       valueField:'code'\r\n");
      out.write("\t\t   }}\r\n");
      out.write("\t      \r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
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
