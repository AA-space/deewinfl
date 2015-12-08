package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fput_005fthis_005fdeewinfl_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tif(isSubTable){\r\n");
      out.write("\t    var columns = [\r\n");
      out.write("\t        \t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t        \t       {name:'pid',  header:'pid',hidden:true},\r\n");
      out.write("\t        \t       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},\r\n");
      out.write("\t        \t       {name:'feeadjust',  header:'feeadjust',hidden:true, defaultValue : 0.00},\r\n");
      out.write("\t                   {name:'rollback',  header:'rollback',hidden:true},\r\n");
      out.write("\t        \t       //{name:'orderid',  header:'序号',nullable:false,type:'number'},\r\n");
      out.write("\t        \t       {name:'paymentid',  header:'投放编号',nullable:false,readOnly:true},\r\n");
      out.write("\t        \t       {name:'factobject',  header:'付款人名称',nullable:false,readOnly:false},\r\n");
      out.write("\t        \t       {name:'custname',  header:'客户名称',nullable:false},\r\n");
      out.write("\t        \t       {name:'contractid',  header:'合同号',hidden:true,nullable:false,readOnly:true},\r\n");
      out.write("\t        \t       //{name:'contractnumber',  header:'融资租赁合同号',nullable:false,readOnly:true},\r\n");
      out.write("\t        \t       //{name:'tablename12',  header:'台数',nullable:false,type:'double'},\r\n");
      out.write("\t        \t        {name:'settlemethod',  header:'settlemethodid', hidden :true},\r\n");
      out.write("\t        \t        {name:'feetype',  header:'feetypeId', hidden :true},\r\n");
      out.write("\t        \t\t \t{name:'rawValue_feetype',  header:'付款名目',nullable:false,type:'combobox',hiddenName:'feetype',\r\n");
      out.write("\t        \t\t\t    \t   config:{\r\n");
      out.write("\t        \t\t\t\t\t       width:165,\r\n");
      out.write("\t        \t\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t        \t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t        \t\t\t\t\t       readOnly:true,\r\n");
      out.write("\t        \t\t\t\t\t       displayField:'name',\r\n");
      out.write("\t        \t\t\t\t\t       valueField:'code',\r\n");
      out.write("\t        \t\t\t\t\t       params:{\r\n");
      out.write("\t        \t\t\t\t\t          pid:'FeeType'\r\n");
      out.write("\t        \t\t\t\t\t       } \r\n");
      out.write("\t        \t\t\t\t\t   }\r\n");
      out.write("\t        \t\t\t       }, \r\n");
      out.write("\t        \t      // {name:'tablename13',  header:'付款名目',nullable:false,type:'double'},\r\n");
      out.write("\t        \t       //{name:'tablename14',  header:'应收首付款',nullable:false,type:'double'},\r\n");
      out.write("\t        \t       {name:'planfirstpayment',  header:'应收首付款',readOnly:true},\r\n");
      out.write("\t        \t       {name:'factfirstmoney',  header:'实收首付款',readOnly:true},\r\n");
      out.write("\t        \t       {name:'equipcount',  header:'台数',nullable:false},\r\n");
      out.write("\t        \t       {name:'equipmoney',  header:'设备款',nullable:false},\r\n");
      out.write("\t        \t       {name:'factmoney',  header:'电汇金额',nullable:false},\r\n");
      out.write("\t        \t       {name:'creditmoney',  header:'放车额度',readOnly:true,nullable:false,otherAttributes:'id=\"id_creditmoney\" onkeyup=\"comptuerCurMoney()\"'},\r\n");
      out.write("\t        \t       //{name:'factdate',  header:'付款时间', type:'date'},\r\n");
      out.write("\t        \t       {name:'clientbank',  header:'客户银行'},\r\n");
      out.write("\t        \t       {name:'clientaccount',  header:'客户账户'},\r\n");
      out.write("\t        \t       {name:'clientaccnumber',  header:'客户账号'},\r\n");
      out.write("\t        \t       {name:'servicefees',  header:' 综合服务费',otherAttributes:'id=\"id_servicefees\"'}\r\n");
      out.write("\t        \t     ];\r\n");
      out.write("\t    \r\n");
      out.write("\t    var _tools = '修改|删除';\r\n");
      out.write("\t    //是否填写开户行和账号\r\n");
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    if(isNeedBank){\r\n");
      out.write("\t    \tif(isNeedBankEdit){\r\n");
      out.write("\t\t    \tfor ( var int = 0; int < columns.length; int++) {\r\n");
      out.write("\t\t\t\t\tif(!columns[int]['readOnly']){\r\n");
      out.write("\t\t\t\t\t\tcolumns[int]['readOnly'] = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t    \t\tcurrentIsNeedTools = true;\r\n");
      out.write("\t    \t\t_tools = '修改';\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \tcolumns.push({name:'accountbank',  header:'开户行户名称',nullable:false}, {name:'accnumber',  header:'账号',nullable:false});\r\n");
      out.write("\t    }\r\n");
      out.write("\t    \r\n");
      out.write("\t    \r\n");
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_contract_fund_payment_now_container',\r\n");
      out.write("\t    width:document.documentElement.clientWidth-2,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    tools:_tools,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    updateFromOperCallBack:function(operType,thisForm,me,rowData){\r\n");
      out.write("\t    \t if(operType==\"update\"){\r\n");
      out.write("\t\t    \t //默认付款日期为周三，超过为下周三\r\n");
      out.write("\t    \t\t /*var day=new Date();\r\n");
      out.write("\t    \t\t var num1=(3-day.getDay()+7)%7;\r\n");
      out.write("\t    \t\t var wed = new Date(day.getTime() + 1000 * 60 * 60 * 24 * num1);\r\n");
      out.write("\t    \t\t var factday=wed.getFullYear()+\"-\"+(wed.getMonth()+1)+\"-\"+wed.getDate();\r\n");
      out.write("\t\t    \t thisForm[\"factdate\"].value=factday;*/\r\n");
      out.write("\t    \t }\r\n");
      out.write("\t \t},\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_fund_payment_now_str ? \"[]\" : json_contract_fund_payment_now_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:columns\r\n");
      out.write("\t });\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function comptuerCurMoney(){\r\n");
      out.write("    var creditmoney=$('#id_creditmoney');\r\n");
      out.write("    var servicefees=$('#id_servicefees');\r\n");
      out.write("    var tempservice=parseFloat(creditmoney.val()||0)*0.026;\r\n");
      out.write("    servicefees.val(tempservice.toFixed(2));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
