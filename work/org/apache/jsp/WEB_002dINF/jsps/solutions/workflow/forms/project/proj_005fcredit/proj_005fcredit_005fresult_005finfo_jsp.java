package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.forms.project.proj_005fcredit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_005fcredit_005fresult_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems != null) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("    <script language=\"javascript\">\r\n");
      out.write("     function AdjustLevel(){//资产级别\r\n");
      out.write("    \t\tvar id_assetslevel=$(\"#id_assetslevel\"); \r\n");
      out.write("    \t\tvar id_assetsassess=$(\"#id_assetsassess\").val();\r\n");
      out.write("    \t\tvar id_leasingmoney=$(\"#id_leasingmoney\").val();\r\n");
      out.write("    \t\tid_assetsassess=id_assetsassess||0;\r\n");
      out.write("    \t\tid_leasingmoney=id_leasingmoney||1;\r\n");
      out.write("    \t\tvar temp=parseFloat(id_assetsassess)/parseFloat(id_leasingmoney);\r\n");
      out.write("    \t\t$(\"#id_assetslevel\").val(temp.toFixed(2));\r\n");
      out.write("    \t}\r\n");
      out.write("     function AdjustCash(){//现金流级别\r\n");
      out.write(" \t\tvar id_cashlevel=$(\"#id_cashlevel\");\r\n");
      out.write(" \t\tvar id_monthcash=$(\"#id_monthcash\").val();\r\n");
      out.write(" \t\tvar id_monthrent=$(\"#id_monthrent\").val();\r\n");
      out.write(" \t\tid_monthcash=id_monthcash||0;\r\n");
      out.write(" \t\tid_monthrent=id_monthrent||1;\r\n");
      out.write(" \t\ttemp=parseFloat(id_monthcash)/parseFloat(id_monthrent);\r\n");
      out.write(" \t\t$(\"#id_cashlevel\").val(temp.toFixed(2));\r\n");
      out.write(" \t}\r\n");
      out.write("     function AdjustLevel1(count){//资产级别\r\n");
      out.write(" \t\tvar id_assetsassess=$(\"#id_assetsassess\"+count).val();\r\n");
      out.write(" \t\tvar id_leasingmoney=$(\"#id_leasingmoney\"+count).val();\r\n");
      out.write(" \t\tid_assetsassess=id_assetsassess||0;\r\n");
      out.write(" \t\tid_leasingmoney=id_leasingmoney||1;\r\n");
      out.write(" \t\tvar temp=parseFloat(id_assetsassess)/parseFloat(id_leasingmoney);\r\n");
      out.write(" \t\t$(\"#id_assetslevel\"+count).val(temp.toFixed(2));\r\n");
      out.write(" \t}\r\n");
      out.write("\r\n");
      out.write("     function AdjustCash1(count){//现金流级别\r\n");
      out.write("  \t\tvar id_monthcash=$(\"#id_monthcash\"+count).val();\r\n");
      out.write("  \t\tvar id_monthrent=$(\"#id_monthrent\"+count).val();\r\n");
      out.write("  \t\tid_monthcash=id_monthcash||0;\r\n");
      out.write("  \t\tid_monthrent=id_monthrent||1;\r\n");
      out.write("  \t\tvar temp=parseFloat(id_monthcash)/parseFloat(id_monthrent);\r\n");
      out.write("  \t\t$(\"#id_cashlevel\"+count).val(temp.toFixed(2));\r\n");
      out.write("  \t}\r\n");
      out.write("     function AdjustCashAssurorname(){\r\n");
      out.write("    \t\t\r\n");
      out.write("    \tvar monthcash = 0;\r\n");
      out.write("    \t for ( var int = 1; int <= tem_count_assurorname; int++) {\r\n");
      out.write("    \t\t monthcash +=  parseFloat($('#id_monthcash' + int).val()||0);\r\n");
      out.write("\t\t}\r\n");
      out.write("    \t \r\n");
      out.write("    \t\tvar id_monthcash=$(\"#guarantor_total_monthcash\").val(monthcash);\r\n");
      out.write("     \t\tvar id_monthrent=$(\"#id_monthrent\").val();\r\n");
      out.write("     \t\tid_monthcash=monthcash||0;\r\n");
      out.write("     \t\tid_monthrent=id_monthrent||1;\r\n");
      out.write("     \t\ttemp=parseFloat(id_monthcash)/parseFloat(id_monthrent);\r\n");
      out.write("     \t\t$(\"#guarantor_total_cashlevel\").val(temp.toFixed(2));\r\n");
      out.write("     }\r\n");
      out.write("     function AdjustLevelAssurorname(){\r\n");
      out.write("    \t \r\n");
      out.write("    \tvar assetsassess = 0;\r\n");
      out.write("    \t for ( var int = 1; int <= tem_count_assurorname; int++) {\r\n");
      out.write("    \t\t assetsassess +=  parseFloat($('#id_assetsassess' + int).val()||0);\r\n");
      out.write("\t\t}\r\n");
      out.write("   \t\tvar id_assetsassess=$(\"#guarantor_total_assetsassess\").val(assetsassess);\r\n");
      out.write("   \t\tvar id_leasingmoney=$(\"#id_leasingmoney\").val();\r\n");
      out.write("   \t\tid_assetsassess=assetsassess||0;\r\n");
      out.write("   \t\tid_leasingmoney=id_leasingmoney||1;\r\n");
      out.write("   \t\tvar temp=parseFloat(id_assetsassess)/parseFloat(id_leasingmoney);\r\n");
      out.write("   \t\t$(\"#guarantor_total_assetslevel\").val(temp.toFixed(2));\r\n");
      out.write("     }\r\n");
      out.write("     \r\n");
      out.write("     var tem_count_assurorname = 0;\r\n");
      out.write("     //赋值\r\n");
      out.write("      jQuery(function(){\r\n");
      out.write("    \t var total = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['assurornameinfo']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \t if(total){\r\n");
      out.write("    \t\t tem_count_assurorname = total.split(',').length;\r\n");
      out.write("    \t }\r\n");
      out.write("     }); \r\n");
      out.write("     \r\n");
      out.write("     </script> \r\n");
      out.write("<table cellspacing=\"0\" cellpadding=\"0\" id=\"proj_credit_result_info\" >\r\n");
      out.write("        <tr>\r\n");
      out.write("             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-proj-credit-result-info\"></div>承租人-");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_info.custname'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("-评审结果</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">资产评估值</td><td class=\"td-content\"><input id=\"id_assetsassess\" name=\"proj_other_info.assetsassess\"  class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.assetsassess']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\"  require=\"true\" label=\"资产评估值\" onkeyup=\"AdjustLevel()\"></input> <font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">融资额：</td><td class=\"td-content\"><input id=\"id_leasingmoney\" name=\"proj_other_info.leasingmoney\" class=\"td-content-input\"  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope['proj_other_info.leasingmoney'] ? 0 : requestScope['proj_other_info.leasingmoney']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  dataType=\"PMoney\"  require=\"true\" label=\"融资额\" onkeyup=\"AdjustLevel()\"/><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">资产级别：</td><td class=\"td-content\" colspan=5><input id=\"id_assetslevel\"  name=\"proj_other_info.assetslevel\"  class=\"td-content-input td-content-readonly\"  readOnly   type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.assetslevel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" readOnly require=\"true\" label=\"资产级别\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-even\">   \r\n");
      out.write("             <td class=\"td-content-title\">平均月现金流：</td><td class=\"td-content\"><input id=\"id_monthcash\"  name=\"proj_other_info.monthcash\" class=\"td-content-input\"   type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.monthcash'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  dataType=\"PMoney\"  require=\"true\" label=\"平均月现金流\" onkeyup=\"AdjustCash()\"> <font class=\"required-content\">*</font></td>\r\n");
      out.write("             <td class=\"td-content-title\">月租金：</td><td class=\"td-content\"><input id=\"id_monthrent\" name=\"proj_other_info.monthrent\" class=\"td-content-input\"  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.monthrent'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\"  require=\"true\" label=\"月租金\" onkeyup=\"AdjustCash()\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr class=\"tr-proj-credit-result-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">现金流级别：</td><td class=\"td-content\" colspan=5><input id=\"id_cashlevel\"  name=\"proj_other_info.cashlevel\"  class=\"td-content-input td-content-readonly\"   readOnly  type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.cashlevel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" dataType=\"PMoney\" readOnly  require=\"true\" label=\"现金流级别\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-even\">\r\n");
      out.write("             <td class=\"td-content-title\">项目级别：</td><td class=\"td-content\" colspan=5><input  name=\"proj_other_info.projectlevel\"  class=\"td-content-input\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.projectlevel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  require=\"true\" label=\"项目级别\"><font class=\"required-content\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr class=\"tr-proj-credit-result-info tr-odd\">\r\n");
      out.write("             <td class=\"td-content-title\">备注：</td>\r\n");
      out.write("\t\t    <td class=\"td-content\" colspan=\"3\"><textarea rows=\"5\"   require=\"true\" label=\"备注\"\r\n");
      out.write("\t\t\tstyle=\"width:98.2%;float:left;\" name=\"proj_other_info.approvememo\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['proj_other_info.approvememo'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("\t\t     </td>\r\n");
      out.write("\t       </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("   \r\n");
      out.write("   ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   \r\n");
      out.write("     \r\n");
      out.write("     ");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(107,3) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['assurornameinfo']}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(107,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("item");
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(107,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("j");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            <table cellspacing=\"0\" cellpadding=\"0\" id=\"proj_credit_result_info");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("            <tr>\r\n");
          out.write("              <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-proj-credit-result-info");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"></div>担保人-");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("-评审结果</td>\r\n");
          out.write("            </tr>\r\n");
          out.write("            <tr class=\"tr-proj-credit-result-info");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(" tr-even\">\r\n");
          out.write("             ");
          if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("             ");
          if (_jspx_meth_c_005fset_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("             <td class=\"td-content-title\">资产评估值</td><td class=\"td-content\"><input id=\"id_assetsassess");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" name=\"proj_other_info.assetsassess");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"  class=\"td-content-input\" type=\"text\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[assetsassessVar]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" dataType=\"PMoney\"  require=\"true\" label=\"资产评估值\" onkeyup=\"AdjustLevelAssurorname()\" ></input> <font class=\"required-content\">*</font></td>\r\n");
          out.write("            </tr>\r\n");
          out.write("             <tr class=\"tr-proj-credit-result-info");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(" tr-even\">  \r\n");
          out.write("             ");
          if (_jspx_meth_c_005fset_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("             ");
          if (_jspx_meth_c_005fset_005f3(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("             <td class=\"td-content-title\">平均月现金流：</td><td class=\"td-content\"><input id=\"id_monthcash");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"  name=\"proj_other_info.monthcash");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"td-content-input\"   type=\"text\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope[monthcashVar]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"  dataType=\"PMoney\"  require=\"true\" label=\"平均月现金流\" onkeyup=\"AdjustCashAssurorname()\" > <font class=\"required-content\">*</font></td>\r\n");
          out.write("            </tr>\r\n");
          out.write("         \r\n");
          out.write("            </table>\r\n");
          out.write("            \r\n");
          out.write("            ");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("            \r\n");
          out.write("     ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(113,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("assetsassessVar");
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(113,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("proj_other_info.assetsassess${j.count}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(114,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("leasingmoneyVar");
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(114,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("proj_other_info.leasingmoney${j.count}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(118,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("monthcashVar");
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(118,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("proj_other_info.monthcash${j.count}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(119,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("monthrentVar");
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(119,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("proj_other_info.monthrent${j.count}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsps/solutions/workflow/forms/project/proj_credit/proj_credit_result_info.jsp(125,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.last == true}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t     <table cellspacing=\"0\" cellpadding=\"0\" id=\"proj_credit_result_info_guarantor_total\">\r\n");
        out.write("\t\t\t        <tr>\r\n");
        out.write("\t\t\t             <td class=\"x-panel-table-div-title\" colspan=4><div class=\"toggle-icon-expanded\" title=\"折叠\" toggleClass=\"tr-proj-credit-result-info\"></div>合计担保人-评审结果</td>\r\n");
        out.write("\t\t\t          </tr>\r\n");
        out.write("\t\t\t          <tr class=\"tr-proj-credit-result-info tr-even\">\r\n");
        out.write("\t\t\t             <td class=\"td-content-title\">担保人合计资产评估值</td>\r\n");
        out.write("\t\t\t             <td class=\"td-content\"><input id=\"guarantor_total_assetsassess\" name=\"guarantor_total.assetsassess\"  class=\"td-content-input\" type=\"text\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['guarantor_total.assetsassess']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" dataType=\"PMoney\"  label=\"资产评估值\" ></input> </td>\r\n");
        out.write("\t\t\t             <td class=\"td-content-title\">担保人合计资产级别：</td>\r\n");
        out.write("\t\t\t             <td class=\"td-content\"><input id=\"guarantor_total_assetslevel\" name=\"guarantor_total.assetslevel\" class=\"td-content-input td-content-readonly\"  readOnly   type=\"text\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['guarantor_total.assetslevel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" dataType=\"PMoney\" readOnly  label=\"资产级别\"></td>\r\n");
        out.write("\t\t\t         </tr>\r\n");
        out.write("\t\t\t          <tr class=\"tr-proj-credit-result-info tr-even\">   \r\n");
        out.write("\t\t\t             <td class=\"td-content-title\">担保人合计平均月现金流：</td>\r\n");
        out.write("\t\t\t             <td class=\"td-content\"><input id=\"guarantor_total_monthcash\"  name=\"guarantor_total.monthcash\" class=\"td-content-input\"   type=\"text\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['guarantor_total.monthcash'] }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"  dataType=\"PMoney\"   label=\"平均月现金流\" > </td>\r\n");
        out.write("\t\t\t             <td class=\"td-content-title\">担保人合计现金流级别：</td>\r\n");
        out.write("\t\t\t             <td class=\"td-content\"><input id=\"guarantor_total_cashlevel\" name=\"guarantor_total.cashlevel\"  class=\"td-content-input td-content-readonly\"   readOnly  type=\"text\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope['guarantor_total.cashlevel']}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" dataType=\"PMoney\" readOnly   label=\"现金流级别\"></td>\r\n");
        out.write("\t\t\t         </tr>\r\n");
        out.write("\t\t\t   </table>\r\n");
        out.write("            \r\n");
        out.write("            ");
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
}
