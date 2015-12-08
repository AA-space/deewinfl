package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

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
      out.write("<title>合同管理-合同审批</title>\r\n");
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
      out.write("    //var proj_id=\"");
      out.print( request.getParameter("id"));
      out.write("\";\r\n");
      out.write("    var param={};\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var table = new tracywindyOperationTable({\r\n");
      out.write("   \t\t tableComment:'[项目信息]',\r\n");
      out.write("   \t\t constantFlagTable:'ProjInfo',\r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'项目信息',\r\n");
      out.write("         width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("         height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         xmlFileName:'\\\\eleasing\\\\workflow\\\\contract\\\\contract_flowlist.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         params:{\r\n");
      out.write("\t\t  user_id:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t  //增加显示 已合同审批的过滤掉（判断项目和合同金额）\r\n");
      out.write("\t\t  cApproval:\"1\"\r\n");
      out.write("\t     },\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         operButtons:' ',\r\n");
      out.write("         isFit:false,\r\n");
      out.write("         isAutoBreakContent:true,\r\n");
      out.write("         tools:[{\r\n");
      out.write("        \t html : '<font color=\"red\">合同审批</font>',\r\n");
      out.write(" \t\t\t handler : function(table) {\r\n");
      out.write(" \t\t\t\tvar projIDValue = table.getCheckedRowDatas();\r\n");
      out.write(" \t\t\t\tif (0 == projIDValue.length) {\r\n");
      out.write(" \t\t\t\t\talert(\"请选择需要启动的流程！\");\r\n");
      out.write(" \t\t\t\t\treturn false;\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write(" \t\t\t\tvar conditions = {};\r\n");
      out.write(" \t\t    \tconditions.projID = projIDValue[0][\"pid\"];//项目id,必填\r\n");
      out.write(" \t\t    \t//ajax成功提交window\r\n");
      out.write("\t \t\t   \tvar sheight = window.screen.availHeight-30;\r\n");
      out.write("\t \t\t    var swidth = window.screen.availWidth-10;\r\n");
      out.write(" \t\t    \tvar winoption =\"left=0px,top=0px,height=\"+sheight+\"px,width=\"+swidth+\"px,toolbar=yes,menubar=yes,location=yes,status=yes,scrollbars=yes,resizable=yes\";\r\n");
      out.write(" \t\t    \t//var winRef = window.open(\"\", \"_blank\",winoption);//打开一个新的页面\r\n");
      out.write("\t\t\t\t/*$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/checkContractStart.action', conditions, function(data) {\r\n");
      out.write("\t\t\t\t\t\tif (data['result'] == 'error') {\r\n");
      out.write("\t\t\t\t\t\t\ttry{\r\n");
      out.write("\t\t\t\t\t\t\t\twinRef.opener = null;\r\n");
      out.write("\t\t\t\t\t\t\t\twinRef.close();\r\n");
      out.write("\t\t\t\t\t\t\t}catch(e){}\r\n");
      out.write("\t\t\t\t\t\t\talert(\"您所选择的项目设备金额为【\"+data['projEquipAmt']+\"】,已经发起【\"+ data['number']+\"】条合同,总共金额为【\" + data['contractEquipAmt'] + \"】。\\n此条项目不能发起流程,请检查。\");\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tvar attachmentParams = \"proj_id=\" + projIDValue[0][\"pid\"]+\"&cust_id=\"+projIDValue[0][\"custid\"];\r\n");
      out.write("\t\t\t\t\t\t\tstartProcess(\"合同审批流程-1\",attachmentParams,winRef);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});*/\r\n");
      out.write("\t\t\tvar loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');\r\n");
      out.write("\t\t\tloadMask_oper.show();\r\n");
      out.write(" \t\t       ajaxRequest({\r\n");
      out.write("\t\t\t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/checkContractStart.action',\r\n");
      out.write("\t\t\t\t     method:'POST',\r\n");
      out.write("\t\t\t\t     success:function(res){\r\n");
      out.write("\t\t\t\t\t     var data = res.responseText;\r\n");
      out.write("\t\t\t\t\t     data = eval(\"(\"+data+\")\");\r\n");
      out.write("\t\t\t\t\t     if (data['result'] == 'error') {\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"您所选择的项目设备金额为【\"+data['projEquipAmt']+\"】,已经发起【\"+ data['number']+\"】条合同,总共金额为【\" + data['contractEquipAmt'] + \"】。\\n此条项目不能发起流程,请检查。\");\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar attachmentParams = \"proj_id=\" + projIDValue[0][\"pid\"]+\"&cust_id=\"+projIDValue[0][\"custid\"];\r\n");
      out.write("\t\t\t\t\t\t\t\tstartProcess(\"合同审批流程-1\",attachmentParams);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t     },\r\n");
      out.write("\t\t\t\t\t params:conditions,\r\n");
      out.write("\t\t\t\t     failure:function(res){},\r\n");
      out.write("\t\t\t\t     async:false,\r\n");
      out.write("\t\t\t\t     timeout:30*1000\r\n");
      out.write("\t\t\t    });\r\n");
      out.write(" \t\t      loadMask_oper.hide();\r\n");
      out.write(" \t\t     table.reload();\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\tcolumns : [ {\r\n");
      out.write("\t\t\t\theader : 'id',\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : 'pid',\r\n");
      out.write("\t\t\t\tname : 'pid',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : 'projstatus',\r\n");
      out.write("\t\t\t\tname : 'projstatusnum',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : 'custid',\r\n");
      out.write("\t\t\t\tname : 'custid',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '项目编号',\r\n");
      out.write("\t\t\t\tname : 'projid',\r\n");
      out.write("\t\t\t\tqueryConfig : {}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '项目名称',\r\n");
      out.write("\t\t\t\tname : 'projname',\r\n");
      out.write("\t\t\t\twidth : 350,\r\n");
      out.write("\t\t\t\tqueryConfig : {\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '租赁形式',\r\n");
      out.write("\t\t\t\tname : 'leasform',\r\n");
      out.write("\t\t\t\tqueryConfig : {\r\n");
      out.write("\t\t\t\t\tisNewLine : true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '项目状态',\r\n");
      out.write("\t\t\t\tname : 'projstatus'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '客户名称',\r\n");
      out.write("\t\t\t\tname : 'custname',\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\tqueryConfig : {}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '经销商名称',\r\n");
      out.write("\t\t\t\tname : 'custdealer',\r\n");
      out.write("\t\t\t\tqueryConfig : {}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '业务类型',\r\n");
      out.write("\t\t\t\tname : 'businesstype'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '业务模式',\r\n");
      out.write("\t\t\t\tname : 'businessmode'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '客户性质',\r\n");
      out.write("\t\t\t\tname : 'custproperty'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '身份证/组织机构代码',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\tname : 'orgcodecardno'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '纳税人类别',\r\n");
      out.write("\t\t\t\tname : 'taxpayertype'\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\theader : '项目经理',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\tname : 'projmanage'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '项目助理',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\tname : 'projassistant'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '项目出单部门',\r\n");
      out.write("\t\t\t\tname : 'projdept'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '项目金额',\r\n");
      out.write("\t\t\t\tname : 'projmoney'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\theader : '已有合同金额',\r\n");
      out.write("\t\t\t\tname : 'contractmoney'\r\n");
      out.write("\t\t\t}  ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
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
