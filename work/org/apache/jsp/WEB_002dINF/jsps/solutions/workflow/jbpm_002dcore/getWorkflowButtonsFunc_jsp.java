package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowButtonsFunc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005fif_0026_005ftest != null) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<script>\r\n");
      out.write(" var isDraft = (\"Draft\" == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${processInstanceState}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//显示流程图\r\n");
      out.write("\tfunction toProcessActivePicture(){\r\n");
      out.write("\t\t/*var processInstanceId =encodeURIComponent('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("\t\t?deployId=&processInstanceId=\"+processInstanceId+\"&randomNumber=\"+Math.random()*/\r\n");
      out.write("\t\tvar attachmentParams = {\r\n");
      out.write("\t\t\t\tdeployId:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentDeployId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\tprocessInstanceId:escape(encodeURIComponent('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')),\r\n");
      out.write("\t\t\t\trandomNumber:Math.random(),\r\n");
      out.write("\t\t\t\tjbpmWorkflowHistoryInfoUserId:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jbpmWorkflowHistoryInfoUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t    };\r\n");
      out.write("\t\topenFullScreenWindow(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workflow/jbpm/getActivedRects.action\",attachmentParams);\r\n");
      out.write("\t}\r\n");
      out.write("\t//流程历史信息\r\n");
      out.write("\tfunction viewWorkflowHistoryDetail(){\r\n");
      out.write("\t\tvar infoFlag=\"history\";\r\n");
      out.write("\t\tif(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){\r\n");
      out.write("\t\t\tjQuery(\"#id_workflowHistoryDetailInfoWindow\").show();\r\n");
      out.write("\t\t\tjQuery(\"#id_workflowHistoryDetailInfoWindow\").window({top:20});\r\n");
      out.write("\t\t\tjQuery(\"#id_workflowHistoryDetailInfoWindow\").window(\"open\");\r\n");
      out.write("\t\t})){\r\n");
      out.write("\t\t\tjQuery(\"#id_workflowHistoryDetailInfoWindow\").show();\r\n");
      out.write("\t\t\tjQuery(\"#id_workflowHistoryDetailInfoWindow\").window({top:20});\r\n");
      out.write("\t\t\tjQuery(\"#id_workflowHistoryDetailInfoWindow\").window(\"open\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//流程历史信息\r\n");
      out.write("\tfunction viewProjSummary(){\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t    var URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/getProjSummaryHistoryInfos.action?keyOne=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyOne}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&proj_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['project_info.projId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t    openFullScreenWindow(URL);\r\n");
      out.write("\t}\r\n");
      out.write("\t//打开历史表单\r\n");
      out.write("\tfunction toProcessForm(currentTaskId){\r\n");
      out.write("\t\twindow.open(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/viewHistoryProcessForm.action?currentTaskId=\"+currentTaskId,\"_blank\");\r\n");
      out.write("\t}\r\n");
      out.write("\t//打印预览\r\n");
      out.write("\tfunction previewPrint(){\r\n");
      out.write("\t    var currentTaskId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.currentTaskId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"||\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['currentTaskId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t    var URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/preivewProcessTaskForm.action?currentTaskId=\"+currentTaskId+\"&jbpmWorkflowHistoryInfoUserId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.jbpmWorkflowHistoryInfoUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\twindow.open (URL, '_blank','width='+(1014)+',height='+(window.screen.availHeight-30)+ ',top=0,left=0,location=no,directories=no,toolbar=no,resizable=no,status=no,menubar=no,scrollbars=yes'); \r\n");
      out.write("\t}\r\n");
      out.write("\t//删除流程实例\r\n");
      out.write("\tfunction removeProcessInstance(){\r\n");
      out.write("\t\tif(isDraft && !window.isCompletedTask){\r\n");
      out.write("\t\t   if(!window.loadMask)\r\n");
      out.write("\t\t   {\r\n");
      out.write("\t\t    \twindow.loadMask = new tracywindyLoadMask(document.body,\"数据处理中，请稍等...\");\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t   window.loadMask.show();\r\n");
      out.write("\t\t   globalCurrentPressButtonText = deleteButtonNoSavedDisplayText;\r\n");
      out.write("\t\t   document.getElementById('id_currentTaskSubmitButtonText').value = globalCurrentPressButtonText;\r\n");
      out.write("\t\t   submitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\ttry{\r\n");
      out.write("\t\t\t   closeWindow();\r\n");
      out.write("\t\t\t}catch(e){}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t/*try{\r\n");
      out.write("\t\t    if(window.top.opener)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t    window.top.opener.location.reload();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}catch(e){}\r\n");
      out.write("\t\tcloseWindow();*/\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("\t/*window.onbeforeunload = onbeforeunload_handler; \r\n");
      out.write("\twindow.onunload = onunload_handler; \r\n");
      out.write("\tfunction onbeforeunload_handler(){ \r\n");
      out.write("\t    var warning=\"确认退出?\";    \r\n");
      out.write("\t    return window.confirm(warning); \r\n");
      out.write("\t} \r\n");
      out.write("\t    \r\n");
      out.write("\tfunction onunload_handler(){ \r\n");
      out.write("\t    var warning=\"谢谢光临\"; \r\n");
      out.write("\t    alert(warning); \r\n");
      out.write("\t} */\r\n");
      out.write("\tif(isDraft && !window.isCompletedTask){\r\n");
      out.write("\t\twindow.onbeforeunload = function(e){    \r\n");
      out.write("\t\t   var ev = getEvent(e);\r\n");
      out.write("\t       var n = ev.screenX - window.screenLeft;    \r\n");
      out.write("\t       var b = n >= (document.documentElement.clientWidth-30);    \r\n");
      out.write("\t       if(b && ev.clientY < 0 || ev.altKey)    \r\n");
      out.write("\t       { \r\n");
      out.write("\t         removeProcessInstance();\r\n");
      out.write("\t         try{\r\n");
      out.write("\t \t\t    if(window.opener)\r\n");
      out.write("\t \t\t    {\r\n");
      out.write("\t \t\t\t    window.opener.location.reload();\r\n");
      out.write("\t \t\t\t}\r\n");
      out.write("\t \t\t}catch(e){}\r\n");
      out.write("\t         try{\r\n");
      out.write("\t        \tcloseWindow();\r\n");
      out.write("\t         }catch(e){}\r\n");
      out.write("\t         cancelBubble(ev);\r\n");
      out.write("\t       } \r\n");
      out.write("\t    }; \r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script> \r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowButtonsFunc.jsp(34,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty currentHistoryTaskInfo.keyOne}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t   alert(\"流程关键字为空,请先设定流程《");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.workflowName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("》的第一个流程关键字\");\r\n");
        out.write("\t\t   return;\r\n");
        out.write("\t\t");
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
}
