
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
.tr_td_dashed{
	   	 border:#DDD 1px dotted;
	   }
	   input[type="text"]{
	   	 border:silver 1px solid;
	   }
	   input[type="checkbox"]{
	   	 vertical-align:middle;
	   	 display:inline-block;
	   }
</style>
    <table style="width:100% ;" border="1" cellpadding="0" bordercolorlight="#999999"
						bordercolordark="#FFFFFF" cellspacing="0" line-height="0px"; class="fillTable">
					    <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td  align="center" colspan="4" class="tr_td_dashed"><b>必投保险种</b></td>
					    </tr>
					    <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td  align="center" style="width:25%" class="tr_td_dashed"><b>险种</b></td>
					    	<td  align="center" style="width:50%" class="tr_td_dashed" colspan="2"><b>保险金额或责任限额（元）</b></td>
					    	<td  align="center" style="width:25%" class="tr_td_dashed"><b>保险费（元）</b></td>
					    </tr>
					       <tr class="tr-project-info tr-even tr_td_dashed" >
							<td class="tr_td_dashed" rowspan="2">机动车损失保险及不计免赔特约：</td>  
							<td class="tr_td_dashed" style="width: 25%">是否不计免赔特约</td>
					        <td class="tr_td_dashed">
					        	<input name="insurance_price.isinsurance1" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" ${("是"==requestScope['insurance_price.isinsurance1']) ? "checked" : "" } >是
					           			  <input name="insurance_price.isinsurance1" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" ${("否"==requestScope['insurance_price.isinsurance1']) ? "checked" : "" }>否  
					        </td>
					        <td align="center" class="tr_td_dashed">
					        	<input  name="insurance_price.insurance1Money2"  label="是否不计免赔特约(保险费)"  type="text" class="calculate" datatype="PMoney" value="${requestScope['insurance_price.insurance1Money2'] }">
					        </td>
					     </tr> 
					        <tr class="tr-project-info tr-even tr_td_dashed" >
					     	<td class="tr_td_dashed">保险金额按车辆购置发票金额</td>
					     	<td class="tr_td_dashed">&nbsp;&nbsp;&nbsp;&nbsp;<input  name="insurance_price.insurance1" class="nocalculate"  label="机动车损失保险及不计免赔特约"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance1'] }" >万&nbsp;元</td>
					     	<td align="center" class="tr_td_dashed">
					        	<input  name="insurance_price.insuranceMoney1"   label="机动车损失保险及不计免赔特约(保险费)"  type="text" class="calculate" datatype="PMoney" value="${requestScope['insurance_price.insuranceMoney1'] }" >
					        </td>
					     </tr>  
						  <tr class="tr-project-info tr-odd tr_td_dashed" >
					        <td class="tr_td_dashed" rowspan="2">第三者责任保险及不计免赔特约：</td>  
							<td class="tr_td_dashed">是否不计免赔特约</td>
							<td class="tr_td_dashed"><input name="insurance_price.isinsurance2" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" ${("是"==requestScope['insurance_price.isinsurance2']) ? "checked" : "" } >是
					           			     <input name="insurance_price.isinsurance2" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" ${("否"==requestScope['insurance_price.isinsurance2']) ? "checked" : "" } >否
					        </td>
							
							<td align="center" class="tr_td_dashed">
					        	<input  name="insurance_price.insurance2money2" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insurance2Money2'] }" >
					        </td>
						 </tr>
						 <tr class="tr-project-info tr-odd tr_td_dashed">
						 <td class="tr_td_dashed"></td>
						 <td class="tr_td_dashed">&nbsp;&nbsp;<div id="id_insurance2"></div></td>
						 <td align="center" class="tr_td_dashed">
					        	<input  name="insurance_price.insuranceMoney2" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney2'] }" >
					     </td>
						 </tr>
					     
					     <tr class="tr-project-info tr-even tr_td_dashed">
					        <td class="tr_td_dashed" rowspan="2">全车盗抢损失险及不计免赔特约：</td>
					        <td class="tr_td_dashed">是否不计免赔特约</td>
					        <td class="tr_td_dashed"><input name="insurance_price.isinsurance3" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" ${("是"==requestScope['insurance_price.isinsurance3']) ? "checked" : "" }>是
					           			  <input name="insurance_price.isinsurance3" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" ${("否"==requestScope['insurance_price.isinsurance3']) ? "checked" : "" }>否</td>
					        </td class="tr_td_dashed">
					        <td align="center" class="tr_td_dashed">
					        	<input  name="insurance_price.insurance3Money2" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"   value="${requestScope['insurance_price.insurance3Money2'] }">
					     </td>
					     </tr> 
					     <tr  class="tr-project-info tr-even tr_td_dashed">
					     <td class="tr_td_dashed">首次投保保险金额按车辆购置发票金额</td>
					     <td class="tr_td_dashed">&nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance_price.insurance3" label="全车盗抢损失险及不计免赔特约" class="nocalculate"   type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance3']}" >万&nbsp;元</td>
					     <td align="center" class="tr_td_dashed">
					        	<input  name="insurance_price.insuranceMoney3" label="全车盗抢损失险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney3'] }" >
					     </td>
					     </tr>
					     
					     
					      
					      <tr class="tr-project-info tr-odd tr_td_dashed">      
					        <td class="tr_td_dashed" rowspan="3">车上人员责任险及不计免赔特约：</td>
					        <td class="tr_td_dashed" >是否不计免赔特约</td>
					        <td class="tr_td_dashed" ><input name="insurance_price.isinsurance5" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" ${("是"==requestScope['insurance_price.isinsurance5']) ? "checked" : "" }>是
					           			  <input name="insurance_price.isinsurance5" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" ${("否"==requestScope['insurance_price.isinsurance5']) ? "checked" : "" }>否</td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.insurance5Money2" label="驾驶员(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insurance5Money2'] }" >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     <td class="tr_td_dashed">驾&nbsp;驶&nbsp;员<input name="insurance_price.insurance41"  class="nocalculate"   label="驾驶员"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance4']}" >人</td>
					      <td class="tr_td_dashed" >保额<input name="insurance_price.insurance4"  class="nocalculate"   label="保额"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance4']}" >元/人</td>
					       <td class="tr_td_dashed" rowspan="2"  align="center">
					        	<input  name="insurance_price.insuranceMoney4" label="驾驶员(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney4'] }" >
					        </td> 	
					      </tr>  
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed">
					        	核定乘客<input name="insurance_price.insurance42" label="核定乘客" class="nocalculate"   type="text" datatype="Number" value="${requestScope['insurance_price.insurance42']}" >人</td>
					        <td class="tr_td_dashed">
					        	保额<input name="insurance_price.insurance43" label="核定乘客"  class="nocalculate"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance43']}" >元/人
					        </td>
					     </tr>
					      <tr class="tr-project-info tr-even  tr_td_dashed">
					     	<td class="tr_td_dashed" rowspan="2" >自燃险及不计免赔特约</td>
					     	<td class="tr_td_dashed">是否不计免赔特约</td>
					     	<td class="tr_td_dashed">
					     	<input name="insurance_price.isinsurance7" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" ${("是"==requestScope['insurance_price.isinsurance7']) ? "checked" : "" }>是
					           			  <input name="insurance_price.isinsurance7" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" ${("否"==requestScope['insurance_price.isinsurance7']) ? "checked" : "" }>否<br>
					      	 
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.insurance7Money2" label="自燃险(保险费)"  type="text" datatype="PMoney" class="calculate" value="${requestScope['insurance_price.insurance7Money2'] }" >
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >自燃险：</td>
					     	<td class="tr_td_dashed"   >
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance_price.insurance7" label="自燃险" class="nocalculate"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance7']}" >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.insuranceMoney7" label="自燃险(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney7'] }" >
					        </td>
					     </tr>
					     
					     
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed" >交强险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"   >
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance_price.insurance8" label="交强险" class="nocalculate"   type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance8']}" >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.insuranceMoney8" label="交强险(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney8'] }" >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >车船税：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"   >
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance_price.insurance6" label="车船税" class="nocalculate"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance6']}" >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.insuranceMoney6" label="车船税(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney6'] }" >
					        </td>
					     </tr>    
					        <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td class="tr_td_dashed"  align="center" colspan="3"><b>选投保险种</b></td>
					    </tr>
					    <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >玻璃单独破碎险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"   >
					      	&nbsp;&nbsp;&nbsp;&nbsp; <input name="insurance_price.insurance9" label="玻璃单独破碎险" class="nocalculate"  type="text" datatype="PMoney" value="${requestScope['insurance_price.insurance9']}" >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.insuranceMoney9" label="玻璃单独破碎险(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney9'] }" >
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed" rowspan="2">车上货物责任险及不计免赔特约：</td>
					     	<td class="tr_td_dashed" >是否不计免赔特约：</td>
					     	<td class="tr_td_dashed" ><input name="insurance_price.isinsurance11" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" ${("是"==requestScope['insurance_price.isinsurance11']) ? "checked" : "" }>是
					           			  <input name="insurance_price.isinsurance11" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" ${("否"==requestScope['insurance_price.isinsurance11']) ? "checked" : "" }>否</td>
					        <td class="tr_td_dashed" align="center">
					        	<input  name="insurance_price.insurance11Money2" label="车上货物责任险(保险费)"  type="text" datatype="PMoney" class="calculate" value="${requestScope['insurance_price.insurance11Money2'] }">
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     <td class="tr_td_dashed" >
					     车上货物责任险
					     </td>
					     <td class="tr_td_dashed" >
					     <span>
					      	 <input name="insuranceMoney10" id="money50000" label="车上货物责任险"  type="checkbox"  value="50000"  ${("5000"==insuranceMoney10) ? "checked" : "" }>50000
					      	 <input name="insuranceMoney10" id="money100000" label="车上货物责任险"  type="checkbox" value="100000" ${("5000"==insuranceMoney10) ? "checked" : "" }>100000
					      	 <input name="insuranceMoney10" id="money200000" label="车上货物责任险"  type="checkbox" value="200000" ${("200000"==insuranceMoney10) ? "checked" : "" }>200000
					      	 <input name="insuranceMoney10" id="money300000" label="车上货物责任险"  type="checkbox" value="300000" ${("300000"==insuranceMoney10) ? "checked" : "" }>300000
					      	 <input name="insuranceMoney10" id="money500000" label="车上货物责任险"  type="checkbox" value="500000" ${("500000"==insuranceMoney10) ? "checked" : "" }>500000
					      	 <input name="insuranceMoney10" id="moneyx" label="车上货物责任险"  type="checkbox" value="0" ${("0"==insuranceMoney10) ? "checked" : "" }>自选投保金额
					      	 <input name="insurance_price.insurance10" id="insurance10" label="车上货物责任险"  type="text" datatype="PMoney" style='display: ${("0"==insuranceMoney10) ? "" : "none"}' value="${requestScope['insurance_price.insurance10'] }" >
					     	</span>
					     	</td>
					     	<td class="tr_td_dashed"  align="center">
					        	<input  name="insurance_price.insuranceMoney10" label="车上货物责任险(保险费)"  type="text" datatype="PMoney" class="calculate"  value="${requestScope['insurance_price.insuranceMoney10'] }" >
					        </td>
					     </tr>
					     
					     
					     
					     
					         
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed" align="center"><b>合计</b></td>
					     	<td class="tr_td_dashed" colspan="2" ></td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance_price.feetotal" id="feetotal" label="合计(保险费)" readonly="readonly" type="text" value="${requestScope['insurance_price.feetotal'] }" >
					        </td>
					     </tr>  
	</table>
	 <script language="javascript">
	 jQuery(function(){ 
	 dict('id_insurance2','insurance_price.insurance2','ThirdInsurTpye','${requestScope["insurance_price.insurance2"]}',null,' label="第三者责任保险及不计免赔特约"');
	 });
	 $(':input[name="insuranceMoney10"]').click(function(){
	        $(':input[name="insuranceMoney10"]').prop('checked',false);
	        $(this).prop('checked',true);
	        if($(this).attr("checked")){
					$("#insurance10").val($(this).val());
		        }
	      //自选投保金额被选中时   
	   	if($("#moneyx").attr("checked")){
			$("#insurance10").show();
		}else{
			$("#insurance10").hide();
		}
	   });	  
	 function getSumFunc(){
			var sum = 0.0;
			jQuery('input[class="calculate"]').each(function(i){
	            var $this = jQuery(this);
	            var value = this.value;
	            var tempValue = parseFloat(value);
	            if(tempValue && !isNaN(tempValue)){
	            	sum+=tempValue;
	            }
		    });
		    //return sum;
		    $("#feetotal").val(sum);
     }  
	$(':input[class="calculate"]').each(function(i){
		this.oninput = function(){
			//alert(getSumFunc());
			getSumFunc();
		};
		this.onpropertychange=function(event){
			var ev = getEvent(event);
			if (ev.propertyName.toLowerCase () == "value")
			{
				//alert(getSumFunc());
				getSumFunc();
			}
		};

	});	   
	

					
	</script>