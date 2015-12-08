<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script language="javascript">
    function showLawCustInfo(cust_id){
    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
    	var params = {cust_id:cust_id};
	    openFullScreenWindow(URL,params);
        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }
    </script>
<table cellspacing="0" cellpadding="0" id="proj_base_info">
	<tr>
		<td class="x-panel-table-div-title" colspan=4>
		    <div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-info"></div>
		经销商信息</td>
	</tr>
	<tr class="tr-project-info tr-even">
		<td class="td-content-title" style="width:17%">经销商名称：</td>
		<td class="td-content">
		 <input name="cust_info.id" type="hidden" value="${requestScope['cust_info.id'] }">
              <input  name="cust_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="经销商名称"  type="text" value="${requestScope['cust_info.custname'] }" >
              <a href="javascript:void(0);"><img alt="经销商信息" src="${pageContext.request.contextPath}/menuIcons/department.png" onclick="showLawCustInfo('${requestScope['cust_info.id'] }')"/></a>
             <font class="required-content">*</font></td>
		<td class="td-content-title" style="width:17%">准入编号：</td>
		<td class="td-content"><input name="dealer_approval_info.creditnum"
			class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['dealer_approval_info.creditnum'] }"><font
			class="required-content">*</font></td>
	</tr>
	<tr class="tr-project-info tr-odd">
		   <td class="td-content-title">注册时间：</td><td class="td-content"><input name="dealer_approval_info.regdate" class="td-content-input td-content-readonly"  
             type="text" value="${requestScope['dealer_approval_info.regdate'] }"  readOnly require="true" label="注册时间" /><font class="required-content">*</font></td>
             <td class="td-content-title">注册资本：</td><td class="td-content"><input name="dealer_approval_info.regcapital" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealer_approval_info.regcapital'] }"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-project-info tr-even">
		 <td class="td-content-title">实收资本：</td><td class="td-content"><input name="dealer_approval_info.incomeassets" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['dealer_approval_info.incomeassets'] }"><font class="required-content">*</font></td>
            
		<td class="td-content-title"></td>
		<td class="td-content" id="q_c7"></td>
	</tr>
	<tr class="tr-project-info tr-even">
		<td class="td-content-title" colspan="4" style="color: red">详细资料补充请到附件一览操作</td>
	</tr>

</table>