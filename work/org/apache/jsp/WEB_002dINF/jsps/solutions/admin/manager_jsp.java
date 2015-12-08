package org.apache.jsp.WEB_002dINF.jsps.solutions.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>系统后台管理</title>\r\n");
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
      out.write("/js/validator.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyCommonUserSelection.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("       var loadMask = null;\r\n");
      out.write("       function xmlDataSynchronized(){\r\n");
      out.write("           if(!window.confirm(\"确认XML数据同步么？\"))\r\n");
      out.write("           {\r\n");
      out.write("               return false;\r\n");
      out.write("           }\r\n");
      out.write("           if(null == loadMask){\r\n");
      out.write("        \t   loadMask = new  tracywindyLoadMask(document.body,\"数据加载中 请稍等...\");\r\n");
      out.write("           }\r\n");
      out.write("           loadMask.show();\r\n");
      out.write("           ajaxRequest({\r\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/updateXmlData.acl',\r\n");
      out.write("                timeout:30*60*1000,\r\n");
      out.write("                success:function(response){\r\n");
      out.write("                     alert(\"XML数据同步成功！\");\r\n");
      out.write("                     loadMask.hide();\r\n");
      out.write("                }\r\n");
      out.write("           });\r\n");
      out.write("       }\r\n");
      out.write("       function permissionSynchronized(){\r\n");
      out.write("           if(!window.confirm(\"确认权限同步么？\"))\r\n");
      out.write("           {\r\n");
      out.write("               return false;\r\n");
      out.write("           }\r\n");
      out.write("           if(null == loadMask){\r\n");
      out.write("        \t   loadMask = new  tracywindyLoadMask(document.body,\"数据加载中 请稍等...\");\r\n");
      out.write("           }\r\n");
      out.write("           loadMask.show();\r\n");
      out.write("           ajaxRequest({\r\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/updatePermission.acl',\r\n");
      out.write("                timeout:30*60*1000,\r\n");
      out.write("                success:function(response){\r\n");
      out.write("                     alert(\"权限同步成功！\");\r\n");
      out.write("                     loadMask.hide();\r\n");
      out.write("                     window.location.href = window.location.href ;\r\n");
      out.write("                }\r\n");
      out.write("           });\r\n");
      out.write("       }\r\n");
      out.write("       function changeSystemModel(){\r\n");
      out.write("           if(!window.confirm(\"确认切换系统模式？\"))\r\n");
      out.write("           {\r\n");
      out.write("               return false;\r\n");
      out.write("           }\r\n");
      out.write("           if(null == loadMask){\r\n");
      out.write("        \t   loadMask = new  tracywindyLoadMask(document.body,\"数据加载中 请稍等...\");\r\n");
      out.write("           }\r\n");
      out.write("           loadMask.show();\r\n");
      out.write("           ajaxRequest({\r\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/updateSystemMode.acl',\r\n");
      out.write("                timeout:30*60*1000,\r\n");
      out.write("                success:function(response){\r\n");
      out.write("                     alert(\"系统模式切换成功！\");\r\n");
      out.write("                     loadMask.hide();\r\n");
      out.write("                     window.location.href = window.location.href ;\r\n");
      out.write("                }\r\n");
      out.write("           });\r\n");
      out.write("       }\r\n");
      out.write("       function workflowSynchronized(flag){\r\n");
      out.write("    \t   var flagComment = flag ? \"选中\" : \"全部\";\r\n");
      out.write("           if(!window.confirm(\"确认同步\"+flagComment+\"流程么？\"))\r\n");
      out.write("           {\r\n");
      out.write("               return false;\r\n");
      out.write("           }\r\n");
      out.write("    \t   if(!Validator.Validate(jQuery(\"#id_workflowSynchronizedContainer\")[0],1,false)){\r\n");
      out.write("        \t   return;\r\n");
      out.write("           }\r\n");
      out.write("           if(null == loadMask){\r\n");
      out.write("        \t   loadMask = new  tracywindyLoadMask(document.body,\"数据加载中 请稍等...\");\r\n");
      out.write("           }\r\n");
      out.write("           loadMask.show();\r\n");
      out.write("           var params = jQuery(\"#id_workflowSynchronizedContainer\").tracywindySerializeFormToJsonObject(true);\r\n");
      out.write("           if(!flag){\r\n");
      out.write("        \t   delete params[\"updateWorkflowIds\"];\r\n");
      out.write("           }else{\r\n");
      out.write("        \t   if(!jQuery(\"#id_updateWorkflowIds\").val()){\r\n");
      out.write("        \t\t   alert(\"请选择需要同步的流程！\");\r\n");
      out.write("        \t\t   jQuery(\"#id_updateWorkflowIds\").focus();\r\n");
      out.write("        \t\t   loadMask.hide();\r\n");
      out.write("        \t   }\r\n");
      out.write("           }\r\n");
      out.write("           ajaxRequest({\r\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/updateWorkflowConfigSynchronized.action',\r\n");
      out.write("                timeout:30*60*1000,\r\n");
      out.write("                method:\"post\",\r\n");
      out.write("                success:function(response){\r\n");
      out.write("                     alert(\"流程同步成功！\");\r\n");
      out.write("                     loadMask.hide();\r\n");
      out.write("                     window.location.href = window.location.href ;\r\n");
      out.write("                },\r\n");
      out.write("                params:params\r\n");
      out.write("           });\r\n");
      out.write("       }\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("    \tbody fieldset{\r\n");
      out.write("    \t\ttext-align:center;\r\n");
      out.write("    \t\tfloat:left;\r\n");
      out.write("    \t\tmargin-top:20px;\r\n");
      out.write("    \t\tmargin-left:20px;\r\n");
      out.write("    \t\tborder:1px solid silver;\r\n");
      out.write("    \t\tpadding-top:10px;\r\n");
      out.write("    \t\tpadding-left:20px;\r\n");
      out.write("    \t\twidth:200px;\r\n");
      out.write("    \t\theight: 70px;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \tbody fieldset font{\r\n");
      out.write("    \t\tcolor: red;\r\n");
      out.write("    \t\tfont-weight:BOLD;\r\n");
      out.write("    \t}\r\n");
      out.write("    \r\n");
      out.write("   \t\tbody fieldset a.btn{\r\n");
      out.write("    \t\twidth:auto;\r\n");
      out.write("    \t\tmargin-top:10px;\r\n");
      out.write("    \t\tmin-width: 100px;\r\n");
      out.write("    \t\tfont-size: 12px;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t.fl{\r\n");
      out.write("    \t\tfloat: left;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t.data-source-config input,.data-source-config textarea{\r\n");
      out.write("    \t\twidth:200px;\r\n");
      out.write("    \t\tborder:1px solid #DDD;\r\n");
      out.write("    \t\toverflow:auto;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t.data-source-config font{\r\n");
      out.write("    \t\twidth:100px;\r\n");
      out.write("    \t\ttext-align:center;\r\n");
      out.write("    \t\tmargin-left:10px;\r\n");
      out.write("    \t\tcolor:red;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t.data-source-config td{\r\n");
      out.write("    \t\ttext-align: right;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("    \t#id_contentContainer{\r\n");
      out.write("    \t\tborder:1px solid #DDD;\r\n");
      out.write("    \t\tborder-top:0px;\r\n");
      out.write("    \t\toverflow: auto;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tbody{\r\n");
      out.write("    \t  overflow-x:hidden;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t#id_updateWorkflowIds_display{\r\n");
      out.write("    \t  height:100px;\r\n");
      out.write("    \t}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div id=\"id_contentContainer\">\r\n");
      out.write("   \t\t<div>\r\n");
      out.write("\t\t   \t<div class=\"fl\">\r\n");
      out.write("\t\t\t   <fieldset>\r\n");
      out.write("\t\t\t      <legend>模式变更</legend>\r\n");
      out.write("\t\t\t      ");
if(!com.kernal.utils.ResourceUtil.isDebug()){
      out.write("  \r\n");
      out.write("\t\t\t         <font>上线模式</font><br/><a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"changeSystemModel();\" >转为 &nbsp;&lt;&nbsp;<font>开发</font> &nbsp;&gt;&nbsp;模式</a>\r\n");
      out.write("\t\t\t      ");
}else{
      out.write("  \r\n");
      out.write("\t\t\t         <font>开发模式</font><br/><a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"changeSystemModel();\" >转为 &nbsp;&lt;&nbsp;<font>上线 </font>&nbsp;&gt;&nbsp;模式</a>\r\n");
      out.write("\t\t\t      ");
}
      out.write("\r\n");
      out.write("\t\t\t   </fieldset>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"fl\">\r\n");
      out.write("\t\t\t   <fieldset>\r\n");
      out.write("\t\t\t      <legend>XML数据同步</legend>\r\n");
      out.write("\t\t\t      <font>XML数据同步&nbsp;</font><br/>\r\n");
      out.write("\t\t\t      <a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"xmlDataSynchronized();\">同&nbsp;步&nbsp;变&nbsp;动 </a>\r\n");
      out.write("\t\t\t   </fieldset>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"fl\">\r\n");
      out.write("\t\t\t   <fieldset>\r\n");
      out.write("\t\t\t      <legend>模板移位</legend>\r\n");
      out.write("\t\t\t      <font>模板移位&nbsp;</font><br/>\r\n");
      out.write("\t\t\t      <a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"removerTemplate();\">模&nbsp;板&nbsp;移&nbsp;位 </a>\r\n");
      out.write("\t\t\t   </fieldset>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"fl\">\r\n");
      out.write("\t\t\t   <fieldset>\r\n");
      out.write("\t\t\t      <legend>权限同步</legend>\r\n");
      out.write("\t\t\t      ");
if(com.kernal.utils.ResourceUtil.isNeedUpdatePermissionCache()){
      out.write("  \r\n");
      out.write("\t\t\t         <font>存在权限变动&nbsp;</font><br/><a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"permissionSynchronized();\">同&nbsp;步&nbsp;变&nbsp;动 </a>\r\n");
      out.write("\t\t\t      ");
}else{
      out.write("  \r\n");
      out.write("\t\t\t         <font>不存在权限变动</font>\r\n");
      out.write("\t\t\t      ");
}
      out.write("\r\n");
      out.write("\t\t\t   </fieldset>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"clear: both;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"data-source-config\">\r\n");
      out.write("\t\t   <fieldset style=\"width:auto;height: auto;\">\r\n");
      out.write("\t\t      <legend>流程数据库同步</legend>\r\n");
      out.write("\t\t      <table id=\"id_workflowSynchronizedContainer\">\r\n");
      out.write("\t\t         <tr><td>源数据库类型：</td><td><select label=\"源数据库类型\" Require=\"true\" name=\"type\" style=\"width:204px;;border:1px solid #DDD;\"><option value=\"oracle\" selected>oracle</option><option value=\"sqlserver\">sqlserver</option></select><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td>源数据库地址：</td><td><input label=\"源数据库地址\" Require=\"true\"  value=\"\" name=\"host\"></input><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td>源数据库端口：</td><td><input label=\"源数据库端口\" Require=\"true\"  value=\"1521\" name=\"port\"></input><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td>源数据库库名/服务名：</td><td><input label=\"源数据库库名/服务名\" Require=\"true\"  value=\"orcl\" name=\"dbname\"></input><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td>源数据库用户名：</td><td><input label=\"源数据库用户名\" Require=\"true\"  value=\"\" name=\"user\"></input><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td>源数据库密码：</td><td><input type=\"password\" label=\"源数据库密码\" Require=\"true\"  value=\"\" name=\"password\"></input><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td>需要同步的流程：</td><td><textarea readonly onclick=\"getUpdateWorkflow();\" id=\"id_updateWorkflowIds_display\" name=\"updateWorkflowIds_display\" label=\"需要同步的流程\" Require=\"false\"  value=\"\"></textarea><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr style=\"display:none\" ><td>需要同步的流程：</td><td><textarea readonly id=\"id_updateWorkflowIds\" name=\"updateWorkflowIds\" label=\"需要同步的流程\" Require=\"false\"  value=\"\" ></textarea><font>*</font></td></tr>\r\n");
      out.write("\t\t         <tr><td style=\"height:20px;\">&nbsp;</td></tr>\r\n");
      out.write("\t\t         <tr><td colspan=2 style=\"text-align:center;\"><a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"workflowSynchronized(true);\">同步选中流程</a>&nbsp;&nbsp;<a class=\"btn btn-primary\" href=\"javascript:void(0);\" onclick=\"workflowSynchronized(false);\">同步全部流程</a></td></tr>\r\n");
      out.write("\t\t      </table>\r\n");
      out.write("\t\t   </fieldset>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("   </div>\r\n");
      out.write("   <script type='text/javascript'>\r\n");
      out.write("         $(\"#id_contentContainer\").css(\"height\",$(window).height()-2);\r\n");
      out.write("         function removerTemplate(){\r\n");
      out.write("      \t   \r\n");
      out.write("      \t   var url=\"/leasing/template/removeTempalate.action\";\r\n");
      out.write("      \t   alert(1);\r\n");
      out.write("      \t    ajaxRequest({\r\n");
      out.write("      \t\t     url:getRootPath()+url,\r\n");
      out.write("      \t\t     method:'POST',\r\n");
      out.write("      \t\t     success:function(rs){\r\n");
      out.write("      \t\t        alert(rs.responseText);\r\n");
      out.write("      \t   \t     },\r\n");
      out.write("      \t\t     async:false,\r\n");
      out.write("      \t\t     failure:function(res){\r\n");
      out.write("      \t   \t\t\r\n");
      out.write("                 }\r\n");
      out.write("      \t   });\r\n");
      out.write("       \r\n");
      out.write("        }  \r\n");
      out.write("         var selectionUpdateWorkflowIds =  null;\r\n");
      out.write("         function getUpdateWorkflow()\r\n");
      out.write("         {\r\n");
      out.write("        \tvar params = jQuery(\"#id_workflowSynchronizedContainer\").tracywindySerializeFormToJsonObject(true);\r\n");
      out.write("        \tif(null == selectionUpdateWorkflowIds){\r\n");
      out.write("\t           \t selectionUpdateWorkflowIds =  new tracywindyCommonUserSelection({\r\n");
      out.write("\t\t\t\t\t    hiddenInput:\"id_updateWorkflowIds\",\r\n");
      out.write("\t\t\t\t\t    displayInput:\"id_updateWorkflowIds_display\",\r\n");
      out.write("\t\t\t\t\t    isMultiSelect:true,\r\n");
      out.write("\t\t\t\t\t    draggable:false,\r\n");
      out.write("\t\t\t\t\t    windowTop:1,\r\n");
      out.write("\t\t\t\t\t    id:\"id_selectionUpdateWorkflowIds\",\r\n");
      out.write("\t\t\t\t\t    type:'synchronizedWorkflowDesigners',\r\n");
      out.write("\t\t\t\t\t    params:params\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("        \t}else{\r\n");
      out.write("        \t\tselectionUpdateWorkflowIds.setParams(params);\r\n");
      out.write("        \t\tselectionUpdateWorkflowIds.reload();\r\n");
      out.write("        \t}\r\n");
      out.write("        \tselectionUpdateWorkflowIds.show();\r\n");
      out.write("         }\r\n");
      out.write("   </script>\r\n");
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
