package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class draftRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>我的草稿</title>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css?version=3\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/easyui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyJsonUtil.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTable.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  var all_width = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("  var all_height = (document.documentElement||document.body).clientHeight-1;\r\n");
      out.write("  var loadMask = null;\r\n");
      out.write("</script>\r\n");
      out.write("\t    <style type=\"text/css\">\r\n");
      out.write("\t       html,body{\r\n");
      out.write("\t         overflow:hidden;\r\n");
      out.write("\t       }\r\n");
      out.write("\t    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"overflow:hidden;\"> \r\n");
      out.write("<div id=\"id_tasksContainer\"></div>\r\n");
      out.write("<script type=\"text/javascript\" defer>\r\n");
      out.write("\tvar processDefinitionsColumns = [\r\n");
      out.write("\t\t {header:'流水号',name:'serialno',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\treturn '<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+rowData.taskid+',\\''+rowData.actorid+'\\',\\''+rowData.tasktype+'\\')\">'+rowData.serialno+'</a>';\r\n");
      out.write("\t\t }},\r\n");
      out.write("\t\t {header:'项目名称',name:'projectname'},\r\n");
      out.write("\t\t {header:'流程名称',name:'workflowname'},\r\n");
      out.write("\t\t //{header:'任务编号',name:'taskid'},\r\n");
      out.write("\t\t {header:'任务名称',name:'taskname'},\r\n");
      out.write("\t\t {header:'任务开始时间',name:'taskstart'},\r\n");
      out.write("\t\t {header:'执行人编号',name:'actorid',hidden:true},\r\n");
      out.write("\t\t {header:'执行人',name:'actorrealname',hidden:true},\r\n");
      out.write("\t\t {header:'流程开始时间',name:'processstart'},\r\n");
      out.write("\t\t {header:'操作',name:'oper',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\t return '<a href=\"javascript:void(0);\" onclick=\"toProcessActivePicture(\\''+rowData.deployid+'\\',\\''+rowData.processinstanceid+'\\',\\''+rowData.actorid+'\\')\">显示流程图</a>'\r\n");
      out.write("\t\t\t\t+'&nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t\t +'<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+rowData.taskid+',\\''+rowData.actorid+'\\',\\''+rowData.tasktype+'\\')\">查看</a>';\r\n");
      out.write("\t\t }}\r\n");
      out.write("\t  ];\r\n");
      out.write(" var tableActivityDetail= new tracywindyTable({\r\n");
      out.write("\t  renderTo:'id_tasksContainer',\r\n");
      out.write("\t  width:all_width,\r\n");
      out.write("\t  height:all_height,\r\n");
      out.write("\t  isCheck:true,\r\n");
      out.write("\t  isRank:false,\r\n");
      out.write("\t  title:'我的草稿',\r\n");
      out.write("\t  toolsLeftMargin:20,\r\n");
      out.write("\t  tools:[{\r\n");
      out.write("    \t  isHtml:true,\r\n");
      out.write("    \t  html:'全局搜索：<input type=\"text\" style=\"margin-right:4px;border:1px solid #DDD;\" id=\"id_queryWorkflowsTableInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.queryText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />'\r\n");
      out.write("        },{\r\n");
      out.write("         html:'<font color=\"red\">删除选中草稿</font>',\r\n");
      out.write("         handler:function(table){\r\n");
      out.write("             var checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("             var rowDatasLen = checkedRowDatas.length;\r\n");
      out.write("             if(0 == rowDatasLen){\r\n");
      out.write("                 alert(\"请选择需要删除的草稿\");\r\n");
      out.write("                 return;\r\n");
      out.write("             }\r\n");
      out.write("             if(null == loadMask){\r\n");
      out.write("            \t loadMask = new tracywindyLoadMask(document.body,'操作进行中 请稍后...');\r\n");
      out.write("             }\r\n");
      out.write("             loadMask.show();\r\n");
      out.write("             var checkedProcessInstanceDbidArr = [];\r\n");
      out.write("             for(var i=0;i<rowDatasLen;i++){\r\n");
      out.write("                 var rowData = checkedRowDatas[i];\r\n");
      out.write("                 checkedProcessInstanceDbidArr.push(rowData[\"processinstancedbid\"]);\r\n");
      out.write("             }\r\n");
      out.write("             var processInstanceDBID = checkedProcessInstanceDbidArr.join(\",\");\r\n");
      out.write("             ajaxRequest({\r\n");
      out.write("                  url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/removeProcessInstance.action',\r\n");
      out.write("                  timeout:30*60*1000,\r\n");
      out.write("                  success:function(res){\r\n");
      out.write("                     alert(\"操作成功\");\r\n");
      out.write("                     table.reload();\r\n");
      out.write("                     loadMask.hide();\r\n");
      out.write("                  },\r\n");
      out.write("                  failure:function(res){\r\n");
      out.write("                \t loadMask.hide();\r\n");
      out.write("                  },\r\n");
      out.write("                  params:{\r\n");
      out.write("                \t  processInstanceDBID:processInstanceDBID\r\n");
      out.write("                  }\r\n");
      out.write("             });\r\n");
      out.write("         },\r\n");
      out.write("         iconCls:'icon-remove'\r\n");
      out.write("      }],\r\n");
      out.write("\t  id:'id_tasks_table',\r\n");
      out.write("\t  xmlFileName:'/jbpm/queryPendingTasks.xml',\r\n");
      out.write("\t  isPage:true,\r\n");
      out.write("\t  border:true,\r\n");
      out.write("\t  isFit:true,\r\n");
      out.write("\t  loadMode:'ajax',\r\n");
      out.write("\t  columns:processDefinitionsColumns,\r\n");
      out.write("\t  params:{\r\n");
      out.write("\t\t  USERID:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t\t  PROCESSINSTANCESTATE:'Draft'\r\n");
      out.write("\t  }\r\n");
      out.write("   });\r\n");
      out.write(" document.getElementById(\"id_queryWorkflowsTableInput\").onkeypress = function(evt){\r\n");
      out.write("\t var e  = getEvent(evt);\r\n");
      out.write("     var code = e.keyCode||e.charCode;\r\n");
      out.write("     if(13 == code){\r\n");
      out.write("         var workflowsTable = getTracywindyTable(\"id_tasks_table\");\r\n");
      out.write("         workflowsTable.setParams({\r\n");
      out.write("                queryText:this.value.toUpperCase()\r\n");
      out.write("         });\r\n");
      out.write("         workflowsTable.reload();\r\n");
      out.write("     }\r\n");
      out.write(" };\r\n");
      out.write("//显示流程图\r\n");
      out.write("function toProcessActivePicture(deployId,processInstanceId,planActorId)\r\n");
      out.write("{\r\n");
      out.write("   var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workflow/jbpm/getActivedRects.action?deployId=\"+deployId+\"&processInstanceId=\"+escape(encodeURIComponent(processInstanceId))+\"&jbpmWorkflowHistoryInfoUserId=\"+planActorId+\"&randomNumber=\"+Math.random();\r\n");
      out.write("   openFullScreenWindow(url);\r\n");
      out.write("}\r\n");
      out.write("function doQueryByText_pending()\r\n");
      out.write("{\r\n");
      out.write("  var contentText = document.all['id_contextText_pending'].value;\r\n");
      out.write("  var tableContact = getTracywindyTable(\"pendingRequestTable\");\r\n");
      out.write("  tableContact.params['proj_id'] = contentText.toUpperCase();\r\n");
      out.write("  tableContact.reload();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function toProcessForm(currentTaskId,planActorId)\r\n");
      out.write("{\r\n");
      out.write("\tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/requestProcessTaskForm.action?currentTaskId=\"+currentTaskId+\"&jbpmWorkflowHistoryInfoUserId=\"+planActorId;\r\n");
      out.write("\topenFullScreenWindow(URL);\r\n");
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
