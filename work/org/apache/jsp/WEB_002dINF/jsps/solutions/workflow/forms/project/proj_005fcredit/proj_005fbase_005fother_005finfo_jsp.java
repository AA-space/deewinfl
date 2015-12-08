package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fbase_005fother_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<table cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=4 class=\"td-even-line-separator\">&nbsp;</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-info\"></div>车辆运营概况</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">单次所需时间：</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=3><input name=\"proj_other_info.singletime\" class=\"td-content-input \" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.singletime'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" require=\"true\"\r\n");
      out.write("\t\t\tlabel=\"单次运输时间\" maxB=\"50\"\r\n");
      out.write("\t\t><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-info tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">单次运输收入：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"proj_other_info.singleincome\" class=\"td-content-input \" type=\"text\" dataType=\"PMoney\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.singleincome'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" require=\"true\"\r\n");
      out.write("\t\t\tlabel=\"单次运输收入\" maxB=\"50\"\r\n");
      out.write("\t\t><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">单次运输费用：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"proj_other_info.singlefee\" class=\"td-content-input \" type=\"text\" dataType=\"PMoney\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.singlefee'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" require=\"true\"\r\n");
      out.write("\t\t\tlabel=\"单次运输费用\" maxB=\"50\"\r\n");
      out.write("\t\t><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-info tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">运输种类：</td><td class=\"td-content\"><div class=\"leftComboContainer\" id=\"id_classoftraffic\"></div></td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">运输路线：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><textarea name=\"proj_other_info.transportroute\" class=\"td-content-input \" dataType=\"Require\" require=\"true\"\r\n");
      out.write("\t\t\tlabel=\"运输路线\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.transportroute'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-info1\"></div>车辆运营费用</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-info1 tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">油费:</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"proj_other_info.oilfee\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.oilfee']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" require=\"true\" label=\"油费\"\r\n");
      out.write("\t\t\tmaxB=\"50\"\r\n");
      out.write("\t\t><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">过路费：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"proj_other_info.tollfee\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.tollfee']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" require=\"true\" label=\"过路费\"\r\n");
      out.write("\t\t\tmaxB=\"50\"\r\n");
      out.write("\t\t/><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-info1 tr-odd\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">人工费：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"proj_other_info.laborfee\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.laborfee']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" require=\"true\"\r\n");
      out.write("\t\t\tlabel=\"人工费\" maxB=\"50\"\r\n");
      out.write("\t\t><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t<td class=\"td-content-title\">维修保养费：</td>\r\n");
      out.write("\t\t<td class=\"td-content\"><input name=\"proj_other_info.servicefee\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.servicefee']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" require=\"true\"\r\n");
      out.write("\t\t\tlabel=\"维修保养费\" maxB=\"50\"\r\n");
      out.write("\t\t><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-info1 tr-even\">\r\n");
      out.write("\t\t<td class=\"td-content-title\">其他：</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=\"3\"><input name=\"proj_other_info.otherfee\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.otherfee'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" label=\"其它\"\r\n");
      out.write("\t\t\tmaxB=\"50\"\r\n");
      out.write("\t\t></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-inf\"></div>特殊说明\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-inf\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\" style=\"width: 98%\" id=\"special_industries\" name=\"proj_other_info.specialindustries\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.specialindustries'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"x-panel-table-div-title\">\r\n");
      out.write("\t\t<td class=\"x-panel-table-div-title\" colspan=4>\r\n");
      out.write("\t\t\t<div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-other-inf\"></div>标的物详情\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-other-inf\">\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=4><textarea rows=\"5\" style=\"width: 98%\" id=\"equipinfo\" name=\"proj_other_info.equipinfo\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.equipinfo'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<script>\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\t\r\n");
      out.write("\t new tracywindyComboBox({\r\n");
      out.write("\t   \t\tlazyLoad:true,\r\n");
      out.write("\t   \t\tid : 'id_classoftraffic',\r\n");
      out.write("\t   \t\twidth : 167,\r\n");
      out.write("\t   \t\trenderTo : 'id_classoftraffic',\r\n");
      out.write("\t   \t\txmlFileName : '\\\\eleasing\\\\workflow\\\\public\\\\projtransficc_combox.xml',\r\n");
      out.write("\t   \t\tloadMode : 'ajax',\r\n");
      out.write("\t   \t\treadOnly : false,\r\n");
      out.write("\t   \t\tisAjaxLenovo : true,\r\n");
      out.write("\t   \t\totherAttributes:'label=\"运输种类\"',//  \r\n");
      out.write("\t   \t\ttopAdd : 0,\r\n");
      out.write("\t   \t\tleftAdd : 0,\r\n");
      out.write("\t   \t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t   \t\tname : 'proj_other_info.classoftraffic',\r\n");
      out.write("\t   \t\tdisplayField : 'name',\r\n");
      out.write("\t   \t\tvalueField : 'id',\r\n");
      out.write("\t   \t\tvalue:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.classoftraffic'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\", \r\n");
      out.write("\t   \t\trawValue:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.classoftraffic'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\", \r\n");
      out.write("\t   \t\t\r\n");
      out.write("\t   \t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
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
