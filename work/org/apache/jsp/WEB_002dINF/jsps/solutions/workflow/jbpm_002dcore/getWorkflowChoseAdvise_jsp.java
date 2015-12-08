package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowChoseAdvise_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t\t\r\n");
      out.write("  <!-- 弹出意见框开始 -->\r\n");
      out.write("  <div id=\"id_adviseContainerWindow\" buttons=\"#id_adviseButtons\" closed=\"true\" modal=\"true\" title=\"意见表单\" style=\"display:none;width:350px;text-align:center\">\r\n");
      out.write("\t<table style=\"width:96%\" style=\"margin:auto;padding:auto;\">\r\n");
      out.write("\t   <tr class=\"tr-odd\">\r\n");
      out.write("\t\t\t<td style=\"width:100px;\">当前时间：</td>\r\n");
      out.write("\t\t\t<td><div id=\"id_currentSystemTime\"></div></td>\r\n");
      out.write("\t   </tr>\r\n");
      out.write("\t   <tr class=\"tr-even\" style=\"width:100px;\">\r\n");
      out.write("\t\t\t<td style=\"padding-top:10px;\">常用意见：</td>\r\n");
      out.write("\t\t\t<td style=\"padding-top:10px;\"><div id=\"id_selectAdvise\"></div></td>\r\n");
      out.write("\t   </tr>\r\n");
      out.write("\t   <tr class=\"tr-odd\">\r\n");
      out.write("\t\t\t<td  style=\"width:100px;\">&nbsp;</td>\r\n");
      out.write("\t\t\t<td style=\"text-align:left;\"><textarea id=\"text_selectedAdvise\" style=\"width:196px;height:150px;overflow:auto;border:1px solid #DDD;\"></textarea></td>\r\n");
      out.write("\t   </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("  </div>\t   \r\n");
      out.write("   <div style=\"padding-top:15px;text-align:center;display:none;\" id=\"id_adviseButtons\"> \r\n");
      out.write("\t  <input class=\"btn btn-primary\" type=\"button\" value=\"确定\" onclick='fillCurrentCommonAdvise();jQuery(\"#id_adviseContainerWindow\").dialog(\"close\");' style=\"cursor:pointer;width:60px;\"/>\r\n");
      out.write("\t<input class=\"btn btn-primary\" type=\"button\" value=\"取消\" onclick='jQuery(\"#id_adviseContainerWindow\").dialog(\"close\");' style=\"cursor:pointer;margin-left:20px;width:60px;\"/>\r\n");
      out.write("  </div>\r\n");
      out.write("  <textarea id='id_processedAdviseTxt' style=\"display:none;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentJBPMWorkflowHistoryInfoUser.processedAdvise}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("  <textarea id='id_assignedAdviseTxt' style=\"display:none;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentJBPMWorkflowHistoryInfoUser.assignedAdvise}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("\t var currentSavedAdvise = (jQuery(\"#id_processedAdviseTxt\").val()||jQuery(\"#id_assignedAdviseTxt\").val());\r\n");
      out.write("  </script>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("\t//添加意见\r\n");
      out.write("\t  function addCommonAdivse(hidden_text_choseAdviseValue)\r\n");
      out.write("\t  {\r\n");
      out.write("\t\t  \tvar hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
      out.write("\t\t  \thidden_text_choseAdvise.value = hidden_text_choseAdviseValue;\r\n");
      out.write("\t\t  \tvar workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');\r\n");
      out.write("\t\t      var insertHtml ='<div id=\"id_currentTaskFilledAdvise_1\" style=\"border:0px solid silver;padding-left:5px;height:25px;line-height:25px;background-color:#EFEFEF;\">';\r\n");
      out.write("\t\t  \tinsertHtml+='\t<span style=\"width:200px;height:100%;padding-top:5px;font-size:12px;\">【步骤】<font color=\"red\" style=\"font-weight:BOLD;\">当前处理</font></span>';\r\n");
      out.write("\t\t  \tinsertHtml+='\t<span style=\"width:300px;margin-left:5%;height:100%;padding-top:5px;font-size:12px;\">【填写时间】'+ getCurDateTime()+'</span>';\r\n");
      out.write("\t\t  \tinsertHtml+='\t<span style=\"width:150px;margin-left:20%;height:100%;padding-top:4px;font-size:12px;\">';\r\n");
      out.write("\t\t  \tif(!isCompletedTask){\r\n");
      out.write("\t\t\t  \tinsertHtml+='\t\t<a href=\"javascript:void(0);\" style=\"text-decoration:none;\" onclick=\"showModalCommonAdivseWindow();\"><img align=\"absmiddle\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/pencil.png\" border=\"0\"/>&nbsp;编辑</a>';\r\n");
      out.write("\t\t\t  \tinsertHtml+='\t\t<a href=\"javascript:void(0);\" style=\"text-decoration:none;margin-left:20px;\" onclick=\"delCommonAdivse();\"><img align=\"absmiddle\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/no.png\" border=\"0\"/>&nbsp;删除</a></span>';\r\n");
      out.write("\t\t  \t}\r\n");
      out.write("\t\t  \tinsertHtml+='</div>';\r\n");
      out.write("\t\t  \tinsertHtml+='<div id=\"id_currentTaskFilledAdvise_2\" style=\"border:0px solid silver;border-top:0px solid #FFFFFF;border-bottom:0px;padding-left:20px;height:25px;line-height:25px;background-color:#FFFFFF;\">';\r\n");
      out.write("\t\t  \tinsertHtml+='\t<span style=\"height:100%;padding-top:5px;font-size:12px;\">'+hidden_text_choseAdvise.value+'</span>';\r\n");
      out.write("\t\t  \tinsertHtml+='</div>';\r\n");
      out.write("\t       workflowAdviseContainer.innerHTML = (insertHtml+workflowAdviseContainer.innerHTML);\r\n");
      out.write("\t  }\r\n");
      out.write("\t  //通用意见弹出窗口\r\n");
      out.write("\t  function showModalCommonAdivseWindow()\r\n");
      out.write("\t  {\r\n");
      out.write("\t\t  loadWorkflowChoseAdvise(function(combo){\r\n");
      out.write("\t\t      var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
      out.write("\t\t\t  document.getElementById(\"id_currentSystemTime\").innerHTML= getCurDateTime();\r\n");
      out.write("\t\t\t  document.getElementById('text_selectedAdvise').value = hidden_text_choseAdvise.value;\r\n");
      out.write("\t\t\t  combo.setRawValue(hidden_text_choseAdvise.value);\r\n");
      out.write("\t      });\r\n");
      out.write("\t\t  jQuery(\"#id_adviseContainerWindow\").show();\r\n");
      out.write("\t\t  jQuery(\"#id_adviseContainerWindow\").dialog({top:100});\r\n");
      out.write("\t\t  jQuery(\"#id_adviseContainerWindow\").dialog(\"open\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t  function fillCurrentCommonAdvise(){\r\n");
      out.write("\t      \r\n");
      out.write("\t  \tvar hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
      out.write("\t   \thidden_text_choseAdvise.value = document.getElementById('text_selectedAdvise').value;\r\n");
      out.write("\t\t    var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');\r\n");
      out.write("\t\t    var currentTaskFilledAdvise_1 = document.getElementById('id_currentTaskFilledAdvise_1');\r\n");
      out.write("\t\t    if(currentTaskFilledAdvise_1)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \tworkflowAdviseContainer.removeChild(currentTaskFilledAdvise_1);\r\n");
      out.write("\t\t    \tvar currentTaskFilledAdvise_2 = document.getElementById('id_currentTaskFilledAdvise_2');\r\n");
      out.write("\t\t    \tworkflowAdviseContainer.removeChild(currentTaskFilledAdvise_2);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t      var insertHtml ='<div id=\"id_currentTaskFilledAdvise_1\" style=\"border:0px solid silver;padding-left:5px;height:25px;line-height:25px;background-color:#EFEFEF;\">';\r\n");
      out.write("\t      \tinsertHtml+='\t<span style=\"width:200px;height:100%;padding-top:5px;font-size:12px;\">【步骤】<font color=\"red\" style=\"font-weight:BOLD;\">当前处理</font></span>';\r\n");
      out.write("\t      \tinsertHtml+='\t<span style=\"width:300px;margin-left:5%;height:100%;padding-top:5px;font-size:12px;\">【填写时间】'+ getCurDateTime()+'</span>';\r\n");
      out.write("\t      \tinsertHtml+='\t<span style=\"width:150px;margin-left:20%;height:100%;padding-top:4px;font-size:12px;\">';\r\n");
      out.write("\t      \tinsertHtml+='\t\t<a href=\"javascript:void(0);\" style=\"text-decoration:none;\" onclick=\"showModalCommonAdivseWindow();\"><img align=\"absmiddle\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/pencil.png\" border=\"0\"/>&nbsp;编辑</a>';\r\n");
      out.write("\t      \tinsertHtml+='\t\t<a href=\"javascript:void(0);\" style=\"text-decoration:none;margin-left:20px;\" onclick=\"delCommonAdivse();\"><img align=\"absmiddle\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/menuIcons/no.png\" border=\"0\"/>&nbsp;删除</a></span>';\r\n");
      out.write("\t      \tinsertHtml+='</div>';\r\n");
      out.write("\t      \tinsertHtml+='<div id=\"id_currentTaskFilledAdvise_2\" style=\"border:0px solid silver;border-top:0px solid #FFFFFF;border-bottom:0px;padding-left:20px;height:25px;line-height:25px;background-color:#FFFFFF;\">';\r\n");
      out.write("\t      \tinsertHtml+='\t<span style=\"height:100%;padding-top:5px;font-size:12px;\">'+hidden_text_choseAdvise.value+'</span>';\r\n");
      out.write("\t      \tinsertHtml+='</div>';\r\n");
      out.write("\t      workflowAdviseContainer.innerHTML = (insertHtml+workflowAdviseContainer.innerHTML);\r\n");
      out.write("\t  }\r\n");
      out.write("\t  function delCommonAdivse()\r\n");
      out.write("\t  {\r\n");
      out.write("\t  \tvar workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');\r\n");
      out.write("\t  \tvar currentTaskFilledAdvise_1 = document.getElementById('id_currentTaskFilledAdvise_1');\r\n");
      out.write("\t\t    if(currentTaskFilledAdvise_1)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \tworkflowAdviseContainer.removeChild(currentTaskFilledAdvise_1);\r\n");
      out.write("\t\t    \tvar currentTaskFilledAdvise_2 = document.getElementById('id_currentTaskFilledAdvise_2');\r\n");
      out.write("\t\t    \tworkflowAdviseContainer.removeChild(currentTaskFilledAdvise_2);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
      out.write("\t\t    hidden_text_choseAdvise.value=\"\";\r\n");
      out.write("\t  }\r\n");
      out.write("\t  //判断已经保存过了意见\r\n");
      out.write("\t  if(currentSavedAdvise && !isCompletedTask)\r\n");
      out.write("\t  {\r\n");
      out.write("\t\t  var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
      out.write("\t\t  hidden_text_choseAdvise.value=currentSavedAdvise;\r\n");
      out.write("\t  \t  //addCommonAdivse(currentSavedAdvise);\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\t//加载通用意见\r\n");
      out.write("\t function loadWorkflowChoseAdvise(loadComplete)\r\n");
      out.write("\t {\r\n");
      out.write("\t    var infoFlag = \"choseAdvise\";\r\n");
      out.write("\t\tif(lazyLoadedObj[infoFlag]){\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tnew tracywindyComboBox({\r\n");
      out.write("\t          renderTo:'id_selectAdvise',\r\n");
      out.write("\t          id:'id_selectAdvise_combo',\r\n");
      out.write("\t          width:200,\r\n");
      out.write("\t\t      xmlFileName:'\\\\combos\\\\comboDict.xml',\r\n");
      out.write("\t\t      loadMode:'ajax',\r\n");
      out.write("\t\t      readOnly:true,\r\n");
      out.write("\t\t      displayField:'name',\r\n");
      out.write("\t\t      valueField:'code',\r\n");
      out.write("\t\t      isForceModify:true,\r\n");
      out.write("\t\t      params:{\r\n");
      out.write("\t            pid:'JbpmCommonAdvise'\r\n");
      out.write("\t\t      },\r\n");
      out.write("\t\t      loadComplete:loadComplete?loadComplete:function(combo){},\r\n");
      out.write("\t\t      onSelect:function(combo){\r\n");
      out.write("\t\t\t    var selectedAdviseValue = combo.getRawValue();\r\n");
      out.write("\t\t        \tdocument.getElementById('text_selectedAdvise').value = selectedAdviseValue;\r\n");
      out.write("\t\t      \t    document.getElementById('id_hidden_text_choseAdvise').value = selectedAdviseValue;\r\n");
      out.write("\t\t\t     }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tlazyLoadedObj[infoFlag] = true;\r\n");
      out.write("   }\r\n");
      out.write("  </script>     \t \r\n");
      out.write("<!-- 弹出意见框结束-->");
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
