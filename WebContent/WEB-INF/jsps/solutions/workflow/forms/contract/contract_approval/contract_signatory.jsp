<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!--合同各方信息 -->
<table cellspacing="0" cellpadding="0">
	<tr>
	    <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-lessor-info"></div>出租方基本信息(甲方)</td>
	 </tr>
	 <tr class="tr-lessor-info tr-even">
	    <td class="td-content-title">出租人：</td><td class="td-content"><input require="true" label="出租人" name="contract_signatory.lessor" class="td-content-input"  type="text" value="${requestScope['contract_signatory.lessor']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">委托代理人：</td><td class="td-content"><input require="true" label="委托代理人" name="contract_signatory.leaseconsigner" class="td-content-input" type="text" value="${requestScope['contract_signatory.leaseconsigner']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-lessor-info tr-odd">
	    <td class="td-content-title">注册地址：</td><td class="td-content"><input require="true" label="注册地址" name="contract_signatory.leaseregisteraddr" class="td-content-input"  type="text" value="${requestScope['contract_signatory.leaseregisteraddr']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">通讯地址：</td><td class="td-content"><input require="true" label="通讯地址" name="contract_signatory.leaseaddr" class="td-content-input" type="text" value="${requestScope['contract_signatory.leaseaddr']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-lessor-info tr-even">
	    <td class="td-content-title">法定代表人：</td><td class="td-content"><input require="true" label="法定代表人" name="contract_signatory.leaseperson" class="td-content-input"  type="text" value="${requestScope['contract_signatory.leaseperson']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">邮编：</td><td class="td-content"><input require="true" label="邮编" name="contract_signatory.leasepostcode" class="td-content-input" type="text" value="${requestScope['contract_signatory.leasepostcode']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-lessor-info tr-odd">
	    <td class="td-content-title">联系人：</td><td class="td-content"><input require="true" label="联系人" name="contract_signatory.leaselinkman" class="td-content-input"  type="text" value="${requestScope['contract_signatory.leaselinkman']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">电话：</td><td class="td-content"><input require="true" label="电话" name="contract_signatory.leasetel" class="td-content-input" type="text" value="${requestScope['contract_signatory.leasetel']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-lessor-info tr-even">
	    <td class="td-content-title">传真：</td><td class="td-content"><input label="传真" name="contract_signatory.leasefax" class="td-content-input"  type="text" value="${requestScope['contract_signatory.leasefax']}"></td>
	    <td class="td-content-title">电子邮件：</td><td class="td-content"><input label="电子邮件" name="contract_signatory.leaseemail" class="td-content-input" type="text" value="${requestScope['contract_signatory.leaseemail']}"></td>
	</tr>
	<tr class="tr-lessor-info tr-odd">
	    <td class="td-content-title">开户账号：</td><td class="td-content"><input require="true" label="开户账号" name="contract_signatory.leaseaccnumber" class="td-content-input"  type="text" value="${requestScope['contract_signatory.leaseaccnumber']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">开户银行：</td><td class="td-content"><input require="true" label="开户银行" name="contract_signatory.leaseaccbank" class="td-content-input" type="text" value="${requestScope['contract_signatory.leaseaccbank']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-lessor-info tr-even">
	    <td class="td-content-title">开户户名：</td><td class="td-content"><input require="true" label="开户户名" name="contract_signatory.leaseaccname" class="td-content-input"  type="text" value="${requestScope['contract_signatory.leaseaccname']}"><font class="required-content">*</font></td>
	    <td class="td-content-title"></td><td class="td-content"></td>
	</tr>
	<tr>
	    <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-client-info"></div>承租方基本信息(乙方)</td>
	 </tr>
	 <tr class="tr-client-info tr-even">
	    <td class="td-content-title">承租人：</td><td class="td-content"><input require="true" label="承租人" name="contract_signatory.client" class="td-content-input"  type="text" value="${requestScope['contract_signatory.client']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">委托代理人：</td><td class="td-content"><input require="true" label="委托代理人" name="contract_signatory.clientconsigner" class="td-content-input" type="text" value="${requestScope['contract_signatory.clientconsigner']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-client-info tr-odd">
	    <td class="td-content-title">通讯地址：</td><td class="td-content"><input require="true" label="通讯地址" name="contract_signatory.clientaddress" class="td-content-input"  type="text" value="${requestScope['contract_signatory.clientaddress']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">邮编：</td><td class="td-content"><input require="true" label="邮编" name="contract_signatory.clientpostcode" class="td-content-input" type="text" value="${requestScope['contract_signatory.clientpostcode']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-client-info tr-even">
	    <td class="td-content-title">法定代表人：</td><td class="td-content"><input require="true" label="法定代表人" name="contract_signatory.clientperson" class="td-content-input"  type="text" value="${requestScope['contract_signatory.clientperson']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">联系人：</td><td class="td-content"><input require="true" label="联系人" name="contract_signatory.clientlinkman" class="td-content-input" type="text" value="${requestScope['contract_signatory.clientlinkman']}"><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-client-info tr-odd">
	    <td class="td-content-title">电话：</td><td class="td-content"><input require="true" label="电话" name="contract_signatory.clienttel" class="td-content-input"  type="text" value="${requestScope['contract_signatory.clienttel']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">传真：</td><td class="td-content"><input  label="传真" name="contract_signatory.clientfax" class="td-content-input" type="text" value="${requestScope['contract_signatory.clientfax']}"></td>
	</tr>
	<tr class="tr-client-info tr-even">
	    <td class="td-content-title">短信联系手机号：</td><td class="td-content"><input require="true" label="短信联系手机号" name="contract_signatory.clientmobilenumber" class="td-content-input"  type="text" value="${requestScope['contract_signatory.clientmobilenumber']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">电子邮件：</td><td class="td-content"><input  label="电子邮件" name="contract_signatory.clientemail" class="td-content-input" type="text" value="${requestScope['contract_signatory.clientemail']}"></td>
	</tr>
	<tr class="tr-client-info tr-odd">
	    <td class="td-content-title">开户账号：</td><td class="td-content"><input  label="开户账号"  id ="clientaccnumber" maxlength="19" name="contract_signatory.clientaccnumber" class="td-content-input" dataType="Number" type="text" value="${requestScope['contract_signatory.clientaccnumber']}"><font class="required-content">*</font></td>
	    <td class="td-content-title">开户银行：</td><td class="td-content">
	    
	    <div id="id_bankname" ></div></td>
	</tr>
	<tr class="tr-client-info tr-even">
	    <td class="td-content-title">开户户名：</td><td class="td-content"><input  label="开户户名" name="contract_signatory.clientaccname" class="td-content-input"  type="text" value="${requestScope['contract_signatory.clientaccname']}"></td>
	    <td class="td-content-title">是否卡扣：</td><td class="td-content"><div style="float: left" class="leftComboContainer" id="iscardname"></div></td>
	</tr>
	<tr>
	    <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-supplier-info"></div>卖方/供应商</td>
	</tr>
	<tr class="tr-supplier-info tr-even">
	    <td colspan=4><div id="id_table_leasing_contract_supplier_container" style="overflow: hidden;"></div></td>
	</tr>
</table>
<script>
jQuery(function(){
	dictYesOrNoByCode('iscardname','contract_signatory.iscard','${empty requestScope["contract_signatory.iscard"] ? "1" : requestScope["contract_signatory.iscard"] }',null,null,'require="true" label="是否卡扣"');//是否卡扣
	dictOnSelect('id_bankname','contract_signatory.clientaccbank','card_hire_bank','${requestScope["contract_signatory.clientaccbank"]}',null,'label="开户银行"',true,null, true);
	
		if(!isSubTable){
		    var currentIsNeedTools = true;
		    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
		    	currentIsNeedTools = false;
		    }
		    new tracywindyMultiTable({
		    renderTo:'id_table_leasing_contract_supplier_container',
		    width:formWidth,
		    height:350,
		    tools:'新增|修改|删除',
		    isNeedTools:currentIsNeedTools,
		    isFit:true,
		    displayToggleContainer:document.getElementById('id_table_leasing_contract_signatory_container').parentNode.parentNode,
		    datas:JsonUtil.decode('${empty json_contract_supplier_str ? "[]" : json_contract_supplier_str }'),
		    columns:[
		       {name:'id',  header:'id',hidden:true},
		       {name:'seller',  header:'供应商'},
		       {name:'sellerlegalperson',  header:'法定代表人'},
		       {name:'sellerlinkman',  header:'联系人'},
		       {name:'sellerregisteraddr',  header:'注册地址'},
		       {name:'selleraddr',  header:'通讯地址'},
		       {name:'sellerpostcode',  header:'邮政编码'},
		       {name:'sellertel',  header:'电话'},
		       {name:'sellerfax',  header:'传真'},
		       {name:'selleraccnumber',  header:'开户账号'},
		       {name:'selleraccbank',  header:'开户银行'},
		       {name:'selleraccname',  header:'开户户名'}
		     ]
		 	});
		}
});

</script>