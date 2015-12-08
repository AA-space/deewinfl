package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fcollection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005freceiverchargehistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("   \r\n");
      out.write("    <script>\r\n");
      out.write("    function setFundFundChargePlanReback(table){\r\n");
      out.write("    \t//loadMask_oper.show();\r\n");
      out.write("    \tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("        var allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("        var currentTabled =getTracywindyObject('table_id_table_receivercharge_container');\r\n");
      out.write("        var talbedata=currentTabled.getRowsData();\r\n");
      out.write("        var iddata=getTableColumnData(talbedata,\"id\");\r\n");
      out.write("        var isAddPlanData=\"\";\r\n");
      out.write("        var reBackData=[];\r\n");
      out.write("        for(var i=0;i<plandata.length;i++){\r\n");
      out.write("        \tif(plandata[i]['rollback'] == '1'){\r\n");
      out.write("        \t\tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>红冲数据不能再次红冲</div>\",'error'); \r\n");
      out.write("        \t\t//loadMask_oper.hide();\r\n");
      out.write("        \t\tif(allItems[i].checked)\r\n");
      out.write("                {\r\n");
      out.write("            \t   allItems[i].checked=false;\r\n");
      out.write("               }\r\n");
      out.write("        \t\treturn;\r\n");
      out.write("        \t}\r\n");
      out.write("        \t\r\n");
      out.write("        \tif(checkIdIsAdd(plandata[i].id,iddata)){\r\n");
      out.write("                if(isAddPlanData==\"\"){isAddPlanData=plandata[i].fundfundchargeplan;}else{isAddPlanData=isAddPlanData+\",\"+plandata[i].fundfundchargeplan;}\r\n");
      out.write("            }else{\r\n");
      out.write("            \t var _temPlandata =  jQuery.extend({},plandata[i]);\r\n");
      out.write("            \t _temPlandata.factmoney=parseFloat(plandata[i].factmoney)*(-1);\r\n");
      out.write("            \t _temPlandata.feeadjust=parseFloat(plandata[i].feeadjust)*(-1);\r\n");
      out.write("            \t _temPlandata.paymentid=plandata[i]['fundfundchargeplan.paymentId'];\r\n");
      out.write("            \t _temPlandata.rollback=1;\r\n");
      out.write("            \t _temPlandata.pid=plandata[i]['id'];\r\n");
      out.write("            \t _temPlandata.settlemethod=\"PayFund9\";\r\n");
      out.write("            \t _temPlandata.rawValue_settlemethod=\"红冲\";\r\n");
      out.write("                 var temp=parseFloat(plandata[i].factmoney)+parseFloat(plandata[i].feeadjust);\r\n");
      out.write("                 _temPlandata.receivermoney=temp.toFixed(2);\r\n");
      out.write("                 _temPlandata.oper=\"old\";\r\n");
      out.write("                 reBackData.push(_temPlandata);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        currentTabled.AddRows(reBackData);\r\n");
      out.write("        for(var i= 0;i<allItems.length;i++)\r\n");
      out.write("        {\r\n");
      out.write("           if(allItems[i].checked)\r\n");
      out.write("            {\r\n");
      out.write("        \t   allItems[i].checked=false;\r\n");
      out.write("           }\r\n");
      out.write("        } \r\n");
      out.write("        //loadMask_oper.hide();\r\n");
      out.write("        if(isAddPlanData==\"\"){\r\n");
      out.write("           jQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功</div>\",'success'); \r\n");
      out.write("        }else{\r\n");
      out.write("        \tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功其中\"+isAddPlanData+\"已经加到实收计划中不能重复添加</div>\",'success'); \r\n");
      out.write("         }\r\n");
      out.write("       }\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("\t    var currentIsNeedTools = false;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t var fund= new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_receiverchargehistory_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    tools:\"新增|修改\",\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    otherTools : [ {\r\n");
      out.write("\t\t\thtml : '<font color=\"red\">生成资金红冲</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tvar fundPlan = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t\t\t\t\talert(\"请选择需要资金计划!\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tsetFundFundChargePlanReback(fund);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t    isFit:false,\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_receiverchargehistory_str ? \"[]\" : json_receiverchargehistory_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t             {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},\r\n");
      out.write("\t\t\t       {name:'fundfundchargeplan.paymentId',  header:'收款编号',nullable:false,readOnly:false},\r\n");
      out.write("\t\t\t       {name:'ebanknumber',  header:'网银编号'},\r\n");
      out.write("\t\t\t       {name:'feetype',  header:'费用类型',hidden:true},\r\n");
      out.write("\t\t\t \t     {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype',\r\n");
      out.write("\t\t\t    \t   config:{\r\n");
      out.write("\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t\t       params:{\r\n");
      out.write("\t\t\t\t\t          pid:'FeeType'\r\n");
      out.write("\t\t\t\t\t       } \r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       {name:'settlemethod',  header:'settlemethodId',hidden :true},\r\n");
      out.write("\t\t\t \t     {name:'rawValue_settlemethod',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'settlemethod',\r\n");
      out.write("\t\t\t    \t   config:{\r\n");
      out.write("\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t\t       params:{\r\n");
      out.write("\t\t\t\t\t          pid:'PayFund'\r\n");
      out.write("\t\t\t\t\t       } \r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t\t\t       {name:'factdate',  header:'到账时间',nullable:false},\r\n");
      out.write("\t\t\t       {name:'factmoney',  header:'金额',nullable:false,type:'double'},\r\n");
      out.write("\t\t\t       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},\r\n");
      out.write("\t\t\t       {name:'accountbank',  header:'银行'},\r\n");
      out.write("\t\t\t       {name:'account',  header:'银行账户'},\r\n");
      out.write("\t\t\t       {name:'accnumber',  header:'银行账号'},\r\n");
      out.write("\t\t\t       {name:'factobject',  header:'付款客户'},\r\n");
      out.write("\t\t\t       {name:'clientbank',  header:'客户银行'},\r\n");
      out.write("\t\t\t       {name:'clientaccount',  header:'客户账户'},\r\n");
      out.write("\t\t\t       {name:'clientaccnumber',  header:'客户帐号'},\r\n");
      out.write("\t\t\t       {name:'accountingdate',  header:'会计处理日'},\r\n");
      out.write("\t\t\t       {name:'invoiceno',  header:'单据号'},\r\n");
      out.write("\t\t\t       {name:'ffcmemo', header:'备注',type:'textarea'},\r\n");
      out.write("\t\t\t       {name:'creator',  header:'输入人'},\r\n");
      out.write("\t\t\t       {name:'createdate',  header:'输入日期'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("   });\r\n");
      out.write("\r\n");
      out.write("   </script>");
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
