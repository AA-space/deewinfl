<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	var contractid = '${param.contractid}';
	var docid = '${param.docid}';
	//alert(docid+"doc" +contractid);
	jQuery("#contractid").html(contractid);
	 
	
		var availWidth = parseInt(document.documentElement.clientWidth);
		var availHeight = parseInt(document.documentElement.clientHeight);
		$("#mianbody").css("height", availHeight - 30 + "px");
		$("#mianbody").css("width", availWidth - 20 + "px");
		
		var read_only =  '${empty param.read_only ? true : param.read_only}' ;
		
		var custInfoParam = {};
		custInfoParam.contractid = contractid;
		custInfoParam.docid = docid;
		$.post('${pageContext.request.contextPath}/leasing/acl/getInterestTempBaseInfo.acl?radom=' + Math.random(), custInfoParam, function(value){
			var src = null;
			if(value.indexOf("查询失败") != -1){
				alert(value);
				return;
			}
			value = eval('(' + value + ')'); 
			
			var $title = $('#title');
			jQuery("#contractnum").html(value.contractnum);
			jQuery("#custname").html(value.custname);
			jQuery("#dealername").html(value.dealername);
			jQuery("#rateoriginal").html(value.rateoriginal);
			jQuery("#rateadjust").html(value.rateadjust);
			jQuery("#oldirr").html(value.oldirr);
			jQuery("#newirr").html(value.newirr);
			if(src != null){
				$("#iframe").attr("src", src);
			}
		});

	var formWidth  = document.documentElement.clientWidth-2;
	var height=document.documentElement.clientHeigth-2;
    var currentIsNeedTools = true;
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
    var table = new tracywindyOperationTable({
		 tableComment:'待回滚',
	     isNeedEnabled:false,
	     isNeedEnabledQuery:false,
	     operButtons:'',
	     border:true,
    	renderTo:'id_table_leasing_compare_temp_list',
    	width:formWidth,
    	height:height,
    	id:'id_table_leasing_current_regulating_of_breathing_container',
    	xmlFileName:'/eleasing/workflow/money_rate/interestComparetmp.xml',
    	loadMode:'ajax',
    	isPage:true,
    	isFit:false,
    	isCheck:false,
    	border:true,
    	windowTop:10,
    	checkType:'combox',
       isNewLineQueryButton:true,
       queryButtonColSpan:4,
       params:{
	     docid:docid,
	     contractid:contractid
	     },
    columns:[

		{header:'id',name:'id',hidden:true},
		{header:'期项',name:'rentlist1'},
		{header:'承付日期',name:'plandate1'},
		{header:'租金',name:'rent1'},
		{header:'财务本金',name:'corpus1'},
		{header:'租息',name:'interest1'},
		{header:'业务本金',name:'corpusbusiness1'},
		{header:'业务租息',name:'interestbusiness1'},
		{header:'年利率',name:'yearrate1'},
		{header:'分隔',name:'flag'},
		{header:'期项',name:'rentlist2'},
		{header:'承付日期',name:'plandate2'},
		{header:'租金',name:'rent2'},
		{header:'财务本金',name:'corpus2'},
		{header:'租息',name:'interest2'},
		{header:'业务本金',name:'corpusbusiness2'},
		{header:'业务租息',name:'interestbusiness2'},
		{header:'年利率',name:'yearrate2'}
		]
		 });
});

</script>