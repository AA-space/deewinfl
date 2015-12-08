package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.fund_005foverduerent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class overdue_005frent_005fletter_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>租赁业务  - 租金催收函</title>\r\n");
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
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("\tvar _tempData = '';\r\n");
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
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var tableebank = new tracywindyOperationTable({\r\n");
      out.write("\r\n");
      out.write("   \t\tresetFormCallback:function(table,$form,operFlag){\r\n");
      out.write("   \t\t if(\"add\" == operFlag){\r\n");
      out.write("   \t\t\tvar rowData = table.getRowDataAt(1);\r\n");
      out.write("   \t   \t\t //document.getElementById(\"custname\").value=rowData[\"custname\"];\r\n");
      out.write("   \t\t\t//$(\"#custname\").val(rowData[\"custname\"]);\r\n");
      out.write("   \t     }\r\n");
      out.write("     \t },\r\n");
      out.write("   \t\t loadFormDataCallBack:function(table,$form,rowIndex){\r\n");
      out.write(" \r\n");
      out.write("        },\r\n");
      out.write("   \t\t tableComment:'[租金催收]',\r\n");
      out.write("   \t\t constantFlagTable:'OverdueRentLetterinfo',\r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'租金催收',\r\n");
      out.write("         width:window.formWidth||parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("         height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_letter.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         operButtons:'',\r\n");
      out.write("         checkType:'checkbox',\r\n");
      out.write("         tools:[{\r\n");
      out.write("     \t    iconCls:'icon-import',\r\n");
      out.write("     \t    html:'<font color=\"red\">维护发送日期</font>',\r\n");
      out.write("     \t    handler:function(table, v){\r\n");
      out.write("     \t    \tvar IDValue = table.getCheckedRowDatas();\r\n");
      out.write(" \t\t\t\tif (0 == IDValue.length) {\r\n");
      out.write(" \t\t\t\t\talert(\"请选择需要维护发送日期的数据！\");\r\n");
      out.write(" \t\t\t\t\treturn false;\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write(" \t\t\t\t_tempData = IDValue;\r\n");
      out.write(" \t\t\t\ttable.addEntity();\r\n");
      out.write("     \t   }\r\n");
      out.write("     \t },{\r\n");
      out.write("     \t    iconCls:'icon-import',\r\n");
      out.write("     \t    html:'<font color=\"red\">生成催款函</font>',\r\n");
      out.write("     \t    handler:function(table){\r\n");
      out.write("     \t    \twindow.open('overdue_rent_letter.bi','_bank');\r\n");
      out.write("     \t    //table.addEntity();\r\n");
      out.write("     \t   }},\r\n");
      out.write("     \t   /*,{\r\n");
      out.write("        \t   iconCls:'icon-import',\r\n");
      out.write("        \t   html:'<font color=\"red\">删除发送</font>',\r\n");
      out.write("        \t   handler:function(table){\r\n");
      out.write("        \t   table.addEntity();\r\n");
      out.write("        \t   }\r\n");
      out.write("     \t }*/\r\n");
      out.write("\r\n");
      out.write("     \t//{\r\n");
      out.write("      \t    //html:'<input name=\"senddate\" id=\"senddate\"  label=\"发送时间\" require=\"true\"  class=\"Wdate td-content-input td-content-readonly\"  onClick=\"WdatePicker(this,{readOnly:true})\" readOnly   type=\"text\" />'\r\n");
      out.write("     \t//}\r\n");
      out.write("     \t ],\r\n");
      out.write("         isFit:true,\r\n");
      out.write("         \r\n");
      out.write("         columns:[\r\n");
      out.write("                    {header:'id',name:'id',hidden:true},\r\n");
      out.write("                    {header:'custid',name:'custid',hidden:true},\r\n");
      out.write("                    {header:'overrent',name:'overrent',hidden:true},\r\n");
      out.write("\t\t            {header:'合同编号',name:'contract_id',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'业务合同号',name:'contractnumber',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'最近一次发送日期',name:'senddate'},\r\n");
      out.write("\t\t            {header:'催款员',name:'dun'},\r\n");
      out.write("\t\t            {header:'客户名称',name:'custname'},\r\n");
      out.write("\t\t            {header:'电话',name:'phone'},\r\n");
      out.write("\t\t            {header:'地址',name:'homeadd'},\r\n");
      out.write("\t\t            {header:'担保人',name:'assurors'}\r\n");
      out.write("\t        ]\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("\r\n");
      out.write("\t   function setValue(){\r\n");
      out.write("\t\t   var _param = {};\r\n");
      out.write("\t\t   if(_tempData){\r\n");
      out.write("\t\t\t  var _senddate = $('#senddate').val();\r\n");
      out.write("\t\t\t // console.info(_tempData);\r\n");
      out.write("\t\t\t\tfor ( var int = 0; int < _tempData.length; int++) {\r\n");
      out.write("\t\t\t\t\t _tempData[int].senddate = _senddate;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t_param.dunningnotice = JsonUtil.encode(_tempData);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t   $.post('acl/addOverdueRentLetterinfo.acl', _param, function(i,v){\r\n");
      out.write("\t\t\t\t   if(v == 'success'){\r\n");
      out.write("\t\t\t\t\t   var table =getTracywindyObject('id_table');\r\n");
      out.write("\t\t\t\t\t   table.reload();\r\n");
      out.write("\t\t\t\t\t   alert(\"维护成功!\");\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t   _tempData = null;\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t} else{\r\n");
      out.write("\t\t\t\talert(\"错误，请核实数据\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t   jQuery(\"#id_detailInfoWindowContainer\").window(\"close\");  \r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("    <div id=\"id_detailInfoWindowContainer\"  closed=\"true\" modal=\"true\" title=\"租金催收函\" style=\"display:none;height:150px;width:400px;padding-top:20px;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t        <form id=\"id_detailInfoForm\">\r\n");
      out.write("\t\t\t        <table style=\"width:100%\" class=\"fillTable\">\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"id\" type=\"hidden\" value=\"\"/><input name=\"custid\" type=\"hidden\" value=\"\"/><input name=\"contractid\" type=\"hidden\" value=\"\"/><input name=\"overrent\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr class=\"tr-odd\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">发送时间:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"senddate\" id=\"senddate\"  label=\"发送时间\" require=\"true\"  class=\"Wdate td-content-input td-content-readonly\"  onClick=\"WdatePicker(this,{readOnly:true})\" readOnly   type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\"></td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\"></td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t            <td colspan='4'>\r\n");
      out.write("\t\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='setValue();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_detailInfoWindowContainer\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t            </td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t        </table>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t</div>\r\n");
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
