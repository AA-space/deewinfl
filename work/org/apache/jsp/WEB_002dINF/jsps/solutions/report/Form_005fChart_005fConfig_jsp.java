package org.apache.jsp.WEB_002dINF.jsps.solutions.report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Form_005fChart_005fConfig_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody != null) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.release();
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

      out.write("\n");
      out.write("\n");
      out.write("<form id=\"chart_form\" class=\"mini-form\" method=\"post\">\n");
      out.write("\t<div style=\"display: none\">\t\t\n");
      out.write("\t\t<input type=\"text\" class=\"mini-textbox\" name=\"chart_id\"  id=\"chart_id\"/>\n");
      out.write("        <input type=\"text\" class=\"mini-textbox\" name=\"chart_layoutId\" id=\"chart_layoutId\" />\n");
      out.write("    </div>\n");
      out.write("    <div id=\"chart_tabs\" class=\"mini-tabs\" activeIndex=\"0\" style=\"width:100%;height:100%\" plain=\"false\" borderStyle=\"border:1px solid #ddd\" bodyStyle=\"border:1px solid #ddd;height:100%\" headerStyle=\"border:1px soldi #ddd\">\n");
      out.write("    \t<div title=\"");
      if (_jspx_meth_s_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("\" class=\"form_table\">\n");
      out.write("    \t\t<table style=\"width:100%\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>名称:</span></td>\n");
      out.write("\t\t\t\t\t<td><input  class=\"mini-textbox\" required=\"true\" name=\"chart_name\" id=\"chart_name\"/><span class=\"content-required\">*</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">图表类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("    \t  \t\t\t\t<input id=\"chart_chartType\" name=\"chart_chartType\" class=\"mini-combobox\"/>\n");
      out.write("    \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t</tr>\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">图表:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("    \t  \t\t\t\t<input id=\"chart_chartType2\" name=\"chart_chartType2\" class=\"mini-combobox\"/>\n");
      out.write("    \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t</tr>\t\n");
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>标题:</span></td>\n");
      out.write("\t\t\t\t\t<td><input   class=\"mini-textbox\" name=\"chart_caption\" id=\"chart_caption\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>子标题:</span></td>\n");
      out.write("\t\t\t\t\t<td><input  class=\"mini-textbox\" name=\"chart_subcaption\" id=\"chart_subcaption\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>X轴标签:</span></td>\n");
      out.write("\t\t\t\t\t<td><input  class=\"mini-textbox\" name=\"chart_xAxisName\" id=\"chart_xAxisName\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>Y轴标签:</span></td>\n");
      out.write("\t\t\t\t\t<td><input  class=\"mini-textbox\" name=\"chart_yAxisName\" id=\"chart_yAxisName\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<tr id=\"tr_chart_dualy2\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>次Y轴标签:</span></td>\n");
      out.write("\t\t\t\t\t<td><input  class=\"mini-textbox\" name=\"chart_sAxisName\" id=\"chart_sAxisName\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<tr id=\"tr_layout_width\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">页面宽度:</td>\n");
      out.write("\t\t\t\t\t<td><input name=\"chart_layout_width\" id=\"chart_layout_width\" class=\"mini-textbox\" value=\"600\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr id=\"tr_layout_height\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">页面高度:</td>\n");
      out.write("\t\t\t\t\t<td><input name=\"chart_layout_height\" id=\"chart_layout_height\" class=\"mini-textbox\" value=\"300\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">数据源:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("    \t  \t\t\t\t<input id=\"chart_datasource\" name=\"chart_datasource\" class=\"mini-combobox\"/>\n");
      out.write("    \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t</tr>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">SQL类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("    \t  \t\t\t\t<input id=\"chart_sqlType\" name=\"chart_sqlType\" class=\"mini-combobox\"/>\n");
      out.write("    \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t \t<td class=\"input_label_desc\">SQL:</td>\n");
      out.write("\t\t\t\t \t<td class=\"input_value\"><textarea id=\"chart_sql\" name=\"chart_sql\" class=\"mini-textarea\" style=\"width:400px;height:200px;\"></textarea></td>\n");
      out.write("\t\t\t\t</tr>\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t \t<td class=\"input_label_desc\">SQL参数值:</td>\n");
      out.write("\t\t\t\t \t<td><input class=\"mini-textbox\" id=\"chart_sqlParamValue\" name=\"chart_sqlParamValue\" /><span class=\"content-required\">使用\"|\"分隔参数</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" style=\"padding-top:20px\"><a class=\"mini-button\" id=\"chart_validateSQL\">验证SQL</a></td>\n");
      out.write("\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t</table>\n");
      out.write("    \t</div>\n");
      out.write("    \t<div title=\"");
      if (_jspx_meth_s_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("\" class=\"form_tab\">\n");
      out.write("    \t\t<div style=\"display:none\">\n");
      out.write("\t\t\t\t<input hidden=\"true\" class=\"mini-textbox\" id=\"chart_selectedColumns\" name=\"chart_selectedColumns\" value=\"\">\n");
      out.write("\t\t\t\t<input hidden=\"true\" class=\"mini-textbox\" id=\"chart_columnNodeId\" name=\"chart_columnNodeId\" value=\"\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"chart_column_layout\" class=\"mini-layout\" style=\"width:100%;height:100%\">\n");
      out.write("\t\t\t\t<div region=\"west\" showHeader=\"false\" width=\"280\" style=\"margin-top:-1px;margin-bottom:-1px;border:0;border-right:1px solid #ddd\">\n");
      out.write("    \t\t\t\t<div id=\"chart_column_tree\" class=\"mini-tree\"></div>\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t\t<div region=\"center\" showHeader=\"false\" style=\"border:0\">\n");
      out.write("    \t\t\t\t<div id=\"chart_column_form\">\n");
      out.write("    \t\t\t\t\t<div style=\"display:none\">\n");
      out.write("    \t\t\t\t\t\t<input type=\"text\" class=\"mini-hidden\" id=\"chart_columnId\" name=\"chart_columnId\" value=\"\" />\n");
      out.write("    \t\t\t\t\t</div>\n");
      out.write("    \t\t\t\t\t<table>\n");
      out.write("\t                        <tr> \n");
      out.write("\t                            <td class=\"input_label_desc\">列名:</td>\n");
      out.write("\t                            <td>\n");
      out.write("\t                            \t<input class=\"mini-textbox\" name=\"chart_columnName\" id=\"chart_columnName\" readonly=\"true\"/>\t                            \t\n");
      out.write("\t                            </td>\n");
      out.write("\t                        </tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">标题:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"mini-textbox\" name=\"chart_columnLabel\" id=\"chart_columnLabel\" value=\"\"/>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">格式类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\t\t\t\n");
      out.write("\t            \t  \t\t\t\t<input id=\"chart_columnType\" name=\"chart_columnType\" class=\"mini-combobox\"/>\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_columnformater\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">格式:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"mini-textbox\" name=\"chart_columnFormater\" id=\"chart_columnFormater\"/>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据用途:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\t\t\t\n");
      out.write("\t            \t  \t\t\t\t<input id=\"chart_columnUsageType\" name=\"chart_columnUsageType\" class=\"mini-combobox\"/>\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">显示数值:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t            \t  \t\t\t\t<input id=\"chart_columnShowValue\" name=\"chart_columnShowValue\" class=\"mini-combobox\"/>\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_dualy\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">次Y坐标轴:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\t\t\t\n");
      out.write("\t            \t  \t\t\t\t<input id=\"chart_columnRightY\" name=\"chart_columnRightY\" class=\"mini-combobox\"/>\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_combichart\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">组合图形类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\t\t\t\n");
      out.write("\t            \t  \t\t\t\t<input id=\"chart_columnCombi\" name=\"chart_columnCombi\" class=\"mini-combobox\"/>\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">颜色</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"mini-textbox\" id=\"chart_columnColor\" name=\"chart_columnColor\" value=\"\" />\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">附加链接类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"chart_columnActionType\" name=\"chart_columnActionType\" class=\"mini-combobox\" showNullItem=\"true\" />\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_actionurl\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接目标:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-combobox\"  name=\"chart_columnActionUrl\" id=\"chart_columnActionUrl\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_actionurl2\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接目标:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"  name=\"chart_columnActionUrl2\" id=\"chart_columnActionUrl2\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_actionparameter\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接参数:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"  name=\"chart_columnActionParameter\" id=\"chart_columnActionParameter\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_actioncondition\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接条件:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"chart_columnActionCondition\" id=\"chart_columnActionCondition\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("    \t\t\t\t</div>\n");
      out.write("    \t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("    \t</div>\n");
      out.write("    \t<div title=\"");
      if (_jspx_meth_s_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("\" class=\"form_tab\">\n");
      out.write("    \t\t<div id=\"chart_filter_layout\" class=\"mini-layout\" style=\"width:100%;height:100%\">    \t\t\t\n");
      out.write("    \t\t\t<div region=\"west\" showHeader=\"false\" width=\"280\" style=\"margin-top:-1px;margin-bottom:-1px;border:0;border-right:1px solid #ddd\">\n");
      out.write("    \t\t\t\t<div id=\"chart_filter_tree\" class=\"mini-tree\"></div>\n");
      out.write("\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t\t<div region=\"center\" showHeader=\"false\" style=\"border:0\">\n");
      out.write("    \t\t\t\t<div style=\"display:none\">\n");
      out.write("    \t\t\t\t\t<input hidden=\"true\" class=\"mini-textbox\" id=\"chart_filterNodeId\" name=\"chart_filterNodeId\" value=\"\">\n");
      out.write("\t    \t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"chart_selectedFilters\" id=\"chart_selectedFilters\" />\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"chart_combine_express_filter\" id=\"chart_combine_express_filter\" />\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"chart_combine_express_search\" id=\"chart_combine_express_search\" />\n");
      out.write("\t    \t\t\t</div>\n");
      out.write("\t    \t\t\t<div id=\"chart_filter_form\">\n");
      out.write("\t    \t\t\t\t<div style=\"display:none\">\n");
      out.write("\t    \t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"chart_filterId\" id=\"chart_filterId\" />\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"chart_filterFilterType\" id=\"chart_filterFilterType\" />\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<table>\n");
      out.write("                            <tr> \n");
      out.write("                                <td class=\"input_label_desc\">字段标识:</td>\n");
      out.write("                                <td class=\"input_value\">\n");
      out.write("                                \t<input type=\"text\" class=\"mini-textbox\" name=\"chart_filterName\" id=\"chart_filterName\" value=\"\"/>\t                                \t\n");
      out.write("                                \t<span class=\"content-required\">*</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr> \n");
      out.write("                                <td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("                                <td class=\"input_value\">                                \t\n");
      out.write("                                \t<span class=\"content-required\" style=\"color:black\">\n");
      out.write("                                \t与列标识或SQL参数相同，若是SQL参数，形式{param}，此处填写param,<br />\n");
      out.write("                                \t如果是多表查询，此处参数应附加表名。\n");
      out.write("                                \t</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">字段显示:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t \t<input type=\"text\" class=\"mini-textbox\" name=\"chart_filterLabel\" id=\"chart_filterLabel\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"content-required\">*</span>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t <tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据类型:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"chart_filterDbType\" name=\"chart_filterDbType\" style=\"display:inline-block\" class=\"mini-combobox\"  />\t\t            \t  \t\t\t\t\n");
      out.write("\t            \t  \t\t\t</td>   \n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr> \n");
      out.write("                                <td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("                                <td class=\"input_value\">                                \t\n");
      out.write("                                \t<span class=\"content-required\" style=\"color:black\">\n");
      out.write("                                \t\t数据库中的类型，用于当数据库类型与格式类型不一致时，调用转换函数时使用，如VARCHAR，选择“文本”。\n");
      out.write("                                \t</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">格式类型:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"chart_filterHtmlType\" name=\"chart_filterHtmlType\" style=\"display:inline-block\" class=\"mini-combobox\"  />\t\t            \t  \t\t\t\t\n");
      out.write("\t            \t  \t\t\t</td>   \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">表达式:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"chart_filterExpress\" id=\"chart_filterExpress\" />\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr> \n");
      out.write("                                <td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("                                <td class=\"input_value\">                                \t\n");
      out.write("                                \t<span class=\"content-required\" style=\"color:black\">\n");
      out.write("                                \t\t应用于Where条件时，默认对于文本和下拉列表使用like '%&lt;value&gt;%'，<br/>对于日期和日期区间使用between...and...<br/>\n");
      out.write("                                \t\t如有特殊需要，在此处输入相应的表达式，如='{字段标识}'\n");
      out.write("                                \t</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">默认值:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"chart_filterDefaultValue\" id=\"chart_filterDefaultValue\" />\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr> \n");
      out.write("                                <td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("                                <td class=\"input_value\">                                \t\n");
      out.write("                                \t<span class=\"content-required\" style=\"color:black\">                                \t\t\n");
      out.write("                                \t\t多值按顺序使用\"|\"分隔\n");
      out.write("                                \t</span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_combobox_datasource1\" style=\"display:none;width:196px;\" >\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据请求类型:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"chart_filterFilterDataRequestType\" name=\"chart_filterFilterDataRequestType\" class=\"mini-combobox\"  />\n");
      out.write("\t            \t  \t\t\t</td>   \n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_combobox_datasource2\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据请求来源:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"chart_filterComboboxDataSource\" id=\"chart_filterComboboxDataSource\" />\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_combobox_datasource3\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据显示字段:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"chart_filterComboboxNameField\" id=\"chart_filterComboboxNameField\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_chart_combobox_datasource4\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据值字段:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"chart_filterComboboxValueField\" id=\"chart_filterComboboxValueField\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t</div>\n");
      out.write("    \t</div>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<!--过滤器组合表达式配置-->\n");
      out.write("<div id=\"chart_filterExpress_container\" style=\"display:none;\">\n");
      out.write("\t<table>\n");
      out.write("\t\t<tr> \n");
      out.write("            <td class=\"input_label_desc\">组合表达式:</td>\n");
      out.write("            <td class=\"input_value\">\n");
      out.write("            \t<input type=\"text\"  name=\"combineexpress\" id=\"combineexpress\" style=\"width:250px\"/>\n");
      out.write("            \t<span class=\"content-required\">*</span>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("        \t<td colspan=\"2\">\n");
      out.write("        \t\t组合表达式：用于对同一组的查询条件进行组合，默认时，所有条件使用\"AND\"连接<br />\n");
      out.write("        \t\t如果需要特定组合，使用格式: {查询条件ID1} AND {查询条件2} OR {查询条件3}\n");
      out.write("        \t</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr><td colspan=\"2\"><span style=\"width:40px\">&nbsp;</span></td>\n");
      out.write("        <tr>\t\t\t\n");
      out.write("\t\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t\t<span style=\"width:40px\">&nbsp;</span>\n");
      out.write("\t\t\t\t<a class=\"btn btn-primary\" onclick=\"saveCombineExpress('#chart_filterExpress_container','#form_chart');\"><span>确定</span></a>\n");
      out.write("\t\t\t\t<span style=\"width:40px\">&nbsp;</span>\n");
      out.write("\t\t\t\t<a class=\"btn btn-primary\" onclick=\"closeWindow('#chart_filterExpress_container');\"><span>取消</span></a>\t\t\t\t\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t <tr><td colspan=\"2\"><span style=\"width:40px\">&nbsp;</span></td></tr>\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--过滤器右键菜单-->\n");
      out.write("<div id=\"chart_filter_contextmenu\" class=\"mini-contextmenu\">\n");
      out.write("\t<div id=\"chart_filter_contextmenu_add\" iconCls=\"icon-plus-w\">新增</div>\n");
      out.write("\t<div id=\"chart_filter_contextmenu_delete\" iconCls=\"icon-plus-w\">删除</div>\n");
      out.write("\t<div id=\"chart_filter_contextmenu_express\" iconCls=\"icon-plus-w\">组合表达式</div>\n");
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

  private boolean _jspx_meth_s_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/report/Form_Chart_Config.jsp(9,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setCode("report.config.form.chart.basic");
    // /WEB-INF/jsps/solutions/report/Form_Chart_Config.jsp(9,17) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setText("基本");
    int[] _jspx_push_body_count_s_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f0 = _jspx_th_s_005fmessage_005f0.doStartTag();
      if (_jspx_th_s_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f1 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/report/Form_Chart_Config.jsp(89,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f1.setCode("report.config.form.chart.columns");
    // /WEB-INF/jsps/solutions/report/Form_Chart_Config.jsp(89,17) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f1.setText("列配置");
    int[] _jspx_push_body_count_s_005fmessage_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f1 = _jspx_th_s_005fmessage_005f1.doStartTag();
      if (_jspx_th_s_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f1.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f2 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/report/Form_Chart_Config.jsp(203,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f2.setCode("report.config.form.chart_.filter");
    // /WEB-INF/jsps/solutions/report/Form_Chart_Config.jsp(203,17) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f2.setText("过滤器");
    int[] _jspx_push_body_count_s_005fmessage_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f2 = _jspx_th_s_005fmessage_005f2.doStartTag();
      if (_jspx_th_s_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f2.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f2);
    }
    return false;
  }
}
