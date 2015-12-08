package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flow_005fcondition_005fselect_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\tfunction selectRoteByCondtion(RoteObject)\r\n");
      out.write("\t{  \r\n");
      out.write("\r\n");
      out.write("\t\t var i=0;\r\n");
      out.write("\t\t var srote=\"\";\r\n");
      out.write("\t     var CustRoteObject=eval(\"(\"+RoteObject+\")\");\r\n");
      out.write("\t    \r\n");
      out.write("\t\t for(;i<CustRoteObject.length;i++){\r\n");
      out.write("\t\t\t if(CustRoteObject[i].condtion==\"\"){\r\n");
      out.write("\t\t\t\t srote=srote+\"<input style='position:relative;top:3px;width:20px' name='flow_condition_select_id' type='radio' id='flow_condition_select_id' value='\"+CustRoteObject[i].rote+\"'>\"+CustRoteObject[i].rote+\"</input><br>\";\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t else{\r\n");
      out.write("\t\t\t srote=srote+\"<input style='position:relative;top:3px;width:20px' name='flow_condition_select_id' type='radio' id='flow_condition_select_id' value='\"+CustRoteObject[i].rote+\"'>\"+CustRoteObject[i].condtion+\"-->\"+CustRoteObject[i].rote+\"</input><br>\";\r\n");
      out.write("\t\t }}\r\n");
      out.write("\t    jQuery(\"#id_flow_condition_select\").html(srote);\t\r\n");
      out.write("\t      \r\n");
      out.write("\t\tjQuery(\"#flow_condition_select\").show();\r\n");
      out.write("\t\tjQuery(\"#flow_condition_select\").window({\r\n");
      out.write("\t\t\t   top:10\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t\t jQuery(\"#flow_condition_select\").window(\"open\");\r\n");
      out.write("    }\r\n");
      out.write("    function selectRoteResult(){\r\n");
      out.write("        var crote=$('input[name=\"flow_condition_select_id\"]:checked').val();\r\n");
      out.write("        if (typeof(crote) == \"undefined\") { \r\n");
      out.write("        \tjQuery.messager.alert('操作提示',\"<div style='font-size:18px;line-height:30px;'>请选择路由！</div>\",'error');\r\n");
      out.write("        \t//jQuery('#flow_condition_select').window('show');\r\n");
      out.write("        }else{  \r\n");
      out.write("        \tisSelectRote=true;\r\n");
      out.write("        \tif(crote==\"流程结束\"){crote=\"\";} \r\n");
      out.write("        \tselectRote=crote;\r\n");
      out.write("    \t   jQuery('#flow_condition_select').window('close');\r\n");
      out.write("    \t   btn_callBack(\"Submit\");\r\n");
      out.write("        } \t\r\n");
      out.write("     }\r\n");
      out.write("\t</script>\r\n");
      out.write("<div id=\"flow_condition_select\" closed=\"true\" modal=\"true\" title=\"提交下一步详情\"\r\n");
      out.write("\tstyle=\"display:none;width:600px;padding-top:10px;padding:0px;\">\r\n");
      out.write("<center>\r\n");
      out.write("<div style=\"width:96%;text-align:left;\">\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("   <tr>\r\n");
      out.write("     <tr style='height:20px;'><td></td></tr>\r\n");
      out.write("\t<td colspan=\"2\">\r\n");
      out.write("\t     条件选择:    \r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td class=\"input_value\"  colspan=\"2\">\r\n");
      out.write("\t   <span id=\"id_flow_condition_select\" style=\"padding-right:10px\">\r\n");
      out.write("\t   </span>    \r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"content-separator\">\r\n");
      out.write("\t\t<td colspan=\"2\"><a style=\"margin-left: 20px;\"\r\n");
      out.write("\t\t\thref=\"javascript:void(0);\" class=\"btn btn-primary\"\r\n");
      out.write("\t\t\tonclick='selectRoteResult();'><span>确定</span></a> <a\r\n");
      out.write("\t\t\tstyle=\"margin-left: 20px;\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\tclass=\"btn btn-primary\"\r\n");
      out.write("\t\t\tonclick=\"jQuery('#flow_condition_select').window('close');\"\r\n");
      out.write("            ><span>取消</span></a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
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
