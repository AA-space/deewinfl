package org.apache.jsp.WEB_002dINF.jsps.solutions.acl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_005ftree_005fmenu_005fmap_005fcontent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(3);
    _jspx_dependants.add("/WEB-INF/tlds/security.tld");
    _jspx_dependants.add("/WEB-INF/tlds/c.tld");
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody != null) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.release();
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

      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t  \r\n");
      out.write("\t\r\n");
      out.write("\t<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("    <html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("\t   \t<!--css sheet-->\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/dtree/dtree.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/easyui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery-easyui/icon.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/tracywindy.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/main.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/tracywindy/button.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<!--javascript libray-->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyUtils.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyJsonUtil.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyAjax.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/tracywindy/tracywindyLoadMask.js\"></script>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t       #id_menuMapContainer{\r\n");
      out.write("\t\t\t\t\tcolor:#87A5C8;\r\n");
      out.write("\t\t\t\t\toverflow:auto;\r\n");
      out.write("\t\t\t\t\tborder:1px solid #DDD;\r\n");
      out.write("\t\t\t\t\tborder-top:0px;\r\n");
      out.write("\t\t\t\t\tpadding:5px;\r\n");
      out.write("\t\t\t\t\tpadding-top:0px;\r\n");
      out.write("\t\t\t\t\tfont-size:12px;\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t\t       #id_menuMapContainer div{\r\n");
      out.write("\t\t\t\t\twhite-space:nowrap;\r\n");
      out.write("\t\t\t\t\tword-wrap:normal;\r\n");
      out.write("\t\t\t\t\tword-break:break-all;\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t\t\t.btn-bg { \r\n");
      out.write("\t\t\t\tbackground:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/ibtnbg.png) repeat-x;\r\n");
      out.write("\t\t\t\tborder:solid 1px #bfcfe1; \r\n");
      out.write("\t\t\t\theight:23px;\r\n");
      out.write("\t\t\t\tline-height:23px; \r\n");
      out.write("\t\t\t\tdisplay:inline-block;\r\n");
      out.write("\t\t\t\t /*float:left; */\r\n");
      out.write("\t\t\t\t padding:0 15px; \r\n");
      out.write("\t\t\t\t cursor:pointer;\r\n");
      out.write("\t\t\t\t color:#87A5C8;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.btn-bg span{\r\n");
      out.write("\t\t\t   display:inline;\r\n");
      out.write("\t\t\t   height:23px;\r\n");
      out.write("\t\t\t   line-height:23px; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ta.btn-bg:hover{\r\n");
      out.write("\t\t\t  color:#056DA1;\r\n");
      out.write("\t\t\t  text-decoration:none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t     var all_width = (document.documentElement||document.body).clientWidth;\r\n");
      out.write("\t\t     var all_height = (document.documentElement||document.body).clientHeight;\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("    <body>\r\n");
      out.write("      <div id=\"id_menuMapContainer\">\r\n");
      out.write("\t\t\t<div id=\"id_loadMaskContainer\" style=\"display:block;\">\r\n");
      out.write("\t\t\t\t<div id=\"loading\">\r\n");
      out.write("\t\t\t\t    <div class=\"loading-indicator\">页面加载中   请稍等...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\tjQuery(\"#id_loadMaskContainer\").css(\"height\",all_height+\"px\");\r\n");
      out.write("\t\t\t\tjQuery(\"#id_menuMapContainer\").css(\"height\",(all_height-8)+\"px\");\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t  </div>\r\n");
      out.write("    </body>\r\n");
      out.write("        <script type='text/javascript'>\r\n");
      out.write("        var globleMenuMapHtml = \"\";\r\n");
      out.write("        jQuery(function() {\r\n");
      out.write("            var url = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/queryMenus.acl?mathRandom=' + Math.random();\r\n");
      out.write("            var rootMenuId = \"402881f43bb24656013bb25c5cef0001\";\r\n");
      out.write("            var data = {rootParentMenuId: rootMenuId};\r\n");
      out.write("            var level = 0;\r\n");
      out.write("            var callBackFunc = function(jsonData) {\r\n");
      out.write("                var $menuMapContainer = $(\"#id_menuMapContainer\");\r\n");
      out.write("                recursionMenuMap($menuMapContainer, 0, {children: []},{children: []}, -1, level, true);//首页\r\n");
      out.write("                var children = jsonData.children;\r\n");
      out.write("                for (var i = 0; i < children.length; i++) {\r\n");
      out.write("                    var childJsonObj = children[i];\r\n");
      out.write("                    recursionMenuMap($menuMapContainer, i + 1, jsonData, childJsonObj, i, level + 1, false);//二层菜单\r\n");
      out.write("                }\r\n");
      out.write("                $menuMapContainer.append(\"<div style='height:5px;width:100%;float:left;'>&nbsp;</div>\");\r\n");
      out.write("                jQuery(\"#id_loadMaskContainer\").hide();\r\n");
      out.write("            };\r\n");
      out.write("            var contentType = \"json\";\r\n");
      out.write("            jQuery.post(url, data, callBackFunc, contentType);\r\n");
      out.write("        });\r\n");
      out.write("        var menuMapTopMargin = 5;\r\n");
      out.write("        var menuMapLeftMargin = 5;\r\n");
      out.write("        var menuMapPadding = 5;\r\n");
      out.write("        \r\n");
      out.write("        function recursionMenuMap($menuMapContainer, topMenuIndex, parentJsonObj, jsonObj, childIndex, level, isMainPage) {\r\n");
      out.write("            var children = jsonObj.children;\r\n");
      out.write("            var icon = jsonObj.icon;\r\n");
      out.write("            var text = jsonObj.name;\r\n");
      out.write("            var menuId = jsonObj.id;\r\n");
      out.write("            if (isMainPage) {\r\n");
      out.write("                icon = \"home.png\";\r\n");
      out.write("                text = '");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("                menuId = \"id_mainPage\";\r\n");
      out.write("            }\r\n");
      out.write("            var $divContainer = $(\"<div/>\").attr(\"topMenuIndex\", topMenuIndex);\r\n");
      out.write("            $divContainer.css(\"marginLeft\", menuMapLeftMargin + \"px\");\r\n");
      out.write("            $divContainer.css(\"marginTop\", menuMapTopMargin + \"px\");\r\n");
      out.write("           // $divContainer.css(\"border\", \"1px solid #CAD6E7\");\r\n");
      out.write("            $divContainer.css(\"padding\", menuMapPadding + \"px\");\r\n");
      out.write("            //$divContainer.css(\"background\", \"#DDD\");\r\n");
      out.write("            $divContainer.css(\"float\", \"left\");\r\n");
      out.write("            var isHasChildren = (0 < children.length);\r\n");
      out.write("            if (isHasChildren) {\r\n");
      out.write("                createBrContainer($menuMapContainer, 0);\r\n");
      out.write("            }\r\n");
      out.write("            $menuMapContainer.append($divContainer);\r\n");
      out.write("            var $img = $(\"<img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/\" + icon + \"'/>\").css({\"verticalAlign\": \"middle\"});\r\n");
      out.write("            //$divContainer.append($img);\r\n");
      out.write("            //$divContainer.append(\"<font>&nbsp;</font>\");\r\n");
      out.write("            var $text = $(\"<a class='btn-bg'></a>\").attr('name',menuId).html($img[0].outerHTML+\"<font>&nbsp;</font>\"+text);\r\n");
      out.write("            $divContainer.append($text);\r\n");
      out.write("           \tif (0 == children.length) {//子节点的点击事件\r\n");
      out.write("                //$divContainer.css(\"background\",\"#D4E1F2\");\r\n");
      out.write("           \t\t$divContainer.css(\"cursor\", \"pointer\");\r\n");
      out.write("\t\t\t\t$divContainer.click(function(event){\r\n");
      out.write("\t\t\t\t\twindow.top.doCheckTree(topMenuIndex,menuId);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("            } else {\r\n");
      out.write("            \t$divContainer.css(\"cursor\", \"default\");\r\n");
      out.write("            \t$divContainer.find(\"a\").css(\"cursor\", \"default\");\r\n");
      out.write("            \t$divContainer.attr(\"disabled\", true);\r\n");
      out.write("            \t$divContainer.find(\"img\").attr(\"disabled\", true);\r\n");
      out.write("            \t$divContainer.find(\"a\").attr(\"disabled\", true);\r\n");
      out.write("            \t//点击父标签可以隐藏或者显示子节点\r\n");
      out.write("            \t//$divContainer.click(function(event){\r\n");
      out.write("            \t//\tif($(this).next('div:hidden').length > 0){\r\n");
      out.write("\t            //\t\t$(this).next('div:hidden').show();\r\n");
      out.write("            \t//\t} else {\r\n");
      out.write("\t            //\t\t$(this).next('div:visible').hide();\r\n");
      out.write("            \t//\t}\r\n");
      out.write("\t\t\t\t//});\r\n");
      out.write("            }\r\n");
      out.write("            if (isMainPage) {\r\n");
      out.write("                createBrContainer($menuMapContainer, 5);\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("\t\t    if(isHasChildren &&((1 == level)||(sameLevelHasChidren(parentJsonObj)))){\r\n");
      out.write("                if ((0 == children.length)) {\r\n");
      out.write("                    var margin = 5;\r\n");
      out.write("                    if (parentJsonObj.children[parentJsonObj.children.length - 1].id == jsonObj.id) {\r\n");
      out.write("                        margin = 0;\r\n");
      out.write("                    }\r\n");
      out.write("                    createBrContainer($menuMapContainer, margin);\r\n");
      out.write("                    return;\r\n");
      out.write("                } else {\r\n");
      out.write("                    var leftIndent = (level * 35);\r\n");
      out.write("                    var $divChildrenContainer = $(\"<div/>\").css({float:'left',width:'100%'});\r\n");
      out.write("                    $menuMapContainer.append($divChildrenContainer);\r\n");
      out.write("                    \r\n");
      out.write("                    var $table = $(\"<table/>\");\r\n");
      out.write("                    $divChildrenContainer.append($table);\r\n");
      out.write("                    \r\n");
      out.write("                    var $tr = $(\"<tr/>\");\r\n");
      out.write("                    $table.append($tr);\r\n");
      out.write("                    \r\n");
      out.write("                    var $leftIndentTd = $(\"<td/>\").css({width:leftIndent});//缩进填充\r\n");
      out.write("                    $tr.append($leftIndentTd);\r\n");
      out.write("                    \r\n");
      out.write("                    var $rightContentTd = $(\"<td/>\");\r\n");
      out.write("                    $tr.append($rightContentTd);\r\n");
      out.write("                    \r\n");
      out.write("                    var $rightContentContainer = $(\"<div/>\");//子菜单table,第三层以后\r\n");
      out.write("                    $rightContentTd.append($rightContentContainer);\r\n");
      out.write("\r\n");
      out.write("                    for (var i = 0; i < children.length; i++) {\r\n");
      out.write("                        var childJsonObj = children[i];\r\n");
      out.write("                        recursionMenuMap($rightContentContainer, topMenuIndex, jsonObj, childJsonObj, i, level, false);\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function createBrContainer($menuMapContainer, margin) {\r\n");
      out.write("            margin = margin || 0;\r\n");
      out.write("            var $brContainer = $(\"<div style='width:100%;float:left;margin-top:\" + margin + \"px;'></div>\");\r\n");
      out.write("            $menuMapContainer.append($brContainer);\r\n");
      out.write("        }\r\n");
      out.write("        function sameLevelHasChidren(parentJsonObj) {\r\n");
      out.write("            if (null == parentJsonObj) return true;\r\n");
      out.write("            var hashChildren = false;\r\n");
      out.write("            var children = parentJsonObj.children;\r\n");
      out.write("            for (var i = 0; i < children.length; i++) {\r\n");
      out.write("                if (children[i].children.length > 0) {\r\n");
      out.write("                    hashChildren = true;\r\n");
      out.write("                    break;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            return hashChildren;\r\n");
      out.write("        }\r\n");
      out.write("        </script>\r\n");
      out.write("    </html>");
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

  private boolean _jspx_meth_spring_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_map_content.jsp(108,24) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("HomePage");
    // /WEB-INF/jsps/solutions/acl/left_tree_menu_map_content.jsp(108,24) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setText("HomePage");
    int[] _jspx_push_body_count_spring_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f0 = _jspx_th_spring_005fmessage_005f0.doStartTag();
      if (_jspx_th_spring_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f0);
    }
    return false;
  }
}
