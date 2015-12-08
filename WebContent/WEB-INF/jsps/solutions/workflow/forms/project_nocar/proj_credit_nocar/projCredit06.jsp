<%@page import="java.net.URLEncoder"%>
<%@page import="com.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>项目信审 - 06项目信审审批（只读）-信审会</title>

<!-- 插入样式和JS -->
<%@include file="/base_nocar/process.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm_nocar/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
<script type="text/javascript">
//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		fillHiddenVal();
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) return;
         
		if(fillHiddenVal("submit")==false) return;
		return true;
	}
</script>
</head>
<body>
	<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
	<input type="hidden" id="id_json_proj_guarantee_detail_str" 	name="json_proj_guarantee_detail_str" value='${empty json_proj_guarantee_detail_str ? "[]" : json_proj_guarantee_detail_str }'></input>
	<input type="hidden" id="id_json_proj_guaranty_detail_str" 	name="json_proj_guaranty_detail_str" value='${empty json_proj_guaranty_detail_str ? "[]" : json_proj_guaranty_detail_str }'></input>
	<!-- fileDetail letterDetail conclusionDetail directorDetail --> 
	<!-- id_json_proj_person_detail_str -->  
	<!-- id_json_proj_file_detail_str -->  
	<!-- id_json_proj_letter_detail_str -->  
	<!-- id_json_proj_conclusion_detail_str -->   
	<!-- id_json_proj_director_detail_str -->  
	<input type="hidden" id="id_json_proj_person_detail_str" 	name="id_json_proj_person_detail_str" value='${empty json_proj_guaranty_detail_str ? "[]" : id_json_proj_person_detail_str }'></input>
	<input type="hidden" id="id_json_proj_file_detail_str" 	name="id_json_proj_file_detail_str" value='${empty id_json_proj_file_detail_str ? "[]" : id_json_proj_file_detail_str }'></input>
	<input type="hidden" id="id_json_proj_letter_detail_str" 	name="id_json_proj_letter_detail_str" value='${empty id_json_proj_letter_detail_str ? "[]" : id_json_proj_letter_detail_str }'></input>
	<input type="hidden" id="id_json_proj_conclusion_detail_str" 	name="id_json_proj_conclusion_detail_str" value='${empty id_json_proj_conclusion_detail_str ? "[]" : id_json_proj_conclusion_detail_str }'></input>
	<input type="hidden" id="id_json_proj_director_detail_str" 	name="id_json_proj_director_detail_str" value='${empty id_json_proj_director_detail_str ? "[]" : id_json_proj_director_detail_str }'></input>
	<div>
		<table class="fillTable" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="4">
						<jsp:include page="../proj_approval_nocar/proj_base_info.jsp"/></td><!-- 插入项目基本信息 -->
				</td>
			</tr>
			</table>
	</div>

	<div class="mini-panel" title="项目商务条件" maskOnLoad="false" showCollapseButton="true" style="width: 100%;height:auto;">
			<div class="mini-tabs" activeIndex="0" plain="false" style="width: 100%;height:500px;" id="tab1" onactivechanged="changeheight">
				<div title="租赁物明细" name="equipList" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_equip_detail.bi?isViewHistoryTask=true">
				</div>
				<div title="商务条件" name="conditionDetail" iconCls="icon-cut">
					商务条件
				</div>
				<div title="担保单位信息" name="guaranteeDetail" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_guarantee_detail.bi?isViewHistoryTask=true">
				</div>
				<div title="抵押物信息" name="guarantyDeatil" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_guaranty_detail.bi?isViewHistoryTask=true">
				</div>																										
			    <div title="考察报告（自然人）" name="personDetail"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_credit_nocar/proj_person_report_comm.bi?isViewHistoryTask=true">
			        
			    </div>
			    <div title="考察报告（法人）" name="companyDetail" refreshOnClick="true"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_credit_nocar/proj_credit_report.bi?isViewHistoryTask=true">
			    </div>
			    <div title="文件清单" name="fileDetail"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_credit_nocar/proj_person_report_fileinfo.bi?isViewHistoryTask=true">
			        
			    </div>
			    <div title="信审结论" name="conclusionDetail"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_credit_nocar/proj_letter_conclusion.bi?isViewHistoryTask=true">
			        
			    </div>
			    <div title="信审会记录" name="letterDetail"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_credit_nocar/proj_letter_record.bi">
			        
			    </div>
		   </div>
	</div>
	<script>
	function changeheight(){
// 		setTimeout(function () {
// 			var tab1 = mini.get("tab1");
// 			for(var i = 0 ; i < tab1.tabs.length;i++){
// 				if(i == tab1.activeIndex){
// 					var tab = tab1.getTab(tab1.tabs[i].name);
// 					var iframe = tab1.getTabIFrameEl(tab);
// 				    var height = iframe.contentWindow.returnHeight();
// 				    tab1.setHeight(height+50);
// 				}
// 			}
//         }, 2000);
	}
    function fillHiddenVal(type){
    	var tabs = mini.get("tab1");
    	var Tab1 = tabs.getTab("equipList");
    	var Tab2 = tabs.getTab("guaranteeDetail");
    	var Tab3 = tabs.getTab("guarantyDeatil");
    	var Tab4 = tabs.getTab("personDetail");
    	var Tab5 = tabs.getTab("fileDetail");
    	var Tab6 = tabs.getTab("letterDetail");
    	var Tab7 = tabs.getTab("conclusionDetail");
    	    
    	var iframe1 = tabs.getTabIFrameEl(Tab1);
    	var iframe2 = tabs.getTabIFrameEl(Tab2);
    	var iframe3 = tabs.getTabIFrameEl(Tab3);
    	var iframe4 = tabs.getTabIFrameEl(Tab4);
    	var iframe5 = tabs.getTabIFrameEl(Tab5);
    	var iframe6 = tabs.getTabIFrameEl(Tab6);
    	var iframe7 = tabs.getTabIFrameEl(Tab7);
    	if(typeof(iframe1)!='undefined'){
    		var grid1 = iframe1.contentWindow.returnTab();
    		if("submit"==type){
    		    grid1.validate();
    		    if (grid1.isValid() == false) {
    			    alert("租赁物件信息错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_equip_str').val(JsonUtil.encode(grid1.getData()));
    	}
    	if(typeof(iframe2)!='undefined'){
    		var grid2 = iframe2.contentWindow.returnTab();
    		if("submit"==type){
    		    grid2.validate();
    		    if (grid2.isValid() == false) {
    			    alert("担保单位信息错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_guarantee_detail_str').val(JsonUtil.encode(grid2.getData()));
    	}
    	if(typeof(iframe3)!='undefined'){
    		var grid3 = iframe3.contentWindow.returnTab();
    		if("submit"==type){
    		    grid3.validate();
    		    if (grid3.isValid() == false) {
    			    alert("抵押物信息错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_guaranty_detail_str').val(JsonUtil.encode(grid3.getData()));
    	}
    	//action
//     	if(typeof(iframe4)!='undefined'){
//     		var grid3 = iframe3.contentWindow.returnTab();
//     		if("submit"==type){
//     		    grid3.validate();
//     		    if (grid3.isValid() == false) {
//     			    alert("考察报告(自然人)错误！！");
//     			    return false;
//     		    }
//     		}
//     		jQuery('#id_json_proj_person_detail_str').val(JsonUtil.encode(grid3.getData()));
//     	}
    	if(typeof(iframe5)!='undefined'){
    		var grid3 = iframe5.contentWindow.returnTab();
    		if("submit"==type){
    		    grid3.validate();
    		    if (grid3.isValid() == false) {
    			    alert("文件清单错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_file_detail_str').val(JsonUtil.encode(grid3.getData()));
    	}
    	if(typeof(iframe6)!='undefined'){
    		var grid3 = iframe6.contentWindow.returnTab();
    		if("submit"==type){
    		    grid3.validate();
    		    if (grid3.isValid() == false) {
    			    alert("信审会记录错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_letter_detail_str').val(JsonUtil.encode(grid3.getData()));
    	}
    	if(typeof(iframe7)!='undefined'){
    		var grid3 = iframe7.contentWindow.returnTab();
    		if("submit"==type){
    		    grid3.validate();
    		    if (grid3.isValid() == false) {
    			    alert("信审结论错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_conclusion_detail_str').val(JsonUtil.encode(grid3.getData()));
    	}
    }
	</script>
</body>
</html>