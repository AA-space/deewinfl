<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="r" uri="http://java.sun.com/jsp/jstl/core" %>
<r:if test="${empty needjs || (needjs eq '1')}">
<!DOCTYPE html PUBLIC"-//W3C//DTDXHTML1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<head>
	<%@include file="/base/mini.jsp" %>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/report/report.js"></script>
	<script type="text/javascript">
		var browserVersion = jQuery.browser.version;
		var pageWidth  = document.documentElement.clientWidth-2;
		var pageHeight = document.documentElement.clientHeight-2;
	</script>
	<style type="text/css">
		body{
			text-align:center;
		}

		.singleReport{
			width:98% !important;
			height:99% !important;
			margin-left:1% !important;
			margin-top:5px;
			border-left:1px solid #DDD;

		}
		.queryButton{
			float:right;			
			padding-top:1px;
			margin-left:10px;
		}

	</style>
</r:if>

<script type="text/javascript">

	jQuery(function(){
		mini.parse();
		window["func_table_${id}"]();		
	});

	var queryObject_${id} = new Object();
	window["func_table_${id}"] = function(){		
		queryObject_${id}.pageSize = ${pageSize};
		queryObject_${id}.id = '${id}';
		queryObject_${id}.name = '${title}';
		queryObject_${id}.type = 'TABLE';
		queryObject_${id}.url = '${pageContext.request.contextPath}/report/loadTableData2.action';
		
		jQuery.ajax({
			url:'${pageContext.request.contextPath}/report/getHeader.action',
			data:{'id':'${id}','pageWidth':pageWidth},
			dataType:'json',
			async:false,
			success:function(data){
				queryObject_${id}.headers=data;
			}
		});

		<r:if test="${empty searchs}">
			jQuery('#search_${id}').css('display','none');
			jQuery('#div_search_button_${id}').css('display','none');
		</r:if>
		<r:if test="${not empty searchs}">
			jQuery('#search_${id}').css('display','');
			jQuery('#div_search_button_${id}').css('display','');
		</r:if>
		
		jQuery('#filters_${id}').css('display','none');
		jQuery('#div_filter_button_${id}').css('display','none');
		jQuery('#div_showquery_button_${id}').css('display','none');
		

		var divHeight = pageHeight - 5;
		var divWidth = pageWidth - 3;
		var divCount = 1;
		<r:if test="${not empty divCount}">
			divCount = ${divCount};
		</r:if>

		queryObject_${id}.divCount = divCount;
		
		<r:if test="${width > 0 }">
			divWidth = ${width};
		</r:if>
		<r:choose>
			<r:when test="${height > 0}">
				divHeight = ${height};
			</r:when>
			<r:otherwise>
				divHeight = pageHeight - 47;
			</r:otherwise>
		</r:choose>
		
	

		queryObject_${id}.width = (divWidth - 5);
		queryObject_${id}.height = (divHeight - 5);		
		queryObject_${id}.hasFilter = false;
		var filter_fields_${id} = new Array();
		<r:if test="${not empty filters}">
			var filter_comboboxs_${id} = new Array();
			<r:forEach items="${filters}" var="filter">
				var filter_field_${filter.id} = new Object();
				filter_field_${filter.id}.id = "${filter.id}";
				filter_field_${filter.id}.name = "${filter.name}";
				filter_field_${filter.id}.value = "";
				filter_field_${filter.id}.type = "${filter.htmlType}";
				filter_field_${filter.id}.label = "${filter.label}";
				<r:if test="${filter.htmlType eq 'COMBOBOX'}" >
					filter_field_${filter.id}.requestType = "${filter.filterDataRequestType}";
					filter_field_${filter.id}.datasource="${(empty filter.comboBoxDataSource)?'':filter.comboBoxDataSource}";
					filter_field_${filter.id}.nameField = "${(empty filter.comboBoxNameField)?'text':filter.comboBoxNameField}";
					filter_field_${filter.id}.valueField = "${(empty filter.comboBoxValueField)?'value':filter.comboBoxValueField}";
					filter_field_${filter.id}.defaultValue="${(empty filter.defaultValue)?"":filter.defaultValue}";
					filter_comboboxs_${id}.push(filter_field_${filter.id});

				</r:if>
				filter_fields_${id}.push(filter_field_${filter.id});

			</r:forEach>
			createComboboxs(filter_comboboxs_${id},'filter','${id}'); 
			queryObject_${id}.filters = filter_fields_${id};
			queryObject_${id}.hasFilter = true;
		</r:if>

		
		var search_fields_${id} = new Array();
		<r:choose>
			<r:when test="${not empty searchs}">
				var search_comboboxs_${id} = new Array();
				<r:forEach items="${searchs}" var="search">
					var search_field_${search.id} = new Object();
					search_field_${search.id}.id = "${search.id}";
					search_field_${search.id}.name = "${search.name}";
					search_field_${search.id}.value = "";
					search_field_${search.id}.type = "${search.htmlType}";
					search_field_${search.id}.label = "${search.label}";
					<r:if test="${search.htmlType eq 'COMBOBOX'}">				
						search_field_${search.id}.requestType="${search.filterDataRequestType}";
						search_field_${search.id}.datasource="${(empty search.comboBoxDataSource)?'':search.comboBoxDataSource}";
						search_field_${search.id}.nameField = "${(empty search.comboBoxNameField)?'text':search.comboBoxNameField}";
						search_field_${search.id}.valueField = "${(empty search.comboBoxValueField)?'value':search.comboBoxValueField}";
						search_field_${search.id}.defaultValue="${(empty search.defaultValue)?"":search.defaultValue}";
						search_comboboxs_${id}.push(search_field_${search.id});
					</r:if>
					search_fields_${id}.push(search_field_${search.id});
				</r:forEach>
				queryObject_${id}.searchs = search_fields_${id};				
				createComboboxs(search_comboboxs_${id},'search','${id}');
				jQuery('#search_${id}').css('display','');
			</r:when>
			<r:otherwise>
				loadReportTableData(queryObject_${id});
			</r:otherwise>
		</r:choose>
		
		if(allQueryObjects != 'undefined'){
			allQueryObjects.push(queryObject_${id});
		}

	}

</script>
<r:if test="${empty needjs || (needjs eq '1')}">
</head>
<body>
</r:if>
<div id='table_${id}' class="singleReport x-panel-table-div x-panel-table-div-border">
	<div id="table_title_${id}" class="x-panel-table-div-title">
		<span class="x-panel-table-div-title-titleSpan">&nbsp;&nbsp;${title}</span>
		<div style="float:rigth">
			<div style="float:right;margin-right:10px;">&nbsp;</div>
			<div id="div_showquery_button_${id}" class="queryButton">
				<a href="javascript:void(0)" class="btn btn-primary" onclick="javascript:showOrHiddenQueryArea(this,'${id}');"><span>显示</span></a>
			</div>
			<div id="div_common_button_${id}" class="queryButton">
				<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:showExportWindow();"><span>导出</span></a>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<r:set var="columnCount" value="3" />

	
	<div id='search_${id}' style="display:none" class="x-panel-table-div-query-area">
			<center>
				<div id="searchcontainer_${id}" class="x-panel-table-div-query-area-auto-config">				
					<table style="width:85%;border:1px solid #fdfdfd;margin-top:20px;margin-bottom:20px;">
						<r:forEach items="${searchs}" var="search" varStatus="status">
							<r:if test="${status.index%columnCount eq 0}"><tr></r:if>								
								<td style="width:${100/(3*columnCount)}%">${search.label}</td>
								<td style="width:${200/(3*columnCount)}%">
								<r:choose>
									<r:when test="${search.htmlType eq 'TEXT' || empty search.htmlType}">
										<input id="search_${search.id}" name="search_${search.id}" class="mini-textbox" value="${(empty search.defaultValue)?'':search.defaultValue}" />
									</r:when>
									<r:when test="${search.htmlType eq 'COMBOBOX'}">							
										<input type="text" class="mini-combobox" id="search_${search.id}" name="search_${search.id}" />
									</r:when>
									<r:when test="${search.htmlType eq 'DATE'}">
										<input name="search_${search.id}" id="search_${search.id}"  label="${search.label}"  class="mini-datepicker" allowInput="false" type="text" />
									</r:when>
									<r:when test="${search.htmlType eq 'DATERANGE'}">
										<span>
										<input name="search_start_${search.id}" id="search_start_${search.id}"  label="${search.label}" style="width:84px;" class="mini-datepicker" allowInput="false" type="text" /></span><span style="float:left;margin-left:5px;margin-right:5px">至</span><span>
										<input name="search_end_${search.id}" id="search_end_${search.id}"  label="${search.label}"  style="width:84px;" class="mini-datepicker" allowInput="false" type="text" /></span>
									</r:when>
									<r:when test="${search.htmlType eq 'NUMBERRANGE'}">
										<span>
										<input name="search_start_${search.id}" id="search_start_${search.id}"  label="${search.label}" style="width:84px;" class="mini-textbox" type="text" /></span><span style="float:left;margin-left:5px;margin-right:5px">至</span><span>
										<input name="search_end_${search.id}" id="search_end_${search.id}"  label="${search.label}"  style="width:84px;" class="mini-textbox" type="text" /></span>
									</r:when>
									<r:otherwise>
										<input type="text" id="search_${search.id}" name="search_${search.id}" value="${(empty search.defaultValue)?'':search.defaultValue}" />
									</r:otherwise>
								</r:choose>
								</td>
							<r:if test="${(status.index+1)%columnCount eq 0}"></tr></r:if>
							<r:if test="${((status.index+1)%columnCount > 0) && status.last}">

								<r:forEach var="i" begin="1" end="${columnCount - (status.index+1)%columnCount}" step="1">
									<td style="width:${100/(3*columnCount)}%;border-right:0px">&nbsp;</td><td style="width:${200/(3*columnCount)}%;border-left:0px">&nbsp;</td>
								</r:forEach>

								</tr>
							</r:if>
						</r:forEach>		
						<tr >
							<td colspan="${columnCount*2}">
								<div id="div_search_button_${id}" style="float:left;padding-top:1px;display:none;margin-left:10px;">
									<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:doSearch(queryObject_${id});"><span>查询</span></a>	
									<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:doClear(queryObject_${id},'search');"><span>清空</span></a>			
								</div>
							</td>
						</tr>	
					</table>
				</div>
			</center>
	</div>
	
	<div id="filter_${id}" style="display:none" class="x-panel-table-div-query-area">
		<div id="filtercontainer_${id}" class="x-panel-table-div-query-area-auto-config">
			<table style="width:100%;border:1px solid #fdfdfd;">				
				<r:forEach items="${filters}" var="filter" varStatus="status">
					<r:if test="${status.index%columnCount eq 0}">
						<tr>
					</r:if>
						<td style="width:${100/(3*columnCount)}%">${filter.label}</td>
						<td style="width:${200/(3*columnCount)}%">						
							<r:choose>
								<r:when test="${filter.htmlType eq 'TEXT' || empty filter.htmlType}">
									<input class="mini-textbox" id="filter_${filter.id}" name="filter_${filter.id}" value="${(empty filter.defaultValue)?'':filter.defaultValue}" />						
								</r:when>
								<r:when test="${filter.htmlType eq 'COMBOBOX'}">
									<input type="text" class="mini-combobox" id="filter_${filter.id}" name="filter_${filter.id}" />
								</r:when>
								<r:when test="${filter.htmlType eq 'DATE'}">
									<input id="filter_${filter.id}" name="filter_${filter.id}" label="${filter.label}" class="mini-datepicker" allowInput="false" type="text" />
								</r:when>
								<r:when test="${filter.htmlType eq 'DATERANGE'}">
									<input name="filter_start_${filter.id}" id="filter_start_${filter.id}"  label="${filter.label}"  class="mini-datepicker" allowInput="false" type="text" /> - 
									<input name="filter_end_${filter.id}" id="filter_end_${filter.id}"  label="${filter.label}"  class="mini-datepicker"  allowInput="false" type="text" />		
								</r:when>
								<r:when test="${filter.htmlType eq 'NUMBERRANGE'}">
										<span>
										<input name="filter_start_${filter.id}" id="filter_start_${filter.id}"  label="${filter.label}" style="width:84px;" class="mini-textbox" type="text" /></span><span style="float:left;margin-left:5px;margin-right:5px">至</span><span>
										<input name="filter_end_${filter.id}" id="filter_end_${filter.id}"  label="${filter.label}"  style="width:84px;" class="mini-textbox" type="text" /></span>
									</r:when>
								<r:otherwise>
									<input class="mini-textbox" id="search_${filter.id}" name="filter_${filter.id}" value="${(empty filter.defaultValue)?'':filter.defaultValue}" />
								</r:otherwise>
							</r:choose>
						</td>
						<r:if test="${(status.index+1)%columnCount eq 0}">
							</tr>
						</r:if>
						<r:if test="${((status.index+1)%columnCount > 0) && status.last}">

							<r:forEach var="i" begin="1" end="${columnCount - (status.index+1)%columnCount}" step="1">
								<td style="width:${100/(3*columnCount)}%;border-right:0px">&nbsp;</td><td style="width:${200/(3*columnCount)}%;border-left:0px">&nbsp;</td>
							</r:forEach>

							</tr>
						</r:if>
						
				</r:forEach>
				<tr>
					<td colspan="${2*columnCount}">
						<div id="div_filter_button_${id}" style="float:left;padding-top:1px;display:none;margin-left:10px;">
							<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:doSearch(queryObject_${id});"><span>查询</span></a>
							<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:doClear(queryObject_${id},'filter');"><span>清空</span></a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="table_data_${id}" style="display:none;overflow:none;width:100%;"></div>
</div>
<r:if test="${empty needjs || (needjs eq '1')}">
<jsp:include page="export.jsp?reportName=${(empty reportName)?'':reportName}" flush="true" />
</body>
</html>
</r:if>