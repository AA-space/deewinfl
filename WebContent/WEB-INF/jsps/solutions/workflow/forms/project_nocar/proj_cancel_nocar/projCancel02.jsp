<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>项目撤销</title>
<!-- 插入样式和JS -->
<%@include file="/base_nocar/process.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm_nocar/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
 
<style type="text/css">
</style>
</head>
<body>
<script type="text/javascript">
isViewHistoryTask = true;
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
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_detail_str" 	name="json_proj_guarantee_detail_str" value='${empty json_proj_guarantee_detail_str ? "[]" : json_proj_guarantee_detail_str }'></input>
<input type="hidden" id="id_json_proj_guaranty_detail_str" 	name="json_proj_guaranty_detail_str" value='${empty json_proj_guaranty_detail_str ? "[]" : json_proj_guaranty_detail_str }'></input>

<input type="hidden" id="id_proj_info_repealdate" 	name="proj_info.repealdate" value="${requestScope['proj_info.repealdate']}"></input>
<input type="hidden" id="id_proj_info_repealreason" name="proj_info.repealreason" value="${requestScope['proj_info.repealreason']}"></input>
<input type="hidden" id="id_proj_info_dictionarydatabyrepealreasontype" name="proj_info.dictionarydatabyrepealreasontype" value="${requestScope['proj_info.dictionarydatabyrepealreasontype']}"></input>
<input type="hidden" id="id_rawValue_proj_info_dictionarydatabyrepealreasontype" name="rawvalue_proj_info.dictionarydatabyrepealreasontype" value="${requestScope['rawvalue_proj_info.dictionarydatabyrepealreasontype']}"></input>

	<div class="fillTableContainer">
		<table class="fillTable" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan=4>
					<!-- 插入项目基本信息 --> <jsp:include page="../proj_approval_nocar/proj_base_info.jsp"></jsp:include></td>
			</tr>
			
			<tr>
				<td colspan=4>
					<div class="mini-panel" title="项目商务条件" showCollapseButton="true" style="width: 99%;">
				
					<div id="tabDeatils" class="mini-tabs" activeIndex="0"
						style="width: 100%; height: 600px" bodyStyle="padding:0;border:0;">
						<div title="撤销说明" name="cancelDetail" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_cancel_nocar/proj_cancel_reason.bi?isViewHistoryTask=true">
							
						</div>

						<div title="租赁物明细" name="equipList" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_equip_detail.bi?isViewHistoryTask=true">
							
						</div>
						<div title="商务条件" name="conditionDetail" iconCls="icon-cut">
							<jsp:include page="../../rent_reckon/rent_reckon/rentCal_4_5nocar.jsp"></jsp:include>
						</div>
						<div title="担保单位信息" name="guaranteeDetail" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_guarantee_detail.bi?isViewHistoryTask=true">
						</div>
						<div title="抵押物信息" name="guarantyDeatil" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_guaranty_detail.bi?isViewHistoryTask=true">
						</div>

					  </div>
					</div>
				</td>
			</tr>
		</table>
	</div>

</body>
<script type="text/javascript">
        function fillHiddenVal(type){
        	//alert(11);
        	var tabs = mini.get("tabDeatils");
        	var Tab0 = tabs.getTab("cancelDetail");
        	var Tab1 = tabs.getTab("equipList");
        	var Tab2 = tabs.getTab("guaranteeDetail");
        	var Tab3 = tabs.getTab("guarantyDeatil");
        	
        	var iframe0 = tabs.getTabIFrameEl(Tab0);
        	var iframe1 = tabs.getTabIFrameEl(Tab1);
        	var iframe2 = tabs.getTabIFrameEl(Tab2);
        	var iframe3 = tabs.getTabIFrameEl(Tab3);
        	if(typeof(iframe0)!='undefined'){
        		var grid0 = iframe0.contentWindow.returnTab();
        		debugger;
        		//保存子页面数据
        		var o = grid0.getData();
        		var repealdate=o.proj_info.repealdate;
        		$("#id_proj_info_repealdate").val(mini.formatDate (repealdate,"yyyy-MM-dd"));
        		
        		var repealreason=o.proj_info.repealreason;
        		$("#id_proj_info_repealreason").val(repealreason);
        		$("#id_proj_info_dictionarydatabyrepealreasontype").val(o.proj_info.dictionarydatabyrepealreasontype);
        		$("#id_rawValue_proj_info_dictionarydatabyrepealreasontype").val(o.rawValue_proj_info.dictionarydatabyrepealreasontype);
        		if("submit"==type){
        		   grid0.validate();
        		   if (grid0.isValid() == false) {
        			  alert("变更说明信息错误！！");
        			  return false;
        		   }
        		}
        	}
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
        }
</script>
</html>