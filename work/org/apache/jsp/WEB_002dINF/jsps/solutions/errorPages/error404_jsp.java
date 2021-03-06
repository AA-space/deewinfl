package org.apache.jsp.WEB_002dINF.jsps.solutions.errorPages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error404_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>404</title>\r\n");
      out.write("\t <style type='text/css'>\r\n");
      out.write("\t\t html,body{\r\n");
      out.write("\t\t\t    border:0px solid #DDD;\r\n");
      out.write("\t\t\t    border-top:0px;\r\n");
      out.write("\t\t\t    padding:0px;\r\n");
      out.write("\t\t\t    margin:0px; \r\n");
      out.write("\t\t\t    overflow:hidden;\r\n");
      out.write("\t\t\t    font-size:12px;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("      <!-- \r\n");
      out.write("       404页面是WWW网站访问比较经常出现的错误。\r\n");
      out.write("                   最常见的出错提示：404 NOT FOUND。404页面就是当用户输入了错误的链接时，返回的页面。 \r\n");
      out.write("                   错误原因原因类型　HTTP 404 错误意味着链接指向的网页不存在，即原始网页的URL失效，这种情况经常会发生，很难避免，\r\n");
      out.write("                   比如说：网页URL生成规则改变、网页文件更名或移动位置、导入链接拼写错误等，导致原来的URL地址无法访问；\r\n");
      out.write("                   当Web 服务器接到类似请求时，会返回一个404 状态码，告诉浏览器要请求的资源并不存在。 \r\n");
      out.write("       404错误页面导致这个错误的原因一般来说，有三种：  　　\r\n");
      out.write("       1、无法在所请求的端口上访问Web站点。 　　\r\n");
      out.write("       2、Web服务扩展锁定策略阻止本请求。 　　\r\n");
      out.write("       3、MIME映射策略阻止本请求。 解决方法　　\r\n");
      out.write("                   把缺少的网页文件恢复到正确的位置，重新设置网络服务。\r\n");
      out.write("                   对于用户来讲，需要检查你所输入的网络地址是否正确。\r\n");
      out.write("    -->\r\n");
      out.write("    <iframe frameborder=\"0\" style=\"width:100%;border:1px solid #DDD;border-top:0px;overflow:hidden;\" id=\"id_frame\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/errorPages/error404Page.bi\"></iframe>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\t    document.getElementById(\"id_frame\").style.width = (document.documentElement.clientWidth-2)+\"px\";\r\n");
      out.write("\t    document.getElementById(\"id_frame\").style.height = (document.documentElement.clientHeight-2)+\"px\";\r\n");
      out.write("\t    if(window.currentJbpmWorkflowHistoryInfoId){\r\n");
      out.write("\t    \tdocument.getElementById(\"id_frame\").style.width = (document.documentElement.clientWidth-42)+\"px\";\r\n");
      out.write("\t    \tdocument.getElementById(\"id_frame\").style.height = (document.documentElement.clientHeight-122)+\"px\";\r\n");
      out.write("\t    \tdocument.getElementById(\"id_frame\").style.borderTop=\"1px solid #DDD\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    \r\n");
      out.write("\t</script>\r\n");
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
}
