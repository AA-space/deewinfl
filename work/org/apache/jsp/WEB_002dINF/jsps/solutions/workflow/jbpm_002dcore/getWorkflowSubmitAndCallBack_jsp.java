package org.apache.jsp.WEB_002dINF.jsps.solutions.workflow.jbpm_002dcore;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getWorkflowSubmitAndCallBack_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    if (_005fjspx_005ftagPool_005fc_005fif_0026_005ftest != null) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("   //提交按钮时候执行回调函数\r\n");
      out.write("    function btn_callBack(buttonText,assignmentIsSilentModel)\r\n");
      out.write("    {\r\n");
      out.write("        if(true == assignmentIsSilentModel){\r\n");
      out.write("        \tdocument.getElementById(\"id_assignmentIsSilentModel\").value =\"true\"; \r\n");
      out.write("        }\r\n");
      out.write("        else{\r\n");
      out.write("        \tdocument.getElementById(\"id_assignmentIsSilentModel\").value =\"false\"; \r\n");
      out.write("        }\r\n");
      out.write("\t    var isNeedChoseOper = false;\r\n");
      out.write("    \tglobalCurrentPressButtonText = buttonText;\r\n");
      out.write("    \tdocument.getElementById('id_currentTaskSubmitButtonText').value = globalCurrentPressButtonText;\r\n");
      out.write("    \tif(resetRouteButtonDisplayText==globalCurrentPressButtonText){\r\n");
      out.write("            var infoFlag = \"all\";\r\n");
      out.write("    \t\tif(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){\r\n");
      out.write("    \t \t \tjQuery(\"#id_allRouteChoseWindow\").show();\r\n");
      out.write("    \t\t\tjQuery(\"#id_allRouteChoseWindow\").dialog({top:10});\r\n");
      out.write("    \t\t\tjQuery(\"#id_allRouteChoseWindow\").dialog(\"open\"); \r\n");
      out.write("    \t\t})){\r\n");
      out.write("    \t \t \tjQuery(\"#id_allRouteChoseWindow\").show();\r\n");
      out.write("    \t\t\tjQuery(\"#id_allRouteChoseWindow\").dialog({top:10});\r\n");
      out.write("    \t\t\tjQuery(\"#id_allRouteChoseWindow\").dialog(\"open\"); \r\n");
      out.write("    \t\t}\r\n");
      out.write("        \treturn;\r\n");
      out.write("        }\r\n");
      out.write("    \tif(saveButtonDisplayText == globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("\t        //是否保存    \r\n");
      out.write("\t        if(window.workflowSaveCallBack)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t        {\r\n");
      out.write("\t            if(!workflowSaveCallBack())\r\n");
      out.write("\t            {\r\n");
      out.write("\t                return;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        }\r\n");
      out.write("\t        submitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("\t    }\r\n");
      out.write("    \telse if((submitButtonDisplayText==globalCurrentPressButtonText)||(backButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("    \t{\r\n");
      out.write("        \tif(!checkAttachmentInfoFunc())return;\r\n");
      out.write("\t\t    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t        //是否提交    \r\n");
      out.write("\t        if(window.workflowSubmitCallBack)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证\r\n");
      out.write("\t        {\r\n");
      out.write("\t            if(!workflowSubmitCallBack(buttonText))\r\n");
      out.write("\t            {\r\n");
      out.write("\t            \t//setInitFocus();\r\n");
      out.write("\t                return;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        }\r\n");
      out.write("\t        /*\r\n");
      out.write("\t        //通过哪条路由路线进行提交\r\n");
      out.write("\t        var requestNextRoute = document.getElementById(\"id_requestInitiatorRoute\");\r\n");
      out.write("\t        alert(requestNextRoute.value);\r\n");
      out.write("\t        //modify by tracywindy 20140211\r\n");
      out.write("\t        if(!requestNextRoute.value){\r\n");
      out.write("\t\t        if(window.workflowNextRouteCallBack)//该回调函数可用于设置提交提交的路由线路通过(requestNextRoute.value=路由线路值)进行设置;\r\n");
      out.write("\t\t    \t{//该回调函数先于endAction中的appointRequestRoute方法的执行\r\n");
      out.write("\t\t    \t\tisNeedChoseOper = workflowNextRouteCallBack(buttonText,requestNextRoute);\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    \telse\r\n");
      out.write("\t\t    \t{\r\n");
      out.write("\t\t    \t\trequestNextRoute.value=\"\";\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t        }*/\r\n");
      out.write("\t    \tif((submitButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("\t    \t{\r\n");
      out.write("\t    \t\tvar infoFlag=\"next\";\r\n");
      out.write("\t    \t\tif(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){\r\n");
      out.write("\t    \t\t\tdealNextRouteChoseWindow();\r\n");
      out.write("\t\t\t    \tif(!isShowSubmitChosePersonWindow)\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t    \t\tsubmitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t    \telse\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t    \t\t\tjQuery(\"#id_nextRouteChoseWindow\").show();\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_nextRouteChoseWindow\").dialog({top:10});\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_nextRouteChoseWindow\").dialog(\"open\"); \r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t    \t\t})){\r\n");
      out.write("\t    \t\t\tdealNextRouteChoseWindow();\r\n");
      out.write("\t\t\t    \tif(!isShowSubmitChosePersonWindow)\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t    \t\tsubmitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t    \telse\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t    \t\t\tjQuery(\"#id_nextRouteChoseWindow\").show();\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_nextRouteChoseWindow\").dialog({top:10});\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_nextRouteChoseWindow\").dialog(\"open\"); \r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t    \telse if((backButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("\t    \t{\r\n");
      out.write("\t    \t\tvar infoFlag=\"back\";\r\n");
      out.write("\t    \t\tif(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){\r\n");
      out.write("\t    \t\t\t//modify by tracywindy for default chose first person\r\n");
      out.write("\t    \t\t\tdealNextRouteChoseWindow();\r\n");
      out.write("\t\t\t    \tif(!isShowBackChosePersonWindow)\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t\t\t    alert(\"退回选择列表为空，不允许退回\");\r\n");
      out.write("\t\t\t\t\t    return;\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t    \telse\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t\t \t \tjQuery(\"#id_backRouteChoseWindow\").show();\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_backRouteChoseWindow\").dialog({top:10});\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_backRouteChoseWindow\").dialog(\"open\");\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t    \t\t})){ \r\n");
      out.write("\t\t    \t\t//modify by tracywindy for default chose first person\r\n");
      out.write("\t    \t\t\tdealNextRouteChoseWindow();\r\n");
      out.write("\t\t\t    \tif(!isShowBackChosePersonWindow)\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t\t\t    alert(\"退回选择列表为空，不允许退回\");\r\n");
      out.write("\t\t\t\t\t    return;\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t    \telse\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t\t \t \tjQuery(\"#id_backRouteChoseWindow\").show();\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_backRouteChoseWindow\").dialog({top:10});\r\n");
      out.write("\t\t\t\t\t\tjQuery(\"#id_backRouteChoseWindow\").dialog(\"open\");\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t\t    }\r\n");
      out.write("    \t}\r\n");
      out.write("    \telse if(deleteButtonDisplayText == buttonText)\r\n");
      out.write("\t    {\r\n");
      out.write("\t\t    if(confirm(\"确认删除该流程实例么？\"))\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t    if(!loadMask)\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t    \tloadMask = new tracywindyLoadMask(document.body,\"数据处理中，请稍等...\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t    submitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("    \telse if(abondonButtonDisplayText == buttonText)\r\n");
      out.write("\t    {\r\n");
      out.write("\t\t    if(confirm(\"确认废弃该流程实例么？\"))\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t    if(!loadMask)\r\n");
      out.write("\t\t\t    {\r\n");
      out.write("\t\t\t    \tloadMask = new tracywindyLoadMask(document.body,\"数据处理中，请稍等...\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t    submitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("    \telse if(readButtonDisplayText == buttonText)\r\n");
      out.write("    \t{\r\n");
      out.write("    \t\tnew tracywindyCommonUserSelection({\r\n");
      out.write("    \t\t\thiddenInput:'id_readUserIds_hidden',\r\n");
      out.write("    \t\t\tdisplayInput:'id_readUserRealNames_display',\r\n");
      out.write("    \t\t\tdisplayPromit:'参与传阅的人员',\r\n");
      out.write("    \t\t\tisMultiSelect:true,\r\n");
      out.write("    \t\t\tchoseCallBack:function(){\r\n");
      out.write("    \t\t\t    submitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("                    return true;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("        \t}).show();\r\n");
      out.write("        }\r\n");
      out.write("    \telse if(signatureButtonDisplayText == buttonText)\r\n");
      out.write("    \t{\r\n");
      out.write("    \t\tnew tracywindyCommonUserSelection({\r\n");
      out.write("    \t\t\thiddenInput:'id_signatureUserIds_hidden',\r\n");
      out.write("    \t\t\tdisplayInput:'id_signatureUserRealNames_display',\r\n");
      out.write("    \t\t\tdisplayPromit:'参与会签的人员',\r\n");
      out.write("    \t\t\tisMultiSelect:true,\r\n");
      out.write("    \t\t\tchoseCallBack:function(){\r\n");
      out.write("    \t\t\t\tsubmitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("                    return true;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("        \t}).show();\r\n");
      out.write("    \t\t\r\n");
      out.write("        }\r\n");
      out.write("    \telse if(assignmentButtonDisplayText == buttonText)\r\n");
      out.write("    \t{\r\n");
      out.write("    \t\tnew tracywindyCommonUserSelection({\r\n");
      out.write("    \t\t\thiddenInput:'id_assignmentedUserId_hidden',\r\n");
      out.write("    \t\t\tdisplayInput:'id_assignmentUserRealName_display',\r\n");
      out.write("    \t\t\tisMultiSelect:false,\r\n");
      out.write("    \t\t\tdisplayPromit:'被指派人员',\r\n");
      out.write("    \t\t\tchoseCallBack:function(){\r\n");
      out.write("    \t\t\t\tsubmitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("                    return true;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("        \t}).show();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    function submitFormWithoutWorkflowNextCallBack()\r\n");
      out.write("    {\r\n");
      out.write("        //条件通过提交表单\r\n");
      out.write("        jQuery(\"#id_workflowAdviseContainer\").css(\"overflow\",\"hidden\");\r\n");
      out.write("        jQuery(\"#id_workflowFormContainer\").css(\"overflow\",\"hidden\");\r\n");
      out.write("        if(!loadMask)\r\n");
      out.write("        {\r\n");
      out.write("        \tloadMask = new tracywindyLoadMask(document.body,\"数据处理中，请稍等...\");\r\n");
      out.write("        }\r\n");
      out.write("        loadMask.show();\r\n");
      out.write("        window.top.document.body.style.overflow=\"hidden\";\r\n");
      out.write("        var submitProcessedForm = document.getElementById(\"id_submitProcessedForm\");\r\n");
      out.write("    \tsubmitProcessedForm.submit();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("    /*function saveCallBack(returnResult){}*///保存回调函数\r\n");
      out.write("    function ajaxCallBack(returnResult,assignmentIsSilentModel)\r\n");
      out.write("    {\r\n");
      out.write("        jQuery(\"#id_workflowAdviseContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("        jQuery(\"#id_workflowFormContainer\").css(\"overflow\",\"auto\");\r\n");
      out.write("\r\n");
      out.write("        if(saveButtonDisplayText == globalCurrentPressButtonText)\r\n");
      out.write("        {\r\n");
      out.write("        \tif(window.saveCallBack)//保存成功时候的回调函数\r\n");
      out.write("        \t{\r\n");
      out.write("        \t\tsaveCallBack(returnResult);\r\n");
      out.write("    \t    }\r\n");
      out.write("    \t    if(!assignmentIsSilentModel){\r\n");
      out.write("\t\t    \tvar promitInfo = '");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_spring_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("\t\t    \talert(promitInfo);\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \tif(loadMask)loadMask.hide();\r\n");
      out.write("\t    \treturn;\r\n");
      out.write("        }\r\n");
      out.write("        else if(submitButtonDisplayText == globalCurrentPressButtonText)\r\n");
      out.write("        {\r\n");
      out.write("        }\r\n");
      out.write("        else if(backButtonDisplayText==globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("\t    }\r\n");
      out.write("        else if(deleteButtonDisplayText==globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("        \treturnResult = \"该流程已被成功删除\";\r\n");
      out.write("\t    }\r\n");
      out.write("        else if(abondonButtonDisplayText==globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("        \treturnResult = \"该流程已被成功废弃\";\r\n");
      out.write("\t    }\r\n");
      out.write("        else if(readButtonDisplayText==globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("\t    \tif(loadMask)loadMask.hide();\r\n");
      out.write("\t    \tvar promitInfo = '");
      if (_jspx_meth_spring_005fmessage_005f2(_jspx_page_context))
        return;
      if (_jspx_meth_spring_005fmessage_005f3(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("\t    \talert(promitInfo);\r\n");
      out.write("\t    \treturn;\r\n");
      out.write("\t    }\r\n");
      out.write("        else if(signatureButtonDisplayText==globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("\t    \tif(loadMask)loadMask.hide();\r\n");
      out.write("\t    \tvar promitInfo = '");
      if (_jspx_meth_spring_005fmessage_005f4(_jspx_page_context))
        return;
      if (_jspx_meth_spring_005fmessage_005f5(_jspx_page_context))
        return;
      out.write("';\r\n");
      out.write("\t    \talert(promitInfo);\r\n");
      out.write("\t    \treturn;\r\n");
      out.write("\t    }\r\n");
      out.write("        else if(assignmentButtonDisplayText==globalCurrentPressButtonText)\r\n");
      out.write("    \t{\r\n");
      out.write("\t    }\r\n");
      out.write("\t\ttry{\r\n");
      out.write("\t\t    if(window.opener)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\twindow.opener.location.reload();\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t}catch(e){}\r\n");
      out.write("\t    if(deleteButtonNoSavedDisplayText != globalCurrentPressButtonText){\r\n");
      out.write("\t    \talert(returnResult);\r\n");
      out.write("\t    }\r\n");
      out.write("\t    try{closeWindow();}catch(e){}\r\n");
      out.write("    \t/*window.opener = null;\r\n");
      out.write("        window.open(\"\",\"_self\");\r\n");
      out.write("     \twindow.close();*/\r\n");
      out.write("    }\r\n");
      out.write("    //提交下一步\r\n");
      out.write("    function  submitNextTask(){\r\n");
      out.write("    \tjQuery(\"#id_currentTaskSubmitButtonText\").val(submitButtonDisplayText);\r\n");
      out.write("    \tjQuery(\"#id_submitProcessedForm\")[0].submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction doChoseRouteOper(operFlag)\r\n");
      out.write("    {\r\n");
      out.write("\t\t    //短信\r\n");
      out.write("         \t/*if(true){\r\n");
      out.write("         \t\tif(jQuery('#isSendMsgFlag').attr('checked')){\r\n");
      out.write("         \t\t\t//短信内容\r\n");
      out.write("         \t\t\tvar value = jQuery('#sendMsgContent');\r\n");
      out.write("         \t\t}\r\n");
      out.write("         \t}*/\r\n");
      out.write("\t        var currentChosePersonArr = [];\r\n");
      out.write("\t        var displayPromit = \"\";\r\n");
      out.write("         \tif('next'==operFlag)\r\n");
      out.write("         \t{\r\n");
      out.write("         \t\tdisplayPromit = \"请选择要提交到的节点\";\r\n");
      out.write("         \t}\r\n");
      out.write("         \telse if('back'==operFlag)\r\n");
      out.write("         \t{\r\n");
      out.write("         \t\tdisplayPromit = \"请选择要退回到的节点\";\r\n");
      out.write("         \t}\r\n");
      out.write("         \telse if('all'==operFlag)\r\n");
      out.write("         \t{\r\n");
      out.write("         \t\tdisplayPromit = \"请选择要重置路由的节点\";\r\n");
      out.write("         \t}\r\n");
      out.write("     \t\tvar firstAlllement = jQuery(\"input[name^='\"+operFlag+\"_chose_']:checked:first\")[0];\r\n");
      out.write("     \t\tif(!firstAlllement){alert(displayPromit);return false;}\r\n");
      out.write("     \t\tvar parent_name = firstAlllement.getAttribute(\"parent_name\");\r\n");
      out.write("     \t\tjQuery(\"input[parent_name='\"+parent_name+\"']\").each(function(){\r\n");
      out.write("         \t\tvar currentName = this.getAttribute(\"name\");\r\n");
      out.write("         \t\tif(!currentChosePersonArr.contains(currentName)){\r\n");
      out.write("         \t\t\tcurrentChosePersonArr.push(currentName);\r\n");
      out.write("             \t}\r\n");
      out.write("            });\r\n");
      out.write("         \tvar allActivityRequestInitiators = {};\r\n");
      out.write("         \tvar signatureAllActivityRequestInitiators = {};\r\n");
      out.write("         \tvar readAllActivityRequestInitiators = {};\r\n");
      out.write("         \tvar chosedRoutePath = null;\r\n");
      out.write("         \tif(currentChosePersonArr)\r\n");
      out.write("         \t{\r\n");
      out.write("             \tfor(var i=0;i<currentChosePersonArr.length;i++)\r\n");
      out.write("             \t{\r\n");
      out.write("\t            \tvar currentChosePerson = currentChosePersonArr[i];\r\n");
      out.write("\t            \tcurrentChoses = jQuery(\"input[name='\"+currentChosePerson+\"']:checked\");\r\n");
      out.write("\t\t\t\t\t//modify by tracywindy 2013-08-26 \r\n");
      out.write("\t\t\t\t\tactorCurrentChoses      = jQuery(\"input[name='\"+currentChosePerson+\"'][flag='actor']\");\r\n");
      out.write("\t\t\t\t\tactorCurrentChosesChecked   = jQuery(\"input[name='\"+currentChosePerson+\"'][flag='actor']:checked\");\r\n");
      out.write("\t            \treadCurrentChoses       = jQuery(\"input[name='\"+currentChosePerson+\"'][flag='read']\");\r\n");
      out.write("\t            \treadCurrentChosesChecked    = jQuery(\"input[name='\"+currentChosePerson+\"'][flag='read']:checked\");\r\n");
      out.write("\t            \tsignatureCurrentChoses  = jQuery(\"input[name='\"+currentChosePerson+\"'][flag='signature']\");\r\n");
      out.write("\t            \tsignatureCurrentChosesChecked  = jQuery(\"input[name='\"+currentChosePerson+\"'][flag='signature']:checked\");\r\n");
      out.write("\r\n");
      out.write("                    var isNeedSignature = (signatureCurrentChoses.length>0)&&(0 == signatureCurrentChosesChecked.length);\r\n");
      out.write("                    var isNeedRead = (readCurrentChoses.length>0)&&(0 == readCurrentChosesChecked.length);\r\n");
      out.write("\t            \tvar msg = \"\";\r\n");
      out.write("\t            \tif((actorCurrentChoses.length>0)&&(0 == actorCurrentChosesChecked.length)){\r\n");
      out.write("\t            \t\tmsg = \"任务处理人\";\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t            \telse if(isNeedSignature){\r\n");
      out.write("\t            \t\tmsg = \"会签对象\";\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t            \telse if(isNeedRead){\r\n");
      out.write("\t            \t\tmsg = \"传阅对象\";\r\n");
      out.write("\t\t            }\r\n");
      out.write("               \t    if(msg/*!currentChoses[0]*/)\r\n");
      out.write("              \t    {\r\n");
      out.write("              \t\t   alert(\"请选择【\"+currentChosePerson.substring(currentChosePerson.lastIndexOf(\"_\")+1)+\"】\"+msg);\r\n");
      out.write("              \t\t   return;\r\n");
      out.write("              \t    }\r\n");
      out.write("               \t    else\r\n");
      out.write("               \t    {\r\n");
      out.write("               \t        var dealMethod  = null;\r\n");
      out.write("\t\t\t\t        var passedCount = null;\r\n");
      out.write("               \t \t    var requestInitiators = new Array();\r\n");
      out.write("               \t \t    var readRequestInitiators = new Array();\r\n");
      out.write("               \t \t    var signatureRequestInitiators = new Array();\r\n");
      out.write("               \t    \tcurrentChoses.each(function(i){\r\n");
      out.write("                   \t    \tif(0==i)\r\n");
      out.write("                   \t    \t{\r\n");
      out.write("                   \t    \t\tchosedRoutePath = this.getAttribute(\"routePath\");\r\n");
      out.write("                       \t    }\r\n");
      out.write("                       \t    var flag = this.getAttribute(\"flag\");\r\n");
      out.write("                       \t    switch(flag){\r\n");
      out.write("                       \t      case \"actor\":{\r\n");
      out.write("                           \t      if(0==i){\r\n");
      out.write("                           \t        dealMethod    = this.getAttribute(\"dealMethod\");\r\n");
      out.write("                           \t        passedCount   = this.getAttribute(\"passedCount\");\r\n");
      out.write("                           \t  }\r\n");
      out.write("                           \t  requestInitiators.push({username:this.getAttribute(\"login_name\")});break;}\r\n");
      out.write("                       \t      case \"read\":{readRequestInitiators.push({username:this.getAttribute(\"login_name\")});break;}\r\n");
      out.write("                       \t      case \"signature\":{signatureRequestInitiators.push({username:this.getAttribute(\"login_name\")});break;}\r\n");
      out.write("                       \t      default:{requestInitiators.push({username:this.getAttribute(\"login_name\")});break;}\r\n");
      out.write("                       \t    }\r\n");
      out.write("                   \t    });\r\n");
      out.write("\t               \t \t/*\t\t\r\n");
      out.write("\t               \t \t *     changeRequestInitiator={\r\n");
      out.write("\t               \t \t * \t\t\t\"02-分支任务1\":[{\"username\":\"Admin\"}],\r\n");
      out.write("\t               \t \t * \t\t\t\"03-分支任务2\":[{\"username\":\"Admin\"}],\r\n");
      out.write("\t               \t \t * \t\t\t\"04-分支任务3\":[{\"username\":\"Admin\"}]\r\n");
      out.write("\t               \t \t * \t\t}\r\n");
      out.write("\t               \t \t */\r\n");
      out.write("                   \t    var node_name = currentChoses[0].getAttribute(\"node_name\");\r\n");
      out.write("                   \t    if(\"NPassed\" == dealMethod){\r\n");
      out.write("                       \t    if(parseInt(passedCount) > requestInitiators.length){\r\n");
      out.write("                           \t    alert(\"节点【\"+node_name+\"】所勾选的处理人员数量必须大于等于需要通过的\"+passedCount+\"人!\");\r\n");
      out.write("                           \t    return;\r\n");
      out.write("                           \t}\r\n");
      out.write("                       \t}\r\n");
      out.write("               \t    \tallActivityRequestInitiators[node_name] =requestInitiators; \r\n");
      out.write("               \t    \treadAllActivityRequestInitiators[node_name] =readRequestInitiators; \r\n");
      out.write("               \t    \tsignatureAllActivityRequestInitiators[node_name] =signatureRequestInitiators; \r\n");
      out.write("\t\t\t\t\t\t//设置任意路由的节点名称\r\n");
      out.write("               \t    \tdocument.getElementById(\"id_choseRequestNextRouteNodeName\").value =currentChoses[0].getAttribute(\"parent_node_name\");\r\n");
      out.write("                   \t}\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("         \tif('next'==operFlag)\r\n");
      out.write("         \t{\r\n");
      out.write("         \t    jQuery(\"#id_nextRouteChoseWindow\").dialog(\"close\");\r\n");
      out.write("         \t}\r\n");
      out.write("         \telse if('back'==operFlag)\r\n");
      out.write("         \t{\r\n");
      out.write("         \t\tjQuery(\"#id_backRouteChoseWindow\").dialog(\"close\");\r\n");
      out.write("         \t}\r\n");
      out.write("         \telse if('all'==operFlag)\r\n");
      out.write("         \t{\r\n");
      out.write("         \t\tjQuery(\"#id_allRouteChoseWindow\").dialog(\"close\");\r\n");
      out.write("         \t}\r\n");
      out.write("         \tvar requestNextRoute = document.getElementById(\"id_requestInitiatorRoute\");\r\n");
      out.write("         \tvar changeRequestInitiator = document.getElementById(\"id_changeRequestInitiator\");\r\n");
      out.write("         \tvar signatureChangeRequestInitiator = document.getElementById(\"id_signatureChangeRequestInitiator\");\r\n");
      out.write("         \tvar readChangeRequestInitiator = document.getElementById(\"id_readChangeRequestInitiator\");\r\n");
      out.write("         \trequestNextRoute.value = chosedRoutePath;\r\n");
      out.write("         \tchangeRequestInitiator.value = JsonUtil.encode(allActivityRequestInitiators);\r\n");
      out.write("         \tsignatureChangeRequestInitiator.value = JsonUtil.encode(signatureAllActivityRequestInitiators);\r\n");
      out.write("         \treadChangeRequestInitiator.value = JsonUtil.encode(readAllActivityRequestInitiators);\r\n");
      out.write("         \tsubmitFormWithoutWorkflowNextCallBack();\r\n");
      out.write("       }\r\n");
      out.write("\t   function dealNextRouteChoseWindow()\r\n");
      out.write("\t   {\r\n");
      out.write("\t\t        //通过哪条路由路线进行提交\r\n");
      out.write("\t\t        var requestNextRoute = document.getElementById(\"id_requestInitiatorRoute\");\r\n");
      out.write("\t\t        //modify by tracywindy 20140211\r\n");
      out.write("\t\t        if(!requestNextRoute.value){\r\n");
      out.write("\t\t\t        if(window.workflowNextRouteCallBack)//该回调函数可用于设置提交提交的路由线路通过(requestNextRoute.value=路由线路值)进行设置;\r\n");
      out.write("\t\t\t    \t{//该回调函数先于endAction中的appointRequestRoute方法的执行\r\n");
      out.write("\t\t\t    \t\tworkflowNextRouteCallBack(globalCurrentPressButtonText,requestNextRoute);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    \telse\r\n");
      out.write("\t\t\t    \t{\r\n");
      out.write("\t\t\t    \t\trequestNextRoute.value=\"\";\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t   var currentChosePersonArr = null;\r\n");
      out.write("\t\t\t   //var requestNextRoute = document.getElementById(\"id_requestInitiatorRoute\");\r\n");
      out.write("\t\t\t   var requestNextRouteValue = (!requestNextRoute.value?\"\":requestNextRoute.value);\r\n");
      out.write("\t\t\t   jQuery(\"tr[identity]\").show();\r\n");
      out.write("\t\t\t   //jQuery(\"input[name^='back_chose_']:first\").attr(\"checked\",true);\r\n");
      out.write("\t\t\t   if((backButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("\t\t\t   {//modify by tracywindy for default chose first person\r\n");
      out.write("\t\t\t\t   currentChosePersonArr = backChosePersonArr;\r\n");
      out.write("\t\t\t\t   /*if(window.workflowNextRouteCallBack)\r\n");
      out.write("\t\t\t\t   {\r\n");
      out.write("\t\t\t\t\t   jQuery(\"tr[identity][identity!='back_chose_tr_\"+requestNextRouteValue+\"']\").hide();\r\n");
      out.write("\t\t\t\t\t  // jQuery(\"tr[identity][identity^='back_chose_tr_'][routePath!='\"+requestNextRouteValue+\"']\").hide();\r\n");
      out.write("\t\t\t\t   }*/\r\n");
      out.write("\t\t\t\t   //jQuery(\"input[name^='back_chose_']:first\").attr(\"checked\",true);\r\n");
      out.write("\t\t\t\t   //return;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t   else if((submitButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("\t\t\t   {\t\r\n");
      out.write("\t\t\t\t   currentChosePersonArr = nextChosePersonArr;\r\n");
      out.write("\t\t\t\t   if(requestNextRouteValue || window.workflowNextRouteCallBack)\r\n");
      out.write("\t\t\t\t   {\r\n");
      out.write("\t\t\t\t\t   ///lish\r\n");
      out.write("\t\t\t\t      jQuery(\"tr[identity][identity!='next_chose_tr_\"+requestNextRouteValue+\"']\").hide();\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t //modify by tracywindy for default chose first person\r\n");
      out.write("\t\t\t   var $firstCheckedInput = null;\r\n");
      out.write("\t\t\t   //默认勾选取消\r\n");
      out.write("\t\t\t   if(currentChosePersonArr)\r\n");
      out.write("\t           {\r\n");
      out.write("\t\t\t\t   for(var i=0;i<currentChosePersonArr.length;i++)\r\n");
      out.write("\t               {\r\n");
      out.write("\t            \t   var currentChoses = null;\r\n");
      out.write("\t            \t   jQuery(\"input[name='\"+currentChosePersonArr[i]+\"']\").attr(\"checked\",false); \r\n");
      out.write("\t            \t   if(window.workflowNextRouteCallBack)\r\n");
      out.write("\t            \t   {\r\n");
      out.write("\t\t            \t   /*\r\n");
      out.write("\t\t            \t   //var nameFlag = \"\";\r\n");
      out.write("\t\t            \t   if((submitButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("\t            \t\t   {\r\n");
      out.write("\t            \t\t\t   //nameFlag =\"next_chose_\";\r\n");
      out.write("\t            \t\t\t   currentChoses = jQuery(\"input[routePath='\"+requestNextRouteValue+\"'][name='\"+currentChosePersonArr[i]+\"']:first\");  \r\n");
      out.write("\t\t            \t   }\r\n");
      out.write("\t                       else if((backButtonDisplayText==globalCurrentPressButtonText))\r\n");
      out.write("\t                       {\r\n");
      out.write("\t                    \t   //nameFlag =\"back_chose_\";\r\n");
      out.write("\t                    \t   currentChoses = jQuery(\"input[name='\"+currentChosePersonArr[i]+\"']:first\"); \r\n");
      out.write("\t\t                   }*/\r\n");
      out.write("\t            \t\t   currentChoses = jQuery(\"input[routePath='\"+requestNextRouteValue+\"'][name='\"+currentChosePersonArr[i]+\"']\");  \r\n");
      out.write("\t\t               }\r\n");
      out.write("\t            \t   else\r\n");
      out.write("\t            \t   {\r\n");
      out.write("\t            \t\t   currentChoses = jQuery(\"input[name='\"+currentChosePersonArr[i]+\"']:first\");  \r\n");
      out.write("\t            \t\t   if(null == $firstCheckedInput){\r\n");
      out.write("\t            \t\t\t   $firstCheckedInput = currentChoses;\r\n");
      out.write("\t\t            \t   }\r\n");
      out.write("\t\t               }\r\n");
      out.write("\t            \t   currentChoses.attr(\"checked\",true);\r\n");
      out.write("\t               }\r\n");
      out.write("\t           }\r\n");
      out.write("\t           //added by tracywindy\r\n");
      out.write("\t           if(null != $firstCheckedInput){\r\n");
      out.write("\t        \t   var first_parent_name = $firstCheckedInput.attr(\"parent_name\");\r\n");
      out.write("\t        \t   if(first_parent_name){\r\n");
      out.write("\t        \t\t   jQuery(\"input[parent_name][parent_name!='\"+first_parent_name+\"']\").attr(\"checked\",false);  \r\n");
      out.write("\t\t           }\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t   //选择会签人或者传阅人\r\n");
      out.write("\t   function readOrSignatureOper(flag)\r\n");
      out.write("\t   {\r\n");
      out.write("\t\t    var msg = \"确认提交么？\";\r\n");
      out.write("\t\t    if(!window.confirm(msg))\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t\t    return;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
      out.write("\t\t    var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/removeReadPersonToTask.action\";\r\n");
      out.write("\t\t    if('read'!=flag)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \tif(!hidden_text_choseAdvise.value){alert(\"请填写处理意见\");return;};\r\n");
      out.write("\t\t    \turl = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jbpm/removeSignaturePersonToTask.action\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t    if(!loadMask)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \tloadMask = new tracywindyLoadMask(document.body,\"数据处理中，请稍等...\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t    loadMask.show();\r\n");
      out.write("\t\t    ajaxRequest({\r\n");
      out.write("\t              url:url,\r\n");
      out.write("\t              success:function(res){alert(\"操作成功\");if(window.opener){window.opener.location.reload();}closeWindow();},\r\n");
      out.write("\t              failure:function(res){alert(\"操作失败\");if(window.opener){window.opener.location.reload();}closeWindow();},\r\n");
      out.write("\t              params:{\r\n");
      out.write("\t            \t    jbpmWorkflowHistoryInfoId:currentJbpmWorkflowHistoryInfoId,\r\n");
      out.write("\t            \t    processedAdvise:hidden_text_choseAdvise.value\r\n");
      out.write("\t              }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t    \r\n");
      out.write("\t   }\r\n");
      out.write(" </script>");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(46,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'1' eq currentTaskIsNeedAdvise}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');\r\n");
        out.write("\t\t\t    if(!hidden_text_choseAdvise.value){alert(\"请填写处理意见\");return;};\r\n");
        out.write("\t\t    ");
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

  private boolean _jspx_meth_spring_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(228,25) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("Save");
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(228,25) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setText("保存");
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

  private boolean _jspx_meth_spring_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f1 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f1.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(228,65) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setCode("Success");
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(228,65) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f1.setText("成功");
    int[] _jspx_push_body_count_spring_005fmessage_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f1 = _jspx_th_spring_005fmessage_005f1.doStartTag();
      if (_jspx_th_spring_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f1.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f2 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f2.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(251,24) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f2.setCode("WorkflowRead");
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(251,24) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f2.setText("传阅");
    int[] _jspx_push_body_count_spring_005fmessage_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f2 = _jspx_th_spring_005fmessage_005f2.doStartTag();
      if (_jspx_th_spring_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f2.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f3 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f3.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(251,72) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f3.setCode("Success");
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(251,72) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f3.setText("成功");
    int[] _jspx_push_body_count_spring_005fmessage_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f3 = _jspx_th_spring_005fmessage_005f3.doStartTag();
      if (_jspx_th_spring_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f3.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f4 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f4.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(258,24) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f4.setCode("Signature");
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(258,24) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f4.setText("会签");
    int[] _jspx_push_body_count_spring_005fmessage_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f4 = _jspx_th_spring_005fmessage_005f4.doStartTag();
      if (_jspx_th_spring_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f4.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f5 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f5.setParent(null);
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(258,69) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f5.setCode("Success");
    // /WEB-INF/jsps/solutions/workflow/jbpm-core/getWorkflowSubmitAndCallBack.jsp(258,69) name = text type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f5.setText("成功");
    int[] _jspx_push_body_count_spring_005fmessage_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f5 = _jspx_th_spring_005fmessage_005f5.doStartTag();
      if (_jspx_th_spring_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f5.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005ftext_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f5);
    }
    return false;
  }
}
