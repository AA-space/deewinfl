<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <script language="javascript">
	var currentTaskId="${requestScope['currentTaskId'] }";
	var currentFlowName="${requestScope['currentWorkFlowName'] }";
	var mainFlowTaskId="${currentProcessInstanceDBID}";
	function getVoteSum(){
		var param={};
		 var method="getAllVote";
		 param.currentTaskId=mainFlowTaskId;
		 ajaxRequest({
  		     url:'${pageContext.request.contextPath}/leasing/vote/'+method+'.action',
  		     method:'POST',
  		     success:function(res){
  	   		    var svote=res.responseText;
  	   		    svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
  	   		    if(svote==""){}else{
                var vote=eval("("+svote+")");
                var agree=0;
                var noagree=0;
                var conagree=0;
                var sagree="";
                var snoagree="";
                var sconagree="";
                for(var i=0;i<vote.length;i++){
                    if(vote[i].voteTypename=="同意"){agree=agree+1;sagree=sagree+vote[i].creator+":"+vote[i].voteTypename+"\r\t"+vote[i].voteCommonent+"\r";}
                    if(vote[i].voteTypename=="不同意"){noagree=noagree+1;snoagree=snoagree+vote[i].creator+":"+vote[i].voteTypename+"\r\t"+vote[i].voteCommonent+"\r";}
                    if(vote[i].voteTypename=="附条件同意"){conagree=conagree+1;sconagree=sconagree+vote[i].creator+":"+vote[i].voteTypename+"\r\t"+vote[i].voteCommonent+"\r";}
                    }
                jQuery('#agree_number').val(agree);
                jQuery('#agree_no_number').val(noagree);
                jQuery('#agree_cond_number').val(conagree);
                jQuery('#voting_Content').val(sagree+sconagree+snoagree);
  	   	   		} 
  		     },
  		     failure:function(res){},
  		     params:param
		 });
	}
	
    jQuery(function() {getVoteSum();});
  </script>      
         <table cellspacing="0" cellpadding="0"  id="proj_voting_result">
         <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-voting-result"></div>表决结果</td>
          </tr>
           <tr class="tr-proj-voting-result tr-even">
             <td class="td-content-title">同意票数：</td><td class="td-content" ><input style="width:60%" name="proj_voting_result.agreenumber" id="agree_number" class="td-content-input"  type="text" value=""  ></td>
             <td class="td-content-title">不同意票数：<td class="td-content" ><input style="width:60%" name="proj_voting_result.agreenonumber" id="agree_no_number" class="td-content-input"  type="text" value=""  ></td>
             <td class="td-content-title">附加同意票数：</td><td class="td-content" ><input style="width:60%" name="proj_voting_result.agreecondnumber" id="agree_cond_number" class="td-content-input"  type="text" value=""  ></td>
           </tr>
		 <tr class="tr-proj-voting-result tr-odd">
             <td class="td-content-title">表决意见：</td>
             <td class="td-content" colspan=5><textarea rows="5" style="width: 98%;float:left;" id="voting_Content" name="proj_voting_result.votingContent"></textarea></td>
		</tr> 
        </table>