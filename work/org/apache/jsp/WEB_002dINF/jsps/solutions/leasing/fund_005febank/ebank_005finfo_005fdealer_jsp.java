package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.fund_005febank;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class ebank_005finfo_005fdealer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/permission.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode != null) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>租前业务  - 网银信息 - 经销商垫付</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/dtree/dtree.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/easyui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/button.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/workFlowUtil.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<!--javascript libray-->\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAttachmentFileUpload.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyJsonUtil.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyTable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyComboBox.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindySerializeFormToJsonObject.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/validator.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyOperationTable.js\"></script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{ overflow:hidden;}\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/**\r\n");
      out.write(" * \r\n");
      out.write(" @Author chennes\r\n");
      out.write("  操作权限判断\r\n");
      out.write("  修改权限：租后管理、业务企划、财务部\r\n");
      out.write("  网银上传：财务部\r\n");
      out.write("  模板下载：财务部\r\n");
      out.write("  废弃：          财务部\r\n");
      out.write(" */\r\n");
      out.write("//#########操作权限#############\r\n");
      out.write("var ebank_update = false;\r\n");
      out.write("var ebank_upload = false ;\r\n");
      out.write("var ebank_download = false;\r\n");
      out.write("var ebank_remove = false;\r\n");
      if (_jspx_meth_permission_005faction_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("/* ");
      if (_jspx_meth_permission_005faction_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_permission_005faction_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("*/\r\n");
      out.write("/* ");
      if (_jspx_meth_permission_005faction_005f3(_jspx_page_context))
        return;
      out.write("  */\r\n");
      out.write("//########操作权限##############\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("var combo_cust = new tracywindyComboBox({\r\n");
      out.write("\tlazyLoad:true,\r\n");
      out.write("    id:'id_combo_cust',\r\n");
      out.write("    width:300,\r\n");
      out.write("    renderTo:'id_cust_name',\r\n");
      out.write("    xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\comboSimpleCustSelect.xml',\r\n");
      out.write("    loadMode:'ajax',\r\n");
      out.write("    readOnly:false,\r\n");
      out.write("    readOnlyData:true,\r\n");
      out.write("    isAjaxLenovo:true,\r\n");
      out.write("    isContainEmpty:false,\r\n");
      out.write("    dropListHeight:300,\r\n");
      out.write("    topAdd:0,\r\n");
      out.write("    leftAdd:0,\r\n");
      out.write("    positionDropIconLeftAdd:-1,\r\n");
      out.write("    name:'custid',\r\n");
      out.write("    displayField:'nameandcode',\r\n");
      out.write("    valueField:'value',\r\n");
      out.write("    \r\n");
      out.write("    onSelect:function(combo){\r\n");
      out.write("   }\r\n");
      out.write(" });\r\n");
      out.write("var combo_ebank = new tracywindyComboBox({\r\n");
      out.write("\tlazyLoad:true,\r\n");
      out.write("    id:'id_combo_ownbank',\r\n");
      out.write("    width:300,\r\n");
      out.write("    renderTo:'id_ownbank',\r\n");
      out.write("    readOnlyData:true,\r\n");
      out.write("    xmlFileName:'\\\\eleasing\\\\jsp\\\\own_manage\\\\ownaccountinfo.xml',\r\n");
      out.write("    loadMode:'ajax',\r\n");
      out.write("    readOnly:false,\r\n");
      out.write("    //isAjaxLenovo:true,\r\n");
      out.write("    isContainEmpty:false,\r\n");
      out.write("    dropListHeight:300,\r\n");
      out.write("    topAdd:0,\r\n");
      out.write("    leftAdd:0,\r\n");
      out.write("    positionDropIconLeftAdd:-1,\r\n");
      out.write("    name:'ownbank',\r\n");
      out.write("    displayField:'accbank',\r\n");
      out.write("    valueField:'accbank',\r\n");
      out.write("    otherAttributes :'label=\"本方银行\"', \r\n");
      out.write("    onSelect:function(combo,cdata){\r\n");
      out.write("      $(\"#id_ownaccount\").val(cdata.accname);\r\n");
      out.write("      $(\"#id_ownaccnumber\").val(cdata.accnumber);\r\n");
      out.write("   }\r\n");
      out.write(" });\r\n");
      out.write(" dictYesOrNoByCode('id_fund_ebank_status','enabled',null,null,null,'\" label=\"是否有效\"', null, true);//是否草稿\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("var importcolumn= [\r\n");
      out.write("                   {header:'id',mapping:'id'},\r\n");
      out.write("                   {header:'流水号',mapping:'sn'},\r\n");
      out.write("                   {header:'到账金额',mapping:'factmoney'},\r\n");
      out.write("\t  \t\t         {header:'与系统无关金额',mapping:'nowithmoney'},\r\n");
      out.write("\t  \t\t         {header:'到账时间',mapping:'factdate'},\r\n");
      out.write("\t  \t\t         {header:'到账金额类型',mapping:'moneytype'},\r\n");
      out.write("\t\t             {header:'付款人',mapping:'clientname'},\r\n");
      out.write("\t\t             //{header:'本方银行',mapping:'ownbank'},\r\n");
      out.write("\t\t             //{header:'本方账户',mapping:'ownaccount'},\r\n");
      out.write("\t\t             {header:'本方账号',mapping:'ownaccnumber'},\r\n");
      out.write("\t\t             //{header:'对方银行',mapping:'clientbank'},\r\n");
      out.write("\t\t             //{header:'对方账户',mapping:'clientaccount'},\r\n");
      out.write("\t\t             {header:'对方账号',mapping:'clientaccnumber'},\r\n");
      out.write("\t\t             {header:'用途',mapping:'usefor'},\r\n");
      out.write("\t\t             {header:'备注1',mapping:'summary',hidden:true},\r\n");
      out.write("\t\t             {header:'备注2',mapping:'summary1',hidden:true}\r\n");
      out.write("\t\t             //{header:'是否启用',mapping:'enabled'}\r\n");
      out.write("\t        ];\r\n");
      out.write("  function checkCancel(){\r\n");
      out.write("    var select_enabled = getTracywindyObject(\"id_combo_id_fund_ebank_status\");\r\n");
      out.write("\tif(select_enabled.getValue()==\"1\"){\r\n");
      out.write("      var owmoney=$(\"#id_hiremoney\").val();\r\n");
      out.write("      if(parseFloat(owmoney)>0){\r\n");
      out.write("        alert(\"本网银已经核销过不能撤销\");\r\n");
      out.write("        select_enabled.setValue(0);\r\n");
      out.write("\t\tselect_enabled.setRawValue(\"是\");\r\n");
      out.write("      }\r\n");
      out.write("\t}\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("    function importEbankCallBack(message){\r\n");
      out.write("    \twindow.currentImportExcelLoadMask.hide();\r\n");
      out.write("    \tvar table = getTracywindyObject(\"id_table\");\r\n");
      out.write("    \ttable.reload();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function cancelFundEbank(table){\r\n");
      out.write("    \tvar plandata = table.getCheckedRowDatas();\r\n");
      out.write("    \tvar ids=\"\";\r\n");
      out.write("    \tfor(var i=0;i<plandata.length;i++){\r\n");
      out.write("           var factmoney=plandata[i].factmoney;\r\n");
      out.write("           var nowithmoney=plandata[i].nowithmoney;\r\n");
      out.write("           var owmoney=plandata[i].owmoney;\r\n");
      out.write("           var allmoney=parseFloat(factmoney)-parseFloat(nowithmoney);\r\n");
      out.write("           allmoney=allmoney.toFixed(2);\r\n");
      out.write("           /*if(parseFloat(allmoney)!=parseFloat(owmoney)){\r\n");
      out.write("                alert(\"网银编号为\"+plandata[i].ebdataid+\"已经核销过，请联系管理员\");\r\n");
      out.write("                return false;\r\n");
      out.write("          }else{*/\r\n");
      out.write("              if(ids!=\"\"){ids=ids+\",\";}\r\n");
      out.write("              ids=ids+plandata[i].id;\r\n");
      out.write("          //} \r\n");
      out.write("       }\r\n");
      out.write("    \tvar params = {ebank_id:ids};\r\n");
      out.write("\t\tparams['enable_flag'] = '92';\r\n");
      out.write("    \tajaxRequest({\r\n");
      out.write("\t\t     url:getRootPath()+\"/leasing/acl/custEbankEnabled.action\",\r\n");
      out.write("\t\t     method:'POST',\r\n");
      out.write("\t\t     success:function(res){\r\n");
      out.write("\t\t        alert(\"操作成功\");\r\n");
      out.write("\t\t        var table = getTracywindyObject(\"id_table\");\r\n");
      out.write("\t\t    \ttable.reload();\r\n");
      out.write("    \t     },\r\n");
      out.write("\t\t     async:false,\r\n");
      out.write("\t\t     failure:function(res){},\r\n");
      out.write("\t\t     params:params\r\n");
      out.write("\t   }); \r\n");
      out.write("    }\r\n");
      out.write("    var tools = [];\r\n");
      out.write("/*    \r\n");
      out.write("\tif(ebank_upload){\r\n");
      out.write("\t\ttools.push({\r\n");
      out.write("    \t    iconCls:'icon-import',\r\n");
      out.write("    \t    html:'<font color=\"red\">网银上传</font>',\r\n");
      out.write("    \t    handler:function(table){\r\n");
      out.write("    \t    \tattachmentUp({url:\"/leasing/template/uploadExcelToDatabase.action\",targetClass:'com.business.entity.asset.FundEbankData',custoperatorMethod:'checkEbankInfoDataImport',modelname:'ebankinfo',title:'网银上传',parames:importcolumn});\r\n");
      out.write("    \t   }\r\n");
      out.write("    \t });\r\n");
      out.write("    } \r\n");
      out.write("    if(ebank_download){\r\n");
      out.write("    \ttools.push({\r\n");
      out.write("    \t    iconCls:'icon-import',\r\n");
      out.write("    \t    html:'<font color=\"red\">模板下载</font>',\r\n");
      out.write("    \t    handler:function(table){\r\n");
      out.write("    \t       attachmentDown({url:'/leasing/template/downloadFileTemplateByClasses.action',returnType:'file','twoClassify':'wordtempletypetwo10'});\r\n");
      out.write("    \t   }});\r\n");
      out.write("    }\r\n");
      out.write("    */\r\n");
      out.write("\t\ttools.push({\r\n");
      out.write("    \t    iconCls:'icon-import',\r\n");
      out.write("    \t    html:'<font color=\"red\">启用</font>',\r\n");
      out.write("    \t    handler:function(table){\r\n");
      out.write("    \t    \tcancelFundEbank(table);\r\n");
      out.write("    \t   }\r\n");
      out.write("    \t });\r\n");
      out.write("     \r\n");
      out.write("    \r\n");
      out.write("    var constantFlagTable = \"User\";\r\n");
      out.write("    var ebankUploadUrl=\"\";\r\n");
      out.write("    var ebankAttachUrl=\"\";\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var tableebank = new tracywindyOperationTable({\r\n");
      out.write("   \t\tresetFormCallback:function(table, $form, operFlag){\r\n");
      out.write("   \t\t if(\"add\" == operFlag){\r\n");
      out.write("   \t\t\tvar rowData = table.getRowDataAt(rowIndex);\r\n");
      out.write("   \t      }\r\n");
      out.write("     \t},\r\n");
      out.write("   \t    beforeShowWindowCallBack:function(table, $form, operFlag){\r\n");
      out.write("       \t      if(\"update\" == operFlag) {\r\n");
      out.write("       \t    \tvar rowData = table.getCheckedRowDatas();\r\n");
      out.write("       \t    \t//可核销金额\r\n");
      out.write("       \t    \tvar hiremoney = rowData[0].hiremoney;\r\n");
      out.write("       \t\t\t//流程中占用金额\r\n");
      out.write("       \t\t\tvar fundpmoney = rowData[0].fundpmoney;\r\n");
      out.write("       \t\t\t\r\n");
      out.write("       \t    \tif(hiremoney!=\"\"||fundpmoney!=\"\")\r\n");
      out.write("     \t  \t    \tif(parseInt(hiremoney)>0||parseInt(fundpmoney)>0){\r\n");
      out.write("     \t\t\t\t\t//alert(\"该网银正在使用不能修改！\");\r\n");
      out.write("     \t\t\t\t\treturn true;\r\n");
      out.write("     \t  \t    \t}else{\r\n");
      out.write("\t\t\t\t\t\treturn true;\r\n");
      out.write("     \t  \t    \t}\r\n");
      out.write("     \t  \t    }\r\n");
      out.write("          \t}\r\n");
      out.write("    \t,\r\n");
      out.write("   \t  loadFormDataCallBack:function(table,$form,rowIndex){\r\n");
      out.write("     \t\t var rowData = table.getRowDataAt(rowIndex);\r\n");
      out.write("     \t\t var select_contract = getTracywindyObject(\"id_combo_cust\");\r\n");
      out.write("     \t\t var befor_fund_ebank_status = jQuery(\"#id_befor_fund_ebank_status\");\r\n");
      out.write("     \t\t var befor_cust_id = jQuery(\"#id_befor_cust_id\");\r\n");
      out.write("     \t\t var befor_nowithmoney = $(\"#id_befor_nowithmoney\");\r\n");
      out.write("     \t\t if(rowData[\"custid\"]){\r\n");
      out.write("    \t        select_contract.setValue(rowData[\"custid\"]);\r\n");
      out.write("    \t        //1.设置修改前的客户编号\r\n");
      out.write("    \t        befor_cust_id.val(rowData[\"custid\"]);\r\n");
      out.write("     \t\t }\r\n");
      out.write("    \t\t if(rowData[\"nowithmoney\"]){\r\n");
      out.write("     \t        //2.设置修改前与系统无关金额\r\n");
      out.write("     \t        befor_nowithmoney.val(rowData[\"nowithmoney\"]);\r\n");
      out.write("      \t\t }\r\n");
      out.write("     \t\t var select_ebank = getTracywindyObject(\"id_combo_ownbank\");\r\n");
      out.write("     \t\t \r\n");
      out.write("     \t\t if(rowData[\"ownbank\"]){\r\n");
      out.write("     \t\t\tselect_ebank.setValue(rowData[\"ownbank\"]);\r\n");
      out.write("     \t\t\tselect_ebank.setRawValue(rowData[\"ownbank\"]);\r\n");
      out.write("     \t\t }\r\n");
      out.write("     \t\tvar select_enabled = getTracywindyObject(\"id_combo_id_fund_ebank_status\");\r\n");
      out.write("    \t\t if(rowData[\"enabled\"]){\r\n");
      out.write("    \t\t\t //select_enabled.setValue(rowData[\"enabled\"]);\r\n");
      out.write("    \t\t\t//var str=\"\";\r\n");
      out.write("    \t\t\t//if(rowData[\"enabled\"]==\"0\"){str=\"是\";}else{str=\"否\";}\r\n");
      out.write("    \t\t\t//select_enabled.setRawValue(str);\r\n");
      out.write("    \t\t\t//3.设置修改前的是否有效\r\n");
      out.write("    \t\t\tbefor_fund_ebank_status.val(rowData[\"enabled\"]);\r\n");
      out.write("    \t    }   \r\n");
      out.write("         },\r\n");
      out.write("   \t\t tableComment:'[网银其他信息]',\r\n");
      out.write("   \t\t constantFlagTable:'fundebank',\r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'网银信息',\r\n");
      out.write("         width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("         height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/fund_ebank/fund_ebank_info.xml',\r\n");
      out.write("         operButtons:\"修改\", \r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         checkType:'checkbox',\r\n");
      out.write("         isExcel:true,\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         validateFrom:function(table,sfrom){\r\n");
      out.write("              var nowithmoney=$(\"#id_nowithmoney\").val();\r\n");
      out.write("              var factmoney=$(\"#id_factmoney\").val();\r\n");
      out.write("              var hirmoney=$(\"#id_hiremoney\").val();\r\n");
      out.write("              var owmoney=parseFloat(factmoney)-parseFloat(hirmoney);\r\n");
      out.write("              owmoney=owmoney.toFixed(2);\r\n");
      out.write("              if(parseFloat(nowithmoney)>parseFloat(owmoney)){\r\n");
      out.write("                  alert(\"与系统无关金额大于网银余额\");\r\n");
      out.write("                return false;\r\n");
      out.write("              }\r\n");
      out.write("             return true;\r\n");
      out.write("         },\r\n");
      out.write("         emptyChar:\"\",\r\n");
      out.write("         tools:tools,\r\n");
      out.write("         isFit:true,\r\n");
      out.write("         params:{\r\n");
      out.write("        \t enabled:111,owmoneythanzero:0\r\n");
      out.write("\t\t },\r\n");
      out.write("         columns:[\r\n");
      out.write("                    {header:'id',name:'id',hidden:true},\r\n");
      out.write("\t\t            {header:'网银编号',name:'ebdataid',queryConfig:{}},\r\n");
      out.write("\t\t            //{header:'是否有效',name:'enabledname'},\r\n");
      out.write("\t\t            /*{header:'经销商/客户',name:'custname',type:'combobox',queryConfig:{\r\n");
      out.write("\t\t            \t  xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\comboSimpleCustSelect.xml',\r\n");
      out.write("\t\t\t \t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t \t\t       isAjaxLenovo:false,    \r\n");
      out.write("\t\t\t \t\t       readOnly:false,\r\n");
      out.write("\t\t\t \t\t       width:200,\r\n");
      out.write("\t\t\t \t\t       name:'name',\r\n");
      out.write("\t\t\t \t\t       displayField:'name',\r\n");
      out.write("\t\t\t \t\t       valueField:'name'\r\n");
      out.write("\t\t\t            }},*/\r\n");
      out.write("\t\t\t        {header:'经销商/客户',name:'custname',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'付款人',name:'clientname',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'本方银行',name:'ownbank',hidden:true},\r\n");
      out.write("\t\t            {header:'本方账户',name:'ownaccount',hidden:true},\r\n");
      out.write("\t\t            {header:'本方账号',name:'ownaccnumber',hidden:true},\r\n");
      out.write("\t\t            {header:'对方银行',name:'clientbank',hidden:true},\r\n");
      out.write("\t\t            {header:'对方账户',name:'clientaccount',hidden:true},\r\n");
      out.write("\t\t            {header:'对方账号',name:'clientaccnumber',hidden:true},\r\n");
      out.write("\t\t            {header:'到账金额类型',name:'moneytype',hidden:true},\r\n");
      out.write("\t\t            {header:'到账金额',name:'factmoney',type:\"double\",queryConfig:{isNewLine:true}},\r\n");
      out.write("\t\t            {header:'与系统无关金额',name:'nowithmoney',type:\"double\"},\r\n");
      out.write("\t\t            {header:'核销过程中金额',name:'fundpmoney',type:\"double\"},\r\n");
      out.write("\t\t            {header:'已核销金额',name:'hiremoney',type:\"double\"},\r\n");
      out.write("\t\t            {header:'剩余金额',name:'owmoney',type:\"double\"},\r\n");
      out.write("\t\t            {header:'到账时间',name:'factdate',type:\"date\",isRange:true,queryConfig:{}},\r\n");
      out.write("\t\t            {header:'流水号',name:'sn',queryConfig:{}},\r\n");
      out.write("\t\t            {header:'用途',name:'usefor'},\r\n");
      out.write("\t\t            {header:'备注1',name:'summary'},\r\n");
      out.write("\t\t            {header:'区域',name:'qyu'},\r\n");
      out.write("\t\t            {header:'登记人',name:'creator_name'},\r\n");
      out.write("\t\t            {header:'登记时间',name:'create_date'}\r\n");
      out.write("\t        ]\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("\t\r\n");
      out.write("\tfunction tableSubmitCallback(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar cust = getTracywindyObject('id_combo_cust').getValue();\r\n");
      out.write("\t\tif(cust){\r\n");
      out.write("\t\t\tgetTracywindyObject(\"id_table\").operationTable();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert (\"请选择用户\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"id_tableContainer\"></div>\r\n");
      out.write("\t<div id=\"id_detailInfoWindowContainer\"  closed=\"true\" modal=\"true\" title=\"网银信息\" style=\"display:none;width:800px;height:900px;padding-top:10px;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t        <form id=\"id_detailInfoForm\">\r\n");
      out.write("\t\t\t        <table style=\"width:90%\" class=\"fillTable\">\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"id\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            \r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t\t            <td class=\"td-content-title\" >流水号:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t     <input name=\"ebdataid\"  class=\"td-content-input\" type=\"hidden\" />\r\n");
      out.write("\t\t\t            \t\t <input name=\"sn\" require=\"true\" label=\"流水号\"   class=\"td-content-input td-content-readonly\" readOnly=true type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">是否有效</td>\r\n");
      out.write("\t\t\t            \t<td  class=\"td-content\">\r\n");
      out.write("\t\t\t            \t  <div id=\"id_fund_ebank_status\" style=\"float:left;\"></div>\r\n");
      out.write("\t\t\t            \t  <input type=\"hidden\" id=\"id_befor_fund_ebank_status\" name=\"befor_fund_ebank_status\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t                <td class=\"td-content-title\">经销商/客户:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t    <div id=\"id_cust_name\" style=\"float:left;\"></div>\r\n");
      out.write("\t\t\t            \t    <input type=\"hidden\" id=\"id_befor_cust_id\" name=\"befor_cust_id\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">付款人:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"clientname\" class=\"td-content-input td-content-readonly\"  readOnly label=\"付款人\"  type=\"text\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">本方银行:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t   <div id=\"id_ownbank\" style=\"float:left;\"></div>\r\n");
      out.write("\t\t\t            \t\t<!--  <input name=\"ownbank\" class=\"td-content-input\"    type=\"text\" />-->\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">对方银行:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t<input name=\"clientbank\" class=\"td-content-input td-content-readonly\" readOnly  label=\"对方银行\"  type=\"text\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("      \t\t\t\t   \t    \r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">本方账户:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"ownaccount\" id=\"id_ownaccount\"  require=\"true\"  class=\"td-content-input td-content-readonly\" label=\"本方账户\"  readOnly type=\"text\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">对方账户:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t   <input name=\"clientaccount\"  class=\"td-content-input td-content-readonly\" readOnly  label=\"对方账户\" readOnly type=\"text\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t             <tr  class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">本方账号:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"ownaccnumber\"  id=\"id_ownaccnumber\" require=\"true\" class=\"td-content-input td-content-readonly\" readOnly label=\"本方账号\"  type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">对方账号:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t                 \t<input name=\"clientaccnumber\" class=\"td-content-input td-content-readonly\"  readOnly label=\"对方账号\"  type=\"text\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">到账金额类型:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"moneytype\" require=\"true\"  class=\"td-content-input td-content-readonly\" readOnly label=\"到账金额类型\"   type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">到账金额:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"factmoney\" id=\"id_factmoney\" require=\"true\" class=\"td-content-input td-content-readonly\"  readOnly label=\"到账金额\" dataType=\"Money\"  type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t\t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">网银余额</td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t    <input id=\"id_owmoney\"  name=\"owmoney\" class=\"td-content-input td-content-readonly\" readOnly label=\"网银余额\" dataType=\"Money\"  type=\"text\" />\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">已核销金额:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input  id=\"id_hiremoney\" name=\"hiremoney\" require=\"true\" class=\"td-content-input td-content-readonly\"  readOnly label=\"已核销金额\" dataType=\"Money\"  type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t               <td class=\"td-content-title\">到账时间:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t                 <input name=\"factdate\" class=\"td-content-input td-content-readonly\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['factdate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readOnly require=\"true\" label=\"到账时间\" /><font class=\"required-content\">*</font>\r\n");
      out.write("          \t            \t</td>\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">与系统无关金额:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\">\r\n");
      out.write("\t\t\t            \t\t<input name=\"nowithmoney\" id=\"id_nowithmoney\" class=\"td-content-input\" require=\"true\" label=\"与系统无关金额\" dataType=\"Money\"  value=\"0.00\" type=\"text\" /><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t\t<input type=\"hidden\" id=\"id_befor_nowithmoney\" name=\"befor_nowithmoney\"></input>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t               <tr  class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t\t            \t\r\n");
      out.write("\t\t\t            \t<td></td><td></td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t               <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">用途:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\" colspan=\"3\">\r\n");
      out.write("\t\t\t            \t\t<textarea name=\"usefor\"   class=\"td-content-input td-content-readonly\" readOnly style=\"width:80%\" label=\"用途\"   type=\"text\" ></textarea><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>   \r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t               <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">备注1:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\" colspan=\"3\">\r\n");
      out.write("\t\t\t            \t\t<textarea name=\"summary\"   class=\"td-content-input td-content-readonly\" readOnly style=\"width:80%\" label=\"备注1\"   type=\"text\" ></textarea><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>   \r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t               <tr  class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t\t            \t<td class=\"td-content-title\">备注2:  </td>  \r\n");
      out.write("\t\t\t            \t<td class=\"td-content\" colspan=\"3\">\r\n");
      out.write("\t\t\t            \t\t<textarea name=\"summarybak\"   class=\"td-content-input td-content-readonly\" readOnly style=\"width:80%\" label=\"备注2\"   type=\"text\" ></textarea><font class=\"required-content\">*</font>\r\n");
      out.write("\t\t\t            \t</td>\r\n");
      out.write("\t\t\t            </tr>   \r\n");
      out.write("\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t            <td colspan='4'>\r\n");
      out.write("\t\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='tableSubmitCallback();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_detailInfoWindowContainer\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t            </td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t        </table>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_permission_005faction_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f0 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f0.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/fund_ebank/ebank_info_dealer.jsp(50,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f0.setCode("ebank_update");
    int _jspx_eval_permission_005faction_005f0 = _jspx_th_permission_005faction_005f0.doStartTag();
    if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\tebank_update=true;\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f0);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f1 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f1.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/fund_ebank/ebank_info_dealer.jsp(53,3) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f1.setCode("ebank_upload");
    int _jspx_eval_permission_005faction_005f1 = _jspx_th_permission_005faction_005f1.doStartTag();
    if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\tebank_upload=true;\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f1);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f2 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f2.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/fund_ebank/ebank_info_dealer.jsp(56,0) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f2.setCode("ebank_download");
    int _jspx_eval_permission_005faction_005f2 = _jspx_th_permission_005faction_005f2.doStartTag();
    if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\tebank_download=true;\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f2);
    return false;
  }

  private boolean _jspx_meth_permission_005faction_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  permission:action
    com.kernal.tags.ActionPermissionTag _jspx_th_permission_005faction_005f3 = (com.kernal.tags.ActionPermissionTag) _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.get(com.kernal.tags.ActionPermissionTag.class);
    _jspx_th_permission_005faction_005f3.setPageContext(_jspx_page_context);
    _jspx_th_permission_005faction_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/leasing/fund_ebank/ebank_info_dealer.jsp(60,3) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_permission_005faction_005f3.setCode("ebank_remove");
    int _jspx_eval_permission_005faction_005f3 = _jspx_th_permission_005faction_005f3.doStartTag();
    if (_jspx_eval_permission_005faction_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_permission_005faction_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_permission_005faction_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_permission_005faction_005f3.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\tebank_remove=true;\r\n");
        int evalDoAfterBody = _jspx_th_permission_005faction_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_permission_005faction_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_permission_005faction_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fpermission_005faction_0026_005fcode.reuse(_jspx_th_permission_005faction_005f3);
    return false;
  }
}
