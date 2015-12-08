package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005fpayment_005fhistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script> \r\n");
      out.write("\r\n");
      out.write("function setFundFundChargePlanReback(table){\r\n");
      out.write("\t//loadMask_oper.show();\r\n");
      out.write("\tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("    var allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("    var currentTabled = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');\r\n");
      out.write("    var talbedata=currentTabled.getRowsData();\r\n");
      out.write("    var iddata=getTableColumnData(talbedata,\"id\");\r\n");
      out.write("    var plantable=getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');\r\n");
      out.write("    var plantabledate=plantable.getRowsData();\r\n");
      out.write("    var isAddPlanData=\"\";\r\n");
      out.write("    var reBackData=[];\r\n");
      out.write("    for(var i=0;i<plandata.length;i++){\r\n");
      out.write("        \r\n");
      out.write("        if(plandata[i].rollback==\"1\"){\r\n");
      out.write("        \t//loadMask_oper.hide();\r\n");
      out.write("        \tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>已经红冲的付款计划不能红冲</div>\",'success'); \r\n");
      out.write("          return false;\r\n");
      out.write("        }\r\n");
      out.write("    \tif(checkIdIsAdd(plandata[i].id,iddata)){\r\n");
      out.write("            if(isAddPlanData==\"\"){isAddPlanData=plandata[i].fundfundchargeplan;}else{isAddPlanData=isAddPlanData+\",\"+plandata[i].fundfundchargeplan;}\r\n");
      out.write("        }else{\r\n");
      out.write("        \t tdate=util.clone(plandata[i]);\r\n");
      out.write("             var paymentid=tdate.fundfundchargeplan;\r\n");
      out.write("             var id=\"\";\r\n");
      out.write("             for(var j=0;j<plantabledate.length;j++){\r\n");
      out.write("                if(plantabledate[j].paymentid==paymentid){\r\n");
      out.write("                    id=plantabledate[j].id;\r\n");
      out.write("                 }\r\n");
      out.write("              }\r\n");
      out.write("             \r\n");
      out.write("             tdate.pid=plandata[i]['id'];\r\n");
      out.write("             tdate.paymentid = plandata[i]['fundfundchargeplan.paymentId'];\r\n");
      out.write("             tdate.rollback = 1;\r\n");
      out.write("             tdate.custname= $('input[name=\"contract_info.custname\"]').val();\r\n");
      out.write("             tdate.PID=plandata[i].id;\r\n");
      out.write("             tdate.fundfundchargeplan= plandata[i].fundfundchargeplan;\r\n");
      out.write("             tdate.paymentid=plandata[i]['fundfundchargeplan.paymentId'];\r\n");
      out.write("             tdate.factmoney=parseFloat(tdate.factmoney)*(-1);\r\n");
      out.write("             tdate.feeadjust=parseFloat(tdate.feeadjust)*(-1);\r\n");
      out.write("             var temp=parseFloat(tdate.factmoney)+parseFloat(tdate.feeadjust);\r\n");
      out.write("             tdate.settlemethod=\"PayFund9\";\r\n");
      out.write("             tdate.rawValue_settlemethod=\"红冲\";\r\n");
      out.write("             tdate.receivermoney=temp.toFixed(2);\r\n");
      out.write("             tdate.oper=\"old\";\r\n");
      out.write("             reBackData.push(tdate);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    currentTabled.AddRows(reBackData);\r\n");
      out.write("    for(var i= 0;i<allItems.length;i++)\r\n");
      out.write("    {\r\n");
      out.write("       if(allItems[i].checked)\r\n");
      out.write("        {\r\n");
      out.write("    \t   allItems[i].checked=false;\r\n");
      out.write("       }\r\n");
      out.write("    } \r\n");
      out.write("    //loadMask_oper.hide();\r\n");
      out.write("    if(isAddPlanData==\"\"){\r\n");
      out.write("       jQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功</div>\",'success'); \r\n");
      out.write("    }else{\r\n");
      out.write("    \tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功其中\"+isAddPlanData+\"已经加到实付计划中不能重复添加</div>\",'success'); \r\n");
      out.write("     }\r\n");
      out.write("   }\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tif(isSubTable){\r\n");
      out.write("\t    var currentIsNeedTools = false;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    \t$('#table_id_table_leasing_contract_fund_payment_history_container_toolsDiv').hide();\r\n");
      out.write("\t    }\r\n");
      out.write("\t   var fundp=   new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_contract_fund_payment_history_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    tools:'新增|修改|删除',\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    otherTools : [ {\r\n");
      out.write("\t\t\thtml : '<font color=\"red\">生成资金红冲</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tvar fundPlan = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t\t\t\t\talert(\"请选择需要资金计划!\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tsetFundFundChargePlanReback(fundp);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t    isFit:false,\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_contract_fund_payment_history_str ? \"[]\" : json_contract_fund_payment_history_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},\r\n");
      out.write("\t       {name:'fundfundchargeplan.paymentId',  header:'付款编号',nullable:false},\r\n");
      out.write("\t       {name:'feetype',  header:'feetypeId',hidden:true},\r\n");
      out.write("\t       {name:'rollback',header:'红冲',hidden:true,type:\"text\",renderer:function(val){if(val==\"1\"){return \"是\"}else{return \"否\"}}},\r\n");
      out.write("  \t       {name:'rawValue_feetype',  header:'费用类型',nullable:false},\r\n");
      out.write("  \t       {name:'factmoney',  header:'金额',nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},\r\n");
      out.write("\t       {name:'settlemethod',  header:'结算方式id',hidden:true},\r\n");
      out.write("\t       {name:'rawValue_settlemethod',  header:'结算方式',nullable:false,readOnly:true},\r\n");
      out.write("\t       {name:'factdate',  header:'支付时间',nullable:false},\r\n");
      out.write("\t       {name:'accountbank',  header:'银行',nullable:false},\r\n");
      out.write("\t       {name:'account',  header:'银行账户',nullable:false},\r\n");
      out.write("\t       {name:'accnumber',  header:'银行账号',nullable:false},\r\n");
      out.write("\t       {name:'factobject',  header:'收款客户',nullable:false},\r\n");
      out.write("\t       {name:'clientbank',  header:'客户银行',nullable:false},\r\n");
      out.write("\t       {name:'clientaccount',  header:'客户账户',nullable:false},\r\n");
      out.write("\t       {name:'clientaccnumber',  header:'客户账号',nullable:false},\r\n");
      out.write("\t       {name:'accountingdate',  header:'会计处理日',nullable:false},\r\n");
      out.write("\t       {name:'invoiceno',  header:'单据号',nullable:false},\r\n");
      out.write("\t       {name:'ffcmemo', header:'备注',type:'textarea'},\r\n");
      out.write("\t       {name:'creator',  header:'输入人',nullable:false},\r\n");
      out.write("\t       {name:'createdate',  header:'输入日期',nullable:false,readOnly:false,type:'date'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t   });\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \t$('#table_id_table_leasing_contract_fund_payment_history_container_toolsDiv').parent().hide();\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
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
