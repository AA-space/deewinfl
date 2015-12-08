<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <script language="javascript">
    jQuery(function(){
    	 var isInit=isSubTable||false;
         if(isInit==true){
        //信审结论
    	dictSameCode('id_credit_review_result_type','proj_credit_re_result.creditresulttype','CreditType','${requestScope["proj_credit_re_result.creditresulttype"]}','${requestScope["rawValue_proj_credit_re_result.creditresulttype"]}','require="true" label="信审结论类型"');
        //信审员
     	commonSelect('id_credit_review_person','t_users','id_','realname_','proj_credit_re_result.creditpersonid','${empty requestScope["proj_credit_re_result.creditpersonid"] ? sessionScope.loginUser.id : requestScope["proj_credit_re_result.creditpersonid"]}',null, null,'require="true" label="信审员"');
         }});
    </script>
         <table cellspacing="0" cellpadding="0"  id="proj_credit_re_result">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-result"></div>复议审核结论</td>
          </tr>
           <tr class="tr-proj-credit-result tr-even">
             <td class="td-content-title">信审通过时间：</td><td class="td-content"><input name="proj_credit_re_result.projcreditpasstime" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_credit_re_result.projcreditpasstime'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="信审通过时间" /><font class="required-content">*</font></td>
             <td class="td-content-title">信审结论类型：</td><td class="td-content"><div class="leftComboContainer" id="id_credit_review_result_type"></div><font class="required-content">*</font></td>
           </tr>
          <tr class="tr-proj-credit-result tr-odd">
             <td class="td-content-title">信审员：</td><td class="td-content" colspan=3><div class="leftComboContainer" id="id_credit_review_person"></div><font class="required-content">*</font></td>
             </tr>
		 <tr class="tr-proj-credit-result tr-even">
             <td class="td-content-title">信审结论：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="credit_conclusion" require="true" label="信审结论"
			name="proj_credit_re_result.creditconclusion">${requestScope['proj_credit_re_result.creditconclusion'] }</textarea>
		</td></tr> 
        </table>