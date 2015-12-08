<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <script language="javascript">
     function AdjustLevel(){//资产级别
    		var id_assetslevel=$("#id_assetslevel"); 
    		var id_assetsassess=$("#id_assetsassess").val();
    		var id_leasingmoney=$("#id_leasingmoney").val();
    		id_assetsassess=id_assetsassess||0;
    		id_leasingmoney=id_leasingmoney||1;
    		var temp=parseFloat(id_assetsassess)/parseFloat(id_leasingmoney);
    		$("#id_assetslevel").val(temp.toFixed(2));
    	}
     function AdjustCash(){//现金流级别
 		var id_cashlevel=$("#id_cashlevel");
 		var id_monthcash=$("#id_monthcash").val();
 		var id_monthrent=$("#id_monthrent").val();
 		id_monthcash=id_monthcash||0;
 		id_monthrent=id_monthrent||1;
 		temp=parseFloat(id_monthcash)/parseFloat(id_monthrent);
 		$("#id_cashlevel").val(temp.toFixed(2));
 	}
     function AdjustLevel1(count){//资产级别
 		var id_assetsassess=$("#id_assetsassess"+count).val();
 		var id_leasingmoney=$("#id_leasingmoney"+count).val();
 		id_assetsassess=id_assetsassess||0;
 		id_leasingmoney=id_leasingmoney||1;
 		var temp=parseFloat(id_assetsassess)/parseFloat(id_leasingmoney);
 		$("#id_assetslevel"+count).val(temp.toFixed(2));
 	}

     function AdjustCash1(count){//现金流级别
  		var id_monthcash=$("#id_monthcash"+count).val();
  		var id_monthrent=$("#id_monthrent"+count).val();
  		id_monthcash=id_monthcash||0;
  		id_monthrent=id_monthrent||1;
  		var temp=parseFloat(id_monthcash)/parseFloat(id_monthrent);
  		$("#id_cashlevel"+count).val(temp.toFixed(2));
  	}
     function AdjustCashAssurorname(){
    		
    	var monthcash = 0;
    	 for ( var int = 1; int <= tem_count_assurorname; int++) {
    		 monthcash +=  parseFloat($('#id_monthcash' + int).val()||0);
		}
    	 
    		var id_monthcash=$("#guarantor_total_monthcash").val(monthcash);
     		var id_monthrent=$("#id_monthrent").val();
     		id_monthcash=monthcash||0;
     		id_monthrent=id_monthrent||1;
     		temp=parseFloat(id_monthcash)/parseFloat(id_monthrent);
     		$("#guarantor_total_cashlevel").val(temp.toFixed(2));
     }
     function AdjustLevelAssurorname(){
    	 
    	var assetsassess = 0;
    	 for ( var int = 1; int <= tem_count_assurorname; int++) {
    		 assetsassess +=  parseFloat($('#id_assetsassess' + int).val()||0);
		}
   		var id_assetsassess=$("#guarantor_total_assetsassess").val(assetsassess);
   		var id_leasingmoney=$("#id_leasingmoney").val();
   		id_assetsassess=assetsassess||0;
   		id_leasingmoney=id_leasingmoney||1;
   		var temp=parseFloat(id_assetsassess)/parseFloat(id_leasingmoney);
   		$("#guarantor_total_assetslevel").val(temp.toFixed(2));
     }
     
     var tem_count_assurorname = 0;
     //赋值
      jQuery(function(){
    	 var total = "${requestScope['assurornameinfo']}";
    	 if(total){
    		 tem_count_assurorname = total.split(',').length;
    	 }
     }); 
     
     </script> 
<table cellspacing="0" cellpadding="0" id="proj_credit_result_info" >
        <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-result-info"></div>承租人-${requestScope['proj_info.custname'] }-评审结果</td>
          </tr>
          <tr class="tr-proj-credit-result-info tr-even">
             <td class="td-content-title">资产评估值</td><td class="td-content"><input id="id_assetsassess" name="proj_other_info.assetsassess"  class="td-content-input" type="text" value="${requestScope['proj_other_info.assetsassess']}" dataType="PMoney"  require="true" label="资产评估值" onkeyup="AdjustLevel()"></input> <font class="required-content">*</font></td>
             <td class="td-content-title">融资额：</td><td class="td-content"><input id="id_leasingmoney" name="proj_other_info.leasingmoney" class="td-content-input"  type="text"  value="${empty requestScope['proj_other_info.leasingmoney'] ? 0 : requestScope['proj_other_info.leasingmoney']}"  dataType="PMoney"  require="true" label="融资额" onkeyup="AdjustLevel()"/><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-proj-credit-result-info tr-odd">
             <td class="td-content-title">资产级别：</td><td class="td-content" colspan=5><input id="id_assetslevel"  name="proj_other_info.assetslevel"  class="td-content-input td-content-readonly"  readOnly   type="text" value="${requestScope['proj_other_info.assetslevel']}" dataType="PMoney" readOnly require="true" label="资产级别"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-proj-credit-result-info tr-even">   
             <td class="td-content-title">平均月现金流：</td><td class="td-content"><input id="id_monthcash"  name="proj_other_info.monthcash" class="td-content-input"   type="text" value="${requestScope['proj_other_info.monthcash'] }"  dataType="PMoney"  require="true" label="平均月现金流" onkeyup="AdjustCash()"> <font class="required-content">*</font></td>
             <td class="td-content-title">月租金：</td><td class="td-content"><input id="id_monthrent" name="proj_other_info.monthrent" class="td-content-input"  type="text"  value="${requestScope['proj_other_info.monthrent'] }" dataType="PMoney"  require="true" label="月租金" onkeyup="AdjustCash()"><font class="required-content">*</font></td>
         </tr>
         <tr class="tr-proj-credit-result-info tr-odd">
             <td class="td-content-title">现金流级别：</td><td class="td-content" colspan=5><input id="id_cashlevel"  name="proj_other_info.cashlevel"  class="td-content-input td-content-readonly"   readOnly  type="text" value="${requestScope['proj_other_info.cashlevel']}" dataType="PMoney" readOnly  require="true" label="现金流级别"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-proj-credit-result-info tr-even">
             <td class="td-content-title">项目级别：</td><td class="td-content" colspan=5><input  name="proj_other_info.projectlevel"  class="td-content-input" type="text" value="${requestScope['proj_other_info.projectlevel']}"  require="true" label="项目级别"><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-proj-credit-result-info tr-odd">
             <td class="td-content-title">备注：</td>
		    <td class="td-content" colspan="3"><textarea rows="5"   require="true" label="备注"
			style="width:98.2%;float:left;" name="proj_other_info.approvememo">${requestScope['proj_other_info.approvememo'] }</textarea>
		     </td>
	       </tr>
   </table>
   
   <c:forEach items="${requestScope['assurornameinfo']}" var="item" varStatus="j">
            <table cellspacing="0" cellpadding="0" id="proj_credit_result_info${j.count}">
            <tr>
              <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-result-info${j.count}"></div>担保人-${item}-评审结果</td>
            </tr>
            <tr class="tr-proj-credit-result-info${j.count} tr-even">
             <c:set var="assetsassessVar" value="proj_other_info.assetsassess${j.count}"></c:set>
             <c:set var="leasingmoneyVar" value="proj_other_info.leasingmoney${j.count}"></c:set>
             <td class="td-content-title">资产评估值</td><td class="td-content"><input id="id_assetsassess${j.count}" name="proj_other_info.assetsassess${j.count}"  class="td-content-input" type="text" value="${requestScope[assetsassessVar]}" dataType="PMoney"  require="true" label="资产评估值" onkeyup="AdjustLevelAssurorname()" ></input> <font class="required-content">*</font></td>
            </tr>
             <tr class="tr-proj-credit-result-info${j.count} tr-even">  
             <c:set var="monthcashVar" value="proj_other_info.monthcash${j.count}"></c:set>
             <c:set var="monthrentVar" value="proj_other_info.monthrent${j.count}"></c:set>
             <td class="td-content-title">平均月现金流：</td><td class="td-content"><input id="id_monthcash${j.count}"  name="proj_other_info.monthcash${j.count}" class="td-content-input"   type="text" value="${requestScope[monthcashVar]}"  dataType="PMoney"  require="true" label="平均月现金流" onkeyup="AdjustCashAssurorname()" > <font class="required-content">*</font></td>
            </tr>
         
            </table>
            
            <c:if test="${j.last == true}">
			     <table cellspacing="0" cellpadding="0" id="proj_credit_result_info_guarantor_total">
			        <tr>
			             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-result-info"></div>合计担保人-评审结果</td>
			          </tr>
			          <tr class="tr-proj-credit-result-info tr-even">
			             <td class="td-content-title">担保人合计资产评估值</td>
			             <td class="td-content"><input id="guarantor_total_assetsassess" name="guarantor_total.assetsassess"  class="td-content-input" type="text" value="${requestScope['guarantor_total.assetsassess']}" dataType="PMoney"  label="资产评估值" ></input> </td>
			             <td class="td-content-title">担保人合计资产级别：</td>
			             <td class="td-content"><input id="guarantor_total_assetslevel" name="guarantor_total.assetslevel" class="td-content-input td-content-readonly"  readOnly   type="text" value="${requestScope['guarantor_total.assetslevel']}" dataType="PMoney" readOnly  label="资产级别"></td>
			         </tr>
			          <tr class="tr-proj-credit-result-info tr-even">   
			             <td class="td-content-title">担保人合计平均月现金流：</td>
			             <td class="td-content"><input id="guarantor_total_monthcash"  name="guarantor_total.monthcash" class="td-content-input"   type="text" value="${requestScope['guarantor_total.monthcash'] }"  dataType="PMoney"   label="平均月现金流" > </td>
			             <td class="td-content-title">担保人合计现金流级别：</td>
			             <td class="td-content"><input id="guarantor_total_cashlevel" name="guarantor_total.cashlevel"  class="td-content-input td-content-readonly"   readOnly  type="text" value="${requestScope['guarantor_total.cashlevel']}" dataType="PMoney" readOnly   label="现金流级别"></td>
			         </tr>
			   </table>
            
            </c:if>
            
     </c:forEach>
   
     
     