package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.invoice_005fmanage.fund_005finvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class contract_005ffund_005ffund_005freceipt_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>资金实收开票确认（收据）</title>\r\n");
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
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    html,body{\r\n");
      out.write("        overflow:hidden;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/**\r\n");
      out.write(" * 金额大写转换函数\r\n");
      out.write(" */\r\n");
      out.write("function money2DX(money) {\r\n");
      out.write("\tif (!/^(0|[1-9]\\d*)(\\.\\d+)?$/.test(money)){\r\n");
      out.write("\t\treturn \"数据非法\";\r\n");
      out.write("\t}\r\n");
      out.write("\tvar unit = \"千百拾亿千百拾万千百拾元角分\", str = \"\";\r\n");
      out.write("\tmoney += \"00\";\r\n");
      out.write("\tvar p = money.indexOf('.');\r\n");
      out.write("\tif (p >= 0){\r\n");
      out.write("\t\tmoney = money.substring(0, p) + money.substr(p + 1, 2);\r\n");
      out.write("\t}\r\n");
      out.write("\tunit = unit.substr(unit.length - money.length);\r\n");
      out.write("\tfor (var i = 0; i < money.length; i++){\r\n");
      out.write("\t\tstr += '零壹贰叁肆伍陆柒捌玖'.charAt(money.charAt(i)) + unit.charAt(i);\r\n");
      out.write("\t}\r\n");
      out.write("\treturn str.replace(/零(千|百|拾|角)/g, \"零\").replace(/(零)+/g, \"零\").replace(/零(万|亿|元)/g, \"$1\").replace(/(亿)万|壹(拾)/g, \"$1$2\").replace(/^元零?|零分/g, \"\").replace(/元$/g, \"元整\");\r\n");
      out.write("};\r\n");
      out.write("function createNote(table){\r\n");
      out.write("\tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("\tids=\"\";\r\n");
      out.write("\tcontracts=\"\";\r\n");
      out.write("\tfilename=\"\";\r\n");
      out.write("\tvar MS_receipt=[];\r\n");
      out.write("\tvar params ={};\r\n");
      out.write("\tvar tempIdArr=[];\r\n");
      out.write("\tfor(var i=0;i<plandata.length;i++){\r\n");
      out.write("    \tvar id=plandata[i].id;\r\n");
      out.write("    \ttempIdArr.push(id);\r\n");
      out.write("    \tif(\"等待导出\" == plandata[i].status || \"已导出\" == plandata[i].status ){\r\n");
      out.write("\t    \tvar contractnumber=plandata[i].contractnumber;\r\n");
      out.write("\t    \t//var custname=plandata[i].custname;\r\n");
      out.write("\t    \tvar contractid=plandata[i].contractid;\r\n");
      out.write("\t    \t//收据数据\r\n");
      out.write("\t    \tvar payobj=plandata[i].payobj;//付款对象\r\n");
      out.write("\t    \tvar factdate=plandata[i].factdate;\r\n");
      out.write("\t    \tvar incomedate=factdate.substr(0,4)+\"年\"+factdate.substr(5,2)+\"月\"+factdate.substr(8,2)+\"日\";//收款时间\r\n");
      out.write("\t    \tvar receipttitle=\"收到\"+plandata[i].custname+plandata[i].feetype;\r\n");
      out.write("\t    \tvar moneymin=\"￥\"+parseFloat(plandata[i].dactmoney).toFixed(2);\r\n");
      out.write("\t    \tvar moneymax=money2DX(parseFloat(plandata[i].dactmoney).toFixed(2));\r\n");
      out.write("\t    \tMS_receipt.push({id:id,memo:contractnumber,modelname:'overduenotice',sheetname:plandata[i].contractid+plandata[i].feetype+'收据'+Math.round(Math.random()*10000),'contractid':contractid,'incomedate':incomedate,'payobj':payobj,'receipttitle':receipttitle,'moneymin':moneymin,'moneymax':moneymax});\r\n");
      out.write("\t    \t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t    \talert(\"只能生成等待导出和已导出的数据\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t    }\r\n");
      out.write("    }\r\n");
      out.write("\t/*后台改收据状态为4  已导出*/\r\n");
      out.write("\tparams[\"cffcid\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t  \ttype: \"POST\",\r\n");
      out.write("\t  \tcache : false,\r\n");
      out.write("\t\tasync : false,\r\n");
      out.write("\t    url:  getRootPath()+\"/leasing/checkVtatusInfo.action\",\r\n");
      out.write("\t    data: params,\r\n");
      out.write("\t    success: function(msg){\r\n");
      out.write("\t    \tif (msg == \"no\"){\r\n");
      out.write("\t    \t\talert(\"变更已导出状态请求失败!\");\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \telse{\r\n");
      out.write("\t    \t\t//alert( msg );//return yes\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \ttable.reload();\r\n");
      out.write("\t   }\r\n");
      out.write("\t});\r\n");
      out.write("\t/*后台改收据状态为4  已导出  end*/\r\n");
      out.write("\tvar url=\"/leasing/template/createFileByTemplateClass.action\";\r\n");
      out.write("\tattachmentDown({url:url,title:\"下载通知函\",twoClassify:'wordtempletypetwo1234',returnType:'list',MS_receipt:MS_receipt});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\tvar buttons = {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tsubmitButton: {\r\n");
      out.write("\t\t\thtml : '提交',\r\n");
      out.write("\t\t\ticonCls : 'icon-save',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t \t\t\tvar operType = \"提交\";\r\n");
      out.write("\t\t\t\tvar operTitle = \"资金实收收据\";\r\n");
      out.write("\t\t\t\tvar operAction = \"submitFundReceipt2\";\r\n");
      out.write("\t \t \t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tvar currentLoadMask = null;\r\n");
      out.write("\t\t        var params = {};\r\n");
      out.write("\t\t        var tempIdArr = [];\r\n");
      out.write("\t\t        var tempPIdArr = [];\r\n");
      out.write("\t\t \t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("\t    \t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t\t        for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\t\t\tvar paymentid=checkedRowdata.paymentid;\r\n");
      out.write("\t\t\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tif(\"等待提交\" != checkedRawData.status){\r\n");
      out.write("\t\t\t\t\t\talert(\"只能提交等待提交的数据\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttempIdArr.push(id);\r\n");
      out.write("\t\t\t\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t\t\t\tparams[\"paymentids\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t\t\t\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) {\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\t\t\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\t\t\t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\t\t\tajaxRequest({\r\n");
      out.write("\t                url:url,\r\n");
      out.write("\t                params:params,\r\n");
      out.write("\t                timeout:30*1000,\r\n");
      out.write("\t                failure:function(){\r\n");
      out.write("\t                \talert(\"请求提交失败\");\r\n");
      out.write("\t                \tcurrentLoadMask.hide();\r\n");
      out.write("\t                },\r\n");
      out.write("\t                success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("\t        \t   \t\tres=res.responseText;\r\n");
      out.write("\t        \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t\t    \t \talert(res);\r\n");
      out.write("\t\t\t     \t    }else{\r\n");
      out.write("\t\t\t     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("\t\t\t     \t    }\r\n");
      out.write("\t                    currentLoadMask.hide();\r\n");
      out.write("\t                    table.reload();\r\n");
      out.write("\t                }\r\n");
      out.write("\t            });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t \t},\r\n");
      out.write("\t \t\r\n");
      out.write("\t\tconfirmButton: {\r\n");
      out.write("\t\t\thtml : '确认',\r\n");
      out.write("\t\t\ticonCls : 'icon-ok',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t \t\t\tvar operType = \"确认\";\r\n");
      out.write("\t\t\t\tvar operTitle = \"资金实收收据\";\r\n");
      out.write("\t\t\t\tvar operAction = \"submitFundReceipt1\";\r\n");
      out.write("\t \t \t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tvar currentLoadMask = null;\r\n");
      out.write("\t\t        var params = {};\r\n");
      out.write("\t\t        var tempIdArr = [];\r\n");
      out.write("\t\t        var tempPIdArr = [];\r\n");
      out.write("\t\t \t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("\t    \t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t\t        for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\t\t\tvar paymentid=checkedRowdata.paymentid;\r\n");
      out.write("\t\t\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tif(\"等待确认\" != checkedRawData.status){\r\n");
      out.write("\t\t\t\t\t\talert(\"只能确认等待确认的数据\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttempIdArr.push(id);\r\n");
      out.write("\t\t\t\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t\t\t\tparams[\"paymentids\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t\t\t\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) {\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\t\t\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\t\t\t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\t\t\tajaxRequest({\r\n");
      out.write("\t                url:url,\r\n");
      out.write("\t                params:params,\r\n");
      out.write("\t                timeout:30*1000,\r\n");
      out.write("\t                failure:function(){\r\n");
      out.write("\t                \talert(\"请求提交失败\");\r\n");
      out.write("\t                \tcurrentLoadMask.hide();\r\n");
      out.write("\t                },\r\n");
      out.write("\t                success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("\t        \t   \t\tres=res.responseText;\r\n");
      out.write("\t        \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t\t    \t \talert(res);\r\n");
      out.write("\t\t\t     \t    }else{\r\n");
      out.write("\t\t\t     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("\t\t\t     \t    }\r\n");
      out.write("\t                    currentLoadMask.hide();\r\n");
      out.write("\t                    table.reload();\r\n");
      out.write("\t                }\r\n");
      out.write("\t            });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t \t},\r\n");
      out.write("\t \t/*\r\n");
      out.write("\t \texportButton : {\r\n");
      out.write("\t\t\thtml : '导出',\r\n");
      out.write("\t\t\ticonCls : 'icon-print',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t \t\t\tvar operType = \"导出\";\r\n");
      out.write("\t\t\t\tvar operTitle = \"资金实收收据\";\r\n");
      out.write("\t\t\t\tvar operAction = \"exportFundReceipt\";\r\n");
      out.write("\t \t \t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t        var tempIdArr = [];\r\n");
      out.write("\t\t \t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("\t    \t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t\t \t\t\r\n");
      out.write("\t\t        for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tif(\"等待导出\" != checkedRawData.status){\r\n");
      out.write("\t\t\t\t\t\talert(\"只能导出等待导出的数据\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttempIdArr.push(id);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录么？\"))) {\r\n");
      out.write("\t\t\t\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\t\t\t\tvar currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar ids = \"'\" + tempIdArr.join(\"','\") + \"'\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t    \tvar fileparames={\r\n");
      out.write("\t    \t\t\t\tids:ids,\r\n");
      out.write("\t    \t\t\t\tuserid:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope[\"login_userid\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t    \t\t\turl:'/leasing/template/createFileByTemplateClass.action',\r\n");
      out.write("\t\t    \t\t\ttitle:\"资金发票计划开票\",\r\n");
      out.write("\t\t    \t\t\tmodelname:'wordtempletypefirst.5',\r\n");
      out.write("\t\t    \t\t\ttwoClassify:'fundchargeconfirmreceipt',\r\n");
      out.write("\t\t    \t\t\treturnType:'file',\r\n");
      out.write("\t\t    \t\t\tfunctionField:\"moneychinese\",\r\n");
      out.write("\t\t    \t\t\t'function':\"convertMoneyToChinese\",\r\n");
      out.write("\t\t    \t\t\tcustoperatorMethod:'forReceiptInfoExportServiceCallback'\r\n");
      out.write("\t\t\t    \t};\r\n");
      out.write("\t\t\t        attachmentDown(fileparames);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t \t},\r\n");
      out.write("\t \t*/\r\n");
      out.write("\t \tcancelButton : {\r\n");
      out.write("\t\t\thtml : '退回',\r\n");
      out.write("\t\t\ticonCls : 'icon-cancel',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t \t\t\tvar operType = \"退回\";\r\n");
      out.write("\t\t\t\tvar operTitle = \"资金实收收据\";\r\n");
      out.write("\t\t\t\tvar operAction = \"updateFundReceiptForReturn\";\r\n");
      out.write("\t \t \t\tvar checkedRowDatas = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tvar currentLoadMask = null;\r\n");
      out.write("\t\t        var params = {};\r\n");
      out.write("\t\t        var tempIdArr = [];\r\n");
      out.write("\t\t        var tempPIdArr = [];\r\n");
      out.write("\t\t \t\tif(0 == checkedRowDatas.length){\r\n");
      out.write("\t    \t\t\talert(\"请选择要\"+operType+\"的记录！！\");\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t\t        for(var i = 0;i<checkedRowDatas.length;i++){\r\n");
      out.write("\t\t\t\t\tvar checkedRowdata = checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tvar id = checkedRowdata.id;\r\n");
      out.write("\t\t\t\t\tvar paymentid=checkedRowdata.paymentid;\r\n");
      out.write("\t\t\t\t\tvar checkedRawData=checkedRowDatas[i];\r\n");
      out.write("\t\t\t\t\tif(\"等待确认\" == checkedRawData.status || \"已导出\" == checkedRawData.status ){\r\n");
      out.write("\t\t\t\t\t\talert(\"等待确认和已导出的数据不允许退回\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttempIdArr.push(id);\r\n");
      out.write("\t\t\t\t\ttempPIdArr.push(paymentid);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams[\"ids\"] = tempIdArr.join(\",\");\r\n");
      out.write("\t\t\t\tparams[\"paymentids\"] = tempPIdArr.join(\",\");\r\n");
      out.write("\t\t\t\tif(!window.confirm((\"确定\"+operType+\"当前\"+checkedRowDatas.length+\"条记录到上一流程么？\"))) {\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tvar loadMaskMsg=\"正在\"+operType+operTitle+\"    请稍后... \";\r\n");
      out.write("\t\t\t\tvar url=getRootPath()+\"/acl/\"+operAction+\".acl\";\r\n");
      out.write("\t\t\t\tcurrentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t\tcurrentLoadMask.show();\r\n");
      out.write("\t\t\t\tajaxRequest({\r\n");
      out.write("\t                url:url,\r\n");
      out.write("\t                params:params,\r\n");
      out.write("\t                timeout:30*1000,\r\n");
      out.write("\t                failure:function(){\r\n");
      out.write("\t                \talert(\"请求提交失败\");\r\n");
      out.write("\t                \tcurrentLoadMask.hide();\r\n");
      out.write("\t                },\r\n");
      out.write("\t                success:function(res){//孙传良 修改  显示出action返回值\r\n");
      out.write("\t        \t   \t\tres=res.responseText;\r\n");
      out.write("\t        \t   \t\tres=res.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t     \t    if(res!=''){\r\n");
      out.write("\t\t\t\t    \t \talert(res);\r\n");
      out.write("\t\t\t     \t    }else{\r\n");
      out.write("\t\t\t     \t    \talert(operType+operTitle+\"成功！！\");\r\n");
      out.write("\t\t\t     \t    }\r\n");
      out.write("\t                    currentLoadMask.hide();\r\n");
      out.write("\t                    table.reload();\r\n");
      out.write("\t                }\r\n");
      out.write("\t            });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tcreateword:{\r\n");
      out.write("     \t    iconCls:'icon-import',\r\n");
      out.write("     \t    html:'生成收据(自动设已导出)',\r\n");
      out.write("     \t    handler:function(table){\r\n");
      out.write("     \t    \tcreateNote(table);\r\n");
      out.write("     \t   }},\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("<!--\r\n");
      if (_jspx_meth_permission_005faction_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_permission_005faction_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_permission_005faction_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var hasSubmitButton = false;//是否有提交按钮\r\n");
      out.write("var hasConfirmButton = false;//是否有确认按钮\r\n");
      out.write("var hasExportButton = false;//是否有导出按钮\r\n");
      out.write("var hasCancelButton = false;//是否有退回按钮\r\n");
      out.write("var hascreateword = false;//是否有生成收据\r\n");
      out.write("var userButtons = [];\r\n");
      out.write("</script >\r\n");
      out.write("\r\n");
      if (_jspx_meth_permission_005faction_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_permission_005faction_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_permission_005faction_005f5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_permission_005faction_005f6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar all_width = (document.documentElement||document.body).clientWidth-2;\r\n");
      out.write("\tvar all_height = (document.documentElement||document.body).clientHeight-2;\r\n");
      out.write("\t\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t   \tvar table = new tracywindyOperationTable({\r\n");
      out.write("\t   \t\t width:all_width,\r\n");
      out.write("\t\t\t height:all_height,\r\n");
      out.write("\t   \t\t tableComment:'[资金发票实收开票]',\r\n");
      out.write("\t   \t\t constantFlagTable:'FundInvoice',\r\n");
      out.write("\t   \t\t windowTop:20,\r\n");
      out.write("\t   \t     border:true,\r\n");
      out.write("\t         renderTo:'id_tableContainer',\r\n");
      out.write("\t         title:'资金发票实收开票',\r\n");
      out.write("\t         id:'id_table',\r\n");
      out.write("\t         xmlFileName:'/eleasing/jsp/invoice_manage/fund_invoice/contract_fund_fund_receipt.xml',\r\n");
      out.write("\t         loadMode:'ajax',\r\n");
      out.write("\t         isPage:true,\r\n");
      out.write("\t         isFit:true,\r\n");
      out.write("\t         isExcel:true,\r\n");
      out.write("\t         operButtons : '',\r\n");
      out.write("\t \t\t tools : userButtons,\r\n");
      out.write("\t         checkType:'checkbox',\r\n");
      out.write("\t         isCheck:true,\r\n");
      out.write("\t         isExcel:true,\r\n");
      out.write("\t \t\t isRank:false,\r\n");
      out.write("\t \t\t params:{\r\n");
      out.write("\t     \t\tenabled:\"1\",\r\n");
      out.write("\t     \t\tuserid:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['login_userid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t     },\r\n");
      out.write("\t         columns:[\r\n");
      out.write("\t            {header:'id',name:'id',hidden: true},\r\n");
      out.write("\t            {header:'合同号',name:'contractid',queryConfig:{}},\r\n");
      out.write("\t            {header:'业务合同号',name:'contractnumber'},\r\n");
      out.write("\t            {header:'经销商',name:'dealername'},\r\n");
      out.write("\t            {header:'客户名称',name:'custname',queryConfig:{}},\r\n");
      out.write("\t            {header:'付款对象',name:'payobj'},\r\n");
      out.write("\t            {header:'费用',name:'dactmoney'},\r\n");
      out.write("\t            {header:'费用类型',name:'feetype'},\r\n");
      out.write("\t            {header:'实收日期',name:'factdate',type:'date',isRange:true,queryConfig:{isNewLine:true}},\r\n");
      out.write("\t            {header:'收据类型',name:'taxlevel'},\r\n");
      out.write("\t            {header:'状态',name:'status',type:'combobox',\r\n");
      out.write("\t            \tqueryConfig:{\r\n");
      out.write("\t\t            \t//isNewLine:false,\r\n");
      out.write("\t\t            \tcolSpan:3, \r\n");
      out.write("\t\t            \tloadMode:'local',\r\n");
      out.write("\t\t            \tdatas:[\r\n");
      out.write("\t\t\t            \t{title:'等待确认',name:'等待确认'},\r\n");
      out.write("\t\t\t            \t{title:'等待提交',name:'等待提交'},\r\n");
      out.write("\t\t\t            \t{title:'等待导出',name:'等待导出'},\r\n");
      out.write("\t\t\t            \t{title:'已导出',name:'已导出'},\r\n");
      out.write("\t\t\t            \t{title:'其他',name:'其他'}\r\n");
      out.write("\t\t            \t],\r\n");
      out.write("\t\t            \tdisplayField:'title',\r\n");
      out.write("\t\t            \tvalueField:'name',\r\n");
      out.write("\t\t            \tdefaultValue:1\r\n");
      out.write("\t            \t}\r\n");
      out.write("\t           \t}]\r\n");
      out.write("\t\t   });\r\n");
      out.write("\t  });\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_permission_005faction_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f0 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f0.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(348,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f0.setCode("submitButton");
    int _jspx_eval_permission_005faction_005f0 = _jspx_th_permission_005faction_005f0.doStartTag();
    if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t<script type=\"text/javascript\">\r\n");
        out.write("\t    userButtons.push(buttons.submitButton);//出纳提交\r\n");
        out.write("\t</script >\r\n");
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
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(353,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f1.setCode("confirmButton");
    int _jspx_eval_permission_005faction_005f1 = _jspx_th_permission_005faction_005f1.doStartTag();
    if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t<script type=\"text/javascript\">\r\n");
        out.write("\t\tuserButtons.push(buttons.confirmButton);//企划确认\r\n");
        out.write("\t</script >\r\n");
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
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(358,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f2.setCode("exportButton");
    int _jspx_eval_permission_005faction_005f2 = _jspx_th_permission_005faction_005f2.doStartTag();
    if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t<script type=\"text/javascript\">\r\n");
        out.write("\t\tuserButtons.push(buttons.exportButton);//审核导出\r\n");
        out.write("\t</script >\r\n");
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

  private boolean _jspx_meth_permission_005faction_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f3 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f3.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(374,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f3.setCode("admin_action");
    int _jspx_eval_permission_005faction_005f3 = _jspx_th_permission_005faction_005f3.doStartTag();
    if (_jspx_eval_permission_005faction_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">//超级系统管理员 提交 确认 导出 退回按钮\r\n");
        out.write("if(false == hasSubmitButton){\r\n");
        out.write("\tuserButtons.push(buttons.submitButton);\r\n");
        out.write("\thasSubmitButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasConfirmButton){\r\n");
        out.write("\tuserButtons.push(buttons.confirmButton);\r\n");
        out.write("\thasConfirmButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasExportButton){\r\n");
        out.write("\tuserButtons.push(buttons.exportButton);\r\n");
        out.write("\thasExportButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasCancelButton){\r\n");
        out.write("\tuserButtons.push(buttons.cancelButton);\r\n");
        out.write("\thasCancelButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hascreateword){\r\n");
        out.write("\tuserButtons.push(buttons.createword);\r\n");
        out.write("\thascreateword = true;\r\n");
        out.write("}\r\n");
        out.write("</script>\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f3);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f4 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f4.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f4.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(399,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f4.setCode("interest_master");
    int _jspx_eval_permission_005faction_005f4 = _jspx_th_permission_005faction_005f4.doStartTag();
    if (_jspx_eval_permission_005faction_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f4.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("//财务部长：查看权限\r\n");
        out.write("</script >\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f4);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f5 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f5.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f5.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(405,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f5.setCode("rent_account");
    int _jspx_eval_permission_005faction_005f5 = _jspx_th_permission_005faction_005f5.doStartTag();
    if (_jspx_eval_permission_005faction_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f5.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">// 提交 确认 导出 退回按钮\r\n");
        out.write("//租赁核算会计\r\n");
        out.write("if(false == hasSubmitButton){\r\n");
        out.write("\tuserButtons.push(buttons.submitButton);\r\n");
        out.write("\thasSubmitButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasConfirmButton){\r\n");
        out.write("\tuserButtons.push(buttons.confirmButton);\r\n");
        out.write("\thasConfirmButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasExportButton){\r\n");
        out.write("\tuserButtons.push(buttons.exportButton);\r\n");
        out.write("\thasExportButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasCancelButton){\r\n");
        out.write("\tuserButtons.push(buttons.cancelButton);\r\n");
        out.write("\thasCancelButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hascreateword){\r\n");
        out.write("\tuserButtons.push(buttons.createword);\r\n");
        out.write("\thascreateword = true;\r\n");
        out.write("}\r\n");
        out.write("</script >\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f5);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f6 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f6.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f6.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/invoice_manage/fund_invoice/contract_fund_fund_receipt.jsp(431,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f6.setCode("fund_account");
    int _jspx_eval_permission_005faction_005f6 = _jspx_th_permission_005faction_005f6.doStartTag();
    if (_jspx_eval_permission_005faction_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f6.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">// 提交 确认 导出 退回按钮\r\n");
        out.write("//资金会计\r\n");
        out.write("if(false == hasSubmitButton){\r\n");
        out.write("\tuserButtons.push(buttons.submitButton);\r\n");
        out.write("\thasSubmitButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasConfirmButton){\r\n");
        out.write("\tuserButtons.push(buttons.confirmButton);\r\n");
        out.write("\thasConfirmButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasExportButton){\r\n");
        out.write("\tuserButtons.push(buttons.exportButton);\r\n");
        out.write("\thasExportButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hasCancelButton){\r\n");
        out.write("\tuserButtons.push(buttons.cancelButton);\r\n");
        out.write("\thasCancelButton = true;\r\n");
        out.write("}\r\n");
        out.write("if(false == hascreateword){\r\n");
        out.write("\tuserButtons.push(buttons.createword);\r\n");
        out.write("\thascreateword = true;\r\n");
        out.write("}\r\n");
        out.write("</script >\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f6);
    return false;
  }
}
