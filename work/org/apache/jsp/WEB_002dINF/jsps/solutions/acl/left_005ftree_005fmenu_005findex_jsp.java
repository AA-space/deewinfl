package org.apache.jsp.WEB_002dINF.jsps.solutions.acl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_005ftree_005fmenu_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:toUpperCase", org.apache.taglibs.standard.functions.Functions.class, "toUpperCase", new Class[] {java.lang.String.class});
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(7);
    _jspx_dependants.add("/WEB-INF/jsps/solutions/acl/main_include_js.jsp");
    _jspx_dependants.add("/WEB-INF/jsps/solutions/acl/workflowDelegate.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/security.tld");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fn.tld");
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
    _jspx_dependants.add("/WEB-INF/tlds/permission.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody != null) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.release();
    if (_005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode != null) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.release();
    if (_005fjspx_005ftagPool_005fc_005fif_0026_005ftest != null) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    if (_005fjspx_005ftagPool_005fc_005fchoose != null) _005fjspx_005ftagPool_005fc_005fchoose.release();
    if (_005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest != null) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    if (_005fjspx_005ftagPool_005fc_005fotherwise != null) _005fjspx_005ftagPool_005fc_005fotherwise.release();
    if (_005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody != null) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    if (_005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems != null) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
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
      out.write(" \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t   <title>");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("-V4.5</title>\r\n");
      out.write("\t   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("\t   \t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("\t   \t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/workFlowUtil.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t   ");
      out.write("\t\r\n");
      out.write("\t  \r\n");
      out.write("\t\r\n");
      out.write("\t<!--css sheet-->\r\n");
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
      out.write("/css/tracywindy/main.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/button.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t      overflow:auto;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<!--javascript libray-->\r\n");
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
      out.write("/js/tracywindy/tracywindyMultiTable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/dtree/dtree.js\"></script>\r\n");
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
      out.write("/js/tracywindy/tracywindyCommonUserSelection.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar isAdminUser = false;\r\n");
      out.write("\t\t");
      if (_jspx_meth_permission_005faction_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("    <!--css sheet-->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/skin/WdatePicker.css\"/>\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<!--javascript libray-->\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t  html,body{\r\n");
      out.write("\t    overflow:hidden;\r\n");
      out.write("\t  }\r\n");
      out.write("\t</style>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    var loadMask = null;\r\n");
      out.write("    var operFlag = \"\";\r\n");
      out.write("     jQuery(function(){\r\n");
      out.write("         if(!jQuery(\"#id_tableContainer\")[0]){return;}\r\n");
      out.write("\t\t if(null == loadMask){\r\n");
      out.write("\t\t\t loadMask = new tracywindyLoadMask(document.body,\"操作进行中   请稍后...\");\r\n");
      out.write("\t     }\r\n");
      out.write("         var all_width  =  800;\r\n");
      out.write("         var all_height =  500;\r\n");
      out.write("         var widthAdd   = 0;\r\n");
      out.write("         if(SysBrowser.getBrowser().toLowerCase().indexOf(\"ie\")>-1){\r\n");
      out.write("        \twidthAdd+=10;\r\n");
      out.write("\t\t }\r\n");
      out.write("  \t     var delegateTable = new tracywindyTable({\r\n");
      out.write("\t\t   renderTo:\"id_tableContainer\",\r\n");
      out.write("\t\t   id:'id_delegateTable',\r\n");
      out.write("\t\t   width:792+widthAdd,\r\n");
      out.write("\t\t   height:400,\r\n");
      out.write("\t\t   isShortPage:true,\r\n");
      out.write("\t\t   //title:'流程授权<font color=\"#FF9238\">&nbsp;&lt;&nbsp;&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('（');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("）&gt;&nbsp;</font>',\r\n");
      out.write("\t\t   xmlFileName:'/jbpm/workflowDelegate.xml',\r\n");
      out.write("\t\t   loadMode:'ajax',\r\n");
      out.write("\t\t   columns:[{\r\n");
      out.write("\t\t\t   header:'流程部署编号',name:'deployment_id_',hidden:true\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'流程定义',name:'workflow_definition_',hidden:true\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'流程名称',name:'workflow_name_'\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'授权编号',name:'grant_delegate_id_',hidden:true\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'授权对象编号',name:'delegate_user_id_',hidden:true\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'授权对象登录名',name:'delegate_user_name_',hidden:true\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'授权对象',name:'delegate_user_realname_',\r\n");
      out.write("\t\t\t   renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\t      if(rowData['delegate_user_name_'])\r\n");
      out.write("\t\t\t      {\r\n");
      out.write("\t\t\t    \t  return value+\"（\"+rowData['delegate_user_name_']+\"）\";\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t      return \"未授权\";\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'授权开始时间',name:'start_date_'\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'授权结束时间',name:'end_date_'\r\n");
      out.write("\t\t   },{\r\n");
      out.write("\t\t\t   header:'操作',name:'oper',\r\n");
      out.write("\t\t\t   renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\t      if(!rowData['grant_delegate_id_'])\r\n");
      out.write("\t\t\t      {\r\n");
      out.write("\t\t\t    \t  return '<a href=\"javascript:void(0);\" onclick=\"delegateSingleWorkflow('+rowData.rowIndex+');\">添加授权</a>';\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  var oper = '<a href=\"javascript:void(0);\" onclick=\"delegateSingleWorkflow('+rowData.rowIndex+');\">修改授权</a>';\r\n");
      out.write("\t\t\t\t  oper+=\"&nbsp;&nbsp;\";\r\n");
      out.write("\t\t\t\t  oper+='<a href=\"javascript:void(0);\"  onclick=\"removeSingleWorkflow('+rowData.rowIndex+');\">取消授权</a>';\r\n");
      out.write("\t\t\t      return oper;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t   }],\r\n");
      out.write("\t\t   params:{userid:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'},\r\n");
      out.write("\t\t   isFit:true,\r\n");
      out.write("\t\t   border:true,\r\n");
      out.write("\t\t   isCheck:true,\r\n");
      out.write("\t\t   pageSize:20,\r\n");
      out.write("\t\t   isShortPage:true,\r\n");
      out.write("\t\t   border:true,\r\n");
      out.write("\t\t   checkType:'checkbox',//radio,\r\n");
      out.write("\t\t   isRank:true,\r\n");
      out.write("\t\t   isPage:false,\r\n");
      out.write("\t\t   displayToggleContainer:\"id_setDelegateWindowContainer\",\r\n");
      out.write("\t\t   tools:[{\r\n");
      out.write("\t              html:'全部授权',\r\n");
      out.write("\t              iconCls:'icon-calendar',\r\n");
      out.write("\t              handler:function(table){operFlag = \"delegateAllWorkflows\";showDelegateDataWindow();}\r\n");
      out.write("\t\t   },'-',{\r\n");
      out.write("\t              html:'批量授权',\r\n");
      out.write("\t              iconCls:'icon-calendar',\r\n");
      out.write("\t              handler:function(table){\t\t\t\r\n");
      out.write("\t\t                var checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t  \t\t\tvar checkedRowDataslen = checkedRowDatas.length;\r\n");
      out.write("\t\t\t\t\t\tif(checkedRowDataslen < 1)\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\talert(\"请选择需要批量授权的流程\");\r\n");
      out.write("\t\t\t\t\t\t\treturn ;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\toperFlag = \"delegateCheckedWorkflows\";showDelegateDataWindow();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t   },'-',{\r\n");
      out.write("              html:'批量取消',\r\n");
      out.write("              iconCls:'icon-calendar',\r\n");
      out.write("              handler:function(table){removeCheckedDelegatedWorkflows(table);}\r\n");
      out.write("\t\t   },'-',{\r\n");
      out.write("\t           html:'全部取消',\r\n");
      out.write("\t           iconCls:'icon-calendar',\r\n");
      out.write("\t           handler:function(table){removeAllDelegatedWorkflows();}\r\n");
      out.write("\t\t   }],\r\n");
      out.write("\t\t   callBack:function(){}\r\n");
      out.write("\t\t});\r\n");
      out.write("     }); \r\n");
      out.write("         //显示授权窗口  \r\n");
      out.write("\t     function showDelegateDataWindow()\r\n");
      out.write("\t     {\r\n");
      out.write("\t    \t   var table = getTracywindyObject('id_delegateTable');\r\n");
      out.write("\t    \t   var checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t    \t   var workflowNameArr  = [];\r\n");
      out.write("\t\t       if(\"delegateAllWorkflows\" == operFlag)\r\n");
      out.write("\t\t       {\r\n");
      out.write("\t\t    \t   checkedRowDatas = table.tableData;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t       var checkedRowDataslen = checkedRowDatas.length;\r\n");
      out.write("\t\t\t   if(0 == checkedRowDataslen){\r\n");
      out.write("\t\t\t\t   alert(\"流程列表不能为空！\");\r\n");
      out.write("\t\t\t\t   return;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t       var rowData  = checkedRowDatas[0];\r\n");
      out.write("\t\t       var isFindRowData = false;\r\n");
      out.write("\t\t\t\tfor(var i=0;i<checkedRowDataslen;i++)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar currentRowData = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tif((currentRowData['delegate_user_name_'])&&!isFindRowData)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\trowData = currentRowData;\r\n");
      out.write("\t\t\t\t\t\tisFindRowData = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tworkflowNameArr.push(currentRowData[\"workflow_name_\"]);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t     \t    var delegateUserId  = rowData[\"delegate_user_id_\"];\r\n");
      out.write("\t\t     \tvar delegateRealName = \"\";\r\n");
      out.write("\t    \t    var startDate  = rowData[\"start_date_\"];\r\n");
      out.write("\t    \t    var endDate  = rowData[\"end_date_\"];\r\n");
      out.write("\t\t\t    if(rowData['delegate_user_name_'])\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t    \tdelegateRealName = rowData['delegate_user_realname_']+\"（\"+rowData['delegate_user_name_']+\"）\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t    \t    jQuery(\"#id_delegateUser\").val(delegateUserId);\r\n");
      out.write("\t    \t    jQuery(\"#id_delegateRealName\").val(delegateRealName);\r\n");
      out.write("\t    \t    jQuery(\"#id_startDate\").val(startDate);\r\n");
      out.write("\t    \t    jQuery(\"#id_endDate\").val(endDate);\r\n");
      out.write("\t\t       jQuery(\"#id_listAllWorflows\").html(workflowNameArr.join(\",\"));\r\n");
      out.write("\t\t       jQuery(\"#id_setDelegateForm\").show();\r\n");
      out.write("\t\t       jQuery(\"#id_setDelegateForm\").window({\r\n");
      out.write("\t                  top:100\r\n");
      out.write("\t\t\t   });\r\n");
      out.write("\t\t       jQuery(\"#id_setDelegateForm\").window(\"open\");\r\n");
      out.write("\t     }\r\n");
      out.write("\t     //关闭授权窗口   \r\n");
      out.write("\t     function closeDelegateWindow(msg)\r\n");
      out.write("\t     {\r\n");
      out.write("\t\t     try{\r\n");
      out.write("\t\t    \t jQuery(\"#id_setDelegateForm\").window(\"close\");\r\n");
      out.write("\t\t\t }catch(e){\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t    \t alert(\"操作\"+msg);\r\n");
      out.write("\t    \t loadMask.hide();\r\n");
      out.write("\t    \t getTracywindyObject('id_delegateTable').reload();\r\n");
      out.write("\t    \t jQuery(\"#id_setDelegateWindowContainer\").window(\"open\");\r\n");
      out.write("\t     }  \r\n");
      out.write("        //选择授权人\r\n");
      out.write("\t    function choseDelegateUser()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar strURL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/commonUserSelection.bi?isUseRowId=true\";\r\n");
      out.write("\t\t\tvar parentOrgId   = '0';\r\n");
      out.write("\t\t\tvar parentOrgName = '组织结构';\r\n");
      out.write("\t\t\tvar selectModel   = 'S';\r\n");
      out.write("\t\t\tvar isQueryModel  = null;\r\n");
      out.write("\t\t\tvar argumentArr = [];\r\n");
      out.write("\t\t\targumentArr.push(document.getElementById('id_delegateUser'));//realValue\r\n");
      out.write("\t\t\targumentArr.push(document.getElementById('id_delegateRealName'));//displayValue\r\n");
      out.write("\t\t\tshowModalUserSelectionWindow_(strURL,argumentArr,parentOrgId,parentOrgName,selectModel,isQueryModel);\r\n");
      out.write("\t    }\r\n");
      out.write("\t    //兼容批量操作\r\n");
      out.write("\t    function singleWorkflowOper(rowIndex)\r\n");
      out.write("\t    {\r\n");
      out.write("\t    \tvar table = getTracywindyObject('id_delegateTable');\r\n");
      out.write("     \t\tvar allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("     \t\tfor(var i= 0;i<allItems.length;i++)\r\n");
      out.write("     \t\t{\r\n");
      out.write("     \t\t\tif(allItems[i]['rowIndex'] == rowIndex)\r\n");
      out.write("     \t\t\t{\r\n");
      out.write("     \t\t\t\tallItems[i].checked = true; \r\n");
      out.write("         \t\t}\r\n");
      out.write("     \t\t\telse\r\n");
      out.write("     \t\t\t{\r\n");
      out.write("     \t\t\t\tallItems[i].checked = false; \r\n");
      out.write("         \t\t}\r\n");
      out.write("     \t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    //单个流程授权\r\n");
      out.write("\t\tfunction delegateSingleWorkflow(rowIndex)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\toperFlag = \"singleDelegateWorkflow\";\r\n");
      out.write("\t\t\tsingleWorkflowOper(rowIndex);\r\n");
      out.write("\t\t\tshowDelegateDataWindow();\r\n");
      out.write("\t    }\r\n");
      out.write("\t    //授权选中流程\r\n");
      out.write("\t    function delegateCheckedWorkflows()\r\n");
      out.write("\t    {\r\n");
      out.write("\t\t    var table = getTracywindyObject('id_delegateTable');\r\n");
      out.write("\t\t\tvar checkedIds = \"\";\r\n");
      out.write("\t\t\tvar checkedIdsArray = [];\r\n");
      out.write("\t\t\tvar checkedDeploymentIdsArray = [];\r\n");
      out.write("\t\t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\tvar checkedRowDataslen = checkedRowDatas.length;\r\n");
      out.write("\t\t\tif(checkedRowDataslen < 1)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"请选择需要批量授权的流程\");\r\n");
      out.write("\t\t\t\treturn ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfor(var i=0;i<checkedRowDataslen;i++)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar rowData = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\tvar id = rowData['grant_delegate_id_'];\r\n");
      out.write("\t\t\t\tif(!id)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tid = \"null\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tcheckedIdsArray.push(id);\r\n");
      out.write("\t\t\t\tcheckedDeploymentIdsArray.push(rowData['deployment_id_']);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("     \t    var delegateUserId  = jQuery(\"#id_delegateUser\").val();\r\n");
      out.write("    \t    var startDate  = jQuery(\"#id_startDate\").val();\r\n");
      out.write("    \t    var endDate  = jQuery(\"#id_endDate\").val();\r\n");
      out.write("    \t    var grantMethod  = \"批量授权\";\r\n");
      out.write("\t    \tloadMask.show();\r\n");
      out.write("\t    \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/delegateCheckedWorkflows.action\";\r\n");
      out.write("\t\t    ajaxRequest({\r\n");
      out.write("                url:url,\r\n");
      out.write("                success:function(res){closeDelegateWindow(\"成功\");},\r\n");
      out.write("                failure:function(res){closeDelegateWindow(\"失败\");},\r\n");
      out.write("                params:{\r\n");
      out.write("                \tdelegateUserId:delegateUserId,\r\n");
      out.write("                \tstartDate:startDate,\r\n");
      out.write("                \tendDate:endDate,\r\n");
      out.write("                \tgrantMethod:grantMethod,\r\n");
      out.write("                \tcheckedIds:checkedIdsArray.join(\",\"),\r\n");
      out.write("                \tcheckedDeploymentIds:checkedDeploymentIdsArray.join(\",\")\r\n");
      out.write("                }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    //授权所有流程\r\n");
      out.write("\t    function delegateAllWorkflows()\r\n");
      out.write("\t    {\r\n");
      out.write("     \t    var delegateUserId  = jQuery(\"#id_delegateUser\").val();\r\n");
      out.write("    \t    var startDate  = jQuery(\"#id_startDate\").val();\r\n");
      out.write("    \t    var endDate  = jQuery(\"#id_endDate\").val();\r\n");
      out.write("    \t    var grantMethod  = \"全部授权\";\r\n");
      out.write("\t    \tloadMask.show();\r\n");
      out.write("\t    \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/delegateAllWorkflows.action\";\r\n");
      out.write("\t\t    ajaxRequest({\r\n");
      out.write("                url:url,\r\n");
      out.write("                success:function(res){closeDelegateWindow(\"成功\");},\r\n");
      out.write("                failure:function(res){closeDelegateWindow(\"失败\");},\r\n");
      out.write("                params:{\r\n");
      out.write("                \tdelegateUserId:delegateUserId,\r\n");
      out.write("                \tstartDate:startDate,\r\n");
      out.write("                \tendDate:endDate,\r\n");
      out.write("                \tgrantMethod:grantMethod\r\n");
      out.write("                }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction setDelegate()\r\n");
      out.write("\t\t{\r\n");
      out.write("     \t    var delegateUserId  = jQuery(\"#id_delegateUser\").val();\r\n");
      out.write("     \t    if(!delegateUserId){alert(\"请选择代理对象\");return;}\r\n");
      out.write("    \t    var startDate  = jQuery(\"#id_startDate\").val();\r\n");
      out.write("    \t    if(!startDate){alert(\"请选择代理开始日期\");return;}\r\n");
      out.write("    \t    var endDate  = jQuery(\"#id_endDate\").val();\r\n");
      out.write("    \t    if(!endDate){alert(\"请选择代理结束日期\");return;}\r\n");
      out.write("\t\t\tif(\"delegateAllWorkflows\" == operFlag){delegateAllWorkflows();}\r\n");
      out.write("\t\t\telse{delegateCheckedWorkflows();}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//取消单个授权\r\n");
      out.write("\t\tfunction removeSingleWorkflow(rowIndex)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\toperFlag = \"removeDelegateWorkflow\";\r\n");
      out.write("\t\t\tsingleWorkflowOper(rowIndex);\r\n");
      out.write("\t\t\tremoveCheckedDelegatedWorkflows();\r\n");
      out.write("\t    }\r\n");
      out.write("\t\t//取消选中授权\r\n");
      out.write("\t\tfunction removeCheckedDelegatedWorkflows()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar table = getTracywindyObject('id_delegateTable');\r\n");
      out.write("\t\t\tvar checkedIds = \"\";\r\n");
      out.write("\t\t\tvar checkedIdsArray = [];\r\n");
      out.write("\t\t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\tvar checkedRowDataslen = checkedRowDatas.length;\r\n");
      out.write("\t\t\tif(checkedRowDataslen < 1)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"请选择需要取消授权的流程\");\r\n");
      out.write("\t\t\t\treturn ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfor(var i=0;i<checkedRowDataslen;i++)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar rowData = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\tvar id = rowData['grant_delegate_id_'];\r\n");
      out.write("\t\t\t\tif(id)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tcheckedIdsArray.push(id);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(checkedIdsArray.length == 0)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"选择项中至少要包含一个已经授权的流程\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t    \tloadMask.show();\r\n");
      out.write("\t    \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/removeCheckedDelegatedWorkflows.action\";\r\n");
      out.write("\t\t    ajaxRequest({\r\n");
      out.write("                url:url,\r\n");
      out.write("                success:function(res){closeDelegateWindow(\"成功\");},\r\n");
      out.write("                failure:function(res){closeDelegateWindow(\"失败\");},\r\n");
      out.write("                params:{\r\n");
      out.write("                \tcheckedIds:checkedIdsArray.join(\",\")\r\n");
      out.write("                }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//取消所有授权\r\n");
      out.write("\t\tfunction removeAllDelegatedWorkflows()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t    \tloadMask.show();\r\n");
      out.write("\t    \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/removeAllDelegatedWorkflows.action\";\r\n");
      out.write("\t\t    ajaxRequest({\r\n");
      out.write("                url:url,\r\n");
      out.write("                success:function(res){closeDelegateWindow(\"成功\");},\r\n");
      out.write("                failure:function(res){closeDelegateWindow(\"失败\");},\r\n");
      out.write("                params:{}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("   </script>\r\n");
      out.write("\r\n");
      out.write("    <script type='text/javascript'>\r\n");
      out.write("          //jQuery.noConflict();\r\n");
      out.write("          var isIE = (SysBrowser.getBrowser().toLowerCase().indexOf(\"ie\")>-1);\r\n");
      out.write("          var init_iframe_clientWidth = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("          var all_width = (document.documentElement||document.body).clientWidth;\r\n");
      out.write("          var all_height = (document.documentElement||document.body).clientHeight;\r\n");
      out.write("          //var iframe_add_height = 147;\r\n");
      out.write("          var iframe_add_height = 105;\r\n");
      out.write("\t      var iframe_clientWidth = all_width-2;\r\n");
      out.write("\t      var iframe_clientHeight = (document.documentElement||document.body).clientHeight-iframe_add_height;\r\n");
      out.write("\t      var init_iframe_clientHeight = iframe_clientHeight+2;\r\n");
      out.write("          var globalMenuJson = {};\r\n");
      out.write("          //菜单个数\r\n");
      out.write("\t      var menuCount = 0;\r\n");
      out.write("          var menuAllWidth = 0;\r\n");
      out.write("          var isNeedScroll = true;\r\n");
      out.write("          var oldClientWidth  = all_width;\r\n");
      out.write("          var oldClientHeight = all_height;\r\n");
      out.write("          var tempWidthAdd  = 24;\r\n");
      out.write("          var incrementSize = all_width-tempWidthAdd*2;\r\n");
      out.write("         \r\n");
      out.write("          \r\n");
      out.write("         function resizeOper(window)\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t\t\t  //重新改变大小\r\n");
      out.write("\t\t\t\t  window.onresize = function(){\r\n");
      out.write("\t\t\t\t\t  all_width = window.document.body.clientWidth;\r\n");
      out.write("\t\t\t\t\t  all_height = window.document.documentElement.clientHeight;\r\n");
      out.write("\t\t\t\t\t  incrementSize = all_width-30;\r\n");
      out.write("\t\t\t\t\t  if((Math.abs(all_width-oldClientWidth)> 50)&&(Math.abs(all_height-oldClientHeight)> 50))\r\n");
      out.write("\t\t\t\t\t  {\r\n");
      out.write("\t\t\t\t\t\t  if(!confirm(\"您改变了页面的大小，请确认已录入的内容是否已保存，页面重新布局后未保存的信息将丢失。请确认是否需要重新布局？\")){\r\n");
      out.write("\t\t\t\t\t\t\t  oldClientWidth = all_width;\r\n");
      out.write("\t\t\t\t\t\t\t  oldClientHeight = all_height;\r\n");
      out.write("\t\t\t\t\t\t\t  return;\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t  var iframeContent = window.document.getElementById('id_iframe_content');\r\n");
      out.write("\t\t\t              if(menuAllWidth <= (all_width-15))\r\n");
      out.write("\t\t\t              {\r\n");
      out.write("\t\t\t              \t  isNeedScroll = false;\r\n");
      out.write("\t\t\t              }\r\n");
      out.write("\t\t\t              else\r\n");
      out.write("\t\t\t              {\r\n");
      out.write("\t\t\t            \t  isNeedScroll = true;\r\n");
      out.write("\t\t\t\t          }\r\n");
      out.write("\t\t\t\t\t\t  with(iframeContent)\r\n");
      out.write("\t\t\t\t\t\t  {\r\n");
      out.write("\t\t\t\t\t\t\t  iframeContent.style.width = (all_width-10)+\"px\";\r\n");
      out.write("\t\t\t\t\t\t\t  iframeContent.style.height = (all_height-iframe_add_height)+\"px\";\r\n");
      out.write("\t\t\t\t\t\t\t  iframeContent.src = iframeContent.src;\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t      if(isNeedScroll)\r\n");
      out.write("\t\t\t\t\t      {\r\n");
      out.write("\t\t\t\t\t    \t  var toolMenuDiv = jQuery(\"#id_toolbar_menu\")[0];\r\n");
      out.write("\t\t\t\t\t    \t  jQuery(\"#id_toolbar_menu\").scrollLeft = 0;\r\n");
      out.write("\t\t\t\t\t          jQuery(\"#id_scroll_left\").hide();\r\n");
      out.write("\t\t\t\t\t          jQuery(\"#id_scroll_right\").show();\r\n");
      out.write("\t\t\t\t\t          jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-tempWidthAdd-2)+\"px\");\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t      else\r\n");
      out.write("\t\t\t\t\t      {\r\n");
      out.write("\t\t\t\t\t\t        jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-2)+\"px\");\r\n");
      out.write("\t\t\t\t\t\t        jQuery(\"#id_scroll_left\").hide();\r\n");
      out.write("\t\t\t\t\t\t        jQuery(\"#id_scroll_right\").hide();\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t        \t jQuery(\"#id_scroll_left\").click(scrollLeftClick);\r\n");
      out.write("\t\t\t\t        \t jQuery(\"#id_scroll_right\").click(scrollRightClick);\r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t\t\t  oldClientWidth = all_width;\r\n");
      out.write("\t\t\t\t\t  oldClientHeight = all_height;\r\n");
      out.write("\t\t\t\t  };\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t     function scrollLeftClick(){\r\n");
      out.write("\t        \t   var toolMenuDiv = jQuery(\"#id_toolbar_menu\")[0];\r\n");
      out.write("\t        \t   if(toolMenuDiv.scrollLeft<=incrementSize)\r\n");
      out.write("\t        \t   {\r\n");
      out.write("\t        \t\t   toolMenuDiv.scrollLeft = 0;\r\n");
      out.write("\t\t\t           jQuery(\"#id_scroll_left\").hide();\r\n");
      out.write("\t\t\t           jQuery(\"#id_scroll_right\").show();\r\n");
      out.write("\t\t\t           jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-tempWidthAdd-2)+\"px\");\r\n");
      out.write("\t\t           }\r\n");
      out.write("\t        \t   else\r\n");
      out.write("\t        \t   {\r\n");
      out.write("\t        \t\t   toolMenuDiv.scrollLeft = (toolMenuDiv.scrollLeft-incrementSize);\r\n");
      out.write("\t\t\t           jQuery(\"#id_scroll_left\").show();\r\n");
      out.write("\t\t\t           jQuery(\"#id_scroll_right\").show();\r\n");
      out.write("\t\t\t           jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-tempWidthAdd*2-2)+\"px\");\r\n");
      out.write("\t\t           }\r\n");
      out.write("\t         }\r\n");
      out.write("\t\t     function scrollRightClick(){\r\n");
      out.write("\t\t        \t   var toolMenuDiv = jQuery(\"#id_toolbar_menu\")[0];\r\n");
      out.write("\t\t        \t   if((toolMenuDiv.scrollLeft+incrementSize)>=(toolMenuDiv.scrollWidth-toolMenuDiv.clientWidth-2))\r\n");
      out.write("\t\t        \t   {\r\n");
      out.write("\t\t        \t\t   toolMenuDiv.scrollLeft = (toolMenuDiv.scrollWidth-toolMenuDiv.clientWidth);\r\n");
      out.write("\t\t        \t\t   jQuery(\"#id_scroll_left\").show();\r\n");
      out.write("\t\t\t\t           jQuery(\"#id_scroll_right\").hide();\r\n");
      out.write("\t\t\t\t           jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-tempWidthAdd-2)+\"px\");\r\n");
      out.write("\t\t\t           }\r\n");
      out.write("\t\t        \t   else\r\n");
      out.write("\t\t        \t   {\r\n");
      out.write("\t\t        \t\t   toolMenuDiv.scrollLeft = (toolMenuDiv.scrollLeft+incrementSize);\r\n");
      out.write("\t\t        \t\t   tempWidthAdd = 30;\r\n");
      out.write("\t\t\t\t           jQuery(\"#id_scroll_left\").show();\r\n");
      out.write("\t\t\t\t           jQuery(\"#id_scroll_right\").show();\r\n");
      out.write("\t\t\t\t           jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-tempWidthAdd*2-2)+\"px\");\r\n");
      out.write("\t\t\t           }\r\n");
      out.write("\t         }\r\n");
      out.write("\t         var iframeContentLoadMask = null;\r\n");
      out.write("\t\t\t function loadAjaxTree(isTreeMenu)\r\n");
      out.write("\t\t\t {\r\n");
      out.write("\t\t\t\t//通用\r\n");
      out.write("\t\t\t    ajaxRequest({\r\n");
      out.write("\t\t\t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/queryMenus.acl',\r\n");
      out.write("\t\t\t\t     method:'POST',\r\n");
      out.write("\t\t\t\t     success:function(res){\r\n");
      out.write("\t\t\t\t\t        var menuJson = eval(\"(\"+res.responseText+\")\");\r\n");
      out.write("\t\t\t\t\t        globalMenuJson = menuJson;\r\n");
      out.write("\t\t\t\t\t        var toolbar_menu_div = document.getElementById(\"id_toolbar_menu\");\r\n");
      out.write("\t\t\t\t\t        var toolbar_menus = menuJson ? menuJson.children : [];\r\n");
      out.write("\t\t\t\t\t       //添加首页\r\n");
      out.write("\t\t\t\t\t       var menuItemDiv = document.createElement(\"a\");\r\n");
      out.write("\t\t\t\t\t       jQuery(menuItemDiv).attr(\"iconCls\",\"icon-home-w\");\r\n");
      out.write("\t\t\t\t\t       jQuery(menuItemDiv).attr(\"isRelativedPath\",\"true\");\r\n");
      out.write("\t\t\t\t\t       jQuery(menuItemDiv).attr(\"plain\",\"true\");\r\n");
      out.write("\t\t\t\t\t       var pageUrl = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.pageUrlPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("                           var clickFunc = (function(pageUrl,currentMenuItemLinkTag){return function(){\r\n");
      out.write("                        \t   changeMenuItemCssStyle(currentMenuItemLinkTag);\r\n");
      out.write("                            \tvar url = pageUrl;\r\n");
      out.write("                            \t\r\n");
      out.write("                \t\t\t\tif(null == iframeContentLoadMask){\r\n");
      out.write("                \t\t\t\t\tiframeContentLoadMask = new tracywindyLoadMask(\"main_content\",\"数据加载中  请稍等...\");\r\n");
      out.write("                    \t\t\t}\r\n");
      out.write("                    \t\t\t\r\n");
      out.write("                    \t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("                \t\t\t\tiframeContentLoadMask.show();\r\n");
      out.write("                \t\t\t\tvar oFrm = document.getElementById('id_iframe_content');\r\n");
      out.write("                \t\t\t\toFrm.src = ((\"true\" == currentMenuItemLinkTag.getAttribute(\"isRelativedPath\")) ? \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\" : \"\" )+url;\r\n");
      out.write("                   \t\t\t\toFrm.onload = oFrm.onreadystatechange = function() {\r\n");
      out.write("                   \t\t\t     if (this.readyState && this.readyState != 'complete') return;\r\n");
      out.write("                   \t\t\t     else {\r\n");
      out.write("                   \t\t\t    \tiframeContentLoadMask.hide();\r\n");
      out.write("                   \t\t\t     }};\r\n");
      out.write("                            };})(pageUrl,menuItemDiv);\r\n");
      out.write("\t\t\t\t\t        with(menuItemDiv)\r\n");
      out.write("\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t        \thref=\"javascript:void(0)\";\r\n");
      out.write("\t\t\t\t\t        \tid = \"id_menuButton_0\";\r\n");
      out.write("\t\t\t\t\t        \tclassName=\"easyui-linkbutton m-btn-plain-active\";\r\n");
      out.write("\t\t\t\t\t        \tinnerHTML = '");
      if (_jspx_meth_spring_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("                                onclick = clickFunc;\r\n");
      out.write("\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t        menuCount++;\r\n");
      out.write("\t\t\t\t\t        toolbar_menu_div.appendChild(menuItemDiv);\r\n");
      out.write("\t\t\t\t\t        jQuery(menuItemDiv).linkbutton();\r\n");
      out.write("\t\t\t\t\t        //添加分隔符\r\n");
      out.write("\t\t\t\t\t        var menuItemSeparator = document.createElement(\"a\");\r\n");
      out.write("\t\t\t\t\t        jQuery(menuItemSeparator).attr(\"class\",\"x-div-menu-separator-image\");\r\n");
      out.write("\t\t\t\t\t        menuItemSeparator.innerHTML=\"&nbsp;\";\r\n");
      out.write("\t\t\t\t\t        toolbar_menu_div.appendChild(menuItemSeparator);\r\n");
      out.write("                           \r\n");
      out.write("\t\t\t\t\t        //开始迭代用户菜单\r\n");
      out.write("\t\t\t\t\t        for(var tbIndex = 0;tbIndex<toolbar_menus.length;tbIndex++)\r\n");
      out.write("\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t        var tbMenu = toolbar_menus[tbIndex];\r\n");
      out.write("\t\t\t\t\t\t        if(!compareAuthorities(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.currentAllAuthoritiesString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",tbMenu.authorities))continue;\r\n");
      out.write("\t\t\t\t\t\t        //增加菜单数量\r\n");
      out.write("\t\t\t\t\t\t        menuCount++;\r\n");
      out.write("                                var icon_class = \"icon-\"+ tbMenu.icon.substring(0,tbMenu.icon.lastIndexOf(\".\")<0?0:tbMenu.icon.lastIndexOf(\".\"))+\"-w\";\r\n");
      out.write("\t\t\t\t\t\t        var menuItemDiv = null;\r\n");
      out.write("                                var isHasChildren = true;\r\n");
      out.write("                                var isRelativedPath = tbMenu.attributes['isRelativedPath'];\r\n");
      out.write("                                if(tbMenu.children.length<1)\r\n");
      out.write("                                {\r\n");
      out.write("                                \tmenuItemDiv = document.createElement(\"a\");\r\n");
      out.write("                                \tjQuery(menuItemDiv).attr(\"iconCls\",icon_class);\r\n");
      out.write("                                \tjQuery(menuItemDiv).attr(\"isRelativedPath\",isRelativedPath);\r\n");
      out.write("                                \tjQuery(menuItemDiv).attr(\"plain\",\"true\");\r\n");
      out.write("                                \tisHasChildren=false;\r\n");
      out.write("                                \tvar pageUrl = tbMenu.url;\r\n");
      out.write("                                    var clickFunc = (function(pageUrl,currentMenuItemLinkTag){return function(){\r\n");
      out.write("                                    \tchangeMenuItemCssStyle(currentMenuItemLinkTag);\r\n");
      out.write("                                    \tvar currentUrl = pageUrl;\r\n");
      out.write("                                    \tcurrentUrl = currentUrl ? currentUrl : \"errorPages/error404.bi\";\r\n");
      out.write("                                     \tvar url = currentUrl;\r\n");
      out.write("                                     \r\n");
      out.write("                         \t\t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("                        \t\t\t\tif(null == iframeContentLoadMask){\r\n");
      out.write("                        \t\t\t\t\tiframeContentLoadMask = new tracywindyLoadMask(\"main_content\",\"数据加载中  请稍等...\");\r\n");
      out.write("                            \t\t\t}\r\n");
      out.write("                        \t\t\t\tiframeContentLoadMask.show();\r\n");
      out.write("                        \t\t\t\tvar oFrm = document.getElementById('id_iframe_content');\r\n");
      out.write("                        \t\t\t\t//alert(currentMenuItemLinkTag.getAttribute(\"isRelativedPath\"));\r\n");
      out.write("                        \t\t\t\toFrm.src = ((\"true\" == currentMenuItemLinkTag.getAttribute(\"isRelativedPath\")) ? \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\" : \"\" )+url;\r\n");
      out.write("                           \t\t\t\toFrm.onload = oFrm.onreadystatechange = function() {\r\n");
      out.write("                           \t\t\t     if (this.readyState && this.readyState != 'complete') return;\r\n");
      out.write("                           \t\t\t     else {\r\n");
      out.write("                           \t\t\t    \tiframeContentLoadMask.hide();\r\n");
      out.write("                           \t\t\t     }};\r\n");
      out.write("                                     };})(pageUrl,menuItemDiv);\r\n");
      out.write("                                    menuItemDiv.onclick=clickFunc;\r\n");
      out.write("                                }\r\n");
      out.write("                                else\r\n");
      out.write("                                {\r\n");
      out.write("                                \tmenuItemDiv = document.createElement(\"a\");\r\n");
      out.write("        \t\t\t\t\t        jQuery(menuItemDiv).attr(\"iconCls\",icon_class);\r\n");
      out.write("        \t\t\t\t\t        jQuery(menuItemDiv).attr(\"isRelativedPath\",isRelativedPath);\r\n");
      out.write("        \t\t\t\t\t        jQuery(menuItemDiv).attr(\"plain\",\"true\");\r\n");
      out.write("        \t\t\t\t\t        jQuery(menuItemDiv).attr(\"menu\",\"#id_menu_\"+(tbIndex+1));\r\n");
      out.write("                                    if(isTreeMenu)\r\n");
      out.write("                                    {\r\n");
      out.write("                                    \tvar pageUrl = tbMenu.url;\r\n");
      out.write("                                    \tvar tbMenuId = tbMenu.id;\r\n");
      out.write("                                        var clickFunc = (function(pageUrl,currentMenuItemLinkTag,tbMenuId){return function(){\r\n");
      out.write("                                        \tchangeMenuItemCssStyle(currentMenuItemLinkTag);\r\n");
      out.write("                             \t\t\t\t\r\n");
      out.write("                             \t\t\t\tvar url = \"acl/left_tree_menu_content.bi\";\r\n");
      out.write("                             \t\t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("                             \t\t\t\turl+=\"&rootParentMenuId=\"+tbMenuId;\r\n");
      out.write("                             \t\t\t\turl+=\"&pageUrl=\"+pageUrl;\r\n");
      out.write("                            \t\t\t\tif(null == iframeContentLoadMask){\r\n");
      out.write("                            \t\t\t\t\tiframeContentLoadMask = new tracywindyLoadMask(\"main_content\",\"数据加载中  请稍等...\");\r\n");
      out.write("                                \t\t\t}\r\n");
      out.write("                            \t\t\t\tiframeContentLoadMask.show();\r\n");
      out.write("                            \t\t\t\tvar oFrm = document.getElementById('id_iframe_content');\r\n");
      out.write("                            \t\t\t\toFrm.src =  ((\"true\" == currentMenuItemLinkTag.getAttribute(\"isRelativedPath\")) ? \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\" : \"\" )+ url;\r\n");
      out.write("                               \t\t\t\toFrm.onload = oFrm.onreadystatechange = function() {\r\n");
      out.write("                               \t\t\t     if (this.readyState && this.readyState != 'complete') return;\r\n");
      out.write("                               \t\t\t     else {\r\n");
      out.write("                               \t\t\t    \tiframeContentLoadMask.hide();\r\n");
      out.write("                               \t\t\t     }};\r\n");
      out.write("                                         };})(pageUrl,menuItemDiv,tbMenuId);\r\n");
      out.write("                                        menuItemDiv.onclick=clickFunc;\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("\t\t\t\t\t\t        with(menuItemDiv)\r\n");
      out.write("\t\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t        \tid = \"id_menuButton_\"+(tbIndex+1);\r\n");
      out.write("\t\t\t\t\t\t        \thref=\"javascript:void(0)\";\r\n");
      out.write("\t\t\t\t\t\t        \tclassName=\"easyui-menubutton \";\r\n");
      out.write("\t\t\t\t\t\t        \tinnerHTML = tbMenu.name;\r\n");
      out.write("\t\t\t\t\t\t        \t\r\n");
      out.write("\t\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t        menuItemDiv.setAttribute(\"firstLevelMenuId\", tbMenu.attributes.firstLevelMenuId);\r\n");
      out.write("\t\t\t\t\t\t\t    if(!isHasChildren||(isTreeMenu))\r\n");
      out.write("\t\t\t\t\t\t\t    {\r\n");
      out.write("\t\t\t\t\t\t\t    \tmenuItemDiv.className=\"easyui-linkbutton\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t        menuItemDiv.setAttribute(\"isHasChildren\",isHasChildren);\r\n");
      out.write("\t\t\t\t\t\t        var menuButtonItemDiv = document.createElement(\"div\");\r\n");
      out.write("\t\t\t\t\t\t        with(menuButtonItemDiv)\r\n");
      out.write("\t\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t\t        id=\"id_menu_\"+(tbIndex+1);\r\n");
      out.write("\t\t\t\t\t\t\t        style.width=\"150px\";\r\n");
      out.write("\t\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t\t    if(!isTreeMenu)\r\n");
      out.write("\t\t\t\t\t\t\t    {\r\n");
      out.write("\t\t\t\t\t\t\t    \trecursionTreeMenu(menuItemDiv,tbMenu,menuButtonItemDiv,true,'');\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t        toolbar_menu_div.appendChild(menuItemDiv);\r\n");
      out.write("\t\t\t\t\t\t        document.body.appendChild(menuButtonItemDiv);\r\n");
      out.write("                                //添加分隔符\r\n");
      out.write("                                var menuItemSeparator = document.createElement(\"a\");\r\n");
      out.write("\t\t\t\t\t            jQuery(menuItemSeparator).attr(\"class\",\"x-div-menu-separator-image\");\r\n");
      out.write("\t\t\t\t\t\t        menuItemSeparator.innerHTML=\"&nbsp;\";\r\n");
      out.write("\t\t\t\t\t\t        toolbar_menu_div.appendChild(menuItemSeparator);\r\n");
      out.write("\t\t\t\t\t        }\r\n");
      out.write("\t\t\t\t\t        for(var tbIndex = 0;tbIndex<toolbar_menus.length;tbIndex++)\r\n");
      out.write("\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t        var tempJqueryObj = jQuery('#id_menuButton_'+(tbIndex+1));\r\n");
      out.write("\t\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t        if((toolbar_menus[tbIndex].children.length > 0)&&!isTreeMenu)\r\n");
      out.write("\t\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t        \ttempJqueryObj.menubutton({plain:true});\r\n");
      out.write("\t\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t        else\r\n");
      out.write("\t\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t        \ttempJqueryObj.linkbutton({plain:true});\r\n");
      out.write("\t\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t        }\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t        jQuery(\".easyui-linkbutton\").each(function(){\r\n");
      out.write("                                   this.onmouseover=function(){jQuery(\"body>div.menu-top\").menu(\"hide\");};\r\n");
      out.write("\t\t\t\t\t\t    });\r\n");
      out.write("\t\t\t\t\t        jQuery(\".x-div-menu-separator-image\").each(function(){\r\n");
      out.write("                                this.onmouseover=function(){jQuery(\"body>div.menu-top\").menu(\"hide\");};\r\n");
      out.write("\t\t\t\t\t\t    });\r\n");
      out.write("\t\t\t\t\t        jQuery(\"#id_mainPage_header\")[0].onmouseover = function(){jQuery(\"body>div.menu-top\").menu(\"hide\");};\r\n");
      out.write("                            //菜单总宽度\r\n");
      out.write("                            //menuAllWidth = Math.max(menuCount*102,jQuery(\"#id_toolbar_menu\")[0].scrollWidth);\r\n");
      out.write("                            //menuAllWidth = Math.max(jQuery(\"#id_toolbar_menu\")[0].offsetWidth,jQuery(\"#id_toolbar_menu\")[0].scrollWidth);\r\n");
      out.write("                           //menuAllWidth = (menuCount-1)*100+60;\r\n");
      out.write("                           menuAllWidth = 0;\r\n");
      out.write("                           jQuery(\"#id_toolbar_menu>a\").each(function(i){\r\n");
      out.write("                        \t   menuAllWidth+=this.offsetWidth;\r\n");
      out.write("                           });\r\n");
      out.write("                            if(menuAllWidth <= (all_width+12))\r\n");
      out.write("                            {\r\n");
      out.write("                            \tiframe_clientHeight = iframe_clientHeight+18;\r\n");
      out.write("                            \tisNeedScroll = false;\r\n");
      out.write("                            }\r\n");
      out.write("                            else\r\n");
      out.write("                            {\r\n");
      out.write("            \t\t        \t // jQuery(\"#id_scroll_left\").show();\r\n");
      out.write("            \t\t        \t jQuery(\"#id_scroll_right\").show();\r\n");
      out.write("            \t\t        \t jQuery(\"#id_scroll_left\").click(scrollLeftClick);\r\n");
      out.write("            \t\t        \t jQuery(\"#id_scroll_right\").click(scrollRightClick);\r\n");
      out.write("            \t\t        \t jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-tempWidthAdd-2)+\"px\");\r\n");
      out.write("                            }\r\n");
      out.write("                            jQuery(\".menu-item\").css(\"height\",\"24px\");\r\n");
      out.write("                            //jQuery(\".menu-item\").css(\"line-height\",\"32px\");\r\n");
      out.write("\t\t\t\t     },\r\n");
      out.write("\t\t\t\t     failure:function(res){},\r\n");
      out.write("\t\t\t\t     async:false,\r\n");
      out.write("\t\t\t\t     timeout:30*1000\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t    };\r\n");
      out.write("\t\t    function changeMenuItemCssStyle(currentMenuItemLinkTag)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \tjQuery(\"#id_toolbar_menu a.easyui-linkbutton\").removeClass(\"m-btn-plain-active\");\r\n");
      out.write("\t\t    \tjQuery(\"#id_toolbar_menu a.easyui-menubutton\").removeClass(\"m-btn-plain-active\");\r\n");
      out.write("\t\t    \tjQuery(\"#id_toolbar_menu a.easyui-linkbutton\").removeClass(\"menu-item-selected\");\r\n");
      out.write("\t\t    \tjQuery(\"#id_toolbar_menu a.easyui-menubutton\").removeClass(\"menu-item-selected\");\r\n");
      out.write("\t\t    \tjQuery(currentMenuItemLinkTag).addClass(\"m-btn-plain-active\");\r\n");
      out.write("\t\t    \tjQuery(currentMenuItemLinkTag).addClass(\"menu-item-selected\");\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t       function recursionTreeMenu(topMenuItemDiv,menuJson,menuButtonItemDiv,isInit,pageUrl)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar menus = menuJson.children;\r\n");
      out.write("\t\t\t\t\tfor(var mIndex = 0;mIndex<menus.length;mIndex++)\r\n");
      out.write("\t\t\t        {\r\n");
      out.write("\t\t\t\t        var tbMenu = menus[mIndex];\r\n");
      out.write("\t\t\t\t        if(!compareAuthorities(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.currentAllAuthoritiesString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",tbMenu.authorities))continue;\r\n");
      out.write("\t                    var icon_class = \"icon-\"+ tbMenu.icon.substring(0,tbMenu.icon.lastIndexOf(\".\")<0?0:tbMenu.icon.lastIndexOf(\".\"))+\"-w\";\r\n");
      out.write("\t\t\t\t        var menuItemDiv = document.createElement(\"div\");\r\n");
      out.write("\t\t\t\t        jQuery(menuItemDiv).attr(\"iconCls\",icon_class);\r\n");
      out.write("\t                    if(tbMenu.children.length > 0)\r\n");
      out.write("\t                    {\r\n");
      out.write("\t                        var insertSpanMenuItem = document.createElement(\"span\");\r\n");
      out.write("\t                        with(insertSpanMenuItem)\r\n");
      out.write("\t                        {\r\n");
      out.write("\t                        \tinnerHTML=tbMenu.name;\r\n");
      out.write("\t                        }\r\n");
      out.write("\t                        menuItemDiv.appendChild(insertSpanMenuItem);\r\n");
      out.write("\t                        var childrenMenusDiv = document.createElement(\"div\");\r\n");
      out.write("\t                        jQuery(childrenMenusDiv).attr(\"iconCls\",icon_class);\r\n");
      out.write("\t                        with(childrenMenusDiv)\r\n");
      out.write("\t                        {\r\n");
      out.write("\t                            style.width=\"180px\";\r\n");
      out.write("\t                        }\r\n");
      out.write("\t                        recursionTreeMenu(topMenuItemDiv,tbMenu,childrenMenusDiv,true,pageUrl);\r\n");
      out.write("\t                        menuItemDiv.appendChild(childrenMenusDiv);\r\n");
      out.write("\t                    }\r\n");
      out.write("\t                    else\r\n");
      out.write("\t                    {\r\n");
      out.write("\t                        var pageUrl = tbMenu.url;\r\n");
      out.write("\t                        var clickFunc = (function(pageUrl,currentMenuItemLinkTag){return function(){\r\n");
      out.write("\t                        \tchangeMenuItemCssStyle(currentMenuItemLinkTag);\r\n");
      out.write("\t                        \tvar url = pageUrl;\t                        \t\r\n");
      out.write("\t            \t\t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("\t            \t\t\t\tdocument.getElementById('id_iframe_content').src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+url;\r\n");
      out.write("\t                        };})(pageUrl,topMenuItemDiv);\r\n");
      out.write("\t                    \twith(menuItemDiv)\r\n");
      out.write("\t                        {\r\n");
      out.write("\t                    \t\tinnerHTML=tbMenu.name;\r\n");
      out.write("\t                    \t\tonclick=clickFunc;\r\n");
      out.write("\t                        }\r\n");
      out.write("\t                    }\r\n");
      out.write("\t                    menuButtonItemDiv.appendChild(menuItemDiv);\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tfunction compareAuthorities(userAuthoritiesStr,menuAuthoritiesStr)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t\tif(!userAuthoritiesStr)return false;\r\n");
      out.write("\t\t\t\t\tif(!menuAuthoritiesStr)return false;\r\n");
      out.write("\t\t\t\t\tvar userAuthorities = userAuthoritiesStr.split(\",\");\r\n");
      out.write("\t\t\t\t\tvar menuAuthorities = menuAuthoritiesStr.split(\",\");\r\n");
      out.write("\t\t\t\t\tvar pass = false;\r\n");
      out.write("\t\t\t\t\tfor(var userIndex = 0;userIndex<userAuthorities.length;userIndex++)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tfor(var menuIndex = 0;menuIndex<menuAuthorities.length;menuIndex++)\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\tif(userAuthorities[userIndex] == menuAuthorities[menuIndex])\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\tpass=true;\r\n");
      out.write("\t\t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\treturn pass;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//消息函数开始\r\n");
      out.write("\t\t\tfunction shwoMessageWindwos(){\r\n");
      out.write("\t\t\t\tvar isClosable = true;\r\n");
      out.write("\t\t\t/* \tif(isForceUpdatePassword)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tisClosable = false;\r\n");
      out.write("\t\t\t\t\tjQuery(\"#id_station_message\").hide();\r\n");
      out.write("\t\t\t\t} */\r\n");
      out.write("\t\t\t\t//id_message_table\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tjQuery('#id_message_table').tabs({  \r\n");
      out.write("\t\t\t\t    border:false,   \r\n");
      out.write("\t\t\t\t    onSelect:function(title){   \r\n");
      out.write("\t\t\t\t       // alert(title+' is selected');   \r\n");
      out.write("\t\t\t\t    }   \r\n");
      out.write("\t\t\t\t});  \r\n");
      out.write("\r\n");
      out.write("\t\t\t\tjQuery(\"#id_station_message\").show();\r\n");
      out.write("\t\t\t\tjQuery(\"#id_station_message\").window({\r\n");
      out.write("\t\t        \tzIndex:9000,\r\n");
      out.write("\t\t        \tdraggable:true,\r\n");
      out.write("\t\t        \ttop:150,\r\n");
      out.write("\t\t        \tresizable:false,\r\n");
      out.write("\t\t        \tshadow:true,\r\n");
      out.write("\t\t        \tmodal:true,\r\n");
      out.write("\t\t        \tinline:false,\r\n");
      out.write("\t\t        \tcollapsible:false,\r\n");
      out.write("\t\t        \tminimizable:false,\r\n");
      out.write("\t\t        \tmaximizable:false,\r\n");
      out.write("\t\t        \tclosable:isClosable,\r\n");
      out.write("\t\t        \tclosed:false\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t        var messageWidthAdd = 0;\r\n");
      out.write("\t\t        if(isIE){\r\n");
      out.write("\t\t        \tmessageWidthAdd = 10;\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t        //短信\r\n");
      out.write("/* \t\t\t\tnew tracywindyTable({\r\n");
      out.write("\t\t\t\t    renderTo:'id_message_list',\r\n");
      out.write("\t\t\t\t    width:578+messageWidthAdd,\r\n");
      out.write("\t\t\t\t    height:350,\r\n");
      out.write("\t\t\t\t    xmlFileName:'\\\\message\\\\queryUnReadMsg.xml',\r\n");
      out.write("\t\t\t        loadMode:'ajax',\r\n");
      out.write("\t\t\t        isPage:true,\r\n");
      out.write("\t\t\t        isCheck:false,\r\n");
      out.write("\t\t\t        pageSize:5,\r\n");
      out.write("\t\t\t        toolsLeftMargin:0,\r\n");
      out.write("\t\t\t        params : {\r\n");
      out.write("\t\t\t        \tuserId :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tborder:true,\r\n");
      out.write("\t\t\t\t\tisFit:true,\r\n");
      out.write("\t\t\t\t    columns:[\r\n");
      out.write("\t\t\t\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t\t       {name:'sendid',  header:'发送者',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t\t\t   {name:'content',  header:'短信内容',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t\t\t   {name:'sendtime',  header:'发送时间',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t\t\t   {name:'operater',  header:'查看', renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\t\t\t\t   return \"<a href='javascript:void(0);' onclick='alert(1);'>查看</a>\";\r\n");
      out.write("\t\t\t\t\t   }}\r\n");
      out.write("\t\t\t\t     ]\r\n");
      out.write("\t\t\t\t });  */\r\n");
      out.write("\t\t\t\t //公告\r\n");
      out.write("\t\t      /*   new tracywindyTable({\r\n");
      out.write("\t\t\t\t    renderTo:'id_notice_list',\r\n");
      out.write("\t\t\t\t    width:578+messageWidthAdd,\r\n");
      out.write("\t\t\t\t    height:350,\r\n");
      out.write("\t\t\t\t    xmlFileName:'\\\\message\\\\queryUnReadMsg.xml',\r\n");
      out.write("\t\t\t        loadMode:'ajax',\r\n");
      out.write("\t\t\t        isPage:true,\r\n");
      out.write("\t\t\t        isCheck:false,\r\n");
      out.write("\t\t\t        pageSize:5,\r\n");
      out.write("\t\t\t        toolsLeftMargin:0,\r\n");
      out.write("\t\t\t        datas : [],\r\n");
      out.write("\t\t\t        params : {\r\n");
      out.write("\t\t\t        \tuserId :'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tborder:true,\r\n");
      out.write("\t\t\t\t\tisFit:true,\r\n");
      out.write("\t\t\t\t    columns:[\r\n");
      out.write("\t\t\t\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t\t       {name:'sendid',  header:'发送者',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t\t\t   {name:'content',  header:'短信内容',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t\t\t   {name:'sendtime',  header:'发送时间',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t\t\t   {name:'operater',  header:'查看', renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\t\t\t\t   return \"<a href='javascript:void(0);' onclick='alert(1);'>查看</a>\";\r\n");
      out.write("\t\t\t\t\t   }}\r\n");
      out.write("\t\t\t\t     ]\r\n");
      out.write("\t\t\t\t });   */\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction sendMessage(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t var names = jQuery('#id_send_names_id').val();\r\n");
      out.write("\t\t\t\t var content = jQuery('#id_send_contents').val();\r\n");
      out.write("\t\t\t\t var data = {receives : names, content : content};\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t if(names == null || names == ''){\r\n");
      out.write("\t\t\t\t\t alert(\"请输入收件人\");\r\n");
      out.write("\t\t\t\t\t return;\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t\t jQuery.post('msg/sendMsg.action', data,  function(i,v){\r\n");
      out.write("\t\t\t\t\t if(i == 'ok'){\r\n");
      out.write("\t\t\t\t\t\tjQuery('#id_send_names_id').val('');\r\n");
      out.write("\t\t\t\t\t\tjQuery('#id_send_names').val('');\r\n");
      out.write("\t\t\t\t\t\tjQuery('#id_send_contents').val('');\r\n");
      out.write("\t\t\t\t\t\talert(\"发送成功\"); \r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write(" \t\t\tjQuery(function(){\r\n");
      out.write("\t\t\t\tnew tracywindyCommonUserSelection({\r\n");
      out.write("\t\t\t\t\t hiddenInput:'id_send_names_id',\r\n");
      out.write("\t\t\t\t\t displayInput:'id_send_names',\r\n");
      out.write("\t\t\t\t\t id:'id_sendMessageChoosor',\r\n");
      out.write("\t\t\t\t\t isMultiSelect:true\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t\t//消息函数结束\r\n");
      out.write("\t\t\t//修改密码\r\n");
      out.write("\t\t\tfunction showModifyPasswordWindow(isForceUpdatePassword)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar isClosable = true;\r\n");
      out.write("\t\t\t\tif(isForceUpdatePassword)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tisClosable = false;\r\n");
      out.write("\t\t\t\t\tjQuery(\"#id_cancel_update_password\").hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tjQuery(\"#id_modifyPasswordDetailInfoForm\").show();\r\n");
      out.write("\t\t\t\tjQuery(\"#id_modifyPasswordDetailInfoForm\").window({\r\n");
      out.write("\t\t        \tzIndex:9000,\r\n");
      out.write("\t\t        \tdraggable:true,\r\n");
      out.write("\t\t        \ttop:150,\r\n");
      out.write("\t\t        \tresizable:true,\r\n");
      out.write("\t\t        \tshadow:true,\r\n");
      out.write("\t\t        \tmodal:true,\r\n");
      out.write("\t\t        \tinline:false,\r\n");
      out.write("\t\t        \tcollapsible:false,\r\n");
      out.write("\t\t        \tminimizable:false,\r\n");
      out.write("\t\t        \tmaximizable:false,\r\n");
      out.write("\t\t        \tclosable:isClosable,\r\n");
      out.write("\t\t        \tclosed:false\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t        jQuery(\"#id_userName\").val(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\t\t        jQuery(\"#id_realName\").val(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\t\t        jQuery(\"#id_telephone\").val(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_usertelephone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\t\t        jQuery(\"#id_email\").val(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_useremail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\t\t        jQuery(\"#id_oldPassword\").val(\"\");\r\n");
      out.write("\t\t\t\tjQuery(\"#id_newPassword\").val(\"\");\r\n");
      out.write("\t\t\t\tjQuery(\"#id_confirmNewPassword\").val(\"\");\r\n");
      out.write("\t\t\t    jQuery(\"#id_modifyPasswordDetailInfoForm\").window('open');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//个人设置\r\n");
      out.write("\t\t\tfunction showPersonalSettingWindow(){\r\n");
      out.write("\t\t\t\tjQuery(\"#id_modifyPersonalSettingDetailInfoFormWindow\").show();\r\n");
      out.write("\t\t\t\tjQuery(\"#id_modifyPersonalSettingDetailInfoFormWindow\").window({\r\n");
      out.write("\t\t        \tzIndex:9000,\r\n");
      out.write("\t\t        \tdraggable:true,\r\n");
      out.write("\t\t        \ttop:50,\r\n");
      out.write("\t\t        \tresizable:true,\r\n");
      out.write("\t\t        \tshadow:true,\r\n");
      out.write("\t\t        \tmodal:true,\r\n");
      out.write("\t\t        \tinline:false,\r\n");
      out.write("\t\t        \tcollapsible:false,\r\n");
      out.write("\t\t        \tminimizable:false,\r\n");
      out.write("\t\t        \tmaximizable:false,\r\n");
      out.write("\t\t        \tclosable:true,\r\n");
      out.write("\t\t        \tclosed:false\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t\t\tjQuery(\"#id_modifyPersonalSettingDetailInfoFormWindow\").window('open');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjQuery(function(){\r\n");
      out.write("\t\t\t\tjQuery('#id_personalSetting_tabs').tabs({   \r\n");
      out.write("\t\t\t\t    border:false,   \r\n");
      out.write("\t\t\t\t    onSelect:function(title){   \r\n");
      out.write("\t\t\t\t    }   \r\n");
      out.write("\t\t\t\t}); \r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\t    //显示在线用户信息\r\n");
      out.write("\t\t    function showOnlineUsersWindow()\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t\tjQuery(\"#id_online_users\").show();\r\n");
      out.write("\t\t\t\tjQuery(\"#id_online_users\").window({\r\n");
      out.write("\t\t        \tzIndex:9000,\r\n");
      out.write("\t\t        \tdraggable:true,\r\n");
      out.write("\t\t        \ttop:150,\r\n");
      out.write("\t\t        \tresizable:true,\r\n");
      out.write("\t\t        \tshadow:true,\r\n");
      out.write("\t\t        \tmodal:true,\r\n");
      out.write("\t\t        \tinline:false,\r\n");
      out.write("\t\t        \tcollapsible:false,\r\n");
      out.write("\t\t        \tminimizable:false,\r\n");
      out.write("\t\t        \tmaximizable:false,\r\n");
      out.write("\t\t        \tclosable:true,\r\n");
      out.write("\t\t        \tclosed:false\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction doModifyPasswordOperation()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar telephone = jQuery(\"#id_telephone\").val();\r\n");
      out.write("\t\t\t\tvar email  = jQuery(\"#id_email\").val();\r\n");
      out.write("\t\t\t\tvar currentUserId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t\tvar realOldPassword = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_userpassword}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t\tif(\"\"==telephone){alert(\"联系人不能为空\");jQuery(\"#id_telephone\").focus();return;}\r\n");
      out.write("\t\t\t\tif(\"\"==email){alert(\"邮箱地址不能为空\");jQuery(\"#id_email\").focus();return;}\r\n");
      out.write("\t\t\t\tvar oldPassword = jQuery(\"#id_oldPassword\").val();\r\n");
      out.write("\t\t\t\tvar newPassword = jQuery(\"#id_newPassword\").val();\r\n");
      out.write("\t\t\t\tvar confirmNewPassword = jQuery(\"#id_confirmNewPassword\").val();\r\n");
      out.write("\t\t\t\tif(newPassword.length < ");
      out.print(com.kernal.utils.ResourceUtil.getMinPasswordLength());
      out.write(")\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\talert(\"新密码不能少于");
      out.print(com.kernal.utils.ResourceUtil.getMinPasswordLength());
      out.write("位!\");\r\n");
      out.write("\t\t\t\t\tjQuery(\"#id_newPassword\").focus();\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    /*if(!(new RegExp(\"");
      out.print(com.kernal.utils.ResourceUtil.getMinPasswordLength());
      out.write("\").test(newPassword))){\r\n");
      out.write("                    alert(\"密码必须包括2种以上字符（可选，大写字母、小写字母、数字、特殊字符）\");\r\n");
      out.write("                    jQuery(\"#id_newPassword\").focus();\r\n");
      out.write("\t\t\t\t    return;\r\n");
      out.write("\t\t\t    }*/\r\n");
      out.write("\t\t\t    if(!/\\d+/gi.test(newPassword)){\r\n");
      out.write("\t\t\t    \talert(\"密码必须至少包含一个数字\");\r\n");
      out.write("\t\t\t\t    jQuery(\"#id_newPassword\").focus();\r\n");
      out.write("\t\t\t\t    return;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(!/[a-zA-Z]+/gi.test(newPassword)){\r\n");
      out.write("\t\t\t\t    alert(\"密码必须包含一个字母\");\r\n");
      out.write("\t\t\t\t    jQuery(\"#id_newPassword\").focus();\r\n");
      out.write("\t\t\t\t    return;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(\"\"==oldPassword){alert(\"原始密码不能为空\");jQuery(\"#id_oldPassword\").focus();return;}\r\n");
      out.write("\t\t\t\t//if(realOldPassword!=oldPassword){alert(\"旧密码不正确\");jQuery(\"#id_oldPassword\").focus();return;}\r\n");
      out.write("\t\t\t\tif(\"\"==newPassword){alert(\"新密码不能为空\");jQuery(\"#id_newPassword\").focus();return;}\r\n");
      out.write("\t\t\t\tif(confirmNewPassword!=newPassword){alert(\"确认密码应与新密码保持一致\");jQuery(\"#id_confirmNewPassword\").focus();return;}\r\n");
      out.write("                var params ={};\r\n");
      out.write("\t\t\t\tparams['method']='modifyUserPassword';\r\n");
      out.write("\t\t\t\tparams['currentUserId']=currentUserId;\r\n");
      out.write("\t\t\t\tparams['oldPassword']=oldPassword;\r\n");
      out.write("\t\t\t\tparams['newPassword']=newPassword;\r\n");
      out.write("\t\t\t\tparams['telephone']=telephone;\r\n");
      out.write("\t\t\t\tparams['email']=email;\r\n");
      out.write("\t\t\t\tajaxRequest({\r\n");
      out.write("\t\t   \t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/modifyUserPassword.acl',\r\n");
      out.write("\t\t   \t\t     method:'POST',\r\n");
      out.write("\t\t   \t\t     success:function(res){\r\n");
      out.write("\t\t   \t\t    \t  var returnInfo = JsonUtil.decode(res.responseText);\r\n");
      out.write("\t\t\t   \t\t      if('success'==returnInfo.status)\r\n");
      out.write("\t\t\t   \t\t      {\r\n");
      out.write("\t\t\t   \t\t    \tjQuery(\"#id_modifyPasswordDetailInfoForm\").window(\"close\");\r\n");
      out.write("\t\t\t   \t\t    \talert(\"信息修改成功\");\r\n");
      out.write("\t\t\t   \t\t    \twindow.top.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login.jsp\";\r\n");
      out.write("\t\t\t\t   \t\t  }\r\n");
      out.write("\t\t\t   \t\t      else\r\n");
      out.write("\t\t\t   \t\t      {\r\n");
      out.write("\t\t\t   \t\t    \talert(returnInfo.message);\r\n");
      out.write("\t\t\t   \t\t    \tjQuery(\"#id_oldPassword\").focus();\r\n");
      out.write("\t\t\t\t   \t\t  }\r\n");
      out.write("\t\t   \t\t     },\r\n");
      out.write("\t\t   \t\t     failure:function(res){\r\n");
      out.write("\t\t\t   \t\t },\r\n");
      out.write("\t\t   \t\t     params:params\r\n");
      out.write("\t   \t\t });\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\tfunction showDelegateWindow()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t        jQuery(\"#id_setDelegateWindowContainer\").show();\r\n");
      out.write("\t        jQuery(\"#id_setDelegateWindowContainer\").window({top:50});\r\n");
      out.write("\t        jQuery(\"#id_setDelegateWindowContainer\").window('open');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    function logoutUserByUserName()\r\n");
      out.write("\t    {\r\n");
      out.write("             window.open(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logoutUserByUserName.acl?method=logoutUserByUserName\",\"_blank\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tjQuery(function(){\r\n");
      out.write("\t\t\t\tif('true'=='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.isForceUpdatePassword}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tjQuery(\"#id_loadMaskContainer\").hide();\r\n");
      out.write("\t\t\t\t\tshowModifyPasswordWindow(true);\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t   });\r\n");
      out.write("\t   /**加载左侧菜单**/\r\n");
      out.write("\t     function loadLeftMenu(menuContainerIdOrObject,menuRootId,isTopMenu)\r\n");
      out.write("         {\r\n");
      out.write("        \tvar url = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/queryMenus.acl?mathRandom='+Math.random();\r\n");
      out.write("        \tvar data = {rootParentMenuId:menuRootId};\r\n");
      out.write("        \tvar callBackFunc = function(jsonData){\r\n");
      out.write("            \tvar menuContainer = null;\r\n");
      out.write("        \t\tif(!(typeof(menuContainerIdOrObject)=='object'))\r\n");
      out.write("        \t\t{\r\n");
      out.write("        \t\t\tmenuContainer = document.getElementById(menuContainerIdOrObject);\r\n");
      out.write("        \t\t}\r\n");
      out.write("        \t\telse\r\n");
      out.write("        \t\t{\r\n");
      out.write("        \t\t\tmenuContainer = menuContainerIdOrObject;\r\n");
      out.write("                }\r\n");
      out.write("                \r\n");
      out.write("\t\t\t    var menuButtonItemUL = document.createElement(\"div\");\r\n");
      out.write("\t\t\t    menuButtonItemUL.id = \"id_menu_container\";\r\n");
      out.write("\t\t\t    menuContainer.appendChild(menuButtonItemUL);\r\n");
      out.write("        \t\trecursionLeftMenu(jsonData,menuButtonItemUL,true);\r\n");
      out.write("        \t\taddOperToLeftMenu();\r\n");
      out.write("            };\r\n");
      out.write("            var contentType = \"json\";\r\n");
      out.write("        \tjQuery.post(url,data,callBackFunc,contentType);\r\n");
      out.write("         }\r\n");
      out.write("\t     function recursionLeftMenu(menuJson,menuButtonItemUL,isTopMenu)\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t\t    var imgSrcPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/menu_topline.gif\";\r\n");
      out.write("\t\t\t\tvar menus = menuJson.children;\r\n");
      out.write("\t\t\t\tfor(var mIndex = 0;mIndex<menus.length;mIndex++)\r\n");
      out.write("\t\t        {\r\n");
      out.write("\t\t\t        var tbMenu = menus[mIndex];\r\n");
      out.write("\t\t\t        if(!compareAuthorities(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.currentAllAuthoritiesString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",tbMenu.authorities))continue;\r\n");
      out.write("                    var icon_class = \"icon-\"+ tbMenu.icon.substring(0,tbMenu.icon.lastIndexOf(\".\")<0?0:tbMenu.icon.lastIndexOf(\".\"))+\"-w\";\r\n");
      out.write("\t\t\t        var menuItemLI = null;\r\n");
      out.write("\t\t\t        var insertHrefMenuItem = null;\r\n");
      out.write("\t\t\t        var childrenCount = tbMenu.children.length ;\r\n");
      out.write("\t\t\t        \r\n");
      out.write("                   if(childrenCount > 0)\r\n");
      out.write("                   {\r\n");
      out.write("                       var tempHtml = \"\";\r\n");
      out.write("                           tempHtml+='<h1><a href=\"javascript:void(0)\" class=\"type\">'+tbMenu.name+'</a></h1>';\r\n");
      out.write("        \t\t\t\t   with(menuButtonItemUL)\r\n");
      out.write("        \t\t\t\t   {\r\n");
      out.write("            \t\t\t\t   innerHTML+=tempHtml;\r\n");
      out.write("            \t\t\t   }    \r\n");
      out.write("                       var contentDiv = document.createElement(\"div\");\r\n");
      out.write("                           tempHtml = \"\";\r\n");
      out.write("\t                       tempHtml+='<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">';\r\n");
      out.write("\t                       tempHtml+='<tr>';\r\n");
      out.write("\t                       tempHtml+='<td><img src=\"'+imgSrcPath+'\" width=\"182\" height=\"5\" /></td>';\r\n");
      out.write("\t                       tempHtml+='</tr>';\r\n");
      out.write("\t                       tempHtml+='</table>';\r\n");
      out.write("                           with(contentDiv)\r\n");
      out.write("                           {\r\n");
      out.write("                        \t   className=\"content\";\r\n");
      out.write("                        \t   innerHTML=tempHtml;\r\n");
      out.write("                           }\r\n");
      out.write("                       menuButtonItemUL.appendChild(contentDiv);\r\n");
      out.write("                       \r\n");
      out.write("                       var childrenMenusUL = document.createElement(\"ul\");\r\n");
      out.write("    \t\t\t       contentDiv.appendChild(childrenMenusUL);\r\n");
      out.write("    \t\t\t       with(childrenMenusUL)\r\n");
      out.write("    \t\t\t       {\r\n");
      out.write("    \t\t\t    \t   className = \"MM\";\r\n");
      out.write("        \t\t\t   }\r\n");
      out.write("    \t\t\t       childrenMenusUL.setAttribute(\"superTitle\",tbMenu.name);\r\n");
      out.write("                       with(childrenMenusUL)\r\n");
      out.write("                       {\r\n");
      out.write("                    \t   //className = \"box-list hidden\";\r\n");
      out.write("                       }\r\n");
      out.write("                       recursionLeftMenu(tbMenu,childrenMenusUL,false);\r\n");
      out.write("                       contentDiv.appendChild(childrenMenusUL);\r\n");
      out.write("                   }\r\n");
      out.write("                   else\r\n");
      out.write("                   {\r\n");
      out.write("                \t   var tempHtml = \"\";\r\n");
      out.write("\t   \t\t\t        if(isTopMenu)\r\n");
      out.write("\t\t\t\t        {\r\n");
      out.write("\t   \t\t\t        \ttempHtml+='<h1 class=\"type\"><a href=\"javascript:void(0)\">'+tbMenu.name+'</a></h1>';\r\n");
      out.write("\t\t\t\t\t        with(menuButtonItemUL)\r\n");
      out.write("\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t        \tinnerHTML+= tempHtml;\r\n");
      out.write("\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t        }\r\n");
      out.write("\t   \t\t\t        else\r\n");
      out.write("\t   \t\t\t        {\r\n");
      out.write("\t   \t\t\t        \tvar pageUrl = tbMenu.url;\r\n");
      out.write("\t\t                    var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+pageUrl;\t\t                  \r\n");
      out.write("\t\t           \t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("\t                 \t    menuItemLI = document.createElement(\"li\");\r\n");
      out.write("\t                 \t    var aLink = document.createElement(\"a\");\r\n");
      out.write("\t                 \t    var pageUrl = tbMenu.url;\r\n");
      out.write("\t                 \t   with(aLink)\r\n");
      out.write("\t                 \t   {\r\n");
      out.write("\t                 \t\t  href      = \"javascript:void(0);\";\r\n");
      out.write("\t\t                 \t  innerHTML = tbMenu.name;\r\n");
      out.write("\t\t                 \t  setAttribute(\"pageUrl\",pageUrl);\r\n");
      out.write("\t\t                   }\r\n");
      out.write("\t                       menuItemLI.appendChild(aLink);\r\n");
      out.write("\t                \t   menuButtonItemUL.appendChild(menuItemLI);\r\n");
      out.write("\t   \t   \t\t\t    }\r\n");
      out.write("                   }     \r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction addOperToLeftMenu()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tjQuery(function(){\r\n");
      out.write("\t\t\t\t     \t\tvar contents = document.getElementsByClassName('content');\r\n");
      out.write("\t\t\t\t    \t\tvar toggles = document.getElementsByClassName('type');\r\n");
      out.write("\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t    \t\tvar myAccordion = new fx.Accordion(\r\n");
      out.write("\t\t\t\t    \t\t\ttoggles, contents\r\n");
      out.write("\t\t\t\t    \t\t);\r\n");
      out.write("\t\t\t\t    \t\t myAccordion.showThisHideOpen(contents[0]);\r\n");
      out.write("\t\t\t\t        \t var currentUserIndex = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.pageUrlPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\t\t        \t if(currentUserIndex)\r\n");
      out.write("\t\t\t\t        \t {\r\n");
      out.write("\t\t\t\t        \t\t jQuery(\"#id_frameRight\")[0].src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+currentUserIndex;\r\n");
      out.write("\t\t\t\t             }\t\r\n");
      out.write("\t\t\t\t             jQuery(\"#id_menu_container div.content ul.MM li>a\").click(function(e){\r\n");
      out.write("\t\t\t\t\t                var pageUrl = jQuery(this).attr(\"pageUrl\");\r\n");
      out.write("\t                        \t    document.getElementById('id_frameRight').src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/loadingIndex.html\";\r\n");
      out.write("\t\t                            var parentNodeTitle = jQuery(this).parent().parent().attr(\"superTitle\");\r\n");
      out.write("\t\t                            var titleHtml = parentNodeTitle+\"&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;\"+jQuery(this).text();\r\n");
      out.write("\t\t                            jQuery(\"#id_goPage\").html(titleHtml);\r\n");
      out.write("\t\t                            jQuery(\"#id_menu_container div.content ul.MM li>a\").removeClass(\"linkclicked\");\r\n");
      out.write("\t\t                            jQuery(this).addClass(\"linkclicked\");\r\n");
      out.write("\t\t\t                       \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+pageUrl;\r\n");
      out.write("\t\t\t                      \r\n");
      out.write("\t\t\t           \t\t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("\t\t\t           \t\t\t\tdocument.getElementById('id_frameRight').src = url;\r\n");
      out.write("\t\t\t           \t\t\t\t\r\n");
      out.write("\t\t\t\t\t        });\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t         function loadLeftMenu_levelN(menuContainerIdOrObject,menuRootId,isTopMenu)\r\n");
      out.write("\t         {\r\n");
      out.write("\t        \tvar url = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/queryMenus.acl?mathRandom='+Math.random();\r\n");
      out.write("\t        \tvar data = {rootParentMenuId:menuRootId};\r\n");
      out.write("\t        \tvar callBackFunc = function(jsonData){\r\n");
      out.write("\t            \tvar menuContainer = null;\r\n");
      out.write("\t        \t\tif(!(typeof(menuContainerIdOrObject)=='object'))\r\n");
      out.write("\t        \t\t{\r\n");
      out.write("\t        \t\t\tmenuContainer = document.getElementById(menuContainerIdOrObject);\r\n");
      out.write("\t        \t\t}\r\n");
      out.write("\t        \t\telse\r\n");
      out.write("\t        \t\t{\r\n");
      out.write("\t        \t\t\tmenuContainer = menuContainerIdOrObject;\r\n");
      out.write("\t                }\r\n");
      out.write("\t                \r\n");
      out.write("\t\t\t\t    var menuButtonItemUL = document.createElement(\"div\");\r\n");
      out.write("\t\t\t\t    menuButtonItemUL.className = \"pnav-cnt\";\r\n");
      out.write("\t\t\t\t    menuContainer.appendChild(menuButtonItemUL);\r\n");
      out.write("\t        \t\trecursionLeftMenu_levelN(jsonData,menuButtonItemUL,true);\r\n");
      out.write("\t        \t\taddOperToLeftMenu_levelN();\r\n");
      out.write("\t            };\r\n");
      out.write("\t            var contentType = \"json\";\r\n");
      out.write("\t        \tjQuery.post(url,data,callBackFunc,contentType);\r\n");
      out.write("\t         }\r\n");
      out.write("\t\t     function recursionLeftMenu_levelN(menuJson,menuButtonItemUL,isTopMenu)\r\n");
      out.write("\t\t\t {\r\n");
      out.write("\t\t\t\t\tvar menus = menuJson.children;\r\n");
      out.write("\t\t\t\t\tfor(var mIndex = 0;mIndex<menus.length;mIndex++)\r\n");
      out.write("\t\t\t        {\r\n");
      out.write("\t\t\t\t        var tbMenu = menus[mIndex];\r\n");
      out.write("\t\t\t\t        if(!compareAuthorities(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.currentAllAuthoritiesString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",tbMenu.authorities))continue;\r\n");
      out.write("\t                    var icon_class = \"icon-\"+ tbMenu.icon.substring(0,tbMenu.icon.lastIndexOf(\".\")<0?0:tbMenu.icon.lastIndexOf(\".\"))+\"_w\";\r\n");
      out.write("\t\t\t\t        var menuItemLI = null;\r\n");
      out.write("\t\t\t\t        var insertHrefMenuItem = null;\r\n");
      out.write("\t\t\t\t        var childrenCount = tbMenu.children.length ;\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t\t        if(isTopMenu)\r\n");
      out.write("\t\t\t\t        {\r\n");
      out.write("\t\t\t\t        \tmenuItemLI = document.createElement(\"div\");\r\n");
      out.write("\t\t\t\t        \tmenuItemLI.className = \"pnav-box\";\r\n");
      out.write("\t\t\t\t        \tinsertHrefMenuItem = document.createElement(\"div\");\r\n");
      out.write("\r\n");
      out.write("\t\t                    var tempHtml =  \"\";      \r\n");
      out.write("\t\t                    if(childrenCount>0)\r\n");
      out.write("\t\t                    {\r\n");
      out.write("\t\t                        tempHtml+='<a class=\"btn-fold \" href=\"\"></a>';\r\n");
      out.write("\t\t\t                    tempHtml+='<a class=\"btn-unfold hidden\" href=\"\"></a>';\r\n");
      out.write("\t\t\t                } \r\n");
      out.write("\t\t                    else\r\n");
      out.write("\t\t                    {\r\n");
      out.write("\t\t                    \ttempHtml+=\"&nbsp;&nbsp;\"; \r\n");
      out.write("\t\t\t                }     \r\n");
      out.write("\t\t                    if(childrenCount>0)\r\n");
      out.write("\t\t                    {\r\n");
      out.write("\t\t                    \ttempHtml+='<span class=\"menu-content\">'+tbMenu.name+'</span>';\r\n");
      out.write("\t\t\t                } \r\n");
      out.write("\t\t                    else\r\n");
      out.write("\t\t                    {\r\n");
      out.write("\t\t\t\t\t        \tvar pageUrl = tbMenu.url;\r\n");
      out.write("\t\t                       \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+pageUrl;\r\n");
      out.write("\t\t                       \r\n");
      out.write("\t\t           \t\t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<b>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<a  href=\"'+url+'\" target=\"name_rightFrame\">'+tbMenu.name+'</a>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='</b>';\r\n");
      out.write("\t\t\t                }  \t   \r\n");
      out.write("\t\t                    with(insertHrefMenuItem)\r\n");
      out.write("\t\t                    {\r\n");
      out.write("\t\t                       className = \"box-title\";\r\n");
      out.write("\t\t                       innerHTML= tempHtml;\r\n");
      out.write("\t\t                    }\r\n");
      out.write("\t\t                    menuItemLI.appendChild(insertHrefMenuItem);\r\n");
      out.write("\t\t\t\t        }\r\n");
      out.write("\t\t\t\t        else\r\n");
      out.write("\t\t\t\t        {\r\n");
      out.write("\t\t\t\t        \tmenuItemLI = document.createElement(\"li\");\r\n");
      out.write("\t\t\t\t        \t\r\n");
      out.write("\t\t\t\t        \tvar tempHtml =  \"\";  \r\n");
      out.write("\t\t\t\t        \tif(childrenCount > 0)\r\n");
      out.write("\t\t\t\t        \t{\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<a class=\"btn-fold\" href=\"\"></a>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<a class=\"btn-unfold hidden\" href=\"\"></a>';\r\n");
      out.write("\t\t\t\t\t        }\r\n");
      out.write("\t\t                    else\r\n");
      out.write("\t\t                    {\r\n");
      out.write("\t\t                    \ttempHtml+=\"&nbsp;&nbsp;\"; \r\n");
      out.write("\t\t\t                }  \r\n");
      out.write("\t\t\t\t        \tif(childrenCount > 0)\r\n");
      out.write("\t\t\t\t        \t{\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<b>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<a  href=\"\">'+tbMenu.name+'</a>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='</b>';\r\n");
      out.write("\t\t\t\t        \t}\r\n");
      out.write("\t\t\t\t        \telse\r\n");
      out.write("\t\t\t\t        \t{\r\n");
      out.write("\t\t\t\t\t        \tvar pageUrl = tbMenu.url;\r\n");
      out.write("\t\t                       \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+pageUrl;\r\n");
      out.write("\t\t                       \r\n");
      out.write("\t\t           \t\t\t\turl = getTracywindyRandomUrl(url);\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<b>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='<a  href=\"'+url+'\" target=\"name_rightFrame\">'+tbMenu.name+'</a>';\r\n");
      out.write("\t\t\t\t\t        \ttempHtml+='</b>';\r\n");
      out.write("\t\t\t\t\t\t    }\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t        \twith(menuItemLI)\r\n");
      out.write("\t\t\t\t        \t{\r\n");
      out.write("\t\t\t\t        \t\tinnerHTML = tempHtml;\r\n");
      out.write("\t\t\t\t\t        }\r\n");
      out.write("\t\t\t\t\t    }\r\n");
      out.write("\t                   \r\n");
      out.write("\t                   if(childrenCount > 0)\r\n");
      out.write("\t                   {\r\n");
      out.write("\t                       var childrenMenusUL = document.createElement(\"ul\");\r\n");
      out.write("\t                       with(childrenMenusUL)\r\n");
      out.write("\t                       {\r\n");
      out.write("\t                    \t   className = \"box-list hidden\";\r\n");
      out.write("\t                       }\r\n");
      out.write("\t                       recursionLeftMenu_levelN(tbMenu,childrenMenusUL,false);\r\n");
      out.write("\t                       menuItemLI.appendChild(childrenMenusUL);\r\n");
      out.write("\t                   }\r\n");
      out.write("\t                   else\r\n");
      out.write("\t                   {\r\n");
      out.write("\t                \t   /*  var pageUrl = tbMenu.url;\r\n");
      out.write("\t                        var clickFunc = (function(pageUrl){return function(){\r\n");
      out.write("\t\t                       \tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+pageUrl;\r\n");
      out.write("\t\t           \t\t\t\tif(url.indexOf('?')>-1)\r\n");
      out.write("\t\t           \t\t\t\t{\r\n");
      out.write("\t\t           \t\t\t\t\turl+=(\"&tracywindyRandom=\" +Math.random());\r\n");
      out.write("\t\t           \t\t\t    }\r\n");
      out.write("\t\t           \t\t\t\telse\r\n");
      out.write("\t\t           \t\t\t\t{\r\n");
      out.write("\t\t           \t\t\t\t\turl+=(\"?tracywindyRandom=\" +Math.random());\r\n");
      out.write("\t\t           \t\t\t\t}\r\n");
      out.write("\t\t           \t\t\t\twindow.open(url);\r\n");
      out.write("\t\t           \t\t\t\t//document.getElementById('id_iframe_content').src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+url;\r\n");
      out.write("\t\t                       };\r\n");
      out.write("\t                       })(pageUrl);\r\n");
      out.write("\t                   \t   with(insertHrefMenuItem)\r\n");
      out.write("\t                       {\r\n");
      out.write("\t                   \t\t onclick=clickFunc;\r\n");
      out.write("\t                       }*/\r\n");
      out.write("\t                   }     \r\n");
      out.write("\t                   menuButtonItemUL.appendChild(menuItemLI);\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tfunction addOperToLeftMenu_levelN()\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t(function($){\r\n");
      out.write("\t\t\t\t\t\t$(\"div.pnav-box div.box-title a.btn-fold\").bind(\"click\", function(e){\r\n");
      out.write("\t\t\t\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t\t\t\tvar eleTitle = $(this.parentNode);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).addClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\teleTitle.children(\"a.btn-unfold\").removeClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\t$(eleTitle.parent()).children(\"ul.box-list\").removeClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t$(\"div.pnav-box div.box-title a.btn-unfold\").bind(\"click\", function(e){\r\n");
      out.write("\t\t\t\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t\t\t\tvar eleTitle = $(this.parentNode);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).addClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\teleTitle.children(\"a.btn-fold\").removeClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\t$(eleTitle.parent()).children(\"ul.box-list\").addClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t$(\"div.pnav-box ul.box-list a.btn-fold\").bind(\"click\", function(e){\r\n");
      out.write("\t\t\t\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t\t\t\tvar eleTitle = $(this.parentNode);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).addClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\teleTitle.children(\"a.btn-unfold\").removeClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\teleTitle.children(\"ul.box-list\").removeClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t$(\"div.pnav-box ul.box-list a.btn-unfold\").bind(\"click\", function(e){\r\n");
      out.write("\t\t\t\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\t\t\t\tvar eleTitle = $(this.parentNode);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).addClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\teleTitle.children(\"a.btn-fold\").removeClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t\teleTitle.children(\"ul.box-list\").addClass(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t})(jQuery);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t    /***加载左侧菜单完成******/\r\n");
      out.write("\t\t    function recusionParentTitle(cn,parentNodeTitle)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t    if(-1 == cn.id)\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t\t    return parentNodeTitle;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t    else\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t    \tvar pnt = cn.name;\r\n");
      out.write("\t\t\t\t    if(parentNodeTitle)\r\n");
      out.write("\t\t\t\t    {\r\n");
      out.write("\t\t\t\t    \tpnt = cn.name+\"&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t    parentNodeTitle=(pnt+parentNodeTitle);\r\n");
      out.write("\t\t\t    \treturn recusionParentTitle(cn._p,parentNodeTitle);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t /******加载左侧树形菜单*****/\r\n");
      out.write("\t\t var frameRightLoadMask = null;\r\n");
      out.write("\t     function loadLeftTreeMenu(menuContainerIdOrObject,menuRootId)\r\n");
      out.write("         {\r\n");
      out.write("\t    \tleftOperMenuTree = new dTree('leftOperMenuTree');\r\n");
      out.write("\t    \tleftOperMenuTree.config.useCookies = false;\r\n");
      out.write("\t    \t// Toggle Open or close\r\n");
      out.write("\t    \tleftOperMenuTree.onclick = function(nodeIndex) {\r\n");
      out.write("\t    \t    if(null == frameRightLoadMask){\r\n");
      out.write("\t    \t    \tframeRightLoadMask = new tracywindyLoadMask(\"id_frameRightContainer\",\"数据加载中 请稍等...\");\r\n");
      out.write("                }\r\n");
      out.write("\t    \t    frameRightLoadMask.show();\r\n");
      out.write("\t    \t\tvar cn = this.aNodes[nodeIndex];\r\n");
      out.write("\t    \t\tif(cn._hc){\r\n");
      out.write("\t    \t\t\tframeRightLoadMask.hide();\r\n");
      out.write("\t    \t\t\treturn false; \r\n");
      out.write("\t\t        }\r\n");
      out.write("\t    \t\t/*this.nodeStatus(!cn._io, id, cn._ls);\r\n");
      out.write("\t    \t\tcn._io = !cn._io;*/\r\n");
      out.write("\t    \t\tif (this.config.closeSameLevel) this.closeLevel(cn);\r\n");
      out.write("\t    \t\tif (this.config.useCookies) this.updateCookie();\r\n");
      out.write("\t    \t\tthis.s(nodeIndex);\r\n");
      out.write("\t    \t\tvar cn = this.aNodes[nodeIndex];\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t    document.getElementById('id_frameRight').src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/loadingIndex.html\";\r\n");
      out.write("                \r\n");
      out.write("                //var parentNodeTitle = //cn._p.name;\r\n");
      out.write("                var titleHtml = recusionParentTitle(cn,\"\");//parentNodeTitle+\"&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;\"+cn.name;\r\n");
      out.write("                jQuery(\"#id_goPage\").html(titleHtml);\r\n");
      out.write("            \tvar currentUrl = cn.url;\r\n");
      out.write("            \tcurrentUrl = currentUrl ? currentUrl : \"errorPages/error404.bi\";\r\n");
      out.write("               \tvar url = ((\"true\" == cn.attributes['isRelativedPath']) ? \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\" : \"\" ) + currentUrl;\r\n");
      out.write("               \t\r\n");
      out.write("               \turl = getTracywindyRandomUrl(url);\r\n");
      out.write("               \t\r\n");
      out.write("   \t\t\t\tvar oFrm = document.getElementById('id_frameRight');\r\n");
      out.write("   \t\t\t\toFrm.src = url;\r\n");
      out.write("   \t\t\t\toFrm.onload = oFrm.onreadystatechange = function() {\r\n");
      out.write("   \t\t\t     if (this.readyState && this.readyState != 'complete') return;\r\n");
      out.write("   \t\t\t     else {\r\n");
      out.write("   \t\t\t    \tframeRightLoadMask.hide();\r\n");
      out.write("   \t\t\t     }};\r\n");
      out.write("\t    \t};\r\n");
      out.write("\t    \t\r\n");
      out.write("        \tvar url = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/queryMenus.acl?mathRandom='+Math.random();\r\n");
      out.write("        \tvar data = {rootParentMenuId:menuRootId};\r\n");
      out.write("        \tvar callBackFunc = function(jsonData){\r\n");
      out.write("        \t\trecursionLeftTreeMenu(menuRootId,jsonData,leftOperMenuTree,true);\r\n");
      out.write("        \t\tvar currentSelectedMenuNode = leftOperMenuTree.aNodes[findLeftMenuTreeIndex];\r\n");
      out.write("        \t\tif(!currentSelectedMenuNode)\r\n");
      out.write("        \t\t{\r\n");
      out.write("            \t\talert(\"子菜单不可操作,请检查菜单权限\");\r\n");
      out.write("            \t\treturn;\r\n");
      out.write("            \t}\r\n");
      out.write("            \tvar currentUrl = currentSelectedMenuNode.url;\r\n");
      out.write("            \tcurrentUrl = currentUrl ? currentUrl : \"errorPages/error404.bi\";\r\n");
      out.write("        \t\tdocument.getElementById('id_frameRight').src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\"+currentUrl;\r\n");
      out.write("                 \r\n");
      out.write("            \tvar menuContainer = null;\r\n");
      out.write("        \t\tif(!(typeof(menuContainerIdOrObject)=='object'))\r\n");
      out.write("        \t\t{\r\n");
      out.write("        \t\t\tmenuContainer = document.getElementById(menuContainerIdOrObject);\r\n");
      out.write("        \t\t}\r\n");
      out.write("        \t\telse\r\n");
      out.write("        \t\t{\r\n");
      out.write("        \t\t\tmenuContainer = menuContainerIdOrObject;\r\n");
      out.write("                }\r\n");
      out.write("        \t\tjQuery(menuContainer).html(leftOperMenuTree.toString());\r\n");
      out.write("        \t\tleftOperMenuTree.s(findLeftMenuTreeIndex);\r\n");
      out.write("                var parentNodeTitle = currentSelectedMenuNode._p.name;\r\n");
      out.write("                var titleHtml = recusionParentTitle(currentSelectedMenuNode,\"\");\r\n");
      out.write("                jQuery(\"#id_goPage\").html(titleHtml);\r\n");
      out.write("                window.top['currentReloadMenuId'] = null;\r\n");
      out.write("\t        \tif(window.top.iframeContentLoadMask){\r\n");
      out.write("\t\t\t    \twindow.top.iframeContentLoadMask.hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("            };\r\n");
      out.write("            var contentType = \"json\";\r\n");
      out.write("        \tjQuery.post(url,data,callBackFunc,contentType);\r\n");
      out.write("         }\r\n");
      out.write("         var findLeftMenuTreeIndex  = -1;\r\n");
      out.write("\t     //迭代左侧树\r\n");
      out.write("\t \tfunction recursionLeftTreeMenu(menuRootId,menuJson,tree,isInit)\r\n");
      out.write("\t \t{\r\n");
      out.write("\t \t\tvar menus = menuJson.children;\r\n");
      out.write("\t \t\tfor(var mIndex = 0;mIndex<menus.length;mIndex++)\r\n");
      out.write("\t \t\t{\r\n");
      out.write("\t \t\t   var tbMenu = menus[mIndex];\r\n");
      out.write("\t \t\t   if( menuRootId == tbMenu.id){\r\n");
      out.write("\t \t\t\t  findLeftMenuTreeIndex = 1;\r\n");
      out.write("\t \t\t\t  recursionLeftTreeMenuData(tbMenu,tree,true);\r\n");
      out.write("\t \t\t\t  break;\r\n");
      out.write("\t\t \t   }\r\n");
      out.write("\t \t\t   \r\n");
      out.write("\t \t\t}\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \tfunction recursionLeftTreeMenuData(menuJson,tree,isInit)\r\n");
      out.write("\t \t{\r\n");
      out.write("\t\t \tvar isRelativedPath = menuJson.attributes['isRelativedPath'];\r\n");
      out.write("\t\t \tif(isInit)\r\n");
      out.write("\t\t \t{\r\n");
      out.write("\t\t \t\tvar topMenu = menuJson;\r\n");
      out.write("\t\t \t\ttree.add(topMenu.id,-1,topMenu.name,topMenu.url,topMenu.icon,topMenu.iconClose,topMenu.iconOpen,topMenu.description,topMenu.position,true,{isRelativedPath:isRelativedPath});\r\n");
      out.write("\t\t \t\ttree.add('id_leftTreeSystemMenuMap',topMenu.id,'");
      if (_jspx_meth_spring_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("',\"acl/left_tree_menu_map_content.bi\"/*+topMenu.id*/,'diagram.png','diagram.png','diagram.png','菜单地图',0,true,{isRelativedPath:'true'});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t \t\tvar menus = menuJson.children;\r\n");
      out.write("\t \t\tfor(var mIndex = 0;mIndex<menus.length;mIndex++)\r\n");
      out.write("\t \t\t{\r\n");
      out.write("\t \t\t   var tbMenu = menus[mIndex];\r\n");
      out.write("\t \t\t   if(!compareAuthorities(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.currentAllAuthoritiesString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",tbMenu.authorities))continue;\r\n");
      out.write("\t \t\t   tree.add(tbMenu.id,tbMenu.pid,tbMenu.name,tbMenu.url,tbMenu.icon,tbMenu.icon,tbMenu.icon,tbMenu.description,tbMenu.position,true,{isRelativedPath:isRelativedPath});\r\n");
      out.write("          \r\n");
      out.write("               if(window.top['currentReloadMenuId']){\r\n");
      out.write("            \t   if(window.top['currentReloadMenuId']==tbMenu.id){\r\n");
      out.write("            \t\t   findLeftMenuTreeIndex = (tree.aNodes.length-1);\r\n");
      out.write("                   }\r\n");
      out.write("               }else{\r\n");
      out.write("            \t     /*if((tbMenu.children.length == 0)&&(-1 == findLeftMenuTreeIndex))\r\n");
      out.write("                     {\r\n");
      out.write("                  \t   findLeftMenuTreeIndex = (tree.aNodes.length-1);\r\n");
      out.write("                     }*/\r\n");
      out.write("               }\r\n");
      out.write("               recursionLeftTreeMenuData(tbMenu,tree,false);\r\n");
      out.write("\t \t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction choseDelegateUser(){\r\n");
      out.write("\t\t\tnew tracywindyCommonUserSelection({\r\n");
      out.write("\t\t\t\t hiddenInput:'id_delegateUser',\r\n");
      out.write("\t\t\t\t displayInput:'id_delegateRealName',\r\n");
      out.write("\t\t\t\t id:'commonUserDelgateChoseUser'\r\n");
      out.write("\t\t\t}).show();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doCheckTree(topMenuIndex,menuId){\r\n");
      out.write("\t\t\twindow.top['currentReloadMenuId'] = menuId;\r\n");
      out.write("\t\t\tdocument.getElementById(\"id_menuButton_\"+topMenuIndex).click();\r\n");
      out.write("\t   }\r\n");
      out.write(" </script>\r\n");
      out.write("\r\n");
      out.write("\t   ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t   <style type=\"text/css\">\r\n");
      out.write("\t      html,body{\r\n");
      out.write("\t         padding:0px;\r\n");
      out.write("\t         margin:0px;\r\n");
      out.write("\t         overflow:hidden;\r\n");
      out.write("\t      }\r\n");
      out.write("\t   </style>\r\n");
      out.write("\t   <script type=\"text/javascript\">\r\n");
      out.write("\t   var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/noMarkEmailNum.action\";\r\n");
      out.write("\t   var userId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("  \t   var params = {user_id:userId};\r\n");
      out.write("\t\t ajaxRequest({\r\n");
      out.write("\t    \t method:'POST',\r\n");
      out.write("\t         url:url,\r\n");
      out.write("\t         params:params,\r\n");
      out.write("\t         failure:function(res){\r\n");
      out.write("\t        \talert(\"获取邮件信息失败!\");\r\n");
      out.write("\t         },\r\n");
      out.write("\t         success:function(res){\r\n");
      out.write("\t \t   \t\tres=res.responseText;\r\n");
      out.write("\t \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t     \t    if(res!=''){\r\n");
      out.write("\t     \t    \tvar rs=JsonUtil.decode(res);\r\n");
      out.write("\t     \t    \t$(\"#emailNum\").html(\"(\"+rs['emailnum']+\")\");\r\n");
      out.write("\t     \t    \tif(0 != rs['emailnum']){\r\n");
      out.write("\t     \t    \t\tshwoMessageWindwos();\r\n");
      out.write("\t     \t    \t\tif(false == window.isAdminUser)$(\".panel-tool\").hide();\r\n");
      out.write("\t\t     \t    }\r\n");
      out.write("\t     \t    }else{\r\n");
      out.write("\t     \t    \talert(\"无结果返回,请重新尝试!\");\r\n");
      out.write("\t     \t    }\r\n");
      out.write("\t         }\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t    function showlogoutWindow(){\r\n");
      out.write("\t\t\t\t\tvar logout=window.confirm(\"该操作将注销用户身份，是否继续？\");\r\n");
      out.write("\t\t\t\t\tif(logout==true){\r\n");
      out.write("\t\t\t\t\t\twindow.top.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/j_spring_security_logout\";\r\n");
      out.write("\t\t\t\t\t\t\talert(\"注销成功！\");\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t   </script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\t\t<body >\r\n");
      out.write("       \t\t  <div id=\"id_loadMaskContainer\" style=\"display:block;\">\r\n");
      out.write("\t\t\t\t\t<div id=\"loading\">\r\n");
      out.write("\t\t\t\t\t    <div class=\"loading-indicator\">页面加载中   请稍等...</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t     jQuery(\"#id_loadMaskContainer\").css(\"height\",all_height);\r\n");
      out.write("\t\t\t  </script>\r\n");
      out.write("\t\t\t  <!--页面的头部包括头部logo背景图片和菜单栏-->\r\n");
      out.write("\t          <div class=\"header\" style=\"overflow:hidden;\" >\r\n");
      out.write("\t              <!--页面的头部包括头部logo背景图片-->\r\n");
      out.write("\t              <!-- fuck -->\r\n");
      out.write("\t\t\t      <div class=\"main_topbg\" id='id_mainPage_header'>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main_logo\"><a>德银融资租赁业务系统<font class=\"font_cls\"> </font></a></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main_logo_img\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"main_time\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t    ");
      if (_jspx_meth_spring_005fmessage_005f3(_jspx_page_context))
        return;
      out.write("&nbsp;&nbsp;<font color=\"#FF9238\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${('ZH' eq currentLoginSessionLanguage) ? sessionScope.login_realname : sessionScope.login_username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font>&nbsp;|\r\n");
      out.write("\t\t\t\t\t\t    <a href=\"javascript:void(0);\" onClick=\"javascript:shwoMessageWindwos(true);\" ><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons_w/mail.png\" style=\"top:3px;margin-right:5px;position:relative;\" border=\"0\" /><span id=\"emailNum\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t    <a href=\"javascript:void(0);\" onClick=\"javascript:showPersonalSettingWindow();\" >");
      if (_jspx_meth_spring_005fmessage_005f4(_jspx_page_context))
        return;
      out.write("</a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t    <a href=\"javascript:void(0);\" onClick=\"javascript:showModifyPasswordWindow();\" ><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons_w/cogs.png\" style=\"top:3px;margin-right:5px;position:relative;\" border=\"0\" />");
      if (_jspx_meth_spring_005fmessage_005f5(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t    <a id=\"id_delegateTooLink\" href=\"javascript:void(0);\" onClick=\"javascript:showDelegateWindow();\" ><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons_w/key.png\" style=\"top:3px;margin-right:5px;position:relative;\" border=\"0\" />");
      if (_jspx_meth_spring_005fmessage_005f6(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t    ");
      if (_jspx_meth_permission_005faction_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t        <a href=\"javascript:void(0);\" onClick=\"javascript:showlogoutWindow();\" style='text-decoration: none;' ><img style=\"top:3px;margin-right:5px;position:relative;\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons_w/on-off.png\" border=\"0\" />");
      if (_jspx_meth_spring_005fmessage_005f7(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t        <br/>\r\n");
      out.write("\t\t\t\t\t        <!--  \r\n");
      out.write("\t\t\t\t\t        ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t-->\r\n");
      out.write("\t\t\t\t\t\t  &nbsp;&nbsp;");
      if (_jspx_meth_spring_005fmessage_005f12(_jspx_page_context))
        return;
      out.write("&nbsp;&nbsp;<span id=\"dateZone\" ></span>\r\n");
      out.write("\t\t\t\t\t\t  ");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t  ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write(" \t\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  <!--菜单栏-->\t\r\n");
      out.write("\t\t\t\t  <div id=\"id_menu_container\" class=\"menu-container\">\r\n");
      out.write("\t\t\t\t     <div id=\"id_scroll_left\"><a class=\"scroll-left\" href=\"javascript:void(0);\">&lt;</a></div>\r\n");
      out.write("\t\t\t\t     <div class=\"toolbar-menu\" id=\"id_toolbar_menu\"></div>\r\n");
      out.write("\t\t\t\t     <script type=\"text/javascript\">jQuery(\"#id_toolbar_menu\").css(\"width\",(all_width-2)+\"px\")</script>\r\n");
      out.write("\t\t\t\t     <div id=\"id_scroll_right\"><a class=\"scroll-right\" href=\"javascript:void(0);\">&gt;</a></div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t\t<div style=\"padding-top:4px;padding-left:4px;padding-right:4px;\" onmouseover='jQuery(\"body>div.menu-top\").menu(\"hide\");'> <!--1112 helen change padding-top-->\t\r\n");
      out.write("\t\t\t\t<div id='main_content' style=\"border-right:0px;\">\r\n");
      out.write("\t\t\t\t\t<div region=\"center\"  style=\"overflow:hidden;border-width:0px;\" id='id_main_content_div'>\r\n");
      out.write("\t\t\t\t\t        <iframe style=\"overflow:auto;border-width:0px;width:100%;height:500px;display:block;\" name=\"name_iframe_content\" id='id_iframe_content' name=\"name_iframe_content\" frameBorder=0 src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/loadingIndex.html\"></iframe>\r\n");
      out.write("\t\t\t\t\t        <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t         var iframeContent = jQuery(\"#id_iframe_content\");\r\n");
      out.write("\t\t\t\t\t         iframeContent.css(\"width\",(iframe_clientWidth-6)+\"px\");\r\n");
      out.write("\t\t\t\t\t         iframeContent.css(\"height\",(iframe_clientHeight)+\"px\");\r\n");
      out.write("\t\t\t\t\t        </script>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 正文  结束>\r\n");
      out.write("\t\t\t<div class=\"scroll-menu\"><div id=\"id_scroll_content\" class=\"scroll-content\"></div></div -->\r\n");
      out.write("\t\t\t<!-- 结尾开始 -->\r\n");
      out.write("\t\t\t<div class=\"foot-above\"></div>\r\n");
      out.write("\t\t\t<!--Foot\r\n");
      out.write("\t\t\t\t<div class=\"foot\">\r\n");
      out.write("\t\t\t\t\t<div class=\"logoMark\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"copyRight\">\r\n");
      out.write("\t\t\t\t    \t<p>COPYRIGHT ©2012  CORPORATION ALL RIGHTS RESERVED.&nbsp;&nbsp;&nbsp;&nbsp;京公网安备 号</p>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t-->\r\n");
      out.write("\t\t\t<!-- 结尾结束 -->\r\n");
      out.write("\t\t\t<!--在线用户数量开始-->\r\n");
      out.write("\t\t\t  <div id=\"id_online_users\" closed=\"true\" modal=\"true\" title=\"当前在线人数（<font color='red'>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${online_user_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</font>）\" style=\"display:none;width:500px;height:300px;padding-top:10px;text-align:center;\">\r\n");
      out.write("\t\t        <center>\r\n");
      out.write("\t\t\t        <div style=\"width:90%;overflow:auto;\" class=\"window-inner-content\">\r\n");
      out.write("\t\t\t             <table width=\"100%\" >\r\n");
      out.write("\t\t\t                <tr><th>序号</th><th>登录时间</th><th>登录名</th><th>真实身份</th></tr>\r\n");
      out.write("\t\t\t                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t             </table>\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t        </center>\r\n");
      out.write("\t\t      </div>  \r\n");
      out.write("\t\t    <!--在线用户数量结束-->\r\n");
      out.write("\t\t\t<!-- 用户信息修改开始 -->\r\n");
      out.write("\t\t\t<div id=\"id_modifyPasswordDetailInfoForm\" closed=\"true\" modal=\"true\" title=\"用户信息修改\" style=\"display:none;width:400px;padding-top:10px;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t        <div style=\"padding-left:30px;\">\r\n");
      out.write("\t\t\t        <table  style=\"width:90%\">\r\n");
      out.write("\t\t\t            <tr style='height:10px;'></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">登录用户:</td><td class=\"input_value\"><input type=\"text\" id=\"id_userName\" disabled/></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">真实身份:</td><td class=\"input_value\"><input type=\"text\" id=\"id_realName\" disabled/></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">联系电话:</td><td class=\"input_value\"><input type=\"text\" id=\"id_telephone\" /></td><td><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">邮箱地址:</td><td class=\"input_value\"><input type=\"text\" id=\"id_email\" /></td><td><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">原始密码:</td><td class=\"input_value\"><input type=\"password\" id=\"id_oldPassword\"/></td><td><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">新密码:</td><td class=\"input_value\"><input type=\"password\" id=\"id_newPassword\"/></td><td><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">确认新密码:</td><td class=\"input_value\"><input type=\"password\" id=\"id_confirmNewPassword\"/></td><td><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t                <td colspan=3>\r\n");
      out.write("\t\t\t\t\t\t        <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='doModifyPasswordOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a  id=\"id_cancel_update_password\" style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_modifyPasswordDetailInfoForm\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t            </td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t        </table>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <!-- 用户信息修改结束 -->\r\n");
      out.write("\t\t\t<!-- 个人设置开始 -->\r\n");
      out.write("\t\t\t<div id=\"id_modifyPersonalSettingDetailInfoFormWindow\" closed=\"true\" modal=\"true\" title=\"个人设置\" style=\"display:none;width:500px;height:550px;\">\r\n");
      out.write("\t\t        <center>\r\n");
      out.write("\t\t\t        <div>\r\n");
      out.write("\t\t\t\t        <table  style=\"margin:auto;padding:auto;\">\r\n");
      out.write("\t\t\t\t            <tr><td>\r\n");
      out.write("\t\t\t\t                 <div id=\"id_personalSetting_tabs\" style=\"border:1px solid #DDD;height:450px;width:450px;\">\r\n");
      out.write("\t\t\t\t\t\t\t        <div title=\"快捷操作\">\r\n");
      out.write("\t\t\t\t\t\t\t            <table>\r\n");
      out.write("\t\t\t\t\t\t\t                <tr>\r\n");
      out.write("\t\t\t\t\t\t\t                   <td style=\"width:20px;\">&nbsp;</td><td><div id=\"id_personalSetting_treeContainer\" ></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t                </tr>\r\n");
      out.write("\t\t\t\t\t\t\t            </table>\r\n");
      out.write("\t\t\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t\t\t     </div>\r\n");
      out.write("\t\t\t\t             </td></tr>\r\n");
      out.write("\t\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t                <td >\r\n");
      out.write("\t\t\t\t\t\t\t        <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='distributeQuick();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_modifyPersonalSettingDetailInfoFormWindow\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t\t            </td>\r\n");
      out.write("\t\t\t\t            </tr>\r\n");
      out.write("\t\t\t\t        </table>\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t        </center>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <script>\r\n");
      out.write("\t            var  currentQuickCheckedNode = null;\r\n");
      out.write("\t            jQuery(function(){\r\n");
      out.write("\t\t            ajaxRequest({\r\n");
      out.write("\t\t            \turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/getUserQuickMenuTreeData.acl',\r\n");
      out.write("                        success:function(res){\r\n");
      out.write("                              jQuery('#id_personalSetting_treeContainer').tree({\r\n");
      out.write("\t\t\t        \t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t        \t\t\tcascadeCheck:false,\r\n");
      out.write("\t\t\t        \t\t\tdata:JsonUtil.decode(res.responseText),\r\n");
      out.write("\t\t\t        \t\t\tonlyLeafCheck:true/*,\r\n");
      out.write("\t\t\t        \t\t\tonLoadSuccess:function(a,b){\r\n");
      out.write("\t\t\t        \t\t\t\tjQuery(\"#id_personalSetting_treeContainer span.tree-checkbox\").click(function(e){\r\n");
      out.write("\t\t\t        \t\t\t\t\tdistributeQuickC(currentQuickCheckedNode);\r\n");
      out.write("\t\t\t        \t\t\t\t});\r\n");
      out.write("\t\t\t        \t\t    },\r\n");
      out.write("\t\t\t        \t\t\tonCheck:function(node,checked){\r\n");
      out.write("\t\t\t        \t\t    \tcurrentQuickCheckedNode = node;\r\n");
      out.write("\t\t\t        \t\t    }*/\r\n");
      out.write("\t\t\t        \t\t});\r\n");
      out.write("                        }\r\n");
      out.write("\t\t\t        });\r\n");
      out.write("\t\t        });\r\n");
      out.write("\t        \tfunction distributeQuick(){\r\n");
      out.write("\t        \t\tloadMask.show();\r\n");
      out.write("\t        \t\tvar checkedNodes = jQuery('#id_personalSetting_treeContainer').tree('getChecked');\r\n");
      out.write("\t        \t\tvar checkedNodesLen = checkedNodes.length;\r\n");
      out.write("\t        \t\tif(0 == checkedNodesLen){\r\n");
      out.write("\t\t        \t\t //alert(\"至少需要勾选一个快捷操作!\");\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t            var menuIdArr = [];\r\n");
      out.write("\t        \t\tfor(var i=0;i<checkedNodesLen;i++){\r\n");
      out.write("\t        \t\t\tmenuIdArr.push(checkedNodes[i].id);\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t                var entityClassName = \"QuickUserMenu\";\r\n");
      out.write("\t                var leftFieldName = \"user\";\r\n");
      out.write("\t                var leftId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t                var rightFieldName = \"menu\";\r\n");
      out.write("\t                var rightId = menuIdArr.join(\",\");\r\n");
      out.write("\t        \t    var params = {\r\n");
      out.write("\t        \t             entityClassName:entityClassName,\r\n");
      out.write("\t        \t       \t\t leftFieldName  :leftFieldName,\r\n");
      out.write("\t        \t       \t\t leftId         :leftId,\r\n");
      out.write("\t        \t       \t\t rightFieldName :rightFieldName,\r\n");
      out.write("\t        \t       \t\t rightId        :rightId\r\n");
      out.write("\t        \t     };\r\n");
      out.write("\t        \t\t var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/addOrRemoveQuickMenuDistribute.acl\";\r\n");
      out.write("\t                 ajaxRequest({\r\n");
      out.write("\t                      url:url,\r\n");
      out.write("\t                      params:params,\r\n");
      out.write("\t                      timeout:30*1000,\r\n");
      out.write("\t                      success:function(res){\r\n");
      out.write("\t                          alert(\"操作成功!\");\r\n");
      out.write("\t                          loadMask.hide();\r\n");
      out.write("\t                          var $iframeContent = jQuery(\"#id_iframe_content\")\r\n");
      out.write("\t                          var iframeContentSrc = $iframeContent.attr(\"src\");\r\n");
      out.write("\t                          if(iframeContentSrc.indexOf(\"/acl/index.bi\")>-1){\r\n");
      out.write("\t                        \t  $iframeContent.attr(\"src\",iframeContentSrc);\r\n");
      out.write("\t\t                      }\r\n");
      out.write("\t\t                      jQuery(\"#id_modifyPersonalSettingDetailInfoFormWindow\").window(\"close\");\r\n");
      out.write("\t                      }\r\n");
      out.write("\t                 });\r\n");
      out.write("\t            }\r\n");
      out.write("\t            function doCheckTreeByMenuId(firstLevelMenuId,menuId){\r\n");
      out.write("\t        \t\twindow.top['currentReloadMenuId'] = menuId;\r\n");
      out.write("\t        \t\tjQuery(\"a[id^='id_menuButton_'][firstLevelMenuId='\"+firstLevelMenuId+\"']\").click();\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t        </script>\r\n");
      out.write("\t        <!--个人设置结束 -->\r\n");
      out.write("\t        <!--站内信开始 -->\r\n");
      out.write("\t\t\t<div id=\"id_station_message\" closed=\"false\" modal=\"true\" title=\"消息管理\"  style=\"display:none;width:800px;height: 420px;overflow:hidden;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t        <div id=\"id_message_table\" style=\"padding:0px;\">\r\n");
      out.write("\t\t\t       <!--  <div title=\"未读消息\">\r\n");
      out.write("\t\t\t\t    \t<div id=\"id_message_list\"></div>\r\n");
      out.write("\t\t\t        </div> -->\r\n");
      out.write("\t\t\t        <div title=\"站内公告\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t        \t<div id=\"id_stationnotice_list\"></div>\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t\t        <div title=\"我的消息\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t        \t<div id=\"id_mynotice_list\"></div>\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t\t        <!-- <div title=\"发送消息\" style=\"\">\r\n");
      out.write("\t\t\t        \t<table  style=\"width:100%;text-indent:10px;border:1px solid #DDD;height: 300px;\">\r\n");
      out.write("\t\t\t\t            <tr style='height:10px;'></tr>\r\n");
      out.write("\t\t\t\t            <tr><td class=\"input_label_desc\" style='text-align:right'>收件人:</td><td class=\"input_value\"><input type=\"text\" id=\"id_send_names\" onclick=\"getTracywindyObject('id_sendMessageChoosor').show();\"/><input type=\"hidden\" id=\"id_send_names_id\"/></td></tr>\r\n");
      out.write("\t\t\t\t            <tr><td class=\"input_label_desc\" style='text-align:right'>发送内容:</td><td class=\"input_value\"><textarea id=\"id_send_contents\" style=\"width: 400px; height: 120px;\"></textarea></td></tr>\r\n");
      out.write("\t\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t                <td colspan=3 style=\"text-align:right;\">\r\n");
      out.write("\t\t\t\t\t\t\t        <a  style=\"margin-right:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='sendMessage();'><span>发送</span></a><span style=\"width:20px;display:inline-block;\">&nbsp;</span>\r\n");
      out.write("\t\t\t\t\t            </td>\r\n");
      out.write("\t\t\t\t            </tr>\r\n");
      out.write("\t\t\t\t        </table>\r\n");
      out.write("\t\t\t        \r\n");
      out.write("\t\t\t        </div> -->\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <!-- 站内信结束 -->\r\n");
      out.write("\t        <div id=\"myNoticeInfo\" buttons=\"#markRead\" closed=\"true\" modal=\"true\" title=\"我的消息\" style=\"width: 1000px; height: 800px;display: none;overflow-x:hidden;\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"messageBid\" id=\"messageBid\">\r\n");
      out.write("\t\t\t\t<form id=\"id_myNoticeInfoForm\">\r\n");
      out.write("\t\t\t\t<table style=\"width: 100%;border:1px #DDD solid;\" class=\"fillTable\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content-title\" style=\"width:15%;text-align: left;\">主题:</td>  \r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content\" style=\"width:35%;text-align: left;\"><span name=\"msgtitle\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<tr class=\"tr-odd\">\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content-title\" style=\"width:15%;text-align: left;\">上报时间:</td>  \r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content\" style=\"width:35%;text-align: left;\"><span name=\"senddate\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content-title\" style=\"width:15%;text-align: left;\">上报人:  </td>  \r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content\" style=\"width:35%;text-align: left;\"><span name=\"fromuser\"></span></td>\t\t\t  \r\n");
      out.write("\t\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t\t<tr class=\"tr-odd\">\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content-title\" style=\"width:15%;text-align: left;\">正文:  </td>  \r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content\" style=\"width:35%;text-align: left;\"><span name=\"msgtext\"></span></td>\t\t\t  \r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"markRead\" style=\"display:none;width:950px;height:40px;line-height:40px;border:0px solid #DDD;text-align:right;background:transparent;\">\r\n");
      out.write("\t\t\t\t\t<a style=\"\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='markAsRead(\"0\",true)'><span>标为已读</span></a>\r\n");
      out.write("\t\t\t\t\t<a style=\"\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='markAsRead(\"1\",true)'><span>标为未读</span></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t        <!-- 设置代理开始 -->\r\n");
      out.write("\t        <div id=\"id_setDelegateWindowContainer\"   closed=\"true\" modal=\"true\" title=\"流程授权   &lt;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('（');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("）&gt;\" style=\"display:none;width:804px;text-align:center;overflow:hidden;\">\r\n");
      out.write("\t           <div id=\"id_tableContainer\"></div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t\t\t<div id=\"id_setDelegateForm\"   closed=\"true\" modal=\"true\" title=\"<span style='margin-left:20px;'></span>委托授权\" style=\"display:none;width:420px;padding-top:10px;text-align:center;\">\r\n");
      out.write("\t\t        <center>\r\n");
      out.write("\t\t\t        <div style=\"width:96%\">\r\n");
      out.write("\t\t\t            <input type=\"hidden\" id=\"id_delegateUser\"/>\r\n");
      out.write("\t\t\t\t        <table align=\"center\" width=\"98%\">\r\n");
      out.write("\t\t\t\t            <tr style='height:10px;'></tr>\r\n");
      out.write("\t\t\t\t            <tr><td style='width:80px;' class=\"input_label_desc\">当前用户:</td><td class=\"input_value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('（');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login_username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("）</td></tr>\r\n");
      out.write("\t\t\t\t            <tr><td style='width:80px;' class=\"input_label_desc\">授权流程:</td><td class=\"input_value\"><label id=\"id_listAllWorflows\" ></label></td></tr>\r\n");
      out.write("\t\t\t\t            <tr><td style='width:80px;' class=\"input_label_desc\">授权对象:</td><td class=\"input_value\"><input type=\"text\" readonly id=\"id_delegateRealName\" style=\"border:1px solid silver;width:160px;\"/>&nbsp;<a type=\"button\" style=\"width:50px;\" class=\"btn btn-primary\"  href=\"javascript:void(0);\" onClick=\"javascript:choseDelegateUser();\">选择用户</a><font color='red' style=\"margin-left:2px;\">（必填）</font></td></tr>\t\t\t            \r\n");
      out.write("\t\t\t\t            <tr><td style='width:80px;' class=\"input_label_desc\">开始日期:</td><td class=\"input_value\"><input type=\"text\" readonly id=\"id_startDate\" class=\"Wdate\" style=\"border:1px solid silver;width:160px;\" onClick=\"WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t\t            <tr><td style='width:80px;' class=\"input_label_desc\">结束日期:</td><td class=\"input_value\"><input type=\"text\" readonly id=\"id_endDate\"   class=\"Wdate\" style=\"border:1px solid silver;width:160px;\" onClick=\"WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t\t            <tr class='content-separator'>\r\n");
      out.write("\t\t\t\t\t            <td colspan=2>\r\n");
      out.write("\t\t\t\t\t\t            <input class=\"btn btn-primary\" type=\"button\" value=\"确定\" onclick='javascript:setDelegate();'/>\r\n");
      out.write("\t\t\t\t\t\t            <input style=\"margin-left:20px;\" class=\"btn btn-primary\" type=\"button\" value=\"关闭\" onclick='javascript:jQuery(\"#id_setDelegateForm\").window(\"close\");'/>\r\n");
      out.write("\t\t\t\t\t            </td>\r\n");
      out.write("\t\t\t\t            </tr>\r\n");
      out.write("\t\t\t\t        </table>\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t        </center>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t      \t<form method=\"post\" target=\"fileDownloadIframe\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/downloadNoticeUploadFile.acl\" id=\"id_nameForm\">\r\n");
      out.write("\t\t\t  <input name=\"type\" type=\"hidden\" value=\"file\" />\r\n");
      out.write("\t\t\t  <input name=\"uuid\"  type=\"hidden\" value=\"\"/>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t      <!-- 设置代理结束 -->\r\n");
      out.write("\t      ");
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f2.setParent(null);
      // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(383,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setVar("dayOfWeek");
      // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(383,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setValue(new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"}[java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_WEEK)-1]);
      int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
      if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      out.write("\r\n");
      out.write("\t\t</body>\r\n");
      out.write("\t\t<!-- 站内信批量设置已读权限 -->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar tools=\"\";\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t");
      if (_jspx_meth_permission_005faction_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\" defer>\r\n");
      out.write("\t\t\tvar tableLoadFirst = false;\r\n");
      out.write("\t\t\tvar tableLoadSecond = false;\r\n");
      out.write("\t\t    jQuery(function(){\r\n");
      out.write("\t\t    \t loadAjaxTree(true);\r\n");
      out.write("\t\t\t\t oldClientWidth = window.document.body.clientWidth;\r\n");
      out.write("\t\t\t\t resizeOper(window.top);\r\n");
      out.write("\t\t         var iframeContent = jQuery(\"#id_iframe_content\");\r\n");
      out.write("\t\t         //加载主页信息\r\n");
      out.write("\t\t         setTimeout('iframeContent[0].src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.pageUrlPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("?mathRandomNumber=");
      out.print(new java.util.Random().nextLong() );
      out.write("\"',1000);\r\n");
      out.write("\t\t\t\t var myDate=new   Date(); \r\n");
      out.write("\t\t\t\t var myHour=myDate.getHours(); \r\n");
      out.write("\t\t\t\t //var arrayDay=[\"星期日\",\"星期一\",\"星期二\",\"星期三\",\"星期四\",\"星期五\",\"星期六\"]; \r\n");
      out.write("\t\t\t\t //var arrayDay =[\"Tuesday\"]; \r\n");
      out.write("\t\t\t\t //Monday 周一Tuesday 周二Wednesday 周三Thursday 周四Friday  周五Saturday 周六Sunday  周日\r\n");
      out.write("\t\t\t\t document.getElementById(\"dateZone\").innerHTML = myDate.getFullYear()+\"/\"+(myDate.getMonth()+1)+\"/\"+myDate.getDate()+\"&nbsp;&nbsp;\"+'");
      if (_jspx_meth_spring_005fmessage_005f15(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("\t\t\t\t jQuery(\".main_time\").show();\r\n");
      out.write("\t\t\t\t jQuery(\"#id_loadMaskContainer\").hide();\r\n");
      out.write("\t\t\t\t//站内公告\r\n");
      out.write("\t\t\t\t var mynotice = new tracywindyOperationTable({\r\n");
      out.write("\t\t\t\t   \t\t tableComment:'[站内公告]',\r\n");
      out.write("\t\t\t\t   \t     border:true,\r\n");
      out.write("\t\t\t\t         renderTo:'id_stationnotice_list',\r\n");
      out.write("\t\t\t\t         width:800,\r\n");
      out.write("\t\t\t\t         height:350,\r\n");
      out.write("\t\t\t\t         title:'站内公告',\r\n");
      out.write("\t\t\t\t         operButtons:'',\r\n");
      out.write("\t\t\t\t         id:'id_table_stationnotice_list',\r\n");
      out.write("\t\t\t\t         xmlFileName:'/eleasing/jsp/base/mynoticeInfo.xml',\r\n");
      out.write("\t\t\t\t         loadMode:'ajax',\r\n");
      out.write("\t\t\t\t         isPage:true,\r\n");
      out.write("\t\t\t\t         isFit:true,\r\n");
      out.write("\t\t\t\t         columns:[\r\n");
      out.write("\t\t\t\t\t            {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t\t\t\t\t            {header:'bid',name:'bid',hidden:true},\r\n");
      out.write("\t\t\t\t\t            {header:'正文',name:'msgtext',hidden:true},\r\n");
      out.write("\t\t\t\t\t            {header:'主题',name:'msgtitle',renderer:showMyNotice,queryConfig:{}},\r\n");
      out.write("\t\t\t\t\t            {header:'上报时间',name:'senddate'},\r\n");
      out.write("\t\t\t\t\t            {header:'上报人',name:'realname',queryConfig:{}},\r\n");
      out.write("\t\t\t\t\t            {header:'状态',name:'readstatus'}\r\n");
      out.write("\t\t\t\t        ],\r\n");
      out.write("\t\t\t\t        params:{\r\n");
      out.write("\t\t\t \t\t\t     MSG_TYPE:'msgtype.2',\r\n");
      out.write("\t\t\t \t\t\t     USER_ID:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t   \t });\r\n");
      out.write("\t\t         //我的消息\r\n");
      out.write("\t\t\t\t var mynotice = new tracywindyOperationTable({\r\n");
      out.write("\t\t\t\t   \t\t tableComment:'[我的消息]',\r\n");
      out.write("\t\t\t\t   \t     border:true,\r\n");
      out.write("\t\t\t\t   \t     title:'我的消息',\r\n");
      out.write("\t\t\t\t         operButtons:'',\r\n");
      out.write("\t\t\t\t         renderTo:'id_mynotice_list',\r\n");
      out.write("\t\t\t\t         width:790,\r\n");
      out.write("\t\t\t\t         height:350,\r\n");
      out.write("\t\t\t\t         id:'id_table_mynotice_list',\r\n");
      out.write("\t\t\t\t         xmlFileName:'/eleasing/jsp/base/mynoticeInfo.xml',\r\n");
      out.write("\t\t\t\t         loadMode:'ajax',\r\n");
      out.write("\t\t\t\t         isCheck:true,\r\n");
      out.write("\t\t\t\t         checkType:'checkbox',\r\n");
      out.write("\t\t\t\t         isPage:true,\r\n");
      out.write("\t\t\t\t         isFit:true,\r\n");
      out.write("\t\t\t\t         tools : tools,\r\n");
      out.write("\t\t\t\t         columns:[\r\n");
      out.write("\t\t\t\t\t            {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t\t\t\t\t            {header:'bid',name:'bid',hidden:true},\r\n");
      out.write("\t\t\t\t\t            {header:'正文',name:'msgtext',hidden:true},\r\n");
      out.write("\t\t\t\t\t            {header:'主题',name:'msgtitle',renderer:showMyNotice,queryConfig:{}},\r\n");
      out.write("\t\t\t\t\t            {header:'上报时间',name:'senddate'},\r\n");
      out.write("\t\t\t\t\t            {header:'上报人',name:'realname',queryConfig:{}},\r\n");
      out.write("\t\t\t\t\t            {header:'状态',name:'readstatus'}\r\n");
      out.write("\t\t\t\t        ],\r\n");
      out.write("\t\t\t\t        params:{\r\n");
      out.write("\t\t\t \t\t\t     MSG_TYPE:'msgtype.1',\r\n");
      out.write("\t\t\t \t\t\t     USER_ID:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t   \t });\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t   \t function showMyNotice(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t   \t\tvar base = \"<a href='javascript:void(0);' onclick='showMyNoticeInfo(\\\"\"+rowData.id+\"\\\",\\\"\"+rowData.bid+\"\\\",\\\"\"+rowData.readstatus+\"\\\")'>{1}</a>\";\r\n");
      out.write("\t\t        var updateFlag=value;\r\n");
      out.write("\t\t        var updateClickFunc=\"other\";\r\n");
      out.write("\t\t        var field=base.replace(\"{1}\",updateFlag);\r\n");
      out.write("\t\t        return field;\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t //readstatus(0只读，1未读) isprompt(标记成功后是否需要提示信息)\r\n");
      out.write("\t\t\t function markAsRead(readstatus,isprompt){\r\n");
      out.write("\t\t\t\tvar messageBid = $(\"#messageBid\").val();\r\n");
      out.write("\t\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/markAsRead.action\";\r\n");
      out.write("\t\t    \tvar params = {message_bid:messageBid,user_id:userId,read_status:readstatus};\r\n");
      out.write("\t\t\t\t ajaxRequest({\r\n");
      out.write("\t\t\t    \t method:'POST',\r\n");
      out.write("\t\t\t         url:url,\r\n");
      out.write("\t\t\t         params:params,\r\n");
      out.write("\t\t\t         failure:function(res){\r\n");
      out.write("\t\t\t        \talert(\"标记失败!\");\r\n");
      out.write("\t\t\t         },\r\n");
      out.write("\t\t\t         success:function(res){\r\n");
      out.write("\t\t\t \t   \t\tres=res.responseText;\r\n");
      out.write("\t\t\t \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t     \t    \tvar rs=JsonUtil.decode(res);\r\n");
      out.write("\t\t\t     \t    \tif(\"0\" == rs['readstatus']){\t\r\n");
      out.write("\t\t\t\t     \t    \tif(isprompt){\r\n");
      out.write("\t\t\t     \t    \t\t\talert(\"标记成功\");\r\n");
      out.write("\t\t\t\t\t     \t    }\r\n");
      out.write("\t\t     \t    \t\t\tvar currentTable = getTracywindyObject('id_table_mynotice_list');\r\n");
      out.write("\t\t\t     \t\t\t\tcurrentTable.reload();\r\n");
      out.write("\t\t\t\t     \t    \tcurrentTable = getTracywindyObject('id_table_stationnotice_list');\r\n");
      out.write("\t\t\t     \t\t\t\tcurrentTable.reload();\r\n");
      out.write("\t\t\t\t     \t    }\r\n");
      out.write("\t\t\t     \t    \tif(\"1\" == rs['readstatus']){\r\n");
      out.write("\t\t\t     \t    \t\tif(isprompt){\r\n");
      out.write("\t\t\t     \t    \t\t\talert(\"标记成功\");\r\n");
      out.write("\t\t\t\t\t     \t    }\r\n");
      out.write("\t\t     \t    \t\t\tvar currentTable = getTracywindyObject('id_table_mynotice_list');\r\n");
      out.write("\t\t\t     \t\t\t\tcurrentTable.reload();\r\n");
      out.write("\t\t\t\t     \t    \tcurrentTable = getTracywindyObject('id_table_stationnotice_list');\r\n");
      out.write("\t\t\t     \t\t\t\tcurrentTable.reload();\r\n");
      out.write("\t\t\t\t     \t    }\r\n");
      out.write("\t\t\t\t     \t    if(\"0\" == rs['readnum']){\r\n");
      out.write("\t\t\t\t     \t    \t$(\".panel-tool\").show();\r\n");
      out.write("\t\t\t\t     \t    \t$(\"#emailNum\").html(\"(0)\");\r\n");
      out.write("\t\t\t\t\t     \t}\r\n");
      out.write("\t\t\t     \t    }else{\r\n");
      out.write("\t\t\t     \t    \talert(\"无结果返回,请重新尝试!\");\r\n");
      out.write("\t\t\t     \t    }\r\n");
      out.write("\t\t\t         }\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t   function addNoticeAttachmentDownloadFunction($v)\r\n");
      out.write("\t\t\t   {\r\n");
      out.write("\t\t\t\t   $v.find(\"a.tracywindyFileDownLoadSpan\").each(function(i){\r\n");
      out.write("\t\t\t\t\t   this.style.cursor = \"pointer\";\r\n");
      out.write("\t\t\t\t\t   this.title = \"点击下载文件\";\r\n");
      out.write("\t\t\t\t\t   this.style.color = \"blue\";\r\n");
      out.write("\t\t\t\t\t   this.href=\"javascript:void(0)\";\r\n");
      out.write("\t\t\t\t\t   this.style.fontWeight = \"BOLD\";\r\n");
      out.write("\t\t\t\t\t   var oldClassStr = (this.className||\"\").replace(/\\s{1,}/gm,\" \");\r\n");
      out.write("\t\t\t\t\t   var oldClassArr = oldClassStr.split(\" \");\r\n");
      out.write("\t\t\t\t\t   for(var i=0;i<oldClassArr.length;i++){\r\n");
      out.write("\t\t\t\t\t\t   var className = oldClassArr[i]||\"\";\r\n");
      out.write("\t\t\t\t\t\t   if(0 == className.indexOf(\"uuid-\")){\r\n");
      out.write("\t\t\t\t\t\t\t   var uuid = className.substring(\"uuid-\".length,className.length);\r\n");
      out.write("\t\t\t\t\t\t\t   var clickFunc = (function(uuid){\r\n");
      out.write("\t\t\t\t\t\t\t\t   return function(e){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   jQuery(\"#id_nameForm input[name='uuid']\").val(uuid);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   jQuery(\"#id_nameForm\")[0].submit();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   return false;\r\n");
      out.write("\t\t\t\t\t\t\t\t   };\r\n");
      out.write("\t\t\t\t\t\t\t   })(uuid);\r\n");
      out.write("\t\t\t\t\t\t\t   this.onclick = clickFunc;\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t    function showMyNoticeInfo(messageId,messageBid,readstatus){\r\n");
      out.write("\t\t\t     $(\"#messageBid\").val(messageBid);\r\n");
      out.write("\t\t\t\t var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/myNoticeInfo.action\";\r\n");
      out.write("\t\t    \t var params = {message_id:messageId};\r\n");
      out.write("\t\t\t\t ajaxRequest({\r\n");
      out.write("\t\t\t    \t method:'POST',\r\n");
      out.write("\t\t\t         url:url,\r\n");
      out.write("\t\t\t         params:params,\r\n");
      out.write("\t\t\t         failure:function(res){\r\n");
      out.write("\t\t\t        \talert(\"访问服务器失败!\");\r\n");
      out.write("\t\t\t         },\r\n");
      out.write("\t\t\t         success:function(res){\r\n");
      out.write("\t\t\t \t   \t\tres=res.responseText;\r\n");
      out.write("\t\t\t \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t     \t    \tvar rs=JsonUtil.decode(res);\r\n");
      out.write("\t\t\t     \t    \t$(\"#myNoticeInfo span\").each(function(i, v){\r\n");
      out.write("\t\t\t\t   \t\t    \tvar $v = $(v);\r\n");
      out.write("\t\t\t\t   \t\t    \tvar name = $v.attr(\"name\");\r\n");
      out.write("\t\t\t\t\t   \t\t    if(name == \"msgtitle\"){\r\n");
      out.write("\t\t\t\t\t   \t\t    \t$v.html(rs['msgtitle']);\r\n");
      out.write("\t\t\t\t\t   \t\t    }\r\n");
      out.write("\t\t\t\t\t   \t\t    if(name == \"msgtext\"){\r\n");
      out.write("\t\t\t\t\t   \t\t    \t$v.html(rs['msgtext']);\r\n");
      out.write("\t\t\t\t\t   \t\t    \taddNoticeAttachmentDownloadFunction($v);\r\n");
      out.write("\t\t\t\t\t\t   \t\t}\r\n");
      out.write("\t\t\t\t\t\t   \t\tif(name == \"senddate\"){\r\n");
      out.write("\t\t\t\t\t   \t\t    \t$v.html(rs['senddate']);\r\n");
      out.write("\t\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t   \t\tif(name == \"fromuser\"){\r\n");
      out.write("\t\t\t\t\t   \t\t    \t$v.html(rs['fromuser']);\r\n");
      out.write("\t\t\t\t\t\t   \t\t}\r\n");
      out.write("\t\t\t\t   \t\t     })\r\n");
      out.write("\t\t\t     \t    }else{\r\n");
      out.write("\t\t\t     \t    \talert(\"无结果返回,请重新尝试!\");\r\n");
      out.write("\t\t\t     \t    }\r\n");
      out.write("\t\t\t         }\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t\t $(\"#myNoticeInfo\").show();\r\n");
      out.write("\t\t\t\t jQuery(\"#myNoticeInfo\").dialog({\r\n");
      out.write("\t\t\t        \tzIndex:9100,\r\n");
      out.write("\t\t\t        \tdraggable:true,\r\n");
      out.write("\t\t\t        \ttop:150,\r\n");
      out.write("\t\t\t        \tresizable:true,\r\n");
      out.write("\t\t\t        \tshadow:true,\r\n");
      out.write("\t\t\t        \tmodal:true,\r\n");
      out.write("\t\t\t        \tinline:false,\r\n");
      out.write("\t\t\t        \tcollapsible:false,\r\n");
      out.write("\t\t\t        \tminimizable:false,\r\n");
      out.write("\t\t\t        \tmaximizable:false,\r\n");
      out.write("\t\t\t        \tclosable:true,\r\n");
      out.write("\t\t\t        \tclosed:false\r\n");
      out.write("\t\t\t     });\r\n");
      out.write("\t\t\t\t markAsRead(\"0\",false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
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

  private boolean _jspx_meth_spring_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(9,11) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("FinancingLeaseBusinessSystem");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(9,11) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setText("FinancingLease");
    int[] _jspx_push_body_count_spring_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f0 = _jspx_th_spring_005fmessage_005f0.doStartTag();
      if (_jspx_th_spring_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f0 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f0.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/acl/main_include_js.jsp(31,2) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f0.setCode("admin_action");
    int _jspx_eval_permission_005faction_005f0 = _jspx_th_permission_005faction_005f0.doStartTag();
    if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t   var isAdminUser = true;\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f0);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f1 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/acl/main_include_js.jsp(184,27) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setCode("HomePage");
    // /WEB-INF/jsps/solutions/acl/main_include_js.jsp(184,27) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setText("HomePage");
    int[] _jspx_push_body_count_spring_005fmessage_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f1 = _jspx_th_spring_005fmessage_005f1.doStartTag();
      if (_jspx_th_spring_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f1.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f2 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/acl/main_include_js.jsp(1146,53) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f2.setCode("MenuMap");
    // /WEB-INF/jsps/solutions/acl/main_include_js.jsp(1146,53) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f2.setText("MenuMap");
    int[] _jspx_push_body_count_spring_005fmessage_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f2 = _jspx_th_spring_005fmessage_005f2.doStartTag();
      if (_jspx_th_spring_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f2.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(14,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'true' eq isHasExistUser}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t       <script type=\"text/javascript\" >\r\n");
        out.write("\t\t\tfunction closeWindow()\r\n");
        out.write("\t\t\t{\r\n");
        out.write("\t\t\t\ttry{window.opener=null;window.open(\"\",\"_self\");window.close();}catch(e){window.close();}\r\n");
        out.write("\t\t\t}\r\n");
        out.write("\t        if(confirm(\"用户");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isHasExistUserRealName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write('（');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isHasExistUserName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("）已在线，是否继续登录，原用户将被强行注销？\")){\r\n");
        out.write("\t\t          ajaxRequest({\r\n");
        out.write("\t\t\t          url:'");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/acl/removeUserSession.acl',\r\n");
        out.write("\t\t\t          async:false,\r\n");
        out.write("\t\t\t          success:function(res){\r\n");
        out.write("\t\t\t\t          \r\n");
        out.write("\t\t\t\t      },\r\n");
        out.write("\t\t\t\t      failure:function(res){\r\n");
        out.write("\t\t\t\t\t  },\r\n");
        out.write("\t\t\t          params:{\r\n");
        out.write("\t\t\t\t          userId:\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isHasExistUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"\r\n");
        out.write("\t\t\t          }\r\n");
        out.write("\t\t          });\r\n");
        out.write("\t\t    }else{\r\n");
        out.write("\t\t\t      try{\r\n");
        out.write("\t\t\t    \t  //closeWindow();  \r\n");
        out.write("\t\t\t    \t  window.location.href = \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/closeWindow.jsp\";\r\n");
        out.write("\t\t\t\t  }catch(e){}\r\n");
        out.write("\t\t\t}\r\n");
        out.write("\t       </script>\r\n");
        out.write("\t   ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f3 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(101,10) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f3.setCode("Welcome");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(101,10) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f3.setText("Welcome");
    int[] _jspx_push_body_count_spring_005fmessage_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f3 = _jspx_th_spring_005fmessage_005f3.doStartTag();
      if (_jspx_th_spring_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f3.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f4 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f4.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(103,91) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f4.setCode("PersonalSetting");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(103,91) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f4.setText("个人设置");
    int[] _jspx_push_body_count_spring_005fmessage_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f4 = _jspx_th_spring_005fmessage_005f4.doStartTag();
      if (_jspx_th_spring_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f4.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f5 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f5.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(104,222) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f5.setCode("Modify");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(104,222) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f5.setText("Modify");
    int[] _jspx_push_body_count_spring_005fmessage_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f5 = _jspx_th_spring_005fmessage_005f5.doStartTag();
      if (_jspx_th_spring_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f5.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f6 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f6.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f6.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(105,239) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f6.setCode("Delegate");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(105,239) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f6.setText("Delegate");
    int[] _jspx_push_body_count_spring_005fmessage_005f6 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f6 = _jspx_th_spring_005fmessage_005f6.doStartTag();
      if (_jspx_th_spring_005fmessage_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f6.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f6);
    }
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f1 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f1.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(106,10) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f1.setCode("dealer_action");
    int _jspx_eval_permission_005faction_005f1 = _jspx_th_permission_005faction_005f1.doStartTag();
    if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f1.doInitBody();
      }
      do {
        out.write("<script type=\"text/javascript\">jQuery(\"#id_delegateTooLink\").hide();</script>");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f1);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f7(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f7 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f7.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f7.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(107,250) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f7.setCode("Logout");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(107,250) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f7.setText("Logout");
    int[] _jspx_push_body_count_spring_005fmessage_005f7 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f7 = _jspx_th_spring_005fmessage_005f7.doStartTag();
      if (_jspx_th_spring_005fmessage_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f7.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f7);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t   ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t   ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(111,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'ZH' eq currentLoginSessionLanguage}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t       <a style=\"color:#FF9238\" target=\"_self\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/acl/changeLocale.acl?locale=en_US&reloadPageUrl=acl/index.acl\">");
        if (_jspx_meth_spring_005fmessage_005f8(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_spring_005fmessage_005f9(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t\t\t   ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f8 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f8.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(112,158) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f8.setCode("ChangeTo");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(112,158) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f8.setText("ChangeTo");
    int[] _jspx_push_body_count_spring_005fmessage_005f8 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f8 = _jspx_th_spring_005fmessage_005f8.doStartTag();
      if (_jspx_th_spring_005fmessage_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f8.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f8);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f9 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f9.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(112,208) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f9.setCode("English");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(112,208) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f9.setText("English");
    int[] _jspx_push_body_count_spring_005fmessage_005f9 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f9 = _jspx_th_spring_005fmessage_005f9.doStartTag();
      if (_jspx_th_spring_005fmessage_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f9[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f9.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f9.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f9);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t      <a style=\"color:#FF9238\" target=\"_self\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/acl/changeLocale.acl?locale=zh_CN&reloadPageUrl=acl/index.acl\">");
        if (_jspx_meth_spring_005fmessage_005f10(_jspx_th_c_005fotherwise_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_spring_005fmessage_005f11(_jspx_th_c_005fotherwise_005f0, _jspx_page_context))
          return true;
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t\t\t   ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f10 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f10.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(115,157) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f10.setCode("ChangeTo");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(115,157) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f10.setText("ChangeTo");
    int[] _jspx_push_body_count_spring_005fmessage_005f10 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f10 = _jspx_th_spring_005fmessage_005f10.doStartTag();
      if (_jspx_th_spring_005fmessage_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f10[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f10.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f10.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f10);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f11 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f11.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(115,207) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f11.setCode("Chinese");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(115,207) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f11.setText("Chinese");
    int[] _jspx_push_body_count_spring_005fmessage_005f11 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f11 = _jspx_th_spring_005fmessage_005f11.doStartTag();
      if (_jspx_th_spring_005fmessage_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f11[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f11.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f11.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f11);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f12(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f12 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f12.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f12.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(119,20) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f12.setCode("Today");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(119,20) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f12.setText("Today");
    int[] _jspx_push_body_count_spring_005fmessage_005f12 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f12 = _jspx_th_spring_005fmessage_005f12.doStartTag();
      if (_jspx_th_spring_005fmessage_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f12[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f12.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f12.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f12);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(120,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("upperLoginUserName");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(120,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:toUpperCase(sessionScope['login_username'])}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, _jspx_fnmap_0, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(121,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${('ADMINISTRATOR' eq upperLoginUserName) or ('ADMIN' eq upperLoginUserName)}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("|\r\n");
        out.write("\t\t\t\t\t\t    ");
        if (_jspx_meth_spring_005fmessage_005f13(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("<a style=\"text-decoration:none;\" href=\"javascript:void(0);\" onClick=\"javascript:showOnlineUsersWindow();\">&nbsp;<font color=\"#FF9238\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.online_user_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</font>&nbsp;</a>");
        if (_jspx_meth_spring_005fmessage_005f14(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t  ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f13 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f13.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(122,10) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f13.setCode("Online");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(122,10) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f13.setText("Online");
    int[] _jspx_push_body_count_spring_005fmessage_005f13 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f13 = _jspx_th_spring_005fmessage_005f13.doStartTag();
      if (_jspx_th_spring_005fmessage_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f13[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f13.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f13.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f13);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f14 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f14.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(122,240) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f14.setCode("User");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(122,240) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f14.setText("User");
    int[] _jspx_push_body_count_spring_005fmessage_005f14 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f14 = _jspx_th_spring_005fmessage_005f14.doStartTag();
      if (_jspx_th_spring_005fmessage_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f14[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f14.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f14.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f14);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(165,19) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("varStatus");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(165,19) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${onlineUsers}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(165,19) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("loginInfo");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t                   ");
          if (_jspx_meth_c_005fset_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t                   <tr><td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${varStatus.index+1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td><td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.loginTime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td><td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td><td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td></tr>\r\n");
          out.write("\t\t\t                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(166,22) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("user");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(166,22) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.loginUser}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f2 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f2.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(389,2) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f2.setCode("mynoticemulti");
    int _jspx_eval_permission_005faction_005f2 = _jspx_th_permission_005faction_005f2.doStartTag();
    if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t<script type=\"text/javascript\">\r\n");
        out.write("\t\t\t\tvar tools=[ {\r\n");
        out.write("\t\t  \t\t\thtml : '<font color=\"red\">设置为已读</font>',\r\n");
        out.write("\t\t  \t\t\thandler : function(table) {\r\n");
        out.write("\t\t \t\t\t\tvar checkedRowdata = table.getCheckedRowDatas();\r\n");
        out.write("\t\t \t\t\t\tdebugger;\r\n");
        out.write("\t\t \t\t\t\tif (0 == checkedRowdata.length) {\r\n");
        out.write("\t\t \t\t\t\t\talert(\"请选择需要修改的数据！\");\r\n");
        out.write("\t\t \t\t\t\t\treturn false;\r\n");
        out.write("\t\t \t\t\t\t}\r\n");
        out.write("\t\t \t\t\t\tvar tempIdArr = [];\r\n");
        out.write("\t\t \t\t\t\tfor(var i = 0;i<checkedRowdata.length;i++){\r\n");
        out.write("\t\t \t\t\t\t\tvar id = checkedRowdata[i].bid;\r\n");
        out.write("\t\t \t\t\t\t\ttempIdArr.push(id);\r\n");
        out.write("\t\t \t\t\t\t}\r\n");
        out.write("\t\t \t\t\t\tvar params = {};\r\n");
        out.write("\t\t \t\t\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
        out.write("\t\t \t\t\t\tparams[\"user_id\"]=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\";\r\n");
        out.write("\t\t \t\t\t\tparams[\"read_status\"]=\"0\";\r\n");
        out.write("\t\t\t\t\t\tvar url = \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/leasing/markMultiAsRead.action\";\r\n");
        out.write("\t\t\t\t\t\tajaxRequest({\r\n");
        out.write("\t\t\t\t\t    \t method:'POST',\r\n");
        out.write("\t\t\t\t\t         url:url,\r\n");
        out.write("\t\t\t\t\t         params:params,\r\n");
        out.write("\t\t\t\t\t         failure:function(res){\r\n");
        out.write("\t\t\t\t\t        \talert(\"标记失败!\");\r\n");
        out.write("\t\t\t\t\t         },\r\n");
        out.write("\t\t\t\t\t         success:function(res){\r\n");
        out.write("\t\t\t\t\t \t   \t\tres=res.responseText;\r\n");
        out.write("\t\t\t\t\t \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
        out.write("\t\t\t\t\t     \t    if(res!=''){\r\n");
        out.write("\t\t\t\t\t     \t    \tvar rs=JsonUtil.decode(res);\r\n");
        out.write("\t\t\t\t\t     \t    \tif(\"0\" == rs['readstatus']){\t\r\n");
        out.write("\t\t\t\t\t     \t    \t\t\talert(\"标记成功\");\r\n");
        out.write("\t\t\t\t     \t    \t\t\tvar currentTable = getTracywindyObject('id_table_mynotice_list');\r\n");
        out.write("\t\t\t\t\t     \t\t\t\tcurrentTable.reload();\r\n");
        out.write("\t\t\t\t\t\t     \t    }\r\n");
        out.write("\t\t\t\t\t     \t    \t\r\n");
        out.write("\t\t\t\t\t\t     \t    if(\"0\" == rs['readnum']){\r\n");
        out.write("\t\t\t\t\t\t     \t    \t$(\".panel-tool\").show();\r\n");
        out.write("\t\t\t\t\t\t     \t    \t$(\"#emailNum\").html(\"(0)\");\r\n");
        out.write("\t\t\t\t\t\t\t     \t}\r\n");
        out.write("\t\t\t\t\t     \t    }else{\r\n");
        out.write("\t\t\t\t\t     \t    \talert(\"无结果返回,请重新尝试!\");\r\n");
        out.write("\t\t\t\t\t     \t    }\r\n");
        out.write("\t\t\t\t\t         }\r\n");
        out.write("\t\t\t\t\t    });\r\n");
        out.write("\t\t  \t\t\t}\r\n");
        out.write("\t\t     }];\r\n");
        out.write("\t\t</script >\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f2);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f15(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f15 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f15.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f15.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(456,137) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f15.setCode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dayOfWeek}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_index.jsp(456,137) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f15.setText((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dayOfWeek}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_spring_005fmessage_005f15 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f15 = _jspx_th_spring_005fmessage_005f15.doStartTag();
      if (_jspx_th_spring_005fmessage_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f15[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f15.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f15.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f15);
    }
    return false;
  }
}