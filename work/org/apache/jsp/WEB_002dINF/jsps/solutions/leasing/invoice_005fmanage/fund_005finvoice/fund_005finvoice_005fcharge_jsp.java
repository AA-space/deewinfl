package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.invoice_005fmanage.fund_005finvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class fund_005finvoice_005fcharge_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>资金发票计划开票</title>\r\n");
      out.write("<!--css sheet-->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/dtree/dtree.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/easyui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/button.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<!--javascript libray-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyJsonUtil.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/dtree/dtree.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTable.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyComboBox.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("var currentLoginUserId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("var isAdmin=false;\r\n");
      out.write("var tools=[ {\r\n");
      out.write("\thtml : '<font color=\"red\">生成开票清单</font>',\r\n");
      out.write("\thandler : function(table) {\r\n");
      out.write("\t\tvar operType = \"生成\";\r\n");
      out.write("\tvar operTitle = \"资金实收开票\";\r\n");
      out.write("\tvar operAction = \"submitFundChargeInvoice\";\r\n");
      out.write("\t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\tvar currentLoadMask = null;\r\n");
      out.write("    var params = {};\r\n");
      out.write("    var tempIdArr = [];\r\n");
      out.write("    var tempPIdArr = [];\r\n");
      out.write("    for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\tvar paymentid=checkedRowdata.paymentid;\r\n");
      out.write("\t\ttempIdArr.push(id);\r\n");
      out.write("\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t}\r\n");
      out.write("\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\tparams[\"paymentids\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfor(var i =0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\tif(\"已确认\"==checkedRawData.invoicestatus){\r\n");
      out.write("\t\t\talert(\"该条\"+operTitle+\"已确认，不允许退回！！！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\tif(\"确认中\"==checkedRawData.invoicestatus){\r\n");
      out.write("\t\t\talert(\"该条\"+operTitle+\"在确认中，不允许再次生成！！！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\tif(\"不生成\"==checkedRawData.invoicestatus){\r\n");
      out.write("\t\t\talert(\"该条\"+operTitle+\"已选择不成生，不允许再次生成！！！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\t}  \r\n");
      out.write("\t}\r\n");
      out.write("\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) return;\r\n");
      out.write("\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\tcurrentLoadMask.show();\r\n");
      out.write("\tajaxRequest({\r\n");
      out.write("        url:url,\r\n");
      out.write("        params:params,\r\n");
      out.write("        timeout:30*1000,\r\n");
      out.write("        success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("\t   \t\tres=res.responseText;\r\n");
      out.write("            res=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("     \t    if(res!=''){\r\n");
      out.write("\t    \t \talert(res);\r\n");
      out.write("     \t    }else{\r\n");
      out.write("     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("     \t    }\r\n");
      out.write("            currentLoadMask.hide();\r\n");
      out.write("            table.reload();\r\n");
      out.write("            //successCallBack(table);\r\n");
      out.write("        }\r\n");
      out.write("   });\r\n");
      out.write("\t},\r\n");
      out.write("\ticonCls : 'icon-save'\r\n");
      out.write("\t },\r\n");
      out.write("\t{\r\n");
      out.write("\t\thtml : '<font color=\"red\">不生成开票清单</font>',\r\n");
      out.write("\t\thandler : function(table) {\r\n");
      out.write("\t\tvar operType = \"不生成\";\r\n");
      out.write("\t\tvar operTitle = \"资金实收开票\";\r\n");
      out.write("\t\tvar operAction = \"removeFundChargeInvoice\";\r\n");
      out.write("\t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\tvar currentLoadMask = null;\r\n");
      out.write("     var params = {};\r\n");
      out.write("     var tempIdArr = [];\r\n");
      out.write("     var taxIdArr = [];\r\n");
      out.write("     var tempPIdArr = [];\r\n");
      out.write("     for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\tvar taxid = checkedRowdata.taxid;\r\n");
      out.write("\t\t\tvar paymentid=checkedRowdata.paymentid;\r\n");
      out.write("\t\ttempIdArr.push(id);\r\n");
      out.write("\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t\t\ttaxIdArr.push(taxid);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t\tparams[\"paymentids\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t\tparams[\"taxid\"] = taxIdArr.join(\",\");\r\n");
      out.write("\t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("\t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\tfor(var i =0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\tif(\"已确认\"==checkedRawData.invoicestatus){\r\n");
      out.write("\t\t\t\talert(\"该条\"+operTitle+\"已确认，不允许退回！！！\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\tif(\"确认中\"==checkedRawData.invoicestatus){\r\n");
      out.write("\t\t\t\talert(\"该条\"+operTitle+\"在确认中，不允许再次操作！！！\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\tif(\"不生成\"==checkedRawData.invoicestatus){\r\n");
      out.write("\t\t\t\talert(\"该条\"+operTitle+\"已选择不成生，不允许再次操作！！！\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) return;\r\n");
      out.write("\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\tajaxRequest({\r\n");
      out.write("         url:url,\r\n");
      out.write("         params:params,\r\n");
      out.write("         timeout:30*1000,\r\n");
      out.write("         success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write(" \t   \t\tres=res.responseText;\r\n");
      out.write(" \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t     \t    if(res!=''){\r\n");
      out.write("\t\t    \t \talert(res);\r\n");
      out.write("\t     \t    }else{\r\n");
      out.write("\t     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("\t     \t    }\r\n");
      out.write("             currentLoadMask.hide();\r\n");
      out.write("             table.reload();\r\n");
      out.write("             //successCallBack(table);\r\n");
      out.write("         }\r\n");
      out.write("    });\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ticonCls : 'icon-save'\r\n");
      out.write("\t }\r\n");
      out.write("\t ];\r\n");
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
      out.write("   \t var table = new tracywindyTable({\r\n");
      out.write("\r\n");
      out.write("   \t\twidth:all_width,\r\n");
      out.write("\t\theight:all_height,\r\n");
      out.write("\t\t//toolsLeftMargin:100,\r\n");
      out.write("   \t\t tableComment:'[资金发票实收开票]',\r\n");
      out.write("   \t\t constantFlagTable:'FundInvoice',\r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'资金发票实收开票',\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/invoice_manage/fund_invoice/fund_invoice_charge.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         isFit:false,\r\n");
      out.write("         checkType:'checkbox',\r\n");
      out.write("         isExcel:true,\r\n");
      out.write("         isCheck:true,\r\n");
      out.write(" \t\t isRank:false,\r\n");
      out.write(" \t\t tools : tools,\r\n");
      out.write("        columns:[\r\n");
      out.write("\t\t            {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t\t            {header:'taxid',name:'taxid',hidden:true},\r\n");
      out.write("\t\t            {header:'编号',name:'paymentid',hidden:true},\r\n");
      out.write("\t\t            {header:'合同号',name:'contractid',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'客户名称',name:'custname',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'经销商名称',name:'dealername'},\r\n");
      out.write("\t\t            {header:'收款日期',name:'plandate',type:\"date\",isRange:true,queryConfig:{isNewLine:false}},\r\n");
      out.write("\t\t            {header:'收款金额',name:'planmoney',type:'double',queryConfig:{isNewLine:true}},\r\n");
      out.write("\t\t            {header:'费用类型',name:'feetype',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'发票类型',name:'taxlevel',type:'combobox',queryConfig:{\r\n");
      out.write("\t\t            \tloadMode:'local',\r\n");
      out.write("\t\t            \tdatas:[\r\n");
      out.write("\t\t            \t{title:'增值税专用发票',name:'增值税专用发票'},\r\n");
      out.write("\t\t            \t{title:'增值税普通发票',name:'增值税普通发票'},\r\n");
      out.write("\t\t            \t{title:'全部',name:''}\r\n");
      out.write("\t\t            \t],\r\n");
      out.write("\t\t            \tisNewLine:true,\r\n");
      out.write("\t\t            \tdisplayField:'title',\r\n");
      out.write("\t\t            \tvalueField:'name',\r\n");
      out.write("\t\t            \tvalue:''\r\n");
      out.write("\t\t            \t\r\n");
      out.write("\t\t            }},\r\n");
      out.write("\t\t            {header:'纳税人识别号',name:'taxregcode'},\r\n");
      out.write("\t\t            {header:'开户行',name:'taxbank'},\r\n");
      out.write("\t\t            {header:'账号',name:'taxacc'},\r\n");
      out.write("\t\t            {header:'电话',name:'taxphone'},\r\n");
      out.write("\t\t            {header:'地址',name:'taxregadd'},\r\n");
      out.write("\t\t            {header:'状态',name:'invoicestatus',type:'combobox',\r\n");
      out.write("\t\t            \tqueryConfig:{\r\n");
      out.write("\t\t            \tisNewLine:false,\r\n");
      out.write("\t\t            \tcolSpan:3, \r\n");
      out.write("\t\t            \tloadMode:'local',\r\n");
      out.write("\t\t            \tdatas:[\r\n");
      out.write("\t\t            \t{title:'已导出',name:'已导出'},\r\n");
      out.write("\t\t            \t{title:'已确认',name:'已确认'},\r\n");
      out.write("\t\t            \t{title:'已退回',name:'已退回'},\r\n");
      out.write("\t\t            \t{title:'确认中',name:'确认中'},\r\n");
      out.write("\t\t            \t{title:'未提交',name:'未提交'},\r\n");
      out.write("\t\t            \t{title:'不生成',name:'不生成'},\r\n");
      out.write("\t\t            \t{title:'全部',name:''}\r\n");
      out.write("\t\t            \t],\r\n");
      out.write("\t\t            \tdisplayField:'title',\r\n");
      out.write("\t\t            \tvalueField:'name',\r\n");
      out.write("\t\t            \tvalue:'未提交'\r\n");
      out.write("\t\t            \t}}\r\n");
      out.write("\t        ],\r\n");
      out.write("\t        params:{\r\n");
      out.write("\t   \t        invoicestatus:'未提交'\r\n");
      out.write("\t\t   \t }\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("\t\r\n");
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

  private boolean _jspx_meth_permission_005faction_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f0 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f0.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/fund_invoice_charge.jsp(171,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/fund_invoice_charge.jsp(178,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/fund_invoice_charge.jsp(185,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
