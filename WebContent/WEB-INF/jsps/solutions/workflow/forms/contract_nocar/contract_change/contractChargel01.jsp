<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 插入样式和JS -->
<%@include file="/base_nocar/process.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm_nocar/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
   
<style type="text/css">
body{
	overflow: auto;
}
</style>
<script type="text/javascript">
	isViewHistoryTask = false;
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}

	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		//fillHiddenVal();
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		var form = new mini.Form("#form1");
        form.validate();
        if (form.isValid() == false) return;
         
		if(fillHiddenVal("submit")==false) return;
		return true;
	}
	//isSubTable = true;
	var currentClientWidth = document.documentElement.clientWidth;
	var currentClientHeight = document.documentElement.clientHeight;
</script>
<!--多行控件  -->
<div>
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str"  value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_detail_str" name="json_contract_guarantee_detail_str" value='${empty json_contract_guarantee_detail_str ? "[]" : json_contract_guarantee_detail_str }'></input>
<input type="hidden" id="id_json_contract_guaranty_detail_str" name="json_contract_guaranty_detail_str" value='${empty json_contract_guaranty_detail_str ? "[]" : json_contract_guaranty_detail_str }'></input>

<input type="hidden" id="id_json_contract_supplier_str" name="json_contract_supplier_str" value='${empty json_contract_supplier_str ? "[]" : json_contract_supplier_str }'></input>
<input type="hidden" id="id_json_contract_premise_str" name="json_contract_premise_str_put" value='${empty json_contract_premise_str_put ? "[]" : json_contract_premise_str_put }'></input>

<input type="hidden" id="id_contract_other_info_contractchangedate" 	name="contract_other_info.contractchangedate" value="${requestScope['contract_other_info.contractchangedate']}"></input>
<input type="hidden" id="id_contract_other_info_contractchangememo" name="contract_other_info.contractchangememo" value="${requestScope['contract_other_info.contractchangememo']}"></input>

</div>
<div id="contract_approval_form">
	<div class="fillTableContainer">
		<table class="fillTable" cellspacing="0" cellpadding="0">
			<tr>
				<td ><!-- 插入项目基本信息 --> <jsp:include page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
			</tr>
		</table>
	</div>
	<div class="mini-panel" title="项目商务条件" maskOnLoad="false" showCollapseButton="true" style="width: 100%">
			<div class="mini-tabs"  plain="false" style="width: 100%;height:auto" id="tab1">
				<div title="合同变更信息" name="changeList" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/contract_nocar/contract_change/contract_change_info.bi">
				</div>
				<div title="租赁物明细" name="equipList" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/contract_nocar/contract_approval/contract_equip_detail.bi">
				</div>
				<div title="商务条件" name="conditionDetail" iconCls="icon-cut">
					 <jsp:include page="../../rent_reckon/rent_reckon/rentCal_4_5nocar.jsp"></jsp:include>
				</div>
				<div title="担保单位信息" name="guaranteeDetail" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/contract_nocar/contract_approval/contract_guarantee_detail.bi">
				</div>	
				<div title="抵押物信息" name="guarantyDeatil" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/contract_nocar/contract_approval/contract_guaranty_detail.bi">
				</div>
			    <div title="合同各方" name="contractAllParties" iconCls="icon-cut">
			         <jsp:include page="../contract_approval/contract_signatory.jsp"></jsp:include>
			    </div>
			    <div title="投放前提条件" name="fileDetail"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/contract_nocar/contract_approval/contract_premise_info.bi">
			    </div>
		   </div>
	</div>
</div>
<script>
jQuery(function(){
	$("#tabDetails").css({height:currentClientHeight-423});
});
mini.parse(document.getElementById("contract_approval_form"));
debugger;
//合同各方，供应商信息
var signatorygrid = mini.get("signatorygrid");
var signatorygridinfo=$("#id_json_contract_supplier_str").val();
signatorygrid.setData(mini.decode(signatorygridinfo));

function fillHiddenVal(type){
	debugger;
	var tabs = mini.get("tab1");
	var Tab0 = tabs.getTab("changeList");
	var Tab1 = tabs.getTab("equipList");
	var Tab2 = tabs.getTab("guaranteeDetail");
	var Tab3 = tabs.getTab("guarantyDeatil");
	var Tab5 = tabs.getTab("fileDetail");
	
	var iframe0 = tabs.getTabIFrameEl(Tab0);
	var iframe1 = tabs.getTabIFrameEl(Tab1);
	var iframe2 = tabs.getTabIFrameEl(Tab2);
	var iframe3 = tabs.getTabIFrameEl(Tab3);
	var iframe5 = tabs.getTabIFrameEl(Tab5);
	
	if(typeof(iframe0)!='undefined'){
		var grid0 = iframe0.contentWindow.returnTab();
		debugger;
		//保存子页面数据
		var o = grid0.getData();
		var repealdate=o.contract_other_info.contractchangedate;
		$("#id_contract_other_info_contractchangedate").val(mini.formatDate (repealdate,"yyyy-MM-dd"));
		var repealreason=o.contract_other_info.contractchangememo;
		$("#id_contract_other_info_contractchangememo").val(repealreason);
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
		jQuery('#id_json_contract_equip_str').val(JsonUtil.encode(grid1.getData()));
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
		jQuery('#id_json_contract_guarantee_detail_str').val(JsonUtil.encode(grid2.getData()));
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
		jQuery('#id_json_contract_guaranty_detail_str').val(JsonUtil.encode(grid3.getData()));
	}
	
	if(typeof(iframe5)!='undefined'){
		var grid5 = iframe5.contentWindow.returnTab();
		if("submit"==type){
		    grid5.validate();
		    if (grid5.isValid() == false) {
			    alert("生成客户信审报告错误！！");
			    return false;
		    }
		}
		jQuery('#id_json_contract_premise_str').val(JsonUtil.encode(grid5.getData()));
	}
	//合同各方信息
	jQuery('#id_json_contract_supplier_str').val(JsonUtil.encode(signatorygrid.getData()));
}
</script>