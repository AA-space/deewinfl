package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fnew_005fword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tvar targ = false;\r\n");
      out.write("\tjQuery(function() {\r\n");
      out.write("\t\tif (isSubTable) {\r\n");
      out.write("\t\t\t//租赁类型\r\n");
      out.write("\t\t\tdictOnSelect('id_word_leas_form', 'contract_word.leasform',\r\n");
      out.write("\t\t\t\t\t'leas_form',\r\n");
      out.write("\t\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty leas_form ? \"lease_form2\" : leas_form }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tchargeTemplate, null, true, null, true, null, false);\r\n");
      out.write("\t\t\t//合作方类型\r\n");
      out.write("\t\t\tdictOnSelect(\r\n");
      out.write("\t\t\t\t\t'id_word_partner_type',\r\n");
      out.write("\t\t\t\t\t'contract_word.partner_type',\r\n");
      out.write("\t\t\t\t\t'partner_type',\r\n");
      out.write("\t\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty contract_word_partner_type ? \"partner_type1\" : contract_word_partner_type }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tchargeTemplate, null, true);\r\n");
      out.write("\t\t\t//是否挂靠\r\n");
      out.write("\t\t\tdictOnSelect(\r\n");
      out.write("\t\t\t\t\t'id_word_car_affiliated',\r\n");
      out.write("\t\t\t\t\t'contract_word.car_affiliated',\r\n");
      out.write("\t\t\t\t\t'car_affiliated',\r\n");
      out.write("\t\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty contract_word_car_affiliated ? \"\" : contract_word_car_affiliated }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tchargeTemplate, null, true);\r\n");
      out.write("\t\t\t//是否抵押\r\n");
      out.write("\t\t\tdictOnSelect(\r\n");
      out.write("\t\t\t\t\t'id_word_mortgage_type',\r\n");
      out.write("\t\t\t\t\t'contract_word.mortgage_type',\r\n");
      out.write("\t\t\t\t\t'mortgage_type',\r\n");
      out.write("\t\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty contract_word_mortgage_type ? \"\" : contract_word_mortgage_type }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tchargeTemplate, null, true);\r\n");
      out.write("\t\t\t//担保类型\r\n");
      out.write("\t\t\tdictOnSelect(\r\n");
      out.write("\t\t\t\t\t'id_word_assurance',\r\n");
      out.write("\t\t\t\t\t'contract_word.assurance',\r\n");
      out.write("\t\t\t\t\t'assurance_type',\r\n");
      out.write("\t\t\t\t\t'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty contract_word_assurance ? \"assurance_type1\" : contract_word_assurance }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tchargeTemplate, null, true);\r\n");
      out.write("\t\t\tvar contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件\r\n");
      out.write("\t\t\tvar contractEquipDatas = contractEquip.getRowsJsonData();\r\n");
      out.write("\t\t\tvar moneyTotle = 0;\r\n");
      out.write("\t\t\tfor (var i = 0; i < contractEquipDatas.length; i++) {\r\n");
      out.write("\t\t\t\tmoneyTotle = moneyTotle\r\n");
      out.write("\t\t\t\t\t\t+ parseInt(contractEquipDatas[i].nowtotal);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#id_equip_money_totle\").val(moneyTotle);\r\n");
      out.write("\t\t\tif (!targ) {\r\n");
      out.write("\t\t\t\t//默认为直租\r\n");
      out.write("\t\t\t\ttarg = true;\r\n");
      out.write("\t\t\t\t//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数\r\n");
      out.write("\t\t\t\tvar leasform = getTracywindyObject(\"id_combo_id_word_leas_form\")\r\n");
      out.write("\t\t\t\t\t\t.getValue();\r\n");
      out.write("\t\t\t\tvar partner_type = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\t\t\"id_combo_id_word_partner_type\").getValue();\r\n");
      out.write("\t\t\t\tvar car_affiliated = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\t\t\"id_combo_id_word_car_affiliated\").getValue();\r\n");
      out.write("\t\t\t\tvar mortgage_type = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\t\t\"id_combo_id_word_mortgage_type\").getValue();\r\n");
      out.write("\t\t\t\tvar assurance = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\t\t\"id_combo_id_word_assurance\").getValue();\r\n");
      out.write("\t\t\t\tvar cust_class = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.custclass']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t\tif (cust_class = \"经销商\") {\r\n");
      out.write("\t\t\t\t\tpartner_type = \"partner_type1\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\tconfig = {\r\n");
      out.write("\t\t\t\t\ttemplateDiv : 'contract_word_check_list',\r\n");
      out.write("\t\t\t\t\toneClassify : 'wordtempletypefirst4',\r\n");
      out.write("\t\t\t\t\ttwoClassify : 'lease_form2',\r\n");
      out.write("\t\t\t\t\tthreethClassify : partner_type,\r\n");
      out.write("\t\t\t\t\tsixClassify : 'assurance_type1',\r\n");
      out.write("\t\t\t\t\tchangeRowNum : 3\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\tloadTemplate(config);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction chargeTemplate() {\r\n");
      out.write("\t\ttarg = true;\r\n");
      out.write("\t\t//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数\r\n");
      out.write("\t\tvar leasform = getTracywindyObject(\"id_combo_id_word_leas_form\")\r\n");
      out.write("\t\t\t\t.getValue();\r\n");
      out.write("\t\t//合作方类型\r\n");
      out.write("\t\tvar partner_type = getTracywindyObject(\"id_combo_id_word_partner_type\")\r\n");
      out.write("\t\t\t\t.getValue();\r\n");
      out.write("\t\t//是否挂靠\r\n");
      out.write("\t\tvar car_affiliated = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\"id_combo_id_word_car_affiliated\").getValue();\r\n");
      out.write("\t\t//是否抵押\r\n");
      out.write("\t\tvar mortgage_type = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\"id_combo_id_word_mortgage_type\").getValue();\r\n");
      out.write("\t\t//担保类型\r\n");
      out.write("\t\tvar assurance = getTracywindyObject(\"id_combo_id_word_assurance\")\r\n");
      out.write("\t\t\t\t.getValue();\r\n");
      out.write("\r\n");
      out.write("\t\t//一.抵押\r\n");
      out.write("\t\t//1.选择条件为抵押时→显示所有的合同模板\r\n");
      out.write("\t\t//2.选择条件为不抵押→除了抵押的合同其他都显示（排除7,7,6）\r\n");
      out.write("\t\tif (mortgage_type == \"mortgage_type1\") {\r\n");
      out.write("\t\t\tmortgage_type = \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//二.挂靠\r\n");
      out.write("\t\t//1.挂靠显示所有合同\r\n");
      out.write("\t\t//2.不挂靠 除了挂靠的合同都显示\r\n");
      out.write("\t\tif (car_affiliated == \"car_affiliated1\") {\r\n");
      out.write("\t\t\tcar_affiliated = \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//三.合作方类型 下拉选项→经销商、专用车企\r\n");
      out.write("\t\t//1.经销商显示经销商的所有合同\r\n");
      out.write("\t\t//2.专用车企 只显示担保模式的 合同加+租赁物回购合同(专用车企业适用)合同\r\n");
      out.write("\r\n");
      out.write("\t\t//四.如果客户是法人 显示 股东会决议和董事会决议两个模板\r\n");
      out.write("\t\tvar cust_class = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['cust_info.custclass']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tif (cust_class == \"法人\"&&leasform !=\"lease_form2\") {\r\n");
      out.write("\t\t\tcust_class = \"CUST_INFO_COMPANY\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tconfig = {\r\n");
      out.write("\t\t\ttemplateDiv : 'contract_word_check_list',\r\n");
      out.write("\t\t\toneClassify : 'wordtempletypefirst4',\r\n");
      out.write("\t\t\ttwoClassify : leasform,\r\n");
      out.write("\t\t\tthreethClassify : partner_type,\r\n");
      out.write("\t\t\tfourClassify : car_affiliated,\r\n");
      out.write("\t\t\tfiveClassify : mortgage_type,\r\n");
      out.write("\t\t\tsixClassify : assurance,\r\n");
      out.write("\t\t\tsevenClassify : cust_class,\r\n");
      out.write("\t\t\tchangeRowNum : 3\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tloadTemplate(config);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction ajaxChargeTemplateCallBack(rs) {\r\n");
      out.write("\t\tvar svote = rs.responseText;\r\n");
      out.write("\t\tsvote = svote.replace(/(^\\s+)|(\\s+$)/g, \"\");\r\n");
      out.write("\t\tcurrentDeleteFileLoadMask.hide();\r\n");
      out.write("\t\tdocument.getElementById(\"contract_word_check_list\").innerHTML = svote;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction createWord() {\r\n");
      out.write("\t\t//在生成合同前保持数据到json\r\n");
      out.write("\t\t//注分fileListTable:合同列表多行控件的ID(取这个table)\r\n");
      out.write("\t\t//modename:'模板分类',第一级分类\r\n");
      out.write("\t\t//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数\r\n");
      out.write("\t\tvar leasform = getTracywindyObject(\"id_combo_id_word_leas_form\")\r\n");
      out.write("\t\t\t\t.getValue();\r\n");
      out.write("\t\t//合作方类型\r\n");
      out.write("\t\tvar partner_type = getTracywindyObject(\"id_combo_id_word_partner_type\")\r\n");
      out.write("\t\t\t\t.getValue();\r\n");
      out.write("\t\t//是否挂靠\r\n");
      out.write("\t\tvar car_affiliated = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\"id_combo_id_word_car_affiliated\").getValue();\r\n");
      out.write("\t\t//是否抵押\r\n");
      out.write("\t\tvar mortgage_type = getTracywindyObject(\r\n");
      out.write("\t\t\t\t\"id_combo_id_word_mortgage_type\").getValue();\r\n");
      out.write("\t\t//担保类型\r\n");
      out.write("\t\tvar assurance = getTracywindyObject(\"id_combo_id_word_assurance\")\r\n");
      out.write("\t\t\t\t.getValue();\r\n");
      out.write("\r\n");
      out.write("\t\t//合同第一步可以修改租赁物明细\r\n");
      out.write("\t\tvar contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件\r\n");
      out.write("\t\tvar contractEquipDatas = contractEquip.getRowsJsonData();\r\n");
      out.write("\t\tvar moneyTotle = 0;\r\n");
      out.write("\t\tvar equipdeliveryplace = contractEquipDatas[0].equipdeliveryplace;\r\n");
      out.write("\t\tfor (var i = 0; i < contractEquipDatas.length; i++) {\r\n");
      out.write("\t\t\tmoneyTotle = moneyTotle + parseInt(contractEquipDatas[i].nowtotal);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//获取页面租金计划每月租金和总租金\r\n");
      out.write("\t\tvar currentTable2 = getTracywindyObject('table_id_table_leasing_rent_plan_container');\r\n");
      out.write("\t\tvar tabledata2 = currentTable2.getRowsData();\r\n");
      out.write("\t\tvar sumMoney = null;\r\n");
      out.write("\t\tfor (var j = 0; j < tabledata2.length; j++) {\r\n");
      out.write("\t\t\tsumMoney = sumMoney + parseFloat(tabledata2[j].rent);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar rentmoney = (sumMoney / parseInt(tabledata2.length)).toFixed(2);\r\n");
      out.write("\t\t$(\"#id_equip_money_totle\").val(moneyTotle);\r\n");
      out.write("\r\n");
      out.write("\t\t//是否上牌\r\n");
      out.write("\t\tvar isregistration = getTracywindyObject(\"id_combo_id_is_registration\")\r\n");
      out.write("\t\t\t\t.getRawValue();\r\n");
      out.write("\t\tvar isguaranty = getTracywindyObject(\"id_combo_id_is_guaranty\")\r\n");
      out.write("\t\t\t\t.getRawValue();\r\n");
      out.write("\t\tif (leasform == \"\") {\r\n");
      out.write("\t\t\talert(\"请选择租赁物类型!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (partner_type == \"\") {\r\n");
      out.write("\t\t\talert(\"请选择合作方类型!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (car_affiliated == \"\") {\r\n");
      out.write("\t\t\talert(\"请选择挂靠类型!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (mortgage_type == \"\") {\r\n");
      out.write("\t\t\talert(\"请选择抵押类型!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (assurance == \"\") {\r\n");
      out.write("\t\t\talert(\"请选择担保类型!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcreateWordByIds({\r\n");
      out.write("\t\t\tfileListTable : 'table_id_table_leasing_contract_list_container',\r\n");
      out.write("\t\t\tmodename : 'wordtempletypefirst4',\r\n");
      out.write("\t\t\t'equip.equip_money_totle' : $(\"#id_equip_money_totle\").val(),\r\n");
      out.write("\t\t\t'json_proj_equip_str' : JsonUtil.encode(contractEquip\r\n");
      out.write("\t\t\t\t\t.getRowsJsonData()),\r\n");
      out.write("\t\t\t'contract_info.equipdeliveryplace' : equipdeliveryplace,\r\n");
      out.write("\t\t\t'framework_condition.rent' : rentmoney,\r\n");
      out.write("\t\t\t'framework_condition.renttotalmoney' : sumMoney.toFixed(2),\r\n");
      out.write("\t\t\t'framework_condition.isregistration' : isregistration,\r\n");
      out.write("\t\t\t'framework_condition.isguaranty' : isguaranty\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 合同制作下拉菜单选择的值-->\r\n");
      out.write("<input type=\"hidden\" id=\"id_equip_money_totle\"\r\n");
      out.write("\tname=\"equip.equip_money_totle\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty equip_money_totle ? \" \" : equip_money_totle }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<div class=\"fillTableContainer\">\r\n");
      out.write("\t<table class=\"fillTable\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t<tr class=\"tr-contractect-word-info tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">租赁类型：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\"\r\n");
      out.write("\t\t\t\t\tid=\"id_word_leas_form\"></div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">合作方类型：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\"\r\n");
      out.write("\t\t\t\t\tid=\"id_word_partner_type\"></div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">挂靠类型：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\"\r\n");
      out.write("\t\t\t\t\tid=\"id_word_car_affiliated\"></div></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">抵押类型：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\"\r\n");
      out.write("\t\t\t\t\tid=\"id_word_mortgage_type\"></div></td>\r\n");
      out.write("\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-contractect-word-info tr-even\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\">担保类型：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\"><div class=\"leftComboContainer\"\r\n");
      out.write("\t\t\t\t\tid=\"id_word_assurance\"></div></td>\r\n");
      out.write("\t\t\t<td class=\"td-content-title\" id=\"contract_multi_choice\"><input\r\n");
      out.write("\t\t\t\tid=\"inputCheck\" type=\"checkbox\" />全选<input id=\"select_reverse\"\r\n");
      out.write("\t\t\t\ttype=\"checkbox\" />反选</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-contractect-word-info tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"td-content-title\" id=\"id_contract_model\">合同模板：</td>\r\n");
      out.write("\t\t\t<td class=\"td-content\" colspan=7><script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t//得到流程名称\r\n");
      out.write("\t\t\t\tvar currentWorkFlowDisplayName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentWorkFlowDisplayName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t\t//得到节点名称\r\n");
      out.write("\t\t\t\tvar currentTaskActivityName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTaskActivityName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t\tif ((currentWorkFlowDisplayName == \"合同审批流程\" || currentWorkFlowDisplayName == \"合同变更流程\")\r\n");
      out.write("\t\t\t\t\t\t&& currentTaskActivityName == \"01发起\") {\r\n");
      out.write("\t\t\t\t\t$(\"#contract_word_check_list\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#id_contract_model\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#btn_create_contract\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#contract_multi_choice\").show();\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#contract_word_check_list\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#id_contract_model\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#btn_create_contract\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#contract_multi_choice\").hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\t<div id=\"contract_word_check_list\">\r\n");
      out.write("\t\t\t\t\t<span>请先选择!</span>\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-contractect-word-info tr-even\" id=\"btn_create_contract\">\r\n");
      out.write("\t\t\t<td class=\"td-content\" colspan=8 align=\"right\"><input\r\n");
      out.write("\t\t\t\tstyle=\"margin-top: 2px; margin-bottom: 2px;\" id=\"btn_rent_cal\"\r\n");
      out.write("\t\t\t\tclass=\"btn btn-primary\" type=\"button\" value=\"生成合同\"\r\n");
      out.write("\t\t\t\tonclick=\"createWord()\" /> <!--  <input style=\"margin-top:2px;margin-bottom:2px;\" id=\"btn_rent_cal\" class=\"btn btn-primary\" type=\"button\" value=\"合同在线编辑\" onclick=\"openoverdue()\"/> -->\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-contractect-word-info tr-odd\">\r\n");
      out.write("\t\t\t<td class=\"x-panel-table-div-title\" colspan=8><div\r\n");
      out.write("\t\t\t\t\tclass=\"toggle-icon-expanded\" title=\"折叠\"\r\n");
      out.write("\t\t\t\t\ttoggleClass=\"tr-contractect-word-list\"></div>合同清单</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr-contractect-word-list\">\r\n");
      out.write("\t\t\t<td class=\"td-content\" colspan=8>\r\n");
      out.write("\t\t\t\t<div id=\"id_table_leasing_contract_list_container\"\r\n");
      out.write("\t\t\t\t\tstyle=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "contract_list_info.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>");
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
