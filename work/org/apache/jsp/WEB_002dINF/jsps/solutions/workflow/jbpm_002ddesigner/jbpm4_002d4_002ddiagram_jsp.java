package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002ddesigner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jbpm4_002d4_002ddiagram_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(2);
    _jspx_dependants.add("/WEB-INF/jsps/solutions/workflow/jbpm-designer/designerCoreJS.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>流程图查看</title>\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jbpmDesigner/jquery-ui-1.8.4.custom.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   html{\r\n");
      out.write("      overflow:auto;\r\n");
      out.write("   }\r\n");
      out.write("   body{\r\n");
      out.write("      overflow:auto;\r\n");
      out.write("   }\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var displayName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.display_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var type = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var code = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var position = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.position}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var workflowName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.workflow_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var workflowVersion = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.workflow_version}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var workflowDescription = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.workflow_description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var isDeployed = (\"true\" == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.workflow_isDeployed}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")? true:false;\r\n");
      out.write("    var processInstanceId  = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.processInstanceId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var jbpmWorkflowHistoryInfoUserId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.jbpmWorkflowHistoryInfoUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var nodeDetailWindowId = \"id_NodeDetailWindow\";\r\n");
      out.write("    var maxDotX  = parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(empty param.maxDotX) ? maxDotX : param.maxDotX}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"||\"0\");\r\n");
      out.write("    var maxDotY  = parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(empty param.maxDotY) ? maxDotY : param.maxDotY}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"||\"0\");\r\n");
      out.write("    var windowClientWidth   = document.documentElement.clientWidth;\r\n");
      out.write("    windowClientWidth = (0 == windowClientWidth) ? document.documentElement.scrollWidth : windowClientWidth;\r\n");
      out.write("    windowClientWidth-=2;\r\n");
      out.write("    var windowClientHeight  = document.documentElement.clientHeight;\r\n");
      out.write("    windowClientHeight = (0 == windowClientHeight) ? document.documentElement.scrollHeight : windowClientHeight;\r\n");
      out.write("    windowClientHeight-=2;\r\n");
      out.write("    var diagramCanvasWidth  = Math.max(windowClientWidth,maxDotX);\r\n");
      out.write("    var diagramCanvasHeight = Math.max(windowClientHeight,maxDotY);\r\n");
      out.write("    var isViewWorkflowDiagram   = (processInstanceId && (\"-1\" != processInstanceId) && (\"0\" != processInstanceId));\r\n");
      out.write("    if(/getDesignerSavedDiagramInfo\\.action/.test(window.location.href)){\r\n");
      out.write("    \tdiagramCanvasWidth  = windowClientWidth*2;\r\n");
      out.write("    \tdiagramCanvasHeight = windowClientHeight*3.5;\r\n");
      out.write("    }\r\n");
      out.write("    function initNodeDetailWindow(){\r\n");
      out.write(" \t   return  '<div  style=\"background:#FFFFFF;border:1px solid #DDD;padding:5px;display:block;z-index:99999;position:absolute;width:450px;overflow:auto;\" id=\"'+nodeDetailWindowId+'\"></div>';\r\n");
      out.write("    }\r\n");
      out.write("    var queryNodeConfigActorLoadMask = null;\r\n");
      out.write("    function globalWorkflowNodeClickCallBack(e,nodeType,nodeName,posX,posY,nodeWidth,nodeHeight)\r\n");
      out.write("    {\r\n");
      out.write("    \tposY+=30;\r\n");
      out.write("    \tposX-=jQuery(\"#myflow\").scrollLeft();\r\n");
      out.write("    \tposY-=jQuery(\"#myflow\").scrollTop();\r\n");
      out.write("\t   if(!$(\"#\"+nodeDetailWindowId)[0]){\r\n");
      out.write("\t\t  jQuery(\"#myflow\").append(initNodeDetailWindow());\r\n");
      out.write("\t\t  $(\"#\"+nodeDetailWindowId)[0].onclick=function(e){\r\n");
      out.write("\t\t\t  cancelBubble(e);\r\n");
      out.write("\t      };\r\n");
      out.write("\t   }\r\n");
      out.write("\t   $windowDiv = $(\"#\"+nodeDetailWindowId);\r\n");
      out.write("\t   var nodeRealWidth = Math.min(450,windowClientWidth-(posX+nodeWidth+50));\r\n");
      out.write("\t   $(\"#\"+nodeDetailWindowId).css(\"width\",nodeRealWidth+\"px\");\r\n");
      out.write("\t   $windowDiv.get(0).style.left =((posX+nodeWidth+5)+\"px\");\r\n");
      out.write("\t   $windowDiv.get(0).style.top =(posY+\"px\");\r\n");
      out.write("\t   //$windowDiv.get(0).style.height =((nodeHeight-10)+\"px\");\r\n");
      out.write("\t   if(null == queryNodeConfigActorLoadMask){\r\n");
      out.write("\t\t   queryNodeConfigActorLoadMask = new tracywindyLoadMask(document.body,'正在加载数据 请稍等...');\r\n");
      out.write("\t   }\r\n");
      out.write("\t   queryNodeConfigActorLoadMask.show();\r\n");
      out.write("\t   ajaxRequest({\r\n");
      out.write("          url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/getNodeConfigInfo.action\",\r\n");
      out.write("          success:function(res){\r\n");
      out.write("        \t  $windowDiv.html(res.responseText);\r\n");
      out.write("    \t      $windowDiv.show();\r\n");
      out.write("    \t      queryNodeConfigActorLoadMask.hide();\r\n");
      out.write("          },\r\n");
      out.write("          params:{\r\n");
      out.write("              workflowDefinition:workflowName+\"-\"+workflowVersion,\r\n");
      out.write("              nodeType:nodeType,\r\n");
      out.write("              nodeName:nodeName,\r\n");
      out.write("              processInstanceId:processInstanceId,\r\n");
      out.write("              deployId:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.deployId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("              jbpmWorkflowHistoryInfoUserId:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.jbpmWorkflowHistoryInfoUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("          }\r\n");
      out.write("\t   });\r\n");
      out.write("\t   e.stopPropagation();\r\n");
      out.write("       if(isViewWorkflowDiagram){\r\n");
      out.write("           \r\n");
      out.write("       }\r\n");
      out.write("    }\r\n");
      out.write("    function hideGlobalWorkflowNodeDetailWindow(e){\r\n");
      out.write("    \t $windowDiv = $(\"#\"+nodeDetailWindowId);\r\n");
      out.write("    \t $windowDiv.hide();\r\n");
      out.write("    }\r\n");
      out.write("    function backFunc(){\r\n");
      out.write("        /*if(confirm(\"确认返回至流程管理页面么？\")){\r\n");
      out.write("    \t\twindow.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workflow/jbpm-core/listDesignedDeployments.bi?pageStart=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.pageStart}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&queryText=\"+escape(encodeURIComponent(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.queryText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"));\r\n");
      out.write("        }*/\r\n");
      out.write("        if(confirm(\"确认流程变更已保存？\")){\r\n");
      out.write("\t         try{\r\n");
      out.write("\t\t \t\t    if(window.opener)\r\n");
      out.write("\t\t \t\t    {\r\n");
      out.write("\t\t \t\t\t    window.opener.getTracywindyObject(\"id_workflows_table\").reload();\r\n");
      out.write("\t\t \t\t\t}\r\n");
      out.write("\t\t \t}catch(e){}\r\n");
      out.write("            closeWindow();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\tfunction closeWindow()\r\n");
      out.write("\t{\r\n");
      out.write("\t\ttry{\r\n");
      out.write("\t\t\twindow.opener=null;\r\n");
      out.write("\t\t\twindow.open(\"\",\"_self\");\r\n");
      out.write("\t\t\twindow.close();\r\n");
      out.write("\t\t}catch(e){\r\n");
      out.write("\t\t\twindow.close();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onbeforeunload = function(e){   \r\n");
      out.write("        try{\r\n");
      out.write(" \t\t    if(window.opener)\r\n");
      out.write(" \t\t    {\r\n");
      out.write(" \t\t\t    window.opener.getTracywindyObject(\"id_workflows_table\").reload();\r\n");
      out.write(" \t\t\t}\r\n");
      out.write(" \t\t}catch(e){}\r\n");
      out.write("\t\t   /*var ev = getEvent(e);\r\n");
      out.write("\t       var n = ev.screenX - window.screenLeft;    \r\n");
      out.write("\t       var b = n >= (document.documentElement.clientWidth-30);    \r\n");
      out.write("\t       if(b && ev.clientY < 0 || ev.altKey)    \r\n");
      out.write("\t       { \r\n");
      out.write("\t\t         try{\r\n");
      out.write("\t\t \t\t    if(window.opener)\r\n");
      out.write("\t\t \t\t    {\r\n");
      out.write("\t\t \t\t\t    window.opener.getTracywindyObject(\"id_workflows_table\").reload();\r\n");
      out.write("\t\t \t\t\t}\r\n");
      out.write("\t\t \t\t}catch(e){}\r\n");
      out.write("\t\t         try{\r\n");
      out.write("\t\t        \tcloseWindow();\r\n");
      out.write("\t\t         }catch(e){}\r\n");
      out.write("\t\t         cancelBubble(ev);\r\n");
      out.write("\t       } */\r\n");
      out.write("\t  };\r\n");
      out.write("</script>\r\n");
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
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyComboBox.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jbpmDesigner/raphael-min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jbpmDesigner/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jbpmDesigner/jquery-ui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jbpmDesigner/myflow.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jbpmDesigner/myflow.editors.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" >\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\tjQuery(\"#myflow\").css(\"overflow\",\"auto\");\r\n");
      out.write("\t\tjQuery(\"#myflow\").css(\"border\",\"1px solid #DDD\");\r\n");
      out.write("\t\tjQuery(\"#myflow\").css(\"borderTopWidth\",\"0px\");\r\n");
      out.write("\t\tif(!/getDesignerSavedDiagramInfo\\.action/.test(window.location.href)){\r\n");
      out.write("\t\t    if(windowClientWidth > maxDotX){\r\n");
      out.write("\t\t    \tjQuery(\"#myflow\").css(\"overflowX\",\"hidden\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    if((windowClientHeight - 35) > maxDotY){\r\n");
      out.write("\t\t        jQuery(\"#myflow\").css(\"overflowY\",\"hidden\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    jQuery(\"#myflow\").css(\"height\",(windowClientHeight-30)+\"px\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tjQuery(\"#myflow\").css(\"overflow\",\"hidden\");\r\n");
      out.write("\t\t\tjQuery(document.body).css(\"width\",(diagramCanvasWidth+2)+\"px\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    jQuery(\"#myflow\").scroll(function(){\r\n");
      out.write("\t        hideGlobalWorkflowNodeDetailWindow();\r\n");
      out.write("\t   });\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jbpmDesigner/myflow.jpdl4.4.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var dpdlVersion = \"4.4\";\n");
      out.write("var workflow_designerWorkflowJsonString = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(empty param.workflow_designerWorkflowJsonString) ? workflow_designerWorkflowJsonString : param.workflow_designerWorkflowJsonString}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\n");
      out.write("var activeRects = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty activeRects ? '{}' :activeRects}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\n");
      out.write("var historyRects =");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty historyRects ? '{}' :historyRects}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\n");
      out.write("$(function(){\n");
      out.write("\t$('#myflow')\n");
      out.write("\t.myflow($.extend(true,{\n");
      out.write("\t\tbasePath : \"\",\n");
      out.write("\t\trestore : eval(\"(\"+workflow_designerWorkflowJsonString+\")\"),\n");
      out.write("\t\teditable : false\n");
      out.write("\t}\n");
      out.write("\t,{\n");
      out.write("\t\t\"activeRects\" :activeRects\n");
      out.write("\t\t\t//{\"rects\":[{\"paths\":[],\"name\":\"任务3\"},{\"paths\":[],\"name\":\"任务4\"},{\"paths\":[],\"name\":\"任务2\"}]}\n");
      out.write("\t    ,\"historyRects\":historyRects\n");
      out.write("\t\t   //{\"rects\":[{\"paths\":[\"TO 任务1\"],\"name\":\"开始\"},{\"paths\":[\"TO 分支\"],\"name\":\"任务1\"},{\"paths\":[\"TO 任务3\",\"TO 任务4\",\"TO 任务2\"],\"name\":\"分支\"}]}\n");
      out.write("\t}\n");
      out.write("\t));\n");
      out.write("});\n");
      out.write("window.onresize = function(){\n");
      out.write("   window.location.href = window.location.href;\n");
      out.write("};\n");
      out.write("</script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("  margin : 0;\n");
      out.write("  pading: 0;\n");
      out.write("  text-align: left;\n");
      out.write("  font-family: Arial, sans-serif, Helvetica, Tahoma;\n");
      out.write("  font-size: 12px;\n");
      out.write("  line-height: 1.5;\n");
      out.write("  color: black;\n");
      out.write("  /*background-image: url(img/bg.png);*/\n");
      out.write("}\n");
      out.write("\n");
      out.write(".node {\n");
      out.write("\twidth : 70px;\n");
      out.write("\ttext-align : center;\n");
      out.write("\tvertical-align:middle;\n");
      out.write("\tborder: 1px solid #fff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".mover{\n");
      out.write("\tborder: 1px solid #ddd;\n");
      out.write("\tbackground-color: #ddd;\n");
      out.write("}\n");
      out.write(".selected{\n");
      out.write("\tbackground-color: #ddd;\n");
      out.write("}\n");
      out.write(".state{}\n");
      out.write("\n");
      out.write("#myflow_props table{\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("#myflow_props th {\n");
      out.write("\tletter-spacing: 2px;\n");
      out.write("\ttext-align: left;\n");
      out.write("\tpadding: 6px;\n");
      out.write("\tbackground: #ddd;\n");
      out.write("} \n");
      out.write("#myflow_props td {\n");
      out.write("\tbackground: #fff;\n");
      out.write("\tpadding: 6px;\n");
      out.write("} \n");
      out.write("\n");
      out.write("#pointer {\n");
      out.write("\tbackground-repeat:no-repeat;\n");
      out.write("\tbackground-position:center;\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("#path {\n");
      out.write("\tbackground-repeat:no-repeat;\n");
      out.write("\tbackground-position:center;\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("#task{\n");
      out.write("\tbackground-repeat:no-repeat;\n");
      out.write("\tbackground-position:center;\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("#state{\n");
      out.write("\tbackground-repeat:no-repeat;\n");
      out.write("\tbackground-position:center;\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body >\n");
      out.write("<div class=\"panel-title\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${workflowdisplaytype}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('-');
      out.write('>');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${workflowdisplayname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\n");
      out.write("<div id=\"myflow\">\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
