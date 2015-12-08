package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005flist_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--合同文件清单 -->\r\n");
      out.write("<script>\r\n");
      out.write("function downloadFile(Id)\r\n");
      out.write("{\r\n");
      out.write("  attachmentDown({returnType:'file',url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/template/downLoadAttachById.action?id=\"+Id});\r\n");
      out.write("} \r\n");
      out.write("function showOperator(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("     var base = \"<a href='javascript:void(0);' onclick='showRecorder(\\\"\"+rowData.id+\"\\\")'>记录</a>\";\r\n");
      out.write("     var base2 = \"<a href='javascript:void(0);' onclick='downloadFile(\\\"\"+rowData.id+\"\\\")'>下载</a>\";\r\n");
      out.write("     var base3 = \"<a href='javascript:void(0);' onclick='editoverdue(\\\"\"+rowData.id+\"\\\")'>编辑</a>\";\r\n");
      out.write("     //return base2+\"&nbsp;&nbsp;|&nbsp;&nbsp;\"+base3; \r\n");
      out.write("     return base3;\r\n");
      out.write("  }\r\n");
      out.write(" \r\n");
      out.write(" function editoverdue(id){\r\n");
      out.write(" \tvar currentPageClientWidth  =  document.documentElement.clientWidth;\r\n");
      out.write(" \tvar currentPageClientHeight =  document.documentElement.clientHeight;\r\n");
      out.write(" \t//status=0 只能打印 \r\n");
      out.write(" \topenFullScreenWindow(getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi',{id:id,status:0});\r\n");
      out.write(" \t//window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',\"resizable=true,top=0,left=0\") ;\r\n");
      out.write(" }\r\n");
      out.write("function showContractFile(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("    var base = \"<a href='#' onclick='downloadContractWordUploadFile(\\\"\"+$(\"#projid\").val()+\"/\"+rowData.wordaddress+\"\\\",\\\"\"+rowData.wordtemplatename+\"\\\")'>{1}</a>{2}\";\r\n");
      out.write("    var separator = \"&nbsp;&nbsp;\";\r\n");
      out.write("    var updateFlag=value;\r\n");
      out.write("    var updateClickFunc=\"other\";\r\n");
      out.write("    var field=base.replace(\"{1}\",updateFlag).replace(\"{2}\",separator);\r\n");
      out.write("       return field;\r\n");
      out.write("    }\r\n");
      out.write("function downloadContractWordUploadFile(fileAddress,wordName)\r\n");
      out.write("{\r\n");
      out.write("   if(null==window.attachmentFileUploadloadMask)\r\n");
      out.write("   {\r\n");
      out.write("      attachmentFileUploadloadMask = new tracywindyLoadMask(document.body,\"操作进行中 请稍等...\");\r\n");
      out.write("       createAttachmentFileContainers();\r\n");
      out.write("    }\r\n");
      out.write("   attachmentFileUploadloadMask.show();\r\n");
      out.write("   var newAction = getRootPath()+\"/leasing/word/downLoadContractAttach.action?browserType=\"+SysBrowser.getBrowser().toLowerCase();\r\n");
      out.write("   newAction+=\"&fileAddress=\"+fileAddress+\"&wordName=\"+wordName;\r\n");
      out.write("   uploadAttachmentFileFormSubmit(newAction);\r\n");
      out.write("   attachmentFileUploadloadMask.hide();\r\n");
      out.write("} \r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\t\t    var currentIsNeedTools = true;\r\n");
      out.write("\t\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    new tracywindyMultiTable({\r\n");
      out.write("\t\t    renderTo:'id_table_leasing_contract_list_container',\r\n");
      out.write("\t\t    width:formWidth,\r\n");
      out.write("\t\t    height:350,\r\n");
      out.write("\t\t    tools:'删除',\r\n");
      out.write("\t\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t\t    isFit:true,\r\n");
      out.write("\t\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_list_str ? \"[]\" : json_contract_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t\t    columns:[\r\n");
      out.write("\t\t       {name:'id',  header:'id',type:'text',hidden:true},\r\n");
      out.write("\t\t       {header:'文件名称',name:'filename'},\r\n");
      out.write("\t\t       {header:'操作',name:'create',renderer:showOperator}\r\n");
      out.write("\t\t     ]\r\n");
      out.write("\t\t \t});\r\n");
      out.write("\t\t\t// 全选 \r\n");
      out.write("\t\t\t$('#inputCheck').click(function() { \r\n");
      out.write("\t\t\t\t$(\"input[name='contract_word_list_check_box']\").attr(\"checked\", $(this).attr(\"checked\")); \r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t\t//反选 \r\n");
      out.write("\t\t\t$(\"#select_reverse\").click(function() { \r\n");
      out.write("\t\t\t\t$(\"input[name='contract_word_list_check_box']\").each(function(idx, item) { \r\n");
      out.write("\t\t\t\t$(item).attr(\"checked\", !$(item).attr(\"checked\")); \r\n");
      out.write("\t\t\t\t}) \r\n");
      out.write("\t\t\t}); \r\n");
      out.write("});\r\n");
      out.write("</script>");
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
