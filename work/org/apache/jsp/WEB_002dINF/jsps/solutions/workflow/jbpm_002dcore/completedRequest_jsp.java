package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class completedRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>已办事宜</title>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css?version=3\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar all_width = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("\tvar all_height = (document.documentElement||document.body).clientHeight-1;\r\n");
      out.write("</script>\r\n");
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
      out.write("\t\t return '<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+rowData.taskid+')\">'+rowData.serialno+'</a>';\r\n");
      out.write("\t\t}},\r\n");
      out.write("\t\t{header:'项目名称',name:'projectname'},\r\n");
      out.write("\t\t{header:'流程名称',name:'workflowname'},\r\n");
      out.write("\t\t{header:'已办类型',name:'processinstancetype',renderer:function(value){return getTaskTypeChineseName(value);}},\r\n");
      out.write("\t\t{header:'当前任务',name:'taskname',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("              return value.substring(rowData[\"taskid\"].length,value.length);\r\n");
      out.write("\t    }},\r\n");
      out.write("\t\t{header:'执行人编号',name:'actorid',hidden:true},\r\n");
      out.write("\t\t{header:'流程开始时间',name:'processstart'},\r\n");
      out.write("\t\t{header:'流程结束时间',name:'processend',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\tif(rowData[\"processend\"]){\r\n");
      out.write("\t\t\t\treturn rowData[\"processend\"];//+\" < 已结束  > \";\r\n");
      out.write("\t\t    }\r\n");
      out.write("            return  \"进行中...\";\r\n");
      out.write("\t    }},\r\n");
      out.write("\t\t{header:'操作',name:'oper',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\treturn '<a href=\"javascript:void(0);\" onclick=\"toProcessActivePicture(\\''+rowData.deployid+'\\',\\''+rowData.processinstanceid+'\\')\">显示流程图</a>'\r\n");
      out.write("\t\t\t+'&nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t    +'<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+rowData.taskid+')\">查看</a>';\r\n");
      out.write("\t\t}}\r\n");
      out.write("\t];\r\n");
      out.write("\tvar tableActivityDetail= new tracywindyTable({\r\n");
      out.write("\t\trenderTo:'id_tasksContainer',\r\n");
      out.write("\t\twidth:all_width,\r\n");
      out.write("\t\theight:all_height,\r\n");
      out.write("\t\tisCheck:false,\r\n");
      out.write("\t\tisRank:false,\r\n");
      out.write("\t\ttitle:'已办事宜',\r\n");
      out.write("\t\ttoolsLeftMargin:20,\r\n");
      out.write("\t\ttools:[{\r\n");
      out.write("\t    \t  isHtml:true,\r\n");
      out.write("\t    \t  html:'全局搜索：<input type=\"text\" style=\"margin-right:4px;border:1px solid #DDD;\" id=\"id_queryWorkflowsTableInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.queryText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />'\r\n");
      out.write("\t        }],\r\n");
      out.write("\t\tid:'id_tasks_table',\r\n");
      out.write("\t\tshowHeader:true,\r\n");
      out.write("\t\tisPage:true,\r\n");
      out.write("\t\tisExcel:true,\r\n");
      out.write("\t\tborder:true,\r\n");
      out.write("\t\txmlFileName:'/jbpm/queryCompletedTasks.xml',\r\n");
      out.write("\t\tpageSize:20,\r\n");
      out.write("\t\tisFit:true,\r\n");
      out.write("\t\tloadMode:'ajax',\r\n");
      out.write("\t\tcolumns:processDefinitionsColumns,\r\n");
      out.write("\t\tparams:{\r\n");
      out.write("\t\t\tUSERID:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t    }\r\n");
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
      out.write("\t  //显示流程图\r\n");
      out.write("\t   function toProcessActivePicture(deployId,processInstanceId)\r\n");
      out.write("\t   {\r\n");
      out.write("\t        var winoption =null;//\"height=\"+sheight+\"px;width=\"+swidth+\"px;status=no;scroll=yes;resizable=yes\";\r\n");
      out.write("\t\t\twindow.open(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workflow/jbpm/getActivedRects.action?deployId=\"+deployId+\"&processInstanceId=\"+escape(encodeURIComponent(processInstanceId))+\"&randomNumber=\"+Math.random(),\"_blank\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t   function doQueryByText_pending()\r\n");
      out.write("\t   {\r\n");
      out.write("\t\t  var contentText = document.all['id_contextText_pending'].value;\r\n");
      out.write("\t\t  var tableContact = getTracywindyTable(\"pendingRequestTable\");\r\n");
      out.write("\t\t  tableContact.params['proj_id'] = contentText.toUpperCase();\r\n");
      out.write("\t\t  tableContact.reload();\r\n");
      out.write("\t   }\r\n");
      out.write("   </script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function toProcessForm(currentTaskId){\r\n");
      out.write("\tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/viewHistoryProcessForm.action?currentTaskId=\"+currentTaskId;\r\n");
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
