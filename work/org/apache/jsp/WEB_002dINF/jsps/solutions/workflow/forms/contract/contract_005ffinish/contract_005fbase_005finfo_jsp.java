package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.contract.contract_005ffinish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fbase_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   \r\n");
      out.write("         <table cellspacing=\"0\" cellpadding=\"0\" id=\"cont_base_info\">\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-contractect-info\"></div>产权转移单</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">合同编号：</td><td class=\"td-content\"><input name=\"contract_equip.contractid\" class=\"td-content-input \" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.contractid']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("             <td class=\"td-content-title\">已付款金额：</td><td class=\"td-content\"><input name=\"contract_devolution.payedmoney\" class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_devolution.payedmoney']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" > </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-odd\">   \r\n");
      out.write("             <td class=\"td-content-title\">设备编号：</td><td class=\"td-content\"><input name=\"contract_equip.eqipid\" class=\"td-content-input \" readOnly  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.eqipid'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\">名称：</td><td class=\"td-content\"><input name=\"contract_equip.eqipname\"  class=\"td-content-input \" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.eqipname'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">型号：</td><td class=\"td-content\"><input name=\"contract_equip.model\" class=\"td-content-input \" readOnly  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.model'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\">计量单位：</td><td class=\"td-content\"><input name=\"equip_model.unit\" class=\"td-content-input \" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['equip_model.unit'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr class=\"tr-contractect-info tr-odd\">   \r\n");
      out.write("             <td class=\"td-content-title\">数量：</td><td class=\"td-content\"><input name=\"contract_equip.equipnum\" class=\"td-content-input \" readOnly  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.equipnum'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\">单价：</td><td class=\"td-content\"><input name=\"contract_equip.price\" class=\"td-content-input \" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.price'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr class=\"tr-contractect-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">产地：</td><td class=\"td-content\"><input name=\"contract_equip.equipplace\" class=\"td-content-input \" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.equipplace'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\">厂商：</td><td class=\"td-content\"><input name=\"contract_equip.manufacturer\" class=\"td-content-input \" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.manufacturer'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-odd\">   \r\n");
      out.write("             <td class=\"td-content-title\">设备状态：</td><td class=\"td-content\"><input name=\"contract_equip.eqipstatus\" class=\"td-content-input \" readOnly  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.eqipstatus'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("              <td class=\"td-content-title\">交付验收时间：</td><td class=\"td-content\"><input name=\"contract_equip.equipdeliverydate\" id=\"leaseAmtDate\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.equipdeliverydate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  onclick=\"WdatePicker(this,{readOnly:true})\" readonly/>\r\n");
      out.write("               </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">项目出单部门：</td><td class=\"td-content\"><input name=\"contract_info.projectdept\" class=\"td-content-input \" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_info.projectdept'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\">品牌：</td><td class=\"td-content\"><input name=\"contract_equip.brand\" class=\"td-content-input \" readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.brand'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr class=\"tr-contractect-info tr-odd\">   \r\n");
      out.write("             <td class=\"td-content-title\">设备新旧：</td><td class=\"td-content\"><input name=\"contract_devolution.oldstatus\" class=\"td-content-input \" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_devolution.oldstatus'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ></td>\r\n");
      out.write("             <td class=\"td-content-title\"> 发票凭证号码：</td><td class=\"td-content\"><input name=\"contract_devolution.invoiceno\" class=\"td-content-input \"   readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_devolution.invoiceno'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr class=\"tr-contractect-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">设备来源：</td><td class=\"td-content\"><input name=\"contract_info.projSource\" class=\"td-content-input \" readOnly type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_info.projSource'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" > </td>\r\n");
      out.write("             <td class=\"td-content-title\"> 行业类别：</td><td class=\"td-content\"><input name=\"contract_info.indusrytype\" class=\"td-content-input \"     readOnly  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_info.indusrytype'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"> </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-odd\">   \r\n");
      out.write("             <td class=\"td-content-title\">转移价格：</td><td class=\"td-content\"><input name=\"contract_end_info.endprice\" id=\"id_endprice\" class=\"td-content-input \" readOnly require=\"true\" label=\"转移价格\"  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_end_info.endprice'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" ><font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\"> 接收方名称：</td><td class=\"td-content\"><input id=\"id_endcust\" name=\"contract_end_info.endcust\" class=\"td-content-input \" readOnly  type=\"text\"  require=\"true\" label=\"接收方名称\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_end_info.endcust'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-contractect-info tr-even\"> \r\n");
      out.write("              <td class=\"td-content-title\">接收时间：</td><td colspan=\"3\" class=\"td-content\"><input name=\"contract_end_info.enddate\" id=\"id_enddate\" class=\"Wdate td-content-input td-content-readonly\"  \r\n");
      out.write("             type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_end_info.enddate'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  onclick=\"WdatePicker(this,{readOnly:true})\" dataType=\"Date\" require=\"true\" label=\"接收时间\" readonly />\r\n");
      out.write("               <font class=\"required-content\">*</font></td>\r\n");
      out.write("          </tr>  \r\n");
      out.write("          <!--<tr class=\"tr-contractect-info tr-even\"> \r\n");
      out.write("             <td class=\"td-content-title\">备注 ：</td>\r\n");
      out.write("             <td colspan=\"3\"><textarea rows=\"10\"   style=\"width: 98%; margin-top: 5px;margin-left: -10px;margin-button: 5px;overflow-y:scroll\" id=\"id_cenote\" name=\"contract_equip.cenote\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['contract_equip.cenote']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        -->\r\n");
      out.write("        </table>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("           jQuery(\"#contract_base_info\").css(\"width\",formWidth+\"px\");\r\n");
      out.write("        </script>");
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
