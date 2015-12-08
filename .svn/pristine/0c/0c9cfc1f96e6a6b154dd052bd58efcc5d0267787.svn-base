
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
    function showLawCustInfo(cust_id){
    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
    	var params = {cust_id:cust_id};
	    openFullScreenWindow(URL,params);
        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }
</script>
    <table cellspacing="0" cellpadding="0">
	  <tr>
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>经销商额度调整申请</td>
	  </tr>
	  <tr class="tr-project-info tr-even">
		<td class="td-content-title" style="width:17%">经销商名称：</td>  
		<td class="td-content" style="width:33%">
		 <input name="cust_info.id" type="hidden" value="${requestScope['cust_info.id'] }">
              <input  name="cust_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="经销商名称"  type="text" value="${requestScope['cust_info.custname'] }" >
              <a href="javascript:void(0);"><img alt="经销商信息" src="${pageContext.request.contextPath}/menuIcons/department.png" onclick="showLawCustInfo('${requestScope['cust_info.id'] }')"/></a>
             <font class="required-content">*</font></td>
         <td class="td-content-title" style="width:17%">当前授信额度：</td>  
		<td class="td-content" style="width:33%">
		  <input   type="text"  name="dealer_credit_info.creditmoney"  value="${requestScope['dealer_credit_info.creditmoney'] }" class="td-content-input td-content-readonly" readonly="readonly">	  
		</td>
	  </tr>
	  <tr class="tr-project-info tr-odd">
          <td class="td-content-title"> 经销商已使用额度：</td><td class="td-content" ><input name="dealer_credit_info.credituse" class=" td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.credituse"] ? '' : requestScope["dealer_credit_info.credituse"]}'   readOnly require="true"  /></td>
         <td class="td-content-title"> 剩余额度：</td><td class="td-content" ><input name="dealer_credit_info.creditlast" class="td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.creditlast"] ? '' : requestScope["dealer_credit_info.creditlast"]}' readOnly require="true"/></td>
       </tr>
	   <tr class="tr-project-info tr-odd">
          <td class="td-content-title"> 当前授信额度开始日期：</td><td class="td-content" ><input name="dealer_credit_info.creditstardate" class=" td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.creditstardate"] ? '' : requestScope["dealer_credit_info.creditstardate"]}'   readOnly require="true" label="当前授信额度开始日期" /><font class="required-content">*</font></td>
         <td class="td-content-title"> 当前授信额度结束日期：</td><td class="td-content" ><input name="dealer_credit_info.creditenddate" class="td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.creditenddate"] ? '' : requestScope["dealer_credit_info.creditenddate"]}' readOnly require="true" label="当前授信额度结束日期" /><font class="required-content">*</font></td>
        </tr>
	  <tr class="tr-project-info tr-even">
		  <td class="td-content-title" align="left">授信金额额度调整为:  </td>  
		  <td class="td-content"><input   type="text"  name="dealer_credit_info.adjustcreditmoney"  value='${requestScope["dealer_credit_info.adjustcreditmoney"]}' class="td-content-input" datatype="Number" require="true"  label="授信金额额度调整为"><font class="required-content">*</font></td>
		  <td class="td-content-title" align="left">应收保证金:  </td>  
		  <td class="td-content"><input   type="text"  name="dealer_credit_info.cautionmoney"  value='${requestScope["dealer_credit_info.cautionmoney"]}' class="td-content-input" datatype="Number" require="true"  label="应收保证金为"><font class="required-content">*</font></td>
	  </tr>
	   <tr class="tr-project-info tr-odd">
          <td class="td-content-title">授信额度开始日期调整为：</td><td class="td-content" ><input name="dealer_credit_info.adjustcreditstardate" class="Wdate td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.adjustcreditstardate"] ? requestScope["dealer_credit_info.creditstardate"] : requestScope["dealer_credit_info.adjustcreditstardate"]}'  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="授信额度开始日期调整" /><font class="required-content">*</font></td>
         <td class="td-content-title"> 授信额度结束日期调整为：</td><td class="td-content" ><input name="dealer_credit_info.adjustcreditenddate" class="Wdate td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.adjustcreditenddate"] ? requestScope["dealer_credit_info.creditenddate"]: requestScope["dealer_credit_info.adjustcreditenddate"]}'  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="授信额度结束日期调整" /><font class="required-content">*</font></td>
        </tr>
	  <tr>
	   <td class="td-content-title" align="left">调整方式:  </td>
		  <td class="td-content" colspan="3">
		  	<textarea rows="5" cols="30" style="width:98.9%;float:left;" name="dealer_credit_info.adjustmode" maxB="300" require="true"  label="调整方式">${requestScope['dealer_credit_info.adjustmode'] }</textarea>
		 </td>
	  </tr>
	  <tr class="tr-project-info tr-odd">
		 <td class="td-content-title" align="left">调整原因:</td>
	     <td class="td-content" colspan="3">
			<textarea rows="5" cols="30" style="width:98.9%;float:left;" name="dealer_credit_info.adjustreason" maxB="300" require="true"  label="调整原因">${requestScope['dealer_credit_info.adjustreason'] }</textarea>
		 </td>
	  </tr>
	  <tr class="tr-project-info tr-even">
		   <td class="td-content-title" align="left">调整日期:  </td>  
		   <td class="td-content" ><input name="dealer_credit_info.adjustdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_credit_info.adjustdate"] ? '' : requestScope["dealer_credit_info.adjustdate"]}'  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="调整日期" /><font class="required-content">*</font></td>
		   <td class="td-content-title" align="left"> </td>  
		   <td class="td-content">	            	
		   </td>
	</tr> 
	</table>
	