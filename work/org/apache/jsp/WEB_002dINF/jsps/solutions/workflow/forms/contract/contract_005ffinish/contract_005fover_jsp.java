package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005ffinish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fover_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("         <table cellspacing=\"0\" cellpadding=\"0\" id=\"contract_over\">\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-contractect-info\"></div>合同结束清单</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">结束时间 ：</td><td class=\"td-content\">\r\n");
      out.write("            \r\n");
      out.write("             <input name=\"contract_info.actualenddate\" id=\"leaseAmtDate\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" datatype=\"Date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_info.actualenddate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  onclick=\"WdatePicker(this,{readOnly:true})\" readonly require=\"true\" label=\"合同结束日期\"/>\r\n");
      out.write("               \r\n");
      out.write("               <font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">结束类型：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_finish_type\"></div><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">结束合同的IRR ：</td><td class=\"td-content\"><input id=\"actualirr\" name=\"contract_condition.endirr\" class=\"td-content-input td-content-readonly\" readOnly require=\"true\" label=\"请点击结算IRR按钮，实际IRR\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_condition.endirr'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\"><input style=\"margin-top:2px;margin-bottom:2px;\" id=\"btn_rent_cal\"  class=\"btn btn-primary\" type=\"button\"  value=\"结算IRR\" onclick=\"IRR_Calc('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_info.id'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\"/></td> \r\n");
      out.write("         </tr>\r\n");
      out.write("          <!--<tr class=\"tr-contractect-info tr-even\"> \r\n");
      out.write("             <td class=\"td-content-title\">备注 ：</td>\r\n");
      out.write("             <td colspan=\"3\"><textarea rows=\"10\"   style=\"width: 98%; margin-top: 5px;margin-left: -10px;margin-button: 5px;overflow-y:scroll\" name=\"contract_end_info.endmemo\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_end_info.endmemo']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("          </tr>     \r\n");
      out.write("        --></table>\r\n");
      out.write("        <script language=\"javascript\">\r\n");
      out.write("    jQuery(function(){\r\n");
      out.write("        if(isSubTable){\r\n");
      out.write("          // dict('id_finish_type','','finish_type','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',null,'require=\"true\" label=\"项目类型\"');\r\n");
      out.write("           dict('id_finish_type','contract_info.endtype','finish_type','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"contract_info.endtype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"RawValue_contract_info.endtype\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("','require=\"true\" label=\"结束类型\"');\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("    function IRR_Calc(id){\r\n");
      out.write("        \r\n");
      out.write("    \tif(!window.currentDeleteFileLoadMask)\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,\"正在加载数据 请稍等...\");\r\n");
      out.write("\t  } \r\n");
      out.write("\t  window.currentDeleteFileLoadMask.show();\r\n");
      out.write("        var url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leasing/getActualIRRData.action\";\r\n");
      out.write("        var params={};\r\n");
      out.write("        //alert(id);\r\n");
      out.write("        params[\"id\"]=id;\r\n");
      out.write("        ajaxRequest({\r\n");
      out.write("        \t method:'POST',\r\n");
      out.write("        \t url:getRootPath()+url,\r\n");
      out.write("        \t params:params,\r\n");
      out.write("             success:function(res){\r\n");
      out.write("     \t   \t\tres=res.responseText.replace(/(^\\s+)|(\\s+$)/g, \"\"); \r\n");
      out.write("         \t    if(res!=''){\r\n");
      out.write("\t  \t        \t $(\"#actualirr\").val(res); \r\n");
      out.write("\t  \t        \tjQuery(\"#id_workflowAdviseContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("               \t\tjQuery(\"#id_workflowFormContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("               \t\twindow.currentDeleteFileLoadMask.hide();  \r\n");
      out.write("         \t    }else{\r\n");
      out.write("         \t    \tjQuery(\"#id_workflowAdviseContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("               \t\tjQuery(\"#id_workflowFormContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("               \t\twindow.currentDeleteFileLoadMask.hide();\r\n");
      out.write("         \t    \talert(\"请求测算成功,但无结果返回,请重新尝试!\");\r\n");
      out.write("         \t    }\r\n");
      out.write("             },\r\n");
      out.write("             failure:function(res){\r\n");
      out.write("         \t\tjQuery(\"#id_workflowAdviseContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("           \t\tjQuery(\"#id_workflowFormContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("           \t\twindow.currentDeleteFileLoadMask.hide();\r\n");
      out.write("             \talert(\"访问服务器进行测算失败[服务器正忙,或者无法连通,或者服务器出现异常]!\");\r\n");
      out.write("              }\r\n");
      out.write("        });\r\n");
      out.write("    \treturn false;\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
      out.write("        \r\n");
      out.write("        ");
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
