package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fbase_005finfo_005fforcredit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
  }

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
      out.write("    <input name=\"proj_info.custid\" id=\"proj_info.custid\" type=\"hidden\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custid'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.businesstype\" id=\"proj_info.businesstype\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.businesstype'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>");
      out.write("\r\n");
      out.write("     <input name=\"proj_info.businessmode\" id=\"proj_info.businessmode\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.businessmode'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input>");
      out.write("\r\n");
      out.write("    <input name=\"proj_info.startdate\" id=\"proj_info.startdate\" type=\"hidden\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.startdate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.enddate\" id=\"proj_info.enddate\" type=\"hidden\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.enddate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.projstatus\" id=\"proj_info.projstatus\" type=\"hidden\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projstatus'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.custdealer\" id=\"proj_info.custdealer\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custdealer'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.twolevelstatus\" id=\"proj_info.twolevelstatus\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.twolevelstatus'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"cust_info.dealername\" id=\"cust_info.dealername\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.dealername'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.deptid\" id=\"proj_info.deptid\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.deptid'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <input name=\"proj_info.loginusername\" id=\"proj_info.loginusername\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.loginusername']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("     <script type=\"text/javascript\">\r\n");
      out.write("     $(function(){\r\n");
      out.write("             if(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projdate']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"==\"\"){\r\n");
      out.write("             \t$(\"#id_projdate\").val(getCurDate());\r\n");
      out.write("             }else{\r\n");
      out.write("             \t$(\"#id_projdate\").val(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projdate']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("             }\r\n");
      out.write("    \t}\r\n");
      out.write("     );\r\n");
      out.write("             </script>\r\n");
      out.write("    <table cellspacing=\"0\" cellpadding=\"0\"  id=\"proj_base_info\">\r\n");
      out.write("\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-project-info\"></div>项目基本信息</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-project-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">项目编号：</td><td class=\"td-content\"><input name=\"proj_info.projid\" id =\"project_id\"  class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("             <td class=\"td-content-title\">项目日期：</td><td class=\"td-content\"><input id=\"id_projdate\" name=\"proj_info.projdate\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projdate']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" onClick=\"WdatePicker(this,{readOnly:true})\" readOnly require=\"true\" label=\"项目日期\" /><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-project-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">项目名称：</td><td class=\"td-content\" colspan=5><input style=\"width:50%\" readOnly name=\"proj_info.projectname\" id=\"project_name\"  require=\"true\" label=\"项目名称\" class=\"td-content-input\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.projectname']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  onclick=\"createProjectName();\" ><font class=\"required-content\" style=\"width:130px\">（系统自动生成）* </font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-project-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">客户编号：</td><td class=\"td-content\">\r\n");
      out.write("             <input name=\"proj_info.custnumber\" class=\"td-content-input td-content-readonly\" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custnumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("              <input name=\"proj_info.cust_type\" id=\"proj_info.cust_type\" class=\"td-content-input td-content-readonly\" readOnly  type=\"hidden\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("              <input name=\"proj_info.business_type\"  id=\"id_business_type\"   class=\"td-content-input td-content-readonly\" readOnly  type=\"hidden\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.business_type'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("             <font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">承租单位：</td><td class=\"td-content\"><input id=\"cust_name\" name=\"proj_info.custname\" class=\"td-content-input td-content-readonly\" readOnly require=\"true\" label=\"承租单位\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custname'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" >\r\n");
      out.write("              <font class=\"required-content\">*</font>\r\n");
      out.write("               <a href=\"javascript:void(0);\">\r\n");
      out.write("               <img alt=\"客户信息\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/department.png\" \r\n");
      out.write("               onclick=\"showEwlpCustInfo('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custid'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\"/></a>\r\n");
      out.write("              </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         ");
      out.write("\r\n");
      out.write("           <tr class=\"tr-project-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">活动类型：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_proj_type\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">历史交易记录：</td><td class=\"td-content\"><input name=\"proj_info.prohistory\" id =\"project_prohistory\"  class=\"td-content-input td-content-readonly\" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.prohistory']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("             \r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-project-info tr-odd\">  \r\n");
      out.write("             <td class=\"td-content-title\">项目来源：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_proj_source\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">是否第三方代付：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_cust_kind\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-project-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">资产分类：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_leas_type\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">租赁形式：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_leas_form\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>  \r\n");
      out.write("          <tr class=\"tr-project-info tr-odd\">   \r\n");
      out.write("             <td class=\"td-content-title\">项目出单部门：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_proj_dept\"></div></td>\r\n");
      out.write("             <td class=\"td-content-title\">录入人员：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_proj_registrar\"></div></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-project-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">项目经理：</td><td class=\"td-content\" colspan=\"3\">\r\n");
      out.write("             <div class=\"leftComboContainer\" id=\"id_proj_manage\"></div></td>\r\n");
      out.write("             ");
      out.write("\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table> \r\n");
      out.write("        <script language=\"javascript\">\r\n");
      out.write("        jQuery(\"#id_business_table\").hide();//不可见,不需要选择\r\n");
      out.write("\t\t    function showEwlpCustInfo(cust_id){\r\n");
      out.write("\t\t    \tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/cust_info/cust_info.bi\";\r\n");
      out.write("\t\t    \tvar params = {cust_id:cust_id,read_only:'false'};\r\n");
      out.write("\t\t\t    openFullScreenWindow(URL,params);\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    jQuery(\"#proj_base_info\").css(\"width\",formWidth+\"px\");\r\n");
      out.write("\t\t        jQuery(function(){\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \tjQuery(\"#id_loadMaskContainer\").show();\r\n");
      out.write("\t\t\t\t\t//(divContainerDivId,fieldName,code,defaultValue,defaultRawValue,otherAttributes,width,readOnlyData,islazyLoad)\r\n");
      out.write("\t\t\t        dict('id_proj_type','proj_info.projtype','proj_type','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.projtype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','非关联','require=\"true\" label=\"活动类型\"'); \r\n");
      out.write("\t\t\t        //dict('id_proj_scale','proj_info.projscale','proj_scale','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.projscale\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"项目规模\"');\r\n");
      out.write("\t\t\t        dict('id_proj_source','proj_info.projsource','proj_source','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.projsource\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"项目来源\"');\r\n");
      out.write("\t\t\t        dictYesOrNoByCode('id_cust_kind','proj_info.isthirdpay','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.isthirdpay\"] ? \"0\" : requestScope[\"proj_info.isthirdpay\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','',true,' require=\"true\" label=\"是否第三方代付\"');\r\n");
      out.write("\t\t\t        dict('id_leas_type','proj_info.leastype','leas_type','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.leastype\"] ? \"lease_type28\" : requestScope[\"proj_info.leastype\"] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"资产分类\"');\r\n");
      out.write("\t\t\t        dict('id_leas_form','proj_info.leasform','leas_form','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.leasform\"] ? \"lease_form2\" : requestScope[\"proj_info.leasform\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"租赁形式\"');\r\n");
      out.write("\t\t\t        //dict('id_businesstype','proj_info.businesstype','bussiness_type','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.businesstype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.businesstype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','',null,true);//,'require=\"true\" label=\"业务类型\"'\r\n");
      out.write("\t\t\t\t    //dict('id_businessmode','proj_info.businessmode','bussiness_mode','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.businessmode\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"proj_info.businessmode\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','',null,true);//,'require=\"true\" label=\"业务模式\"'\r\n");
      out.write("\t\t\t        \r\n");
      out.write("\t\t\t        new tracywindyComboBox({\r\n");
      out.write("\t\t\t\t\t\tlazyLoad:true,\r\n");
      out.write("\t\t\t\t\t\tid : 'id_combo_creatordept',\r\n");
      out.write("\t\t\t\t\t\twidth : 167,\r\n");
      out.write("\t\t\t\t\t\trenderTo : 'id_proj_dept',\r\n");
      out.write("\t\t\t\t\t\txmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\department_combox.xml',\r\n");
      out.write("\t\t\t\t\t\tloadMode : 'ajax',\r\n");
      out.write("\t\t\t\t\t\treadOnly : false,\r\n");
      out.write("\t\t\t\t\t\tisAjaxLenovo : true,\r\n");
      out.write("\t\t\t\t\t\totherAttributes:'require=\"true\"  label=\"项目出单部门\"',\r\n");
      out.write("\t\t\t\t\t\ttopAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tleftAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t\t\t\t\t\tname : 'proj_info.projdept',\r\n");
      out.write("\t\t\t\t\t\tdisplayField : 'name',\r\n");
      out.write("\t\t\t\t\t\tvalueField : 'id',\r\n");
      out.write("\t\t\t\t\t\tvalue:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope['proj_info.projdept'] ? sessionScope['loginUserDeptObj'].id : requestScope['proj_info.projdept'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t\t\t\t\t\trawValue:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope['proj_info.projdept'] ? sessionScope['loginUserDeptObj'].name : requestScope['rawValue_proj_info.projdept'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t\t\t\t\t\tparams : {\r\n");
      out.write("\t\t\t\t\t\t\tdealer_id:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['currentDealerCustInfoId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t        new tracywindyComboBox({\r\n");
      out.write("\t\t\t\t\t\tlazyLoad:true,\r\n");
      out.write("\t\t\t\t\t\tid : 'id_combo_registrar',\r\n");
      out.write("\t\t\t\t\t\twidth : 167,\r\n");
      out.write("\t\t\t\t\t\trenderTo : 'id_proj_registrar',\r\n");
      out.write("\t\t\t\t\t\txmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\creator_combox.xml',\r\n");
      out.write("\t\t\t\t\t\tloadMode : 'ajax',\r\n");
      out.write("\t\t\t\t\t\treadOnly : false,\r\n");
      out.write("\t\t\t\t\t\tisAjaxLenovo : true,\r\n");
      out.write("\t\t\t\t\t\totherAttributes:'require=\"true\"  label=\"录入人员\"',\r\n");
      out.write("\t\t\t\t\t\ttopAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tleftAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t\t\t\t\t\tname : 'proj_info.projregistrar',\r\n");
      out.write("\t\t\t\t\t\tdisplayField : 'name',\r\n");
      out.write("\t\t\t\t\t\tvalueField : 'id',\r\n");
      out.write("\t\t\t\t\t\tvalue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projregistrar\"] ? sessionScope.loginUser.id : requestScope[\"proj_info.projregistrar\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\t\trawValue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projregistrar\"] ? sessionScope.loginUser.realname : requestScope[\"proj_info.projregistrar\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\t\tparams : {\r\n");
      out.write("\t\t\t\t\t\t\tdealer_id:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['currentDealerCustInfoId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t        new tracywindyComboBox({\r\n");
      out.write("\t\t\t\t\t\tlazyLoad:true,\r\n");
      out.write("\t\t\t\t\t\tid : 'id_combo_proj_manage',\r\n");
      out.write("\t\t\t\t\t\twidth : 167,\r\n");
      out.write("\t\t\t\t\t\trenderTo : 'id_proj_manage',\r\n");
      out.write("\t\t\t\t\t\txmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\creator_project_manager.xml',\r\n");
      out.write("\t\t\t\t\t\tloadMode : 'ajax',\r\n");
      out.write("\t\t\t\t\t\treadOnly : false,\r\n");
      out.write("\t\t\t\t\t\tisAjaxLenovo : true,\r\n");
      out.write("\t\t\t\t\t\totherAttributes:'require=\"true\"  label=\"项目经理\"',\r\n");
      out.write("\t\t\t\t\t\ttopAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tleftAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t\t\t\t\t\tname : 'proj_info.projmanage',\r\n");
      out.write("\t\t\t\t\t\tdisplayField : 'name',\r\n");
      out.write("\t\t\t\t\t\tvalueField : 'id',\r\n");
      out.write("\t\t\t\t\t\tvalue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projmanage\"] ? sessionScope.loginUser.id : requestScope[\"proj_info.projmanage\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\t\trawValue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projmanage\"] ? sessionScope.loginUser.realname : requestScope[\"proj_info.projmanage\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\t\tparams : {\r\n");
      out.write("\t\t\t\t\t\t\tdealer_id:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['currentDealerCustInfoId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t        /*\r\n");
      out.write("\t\t\t        new tracywindyComboBox({\r\n");
      out.write("\t\t\t\t\t\tlazyLoad:true,\r\n");
      out.write("\t\t\t\t\t\tid : 'id_combo_proj_assist',\r\n");
      out.write("\t\t\t\t\t\twidth : 167,\r\n");
      out.write("\t\t\t\t\t\trenderTo : 'id_proj_assist',\r\n");
      out.write("\t\t\t\t\t\txmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\creator_combox.xml',\r\n");
      out.write("\t\t\t\t\t\tloadMode : 'ajax',\r\n");
      out.write("\t\t\t\t\t\treadOnly : false,\r\n");
      out.write("\t\t\t\t\t\tisAjaxLenovo : true,\r\n");
      out.write("\t\t\t\t\t\totherAttributes:'require=\"true\"  label=\"客户经理\"',\r\n");
      out.write("\t\t\t\t\t\ttopAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tleftAdd : 0,\r\n");
      out.write("\t\t\t\t\t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t\t\t\t\t\tname : 'proj_info.projassist',\r\n");
      out.write("\t\t\t\t\t\tdisplayField : 'name',\r\n");
      out.write("\t\t\t\t\t\tvalueField : 'id',\r\n");
      out.write("\t\t\t\t\t\tvalue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projassist\"] ? sessionScope.loginUser.id : requestScope[\"proj_info.projassist\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\t\trawValue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope[\"proj_info.projassist\"] ? sessionScope.loginUser.realname : requestScope[\"proj_info.projassist\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\t\tparams : {\r\n");
      out.write("\t\t\t\t\t\t\tdealer_id:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['currentDealerCustInfoId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});*/\r\n");
      out.write("\t\t\t       jQuery(\"#id_loadMaskContainer\").hide();\r\n");
      out.write("\t\t\t   });\r\n");
      out.write("\r\n");
      out.write("       </script>\r\n");
      out.write("          <!-- 插入法人客户 -->\r\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.cust_type']=='法人' ?'proj_law_cust_info.jsp':'proj_cust_info.jsp'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false), out, false);
      out.write("\r\n");
      out.write("\t\t \r\n");
      out.write("\t    ");
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
