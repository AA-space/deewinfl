package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fsignatory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--合同各方信息 -->\r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-lessor-info\"></div>出租方基本信息(甲方)</td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("\t <tr class=\"tr-lessor-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">出租人：</td><td class=\"td-content\"><input require=\"true\" label=\"出租人\" name=\"contract_signatory.lessor\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.lessor']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">委托代理人：</td><td class=\"td-content\"><input require=\"true\" label=\"委托代理人\" name=\"contract_signatory.leaseconsigner\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseconsigner']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-lessor-info tr-odd\">\r\n");
      out.write("\t    <td class=\"td-content-title\">注册地址：</td><td class=\"td-content\"><input require=\"true\" label=\"注册地址\" name=\"contract_signatory.leaseregisteraddr\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseregisteraddr']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">通讯地址：</td><td class=\"td-content\"><input require=\"true\" label=\"通讯地址\" name=\"contract_signatory.leaseaddr\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseaddr']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-lessor-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">法定代表人：</td><td class=\"td-content\"><input require=\"true\" label=\"法定代表人\" name=\"contract_signatory.leaseperson\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseperson']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">邮编：</td><td class=\"td-content\"><input require=\"true\" label=\"邮编\" name=\"contract_signatory.leasepostcode\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leasepostcode']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-lessor-info tr-odd\">\r\n");
      out.write("\t    <td class=\"td-content-title\">联系人：</td><td class=\"td-content\"><input require=\"true\" label=\"联系人\" name=\"contract_signatory.leaselinkman\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaselinkman']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">电话：</td><td class=\"td-content\"><input require=\"true\" label=\"电话\" name=\"contract_signatory.leasetel\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leasetel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-lessor-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">传真：</td><td class=\"td-content\"><input label=\"传真\" name=\"contract_signatory.leasefax\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leasefax']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">电子邮件：</td><td class=\"td-content\"><input label=\"电子邮件\" name=\"contract_signatory.leaseemail\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseemail']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-lessor-info tr-odd\">\r\n");
      out.write("\t    <td class=\"td-content-title\">开户账号：</td><td class=\"td-content\"><input require=\"true\" label=\"开户账号\" name=\"contract_signatory.leaseaccnumber\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseaccnumber']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">开户银行：</td><td class=\"td-content\"><input require=\"true\" label=\"开户银行\" name=\"contract_signatory.leaseaccbank\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseaccbank']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-lessor-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">开户户名：</td><td class=\"td-content\"><input require=\"true\" label=\"开户户名\" name=\"contract_signatory.leaseaccname\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.leaseaccname']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\"></td><td class=\"td-content\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-client-info\"></div>承租方基本信息(乙方)</td>\r\n");
      out.write("\t </tr>\r\n");
      out.write("\t <tr class=\"tr-client-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">承租人：</td><td class=\"td-content\"><input require=\"true\" label=\"承租人\" name=\"contract_signatory.client\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.client']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">委托代理人：</td><td class=\"td-content\"><input require=\"true\" label=\"委托代理人\" name=\"contract_signatory.clientconsigner\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientconsigner']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-client-info tr-odd\">\r\n");
      out.write("\t    <td class=\"td-content-title\">通讯地址：</td><td class=\"td-content\"><input require=\"true\" label=\"通讯地址\" name=\"contract_signatory.clientaddress\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientaddress']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">邮编：</td><td class=\"td-content\"><input require=\"true\" label=\"邮编\" name=\"contract_signatory.clientpostcode\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientpostcode']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-client-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">法定代表人：</td><td class=\"td-content\"><input require=\"true\" label=\"法定代表人\" name=\"contract_signatory.clientperson\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientperson']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">联系人：</td><td class=\"td-content\"><input require=\"true\" label=\"联系人\" name=\"contract_signatory.clientlinkman\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientlinkman']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-client-info tr-odd\">\r\n");
      out.write("\t    <td class=\"td-content-title\">电话：</td><td class=\"td-content\"><input require=\"true\" label=\"电话\" name=\"contract_signatory.clienttel\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clienttel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">传真：</td><td class=\"td-content\"><input  label=\"传真\" name=\"contract_signatory.clientfax\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientfax']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-client-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">短信联系手机号：</td><td class=\"td-content\"><input require=\"true\" label=\"短信联系手机号\" name=\"contract_signatory.clientmobilenumber\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientmobilenumber']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">电子邮件：</td><td class=\"td-content\"><input  label=\"电子邮件\" name=\"contract_signatory.clientemail\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientemail']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-client-info tr-odd\">\r\n");
      out.write("\t    <td class=\"td-content-title\">开户账号：</td><td class=\"td-content\"><input  label=\"开户账号\"  id =\"clientaccnumber\" maxlength=\"19\" name=\"contract_signatory.clientaccnumber\" class=\"td-content-input\" dataType=\"Number\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientaccnumber']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">开户银行：</td><td class=\"td-content\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <div id=\"id_bankname\" ></div></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-client-info tr-even\">\r\n");
      out.write("\t    <td class=\"td-content-title\">开户户名：</td><td class=\"td-content\"><input  label=\"开户户名\" name=\"contract_signatory.clientaccname\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_signatory.clientaccname']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t    <td class=\"td-content-title\">是否卡扣：</td><td class=\"td-content\"><div style=\"float: left\" class=\"leftComboContainer\" id=\"iscardname\"></div></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t    <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-supplier-info\"></div>卖方/供应商</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-supplier-info tr-even\">\r\n");
      out.write("\t    <td colspan=4><div id=\"id_table_leasing_contract_supplier_container\" style=\"overflow: hidden;\"></div></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tdictYesOrNoByCode('iscardname','contract_signatory.iscard','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"contract_signatory.iscard\"] ? \"1\" : requestScope[\"contract_signatory.iscard\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,null,'require=\"true\" label=\"是否卡扣\"');//是否卡扣\r\n");
      out.write("\tdictOnSelect('id_bankname','contract_signatory.clientaccbank','card_hire_bank','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"contract_signatory.clientaccbank\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'label=\"开户银行\"',true,null, true);\r\n");
      out.write("\t\r\n");
      out.write("\t\tif(!isSubTable){\r\n");
      out.write("\t\t    var currentIsNeedTools = true;\r\n");
      out.write("\t\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    new tracywindyMultiTable({\r\n");
      out.write("\t\t    renderTo:'id_table_leasing_contract_supplier_container',\r\n");
      out.write("\t\t    width:formWidth,\r\n");
      out.write("\t\t    height:350,\r\n");
      out.write("\t\t    tools:'新增|修改|删除',\r\n");
      out.write("\t\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t\t    isFit:true,\r\n");
      out.write("\t\t    displayToggleContainer:document.getElementById('id_table_leasing_contract_signatory_container').parentNode.parentNode,\r\n");
      out.write("\t\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_supplier_str ? \"[]\" : json_contract_supplier_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t\t    columns:[\r\n");
      out.write("\t\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t       {name:'seller',  header:'供应商'},\r\n");
      out.write("\t\t       {name:'sellerlegalperson',  header:'法定代表人'},\r\n");
      out.write("\t\t       {name:'sellerlinkman',  header:'联系人'},\r\n");
      out.write("\t\t       {name:'sellerregisteraddr',  header:'注册地址'},\r\n");
      out.write("\t\t       {name:'selleraddr',  header:'通讯地址'},\r\n");
      out.write("\t\t       {name:'sellerpostcode',  header:'邮政编码'},\r\n");
      out.write("\t\t       {name:'sellertel',  header:'电话'},\r\n");
      out.write("\t\t       {name:'sellerfax',  header:'传真'},\r\n");
      out.write("\t\t       {name:'selleraccnumber',  header:'开户账号'},\r\n");
      out.write("\t\t       {name:'selleraccbank',  header:'开户银行'},\r\n");
      out.write("\t\t       {name:'selleraccname',  header:'开户户名'}\r\n");
      out.write("\t\t     ]\r\n");
      out.write("\t\t \t});\r\n");
      out.write("\t\t}\r\n");
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
