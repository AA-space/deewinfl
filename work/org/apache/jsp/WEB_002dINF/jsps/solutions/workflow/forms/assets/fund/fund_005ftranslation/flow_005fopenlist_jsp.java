package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005ftranslation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class flow_005fopenlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>收款</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/dtree/dtree.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/easyui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/button.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/workFlowUtil.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<!--javascript libray-->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyJsonUtil.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyComboBox.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindySerializeFormToJsonObject.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/validator.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("//var proj_id=\"");
      out.print( request.getParameter("id"));
      out.write("\";\r\n");
      out.write("var param={};\r\n");
      out.write("//if(proj_id!=\"null\" || proj_id==\"\"){param.proj_id=proj_id;}\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\tvar attachmentParams;\r\n");
      out.write("\t\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t var table = new tracywindyOperationTable({\r\n");
      out.write("\t\t tableComment:'[项目信息]',\r\n");
      out.write("\t\t constantFlagTable:'ProjInfo',\r\n");
      out.write("\t\t windowTop:20,\r\n");
      out.write("\t     border:true,\r\n");
      out.write("\t     renderTo:'id_ebank',\r\n");
      out.write("      title:'项目信息',\r\n");
      out.write("      width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("      height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("      id:'id_table',\r\n");
      out.write("      xmlFileName:'/eleasing/jsp/fund_ebank/fund_ebank_info.xml',\r\n");
      out.write("      loadMode:'ajax',\r\n");
      out.write("      params:{\r\n");
      out.write("\t\t\t\tuser_id:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t        enabled:0,\r\n");
      out.write("\t\t      \tkehu:'1',\r\n");
      out.write("\t\t\t\towmoneythanzero:'0'\r\n");
      out.write("\t\t\t//cust_id : cust_id\r\n");
      out.write("\t\t\t//parentid:'ProductType'\r\n");
      out.write("\t\t\t},\r\n");
      out.write("      isPage:true,\r\n");
      out.write("      operButtons:' ',\r\n");
      out.write("      isFit:true,\r\n");
      out.write("      tools:[{\r\n");
      out.write("     \t html : '<font color=\"red\">收款</font>',\r\n");
      out.write("\t\t handler : function(table) {\r\n");
      out.write("\t\t\t\tvar projIDValue = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == projIDValue.length) {\r\n");
      out.write("\t\t\t\t\talert(\"请选择需要启动的流程！\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar cur_depid=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['loginUserDeptObj'].id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"; \r\n");
      out.write("\t\t\t\tattachmentParams = attachmentParams + \"&ebank_id=\" +projIDValue[0].id +\"&cur_depid=\"+cur_depid+\"&dealer=\"+projIDValue[0].custname;\r\n");
      out.write("\t\t\t\tstartProcess(\"经销商租金回笼-1\",attachmentParams);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls :'icon-update'\r\n");
      out.write("          }],\r\n");
      out.write("          columns:[\r\n");
      out.write("                   {header:'id',name:'id',hidden:true},\r\n");
      out.write("                   {header:'custdealerid',name:'custdealerid',hidden:true},\r\n");
      out.write("\t\t            {header:'网银编号',name:'ebdataid',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'经销商',name:'custname',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'付款人',name:'clientname',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'本方银行',name:'ownbank',hidden:true},\r\n");
      out.write("\t\t            {header:'本方账户',name:'ownaccount',hidden:true},\r\n");
      out.write("\t\t            {header:'本方账号',name:'ownaccnumber',hidden:true},\r\n");
      out.write("\t\t            {header:'对方银行',name:'clientbank',hidden:true},\r\n");
      out.write("\t\t            {header:'对方账户',name:'clientaccount',hidden:true},\r\n");
      out.write("\t\t            {header:'对方账号',name:'clientaccnumber',hidden:true},\r\n");
      out.write("\t\t            {header:'到账金额类型',name:'moneytype',hidden:true},\r\n");
      out.write("\t\t            {header:'到账金额',name:'factmoney',queryConfig:{isNewLine:true}},\r\n");
      out.write("\t\t            //{header:'与系统无关金额',name:'nowithmoney'},\r\n");
      out.write("\t\t            {header:'已核销金额',name:'hiremoney'},\r\n");
      out.write("\t\t            {header:'可核销金额',name:'owmoney'},\r\n");
      out.write("\t\t            {header:'到账时间',name:'factdate',type:\"date\",isRange:true,queryConfig:{}},\r\n");
      out.write("\t\t            {header:'流水号',name:'sn',queryConfig:{isNewLine:true}},\r\n");
      out.write("\t\t            {header:'备注',name:'summary'},//,hidden:true\r\n");
      out.write("\t\t            {header:'用途',name:'usefor'}\r\n");
      out.write("\t\t            //{header:'登记人',name:'creator_name'},\r\n");
      out.write("\t\t            //{header:'登记时间',name:'create_date'}\r\n");
      out.write("\t        ]\r\n");
      out.write("\t });\r\n");
      out.write("});\r\n");
      out.write("\t/*\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t   \t new tracywindyOperationTable({\r\n");
      out.write("\t         displayToggleContainer:'ebank',\r\n");
      out.write("\t   \t\t tableComment:'[网银信息]',\r\n");
      out.write("\t   \t\t constantFlagTable:'fundebank',\r\n");
      out.write("\t   \t\t windowTop:20,\r\n");
      out.write("\t   \t     border:true,\r\n");
      out.write("\t         renderTo:'id_ebank',\r\n");
      out.write("\t         //title:'网银信息',\r\n");
      out.write("\t         width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("     \t\t height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("\t         id:'table_ebank',\r\n");
      out.write("\t        \r\n");
      out.write("\t         loadMode:'ajax',\r\n");
      out.write("\t         isPage:true,\r\n");
      out.write("\t         operButtons:' ',\r\n");
      out.write("\t         isFit:true,\r\n");
      out.write("\t         operButtons:' ',\r\n");
      out.write("\t         //params : param_,\r\n");
      out.write("\t         tools:[{\r\n");
      out.write("\t         \t html : '<font color=\"red\">收款</font>',\r\n");
      out.write("\t \t\t\thandler : function(table) {\r\n");
      out.write("\t \t\t\t\tvar projIDValue = table.getCheckedRowDatas();\r\n");
      out.write("\t \t\t\t\tif (0 == projIDValue.length) {\r\n");
      out.write("\t \t\t\t\t\talert(\"请选择需要的网银\");\r\n");
      out.write("\t \t\t\t\t\treturn false;\r\n");
      out.write("\t \t\t\t\t}\r\n");
      out.write("\t \t\t\t\t\r\n");
      out.write("\t \t\t\t\tattachmentParams = attachmentParams + \"&ebank_id=\" +projIDValue[0].id ;\r\n");
      out.write("\t\t \t\t\tstartProcess(\"收款流程-1\",attachmentParams);\r\n");
      out.write("\t \r\n");
      out.write("\t \t\t\t},\r\n");
      out.write("\t \t\t\ticonCls :'icon-update'\r\n");
      out.write("\t           }],\r\n");
      out.write("\t         isFit:false,\r\n");
      out.write("\t         columns:[\r\n");
      out.write("\t                    {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t                    {header:'custdealerid',name:'custdealerid',hidden:true},\r\n");
      out.write("\t\t\t            {header:'网银编号',name:'ebdataid'},\r\n");
      out.write("\t\t\t            {header:'经销商',name:'custname'},\r\n");
      out.write("\t\t\t            {header:'付款人',name:'clientname'},\r\n");
      out.write("\t\t\t            {header:'本方银行',name:'ownbank',hidden:true},\r\n");
      out.write("\t\t\t            {header:'本方账户',name:'ownaccount',hidden:true},\r\n");
      out.write("\t\t\t            {header:'本方账号',name:'ownaccnumber',hidden:true},\r\n");
      out.write("\t\t\t            {header:'对方银行',name:'clientbank',hidden:true},\r\n");
      out.write("\t\t\t            {header:'对方账户',name:'clientaccount',hidden:true},\r\n");
      out.write("\t\t\t            {header:'对方账号',name:'clientaccnumber',hidden:true},\r\n");
      out.write("\t\t\t            {header:'到账金额类型',name:'moneytype',hidden:true},\r\n");
      out.write("\t\t\t            {header:'到账金额',name:'factmoney'},\r\n");
      out.write("\t\t\t            //{header:'与系统无关金额',name:'nowithmoney'},\r\n");
      out.write("\t\t\t            {header:'已核销金额',name:'hiremoney'},\r\n");
      out.write("\t\t\t            {header:'可核销金额',name:'owmoney'},\r\n");
      out.write("\t\t\t            {header:'到账时间',name:'factdate'},\r\n");
      out.write("\t\t\t            {header:'流水号',name:'sn'},\r\n");
      out.write("\t\t\t            {header:'备注',name:'summary',hidden:true}\r\n");
      out.write("\t\t\t            //{header:'登记人',name:'creator_name'},\r\n");
      out.write("\t\t\t            //{header:'登记时间',name:'create_date'}\r\n");
      out.write("\t\t        ]\r\n");
      out.write("\t   \t });\r\n");
      out.write("\t   });\r\n");
      out.write("\t*/\r\n");
      out.write(" </script>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"id_ebank\"></div>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("\t    <div id=\"ebank\" style=\"display: none;overflow:hidden;\" title=\"选择网银\">\r\n");
      out.write("\t    \t\r\n");
      out.write("    </div>\r\n");
      out.write("\t<script type='text/javascript'>\r\n");
      out.write("\t    var ebankDom =document.getElementById(\"ebank\");\r\n");
      out.write("\t    //ebankDom.style.height= ((parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight) - 100)+\"px\";\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
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
}
