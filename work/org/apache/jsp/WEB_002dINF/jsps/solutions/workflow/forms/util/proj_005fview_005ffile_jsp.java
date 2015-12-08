package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fview_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("    //新增担保人 后保存参数\r\n");
      out.write("\tvar onSelectDatas;\r\n");
      out.write("\tfunction getSelectDatas($me,currentTable){\r\n");
      out.write("\t\tlazyLoadedObj[\"attachment\"] = false;\r\n");
      out.write("\t\tvar attachmentTable = getTracywindyObject(\"id_customworkflowattachment\");\r\n");
      out.write("\t\tif(attachmentTable){\r\n");
      out.write("\t\t\tattachmentTable.setParams({\r\n");
      out.write("\t\t\t\tonSelectDatas:JsonUtil.encode(currentTable.getRowsData())\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tattachmentTable.reload();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction customWorkflowAttachment(Param_onSelectDatas,Param_custname,Param_custnumber,Param_custclass){\r\n");
      out.write("\t\t//流水号\r\n");
      out.write("\t\tvar identifierOne = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projApproveProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"||\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t//控制附件编辑权限\r\n");
      out.write("\t\tvar currentIsReadOnly = window.isCompletedTask||window.assignAttachmentIsReadOnly||false;\r\n");
      out.write("\t\t//得到流程名称\r\n");
      out.write("\t\tvar currentWorkFlowDisplayName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentWorkFlowDisplayName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t//得到节点名称\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar currentTaskActivityName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTaskActivityName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t//console.info(\"流程名称：\"+currentWorkFlowDisplayName);\r\n");
      out.write("\t\t//console.info(\"步骤名称：\"+currentTaskActivityName);\r\n");
      out.write("\t\tif(currentWorkFlowDisplayName == \"项目立项流程\" && currentTaskActivityName == \"01经销商发起\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else if(currentWorkFlowDisplayName == \"立项变更流程\" && currentTaskActivityName == \"01经销商发起\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else if(currentWorkFlowDisplayName == \"项目资料补齐\" && currentTaskActivityName == \"01信用分析师补充资料\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else if(currentWorkFlowDisplayName == \"项目信审流程\" && currentTaskActivityName == \"01信用分析师发起\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else if(currentWorkFlowDisplayName == \"项目信审流程\" && currentTaskActivityName == \"02信用分析师2\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else if(currentWorkFlowDisplayName == \"合同审批流程\" && currentTaskActivityName == \"01发起\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else if(currentWorkFlowDisplayName == \"起租后合同变更\" && currentTaskActivityName == \"01发起\"){\r\n");
      out.write("\t\t\tcurrentIsReadOnly = false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tcurrentIsReadOnly = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcurrentIsReadOnly = currentIsReadOnly||window.isCompletedTask;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\ttracywindyAttachmentFileUpload({\r\n");
      out.write("\t\t\tisReadOnly:currentIsReadOnly,\r\n");
      out.write("\t\t\tunionKey:'assuror',\r\n");
      out.write("            renderTo:'id_workflowAttachmentContainer',\r\n");
      out.write("            module:'WorkflowAttchmentFiles',\r\n");
      out.write("            id:'id_customworkflowattachment',\r\n");
      out.write("            params:{\r\n");
      out.write("\t\t\t onSelectDatas:Param_onSelectDatas,\r\n");
      out.write("\t\t\t custname:Param_custname,\r\n");
      out.write("\t\t\t custnumber:Param_custnumber,\r\n");
      out.write("\t\t\t assignAttachmentKeyOne:identifierOne,\r\n");
      out.write("\t\t\t custclass:Param_custclass\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    batchDownloadAttachmentFileTitle:window.assignBatchDownloadAttachmentFileTitle||\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custname']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("            columns:[\r\n");
      out.write("\t\t\t\t\t{name:'id',header:'uuid', hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'uploadtype',header:'分类',hidden:false,width:80},\r\n");
      out.write("                \t{name:'bondsman',header:'客户/担保人',width:80,hidden:false},\r\n");
      out.write("    \t\t\t  \t{name:'assuror',header:'客户id/担保人id',hidden:true},\r\n");
      out.write("    \t\t\t  \t{name:'type',header:'资料类别',width:60,hidden:false},\r\n");
      out.write("    \t\t\t  \t{name:'attachmentFileDictFileName',header:'资料名称',width:180},\r\n");
      out.write("    \t\t\t  \t{name:'character',header:'性质',hidden:false,width:26},\r\n");
      out.write("    \t\t\t  \t{name:'gradelevel',header:'等级',hidden:false,width:30},\r\n");
      out.write("    \t\t\t  \t{name:'description',header:'附件说明',hidden:false,width:300},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileDictId',header:'文件编号',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoId',header:'文件上传编号',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoDetailIds',header:'上传明细文件编号',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoDetailChineseFileNames',header:'上传明细文件显示名称',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoDetailEncodeFileNames',header:'上传明细文件加密名称',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoDetailFileSizes',header:'上传明细文件文件大小', hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoDetailUploadTimes',header:'上传明细文件上传日期',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'attachmentFileUploadInfoDetailRemarks',header:'上传明细文件文件说明',hidden:true},\r\n");
      out.write("\t\t\t\t\t{name:'operOne',header:'上载',align:'center',width:60,renderer:\r\n");
      out.write("\t\t\t\t\t\tfunction(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("\t\t\t\t\t       var oper = \"<a href='javascript:void(0);' onclick='addUploadFile(\\\"\"+tableObj.id+\"\\\",\"+rowData.rowIndex+\",\\\"add\\\");'>附件上传</a>\";\r\n");
      out.write("\t\t\t\t\t        if(!identifierOne){\r\n");
      out.write("\t\t\t\t\t       \t oper = \"<font color='red'>关键字为空</br>不能上载文件</font>\";\r\n");
      out.write("\t\t\t\t\t        }\r\n");
      out.write("\t\t\t\t\t       return oper;\r\n");
      out.write("\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t},{\r\n");
      out.write("\t\t\t\t\t  name:'operTwo',\r\n");
      out.write("\t\t\t\t\t  header:'上载文件清单'\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("            ],\r\n");
      out.write("            checkAttachmentInfoFuncCallback:function(attachmentFileDictFileName,fileListUUIDStr,attachmentRowData,attachmentTable){\r\n");
      out.write("\t\t        if(!fileListUUIDStr)\r\n");
      out.write("\t\t        {\r\n");
      out.write("\t\t\t        alert(attachmentRowData[\"bondsman\"]+\" < \"+attachmentFileDictFileName+\" > 必需上传附件\");\r\n");
      out.write("\t\t            return false;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t            return true;\r\n");
      out.write("\t        },\r\n");
      out.write("\t\t\tcallBack:function(){\r\n");
      out.write("\t\t         var fileDetailWidth = this.width -this.rankSize - this.checkSize - 868;\r\n");
      out.write("\t\t         if(currentIsReadOnly){\r\n");
      out.write("\t\t        \t  fileDetailWidth+=80;\r\n");
      out.write("\t\t     \t\t  this.setColumnHidden(true,'operOne');\r\n");
      out.write("\t\t         }\r\n");
      out.write("\t\t         this.setColumnWidth(fileDetailWidth,'operTwo');\r\n");
      out.write("\t\t         globalAttachmentUploadOperCallBack('operTwo',this,currentIsReadOnly);\r\n");
      out.write("\t\t   },\r\n");
      out.write("            attachmentFileDictListImplBeanName:'projAttachmentFileList',\r\n");
      out.write("            attachmentType:window.assignAttachmentTypeIds||'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTaskActivityDetailInfo.attachmentTypeIds}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("            identifierOne:identifierOne,\r\n");
      out.write("            identifierTwo:window.assignAttachmentKeyTwo||jQuery(\"#id_currentHistoryTaskInfo_keyOne\").val(),\r\n");
      out.write("            identifierThree:window.assignAttachmentKeyThree||jQuery(\"#id_currentHistoryTaskInfo_keyTwo\").val(),\r\n");
      out.write("            identifierFour:window.assignAttachmentKeyFour||jQuery(\"#id_currentHistoryTaskInfo_keyThree\").val(),\r\n");
      out.write("            identifierFive:window.assignAttachmentKeyFive||jQuery(\"#id_currentHistoryTaskInfo_keyFour\").val(),\r\n");
      out.write("            identifierSix:window.assignAttachmentKeySix||jQuery(\"#id_currentHistoryTaskInfo_keyFive\").val(),\r\n");
      out.write("            identifierSeven:window.assignAttachmentKeySeven||jQuery(\"#id_currentHistoryTaskInfo_keySix\").val(),\r\n");
      out.write("            identifierEight:window.assignAttachmentKeyEight||jQuery(\"#id_currentHistoryTaskInfo_keySeven\").val(),\r\n");
      out.write("            identifierNine:window.assignAttachmentKeyNine||jQuery(\"#id_currentHistoryTaskInfo_keyEight\").val(),\r\n");
      out.write("            identifierTen:window.assignAttachmentKeyTen||jQuery(\"#id_currentHistoryTaskInfo_keyNine\").val(),\r\n");
      out.write("            width:all_width-13,\r\n");
      out.write("            height:all_height-containerWidthAdd-132,\r\n");
      out.write("            border:true,\r\n");
      out.write("            displayToggleContainer:\"id_toggle_tabs_attachment\"\r\n");
      out.write("            \r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\t\r\n");
      out.write("    </script>");
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
