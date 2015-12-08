<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <script language="javascript">
    jQuery(function(){
    	 var isInit=isSubTable||false;
         if(isInit==true){
        //会议方式
    	dictSameCode('id_review_meettype','proj_credit_re_risk_record.meettype','meettype','${requestScope["proj_credit_re_risk_record.meettype"]}','${requestScope["rawValue_proj_credit_re_risk_record.meettype"]}','require="true" label="会议方式"');
        //主持人
     	commonSelect('id_review_meetting_compere1','t_users','id_','realname_','proj_credit_re_risk_record.meettingcompereid','${empty requestScope["proj_credit_re_risk_record.meettingcompereid"] ? sessionScope.loginUser.id : requestScope["proj_credit_re_risk_record.meettingcompereid"]}',null, null,'require="true" label="主持人"');
         } });
    </script>
         <table cellspacing="0" cellpadding="0"  id="proj_credit_re_risk_record">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-record"></div>项目复议风险委员会会议记录</td>
          </tr>
           <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">上会时间：</td><td class="td-content"><input name="proj_credit_re_risk_record.projmeettime" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_credit_re_risk_record.projmeettime'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="上会时间" /><font class="required-content">*</font></td>
             <td class="td-content-title">上会地点：</td><td class="td-content" ><input require="true" label="上会地点"  style="width:60%" name="proj_credit_re_risk_record.projmeetplace" id="proj_meet_place" class="td-content-input"  type="text" value="${requestScope['proj_credit_re_risk_record.projmeetplace']}"  ><font class="required-content" style="width:150px;">* </font></td>
          </td>
           </tr>
          <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">主持人：</td><td class="td-content"><div class="leftComboContainer" id="id_review_meetting_compere1"></div><font class="required-content">*</font></td>
             <td class="td-content-title">会议方式：</td><td class="td-content"><div class="leftComboContainer" id="id_review_meettype"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">审批内容：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="credit_comment" require="true" label="审批内容" 
			name="proj_credit_re_risk_record.creditcomment">${requestScope['proj_credit_re_risk_record.creditcomment'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">参加审批人员：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="credit_persons" require="true" label="参加审批人员" 
			name="proj_credit_re_risk_record.creditpersons">${requestScope['proj_credit_re_risk_record.creditpersons'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">列席会议人员：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_person" require="true" label="列席会议人员" 
			name="proj_credit_re_risk_record.meetperson">${requestScope['proj_credit_re_risk_record.meetperson'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">缺席会议人员：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_no_person" require="true" label="缺席会议人员" 
			name="proj_credit_re_risk_record.meetnoperson">${requestScope['proj_credit_re_risk_record.meetnoperson'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">会议记录：</td></td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_record" require="true" label="会议记录" 
			name="proj_credit_re_risk_record.meetrecord">${requestScope['proj_credit_re_risk_record.meetrecord'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">会议结论：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_result"  require="true" label="会议结论" 
			name="proj_credit_re_risk_record.meetresult">${requestScope['proj_credit_re_risk_record.meetresult'] }</textarea>
			<input  name="proj_credit_re_risk_record.meetrecordtype" value="风险控制委员会审议复议"  type="hidden">
		</td></tr> 
        </table>