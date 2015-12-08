package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>实际投放</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
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
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/workFlowUtil.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<!--javascript libray-->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
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
      out.write("/js/tracywindy/tracywindySerializeFormToJsonObject.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/validator.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("\tvar param={};\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\t\r\n");
      out.write("\tvar attachmentParams;\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t var table = new tracywindyOperationTable({\r\n");
      out.write("\t\t tableComment:'[项目信息]',\r\n");
      out.write("\t\t constantFlagTable:'ProjInfo',\r\n");
      out.write("\t\t windowTop:20,\r\n");
      out.write("\t     border:true,\r\n");
      out.write("      renderTo:'id_tableContainer',\r\n");
      out.write("      title:'项目信息',\r\n");
      out.write("      width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("      height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("      id:'id_table',\r\n");
      out.write("      xmlFileName:'\\\\eleasing\\\\workflow\\\\contract\\\\payequipment_flowopen_list.xml',\r\n");
      out.write("      loadMode:'ajax',\r\n");
      out.write("      params:{\r\n");
      out.write("      \tCONTRACT_STATUS_LessThan : 100, \r\n");
      out.write("      \tCONTRACT_STATUS_GreaterThan : 30,\r\n");
      out.write("      \tuserId:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("       },\r\n");
      out.write("      isPage:true,\r\n");
      out.write("      operButtons:' ',\r\n");
      out.write("      isFit:false,\r\n");
      out.write("      tools:[{\r\n");
      out.write("     \t html : '<font color=\"red\">投放</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tvar projIDValue = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == projIDValue.length) {\r\n");
      out.write("\t\t\t\t\talert(\"请选择需要启动的流程！\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//attachmentParams = \"cust_id=\"+projIDValue[0].custid+\"&contract_id=\" + projIDValue[0].id ;\r\n");
      out.write("\t\t     \t//startProcess(\"实际投放流程-1\",attachmentParams);\r\n");
      out.write("\t\t     \t\r\n");
      out.write("\t\t\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/checkContractOnhireStart.action\";\r\n");
      out.write(" \t\t\t\tvar params = {contract_id:projIDValue[0][\"id\"]};\r\n");
      out.write(" \t\t\t\t ajaxRequest({\r\n");
      out.write(" \t\t\t    \t method:'POST',\r\n");
      out.write(" \t\t\t         url:url,\r\n");
      out.write(" \t\t\t         async:false,\r\n");
      out.write(" \t\t\t         params:params,\r\n");
      out.write(" \t\t\t         failure:function(res){},\r\n");
      out.write(" \t\t\t         success:function(res){\r\n");
      out.write(" \t\t\t \t   \t\tres=res.responseText;\r\n");
      out.write(" \t\t\t \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write(" \t\t\t     \t    if(res != ''){\r\n");
      out.write(" \t\t\t     \t    \tvar rs=JsonUtil.decode(res);\r\n");
      out.write(" \t\t\t     \t    \t//alert(rs['result']);\r\n");
      out.write(" \t \t\t\t     \t    if(rs['result'] == '-5'){\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"首付款没收完\");\r\n");
      out.write("\t\t\t\t\t\t\t}else if(rs['result'] == '-4'){\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"GPS没有安装\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t/* else if(rs['result'] == 'equipAmt_lt'){\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"已投放完毕！\");\r\n");
      out.write("\t\t\t\t\t\t\t} */\r\n");
      out.write("\t\t\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\t\t\tattachmentParams = \"cust_id=\"+projIDValue[0].custid+\"&contract_id=\" + projIDValue[0].id ;\r\n");
      out.write(" \t \t\t\t\t\t     \tstartProcess(\"实际投放流程-1\",attachmentParams);\r\n");
      out.write(" \t \t \t \t\t\t    }\r\n");
      out.write(" \t \t\t\t     \t table.reload(); \r\n");
      out.write(" \t\t\t     \t    }else{\r\n");
      out.write(" \t\t\t     \t    \t\r\n");
      out.write(" \t\t\t     \t    }\r\n");
      out.write(" \t\t\t         }\r\n");
      out.write(" \t\t\t    });\r\n");
      out.write("\t\t     \t\r\n");
      out.write("\t\t     \t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls :'icon-update'\r\n");
      out.write("          }],\r\n");
      out.write("      columns:[\r\n");
      out.write("\t\t            {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t\t            {header:'proj_id',name:'proj_id',hidden:true},\r\n");
      out.write("\t\t            {header:'pid',name:'pid',hidden:true},\r\n");
      out.write("\t\t            {header:'custid',name:'custid',hidden:true},\r\n");
      out.write("\t\t            {header:'typecode',name:'typecode',hidden:true},\r\n");
      out.write("\t\t            {header:'合同编号',name:'contractid',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'业务合同号',name:'contractnumber',width:150,queryConfig:{}},\r\n");
      out.write("\t\t            {header:'项目名称',name:'projname',width:300,queryConfig:{}},\r\n");
      out.write("\t\t            {header:'客户名称',name:'custname',queryConfig:{isNewLine:true}},\r\n");
      out.write("\t\t            {header:'经销商名称',name:'custdealer',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'业务类别',name:'businesstype'},\r\n");
      out.write("\t\t            {header:'业务模式',name:'businessmode'},\r\n");
      out.write("\t\t            {header:'区域',name:'ownerdistrict'},\r\n");
      out.write("\t\t            {header:'应付设备款',name:'planmoney',type:'number'},\r\n");
      out.write("\t\t            {header:'设备验收日期',name:'acceptdate'},\r\n");
      out.write("\t\t            {header:'已付设备款',name:'factmoney',type:'number'},\r\n");
      out.write("\t\t            {header:'未付设备款',name:'lastmoney',type:'number'},\r\n");
      out.write("\t\t            {header:'活动类型',name:'projtype'},\r\n");
      out.write("\t\t            {header:'项目来源',name:'projsource'},\r\n");
      out.write("\t\t            //{header:'项目规模',name:'projscale'},\r\n");
      out.write("\t\t            {header:'租赁形式',name:'leasform'},\r\n");
      out.write("\t\t            {header:'客户经理',name:'projmanage'}\r\n");
      out.write("      ]\r\n");
      out.write("\t });\r\n");
      out.write("});\r\n");
      out.write(" </script>\r\n");
      out.write(" \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
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
