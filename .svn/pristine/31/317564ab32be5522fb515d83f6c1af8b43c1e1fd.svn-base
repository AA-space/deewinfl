<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script language="javascript">
	jQuery(function(){
    	commonSelect('id_proj_dept','t_depts','id_','name_','dealer_approval_info.approvaldept','${empty requestScope["dealer_approval_info.approvaldept"] ? sessionScope["loginUserDeptObj"].id : requestScope["dealer_approval_info.approvaldept"] }',null,' require="true" label="申请部门"',false);
    	commonSelect('id_proj_registrar','t_users','id_','realname_','dealer_approval_info.approval','${empty requestScope["dealer_approval_info.approval"] ? sessionScope.loginUser.id : requestScope["dealer_approval_info.approval"]}',null,' require="true" label="申请人"',false);
    });
	</script>
<table cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-per_money"></div>
		申请信息</td>
	</tr>
 <tr class="tr-project-info tr-even">   
             <td class="td-content-title">申请部门：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_dept"></div><font class="required-content">*</font></td>
             <td class="td-content-title">申请人：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_registrar"></div><font class="required-content">*</font></td>
         </tr>
         <tr class="tr-project-info tr-odd">
          <td class="td-content-title"> 申请时间：</td><td class="td-content" colspan="3"><input name="dealer_approval_info.approvaltime" class="Wdate td-content-input td-content-readonly"  
             type="text" value='${empty requestScope["dealer_approval_info.approvaltime"] ? requestScope["current_date"] : requestScope["dealer_approval_info.approvaltime"]}'  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="申请时间" /><font class="required-content">*</font></td>
        </tr>
</table>