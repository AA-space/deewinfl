<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量罚息减免</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript"> 
//var proj_id="<%= request.getParameter("id")%>";
var param={};
//if(proj_id!="null" || proj_id==""){param.proj_id=proj_id;}
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	var attachmentParams;
	jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'[合同信息]',
		 constantFlagTable:'ProjInfo',
		 windowTop:20,
	     border:true,
	     id:'id_table',
      renderTo:'id_tableContainer',
      title:'合同信息',
      width:parseInt("${param.tableWidth}")||pageWidth,
      height:parseInt("${param.tableHeight}")||pageHeight,
      id:'id_table',
      xmlFileName:'\\eleasing\\workflow\\penalty\\contract_fund_charge_incom_list.xml',
      loadMode:'ajax',
      checkType:'checkbox',
      params:{
    	  		CONTRACT_STATUS_GreaterThan : '31', 
				CONTRACT_STATUS_LessThan:'71',
				hasMoney : "1",
				palndate_end : getCurDate(),
				dealer_id:"${sessionScope['currentDealerCustInfoId']}"
			},
      isPage:true,
      operButtons:' ',
      isFit:false,
      isExcel:true,
      tools:[{
     	 html : '<font color="red">批量罚息减免</font>',
		 handler : function(table) {
			 
			
				var projIDValue = table.getCheckedRowDatas();
				if ( 0 == projIDValue.length ) {
					alert( "请选择需要启动的流程！" );
					return false;
				}
				var pnum = 21;
				if ( pnum <= projIDValue.length )
				{
					alert( "选择操作的条数不能大于20条！" );
					return false;
				}
				var cid = "";
				for ( var i = 0; i < projIDValue.length; i++ ) 
				{
					cid += "'" + projIDValue[i].id + "',";
				}
				cid = cid.substring(-1,cid.lastIndexOf(","));
				//console.log(cid);
				cid=encodeURI(cid);
				attachmentParams = "&contract_id=" + cid ;
				startProcess("批量罚息减免流程-1", attachmentParams);
				table.reload();
			},
			iconCls :'icon-update'
          } ],
      columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'proj_id',name:'proj_id',hidden:true},
		            {header:'pid',name:'pid',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'typecode',name:'typecode',hidden:true},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',width:200,queryConfig:{}},
		            {header:'客户名称',name:'custname'},
		            {header:'应收租金',name:'receivablerent'},
		            {header:'应收罚息',name:'sjpenalty'},
		            {header:'结束时间',name:'pdate',  type:"date",isRange:true,queryConfig:{isNewLine:true}},
		            {header:'是否卡扣',name:'kakou',type:'combobox',queryConfig:{
			 		       loadMode:'local',
			 		       datas:[{title:'是',name:'0'},{title:'否',name:'1'}],
			 		       isAjaxLenovo:true,    
			 		       width:150,
			 		       name:'kakou',
			 		       displayField:'title',
			 		       valueField:'name',
			 		       readOnly:false
			            }}
      ]
	 });
});
	
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
    
    <div id="id_message_list" style="width: 420px; display: none; overflow: hidden;" title="请填写需要撤销合同的期次">
		<table class="fillTable">
			<tr class="tr-odd" style="display: none">
				<input type="text" hidden="true" id="cid" name ="cid"/>
			</tr>
			<tr class="tr-even">
			<td class="td-content-title">业务合同号：</td>
			<td class="td-content">
			<input id="contractnumber" name="contractnumber" class="td-content-input td-content-readonly" type="text" readOnly/>
			</td>
			</tr>
			<tr class="tr-odd">
			<td class="td-content-title">期次：</td>
			<td class="td-content">
			<input id="rentlist" name="rentlist" onclick="Contractshow();" class="td-content-input" maxlength="4" dataType="Number" type="text" />
			</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center">
					<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='confirmData();'><span>确定</span></a>
					<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_message_list").window("close");'><span>取消</span></a>
				</td>
			</tr>
	 </table>
	</div>
    <script type="text/javascript"> 
    	function confirmData(){
    		var id_table = getTracywindyObject("id_table").getRowsData();
    		var rentlist = jQuery("#rentlist").val();
   		    if( !/^[0-9]*$/.test(rentlist) ){
   		         alert("填写期次请输入数字!");
	   		     jQuery("#rentlist").val("");
	   		     jQuery("#rentlist").focus();
   		    	return false;
   		    }
    		var cid="'"+id_table[0].id+"'";
    		var url = "${pageContext.request.contextPath}/leasing/checkPenaltyInfo.action";
				var params = {contract_id:cid,rentlist:rentlist};
				 ajaxRequest({
			    	 method:'POST',
			         url:url,
			         params:params,
			         failure:function(res){},
			         success:function(res)
			         {
	 			 	   		res=res.responseText;
	 			 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	 			     	    if(res != '')
	 			     	    {
	 			     	    	if( res =="yes")
			     	    		{
			     	    			alert("撤销成功!");
			     	    		}else{
			     	    			alert("撤销失败!");
			     	    		}
	 			     	    	jQuery("#id_message_list").window("close");
	 			     	    	getTracywindyObject("id_table").reload();
	 			     	    }
	 			  }
			    });
    	}
    	function Contractshow(){ 
    		var id_table = getTracywindyObject("id_table").getRowsData();
    		jQuery("#contractnumber").val(id_table[0].contractnumber);
        }
     
    </script>
</body>
</html>