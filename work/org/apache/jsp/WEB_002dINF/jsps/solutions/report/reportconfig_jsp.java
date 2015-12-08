package org.apache.jsp.WEB_002dINF.jsps.solutions.report;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.EnumUtil;

public final class reportconfig_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(6);
    _jspx_dependants.add("/base/mini.jsp");
    _jspx_dependants.add("/base/base.jsp");
    _jspx_dependants.add("/base/var.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/fmt.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody != null) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write(" \n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("<title>报表管理</title>\n");
      out.write("    <!--css sheet-->\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f0(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f1(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f2(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_sc_005fset_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<script type=\"text/javascript\">var globalTimestamp = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";var globalLocale = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocale}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";var globalSkin = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";var globalClientWidth = document.documentElement.clientWidth;var globalClientHeight = document.documentElement.clientHeight;var globalWebRoot = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";</script>");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/seajs/sea.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">seajs.config({vars: { currentLocale: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocale}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',currentSkin:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'},base: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/',map: [[ /^(.*\\.(?:css|js))(.*)$/i, '$1?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' ]],charset: 'UTF-8'});</script>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/base/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/base.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('/');
      out.write('>');
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/miniui/miniui.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/miniui/locale/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocale}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(".js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/miniui/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/miniui.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/miniui/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icons.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<link rel=stylesheet href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/miniui/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentSkin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentTimestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('/');
      out.write('>');
      out.write("\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/ajaxfileupload.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.fileDownload.js\"></script>\n");
      out.write("   \t<style type=\"text/css\">\n");
      out.write("\t\thtml,body{\n");
      out.write("\t\t\toverflow:hidden;\n");
      out.write("\t\t    height:100%;\n");
      out.write("\t\t}\n");
      out.write("\t\t.input_label_desc{\n");
      out.write("\t\t\t width:100px;\n");
      out.write("\t\t\t font-weight:BOLD;\n");
      out.write("\t\t}\t\t\n");
      out.write("\t\t.container{\n");
      out.write("\t\t\tfloat:left;\n");
      out.write("\t\t\theight: 100%;\n");
      out.write("\t\t\tborder: 1px solid #DDD;\n");
      out.write("\t\t\tborder-top:0px;\n");
      out.write("\t\t\tborder-right:0px;\n");
      out.write("\t\t\tpadding: 0px;\n");
      out.write("\t\t\tpadding-top:5px;\n");
      out.write("\t\t\tpadding-right:5px;\t\t\t\n");
      out.write("\t   \t}\t\n");
      out.write("\n");
      out.write("\t   \t.panel-button{\n");
      out.write("\t   \t\twidth:54px;\t   \t\t\n");
      out.write("\t   \t\tmargin-left:20px;\n");
      out.write("\t   \t\tmargin-top:-3px;\n");
      out.write("\t   \t\tborder:1px solid #A9ACB5;\n");
      out.write("\t   \t\tbackground: #ebedf2;\n");
      out.write("\t   \t\tfont-size:9pt;\n");
      out.write("\t   \t\tline-height: 22px;\n");
      out.write("\t   \t\ttext-decoration: none;\n");
      out.write("\t   \t\ttext-align: center;\n");
      out.write("\t   \t\tdisplay:inline-block;\n");
      out.write("\t   \t\tcursor:pointer;\n");
      out.write("\t   \t\tvertical-align: middle;\n");
      out.write("\t   \t\toutline:none;\t   \t\t\n");
      out.write("\t   \t\t\n");
      out.write("\t   \t}\n");
      out.write("\n");
      out.write("\t   \t.panel-button span{\n");
      out.write("\t   \t\tpadding-left:25px;\n");
      out.write("\t   \t\tbackground-position:6px,50%;\n");
      out.write("\t   \t\tbackground-repeat:no-repeat;\n");
      out.write("\t   \t\twidth:25px;\n");
      out.write("\t   \t\tcolor:#201F35;\n");
      out.write("\t   \t}\n");
      out.write("\n");
      out.write("\t   \t.form_tab{\n");
      out.write("\t   \t\tborder:1px solid #ddd;\n");
      out.write("\t   \t}\n");
      out.write("\t  \n");
      out.write("\t\t#report_tree_container{\t\t\t\n");
      out.write("\t\t\toverflow:hidden;\t\n");
      out.write("\t\t\tpadding-left:0px;\t\t\n");
      out.write("\t\t}\n");
      out.write("\t</style>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tvar dataSourceJson;\t\t\n");
      out.write("\n");
      out.write("\t\tjQuery.ajax({\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/report/config/queryDataSource.action',\n");
      out.write("\t\t\tasync: false,\t\t\t\n");
      out.write("\t\t\tdataType:'json',\n");
      out.write("\t\t\tsuccess:function(data){\n");
      out.write("\t\t\t\tdataSourceJson = data;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\tvar comboboxDatas = {\n");
      out.write("\t\t\t'dataSource': dataSourceJson,\n");
      out.write("\t\t\t'sqlType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.QueryType.class));
      out.write(",\n");
      out.write("\t\t\t'queryType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.QueryType.class));
      out.write(",\n");
      out.write("\t\t\t'chartType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.ChartType.class));
      out.write(",\n");
      out.write("\t\t\t'subChartType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.ChartType.Area,com.tenwa.report.enums.ChartType.Column,com.tenwa.report.enums.ChartType.Line));
      out.write(",\n");
      out.write("\t\t\t'columnType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.ColumnDataType.class) );
      out.write(",\n");
      out.write("\t\t\t'usageType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.UsageType.class) );
      out.write(",\n");
      out.write("\t\t\t'alignType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.AlignType.class) );
      out.write(",\n");
      out.write("\t\t\t'contentType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.ContentType.class) );
      out.write(",\n");
      out.write("\t\t\t'filterRequestDataType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.FilterDataRequestType.class) );
      out.write(",\n");
      out.write("\t\t\t'filterDataDbType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.ColumnDataType.STRING,com.tenwa.report.enums.ColumnDataType.NUMBER,com.tenwa.report.enums.ColumnDataType.DATE));
      out.write(",\n");
      out.write("\t\t\t'htmlType':");
      out.print(EnumUtil.getEnumConstantsAsJson(com.tenwa.report.enums.HtmlType.class) );
      out.write(",\n");
      out.write("\t\t\t'yesOrNo' :[{text:'Yes',value:'1'},{text:'No',value:'0'}]\n");
      out.write("\t\t};\n");
      out.write("\n");
      out.write("\t\tjQuery(function(){\n");
      out.write("\t\t\tmini.parse();\t\t\t\n");
      out.write("\t\t\tseajs.use('js/report/reportconfig',function(rc){\n");
      out.write("\t\t\t\trc.initPage(comboboxDatas,'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.reportMenuRoot}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\n");
      out.write("\n");
      out.write("\t\t\t})\n");
      out.write("\t\t})\n");
      out.write("\t\t\n");
      out.write("\t</script>\n");
      out.write("\t\t\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- left -->\n");
      out.write("\t<div style=\"width:100%;height:100%\">\n");
      out.write("\t\t<div id=\"report_tree_container\" class=\"container mini-panel\" title=\"");
      if (_jspx_meth_s_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("\">\t\t\n");
      out.write("\t\t\t<div id=\"report_tree\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"content_tree_container\" class='container mini-panel' title=\"");
      if (_jspx_meth_s_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("\">\t\t\n");
      out.write("\t\t\t<div id=\"table_chart_tree\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--表格表单-->\n");
      out.write("\t\t<div id=\"table_container\" style=\"margin-top:5px;display:none\" class=\"container mini-panel\" width=\"800px\" title=\"");
      if (_jspx_meth_s_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("\">\n");
      out.write("\t\t\t<div id=\"table_toolbar\" style=\"display:none\">\n");
      out.write("\t\t\t\t<a class=\"panel-button\" id=\"btn_save_table\" href=\"javascript:void(0);\"><span class=\"mini-button-text mini-button-icon icon-save\">保存</span></a>\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Form_Table_Config.jsp", out, true);
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--静态页面表单-->\t\t\n");
      out.write("\t\t<div id=\"page_container\" style=\"margin-top:5px;display:none\" class=\"container mini-panel\" width=\"800px\" title=\"");
      if (_jspx_meth_s_005fmessage_005f3(_jspx_page_context))
        return;
      out.write("\">\n");
      out.write("\t\t\t<div id=\"page_toolbar\" style=\"display:none\">\n");
      out.write("\t\t\t\t<a class=\"panel-button\" id=\"btn_save_page\" href=\"javascript:void(0);\"><span class=\"mini-button-text mini-button-icon icon-save\">保存</span></a>\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Form_Page_Config.jsp", out, true);
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--图形表单-->\n");
      out.write("\t\t<div id=\"chart_container\" style=\"margin-top:5px;display:none\" class=\"container mini-panel\" width=\"800px\" title=\"");
      if (_jspx_meth_s_005fmessage_005f4(_jspx_page_context))
        return;
      out.write("\">\n");
      out.write("\t\t\t<div id=\"chart_toolbar\" style=\"display:none\">\n");
      out.write("\t\t\t\t<a class=\"panel-button\" id=\"btn_save_chart\" href=\"javascript:void(0)\"><span class=\"mini-button-text mini-button-icon icon-save\">保存</span></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Form_Chart_Config.jsp", out, true);
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!--报表表单-->\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Form_Report_Config.jsp", out, false);
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t<!-- Context Menu Operation -->\n");
      out.write("\t<div id=\"report_contextmenu\" class=\"mini-contextmenu\" style=\"display:none;width:120px;\">\n");
      out.write("\t\t<div id=\"report_contextmenu_add_folder\" iconCls=\"icon-plus-w\">添加文件夹</div>\n");
      out.write("\t\t<div id=\"report_contextmenu_add_report\" iconCls=\"icon-plus-w\">添加报表</div>\t\t\n");
      out.write("\t\t<div id=\"report_contextmenu_modify\" iconCls=\"icon-cogs-w\" >修改</div>\n");
      out.write("\t\t<div id=\"report_contextmenu_export\" iconCls=\"icon-cogs-w\">导出</div>\n");
      out.write("\t\t<div id=\"report_contextmenu_import\" iconCls=\"icon-cogs-w\">导入</div>\n");
      out.write("\t\t<div id=\"report_contextmenu_delete\" iconCls=\"icon-minus-w\">删除</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"content_contextmenu\" class=\"mini-contextmenu\" style=\"display:none;width:120px;\">\n");
      out.write("\t\t<div id=\"content_contexmenu_add_table\" iconCls=\"icon-plus-w\">添加表格报表</div>\n");
      out.write("\t\t<div id=\"content_contextmenu_add_chart\" iconCls='icon-plus-w'>添加图形报表</div>\n");
      out.write("\t\t<div id=\"content_contextmenu_add_page\" iconCls=\"icon-plus-w\">添加静态页面</div>\t\n");
      out.write("\t\t<div id=\"content_contextmenu_delete\" iconCls=\"icon-plus-w\">删除</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"report_download\" style=\"display:none\">\n");
      out.write("\t\t<form id=\"download_form\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/report/config/export.action\">\n");
      out.write("\t\t\t<input id=\"browser\" name=\"browser\" value=\"\" />\n");
      out.write("\t\t\t<input id=\"id\" name=\"id\" value=\"\" />\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"div_upload\" class=\"mini-window\" modal=\"true\" title=\"报表导入\" style=\"width:450px\">\n");
      out.write("\t\t\n");
      out.write("\t\t<table style=\"width:98%;padding-left:20px;padding-top:15px;\">\n");
      out.write("\t\t\t<tr id=\"import_fileupload\">\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"input_file_upload\" name=\"input_file_upload\">\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<div id=\"import_progress\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td style=\"text-align:right;padding-right:10px\">\n");
      out.write("\t\t\t\t\t<a id=\"import_ok\" class=\"mini-button\"><span>确定</span></a>\n");
      out.write("\t\t\t\t\t<a id=\"import_cancel\" class=\"mini-button\"><span>关闭</span></a>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_sc_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f0.setParent(null);
    // /base/var.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f0.setVar("currentTimestamp");
    // /base/var.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f0.setValue(new String("20140420"));
    int _jspx_eval_sc_005fset_005f0 = _jspx_th_sc_005fset_005f0.doStartTag();
    if (_jspx_th_sc_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_sc_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f1.setParent(null);
    // /base/var.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f1.setVar("currentLocale");
    // /base/var.jsp(4,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f1.setValue(new String("zh_CN"));
    int _jspx_eval_sc_005fset_005f1 = _jspx_th_sc_005fset_005f1.doStartTag();
    if (_jspx_th_sc_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_sc_005fset_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f2.setParent(null);
    // /base/var.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f2.setVar("currentSkin");
    // /base/var.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f2.setValue(new String("tenwa"));
    int _jspx_eval_sc_005fset_005f2 = _jspx_th_sc_005fset_005f2.doStartTag();
    if (_jspx_th_sc_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_sc_005fset_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sc:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_sc_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_sc_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_sc_005fset_005f3.setParent(null);
    // /base/var.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f3.setVar("ctx");
    // /base/var.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sc_005fset_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_sc_005fset_005f3 = _jspx_th_sc_005fset_005f3.doStartTag();
    if (_jspx_th_sc_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fsc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_sc_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(108,70) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setCode("report.config.form.report");
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(108,70) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setText("报表");
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
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(111,71) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f1.setCode("report.config.form.content");
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(111,71) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f1.setText("图表");
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
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(115,114) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f2.setCode("report.config.form.table");
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(115,114) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f2.setText("表格");
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

  private boolean _jspx_meth_s_005fmessage_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f3 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(122,113) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f3.setCode("report.config.form.page");
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(122,113) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f3.setText("静态页");
    int[] _jspx_push_body_count_s_005fmessage_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f3 = _jspx_th_s_005fmessage_005f3.doStartTag();
      if (_jspx_th_s_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f3.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f4 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f4.setParent(null);
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(129,114) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f4.setCode("report.config.form.chart");
    // /WEB-INF/jsps/solutions/report/reportconfig.jsp(129,114) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f4.setText("图表");
    int[] _jspx_push_body_count_s_005fmessage_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f4 = _jspx_th_s_005fmessage_005f4.doStartTag();
      if (_jspx_th_s_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f4.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f4);
    }
    return false;
  }
}
