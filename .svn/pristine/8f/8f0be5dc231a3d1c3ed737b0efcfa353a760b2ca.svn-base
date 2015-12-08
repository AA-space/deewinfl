<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/ajaxfileupload.js"></script>
<script type="text/javascript">
 
     var isCompletedTask=("true"=="${isCompletedTask}");   //当前结点是否结束
     var flowName="${requestScope['currentWorkFlowName']}";//流程名称
     var stepName="${currentTaskActivityName}";   //当前节点的名称
     var flowUnid="${currentProcessInstanceDBID}";   //当前流程的ID
     var stepUnid="${requestScope['currentTaskId']}";   //当前节点的id
    </script>
<script type="text/javascript">

    jQuery(function(){
        var currentIsNeedTools = true;
        
        if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
        	currentIsNeedTools = false;
        }
    	new tracywindyMultiTable({
    	    renderTo:'id_fina_proj_apply',
    	    width:formWidth,
    	    height:350,
    	    isFit:true,
    	    isNeedTools:currentIsNeedTools,
    	    tools:'新增|修改|删除',
    	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
    	    columns:[
    	       {name:'id',  header:'id',hidden:true},
    	       {name:'eqipname',  header:'申报序号',nullable:false},
    	       {name:'guarantor', header:'项目名称',nullable:false,type:'combobox',
    			    config:{
    				       width:165,
    				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
    				       loadMode:'ajax',
    				       readOnly:false,
    				       isAjaxLenovo:true,
    				       displayField:'name',
    				       valueField:'code',
    				       params:{
    	    	  				custType:'cust_type.guarantor'
    				       } 
    		   }},
    	       {name:'equipinvoice',  header:'起租编号',nullable:true},
    	       {name:'totalprice',  header:'操作',nullable:false,type:'double'},
    	       {name:'presentvalue',  header:'承租人',nullable:false,type:'double'},
    	       {name:'equipguaranteetype',  header:'行业',nullable:true,type:'double'},
    			   // config:{
    			   //   width:165,
    			   //    xmlFileName:'\\combos\\comboDict.xml',
    			   //    loadMode:'ajax',
    			   //    readOnly:true,
    			   //   displayField:'name',
    			   //   valueField:'code',
    			   //   params:{
    			   //       pid:'guarantee_type'
    			   //    } 
       			   // }
    	       {name:'notaryflag',  header:'租赁类型',nullable:true,type:'double'},
        	       //,config:{
    			   //    width:165,
    			   //    xmlFileName:'\\combos\\comboDict.xml',
    			   //    loadMode:'local',
    			   //    readOnly:true,
    			   //    displayField:'name',
    			   //    valueField:'code',
    			   //    datas:[{name:'是',code:'0'},{name:'否',code:'1'}]
        		   //    }
		       
    	       {name:'recordmech',  header:'剩余租金',nullable:true},
    	       {name:'purchaselife',  header:'融资状态',nullable:false,type:'number'},
    	       {name:'cgenote',  header:'备注',type:'textarea'}
    	     ]
    	 });
    	 
    });

    
    </script>

<tr class="x-panel-table-div-title">
	<td class="x-panel-table-div-title" colspan=4>
	<div class="toggle-icon-expanded" title="折叠"
		toggleClass="tr-project-apply"></div>
	融资项目申报</td>
</tr>
<tr class="tr-project-apply">
	<td colspan=4>
	<div>
	<div id="id_fina_proj_apply"></div>
	</div>

	</td>
</tr>
<script>




var isSubTable = true;
//初始化调用
jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
	$("#id_project_info_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_project_info_tabs_content");
	$("#id_project_fund_rent_plan_tabs_content").css("width",
			(formWidth) + "px");
	$("#id_project_fund_rent_plan_tabs_content").tabs();
	//jQuery(".fillTableContainer").css("width",formWidth+"px");
});
</script>