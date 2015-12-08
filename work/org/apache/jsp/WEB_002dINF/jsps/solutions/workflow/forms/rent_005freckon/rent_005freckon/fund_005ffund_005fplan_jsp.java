package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.rent_005freckon.rent_005freckon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005ffund_005fplan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tif(isSubTable){\r\n");
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_fund_fund_charge_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    isAutoHeight:true,\r\n");
      out.write("\t    isAutoHeight:true,\r\n");
      out.write("\t    tools:'修改',\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    completeCallBack:function(){\r\n");
      out.write("\t    \tfundPlanMultiTable();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fund_fund_charge_str ? \"[]\" : json_fund_fund_charge_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t       {name:'docid',  header:'docid',hidden:true},\r\n");
      out.write("\t       {name:'contractid',  header:'合同号',nullable:false,readOnly:true},\r\n");
      out.write("\t       {name:'paymentid',  header:'编号',nullable:false,readOnly:true},\r\n");
      out.write("\t       {name:'plandate',  header:'计划收款日期',nullable:false,type:'date'},\r\n");
      out.write("\t       {name:'planmoney',  header:'金额',nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'feetypename',  header:'款项名称',nullable:false,readOnly:false,type:'combobox',hiddenName:'feetype',\r\n");
      out.write("\t\t\t   config:{\r\n");
      out.write("\t\t\t       width:165,\r\n");
      out.write("\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t\t\t          pid:'FeeType'\r\n");
      out.write("\t\t\t       } \r\n");
      out.write("\t\t       }\r\n");
      out.write("\t       },\r\n");
      out.write("\t       {name:'feetype',  header:'款项名称id',hidden:true},\r\n");
      out.write("\t       {name:'paytypename',  header:'收付方向',nullable:false,readOnly:false,type:'combobox',hiddenName:'paytype',\r\n");
      out.write("\t\t\t   config:{\r\n");
      out.write("\t\t\t       width:165,\r\n");
      out.write("\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t\t\t          pid:'pay_type'\r\n");
      out.write("\t\t\t       } \r\n");
      out.write("\t\t       }\r\n");
      out.write("\t       },\r\n");
      out.write("\t       {name:'paytype',  header:'收付方向id',hidden:true},\r\n");
      out.write("\t       {name:'payobj',  header:'收付对象',nullable:false,readOnly:false,type:'combobox',\r\n");
      out.write("\t\t    \tconfig:{\r\n");
      out.write("\t\t\t       width:165,\r\n");
      out.write("\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\proj_approval\\\\FundFundPlanCustSelect.xml',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t       valueField:'name',\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t    \t  \t\t\tuser_id:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t\t\t       } \r\n");
      out.write("\t       \t\t}\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t       {name:'fpnote', header:'备注',type:'textarea'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("function  createFundChargePlan(returnResult){\r\n");
      out.write("\t//alert(\"资金计划重组\");\r\n");
      out.write("\tvar fundChargePlan = getTracywindyObject('table_id_table_leasing_fund_fund_charge_container');\r\n");
      out.write("\tfundChargePlan.tableData = JsonUtil.decode(returnResult)['fundchargeplan'];\r\n");
      out.write("\tfundChargePlan.reload();\r\n");
      out.write("}\r\n");
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
