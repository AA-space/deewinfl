<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<%@ taglib prefix="fmt"  uri="/WEB-INF/tlds/fmt.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.business.util.MoneyUtils"%><html>
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css?version=3" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<!--<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MustFillIn.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/custType.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
-->




	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>


<script type="text/javascript">
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证信息修改</title>
<script type="text/javascript">
	function onSubmit(){
		var voucher = new Object();
		voucher.header = jQuery('#voucher_header').tracywindySerializeFormToJsonObject(true);
		var i = 0;
		var content = jQuery('#voucher_content_' + i);
		var allContents = new Array();
		while(content.length > 0){
			var contentObject = new Object();
			contentObject.content = content.tracywindySerializeFormToJsonObject(true);
			
			var k = 0;
			var intereasVoucherEntrie = jQuery('#intereasVoucherEntre_' + i + "_" + k);
			contentObject.intereasVoucherEntrie = new Array();
			while(intereasVoucherEntrie.length > 0 ){
				contentObject.intereasVoucherEntrie.push(intereasVoucherEntrie.tracywindySerializeFormToJsonObject(true));
				k++;
				intereasVoucherEntrie = jQuery('#intereasVoucherEntre_' + i + "_" + k);
			}
			allContents.push(contentObject);
			i++;
			content = jQuery('#voucher_content_' + i );
		}
		voucher.contents = allContents;
		var jsonString = JsonUtil.encode(voucher);
		showLoadMask();
		ajaxRequest({
			url:'${pageContext.request.contextPath}/leasing/updateIntereasVoucherMod.action',
			method:'post',
			params:{'data':jsonString},
			success:function(res){
				window.location.reload();
				hideLoadMask();
				var result = res.responseText;
				if(result == "TRUE"){
					alert("保存成功");
					//window.location.href = window.location.href;  //reload windows
				}else{
					alert(result);
				}
				
			}
		});
	}
	function del(eas_flag,id){
		//alert(eas_flag+"----------"+id);
		//var id=jQuery("#"+id).val();
		if(eas_flag!="1"){
			if(id!=""){
				var url = '${pageContext.request.contextPath}/leasing/removeIntereasVoucherasStacts.acl';
				var param={};
				param.eas_flag = eas_flag;
				param.id = id;
				ajaxRequest({
					 url:url,
		             params:param,
				       success:function(res){
							window.location.reload();
							hideLoadMask();
							var result = res.responseText;
							if(result == "TRUE"){
								alert("成功");
							}else{
								alert(result);
							}
						}
				});
			}
		}else{
			alert("该凭证已导入财务系统中，不允许删除，请联系管理员!");
		}
		
	}


	function checkBizDate(obj){
		//var bizDate = jQuery("#bizDate").val();
		bizDate = obj.value;
		if(bizDate!=""){
			var url = '${pageContext.request.contextPath}/leasing/checkBizDate.acl';
			var param={};
			param.bizDate=bizDate;
			ajaxRequest({
	             url:url,
	             params:param,
			     success:function(res){
				res=res.responseText; 
         	    if(res!=''){
         	    	var bookedDate = res.substring(0,10);
	  	        	$("#bookedDate").val(bookedDate); 
					var periodYear = res.substring(0,4);
					$("#periodYear").val(periodYear); 
					var periodNumber = res.substring(5,7);
					$("#periodNumber").val(periodNumber);
	  	        	 
				     }
			}
	        });
		}
		return false;
		}
	/**
	*  功能1 
	*  功能2：选择完“辅助账类型编码” “辅助账类型名称” 自动根据 voucherassstacts_info（辅助账类型表）带出
	*  功能3： “核算对象编码” 是由cust_info(客户表)读出来 然后查询出其cust_number(客户编号)
	*
	*/
	
	var idstr = "";
	var temp  = "";
	var cust_id = "";
	var asstActType = "";
/*
	 var divContainerDivId="";//加载的下拉框需要显示到的层ID
	 var tableName="";//查询数据来自的表
	 var valueColumnName:查询结果中隐式返回字段
	 var displayColumnName:查询结果中的显示字段
	 var fieldName:下拉框显示出来的输入域的域名
	 var defaultValue:默认显示值(隐式返回字段值)
	 var defaultRawValue:默认显示值
	 var otherAttributes:其他的附加在输入域上的属性
	 var selectFunc:下拉框发生select事件后需要触发的函数
	 var isContainEmpty:加载的下拉框是否有空选择项
	 var 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
		'value',"CUST_NUMBER",
		'custIdB_asstActNumber','',cust_id,
		'require="true" label="核算对象编码"',fuck
				,false);
	 */
	   var columns = [    
	                            {"cust":
			                            {
				                             "divContainerDivId":"id_asstActNumber",
				                             "tableName":"(SELECT CUST_NUMBER,ID||'/'||CUST_NUMBER AS value FROM CUST_INFO) rs",
		                                     "valueColumnName":"value",
		                                     "displayColumnName":"CUST_NUMBER",
		                                     "fieldName":"custIdB_asstActNumber",
		                                     "defaultValue":"",
		                                     "defaultRawValue":"cust_id",
		                                     "otherAttributes":'require="true" label="核算对象编码"',
		                                     "selectFunc":"fuck",
		                                     "isContainEmpty":"false"
					                    },
			                     "contract":
					                    {
					                    	 "divContainerDivId":"id_asstActNumber",
				                             "tableName":"(SELECT CONTRACT_ID,ID||'/'||CONTRACT_ID AS value FROM CONTRACT_INFO) rs",
		                                     "valueColumnName":"value",
		                                     "displayColumnName":"CONTRACT_ID",
		                                     "fieldName":"custIdB_asstActNumber",
		                                     "defaultValue":"",
		                                     "defaultRawValue":"cust_id",
		                                     "otherAttributes":'require="true" label="核算对象编码"',
		                                     "selectFunc":"fuck",
		                                     "isContainEmpty":"false"
		                                }
	                            }          
	          
	                  	  	 ];

		var divContainerDivId = divContainerDivId||"id_asstActNumber";
		var tableName = tableName||"(SELECT CUST_NUMBER,ID||'/'||CUST_NUMBER AS value FROM CUST_INFO) rs";
		var valueColumnName = valueColumnName||"value";
		var displayColumnName = displayColumnName||"CUST_NUMBER";
		var fieldName = fieldName||"custIdB_asstActNumber";
		var defaultValue = "";
		var defaultRawValue = defaultRawValue||cust_id;
		var otherAttributes = otherAttributes||'require="true" label="核算对象编码"';
		var selectFuncName = selectFuncName||"fuck";
		var isContainEmpty = isContainEmpty||"false";         	
	jQuery(function(){

		//alert(columns[0].contract['tableName']);
			idstr = idstr.substr(0,idstr.length-1);
			var id_str = idstr.split(',');
			for(var i=0;i<id_str.length;i++){
				temp = id_str[i];
				var selectFunc = (function(temp){
					return 	function(code,data) {
						/*
						--1 核算对象编码取值  包括点‘详情’和‘修改’
						--001情况下从客户表中去取对应的客户名称
						--002情况下从合同表中取出对应的合同编号
						--003至007 情况下预留一个可以查询对应名称的接口或者sql方便以后修改
						*/
						flag = data.value;
						if("voucherassstacts_info_id_2" == flag){
							tableName = columns[0].contract['tableName'];
							valueColumnName = columns[0].contract['valueColumnName'];
							displayColumnName = columns[0].contract['displayColumnName'];
							var id_asstActNumber = getTracywindyObject("id_combo_id_asstActNumber"+temp);
							id_asstActNumber.rawValue = cust_id;
							id_asstActNumber.setParams({
								tableName:tableName,
								valueColumnName:valueColumnName,
								displayColumnName:displayColumnName
							});
							id_asstActNumber.reload();
						}else{
							divContainerDivId = columns[0].cust['divContainerDivId'];
							tableName = columns[0].cust['tableName'];
							valueColumnName = columns[0].cust['valueColumnName'];
							fieldName = columns[0].cust['fieldName'];
							defaultValue = columns[0].cust['defaultValue'];
							defaultRawValue = columns[0].cust['defaultRawValue'];
							otherAttributes = columns[0].cust['otherAttributes'];
							selectFuncName = columns[0].cust['selectFunc'];
							isContainEmpty = columns[0].cust['isContainEmpty'];
						}
						var url = '${pageContext.request.contextPath}/leasing/changeValue.acl';
						var param  = {};
						param.voucherassstacts_info_id = data.value;
						ajaxRequest({
				            url:url,
				            params:param,
						    success:function(res){
							res=JsonUtil.decode(res.responseText); 
			         	    if(res!=""){
					         	    if(res.asstacttypename!=""){
										jQuery("#id_asstActTypeName"+temp).val(res.asstacttypename);
					         	    }else{
					         	    	jQuery("#id_asstActTypeName"+temp).val("");
					         	    }
					         	    if(res.id!=""){
					         	    	jQuery("#id_asstacttype"+temp).val(res.asstacttype);
					         	    }else{
					         	    	jQuery("#id_asstacttype"+temp).val("");
					         	    }
			         	    }
						}});
					};
				})(temp);
				
				asstActType = jQuery("#id_asstacttype"+id_str[i]).val();
				if(" "!=id_str[i]&&id_str[i]!=null&""!=id_str[i]){
				commonSelectOverall("id_is_asstacttype"+id_str[i],
				"(select id,asstacttype from voucherassstacts_info) rs",
				'id',"asstacttype",'asstActType',
				'',asstActType,'require="true" label="辅助账类型编码"', selectFunc,false);
				
				//核算对象编码 
				var fuck = (function(temp){
					return 	function(code,data) {
						var values = data.value.split("/");
						jQuery("#id_custIdB"+temp).val(values[0]);
						jQuery("#asstActNumber"+temp).val(values[1]);
					};
				})(temp);
				cust_id = jQuery("#asstActNumber"+id_str[i]).val();
				commonSelectOverall("id_asstActNumber"+id_str[i],
						"(SELECT CUST_NUMBER,ID||'/'||CUST_NUMBER AS value FROM CUST_INFO) rs",
						'value',"CUST_NUMBER",
						'custIdB_asstActNumber','',cust_id,
						'require="true" label="核算对象编码"',fuck
								,false);
				}

			}
		});
	
</script>
</head>

<body>
	<div id="div_formdata">
		<div style="text-align: left;height: 30px; margin: 0px;">
			<a style="margin-left: 20px; margin-right: 20px" href="javascript:void(0);" class="btn btn-primary" onclick="javascript:onSubmit()"><span>修改</span></a>
		</div>
		
			<table  id="voucher_header" style="width:100%;border:0px" class="x-panel-table">
			    <tr ><td colspan="9" class="x-panel-table-div-title" style="padding-left:20px;">凭证头</td>
			    <td><input name="id"  value="${intereasVoucherHead.id}" label="凭证头id"   type="hidden" /></td>
			    </tr>

			    <tr>
			    	<td>凭证号</td>
			    	<td>${intereasVoucherHead.voucherNumber}</td>
			    	<td>公司编码</td>
			    	<td>${intereasVoucherHead.companyNumber.orgCode}</td>
			    	<td>记账日期（会记处理日）</td>
			    	<td><input  readonly name="bookedDate" id="bookedDate" value="${intereasVoucherHead.bookedDate}"   type="text"  class="td-content-input"  label="记账日期（会计处理日）"></td>
				</tr>
				
				<tr>
					<td>业务日期</td>
			    	<td><input class="Wdate td-content-input" onchange="checkBizDate(this)" id="bizDate" name="bizDate" value="${intereasVoucherHead.bizDate}" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'});"  label="业务日期"></td>
					<td>会计期间-年</td>
					<td><input name="periodYear" id="periodYear" readonly value="${intereasVoucherHead.periodYear}" class="td-content-input" label="会计期间-年"   type="text" /></td>
					<td>会计期间-月</td>
					<td><input name="periodNumber" id="periodNumber" readonly value="${intereasVoucherHead.periodNumber}" class="td-content-input"  label="会计期间-月"   type="text" /></td>
				</tr>
				
				<tr>
					<td>凭证类型</td>
					<td>
						<input name="voucherType" id="voucherType" value="${intereasVoucherHead.voucherType.code}" class="td-content-input"  label="凭证类型"   type="hidden" />
						<input value="${intereasVoucherHead.voucherType.name}" class="td-content-input" type="text" />
						</td>
					<td>制单人</td>
			    	<td>${intereasVoucherHead.creator.realname}</td>
				</tr>
			</table>
		
			<c:set var="intereasVoucherEntries" value="${intereasVoucherHead.intereasVoucherEntries}"/>
			<c:set var="entrieLen" value="${fn:length(intereasVoucherEntries)}"/>
		    <c:forEach items="${intereasVoucherEntries}" var="intereasVoucherEntrie" varStatus="entrieStatus">
		       <table id="voucher_content_${entrieStatus.index}" style="width:100%;border:0px" class="x-panel-table">
			    <tr>
			    	<td colspan="9" class="x-panel-table-div-title" style="padding-left:60px;">凭证体${intereasVoucherEntrie.entrySeq}</td>
			    	<td><input  name="id" value="${intereasVoucherEntrie.id}" label="凭证体id"   type="hidden" /></td>
			    </tr>
			    <tr></tr>
			    <tr>
			    	<td colspan="2" align="right">凭证号</td>
			    	<td>${intereasVoucherHead.voucherNumber}</td>
			    	<td>分录行号</td>
					<td>${intereasVoucherEntrie.entrySeq}</td>
			    	<td>摘要</td>
					<td>
						<input id="id_voucherAbstract_${intereasVoucherEntrie.entrySeq}" name="voucherAbstract" class="td-content-input" style="width:300px;" value="${intereasVoucherEntrie.voucherAbstract}" size="100" label="摘要"   type="text" />
						<script type="text/javascript">$("#id_voucherAbstract_${intereasVoucherEntrie.entrySeq}").val(formatNumberThousand('${intereasVoucherEntrie.voucherAbstract}'));</script>
						</td>
				</tr>
				
				<tr>
					<td colspan="2" align="right">科目编码</td>
					<td>
						<input name="accountNumber" value="${intereasVoucherEntrie.accountNumber.id}" class="td-content-input"  label="科目编码"   type="hidden" />
					    <input value="${intereasVoucherEntrie.accountNumber.subjectsCode}" class="td-content-input"  label="科目编码"   type="text" />
					</td>
					<td>方向</td>
					<td>${intereasVoucherEntrie.entryDC}</td>
					<td>币别编码</td>
					<td>${intereasVoucherEntrie.currencyNumber.name}</td>
				</tr>
				
				<tr>
					<td colspan="2" align="right">原币金额</td>
					<td>
						<span id="id_originalAmount_${intereasVoucherEntrie.entrySeq}"></span>
					    <script type="text/javascript">$("#id_originalAmount_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.originalAmount}'));</script>
					</td>
					<td>借方金额</td>
			    	<td>
					    <span id="id_debitAmount_${intereasVoucherEntrie.entrySeq}"></span>
					    <script type="text/javascript">$("#id_debitAmount_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.debitAmount}'));</script>
					</td>
			    	<td>贷方金额</td>
			    	<td>
						<span id="id_creditAmount_${intereasVoucherEntrie.entrySeq}"></span>
					    <script type="text/javascript">$("#id_creditAmount_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.creditAmount}'));</script>
					</td>
				</tr>
			</table>
		
		   	 <c:set var="stactLen" value="${fn:length(intereasVoucherasStacts)}"/>
			 <c:set var="intereasVoucherasStacts" value="${intereasVoucherEntrie.intereasVoucherasStacts}"/>
			 <c:forEach items="${intereasVoucherasStacts}" var="intereasVoucherasStact" varStatus="stactStatus">
			 
					<table  id="intereasVoucherEntre_${entrieStatus.index}_${stactStatus.index}" style="width:100%;border:0px" class="x-panel-table">
					    <tr>
						    <td colspan="9" class="x-panel-table-div-title" style="padding-left:100px;">凭证体${intereasVoucherEntrie.entrySeq}-辅助账${intereasVoucherasStact.asstSeq}</td>
						    <td>
						    	<input  name="id" value="${intereasVoucherasStact.id}" label="辅助账id"   type="hidden"/>
						    </td>
					    </tr>
					    <tr></tr>
					    <tr>
					    	<td colspan="4" align="right">凭证号</td>
					    	<td><span id="id_voucherNumber_${entrieStatus.index}_${stactStatus.index}">${intereasVoucherHead.voucherNumber}</span></td>
					    	<td>辅助账行号</td>
							<td><span id="id_asstSeq_${entrieStatus.index}_${stactStatus.index}">${intereasVoucherasStact.asstSeq}</span></td>
					    	<td>辅助账类型编码</td>
							<td>
								<!-- <input name="asstActType" value="${intereasVoucherasStact.asstActType.asstActType}" class="td-content-input"  label="辅助账类型编码"   type="text" /> -->
								<!-- <select id="id_asstActType" name="asstActType" label="辅助账类型编码" >
							
									<option value="${intereasVoucherasStact.asstActType.asstActType}">${intereasVoucherasStact.asstActType.asstActType}</option>
								</select>-->
		     <%--<% String str = request.getParameter("id_is_asstacttype_${intereasVoucherEntrie.entrySeq}_${intereasVoucherasStact.asstSeq}");
								<c:param name="arr" value="id_is_asstacttype_${intereasVoucherEntrie.entrySeq}_${intereasVoucherasStact.asstSeq}"></c:param>--%>
								<script type="text/javascript">
								
								 idstr = idstr +"_${entrieStatus.index}_${stactStatus.index}"+",";
								// asstActType = "${intereasVoucherasStact.asstActType.asstActType}";
								 //cust_id = "${intereasVoucherasStact.asstActNumber}";
								</script>
								<div id="id_is_asstacttype_${entrieStatus.index}_${stactStatus.index}"></div>
								
							</td>
						</tr>
						
						<tr>
							<td colspan="4" align="right">辅助账类型名称</td>
							<td>
								<input id="id_asstActTypeName_${entrieStatus.index}_${stactStatus.index}" name="asstActTypeName" value="${intereasVoucherasStact.asstActTypeName}" class="td-content-input"  label="辅助账类型名称"   type="text" />
							</td>
							<td>核算对象编码</td>
							<td>
								<!-- <input id="id_custIdB_custNumber_${entrieStatus.index}_${stactStatus.index}" name="custIdB_custNumber" value="${intereasVoucherasStact.custIdB.custNumber}" class="td-content-input"  label="核算对象编码"   type="text" /> -->
								<div id="id_asstActNumber_${entrieStatus.index}_${stactStatus.index}" style="display:none"></div>
								<!-- 隐藏字段 -->
								<input type="hidden" id="id_custIdB_${entrieStatus.index}_${stactStatus.index}" name="custIdB" value="${intereasVoucherasStact.custIdB.id}"/>
								<input type="text" class="td-content-input" style="width:200px;" id="asstActNumber_${entrieStatus.index}_${stactStatus.index}" name="asstActNumber" value="${intereasVoucherasStact.asstActNumber}"></input>
								<input type="hidden" id="id_asstacttype_${entrieStatus.index}_${stactStatus.index}" name="asstActType2" value="${intereasVoucherasStact.asstActType.asstActType}"></input>
							</td>
							<td>
							 	<button name="delid" id="delid_voucherNumber_${entrieStatus.index}_${stactStatus.index}" value="${intereasVoucherasStact.id}" onclick="del('${intereasVoucherHead.eas_flag}','delid_voucherNumber_${entrieStatus.index}_${stactStatus.index}')">删除</button>
							</td>
							<td></td>
						</tr>
					</table>
					 </c:forEach>
	 </c:forEach>
    </div>	
 </body>
</html>
