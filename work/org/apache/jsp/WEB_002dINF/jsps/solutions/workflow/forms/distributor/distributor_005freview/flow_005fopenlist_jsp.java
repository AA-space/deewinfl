package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.distributor.distributor_005freview;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class flow_005fopenlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>经销商准入评审</title>\r\n");
      out.write("<!--css sheet-->\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/dtree/dtree.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/easyui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/button.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
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
      out.write("/js/dtree/dtree.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyComboBox.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   .picItem{\r\n");
      out.write("\t      float:left;\r\n");
      out.write("\t      padding:5px 5px 5px 5px;\r\n");
      out.write("\t      border:1px solid silver;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tvar all_width = (document.documentElement || document.body).clientWidth - 2;\r\n");
      out.write("\tvar all_height = (document.documentElement || document.body).clientHeight - 1;\r\n");
      out.write("\tvar table = new tracywindyOperationTable ({\r\n");
      out.write("\t\t\t\trenderTo : 'id_table_flowopen_select',\r\n");
      out.write("\t\t\t\twidth : all_width,\r\n");
      out.write("\t\t\t\theight : all_height,\r\n");
      out.write("\t\t\t\tisFit : true,\r\n");
      out.write("\t\t\t\toperButtons:\"\",\r\n");
      out.write("\t\t\t\ttools : [ {\r\n");
      out.write("\t\t\t\t\thtml : '<font color=\"red\">准入评审</font>',\r\n");
      out.write("\t\t\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\t\t\tvar projIDValue = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\t\t\tif (0 == projIDValue.length) {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"请选择经销商！\");\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t    var attachmentParams=\"&cust_id=\"+projIDValue[0].cust_id+\"&approvalnum=\"+projIDValue[0].approvalnum+\"&dealerid=\"+projIDValue[0].dealerid;\r\n");
      out.write("\t\t\t\t\tstartProcess(\"经销商准入评审-1\", attachmentParams);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t {\r\n");
      out.write("\t\t\t\t\t\thtml : '<font color=\"red\">准入撤销</font>',\r\n");
      out.write("\t\t\t\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\t\t\t\tvar projIDValue = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\t\t\t\tif (0 == projIDValue.length) {\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"请选择经销商！\");\r\n");
      out.write("\t\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t    var param={id:projIDValue[0].id};\r\n");
      out.write("\t\t\t\t\t    ajaxRequest({\r\n");
      out.write("\t\t\t\t\t\t     url:getRootPath()+\"/acl/cancelDealerApproval.acl\",\r\n");
      out.write("\t\t\t\t\t\t     method:'POST',\r\n");
      out.write("\t\t\t\t\t\t     success:function(res){\r\n");
      out.write("\t\t\t\t\t   \t\t    alert(res.responseText);\r\n");
      out.write("\t\t\t\t\t   \t\t    table.reload();\r\n");
      out.write("\t\t\t\t\t\t     },\r\n");
      out.write("\t\t\t\t\t\t     async:false,\r\n");
      out.write("\t\t\t\t\t\t     failure:function(res){},\r\n");
      out.write("\t\t\t\t\t\t     params:param\r\n");
      out.write("\t\t\t\t\t    });\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t ],\r\n");
      out.write("\t\t\t\tisPage : true,\r\n");
      out.write("\t\t\t\tpageSize : 20,\r\n");
      out.write("\t\t\t\tisCheck : true,\r\n");
      out.write("\t\t\t\tborder:   true,\r\n");
      out.write("\t\t\t\temptyChar : '-',\r\n");
      out.write("\t\t\t\tcheckType : 'radio',\r\n");
      out.write("\t\t\t\ttitle:\"经销商准入评审\",\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\txmlFileName : 'eleasing/workflow/distributor/DistributorCreditFlowSelectList.xml',\r\n");
      out.write("\t\t\t\tcolumns : [\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '经销商名称',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'custname',queryConfig:{\r\n");
      out.write("\t\t\t            \t   \r\n");
      out.write("\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '准入申请编号',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'approvalnum'\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '合作经销商编号',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'contractnum'\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '所属区域',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'ownerdistrict'\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '办事处',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'owneroffice'\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '登记人',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'creator'\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\theader : '登记时间',\r\n");
      out.write("\t\t\t\t\t\t\tname : 'createdate'\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t],\r\n");
      out.write("\t\t\tparams:{\r\n");
      out.write("\t\t  draft:'1',dealertstatus:'dealerApprovalstatus2',dealertstatus1:'dealerApprovalstatus5'\r\n");
      out.write("\t\t\t       //不是草稿,合作状态不为禁用,申请状态不为不通过\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("function openWindow(){\r\n");
      out.write("\tvar cust_id = getTracywindyObject('id_combo_cust').getValue();\r\n");
      out.write("\tif (!cust_id) {\r\n");
      out.write("\t\talert(\"请选择经销商!\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}else {\r\n");
      out.write("\t\t   var attachmentParams=\"&cust_id=\"+cust_id;\r\n");
      out.write("\t       startProcess(\"经销商准入评审-1\",attachmentParams);\r\n");
      out.write("        }\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"id_table_flowopen_select\"></div>\r\n");
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
