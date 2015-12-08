<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
        // var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
        var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
        var base3 = "<a href='#' onclick='openoverdue(\""+rowData.id+"\")'>编辑</a>";
        return base3+"    &nbsp;&nbsp;   "+base2; 
     }

    function downloadFile(Id)
    {
      attachmentDown({url:"/leasing/template/downLoadAttachById.action",id:Id,returnType:'file'});
    }
    
    function openoverdue(id){
    	var currentPageClientWidth  =  document.documentElement.clientWidth;
    	var currentPageClientHeight =  document.documentElement.clientHeight;
    	window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',"height="+currentPageClientHeight+",width="+currentPageClientWidth +",top=0,left=0") ;
    }
    jQuery(function(){
	    new tracywindyMultiTable({
	    renderTo:'projcreditreport',
	    width:formWidth,
	    height:250,
	    tools:'删除',
	    otherTools:[{
	     	 html : '<font color="blue">生成天行健费用结算表</font>',
	 		handler : function(table) {
	 				createTemFile();
	 		},
	 		iconCls : 'icon-update'
	    },{
	     	 html : '<font color="blue">生成天行健账户登记表</font>',
		 		handler : function(table) {
		 				createTemFile2();
		 		},
		 		iconCls : 'icon-update'
		    }],
	    isFit:true,
	    isNeedTools:true,
	    datas:JsonUtil.decode('${empty json_word_list_str ? "[]" : json_word_list_str }'),
	    columns:[
	       {name:'id',  header:'id',type:'text',hidden:true},
	       {header:'文件名称',name:'filename'},
	       {header:'文件生成时间',name:'createdate'},
	       {header:'操作',name:'create',renderer:showOperator}
	      // {name:'templateshowname',  header:'协议文本',type:'text', renderer:showContractFile}
	     ]
	 	});
    });
    </script>
   
 <table cellspacing="0" cellpadding="0">
     <tr>
        <td class="x-panel-table-div-title" colspan=4>
        <div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-report"></div>
                            天行健费用核对模版</td>
     </tr>
     <tr class="tr-proj-credit-report tr-even">
     <td>
     <div id="projcreditreport"></div>
     </td>
    </tr>         
</table>
   
   <script type="text/javascript">
 	//租赁物信息获取
    var currentTableRent = getTracywindyObject('table_id_table_leasing_proj_equip_container');
	var tabledataRent=currentTableRent.getRowsData();
	var num=0;
	var chassisnums ="";
	var isaffiliateds ="";
	var tablelength =  tabledataRent.length;
	for (var i=0;i<tablelength;i++){
		 
		//取车辆分类
		var equipclass= tabledataRent[i].equipclass;
		if( equipclass != "equip_class_2"){
			//取车架号
			var  chassisnum = tabledataRent[i].chassisnum;
			chassisnums+= (i+1)+"、"+chassisnum+"\n";
			
			num++;
		}
		var isaffiliated = tabledataRent[i].isaffiliated;
		var affiliatedinfo = tabledataRent[i].affiliatedinfo;
		if(isaffiliated == "0"){//是挂靠
			isaffiliateds = affiliatedinfo;
		}
	 }
   function createTemFile(){
		var currentTablelist = getTracywindyObject('table_projcreditreport');
		var tabledata11=currentTablelist.getRowsData();
		for(var i=0;i<tabledata11.length;i++){
			if(tabledata11[i].filename=='天行健费用结算表.doc')
			{
			  alert(tabledata11[i].filename+"已经生成");
			  return false;
			}
		}

	    var url="/leasing/template/createFileByTemplateClass.action";
	    var filename='table_projcreditreport';
	    attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.201501'
	    	,returnType:'listtocurpaget',modelname:'contractNotice'
	    	,"contract_equip.cartotal":num
	    	,"contract_equip.caror":isaffiliateds
	    	,"contract_equip.chanum":chassisnums
	    	 });
	 }
   function createTemFile2(){
		var currentTablelist = getTracywindyObject('table_projcreditreport');
		var tabledata11=currentTablelist.getRowsData();
		for(var i=0;i<tabledata11.length;i++){
			if(tabledata11[i].filename=='天行健账户登记表.doc')
			{
			  alert(tabledata11[i].filename+"已经生成");
			  return false;
			}
		}

	    var url="/leasing/template/createFileByTemplateClass.action";
	    var filename='table_projcreditreport';
	    attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.201502'
	    	,returnType:'listtocurpaget',modelname:'contractNotice'
    		,"contract_equip.cartotal":num
	    	,"contract_equip.caror":isaffiliateds
	    	,"contract_equip.chanum":chassisnums
	    	 });
	 }
   
  </script>