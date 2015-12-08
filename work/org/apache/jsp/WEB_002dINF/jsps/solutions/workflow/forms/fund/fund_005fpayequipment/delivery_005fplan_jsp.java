package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fpayequipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class delivery_005fplan_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    function getCurrentDate(){\r\n");
      out.write("        var cdate=new Date();\r\n");
      out.write("        return cdate.getFullYear()+\"-\"+(parseFloat(cdate.getMonth())+1)+\"-\"+cdate.getDate();\r\n");
      out.write("    }\r\n");
      out.write("    function checkIdIsAdd(id,ids){\r\n");
      out.write("        if(ids.length>0){\r\n");
      out.write("        for(var i=0;i<ids.length;i++){\r\n");
      out.write("         if(id==ids[i]){return true;}\r\n");
      out.write("        }\r\n");
      out.write("        return false;\r\n");
      out.write("        }else{return false;}\r\n");
      out.write("    }\r\n");
      out.write("    function getTableColumnData(tabledatas,column){\r\n");
      out.write("        var cdata=[];\r\n");
      out.write("        if(tabledatas.length>0){\r\n");
      out.write("            for(var i=0;i<tabledatas.length;i++){\r\n");
      out.write("                var ctable=tabledatas[i];\r\n");
      out.write("                cdata[i]=ctable[column];\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        return cdata;\r\n");
      out.write("    }\r\n");
      out.write("    var loadMask_oper ;//= new tracywindyLoadMask(document.body,'操作进行中，请稍等...');\r\n");
      out.write("    function setFundFundChargePlan(table){\r\n");
      out.write("\r\n");
      out.write("    \t//获取合同额度\r\n");
      out.write("    \tvar currentTablelimit = getTracywindyObject('table_id_table_leasing_contract_limit_list');\r\n");
      out.write("\t\tvar tabledatalimit=currentTablelimit.getRowsData();\r\n");
      out.write("\t\t\tvar sumMoney=0;\r\n");
      out.write("\t\t\tfor(var j=0;j<tabledatalimit.length;j++)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t       sumMoney=sumMoney+parseFloat(tabledatalimit[j].limitmoney);\r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t \t//alert(sumMoney);\r\n");
      out.write("        \r\n");
      out.write("    \tvar firstpayment = JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${firstpayment}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("    \t//console.info(firstpayment);\r\n");
      out.write("    \tif(loadMask_oper==null){\r\n");
      out.write("    \t\tloadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');\r\n");
      out.write("    \t}\r\n");
      out.write("    \tloadMask_oper.show();\r\n");
      out.write("    \tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("        var allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("        for(var i= 0;i<allItems.length;i++)\r\n");
      out.write("        {\r\n");
      out.write("           if(allItems[i].checked)\r\n");
      out.write("            {\r\n");
      out.write("        \t   allItems[i].checked=false;\r\n");
      out.write("           }\r\n");
      out.write("        } \r\n");
      out.write("        var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');\r\n");
      out.write("       var planTable = getTracywindyObject('table_id_table_leasing_delivery_plan');\r\n");
      out.write("        //计算合计计划投放金额\r\n");
      out.write("        var datas = planTable.tableData;\r\n");
      out.write("        var totalPlanMoney = 0;\r\n");
      out.write("        for ( var int = 0; int < datas.length; int++) {\r\n");
      out.write("        \ttotalPlanMoney += parseFloat(datas[int].planmoney);\r\n");
      out.write("\t\t}\r\n");
      out.write("        var talbedata=currentTable1.getRowsData();\r\n");
      out.write("        var iddata=getTableColumnData(talbedata,\"id\");\r\n");
      out.write("        var isAddPlanData=\"\";\r\n");
      out.write("        var curdate=getCurrentDate();\r\n");
      out.write("        for(i=0;i<plandata.length;i++){\r\n");
      out.write("          if(parseFloat(plandata[i].planmoney)>parseFloat(plandata[i].receivermoney)){\r\n");
      out.write("               var fund={};\r\n");
      out.write("               if(checkIdIsAdd(plandata[i].id,iddata)){\r\n");
      out.write("                   if(isAddPlanData==\"\"){isAddPlanData=plandata[i].paymentid;}else{isAddPlanData=isAddPlanData+\",\"+plandata[i].paymentid;}\r\n");
      out.write("               }else{\r\n");
      out.write("               fund.id=plandata[i].id;\r\n");
      out.write("               fund.fundfundchargeplan=plandata[i].paymentid;\r\n");
      out.write("               //fund.ebanknumber=ebank[\"fund_ebank_data.ebdataid\"];\r\n");
      out.write("               fund.feetype='feetype10';\r\n");
      out.write("               fund.rawValue_feetype = '设备款';\r\n");
      out.write("               //付款时间由最后一步出纳填写\r\n");
      out.write("               //fund.factdate=plandata[i].plandate;\r\n");
      out.write("              var temp=parseFloat(plandata[i].planbalance);\r\n");
      out.write("               //fund.factmoney=temp.toFixed(2);\r\n");
      out.write("               fund.feeadjust=0.00;\r\n");
      out.write("               fund.receivermoney=temp.toFixed(2);\r\n");
      out.write("               fund.factobject=plandata[i].payobj;\r\n");
      out.write("               fund.oper=\"add\";\r\n");
      out.write("               fund.settlemethod=\"PayFund6\";\r\n");
      out.write("               fund.rawValue_settlemethod=\"电汇\";\r\n");
      out.write("               //fund.accountbank=ebank[\"fund_ebank_data.ownbank\"];\r\n");
      out.write("               //fund.account=ebank[\"fund_ebank_data.ownaccount\"];\r\n");
      out.write("               //fund.accnumber=ebank[\"fund_ebank_data.ownaccnumber\"];\r\n");
      out.write("               //fund.factobject=ebank[\"fund_ebank_data.clientname\"];\r\n");
      out.write("               //fund.clientbank=ebank[\"fund_ebank_data.clientbank\"];\r\n");
      out.write("               //fund.clientaccount=ebank[\"fund_ebank_data.clientaccount\"];\r\n");
      out.write("               //fund.clientaccnumber=ebank[\"fund_ebank_data.clientaccnumber\"];\r\n");
      out.write("               fund.fundfundchargeplan=plandata[i].id;;\r\n");
      out.write("               fund.accountingdate=curdate;\r\n");
      out.write("               fund.paytype='pay_type_out';\r\n");
      out.write("               fund.accountingdate=curdate;\r\n");
      out.write("               fund.invoiceno=\"\";\r\n");
      out.write("               fund.ffcmemo=plandata[i].fpnote;\r\n");
      out.write("               fund.contractid=plandata[i].contractid;\r\n");
      out.write("               fund.contractnumber=plandata[i].contractnumber;\r\n");
      out.write("               fund.equipmoney=plandata[i].planmoney;\r\n");
      out.write("               fund.equipcount='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${equipcount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("               fund.paymentid=plandata[i].paymentid;\r\n");
      out.write("               fund.factmoney=parseFloat(plandata[i].planmoney)-parseFloat(sumMoney);\r\n");
      out.write("               //fund.factmoney= totalPlanMoney;\r\n");
      out.write("               fund.clientbank='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dealer_bankName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("               fund.clientaccount='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dealer_account}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("               fund.clientaccnumber='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dealer_accNumber}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("               fund.planfirstpayment = firstpayment['datas'][0]['plan_money'];\r\n");
      out.write("               fund.factfirstmoney = firstpayment['datas'][0]['plan_first_fact_money'];\r\n");
      out.write("               fund.custname= $('input[name=\"contract_info.custname\"]').val();\r\n");
      out.write("               if(talbedata.length==0)\r\n");
      out.write("               {\r\n");
      out.write("                     fund.creditmoney=sumMoney;\r\n");
      out.write("                }else{\r\n");
      out.write("                \tfund.creditmoney=0;\r\n");
      out.write("                }\r\n");
      out.write("                       \r\n");
      out.write("               currentTable1.AddRow(fund);\r\n");
      out.write("               }\r\n");
      out.write("          }else{\r\n");
      out.write("        \t  loadMask_oper.hide();\r\n");
      out.write("        \t  jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>编辑号\"+plandata[i].paymentid+\"已经回笼</div>\",'error'); \r\n");
      out.write("        \t  return false;\r\n");
      out.write("           }\r\n");
      out.write("          \r\n");
      out.write("        }\r\n");
      out.write("        loadMask_oper.hide();\r\n");
      out.write("        if(isAddPlanData==\"\"){\r\n");
      out.write("            jQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功</div>\",'success'); \r\n");
      out.write("        }else{\r\n");
      out.write("        \tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功其中\"+isAddPlanData+\"已经加到实收计划中不能重复添加</div>\",'success'); \r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("        if(isSubTable){\r\n");
      out.write("    \tvar currentIsNeedTools = false;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    var talbe= new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_delivery_plan',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    otherTools : [ {\r\n");
      out.write("\t\t\thtml : '<font color=\"red\">生成资金投放</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tvar fundPlan = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t         \t\talert(\"请选择需要资金计划!\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tsetFundFundChargePlan(talbe)\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_leasing_delivery_plan_str ? \"[]\" : json_leasing_delivery_plan_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t           {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t  \t       {name:'paymentid',  header:'投放编号',nullable:false,readOnly:false},\r\n");
      out.write("\t  \t       {name:'contractid',  header:'contractid',hidden:true},\r\n");
      out.write("\t  \t       {name:'contractnumber',  header:'contractnumber',hidden:true},\r\n");
      out.write("\t  \t       {name:'planmoney',  header:'计划金额',nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'plandate',  header:'计划投放日期',nullable:false},\r\n");
      out.write("\t  \t       {name:'receivermoney',  header:'已投放金额',nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'adjustmoney',  header:'调整金额',nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'planbalance',  header:'可投放金额',nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'payobj',  header:'付款对象'},\r\n");
      out.write("\t  \t       {name:'planmoneystatus',  header:'planmoneystatusid', hidden:true},\r\n");
      out.write("\t  \t       {name:'rawValue_planmoneystatus',  header:'投放状态'},\r\n");
      out.write("\t  \t       {name:'fpnote', header:'备注',type:'textarea'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t\t });\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \t$('#table_id_table_leasing_delivery_plan_toolsDiv').parent().hide();\r\n");
      out.write("\t    }\r\n");
      out.write("      }\r\n");
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
