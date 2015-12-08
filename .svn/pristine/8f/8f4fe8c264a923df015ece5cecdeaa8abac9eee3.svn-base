<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理  - 重要个人</title>
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
var operButtons='';
</script >
<permission:action  code="cust_add_update">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script >
</permission:action>
<permission:action  code="admin_action">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script >
</permission:action>
<script type="text/javascript">
if("false"=='${param.readOnly}')
{
	operButtons="";
}
var cust_id="<%= request.getParameter("cust_id")%>";
   var param={};
   if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
		
   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   			jQuery("#creator").val('${sessionScope.loginUser.realname}');
   			initCustInfoName(cust_id);
   			var select_contract = getTracywindyObject("id_combo_id_is_mainPersonFlag");
    	    select_contract.setValue('');
   			
   	       } 
     	 },
     	loadFormDataCallBack:function(table,$form,rowIndex){
	   		 var rowData = table.getRowDataAt(rowIndex);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_relationship");
	   	     select_contract.setValue(rowData["relationship"]);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_mainPersonFlag");
	   	     select_contract.setValue(rowData["mainpersonflag"]);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_sex");
	   	     select_contract.setValue(rowData["sex"]);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_jobposition");
	   	     select_contract.setValue(rowData["jobposition"]);
	 	},
   		 tableComment:'[重要个人]',
   		 constantFlagTable:'CustPerson',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'重要个人',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_person/cust_person_info.xml',
         loadMode:'ajax',
         params:param,
         isPage:true,
         isFit:true,
         operButtons:operButtons,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            //{header:'所属客户',name:'custname'},
		            {header:'姓名',name:'personname'},
		            {header:'客户名称',name:'custname'},
		            {header:'是否主联系人',name:'mainpersonflagname'},
		            {header:'身份证号码',name:'idcardno',width:140},
		            {header:'关系',name:'relationshipname'},
		            {header:'手机',name:'mobilenumber'},
		            {header:'电话',name:'phone'}
		            //{header:'登记人',name:'username'},
		           
		          
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

     jQuery(function(){
    	 dictOnSelect('id_is_jobposition','jobposition','cust_jobposition',null,null,' require="true" label="职务"');//职务
     dictYesOrNoByCode('id_is_mainPersonFlag','mainPersonFlag','${empty requestScope["mainPersonFlag"] ? "1" : requestScope["mainPersonFlag"] }',null,false,'require="true" label="是否是主联系人 "',165); //是否是主联系人
     dictSexByCode('id_is_sex','sex','${empty requestScope["framework_condition.ismerger"] ? "1" : requestScope["framework_condition.ismerger"] }',null,false,'require="true" label="性别"',165) //性别
     dictOnSelect('id_is_relationship','relationship','relationship',null,null,false,true,165); //关系 
        });
     function checkCardNo(idcardno){//校验身份证号码唯一
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
    	  			jQuery("#birthdate").val(temp);
	    	  		if(sex%2==1){
	    	  			getTracywindyObject("id_combo_id_is_sex").setRawValue("男");
	    				getTracywindyObject("id_combo_id_is_sex").setValue("1");
	    				getTracywindyObject("id_combo_id_is_sex").reload();
	    	  		}else{
	    	  			getTracywindyObject("id_combo_id_is_sex").setRawValue("女");
	    				getTracywindyObject("id_combo_id_is_sex").setValue("0");
	    				getTracywindyObject("id_combo_id_is_sex").reload();
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
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  buttons="#id-dlg-buttons" closed="true" modal="true" title="重要个人" style="display:none;width:900px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">客户名称:  </td>  
			            	<td class="td-content" colspan="3" >
			            	    <input name="custid" id="id_custid" type="hidden" />
			            		<input name="custname" id="id_custname"  maxlength="255" style="width:82%" require="true" label="客户名称" readonly="readonly" class="td-content-input td-content-readonly"  type="text" /><font class="required-content">*</font></td>
			            </tr>
			              <tr class="tr-odd">
			            <td class="td-content-title" >重要个人姓名:  </td>  
			            	<td class="td-content"   colspan="3">
			            		<input name="personname" id="personname" require="true" label="姓名" class="td-content-input" maxB="20"  maxlength="20"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	</tr>
			              <tr class="tr-even">
			            	<td class="td-content-title">身份证号码:  </td>  
			            	<td class="td-content">
			            		<input name="idcardno" require="true" label="身份证号码" onblur="checkCardNo(this.value)"  class="td-content-input" datatype="IdCard"  maxlength="18"   maxB="20"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">出生年月:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="birthdate" id="birthdate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="出生年月"><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	 <td class="td-content-title" >性别：</td>
           			  <td class="td-content" >
           			        <div id="id_is_sex" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font></td>
			           <td class="td-content-title">关系:  </td>  
			           <td class="td-content">
			           <div id="id_is_relationship" class="leftComboContainer"  style="float:left"></div><font class="required-content">*</font></td>
      				    	
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">是否是主联系人 :  </td>  
			            	<td class="td-content">
			           <div id="id_is_mainPersonFlag" class="leftComboContainer"  style="float:left"></div><font class="required-content">*</font></td>
      				    
			            	<td class="td-content-title">手机:  </td>  
			            	<td class="td-content">
			            		<input name="mobilenumber" require="true" label="手机"   maxlength="11"   class="td-content-input"  maxB="50"  dataType="Mobile"  type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">户口所在地:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="domicileplace" require="true" label="户口所在地" style="width:82%"  class="td-content-input"  maxlength="255"   maxB="255"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">邮寄地址:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="mailadd" require="true" label="邮寄地址" style="width:82%"   class="td-content-input"  maxlength="255"   maxB="255"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">常住地址:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="homeadd" require="true" label="常住地址"  maxB="255"   maxlength="255"  class="td-content-input" style="width:82%"  type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">邮编:  </td>  
			            	<td class="td-content">
			            		<input name="postcode" require="true" label="邮编" dataType="Zip"   maxlength="6"   maxB="30"   class="td-content-input"  type="text"  /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">电话:  </td>  
			            	<td class="td-content">
			            		<input name="phone" require="true" label="电话 "  class="td-content-input"  maxB="100"   type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">职务:</td>  
			            	<td class="td-content">
			            		<div style="float:left" class="leftComboContainer" label="职务" id="id_is_jobposition"></div>
			            	</td>
			            	<td class="td-content-title">任职年限:  </td>  
			            	<td class="td-content">
			            		<input name="servicelife" require="true" label="任职年限"  maxlength="30"   maxB="30"  class="td-content-input"  datatype="Integer"  type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">E-mail:  </td>  
			            	<td class="td-content">
			            		<input   name="email"   type="text" style="width:191%"  label="E-mail"   maxlength="50"  maxB="50" datatype="Email"  class="td-content-input"  >
			            	</td>
			            	<td class="td-content-title">  </td>  
			            	<td class="td-content">
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">备注:  </td>  
			            	<td class="td-content" colspan="3" > 
			            	<textarea name="cpmemo"  style="width:82%"   class="td-content-input"  label="备注" maxB="2000"   maxlength="2000"  type="text" ></textarea>
						</td>
			            	 
			            </tr>
			            	<tr class="tr-odd">
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="username" id="creator" label="登记人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">登记时间:</td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" label="登记时间 " isDefaultDate="true"   class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>
			            	<tr class="tr-even">
			            	<td class="td-content-title">修改人 :  </td>  
			            	<td class="td-content">
			            		<input name="modificatorname" id="modificator" label="修改人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">修改时间:</td>  
			            	<td class="td-content">
			            		<input name="modifydate" id="modifydate" label="修改时间" class=" td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>
			           
			            
			        </table>
		        </form>     
	        </center>
		</div>
	<div style="text-align:center;width:900px;display:none;height:50px;line-height:40px;" id="id-dlg-buttons">
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
	</div>

	
</body>
<script language="javascript">
function initCustInfoName(cust_id){
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
        var param={};
        param.custID=cust_id;
        param.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustInfoSelect.xml';
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
	   		    var scustinfo=res.responseText;
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    $("#id_custname").val(currentRowData.name);
	   		    $("#id_custid").val(cust_id);
	   		   currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
		    	 currentLoadMask.hide();
			     },
		     params:param
	 });
    }
</script>
</html>