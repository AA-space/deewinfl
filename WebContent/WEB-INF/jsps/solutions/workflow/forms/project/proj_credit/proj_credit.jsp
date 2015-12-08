<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	
<div id="id_proj_votingForm" closed="true" modal="true" title="表决意见"
	style="display: none; width: 420px;">
<center>
<div style="width: 90%; padding-top: 30px;">
<table>
	<tr>
	    <input id="id_proj_vote" name="proj_vote.id" class="td-content-input td-content-readonly" readOnly  type="hidden"  value=""/>
		<td class="input_label_desc" style="width:30%">表决意见:</td>
		<td class="input_value"><div class="leftComboContainer" id="id_vote_type"> </div><td><span class="content-required">*</span></td>
        </td>
    </tr>
    <tr>
		<td class="input_label_desc">评分:</td>
		<td class="input_value"><input type="text"  id="id_votegrade"  name="proj_vote.votegrade" value="" style="width:30" />
		</td><td><span class="content-required">*</span></td>
	</tr>
	<tr>
		<td class="input_label_desc">表决内容:</td>
		<td  colspan=2><textarea rows="10" cols="150" id="id_votecommonent" style="width: 98%"
			name="proj_vote.votecommonent"></textarea>
		</td>
	</tr>
	<tr class="content-separator">
	<td colspan=3>
	<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='doVoteOperation();'><span>确定</span></a> 
	<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_proj_votingForm").window("close");'><span>取消</span></a>
	</td>
	</tr>
</table>
</div>
</center>
</div>
<script language="javascript">
	var currentTaskId="${requestScope['currentTaskId'] }";
	var currentFlowName="${requestScope['currentWorkFlowName'] }";
	var mainFlowTaskId="${currentProcessInstanceDBID}";
	var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
	jQuery(function(){
	 //加投票按钮
	 if(!isCompletedTask){
	  jQuery("#id_btn_tools_container").append("<a id='' class='easyui-linkbutton l-btn l-btn-plain' iconcls='icon-ok' plain='true' onclick='addMenuData();' href='javascript:void(0);'><span class='l-btn-left'><span class='l-btn-text icon-ok' style='padding-left: 20px;'>投票</span></span></a>");
	 }
    });	
	function checkVote(){
		loadMask_oper.show();
		var isSubmit = false;
		 var param={};
		 var method="getCurrentCustVote";
		 param.currentTaskId=mainFlowTaskId;
		 ajaxRequest({
  		     url:'${pageContext.request.contextPath}/leasing/vote/'+method+'.action',
  		     method:'POST',
  		     success:function(res){
  	   		    var svote=res.responseText;
  	   		    svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
  	   		    loadMask_oper.hide();
  	   		    if(svote==""){
	  	   		    jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>没有投票！</div>",'error');
	  	   		    isSubmit = false;
  	   		    }else{
  	   		        isSubmit = true;
  	   	   		}
  		     },
  		     async:false,
  		     failure:function(res){},
  		     params:param
		 });
		 return isSubmit;
		}
	function addMenuData()
	{   
		 jQuery("#id_proj_votingForm").show();
		 jQuery("#id_proj_votingForm").window({
			   top:100,width:500
		  });
		 jQuery("#id_proj_votingForm").window("open");
		 loadMask_oper.show();
		 var param={};
		 var method="getCurrentCustVote";
		 param.currentTaskId=mainFlowTaskId;
		 ajaxRequest({
   		     url:'${pageContext.request.contextPath}/leasing/vote/'+method+'.action',
   		     method:'POST',
   		     success:function(res){
   	   		    var svote=res.responseText;
   	   		    svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
   	   		    if(svote==""){}else{
                 var vote=eval("("+svote+")");
                 jQuery("#id_proj_vote").val(vote.id);
                 jQuery("#id_votecommonent").val(vote.voteCommonent);
                 jQuery("#id_votegrade").val(vote.voteGrade);
                 var votetype = getTracywindyObject('id_combo_vottype');
                 votetype.setValue(vote.voteTypeid);
                 votetype.setRawValue(vote.voteTypename);
   	   	   		}
   		    	loadMask_oper.hide();
   		     },
   		     failure:function(res){},
   		     params:param
		 });
    }
	jQuery(function(){
		var cfalg=isViewHistoryTask;
		isViewHistoryTask = false;
		dict('id_vote_type','proj_vote.votetype','vottype','${requestScope["proj_vote.votetype"]}','${requestScope["rawValue_proj_vote.votetype"]}','require="true" label="表决意见"');
		isViewHistoryTask=cfalg;
		});	
	function doVoteOperation(){
		var vtypeid=getTracywindyObject("id_combo_vottype").getValue();
		var vtype=getTracywindyObject("id_combo_vottype").getRawValue();
		if("" == vtype)
		{
			jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>表决意见不能为空！</div>",'error');
			jQuery("#id_votegrade").focus();
			return;
        }
    	var grade = jQuery("#id_votegrade").val();
    	if("" == grade)
		{
			jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>评分不能为空！</div>",'error');
			jQuery("#id_votegrade").focus();
			return;
        }
    	var commtent = jQuery("#id_votecommonent").val();
    	if("" == commtent)
		{
			jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>表决内容不能为空！</div>",'error');
			jQuery("#id_votecommonent").focus();
			return;
        }
    	loadMask_oper.show();
        var params={};
        params["id"]=jQuery("#id_proj_vote").val();
        params["vtype"]=vtype;
        params["projid"]=jQuery("#project_id").val();
        params["vtypeid"]=vtypeid;
        params["grade"]=grade;
        params["vtypeid"]=vtypeid;
        params["commtent"]=commtent;
        params["taskId"]=mainFlowTaskId
        params["flowName"]= currentFlowName
        method="saveOrUpdateVote"
        ajaxRequest({
        	     url:'${pageContext.request.contextPath}/leasing/vote/'+method+'.action',
	   		     method:'POST',
	   		     success:function(res){
	   		    	jQuery("#id_proj_votingForm").window("close");
	   		    	jQuery.messager.alert('操作提示',"<div style='font-size:18px;line-height:30px;'>投票成功！</div>",'success');
	   		    	loadMask_oper.hide();
	   		     },
	   		     failure:function(res){},
	   		     params:params
   		 });
    }
</script>