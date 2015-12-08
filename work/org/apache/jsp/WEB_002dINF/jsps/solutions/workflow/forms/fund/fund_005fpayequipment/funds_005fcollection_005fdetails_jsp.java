package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class funds_005fcollection_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\tvar table_proj_fund_rent_plan= new tracywindyTable({\r\n");
      out.write("\t\t    renderTo:'id_table_leasing_funds_collection_details',\r\n");
      out.write("\t\t    id:'table_leasing_funds_collection_details',\r\n");
      out.write("\t\t    loadMode:'local',\r\n");
      out.write("\t\t    width:formWidth,\r\n");
      out.write("\t\t    height:350,\r\n");
      out.write("\t\t    isFit:false,\r\n");
      out.write("\t\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_fundfundcharge_str ? \"[]\" : json_fundfundcharge_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t\t    columns:[\r\n");
      out.write("\t              {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'paytype',  header:'paytype',hidden:true},\r\n");
      out.write("\t\t\t       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},\r\n");
      out.write("\t\t\t       {name:'fundfundchargeplan.paymentId',  header:'收款编号',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t       {name:'ebanknumber',  header:'网银编号'},\r\n");
      out.write("\t\t\t       {name:'feetype',  header:'费用类型',hidden:true},\r\n");
      out.write("\t\t\t \t     {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype',\r\n");
      out.write("\t\t\t    \t   config:{\r\n");
      out.write("\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t\t       params:{\r\n");
      out.write("\t\t\t\t\t          pid:'FeeType'\r\n");
      out.write("\t\t\t\t\t       } \r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       {name:'settlemethod',  header:'settlemethodId',hidden :true},\r\n");
      out.write("\t\t\t \t     {name:'rawValue_settlemethod',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'settlemethod',\r\n");
      out.write("\t\t\t    \t   config:{\r\n");
      out.write("\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t\t       params:{\r\n");
      out.write("\t\t\t\t\t          pid:'PayFund'\r\n");
      out.write("\t\t\t\t\t       } \r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t\t\t       {name:'factdate',  header:'到账时间',nullable:false},\r\n");
      out.write("\t\t\t       {name:'factmoney',  header:'金额',nullable:false,type:'double'},\r\n");
      out.write("\t\t\t       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},\r\n");
      out.write("\t\t\t       {name:'accountbank',  header:'银行'},\r\n");
      out.write("\t\t\t       {name:'account',  header:'银行账户'},\r\n");
      out.write("\t\t\t       {name:'accnumber',  header:'银行账号'},\r\n");
      out.write("\t\t\t       {name:'factobject',  header:'付款客户'},\r\n");
      out.write("\t\t\t       {name:'clientbank',  header:'客户银行'},\r\n");
      out.write("\t\t\t       {name:'clientaccount',  header:'客户账户'},\r\n");
      out.write("\t\t\t       {name:'clientaccnumber',  header:'客户帐号'},\r\n");
      out.write("\t\t\t       {name:'accountingdate',  header:'会计处理日'},\r\n");
      out.write("\t\t\t       {name:'invoiceno',  header:'单据号'},\r\n");
      out.write("\t\t\t       {name:'ffcmemo', header:'备注',type:'textarea'},\r\n");
      out.write("\t\t\t       {name:'creator',  header:'输入人'},\r\n");
      out.write("\t\t\t       {name:'createdate',  header:'输入日期'}\r\n");
      out.write("\t\t     ]\r\n");
      out.write("\t\t });\r\n");
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
