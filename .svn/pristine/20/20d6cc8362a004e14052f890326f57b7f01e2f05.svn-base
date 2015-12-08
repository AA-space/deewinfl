<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/ajaxfileupload.js"></script>
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
    	    renderTo:'id_drawing_proj',
    	    width:formWidth,
    	    height:350,
    	    isFit:true,
    	    isNeedTools:currentIsNeedTools,
    	    tools:'新增|修改|删除',
    	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
    	    columns:[
    	       {name:'id',  header:'id',hidden:true},
    	       {name:'eqipname',  header:'序号',nullable:false},
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
    	       {name:'begin_id',  header:'起租编号',nullable:true},
    	       {name:'financing_corpus',  header:'剩余本金',nullable:false,type:'double'},
    	       {name:'financing_interest',  header:'剩余利息',nullable:false,type:'double'},
    	       {name:'equipguaranteetype',  header:'剩余租金',nullable:true,type:'double'},
    	       {name:'financing_begin_date',  header:'起息日',nullable:true,type:'double'},
    	       {name:'financing_end_date',  header:'到期日',nullable:true},
    	       {name:'financing_allotted',  header:'借款期限(年)',nullable:false,type:'number'},
    	       {name:'financing_start_list',  header:'融资起始期次',nullable:false,type:'number'},
    	       {name:'financing_end_list',  header:'融资截止期次',nullable:false,type:'number'},
    	       {name:'leas_term',  header:'租赁期限',nullable:false,type:'number'},
    	       {name:'leas_type',  header:'租赁类型',nullable:false,type:'number'},
    	       {name:'industry_type',  header:'行业',nullable:false},
    	       {name:'financing_remark',  header:'备注',type:'textarea'}
    	     ]
    	 });
    	 
    });
    </script>
          
          <tr class="x-panel-table-div-title">
					<td class="x-panel-table-div-title" colspan=4>
						<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-drawings-proj"></div>
						提款项目</td>
		  </tr>
		  <tr class="tr-drawings-proj">
	          <td colspan=4>
		          <div>
		          <div id="id_drawing_proj"></div></div>
	          
	          </td>
          </tr>
          <tr class="tr-drawings-proj">
          	<td colspan=4 align="right">合计<input type="text" readonly name="sum" style="width: 80px;">&nbsp;</td>
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