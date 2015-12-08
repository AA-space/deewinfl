package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class processInstanceRequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/permission.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode != null) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>流程实例</title>\r\n");
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
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t      var all_width = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("\t      var all_height = (document.documentElement||document.body).clientHeight-1;\r\n");
      out.write("\t    </script>\r\n");
      out.write("\t     <style type=\"text/css\">\r\n");
      out.write("\t       html,body{\r\n");
      out.write("\t         overflow:hidden;\r\n");
      out.write("\t       }\r\n");
      out.write("\t    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"overflow:hidden;\"> \r\n");
      out.write("   <div id=\"id_tasksContainer\"></div>\r\n");
      out.write("   <script type=\"text/javascript\" >\r\n");
      out.write("\tvar processDefinitionsColumns = [\r\n");
      out.write("\t                                 {header:'流水号',name:'serialno'},\r\n");
      out.write("\t                                 {header:'项目名称',name:'projectname'},\r\n");
      out.write("\t                                 {header:'流程名称',name:'workflowname'},\r\n");
      out.write("\t                                 {header:'当前任务',align:'center',name:'taskid',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("                                          var taskids = rowData['taskid'].split(\",\");\r\n");
      out.write("                                          var tasknames = rowData['taskname'].split(\",\");\r\n");
      out.write("                                          var rs = \"\";\r\n");
      out.write("                                          for(var i=0;i<taskids.length;i++){\r\n");
      out.write("                                              var taskid = taskids[i];\r\n");
      out.write("                                              var taskname = \"\";\r\n");
      out.write("                                              for(var j=0;j<tasknames.length;j++){\r\n");
      out.write("                                                  var tempTaskName = tasknames[j];\r\n");
      out.write("                                                  var tempTaskId   = tempTaskName.split(\"@@_@@\")[0];\r\n");
      out.write("                                                  if(tempTaskId == taskid){\r\n");
      out.write("                                                \t  taskname = tempTaskName.substring(taskid.length+\"@@_@@\".length,tempTaskName.length);\r\n");
      out.write("                                                \t  break;\r\n");
      out.write("                                                  }\r\n");
      out.write("                                              }\r\n");
      out.write("                                              if(i>0){\r\n");
      out.write("                                            \t  rs+='<br>&nbsp;';\r\n");
      out.write("                                              }\r\n");
      out.write("                                              rs+='<a href=\"javascript:void(0);\" onclick=\"toProcessForm('+taskid+')\">'+taskname+'</a>';\r\n");
      out.write("                                          }\r\n");
      out.write("                                          return rs;\r\n");
      out.write("\t\t                             }},\r\n");
      out.write("\t\t                             {header:'流程图',name:'viewdiagram',align:'center',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t                            \t return '<a href=\"javascript:void(0);\" onclick=\"toProcessActivePicture(\\''+rowData.deployid+'\\',\\''+((rowData.processinstanceid))+'\\')\">查看</a>';\r\n");
      out.write("\t\t\t                         }},\r\n");
      out.write("\t                                 {header:'流程开始时间',name:'processstart',type:'date',queryConfig:{}},\r\n");
      out.write("\t                         \t\t {header:'流程结束时间',name:'processend',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t                         \t\t\tif(rowData[\"processend\"]){\r\n");
      out.write("\t                         \t\t\t\treturn rowData[\"processend\"];//+\" < 已结束  > \";\r\n");
      out.write("\t                         \t\t    }\r\n");
      out.write("\t                                     return  \"进行中...\";\r\n");
      out.write("\t                         \t     }}\r\n");
      out.write("\t                              ];\r\n");
      out.write("   </script>\r\n");
      out.write("   ");
      if (_jspx_meth_permission_005faction_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" defer>\r\n");
      out.write("\t\t var tableActivityDetail= new tracywindyTable({\r\n");
      out.write("\t          renderTo:'id_tasksContainer',\r\n");
      out.write("\t          width:all_width,\r\n");
      out.write("\t          height:all_height,\r\n");
      out.write("\t          isCheck:false,\r\n");
      out.write("\t          isExcel:true,\r\n");
      out.write("\t          isRank:false,\r\n");
      out.write("\t  \t\t  toolsLeftMargin:20,\r\n");
      out.write("\t\t\t  tools:[{\r\n");
      out.write("\t\t    \t  isHtml:true,\r\n");
      out.write("\t\t    \t  html:'全局搜索：<input type=\"text\" style=\"margin-right:4px;border:1px solid #DDD;\" id=\"id_queryWorkflowsTableInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.queryText}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />'\r\n");
      out.write("\t\t        }],\r\n");
      out.write("\t          id:'id_tasks_table',\r\n");
      out.write("\t          showHeader:true,\r\n");
      out.write("\t          xmlFileName:'/jbpm/queryAllProcessInstances.xml',\r\n");
      out.write("\t          isPage:true,\r\n");
      out.write("\t          border:true,\r\n");
      out.write("\t          isFit:true,\r\n");
      out.write("\t          title:'流程信息',\r\n");
      out.write("\t          loadMode:'ajax',\r\n");
      out.write("\t          columns:processDefinitionsColumns\r\n");
      out.write("\t       });\r\n");
      out.write("\t\t document.getElementById(\"id_queryWorkflowsTableInput\").onkeypress = function(evt){\r\n");
      out.write("\t\t\t var e  = getEvent(evt);\r\n");
      out.write("\t\t     var code = e.keyCode||e.charCode;\r\n");
      out.write("\t\t     if(13 == code){\r\n");
      out.write("\t\t         var workflowsTable = getTracywindyTable(\"id_tasks_table\");\r\n");
      out.write("\t\t         workflowsTable.setParams({\r\n");
      out.write("\t\t                queryText:this.value.toUpperCase()\r\n");
      out.write("\t\t         });\r\n");
      out.write("\t\t         workflowsTable.reload();\r\n");
      out.write("\t\t     }\r\n");
      out.write("\t\t };\r\n");
      out.write("\t  //显示流程图\r\n");
      out.write("\t   function toProcessActivePicture(deployId,processInstanceId)\r\n");
      out.write("\t   {\r\n");
      out.write("\t\t\tvar sheight = 600;\r\n");
      out.write("\t        var swidth = 850;\r\n");
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
      out.write("\t   var loadMask = null;\r\n");
      out.write("\t   ");
      if (_jspx_meth_permission_005faction_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   </script>\r\n");
      out.write("      <script type=\"text/javascript\">\r\n");
      out.write("        function toProcessForm(currentTaskId){\r\n");
      out.write("    \t\tvar URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/viewHistoryProcessForm.action?currentTaskId=\"+currentTaskId;\r\n");
      out.write("    \t\topenFullScreenWindow(URL);\r\n");
      out.write("    \t}\r\n");
      out.write("      </script>\r\n");
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

  private boolean _jspx_meth_permission_005faction_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f0 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f0.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/processInstanceRequest.jsp(67,3) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
        out.write("      <script  type=\"text/javascript\">\r\n");
        out.write("\t    processDefinitionsColumns.push({header:'操作',name:'oper',align:'center',renderer:function(value,tableObj,columnName,columnIndex,rowData){\r\n");
        out.write("\t\t     return '<a href=\"javascript:void(0);\" onclick=\"removeProcessInstance(\\''+rowData.processinstancedbid+'\\',\\''+rowData.processinstanceid+'\\');\">删除流程实例</a>';\r\n");
        out.write("\t    }});\r\n");
        out.write("\t  </script>\r\n");
        out.write("   ");
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

  private boolean _jspx_meth_permission_005faction_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f1 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f1.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/processInstanceRequest.jsp(125,4) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f1.setCode("admin_action");
    int _jspx_eval_permission_005faction_005f1 = _jspx_th_permission_005faction_005f1.doStartTag();
    if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t   function removeProcessInstance(processInstanceDBID,processInstanceId)\r\n");
        out.write("\t   {\r\n");
        out.write("\t\t   if(!confirm(\"确认删除该流程实例么？\"))\r\n");
        out.write("\t\t   {\r\n");
        out.write("\t\t\t   return ;\r\n");
        out.write("\t\t   }\r\n");
        out.write("\t\t   if(!loadMask)\r\n");
        out.write("\t\t   {\r\n");
        out.write("\t\t\t   loadMask = new tracywindyLoadMask(document.body,\"正在执行操作  请稍等...\");\r\n");
        out.write("\t\t   }\r\n");
        out.write("\t\t   loadMask.show();\r\n");
        out.write("           ajaxRequest({\r\n");
        out.write("               method:'post',\r\n");
        out.write("               url:'");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/jbpm/removeProcessInstance.action',\r\n");
        out.write("               success:function(res){alert(\"删除成功\");window.location.reload();},\r\n");
        out.write("               failure:function(res){alert(\"删除失败\");window.location.reload();},\r\n");
        out.write("               params:{\r\n");
        out.write("            \t   processInstanceDBID  : processInstanceDBID,\r\n");
        out.write("            \t   processInstanceId    : processInstanceId\r\n");
        out.write("               }\r\n");
        out.write("            });\r\n");
        out.write("\t   }\r\n");
        out.write("\t   ");
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
}
