package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fterminate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fterminate_005fequip_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tvar temp_equip=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['json_proj_equip_str']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\tfunction validataTotalMoney(){//验证金额，add by Jason ###蔡雅超8-15改\r\n");
      out.write("\t\tif(chenckCondiotn){\r\n");
      out.write("\t\t\t//计算租赁物的总交易价格\r\n");
      out.write("\t\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\t\t\tvar data = currentTable1.tableData;\r\n");
      out.write("\t\t\tvar totalPrice = 0;\r\n");
      out.write("\t\t\tfor(var i=0;i<data.length;i++){\r\n");
      out.write("\t\t\t\ttotalPrice += parseFloat(data[i]['nowtotal']);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//计算商务条件的设备款\r\n");
      out.write("\t\t\tvar equipAmt = parseFloat($(\"#equipAmt\").val());\r\n");
      out.write("\t\t\ttotalPrice = totalPrice.toFixed(2);\r\n");
      out.write("\t\t\tequipAmt = equipAmt.toFixed(2);\r\n");
      out.write("\t\t\tif(totalPrice !=  equipAmt){//如果不相等，则跳出执行\r\n");
      out.write("\t\t\t\talert(\"【租赁物明细】标签的合计总价[\"+ totalPrice + \"]和【拟商务条件】标签中的设备款[\"+ equipAmt +\"]不相等,请检查.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else{\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"您修改过商务条件中的值且未进行过测算!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>    \r\n");
      out.write("<script>\r\n");
      out.write("function AdjustMoney(){//算出差额\r\n");
      out.write("\tvar differential_swap=$(\"#id_differential_swap\");\r\n");
      out.write("\tvar purchaseprice=$(\"#id_purchaseprice\").val();\r\n");
      out.write("\tvar saleprice=$(\"#id_saleprice\").val();\r\n");
      out.write("\tpurchaseprice=purchaseprice||0;\r\n");
      out.write("\tsaleprice=saleprice||0;\r\n");
      out.write("\tvar temp=parseFloat(saleprice)-parseFloat(purchaseprice);\r\n");
      out.write("\t$(\"#id_differential_swap\").val(temp.toFixed(2));\r\n");
      out.write("}\r\n");
      out.write("function AdjustTotal(){//算出总价\r\n");
      out.write("\t//var copydata=jQuery('#id_json_proj_equip_str_copy').val();\r\n");
      out.write("    var copydatas=eval(temp_equip);\r\n");
      out.write("\t/*for(var i=0;i<copydatas.length;i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t    if (copydatas[i].id==$(\"#id_equip\").val())\r\n");
      out.write("\t    {\r\n");
      out.write("\t\t    if (parseFloat($(\"#id_saleprice\").val())>parseFloat(copydatas[i].saleprice))\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \t$(\"#id_saleprice\").val(copydatas[i].saleprice);\r\n");
      out.write("\t\t\t    alert(\"租赁物单价不能超过之前的单价,请重新输入！\");\r\n");
      out.write("\t             return false;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t    }\r\n");
      out.write("\t}*/\r\n");
      out.write("\tvar differential_swap=$(\"#id_nowtotal\");\r\n");
      out.write("\tvar equipnum=$(\"#id_equipnum\").val();\r\n");
      out.write("\tvar saleprice=$(\"#id_saleprice\").val();\r\n");
      out.write("\tvar purchasetax=$(\"#id_purchasetax\").val();\r\n");
      out.write("\tvar insuremoney=$(\"#id_insuremoney\").val();\r\n");
      out.write("\tvar leasingmoney=$(\"#id_leasingmoney\").val();\r\n");
      out.write("\tequipnum=equipnum||0;\r\n");
      out.write("\tsaleprice=saleprice||0;\r\n");
      out.write("\tpurchasetax=purchasetax||0;\r\n");
      out.write("\tinsuremoney=insuremoney||0;\r\n");
      out.write("\tleasingmoney=leasingmoney||0;\r\n");
      out.write("\t//Edit by Jason 2013-11-23 为temp添加var 变成局部变量\r\n");
      out.write("\tvar temp=parseFloat(saleprice)*parseFloat(equipnum)+parseFloat(purchasetax)+parseFloat(insuremoney)+parseFloat(leasingmoney);\r\n");
      out.write("\t$(\"#id_nowtotal\").val(temp.toFixed(2));\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write("* 车架号唯一验证，注:同步ajax。Edit by jason 2012-12-24 22:25:00\r\n");
      out.write("*/\r\n");
      out.write("function validateChassisnum(chassisnum){//验证车架号信息\r\n");
      out.write("\tvar returnStatus = true;\r\n");
      out.write("\tvar chassisnumArray = [];\r\n");
      out.write("\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\tvar data = currentTable1.tableData;\r\n");
      out.write("\tfor ( var int = 0; int < data.length; int++) {\r\n");
      out.write("\t\tif(data[int]['chassisnum']){\r\n");
      out.write("\t\t\tfor(var i = 0; i < chassisnumArray.length; i++){//验证当前表单中是否重复\r\n");
      out.write("\t\t\t\tif(data[int]['chassisnum'] === chassisnumArray[i]){\r\n");
      out.write("\t\t\t\t\talert(\"本次租赁物列表中车架号[\"+data[int]['chassisnum']+\"]重复,请查证\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tchassisnumArray.push(String(data[int]['chassisnum']));\r\n");
      out.write("\t\t};\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar chassisnum = chassisnumArray.join(\",\");\r\n");
      out.write("\t//与数据库中对比\r\n");
      out.write("\tif(chassisnum){\r\n");
      out.write("\t\tvar param = {};\r\n");
      out.write("\t\tparam.chassisnum  = chassisnum;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"leasing/validateChassisnum.action\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\tdata : param,\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif( data === 0 || data === '0'){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t} else{\r\n");
      out.write("\t\t\t\t\talert(\"当前车架号与系统中车架号[\"+data+\"]有重复，请查证\");\r\n");
      out.write("\t\t\t\t\treturnStatus = false;\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\treturn returnStatus;\t\r\n");
      out.write("}\t\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\t//dictYesOrNoByCode('id_isAffiliated','isAffiliated',1,'','','require=\"true\" label=\"是否挂靠\"');\r\n");
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    if(('true'!='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isFirstTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')||('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isViewHistoryTask}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')){\r\n");
      out.write("\t    \t//currentIsNeedTools = false;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    var equipclassname=\"\";\r\n");
      out.write("\t    var equiptypename =\"\";\r\n");
      out.write("\t    var modelname     = \"\";\r\n");
      out.write("\t\tvar isaffiliated  =\"\";\r\n");
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_proj_equip_container',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    isAutoHeight:true,\r\n");
      out.write("\t    isShowCopyCount:true,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:false,\r\n");
      out.write("\t    tools:'修改',//|删除\r\n");
      out.write("\t    updateFromOperCallBack:function(operType,thisForm,me,rowData){\r\n");
      out.write("\t    \t if(operType==\"update\"){\r\n");
      out.write("\t\t\t\t  for(var i=0;i<me.comboboxs.length;i++){\r\n");
      out.write("\t\t\t    \t   var combo =me.comboboxs[i];\r\n");
      out.write("\t\t\t    \t   if(combo.otherConfig.name==\"equipclassname\"){\r\n");
      out.write("\t\t\t    \t\t   equipclassname=rowData[\"equipclass\"];//combo.getValue();\r\n");
      out.write("\t\t\t    \t\t   //当车辆类型为挂车时 ’车架号‘和’合同小号‘ 不验证  equip_class_2（挂车）\r\n");
      out.write("\t\t\t    \t\t   if(equipclassname==\"equip_class_2\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t $(\"#id_equipcontractnum\").attr(\"require\",\"false\");\r\n");
      out.write("\t\t\t\t\t\t\t\t $(\"#id_chassisnum\").attr(\"require\",\"false\");\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t     $(\"#id_equipcontractnum\").attr(\"require\",\"true\").attr(\"label\",\"车辆合同小号\");\r\n");
      out.write("\t\t\t\t\t\t\t\t $(\"#id_chassisnum\").attr(\"require\",\"true\").attr(\"label\",\"车架号\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t       }\r\n");
      out.write("\t\t\t    \t   if(combo.otherConfig.name==\"equiptypename\"){\r\n");
      out.write("\t\t\t    \t\t   equiptypename = rowData[\"equiptype\"];\r\n");
      out.write("\t\t\t    \t\t   combo.setParams({equipclass:equipclassname});\r\n");
      out.write("\t\t\t    \t\t   combo.value=equiptypename;\r\n");
      out.write("\t\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t\t       }\r\n");
      out.write("\t\t\t    \t   if(combo.otherConfig.name==\"modelname\"){\r\n");
      out.write("\t\t\t    \t\t   modelname = rowData[\"model\"];\r\n");
      out.write("\t\t\t    \t\t   combo.setParams({equipclass:equipclassname,equiptype:equiptypename});\r\n");
      out.write("\t\t\t    \t\t   combo.value=modelname;\r\n");
      out.write("\t\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t\t       }\r\n");
      out.write("\t\t\t\t\t   if(combo.otherConfig.name==\"isaffiliated\"){\r\n");
      out.write("\t\t\t\t\t   \t\tisaffiliated = rowData[\"isaffiliatedname\"];\r\n");
      out.write("\t\t\t\t\t\t\tvar affiliatedinfo = $(\"#id_affiliatedinfo\");\r\n");
      out.write("\t\t\t\t\t\t\tif(isaffiliated == \"是\"){\r\n");
      out.write("\t\t\t\t\t\t\t\taffiliatedinfo.attr(\"require\",\"true\").attr(\"label\",\"挂靠信息\");\r\n");
      out.write("\t\t\t\t\t\t\t\taffiliatedinfo.show();\r\n");
      out.write("\t\t\t\t\t\t        affiliatedinfo.parent().parent().show();\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\taffiliatedinfo.hide();\r\n");
      out.write("\t\t\t\t\t\t\t\taffiliatedinfo.parent().parent().hide();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t    },\r\n");
      out.write("\t    operValidate:function(operType,rowDatas,thisForm,me){\r\n");
      out.write("\t\t  if(operType==\"add\"){\r\n");
      out.write("\t\t\t  for(var i=0;i<me.comboboxs.length;i++){\r\n");
      out.write("\t\t    \t   var combo =me.comboboxs[i];\r\n");
      out.write("\t\t    \t   if(combo.otherConfig.name==\"equiptypename\"){\r\n");
      out.write("\t\t\t    \t   combo.setParams({equipclass:'1'});\r\n");
      out.write("\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t       }\r\n");
      out.write("\t\t    \t   if(combo.otherConfig.name==\"modelname\"){\r\n");
      out.write("\t\t    \t\t   combo.setParams({equipclass:'1',equiptype:'1'});\r\n");
      out.write("\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t       }\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t  }\r\n");
      out.write("          return true;  \r\n");
      out.write("\t    },\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_proj_equip_str ? \"[]\" : json_proj_equip_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id', header:'id',otherAttributes:'id=\"id_equip\"',hidden:true},\r\n");
      out.write("\t       {name:'projid', header:'projid',hidden:true},\r\n");
      out.write("\t       {name:'equipclassname', header:'车辆分类',type:'combobox',readOnly:true ,hiddenName:'equipclass',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t    \t   //id:'id_combobox_equipclassname',\r\n");
      out.write("\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\proj_approval\\\\equipClassSelect.xml',\r\n");
      out.write("\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t       isForceModify:true,\r\n");
      out.write("\t\t\t\t       otherConfig:{\r\n");
      out.write("\t\t\t\t\t\t\t  name:'equipclassname',\r\n");
      out.write("\t\t\t\t\t\t\t  hiddenName:'equipclass'\r\n");
      out.write("\t\t   \t\t\t   },\r\n");
      out.write("\t\t\t\t       onSelected:function(combo,rowData,me,columnConfig){\r\n");
      out.write("\t    \t   \t\t\t   var equipclassValue  = combo.getValue();\r\n");
      out.write("\t\t\t\t    \t   for(var i=0;i<me.comboboxs.length;i++){\r\n");
      out.write("\t\t\t\t\t    \t   var combo =me.comboboxs[i];\r\n");
      out.write("\t\t\t\t\t    \t  /*  if(combo.otherConfig.name==\"equiptypename\"){\r\n");
      out.write("\t\t\t\t\t\t    \t   combo.setParams({equipclass:equipclassValue});\r\n");
      out.write("\t\t\t\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t\t\t\t       }\r\n");
      out.write("\t\t\t\t\t    \t   if(combo.otherConfig.name==\"modelname\"){\r\n");
      out.write("\t\t\t\t\t    \t\t   combo.setParams({equipclass:'1',equiptype:'1'});\r\n");
      out.write("\t\t\t\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t\t\t\t       } */\r\n");
      out.write("\t\t\t\t\t\t       \r\n");
      out.write("\t\t\t\t\t    \t   if(combo.otherConfig.name==\"modelname\"){\r\n");
      out.write("\t\t\t\t\t    \t\t   combo.setParams({equipclass:equipclassValue});\r\n");
      out.write("\t\t\t\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t\t\t\t    \t   break;\r\n");
      out.write("\t\t\t\t\t\t    \t}\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t       \t\t\t   }\r\n");
      out.write("\t\t   }},\r\n");
      out.write("\t\t   {name:'equipclass', header:'车辆分类id',hidden:true},\r\n");
      out.write("\t\t/*    {name:'equiptypename', header:'车辆类别',type:'combobox',readOnly:true ,hiddenName:'equiptype',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t    \t   //id:'id_combobox_equiptypename',\r\n");
      out.write("\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\proj_approval\\\\equipTypeSelect.xml',\r\n");
      out.write("\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t       isForceModify:true,\r\n");
      out.write("\t\t\t\t       params:{\r\n");
      out.write("\t\t\t   \t\t\t\t//equipclass:'1'\r\n");
      out.write("\t\t   \t\t\t   },\r\n");
      out.write("\t\t   \t\t\t   otherConfig:{\r\n");
      out.write("\t\t\t\t\t\t\t  name:'equiptypename',\r\n");
      out.write("\t\t\t\t\t\t\t  hiddenName:'equiptype'\r\n");
      out.write("\t\t   \t\t\t   },\r\n");
      out.write("\t\t   \t\t\t   onSelected:function(combo,rowData,me,columnConfig){\r\n");
      out.write("\t    \t   \t\t\t   var equipclassValue;\r\n");
      out.write("\t    \t   \t\t\t   var equiptypeValue  = combo.getValue();\r\n");
      out.write("\t\t\t\t    \t   for(var i=0;i<me.comboboxs.length;i++){\r\n");
      out.write("\t\t\t\t\t    \t   var combo =me.comboboxs[i];\r\n");
      out.write("\t\t\t\t\t    \t   if(combo.otherConfig.name==\"equipclassname\"){\r\n");
      out.write("\t\t\t\t\t    \t\t   equipclassValue=combo.getValue();\r\n");
      out.write("\t\t\t\t\t\t    \t   break;\r\n");
      out.write("\t\t\t\t\t\t    \t}\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t\t   if(equipclassValue==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t   alert(\"请先选择车辆分类\");\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t\t   if(equiptypeValue==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t   alert(\"请先选择车辆类别\");\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t\t   for(var i=0;i<me.comboboxs.length;i++){\r\n");
      out.write("\t\t\t\t\t    \t   var combo =me.comboboxs[i];\r\n");
      out.write("\t\t\t\t\t    \t   if(combo.otherConfig.name==\"modelname\"){\r\n");
      out.write("\t\t\t\t\t    \t\t   combo.setParams({equipclass:equipclassValue,equiptype:equiptypeValue});\r\n");
      out.write("\t\t\t\t\t\t    \t   combo.reload();\r\n");
      out.write("\t\t\t\t\t\t    \t   break;\r\n");
      out.write("\t\t\t\t\t\t    \t}\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t       \t\t\t   }\r\n");
      out.write("\t\t   }},\r\n");
      out.write("\t\t   {name:'equiptype', header:'车辆型号id',hidden:true}, */\r\n");
      out.write("\t\t   {name:'modelname', header:'规格型号',type:'combobox',readOnly:true ,hiddenName:'model',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t\t       width:165,\r\n");
      out.write("\t\t\t\t       xmlFileName:'\\\\eleasing\\\\workflow\\\\proj_approval\\\\equipModelSelect.xml',\r\n");
      out.write("\t\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t\t       isForceModify:true,\r\n");
      out.write("\t\t\t\t       otherConfig:{\r\n");
      out.write("\t\t\t\t\t\t\t  name:'modelname',\r\n");
      out.write("\t\t\t\t\t\t\t  hiddenName:'model'\r\n");
      out.write("\t\t   \t\t\t   },\r\n");
      out.write("\t\t\t\t       params:{\r\n");
      out.write("\t\t\t   \t\t\t\t//equipclass:'1',\r\n");
      out.write("\t\t\t   \t\t\t\t//equiptype:'1'\r\n");
      out.write("\t\t   \t\t\t   }\r\n");
      out.write("\t\t   }},\r\n");
      out.write("\t\t   {name:'model',  header:'规格型号',hidden:true},\r\n");
      out.write("\t\t   {name:'equipcontractnum',  header:'车辆合同小号',readOnly:true,otherAttributes:'maxB=\"20\"',otherAttributes:'id=\"id_equipcontractnum\"'},\r\n");
      out.write("\t\t   {name:'chassisnum',  header:'车架号',readOnly:true,otherAttributes:'maxB=\"100\"',otherAttributes:'id=\"id_chassisnum\"' },\r\n");
      out.write("\t\t   {header:'是否提前终止',name:'isadvancestopname',nullable:false,type:'combobox',hiddenName:'isadvancestop' \r\n");
      out.write("\t            ,config:{\r\n");
      out.write("\t\t\t\twidth:165,\r\n");
      out.write("\t\t\t\t//isNewLine:true,\r\n");
      out.write("\t\t\t\t//colSpan:3, \r\n");
      out.write("\t\t\t\tloadMode:'local',\r\n");
      out.write("\t\t\t\tisForceModify:true,\r\n");
      out.write("\t\t\t\tdatas:[{title:'是',name:'0'},{title:'否',name:'1'}],\r\n");
      out.write("\t            displayField:'title',\r\n");
      out.write("\t            valueField:'name',\r\n");
      out.write("\t            defaultValue:1,\r\n");
      out.write("\t            value:'1'\r\n");
      out.write("\t            }\r\n");
      out.write("\t       },\r\n");
      out.write("\t       {name:'isadvancestop', header:'是否提前终止id',hidden:true},\r\n");
      out.write("\t\t   {name:'garagedate',  header:'入库时间',type:'date',readOnly:true},\r\n");
      out.write("\t\t   {name:'saledate',  header:'已售时间',type:'date',readOnly:true},\r\n");
      out.write("\t\t   {name:'equipnum',  header:'数量',type:'number',readOnly:true,hidden:true,defaultValue:1,otherAttributes:'id=\"id_equipnum\" onkeyup=\"AdjustTotal()\"'},\r\n");
      out.write("\t\t   {name:'saleprice',  header:'销售价',type:'double',readOnly:true ,otherAttributes:'id=\"id_saleprice\" onkeyup=\"AdjustTotal()\" onkeyup=\"AdjustMoney()\"'},\r\n");
      out.write("\t\t   {name:'purchaseprice',  header:'采购价',type:'double',readOnly:true ,otherAttributes:'id=\"id_purchaseprice\" onkeyup=\"AdjustMoney()\"'}, \r\n");
      out.write("\t\t   {name:'differential_swap',  header:'差额[销售价-采购价]',type:'double',readOnly:true ,otherAttributes:'id=\"id_differential_swap\"',readOnly:true,width:160},\r\n");
      out.write("\t\t   {name:'purchasetax',  header:'购置税',hidden:true,type:'double',defaultValue:'0',otherAttributes:'id=\"id_purchasetax\" onkeyup=\"AdjustTotal()\"'},\r\n");
      out.write("\t\t   {name:'insuremoney',  header:'保费',hidden:true,type:'double',defaultValue:'0',otherAttributes:'id=\"id_insuremoney\" onkeyup=\"AdjustTotal()\"'},\r\n");
      out.write("\t\t   {name:'leasingmoney',  header:'其他融资额',readOnly:true,hidden:true,type:'double',defaultValue:'0',otherAttributes:'id=\"id_leasingmoney\" onkeyup=\"AdjustTotal()\"'},\r\n");
      out.write("\t       {name:'devicetypename',  header:'设备类型',readOnly:true,type:'combobox',defaultRawValue:'' ,hiddenName:'devicetype',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t       width:165,\r\n");
      out.write("\t\t\t       xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t       isForceModify:true,\r\n");
      out.write("\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t       valueField:'code',\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t\t\t          pid:'device_type'\r\n");
      out.write("\t\t\t       } \r\n");
      out.write("\t\t\t}},\r\n");
      out.write("\t\t\t{name:'devicetype', header:'设备类型id',hidden:true},\r\n");
      out.write("\t       {name:'nowtotal',  header:'总计',readOnly:true ,otherAttributes:'id=\"id_nowtotal\"',readOnly:true,width:130,type:'double'},\r\n");
      out.write("\t       {name:'manufacturername',readOnly:true,  header:'制造商',type:'combobox' ,hiddenName:'manufacturer',\r\n");
      out.write("\t\t\t    config:{\r\n");
      out.write("\t\t\t       width:165,\r\n");
      out.write("\t\t\t       xmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\SimpleCustSelectForManufacturer.xml',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:false,\r\n");
      out.write("\t\t\t       isAjaxLenovo:true,\r\n");
      out.write("\t\t\t       displayField:'name',\r\n");
      out.write("\t\t\t       valueField:'id',\r\n");
      out.write("\t\t\t       isForceModify:true,\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t\t\t    \t    cust_class_m:\"1\",\r\n");
      out.write("\t\t\t   \t\t\tcust_class1:'CUST_INFO_COMPANY',\r\n");
      out.write("\t\t\t   \t\t\tcust_class2:'CUST_INFO_PERSON',\r\n");
      out.write("\t\t\t  \t\t\tcust_type:'cust_type.manufacturer',\r\n");
      out.write("\t\t\t  \t\t\tcust_dealer_id:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope['currentDealerCustInfoId']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t       } \r\n");
      out.write("  \t\t\t}},\r\n");
      out.write("  \t\t\t{header:'是否挂靠',readOnly:true,name:'isaffiliatedname',type:'combobox',hiddenName:'isaffiliated',otherAttributes:'id=\"id_isaffiliated\"',\r\n");
      out.write("\t            config:{\r\n");
      out.write("  \t\t\t\twidth:165,\r\n");
      out.write("\t\t\t\tisNewLine:true,\r\n");
      out.write("\t\t\t\tisForceModify:true,\r\n");
      out.write("\t\t\t\tcolSpan:3, \r\n");
      out.write("\t\t\t\tloadMode:'local',\r\n");
      out.write("\t\t\t\tdatas:[{title:'是',name:'0'},{title:'否',name:'1'}],\r\n");
      out.write("\t            displayField:'title',\r\n");
      out.write("\t            valueField:'name',\r\n");
      out.write("\t            defaultValue:1,\r\n");
      out.write("\t            value:'1',\r\n");
      out.write("\t            \r\n");
      out.write("\t            onSelected:function(combo,rowData,me,columnConfig){\r\n");
      out.write(" \t   \t\t\t   var isAffiliated;\r\n");
      out.write(" \t   \t\t\t   var isAffiliated  = combo.getValue();\r\n");
      out.write("\t\t\t\t   if(isAffiliated=='1'){\r\n");
      out.write("\t\t\t\t\t\t$(\"#id_affiliatedinfo\").hide();\r\n");
      out.write("\t\t\t\t\t\t$(\"#id_affiliatedinfo\").parent().parent().hide();\r\n");
      out.write("\t\t\t\t\t\t$(\"#id_affiliatedinfo\").attr(\"require\",\"false\").attr(\"sytle\",\"display:none\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t   }else{\r\n");
      out.write("\t\t\t\t\t    $(\"#id_affiliatedinfo\").show();\r\n");
      out.write("\t\t\t\t\t\t$(\"#id_affiliatedinfo\").parent().parent().show();\r\n");
      out.write("\t\t\t\t\t\t$(\"#id_affiliatedinfo\").attr(\"require\",\"true\").attr(\"label\",\"挂靠信息\").attr(\"style\",\"display:inline\");\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("  \t\t\t\t},\r\n");
      out.write("\t  \t\t\totherConfig:{name:'isaffiliated'}\r\n");
      out.write("\t            }\r\n");
      out.write("\t           \r\n");
      out.write("            },\r\n");
      out.write("           {name:'isaffiliated', header:'是否挂靠id',hidden:true},\r\n");
      out.write("  \t\t   {name:'affiliatedinfo',readOnly:true, header:\"挂靠单位及法人信息\",type:'textarea',otherAttributes:'maxB=\"2000\" id=\"id_affiliatedinfo\"'},\r\n");
      out.write("  \t\t   {name:'manufacturer', header:'制造商id',readOnly:true,hidden:true},    \r\n");
      out.write("\t       {name:'equipdeliveryplace',readOnly:true,  header:'交付地点' ,otherAttributes:'maxB=\"2000\"'},\r\n");
      out.write("\t       {name:'equipdeliverydate',readOnly:true,  header:'预计交付时间',type:'date' },\r\n");
      out.write("\t       {name:'cenote', header:'备注',type:'textarea',otherAttributes:'maxB=\"2000\"'}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t });\r\n");
      out.write("});\r\n");
      out.write("\t\t\r\n");
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
