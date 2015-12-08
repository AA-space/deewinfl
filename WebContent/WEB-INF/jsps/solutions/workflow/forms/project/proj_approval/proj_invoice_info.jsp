<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<!--合同租金发票信息 -->
<table class="fillTable" cellspacing="0" cellpadding="0" width="50%" id="proj_invoice_info">
	<tr class="tr-even">
			<td class="td-content-title">是否开票：</td>
			<td class="td-content">
				<div class="leftComboContainer" id="id_kfp"></div><font class="required-content">*</font>
			</td>
			<td class="td-content-title" id="fp_title">发票种类：</td>
			<td class="td-content" id="fp_content">
			<div class="leftComboContainer" id="id_fptype"></div>
			</td>
		</tr>
	<tr class="tr-odd">
	<td class="td-content-title">开户行：</td>
		<td class="td-content">
			<input name="proj_invoice_info.invoiceopenbank"  class="td-content-input" type="text"value="${requestScope['proj_invoice_info.invoiceopenbank'] }"   label="开户行"/> <font class="required-content">*</font>
		</td>
		<td class="td-content-title">开户账户：</td>
		<td class="td-content">
			<input name="proj_invoice_info.invoicenumber" class="td-content-input" type="text" value="${requestScope['proj_invoice_info.invoicenumber'] }"  label="开户账户"/> <font class="required-content">*</font>
		</td>
	</tr>
	<tr class="tr-even">
		<td class="td-content-title">地址：</td>
		<td class="td-content">
			<input name="proj_invoice_info.invoiceaddress"  class="td-content-input" type="text"value="${requestScope['proj_invoice_info.invoiceaddress'] }"   label="地址"/> <font class="required-content">*</font>
		</td>
		<td class="td-content-title">电话：</td>
		<td class="td-content">
			<input name="proj_invoice_info.invoicetel" class="td-content-input" type="text" value="${requestScope['proj_invoice_info.invoicetel'] }"   label="电话" /> <font class="required-content">*</font>
		</td>
	</tr>
	<tr class="tr-odd">
		<td class="td-content-title">税号：</td>
		<td class="td-content">
			<input name="proj_invoice_info.taxnumber" class="td-content-input" type="text" value="${requestScope['proj_invoice_info.taxnumber'] }"   label="税号"/> <font id="taxnumber" class="required-content">*</font>
		</td>
		<td class="td-content-title">纳税人类别：</td>
		<td class="td-content">
		<div class="leftComboContainer" id="id_ns"></div>
            </td>
	</tr>
		<tr class="tr-odd">
			<td class="td-content-title">开票说明：</td>
			<td style="padding-top: 4px;padding-bottom: 4px;" colspan="3">
				<input style="width:74%;height: 150px;" id="proj_invoice_info.invoicememo" name="proj_invoice_info.invoicememo" label="开票说明" value="${requestScope['proj_invoice_info.invoicememo'] }"  label="开票说明" class="mini-textarea" type="text" emptyText="请输入开票说明。。。" /> 
			</td>
		</tr>
		<tr class="tr-even">
			<td class="td-content-title">开票备注：</td>
			<td colspan=3 style="padding-top: 4px;padding-bottom: 4px;">
		<input style="width:74%;height:150px" id="proj_invoice_info.invoiceremarks"  name="proj_invoice_info.invoiceremarks" label="开票备注"  value="${requestScope['proj_invoice_info.invoiceremarks'] }"  label="开票备注" class="mini-textarea" maxLength="500" type="text" emptyText="请输入开票备注。。。"> 
			</td>
		</tr>
</table>
<script >
jQuery(function() {
	
	/*start 数据字典初始化*/
	dict('id_ns','proj_invoice_info.taxregtype','tax_level_name',
			'${requestScope["proj_invoice_info.taxregtype"]}',
			'${requestScope["rawValue_proj_invoice_info.taxregtype"]}','label="纳税人类别"');
			
	dict('id_fptype','proj_invoice_info.invoicetype','invoicetype',
		'${requestScope["proj_invoice_info.invoicetype"]}',
		'${requestScope["rawValue_proj_invoice_info.invoicetype"]}','label="发票种类"');		

	dictYesOrNoByCode('id_kfp','proj_invoice_info.iskfp',
			'${requestScope["proj_invoice_info.iskfp"]}',
			function(){
				if($("#selectOfValue_id_combo_id_kfp").val() == "1"){//否
					$("#proj_invoice_info input[type='text']").each(function(){
						$(this).attr("require",false);
					  });
					  $("#selectOfValue_id_combo_invoicetype").attr("require",false);
					  $("#selectOf_id_combo_tax_level_name").attr("require",false);
					  $("#proj_invoice_info font").each(function(){
						$(this).hide();
					  });
					 var  comb = getTracywindyObject('id_combo_invoicetype');
					      comb.readOnlyData= false;
						  comb.setValue("");
						  comb.getRawValue("");
						  $("#selectOfValue_id_combo_invoicetype").val("");
						  $("#selectOfRawValue_id_combo_invoicetype").val("");
						  comb.loadSelect();
				}else{//是
					$("#proj_invoice_info input[type='text']").each(function(){
						$(this).attr("require",true);
					  });
					   $("#selectOfValue_id_combo_invoicetype").attr("require",true);
					   $("#selectOf_id_combo_tax_level_name").attr("require",true);
					  $("#proj_invoice_info font").each(function(){
						$(this).show();
					  });  
					  /*start 非开票的情况隐藏开票种类*/
					  var custtype ="${requestScope['proj_info.cust_type'] }";
					  if(custtype == "自然人"){
						   var  comb = getTracywindyObject('id_combo_invoicetype');
						  comb.readOnlyData= true;
						  
						  $("input[name='proj_invoice_info.taxnumber']").attr("require",false);
						  $("input[name='proj_invoice_info.invoiceopenbank']").attr("require",false);
						  $("input[name='proj_invoice_info.invoicenumber']").attr("require",false);
						  $("input[name='proj_invoice_info.invoiceaddress']").attr("require",false);
						  $("input[name='proj_invoice_info.invoicetel']").attr("require",false);
						  $("input[name='proj_invoice_info.invoiceaddress']").attr("require",false);
						  $("#taxnumber").hide();
						  $("#proj_invoice_info font").each(function(){
								$(this).hide();
						  });
						  $("#selectOf_id_combo_tax_level_name").attr("require",false);
						  comb.setValue("invoicetype2");
						  comb.getRawValue("增值税普通发票");
						  $("#selectOfValue_id_combo_invoicetype").val("invoicetype2");
						  $("#selectOfRawValue_id_combo_invoicetype").val("增值税普通发票");
						  comb.loadSelect();
					  } 
					  /*end 非开票的情况隐藏开票种类*/
				}
				 $("#selectOfValue_id_combo_invoicetype").attr("label","发票种类");
				 $("#selectOf_id_combo_tax_level_name").attr("label","纳税人类别");
			},
			null,'label="是否开票"');
	 
	/*end 数据字典初始化*/
	 
	 $("#selectOfValue_id_combo_invoicetype").attr("label","发票种类");
	 $("#selectOf_id_combo_tax_level_name").attr("label","纳税人类别");
	 $("#selectOfValue_id_combo_invoicetype").attr("require",true);
	 $("#selectOf_id_combo_tax_level_name").attr("require",true);
	 
	 /*设置默认*/
	  $("#proj_invoice_info input[type='text']").each(function(){
	       $(this).attr("require",true);
	  });
	  $("#proj_invoice_info font").each(function(){
	    $(this).show();
	  });
	
})


</script>