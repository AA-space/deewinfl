package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005fincome;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005fincome_005fplan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script language=\"javascript\">\r\n");
      out.write("    function getCurrentDate(){\r\n");
      out.write("        var cdate=new Date();\r\n");
      out.write("        var month=(parseFloat(cdate.getMonth())+1);\r\n");
      out.write("        var day=cdate.getDate();\r\n");
      out.write("        if(parseFloat(day)<10){day=\"0\"+day;}\r\n");
      out.write("        if(parseFloat(month)<10){month=\"0\"+month;}\r\n");
      out.write("        return cdate.getFullYear()+\"-\"+month+\"-\"+day;\r\n");
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
      out.write("    var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');\r\n");
      out.write("    function setFundFundChargePlan(table){\r\n");
      out.write("    \tloadMask_oper.show();\r\n");
      out.write("    \tvar fund_rent_plans = JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty fund_rent_plans ? \"[]\" : fund_rent_plans }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("\t\tvar fund_rent_plans_rentlist = [];\r\n");
      out.write("    \tfor ( var int = 0; int < fund_rent_plans.length; int++) {\r\n");
      out.write("    \t\tfund_rent_plans_rentlist.push(fund_rent_plans[int].rentlist);\r\n");
      out.write("\t\t}\r\n");
      out.write("    \t\r\n");
      out.write("    \tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("        var ebankdatas=jQuery(\"#fund_ebank_data input[type='text'],#fund_ebank_data textarea\");\r\n");
      out.write("        var ebank=[];\r\n");
      out.write("        var i=0;\r\n");
      out.write("        for(i=0;i<ebankdatas.length;i++){\r\n");
      out.write("           ebank[ebankdatas[i].name]=ebankdatas[i].value;\r\n");
      out.write("        }\r\n");
      out.write("        var allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("        for(var i= 0;i<allItems.length;i++)\r\n");
      out.write("        {\r\n");
      out.write("           if(allItems[i].checked)\r\n");
      out.write("            {\r\n");
      out.write("        \t   allItems[i].checked=false;\r\n");
      out.write("           }\r\n");
      out.write("        } \r\n");
      out.write("        var currentTable1 = getTracywindyObject('table_id_current_fund_income_detial_container');\r\n");
      out.write("        var talbedata=currentTable1.getRowsData();\r\n");
      out.write("        var iddata=getTableColumnData(talbedata,\"id\");\r\n");
      out.write("        var isAddPlanData=\"\";\r\n");
      out.write("        var curdate=getCurrentDate();\r\n");
      out.write("        for(i=0;i<plandata.length;i++){\r\n");
      out.write("        \t/* if(plandata[i].rentlist != fund_rent_plans_rentlist[0]){\r\n");
      out.write("       \t\t    loadMask_oper.hide();\r\n");
      out.write("           \t    jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>因租金必须按顺序回笼, 第\"+plandata[i].rentlist+\"期及以下租金未被选择</div>\",'error'); \r\n");
      out.write("           \t    return false;\r\n");
      out.write("        \t} */\r\n");
      out.write("        \tfund_rent_plans_rentlist.shift();\r\n");
      out.write("        \t\r\n");
      out.write("          if(parseFloat(plandata[i].currentoverage)>0 || parseFloat(plandata[i].penaltyoverage)>0 ){\r\n");
      out.write("               var fund={};\r\n");
      out.write("               if(checkIdIsAdd(plandata[i].id,iddata)){\r\n");
      out.write("                   if(isAddPlanData==\"\"){isAddPlanData=plandata[i].rentlist;}else{isAddPlanData=isAddPlanData+\",\"+plandata[i].rentlist;}\r\n");
      out.write("               }else{   \r\n");
      out.write("               fund.id=plandata[i].id;\r\n");
      out.write("               fund.planid=plandata[i].id;\r\n");
      out.write("               fund.planlist=plandata[i].rentlist;\r\n");
      out.write("               fund.ebanknumber=ebank[\"fund_ebank_data.ebdataid\"];\r\n");
      out.write("               fund.balancemode=\"PayFund6\";\r\n");
      out.write("               fund.rawValue_balancemode=\"电汇\";\r\n");
      out.write("               //fund.hirelist=parseFloat(plandata[i].hirelist)+1;\r\n");
      out.write("               fund.hirelist=plandata[i].rentlist;\r\n");
      out.write("               fund.hiredate=ebank[\"fund_ebank_data.factdate\"];\r\n");
      out.write("               fund.rent=plandata[i].currentoverage;\r\n");
      out.write("               fund.corpus=plandata[i].curcorpusoverage;\r\n");
      out.write("               fund.interest=plandata[i].curinterestoverage;\r\n");
      out.write("               fund.penalty=plandata[i].penaltyoverage;\r\n");
      out.write("               fund.interestadjust=0.00;\r\n");
      out.write("               fund.penaltyadjust=0.00;\r\n");
      out.write("               temp=parseFloat(plandata[i].currentoverage)+parseFloat(plandata[i].penaltyoverage);\r\n");
      out.write("               fund.receivermoney=temp.toFixed(2);\r\n");
      out.write("               fund.accountingdate=curdate;\r\n");
      out.write("               fund.oper=\"add\";         \r\n");
      out.write("               fund.ownbank=ebank[\"fund_ebank_data.ownbank\"];\r\n");
      out.write("               fund.ownaccount=ebank[\"fund_ebank_data.ownaccount\"];\r\n");
      out.write("               fund.accnumber=ebank[\"fund_ebank_data.ownaccnumber\"];\r\n");
      out.write("               fund.hireobject=ebank[\"fund_ebank_data.clientname\"];\r\n");
      out.write("               fund.hirebank=ebank[\"fund_ebank_data.clientbank\"];\r\n");
      out.write("               fund.clientaccount=ebank[\"fund_ebank_data.clientaccount\"];\r\n");
      out.write("               fund.hirenumber=ebank[\"fund_ebank_data.clientaccnumber\"];\r\n");
      out.write("               fund.invoiceno=\"\";\r\n");
      out.write("               currentTable1.AddRow(fund);\r\n");
      out.write("               }\r\n");
      out.write("          }else{\r\n");
      out.write("        \t  loadMask_oper.hide();\r\n");
      out.write("        \t  jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>第\"+plandata[i].rentlist+\"期已经回笼</div>\",'error'); \r\n");
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
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\tvar currentIsNeedTools = false;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    var table_proj_fund_rent_plan= new tracywindyMultiTable({\r\n");
      out.write("\t\t    renderTo:'id_fund_income_plans_container',\r\n");
      out.write("\t\t    width:formWidth,\r\n");
      out.write("\t\t    height:350,\r\n");
      out.write("\t\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t\t    isFit:true,\r\n");
      out.write("\t\t    otherTools : [ {\r\n");
      out.write("\t\t\t\thtml : '<font color=\"red\">生成租金核销</font>',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tvar fundPlan = table_proj_fund_rent_plan.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t\t\t\t\t\talert(\"请选择需要核销的租金计划!\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}        \r\n");
      out.write("\t\t\t\t\tsetFundFundChargePlan(table_proj_fund_rent_plan);\r\n");
      out.write("\t\t\t\t},    \r\n");
      out.write("\t\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t  datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty fund_rent_plans ? \"[]\" : fund_rent_plans }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t\t    columns:[\r\n");
      out.write("\t\t           {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t  \t       {name:'rentlist',  header:'期次'},\r\n");
      out.write("\t\t  \t       {name:'planstatus',  header:'回笼状态'},\r\n");
      out.write("\t\t  \t       {name:'hirelist',header:'已操作的期次',hidden:true},\r\n");
      out.write("\t\t  \t       {name:'plandate', header:'计划日期'},\r\n");
      out.write("\t\t  \t       {name:'rent', header:'计划租金' ,nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'corpus', header:'计划本金', nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'interest',  header:'计划租息', nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'penalty',  header:'应收罚息' , nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'currentoverage',  header:'租金余额' , nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'curcorpusoverage',  header:'本金余额' , nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'curinterestoverage',  header:'利息余额' , nullable:false,type:'double'},\r\n");
      out.write("\t\t  \t       {name:'penaltyoverage',  header:'罚息余额', nullable:false,type:'double'}\r\n");
      out.write("\t\t     ] \r\n");
      out.write("\t\t });\r\n");
      out.write("\t    \r\n");
      out.write("});\r\n");
      out.write("\t</script>");
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
