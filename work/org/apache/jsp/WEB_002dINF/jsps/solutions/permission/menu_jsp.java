package org.apache.jsp.WEB_002dINF.jsps.solutions.permission;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kernal.utils.FileUtil;
import com.kernal.utils.WebUtil;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody != null) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    if (_005fjspx_005ftagPool_005fc_005fif_0026_005ftest != null) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write(" \r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLabel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("信息管理</title>\r\n");
      out.write("    <!--css sheet-->\r\n");
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
      out.write("\t<!--javascript libray-->\r\n");
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
      out.write("/js/validator.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/dtree/dtree.js\"></script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t   html,body{\r\n");
      out.write("\t     overflow:hidden;\r\n");
      out.write("\t   }\r\n");
      out.write("\t   .picItem{\r\n");
      out.write("\t      float:left;\r\n");
      out.write("\t      padding:5px 5px 5px 5px;\r\n");
      out.write("\t      border:1px solid silver;\r\n");
      out.write("\t   }\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script type='text/javascript'>\r\n");
      out.write("\t  var isWorkflowOper = false;\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_005fif_005f5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t   var picJson = ");
      out.print(FileUtil.getChildrenFileNameJson(WebUtil.getWebContextRealPath()+"\\menuIcons\\"));
      out.write(";\r\n");
      out.write("\t   var currentPicInputId = null;\r\n");
      out.write("\t   jQuery(function(){\r\n");
      out.write("\t        for(var pic in picJson)\r\n");
      out.write("\t        {\r\n");
      out.write("\t            jQuery(\"#id_pictureContainer\").append(\"<div class='picItem'><a href='javascript:void(0)' ondblclick='getSelectedPicture(\\\"\"+pic+\"\\\")'><img width='22px' height='22px' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/\"+pic+\"'/></a><div>\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t   });\r\n");
      out.write("\t   function getSelectedPicture(picSrc)\r\n");
      out.write("\t   {\r\n");
      out.write("\t\t   if(currentPicInputId)\r\n");
      out.write("\t\t   {\r\n");
      out.write("\t\t\t   jQuery(\"#\"+currentPicInputId).val(picSrc);\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t   jQuery(\"#id_pictureContainer\").dialog(\"close\");\r\n");
      out.write("\t   }\r\n");
      out.write("\t    function showIconPictureWindow(e)\r\n");
      out.write("\t    {\r\n");
      out.write("\t        jQuery(\"#id_pictureContainer\").show();\r\n");
      out.write("\t    \tjQuery(\"#id_pictureContainer\").dialog({\r\n");
      out.write("\t        \tleft:(e.pageX||e.clientX),\r\n");
      out.write("\t        \ttop:20,//(e.pageY||e.clientY+5),\r\n");
      out.write("\t        \tzIndex:9000,\r\n");
      out.write("\t        \tdraggable:true,\r\n");
      out.write("\t        \tresizable:true,\r\n");
      out.write("\t        \tshadow:true,\r\n");
      out.write("\t        \tmodal:false,\r\n");
      out.write("\t        \tinline:false,\r\n");
      out.write("\t        \tcollapsible:false,\r\n");
      out.write("\t        \tminimizable:false,\r\n");
      out.write("\t        \tmaximizable:false,\r\n");
      out.write("\t        \tclosable:true,\r\n");
      out.write("\t        \tclosed:false\r\n");
      out.write("\t        });\r\n");
      out.write("\t    \tjQuery(\"#id_pictureContainer\").dialog(\"open\");\r\n");
      out.write("\t    }\r\n");
      out.write("\t</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-10;\r\n");
      out.write("    var constantFlag = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${constantFlag}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    var operFlag = \"\";\r\n");
      out.write("    var operPromit = \"\";\r\n");
      out.write("    var loadMask_add = null;\r\n");
      out.write("    var loadMask_update = null;\r\n");
      out.write("    var loadMask_remove = null;\r\n");
      out.write("    var loadMask_reset = null;\r\n");
      out.write("    var loadMask_enabled = null;\r\n");
      out.write("    var windowContainerId = \"id_\"+constantFlag.toLowerCase()+\"DetailInfoWindowContianer\";\r\n");
      out.write("    var formId  =  \"id_\"+constantFlag.toLowerCase()+\"DetailInfoForm\";\r\n");
      out.write("\tvar constantLabelId =\"id_\"+constantFlag.toLowerCase()+\"ConstantLabel\";\r\n");
      out.write("    function resetForm(){\r\n");
      out.write("    \t clearForm($(\"#\"+formId)[0]);\r\n");
      out.write("    \t $(\"#\"+formId+\" input[name='isRelativedPath'][value='true']:radio \").attr(\"checked\", true);\r\n");
      out.write("    \t //$(\"#\"+formId+\" input[name='code']\").val((currentMenuNode.attributes['code'] ? currentMenuNode.attributes['code'] : \"root\") +\".\");\r\n");
      out.write("    }\r\n");
      out.write("    function loadFormData(){\r\n");
      out.write("    \tresetForm();\r\n");
      out.write("        var currentRowData = currentMenuNode;\r\n");
      out.write("        var arr=jQuery(\"#\"+formId)[0].elements;  \r\n");
      out.write("        jQuery.each(arr,function(k,v){  \r\n");
      out.write("\t           var name = v.name;\r\n");
      out.write("\t           if(name && (\"undefined\"!=typeof(currentRowData[name]))){\r\n");
      out.write("\t\t            v.value = currentRowData[name];\r\n");
      out.write("\t\t       }\r\n");
      out.write("        });\r\n");
      out.write("        $(\"#\"+formId+\" input[name='parent\"+constantFlag+\"']\").val(currentMenuNode.attributes['pid']);\r\n");
      out.write("        $(\"#\"+formId+\" input[name='code']\").val(currentMenuNode.attributes['code']);\r\n");
      out.write("        $(\"#\"+formId+\" input[name='name']\").val(currentMenuNode.attributes['name']);\r\n");
      out.write("        $(\"#\"+formId+\" input[name='icon']\").val(currentMenuNode.attributes['icon']);\r\n");
      out.write("        $(\"#\"+formId+\" input[name='url']\").val(currentMenuNode.attributes['url']);\r\n");
      out.write("        $(\"#\"+formId+\" textarea[name='description']\").val(currentMenuNode.attributes['description']);\r\n");
      out.write("        var isRelativedPath = currentMenuNode.attributes['isRelativedPath']+\"\";\r\n");
      out.write("        if(!isRelativedPath){\r\n");
      out.write("        \tisRelativedPath = \"true\";\r\n");
      out.write("        }\r\n");
      out.write("        $(\"#\"+formId+\" input[name='isRelativedPath'][value='\"+isRelativedPath+\"']:radio\").attr(\"checked\",true);;\r\n");
      out.write("    }\r\n");
      out.write("    function submitCallBack(){\r\n");
      out.write("    \t//loadTreeMenu(loadMask); \r\n");
      out.write("    \tvar currentReloadId = \"\";\r\n");
      out.write("    \tif(\"add\" == operFlag){\r\n");
      out.write("    \t\tcurrentReloadId = currentMenuNode.id;\r\n");
      out.write("    \t\tif(( \"0\" != currentReloadId) && $('#id_menu_tabs_menu').tree('isLeaf',currentMenuNode.target)){\r\n");
      out.write("    \t\t\tcurrentReloadId = currentMenuNode.attributes[\"pid\"];\r\n");
      out.write("        \t}\r\n");
      out.write("        }else{\r\n");
      out.write("        \tcurrentReloadId = currentMenuNode.attributes[\"pid\"];\r\n");
      out.write("        }\r\n");
      out.write("        if(!currentReloadId)\r\n");
      out.write("        {\r\n");
      out.write("        \tcurrentReloadId = currentMenuNode.id;\r\n");
      out.write("        }\r\n");
      out.write("        var currentNode = $('#id_menu_tabs_menu').tree('find',currentReloadId);\r\n");
      out.write("    \t$('#id_menu_tabs_menu').tree('reload',currentNode.target);\r\n");
      out.write("    \t$('#id_menu_tabs_menu').tree('expand',currentNode.target);\r\n");
      out.write("    }\r\n");
      out.write("    function validateForm(){\r\n");
      out.write("        return Validator.Validate(jQuery(\"#\"+formId)[0],1,false);\r\n");
      out.write("    }\r\n");
      out.write("    function addMenu(){\r\n");
      out.write("    \tresetForm();\r\n");
      out.write("\t\t var comboMenuPosition = getTracywindyObject(\"id_comboMenuPosition\");\r\n");
      out.write("\t\t comboMenuPosition.rawValue=\"最后\";\r\n");
      out.write("\t\t comboMenuPosition.value=\"\";\r\n");
      out.write("\t\t jQuery(\"#\"+constantLabelId).hide();\r\n");
      out.write("\t\t var pid = currentMenuNode.id;\r\n");
      out.write("\t\t comboMenuPosition.setParams({\r\n");
      out.write("\t            pid:pid\r\n");
      out.write("\t\t     });\r\n");
      out.write("\t\t comboMenuPosition.reload();\r\n");
      out.write("    \t$(\"#\"+formId+\" input[name='parent\"+constantFlag+\"']\").val(currentMenuNode.id);\r\n");
      out.write("    \tshowWindow();\r\n");
      out.write("    \toperFlag = \"add\";\r\n");
      out.write("    \toperPromit = \"新增\";\r\n");
      out.write("    }\r\n");
      out.write("    function updateMenu(){\r\n");
      out.write("    \tresetForm();\r\n");
      out.write("    \tloadFormData();\r\n");
      out.write("    \tupdatePosition();\r\n");
      out.write("    \tshowWindow();\r\n");
      out.write("    \toperFlag = \"update\";\r\n");
      out.write("    \toperPromit = \"修改\";\r\n");
      out.write("    }\r\n");
      out.write("    function updatePosition(){\r\n");
      out.write("    \tvar position  = currentMenuNode.attributes.position;\r\n");
      out.write("    \tvar pid  = currentMenuNode.attributes.pid;\r\n");
      out.write("    \t$(\"#\"+constantLabelId).hide();\r\n");
      out.write("    \tvar comboMenuPosition = getTracywindyObject(\"id_comboMenuPosition\");\r\n");
      out.write("\t   \tcomboMenuPosition.setParams({\r\n");
      out.write("\t         pid:pid\r\n");
      out.write("\t      });\r\n");
      out.write("\t \tcomboMenuPosition.value = position;\r\n");
      out.write("\t \tcomboMenuPosition.reload();\r\n");
      out.write("    }\r\n");
      out.write("    function removeMenu(){\r\n");
      out.write("    \tjQuery(\"#id_contextmenu\").menu('hide');\r\n");
      out.write("    \tloadFormData();\r\n");
      out.write("    \toperFlag = \"remove\";\r\n");
      out.write("    \toperPromit = \"删除\";\r\n");
      out.write("    \tuserOperation();\r\n");
      out.write("    }\r\n");
      out.write("    function showWindow(){\r\n");
      out.write("\t\tvar $window = $(\"#\"+windowContainerId);\r\n");
      out.write("\t\t$window.show();\r\n");
      out.write("\t\t$window.dialog({\r\n");
      out.write("              top:20,\r\n");
      out.write("              closable:false,\r\n");
      out.write("              draggable:false\r\n");
      out.write("        });\r\n");
      out.write("\t\t$window.dialog('open');\r\n");
      out.write("    }\r\n");
      out.write("    function userOperation(){\r\n");
      out.write("    \tif(!validateForm(formId))return;\r\n");
      out.write("        if(!window.confirm(\"确认{0}当前");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLabel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("么？\".replace(\"{0}\",operPromit)))return;\r\n");
      out.write("    \t//用户增删改查操作\r\n");
      out.write("        {\r\n");
      out.write("            var url =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/{0}.acl\".replace(\"{0}\",operFlag+constantFlag);\r\n");
      out.write("            var loadMaskMsg = \"正在{0}");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLabel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("   请稍后... \".replace(\"{0}\",operPromit);\r\n");
      out.write("            var currentLoadMask = null;\r\n");
      out.write("            switch(operFlag)\r\n");
      out.write("            {\r\n");
      out.write("\t            case \"add\"   :{\r\n");
      out.write("\t\t            if(null == loadMask_add){\r\n");
      out.write("\t\t            \tloadMask_add = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t            currentLoadMask = loadMask_add;\r\n");
      out.write("\t\t            break;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t            case \"update\":{\r\n");
      out.write("\t\t            if(null == loadMask_update){\r\n");
      out.write("\t\t            \tloadMask_update = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t            currentLoadMask = loadMask_update;\r\n");
      out.write("\t\t            break;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t            case \"remove\":{\r\n");
      out.write("\t\t            if(null == loadMask_remove){\r\n");
      out.write("\t\t            \tloadMask_remove = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t            currentLoadMask = loadMask_remove;\r\n");
      out.write("\t\t            break;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t            default:{\t\t            \r\n");
      out.write("\t\t\t        if(null == loadMask_update){\r\n");
      out.write("\t\t            \tloadMask_update = new tracywindyLoadMask(document.body,loadMaskMsg);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t            currentLoadMask = loadMask_update;\r\n");
      out.write("\t\t            break;\r\n");
      out.write("\t            }\r\n");
      out.write("           }\r\n");
      out.write("           currentLoadMask.show();\r\n");
      out.write("           var params = $('#'+formId).tracywindySerializeFormToJsonObject(true);\r\n");
      out.write("           params['isRelativedPath']=$(\"#\"+formId+\" input[name='isRelativedPath']:radio:checked\").val();\r\n");
      out.write("           params['position'] = 0;\r\n");
      out.write("           ajaxRequest({\r\n");
      out.write("                url:url,\r\n");
      out.write("                params:params,\r\n");
      out.write("                timeout:30*1000,\r\n");
      out.write("                success:function(res){\r\n");
      out.write("                    alert(\"{0}");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLabel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("成功\".replace(\"{0}\",operPromit));\r\n");
      out.write("                    try{$(\"#\"+windowContainerId).dialog('close');}catch(e){}\r\n");
      out.write("                    currentLoadMask.hide();\r\n");
      out.write("                    submitCallBack();\r\n");
      out.write("                }\r\n");
      out.write("           });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\tvar loadMask = null;\r\n");
      out.write("\t\r\n");
      out.write("    var isMenuLoaded = false;\r\n");
      out.write("    var isUserLoaded = false;\r\n");
      out.write("    var isGroupLoaded = false;\r\n");
      out.write("    \r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\tif(!isWorkflowOper)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t    document.getElementById('id_'+constantFlag.toLowerCase()+'Icon').onclick=function(e){\r\n");
      out.write("\t\t    \tcurrentPicInputId = this.id;\r\n");
      out.write("\t\t    \tshowIconPictureWindow(getEvent(e));\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t    document.getElementById('id_'+constantFlag.toLowerCase()+'Open').onclick=function(e){\r\n");
      out.write("\t\t    \tcurrentPicInputId = this.id;\r\n");
      out.write("\t\t    \tshowIconPictureWindow(getEvent(e));\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t    document.getElementById('id_'+constantFlag.toLowerCase()+'Close').onclick=function(e){\r\n");
      out.write("\t\t    \tcurrentPicInputId = this.id;\r\n");
      out.write("\t\t    \tshowIconPictureWindow(getEvent(e));\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t//下拉框\r\n");
      out.write("\t\t\tvar comboMenuPosition = new tracywindyComboBox({\r\n");
      out.write("\t\t\t\tlazyLoad:true,\r\n");
      out.write("\t\t\t       dropListHeight:200,\r\n");
      out.write("\t\t\t       id:'id_comboMenuPosition',\r\n");
      out.write("\t\t\t       width:190,\r\n");
      out.write("\t\t\t       name:'currentPosition',\r\n");
      out.write("\t\t\t       renderTo:'id_'+constantFlag.toLowerCase()+'PositionContainer',\r\n");
      out.write("\t\t\t       loadMode:'ajax',\r\n");
      out.write("\t\t\t       readOnly:true,\r\n");
      out.write("\t\t\t       //xmlFileName:'\\\\combos\\\\combo'+constantFlag+'Position.xml',\r\n");
      out.write("\t\t\t       xmlFileName:'\\\\combos\\\\comboPosition.xml',\r\n");
      out.write("\t\t\t       isCheck:false,\r\n");
      out.write("\t\t\t       leftAdd:1,\r\n");
      out.write("\t\t\t       params:{\r\n");
      out.write("\t\t\t          tablename:(\"t_\"+constantFlag+\"s\").toUpperCase(),\r\n");
      out.write("\t                  pid:'-1'\r\n");
      out.write("\t\t\t       },\r\n");
      out.write("\t\t\t       onSelect:function(combo){\r\n");
      out.write("\t\t\t          var currentRawValue = combo.getRawValue();\r\n");
      out.write("\t\t\t          \r\n");
      out.write("\t\t\t          if((\"第一位\" == currentRawValue)||(\"最后\" == currentRawValue))\r\n");
      out.write("\t\t\t          {\r\n");
      out.write("\t\t\t\t          jQuery(\"#\"+constantLabelId).hide();\r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t          else\r\n");
      out.write("\t\t\t          {\r\n");
      out.write("\t\t\t        \t  jQuery(\"#\"+constantLabelId).show();\r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t       }\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(null == loadMask){\r\n");
      out.write("\t\t\tloadMask = new tracywindyLoadMask(document.body,\"数据加载中 请稍后...\");\r\n");
      out.write("\t    }\r\n");
      out.write("\t    isMenuLoaded = false;\r\n");
      out.write("\t    loadMask.show();\r\n");
      out.write("\t    //加载树形\r\n");
      out.write("\t    var curUrl = isWorkflowOper ? ('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/getDeployedWorkflowsTreeData.action') : ('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/table/get'+constantFlag+'TreeData.action');\r\n");
      out.write("\t    \r\n");
      out.write("\t\t$('#id_menu_tabs_menu').tree({\r\n");
      out.write("\t\t\turl:curUrl,\r\n");
      out.write("\t\t\tdnd:isWorkflowOper ? false :true ,\r\n");
      out.write("\t\t\tonDrop:function(a,b,c){\r\n");
      out.write("\t\t\t   var toNodeId    = $(a).attr(\"node-id\");\r\n");
      out.write("\t\t\t   var toNode = $('#id_menu_tabs_menu').tree('find',toNodeId);\r\n");
      out.write("\t\t\t   var fromNodeId = b.id;\r\n");
      out.write("\t\t\t   var text = toNode.text;\r\n");
      out.write("\t\t\t   var currentPosition = toNode.attributes['position'];\r\n");
      out.write("\t\t\t   var pid             = toNode.id;\r\n");
      out.write("\t\t\t   var parentNode = $('#id_menu_tabs_menu').tree('getParent',toNode.target);\r\n");
      out.write("\t\t\t   if((\"0\" == toNodeId)&&(\"append\"!=c)){\r\n");
      out.write("\t\t\t\t   return false;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t   switch(c){\r\n");
      out.write("\t\t\t      case  'append':{\r\n");
      out.write("\t\t\t    \t  var childrenNodes = $('#id_menu_tabs_menu').tree('getChildren',toNode.target);\r\n");
      out.write("\t\t\t\t\t  var  childrenLen = childrenNodes.length;\r\n");
      out.write("\t\t\t\t\t  if(0 == childrenLen){\r\n");
      out.write("\t\t\t\t\t\t  currentPosition = -1;\r\n");
      out.write("\t\t\t\t      }else{\r\n");
      out.write("\t\t\t\t    \t  currentPosition = childrenNodes[childrenNodes.length-1].attributes['position'];\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t      break;\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t      case  'top':{\r\n");
      out.write("\t\t\t    \t  pid = parentNode.id;\r\n");
      out.write("\t\t\t    \t  currentPosition = -1;\r\n");
      out.write("\t\t\t\t      var childrenNodes = $('#id_menu_tabs_menu').tree('getChildren',parentNode.target);\r\n");
      out.write("\t\t\t\t      for(var i = 0;i<childrenNodes.length;i++){\r\n");
      out.write("\t\t\t\t    \t  var childNode = childrenNodes[i];\r\n");
      out.write("\t\t\t\t    \t  if(toNodeId == childNode.id){\r\n");
      out.write("\t\t\t\t\t    \t  if(i > 0){\r\n");
      out.write("\t\t\t\t\t    \t\t  currentPosition = childrenNodes[i-1].attributes['position'];\r\n");
      out.write("\t\t\t\t\t\t      }\r\n");
      out.write("\t\t\t\t    \t\t  break;\r\n");
      out.write("\t\t\t\t\t      } \r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t    \t  break;\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t      case  'bottom':{\r\n");
      out.write("\t\t\t    \t  pid = parentNode.id;\r\n");
      out.write("\t\t\t    \t  break;\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t   loadMask.show();\r\n");
      out.write("\t\t\t    var params = {id:fromNodeId,entityClassSimpleName:constantFlag,parentId:pid,currentPosition:currentPosition};\r\n");
      out.write("\t\t\t\tajaxRequest({\r\n");
      out.write("\t\t\t        url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/updatePosition.acl\",\r\n");
      out.write("\t\t\t        success:function(res){\r\n");
      out.write("\t\t\t\t       //modify by tracywindy 2013-09-28 revise the position is null's bug\r\n");
      out.write("\t\t\t           b.attributes.pid = pid;\r\n");
      out.write("\t\t\t\t       currentPosition = (-1 == parseInt(currentPosition)) ? 1 : (parseInt(currentPosition)+1);\r\n");
      out.write("\t\t\t\t       b.attributes.position = \"\"+currentPosition;\r\n");
      out.write("\t\t\t           loadMask.hide();\r\n");
      out.write("\t\t\t        },\r\n");
      out.write("\t\t\t        failure:function(res){alert(\"操作失败\");loadMask.hide();},\r\n");
      out.write("\t\t\t        params:params\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t   return true;\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonBeforeLoad:function(node,params){\r\n");
      out.write("\t\t\t\tif(loadMask){\r\n");
      out.write("\t\t\t\t\tloadMask.show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t    if(isWorkflowOper){\r\n");
      out.write("\t\t\t\t\tif(!node){\r\n");
      out.write("\t\t\t\t\t\tparams['init'] = true; \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tparams['typeId'] = node.id;\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tparams['pid']  = node ? node.id : \"0\";\r\n");
      out.write("\t\t\t\t\tif(!node){\r\n");
      out.write("\t\t\t\t\t\tparams['init'] = true; \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonLoadSuccess:function(a,b){\r\n");
      out.write("\t\t\t\tisMenuLoaded = true;\r\n");
      out.write("\t\t\t\tif(isUserLoaded && isGroupLoaded){\r\n");
      out.write("\t\t\t\t\tloadMask.hide();\r\n");
      out.write("\t\t\t    };\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    onContextMenu:function(event,node){\r\n");
      out.write("\t\t\t\tnode.target.style.width = ($('#id_menu_tabs_menu')[0].scrollWidth-5)+\"px\";\r\n");
      out.write("\t\t\t\tcurrentMenuSelectNode = node;\r\n");
      out.write("\t\t\t\t$(\".flagUserSelectContainer\").html(node.attributes.name);\r\n");
      out.write("\t\t    \t//$(\".flagUserSelectContainer\").html(\"\");\r\n");
      out.write("\t\t    \t//reloadInitTree();\r\n");
      out.write("\t\t    \tstopDefault(event);\r\n");
      out.write("\t\t    \tif(isWorkflowOper){\r\n");
      out.write("\t\t\t    \treturn;\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t\tvar x = event.clientX;\r\n");
      out.write("\t\t\t\tvar y = event.clientY;\r\n");
      out.write("\t\t\t    if(\"user\" == node.attributes[\"type\"]){\r\n");
      out.write("\t\t\t    \tcurrentMenuRemoveUserNode = node;\r\n");
      out.write("\t\t\t\t\tjQuery(\"#id_contextmenu_remove\").menu('show',{\r\n");
      out.write("\t\t\t\t\t\tleft:event.pageX||x,\r\n");
      out.write("\t\t\t\t\t\ttop: event.pageY||y\r\n");
      out.write("\t\t\t\t    });\r\n");
      out.write("\t\t\t    \treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tcurrentOperTree = \"menuTree\";\r\n");
      out.write("\t\t\t\tcurrentMenuNode = node;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar menuItems = jQuery(\"#id_contextmenu div.menu-item\");\r\n");
      out.write("\t\t\t\tmenuItems.each(function(i){\r\n");
      out.write("\t\t\t\t\tif((\"0\" == node.id)&&(2 == i) ){\r\n");
      out.write("\t\t\t\t\t\tthis.style.display=\"none\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tif(!$('#id_menu_tabs_menu').tree('isLeaf',currentMenuNode.target) && (2 == i)){\r\n");
      out.write("\t\t\t\t\t\t\tthis.style.display=\"none\";\r\n");
      out.write("\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\t\tthis.style.display=\"block\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t // this.disabled = false;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tjQuery(\"#id_contextmenu\").menu('show',{\r\n");
      out.write("\t\t\t\t\tleft:event.pageX||x,\r\n");
      out.write("\t\t\t\t\ttop: event.pageY||y\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t\t$('#id_menu_tabs_menu').tree('select',node.target);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t    onClick:function(node){\r\n");
      out.write("\t\t\t\tnode.target.style.width = ($('#id_menu_tabs_menu')[0].scrollWidth-5)+\"px\";\r\n");
      out.write("\t\t\t    var isType = false;\r\n");
      out.write("\t\t    \tif(!node.attributes)isType=true;\r\n");
      out.write("\t\t    \tif(isWorkflowOper){\r\n");
      out.write("\t\t\t    \tif(node.attributes){\r\n");
      out.write("\t\t\t\t    \tif(!node.attributes[\"typeId\"])isType=true;\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t    \tif(!isType)\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t\t\tcurrentMenuSelectNode = node;\r\n");
      out.write("\t\t\t\t\t$(\".flagUserSelectContainer\").html(node.attributes.name);\r\n");
      out.write("\t\t\t\t\treloadOperTree();\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar pageWidth  = document.documentElement.clientWidth;\r\n");
      out.write("\tvar pageHeight = document.documentElement.clientHeight-10;\r\n");
      out.write("\tvar loadMask = null;\r\n");
      out.write("\tjQuery(function(){\r\n");
      out.write("\t\tif(null == loadMask){\r\n");
      out.write("\t\t\tloadMask = new tracywindyLoadMask(document.body,\"数据加载中 请稍后...\");\r\n");
      out.write("\t    }\r\n");
      out.write("\t\tloadMask.show();\r\n");
      out.write("\t\treloadInitTree();\r\n");
      out.write("   });\r\n");
      out.write("   var currentCheckedNode = null;\r\n");
      out.write("   function reloadInitTree(){\r\n");
      out.write("\t    var isReload = false;\r\n");
      out.write("\t    try{\r\n");
      out.write("\t    \tisReload = $('#id_menu_main_content_div').tree('options').checkbox;\r\n");
      out.write("\t\t}catch(e){\r\n");
      out.write("\t\t\tisReload = true;\r\n");
      out.write("\t\t\tloadMask.show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!isReload)return;\r\n");
      out.write("\t    //加载树形\r\n");
      out.write("\t    isUserLoaded = false;\r\n");
      out.write("\t\t$('#id_menu_main_content_div').tree({\r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/table/get'+constantFlag+'DeptAllTreeData.action',\r\n");
      out.write("\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\tonLoadSuccess:function(a,b){\r\n");
      out.write("\t\t\t\tisUserLoaded = true;\r\n");
      out.write("\t\t\t\tif(isMenuLoaded && isGroupLoaded){\r\n");
      out.write("\t\t\t\t\tloadMask.hide();\r\n");
      out.write("\t\t\t    };\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t\tonBeforeLoad:function(node,params){\r\n");
      out.write("\t\t\t\tif(loadMask){\r\n");
      out.write("\t\t\t\t\tloadMask.show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams['pid']  = node ? node.id : \"0\";\r\n");
      out.write("\t\t\t\tif(!node){\r\n");
      out.write("\t\t\t\t\tparams['init'] = true; \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t    //加载树形\r\n");
      out.write("\t    isGroupLoaded = false;\r\n");
      out.write("\t\t$('#id_menu_main_content_div_right').tree({\r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/table/get'+constantFlag+'GroupTreeData.action',\r\n");
      out.write("\t\t\tcheckbox:false,\r\n");
      out.write("\t\t\tonLoadSuccess:function(a,b){\r\n");
      out.write("\t\t\t\tisGroupLoaded = true;\r\n");
      out.write("\t\t\t\tif(isMenuLoaded && isUserLoaded){\r\n");
      out.write("\t\t\t\t\tloadMask.hide();\r\n");
      out.write("\t\t\t    };\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t\tonBeforeLoad:function(node,params){\r\n");
      out.write("\t\t\t\tif(loadMask){\r\n");
      out.write("\t\t\t\t\tloadMask.show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams['pid']  = node ? node.id : \"0\";\r\n");
      out.write("\t\t\t\tif(!node){\r\n");
      out.write("\t\t\t\t\tparams['init'] = true; \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("   }\r\n");
      out.write("   var $tree = $('#id_menu_tabs_menu').tree;\r\n");
      out.write("   function recursionChecked(rootNode,checked){\r\n");
      out.write("\t   var childrenNodes =  $tree('getChildren',rootNode.target);\r\n");
      out.write("       for(var i=0;i<childrenNodes.length;i++){\r\n");
      out.write("           var childrenNode = childrenNodes[i];\r\n");
      out.write("           var type = childrenNode.attributes[\"type\"];\r\n");
      out.write("           if(\"dept\"==type){\r\n");
      out.write("               var $checkbox = $(childrenNode.target).find(\"span.tree-checkbox\");\r\n");
      out.write("               if(checked){\r\n");
      out.write("            \t   //$tree(\"check\"  ,childrenNode.target);\r\n");
      out.write("            \t   $checkbox.removeClass(\"tree-checkbox0\");\r\n");
      out.write("            \t   $checkbox.addClass(\"tree-checkbox1\");\r\n");
      out.write("               }else{\r\n");
      out.write("            \t   //$tree(\"uncheck\",childrenNode.target);\r\n");
      out.write("            \t   $checkbox.removeClass(\"tree-checkbox1\");\r\n");
      out.write("            \t   $checkbox.addClass(\"tree-checkbox0\");\r\n");
      out.write("               }\r\n");
      out.write("               recursionChecked(childrenNode,checked);\r\n");
      out.write("           }\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("   function reloadOperTree(){\r\n");
      out.write("\t    //加载树形\r\n");
      out.write("\t    isUserLoaded = false; \r\n");
      out.write("\t    loadMask.show();\r\n");
      out.write("\t\t$('#id_menu_main_content_div').tree({\r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/table/get'+constantFlag+'DeptAllTreeData.action',\r\n");
      out.write("\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\tcascadeCheck:false,\r\n");
      out.write("\t\t\tonBeforeLoad:function(node,params){\r\n");
      out.write("\t\t\t\tif(loadMask){\r\n");
      out.write("\t\t\t\t\tloadMask.show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams['pid']  = node ? node.id : \"0\";\r\n");
      out.write("\t\t\t\tparams['menuId']  = currentMenuSelectNode.id;\r\n");
      out.write("\t\t\t\tif(!node){\r\n");
      out.write("\t\t\t\t\tparams['init'] = true; \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t    },\r\n");
      out.write("            onLoadSuccess:function(a,b){\r\n");
      out.write("\t\t\t\t/*$(\"#id_menu_main_content_div span.tree-checkbox\").click(function(e){\r\n");
      out.write("\t\t\t\t\tdistribute(currentCheckedNode);\r\n");
      out.write("\t\t\t\t\tvar checked = false;\r\n");
      out.write("\t\t\t\t\tvar currentTarget = e.currentTarget||e.target;\r\n");
      out.write("\t\t\t\t\tif(currentTarget.className.indexOf(\"tree-checkbox1\")>-1){\r\n");
      out.write("\t\t\t\t\t\tchecked = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\trecursionChecked(currentCheckedNode,checked);\r\n");
      out.write("\t\t\t\t});*/\r\n");
      out.write("\t\t\t\t$(\"#id_menu_main_content_div span.tree-checkbox\").each(function(i){\r\n");
      out.write("\t\t\t\t\tthis.onclick=function(e){\r\n");
      out.write("\t\t\t\t\t\tvar currentTarget = getTarget(e);\r\n");
      out.write("\t\t\t\t\t\tvar nodeId = (currentTarget.parentNode.getAttribute(\"node-id\"));\r\n");
      out.write("\t\t\t\t\t\tcurrentCheckedNode = $('#id_menu_main_content_div').tree('find',nodeId);\r\n");
      out.write("\t\t\t\t\t\tdistribute(currentCheckedNode);\r\n");
      out.write("\t\t\t\t\t\tvar checked = false;\r\n");
      out.write("\t\t\t\t\t\tif(currentTarget.className.indexOf(\"tree-checkbox1\")>-1){\r\n");
      out.write("\t\t\t\t\t\t\tchecked = true;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\trecursionChecked(currentCheckedNode,checked);\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tisUserLoaded = true;\r\n");
      out.write("\t\t\t\tif(isMenuLoaded && isGroupLoaded){\r\n");
      out.write("\t\t\t\t\tloadMask.hide();\r\n");
      out.write("\t\t\t    };\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t\tonCheck:function(node,checked){\r\n");
      out.write("\t\t    \tcurrentCheckedNode = node;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t    //加载树形\r\n");
      out.write("\t    isGroupLoaded = false; \r\n");
      out.write("\t    loadMask.show();\r\n");
      out.write("\t\t$('#id_menu_main_content_div_right').tree({\r\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/table/get'+constantFlag+'GroupTreeData.action',\r\n");
      out.write("\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\tcascadeCheck:false,\r\n");
      out.write("\t\t\tonlyLeafCheck:true,\r\n");
      out.write("\t\t\tonBeforeLoad:function(node,params){\r\n");
      out.write("\t\t\t\tif(loadMask){\r\n");
      out.write("\t\t\t\t\tloadMask.show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tparams['pid']  = node ? node.id : \"0\";\r\n");
      out.write("\t\t\t\tparams['menuId']  = currentMenuSelectNode.id;\r\n");
      out.write("\t\t\t\tif(!node){\r\n");
      out.write("\t\t\t\t\tparams['init'] = true; \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonLoadSuccess:function(a,b){\r\n");
      out.write("\t\t\t\t/*$(\"#id_menu_main_content_div_right span.tree-checkbox\").click(function(e){\r\n");
      out.write("\t\t\t\t\tdistribute(currentCheckedNode);\r\n");
      out.write("\t\t\t\t});*/\r\n");
      out.write("\t\t\t\t$(\"#id_menu_main_content_div_right span.tree-checkbox\").each(function(i){\r\n");
      out.write("\t\t\t\t\tthis.onclick=function(e){\r\n");
      out.write("\t\t\t\t\t\tvar currentTarget = getTarget(e);\r\n");
      out.write("\t\t\t\t\t\tvar nodeId = (currentTarget.parentNode.getAttribute(\"node-id\"));\r\n");
      out.write("\t\t\t\t\t\tcurrentCheckedNode = $('#id_menu_main_content_div_right').tree('find',nodeId);\r\n");
      out.write("\t\t\t\t\t\tdistribute(currentCheckedNode);\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tisGroupLoaded = true;\r\n");
      out.write("\t\t\t\tif(isMenuLoaded && isUserLoaded){\r\n");
      out.write("\t\t\t\t\tloadMask.hide();\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t\tonCheck:function(node,checked){\r\n");
      out.write("\t\t    \tcurrentCheckedNode = node;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("   }\r\n");
      out.write("\t   \r\n");
      out.write("\t//加载人员选择\r\n");
      out.write("\tvar currentMenuSelectNode = null;\r\n");
      out.write("\tvar firstReloaded = false;\r\n");
      out.write("\tfunction distribute(node){\r\n");
      out.write("\t\tloadMask.show();\r\n");
      out.write("\t\tvar firstLetter = constantFlag.substring(0,1);\r\n");
      out.write("\t\tvar dealField = constantFlag.replace(firstLetter,firstLetter.toLowerCase());\r\n");
      out.write("        var entityClassName = node.attributes[dealField+\"EntityClassName\"];\r\n");
      out.write("        var leftFieldName = dealField;\r\n");
      out.write("        var leftId = currentMenuSelectNode.id;\r\n");
      out.write("        var rightFieldName = node.attributes[\"type\"];;\r\n");
      out.write("        var rightId = node.id;\r\n");
      out.write("\t    var params = {\r\n");
      out.write("\t             entityClassName:entityClassName,\r\n");
      out.write("\t       \t\t leftFieldName  :leftFieldName,\r\n");
      out.write("\t       \t\t leftId         :leftId,\r\n");
      out.write("\t       \t\t rightFieldName :rightFieldName,\r\n");
      out.write("\t       \t\t rightId        :rightId\r\n");
      out.write("\t        };\r\n");
      out.write("\t\t var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/addOrRemoveDistribute.acl\";\r\n");
      out.write("         ajaxRequest({\r\n");
      out.write("              url:url,\r\n");
      out.write("              params:params,\r\n");
      out.write("              timeout:30*1000,\r\n");
      out.write("              success:function(res){\r\n");
      out.write("                  loadMask.hide();\r\n");
      out.write("              }\r\n");
      out.write("         });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='menu_main_content' style=\"float:left;width:325px;overflow:hidden;border:1px solid #DDD;border-top:0px;border-right:0px;padding:5px;\">\r\n");
      out.write("\t   <div class=\"panel-title\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLabel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("列表</div>\r\n");
      out.write("       <div id=\"id_menu_tabs_menu\" style=\"border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;\" oncontextmenu='cancelBubble(event);' ></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id='menu_main_oper' style=\"overflow:hidden;float:left;border-bottom:1px solid #DDD;padding:5px;\">\r\n");
      out.write("\t   <div class=\"panel-title\" ><font color=\"red\" class=\"flagUserSelectContainer\"></font>&nbsp;&nbsp;部门-角色-人员&nbsp;分配</div>\r\n");
      out.write("\t   <div id='id_menu_main_content_div' style=\"border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id='menu_main_oper_right' style=\"overflow:hidden;float:left;border:1px solid #DDD;border-left:0px;border-top:0px;padding:5px;\">\r\n");
      out.write("\t   <div class=\"panel-title\" ><font color=\"red\" class=\"flagUserSelectContainer\"></font>&nbsp;&nbsp;群组&nbsp;分配</div>\r\n");
      out.write("\t   <div id='id_menu_main_content_div_right' style=\"border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type='text/javascript'>\r\n");
      out.write("\t    var heightAdd = -2;\r\n");
      out.write("\t    var widthAdd  = -358;\r\n");
      out.write("\t\tjQuery(\"#menu_main_content\").css(\"height\",(pageHeight+heightAdd)+\"px\");\r\n");
      out.write("\t\tjQuery(\"#id_menu_tabs_menu\").css(\"height\",(pageHeight+heightAdd-40)+\"px\");\r\n");
      out.write("\t\tjQuery(\"#id_menu_main_content_div\").css(\"height\",(pageHeight+heightAdd-40)+\"px\");\r\n");
      out.write("\t\tjQuery(\"#id_menu_main_content_div_right\").css(\"height\",(pageHeight+heightAdd-40)+\"px\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tjQuery(\"#menu_main_oper\").css(\"height\",(pageHeight+heightAdd)+\"px\");\r\n");
      out.write("\t\tjQuery(\"#menu_main_oper_right\").css(\"height\",(pageHeight+heightAdd)+\"px\");\r\n");
      out.write("\t\tjQuery(\"#menu_main_oper\").css(\"width\",((pageWidth + widthAdd)/2 )+\"px\");\r\n");
      out.write("\t\tjQuery(\"#menu_main_oper_right\").css(\"width\",((pageWidth + widthAdd)/2 )+\"px\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<div id=\"id_menuDetailInfoWindowContianer\"  buttons=\"#id-dlg-buttons-menu\" closed=\"true\" modal=\"true\" title=\"菜单信息管理\" style=\"display:none;width:400px;padding-top:10px;height:360px;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t\t  <form id=\"id_menuDetailInfoForm\">\r\n");
      out.write("\t\t\t        <table style=\"width:90%;\">\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"id\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"parentMenu\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">菜单名称:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"菜单名称\"  name=\"name\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">菜单编号:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"菜单编号\"  name=\"code\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">菜单url:      </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"url\" /><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">&nbsp;&nbsp;</td><td colspan=2 >\r\n");
      out.write("\t\t\t             <input type=\"radio\" name=\"isRelativedPath\" value=\"true\"/>相对路径&nbsp;&nbsp;\r\n");
      out.write("\t\t\t             <input type=\"radio\" name=\"isRelativedPath\" value=\"false\" />绝对路径</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">菜单图标:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"icon\" id=\"id_menuIcon\" readOnly/><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none;\"><td class=\"input_label_desc\">菜单打开图标: </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"iconClose\" id=\"id_menuOpen\" readOnly /><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none;\"><td class=\"input_label_desc\">菜单关闭图标: </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"iconOpen\" id=\"id_menuClose\" readOnly/><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">菜单描述:     </td><td  colspan=2 class=\"input_value\"><textarea name=\"description\"></textarea><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t             <tr><td colspan=3><div style=\"width:100%;height:5px;\">&nbsp;</div></td></tr>\r\n");
      out.write("\t\t\t            <tr><td colspan=3><div style=\"width:100%;border-top:1px solid #DDD;\"></div></td></tr>\r\n");
      out.write("\t\t\t            <tr><td colspan=3><div style=\"width:100%;height:5px;\">&nbsp;</div></td></tr>\r\n");
      out.write("\t\t\t            <tr  ><td  class=\"input_label_desc\" colspan=3><span style=\"float:left;margin-left:50px;\">排在&nbsp;&nbsp;</span><span style=\"float:left;\" id=\"id_menuPositionContainer\"></span><span style=\"float:left;\" id=\"id_menuConstantLabel\">&nbsp;&nbsp;之后</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"enabled\" type=\"hidden\" value=\"true\"/></td></tr>\r\n");
      out.write("\t\t\t            <!--  \r\n");
      out.write("\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t            <td colspan=3>\r\n");
      out.write("\t\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='userOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_menuDetailInfoWindowContianer\").dialog(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t            </td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            -->\r\n");
      out.write("\t\t\t        </table>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"text-align:center;width:400px;display:none;height:40px;line-height:40px;\" id=\"id-dlg-buttons-menu\">\r\n");
      out.write("\t\t  <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='userOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t  <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_menuDetailInfoWindowContianer\").dialog(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<div id=\"id_resourceDetailInfoWindowContianer\"  buttons=\"#id-dlg-buttons-resource\"  closed=\"true\" modal=\"true\" title=\"资源信息管理\" style=\"display:none;width:400px;padding-top:10px;height:340px;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t\t  <form id=\"id_resourceDetailInfoForm\">\r\n");
      out.write("\t\t\t        <table style=\"width:90%\">\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"id\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"parentResource\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">资源名称:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"资源名称\"  name=\"name\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">资源编号:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"资源编号\"  name=\"code\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">资源url:      </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"资源 URL\"  name=\"url\" /><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td class=\"input_label_desc\">&nbsp;&nbsp;</td><td colspan=2 >\r\n");
      out.write("\t\t\t             <input type=\"radio\" name=\"isRelativedPath\" value=\"true\"/>相对路径&nbsp;&nbsp;\r\n");
      out.write("\t\t\t             <input type=\"radio\" name=\"isRelativedPath\" value=\"false\" />绝对路径</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">资源图标:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"icon\" id=\"id_resourceIcon\" readOnly/><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none;\"><td class=\"input_label_desc\">资源打开图标: </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"iconClose\" id=\"id_resourceOpen\" readOnly /><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none;\"><td class=\"input_label_desc\">资源关闭图标: </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"iconOpen\" id=\"id_resourceClose\" readOnly/><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">资源描述:     </td><td  colspan=2 class=\"input_value\"><textarea name=\"description\"></textarea><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t             <tr><td colspan=3><div style=\"width:100%;height:5px;\">&nbsp;</div></td></tr>\r\n");
      out.write("\t\t\t            <tr><td colspan=3><div style=\"width:100%;border-top:1px solid #DDD;\"></div></td></tr>\r\n");
      out.write("\t\t\t            <tr><td colspan=3><div style=\"width:100%;height:5px;\">&nbsp;</div></td></tr>\r\n");
      out.write("\t\t\t            <tr  ><td  class=\"input_label_desc\" colspan=3><span style=\"float:left;margin-left:50px;\">排在&nbsp;&nbsp;</span><span style=\"float:left;\" id=\"id_resourcePositionContainer\"></span><span style=\"float:left;\" id=\"id_resourceConstantLabel\">&nbsp;&nbsp;之后</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"enabled\" type=\"hidden\" value=\"true\"/></td></tr>\r\n");
      out.write("\t\t\t            <!--  \r\n");
      out.write("\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t            <td colspan=3>\r\n");
      out.write("\t\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='userOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_resourceDetailInfoWindowContianer\").dialog(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t            </td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            -->\r\n");
      out.write("\t\t\t        </table>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"text-align:center;width:400px;display:none;height:40px;line-height:40px;\" id=\"id-dlg-buttons-resource\">\r\n");
      out.write("\t\t  <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='userOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t  <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_resourceDetailInfoWindowContianer\").dialog(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t<div id=\"id_actionDetailInfoWindowContianer\"  buttons=\"#id-dlg-buttons-action\"  closed=\"true\" modal=\"true\" title=\"操作信息管理\" style=\"display:none;width:400px;padding-top:10px;height:340px;\">\r\n");
      out.write("\t        <center>\r\n");
      out.write("\t\t\t  <form id=\"id_actionDetailInfoForm\">\r\n");
      out.write("\t\t\t        <table style=\"width:90%\">\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"id\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"parentAction\" type=\"hidden\" value=\"\"/></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">操作名称:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"操作名称\"  name=\"name\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">操作编号:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" require=\"true\" label=\"操作编号\"  name=\"code\"/><span class=\"content-required\">*</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td class=\"input_label_desc\">操作url:      </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"url\" /><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td class=\"input_label_desc\">&nbsp;&nbsp;</td><td colspan=2 >\r\n");
      out.write("\t\t\t             <input type=\"radio\" name=\"isRelativedPath\" value=\"true\"/>相对路径&nbsp;&nbsp;\r\n");
      out.write("\t\t\t             <input type=\"radio\" name=\"isRelativedPath\" value=\"false\" />绝对路径</td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">操作图标:     </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"icon\" id=\"id_actionIcon\" readOnly/><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none;\"><td class=\"input_label_desc\">操作打开图标: </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"iconClose\" id=\"id_actionOpen\" readOnly /><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none;\"><td class=\"input_label_desc\">操作关闭图标: </td><td  colspan=2 class=\"input_value\"><input  type=\"text\" name=\"iconOpen\" id=\"id_actionClose\" readOnly/><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t            <tr><td class=\"input_label_desc\">操作描述:     </td><td  colspan=2 class=\"input_value\"><textarea name=\"description\"></textarea><span class=\"content-required\">&nbsp;&nbsp;</span></td></tr>\r\n");
      out.write("\t\t\t             <tr><td colspan=3><div style=\"width:100%;height:5px;\">&nbsp;</div></td></tr>\r\n");
      out.write("\t\t\t            <tr><td colspan=3><div style=\"width:100%;border-top:1px solid #DDD;\"></div></td></tr>\r\n");
      out.write("\t\t\t            <tr><td colspan=3><div style=\"width:100%;height:5px;\">&nbsp;</div></td></tr>\r\n");
      out.write("\t\t\t            <tr  ><td  class=\"input_label_desc\" colspan=3><span style=\"float:left;margin-left:50px;\">排在&nbsp;&nbsp;</span><span style=\"float:left;\" id=\"id_actionPositionContainer\"></span><span style=\"float:left;\" id=\"id_actionConstantLabel\">&nbsp;&nbsp;之后</span></td></tr>\r\n");
      out.write("\t\t\t            <tr style=\"display:none\"><td><input name=\"enabled\" type=\"hidden\" value=\"true\"/></td></tr>\r\n");
      out.write("\t\t\t            <!--  \r\n");
      out.write("\t\t\t            <tr class=\"content-separator\">\r\n");
      out.write("\t\t\t\t            <td colspan=3>\r\n");
      out.write("\t\t\t\t                 <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\"onclick='userOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t\t\t\t\t         <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_actionDetailInfoWindowContianer\").dialog(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t\t\t\t            </td>\r\n");
      out.write("\t\t\t            </tr>\r\n");
      out.write("\t\t\t            -->\r\n");
      out.write("\t\t\t        </table>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t        </center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"text-align:center;width:400px;display:none;height:40px;line-height:40px;\" id=\"id-dlg-buttons-action\">\r\n");
      out.write("\t\t  <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='userOperation();'><span>确定</span></a>\r\n");
      out.write("\t\t  <a  style=\"margin-left:20px;\" href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick='jQuery(\"#id_actionDetailInfoWindowContianer\").dialog(\"close\");'><span>取消</span></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"id_contextmenu\" class=\"easyui-menu\" style=\"display:none;width:120px;\">\r\n");
      out.write("\t\t<div iconCls=\"icon-plus-w\" onclick='addMenu();'>添加</div>\t\r\n");
      out.write("\t\t<div iconCls=\"icon-cogs-w\" onclick='updateMenu();'>修改</div>\r\n");
      out.write("\t\t<div iconCls=\"icon-minus-w\" onclick='removeMenu();'>删除</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"id_pictureContainer\" style=\"display:none;text-align:center;width:300px;height:300px;overflow:auto;\"  closed=\"true\" modal=\"true\" title=\"图片选择器\"></div>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("constantFlag");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(5,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new String("Menu"));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("currentLabel");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new String("菜单"));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(7,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'Resource' eq param.currentFlag}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f2(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f3(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(8,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("constantFlag");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(8,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new String("Resource"));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(9,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("currentLabel");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(9,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue(new String("资源"));
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(11,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'Action' eq param.currentFlag}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f4(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f5(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(12,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setVar("constantFlag");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(12,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setValue(new String("Action"));
    int _jspx_eval_c_005fset_005f4 = _jspx_th_c_005fset_005f4.doStartTag();
    if (_jspx_th_c_005fset_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(13,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setVar("currentLabel");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(13,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setValue(new String("操作"));
    int _jspx_eval_c_005fset_005f5 = _jspx_th_c_005fset_005f5.doStartTag();
    if (_jspx_th_c_005fset_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(15,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'WorkflowStart' eq param.currentFlag}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f6(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f7(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f6 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(16,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setVar("constantFlag");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(16,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setValue(new String("WorkflowStart"));
    int _jspx_eval_c_005fset_005f6 = _jspx_th_c_005fset_005f6.doStartTag();
    if (_jspx_th_c_005fset_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f7 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(17,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setVar("currentLabel");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(17,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setValue(new String("可发起流程"));
    int _jspx_eval_c_005fset_005f7 = _jspx_th_c_005fset_005f7.doStartTag();
    if (_jspx_th_c_005fset_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(19,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'WorkflowView' eq param.currentFlag}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f8(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_c_005fset_005f9(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f8 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(20,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setVar("constantFlag");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(20,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setValue(new String("WorkflowView"));
    int _jspx_eval_c_005fset_005f8 = _jspx_th_c_005fset_005f8.doStartTag();
    if (_jspx_th_c_005fset_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f9 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(21,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setVar("currentLabel");
    // /WEB-INF/jsps/solutions/permission/menu.jsp(21,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setValue(new String("可查看流程"));
    int _jspx_eval_c_005fset_005f9 = _jspx_th_c_005fset_005f9.doStartTag();
    if (_jspx_th_c_005fset_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(61,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${('WorkflowStart' eq param.currentFlag)}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<script type='text/javascript'>\r\n");
        out.write("\t\t  var isWorkflowOper = true;\r\n");
        out.write("\t\t</script>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f5.setParent(null);
    // /WEB-INF/jsps/solutions/permission/menu.jsp(66,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${('WorkflowView' eq param.currentFlag)}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
    if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<script type='text/javascript'>\r\n");
        out.write("\t\t  var isWorkflowOper = true;\r\n");
        out.write("\t\t</script>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
    return false;
  }
}
