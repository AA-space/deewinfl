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
    	dictOnSelect("id_drawings_rate1","drawings_rate_para1","ContRateStand",null,null,null,true,100);
    	var combo_rate = new tracywindyComboBox({
    	    id:'id_combo_id_drawings_rate',
    	    width:50,
    	    renderTo:'id_drawings_rate2',
    	   // xmlFileName:'\\eleasing\\workflow\\public\\comboCustSelect.xml',
    	    loadMode:'local',
    	    datas:[{title:'+',name:'+'},{title:'-',name:'-'},{title:'*',name:'*'},{title:'/',name:'/'}],
    	    readOnly:true,
    	    //isAjaxLenovo:true,
    	    isContainEmpty:true,
    	    dropListHeight:200,
    	    topAdd:0,
    	    leftAdd:0,
    	    positionDropIconLeftAdd:-1,
    	    name:'drawings_rate_para2',
    		displayField:'title',
    		valueField:'name',
    	    otherAttributes:'require="true" label="所属客户"'
    	    //params:{
    		//	custType:'cust_type.cust'
    	    //},
    	    //onSelect:function(combo){
    	      
    	    //    }
    	 });
    });
    </script>
    
		
        <tr class="x-panel-table-div-title"><td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_drawings_info"></div>
		提款表单信息</td>
          </tr>
          <tr class="tr_drawings_info tr-even">
             <td class="td-content-title"> 已占用额度：</td><td class="td-content"><input name="" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['']}"></td>
             <td class="td-content-title">剩余提款额度：</td><td class="td-content"><input name="" type="text" class="td-content-input td-content-readonly" value="${requestScope['']}" readOnly require="true"/></td>
         </tr>
          <tr class="tr_drawings_info tr-odd">
             <td class="td-content-title">提款标号：</td><td class="td-content"><input name="financing_drawings.drawings_id" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['financing_drawings.drawings_id']}"  require="true"></td>
             <td class="td-content-title"> 提款金额(元)：</td><td class="td-content"><input name="financing_drawings.drawings_money"  label="提款金额" type="text" class="td-content-input td-content-readonly" value="${requestScope['financing_drawings.drawings_money']}" readOnly/><font class="required-content">*</font></td>
          </tr>
          <tr class="tr_drawings_info tr-even">   
             <td class="td-content-title">贷款账号：</td><td class="td-content"><input label="贷款账号" name="financing_drawings.account" class="td-content-input td-content-readonly" readOnly require="true" type="text" value="${requestScope['financing_drawings.account'] }" ><font class="required-content">*</font></td>
             <td class="td-content-title">币种：</td><td class="td-content"><input label="币种" name="financing_drawings.currency" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['financing_drawings.currency'] }"><font class="required-content">*</font></td>
         </tr>
         <tr  class="tr_drawings_info tr-odd">
          	<td  class="td-content-title">贷款账号备注：</td>
			<td colspan="3"  class="td-content-title"><textarea name="account_remark" class="h60" rows="4" cols="80"></textarea>
			</td>
          </tr>
           <tr class="tr_drawings_info tr-even">
             <td class="td-content-title">提款日期：</td><td class="td-content"><input label="提款日期" name="financing_drawings.drawings_date" class="Wdate td-content-input td-content-readonly"  onclick="WdatePicker(this,{readOnly:true})" readOnly require="true" type="text" value="${requestScope['financing_drawings.drawings_date'] }" ><font class="required-content">*</font></td>
             <td class="td-content-title">借款到期日：</td><td class="td-content"><input label="借款到期日" name="financing_drawings.drawings_end_date" class="Wdate td-content-input td-content-readonly"  onclick="WdatePicker(this,{readOnly:true})" readOnly require="true" type="text" value="${requestScope['financing_drawings.drawings_end_date'] }" ><font class="required-content">*</font></td>
          </tr>
          <tr class="tr_drawings_info tr-odd">  
             <td class="td-content-title">贷款期限：</td><td class="td-content"><input label="贷款期限" name="financing_drawings.drawings_time_limit" class="td-content-input td-content-readonly" readOnly require="true" type="text" value="${requestScope['financing_drawings.drawings_time_limit'] }" ><font class="required-content" style="color: black;width: 20px;">月&nbsp;</font><font class="required-content">*</font></td>
             <td class="td-content-title">原始外币汇率：</td><td class="td-content"><input name="" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope[''] }" ></td>
         </tr>
          <tr class="tr_drawings_info tr-even">   
             <td class="td-content-title">合同利率：</td><td class="td-content">
             <div id="id_drawings_rate1" style="float: left;"></div>
             <div id="id_drawings_rate2" style="float: left;"></div>
             <input label="合同利率" style="width: 60px;" name="financing_drawings.drawings_rate" class="td-content-input td-content-readonly" readOnly require="true" type="text" value="${requestScope['financing_drawings.drawings_rate'] }" ><font class="required-content" style="color: black;width: 20px;">%&nbsp;</font><font class="required-content">*</font></td>
             
             
             <td class="td-content-title">利率浮动类型：</td><td class="td-content"><input name="financing_drawings.drawings_rate_float_type" class="td-content-input td-content-readonly" readOnly  require="true" type="text" value="${requestScope['financing_drawings.drawings_rate_float_type'] }"><font class="required-content">*</font></td>
         </tr>  
          <tr class="tr_drawings_info tr-odd">   
             <td class="td-content-title">综合利率：</td><td class="td-content"><input name="" class="td-content-input td-content-readonly" readOnly require="true"  type="text" value="${requestScope[''] }" ></td>
             <td class="td-content-title">扣息方式：</td><td class="td-content"><input name="financing_drawings.rebated_type" class="td-content-input td-content-readonly"  onclick="WdatePicker(this,{readOnly:true})" readOnly require="true" type="text" value="${requestScope['financing_drawings.rebated_type']}" ><font class="required-content">*</font></td>
         </tr>
         <tr  class="tr_drawings_info tr-even">
          	<td  class="td-content-title">合同利率备注：</td>
			<td colspan="3"  class="td-content-title"><textarea name="drawings_rate_remark" class="h60" rows="4" cols="80"></textarea>
			</td>
          </tr>
          <tr class="tr_drawings_info tr-odd">   
              <td class="td-content-title">贷款类型：</td><td class="td-content"><input label="贷款类型" name="financing_drawings.drawings_type" class="td-content-input td-content-readonly" readOnly require="true"  type="text" value="${requestScope['financing_drawings.drawings_type'] }" ><font class="required-content">*</font></td>
             <td class="td-content-title">还款方式：</td><td class="td-content"><input label="还款方式" name="financing_drawings.refund_way" class="td-content-input td-content-readonly" readOnly require="true" type="text" value="${requestScope['financing_drawings.refund_way'] }" ><font class="required-content">*</font></td>
          </tr>
          <tr class="tr_drawings_info tr-even">   
              <td class="td-content-title">还款方式明细：</td><td class="td-content"><input name="financing_drawings.refund_way_detail" class="td-content-input td-content-readonly" readOnly require="true"  type="text" value="${requestScope['financing_drawings.refund_way_detail'] }" ></td>
             <td class="td-content-title">融资比例：</td><td class="td-content"><input name="financing_drawings.financing_ratio" class="td-content-input td-content-readonly" readOnly require="true" type="text" value="${requestScope['financing_drawings.financing_ratio'] }"><font  class="required-content" style="width: 115px;font-size: 12px;">提款金额/剩余租金</font></td>
          </tr>
          <tr class="tr_drawings_info tr-odd">   
          	<td class="td-content-title">剩余租金总和：</td><td class="td-content"><input name="financing_drawings.financing_money" class="td-content-input td-content-readonly" readOnly require="true" type="text" value="${requestScope['financing_drawings.financing_money'] }" ></td>
          	<td></td><td></td>
          </tr>
          <tr  class="tr_drawings_info tr-even">
          	<td  class="td-content-title">融资比例备注：</td>
			<td colspan="3"  class="td-content-title"><textarea name="financing_ratio_remark" class="h60" rows="4" cols="80"></textarea></td>
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