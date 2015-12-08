<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
       // var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
        //var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
        var base3 = "<a href='#' onclick='openoverdue(\""+rowData.id+"\")'>编辑</a>";
        return base3; 
     }
    
    function openoverdue(id){
    	var currentPageClientWidth  =  document.documentElement.clientWidth;
    	var currentPageClientHeight =  document.documentElement.clientHeight;
    	window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',"height="+currentPageClientHeight+",width="+currentPageClientWidth +",top=0,left=0") ;
    }
    jQuery(function(){
    	isViewHistoryTask = false;
	    var test=new tracywindyMultiTable({
	    renderTo:'projcreditreport',
	    width:formWidth,
	    height:250,
	    tools:'删除',
	    isFit:true,
	    isNeedTools:true,
	    datas:JsonUtil.decode('${empty json_word_list_dealer ? "[]" : json_word_list_dealer }'),
	    columns:[
	       {name:'id',  header:'id',type:'text',hidden:true},
	       {header:'文件名称',name:'filename'},
	       {header:'文件生成时间',name:'createdate'},
	       {header:'操作',name:'create',renderer:showOperator}
	      // {name:'templateshowname',  header:'协议文本',type:'text', renderer:showContractFile}
	     ]
	 	});
	    isViewHistoryTask = window.isViewHistoryTask;
    });
    </script>
   
 <table cellspacing="0" cellpadding="0">
        <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-proj-credit-report">
             </div>经销商合同</td>
          </tr>
          <tr class="tr-proj-credit-report tr-even">
          <td>
          <div>
       	<a href="javascript:void(0);" onclick="createTemFile1()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>经销商授信额度调减通知函 </font></a>
		<a href="javascript:void(0);" onclick="createTemFile2()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>经销商授信额度调增通知函 </font></a>
		<a href="javascript:void(0);" onclick="createTemFile3()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>融资租赁业务合作协议(经销商适用) </font></a>
		<a href="javascript:void(0);" onclick="createTemFile4()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>最高额保证担保函（经销商适用） </font></a>
		<a href="javascript:void(0);" onclick="createTemFile5()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>最高额保证担保函(经销商自然人股东适用) </font></a>
		<a href="javascript:void(0);" onclick="createTemFile6()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>法定代表人证明书</font></a>
		<a href="javascript:void(0);" onclick="createTemFile7()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>股东会成员签章样本</font></a>
		<a href="javascript:void(0);" onclick="createTemFile8()" class="btn btn-primary" iconCls="icon-update" plain="true"><font>股东会决议</font></a>
		</div>
          <div id="projcreditreport">
          </div>
          </td>
         </tr>         
   </table>