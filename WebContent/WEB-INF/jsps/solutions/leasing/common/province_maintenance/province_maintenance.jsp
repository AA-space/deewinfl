<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市编码维护</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
    <style type="text/css">
		html,body{
			overflow:hidden;
		}
		.picItem{
			float:left;
			padding:5px 5px 5px 5px;
			border:1px solid silver;
		}
		.ul_district_list li{
			list-style-type: none;
			line-height: 20px;
			font-size: 12px;
			padding-left: 10px;
			cursor: pointer;
		}
		.li_selected{
			background-color: #FBEC88;
		}
		.li_hover{
			background-color: #FAFAFA;
		}
		li span{
			margin-right: 100px;
			float: right;
		}
	</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth;
	var pageHeight = document.documentElement.clientHeight-10;
	
	this_province = null;
	this_city = null;
	this_county = null;
	//【省份 城市 县区】选中事件及鼠标悬停事件
	function bindEvent(ul_id_district,obj,tempstr){
		//【省份 城市 县区】绑定鼠标悬停事件
		$("#" + ul_id_district + " li").mouseover(function(){
			if($(this).hasClass("li_selected") == false){
				$(this).addClass("li_hover");
			}
		}).mouseout(function(){
			$(this).removeClass("li_hover");
		});
		

		//【省份 城市 县区】绑定单击事件
		$("#" + ul_id_district + " li").bind("click",function(){
			if(obj != null){
				obj.removeClass("li_selected");
			}
			$(this).removeClass("li_hover");
			$(this).addClass("li_selected");
			obj = $(this);
			if(tempstr != ""){
				loadDistrict(tempstr,$(this).attr("districtid"));
				$("#" + tempstr + "_title").html("（" + obj.attr("districtname") + "）");
			}
		});
	}
	
	//ajax方式加载地区，
	function loadDistrict(ul_id_district,pid){
		var params = {};
		params['xmlFileName'] = "/acl/queryDistrict.xml";
		
		if(pid == 'CHN'){
			params['inpid'] = "'DB','HB','HD','HN','HZ','TQ','XB','XN'";
		} else {
			params['pid'] = pid;
		}
		
		ajaxRequest({
			url: "${pageContext.request.contextPath}/table/getTableData.action",
			params:params,
			success: function(res) {
				var jsondata = eval('(' + res.responseText + ')').datas;
				var li_str = "";
				if(jsondata[0].id != ""){
					for(var i = 0;i < jsondata.length;i ++){
						li_str += "<li districtid='" + jsondata[i].id +"' districtname='" + jsondata[i].name + "'><span>" + jsondata[i].id + "</span>" + jsondata[i].name + "</li>";
					}
				}
				$("#" + ul_id_district).html(li_str);
				if(ul_id_district == "id_list_province"){
					bindEvent(ul_id_district,this_province,"id_list_city");
				}else if(ul_id_district == "id_list_city"){
					bindEvent(ul_id_district,this_city,"id_list_county");
				}else{
					bindEvent(ul_id_district,this_county,"");
				}
			},
            failure: function(res) {
                alert("Server Unavailable");
            }
		});
	}
	
	jQuery(function(){
		//加载省份数据，生成省份列表
		loadDistrict("id_list_province","CHN");
		
		//Validator.DistrictCode = '/^[0-9]\d{6}$/';
		//Validator.ErrDistrictCode = '地区编码必须是六位数字！';
		
	});
</script>
</head>
<body>
<div id='menu_main_province' style="overflow:hidden;float:left;width:375px;border:1px solid #DDD;border:0px;">
	<div class="panel-title" style="margin-top:0px;border-top:0px;">省份</div>
	<div id="id_div_province" style="border:1px solid #DDD;border-top:0px;overflow:auto;">
		<ul id="id_list_province" class="ul_district_list" style="padding-left: 5px;margin-top: 3px;"></ul>
	</div>
</div>
<div id='menu_main_city' style="overflow:hidden;float:left;border-bottom:1px solid #DDD;">
	<div class="panel-title" >城市&nbsp;&nbsp;<font color="red" id="id_list_city_title"></font></div>
	<div class="panel-title" style="padding-top: 5px;">
		<a href="javascript:void(0);" onclick="showDiv('addcity');" style="TEXT-INDENT: 0px" class="l-btn l-btn-plain" plain="true">
			<SPAN class=l-btn-left><SPAN style="PADDING-LEFT: 20px" class="l-btn-text icon-plus">添加</SPAN></SPAN>
		</a>
		<a href="javascript:void(0);" onclick="showDiv('editcity');" style="TEXT-INDENT: 0px" class="l-btn l-btn-plain" plain="true">
			<SPAN class=l-btn-left><SPAN style="PADDING-LEFT: 20px" class="l-btn-text icon-update">修改</SPAN></SPAN>
		</a>
		<a href="javascript:void(0);" onclick="removeDistrict('city');" style="TEXT-INDENT: 0px" class="l-btn l-btn-plain" plain="true">
			<SPAN class=l-btn-left><SPAN style="PADDING-LEFT: 20px" class="l-btn-text icon-remove">删除</SPAN></SPAN>
		</a>
	</div>
	<div id="id_div_city" style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;">
		<ul id="id_list_city" class="ul_district_list" style="padding-left: 5px;margin-top: 3px;"></ul>
	</div>
</div>
<div id='menu_main_county' style="overflow:hidden;float:left;border-bottom:1px solid #DDD;">
	<div class="panel-title" >区县&nbsp;&nbsp;<font color="red" id="id_list_county_title"></font></div>
	<div class="panel-title" style="padding-top: 5px;">
		<a href="javascript:void(0);" onclick="showDiv('addcounty');" style="TEXT-INDENT: 0px" class="l-btn l-btn-plain" plain="true">
			<SPAN class=l-btn-left><SPAN style="PADDING-LEFT: 20px" class="l-btn-text icon-plus">添加</SPAN></SPAN>
		</a>
		<a href="javascript:void(0);" onclick="showDiv('editcounty');" style="TEXT-INDENT: 0px" class="l-btn l-btn-plain" plain="true">
			<SPAN class=l-btn-left><SPAN style="PADDING-LEFT: 20px" class="l-btn-text icon-update">修改</SPAN></SPAN>
		</a>
		<a href="javascript:void(0);" onclick="removeDistrict('county');" style="TEXT-INDENT: 0px" class="l-btn l-btn-plain" plain="true">
			<SPAN class=l-btn-left><SPAN style="PADDING-LEFT: 20px" class="l-btn-text icon-remove">删除</SPAN></SPAN>
		</a>
	</div>
	<div id="id_div_county" style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;">
		<ul id="id_list_county" class="ul_district_list" style="padding-left: 10px;margin-top: 3px;"></ul>
	</div>
</div>
<div id="id_detailInfoWindowContianer" buttons="#id-dlg-buttons" closed="true" modal="true" style="display:none;width:400px;padding-top:20px;height:280px;">
	<center>
		<form id="id_detailInfoForm">
			<table style="width:90%" class="fillTable">
				<tr style="display:none"><td colspan="2"><input name="pid" type="hidden" value=""/><input id="opertype" type="hidden" value=""/></td></tr>
				<tr class="tr-even">
					<td class="td-content-title">名称:</td>
					<td class="td-content" nowrap="nowrap">
						<input name="name" id="name" label="名称" class="td-content-input" require="true" dataType="Chinese" type="text" /><font class="required-content">*</font>
					</td>
				</tr>
				<tr class="tr-odd">
					<td class="td-content-title">编码:</td>
					<td class="td-content" nowrap="nowrap">
						<input name="id" id="id" label="编码" class="td-content-input" require="true" dataType="Number" type="text" /><font class="required-content">*</font>
					</td>
				</tr>
			</table>
		</form>
	</center>
</div>
<div style="text-align:center;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
	<a style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitDistrict()'><span>确定</span></a>
	<a style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContianer").dialog("close");'><span>取消</span></a>
</div>
</body>
</html>
<script type='text/javascript'>
	$('#menu_main_province').css("height",pageHeight);
	$('#menu_main_city').css("height",pageHeight);
	$('#menu_main_county').css("height",pageHeight);
	$('#menu_main_province').css("width",pageWidth*0.33);
	$('#menu_main_city').css("width",pageWidth*0.33);
	$('#menu_main_county').css("width",pageWidth*0.33);
	$('#id_div_province').css("height",pageHeight-35);
	$('#id_div_city').css("height",pageHeight-80);
	$('#id_div_county').css("height",pageHeight-80);
	
	//新增 修改显示窗口
	function showDiv(oper){
		var $obj = $("#id_detailInfoWindowContianer");
		$obj.show();
		$("#id_detailInfoForm")[0].reset();
		var tempnum = "";
		if(oper == 'addcity'){
			$obj.dialog({autoScroll: true,title:"新增（城市）"});
			$("input[name='pid']").val($("#id_list_province .li_selected").attr("districtid"));
			tempnum = 1;
			if(isSelected("id_list_province")){alert("请先选中上级省份！");return;}
		}else if(oper == 'editcity'){
			$obj.dialog({autoScroll: true,title:"修改（城市）"});
			$("input[name='pid']").val($("#id_list_province .li_selected").attr("districtid"));
			$("input[name='name']").val($("#id_list_city .li_selected").attr("districtname"));
			$("input[name='id']").val($("#id_list_city .li_selected").attr("districtid"));
			tempnum = 2;
			if(isSelected("id_list_province")){alert("请先选中上级省份！");return;}
			if(isSelected("id_list_city")){alert("请先选中要修改的城市！");return;}
		}else if(oper == 'addcounty'){
			$obj.dialog({autoScroll: true,title:"新增（区县）"});
			$("input[name='pid']").val($("#id_list_city .li_selected").attr("districtid"));
			tempnum = 3;
			if(isSelected("id_list_city")){alert("请先选中上级城市！");return;}
		}else if(oper == 'editcounty'){
			$obj.dialog({autoScroll: true,title:"修改（区县）"});
			$("input[name='pid']").val($("#id_list_city .li_selected").attr("districtid"));
			$("input[name='name']").val($("#id_list_county .li_selected").attr("districtname"));
			$("input[name='id']").val($("#id_list_county .li_selected").attr("districtid"));
			tempnum = 4;
			if(isSelected("id_list_city")){alert("请先选中上级城市！");return;}
			if(isSelected("id_list_county")){alert("请先选中要修改的区县！");return;}
		}
		$("#opertype").val(tempnum);
		$obj.dialog('open');
	}

	
	//新增 修改提交方法
	function submitDistrict(){
		var $form = jQuery("#id_detailInfoForm");
		if(!Validator.Validate($form[0], 1, false)){return;}
		if($("#id").val().length != '6'){alert('地区编码必须是六位数字！');return;}
		if(isExist($("#id").val()) && ($("#opertype").val() == 1 || $("#opertype").val() == 3)){alert("该编码已存在，请重新输入！");return;}
		
		var url = "";
		var arr = new Array();
		if($("#opertype").val() == 1 || $("#opertype").val() == 3){
			arr[0] = "新增";
			arr[1] = "add";
		}else if($("#opertype").val() == 2 || $("#opertype").val() == 4){
			arr[0] = "修改";
			arr[1] = "update";
		}
		if($("#opertype").val() == 1 || $("#opertype").val() == 2){
			arr[2] = "id_list_city";
			arr[3] = $("input[name='pid']").val();
		}else if($("#opertype").val() == 3 || $("#opertype").val() == 4){
			arr[2] = "id_list_county";
			arr[3] = $("input[name='pid']").val();
		}
		if(confirm("确定" + arr[0] + "该记录么？") == false){
			return;
		}else{
			url = "${pageContext.request.contextPath}/district/" + arr[1] + "District.acl";
		}
		var params = $("#id_detailInfoForm").tracywindySerializeFormToJsonObject(true);
        ajaxRequest({
            url: url,
            params: params,
            timeout: 30 * 1000,
            success: function(res) {
            	alert(arr[0] + "成功！");
            	jQuery("#id_detailInfoWindowContianer").dialog("close");
            	loadDistrict(arr[2],arr[3]);
            }
        });
	}
	
	//删除地区
	function removeDistrict(dist){
		var arr = new Array();
		if(dist == "city"){
			arr[0] = "城市（" + $("#id_list_city .li_selected").attr("districtname") + "）";
			arr[1] = $("#id_list_city .li_selected").attr("districtid");
			arr[2] = "id_list_city";
			arr[3] = $("#id_list_province .li_selected").attr("districtid");
			if(isSelected("id_list_city")){alert("请先选中要删除的城市！");return;}
			if($("#id_list_county:has(li)").html()!=undefined){alert("请先删除所有属于该城市的区县！");return;}
		}else if(dist == "county"){
			arr[0] = "区县（" + $("#id_list_county .li_selected").attr("districtname") + "）";
			arr[1] = $("#id_list_county .li_selected").attr("districtid");
			arr[2] = "id_list_county";
			arr[3] = $("#id_list_city .li_selected").attr("districtid");
			if(isSelected("id_list_county")){alert("请先选中要删除的区县！");return;}
		}
		var url = "${pageContext.request.contextPath}/district/removeDistrict.acl";
		var params = {};
		params["id"] = arr[1];
		if(confirm("确定删除该" + arr[0] + "么？")){
		   ajaxRequest({
	            url: url,
	            params: params,
	            timeout: 30 * 1000,
	            success: function(res) {
	            	alert("删除成功!");
	            	loadDistrict(arr[2],arr[3]);
	            }
	        });
		}
	}
	
	//判断某ul是否有选中元素
	function isSelected(id_list_dist){
		return $("#" + id_list_dist + " .li_selected").attr("districtid") == undefined;
	}
	//查看某编码是否已存在
	function isExist(id){
		flag = false;
		var params = {};
		params['xmlFileName'] = "/acl/queryDistrict.xml";
		params['id'] = id;
		ajaxRequest({
			url: "${pageContext.request.contextPath}/table/getTableData.action",
			params:params,
			async:false,
			success: function(res) {
				var jsondata = eval('(' + res.responseText + ')').datas;
				if(jsondata[0].id == ""){
					flag = false;
				}else{
					flag = true;
				}
			},
            failure: function(res) {
                alert("Server Unavailable");
            }
		});
		return flag;
	}
</script>