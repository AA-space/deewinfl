package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fguarantee_005fmethod_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("   \r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("    var currentIsNeedTools = true;\r\n");
      out.write("    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("    \tcurrentIsNeedTools = false;\r\n");
      out.write("    }\r\n");
      out.write("\tnew tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_contract_guarantee_method_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:250,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    tools:'新增|修改|删除',\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_guarantee_method_str ? \"[]\" : json_contract_guarantee_method_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'uuid',hidden:true},\r\n");
      out.write("\t       {name:'assurorname', header:'担保单位',renderer:showCustName,nullable:false,type:'combobox',hiddenName:'assuror',splitname:'-[',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t    \t   width:165,\r\n");
      out.write("\t\t       xmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\SimpleCustSelect.xml',\r\n");
      out.write("\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t       readOnly:false,\r\n");
      out.write("\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t       displayField:'allname',\r\n");
      out.write("\t\t       valueField:'id',\r\n");
      out.write("\t\t       params:{\r\n");
      out.write("\t\t    \t    cust_class_m:\"1\",\r\n");
      out.write("\t\t   \t\t\tcust_class1:'CUST_INFO_COMPANY',\r\n");
      out.write("\t\t   \t\t\tcust_class2:'CUST_INFO_PERSON',\r\n");
      out.write("\t\t  \t\t\tcust_type:'cust_type.assuror',\r\n");
      out.write("\t\t  \t\t\tcust_dealer_id:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['currentDealerCustInfoId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t\t   }},\r\n");
      out.write("\t\t   {name:'assuror', header:'担保单位id',hidden:true},\r\n");
      out.write("\t       {name:'assuremethodname', header:'担保类型',nullable:false,type:'combobox',mapping:'assuremethodname',hiddenName:'assuremethod',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t       /*init:function(combo,currentTable,multiTable){\r\n");
      out.write("\t\t               },\r\n");
      out.write("\t\t\t\t       onSelected:function(multiTable,columnConfig){\r\n");
      out.write("\t\t               },*/\r\n");
      out.write("\t\t\t\t       params:{\r\n");
      out.write("\t\t\t\t          pid:'assure_method'\r\n");
      out.write("\t\t\t\t       } \r\n");
      out.write("\t\t   }},\r\n");
      out.write("\t\t   {name:'assuremethod', header:'担保类型id',hidden:true},\r\n");
      out.write("\t       {name:'assurerelationname',  header:'关系',nullable:false,type:'combobox',mapping:'assurerelationname',hiddenName:'assurerelation',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t       width:165,\r\n");
      out.write("\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t\t\t          pid:'relation'\r\n");
      out.write("\t\t\t       } \r\n");
      out.write("   \t\t\t}},\r\n");
      out.write("   \t\t\t{name:'assurerelation', header:'关系id',hidden:true},\r\n");
      out.write("\t       {name:'cgmnote',  header:'备注',type:'textarea'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("});\r\n");
      out.write("function showCustName(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("    var base = \"<a href='javascript:void(0);' onclick='showEwlpCustInfoaAssuror(\\\"\"+rowData.assuror+\"\\\")'>{1}</a>{2}\";\r\n");
      out.write("    var separator = \"&nbsp;&nbsp;\";\r\n");
      out.write("    var updateFlag=value;\r\n");
      out.write("    var updateClickFunc=\"other\";\r\n");
      out.write("    var field=base.replace(\"{1}\",updateFlag).replace(\"{2}\",separator);\r\n");
      out.write("    return field;\r\n");
      out.write("  }\r\n");
      out.write("function showEwlpCustInfoaAssuror(cust_id){\r\n");
      out.write(" \tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/cust_info/cust_info.bi\";\r\n");
      out.write(" \tvar params = {cust_id:cust_id,read_only:false};\r\n");
      out.write("\t    openFullScreenWindow(URL,params);\r\n");
      out.write("     //window.open(getRootPath()+\"/leasing/law_cust/show_template.bi?cust_id=\"+cust_id+\"&jsp=law_cust_all_info\",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');\r\n");
      out.write(" }\r\n");
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
