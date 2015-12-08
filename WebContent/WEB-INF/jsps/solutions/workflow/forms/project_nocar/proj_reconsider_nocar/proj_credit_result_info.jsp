<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

     <div id="proj_credit_form1">
     <div class="mini-panel" title="审核结论" showCollapseButton="true" style="width: 99%;">
	    <table class="fillTable" cellspacing="0" cellpadding="0" >
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">信审结论：</td>
	             <td class="td-content">
	             <input id="id_proj_info_credittype" name="proj_info_credittype"   class="mini-combobox" textField="name"  required="true"
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'CreditType'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
							   value="${requestScope['proj_info_credittype'] }" 
							   text="${requestScope['rawValue_proj_info_credittype']}" 
							   onvaluechanged="comboboxChanged(e)"
				 />
				 <input id="rawValue_proj_info_credittype" name="rawValue_proj_info_credittype" value="${requestScope['rawValue_proj_info_credittype']}"  class="mini-textbox" style="display:none"/>
	             </td>
	             <td class="td-content-title" style="width:10%">信审日期：</td><td class="td-content">
	             <input id="id_projcreditpasstime" name="proj_credit_re_result.projcreditpasstime"  value="${requestScope['proj_credit_re_result.projcreditpasstime']}" class="mini-datepicker" required="true"  allowInput="false"/>
	             </td>
	          </tr>
	          
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">备注：</td>
	             <td class="td-content" colspan=5 >
	             <input id="id_creditconclusion" style="width:73%" name="proj_credit_re_result.creditconclusion" value="${requestScope['proj_credit_re_result.creditconclusion']}" required="true" label="备注" class="mini-textarea"  type="text" > 
	             </td>
	          </tr>
	            
	</table>
</div>
</div>
<script language="javascript">

//控制只读页面
if(!isViewHistoryTask||notdisplay){
mini.parse("proj_credit_form1");
var form = new mini.Form("proj_credit_form1");
var o = form.getData(); 
var fields = form.getFields();
for(var index =0;index<fields.length;index++){
	 //判断是否是下拉框控件，是则同时把text属性传入后台
	if(fields[index].uiCls == "mini-combobox" || fields[index].uiCls =="mini-datepicker"){
		fields[index].disable();
	}else{
		fields[index].allowInput=false;
	}
}
}


</script>

