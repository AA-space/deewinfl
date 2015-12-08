package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.assets.fund.fund_005ftranslation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fund_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script>\r\n");
      out.write("function getCurrentDate(){\r\n");
      out.write("    var cdate=new Date();\r\n");
      out.write("    var month=(parseFloat(cdate.getMonth())+1);\r\n");
      out.write("    var day=cdate.getDate();\r\n");
      out.write("    if(parseFloat(day)<10){day=\"0\"+day;}\r\n");
      out.write("    if(parseFloat(month)<10){month=\"0\"+month;}\r\n");
      out.write("    return cdate.getFullYear()+\"-\"+month+\"-\"+day;\r\n");
      out.write("}\r\n");
      out.write("function checkIdIsAdd(id,ids){\r\n");
      out.write("    if(ids.length>0){\r\n");
      out.write("    for(var i=0;i<ids.length;i++){\r\n");
      out.write("     if(id==ids[i]){return true;}\r\n");
      out.write("    }\r\n");
      out.write("    return false;\r\n");
      out.write("    }else{return false;}\r\n");
      out.write("}\r\n");
      out.write("function getTableColumnData(tabledatas,column){\r\n");
      out.write("    var cdata=[];\r\n");
      out.write("    if(tabledatas.length>0){\r\n");
      out.write("        for(var i=0;i<tabledatas.length;i++){\r\n");
      out.write("            var ctable=tabledatas[i];\r\n");
      out.write("            cdata[i]=ctable[column];\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    return cdata;\r\n");
      out.write("}\r\n");
      out.write("var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');\r\n");
      out.write("\r\n");
      out.write("\tfunction setFundFundChargePlan(table) {\r\n");
      out.write("\t\tloadMask_oper.show();\r\n");
      out.write("\t\tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("\t\tvar rowDatas = table.getRowsData();\r\n");
      out.write("\r\n");
      out.write("\t\tvar plandata_rent_list = {};\r\n");
      out.write("\t\tfor ( var int = 0; int < rowDatas.length; int++) {\r\n");
      out.write("\t\t\tif (!plandata_rent_list[rowDatas[int]['contract_id']]) {\r\n");
      out.write("\t\t\t\tplandata_rent_list[rowDatas[int]['contract_id']] = [];\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tplandata_rent_list[rowDatas[int]['contract_id']].push(rowDatas[int]['rent_list']);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar ebankdatas = jQuery(\"#fund_ebank_data input[type='text'],#fund_ebank_data textarea\");\r\n");
      out.write("\t\tvar ebank = [];\r\n");
      out.write("\t\tvar i = 0;\r\n");
      out.write("\t\tfor (i = 0; i < ebankdatas.length; i++) {\r\n");
      out.write("\t\t\tebank[ebankdatas[i].name] = ebankdatas[i].value;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar allItems = document.getElementsByName(table.checkName);\r\n");
      out.write("\t\tfor ( var i = 0; i < allItems.length; i++) {\r\n");
      out.write("\t\t\tif (allItems[i].checked) {\r\n");
      out.write("\t\t\t\tallItems[i].checked = false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');\r\n");
      out.write("\t\tvar talbedata = currentTable1.getRowsData();\r\n");
      out.write("\t\tvar iddata = getTableColumnData(talbedata, \"id\");\r\n");
      out.write("\t\tvar isAddPlanData = \"\";\r\n");
      out.write("\t\tvar curdate = getCurrentDate();\r\n");
      out.write("\t\tfor (i = 0; i < plandata.length; i++) {\r\n");
      out.write("\t\t\t// plandata_rent_list[plandata[i]['contract_id']][0];\r\n");
      out.write("\t\t\t// console.info( plandata_rent_list[plandata[i]['contract_id']]);\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (plandata[i].rent_list != plandata_rent_list[plandata[i]['contract_id']][0]) {\r\n");
      out.write("\t\t\t\tloadMask_oper.hide();\r\n");
      out.write("\t\t\t\t//jQuery.messager.alert('错误提示',\"<div style='font-size:18px;line-height:30px;'>因租金必须按顺序回笼, 第\"+plandata[i].rentlist+\"期以下租金未被选择</div>\",'error'); \r\n");
      out.write("\t\t\t\talert(\"因租金必须按顺序回笼,合同【\" + plandata[i].contract_number + \"】中, 第【\" + plandata[i].rent_list + \"】期及以下租金未被选择\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (plandata[i].incomecard == \"3\") {\r\n");
      out.write("\t\t\t\tloadMask_oper.hide();\r\n");
      out.write("\t\t\t\talert(\"所勾选的租金计划记录正在卡扣,不允许操作!\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tplandata_rent_list[plandata[i]['contract_id']].shift();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (parseFloat(plandata[i].ov_rent) > 0 || parseFloat(plandata[i].vo_penalty) > 0) {\r\n");
      out.write("\t\t\t\tvar fund = {};\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (checkIdIsAdd(plandata[i].id, iddata)) {\r\n");
      out.write("\t\t\t\t\tif (isAddPlanData == \"\") {\r\n");
      out.write("\t\t\t\t\t\tisAddPlanData = '【' + plandata[i].contract_number + '】号合同第【' + plandata[i].rent_list + '】期';\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tisAddPlanData = isAddPlanData + \",\" + '【' + plandata[i].contract_number + '】号合同第【' + plandata[i].rent_list + '】期';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tfund.id = plandata[i].id;\r\n");
      out.write("\t\t\t\t\tfund.planid = plandata[i].id;\r\n");
      out.write("\t\t\t\t\tfund.planlist = plandata[i].rent_list;\r\n");
      out.write("\t\t\t\t\tfund.dealer_id = plandata[i].dealer_id;\r\n");
      out.write("\t\t\t\t\tfund.dealer_cust_name = plandata[i].dealer_cust_name;\r\n");
      out.write("\t\t\t\t\tfund.cust_id = plandata[i].cust_id;\r\n");
      out.write("\t\t\t\t\tfund.cust_name = plandata[i].cust_name;\r\n");
      out.write("\t\t\t\t\tfund.plan_date = plandata[i].plan_date;\r\n");
      out.write("\t\t\t\t\tfund.contract_id = plandata[i].contract_id;\r\n");
      out.write("\t\t\t\t\tfund.contract_number = plandata[i].contract_number;\r\n");
      out.write("\t\t\t\t\tfund.ebanknumber = ebank[\"fund_ebank_data.ebdataid\"];\r\n");
      out.write("\t\t\t\t\tfund.balancemode = \"PayFund6\";\r\n");
      out.write("\t\t\t\t\tfund.rawValue_balancemode = \"电汇\";\r\n");
      out.write("\t\t\t\t\tfund.hirelist = parseFloat(plandata[i].hirelist || 0) + 1;\r\n");
      out.write("\t\t\t\t\tfund.hiredate = ebank[\"fund_ebank_data.factdate\"];\r\n");
      out.write("\t\t\t\t\tfund.ov_rent = plandata[i].ov_rent;\r\n");
      out.write("\t\t\t\t\tfund.ov_corpus = plandata[i].ov_corpus;\r\n");
      out.write("\t\t\t\t\tfund.ov_interest = plandata[i].ov_interest;\r\n");
      out.write("\t\t\t\t\tfund.rent = plandata[i].ov_rent;\r\n");
      out.write("\t\t\t\t\tfund.corpus = plandata[i].ov_corpus;\r\n");
      out.write("\t\t\t\t\tfund.interest = plandata[i].ov_interest;\r\n");
      out.write("\t\t\t\t\tfund.penalty = plandata[i].vo_penalty;\r\n");
      out.write("\t\t\t\t\tfund.interestadjust = 0.00;\r\n");
      out.write("\t\t\t\t\tfund.penaltyadjust = 0.00;\r\n");
      out.write("\t\t\t\t\ttemp = parseFloat(plandata[i].ov_rent) + parseFloat(plandata[i].vo_penalty);\r\n");
      out.write("\t\t\t\t\tfund.receivermoney = temp.toFixed(2);\r\n");
      out.write("\t\t\t\t\tfund.accountingdate = curdate;\r\n");
      out.write("\t\t\t\t\tfund.oper = \"add\";\r\n");
      out.write("\t\t\t\t\tfund.ownbank = ebank[\"fund_ebank_data.ownbank\"];\r\n");
      out.write("\t\t\t\t\tfund.ownaccount = ebank[\"fund_ebank_data.ownaccount\"];\r\n");
      out.write("\t\t\t\t\tfund.accnumber = ebank[\"fund_ebank_data.ownaccnumber\"];\r\n");
      out.write("\t\t\t\t\tfund.hireobject = ebank[\"fund_ebank_data.clientname\"];\r\n");
      out.write("\t\t\t\t\tfund.hirebank = ebank[\"fund_ebank_data.clientbank\"];\r\n");
      out.write("\t\t\t\t\tfund.clientaccount = ebank[\"fund_ebank_data.clientaccount\"];\r\n");
      out.write("\t\t\t\t\tfund.hirenumber = ebank[\"fund_ebank_data.clientaccnumber\"];\r\n");
      out.write("\t\t\t\t\tfund.invoiceno = \"\";\r\n");
      out.write("\t\t\t\t\tcurrentTable1.AddRow(fund);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tloadMask_oper.hide();\r\n");
      out.write("\t\t\t\talert(\"合同【\" + plandata[i].contract_number + \"】, 第【\" + plandata[i].rent_list + \"】期已经回笼\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tloadMask_oper.hide();\r\n");
      out.write("\t\tif (isAddPlanData == \"\") {\r\n");
      out.write("\t\t\talert(\"操作成功\");\r\n");
      out.write("\t\t\tjQuery(\"#id_fund_plan_detial\").window(\"close\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"操作成功其中\" + isAddPlanData + \"已经加到实收计划中不能重复添加\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\tvar currentIsNeedTools = true;\r\n");
      out.write("\t\tif (('true' != '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("') || ('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')) {\r\n");
      out.write("\t\t\tcurrentIsNeedTools = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tnew tracywindyMultiTable({\r\n");
      out.write("\t\t\trenderTo : 'id_fund_plan_detial',\r\n");
      out.write("\t\t\twidth : formWidth,\r\n");
      out.write("\t\t\theight : 350,\r\n");
      out.write("\t\t\tisNeedTools : currentIsNeedTools,\r\n");
      out.write("\t\t\txmlFileName : '/eleasing/workflow/public/fundRentPlanSelect.xml',\r\n");
      out.write("\t\t\tloadMode : 'ajax',\r\n");
      out.write("\t\t\t//此处不能用分页，如果分页按顺序核销有可能失效 add by jason 2013-12-5\r\n");
      out.write("\t\t\t//isPage:true,\r\n");
      out.write("\t\t\tisAutoBreakContent : true,\r\n");
      out.write("\t\t\tisColumnResizable : false,\r\n");
      out.write("\t\t\tisRemoteSortable : false,\r\n");
      out.write("\t\t\ttools : ' ',\r\n");
      out.write("\t\t\tparams : {\r\n");
      out.write("\t\t\t\t//pay_type : 'pay_type_in',\r\n");
      out.write("\t\t\t\tcontract_id : ' ',\r\n");
      out.write("\t\t\t\thasmoney : \"1\",\r\n");
      out.write("\t\t\t\tcalcdate:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['fund_ebank_data.factdate']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\totherTools : [ {\r\n");
      out.write("\t\t\t\thtml : '<font color=\"red\">生成本次租金回笼明细</font>',\r\n");
      out.write("\t\t\t\thandler : function(table) {\r\n");
      out.write("\t\t\t\t\tvar fundPlan = table.getCheckedRowDatas();\r\n");
      out.write("\t\t\t\t\tif (0 == fundPlan.length) {\r\n");
      out.write("\t\t\t\t\t\talert(\"请选择需要租金!\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tsetFundFundChargePlan(table);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\ticonCls : 'icon-update'\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\t//datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_guarantee_equip_str ? \"[]\" : json_proj_guarantee_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t\t\tcolumns : [ {\r\n");
      out.write("\t\t\t\tname : 'id',\r\n");
      out.write("\t\t\t\theader : 'id',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'contract_id',\r\n");
      out.write("\t\t\t\theader : 'contract_id',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'dealer_id',\r\n");
      out.write("\t\t\t\theader : 'dealer_id',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'dealer_cust_name',\r\n");
      out.write("\t\t\t\theader : '经销商名称'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'cust_id',\r\n");
      out.write("\t\t\t\theader : 'cust_id',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'cust_name',\r\n");
      out.write("\t\t\t\theader : '客户名称',\r\n");
      out.write("\t\t\t\twidth : 130\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'contract_number',\r\n");
      out.write("\t\t\t\theader : '合同号',\r\n");
      out.write("\t\t\t\tnullable : false,\r\n");
      out.write("\t\t\t\twidth : 180\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'rent_list',\r\n");
      out.write("\t\t\t\theader : '期次',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t//{name:'hire_list',  header:'期次',nullable:false },\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tname : 'rent_status',\r\n");
      out.write("\t\t\t\theader : '回笼状态',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'plan_date',\r\n");
      out.write("\t\t\t\theader : '计划日期',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'rent',\r\n");
      out.write("\t\t\t\theader : '计划租金',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'corpus',\r\n");
      out.write("\t\t\t\theader : '计划本金',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'interest',\r\n");
      out.write("\t\t\t\theader : '计划租息',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'penalty',\r\n");
      out.write("\t\t\t\theader : '应收罚息',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'ov_rent',\r\n");
      out.write("\t\t\t\theader : '租金余额',\r\n");
      out.write("\t\t\t\tnullable : false\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'ov_corpus',\r\n");
      out.write("\t\t\t\theader : '本金余额',\r\n");
      out.write("\t\t\t\tnullable : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'ov_interest',\r\n");
      out.write("\t\t\t\theader : '利息余额',\r\n");
      out.write("\t\t\t\tnullable : false,\r\n");
      out.write("\t\t\t\ttype : 'double'\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tname : 'vo_penalty',\r\n");
      out.write("\t\t\t\theader : '罚息余额',\r\n");
      out.write("\t\t\t\tnullable : false,\r\n");
      out.write("\t\t\t\ttype : 'double'\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\t, {\r\n");
      out.write("\t\t\t\tname : 'is_card',\r\n");
      out.write("\t\t\t\theader : '是否卡扣'\r\n");
      out.write("\t\t\t} , {\r\n");
      out.write("\t\t\t\tname : 'incomecard',\r\n");
      out.write("\t\t\t\theader : '是否正在卡扣',\r\n");
      out.write("\t\t\t\thidden : true\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
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
