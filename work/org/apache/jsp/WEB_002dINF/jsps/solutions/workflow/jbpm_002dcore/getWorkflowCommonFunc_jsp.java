package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowCommonFunc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!-- function -->\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("\t   window.onresize = function(){\r\n");
      out.write("\t\t   \tvar currentPageClientWidth  =  document.documentElement.clientWidth;\r\n");
      out.write("\t\t   \tvar currentPageClientHeight =  document.documentElement.clientHeight;\r\n");
      out.write("\t\t   \tcurrentPageClientWidth  = currentPageClientWidth  > 0 ? currentPageClientWidth  : document.body.clientWidth;\r\n");
      out.write("\t\t   \tcurrentPageClientHeight = currentPageClientHeight > 0 ? currentPageClientHeight : document.body.clientHeight;\r\n");
      out.write("\t\t       if(\r\n");
      out.write("\t\t                (Math.abs(currentPageClientWidth-oldCurrentPageClientWidth)>10)\r\n");
      out.write("\t\t              &&(Math.abs(currentPageClientHeight-oldCurrentPageClientHeight)>10)\r\n");
      out.write("\t\t         ){\r\n");
      out.write("\t\t             if(confirm(\"您改变了页面的大小，确定录入内容已保存,重新布局页面么？\")){\r\n");
      out.write("\t\t           \t  window.location.href = window.location.href;\r\n");
      out.write("\t\t\t          }\r\n");
      out.write("\t\t         }\r\n");
      out.write("\t\t   \toldCurrentPageClientWidth  =  currentPageClientWidth;\r\n");
      out.write("\t\t   \toldCurrentPageClientHeight =  currentPageClientHeight;\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t//点击加载容器内容\r\n");
      out.write("\t\tfunction getLazyLoadedObj(infoFlag,$parent,callback){\r\n");
      out.write("\t\t\t/*if(lazyLoadedObj[infoFlag]){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}*/\r\n");
      out.write("\t\t\tif(((\"advise\" == infoFlag)||(\"history\" == infoFlag)) && lazyLoadedObj[infoFlag]){\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}else if(lazyLoadedObj[infoFlag]){\r\n");
      out.write("\t\t\t\ttry{jQuery(\"#id_nextRouteChoseWindow\")[0].outerHTML=\"\";}catch(e){};\r\n");
      out.write("\t\t\t\ttry{$parent.remove(jQuery(\"#id_backRouteChoseWindow\"));}catch(e){};\r\n");
      out.write("\t\t\t\ttry{$parent.remove(jQuery(\"#id_allRouteChoseWindow\"));}catch(e){};\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar loadMaskContainer = jQuery(\"#id_loadMaskContainer\");\r\n");
      out.write("\t\t\tloadMaskContainer.show();\r\n");
      out.write("\t\t\t//回退之前的回调函数\r\n");
      out.write("\t        if(window.backBeforeOperCallBack)\r\n");
      out.write("\t        {\r\n");
      out.write("\t            backBeforeOperCallBack();\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t\tvar back_workflow_name='';\r\n");
      out.write("\t\t\tif(document.getElementById(\"id_back_workflow_name_str\")!=null){\r\n");
      out.write("\t\t\t\tback_workflow_name = document.getElementById(\"id_back_workflow_name_str\").value;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\tvar params = {\r\n");
      out.write("\t\t\t\t\tjhiCompletedTaskImplId:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentJbpmWorkflowHistoryInfoId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\thistoryProcessInstanceImplDbid:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentProcessInstanceDBID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tjbpmWorkflowHistoryInfoUserId:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jbpmWorkflowHistoryInfoUserId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("\t\t\t\t\tinfoFlag:infoFlag,\r\n");
      out.write("\t\t\t\t\tbackworkflowname:back_workflow_name\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t        var submitForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("\t        var formElements = submitForm.elements;\r\n");
      out.write("\t        for (var i = 0; i < formElements.length; i++) {\r\n");
      out.write("\t        \tvar formElement = formElements[i];\r\n");
      out.write("\t        \tvar inputName   = formElement.name;\r\n");
      out.write("\t        \tvar inputValue  = formElement.value;\r\n");
      out.write("\t\t        if(inputName){\r\n");
      out.write("\t\t        \tparams[inputName] = inputValue;\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t\tajaxRequest({\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/getWorkflowInfo.action\",\r\n");
      out.write("\t\t\t\tasync:false, \r\n");
      out.write("\t\t\t\tsuccess:function(res){\r\n");
      out.write("\t\t\t\t\tvar html = (res.responseText||\"\").replace(/(\\r|\\n)/gi,\"\");\r\n");
      out.write("\t\t\t\t\tif(0 == (html||\"\").indexOf(\"javascript:\")){\r\n");
      out.write("\t\t\t\t        var oHead = document.getElementsByTagName(\"HEAD\").item(0); \r\n");
      out.write("\t\t\t\t        var oScript = document.createElement( \"script\" ); \r\n");
      out.write("\t\t\t\t        oScript.language = \"javascript\"; \r\n");
      out.write("\t\t\t\t        oScript.type = \"text/javascript\"; \r\n");
      out.write("\t\t\t\t        oScript.defer = true; \r\n");
      out.write("\t\t\t\t        oScript.text = html.substring(\"javascript:\".length,html.length); \r\n");
      out.write("\t\t\t\t        oHead.appendChild( oScript ); \r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$parent.append(jQuery(html));\r\n");
      out.write("\t\t\t\t\tif(callback){\r\n");
      out.write("\t\t\t\t\t\ttry{\r\n");
      out.write("\t\t\t\t\t\t\tcallback();\r\n");
      out.write("\t\t\t\t\t\t}catch(e){\r\n");
      out.write("\t\t\t\t\t\t\tlazyLoadedObj[infoFlag] = false;\r\n");
      out.write("\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tloadMaskContainer.hide();\r\n");
      out.write("\t\t\t\t\tlazyLoadedObj[infoFlag] = true;\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tfailure:function(res){\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\ttimeout:30*60*1000,\r\n");
      out.write("\t\t\t\tparams:params\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction backRejectChecked(checkName){\r\n");
      out.write("\t\t     jQuery(\"#id_backRouteChoseWindow input[parent_name^='back_chose_'][parent_name!='\"+checkName+\"']:checked\").attr(\"checked\",false);\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t     jQuery(\"#id_backRouteChoseWindow input[id^='back_chose_'][id!='\"+checkName+\"_checkedAll_actor']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_read\") != this.id) && ((checkName+\"_checkedAll_signature\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     jQuery(\"#id_backRouteChoseWindow input[id^='back_chose_'][id!='\"+checkName+\"_checkedAll_read']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_actor\") != this.id) && ((checkName+\"_checkedAll_signature\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     jQuery(\"#id_backRouteChoseWindow input[id^='back_chose_'][id!='\"+checkName+\"_checkedAll_signature']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_actor\") != this.id) && ((checkName+\"_checkedAll_read\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     //jQuery(\"#id_backRouteChoseWindow input[name^='back_chose_'][parent_name!='\"+checkName+\"']:checked\").attr(\"checked\",false);\r\n");
      out.write("\t\t     //jQuery(\"#id_backRouteChoseWindow input[id^='back_chose_'][id!='\"+checkName+\"_checkedAll']:checked\").attr(\"checked\",false);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction nextRejectChecked(checkName,flag){\r\n");
      out.write("\t\t     jQuery(\"#id_nextRouteChoseWindow input[parent_name^='next_chose_'][parent_name!='\"+checkName+\"']:checked\").attr(\"checked\",false);\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t     jQuery(\"#id_nextRouteChoseWindow input[id^='next_chose_'][id!='\"+checkName+\"_checkedAll_actor']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_read\") != this.id) && ((checkName+\"_checkedAll_signature\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     jQuery(\"#id_nextRouteChoseWindow input[id^='next_chose_'][id!='\"+checkName+\"_checkedAll_read']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_actor\") != this.id) && ((checkName+\"_checkedAll_signature\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     jQuery(\"#id_nextRouteChoseWindow input[id^='next_chose_'][id!='\"+checkName+\"_checkedAll_signature']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_actor\") != this.id) && ((checkName+\"_checkedAll_read\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction allRejectChecked(checkName){\r\n");
      out.write("\t\t    /* jQuery(\"#id_allRouteChoseWindow input[parent_name^='all_chose_'][parent_name!='\"+checkName+\"']:checked\").attr(\"checked\",false);\r\n");
      out.write("\t\t     jQuery(\"#id_allRouteChoseWindow input[id^='all_chose_'][id!='\"+checkName+\"_checkedAll']:checked\").attr(\"checked\",false);*/\r\n");
      out.write("\t\t     jQuery(\"#id_allRouteChoseWindow input[parent_name^='all_chose_'][parent_name!='\"+checkName+\"']:checked\").attr(\"checked\",false);\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t     jQuery(\"#id_allRouteChoseWindow input[id^='all_chose_'][id!='\"+checkName+\"_checkedAll_actor']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_read\") != this.id) && ((checkName+\"_checkedAll_signature\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     jQuery(\"#id_allRouteChoseWindow input[id^='all_chose_'][id!='\"+checkName+\"_checkedAll_read']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_actor\") != this.id) && ((checkName+\"_checkedAll_signature\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t     jQuery(\"#id_allRouteChoseWindow input[id^='all_chose_'][id!='\"+checkName+\"_checkedAll_signature']:checked\").each(function(){\r\n");
      out.write("\t\t\t       if(((checkName+\"_checkedAll_actor\") != this.id) && ((checkName+\"_checkedAll_read\") != this.id)){\r\n");
      out.write("\t\t\t\t       this.checked = false;\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doCheckedAll(checked,checkName,parentCheckName,flag)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar checkboxsArr =  document.getElementsByName(checkName);\r\n");
      out.write("            var checkboxs = [];\r\n");
      out.write("            for(var i=0;i<checkboxsArr.length;i++){\r\n");
      out.write("                var checkbox = checkboxsArr[i];\r\n");
      out.write("                if(flag == checkbox.getAttribute(\"flag\")){\r\n");
      out.write("                \tcheckboxs.push(checkbox);\r\n");
      out.write("                } \r\n");
      out.write("            }\r\n");
      out.write("\t\t\tfor(var i=0;i<checkboxs.length;i++)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tcheckboxs[i].checked = checked;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(checkName.indexOf(\"back_chose_\")>-1){\r\n");
      out.write("\t\t\t\tbackRejectChecked(parentCheckName);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(checkName.indexOf(\"next_chose_\")>-1){\r\n");
      out.write("\t\t\t\tnextRejectChecked(parentCheckName,flag);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(checkName.indexOf(\"all_chose_\")>-1){\r\n");
      out.write("\t\t\t\tallRejectChecked(parentCheckName);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t function toggleFormDisplay()\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_form\").show();\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_advise\").hide();\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_attachment\").hide();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_form_link\").parent().addClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_advise_link\").parent().removeClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_attachment_link\").parent().removeClass(\"tabs-selected\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction toggleAdviseDisplay()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_form\").hide();\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_advise\").show();\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_attachment\").hide();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_advise_link\").parent().addClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_form_link\").parent().removeClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_attachment_link\").parent().removeClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tgetLazyLoadedObj(\"advise\",jQuery(\"#id_workflowAdviseContainer\"),function(){\r\n");
      out.write("\t\t\t\t  if(currentSavedAdvise /*&& !isCompletedTask*/)\r\n");
      out.write("\t\t\t\t  {\r\n");
      out.write("\t\t\t\t  \t addCommonAdivse(currentSavedAdvise);\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    function toggleAttachmentDisplay()\r\n");
      out.write("\t    {\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_form\").hide();\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_advise\").hide();\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_tabs_attachment\").show();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_advise_link\").parent().removeClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_form_link\").parent().removeClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tjQuery(\"#id_toggle_attachment_link\").parent().addClass(\"tabs-selected\");\r\n");
      out.write("\t\t\tloadWorkflowAttachment();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction closeWindow()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\ttry{\r\n");
      out.write("\t\t\t\twindow.opener=null;\r\n");
      out.write("\t\t\t\twindow.open(\"\",\"_self\");\r\n");
      out.write("\t\t\t\twindow.close();\r\n");
      out.write("\t\t\t}catch(e){\r\n");
      out.write("\t\t\t\twindow.close();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction toggleDisplay()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t   var currentOperationImgElement = window.event.srcElement;\r\n");
      out.write("\t\t   var isDisplay = currentOperationImgElement.src.indexOf(\"_b\")==-1;\r\n");
      out.write("\t\t   currentOperationImgElement.src = isDisplay?currentOperationImgElement.src.replace(\"_a\",\"_b\"):currentOperationImgElement.src.replace(\"_b\",\"_a\");\r\n");
      out.write("\t\t   var toggleDisplayElement = currentOperationImgElement.parentNode.parentNode.nextSibling;\r\n");
      out.write("\t\t   toggleDisplayElement.style.display = (isDisplay?\"block\":\"none\");\r\n");
      out.write("\t\t}\r\n");
      out.write("   </script>");
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