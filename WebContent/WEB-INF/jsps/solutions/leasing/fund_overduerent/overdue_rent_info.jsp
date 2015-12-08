<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 租金催收</title>
    <!--css sheet-->
    <%@include file="/base/mini.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
	
<script type="text/javascript">
    function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	
	jQuery(function(){
		//alert("==");
		 //  var editWindow = mini.get("id_riskInfoWindowContainer");
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable){
			new ApTable({
				      renderTo:'id_tableContainer',
				      title:'租金催收',
             width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
             height:parseInt("${param.tableHeight}")||pageHeight,
               id:'id_table',
                   pageSize:20,
                   windowTop:20,
				    showPager:true, 
				  showFooter:false,
				    showToolbar:false,
				    hiddenQueryArea : false,
				    //editFormPopupWindowWidth:580,
				   // lockedNames:['custname'],
				    xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_info.xml',
					//multiSelect : true,//是否可以多选，true多选，false为单选,
				     columns:[
                 /* {type:'indexcolumn'}, */
                  {type:'checkcolumn'},
                  {header:'id',field:'id',visible:false},
		            {header:'客户名称',field:'custname',
                	  renderer:showOverdueName,
                	  width:180,queryConfig:{
                		  width:150
                	  }},
		            {header:'合同号',field:'contractid'},
		            {header:'合同状态',field:'contractstatusname'},
		            {header:'催款员',field:'dun'},
		            {header:'事业部',field:'projdeptname'},
		            {header:'省份',field:'provincename'},
		            {header:'身份证/组织机构代码',field:'idcardorcode',width:140},
		            {header:'经销商',field:'dealername',width:200,queryConfig:{
		            	width:150
		            }},
		            //{header:'项目经理',name:'projmanagename',width:200},
		            {header:'逾期期数',field:'overnum-'},
		            {header:'逾期租金',field:'overrent',
		            	queryConfig:{
		            		type:"float",
		            		range:true,
		            		width:150
		            	}},
		            {header:'逾期利息',field:'overinterest'},
		            {header:'逾期罚息',field:'penalty-'},
		            {header:'逾期天数',field:'column14-'},
		            //{header:'累计逾期数',name:'column16'},
		            {header:'留购价款',field:'nominalprice'},
		            {header:'总期数',field:'incomenumber'},
		            {header:'联系方式',field:'liaisonwayname'},
		            {header:'起租日',field:'startdate',queryConfig:{
		            	type:'date',
		            	vtype:'date',
		            	range:true,
		            	newLine:true,
		            	width:150,
		            	format:'yyyy-MM-dd'
		            }},
		            {header:'本金余额/剩余还款期数',field:'corpusorresiduenum'},
		            {header:'下一次联系日',field:'nextliaisondate'},
		            {header:'最近一次付款金额/时间',field:'rentordate',width:170},
		            {header:'催收日',field:'liaisondate'},
		            {header:'承诺还款日',field:'paydate',queryConfig:{
		            	type:'date',
		            	vtype:'date',
		            	range:true,
		            	
		            	width:150,
		            	format:'yyyy-MM-dd'
		            }},
		            {header:'承诺还款金额',field:'paymoney'},
		            {header:'担保人',field:'assurors'},
		            {header:'担保人联系方式',field:'assurorsnum'},
		            {header:'承租人邮寄地址',field:'mailadd',width:140},
		            {header:'逾期天数',field:'overduedate',queryConfig:{
		            	type:'number',
		            	vtype:'int',
		            	width:150,
		            	newLine:true,
		            	//minValue:1,
		            	maxValue:1000,
		            	range:true
		            }},
		            {header:'台数',field:'equipcount',queryConfig:{
		            	type:'number',
		            	vtype:'int',
		            	width:150,
		            	//newLine:true,
		            	//minValue:1,
		            	maxValue:1000,
		            	range:true
		            }},
		            {header:'风险级别',field:'overduetypename',width:140,queryConfig:{
		            	type:'combobox',
		            	width:150,
		            	//colspan:1,
		            	//rowspan:2,
		            	//dataField:"datas",
		            	valueField:"name" ,
		            	textField:"name" ,
		            	newLine:true,
		            	params:{
		            		xmlFileName:'\\combos\\comboDict.xml',
		            		pid:'contract_risk_adjust_type'
		            	}
		            }}
                  
		  		   ]
			});
			
		});
		
});
	
	
function showOverdueName(e){
    	  var rowData=e.record; 
    	
    	  var base = "<a href='#' onclick=showoverdueInfo('"+rowData.custid+"','"+rowData.contractid+"')>{1}</a>{2}";
    	  var separator = "&nbsp;&nbsp;";
          var updateFlag=rowData.custname;
          var updateClickFunc="other";
          var field=base.replace("{1}",updateFlag).replace("{2}",separator);
         // alert(field);
          return field;
      };
	    
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
  // });
	 function showoverdueInfo(custid,contractid){
	    	var URL = "${pageContext.request.contextPath}/leasing/fund_overduerent/show_template.bi";
	    	var params = {cust_id:custid,contract_id:contractid,jsp:"overdue_rent_detail_info"};
		    openFullScreenWindow(URL,params);
	        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	    }

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>