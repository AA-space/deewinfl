<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var constantFlagTable = "User";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
var editor;
jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'调息',
		 limit:20,
		 constantFlagTable:'Notice',
	     isNeedEnabled:false,
	     isNeedEnabledQuery:false,
	     operButtons:'',
	     border:true,
	     renderTo:'id_table_leasing_already_regulating_of_breathing_container',
	     width:formWidth,
	     id:'id_table_leasing_already_regulating_of_breathing_container',
	     xmlFileName:'/eleasing/workflow/money_rate/already_money_rate_list.xml',
	     loadMode:'ajax',
	     isPage:true,
	     isFit:true,
	     border:true,
	     windowTop:10,
	     checkType:'combox',
	     afterShowWindowCallBack:function($form){
	        if(!editor){
				editor = KindEditor.create('textarea[name="content"]', {
					allowFileManager : false,
					allowImageRemote:false,
					items:[
					        'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
					        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
					        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
					        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
					        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
					        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
					        'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
					        'anchor', 'link', 'unlink'/*, '|', 'about'*/
					],
					uploadJson       :'${pageContext.request.contextPath}/acl/uploadNoticeFile.acl'
				});
	        }
		editor.html($form.find('textarea[name="content"]').val());
     },
     beforeSubmitData:function($form,params){
    	 var content = editor.html().replace(/(\r|\n)/gim,"");
    	 params["content"]= content;
     },
     isNewLineQueryButton:true,
     queryButtonColSpan:4,
     params:{
	     adjustid:"${requestScope['fund_standard_interest.id'] }"
	     },
     columns:[
			{header:'id',name:'id',hidden:true},
			{header:'proj_id',name:'proj_id',hidden:true},
			{header:'custid',name:'custid',hidden:true},
			{header:'合同号',name:'contractid'},
			{header:'docid',name:'docid',hidden:true},
			{header:'业务合同号',name:'contractnumber'},
			{header:'客户名',name:'custname'},
			{header:'经销商',name:'custdealer'},
			{header:'设备款',name:'equipamt'},
			{header:'首付款',name:'firstpayment'},
			{header:'还租次数',name:'incomenumber'},
			{header:'付租类型',name:'incomenumberyear'},
			{header:'付租方式',name:'periodtype'},
			{header:'起租日期',name:'startdate'},
			{header:'利率',name:'yearrate'},
			{header:'内部收益率',name:'irr'},
			{header:'调息前利率',name:'rateoriginal'},
			{header:'调息后利率',name:'rateadjust'},
			{header:'调息前内部收益率',name:'oldirr'},
			{header:'调息后内部收益率',name:'newirr'},
			{header:'操作',align:'center',renderer:comparetmp}
			    ]
	 });
});
function comparetmp(value,tableObj,columnName,columnIndex,rowData){
     var base3 = "<a href='#' onclick='previewtmp("+JsonUtil.encode(rowData)+")'>对比</a>";
     return base3; 
  }
function previewtmp(data){
   //var $previewDetailInfoWindowContainer = jQuery("#id_previewDetailInfoWindowContainer");
   // $previewDetailInfoWindowContainer.show();
   //var $previewDetailInfo = jQuery("#id_previewDetailInfo");
   //$previewDetailInfo.html(content);
   // $previewDetailInfoWindowContainer.window({top:20});
   //$previewDetailInfoWindowContainer.window('open');

   var URL = "${pageContext.request.contextPath}/leasing/query/condition_his/interestCompare.bi";
   var params = {contractid:data.contractid,docid:data.docid,read_only :false};
   openFullScreenWindow(URL,params);
}

</script>