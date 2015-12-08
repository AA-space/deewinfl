<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <script language="javascript">
    function getCurrentDate(){
        var cdate=new Date();
        var month=(parseFloat(cdate.getMonth())+1);
        var day=cdate.getDate();
        if(parseFloat(day)<10){day="0"+day;}
        if(parseFloat(month)<10){month="0"+month;}
        return cdate.getFullYear()+"-"+month+"-"+day;
    }
    jQuery(function(){
        //信审结论approveConclusion
        $('#proj_credit_result_creditresulttype').val("credit_type_@11");//默认值
    dictOnSelect('id_credit_result_type','proj_info.approvetype','CreditType','${empty requestScope["proj_info.approvetype"] ? "credit_type_@11" : requestScope["proj_info.approvetype"]}',function(i,v){
    		if(v.value){
    			var statusVal = v.value.substr(v.value.indexOf("@") + 1);
    			$('#id_credit_result_value').val(statusVal);
    			$('#proj_credit_result_creditresulttype').val(v.value);
    		} else{
    			alert("请指定信审结论");
    		}
    	}
	    );
        //信审日期默认当前日期
        var curdate = getCurrentDate();
        $("#id_proj_projcreditpasstime").val(curdate);
      });
    </script>
         <!-- 给信审赋值 -->
<input id="proj_credit_result_creditresulttype" name="proj_credit_result.creditresulttype" type="hidden" value="${requestScope['proj_credit_result.creditresulttype'] }"/>
<input id="id_credit_result_value" name="credit_result_value" type="hidden" value="${requestScope['credit_result_value'] }"/>
    
         <table cellspacing="0" cellpadding="0"  id="proj_credit_result">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-result"></div>审核结论</td>
          </tr>
          <tr class="tr-proj-credit-result-info tr-even">
             <td class="td-content-title">信审结论：</td><td class="td-content"><div class="leftComboContainer" id="id_credit_result_type"></div><font class="required-content">*</font></td>
             <td class="td-content-title">信审日期：</td><td class="td-content"><input id="id_proj_projcreditpasstime" name="proj_credit_result.projcreditpasstime" class="Wdate td-content-input td-content-readonly"  
             type="text" dataType="Date" value="${requestScope['proj_credit_result.projcreditpasstime'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly /><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-proj-credit-result-info tr-odd">
             <td class="td-content-title">备注：</td>
		    <td class="td-content" colspan="3"><textarea rows="5"  
			style="width:98.2%;float:left;" name="proj_other_info.approveconclusion">${requestScope['proj_other_info.approveconclusion'] }</textarea>
		     </td>
	       </tr> 
        </table>