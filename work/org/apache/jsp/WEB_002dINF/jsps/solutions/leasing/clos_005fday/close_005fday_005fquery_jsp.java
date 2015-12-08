package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.clos_005fday;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class close_005fday_005fquery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>关账日信息</title>\r\n");
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
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/workFlowUtil.js\"></script>\r\n");
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
      out.write("\t<style type=\"text/css\"> \r\n");
      out.write("\t\thtml,body{overflow:hidden;}\r\n");
      out.write("\t\t.required-content{color:red}\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("   \t var table = new tracywindyOperationTable({   \t\t \r\n");
      out.write("   \t\t windowTop:20,\r\n");
      out.write("   \t\t constantFlagTable:'CloseDayInfo',\r\n");
      out.write("   \t     border:true,\r\n");
      out.write("         renderTo:'id_tableContainer',\r\n");
      out.write("         title:'关账日信息',\r\n");
      out.write("         tableComment:'[关账日信息]',\r\n");
      out.write("         width:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageWidth,\r\n");
      out.write("         height:parseInt(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.tableHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\")||pageHeight,\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/close_day/close_day_info.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         operButtons:'新增|修改|删除',\r\n");
      out.write("         lazyLoad: false,\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         id:'id_table',\r\n");
      out.write("         isAutoBreakContent: false,\r\n");
      out.write("         isExcel:true,\r\n");
      out.write("         isFit: true,\r\n");
      out.write("         beforeShowWindowCallBack:function(operType,thisForm,operType){\r\n");
      out.write("\t    \t if(operType==\"update\"){\r\n");
      out.write("\t    \t\t var status = $('input[name=\"status\"]').val();\r\n");
      out.write("\t    \t\t if(status == \"0\"){\r\n");
      out.write("\t    \t\t\t getTracywindyObject(\"id_combo_id_status\").setRawValue(\"有效\");\r\n");
      out.write("\t    \t\t }else{\r\n");
      out.write("\t    \t\t\t getTracywindyObject(\"id_combo_id_status\").setRawValue(\"无效\");\r\n");
      out.write("\t    \t\t }\r\n");
      out.write("\t\t\t\t getTracywindyObject(\"id_combo_id_status\").setValue(status);\r\n");
      out.write("\t    \t }\r\n");
      out.write("\t    \t return true;\r\n");
      out.write("\t     },\r\n");
      out.write("         columns:\r\n");
      out.write("         [\r\n");
      out.write("\t            {header:'id',name:'cid',hidden:true},\r\n");
      out.write("\t    \t    {header:'年份',name:'closeyear',queryConfig:{}},\r\n");
      out.write("\t            {header:'月份',name:'closemonth',queryConfig:{}},\r\n");
      out.write("\t            {header:'关账日',name:'closeday'},\r\n");
      out.write("\t            {name:'status', header:'状态id',hidden:true},\r\n");
      out.write("\t            {header:'状态',name:'statusname',hiddenName:'status',queryConfig:{},config:{\r\n");
      out.write("\t  \t\t\t\twidth:165,\r\n");
      out.write("\t\t\t\t\tisNewLine:true,\r\n");
      out.write("\t\t\t\t\ttype:'combobox',\r\n");
      out.write("\t\t\t\t\tcolSpan:3, \r\n");
      out.write("\t\t\t\t\tloadMode:'local',\r\n");
      out.write("\t\t\t\t\tdatas:[{title:'有效',name:'0'},{title:'无效',name:'1'}],\r\n");
      out.write("\t\t            displayField:'title',\r\n");
      out.write("\t\t            valueField:'name',\r\n");
      out.write("\t\t            defaultValue:1,\r\n");
      out.write("\t\t            value:'1'\r\n");
      out.write("\t            }}\r\n");
      out.write("\t     ]\r\n");
      out.write("   \t });\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 加载table 内容div -->\r\n");
      out.write("<div id=\"id_tableContainer\"></div>\r\n");
      out.write("\r\n");
      out.write("<!-- 画弹出框内容 -->\t\r\n");
      out.write("<center>\r\n");
      out.write("<div id=\"id_detailInfoWindowContainer\"  title=\"关账日信息\" style=\"display:none;width:550px;height:300px\">\r\n");
      out.write("        <center>\r\n");
      out.write("\t        <form id=\"id_detailInfoForm\">\r\n");
      out.write("\t\t        <table style=\"width:90%\">\r\n");
      out.write("\t\t            <tr style=\"display:none\">\r\n");
      out.write("\t\t            <td><input name=\"id\" id=\"id\" type=\"hidden\" value=\"\"/></td>\r\n");
      out.write("\t\t            <td><input name=\"closeStaff\" id=\"closeStaff\" type=\"hidden\" value=\"\"/></td>\r\n");
      out.write("\t\t            </tr>\r\n");
      out.write("\t\t           <tr >\r\n");
      out.write("\t\t\t\t\t   <td class=\"td-content-title\">年份：</td>\r\n");
      out.write("\t\t\t\t\t   <td class=\"td-content\"><input name=\"closeyear\" class=\"td-content-input\"  \r\n");
      out.write("\t\t\t             type=\"text\" require=\"true\" label=\"年份\" /><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t\t           <td class=\"td-content-title\">月份：</td>\r\n");
      out.write("\t\t\t             <td class=\"td-content\"><input name=\"closemonth\" class=\"td-content-input\" require=\"true\" label=\"月份\"   type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['closemonth'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t   <td class=\"td-content-title\">关账日：</td>\r\n");
      out.write("\t\t\t\t\t   <td class=\"td-content\"><input name=\"closeday\" id=\"closeday\" onClick=\"WdatePicker(this,{readOnly:true})\" dataType=\"date\" readOnly class=\"td-content-input\"  \r\n");
      out.write("\t\t\t             type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['closeday'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   require=\"true\" label=\"关账日\" /><font class=\"required-content\">*</font></td>\r\n");
      out.write("\t\t\t           <td class=\"td-content-title\">状态：</td>\r\n");
      out.write("\t\t\t             <td class=\"td-content\">\r\n");
      out.write("\t\t\t             <div class=\"leftComboContainer\" id=\"id_status\"></div></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t            <td colspan='4'>\r\n");
      out.write("\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='submitInfo()'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_detailInfoWindowContainer\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t            </td>\r\n");
      out.write("\t\t            </tr>\r\n");
      out.write("\t\t        </table>\r\n");
      out.write("\t        </form> \r\n");
      out.write("        </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("</center>\r\n");
      out.write("<script>\r\n");
      out.write("function submitInfo(){\r\n");
      out.write("\tif($(\"#closeday\").val() == \"\"){\r\n");
      out.write("\t\talert(\"关账日不为空!\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn getTracywindyObject(\"id_table\").operationTable();\r\n");
      out.write("}\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tnew tracywindyComboBox({\r\n");
      out.write("\t\tlazyLoad:true,\r\n");
      out.write("\t\tid : 'id_combo_id_status',\r\n");
      out.write("\t\twidth : 167,\r\n");
      out.write("\t\trenderTo : 'id_status',\r\n");
      out.write("\t\tdatas:[{value:'0',name:'有效'},{value:'1',name:'无效'}],\r\n");
      out.write("\t\tloadMode : 'local',\r\n");
      out.write("\t\treadOnly : false,\r\n");
      out.write("\t\tisAjaxLenovo : true,\r\n");
      out.write("\t\treadOnly:true,\r\n");
      out.write("\t\totherAttributes:'require=\"true\"  label=\"状态\"',\r\n");
      out.write("\t\ttopAdd : 0,\r\n");
      out.write("\t\tleftAdd : 0,\r\n");
      out.write("\t\tpositionDropIconLeftAdd : -1,\r\n");
      out.write("\t\tname : 'status',\r\n");
      out.write("\t\tdisplayField : 'name',\r\n");
      out.write("\t\tvalueField : 'value',\r\n");
      out.write("\t\tvalue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"status\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\trawValue:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[\"rawValue_status\"]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
}
