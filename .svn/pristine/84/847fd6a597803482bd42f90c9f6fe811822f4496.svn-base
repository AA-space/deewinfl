<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
    function downloadFile(Id)
    {
      attachmentDown({returnType:'file',url:"${pageContext.request.contextPath}/leasing/template/downLoadAttachById.action?id="+Id});
    } 
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
         var base = "<a href='javascript:void(0);' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
         var base2 = "<a href='javascript:void(0);' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
         var base3 = "<a href='javascript:void(0);' onclick='editoverdue(\""+rowData.id+"\")'>编辑</a>";
         return base2+"&nbsp;&nbsp;|&nbsp;&nbsp;"+base3; 
      }
      
    function openoverdue(id){
    	var currentPageClientWidth  =  document.documentElement.clientWidth;
    	var currentPageClientHeight =  document.documentElement.clientHeight;
    	window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',"height="+currentPageClientHeight+",width="+currentPageClientWidth +",top=0,left=0") ;
    }
    jQuery(function(){
    	isViewHistoryTask = false;
	    var test=new tracywindyMultiTable({
	    renderTo:'id_table_leasing_xieyi_info',
	    width:formWidth,
	    height:250,
	    tools:'删除',
	    otherTools:[{
       	 html : '<font color="blue">生成协议报告 </font>',
				handler : function(table) {
						createTemFile();
				},
				iconCls : 'icon-update'
        }
	    /* ,{
          	 html : '<font color="blue">生成部分买断协议报告 </font>',
				handler : function(table) {
						createTemFile2();
				},
				iconCls : 'icon-update'
     	} */
	    ],
	    isFit:true,
	    isNeedTools:true,
	    datas:JsonUtil.decode('${empty json_word_list_str ? "[]" : json_word_list_str }'),
	    columns:[
	       {name:'id',  header:'id',type:'text',hidden:true},
	       {header:'文件名称',name:'filename'},
	       {header:'文件生成时间',name:'createdate'},
	       {header:'操作',name:'create',renderer:showOperator}
	     ]
	 	});
	    isViewHistoryTask = window.isViewHistoryTask;
    });
    </script>
   
   <script type="text/javascript">
   
   function createTemFile(){
	   var corpusoverage = parseFloat($("#corpusOverage").val()).toFixed(2);//买断本金
	   var handlingCharge = parseFloat($("#handlingCharge").val()).toFixed(2);//违约手续费
	   var currentcautionmoney = parseFloat($("#currentcautionmoney").val()).toFixed(2);//抵扣保证金
	   var chae = parseFloat(corpusoverage,2)-parseFloat(currentcautionmoney,2)+parseFloat(handlingCharge,2);//保证金抵扣后，乙方还应向甲方支付=买断本金-抵扣保证金+违约手续费
	   var url="/leasing/template/createFileByTemplateClass.action";
	   var filename='table_id_table_leasing_xieyi_info';
	   attachmentDown({uploadid:filename,url:url,returnType:'listtocurpaget',title:"",flowunid:flowUnid
		   ,"total.chae":chae
		   ,"fund_rent_adjust.corpusoverage":corpusoverage
		   ,"fund_rent_adjust.handlingCharge":handlingCharge
		   ,"fund_rent_adjust.currentcautionmoney":currentcautionmoney
		   ,"contract_signatory.leaseperson":"${requestScope['law_d'] }"
		   ,twoClassify:'wordtempletypetwoxieyi01'
		   ,modelname:'id_table_leasing_xieyi_info'});
	 }
   function createTemFile2(){
	   var chae = $("#deductible").val()-$("#currentcautionmoney").val();// 剩余保证金- 本次抵扣保证金
	   var url="/leasing/template/createFileByTemplateClass.action";
	   var filename='table_projcreditreport';
	   attachmentDown({uploadid:filename,url:url,returnType:'listtocurpaget',title:"",flowunid:flowUnid
		   ,"total.chae":chae
		   ,twoClassify:'wordtempletypetwoxieyi02'
		   ,modelname:'creditreport'});
	 }
   
   </script>