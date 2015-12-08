package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005ffinish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reg_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tfunction validataTotalMoney() {//验证金额，add by Jason ###蔡雅超8-15改\r\n");
      out.write("\t\tif (chenckCondiotn) {\r\n");
      out.write("\t\t\t//计算租赁物的总交易价格\r\n");
      out.write("\t\t\tvar currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');\r\n");
      out.write("\t\t\tvar data = currentTable1.tableData;\r\n");
      out.write("\t\t\tvar totalPrice = 0;\r\n");
      out.write("\t\t\tfor ( var i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t\t\ttotalPrice += parseFloat(data[i]['nowtotal']);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//计算商务条件的设备款\r\n");
      out.write("\t\t\tvar equipAmt = parseFloat($(\"#equipAmt\").val());\r\n");
      out.write("\t\t\tif (totalPrice != equipAmt) {//如果不相等，则跳出执行\r\n");
      out.write("\t\t\t\talert(\"【租赁物明细】标签的合计总价[\" + totalPrice + \"]和【拟商务条件】标签中的设备款[\" + equipAmt + \"]不相等,请检查.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"您修改过商务条件中的值且未进行过测算!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
      out.write("function AdjustTotal(){//算出总价---总计[销售价+购置税+保费+其他融资额]\r\n");
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
      out.write("var nominalPrice = $(\"#nominalPrice\");\r\n");
      out.write("var liugoujiasum = 0;\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\t    var currentIsNeedTools = true;\r\n");
      out.write("\t    new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'id_table_leasing_doc_send_info',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    isAutoHeight:true,\r\n");
      out.write("\t    isShowCopyCount:true,\r\n");
      out.write("\t    isNeedTools:currentIsNeedTools,\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    tools:'修改',\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_reg_list_str ? \"[]\" : json_reg_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t         \t   {name:'id',  header:'id',hidden:true},\r\n");
      out.write("\t   \t       {name:'docnumber',  header:'docnumber',hidden:true},\r\n");
      out.write("\t  \t       {name:'contractid',  header:'contractid',hidden:true},\r\n");
      out.write("\t  \t       {name:'docname',  header:'docname',hidden:true},\r\n");
      out.write("\t  \t       {name:'rowvalue_docname', header:'合同档案名称'},\r\n");
      out.write("\t  \t       {name:'rowvalue_doc', header:'合同档案名称code',hidden:true},\r\n");
      out.write("\t  \t       {name:'contractperson', width:70,  header:'合同对方'},\r\n");
      out.write("\t  \t       //{name:'totalprice', width:102,  header:'合同金额'},\r\n");
      out.write("\t  \t       {name:'docpart', width:70, header:'合同份数'},\r\n");
      out.write("\t  \t       {name:'contracta', width:120, header:'我方签约人'},\r\n");
      out.write("\t  \t       {name:'contractb', header:'对方签约人'},\r\n");
      out.write("\t  \t       {name:'sendpart',  header:'寄送份数',width:50},\r\n");
      out.write("\t  \t       {name:'sendno',  header:'快递单号'},\r\n");
      out.write("\t  \t       {name:'maincount',  header:'主车台数',nullable:false},\r\n");
      out.write("\t  \t       {name:'gcount',  header:'挂车台数',nullable:false},\r\n");
      out.write("\t  \t       {name:'sdy',  header:'是否抵押',nullable:false}\r\n");
      out.write("\t  \t     ]\r\n");
      out.write("\t });\r\n");
      out.write("\t    \r\n");
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
