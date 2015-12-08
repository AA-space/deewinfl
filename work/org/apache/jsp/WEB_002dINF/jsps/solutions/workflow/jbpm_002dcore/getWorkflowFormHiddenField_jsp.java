package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowFormHiddenField_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--工作指派-->\r\n");
      out.write("<input type=\"hidden\" id=\"id_assignmentUserId_hidden\" name=\"assignmentUserId\" readOnly value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty currentJBPMWorkflowHistoryInfoUser.assignActor ? '' : currentJBPMWorkflowHistoryInfoUser.assignActor.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_assignmentUserRealName_display\" name=\"assignmentUserRealName\" readOnly  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty currentJBPMWorkflowHistoryInfoUser.assignActor ? '' : currentJBPMWorkflowHistoryInfoUser.assignActor.realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_assignmentedUserRealName_display\" name=\"assignmentedUserRealName\" readOnly  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty currentJBPMWorkflowHistoryInfoUser.assignedActor ? '' : currentJBPMWorkflowHistoryInfoUser.assignedActor.realname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_assignmentIsSilentModel\" name=\"assignmentIsSilentModel\" readOnly  value=\"false\"/>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyOne\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyOne}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyTwo\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyTwo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyThree\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyThree}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyFour\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyFour}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyFive\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyFive}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keySix\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keySix}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keySeven\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keySeven}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyEight\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyEight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyNine\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyNine}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<textarea style=\"display:none\"  id=\"id_currentHistoryTaskInfo_keyTen\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentHistoryTaskInfo.keyTen}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("<!--传阅-->\r\n");
      out.write("<input type=\"hidden\" id=\"id_readUserIds_hidden\" name=\"readUserIds\" readOnly  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${readUserIds}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>    \r\n");
      out.write("<input type=\"hidden\" id=\"id_readUserRealNames_display\" readOnly  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${readUserIds}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>    \r\n");
      out.write("<!--会签-->\r\n");
      out.write("<input type=\"hidden\" id=\"id_signatureUserIds_hidden\" readOnly value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${signatureUserIds}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_signatureUserRealNames_display\" name=\"signatureUserIds\" readOnly value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${signatureUserIds}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<!--任务类型 -->\r\n");
      out.write("<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentRequestTaskType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"currentRequestTaskType\"/>\r\n");
      out.write("<!-- 必要隐藏参数 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_currentTaskId\" name=\"currentTaskId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTaskId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("<input type=\"hidden\" name=\"jbpmWorkflowHistoryInfoUserId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jbpmWorkflowHistoryInfoUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("<!--任意路由参数--> \r\n");
      out.write("<input type=\"hidden\" id=\"id_choseRequestNextRouteNodeName\" name=\"choseRequestNextRouteNodeName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTaskId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("<!-- 流程实例动态变量 -->\r\n");
      out.write("<input type=\"hidden\" id=\"id_requestInitiatorRoute\" name=\"requestInitiatorRoute\" value=\"\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_readChangeRequestInitiator\" name=\"readChangeRequestInitiator\" value=\"\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_signatureChangeRequestInitiator\" name=\"signatureChangeRequestInitiator\" value=\"\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_changeRequestInitiator\" name=\"changeRequestInitiator\" value=\"\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_hidden_text_choseAdvise\" name=\"processedAdvise\"  value=\"\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_currentTaskSubmitButtonText\" name=\"currentTaskSubmitButtonText\"  value=\"\"/>\r\n");
      out.write("<input type=\"hidden\" id=\"id_workflow_ishis\" name=\"is_workflow_ishis\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${workflow_ishis}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />");
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
