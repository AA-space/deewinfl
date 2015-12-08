package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005fapproval;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fdoc_005fems_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("   \r\n");
      out.write("<div id=\"id_contract_doc_ems_window\" closed=\"true\" modal=\"true\" title=\"EMS单号\"\r\n");
      out.write("\tstyle=\"display:none;width:600px;padding-top:10px;padding:0px;\">\r\n");
      out.write("<center>\r\n");
      out.write("<div style=\"width:96%;text-align:left;\">\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("   <tr><tr style='height:20px;'><td >EMS单号:</td>\r\n");
      out.write("\t<td class=\"input_value\"><input id=\"contractems_id\"  type='text' name=\"contractems\" style=\"border:1px solid #DDD;width:200px;\" value=\"\"/>\r\n");
      out.write("\t   </span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"content-separator\">\r\n");
      out.write("\t\t<td colspan=\"2\"><a style=\"margin-left: 20px;\"\r\n");
      out.write("\t\t\thref=\"javascript:void(0);\" class=\"btn btn-primary\"\r\n");
      out.write("\t\t\tonclick='setContractEms();'><span>确定</span></a> <a\r\n");
      out.write("\t\t\tstyle=\"margin-left: 20px;\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\tclass=\"btn btn-primary\"\r\n");
      out.write("\t\t\tonclick=\"jQuery('#id_contract_doc_ems_window').window('close');\"\r\n");
      out.write("            ><span>取消</span></a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
      out.write("</div>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function setContractEms(){\r\n");
      out.write("\tvar contractdoc = getTracywindyObject('table_id_table_leasing_contract_doc_send_info');//合同\r\n");
      out.write("    var plandata = contractdoc.getCheckedRowDatas();\r\n");
      out.write("    var ems=$('#contractems_id').val();\r\n");
      out.write("    for(var i=0;i<plandata.length;i++){\r\n");
      out.write("    \tcontractdoc.getRowDataAt(plandata[i].rowIndex).sendno=ems;\r\n");
      out.write("     }\r\n");
      out.write("    jQuery('#id_contract_doc_send_info_str').val(JsonUtil.encode(contractdoc.getRowsJsonData()));\r\n");
      out.write("    contractdoc.reload();\r\n");
      out.write("    jQuery('#id_contract_doc_ems_window').window('close');\r\n");
      out.write("}\r\n");
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
