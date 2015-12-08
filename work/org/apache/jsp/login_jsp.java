package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody != null) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\t<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\t<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t\t<title>德银融资租赁管理系统</title>\r\n");
      out.write("\t\t<script type=\"text/javascript\"\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/cloud.js\"></script>\r\n");
      out.write("\t\t <!--css sheet-->\r\n");
      out.write("\t   <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t   <script type=\"text/javascript\">\r\n");
      out.write("\t\tif (window != window.top) \r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t   window.top.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/acl/index.acl\"; \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction MM_swapImgRestore() { //v3.0\r\n");
      out.write("\t\t  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction MM_preloadImages() { //v3.0\r\n");
      out.write("\t\t    var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\r\n");
      out.write("\t\t    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\r\n");
      out.write("\t\t    if (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\r\n");
      out.write("            var userInput    = document.getElementById(\"j_username\");\r\n");
      out.write("            var userPassword = document.getElementById(\"j_password\");\r\n");
      out.write("\t\t    userInput.value = getCookie(\"SECURITY_USER_NAME_SAVE_KEY\");\r\n");
      out.write("\t\t\tif('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.login_password_error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tuserPassword.focus();\r\n");
      out.write("\t\t    }else{\r\n");
      out.write("\t\t    \tuserInput.focus();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction MM_findObj(n, d) { //v4.01\r\n");
      out.write("\t\t  var p,i,x;  if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\r\n");
      out.write("\t\t    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\r\n");
      out.write("\t\t  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\r\n");
      out.write("\t\t  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);\r\n");
      out.write("\t\t  if(!x && d.getElementById) x=d.getElementById(n); return x;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction MM_swapImage() { //v3.0\r\n");
      out.write("\t\t  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)\r\n");
      out.write("\t\t   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction setCookie(name,value)//两个参数，一个是cookie的名子，一个是值\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t var Days = 30; //此 cookie 将被保存 30 天\r\n");
      out.write("\t\t var exp   = new Date(); //new Date(\"December 31, 9998\");\r\n");
      out.write("\t\t exp.setTime(exp.getTime() + Days*24*60*60*1000);\r\n");
      out.write("\t\t document.cookie = name + \"=\"+ escape (value) + \";expires=\" + exp.toGMTString();\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction getCookie(name)//取cookies函数       \r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t    var arr = document.cookie.match(new RegExp(\"(^| )\"+name+\"=([^;]*)(;|$)\"));\r\n");
      out.write("\t\t    if(arr != null) return unescape(arr[2]); return \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction login()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar inputUsername = document.getElementById(\"j_username\");\r\n");
      out.write("\t\t\tusername = inputUsername.value.replace(/(^\\s{1,})|(\\s{1,}$)/gim,\"\");\r\n");
      out.write("\t\t\tinputUsername.value = username;\r\n");
      out.write("\t\t\tsetCookie(\"SECURITY_USER_NAME_SAVE_KEY\",username);\r\n");
      out.write("\t\t\tif(!username){\r\n");
      out.write("\t\t\t   alert(\"用户名不能为空！\");\r\n");
      out.write("               return false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tdocument.getElementById(\"login_form_\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.onkeyup = loginAction;\r\n");
      out.write("\t\tfunction loginAction(evt)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar e=window.event||evt;\r\n");
      out.write("\t\t\tif(e.keyCode==13)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t \tlogin();\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t}\r\n");
      out.write("     </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body  style=\"background-color: #1c77ac; background-image: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;\">\r\n");
      out.write("\t\t<div id=\"mainBody\">\r\n");
      out.write("\t\t\t<div id=\"cloud1\" class=\"cloud\"></div>\r\n");
      out.write("\t\t\t<div id=\"cloud2\" class=\"cloud\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"logintop\" style=\"height:47px;\">\r\n");
      out.write("\t\t\t<span>欢迎登录系统</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form name=\"login_form_\" id=\"login_form_\" action=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" method=\"post\" >\r\n");
      out.write("\t\t\t<div class=\"loginbody\">\r\n");
      out.write("\t\t\t\t<span class=\"systemlogo\"></span>\r\n");
      out.write("\t\t\t\t<div class=\"loginbox\" id='id_loginBox'>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><input name=\"j_username\" id='j_username' type=\"text\" class=\"loginuser\"/></li>\r\n");
      out.write("\t\t\t\t\t\t<li><input name=\"j_password\" id='j_password' type=\"password\" class=\"loginpwd\" /></li>\r\n");
      out.write("\t\t\t\t\t\t<li style=\"float:right;margin-right:70px;\"><input name=\"\" type=\"button\" class=\"loginbtn\" value=\"登录\"onclick=\"javascript:login();\" /></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t    var loginBox = document.getElementById(\"id_loginBox\");\r\n");
      out.write("\t\t\t\t    var all_width = document.documentElement.clientWidth;\r\n");
      out.write("\t\t\t\t    with(loginBox){\r\n");
      out.write("\t\t\t\t    \tstyle.position = \"absolute\";\r\n");
      out.write("\t\t\t\t    \tstyle.left     = (all_width-692)/2+\"px\";\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t    window.onresize = function(e){\r\n");
      out.write("\t\t\t\t\t    with(loginBox){\r\n");
      out.write("\t\t\t\t\t    \tstyle.position = \"absolute\";\r\n");
      out.write("\t\t\t\t\t    \tstyle.left     = (all_width-692)/2+\"px\";\r\n");
      out.write("\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t    };\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t<form>\r\n");
      out.write("\t\t<div class=\"loginbm\" style=\"display:none\">版权所有 2014</div>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t<!--\r\n");
      out.write("\t\t var loadInfo = function(){\r\n");
      out.write("\t\t\tif('empty' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.checkUniqueComputerPass}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"未检测到该机器的硬盘号，请检查是否已安装所需浏览器插件，或者没有加入受信站点！\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t\tif('false' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.checkUniqueComputerPass}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"请使用已注册的电脑登录（");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.checkUserName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("）\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t\tif('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.login_username_error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"您输入的用户不存在，请重新输入！\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t\tif('true' == '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.login_password_error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"您输入的密码有误，请重新输入！\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t };\r\n");
      out.write("\t\t setTimeout(\"loadInfo()\",200);\r\n");
      out.write("\t\t//-->\r\n");
      out.write("\t </script>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t</html>");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /login.jsp(93,52) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("j_spring_security_check");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
