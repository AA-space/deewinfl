package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.fund_005fbankcardload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class dedulist_005fmodif_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>抵扣明细维护</title>\r\n");
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
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function AdjustTotal(){\r\n");
      out.write("\tvar id_plan_money=$(\"#id_plan_money\").val()||0;\r\n");
      out.write("\tvar id_dedu_money=$(\"#id_dedu_money\").val()||0;\r\n");
      out.write("\tvar temp=parseFloat(id_plan_money)-parseFloat(id_dedu_money);\r\n");
      out.write("\t$(\"#id_last_money\").val(temp.toFixed(2));\r\n");
      out.write("}\r\n");
      out.write("    function importEbankCallBack(message){\r\n");
      out.write("        alert(message);\r\n");
      out.write("    \twindow.currentImportExcelLoadMask.hide();\r\n");
      out.write("    \tvar table = getTracywindyObject(\"id_table\");\r\n");
      out.write("    \ttable.reload();\r\n");
      out.write("    }\r\n");
      out.write("    var constantFlagTable = \"bankdownlist\";\r\n");
      out.write("    var ebankUploadUrl=\"\";\r\n");
      out.write("    var ebankAttachUrl=\"\";\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\t\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var tableebank = new tracywindyOperationTable({\r\n");
      out.write("\r\n");
      out.write("   \t\t tableComment:'[抵扣明细维护]',\r\n");
      out.write("   \t\t constantFlagTable:'FundforRent',\r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'抵扣明细维护',\r\n");
      out.write("         width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("         height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/fund_exprot_for_rent/dedulistmodifycollect.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         isExcel:true,\r\n");
      out.write("         isFit:true,\r\n");
      out.write("         //checkType:'checkbox',\r\n");
      out.write("         operButtons:'修改',\r\n");
      out.write("//          tools:[\r\n");
      out.write("//         \t {\r\n");
      out.write("//          \t    iconCls:'icon-update',\r\n");
      out.write("//          \t    html:'<font color=\"red\">提交租后经理</font>',\r\n");
      out.write("//          \t\thandler : function(table) {\r\n");
      out.write("//          \t\t    var operAction = \"submitFundForRentManager\";\r\n");
      out.write("//          \t\t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("// \t         \t\tvar currentLoadMask = null;\r\n");
      out.write("// \t         \t    var params = {};\r\n");
      out.write("// \t         \t    var tempIdArr = [];\r\n");
      out.write("// \t         \t    for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("// \t         \t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("// \t         \t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("// \t         \t\t\ttempIdArr.push(\"'\"+id+\"'\");\r\n");
      out.write("// \t         \t\t}\r\n");
      out.write("// \t         \t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("//          \t\t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("//          \t\t\t\talert(\"请选择要提交的记录！！\");\r\n");
      out.write("//          \t\t\t\treturn false;\r\n");
      out.write("//          \t\t\t}\r\n");
      out.write("// \t         \t\tif(!window.confirm((\"确定提交当前\"+checkedRowDatas.length+\"条记录么？\"))) return;\r\n");
      out.write("// \t         \t\tvar loadMaskMsg=\"正在提交数据   请稍后... \";\r\n");
      out.write("// \t         \t\tvar url=getRootPath()+\"/acl/\"+operAction+\".action\";\r\n");
      out.write("// \t         \t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("// \t         \t\tcurrentLoadMask.show();\r\n");
      out.write("// \t         \t\tajaxRequest({\r\n");
      out.write("// \t         \t        url:url,\r\n");
      out.write("// \t         \t        params:params,\r\n");
      out.write("// \t         \t        timeout:30*1000,\r\n");
      out.write("// \t         \t        success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("// \t         \t\t   \t\tres=res.responseText;\r\n");
      out.write("// \t         \t\t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("// \t         \t     \t    if(res!=''){\r\n");
      out.write("// \t         \t\t    \t \talert(res);\r\n");
      out.write("// \t         \t     \t    }else{\r\n");
      out.write("// \t         \t     \t    \talert(\"提交成功！！\");\r\n");
      out.write("// \t         \t     \t    }\r\n");
      out.write("// \t         \t            currentLoadMask.hide();\r\n");
      out.write("// \t         \t            table.reload();\r\n");
      out.write("// \t         \t        }\r\n");
      out.write("// \t         \t   });\r\n");
      out.write("//          \t\t}\r\n");
      out.write("//          \t }\r\n");
      out.write("//         \t ],\r\n");
      out.write("         columns:[\r\n");
      out.write("                    {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t\t            {header:'经销商',name:'cust_name',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'账号',name:'client_accnumber'},\r\n");
      out.write("\t\t            {header:'账户名称',name:'client_account'},\r\n");
      out.write("\t\t            {header:'开户行',name:'client_bank'},\r\n");
      out.write("\t\t            {header:'台数',name:'equip_count'},\r\n");
      out.write("\t\t            {header:'付款时间',name:'plan_date'},\r\n");
      out.write("\t\t            {header:'现汇金额',name:'plan_money'},\r\n");
      out.write("\t\t            {header:'抵扣金额',name:'dedu_money'},\r\n");
      out.write("\t\t            {header:'状态',name:'invalid',type:'combobox'\r\n");
      out.write("// \t\t\t\t\t\tqueryConfig:{\r\n");
      out.write("// \t\t\t\t\t\tcolSpan:2,\r\n");
      out.write("// \t\t\t\t\t\tloadMode:'local',\r\n");
      out.write("// \t\t\t\t\t\tdatas:[{title:'未提交',name:\"'未提交'\"},{title:'已提交',name:\"'已提交'\"}],\r\n");
      out.write("// \t\t\t            displayField:'title',\r\n");
      out.write("// \t\t\t            valueField:'name'\r\n");
      out.write("// \t\t\t\t\t\t}\r\n");
      out.write("\t\t            },\r\n");
      out.write("\t\t            {header:'备注',name:'fpnote'}\r\n");
      out.write("\t        ],\r\n");
      out.write("\t        params:{\r\n");
      out.write("\t        \tinvalid : \"'未提交'\"\r\n");
      out.write("\t\t   }\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("\t<div id=\"id_detailInfoWindowContainer\" title=\"维护抵扣租金信息\" style=\"display: none; width: 800px; height: 300px\">\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<form id=\"id_detailInfoForm\">\r\n");
      out.write("\t\t\t\t<table style=\"width: 90%\">\r\n");
      out.write("\t\t\t\t\t<tr style=\"display: none\">\r\n");
      out.write("\t\t\t\t\t\t<td><input name=\"id\" type=\"hidden\" value=\"\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"input_label_desc\" align=\"left\">经销商:</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input name=\"cust_name\" class=\"td-content-input\" readOnly label=\"经销商\" maxB=\"50\" /> <span class=\"content-required\">*</span></td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"input_label_desc\" align=\"left\">现汇金额:</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content\"><input type=\"text\" name=\"plan_money\" id=\"id_plan_money\" class=\"td-content-input\" readOnly require=\"true\" label=\"现汇金额\" dataType=\"Money\" /><span class=\"content-required\">*</span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"input_label_desc\" align=\"left\">抵扣金额:</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td-content\"><input type=\"text\" name=\"dedu_money\" id=\"id_dedu_money\" onkeyup=\"AdjustTotal()\" class=\"td-content-input\" require=\"true\" label=\"抵扣金额\" dataType=\"Money\" /><span class=\"content-required\">*</span></td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"input_label_desc\" align=\"left\">抵扣后放款金额:</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input name=\"last_money\" id=\"id_last_money\" class=\"td-content-input\" readOnly label=\"抵扣后放款金额\" maxB=\"50\" /> <span class=\"content-required\">*</span></td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t\t\t<td colspan='4'><a style=\"margin-left: 20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='getTracywindyObject(\"id_table\").operationTable();'><span>确定</span></a> <a\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"margin-left: 20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_detailInfoWindowContainer\").window(\"close\");'\r\n");
      out.write("\t\t\t\t\t\t><span>取消</span></a></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t</div>\r\n");
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
