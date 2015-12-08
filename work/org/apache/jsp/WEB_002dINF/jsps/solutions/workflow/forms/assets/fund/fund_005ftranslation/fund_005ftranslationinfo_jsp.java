package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005ftranslation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005ftranslationinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction checkOnePlanList(rentplan){\r\n");
      out.write("\t      //corpusov,interestov,penaltyov,corpus,interest,penalty,interestadjust,penaltyadjust\r\n");
      out.write("\t\t  var cmessage=new Array();\r\n");
      out.write("\t\t  var cmessagt=new Array();\r\n");
      out.write("\t\t  if(parseFloat(rentplan.corpusov)<0){cmessage.push(\"本金\");}\r\n");
      out.write("\t\t  if(parseFloat(rentplan.interestov)<0){cmessage.push(\"租息\");}\r\n");
      out.write("\t\t  if(parseFloat(rentplan.penaltyov)<0){cmessage.push(\"罚息\");}\r\n");
      out.write("\t\t  if(cmessage.length>0){cmessage.push(\"大于计划\");}\r\n");
      out.write("\t\t  if(parseFloat(rentplan.corpus)<0){cmessagt.push(\"本金\");}\r\n");
      out.write("\t\t  if(parseFloat(rentplan.interest)<0){cmessagt.push(\"租息\");}\r\n");
      out.write("\t\t // if(parseFloat(rentplan.penalty)<0){cmessagt.push(\"罚息\");}\r\n");
      out.write("\t\t  if(parseFloat(rentplan.interestadjust)<0){cmessagt.push(\"租息调整\");}\r\n");
      out.write("\t\t  if(parseFloat(rentplan.penaltyadjust)<0){cmessagt.push(\"罚息调整\");}\r\n");
      out.write("\t\t  if(cmessagt.length>0){cmessagt.push(\"红冲大于实收\");}\r\n");
      out.write("\t\t  return  cmessage+cmessagt+\"\";   \r\n");
      out.write("\t    }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t * 根据网银余额校验当前收的保证金是不是大于网银余额\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\tfunction doCheckRentCharge(sfund,tabledata){\r\n");
      out.write("\t\t\tvar tmoney=parseFloat(sfund);\r\n");
      out.write("\t\t\tvar stmoney=tmoney;\r\n");
      out.write("\t\t\tvar ebankid=jQuery(\"#ebdataid\").val();\r\n");
      out.write("\t\t\tvar all_cur_money=0.00;\r\n");
      out.write("\t\t\t///console.info(123);\r\n");
      out.write("\t\t\tfor(var i=0;i<tabledata.length;i++){\r\n");
      out.write("\t\t       if(tabledata[i].ebanknumber==ebankid){\r\n");
      out.write("\t\t           //if(tabledata[i].settlemethod!=\"红冲\"){\r\n");
      out.write("\t\t             tmoney=parseFloat(tmoney)-parseFloat(tabledata[i].receivermoney);\r\n");
      out.write("\t\t             tmoney=parseFloat(tmoney.toFixed(2));\r\n");
      out.write("\t\t             all_cur_money=all_cur_money+parseFloat(tabledata[i].receivermoney);\r\n");
      out.write("\t\t             all_cur_money=parseFloat(all_cur_money.toFixed(2));\r\n");
      out.write("\t\t           //}\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    if(tmoney<0){\r\n");
      out.write("\t\t    \t //jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>本次收取的金额【\"+all_cur_money+\"】大于网银余额【\"+stmoney+\"】\\n不能执行下一步.请调整.</div>\",'error');\r\n");
      out.write("\t\t        //return false;\r\n");
      out.write("\t\t        return true;\r\n");
      out.write("\t\t    }else{\r\n");
      out.write("\t\t        return true;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction checkRentCharge(){\r\n");
      out.write("\t\t     //获得这个合同的收款计划情况和相对网银\r\n");
      out.write("\t\t      var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');\r\n");
      out.write("\t\t\t loadMask_oper.show();\r\n");
      out.write("\t\t\t var isSubmit = false;\r\n");
      out.write("\t\t\t //var contractid=jQuery(\"#contractid\").val();\r\n");
      out.write("\t\t\t  var contractid=jQuery('input[name=\"contract_info.contractid\"]').val();\r\n");
      out.write("\t\t\t var ebankid=jQuery(\"#ebdataid\").val();\r\n");
      out.write("\t\t\t var param={};\r\n");
      out.write("\t\t\t var currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');\r\n");
      out.write("\t\t\t var tabledata=currentTable1.getRowsData();\r\n");
      out.write("\t\t\t if(tabledata.length==0){\r\n");
      out.write("\t\t\t\t loadMask_oper.hide();\r\n");
      out.write("\t\t\t\t jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>请选择核销的计划！</div>\",'error');\r\n");
      out.write("\t\t     return false;}\r\n");
      out.write("\t\t     var rentlist=\"\";\r\n");
      out.write("\t\t     for(var i=0;i<tabledata.length;i++){\r\n");
      out.write("\t\t\t     if(rentlist!=\"\"){\r\n");
      out.write("\t               rentlist=rentlist+\",\";\r\n");
      out.write("\t\t\t     }\r\n");
      out.write("\t\t\t     rentlist=rentlist+tabledata[i].planlist;\r\n");
      out.write("\t\t     }   \r\n");
      out.write("\t\t\t //var method=\"getRentCheckData\";\r\n");
      out.write("\t\t\t var method=\"getCanHireMoeny\";\r\n");
      out.write("\t\t\t param.contractid=contractid;\r\n");
      out.write("\t\t\t param.ebankid=ebankid;\r\n");
      out.write("\t\t\t param.rentlist=rentlist;\r\n");
      out.write("\t\t\t //网银中间表\r\n");
      out.write("\t\t\t param.ebankProcess = $('#id_fund_ebank_process').val();\r\n");
      out.write("\t\t\t ajaxRequest({\r\n");
      out.write("\t\t\t\t     //url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/rent/'+method+'.action',\r\n");
      out.write("\t\t\t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/fund/'+method+'.action',\r\n");
      out.write("\t\t\t\t     method:'POST',\r\n");
      out.write("\t\t\t\t     success:function(res){\r\n");
      out.write("\t\t\t   \t\t    var sfund=res.responseText;\r\n");
      out.write("\t\t\t   \t\t    sfund=sfund.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t\t\t   \t\t    loadMask_oper.hide();\r\n");
      out.write("\t\t\t   \t\t    if(sfund==\"\"){\r\n");
      out.write("\t\t  \t   \t\t    jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>没有租金计划！</div>\",'error');\r\n");
      out.write("\t\t  \t   \t\t        isSubmit = false;\r\n");
      out.write("\t\t\t   \t\t    }else{\r\n");
      out.write("\t\t\t   \t\t        isSubmit = doCheckRentCharge(sfund,tabledata);\r\n");
      out.write("\t\t\t   \t   \t\t}\r\n");
      out.write("\t\t\t\t     },\r\n");
      out.write("\t\t\t\t     async:false,\r\n");
      out.write("\t\t\t\t     failure:function(res){},\r\n");
      out.write("\t\t\t\t     params:param\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t\t loadMask_oper.hide();\r\n");
      out.write("\t\t\t return isSubmit;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>   \r\n");
      out.write("\t\t<script> \r\n");
      out.write("\t\tfunction   showdisplayplandate(opertype,rowDatas){\r\n");
      out.write("\t\t\tvar rentPlan=getTracywindyObject('multiTable_id_current_fund_income_detial_container');\r\n");
      out.write("\t\t    for(var i=0;i<rowDatas.length;i++){\r\n");
      out.write("\t        if(rowDatas[i].oper==\"old\"){\r\n");
      out.write("\t        \trentPlan.setReadOnly(true,\"hiredate\");\r\n");
      out.write("\t        }else{\r\n");
      out.write("\t        \trentPlan.setReadOnly(false,\"hiredate\");\r\n");
      out.write("\t            }\r\n");
      out.write("\t          }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\tfunction comptuerCurMoney(){\r\n");
      out.write("\t\t\tvar corpus=$(\"#re_corpus\").val()||0;\r\n");
      out.write("\t\t\tvar interest=$(\"#re_interest\").val()||0;\r\n");
      out.write("\t\t\tvar penalty=$(\"#re_penalty\").val()||0;\r\n");
      out.write("\t\t\tvar interestad=$(\"#re_interestadjust\").val()||0;\r\n");
      out.write("\t\t    var penaltyad=$(\"#re_penaltyadjust\").val()||0;\r\n");
      out.write("\t\t    var interestadjust=$(\"#re_interestadjust\").val()||0;\r\n");
      out.write("\t\t    var penaltyadjust=$(\"#re_penaltyadjust\").val()||0;\r\n");
      out.write("\t\t    if ( penalty < 0)\r\n");
      out.write("\t    \t{\r\n");
      out.write("\t\t    \talert(\"回笼罚息不能小于0\");\r\n");
      out.write("\t    \t\t$(\"#re_penalty\").val(-(penalty));\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t\t    var temp=parseFloat(corpus)+parseFloat(interest)+parseFloat(penalty)+parseFloat(interestad)+parseFloat(penaltyad)\r\n");
      out.write("\t            temp=temp+parseFloat(interestadjust)+parseFloat(penaltyadjust);\r\n");
      out.write("\t        $(\"#re_receivermoney\").val(temp.toFixed(2));\r\n");
      out.write("\t        temp=parseFloat(corpus)+parseFloat(interest)+parseFloat(interestad);\r\n");
      out.write("\t        $(\"#re_rent\").val(temp.toFixed(2));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\tfunction splitRent(){\r\n");
      out.write("\t\t\tvar ovcorpus=parseFloat($(\"#ov_corpus\").val())||0;\r\n");
      out.write("\t\t\tvar ovinterest=parseFloat($(\"#ov_interest\").val())||0;\r\n");
      out.write("\t\t\tvar ovrent=parseFloat($(\"#ov_rent\").val())||0;\r\n");
      out.write("\t\t\tvar rerent=parseFloat($(\"#re_rent\").val())||0;\r\n");
      out.write("\t\t\tvar penalty=parseFloat($(\"#re_penalty\").val())||0;\r\n");
      out.write("\t\t    if(rerent>ovrent){\r\n");
      out.write("\t\t    \talert(\"回笼租金不能大于剩余租金！！\");\r\n");
      out.write("\t\t    \t$(\"#re_rent\").val(ovrent);\r\n");
      out.write("\t\t    \t$(\"#re_corpus\").val(ovcorpus);\r\n");
      out.write("\t    \t\t$(\"#re_interest\").val(ovinterest);\r\n");
      out.write("\t    \t\t$(\"#re_receivermoney\").val((ovrent+penalty).toFixed(2));//合计\r\n");
      out.write("\t\t    \treturn false;\r\n");
      out.write("\t\t    }else{\r\n");
      out.write("\t\t    \t//如果本次租金小于剩余本金，怎么全部回笼本金\r\n");
      out.write("\t\t    \tif(rerent<=ovcorpus){\r\n");
      out.write("\t\t    \t\t$(\"#re_corpus\").val(rerent.toFixed(2));\r\n");
      out.write("\t\t    \t\t$(\"#re_interest\").val(0);\r\n");
      out.write("\t\t    \t}else{\r\n");
      out.write("\t\t    \t\t$(\"#re_corpus\").val(ovcorpus.toFixed(2));\r\n");
      out.write("\t\t    \t\t$(\"#re_interest\").val((rerent-ovcorpus).toFixed(2));\r\n");
      out.write("\t\t    \t}\r\n");
      out.write("\t\t    \t$(\"#re_receivermoney\").val((rerent+penalty).toFixed(2));//合计\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction onCheckPenalty(){\r\n");
      out.write("\t\t\tvar penalty = $(\"#re_penalty\").val(); \r\n");
      out.write("\t\t\tif ( penalty < 0)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"回笼罚息小于0\");\r\n");
      out.write("\t\t\t\treturn false;\t\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t}\r\n");
      out.write("</script>  \r\n");
      out.write("</script>    \r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("    var currentIsNeedTools = true;\r\n");
      out.write("    \r\n");
      out.write("    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("    \tcurrentIsNeedTools = false;\r\n");
      out.write("    }\r\n");
      out.write("\tnew tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_delivery_plan',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    tools:'修改|删除',\r\n");
      out.write("\t  /*   otherTools : [ {\r\n");
      out.write("\t\t\thtml : '<font color=\"red\">生成本次回笼租金明细</font>',\r\n");
      out.write("\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\tvar fundPlan = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t\t\t\t\talert(\"请选择需要回笼租金!\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tsetFundFundChargePlan(talbe)\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t} ], */\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_id_fund_rent_income ? \"[]\" : json_id_fund_rent_income }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t\t\t       {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'pid',  header:'pid',hidden:true},\r\n");
      out.write("\t\t\t       {name:'contract_id',  header:'contract_id',hidden:true},\r\n");
      out.write("\t\t           {name:'rollback',  header:'rollback',hidden:true},\r\n");
      out.write("\t\t\t       {name:'ebanknumber',  header:'ebanknumber', hidden:true},\r\n");
      out.write("\t\t\t       {name:'planid',header:'租金计划',hidden:true},\r\n");
      out.write("\t\t\t\t   {name:'dealer_id',  header:'dealer_id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'dealer_cust_name',header:'经销商名称',hidden:false},\r\n");
      out.write("\t\t\t\t   {name:'cust_id',  header:'cust_id',hidden:true},\r\n");
      out.write("\t\t\t       {name:'cust_name',header:'客户名称',hidden:false},\r\n");
      out.write("\t\t\t       {name:'contract_number',header:'合同号',hidden:false},\r\n");
      out.write("\t\t\t\t   {name:'plan_date',header:'计划日期',hidden:false},\r\n");
      out.write("\t\t\t       {name:'planlist',  header:'计划期项',readOnly:false},\r\n");
      out.write("\t\t\t       {name:'hirelist',  header:'回笼期项',readOnly:false},\r\n");
      out.write("\t\t\t       {name:'balancemode',  header:'balancemode',hidden:true},\r\n");
      out.write("\t\t\t       {name:'hiredate',  header:'回笼日期',type:'date',readOnly :false},\r\n");
      out.write("\t\t\t       {name:'ov_rent',  header:'剩余租金',readOnly:true,otherAttributes:'id=\"ov_rent\"'},\r\n");
      out.write("\t\t\t       {name:'ov_corpus',  header:'剩余本金',readOnly:true,otherAttributes:'id=\"ov_corpus\"'},\r\n");
      out.write("\t\t\t       {name:'ov_interest',  header:'剩余利息',readOnly:true,otherAttributes:'id=\"ov_interest\"'},\r\n");
      out.write("\t\t\t       {name:'rent',  header:'回笼租金' , nullable:false,type:'double',readOnly:false, otherAttributes:'id=\"re_rent\" onkeyup=\"splitRent()\"'},\r\n");
      out.write("\t\t\t       {name:'corpus',  header:'回笼本金' , nullable:false,type:'double', readOnly:true,otherAttributes:'id=\"re_corpus\" onkeyup=\"comptuerCurMoney()\"'},\r\n");
      out.write("\t\t\t       {name:'interest',  header:'回笼租息', nullable:false,type:'double',readOnly:true, otherAttributes:'id=\"re_interest\" onkeyup=\"comptuerCurMoney()\"'},\r\n");
      out.write("\t\t\t       {name:'penalty',  header:'回笼罚息' , nullable:false,type:'double', otherAttributes:'id=\"re_penalty\" onkeyup=\"comptuerCurMoney()\" '},\r\n");
      out.write("\t\t\t       {name:'interestadjust',  header:'租息调整',readOnly :true, nullable:false,type:'double', otherAttributes:'id=\"re_interestadjust\" onkeyup=\"comptuerCurMoney()\"'},\r\n");
      out.write("\t\t\t       {name:'penaltyadjust',  header:'罚息调整', readOnly :true,nullable:false,type:'double', otherAttributes:'id=\"re_penaltyadjust\" onkeyup=\"comptuerCurMoney()\"'},\r\n");
      out.write("\t\t\t       {name:'receivermoney',  header:'回笼合计', nullable:false,type:'double',readOnly:true, otherAttributes:'id=\"re_receivermoney\"'},\r\n");
      out.write("\t\t\t       {name:'invoiceno',  header:'单据号'},\r\n");
      out.write("\t\t\t       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},\r\n");
      out.write("\t\t\t       //{name:'accountingdate',  header:'会计处理日', nullable:false,type:'date'},\r\n");
      out.write("\t\t\t       {name:'ownbank',  header:'本方银行', readOnly:false},\r\n");
      out.write("\t\t\t       {name:'accnumber',  header:'本方账号', readOnly:false},\r\n");
      out.write("\t\t\t       {name:'ownaccount',  header:'本方银行账户',readOnly:false},\r\n");
      out.write("\t\t\t       {name:'hireobject',  header:'付款人', readOnly:false},\r\n");
      out.write("\t\t\t       {name:'hirebank',  header:'付款人银行', readOnly:false},\r\n");
      out.write("\t\t\t       {name:'hirenumber',  header:'付款人帐号', readOnly:false}\r\n");
      out.write("\t       \t     ]\r\n");
      out.write("\t });\r\n");
      out.write("\t \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
