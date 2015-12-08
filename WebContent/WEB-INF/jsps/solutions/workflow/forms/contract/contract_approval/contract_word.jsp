<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script language="javascript">
jQuery(function(){
    if(isSubTable){
    	dictOnSelect('id_word_industry','contract_word.industry','cust_kind','',chargeTemplate,null,false);
    	dictOnSelect('id_word_leas_form','contract_word.leasform','leas_form','',chargeTemplate,null,false);
    	dictOnSelect('id_word_leas_type','contract_word.leastype','contract_lease_type','',chargeTemplate,null,false);
    }
 });
function chargeTemplate(){
	return false;
	var industry=getTracywindyObject("id_combo_id_word_industry").getValue();
	var leasform=getTracywindyObject("id_combo_id_word_leas_form").getValue();
	var leastype=getTracywindyObject("id_combo_id_word_leas_type").getValue();
	
	if(industry!=""&&leasform!=""&&leastype!=""){
		var param={};
		param.industry=industry;
		param.leasform=leasform;
		param.leastype=leastype;
		window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,"正在加载合同模板 请稍等..."); 
		currentDeleteFileLoadMask.show();
		ajaxRequest({
		     url:'${pageContext.request.contextPath}/leasing/word/changeTemplate.action',
		     method:'POST',
		     success:ajaxChargeTemplateCallBack,
		     async:false,
		     failure:function(res){
		    	 currentDeleteFileLoadMask.hide(); 
			     alert("抓合同模板失败!");},
		     params:param
		});
	}else{
		document.getElementById("contract_word_check_list").innerHTML="内部行业,租赁形式和租赁合同类型为必须筛选项!";
	}
}
function ajaxChargeTemplateCallBack(rs){
	var svote=rs.responseText;
    svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
    currentDeleteFileLoadMask.hide(); 
    document.getElementById("contract_word_check_list").innerHTML=svote;
}
function createWord(){
	 var chk_value =[];    
    $('input[name="contract_word_list_check_box"]:checked').each(function(){    
	   chk_value.push($(this).val());    
    });
    if(chk_value.length<=0){
    	jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>请勾选合同！</div>",'error')
        return false;
    }else{
       var params={};   
       params["id"]=chk_value+"";
       params["projid"]=$("#projid").val();
       params["currentProcessInstanceDBID"]="${currentProcessInstanceDBID}";
       if(!window.currentDeleteFileLoadMask)
	   {window.currentDeleteFileLoadMask = new tracywindyLoadMask(document.body,"正在生成合同 请稍等..."); } 
       window.currentDeleteFileLoadMask.show();
       var url="/leasing/word/createWord.action";
       ajaxRequest({
   		  url:getRootPath()+url,
   		  success:function(rs){
    	   window.currentDeleteFileLoadMask.hide();  
    	    var contractlist= rs.responseText;
    	   contractlist=contractlist.replace(/(^\s+)|(\s+$)/g, ""); 
    	   if(contractlist==""){
    		   jQuery.messager.alert('提示',"<div style='font-size:15px;line-height:30px;width:200px;'>生成合同失败！</div>",'error')
        	   }
    	   else{
    		   jQuery.messager.alert('提示',"<div style='font-size:15px;line-height:30px;width:200px;'>生成合同成功！</div>",'success')
    	       var vlist=eval("("+contractlist+")");
    	       var list=getTracywindyObject('table_id_table_leasing_contract_list_container');
    	       list.AddRows(vlist);
        	   }
   		   // window.location.reload();
   		 },
   		  failure:function(res){
   			window.currentDeleteFileLoadMask.hide();
      		 },
   		  params:params 
   	   }); 
    }
   
}
</script>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contractect-word-info tr-even">
		<td class="td-content-title">内部行业：</td>
		<td class="td-content"><div class="leftComboContainer" id="id_word_industry"></div></td>
		<td class="td-content-title">租赁形式：</td>
		<td class="td-content"><div class="leftComboContainer" id="id_word_leas_form"></div></td>
		<td class="td-content-title">租赁合同类型：</td>
		<td class="td-content"><div class="leftComboContainer" id="id_word_leas_type"></div></td>
	</tr>
	<tr class="tr-contractect-word-info tr-odd">
		<td class="td-content-title">合同模板：</td>
		<td class="td-content" colspan=5><div class="leftComboContainer" id="contract_word_check_list">请先选择!</div></td>
	</tr>
	<tr class="tr-contractect-word-info tr-even">
		<td class="td-content" colspan=6 align="right">
		<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="生成合同" onclick="createWord()"/>
		</td>
	</tr>
	<tr class="tr-contractect-word-info tr-odd">
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-word-list"></div>合同清单</td>
    </tr>
	<tr class="tr-contractect-word-list">
		<td class="td-content" colspan=6>
			<div id="id_table_leasing_contract_list_container"	style="overflow: hidden;">
				<jsp:include page="contract_list_info.jsp"></jsp:include><%--合同清单 --%>
			</div>
		</td>
	</tr>
</table>
</div>