package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.invoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class invoice_005finfo_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>发票信息维护</title>\r\n");
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
      out.write("\t<style type=\"text/css\"> \r\n");
      out.write("\t\thtml,body{overflow:hidden;}\r\n");
      out.write("\t\t.required-content{color:red}\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var table = new tracywindyOperationTable({   \t\t \r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t\t constantFlagTable:'InvoiceWHInfo',\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'发票信息维护',\r\n");
      out.write("         tableComment:'[发票信息维护]',\r\n");
      out.write("         width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("         height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("         xmlFileName:'/eleasing/workflow/invoice/invoice_info_list.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         operButtons:'修改',\r\n");
      out.write("         lazyLoad: false,\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         isAutoBreakContent: false,\r\n");
      out.write("         isExcel:true,\r\n");
      out.write("         isFit: true,\r\n");
      out.write("         beforeShowWindowCallBack:function(operType,thisForm,operType){\r\n");
      out.write("\t    \t if(operType==\"update\"){\r\n");
      out.write("\t    \t\t var status = $('input[name=\"invoicetype\"]').val();\r\n");
      out.write("\t    \t\t if(status == \"invoicetype1\"){\r\n");
      out.write("\t    \t\t\t getTracywindyObject(\"id_combo_id_status\").setRawValue(\"增值税专用发票\");\r\n");
      out.write("\t    \t\t }else{\r\n");
      out.write("\t    \t\t\t getTracywindyObject(\"id_combo_id_status\").setRawValue(\"增值税普通发票\");\r\n");
      out.write("\t    \t\t }\r\n");
      out.write("\t\t\t\t getTracywindyObject(\"id_combo_id_status\").setValue(status);\r\n");
      out.write("\t    \t }\r\n");
      out.write("\t    \t return true;\r\n");
      out.write("\t     },\r\n");
      out.write("         columns:\r\n");
      out.write("         [\r\n");
      out.write("\t            {header:'id',name:'id',hidden: true},\r\n");
      out.write("\t            {header:'合同编号',name:'contractid',hidden: true},\r\n");
      out.write("\t            {header:'合同号',name:'contractnumber',queryConfig:{}},\r\n");
      out.write("\t            {header:'客户名',name:'custname',queryConfig:{}},\r\n");
      out.write("\t            {header:'经销商',name:'custdealer',queryConfig:{}},\r\n");
      out.write("\t            {header:'项目名称',name:'projectname',width:300,queryConfig:{isNewLine:true}},\r\n");
      out.write("\t            {header:'税号',name:'taxnumber'},\r\n");
      out.write("\t            {header:'开户行',name:'invoiceopenbank'},\r\n");
      out.write("\t            {header:'开户账号',name:'invoicenumber'},\r\n");
      out.write("\t            {header:'地址',name:'invoiceaddress'},\r\n");
      out.write("\t            {header:'电话',name:'invoicetel'}, \r\n");
      out.write("\t            {header:'合同提报日',name:'contractdate'},\r\n");
      out.write("\t            {header:'修改日期',name:'modifydate',type:'date',isRange:true,queryConfig:{}},\r\n");
      out.write("\t            {header:'开票类型',name:'invoicetypename',type:'combobox',queryConfig:{\r\n");
      out.write("\t            \tisNewLine:true,\r\n");
      out.write("\t            \ttype:'combobox',\r\n");
      out.write("\t            \tloadMode:'local',\r\n");
      out.write("\t            \tdisplayField:'text',\r\n");
      out.write("\t\t\t\t    valueField:'id',\r\n");
      out.write("\t\t\t\t    datas:[{id:'增值税专用发票',text:'增值税专用发票'},{id:'增值税普通发票',text:'增值税普通发票'}]\r\n");
      out.write("\t            \t\r\n");
      out.write("\t            }},\r\n");
      out.write("\t            {header:'附件',name:'projid',\r\n");
      out.write("\t            \trenderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t                return \"<a href='javascript:void(0);' onclick='viewProjSummary(\\\"\"+rowData[\"projid\"]+\"\\\")'>\"+\"附件\"+\"</a>\";\r\n");
      out.write("\t    \t       }\r\n");
      out.write("\t\t         }\r\n");
      out.write("\t     ]\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("\tfunction viewProjSummary(keyOne){\r\n");
      out.write("\t\tif(keyOne.indexOf(\"DY\") > -1)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t    var URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/getProjSummaryHistoryInfos.action?keyOne=\"+keyOne;\r\n");
      out.write("\t\t    openFullScreenWindow(URL);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"该项目未走项目立项上传附件!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 加载table 内容div -->\r\n");
      out.write("<div id=\"id_tableContainer\"></div>\r\n");
      out.write("\r\n");
      out.write("<!-- 画弹出框内容 -->\t\r\n");
      out.write("<center>\r\n");
      out.write("<div id=\"id_detailInfoWindowContainer\"  title=\"关账日信息\" style=\"display:none;width:550px;height:300px\">\r\n");
      out.write("        <center>\r\n");
      out.write("\t        <form id=\"id_detailInfoForm\">\r\n");
      out.write("\t\t        <table style=\"width:90%\">\r\n");
      out.write("\t\t            <tr style=\"display:none\">\r\n");
      out.write("\t\t            <td><input name=\"id\" id=\"id\" type=\"hidden\" value=\"\"/></td>\r\n");
      out.write("\t\t            <td><input name=\"contractid\" id=\"contractid\" type=\"hidden\" value=\"\"/></td> \r\n");
      out.write("\t\t            </tr>\r\n");
      out.write("\t\t           <tr >\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content-title\">合同号：</td>\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content\"><input name=\"contractnumber\" readOnly class=\"td-content-input td-content-readonly\" type=\"text\" require=\"true\" label=\"合同号\" /></td>\r\n");
      out.write("\t\t\t\t           <td class=\"td-content-title\">税号：</td>\r\n");
      out.write("\t\t\t\t           <td class=\"td-content\"><input name=\"taxnumber\" id=\"taxnumber\" class=\"td-content-input\"  label=\"税号\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['taxnumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t            <tr >\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content-title\">开户行：</td>\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content\"><input name=\"invoiceopenbank\" id=\"invoiceopenbank\" class=\"td-content-input\" type=\"text\" require=\"true\" label=\"开户行\" /></td>\r\n");
      out.write("\t\t\t\t           <td class=\"td-content-title\">开户账号：</td>\r\n");
      out.write("\t\t\t\t           <td class=\"td-content\"><input name=\"invoicenumber\" id=\"invoicenumber\" class=\"td-content-input\"  label=\"开户账号\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['invoicenumber'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t            <tr >\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content-title\">地址：</td>\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content\"><input name=\"invoiceaddress\" id=\"invoiceaddress\" class=\"td-content-input\" type=\"text\"  label=\"地址\" /></td>\r\n");
      out.write("\t\t\t\t           <td class=\"td-content-title\">电话：</td>\r\n");
      out.write("\t\t\t\t           <td class=\"td-content\"><input name=\"invoicetel\" id=\"invoicetel\" class=\"td-content-input\"  label=\"电话\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['invoicetel'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t             <tr >\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content-title\">开票类型：</td>\r\n");
      out.write("\t\t\t\t\t\t   <td class=\"td-content\">\r\n");
      out.write("\t\t\t\t\t\t   <div class=\"leftComboContainer\" id=\"id_status\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t   </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t            <td colspan='4'>\r\n");
      out.write("\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='submitInfo()'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_detailInfoWindowContainer\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t            </td>\r\n");
      out.write("\t\t            </tr>\r\n");
      out.write("\t\t        </table>\r\n");
      out.write("\t        </form> \r\n");
      out.write("        </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("</center>\r\n");
      out.write("<script>\r\n");
      out.write("function submitInfo(){\r\n");
      out.write("\tvar idstatus = getTracywindyObject(\"id_combo_id_status\").getValue();\r\n");
      out.write("\tvar attrs =[\"taxnumber\",\"invoiceopenbank\",\"invoicenumber\",\"invoiceaddress\",\"invoicetel\"];\r\n");
      out.write("\tif(idstatus==\"invoicetype1\"){\r\n");
      out.write("\t\tfor(var i=0;i<attrs.length;i++){\r\n");
      out.write("\t\t\t$(\"#\"+attrs[i]).attr(\"require\",true);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tfor(var i=0;i<attrs.length;i++){\r\n");
      out.write("\t\t\t$(\"#\"+attrs[i]).attr(\"require\",false);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\treturn getTracywindyObject(\"id_table\").operationTable();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tnew tracywindyComboBox({\r\n");
      out.write("\t\tlazyLoad:true,\r\n");
      out.write("\t\tid : 'id_combo_id_status',\r\n");
      out.write("\t\twidth : 167,\r\n");
      out.write("\t\trenderTo : 'id_status',\r\n");
      out.write("\t\tdatas:[{value:'invoicetype1',name:'增值税专用发票'},{value:'invoicetype2',name:'增值税普通发票'}],\r\n");
      out.write("\t\tloadMode : 'local',\r\n");
      out.write("\t\treadOnly : false,\r\n");
      out.write("\t\tisAjaxLenovo : true,\r\n");
      out.write("\t\treadOnly:true,\r\n");
      out.write("\t\totherAttributes:'require=\"true\"  label=\"开票类型\"',\r\n");
      out.write("\t\ttopAdd : 0,\r\n");
      out.write("\t\tleftAdd : 0,\r\n");
      out.write("\t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t\tname : 'invoicetype',\r\n");
      out.write("\t\tdisplayField : 'name',\r\n");
      out.write("\t\tvalueField : 'value',\r\n");
      out.write("\t\tvalue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"invoicetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\trawValue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"rawValue_invoicetype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\tonSelected:function(combo,rowData,me,columnConfig){\r\n");
      out.write("\t\t\t for(var i=0;i<me.comboboxs.length;i++){\r\n");
      out.write("\t\t    \t   var combo =me.comboboxs[i];\r\n");
      out.write("\t\t    \t   var ivValue  = combo.getValue();\r\n");
      out.write("\t\t    \t   alert(ivValue);\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
