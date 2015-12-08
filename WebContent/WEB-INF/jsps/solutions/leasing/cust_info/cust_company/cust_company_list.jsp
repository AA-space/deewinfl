<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld'%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法人客户 - 法人客户</title>
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
		var deptname='';
		if("${sessionScope['loginUserDeptObj'].name}"=='子公司项目部'){
			deptname="${sessionScope['loginUserDeptObj'].name}";
		}
		
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
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
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
			   otherAttributes:'label="客户类别"',
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
		    //2013-11-29 15:08 修改人 陈兴  原因：银行登记验证 提示信息为空
		dictOnSelect('id_is_banklevel','banklevel','credit_rating',null,null,'label="银行信用等级"',true,165,true,null); //银行信用等级
		dictOnSelect('custkindname','custkind','cust_kind',null,null,'label="客户内部行业"');//客户内部行业
		commonSelectOverall('industryname',"(select id,name from t_industry where pid is null) rs",'id',"name",'industry','','','label="客户所属行业门类"',function(combo,data){choseNext(combo,'id_combo_industrylevelbigname','t_industry');},true);//客户所属行业门类
		commonSelectOverall('industrylevelbigname',"(select id,name from t_industry where 1=2) rs",'id',"name",'industrylevelbig','','','label="客户所属行业大类"',function(combo,data){choseNext(combo,'id_combo_industrylevelmiddlename','t_industry');},true);//客户所属行业大类
		commonSelectOverall('industrylevelmiddlename',"(select id,name from t_industry where 1=2) rs",'id',"name",'industrylevelmiddle','','','label="客户所属行业中类"',function(combo,data){choseNext(combo,'id_combo_industrylevelsmallname','t_industry');},true);//客户所属行业中类
		commonSelectOverall('industrylevelsmallname',"(select id,name from t_industry where 1=2) rs",'id',"name",'industrylevelsmall','','','label="客户所属行业小类"',null,true);//客户所属行业小类
		commonSelectOverall('provincename',"(select id,name from t_district where pid in('HB','DB','HD','HZ','XN','XB','HN','TQ')) rs",'id',"name",'province','','','require="true"  label="省份"', function(combo,data){ choseNext(combo,'id_combo_cityname','t_district');},true);//省份
		commonSelectOverall('cityname',"(select id,name from t_district where 1=2) rs",'id',"name",'city','','','require="true"  label="城市"', function(combo,data){ choseNext(combo,'id_combo_countyname','t_district');},true);//城市
		commonSelectOverall('countyname',"(select id,name from t_district where 1=2) rs",'id',"name",'county','','','require="true"  label="区县"',null,true);//地区
		dictOnSelect('ownershipname','ownership','ownership',null,null,'label="企业性质"');//企业性质
		dictOnSelect('custscalename','custscale','cust_scale',null,null,'label="客户规模"');//客户规模
		dictOnSelect('taxlevelname','taxlevel','tax_level_name',null,null,'label="纳税人类别"');//纳税人
		dictYesOrNoByCode('iscompanymanagename','iscompanymanage',null,null,true,'label="是否已办企业管理"');//是否已办企业管理
		dictYesOrNoByCode('draftname','draft',null,null,null,'label="是否草稿"');//是否草稿
		dictHadOrNoByCode('valuationfile','valuationfile',null,null,null,'require="true" label="有无估价文件"');//有无估价文件

		new tracywindyComboBox({
			id : 'id_combo_id_is_dealerorcompany',
			width : 167,
			renderTo : 'id_is_dealerorcompany',
			xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelect.xml',
			loadMode : 'ajax',
			readOnly : false,
			isAjaxLenovo : true,
			otherAttributes:'require="true" label="经销商"',
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
			}
		,onSelect:changeDealerorInfo
		
		});
		function changeDealerorInfo()
		{
			if ( getTracywindyObject("id_combo_id_is_dealerorcompany").getValue()!="")
			{
				if(window.confirm("您是否确认选中的经销商为该经销商下的客户？"))
				{
					var custid=$("#custid").val();
					var tempStr=getTracywindyObject("id_combo_id_is_dealerorcompany").getValue();//新下拉选中经销商id
					var url = "${pageContext.request.contextPath}/leasing/checkDealerCompayInfo.action";
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
			id : 'id_combo_creatordeptname',
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
		var assure_type = new tracywindyComboBox({
			lazyLoad:true,
    	    id:'id_combo_provideassuretype',
    	    width:510,
    	    renderTo:'id_provideassuretype',
    	    loadMode:'local',
    	    //pledgetype,collateraltype,warrantertype
    	    datas:[{title:'抵押方式',name:'collateraltype'},{title:'质押方式',name:'pledgetype'},{title:'第三方保证',name:'warrantertype'}],
    	    readOnly:true,
    	    isContainEmpty:true,
    	    isCheck:true,
    	    dropListHeight:200,
    	    positionDropIconLeftAdd:-1,
    	    //value:'',
    	    name:'provideassuretype',
    		displayField:'title',
    		valueField:'name',
    	    //otherAttributes:'require="true" label="可提供担保方式"',
    	    onSelect:changeAssureType
    	 });
		
		//加载页面列表
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
				jQuery("#invalidname").val("否");
				jQuery("#invalid").val("1");
				jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
				MustFillIn.setRequire(custType.lawCust);//默认承租人
				MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));

				getTracywindyObject("id_combo_id_is_dealerorcompany").setValue("${sessionScope['currentDealerCustInfoId']}");
   	   	        getTracywindyObject("id_combo_creatordeptname").setValue("${sessionScope['loginUserDeptObj'].id}");
				
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
 			       			    {comboId:'provideassuretype',rowDataMapping:'provideassuretype'},
 			                    {comboId:'custkindname',rowDataMapping:'custkind'},
 			                    {comboId:'industryname',rowDataMapping:'industry'},
 			                    {comboId:'industrylevelbigname',rowDataMapping:'industrylevelbig',parentRowDataMapping:'industry',tableName:'t_industry'},
 			                    {comboId:'industrylevelmiddlename',rowDataMapping:'industrylevelmiddle',parentRowDataMapping:'industrylevelbig',tableName:'t_industry'},
 			                    {comboId:'industrylevelsmallname',rowDataMapping:'industrylevelsmall',parentRowDataMapping:'industrylevelmiddle',tableName:'t_industry'},
 			                    {comboId:'provincename',rowDataMapping:'province'},
 			                    {comboId:'cityname',rowDataMapping:'city',parentRowDataMapping:'province',tableName:'t_district'},
 			                    {comboId:'countyname',rowDataMapping:'county',parentRowDataMapping:'city',tableName:'t_district'},
 			                    {comboId:'ownershipname',rowDataMapping:'ownership'},
 			                    {comboId:'custscalename',rowDataMapping:'custscale'},
 			                    {comboId:'taxlevelname',rowDataMapping:'taxlevel'},
 			                    {comboId:'iscompanymanagename',rowDataMapping:'iscompanymanage'},
 			                    {comboId:'draftname',rowDataMapping:'draft'},
 			                    {comboId:'creatordeptname',rowDataMapping:'creatordept'},
 			                    {comboId:'id_is_banklevel',rowDataMapping:'banklevel'},
 			                    {comboId:'id_is_dealerorcompany',rowDataMapping:'dealerorcompany'},
 			                    {comboId:'valuationfile',rowDataMapping:'valuationfile'}
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
			
			changeCustType();//修改时加载必填
			changeAssureType();//处理可提供担保方式
			if(getTracywindyObject("id_combo_draftname").getValue()=='1'){//不是草稿的时候不能修改
   	   	  		//getTracywindyObject("id_combo_draftname").readOnlyData = true;
   	   	  		//getTracywindyObject("id_combo_draftname").reload();
			}else{
				getTracywindyObject("id_combo_draftname").readOnlyData = false;
   	   	  		getTracywindyObject("id_combo_draftname").reload();
			}
    	 },
    	 //2013-11-29 15:09 修改人 陈兴 原因： 焦经理要求新增法人客户的时候 提示信息由“确认新增【法人客户】么？“改为”确认新增【客户】么？“ ”
   		 tableComment:'客户',
   		 constantFlagTable:'CustLaw',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'法人客户',
         width:pageWidth,
         height:pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/law_manage/law_info.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:false,
         operButtons:operButtons,
         enabledPromit:'有效',
         disabledPromit:'无效',
         enabledDefaultValue:'1',
         isNeedEnabled:isAdmin,
         isNeedEnabled:true,
         isAutoBreakContent:true,
         lockedNames:['custname'],
         columns:[
					{header:'客户名称',name:'custname',renderer:showCustName,width:180,queryConfig:{}},
		            {header:'id',name:'id',hidden:true},
					{header:'客户ID',name:'custid',hidden:true},
					{header:'客户编号',name:'custnumber',hidden:true},
					{header:'经销商id',name:'dealerorcompany',hidden:true},
					{header:'经销商',name:'dealerorcompanyname',width:120,queryConfig:{}},
					{header:'组织机构代码',name:'orgcode',queryConfig:{}},
					{header:'客户规模',name:'custscalename'},
					{header:'客户规模ID',name:'custscale',hidden:true},
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
					
					{header:'客户类别',name:'custtype',hidden:true},
					{header:'纳税人类别',name:'taxlevelname'},
					{header:'纳税人识别号/国税登记号',name:'taxregcode'},
					{header:'开户行',name:'taxbank',width:140},
					{header:'开户账号',name:'taxacc',width:140},
					{header:'货款卡号',name:'creditcard',width:140},
					{header:'是否已办企业管理',name:'iscompanymanagename'},
					{header:'客户内部行业',name:'custkindname'},
					{header:'客户内部行业',name:'custkind',hidden:true},
					{header:'省份',name:'provincename'},
					{header:'省份',name:'province',hidden:true},
					{header:'城市',name:'cityname'},
					{header:'城市',name:'city',hidden:true},
					{header:'区县',name:'countyname'},
					{header:'区县',name:'county',hidden:true},
					{header:'企业性质',name:'ownershipname'},
					{header:'公司邮寄地址',name:'mailadd',width:160},
					{header:'邮编',name:'postcode'},
					{header:'公司网址',name:'website',width:160},
					{header:'公司地址',name:'postaddr'},	
					{header:'传真',name:'faxnumber'},
					{header:'登记注册号（营业执照号）',name:'regnumber',width:150},
					//{header:'注册资本',name:'regcapital'},
					//{header:'实收资本',name:'calledcapital'},
					{header:'注册地址',name:'regaddr',width:160},
					{header:'法人代表名称',name:'legalrepresentative',width:140},
					{header:'法人代表身份证号',name:'idcardno',width:140},
					{header:'法人代表手机',name:'mobilenumber'},
					{header:'法人代表电话',name:'phone'},
					{header:'银行信用等级',name:'banklevel',hidden:true},
					{header:'净资产',name:'netassets',hidden:true},					
					{header:'客户所属行业门类',name:'industry',hidden:true},
					{header:'客户所属行业大类',name:'industrylevelbig',hidden:true},
					{header:'客户所属行业中类',name:'industrylevelmiddle',hidden:true},
					{header:'客户所属行业小类',name:'industrylevelsmall',hidden:true},
					{header:'是否作废',name:'invalidname'},
					{header:'是否草稿',name:'draftname',type:'combobox',
			            queryConfig:{
						width:165,
						colSpan:3, 
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
		     		logindeptname:deptname,
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
    	if(confirm("是否撤销删除["+name+"]法人客户?")){
    		var loadMaskMsg = ("正在撤销删除["+name+"]法人客户,请稍后... ");
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
        var base = "<a href='javascript:void(0);' onclick='showLawCustInfo(\""+rowData.custid+"\")'>{1}</a>{2}";
        var separator = "&nbsp;&nbsp;";
        var updateFlag=value;
        var updateClickFunc="other";
        var field=base.replace("{1}",updateFlag).replace("{2}",separator);
        return field;
      }
	 function showLawCustInfo(cust_id){
	    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
	    	var params = {cust_id:cust_id,read_only :true};
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
function changeCustType(){//选择客户类别联动校验函数
	MustFillIn.cancelRequireAll(document.getElementById("id_detailInfoForm"));//清除所有必填
	var tempStr=getTracywindyObject("id_combo_custtypename").getValue();
	if(tempStr!=""){
		var checkLis=tempStr.split(",");
		for(var i=0;i<checkLis.length;i++){
			//此处需要和数据字典中的值关联起来 如果增加数据字典想需要在此增加设置
			cust_type=custType.getCheckField("law",checkLis[i]);
			MustFillIn.setRequire(cust_type);
		}
		MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));
	}else{//当没有勾选时必须填写名字和客户类别
		MustFillIn.setRequire(["custname","rawValue_custtype","rawValue_creatordept","rawValue_dealerorcompany"]);
		MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));
	}
}
function changeAssureType(){
	var tempStr=getTracywindyObject("id_combo_provideassuretype").getValue();
	$("#collateraltype_TR1").hide();
	$("#collateraltype_TR2").hide();
	$("#pledgetype_TR1").hide();
	$("#warrantertype_TR").hide();
	if(tempStr!=""){
		var checkLis=tempStr.split(",");
		for(var i=0;i<checkLis.length;i++){
			var temp=checkLis[i];
			if(temp=="collateraltype"){
				$("#collateraltype_TR1").show();
				$("#collateraltype_TR2").show();
			}
			if(temp=="pledgetype"){
				 $("#pledgetype_TR1").show();
			}
			if(temp=="warrantertype"){
				$("#warrantertype_TR").show();
			}
		}
	}
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


function submitCust(){//提交表单
	 if ( "" != getTracywindyObject("id_combo_taxlevelname").getValue() && "tax_level_name.1" == getTracywindyObject("id_combo_taxlevelname").getValue() )
	 {
		 if($("#taxregcode").val() =="")
		 {
			alert("现在您选定的是 一般纳税人【纳税人识别号/国税登记号】必填！");
			$("#taxregcode").focus();
			return false;
		 }
		 if($("#regnumber").val() =="")
		 {
			alert("现在您选定的是 一般纳税人【登记注册号（营业执照号）】必填！");
			$("#regnumber").focus();
			return false;
		 }
	 }
	var tempStr=getTracywindyObject("id_combo_provideassuretype").getValue();
	if(tempStr!=""){
		var checkLis=tempStr.split(",");
		for(var i=0;i<checkLis.length;i++){
			var temp=checkLis[i];
			if(temp=="collateraltype"){
				if(document.getElementById("collateralname").value==""){
					alert("请输入抵押物品名称！");
					return false;
				}
				if(document.getElementById("valuationfile").value==""){
					alert("请输入有无估价文件！");
					return false;
				}
				if(document.getElementById("gagevalue").value==""){
					alert("请输入抵押物价值！");
					return false;
				}
			 }
			 if(temp=="pledgetype"){
				if(document.getElementById("pledgename").value==""){
					alert("请输入质物名称！");
					return false;
				}
				if(document.getElementById("pledgevalue").value==""){
					alert("请输入质物价值！");
					return false;
				}
			 }
			 if(temp=="warrantertype"){
				if(document.getElementById("warrantername").value==""){
					alert("请输入保证人名称！");
					return false;
				}
			 }
		}
	}
	
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
		alert("请输入正确的组织机构代码!");
		return false;
	}
	return true;
}
//其中checkORG1为原来组织机构编码的校验
function checkORG(obj)
{
	var code = obj.value;
    if (code.length == 10)
    {
        return checkORG1(obj);
    }else{
        var flag = isValidSocialCreditIdentifier(code);
        if(!flag){
        	alert("组织机构代码错误!");
        }
        return flag;
    }
}

function isValidSocialCreditIdentifier(code)
{
    if (code.length != 18) return false;
    var ws = [1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28];
    var str = "0123456789ABCDEFGHJKLMNPQRTUWXY";
    //验证9-17位 的组织机构代码
    var tCode = code.substr(8, 8) + "-" + code.substr(16, 1);
    if (isValidEntpCode(tCode) == false) return false;
    var sum = 0;
    for (var i = 0; i < 17; i++)
    {
        sum += str.indexOf((code.substr(i, 1))+"") * ws[i];
    }
    var c18 = 31 - (sum % 31);
    return (str.substr(c18, 1)+"") == (code.substr(17, 1));
}

function isValidEntpCode(code)
{
    var ws = [3,7,9,10,5,8,4,2];
    var  str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    var  rx = /^([0-9A-Z]){8}-[0-9|X]$/g;
    if (!rx.test(code)){return false;}
     var  sum = 0;
    for (var i = 0; i < 8; i++)
    {sum += str.indexOf((code.substr(i,1))+"") * ws[i];}
    var  c9 = 11 - (sum % 11);
    var  sc9 =c9+"";
    if (11 == c9)
    {sc9 = "0";}
    else if (10 == c9)
    {   sc9 = "X";}
    return sc9==(code.substr(9,1));
}

function checkORG1(obj){
	if(checkORGRight(obj)){
		if(checkORGPrmary()){
			return true;
		}
	}
	return false;
}
function checkORGRight(obj){//校验组织机构代码
	  var financecode=obj.value;
	   var fir_value, sec_value;
	   var w_i = new Array(8);
	   var c_i = new Array(8);
	   var j, s = 0;
	   var c, i;

	   var code = financecode;

	   if (code.length<1) {
	     //alert("请输入组织机构代码!");
	     //obj.select();
	       return false;
	   }

	   if (code == "00000000-0") {
	     alert("组织机构代码错误!");
	     //obj.select();
	       return false;
	   }

	   re = /[A-Z0-9]{8}-[A-Z0-9]/;    
	   r = code.match(re);   
	   if (r == null) {
		 alert("组织机构代码错误!");
	     //obj.select();
	     return false;
	   }        

		   w_i[0] = 3;
		   w_i[1] = 7;
		   w_i[2] = 9;
		   w_i[3] = 10;
		   w_i[4] = 5;
		   w_i[5] = 8;
		   w_i[6] = 4;
		   w_i[7] = 2;

		   if (financecode.charAt(8) != '-') {
		   alert("组织机构代码错误!");
			 //obj.select();
			   return false;
		   }

		   for (i = 0; i < 10; i++) {
			   c = financecode.charAt(i);
			   if ((c <= 'z') && (c >= 'a')) 
			  {
			   alert("组织机构代码错误!");
			 //obj.select();
				   return false;
			   }
		   }


		   fir_value = financecode.charCodeAt(0);
		   sec_value = financecode.charCodeAt(1);

		   if (fir_value >= 'A'.charCodeAt(0) && fir_value <= 'Z'.charCodeAt(0)) {
			   c_i[0] = fir_value + 32 - 87;
		   } else {
				if (fir_value >= '0'.charCodeAt(0) && fir_value <= '9'.charCodeAt(0)) {
				c_i[0] = fir_value - '0'.charCodeAt(0);
				} else {
						alert("组织机构代码错误!");
			 //obj.select();
				return false;
				}
		   }

		   s = s + w_i[0] * c_i[0];

		   if (sec_value >= 'A'.charCodeAt(0) && sec_value <= 'Z'.charCodeAt(0)) {
			   c_i[1] = sec_value + 32 - 87;
		   } else if (sec_value >= '0'.charCodeAt(0) && sec_value <= '9'.charCodeAt(0)) {
			   c_i[1] = sec_value - '0'.charCodeAt(0);
		   } else {
		   alert("组织机构代码错误!");
			 //obj.select();
			   return false;
		   }

		   s = s + w_i[1] * c_i[1];
		   for (j = 2; j < 8; j++) {
			   if (financecode.charAt(j) < '0' || financecode.charAt(j) > '9') {
			   alert("组织机构代码错误!");
			 //obj.select();
				   return false;
			   }
			   c_i[j] = financecode.charCodeAt(j) - '0'.charCodeAt(0);
			   s = s + w_i[j] * c_i[j];
		   }

		   c = 11 - (s % 11);

		   if (!((financecode.charAt(9) == 'X' && c == 10) ||
				 (c == 11 && financecode.charAt(9) == '0') || (c == financecode.charCodeAt(9) - '0'.charCodeAt(0)))) {

				  alert("组织机构代码错误!");
				  // obj.select();
					return false;
		   }
	   return true;
}
var check=true;
function checkORGPrmary(){//校验组织结构代码唯一
	var custid=jQuery("#custid").val();
	var orgcode=jQuery("#orgcode").val();
	var dealerorcompany=jQuery("#id_is_dealerorcompany").val();
	if(orgcode!=""){
		var url = '${pageContext.request.contextPath}/acl/checkCustLaw.acl';
		var param={};
		param.custid=custid;
		param.orgcode=orgcode;
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
		     failure:function(res){alert("校验组织机构代码唯一失败!");}
        });
	}
	return check;
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
	<div id="id_detailInfoWindowContainer" buttons="#id-dlg-buttons" closed="true" modal="true" title="法人客户" style="display:none;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:100%" class="fillTable">
			             <tr style="display:none"><td><input name="id"  type="hidden" value=""/><input name="custid" id="custid" type="hidden" value=""/></td></tr>
			            <tr class="tr-even">
			            <td class="td-content-title">客户编号:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="custnumber" id="custnumber" maxB="100" label="客户编号" readonly="readonly"  class="td-content-input td-content-readonly"  type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">客户名称:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input style="width:91%" name="custname" id="custname"  maxlength="255"  label="客户名称" maxB="255" class="td-content"   type="text" />
			            	</td>
			            	
			            </tr>
			            
			               <tr  class="tr-even">
			            	<td class="td-content-title">组织机构代码(统一社会信用代码):  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<input name="orgcode" id="orgcode"  onblur="checkORG(this)" label="组织结构代码" maxB="100"  maxlength="18" class="td-content"   type="text" />
			            	</td>
			            	<td class="td-content-title">客户规模:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="custscalename"></div>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">客户类别:  </td>
			            	<td class="td-content" colspan="3" id="ccc">
			            		<div style="float:left" class="leftComboContainer" style="width:91%" id="custtype"></div>
			            	</td>
			            </tr>
	            		<tr class="tr-even">
		            		<td class="td-content-title">纳税人类别:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="taxlevelname"></div>
			            	</td>
			            	<td class="td-content-title">纳税人识别号/国税登记号:  </td>  
			            	<td class="td-content">
			            		<input name="taxregcode" id ="taxregcode" label="纳税人识别号/国税登记号" maxB="100"  type="text" />
			            	</td>
	            		</tr>
	            		<tr class="tr-odd">
		            		<td class="td-content-title">开户行:  </td>  
			            	<td class="td-content">
			            		<input name="taxbank"  label="开户行"  maxB="100"  maxlength="100"  type="text" />
			            	</td>
			            	<td class="td-content-title">开户账号:  </td>  
			            	<td class="td-content">
			            		<input name="taxacc"  label="开户账号"  maxB="100"  maxlength="30"  type="text" />
			            	</td>
	            		</tr>
	            		<tr class="tr-even">
	            			<td class="td-content-title">货款卡号:  </td>  
			            	<td class="td-content">
			            		<input name="creditcard"  label="货款卡号"  maxB="100"  maxlength="30"  type="text" />
			            	</td>
			            	<td class="td-content-title">电话:  </td>  
			            	<td class="td-content">
			            		<input name="taxphone"  label="电话"   maxB="100"   type="text" />
			            	</td>
	            		</tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">是否已办企业管理:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="iscompanymanagename"></div>
			            	</td>		          
			            	<td class="td-content-title">银行信用等级</td>  
			            	<td class="td-content">
			            		 <div id="id_is_banklevel" class="leftComboContainer" style="display:inline-block"></div></td>	
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">企业在职人数:  </td>  
			            	<td class="td-content">
			            		<input name="enterpriseNumber"  label="企业在职人数" dataType="Number"  maxlength="20"   maxB="100"  type="text" />
			            	</td>
			            	<td class="td-content-title">企业总人数:  </td>  
			            	<td class="td-content">
			            		<input name="enterpriseTotal"  label="企业总人数" dataType="Number"  maxB="100"  maxlength="20"  type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">年营业收入:  </td>  
			            	<td class="td-content">
			            		<input name="annualRevenue"  label="年营业收入"  maxB="100"  maxlength="100"  dataType="PMoney" type="text" />
			            	</td>
			            	<td class="td-content-title">净资产:  </td>  
			            	<td class="td-content">
			            		<input name="netassets"  label="净资产"  maxB="100" dataType="PMoney" maxlength="100"  type="text" />
			            	</td>
			            </tr>
			              <tr  class="tr-even">
			            	<td class="td-content-title">客户内部行业:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="custkindname"></div>
			            	</td>
			            	<td class="td-content-title">客户所属行业门类:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="industryname"></div>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">客户所属行业大类:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="industrylevelbigname"></div>
			            	</td>
			            	<td class="td-content-title">客户所属行业中类:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="industrylevelmiddlename"></div>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">客户所属行业小类:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="industrylevelsmallname"></div>
			            	</td>
			            	<td class="td-content-title">国家:  </td>  
			            	<td class="td-content">
			            		中国
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			            	<td class="td-content-title">省份:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="provincename"></div>
			            	</td>
			            	<td class="td-content-title">城市:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="cityname"></div>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">区县:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="countyname"></div>
			            	</td>
			            	<td class="td-content-title">企业性质:  </td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" id="ownershipname"></div>
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			            	<td class="td-content-title">法人代表:  </td>  
			            	<td class="td-content">
			            		<input name="legalrepresentative"  label="法人代表"  maxlength="50"  maxB="50" type="text" />
			            	</td>
			            	<td class="td-content-title">法人代表身份证号:  </td>  
			            	<td class="td-content">
			            		<input name="idcardno"  label="法人代表身份证号" maxB="30"  maxlength="18" dataType="IdCard" type="text" />
			            	</td>
			            </tr>
			             <tr  class="tr-even">
			            	<td class="td-content-title">手机:  </td>  
			            	<td class="td-content">
			            		<input name="mobilenumber"  label="手机" dataType="Mobile"  maxlength="11" maxB="20" type="text" />
			            	</td>
			            	<td class="td-content-title">电话:  </td>  
			            	<td class="td-content">
			            		<input name="phone"  label="电话"   maxB="100"  type="text" />
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			            	<td class="td-content-title">公司邮寄地址:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="mailadd"  label="公司邮寄地址" maxB="255" maxlength="255" style="width:92%"  type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr   class="tr-even">
			            	<td class="td-content-title">邮编:  </td>  
			            	<td class="td-content">
			            		<input name="postcode"  label="邮编"  dataType="Zip"  maxlength="6" maxB="50" type="text" />
			            	</td>
			            	<td class="td-content-title">公司网址:  </td>  
			            	<td class="td-content">
			            		<input name="website"  label="公司网址" dataType="Url" maxB="100" maxlength="100" type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">公司地址: </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="postaddr"  label="公司地址" style="width:92%" maxB="255" type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            <td class="td-content-title">传真:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="faxnumber"  label="传真" maxB="100" type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title"><B>注册资本 </B> </td>  
			            	<td class="td-content-title"></td> 
			            	<td class="td-content-title"></td> 
			            	<td class="td-content-title"></td> 
			            </tr>
			             <tr   class="tr-even">
			            	<td class="td-content-title">出资方式及金额(货币、实物等):  </td>  
			            	<td class="td-content">
			            		<input name="investmentamoun"  label="出资方式及金额(货币、实物等)" maxB="100" maxlength="100" dataType="PMoney"  type="text" />
			            	</td>
			            	<td class="td-content-title">注册登记机关: </td>  
			            	<td class="td-content">
			            		<textarea name="registrationauthority" style="width:77%"  label="注册登记机关" maxB="100" maxlength="100" type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">认缴额:  </td>  
			            	<td class="td-content">
			            		<input name="subscriptions"  label="认缴额" dataType="PMoney" maxB="100" maxlength="100" type="text" />
			            	</td>
			            	<td class="td-content-title">登记注册号（营业执照号）: </td>  
			            	<td class="td-content">
			            		<textarea name="regnumber" style="width:77%" id="regnumber"  label="登记注册号（营业执照号）"  maxB="100" maxlength="100" type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr   class="tr-even">
			            	<td class="td-content-title">实缴额:  </td>  
			            	<td class="td-content">
			            		<input name="paidinamount" id="paidinamount" label="实缴额" dataType="PMoney" maxB="200" maxlength="20" type="text" />
			            	</td>
             				<td class="td-content-title">成立时间:  </td>  
			            	<td class="td-content">
			            		<input name="fundtime" id="fundtime"  label="成立时间"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" />
			            	</td>
			            	
          			    </tr>
          			    <tr id="pledgetype_TR"  class="tr-odd">
          			    		<td class="td-content-title"><B>可提供担保方式</B></td>
          			    		<td class="td-content"  colspan="3">
				            		<div style="float:left;" class="leftComboContainer" id="id_provideassuretype"></div>
				            	</td>
          			    	</tr>
          			    	<tr id="collateraltype_TR1" style="display: none;" class="tr-even">
          			    		<td class="td-content-title">抵押物品名称:</td>
				            	<td class="td-content">
				            		<input name="collateralname" id="collateralname" label="抵押物品名称"  maxB="50"  type="text" />
				            	</td>
				            	<td class="td-content-title">有无估价文件:  </td>  
				            	<td class="td-content">
				            		<div style="float:left" class="leftComboContainer" id="valuationfile"></div>
				            	</td>
          			    	</tr>
          			    	<tr id="collateraltype_TR2" style="display: none;"  class="tr-odd">
          			    		<td class="td-content-title">抵押物价值:</td>
				            	<td class="td-content" colspan="3">
				            		<input name="gagevalue" id="gagevalue" label="抵押物价值"  maxB="22" maxlength="22" type="text" dataType="PMoney" />
				            	</td>
          			    	</tr>
          			    	<tr id="pledgetype_TR1" style="display: none;" class="tr-even">
          			    		<td class="td-content-title">质物名称:</td>
				            	<td class="td-content">
				            		<input name="pledgename" id="pledgename"  label="质物名称"  maxB="50" maxlength="50" type="text" />
				            	</td>
				            	<td class="td-content-title">质物价值:  </td>  
				            	<td class="td-content">
				            		<input name="pledgevalue" dataType="PMoney" id="pledgevalue" label="质物价值" maxB="22" maxlength="22"  type="text" />
				            	</td>
          			    	</tr>
          			    	<tr id="warrantertype_TR"  style="display: none;" class="tr-odd">
          			    		<td class="td-content-title">保证人名称:</td>
				            	<td class="td-content">
				            		<input name="warrantername" id="warrantername"  label="保证人名称" maxlength="50" maxB="50"  type="text" />
				            	</td>
				           			           
				            	<td class="td-content-title"> </td>  
				            	<td class="td-content" >
				            	</td>
          			    	</tr>
			           <tr class="tr-even">
			           <td class="td-content-title">注册地址 : </td>  
						            	<td class="td-content" colspan="3">
						            		<input name="taxregadd" label="注册地址 : "  maxB="255" maxlength="255" style="width:92%"  type="text"/>
						            	</td>
			           </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">经营方式 : </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="bizmethod"  label="经营方式: " maxB="2000" maxlength="2000" style="width:92%"  type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">经营范围（主营） : </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="bizscopeprimary"  label="经营范围（主营） " maxB="2000" maxlength="2000" style="width:92%" type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">经营范围（兼营） : </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="bizscopesecondary"  label="经营范围（兼营） : "  style="width:92%" maxB="2000" maxlength="2000" type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">客户概况 : </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="cimemo"  label="客户概况"  maxB="2000" maxlength="2000" style="width:92%" type="text" ></textarea>
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
			            	<tr class="tr-even">
			            	<td class="td-content-title">经销商:  </td>  
			            	<td class="td-content">
			            	<div style="float: left" class="leftComboContainer" id="id_is_dealerorcompany" ></div></td>
			            	
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creatorname" label="登记人 " class="td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            </tr>
			             <tr  class="tr-odd">
			           	 	<td class="td-content-title">登记人部门:</td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" label="登记人部门 " id="creatordeptname"></div>
			            	</td>
			            	<td class="td-content-title">登记时间:</td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" isDefaultDate="true" label="登记时间 " class="td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            	</tr>
			        </table>
		        </form>
	        </center>
	        <div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitCust();'><span>确定</span></a>
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
	</div>
	</div>

</body>
</html>