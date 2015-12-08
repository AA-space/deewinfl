package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.invoice_005fmanage.rent_005finvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class rent_005finvoice_005fincome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>租金/罚息实收应开票数据提醒清单</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
      out.write("    <link href=\"");
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
      out.write("\t\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var currentLoginUserId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("var isAdmin=false;\r\n");
      out.write("var tools=[ {\r\n");
      out.write("\t\thtml : '<font color=\"red\">生成开票清单</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("    \tvar operType = \"生成\";\r\n");
      out.write("\t\t\tvar operTitle = \"租金/罚息实收应开票数据\";\r\n");
      out.write("\t\t\tvar operAction = \"submitRentIncome\";\r\n");
      out.write("\t \t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\tvar currentLoadMask = null;\r\n");
      out.write("\t        var params = {};\r\n");
      out.write("\t        var tempIdArr = [];\r\n");
      out.write("\t        var tempPIdArr = [];\r\n");
      out.write("\t        for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\t\tvar paymentid=checkedRowdata.typename;\r\n");
      out.write("\t\t\t\ttempIdArr.push(id);\r\n");
      out.write("\t\t\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t\t\tparams[\"typnames\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t \t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("   \t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("   \t\t\treturn;\r\n");
      out.write("   \t\t\t}\r\n");
      out.write("\t \t\tfor(var i =0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\t\tif(\"确认中\"==checkedRawData.status||\"已导出\"==checkedRawData.status){\r\n");
      out.write("\t\t\t\t\talert(\"该条\"+operTitle+checkedRawData.status+\"，不允许重复提交！！！\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) return;\r\n");
      out.write("\t\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\t\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\t\t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\t\tajaxRequest({\r\n");
      out.write("               url:url,\r\n");
      out.write("               params:params,\r\n");
      out.write("               timeout:30*1000,\r\n");
      out.write("               success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("       \t   \t\tres=res.responseText;\r\n");
      out.write("       \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t    \t \talert(res);\r\n");
      out.write("\t\t     \t    }else{\r\n");
      out.write("\t\t     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("\t\t     \t    }\r\n");
      out.write("                   currentLoadMask.hide();\r\n");
      out.write("                   table.reload();\r\n");
      out.write("                   //successCallBack(table);\r\n");
      out.write("               }\r\n");
      out.write("          });\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-save'\r\n");
      out.write("\t\t},{\r\n");
      out.write("\t\t\thtml : '<font color=\"red\">不生成开票清单</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\tvar operType = \"不生成\";\r\n");
      out.write("\t\t\tvar operTitle = \"租金/罚息实收应开票\";\r\n");
      out.write("\t\t\tvar operAction = \"removeRentIncome\";\r\n");
      out.write("\t \t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\tvar currentLoadMask = null;\r\n");
      out.write("\t        var params = {};\r\n");
      out.write("\t        var tempIdArr = [];\r\n");
      out.write("\t        var tempPIdArr = [];\r\n");
      out.write("\t        for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\t\tvar paymentid=checkedRowdata.typename;\r\n");
      out.write("\t\t\t\ttempIdArr.push(id);\r\n");
      out.write("\t\t\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t\t\tparams[\"typnames\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t \t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("  \t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("  \t\t\treturn;\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("\t \t\tfor(var i =0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\t\tif(\"已确认\"==checkedRawData.status){\r\n");
      out.write("\t\t\t\t\talert(\"该条\"+operTitle+\"已确认，不允许退回！！！\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) return;\r\n");
      out.write("\t\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\t\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\t\t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\t\tajaxRequest({\r\n");
      out.write("              url:url,\r\n");
      out.write("              params:params,\r\n");
      out.write("              timeout:30*1000,\r\n");
      out.write("              success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("      \t   \t\tres=res.responseText;\r\n");
      out.write("      \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t    \t \talert(res);\r\n");
      out.write("\t\t     \t    }else{\r\n");
      out.write("\t\t     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("\t\t     \t    }\r\n");
      out.write("                  currentLoadMask.hide();\r\n");
      out.write("                  table.reload();\r\n");
      out.write("                  //successCallBack(table);\r\n");
      out.write("              }\r\n");
      out.write("         });\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-cancel'\r\n");
      out.write("\t\t} ];\r\n");
      out.write("</script >\r\n");
      if (_jspx_meth_permission_005faction_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_permission_005faction_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_permission_005faction_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t      var all_width = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("\t      var all_height = (document.documentElement||document.body).clientHeight-2;\r\n");
      out.write("\t    </script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var table = new tracywindyOperationTable({\r\n");
      out.write("   \t\t renderTo:'id_tableContainer',\r\n");
      out.write("   \t\t width:all_width,\r\n");
      out.write("\t\t height:all_height,\r\n");
      out.write("\t\t //toolsLeftMargin:200,\r\n");
      out.write("\t\t windowTop:20,\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         title:'租金/罚息实收应开票数据提醒清单',\r\n");
      out.write("         tools : tools,\r\n");
      out.write(" \t\t\r\n");
      out.write("         \r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_income.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         pageSize : 20,\r\n");
      out.write("         isExcel:true,\r\n");
      out.write("         isCheck:true,\r\n");
      out.write("         checkType:'checkbox',\r\n");
      out.write("         params:{\r\n");
      out.write("        \t status:\"未生成','已退回\"\r\n");
      out.write("         },\r\n");
      out.write(" \t\t isRank:false,\r\n");
      out.write("         columns:[\r\n");
      out.write("\t\t\t        {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'typename',  header:'typename',hidden:true},\r\n");
      out.write("\t\t\t       {name:'contractid',  header:'合同号',nullable:false ,width:80,queryConfig:{}},\r\n");
      out.write("\t\t\t       {name:'contractnumber',  header:'业务合同编号',nullable:false ,queryConfig:{},width:150},\r\n");
      out.write("\t\t\t       {name:'custname',  header:'客户名称',nullable:false ,queryConfig:{}},\r\n");
      out.write("\t\t\t       {name:'dealername',  header:'经销商名称',nullable:false},\r\n");
      out.write("\t\t\t       {name:'rentlist',  header:'期项',nullable:false,width:40 },\r\n");
      out.write("\t\t\t       {name:'rent',  header:'租金',nullable:false,type:'double' },\r\n");
      out.write("\t\t\t       {name:'corpus',  header:'本金',nullable:false,type:'double' },\r\n");
      out.write("\t\t\t       {name:'interest',  header:'利息',nullable:false,type:'double' },\r\n");
      out.write("\t\t\t       {name:'penalty',  header:'罚息',nullable:false,type:'double' },\r\n");
      out.write("\t\t\t       {name:'moneytype',  header:'金额类型',nullable:false },\r\n");
      out.write("\t\t\t       {name:'plandate',  header:'实收日期',type:'date',isRange:true,queryConfig:{isNewLine:true}},\r\n");
      out.write("\t\t\t       {name:'plan_date',  header:'计划日期',nullable:false,type:\"date\",isRange:true,queryConfig:{}},\r\n");
      out.write("\t\t\t       {name:'taxtype',  header:'发票类型',nullable:false ,type:'combobox',queryConfig:{\r\n");
      out.write("\t\t            \tloadMode:'local',\r\n");
      out.write("\t\t            \tdatas:[\r\n");
      out.write("\t\t            \t{title:'增值税专用发票',name:'增值税专用发票'},\r\n");
      out.write("\t\t            \t{title:'增值税普通发票',name:'增值税普通发票'},\r\n");
      out.write("\t\t            \t{title:'全部',name:''}\r\n");
      out.write("\t\t            \t],\r\n");
      out.write("\t\t            \tdisplayField:'title',\r\n");
      out.write("\t\t            \tvalueField:'name',\r\n");
      out.write("\t\t            \tvalue:''\r\n");
      out.write("\t\t            \t\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t\t       {name:'rentinvoicetype',  header:'开票方式',nullable:false },\r\n");
      out.write("\t\t\t       {name:'status',  header:'状态',type:'combobox',\r\n");
      out.write("\t\t            \tqueryConfig:{\r\n");
      out.write("\t\t            \tisNewLine:true,\r\n");
      out.write("\t\t            \tcolSpan:3, \r\n");
      out.write("\t\t            \tloadMode:'local',\r\n");
      out.write("\t\t            \tdatas:[\r\n");
      out.write("                        {title:'未生成',name:'未生成'},       \r\n");
      out.write("                        {title:'确认中',name:'确认中'},\r\n");
      out.write("\t\t            \t{title:'已导出',name:'已导出'},\r\n");
      out.write("\t\t            \t{title:'已退回',name:'已退回'}\r\n");
      out.write("\t\t            \t],\r\n");
      out.write("\t\t            \tdisplayField:'title',\r\n");
      out.write("\t\t            \tvalueField:'name',\r\n");
      out.write("\t\t            \tvalue:''\r\n");
      out.write("\t\t            \t}\r\n");
      out.write("\t\t\t       }\r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t       \t     ]\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/rent_invoice/rent_invoice_income.jsp(155,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f0.setCode("interest_master");
    int _jspx_eval_permission_005faction_005f0 = _jspx_th_permission_005faction_005f0.doStartTag();
    if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("isAdmin=true;\r\n");
        out.write("tools='';\r\n");
        out.write("</script >\r\n");
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
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/rent_invoice/rent_invoice_income.jsp(162,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f1.setCode("rent_account");
    int _jspx_eval_permission_005faction_005f1 = _jspx_th_permission_005faction_005f1.doStartTag();
    if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("isAdmin=true;\r\n");
        out.write("tools='';\r\n");
        out.write("</script >\r\n");
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

  private boolean _jspx_meth_permission_005faction_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f2 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f2.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/rent_invoice/rent_invoice_income.jsp(169,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f2.setCode("tax_account");
    int _jspx_eval_permission_005faction_005f2 = _jspx_th_permission_005faction_005f2.doStartTag();
    if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("isAdmin=true;\r\n");
        out.write("tools='';\r\n");
        out.write("</script >\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f2);
    return false;
  }
}
