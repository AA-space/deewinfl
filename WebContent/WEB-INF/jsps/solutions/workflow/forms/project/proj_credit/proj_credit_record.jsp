<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <script language="javascript">
    jQuery(function(){
    	 var isInit=isSubTable||false;
         if(isInit==true){
        //会议方式
    	dictSameCode('id_meettype1','proj_meet_record1.meettype','meettype','${requestScope["proj_meet_record1.meettype"]}','${requestScope["rawValue_proj_meet_record1.meettype"]}','require="true" label="会议方式"');
        //主持人
     	commonSelect('id_meetting_compere1','t_users','id_','realname_','proj_meet_record1.meettingcompereid','${empty requestScope["proj_meet_record1.meettingcompereid"] ? sessionScope.loginUser.id : requestScope["proj_meet_record1.meettingcompereid"]}',null, null,'require="true" label="主持人"');
         } });
    </script>
         <table cellspacing="0" cellpadding="0"  id="proj_credit_record">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-record"></div>项目评审会议记录</td>
          </tr>
           <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">上会时间：</td><td class="td-content"><input name="proj_meet_record1.projmeettime" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_meet_record1.projmeettime'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="上会时间" /><font class="required-content">*</font></td>
             <td class="td-content-title">上会地点：</td><td class="td-content" ><input style="width:60%" name="proj_meet_record1.projmeetplace" id="proj_meet_place" require="true" label="上会地点" class="td-content-input"  type="text" value="${requestScope['proj_meet_record1.projmeetplace']}"  ><font class="required-content" style="width:150px;">* </font></td>
          </td>
           </tr>
          <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">主持人：</td><td class="td-content"><div class="leftComboContainer" id="id_meetting_compere1"></div><font class="required-content">*</font></td>
             <td class="td-content-title">会议方式：</td><td class="td-content"><div class="leftComboContainer" id="id_meettype1"></div><font class="required-content">*</font></td>
         </tr>
          <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">审批内容：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="credit_comment" require="true" label="审批内容" 
			name="proj_meet_record1.creditcomment">${requestScope['proj_meet_record1.creditcomment'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">参加审批人员：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="credit_persons"  require="true" label="参加审批人员" 
			name="proj_meet_record1.creditpersons">${requestScope['proj_meet_record1.creditpersons'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">列席会议人员：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_person"  require="true" label="列席会议人员" 
			name="proj_meet_record1.meetperson">${requestScope['proj_meet_record1.meetperson'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">缺席会议人员：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_no_person"  require="true" label="缺席会议人员" 
			name="proj_meet_record1.meetnoperson">${requestScope['proj_meet_record1.meetnoperson'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-even">
             <td class="td-content-title">会议记录：</td></td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_record"  require="true" label="会议记录" 
			name="proj_meet_record1.meetrecord">${requestScope['proj_meet_record1.meetrecord'] }</textarea>
		</td></tr> 
		 <tr class="tr-proj-credit-record tr-odd">
             <td class="td-content-title">会议结论：</td>
             <td class="td-content" colspan=3><textarea rows="5"
			style="width: 98%" id="meet_result"   require="true" label="会议结论" 
			name="proj_meet_record1.meetresult">${requestScope['proj_meet_record1.meetresult'] }</textarea>
			<input  name="proj_meet_record1.meetrecordtype" value="审核"  type="hidden">
		</td></tr> 
        </table>