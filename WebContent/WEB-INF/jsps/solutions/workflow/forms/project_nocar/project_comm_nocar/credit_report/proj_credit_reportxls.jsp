<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/base/mini.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask_single.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
<title>租赁物件</title>
<%
	String prefix = "${pageContext.request.contextPath}/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=";
	String custid=request.getParameter("custid");
	//String custname=java.net.URLDecoder.decode(request.getParameter("custname"),"utf-8").toString();
%>
</head>
<body>
<div class="mini-panel" title="法人客户信审报告" showCollapseButton="true" style="width: 100%;">
    <!-- 按钮操作 -->
    <div class="mini-toolbar miniext-toolbar-top" id="projEquipForm1">
        <table class="miniext-form-fit">
            <tr>
	            <td>
	            	<input type="hidden" id="json_word_list_str" 	name="json_word_list_str" value='${empty json_word_list_str ? "[]" : json_word_list_str }'></input>
	                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addReportxlsRow">生成法人客户现场考察报告</a>
	                <span class="separator"></span>
	                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeReportxlsRow">删除</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--grid展示--撑满页面-->
    <div id="reportxlsgrid" class="mini-datagrid" style="width:100%;height:250px;" 
        sizeList="[5,10,20,50]" pageSize="10"  idField="id"
	     allowResize="true" showColumnsMenu="true"
	     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
	     allowCellValid="true"
     >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div field="filename"  width="120" headerAlign="center">文件名称
                </div>  
                <div field="createdate"  width="120" headerAlign="center" renderer="onDateRenderer">文件生成时间
                </div> 
                <div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">操作</div>
            </div>
        </div> 
    </div>
</body>
</html>
<script>
mini.parse();
var grid = mini.get("reportxlsgrid");
var temp = parent.document.getElementById("id_json_word_list_str").value;  
var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
grid.setData(mini.decode(temp));
//控制只读页面
if (isViewHistoryTask == "true") {
	grid.disable();
	$("#projEquipForm1").hide();
}
//调用返回到主页面
function returnTab(){
	return grid;
}
//格式化日期
function onDateRenderer(e) {
    return miniui_ext.onDateRenderer(e);
}
function onActionRenderer(e) {
    var grid = e.sender;
    var record = e.record;
    var uid = record._uid;
    var rowIndex = e.rowIndex;
    var s = ' <a class="Edit_Button" href="javascript:openoverdue(\'' + record.id + '\')" >编辑</a>'
    		+ ' <a class="Add_Button" href="javascript:downloadFile(\'' + record.id + '\')" >下载</a>';
    return s;
}
	function addReportxlsRow() {
		var reportxlsgrid = mini.get("reportxlsgrid");
		var tabledata11=reportxlsgrid.getData();
		for(var i=0;i<tabledata11.length;i++){
				if(tabledata11[i].filename=='信审报告.doc')
					{
					  alert(tabledata11[i].filename+"已经生成");
					  return false;
					}
		}
	    var d=new Date();
	    //alert(d.getFullYear());
		var currentTable2 = parent.document.getElementById("id_json_proj_equip_str").value;  
	   // alert(currentTable2.getRowsData().length);
		
	    var currentTable1 = parent.document.getElementById("id_json_proj_guarantee_detail_str").value;
		//alert(JsonUtil.encode(currentTable1.getRowsJsonData()));
				var tabledata=mini.decode(currentTable1);
				var assurorname="('";
				for(var i=0;i<tabledata.length;i++){
					assurorname+=tabledata[i].assurorname;
					 if(i<tabledata.length-1)
			 		  {
			 			assurorname+="','";
			 		   }
			 		}
			 		assurorname+="')";
				//alert(assurorname);
	    
	   var url="/leasing/template/createFileByTemplateClass.action";
	   var filename="reportxlsgrid";
	   var flowunid=parent.document.getElementById("id_flow_unid").value;
	   attachmentDown2({uploadid:filename,url:url,title:"",flowunid:flowunid,twoClassify:'wordtempletypetwo.2112',returnType:'listtocurpaget',modelname:'creditreport',assurorname:assurorname,projectid:jQuery("#project_id").val(),"framework_condition.equipnum":mini.decode(currentTable2).length,"framework_condition.date":d.getFullYear()});
	}
	function removeReportxlsRow() {
		var Reportxlsgrid = $mini("reportxlsgrid");
	    var rows = Reportxlsgrid.getSelecteds();
	    if (rows.length > 0) {
	    	Reportxlsgrid.removeRows(rows, true);
	    }
	}
	function $mini(id){
    	return mini.get(id);
    } 
</script>

    <script language="javascript">
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
       // var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
       // var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
        var base3 = "<a href='#' onclick='openoverdue(\""+rowData.id+"\")'>编辑</a>";
        return base3; 
     }

    function downloadFile(Id)
    {
      attachmentDown2({url:"/leasing/template/downLoadAttachById.action",id:Id,returnType:'file'});
      
     }
    
    function openoverdue(id){
    	var currentPageClientWidth  =  document.documentElement.clientWidth;
    	var currentPageClientHeight =  document.documentElement.clientHeight;
    	window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',"height="+currentPageClientHeight+",width="+currentPageClientWidth +",top=0,left=0") ;
    }
//     jQuery(function(){
// 	    var test=new tracywindyMultiTable({
// 	    renderTo:'projcreditreport',
// 	    width:formWidth,
// 	    height:250,
// 	    tools:'删除',
// 	    otherTools:('undefined'==typeof(tooldata)) ? "" :tooldata,
// 	    isFit:true,
// 	    isNeedTools:true,
// 	    datas:JsonUtil.decode('${empty json_word_list_str ? "[]" : json_word_list_str }'),
//	    datas:[{id:11,filename:111}],
// 	    columns:[
	       
//	      {name:'templateshowname',  header:'协议文本',type:'text', renderer:showContractFile}
// 	     ]
// 	 	});
//     });
    </script>
