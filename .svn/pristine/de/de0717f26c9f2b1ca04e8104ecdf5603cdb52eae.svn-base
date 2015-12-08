<%@page import="java.net.URLEncoder"%>
<%@page import="com.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>项目信审 - 申请项目信审</title>
<!-- 插入样式和JS -->
<%@include file="/base_nocar/process.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm_nocar/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
<script type="text/javascript">
isViewHistoryTask = true;
var notdisplay=true;
//mini.parse("assetinfogrid");
	//注：alert(flowUnid);
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
	<input type="hidden" id="id_json_word_list_str" 	name="id_json_word_list_str" value='${empty id_json_word_list_str ? "[]" : id_json_word_list_str }'></input>
	
	<input type="hidden" id="id_flow_unid"></input>
	<div class="fillTableContainer">
		<table class="fillTable" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan=4>
					<!-- 插入项目基本信息 --> <jsp:include page="../proj_approval_nocar/proj_base_info.jsp?isViewHistoryTask=true"></jsp:include></td>
			</tr>
			<tr>
				<td colspan=4>
					<!-- 插入项目基本信息 --> <jsp:include page="../proj_reconsider_nocar/proj_credit_result_info.jsp"></jsp:include></td>
			</tr>
			<tr>
				<td colspan=4>
					<div id="projectinfo" class="mini-panel" title="项目商务条件" maskOnLoad="false" showCollapseButton="true" style="width: 100%;height:auto;">
							<div class="mini-tabs" activeIndex="0" plain="false" borderStyle="border:0" style="width: 100%;height:900px;" id="tab1" >
								<div title="租赁物明细" name="equipList" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_equip_detail.bi?isViewHistoryTask=true">
								</div>
								<div title="商务条件" name="conditionDetail" iconCls="icon-cut">
									<jsp:include page="../../rent_reckon/rent_reckon/rentCal_4_5nocar.jsp"></jsp:include>
								</div>
								<div title="担保单位信息" name="guaranteeDetail" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_guarantee_detail.bi?isViewHistoryTask=true">
								</div>
								<div title="抵押物信息" name="guarantyDeatil" iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_approval_nocar/proj_guaranty_detail.bi?isViewHistoryTask=true">
								</div>																										
							    <div title="考察报告（自然人）" name="personDetail" iconCls="icon-cut">
							        <jsp:include page="proj_person_report_comm.jsp"></jsp:include>
							    </div>
							    <div title="考察报告（法人）" name="companyDetail"   iconCls="icon-cut">
							    <jsp:include page="proj_credit_report.jsp" ></jsp:include>
							    </div>
							    <div title="文件清单" name="fileDetail"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/proj_credit_nocar/proj_person_report_fileinfo.bi?isViewHistoryTask=true" >
							        
							    </div>
							    <div title="生成客户信审报告" name="creditReportxls"   iconCls="icon-cut" url="<%=request.getContextPath()%>/workflow/forms/project_nocar/project_comm_nocar/credit_report/proj_credit_reportxls.bi?isViewHistoryTask=true">
							        
							    </div>
						   </div>
					</div>	
				</td>
			</tr>
		</table>
	</div>
	<script>
	//是否存在指定函数 
	debugger;
	jQuery('#id_flow_unid').val(flowUnid);
	//自然人考察报告
	mini.parse("personid");
	//资产信息
	var grid = mini.get("assetinfogrid");
	var assetinfo=$("#id_json_assetinfogrid").val();
	grid.setData(mini.decode(assetinfo));
	//收入来源
	var revenuegrid = mini.get("revenuegrid");
	var revenueinfo=$("#id_json_revenuegrid").val();
	revenuegrid.setData(mini.decode(revenueinfo));
	
	//债务调查
	var debtanalysisgrid = mini.get("debtanalysisgrid");
	var debtanalysisinfo=$("#id_json_debtanalysisgrid").val();
	debtanalysisgrid.setData(mini.decode(debtanalysisinfo));
	
	//债权调查
	var surveygrid = mini.get("surveygrid");
	var surveyinfo=$("#id_json_surveygrid").val();
	surveygrid.setData(mini.decode(surveyinfo));
	
	//法人报告
	mini.parse("companyid");
	//承租企业重要个人基本信息
	var vippersongrid = mini.get("vippersongrid");
	var vippersoninfo=$("#id_json_vippersongrid").val();
	vippersongrid.setData(mini.decode(vippersoninfo));
	
	//与其他融资企业的相关交易情况
	var corporationgrid = mini.get("corporationgrid");
	var corporationinfo=$("#id_json_corporationgrid").val();
	corporationgrid.setData(mini.decode(corporationinfo));
	
	//与本融资企业的相关交易情况
	var localcorporationgrid = mini.get("localcorporationgrid");
	var localcorporationinfo=$("#id_json_localcorporationgrid").val();
	localcorporationgrid.setData(mini.decode(localcorporationinfo));
	
	//银行资信情况
	var ebankcreditgrid = mini.get("ebankcreditgrid");
	var ebankcreditinfo=$("#id_json_ebankcreditgrid").val();
	ebankcreditgrid.setData(mini.decode(ebankcreditinfo));
	
	//银行资信情况
	var assetgrid = mini.get("assetgrid");
	var assetgridinfo=$("#id_json_assetgrid").val();
	assetgrid.setData(mini.decode(assetgridinfo));
	
	//控制只读页面
	if(isViewHistoryTask){
	//mini.parse("personid");
	var form = new mini.Form("projectinfo");
	var o = form.getData(); 
	var fields = form.getFields();
	for(var index =0;index<fields.length;index++){
		 //判断是否是下拉框控件，是则同时把text属性传入后台
		if(fields[index].uiCls == "mini-combobox" || fields[index].uiCls =="mini-datepicker"){
			fields[index].disable();
		}else{
			fields[index].allowInput=false;
		}
	}
	}

	
	function isExitsFunction(funcName) {
	    try {
	        if (typeof(eval(funcName)) == "function") {
	            return true;
	        }
	    } catch(e) {}
	    return false;
	}
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
    	var Tab6 = tabs.getTab("creditReportxls");
    	    
    	var iframe1 = tabs.getTabIFrameEl(Tab1);
    	var iframe2 = tabs.getTabIFrameEl(Tab2);
    	var iframe3 = tabs.getTabIFrameEl(Tab3);
    	var iframe4 = tabs.getTabIFrameEl(Tab4);
    	var iframe5 = tabs.getTabIFrameEl(Tab5);
    	var iframe6 = tabs.getTabIFrameEl(Tab6);
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
//     	//action
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
    		var grid5 = iframe5.contentWindow.returnTab();
    		if("submit"==type){
    		    grid5.validate();
    		    if (grid5.isValid() == false) {
    			    alert("文件清单错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_proj_file_detail_str').val(JsonUtil.encode(grid5.getData()));
    	}
    	
    	if(typeof(iframe6)!='undefined'){
    		var grid6 = iframe6.contentWindow.returnTab();
    		if("submit"==type){
    		    grid6.validate();
    		    if (grid6.isValid() == false) {
    			    alert("生成客户信审报告错误！！");
    			    return false;
    		    }
    		}
    		jQuery('#id_json_word_list_str').val(JsonUtil.encode(grid6.getData()));
    	}
    	//保存清单
    	jQuery('#id_json_assetinfogrid').val(JsonUtil.encode(mini.get("assetinfogrid").getData()));
    	jQuery('#id_json_revenuegrid').val(JsonUtil.encode(mini.get("revenuegrid").getData()));
    	jQuery('#id_json_debtanalysisgrid').val(JsonUtil.encode(mini.get("debtanalysisgrid").getData()));
    	jQuery('#id_json_surveygrid').val(JsonUtil.encode(mini.get("surveygrid").getData()));
    	
    	//法人报告
    	jQuery('#id_json_vippersongrid').val(JsonUtil.encode(mini.get("vippersongrid").getData()));
    	jQuery('#id_json_corporationgrid').val(JsonUtil.encode(mini.get("corporationgrid").getData()));
    	jQuery('#id_json_localcorporationgrid').val(JsonUtil.encode(mini.get("localcorporationgrid").getData()));
    	jQuery('#id_json_ebankcreditgrid').val(JsonUtil.encode(mini.get("ebankcreditgrid").getData()));
    	jQuery('#id_json_assetgrid').val(JsonUtil.encode(mini.get("assetgrid").getData()));
    }
	</script>
</body>
</html>