package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005fincome;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005fincome_005fhistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script>\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\t function setFundFundChargePlanReback(table){\r\n");
      out.write("\t\t    \t//loadMask_oper.show();\r\n");
      out.write("\t\t    \tvar plandata =table.getCheckedRowDatas();\r\n");
      out.write("\t\t        var allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("\t\t        var currentTabled =getTracywindyObject('table_id_current_fund_income_detial_container');\r\n");
      out.write("\t\t        var talbedata=currentTabled.getRowsData();\r\n");
      out.write("\t\t        var iddata=getTableColumnData(talbedata,\"id\");\r\n");
      out.write("\t\t        var isAddPlanData=\"\";\r\n");
      out.write("\t\t        var reBackData=[];\r\n");
      out.write("\t\t        for(var i=0;i<plandata.length;i++){\r\n");
      out.write("\t\t        \tif(plandata[i]['rollback'] == '1'){\r\n");
      out.write("\t\t        \t\tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>红冲数据不能再次红冲</div>\",'error'); \r\n");
      out.write("\t\t        \t\t//loadMask_oper.hide();\r\n");
      out.write("\t\t        \t\tif(allItems[i].checked)\r\n");
      out.write("\t\t                {\r\n");
      out.write("\t\t            \t   allItems[i].checked=false;\r\n");
      out.write("\t\t               }\r\n");
      out.write("\t\t        \t\treturn;\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \tif(checkIdIsAdd(plandata[i].id,iddata)){\r\n");
      out.write("\t\t                if(isAddPlanData==\"\"){isAddPlanData=plandata[i].planlist;}else{isAddPlanData=isAddPlanData+\",\"+plandata[i].planlist;}\r\n");
      out.write("\t\t            }else{\r\n");
      out.write("\t\t            \t var _temPlandata =  jQuery.extend({},plandata[i]);\r\n");
      out.write("\t\t            \t _temPlandata.rent=parseFloat(plandata[i].rent)*(-1);\r\n");
      out.write("\t\t            \t _temPlandata.corpus=parseFloat(plandata[i].corpus)*(-1);\r\n");
      out.write("\t\t            \t _temPlandata.interest=parseFloat(plandata[i].interest)*(-1);\r\n");
      out.write("\t\t            \t _temPlandata.penalty=parseFloat(plandata[i].penalty)*(-1);\r\n");
      out.write("\t\t            \t _temPlandata.interestadjust=parseFloat(plandata[i].interestadjust)*(-1);\r\n");
      out.write("\t\t            \t _temPlandata.penaltyadjust=parseFloat(plandata[i].penaltyadjust)*(-1);\r\n");
      out.write("\t\t            \t _temPlandata.rollback=1;\r\n");
      out.write("\t\t            \t _temPlandata.pid=plandata[i]['id'];\r\n");
      out.write("\t\t            \t _temPlandata.balancemode=\"PayFund9\";\r\n");
      out.write("\t\t            \t _temPlandata.rawValue_balancemode=\"红冲\";\r\n");
      out.write("\t\t            \t temp=(parseFloat(plandata[i].rent)+parseFloat(plandata[i].penalty)+parseFloat(plandata[i].penaltyadjust));\r\n");
      out.write("\t\t            \t _temPlandata.receivermoney=temp.toFixed(2);\r\n");
      out.write("\t\t            \t _temPlandata.oper=\"old\";\r\n");
      out.write("\t\t                 reBackData.push(_temPlandata);\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t        currentTabled.AddRows(reBackData);\r\n");
      out.write("\t\t        for(var i= 0;i<allItems.length;i++)\r\n");
      out.write("\t\t        {\r\n");
      out.write("\t\t           if(allItems[i].checked)\r\n");
      out.write("\t\t            {\r\n");
      out.write("\t\t        \t   allItems[i].checked=false;\r\n");
      out.write("\t\t           }\r\n");
      out.write("\t\t        } \r\n");
      out.write("\t\t        //loadMask_oper.hide();\r\n");
      out.write("\t\t        if(isAddPlanData==\"\"){\r\n");
      out.write("\t\t           jQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功</div>\",'success'); \r\n");
      out.write("\t\t        }else{\r\n");
      out.write("\t\t        \tjQuery.messager.alert('提示',\"<div style='font-size:18px;line-height:30px;'>操作成功其中\"+isAddPlanData+\"已经加到实收计划中不能重复添加</div>\",'success'); \r\n");
      out.write("\t\t         }\r\n");
      out.write("\t\t       }\r\n");
      out.write("    var currentIsNeedTools = false;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\tvar table_fund_rent_inComes= new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_fund_income_history_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:false,\r\n");
      out.write("\t    otherTools : [ {\r\n");
      out.write("\t\t\thtml : '<font color=\"red\">生成租金红冲</font>',\r\n");
      out.write("\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\tvar fundPlan = table_fund_rent_inComes.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t\t\t\t\talert(\"请选择租金计划!\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tsetFundFundChargePlanReback(table_fund_rent_inComes)\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty fund_income_history ? \"[]\" : fund_income_history }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    isRank:true,\r\n");
      out.write("\t    rankSize:60,\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t           {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t  \t       {name:'planid',header:'租金计划',hidden:true},\r\n");
      out.write("\t  \t       {name:'planlist',  header:'计划期项'},\r\n");
      out.write("\t  \t       {name:'ebanknumber',  header:'网银编号'},\r\n");
      out.write("\t  \t       {name:'hirelist',  header:'回笼期项'},\r\n");
      out.write("\t  \t     {name:'balancemode',  header:'balancemode',hidden:true},\r\n");
      out.write("\t\t       {name:'rawValue_balancemode',  header:'结算方式',nullable:false,type:'combobox',hiddenName:'balancemode',\r\n");
      out.write("\t\t    \t   config:{\r\n");
      out.write("\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t       params:{\r\n");
      out.write("\t\t\t\t          pid:'PayFund'\r\n");
      out.write("\t\t\t\t       } \r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t       },\r\n");
      out.write("\t  \t       {name:'hiredate',  header:'回笼日期'},\r\n");
      out.write("\t  \t       {name:'rent',  header:'回笼租金' , nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'corpus',  header:'回笼本金' , nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'interest',  header:'回笼租息', nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'penalty',  header:'回笼罚息' , nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'interestadjust',  header:'租息调整', nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'penaltyadjust',  header:'罚息调整', nullable:false,type:'double'},\r\n");
      out.write("\t  \t       {name:'invoiceno',  header:'单据号'},\r\n");
      out.write("\t  \t       {name:'accountingdate',  header:'会计处理日'},\r\n");
      out.write("\t  \t       {name:'ownbank',  header:'本方银行'},\r\n");
      out.write("\t  \t       {name:'ownaccount',  header:'本方银行账户'},\r\n");
      out.write("\t  \t       {name:'hireobject',  header:'付款人'},\r\n");
      out.write("\t  \t       {name:'hirebank',  header:'付款人银行'},\r\n");
      out.write("\t  \t       {name:'hirenumber',  header:'付款人帐号'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
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
