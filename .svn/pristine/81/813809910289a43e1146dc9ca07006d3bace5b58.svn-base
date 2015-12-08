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
    	    renderTo:'id_drawing_factorage',
    	    width:formWidth,
    	    height:350,
    	    isFit:true,
    	    isNeedTools:currentIsNeedTools,
    	    tools:'新增|修改|删除',
    	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
    	    columns:[
    	       {name:'id',  header:'id',hidden:true},
    	       {name:'eqipname',  header:'序号',nullable:false},
    	       {name:'factorage_money', header:'手续费金额',nullable:false,type:'double'},
    	       {name:'factorage_type',  header:'手续费类型',nullable:true,type:'double'},
    	       {name:'factorage_date',  header:'手续费日期',nullable:false,type:'double'},
    	       {name:'currency',  header:'币种',nullable:false,type:'double'},
    	       {name:'factorage_paytype',  header:'支付方式',nullable:true,type:'double'},
    	       {name:'factorage_remark',  header:'手续费备注',type:'textarea'}
    	     ]
    	 });
    	 
    });
    
    </script>
          
		  <tr>
			  <td colspan=4 class="td-even-line-separator">&nbsp;</td>
		  </tr>
          <tr class="x-panel-table-div-title">
          		<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr_drawings_factorage"></div>
				提款手续费</td>
		  </tr>
          <tr class="tr_drawings_factorage"  >
	          <td colspan=4>
	          <div><div id="id_drawing_factorage"></div></div>
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