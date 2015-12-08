<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
       // var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
       // var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
        var base3 = "<a href='#' onclick='openoverdue(\""+rowData.id+"\")'>编辑</a>";
        return base3; 
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
	    var test=new tracywindyMultiTable({
	    renderTo:'projcreditreport',
	    width:formWidth,
	    height:250,
	    tools:'删除',
	    otherTools:('undefined'==typeof(tooldata)) ? "" :tooldata,
	    isFit:true,
	    isNeedTools:true,
	    datas:JsonUtil.decode('${empty json_word_list_str ? "[]" : json_word_list_str }'),
	    //datas:[{id:11,filename:111}],
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
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-report"></div>法人客户信审报告</td>
          </tr>
          <tr class="tr-proj-credit-report tr-even">
          <td>
          <div id="projcreditreport"></div>
          </td>
         </tr>         
   </table>