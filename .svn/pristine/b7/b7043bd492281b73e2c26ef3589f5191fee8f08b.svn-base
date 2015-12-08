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
    	    renderTo:'id_pay_plan2',
    	    width:formWidth,
    	    height:350,
    	    isFit:true,
    	    isNeedTools:currentIsNeedTools,
    	    tools:'新增|修改|删除',
    	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
    	    columns:[
    	       {name:'id',  header:'id',hidden:true},
    	       {name:'eqipname',  header:'序号',nullable:false},
    	       {name:'refund_list', header:'期数',nullable:false,type:'double'},
    	       {name:'refund_plan_date',  header:'还款日期',nullable:true,type:'double'},
    	       {name:'refund_corpus',  header:'还本金额',nullable:false,type:'double'},
    	       {name:'refund_interest',  header:'付息金额',nullable:true,type:'double'},
    	       {name:'refund_money',  header:'本息合计',type:'double'},
    	       {name:'refund_otherfee_money',  header:'其他费用金额',type:'double'},
    	       {name:'refund_otherfee_type',  header:'其他费用类型',type:'double'},
    	       {name:'refund_subtotal',  header:'本次还款总计',type:'double'},
    	       {name:'remark',  header:'备注',type:'textarea'}
    	     ]
    	 });
    	 
    });
    
    </script>
    
          <tr class="x-panel-table-div-title">
          		<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr_pay_plan2"></div>
				还款计划制定</td>
		  </tr>
          <tr class="tr_pay_plan2"  >
	          <td colspan=4>
	          <div><div id="id_pay_plan2"></div></div>
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