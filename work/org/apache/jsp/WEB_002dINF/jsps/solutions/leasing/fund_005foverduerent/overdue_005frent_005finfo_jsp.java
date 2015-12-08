package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.fund_005foverduerent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class overdue_005frent_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(5);
    _jspx_dependants.add("/base/mini.jsp");
    _jspx_dependants.add("/base/base.jsp");
    _jspx_dependants.add("/base/var.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody != null) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>租赁业务  - 租金催收</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f0(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f1(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f2(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script type=\"text/javascript\">var globalTimestamp = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";var globalLocale = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocale}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";var globalSkin = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";var globalClientWidth = document.documentElement.clientWidth;var globalClientHeight = document.documentElement.clientHeight;var globalWebRoot = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";</script>");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/seajs/sea.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">seajs.config({vars: { currentLocale: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocale}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',currentSkin:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'},base: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/',map: [[ /^(.*\\.(?:css|js))(.*)$/i, '$1?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' ]],charset: 'UTF-8'});</script>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/base/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/base.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('/');
      out.write('>');
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/miniui/miniui.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/miniui/locale/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocale}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(".js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/miniui/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/miniui.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/miniui/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icons.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/miniui/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('/');
      out.write('>');
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function importEbankCallBack(message){\r\n");
      out.write("        alert(message);\r\n");
      out.write("    \twindow.currentImportExcelLoadMask.hide();\r\n");
      out.write("    \tvar table = getTracywindyObject(\"id_table\");\r\n");
      out.write("    \ttable.reload();\r\n");
      out.write("    }\r\n");
      out.write("    var constantFlagTable = \"User\";\r\n");
      out.write("    var ebankUploadUrl=\"\";\r\n");
      out.write("    var ebankAttachUrl=\"\";\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\t//alert(\"==\");\r\n");
      out.write("\t\t //  var editWindow = mini.get(\"id_riskInfoWindowContainer\");\r\n");
      out.write("\t\tseajs.use(\"js/apcomponent/aptable/aptable.js\",function(ApTable){\r\n");
      out.write("\t\t\tnew ApTable({\r\n");
      out.write("\t\t\t\t      renderTo:'id_tableContainer',\r\n");
      out.write("\t\t\t\t      title:'租金催收',\r\n");
      out.write("             width:window.formWidth||parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("             height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("               id:'id_table',\r\n");
      out.write("                   pageSize:20,\r\n");
      out.write("                   windowTop:20,\r\n");
      out.write("\t\t\t\t    showPager:true, \r\n");
      out.write("\t\t\t\t  showFooter:false,\r\n");
      out.write("\t\t\t\t    showToolbar:false,\r\n");
      out.write("\t\t\t\t    hiddenQueryArea : false,\r\n");
      out.write("\t\t\t\t    //editFormPopupWindowWidth:580,\r\n");
      out.write("\t\t\t\t   // lockedNames:['custname'],\r\n");
      out.write("\t\t\t\t    xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_info.xml',\r\n");
      out.write("\t\t\t\t\t//multiSelect : true,//是否可以多选，true多选，false为单选,\r\n");
      out.write("\t\t\t\t     columns:[\r\n");
      out.write("                 /* {type:'indexcolumn'}, */\r\n");
      out.write("                  {type:'checkcolumn'},\r\n");
      out.write("                  {header:'id',field:'id',visible:false},\r\n");
      out.write("\t\t            {header:'客户名称',field:'custname',\r\n");
      out.write("                \t  renderer:showOverdueName,\r\n");
      out.write("                \t  width:180,queryConfig:{\r\n");
      out.write("                \t\t  width:150\r\n");
      out.write("                \t  }},\r\n");
      out.write("\t\t            {header:'合同号',field:'contractid'},\r\n");
      out.write("\t\t            {header:'合同状态',field:'contractstatusname'},\r\n");
      out.write("\t\t            {header:'催款员',field:'dun'},\r\n");
      out.write("\t\t            {header:'事业部',field:'projdeptname'},\r\n");
      out.write("\t\t            {header:'省份',field:'provincename'},\r\n");
      out.write("\t\t            {header:'身份证/组织机构代码',field:'idcardorcode',width:140},\r\n");
      out.write("\t\t            {header:'经销商',field:'dealername',width:200,queryConfig:{\r\n");
      out.write("\t\t            \twidth:150\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t            //{header:'项目经理',name:'projmanagename',width:200},\r\n");
      out.write("\t\t            {header:'逾期期数',field:'overnum-'},\r\n");
      out.write("\t\t            {header:'逾期租金',field:'overrent',\r\n");
      out.write("\t\t            \tqueryConfig:{\r\n");
      out.write("\t\t            \t\ttype:\"float\",\r\n");
      out.write("\t\t            \t\trange:true,\r\n");
      out.write("\t\t            \t\twidth:150\r\n");
      out.write("\t\t            \t}},\r\n");
      out.write("\t\t            {header:'逾期利息',field:'overinterest'},\r\n");
      out.write("\t\t            {header:'逾期罚息',field:'penalty-'},\r\n");
      out.write("\t\t            {header:'逾期天数',field:'column14-'},\r\n");
      out.write("\t\t            //{header:'累计逾期数',name:'column16'},\r\n");
      out.write("\t\t            {header:'留购价款',field:'nominalprice'},\r\n");
      out.write("\t\t            {header:'总期数',field:'incomenumber'},\r\n");
      out.write("\t\t            {header:'联系方式',field:'liaisonwayname'},\r\n");
      out.write("\t\t            {header:'起租日',field:'startdate',queryConfig:{\r\n");
      out.write("\t\t            \ttype:'date',\r\n");
      out.write("\t\t            \tvtype:'date',\r\n");
      out.write("\t\t            \trange:true,\r\n");
      out.write("\t\t            \tnewLine:true,\r\n");
      out.write("\t\t            \twidth:150,\r\n");
      out.write("\t\t            \tformat:'yyyy-MM-dd'\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t            {header:'本金余额/剩余还款期数',field:'corpusorresiduenum'},\r\n");
      out.write("\t\t            {header:'下一次联系日',field:'nextliaisondate'},\r\n");
      out.write("\t\t            {header:'最近一次付款金额/时间',field:'rentordate',width:170},\r\n");
      out.write("\t\t            {header:'催收日',field:'liaisondate'},\r\n");
      out.write("\t\t            {header:'承诺还款日',field:'paydate',queryConfig:{\r\n");
      out.write("\t\t            \ttype:'date',\r\n");
      out.write("\t\t            \tvtype:'date',\r\n");
      out.write("\t\t            \trange:true,\r\n");
      out.write("\t\t            \t\r\n");
      out.write("\t\t            \twidth:150,\r\n");
      out.write("\t\t            \tformat:'yyyy-MM-dd'\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t            {header:'承诺还款金额',field:'paymoney'},\r\n");
      out.write("\t\t            {header:'担保人',field:'assurors'},\r\n");
      out.write("\t\t            {header:'担保人联系方式',field:'assurorsnum'},\r\n");
      out.write("\t\t            {header:'承租人邮寄地址',field:'mailadd',width:140},\r\n");
      out.write("\t\t            {header:'逾期天数',field:'overduedate',queryConfig:{\r\n");
      out.write("\t\t            \ttype:'number',\r\n");
      out.write("\t\t            \tvtype:'int',\r\n");
      out.write("\t\t            \twidth:150,\r\n");
      out.write("\t\t            \tnewLine:true,\r\n");
      out.write("\t\t            \t//minValue:1,\r\n");
      out.write("\t\t            \tmaxValue:1000,\r\n");
      out.write("\t\t            \trange:true\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t            {header:'台数',field:'equipcount',queryConfig:{\r\n");
      out.write("\t\t            \ttype:'number',\r\n");
      out.write("\t\t            \tvtype:'int',\r\n");
      out.write("\t\t            \twidth:150,\r\n");
      out.write("\t\t            \t//newLine:true,\r\n");
      out.write("\t\t            \t//minValue:1,\r\n");
      out.write("\t\t            \tmaxValue:1000,\r\n");
      out.write("\t\t            \trange:true\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t            {header:'风险级别',field:'overduetypename',width:140,queryConfig:{\r\n");
      out.write("\t\t            \ttype:'combobox',\r\n");
      out.write("\t\t            \twidth:150,\r\n");
      out.write("\t\t            \t//colspan:1,\r\n");
      out.write("\t\t            \t//rowspan:2,\r\n");
      out.write("\t\t            \t//dataField:\"datas\",\r\n");
      out.write("\t\t            \tvalueField:\"name\" ,\r\n");
      out.write("\t\t            \ttextField:\"name\" ,\r\n");
      out.write("\t\t            \tnewLine:true,\r\n");
      out.write("\t\t            \tparams:{\r\n");
      out.write("\t\t            \t\txmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t            \t\tpid:'contract_risk_adjust_type'\r\n");
      out.write("\t\t            \t}\r\n");
      out.write("\t\t            }}\r\n");
      out.write("                  \r\n");
      out.write("\t\t  \t\t   ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("function showOverdueName(e){\r\n");
      out.write("    \t  var rowData=e.record; \r\n");
      out.write("    \t\r\n");
      out.write("    \t  var base = \"<a href='#' onclick=showoverdueInfo('\"+rowData.custid+\"','\"+rowData.contractid+\"')>{1}</a>{2}\";\r\n");
      out.write("    \t  var separator = \"&nbsp;&nbsp;\";\r\n");
      out.write("          var updateFlag=rowData.custname;\r\n");
      out.write("          var updateClickFunc=\"other\";\r\n");
      out.write("          var field=base.replace(\"{1}\",updateFlag).replace(\"{2}\",separator);\r\n");
      out.write("         // alert(field);\r\n");
      out.write("          return field;\r\n");
      out.write("      };\r\n");
      out.write("\t    \r\n");
      out.write("   // \tcommonSelectOverall('id_select_contract_id',\"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs\",'value',\"contract_id\",'contractid','','','',selectContract,false);\r\n");
      out.write("  //   \tdictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require=\"true\" label=\"是否投保\"');\r\n");
      out.write("  // });\r\n");
      out.write("\t function showoverdueInfo(custid,contractid){\r\n");
      out.write("\t    \tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/fund_overduerent/show_template.bi\";\r\n");
      out.write("\t    \tvar params = {cust_id:custid,contract_id:contractid,jsp:\"overdue_rent_detail_info\"};\r\n");
      out.write("\t\t    openFullScreenWindow(URL,params);\r\n");
      out.write("\t        //window.open(getRootPath()+\"/leasing/law_cust/show_template.bi?cust_id=\"+cust_id+\"&jsp=law_cust_all_info\",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');\r\n");
      out.write("\t    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_sc_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f0.setParent(null);
    // /base/var.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f0.setVar("currentTimestamp");
    // /base/var.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f0.setValue(new String("20140420"));
    int _jspx_eval_sc_005fset_005f0 = _jspx_th_sc_005fset_005f0.doStartTag();
    if (_jspx_th_sc_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_sc_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f1.setParent(null);
    // /base/var.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f1.setVar("currentLocale");
    // /base/var.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f1.setValue(new String("zh_CN"));
    int _jspx_eval_sc_005fset_005f1 = _jspx_th_sc_005fset_005f1.doStartTag();
    if (_jspx_th_sc_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_sc_005fset_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f2.setParent(null);
    // /base/var.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f2.setVar("currentSkin");
    // /base/var.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f2.setValue(new String("tenwa"));
    int _jspx_eval_sc_005fset_005f2 = _jspx_th_sc_005fset_005f2.doStartTag();
    if (_jspx_th_sc_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_sc_005fset_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f3.setParent(null);
    // /base/var.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f3.setVar("ctx");
    // /base/var.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_sc_005fset_005f3 = _jspx_th_sc_005fset_005f3.doStartTag();
    if (_jspx_th_sc_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f3);
    return false;
  }
}
