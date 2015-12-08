package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fonhire;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fonhire_005fnotice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    function showOperator(value,tableObj,columnName,columnIndex,rowData){\r\n");
      out.write("        // var base = \"<a href='#' onclick='showRecorder(\\\"\"+rowData.id+\"\\\")'>记录</a>\";\r\n");
      out.write("        var base2 = \"<a href='#' onclick='downloadFile(\\\"\"+rowData.id+\"\\\")'>下载</a>\";\r\n");
      out.write("        var base3 = \"<a href='#' onclick='openoverdue(\\\"\"+rowData.id+\"\\\")'>编辑</a>\";\r\n");
      out.write("        return base3+\"  \"+base2; \r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("    function downloadFile(Id)\r\n");
      out.write("    {\r\n");
      out.write("      attachmentDown({url:\"/leasing/template/downLoadAttachById.action\",id:Id,returnType:'file'});\r\n");
      out.write("     }\r\n");
      out.write("    \r\n");
      out.write("    function openoverdue(id){\r\n");
      out.write("    \tvar currentPageClientWidth  =  document.documentElement.clientWidth;\r\n");
      out.write("    \tvar currentPageClientHeight =  document.documentElement.clientHeight;\r\n");
      out.write("    \twindow.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',\"height=\"+currentPageClientHeight+\",width=\"+currentPageClientWidth +\",top=0,left=0\") ;\r\n");
      out.write("    }\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("\t    var test=new tracywindyMultiTable({\r\n");
      out.write("\t    renderTo:'projcreditreport',\r\n");
      out.write("\t    width:formWidth,\r\n");
      out.write("\t    height:250,\r\n");
      out.write("\t    tools:'删除',\r\n");
      out.write("\t    //otherTools:('undefined'==typeof(tooldata)) ? \"\" :tooldata,\r\n");
      out.write("\t    otherTools:[{\r\n");
      out.write("\t     \t html : '<font color=\"blue\">生成起租通知函</font>',\r\n");
      out.write("\t \t\thandler : function(table) {\r\n");
      out.write("\t \t\t\t\tcreateTemFile();\r\n");
      out.write("\t \t\t\t\t//return false;\r\n");
      out.write("\t \t\t},\r\n");
      out.write("\t \t\ticonCls : 'icon-update'\r\n");
      out.write("\t    }],\r\n");
      out.write("\t    isFit:true,\r\n");
      out.write("\t    isNeedTools:true,\r\n");
      out.write("\t    datas:JsonUtil.decode('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty json_word_list_str ? \"[]\" : json_word_list_str }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'),\r\n");
      out.write("\t    //datas:[{id:11,filename:111}],\r\n");
      out.write("\t    columns:[\r\n");
      out.write("\t       {name:'id',  header:'id',type:'text',hidden:true},\r\n");
      out.write("\t       {header:'文件名称',name:'filename'},\r\n");
      out.write("\t       {header:'文件生成时间',name:'createdate'},\r\n");
      out.write("\t       {header:'操作',name:'create',renderer:showOperator}\r\n");
      out.write("\t      // {name:'templateshowname',  header:'协议文本',type:'text', renderer:showContractFile}\r\n");
      out.write("\t     ]\r\n");
      out.write("\t \t});\r\n");
      out.write("    });\r\n");
      out.write("    </script>\r\n");
      out.write("   \r\n");
      out.write(" <table cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-proj-credit-report\"></div>起租通知函</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-report tr-even\">\r\n");
      out.write("          <td>\r\n");
      out.write("          <div id=\"projcreditreport\"></div>\r\n");
      out.write("          </td>\r\n");
      out.write("         </tr>         \r\n");
      out.write("   </table>");
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
