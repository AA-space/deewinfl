package org.apache.jsp.WEB_002dINF.jsps.solutions.leasing.other.area;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class manager_005fdistrict_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>区域管理</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
      out.write("     <link href=\"");
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
      out.write("\t <!--javascript libray-->\r\n");
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
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var constantFlagTable = \"ContractDocInfo\";\r\n");
      out.write("var pageWidth  = document.documentElement.clientWidth-2;\r\n");
      out.write("var pageHeight = document.documentElement.clientHeight-2;\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\ttracywindyOperationTable({\t\t\r\n");
      out.write("\t\tresetFormCallback:function(table,$form,operFlag){\r\n");
      out.write("   \t\t if(\"add\" == operFlag){\r\n");
      out.write("   \t\t\tvar rowData = table.getRowDataAt(0);\r\n");
      out.write("   \t\t\tvar select_contract = getTracywindyObject(\"id_combo_id_district\");\r\n");
      out.write("   \t        select_contract.setRawValue(\"\"); \r\n");
      out.write("   \t        select_contract = getTracywindyObject(\"id_combo_id_managerrole\");\r\n");
      out.write("\t        select_contract.setRawValue(\"\"); \r\n");
      out.write("\t    \tselect_contract = getTracywindyObject(\"id_combo_manager\");\r\n");
      out.write("   \t        select_contract.setRawValue(\"\");   \r\n");
      out.write("   \t     }\r\n");
      out.write("     \t },\r\n");
      out.write("   \t\t loadFormDataCallBack:function(table,$form,rowIndex){\r\n");
      out.write("     \t\tvar rowData = table.getRowDataAt(rowIndex);\t  \r\n");
      out.write("     \t\tvar select_contract = getTracywindyObject(\"id_combo_id_district\");\r\n");
      out.write("   \t        select_contract.setRawValue(rowData[\"district\"]); \r\n");
      out.write("   \t        select_contract = getTracywindyObject(\"id_combo_id_managerrole\");\r\n");
      out.write("\t        select_contract.setRawValue(rowData[\"rolename\"]); \r\n");
      out.write("\t    \tselect_contract = getTracywindyObject(\"id_combo_manager\");\r\n");
      out.write("   \t        select_contract.setRawValue(rowData[\"manager\"]); \r\n");
      out.write("        },\t \r\n");
      out.write("\t\t tableComment:'区域管理 ',\r\n");
      out.write("   \t\t constantFlagTable:'managerDistrict',\r\n");
      out.write("         renderTo:'id_tableriskContainer',\r\n");
      out.write("         title:'区域管理 ',\r\n");
      out.write("         width:window.formWidth||pageWidth,\r\n");
      out.write("         height:pageHeight,\r\n");
      out.write("         id:'id_tablerisk',\r\n");
      out.write("         formContainerId:'id_riskInfoWindowContainer',\r\n");
      out.write("         xmlFileName:'/eleasing/jsp/other/area/managerdistrict.xml',\r\n");
      out.write("         loadMode:'ajax',\r\n");
      out.write("         isPage:true,\r\n");
      out.write("         border:true,\r\n");
      out.write("         isRank:true,\r\n");
      out.write("         //params:param,\r\n");
      out.write("         isFit:true,\r\n");
      out.write("         columns:[\r\n");
      out.write(" \t\t      {header:'角色',name:'rolename'},\r\n");
      out.write(" \t\t      {header:'人员',name:'manager',queryConfig:{}},\r\n");
      out.write(" \t\t      {header:'所属区域',name:'district',queryConfig:{}}\r\n");
      out.write("\t        ]\r\n");
      out.write("\t });\r\n");
      out.write("\t \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("jQuery(function(){\r\n");
      out.write("\tdictOnSelect('id_district','district','dealer_district',null,null,'require=\"true\" label=\"所属区域\"');\r\n");
      out.write("\tcommonSelectOverall('id_managerrole',\"(SELECT ID_, name_ FROM t_roles) rs\",'id_',\"name_\",'managerrole','','','require=\"true\" label=\"角色\"', function(combo,data){\r\n");
      out.write("\t\tvar cust=getTracywindyObject(\"id_combo_manager\");\r\n");
      out.write("\t\t  cust.setParam(\"roleid\",combo.getValue());\r\n");
      out.write("\t\t  cust.reload();\r\n");
      out.write("\t\t\t},false);\r\n");
      out.write("\tvar combo_cust = new tracywindyComboBox({\r\n");
      out.write("\t    id:'id_combo_manager',\r\n");
      out.write("\t    width:300,\r\n");
      out.write("\t    renderTo:'id_manager',\r\n");
      out.write("\t    xmlFileName:'\\\\eleasing\\\\workflow\\\\public\\\\SimpleUserSelectByRole.xml',\r\n");
      out.write("\t    loadMode:'ajax',\r\n");
      out.write("\t    readOnly:false,\r\n");
      out.write("\t    isAjaxLenovo:true,\r\n");
      out.write("\t    isContainEmpty:false,\r\n");
      out.write("\t    dropListHeight:300,\r\n");
      out.write("\t    topAdd:0,\r\n");
      out.write("\t    leftAdd:0,\r\n");
      out.write("\t    positionDropIconLeftAdd:-1,\r\n");
      out.write("\t    name:'manager',\r\n");
      out.write("\t    displayField:'name',\r\n");
      out.write("\t    valueField:'id',\r\n");
      out.write("\t    params:{\r\n");
      out.write("\t    },\r\n");
      out.write("\t    onSelect:function(combo){\r\n");
      out.write("\t    }\r\n");
      out.write(" \t});\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"id_tableriskContainer\"></div>\r\n");
      out.write("<div id=\"id_riskInfoWindowContainer\" closed=\"true\" modal=\"true\" title=\"区域管理\" style=\"display:none;width:900px;padding-top:20px;\">\r\n");
      out.write("<center>\r\n");
      out.write("\t        <form id=\"id_detailInfoForm\">\r\n");
      out.write("\t\t        <table style=\"width:90%\">\r\n");
      out.write(" \t<tr>\r\n");
      out.write(" \t<td colspan=\"4\">&nbsp;</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr style=\"display:none\"><td><input name=\"id\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">角色:</td>\r\n");
      out.write("\t\t<td class=\"input_value\">\r\n");
      out.write("\t\t\t<div style=\"float: left\" class=\"leftComboContainer\" id=\"id_managerrole\"></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">人员:  </td>  \r\n");
      out.write("       \t<td class=\"td-content\">\r\n");
      out.write("       \t    <div style=\"float: left\" class=\"leftComboContainer\" id=\"id_manager\"></div>\r\n");
      out.write("\t\t  </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-odd\">\t\r\n");
      out.write("       \t<td class=\"input_label_desc\" align=\"left\">所属区域:  </td>  \r\n");
      out.write("       \t<td class=\"td-content\">\r\n");
      out.write("      \t \t<div style=\"float: left\" class=\"leftComboContainer\" id=\"id_district\"></div>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("<!-- \t<tr class=\"tr-even\">\r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">备注:</td>\r\n");
      out.write("\t\t<td class=\"td-content\" colspan=\"4\">\r\n");
      out.write("\t\t<textarea rows=\"2\" cols=\"95\" name=\"lawmemo\" require=\"true\" label=\"备注\" style=\"width:84%\" ></textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr> -->\r\n");
      out.write("\t<tr class=\"tr-odd\">\r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">登记人 :  </td>  \r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t    <input name=\"creatorname\" id=\"creator\" label=\"登记人 \" class=\"td-content-input td-content-readonly\"  readonly=\"readonly\" type=\"text\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">登记时间</td>  \r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t    <input name=\"createdate\" id=\"createdate\" isDefaultDate=\"true\" label=\"登记时间 \"   class=\"td-content-input td-content-readonly\"  readonly=\"readonly\" type=\"text\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr class=\"tr-even\">\r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">修改人 :  </td>  \r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t    <input name=\"modificatorname\" id=\"modificator\" label=\"修改人 \" class=\"td-content-input td-content-readonly\" readonly=\"readonly\" type=\"text\" />\r\n");
      out.write("\t\t</td> \r\n");
      out.write("\t\t<td class=\"input_label_desc\" align=\"left\">修改时间</td>  \r\n");
      out.write("\t\t<td class=\"td-content\">\r\n");
      out.write("\t\t    <input name=\"modifydate\" id=\"modifydate\" label=\"修改时间\" class=\"td-content-input td-content-readonly\"  readonly=\"readonly\" type=\"text\" />\r\n");
      out.write("    \t</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\t<tr class=\"content-separator\">\r\n");
      out.write("\t\t<td colspan='4'>\r\n");
      out.write("\t\t<a style=\"margin-left: 20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='getTracywindyObject(\"id_tablerisk\").operationTable();'><span>确定</span></a>\r\n");
      out.write("\t\t<a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_riskInfoWindowContainer\").window(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t</td>                                                                                             \r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</center>\r\n");
      out.write("</div>\r\n");
      out.write("</head>\r\n");
      out.write("</html>\r\n");
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
