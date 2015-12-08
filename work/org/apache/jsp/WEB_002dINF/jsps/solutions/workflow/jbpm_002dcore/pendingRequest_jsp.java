package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pendingRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>未办事宜</title>\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css?version=3\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyJsonUtil.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTable.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t      var all_width = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("\t      var all_height = (document.documentElement||document.body).clientHeight-2;\r\n");
      out.write("\t    </script>\r\n");
      out.write("\t    <style type=\"text/css\">\r\n");
      out.write("\t       html,body{\r\n");
      out.write("\t         overflow:hidden;\r\n");
      out.write("\t       }\r\n");
      out.write("\t    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"overflow:hidden;\"> \r\n");
      out.write("   <div id=\"id_tasksContainer\"></div>\r\n");
      out.write("   <script type=\"text/javascript\" defer>\r\n");
      out.write("\t\r\n");
      out.write("\tvar processDefinitionsColumns = [\r\n");
      out.write("\t\t{header:'流水号',name:'serialno',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t return '<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+rowData.taskid+',\\''+rowData.actorid+'\\',\\''+rowData.tasktype+'\\')\">'+rowData.serialno+'</a>';\r\n");
      out.write("\t\t}},\r\n");
      out.write("\t\t{header:'项目名称',name:'projectname'},\r\n");
      out.write("\t\t{header:'流程名称',name:'workflowname'},\r\n");
      out.write("\t\t{header:'任务名称',name:'taskname'},\r\n");
      out.write("\t\t{header:'任务类型',name:'tasktype',renderer:function(value){return getTaskTypeChineseName(value);},width:80},\r\n");
      out.write("\t\t{header:'任务开始时间',name:'taskstart',width:150},\r\n");
      out.write("\t\t{header:'提交类型',name:'sourcetype',width:150},\r\n");
      out.write("\t\t{header:'执行人编号',name:'actorid',hidden:true},\r\n");
      out.write("\t\t{header:'流程开始时间',name:'processstart',width:150},\r\n");
      out.write("\t\t{header:'操作',name:'oper',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\treturn '<a href=\"javascript:void(0);\" onclick=\"toProcessActivePicture(\\''+rowData.deployid+'\\',\\''+rowData.processinstanceid+'\\',\\''+rowData.actorid+'\\')\">显示流程图</a>'\r\n");
      out.write("\t\t+'&nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t+'<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+rowData.taskid+',\\''+rowData.actorid+'\\',\\''+rowData.tasktype+'\\')\">查看</a>';\r\n");
      out.write("\t\t}}\r\n");
      out.write("\t];\r\n");
      out.write("\tvar tableActivityDetail= new tracywindyTable({\r\n");
      out.write("\t\trenderTo:'id_tasksContainer',\r\n");
      out.write("\t\tisAutoBreakContent:true,\r\n");
      out.write("\t\twidth:all_width,\r\n");
      out.write("\t\theight:all_height,\r\n");
      out.write("\t\tisCheck:false,\r\n");
      out.write("\t\tisRank:false,\r\n");
      out.write("\t\ttoolsLeftMargin:20,\r\n");
      out.write("\t\ttools:[{\r\n");
      out.write("\t    \t  isHtml:true,\r\n");
      out.write("\t    \t  html:'全局搜索：<input type=\"text\" style=\"margin-right:4px;border:1px solid #DDD;\" id=\"id_queryWorkflowsTableInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.queryText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />'\r\n");
      out.write("\t        }],\r\n");
      out.write("\t\tid:'id_tasks_table',\r\n");
      out.write("\t\txmlFileName:'/jbpm/queryPendingTasks.xml',\r\n");
      out.write("\t\tisFit:true,\r\n");
      out.write("\t\tisPage:true,\r\n");
      out.write("\t\tborder:true,\r\n");
      out.write("\t\ttitle:'待办事宜',\r\n");
      out.write("\t\tloadMode:'ajax',\r\n");
      out.write("\t\tisExcel:true,\r\n");
      out.write("\t\tcolumns:processDefinitionsColumns,\r\n");
      out.write("\t\tparams:{\r\n");
      out.write("\t\t  USERID:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t\t  NOTPROCESSINSTANCESTATE:'Draft',\r\n");
      out.write("\t\t  PENDING:true\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t document.getElementById(\"id_queryWorkflowsTableInput\").onkeypress = function(evt){\r\n");
      out.write("\t\t var e  = getEvent(evt);\r\n");
      out.write("\t     var code = e.keyCode||e.charCode;\r\n");
      out.write("\t     if(13 == code){\r\n");
      out.write("\t         var workflowsTable = getTracywindyTable(\"id_tasks_table\");\r\n");
      out.write("\t         workflowsTable.setParams({\r\n");
      out.write("\t                queryText:this.value.toUpperCase()\r\n");
      out.write("\t         });\r\n");
      out.write("\t         workflowsTable.reload();\r\n");
      out.write("\t     }\r\n");
      out.write("\t };\r\n");
      out.write("\t//显示流程图\r\n");
      out.write("\tfunction toProcessActivePicture(deployId,processInstanceId,planActorId)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workflow/jbpm/getActivedRects.action?deployId=\"+deployId+\"&processInstanceId=\"+escape(encodeURIComponent(processInstanceId))+\"&jbpmWorkflowHistoryInfoUserId=\"+planActorId+\"&randomNumber=\"+Math.random();\r\n");
      out.write("\t\topenFullScreenWindow(url);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction doQueryByText_pending()\r\n");
      out.write("\t{\r\n");
      out.write("\t  var contentText = document.all['id_contextText_pending'].value;\r\n");
      out.write("\t  var tableContact = getTracywindyTable(\"pendingRequestTable\");\r\n");
      out.write("\t  tableContact.params['proj_id'] = contentText.toUpperCase();\r\n");
      out.write("\t  tableContact.reload();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function toProcessForm(currentTaskId,planActorId,tasktype)\r\n");
      out.write("{\r\n");
      out.write("\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/requestProcessTaskForm.action?currentTaskId=\"+currentTaskId+\"&jbpmWorkflowHistoryInfoUserId=\"+planActorId+\"&currentRequestTaskType=\"+tasktype;\r\n");
      out.write("\topenFullScreenWindow(url);\r\n");
      out.write("}\r\n");
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
