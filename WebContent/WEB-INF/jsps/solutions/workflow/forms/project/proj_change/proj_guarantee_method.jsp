<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    if('true' == '${isViewHistoryTask}'){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_guarantee_method_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    datas:JsonUtil.decode('${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'),
	    addOperCallBack:getSelectDatas,
	    columns:[
	       {name:'id',  header:'uuid',hidden:true},
	       {name:'assurorname', header:'担保单位',renderer:showCustName,type:'combobox',nullable:false,hiddenName : 'assuror',
			    config:{
				       width:165,
				       xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'id',
				       params:{
				    	    cust_class_m:"1",
				   			cust_class1:'CUST_INFO_COMPANY',
				   			cust_class2:'CUST_INFO_PERSON',
				  			cust_type:'cust_type.assuror',
				  			cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}"
				       } 
		   }},
		   {name:'assuror', header:'担保单位id',hidden:true},
	       {name:'assuremethodname', header:'担保类型',type:'combobox',nullable:false,hiddenName :'assuremethod',
			    config:{
				       width:165,
				       xmlFileName:'\\combos\\comboDict.xml',
				       loadMode:'ajax',
				       readOnly:true,
				       displayField:'name',
				       valueField:'code',
				       params:{
				          pid:'assure_method'
				       } 
		   }},
		   {name:'assuremethod', header:'担保类型id',hidden:true},
	       {name:'assurerelationname',  header:'关系',type:'combobox',nullable:false,hiddenName : 'assurerelation',
			    config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'relation'
			       } 
   			}},
   			{name:'assurerelation', header:'关系id',hidden:true},
	       {name:'cgmnote',header:'备注',type:'textarea',nullable:false,otherAttributes:'maxB="2000"'}
	     ]
	 });
});
function showCustName(value,tableObj,columnName,columnIndex,rowData){
    var base = "<a href='javascript:void(0);' onclick='showEwlpCustInfoaAssuror(\""+rowData.assuror+"\")'>{1}</a>{2}";
    var separator = "&nbsp;&nbsp;";
    var updateFlag=value;
    var updateClickFunc="other";
    var field=base.replace("{1}",updateFlag).replace("{2}",separator);
    return field;
  }
function showEwlpCustInfoaAssuror(cust_id){
 	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
 	var params = {cust_id:cust_id,read_only:false};
	    openFullScreenWindow(URL,params);
     //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
 }
</script>