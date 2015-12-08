<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<%@ taglib prefix="fmt"  uri="/WEB-INF/tlds/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css?version=3" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证详细信息</title>
<style type="text/css">
       table.x-panel-table td {
         border:1px solid #DDD;
         border-top:0px solid #DDD;
      }
</style>
</head>
<body>
			<table  style="width:100%;border:0px" class="x-panel-table">
			    <tr ><td colspan="9" class="x-panel-table-div-title" style="padding-left:20px;">凭证头</td></tr>
				<tr>
				    <td style="width:50px;border:0px;">&nbsp;</td>
					<td>凭证号</td>
					<td>公司编码</td>
					<td>客户名称</td>
					<td>记账日期</td>
					<td>业务日期</td>
					<td>凭证字</td>
					<td>凭证状态</td>
					<td>导出状态</td>
			    </tr>
			    <tr>
			       <td style="width:50px;border:0px;">&nbsp;</td>
			       <td>${intereasVoucherHead.voucherNumber}</td>
			       <td>${intereasVoucherHead.companyNumber.orgCode}</td>
			       <td>${intereasVoucherHead.contract_id.custId.custName}</td>
			       <td>${intereasVoucherHead.bookedDate}</td>
			       <td>${intereasVoucherHead.bizDate}</td>
			       <td>${intereasVoucherHead.voucherType.name}</td>
			       <td>${intereasVoucherHead.status}</td>
			       <td><c:if test="${'1' eq intereasVoucherHead.eas_flag}">已导出</c:if><c:if test="${'0' eq intereasVoucherHead.eas_flag}">未导出</c:if></td>
			    </tr>
			<c:set var="intereasVoucherEntries" value="${intereasVoucherHead.intereasVoucherEntries}"/>
		    <c:forEach items="${intereasVoucherEntries}" var="intereasVoucherEntrie" varStatus="entrieStatus">
		       <c:set var="entrieLen" value="${fn:length(intereasVoucherEntries)}"/>
		       <tr><td colspan="9" class="x-panel-table-div-title" style="padding-left:60px;" >凭证体</td></tr>
		       <tr><td colspan="9" style="border:0px;">
		        <table class="x-panel-table" style="width:100%;border:0px">
			        <tr>
			            <td style="border:0px;width:100px;">&nbsp;</td>
						<td>分录行号</td>
						<td>摘要</td>
						<td>科目编码</td>
						<td>方向</td>
						<td>币别</td>
						<td>原币金额</td>
						<td>借方金额</td>
						<td style="border-right:0px;">贷方金额</td>
					</tr>
		            <tr>
			            <td style="border:0px;width:100px;"></td>
			       		<td>${intereasVoucherEntrie.entrySeq}</td>
			       		<td>
						<span id="id_voucherAbstract_${intereasVoucherEntrie.entrySeq}"></span>
						<script type="text/javascript">$("#id_voucherAbstract_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.voucherAbstract}'));</script>
						</td>
			       		<td>${intereasVoucherEntrie.accountNumber.subjectsCode}</td>
			       		<td>${intereasVoucherEntrie.entryDC}</td>
			       		<td>${intereasVoucherEntrie.currencyNumber.name}</td>
			       		<td>
						<span id="id_originalAmount_${intereasVoucherEntrie.entrySeq}"></span>
					    <script type="text/javascript">$("#id_originalAmount_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.originalAmount}'));</script>
						</td>
			       		<td>
						<span id="id_debitAmount_${intereasVoucherEntrie.entrySeq}"></span>
					    <script type="text/javascript">$("#id_debitAmount_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.debitAmount}'));</script>
						</td>
			       		<td style="border-right:0px;">
						<span id="id_creditAmount_${intereasVoucherEntrie.entrySeq}"></span>
					    <script type="text/javascript">$("#id_creditAmount_${intereasVoucherEntrie.entrySeq}").html(formatNumberThousand('${intereasVoucherEntrie.creditAmount}'));</script>
						</td>
				    </tr>
		       <c:set var="intereasVoucherasStacts" value="${intereasVoucherEntrie.intereasVoucherasStacts}"/>
		       <c:forEach items="${intereasVoucherasStacts}" var="intereasVoucherasStact" varStatus="stactStatus">
		           <c:set var="stactLen" value="${fn:length(intereasVoucherasStacts)}"/>
		           <c:if test="${0 == stactStatus.index}">
		             <tr><td colspan="10" class="x-panel-table-div-title" style="padding-left:100px;" >辅助账</td></tr>
		             <tr><td colspan="10" style="border:0px;">
		             <table class="x-panel-table" style="width:100%;border:0px;">
		             <tr>
		             <td style="border:0px;width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
		             <td>辅助账行号</td>
		             <td>辅助账类型编码</td>
		             <td>辅助账类型名称</td>
		             <td>核算对象编码</td>
		             <td>核算对象名称</td>
		             <td style="border-right:0px;">是否完整</td>
		             </tr>
		           </c:if>
		           <tr>
		            <c:set var="borderWidth" value="1px"/>
		            <c:if test="${(stactLen -1 ) == stactStatus.index}"> <c:set var="borderWidth" value="1px"/></c:if>
		            <td style="border:0px;width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
		             <td style="border-bottom-width:${borderWidth}">${intereasVoucherasStact.asstSeq}</td>
		             <td style="border-bottom-width:${borderWidth}">${intereasVoucherasStact.asstActType.asstActType}</td>
		             <td style="border-bottom-width:${borderWidth}">${intereasVoucherasStact.asstActTypeName}</td>
		             <td style="border-bottom-width:${borderWidth}">${intereasVoucherasStact.custIdB.custNumber}</td>
		             <td style="border-bottom-width:${borderWidth}">${intereasVoucherasStact.custIdB.custName}</td>
		             <td style="border-right:0px;">${intereasVoucherHead.status}</td>
		           </tr>
		           <c:if test="${(stactLen -1 ) == stactStatus.index}">
			          </table></td></tr>
				   </c:if>
		       </c:forEach>
		       <c:if test="${(entrieLen -1 ) == entrieStatus.index}"></c:if>
			   </table></td></tr>
			</c:forEach>
	</table>
	
</body>
</html>