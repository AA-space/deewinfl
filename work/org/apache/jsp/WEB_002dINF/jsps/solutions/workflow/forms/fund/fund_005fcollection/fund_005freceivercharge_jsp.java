package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.fund.fund_005fcollection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005freceivercharge_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("function doCheckFundCharge(fundData,tabledata){\r\n");
      out.write("\tvar fund=eval(\"(\"+fundData+\")\");\r\n");
      out.write("\tvar ebankMoney=0.00;\r\n");
      out.write("\tvar ebankId=\"\";\r\n");
      out.write("\tvar fundList=new Array();\r\n");
      out.write("\tebankMoney=fund.ebank[0].mayopemoney;\r\n");
      out.write("\tebankId=fund.ebank[0].ebankid;\r\n");
      out.write("\tfundList=fund.fund;\r\n");
      out.write("\tvar messageovpaln=new Array();\r\n");
      out.write("\tvar messageovebank=new Array();\r\n");
      out.write("\tvar messageovreback=new Array();\r\n");
      out.write("\r\n");
      out.write("\t//检查核销的收款计划大于网银/计划可核销的金额\r\n");
      out.write("\tfor(var i=0;i<tabledata.length;i++){\r\n");
      out.write("\t\tif(parseFloat(tabledata[i].factmoney)<0){\r\n");
      out.write("\t\t\t if(ebankId==tabledata[i].ebanknumber)\r\n");
      out.write("             {\r\n");
      out.write("          \t  ebankMoney=parseFloat(ebankMoney)-parseFloat(tabledata[i].factmoney);\r\n");
      out.write("          \t  ebankMoney=ebankMoney.toFixed(2);\r\n");
      out.write("             }\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t}\t\r\n");
      out.write("\tfor(var i=0;i<tabledata.length;i++){\r\n");
      out.write("       for(var j=0;j<fundList.length;j++){\r\n");
      out.write("          if(fundList[j].paymentid==tabledata[i].paymentid){//查找相同的付款编号\r\n");
      out.write("             var temp=parseFloat(tabledata[i].factmoney)+parseFloat(tabledata[i].feeadjust);\r\n");
      out.write("             temp=temp.toFixed(2);\r\n");
      out.write("             if(parseFloat(temp)>0){\r\n");
      out.write("                 //检查是否大于计划\r\n");
      out.write("                  if(parseFloat(fundList[j].lastmoney)<parseFloat(temp)){\r\n");
      out.write("                \t messageovpaln.push(fundList[j].paymentid);\r\n");
      out.write("                  }\r\n");
      out.write("                  if(ebankId==tabledata[i].ebanknumber)\r\n");
      out.write("                   {\r\n");
      out.write("                \t  ebankMoney=parseFloat(ebankMoney)-parseFloat(tabledata[i].factmoney);\r\n");
      out.write("                \t  ebankMoney=ebankMoney.toFixed(2);\r\n");
      out.write("                     }\r\n");
      out.write("                  if(ebankMoney<0){\r\n");
      out.write("                \t  messageovebank.push(fundList[j].paymentid);\r\n");
      out.write("                   }\r\n");
      out.write("             }else{\r\n");
      out.write("                 //如果红冲是相同的网银则将相应的金额加到相应的网银\r\n");
      out.write("                 var temp=parseFloat(fundList[j].receivermoney)+parseFloat(tabledata[i].factmoney);\r\n");
      out.write("                 if(temp<0){\r\n");
      out.write("                \t messageovreback.push( fundList[j].paymentid+\"的收款\"); \r\n");
      out.write("                 }\r\n");
      out.write("                 fundList[j].receivermoney=temp;\r\n");
      out.write("                 temp=parseFloat(fundList[j].adjustmoney)+parseFloat(tabledata[i].feeadjust);\r\n");
      out.write("                 if(temp<0){\r\n");
      out.write("                \t messageovreback.push( fundList[j].paymentid+\"的调整\"); \r\n");
      out.write("                 }\r\n");
      out.write("                 fundList[j].adjustmoney=temp;\r\n");
      out.write("              }\r\n");
      out.write("          }\r\n");
      out.write("       }\r\n");
      out.write("\t}\r\n");
      out.write("\tif(messageovpaln.length>0||messageovebank.length>0||messageovreback.length>0){\r\n");
      out.write("\t\tvar message=\"\";\r\n");
      out.write("\t\tif(messageovpaln.length>0){message=message+\"编号为\"+messageovpaln+\"收款计划的金额大于计划\";}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(messageovebank.length>0){if(message!=\"\"){message=message+\"<br>\";} message=message+\"编号为\"+messageovebank+\"收款计划的金额大于网银金额\";}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(messageovreback.length>0){\r\n");
      out.write("\t\t\tif(message!=\"\"){message=message+\"<br>\";}\r\n");
      out.write("\t      \tmessage=message+\"编号为\"+messageovreback+\"大于可红冲金额\";}\r\n");
      out.write("\t\tjQuery.messager.alert('错误提示',\"<div style='font-size:15px;line-height:30px;width:200px;'>\"+message+\"！</div>\",'error');\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("    }else{\r\n");
      out.write("        return true;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("function checkFundCharge(){\r\n");
      out.write("     //获得这个合同的收款计划情况和相对网银\r\n");
      out.write("\t loadMask_oper.show();\r\n");
      out.write("\t var isSubmit = false;\r\n");
      out.write("\t //var contractid=jQuery(\"#contractid\").val();\r\n");
      out.write("\t var contractid=jQuery('input[name=\"contract_info.id\"]').val();\r\n");
      out.write("\t var ebankid=jQuery(\"#ebdataid\").val();\r\n");
      out.write("\t var paytype=\"pay_type_in\";\r\n");
      out.write("\t var param={};\r\n");
      out.write("\t var currentTable1 = getTracywindyObject('table_id_table_receivercharge_container');\r\n");
      out.write("\t var tabledata=currentTable1.getRowsData();\r\n");
      out.write("\t if(tabledata.length==0){\r\n");
      out.write("\t\t loadMask_oper.hide();\r\n");
      out.write("\t\t jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>请选择核销的计划！</div>\",'error');\r\n");
      out.write("     return false;}\r\n");
      out.write("\t var method=\"getFundCheckData\";\r\n");
      out.write("\t param.contractid=contractid;\r\n");
      out.write("\t param.ebankid=ebankid;\r\n");
      out.write("\t param.paytype=paytype;\r\n");
      out.write("\t param.ebankProcess=$('#id_fund_ebank_process').val();\r\n");
      out.write("\t ajaxRequest({\r\n");
      out.write("\t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/fund/'+method+'.action',\r\n");
      out.write("\t\t     method:'POST',\r\n");
      out.write("\t\t     success:function(res){\r\n");
      out.write("\t   \t\t    var sfund=res.responseText;\r\n");
      out.write("\t   \t\t    sfund=sfund.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("\t   \t\t    loadMask_oper.hide();\r\n");
      out.write("\t   \t\t    if(sfund==\"\"){\r\n");
      out.write("  \t   \t\t    jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>没有收款计划！</div>\",'error');\r\n");
      out.write("  \t   \t\t        isSubmit = false;\r\n");
      out.write("\t   \t\t    }else{\r\n");
      out.write("\t   \t\t        isSubmit = doCheckFundCharge(sfund,tabledata);\r\n");
      out.write("\t   \t   \t\t}\r\n");
      out.write("\t\t     },\r\n");
      out.write("\t\t     async:false,\r\n");
      out.write("\t\t     failure:function(res){},\r\n");
      out.write("\t\t     params:param\r\n");
      out.write("\t });\r\n");
      out.write("\t loadMask_oper.hide();\r\n");
      out.write("\t return isSubmit;\r\n");
      out.write("\t}\n");
      out.write("</script>    \r\n");
      out.write("<script>\r\n");
      out.write("function comptuerPartFeeMoney(){\r\n");
      out.write("\tvar allMoney=$(\"#re_receivermoney\").val();\r\n");
      out.write("\tvar feemoney=$(\"#re_factmoney\").val();\r\n");
      out.write("\tvar feeadjust=$(\"#re_feeadjust\").val();\r\n");
      out.write("\tfeeadjust=feeadjust||0;\r\n");
      out.write("\tallMoney=allMoney||0;\r\n");
      out.write("\ttemp=parseFloat(allMoney)-parseFloat(feeadjust);\r\n");
      out.write("\t$(\"#re_factmoney\").val(temp.toFixed(2));\r\n");
      out.write("}\r\n");
      out.write("function comptuerPartAdjustMoney(){\r\n");
      out.write("\tvar allMoney=$(\"#re_receivermoney\");\r\n");
      out.write("\tvar feemoney=$(\"#re_factmoney\").val();\r\n");
      out.write("\tvar feeadjust=$(\"#re_feeadjust\").val();\r\n");
      out.write("\tfeemoney=feemoney||0;\r\n");
      out.write("\tfeeadjust=feeadjust||0;\r\n");
      out.write("\ttemp=parseFloat(feemoney)+parseFloat(feeadjust);\r\n");
      out.write("\t$(\"#re_receivermoney\").val(temp.toFixed(2));\r\n");
      out.write("}\r\n");
      out.write("function   showdisplayplandate(opertype,rowDatas){\r\n");
      out.write("\tvar rentPlan=getTracywindyObject('multiTable_id_table_receivercharge_container');\r\n");
      out.write("    for(var i=0;i<rowDatas.length;i++){\r\n");
      out.write("    if(rowDatas[i].oper==\"old\"){\r\n");
      out.write("    \trentPlan.setReadOnly(true,\"factdate\");\r\n");
      out.write("    }else{\r\n");
      out.write("    \trentPlan.setReadOnly(false,\"factdate\");\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("\t}\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \tcurrentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    \r\n");
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_receivercharge_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:350,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:false,\r\n");
      out.write("\t    tools:\"修改|删除\",\r\n");
      out.write("\t    operValidate:function(opertype,rowDatas){\r\n");
      out.write("\t\t\tshowdisplayplandate(opertype,rowDatas);\r\n");
      out.write("\t         return true;\r\n");
      out.write("\t        },\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_receivercharge_str ? \"[]\" : json_receivercharge_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t             {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t             {name:'pid',  header:'pid',hidden:true},\r\n");
      out.write("\t             {name:'rollback',  header:'rollback',hidden:true},\r\n");
      out.write("\t             {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},\r\n");
      out.write("\t\t\t     {name:'paymentid',  header:'收款编号',nullable:false,readOnly:true},\r\n");
      out.write("\t\t\t     {name:'ebanknumber',  header:'网银编号',readOnly:true},\r\n");
      out.write("\t\t\t\t {name:'feetype',  header:'feetypeId', hidden :true},\r\n");
      out.write("\t\t\t\t {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype',\r\n");
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
      out.write("\t\t\t       {name:'settlemethod',  header:'settlemethodId', hidden:true},\r\n");
      out.write("\t\t\t       {name:'rawValue_settlemethod',  header:'结算方式',nullable:false,type:'combobox',hiddenName:'settlemethod',\r\n");
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
      out.write("\t\t\t       {name:'factdate',  header:'到账时间',type:'date',readOnly:true},\r\n");
      out.write("\t\t\t       {name:'factmoney',  header:'金额',nullable:false,type:'double',otherAttributes:'id=\"re_factmoney\" onkeyup=\"comptuerPartAdjustMoney()\"'},\r\n");
      out.write("\t\t\t       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double',otherAttributes:'id=\"re_feeadjust\" onkeyup=\"comptuerPartFeeMoney()\"'},\r\n");
      out.write("\t\t\t       {name:'receivermoney',  header:'收款合计',nullable:false,type:'double',readOnly:true,otherAttributes:'id=\"re_receivermoney\"'},\r\n");
      out.write("\t\t\t       {name:'accountbank',  header:'银行(由银行账号自动生成)',readOnly:true},\r\n");
      out.write("\t\t\t       {name:'account',  header:'银行账户(由银行账号自动生成)',readOnly:true},\r\n");
      out.write("\t\t\t       {name:'accnumber',  header:'银行帐号',nullable:false,type:'combobox',\r\n");
      out.write("\t\t\t\t\t    config:{\r\n");
      out.write("\t\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\ebank\\\\comboEbankSelect.xml',\r\n");
      out.write("\t\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t\t\t       displayField:'accnumber',\r\n");
      out.write("\t\t\t\t\t\t       valueField:'accnumber'\r\n");
      out.write("\t\t\t   \t\t\t}\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       {name:'factobject',  header:'付款客户',type:'combobox',readOnly:true,\r\n");
      out.write("\t\t\t\t\t    config:{\r\n");
      out.write("\t\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\ebank\\\\comboEbankSelect.xml',\r\n");
      out.write("\t\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t\t\t       displayField:'clientname',\r\n");
      out.write("\t\t\t\t\t\t       valueField:'clientname'\r\n");
      out.write("\t\t\t   \t\t\t}\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       {name:'clientbank',  header:'客户银行(由银行账号自动生成)',readOnly:true},\r\n");
      out.write("\t\t\t       {name:'clientaccount',  header:'客户帐号(由银行账号自动生成)',readOnly:true},\r\n");
      out.write("\t\t\t       {name:'clientaccnumber',  header:'客户帐号',type:'combobox',\r\n");
      out.write("\t\t\t\t\t    config:{\r\n");
      out.write("\t\t\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\ebank\\\\comboEbankSelect.xml',\r\n");
      out.write("\t\t\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t\t\t       displayField:'clientaccnumber',\r\n");
      out.write("\t\t\t\t\t\t       valueField:'clientaccnumber'\r\n");
      out.write("\t\t\t   \t\t\t}},\r\n");
      out.write("\t\t\t       {name:'accountingdate', header:'会计处理日',type:'date',nullable:false},\r\n");
      out.write("\t\t\t       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},\r\n");
      out.write("\t\t\t       {name:'invoiceno',  header:'单据号'},\r\n");
      out.write("\t\t\t       {name:'paytype',header:'收付类型',hidden:true,defaultValue:\"pay_type_in\"},\r\n");
      out.write("\t\t\t       {name:'ffcmemo',  header:'备注',type:'textarea'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
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
