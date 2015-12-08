<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script language="javascript">
	function selectRoteByCondtion(RoteObject)
	{  

		 var i=0;
		 var srote="";
	     var CustRoteObject=eval("("+RoteObject+")");
	    
		 for(;i<CustRoteObject.length;i++){
			 if(CustRoteObject[i].condtion==""){
				 srote=srote+"<input style='position:relative;top:3px;width:20px' name='flow_condition_select_id' type='radio' id='flow_condition_select_id' value='"+CustRoteObject[i].rote+"'>"+CustRoteObject[i].rote+"</input><br>";
				 }
			 else{
			 srote=srote+"<input style='position:relative;top:3px;width:20px' name='flow_condition_select_id' type='radio' id='flow_condition_select_id' value='"+CustRoteObject[i].rote+"'>"+CustRoteObject[i].condtion+"-->"+CustRoteObject[i].rote+"</input><br>";
		 }}
	    jQuery("#id_flow_condition_select").html(srote);	
	      
		jQuery("#flow_condition_select").show();
		jQuery("#flow_condition_select").window({
			   top:10
		  });
		 jQuery("#flow_condition_select").window("open");
    }
    function selectRoteResult(){
        var crote=$('input[name="flow_condition_select_id"]:checked').val();
        if (typeof(crote) == "undefined") { 
        	jQuery.messager.alert('操作提示',"<div style='font-size:18px;line-height:30px;'>请选择路由！</div>",'error');
        	//jQuery('#flow_condition_select').window('show');
        }else{  
        	isSelectRote=true;
        	if(crote=="流程结束"){crote="";} 
        	selectRote=crote;
    	   jQuery('#flow_condition_select').window('close');
    	   btn_callBack("Submit");
        } 	
     }
	</script>
<div id="flow_condition_select" closed="true" modal="true" title="提交下一步详情"
	style="display:none;width:600px;padding-top:10px;padding:0px;">
<center>
<div style="width:96%;text-align:left;">
<table width="100%">
   <tr>
     <tr style='height:20px;'><td></td></tr>
	<td colspan="2">
	     条件选择:    
	</td>
	</tr>
	<tr>
	<td class="input_value"  colspan="2">
	   <span id="id_flow_condition_select" style="padding-right:10px">
	   </span>    
	</td>
	</tr>
	<tr class="content-separator">
		<td colspan="2"><a style="margin-left: 20px;"
			href="javascript:void(0);" class="btn btn-primary"
			onclick='selectRoteResult();'><span>确定</span></a> <a
			style="margin-left: 20px;" href="javascript:void(0);"
			class="btn btn-primary"
			onclick="jQuery('#flow_condition_select').window('close');"
            ><span>取消</span></a>
		</td>
	</tr>
</table>
</div>
</center>
</div>