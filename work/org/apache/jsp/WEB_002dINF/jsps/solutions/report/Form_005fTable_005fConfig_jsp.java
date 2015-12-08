package org.apache.jsp.WEB_002dINF.jsps.solutions.report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Form_005fTable_005fConfig_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<form id=\"table_form\" class=\"mini-form\" method=\"post\">\n");
      out.write("\t<div style=\"display:none\">\n");
      out.write("\t \t<input type=\"text\" class=\"mini-textbox\" name=\"table_id\"  id=\"table_id\"/>\n");
      out.write("        <input type=\"text\" class=\"mini-textbox\" name=\"table_layoutId\" id=\"table_layoutId\" />        \n");
      out.write("    </div>\n");
      out.write("    <div id=\"table_tabs\" class=\"mini-tabs\" activeIndex=\"0\" style=\"width:100%;height:100%\" plain=\"false\" borderStyle=\"border:1px solid #ddd\" bodyStyle=\"border:1px solid #ddd;height:100%\" headerStyle=\"border:1px soldi #ddd\">\n");
      out.write("    \t<div title=\"");
      if (_jspx_meth_s_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("\" class=\"form_tab\">\n");
      out.write("    \t\t<table style=\"width:100%\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\"><span>名称:</span></td>\n");
      out.write("\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" required=\"true\" name=\"table_name\" id=\"table_name\" value=\"\"/><span class=\"content-required\">*</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t<tr id=\"tr_table_layout_width\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">页面宽度:</td>\n");
      out.write("\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_layout_width\" id=\"table_layout_width\" value=\"600\"/><span class=\"content-required\">px</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr id=\"tr_table_layout_height\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">页面高度:</td>\n");
      out.write("\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"  name=\"table_layout_height\" id=\"table_layout_height\" value=\"300\"/><span class=\"content-required\">px</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">每页显示记录数:</td>\n");
      out.write("\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_pageSize\" id=\"table_pageSize\" value=\"20\"/><span class=\"content-required\">条</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">按比例扩展列:</td>\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\n");
      out.write("    \t  \t\t\t\t<input id=\"table_isScale\" name=\"table_isScale\" style=\"display:inline-block\" class=\"mini-combobox\" />\n");
      out.write("    \t  \t\t\t</td>  \n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">数据源:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\n");
      out.write("    \t  \t\t\t\t<input id=\"table_datasource\" name=\"table_datasource\" style=\"display:inline-block\" class=\"mini-combobox\" />\n");
      out.write("    \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t</tr>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">SQL类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("    \t  \t\t\t\t<input id=\"table_sqlType\" name=\"table_sqlType\" style=\"display:inline-block\" class=\"mini-combobox\"/><span class=\"content-required\">*</span>\n");
      out.write("    \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t \t<td class=\"input_label_desc\">SQL:</td>\n");
      out.write("\t\t\t\t \t<td class=\"input_value\">\n");
      out.write("\t\t\t\t \t\t<textarea id=\"table_sql\" name=\"table_sql\" class=\"mini-textarea\" style=\"width:400px;height:200px;\"></textarea> \n");
      out.write("\t\t\t\t \t</td>\n");
      out.write("\t\t\t\t</tr>\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t \t<td class=\"input_label_desc\">SQL参数值:</td>\n");
      out.write("\t\t\t\t \t<td class=\"input_value\">\n");
      out.write("\t\t\t\t \t\t<input id=\"table_sqlParamValue\" name=\"table_sqlParamValue\" class=\"mini-textbox\"  />\n");
      out.write("\t\t\t\t\t\t<span class=\"content-required\">使用\"|\"分隔参数</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t\t\t\t<p>SQL说明：如果需要在SQL中使用参数，其格式应类似select * from table where id={id},</p>\n");
      out.write("\t\t\t\t\t\t<p>对于日期区间或日期的参数，其格式为 select * from table where d {date}，并在预查询</p>\n");
      out.write("\t\t\t\t\t\t<p>中设置该参数类型为日期。 </p>\n");
      out.write("\t\t\t\t\t\t<p>权限控制参数：</p>\n");
      out.write("\t\t\t\t\t\t<p>_TENWA_USERID:用于替换当前用户ID</p>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">显示行序列:</td>\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t<input id=\"table_showRowNumber\" name=\"table_showRowNumber\" style=\"display:inline-block\" class=\"mini-combobox\" />\n");
      out.write("    \t  \t\t\t</td>    \n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td class=\"input_label_desc\">显示统计标题列:</td>\n");
      out.write("\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\n");
      out.write("    \t  \t\t\t\t<input id=\"table_showTotalTitle\" name=\"table_showTotalTitle\" style=\"display:inline-block\" class=\"mini-combobox\"  />    \t  \t\t\t\t\n");
      out.write("    \t  \t\t\t</td>    \n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" style=\"padding-top:20px\">\n");
      out.write("\t\t\t\t\t\t<a class=\"mini-button\" id=\"table_validateSQL\">验证SQL</a>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t</table>\n");
      out.write("    \t</div>\n");
      out.write("    \t<div title=\"");
      if (_jspx_meth_s_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("\" class=\"form_tab\">\n");
      out.write("    \t\t<div style=\"display:none\">\n");
      out.write("    \t\t\t<input type=\"text\" class=\"mini-TextArea\" id=\"table_selectedColumns\" name=\"table_selectedColumns\" value=\"\">\n");
      out.write("    \t\t</div>\n");
      out.write("    \t\t<div id=\"table_column_layout\" class=\"mini-layout\" style=\"width:100%;height:100%\">\n");
      out.write("    \t\t\t<div region=\"west\" showHeader=\"false\" width=\"280\" style=\"margin-top:-1px;margin-bottom:-1px;border:0;border-right:1px solid #ddd\">\n");
      out.write("    \t\t\t\t<div id=\"table_column_tree\" class=\"mini-tree\"></div>\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t\t<div region=\"center\" showHeader=\"false\" style=\"border:0\">\n");
      out.write("    \t\t\t\t<div id=\"table_column_form\">\n");
      out.write("    \t\t\t\t\t<div style=\"display:none\">\n");
      out.write("    \t\t\t\t\t\t<input hidden=\"true\" class=\"mini-textbox\" id=\"table_columnNodeId\" name=\"table_columnNodeId\" value=\"\">\n");
      out.write("    \t\t\t\t\t\t<input type=\"text\" class=\"mini-hidden\" id=\"table_columnId\" name=\"table_columnId\" value=\"\" />\n");
      out.write("    \t\t\t\t\t</div>\n");
      out.write("    \t\t\t\t\t<table>\n");
      out.write("                            <tr> \n");
      out.write("                                <td class=\"input_label_desc\">列名:</td>\n");
      out.write("                                <td class=\"input_value\">\n");
      out.write("                                \t<input type=\"text\" class=\"mini-textbox\"  name=\"table_columnName\" id=\"table_columnName\" readonly=\"true\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">标题:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_columnLabel\" id=\"table_columnLabel\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">格式类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\t\t\t\n");
      out.write("\t            \t  \t\t\t\t<input id=\"table_columnType\" name=\"table_columnType\" class=\"mini-combobox\"  />\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_columnformater\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">格式:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_columnFormater\" id=\"table_columnFormater\" value=\"\"/>\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">列宽:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_columnWidth\" id=\"table_columnWidth\" value=\"100\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"content-required\">px</span>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">可见:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnVisible\" name=\"table_columnVisible\" class=\"mini-combobox\"  />\t     \n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">对齐:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnAlign\" name=\"table_columnAlign\" class=\"mini-combobox\"  />\t     \n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">同值合并:</td>  \n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnMerge\" name=\"table_columnMerge\" class=\"mini-combobox\"  />\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\" >分组依据:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnGroupby\" name=\"table_columnGroupby\" class=\"mini-combobox\"  />\t            \t  \t\t\t\t\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_subTotal\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\" >小计:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnSubTotal\" name=\"table_columnSubTotal\" class=\"mini-combobox\"  />\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_total\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">总计:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnTotal\" name=\"table_columnTotal\"\tclass=\"mini-combobox\"  />\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">着色:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_columnColor\" id=\"table_columnColor\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t说明：JSON格式,\"&lt;颜色值&gt;\":\"&lt;条件表达式&gt;\",\"&lt;颜色值&gt;\":\"&lt;条件表达式&gt;\"，如果要统一着色，使用\"&lt;颜色值&gt;\":\"\"\n");
      out.write("\t\t\t\t\t\t\t\t\t<br/>示例:\"#ddd\":\"{a}+{b}\",\"#eee\":\"ccc\"\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">附加链接类型:</td>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_columnActionType\" name=\"table_columnActionType\" class=\"mini-combobox\" showNullItem=\"true\" />\n");
      out.write("\t            \t  \t\t\t</td>         \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_actionurl\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接目标:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-combobox\"  name=\"table_columnActionUrl\" id=\"table_columnActionUrl\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_actionurl2\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接目标:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"  name=\"table_columnActionUrl2\" id=\"table_columnActionUrl2\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_actionparameter\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接参数:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"  name=\"table_columnActionParameter\" id=\"table_columnActionParameter\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_actioncondition\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">链接条件:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"table_columnActionCondition\" id=\"table_columnActionCondition\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_actionmemo\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t说明：若取其它域名，使用{columnName1} + {columnName2} > {columnName3}类似格式\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("    \t\t\t\t</div>\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t</div>    \t\t\t\n");
      out.write("    \t</div>\n");
      out.write("    \t<div title=\"");
      if (_jspx_meth_s_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("\" class=\"form_tab\">\n");
      out.write("    \t\t<div id=\"table_filter_layout\" class=\"mini-layout\" style=\"width:100%;height:100%\">    \t\t\t\n");
      out.write("    \t\t\t<div region=\"west\" showHeader=\"false\" width=\"280\" style=\"margin-top:-1px;margin-bottom:-1px;border:0;border-right:1px solid #ddd\">\n");
      out.write("    \t\t\t\t<div id=\"table_filter_tree\" class=\"mini-tree\"></div>\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t\t<div region=\"center\" showHeader=\"false\" style=\"border:0\">\n");
      out.write("    \t\t\t\t<div style=\"display:none\">\n");
      out.write("    \t\t\t\t\t<input hidden=\"true\" class=\"mini-textbox\" id=\"table_filterNodeId\" name=\"table_filterNodeId\" value=\"\">\n");
      out.write("\t    \t\t\t\t<input type=\"text\" class=\"mini-TextArea\" name=\"table_selectedFilters\" id=\"table_selectedFilters\" />\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-TextArea\" name=\"table_combine_express_filter\" id=\"table_combine_express_filter\" />\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"mini-TextArea\" name=\"table_combine_express_search\" id=\"table_combine_express_search\" />\n");
      out.write("\t    \t\t\t</div>\n");
      out.write("\t    \t\t\t<div id=\"table_filter_form\">\n");
      out.write("\t    \t\t\t\t<div style=\"display:none\">\n");
      out.write("\t    \t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_filterId\" id=\"table_filterId\" />\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\" name=\"table_filterFilterType\" id=\"table_filterFilterType\" />\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<table>\n");
      out.write("                            <tr> \n");
      out.write("                                <td class=\"input_label_desc\">字段标识:</td>\n");
      out.write("                                <td class=\"input_value\">\n");
      out.write("                                \t<input type=\"text\" class=\"mini-textbox\" name=\"table_filterName\" id=\"table_filterName\" value=\"\"/>\t                                \t\n");
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
      out.write("\t\t\t\t\t\t\t\t \t<input type=\"text\" class=\"mini-textbox\" name=\"table_filterLabel\" id=\"table_filterLabel\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"content-required\">*</span>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t <tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据类型:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_filterDbType\" name=\"table_filterDbType\" style=\"display:inline-block\" class=\"mini-combobox\"  />\t\t            \t  \t\t\t\t\n");
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
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_filterHtmlType\" name=\"table_filterHtmlType\" style=\"display:inline-block\" class=\"mini-combobox\"  />\t\t            \t  \t\t\t\t\n");
      out.write("\t            \t  \t\t\t</td>   \n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">表达式:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"table_filterExpress\" id=\"table_filterExpress\" />\n");
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
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"table_filterDefaultValue\" id=\"table_filterDefaultValue\" />\n");
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
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_combobox_datasource1\" style=\"display:none;width:196px;\" >\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据请求类型:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"td-content\">\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"table_filterFilterDataRequestType\" name=\"table_filterFilterDataRequestType\" class=\"mini-combobox\"  />\n");
      out.write("\t            \t  \t\t\t</td>   \n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_combobox_datasource2\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据请求来源:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"table_filterComboboxDataSource\" id=\"table_filterComboboxDataSource\" />\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_combobox_datasource3\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据显示字段:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"table_filterComboboxNameField\" id=\"table_filterComboboxNameField\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"tr_table_combobox_datasource4\" style=\"display:none\">\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_label_desc\">数据值字段:</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"input_value\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"mini-textbox\"   name=\"table_filterComboboxValueField\" id=\"table_filterComboboxValueField\" value=\"\"/>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t</div>    \t\t\t\t\n");
      out.write("    \t\t\t</div>\n");
      out.write("    \t\t</div>\n");
      out.write("  \t\t</div>\n");
      out.write("  \t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<!--过滤器右键菜单-->\n");
      out.write("<div id=\"table_filter_contextmenu\" class=\"mini-contextmenu\">\n");
      out.write("\t<div id=\"table_filter_contextmenu_add\" iconCls=\"icon-plus-w\">新增</div>\n");
      out.write("\t<div id=\"table_filter_contextmenu_delete\" iconCls=\"icon-plus-w\">删除</div>\n");
      out.write("\t<div id=\"table_filter_contextmenu_express\" iconCls=\"icon-plus-w\">组合表达式</div>\n");
      out.write("</div>\n");
      out.write("\n");
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
    // /WEB-INF/jsps/solutions/report/Form_Table_Config.jsp(9,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setCode("report.config.form.table.basic");
    // /WEB-INF/jsps/solutions/report/Form_Table_Config.jsp(9,17) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/report/Form_Table_Config.jsp(98,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f1.setCode("report.config.form.table.columns");
    // /WEB-INF/jsps/solutions/report/Form_Table_Config.jsp(98,17) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/jsps/solutions/report/Form_Table_Config.jsp(241,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f2.setCode("report.config.form.table.filter");
    // /WEB-INF/jsps/solutions/report/Form_Table_Config.jsp(241,17) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
