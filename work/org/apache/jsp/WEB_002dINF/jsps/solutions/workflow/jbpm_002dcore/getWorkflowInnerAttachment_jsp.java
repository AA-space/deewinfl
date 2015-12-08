package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowInnerAttachment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div id=\"id_toggle_tabs_attachment\"><!--页签2开始-->\r\n");
      out.write("\t<div class=\"x-panel-table-div-title\" >附件上传</div>\r\n");
      out.write("\t<div id=\"id_workflowAttachmentContainer\"></div>\r\n");
      out.write(" </div>\r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("    function loadWorkflowAttachment()\r\n");
      out.write("    {\r\n");
      out.write("        var infoFlag = \"attachment\";\r\n");
      out.write("\t\tif(lazyLoadedObj[infoFlag]){\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar workflowAttachmentContainer = \"id_workflowAttachmentContainer\";\r\n");
      out.write("\t\tvar module = \"WorkflowAttchmentFiles\";\r\n");
      out.write("\t\tif(!window.initFileListParams){\r\n");
      out.write("\t\t\ttracywindyAttachmentFileUpload({\r\n");
      out.write("\t                  renderTo:'id_workflowAttachmentContainer',\r\n");
      out.write("\t                  module:'WorkflowAttchmentFiles',\r\n");
      out.write("\t                  id:'id_customworkflowattachment',\r\n");
      out.write("\t                  batchDownloadAttachmentFileTitle:window.assignBatchDownloadAttachmentFileTitle||\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custname']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t                  //attachmentFileDictListImplBeanName:'commonAttachmentFileDictList',\r\n");
      out.write("\t                  attachmentType:window.assignAttachmentTypeIds||'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTaskActivityDetailInfo.attachmentTypeIds}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t                  identifierOne:window.assignAttachmentKeyOne||\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("\t                  identifierTwo:window.assignAttachmentKeyTwo||jQuery(\"#id_currentHistoryTaskInfo_keyOne\").val(),\r\n");
      out.write("\t                  identifierThree:window.assignAttachmentKeyThree||jQuery(\"#id_currentHistoryTaskInfo_keyTwo\").val(),\r\n");
      out.write("\t                  identifierFour:window.assignAttachmentKeyFour||jQuery(\"#id_currentHistoryTaskInfo_keyThree\").val(),\r\n");
      out.write("\t                  identifierFive:window.assignAttachmentKeyFive||jQuery(\"#id_currentHistoryTaskInfo_keyFour\").val(),\r\n");
      out.write("\t                  identifierSix:window.assignAttachmentKeySix||jQuery(\"#id_currentHistoryTaskInfo_keyFive\").val(),\r\n");
      out.write("\t                  identifierSeven:window.assignAttachmentKeySeven||jQuery(\"#id_currentHistoryTaskInfo_keySix\").val(),\r\n");
      out.write("\t                  identifierEight:window.assignAttachmentKeyEight||jQuery(\"#id_currentHistoryTaskInfo_keySeven\").val(),\r\n");
      out.write("\t                  identifierNine:window.assignAttachmentKeyNine||jQuery(\"#id_currentHistoryTaskInfo_keyEight\").val(),\r\n");
      out.write("\t                  identifierTen:window.assignAttachmentKeyTen||jQuery(\"#id_currentHistoryTaskInfo_keyNine\").val(),\r\n");
      out.write("\t                  width:all_width-13,\r\n");
      out.write("\t                  height:all_height-containerWidthAdd-142,\r\n");
      out.write("\t                  isReadOnly:window.isCompletedTask||window.assignAttachmentIsReadOnly||false,\r\n");
      out.write("\t                  border:true,\r\n");
      out.write("\t                  displayToggleContainer:\"id_toggle_tabs_attachment\",\r\n");
      out.write("\t                  checkedKey:'isAttachmentChecked'\r\n");
      out.write("\t      });\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\twindow.initFileListParams();\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("    var checkAttachmentInfoFunc = function(){return true;};\r\n");
      out.write(" </script>\r\n");
      out.write(" ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
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
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowInnerAttachment.jsp(48,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'true' eq currentTaskIsAttachmentChecked}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("     <script type='text/javascript'>\r\n");
        out.write("\t    checkAttachmentInfoFunc = function(){\r\n");
        out.write("\t        if(!lazyLoadedObj[\"attachment\"]){\r\n");
        out.write("\t            alert(\"由于此流程步骤需要检查附件完整性，请点击附件一览确认附件完整性，确认无误后再进行提交！\");\r\n");
        out.write("\t            return false;\r\n");
        out.write("\t        }\r\n");
        out.write("\t\t    var attachmentTable    = getTracywindyObject(\"id_customworkflowattachment\");\r\n");
        out.write("\t\t    var attachmentRowsJsonArrayData = attachmentTable.getRowsData();\r\n");
        out.write("\t\t    {//检查附件\r\n");
        out.write("\t\t\t\t  var checkedKey = attachmentTable.checkedKey;\r\n");
        out.write("\t\t\t\t  for(var i=0;i< attachmentRowsJsonArrayData.length;i++){\r\n");
        out.write("\t\t\t\t\t  var attachmentRowData = attachmentRowsJsonArrayData[i];\r\n");
        out.write("\t\t\t\t\t  var attachmentFileDictFileName = attachmentRowData[\"attachmentFileDictFileName\"] ;\r\n");
        out.write("\t\t\t\t\t  var fileListUUIDStr = attachmentRowData[\"attachmentFileUploadInfoDetailIds\"] ;\r\n");
        out.write("\t\t\t\t\t  var currentIsAttachmentChecked = attachmentRowData[checkedKey] ;\r\n");
        out.write("\t\t\t\t\t  if(\"true\" == (currentIsAttachmentChecked+\"\")){\r\n");
        out.write("\t\t\t\t\t\t  if(attachmentTable.checkAttachmentInfoFuncCallback){\r\n");
        out.write("\t\t\t\t\t    \t  isPassed = attachmentTable.checkAttachmentInfoFuncCallback(attachmentFileDictFileName,fileListUUIDStr,attachmentRowData,attachmentTable); \r\n");
        out.write("                              if(false == isPassed){\r\n");
        out.write("                                  return isPassed;\r\n");
        out.write("                              }\r\n");
        out.write("\t\t\t\t\t\t   }else{\r\n");
        out.write("\t\t\t\t\t\t        if(!fileListUUIDStr)\r\n");
        out.write("\t\t\t\t\t\t        {\r\n");
        out.write("\t\t\t\t\t\t\t        alert(attachmentFileDictFileName+\"必需上传附件\");\r\n");
        out.write("\t\t\t\t\t\t            return false;\r\n");
        out.write("\t\t\t\t\t\t        }\r\n");
        out.write("\t\t\t\t\t\t  }\r\n");
        out.write("\t\t\t\t\t  }\r\n");
        out.write("\t\t\t      }\r\n");
        out.write("\t\t   }\r\n");
        out.write("\t\t   return true;\r\n");
        out.write("\t    };\r\n");
        out.write("     </script>\r\n");
        out.write(" ");
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
