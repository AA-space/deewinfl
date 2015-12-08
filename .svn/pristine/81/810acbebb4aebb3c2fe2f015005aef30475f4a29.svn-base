<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自然人客户 - 自然人客户</title>   
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBoxCust.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MustFillIn.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/custType.js"></script>
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	   td.td-content{
	     text-align:left;
	   }
	   td.td-content input{
	      width:165px;
	      float:left;
	      border:1px solid #DDD;
	   }
	   td.td-content textarea{
	      width:90%;
	      overflow:auto;
	      float:left;
	      border:1px solid #DDD;
	   }
	</style>
<script type="text/javascript">
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var operButtons='';
</script >
<permission:action  code="cust_add_update">
<script type="text/javascript">
isAdmin=true;
operButtons='新增|修改';
</script >
</permission:action>
<permission:action  code="admin_action">
<script type="text/javascript">
isAdmin=true;
operButtons='新增|修改|删除|状态';
</script >
</permission:action>
<script type="text/javascript">
var constantFlagTable = "User";
var user_id="${sessionScope.loginUser.id}";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;


function changeCustType(){//选择客户类别联动校验函数
	MustFillIn.cancelRequireAll(document.getElementById("id_detailInfoForm"));//清除所有必填
	var tempStr=getTracywindyObject("id_combo_custtypename").getValue();
	if(tempStr!=""){
		var checkLis=tempStr.split(",");
		for(var i=0;i<checkLis.length;i++){
			//此处需要和数据字典中的值关联起来 如果增加数据字典想需要在此增加设置
			cust_type=custType.getCheckField("ewlp",checkLis[i]);
			MustFillIn.setRequire(cust_type);
		}
		MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));
	}else{//当没有勾选时必须填写名字和客户类别,经销商,部门
		MustFillIn.setRequire(["custname","rawValue_custtype","rawValue_creatordept","rawValue_dealerorcompany"]);
		MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));
	}
}

jQuery(function(){
	//构建页面中的combox
	//客户类别
	var custtype = new tracywindyComboBoxCust({
		lazyLoad:true,
	       id:'id_combo_custtypename',
	       renderTo:'custtype',
	       xmlFileName:'\\combos\\comboDict.xml',
	       loadMode:'ajax',
	       readOnly:true,
		   isContainEmpty:false,
		   otherAttributes:'require="true" label="客户类别"',
	       name:'custtype',
	       width:510,
	       displayField:'name',
	       valueField:'code',
	       leftAdd:0,
	       loadComplete:changeCustType,
	       value:'cust_type.cust',
	       isCheck:true,
	       params:{
	          pid:'cust_type'
	       },
		   onSelect:changeCustType
	    });
	dictSexByCode('sexname','sex','','','',' require="true" label="性别"');

	dictOnSelect('custkindname','custkind','cust_kind',null,null,' require="true" label="客户内部行业"');//客户内部行业
	dictOnSelect('unitpositionname','unitposition','cust_jobposition',null,null,' require="true" label="职务"');//职务
	commonSelectOverall('provincename',"(select id,name from t_district where pid in('HB','DB','HD','HZ','XN','XB','HN','TQ')) rs",'id',"name",'province','','','require="true" label="省份"', function(combo,data){ choseNext(combo,'id_combo_cityname','t_district');},true);//省份
	commonSelectOverall('cityname',"(select id,name from t_district where 1=2) rs",'id',"name",'city','','','require="true"  label="城市"', function(combo,data){ choseNext(combo,'id_combo_countyname','t_district');},true);//城市
	commonSelectOverall('countyname',"(select id,name from t_district where 1=2) rs",'id',"name",'county','','','require="true"  label="区县"',function(combo,data){
    $("#id_mailadd").val(getTracywindyObject("id_combo_provincename").getRawValue()+getTracywindyObject("id_combo_cityname").getRawValue()+combo.getRawValue());
		},true);//地区
	dictYesOrNoByCode('draftname','draft',null,null,null,'require="true" label="是否草稿"');//是否草稿
	dictOnSelect('custethnicname','custethnic','root_ethnic',null,null,'require="true"  label="民族"',false,null,false);//民族
	dictOnSelect('id_school','school','school',null,null,'require="true"  label="学历"');//学历
	dictOnSelect('id_maritalstatus','maritalstatus','marital_status',null,function(combo){
		if(combo.getValue()=='married'&&getTracywindyObject("id_combo_custtypename").getValue().indexOf("cust_type.cust") > -1)
		{
			custType.ewlpCust.push("spousename");
			custType.ewlpCust.push("spouseidcardno");
			//alert(custType.ewlpCust);
			changeCustType();
			custType.ewlpCust.pop();
			custType.ewlpCust.pop();
		}else{
			changeCustType();
		}
		//alert(custType.ewlpCust);
		},'require="true" label="婚姻状况"');//婚姻状况
	dictHadOrNoByCode('id_spousechild','spousechild',null,null,null,'require="true" label="有无子女"');//有无子女
	new tracywindyComboBox({
		id : 'id_combo_dealerorcompany',
		width : 167,
		renderTo : 'dealerorcompany',
		xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelect.xml',
		loadMode : 'ajax',
		readOnly : false,
		isAjaxLenovo : true,
		otherAttributes:'require="true"  label="经销商"',
		topAdd : 0,
		leftAdd : 0,
		positionDropIconLeftAdd : -1,
		name : 'dealerorcompany',
		displayField : 'name',
		valueField : 'id',
		value:"${sessionScope['currentDealerCustInfoId']}",
		rawValue:"${sessionScope['currentDealerCustInfoName']}",
		params : {
			cust_class:'CUST_INFO_DEALER',
			cooperate_status:'dealer_symbiosis1',
			dealer_id:"${sessionScope['currentDealerCustInfoId']}"
		},onSelect:changeDealerInfo
		
	});
	function changeDealerInfo()
	{
		if ( getTracywindyObject("id_combo_dealerorcompany").getValue()!="")
		{
			if(window.confirm("您是否确认选中的经销商为该经销商下的客户？"))
			{
				var custid=$("#custid").val();
				var tempStr=getTracywindyObject("id_combo_dealerorcompany").getValue();//新下拉选中经销商id
				var url = "${pageContext.request.contextPath}/leasing/checkDealerPersonInfo.action";
				var params = {dealerid:tempStr,custid:custid};
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
			     	    			alert("下拉修改完毕后请单击确认!");
			     	    		}
	 			     	    	else if(res == "custidIsNull")
 			     	    		{
 			     	    			//新增
 			     	    			//alert("新增");
 			     	    		}
	 			     	    	else{
			     	    			alert("操作失败!");
			     	    		}
	 			     	    }
	 			  }
			    });
			}
		}
	}
	new tracywindyComboBox({
		id : 'id_combo_creatordept',
		width : 167,
		renderTo : 'creatordeptname',
		xmlFileName : '\\eleasing\\workflow\\public\\department_combox.xml',
		loadMode : 'ajax',
		readOnly : false,
		isAjaxLenovo : true,
		otherAttributes:'require="true" label="登记人部门"',
		topAdd : 0,
		leftAdd : 0,
		positionDropIconLeftAdd : -1,
		name : 'creatordept',
		displayField : 'name',
		valueField : 'id',
		value:"${sessionScope['loginUserDeptObj'].id}",
		rawValue:"${sessionScope['loginUserDeptObj'].name}",
		params : {
			dealer_id:"${sessionScope['currentDealerCustInfoId']}"
		}
		
	});
	
	

	 var table = new tracywindyOperationTable({
   		 resetFormCallback:function(table,$form,operFlag){
			if("add" == operFlag){
				//客户类型为承租人时不能修改
				getTracywindyObject("id_combo_custtypename").isDisabled=false;
				getTracywindyObject("id_combo_custtypename").setValue("cust_type.cust");
				getTracywindyObject("id_combo_draftname").readOnlyData = false;
   	   	  		getTracywindyObject("id_combo_draftname").reload();
				getTracywindyObject("id_combo_draftname").setRawValue("否");
				getTracywindyObject("id_combo_draftname").setValue("1");

				getTracywindyObject("id_combo_custethnicname").setRawValue("汉族");
				
				jQuery("#invalidname").val("否");
				jQuery("#invalid").val("1");
				jQuery("#creatorname").val('${sessionScope.loginUser.realname}');

				getTracywindyObject("id_combo_custtypename").setValue("cust_type.cust");
				getTracywindyObject("id_combo_draftname").readOnlyData = false;
   	   	  		getTracywindyObject("id_combo_draftname").reload();

   	   	        getTracywindyObject("id_combo_dealerorcompany").setValue("${sessionScope['currentDealerCustInfoId']}");
   	   	        getTracywindyObject("id_combo_creatordept").setValue("${sessionScope['loginUserDeptObj'].id}");
				
			}  
			if ("update" == operFlag){
				//客户类型为承租人时不能修改
				getTracywindyObject("id_combo_custtypename").isDisabled=true;
		 			//changeCustType();//修改时加载必填

				}

			
			 			
  	     },
  		
  	  loadFormDataCallBack:function(table,$form,rowIndex){
			var rowData = table.getRowDataAt(rowIndex);
						 			var objMappingArr = [
			  			       			    {comboId:'custtypename',rowDataMapping:'custtype'},
			  			                    {comboId:'custkindname',rowDataMapping:'custkind'},
			  			                    {comboId:'sexname',rowDataMapping:'sex'},
			  			                	{comboId:'provincename',rowDataMapping:'province'},
		 			                    	{comboId:'cityname',rowDataMapping:'city',parentRowDataMapping:'province',tableName:'t_district'},
		 			                    	{comboId:'countyname',rowDataMapping:'county',parentRowDataMapping:'city',tableName:'t_district'},
			  			                    {comboId:'creatordept',rowDataMapping:'creatordept'},
			  			                 	{comboId:'custethnicname',rowDataMapping:'custethnic'},
			  			                    {comboId:'id_school',rowDataMapping:'school'},
			  			                    {comboId:'id_maritalstatus',rowDataMapping:'maritalstatus'},
			  			               	  	{comboId:'id_spousechild',rowDataMapping:'spousechild'},
			  			                	{comboId:'draftname',rowDataMapping:'draft'},
			  			               		{comboId:'unitpositionname',rowDataMapping:'unitposition'},
			  			               		{comboId:'dealerorcompany',rowDataMapping:'dealerorcompany'}
			  			                  ];
			 			for(var j=0;j<objMappingArr.length;j++){
			 			     var objMapping = objMappingArr[j];
			 			     var parentRowDataMapping = objMapping['parentRowDataMapping'];
			 			     var rowDataValue         = rowData[objMapping['rowDataMapping']];
			 			     var comboId   =  ("id_combo_"+objMapping['comboId']);
			 			     var currentCombo = getTracywindyObject(comboId);
			 			     if(parentRowDataMapping){
			 				     var parentRowDataMappingValue = rowData[parentRowDataMapping];
			 				     var tableName = objMapping['tableName'];
			 				     currentCombo.setParams({tableName:"(select id,name from "+tableName+" where pid='"+parentRowDataMappingValue+"') rs "}) ;
			 					 var loadCompleteFunc = (function(combo,rowDataValue){
			 						       return function(combo){
			 						    	   combo.setValue(rowDataValue);
			 							  };
			 					 })(currentCombo,rowDataValue);
			 					 currentCombo.loadComplete = loadCompleteFunc;
			 				}
			 			    else{
			 			    	currentCombo.setValue(rowDataValue);
			 			   }
			 			    currentCombo.reload();
			 			 }
			 			//changeCustType();//修改时加载必填
			 			if(getTracywindyObject("id_combo_draftname").getValue()=='1'){//不是草稿的时候不能修改
			 					//要求修改的时候也可以选择是否草稿
			    	   	  		//getTracywindyObject("id_combo_draftname").readOnlyData = true;
			    	   	  		//getTracywindyObject("id_combo_draftname").reload();
			 			}else{
			 				getTracywindyObject("id_combo_draftname").readOnlyData = false;
			    	   	  		getTracywindyObject("id_combo_draftname").reload();
			 			}
			     	 },
			     	 //2013-11-29 15:11 跟法人客户信息修改原因一样
  		 tableComment:'客户',
  		 constantFlagTable:'CustEwlp',
  		 windowTop:20,
  	     border:true,
        renderTo:'id_tableContainer',
        title:'自然人客户',
        width:parseInt("${param.tableWidth}")||pageWidth,
        height:parseInt("${param.tableHeight}")||pageHeight,
        id:'id_table',
        xmlFileName:'/eleasing/jsp/ewlp_cust/ewlp_info.xml',
        loadMode:'ajax',
        isPage:true,
        isFit:false,
        operButtons:operButtons,
        enabledPromit:'有效',
        disabledPromit:'无效',
        enabledDefaultValue:'1',
        isNeedEnabled:isAdmin,
        isAutoBreakContent:true,
        lockedNames:['custname'],
        columns:[
				{header:'客户名称',name:'custname',renderer:showCustName,width:180,queryConfig:{}},
	            {header:'id',name:'id',hidden:true},
	            {header:'客户编号',name:'custnumber',hidden:true},
	            {header:'经销商id',name:'dealerorcompany',hidden:true,width:120},
	            {header:'经销商',name:'dealerorcompanyname',queryConfig:{}},
	            {header:'身份证号码',name:'idcardno',width:120,queryConfig:{}},
	            {header:'民族',name:'custethnicname'},
	            {header:'性别',name:'sexname'},
	            {header:'出生年月',name:'brithdate'},
	            {header:'客户类别',name:'custtype',hidden:true},
	            {header:'客户类别',name:'custtypename',width:140,type:'combobox',
		            queryConfig:{
	               isNewLine:true,
	               width:165,
	 		       xmlFileName:'\\combos\\comboDict.xml',
	 		       loadMode:'ajax',
	 		       readOnly:true,
	 			   isContainEmpty:false,
	 		       name:'custtype',
	 		       displayField:'name',
	 		       valueField:'code',
	 		       leftAdd:0,
	 		       isCheck:true,
	 		       params:{
	 		          pid:'cust_type'
	 		       }


		            }},
	            {header:'获取驾照日期',name:'driverlicensedate'},
	            {header:'开户行',name:'taxbank',width:120},
	            {header:'开户账号',name:'taxacc',width:140},
	            {header:'客户内部行业',name:'custkindname'},
	            {header:'工作单位',name:'unitname'},
	            {header:'省份',name:'provincename'},
	            {header:'省份',name:'province',hidden:true},
	            {header:'城市',name:'cityname'},
	            {header:'城市',name:'city',hidden:true},
	            {header:'区县',name:'countyname'},
	            {header:'区县',name:'county',hidden:true},
	            {header:'户口所在地',name:'domicileplace'},
	            {header:'邮寄地址',name:'mailadd',width:160},
	            {header:'常住地址',name:'homeadd',width:160},
	            {header:'手机',name:'mobilenumber',queryConfig:{}},
	            {header:'电话',name:'phone'},
	            {header:'婚姻状况',name:'maritalstatusname'},
	            {header:'学历',name:'schoolname'},
	            {header:'配偶名称',name:'spousename'},
	            {header:'配偶联系方式',name:'spousecontact'},
	            {header:'配偶身份证号',name:'spouseidcardno',width:140},
	            {header:'配偶年龄',name:'spouseage'},
	            {header:'有无子女',name:'spousechildname'},
	            {header:'配偶工作单位',name:'spousework'},
	            {header:'职务',name:'unitpositionname'},
	            {header:'是否作废',name:'invalidname'},
	            {header:'是否草稿',name:'draftname',type:'combobox',
		            queryConfig:{
					colSpan:3,
					width:165,
					loadMode:'local',
					datas:[{title:'否',name:'1'},{title:'是',name:'0'}],
		            displayField:'title',
		            valueField:'name',
		            defaultValue:1
		        }},
	            {header:'操作',name:'enabled',hidden:!isAdmin,renderer:resetCust}
        ],
        params:{
			     		enabled:"1",
			     		dealer_id:"${sessionScope['currentDealerCustInfoId']}",
			     		loginuser:currentLoginUserId//"${sessionScope['login_userid']}"
				   }
  	 });
 });
function resetCust(value,tableObj,columnName,columnIndex,rowData){
   	var field="-";
       var invalid=rowData.invalidname;
       if(invalid=="是"){
    	var base = "<a href='#' onclick='doResetCust(\""+rowData.custid+"\",\""+rowData.custname+"\")'>{1}</a>";
        var updateFlag="撤销删除";
        field=base.replace("{1}",updateFlag);
       }
       return field;
}
 var currentLoadMask;
function doResetCust(custId,name){
	if(confirm("是否撤销删除["+name+"]客户?")){
		var loadMaskMsg = ("正在撤销删除["+name+"]客户,请稍后... ");
        if(null == currentLoadMask){
        	currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
     }
        currentLoadMask.show();
        ajaxRequest({
            url:"${pageContext.request.contextPath}/leasing/acl/resetCustEwlp.acl",
            params:{"id":custId},
            timeout:30*1000,
            success:function(res){
    	   		res=res.responseText;
    	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
   	    if(res!=''){
   	 	alert(res);
   	    }else{
   	    	alert("撤销成功["+name+"]!");
   	    	getTracywindyObject("id_table").reload();
   	    }
                currentLoadMask.hide();
            },
            failure:function(res){
                alert("服务器通信失败!");
                currentLoadMask.hide();
            }
       });
    }
}
function showCustName(value,tableObj,columnName,columnIndex,rowData){
       var base = "<a href='javascript:void(0);' onclick='showEwlpCustInfo(\""+rowData.custid+"\")'>{1}</a>{2}";
       var separator = "&nbsp;&nbsp;";
       var updateFlag=value;
       var updateClickFunc="other";
       var field=base.replace("{1}",updateFlag).replace("{2}",separator);
       return field;
     }
 function showEwlpCustInfo(cust_id){
    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
    	var params = {cust_id:cust_id,read_only:true};
	    openFullScreenWindow(URL,params);
        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }
//combox的相关onselect函数
function choseNext(parentCombo,childComboId,table){//多级联动函数
	 var parentValue = parentCombo.getValue();
	 var childCombo  = getTracywindyObject(childComboId);
	 childCombo.params['tableName'] ="(select id,name from "+table+" where pid='"+parentValue+"') rs" ;
	 childCombo.reload();
}
  function doTest(){
   var table =getTracywindyObject('id_table');
   var params = getQueryAreaParams(table);
   //alert(JsonUtil.encode(params));
   table.setParams(params);
   table.reload();
  }
  
  function submitCust(){//提交表单
	if(check){
		if(checkDraft()){return false;}
		if(getTracywindyObject("id_combo_draftname").getValue()=='1'){
			if(getTracywindyObject("id_combo_custtypename").getValue().indexOf("cust_type.cust")>-1){
				var phone=jQuery("#id_phone").val();
				var mobilenumber=jQuery("#id_mobilenumber").val();
				if(phone==""&&mobilenumber==""){
					jQuery("#id_mobilenumber").focus();
					alert("手机电话必须填写其中任意一个!");
					return false;
				}
			}
		}
		getTracywindyObject("id_table").operationTable();
	}else{
		alert("请输入正确的身份证号码!");
		return false;
	}
	return true;
}
  function checkDraft(){//确认是否草稿
	var cancelkDraft = false;
	if(getTracywindyObject("id_combo_draftname").getValue()=='0'){
		if(confirm("您确认存为草稿吗?")){
			MustFillIn.cancelRequireAll(document.getElementById("id_detailInfoForm"));//清除所有必填
			MustFillIn.setRequire(["custname","rawValue_custtype","rawValue_creatordept","rawValue_dealerorcompany"]);
			MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));
		}else{
			//选择取消的时候，直接修改是否为草稿为否，直接返回不做操作。
			changeCustType();
			getTracywindyObject("id_combo_draftname").setRawValue("否");
			getTracywindyObject("id_combo_draftname").setValue("1");
			getTracywindyObject("id_combo_draftname").reload();
			cancelkDraft = true; 
		}
	}else{
		changeCustType();
	}
	return cancelkDraft;
}  
  
  
  var check=true;
  function checkCardNo(){//校验身份证号码唯一
  	var idcardno=jQuery("#idcardno").val();
  	if(idcardno!=""){
  		var temp=idcardno;
  		var sex="";
  		if(temp.length==15){
  			 sex=temp.substring(13,14);
  			 temp=temp.substring(6,12);
  			 temp="19"+temp.substring(0,2)+"-"+temp.substring(2,4)+"-"+temp.substring(4,6);
  		}else if(temp.length==18){
  			sex=temp.substring(16,17);
  		    temp=temp.substring(6,14);
  		    temp=temp.substring(0,4)+"-"+temp.substring(4,6)+"-"+temp.substring(6,8);			
  		}
  		if(dateTest(temp,"ymd")){
  			jQuery("#brithdate").val(temp);
	  		if(sex%2==1){
	  			getTracywindyObject("id_combo_sexname").setRawValue("男");
				getTracywindyObject("id_combo_sexname").setValue("1");
				getTracywindyObject("id_combo_sexname").reload();
	  		}else{
	  			getTracywindyObject("id_combo_sexname").setRawValue("女");
				getTracywindyObject("id_combo_sexname").setValue("0");
				getTracywindyObject("id_combo_sexname").reload();
	  		}
  		}else{
  			alert("身份证可能不正确:不能从身份证中截取出正确的生日!!");
  		}
  		var url = '${pageContext.request.contextPath}/acl/checkCustLaw.acl';
  		var param={};
  		param.idcardno=idcardno;
          ajaxRequest({
               url:url,
               params:param,
  		     success:function(res){
  			     	if(res!=''){
  			     		var svote=res.responseText;
  			     	    svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
  			     	    if(svote!=''){
  				    	 	alert(svote);
  				     		check=false;
  			     	    }else{
  			     	    	check=true;
  			     	    }
  			     	}
  			     },
  		     failure:function(res){alert("校验身份证号码唯一失败!");}
          });
  	}else{
  		check=true;
  	}
  	return check;
  }
function dateTest(op, formatString){
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch(formatString){
			case "ymd" :
				m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
				if(m == null ) return false;
				day = m[6];
				month = m[5]*1;
				year =  (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
				break;
			case "dmy" :
				m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
				if(m == null ) return false;
				day = m[1];
				month = m[3]*1;
				year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
				break;
			default :
				break;
		}
		if(!parseInt(month)) return false;
		month = month==0 ?12:month;
		var date = new Date(year, month-1, day);
        return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth()+1) && day == date.getDate());
		function GetFullYear(y){return ((y<30 ? "20" : "19") + y)|0;}
}
</script>
</head>
<body>
<script type='text/javascript'>
       var currentClientWidth = document.documentElement.clientWidth;
       jQuery(function(){
           jQuery("#id_detailInfoWindowContainer").css({
               width:currentClientWidth*0.95
           });
       });
    </script>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer" buttons="#id-dlg-buttons" closed="true" modal="true" title="自然人管理" style="display:none;height:400px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:100%" class="fillTable">
			        
			            <tr style="display:none"><td><input name="user_id" type="hidden" value=""/><input name="id" type="hidden" value=""/><input name="custid" id="custid" type="hidden" value=""/></td></tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">客户名称:  </td>  
			            	<td class="td-content">
			            		<input name="custname" id="custname" maxlength="255" label="客户名称" maxB="255" class="td-content"   type="text" />
			            	</td>
			            	<td class="td-content-title">客户编号:  </td>  
			            	<td class="td-content">
			            		<input name="custnumber" id="custnumber" label="客户编号" maxB="100" readonly="readonly" class="td-content-input td-content-readonly" type="text" />
			            	</td>			  
			            </tr> 
			            <tr class="tr-odd">
			            	<td class="td-content-title">身份证号码:  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<input name="idcardno" id="idcardno" onblur="checkCardNo(this)" maxlength="18" label="身份证号码" maxB="18"  dataType="IdCard"  class="td-content"   type="text" />
			            	</td>
			            	<td class="td-content-title">性别:  </td>
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="sexname" label="性别"></div>
			            	</td>
			            </tr>
			             <tr class="tr-even">
			            	<td class="td-content-title">出生年月:  </td>  
			            	<td class="td-content">
			            		<input name="brithdate" id="brithdate"  label="出生年月"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" />
			            	</td>
			            	<td class="td-content-title">民族:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer"  label="民族" id="custethnicname"></div>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">客户类别:  </td>
			            	<td class="td-content" colspan="3">
			            		<div style="float:left" class="leftComboContainer"  label="客户类别" id="custtype"></div>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            <td class="td-content-title">客户内部行业:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" label="客户内部行业" id="custkindname"></div>
			            	</td>
			           	 <td class="td-content-title">获取驾照日期:  </td>  
			            	<td class="td-content" >
			            		<input name="driverlicensedate" id="driverlicensedate"  label="获取驾照日期"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" />
			            	</td>
			            </tr>
			             <tr class="tr-odd">
			            	<td class="td-content-title">开户行:  </td>  
			            	<td class="td-content">
			            		<input name="taxbank"  label="开户行" maxB="50"  maxlength="50" type="text" />
			            	</td>
			            	<td class="td-content-title">开户账号:  </td>  
			            	<td class="td-content">
			            		<input name="taxacc"  label="开户账号"  maxlength="30"  maxB="30"  type="text" />
			            	</td>
			            </tr>
			             
			            <tr class="tr-even">
			            	<td class="td-content-title">工作单位:</td>  
			            	<td class="td-content">
			            		<input name="unitname" maxB="100" label="工作单位"  maxlength="100"   type="text" />
			            	</td>
			            	<td class="td-content-title">职务:</td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" label="职务" id="unitpositionname"></div>
			            	</td>
			            </tr>
			             <tr class="tr-odd">
			            	<td class="td-content-title">省份:  </td>  
			            	<td class="td-content">
			            		<div style="float:left"  class="leftComboContainer" id="provincename"></div>
			            	</td>
			            	<td class="td-content-title">城市:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="cityname"></div>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">区县:  </td>  
			            	<td class="td-content" colspan="3">
			            		<div style="float:left" class="leftComboContainer" id="countyname"></div>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">户口所在地:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="domicileplace" style="width:85%" maxB="255" label="户口所在地"   type="text" ></textarea>
			            	</td>
			            </tr> 
			             <tr class="tr-even">
			            	<td class="td-content-title">邮寄地址:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="mailadd" id="id_mailadd" style="width:85%" label="邮寄地址" maxB="255"  type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">常住地址: </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="homeadd" style="width:85%" label="常住地址"  maxB="255" type="text" ></textarea>
			            	</td>
			            </tr>
			            
			             <tr class="tr-even"> 
			            	<td class="td-content-title">手机:  </td>  
			            	<td class="td-content">
			            		<input name="mobilenumber" id="id_mobilenumber"  label="手机" maxB="20"  maxlength="11"  dataType="Mobile" type="text" />
			            	</td>
			            	<td class="td-content-title">电话:  </td>  
			            	<td class="td-content">
			            		<input name="phone" id="id_phone" label="电话"  maxB="100"  type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">婚姻状况: </td>  
			            	<td class="td-content">
			            	<div style="float:left" class="leftComboContainer" id="id_maritalstatus" label="婚姻状况"></div>
			            	</td>
			            	<td class="td-content-title">学历:  </td>  
			            	<td class="td-content">
			            	    <div style="float:left" class="leftComboContainer" id="id_school"></div>
			            	</td>
			            </tr>
			             <tr class="tr-even">
			            	<td class="td-content-title">配偶名称: </td>  
			            	<td class="td-content">
			            		<input name="spousename"  label="配偶名称"  maxlength="30"  maxB="30" type="text" />
			            	</td>
			            	<td class="td-content-title">配偶联系方式:  </td>  
			            	<td class="td-content">
			            		<input name="spousecontact"  label="配偶联系方式" maxB="30"  maxlength="30"  type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">配偶身份证号: </td>  
			            	<td class="td-content">
			            		<input name="spouseidcardno" maxlength="18" label="配偶身份证号"   maxlength="18"  maxB="18" dataType="IdCard" type="text" />
			            	</td>
			            	<td class="td-content-title">配偶年龄:  </td>  
			            	<td class="td-content">
			            		<input name="spouseage"  label="配偶年龄" maxB="10"  dataType="Number" maxlength="10"  type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">有无子女: </td>  
			            	<td class="td-content">
			            	 <div style="float:left" class="leftComboContainer" id="id_spousechild"></div>
			            	</td>
			            	<td class="td-content-title">配偶工作单位:  </td>  
			            	<td class="td-content">
			            		<input name="spousework"  label="配偶工作单位"  maxB="100"  maxlength="100"  type="text" />
			            	</td>
			            </tr>
			         
			             <tr  class="tr-even">
			            	<td class="td-content-title">备注:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="ceimemo" style="width:85%" label="备注" maxB="2000"  type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">是否作废: </td>  
			            	<td class="td-content">
			            		<input name="invalidname" id="invalidname"  label="是否作废 " class="td-content-readonly" readonly="readonly"  type="text" />
			            		<input name="invalid" id="invalid"  label="是否作废 " class="td-content-readonly" readonly="readonly"  type="hidden" />
			            	</td>
			            	<td class="td-content-title">是否草稿: </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="draftname"></div>
			            	</td>
			            </tr>
			            
			             <tr  class="tr-even">
			             	<td class="td-content-title">经销商:  </td>  
			            	<td class="td-content">
			            		<div style="float: left" class="leftComboContainer" id="dealerorcompany" ></div>
			            	</td>
			            	
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creatorname" label="登记人 " class="td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			           	 	<td class="td-content-title">登记人部门:</td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="creatordeptname"></div>
			            	</td>
			           	 	<td class="td-content-title">登记时间: </td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" label="登记时间" isDefaultDate="true" readonly="readonly" class="td-content-input td-content-readonly"    type="text" />
			            		<input id="draftname" type="hidden" />
			            		<input id="custscalename" type="hidden" />
			            		<input id="taxlevelname" type="hidden" />
			            		
			            	</td>
			            </tr>
			        </table>
		        </form>
	        </center>
	        </div>
		<div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
		 <!--  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a> -->
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitCust()'><span>确定</span></a>
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
	</div>
</body>
</html>