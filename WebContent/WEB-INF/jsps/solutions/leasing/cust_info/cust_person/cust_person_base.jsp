<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息 - 自然人管理</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MustFillIn.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/custType.js"></script>
</head>
<body >
<script language="javascript">
var cust_id="<%= request.getParameter("cust_id")%>";
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
    function initCustInfo(cust_id){
        var param={};
        param.CUST_ID=cust_id;
        param.xmlFileName='/eleasing/jsp/ewlp_cust/ewlp_info.xml';
        param.loginuser = "${sessionScope['login_userid']}";
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
			   
    		 var scustinfo=res.responseText;
	   		    
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    // var $form=$("#id_custForm form");
	   			$("span").each(function(i, v){
	   		    	 var $v = $(v);
	   		    	var name = $v.attr("name");
		   		    if(name && ("undefined"!=typeof(currentRowData[name.toLowerCase()]))){
		   		    	$v.html(currentRowData[name.toLowerCase()]);
		   		    }
	   		     })
	   		 currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
		    	 currentLoadMask.hide();
			     },
		     params:param
	 });
 }	
    
    $(function(){
    	$(":input").each(function(index,input){
    		$(input).css('border','none');
    		$(input).css('background','none');
    	});
    })
   </script>
 <form>
   <table style="width:100%;height:100%" class="fillTable">
       <tr style="display:none"><td><input name="id" type="hidden" value=""/><input name="custid" type="hidden" value=""/></td></tr>
	   <tr class="tr-even">
			<td class="td-content-title" style="width:15%">客户名称:</td>  
			<td class="td-content" style="width:35%"><span name="custname"></span></td>
			<td class="td-content-title" style="width:15%">客户编号:  </td>  
			<td class="td-content" style="width:35%"><span name="custnumber"></span></td>			  
	   </tr> 
	   <tr class="tr-odd">
			<td class="td-content-title">客户类别:  </td>
			<td class="td-content" colspan="3"><span name="custtypename"></span></td>
		</tr>
	   <tr class="tr-even">
			<td class="td-content-title">性别:</td>
			<td class="td-content"><span name="sexname"></span></td>
			<td class="td-content-title">身份证号码:  </td>  
			<td class="td-content" nowrap="nowrap"><span name="idcardno"></span></td>
		</tr>
			<tr class="tr-odd">
			<td class="td-content-title">民族:  </td>  
			<td class="td-content"><span name="custethnicname"></span></td>
			<td class="td-content-title">出生年月:  </td>  
			<td class="td-content"><span name="brithdate"></span></td>
		</tr>
		
		<tr class="tr-even">
			<td class="td-content-title">客户内部行业:  </td>  
			<td class="td-content"><span name="custkindname"></span></td>
			<td class="td-content-title">获取驾照日期:  </td>  
			<td class="td-content"><span name="driverlicensedate"></span></td>
		</tr>
		<tr class="tr-odd">
			 <td class="td-content-title">开户行:  </td>  
			 <td class="td-content"><span name="taxbank"></span></td>
			 <td class="td-content-title">开户账号:  </td>  
			 <td class="td-content"><span name="taxacc"></span></td>
		</tr>
		<tr class="tr-even">
			 <td class="td-content-title">工作单位</td>  
			 <td class="td-content"><span name="unitname"></span></td>
			 <td class="td-content-title">职务:  </td>  
			 <td class="td-content"><span name="unitpositionname"></span></td>
		</tr>
		<tr class="tr-odd">
			 <td class="td-content-title">省份:  </td>  
			 <td class="td-content"><span name="provincename"></span></td>
			 <td class="td-content-title">城市:  </td>  
			 <td class="td-content"><span name="cityname"></span></td>
		</tr>
		<tr class="tr-even">
			 <td class="td-content-title">区县:  </td>  
			 <td class="td-content" colspan="3"><span name="countyname" ></span></td>
		</tr>
		<tr class="tr-odd">
			 <td class="td-content-title">户口所在地:  </td>  
			 <td class="td-content" colspan="3"><span name="domicileplace"></span></td>
		</tr>
		<tr class="tr-even">
			  <td class="td-content-title">邮寄地址:  </td>  
			  <td class="td-content" colspan="3"><span name="mailadd"></span></td>
		</tr>
		<tr class="tr-odd">
			   <td class="td-content-title">常住地址: </td>  
			   <td class="td-content" colspan="3"><span name="homeadd"></span></td>
		</tr>
			            
		<tr class="tr-even"> 
			    <td class="td-content-title">手机:  </td>  
			    <td class="td-content"><span name="mobilenumber"></span></td>
			    <td class="td-content-title">电话:  </td>  
			    <td class="td-content"><span name="phone"></span></td>
		</tr>
		<tr class="tr-odd">
			    <td class="td-content-title">婚姻状况: </td>  
			    <td class="td-content"><span name="maritalstatusname"></span></td>
			    <td class="td-content-title">学历:  </td>  
			    <td class="td-content"><span name="schoolname"></span></td>
		</tr>
		<tr class="tr-even">
			    <td class="td-content-title">配偶名称: </td>  
			    <td class="td-content"><span name="spousename"></span></td>
			    <td class="td-content-title">配偶联系方式:  </td>  
			    <td class="td-content"><span name="spousecontact"></span></td>
		 </tr>
		 <tr class="tr-odd">
			    <td class="td-content-title">配偶身份证号: </td>  
			    <td class="td-content"><span name="spouseidcardno"></span></td>
			    <td class="td-content-title">配偶年龄:  </td>  
			    <td class="td-content"><span name="spouseage"></span></td>
		 </tr>
		 <tr  class="tr-even">
			    <td class="td-content-title">有无子女: </td>  
			    <td class="td-content"><span name="spousechildname"></span></td>
			    <td class="td-content-title">配偶工作单位:  </td>  
			    <td class="td-content"><span name="spousework" ></span></td>
		 </tr>
		 <tr  class="tr-odd">
			    <td class="td-content-title">自有车辆:  </td>  
			    <td class="td-content" colspan="3"><span name="ownervehicle"></span></td>
		 </tr>
		 <tr   class="tr-even">
			    <td class="td-content-title">房产:  </td>  
			    <td class="td-content" colspan="3"><span name="ownerestate"></span></td>
		 </tr>
		 <tr  class="tr-odd">
			    <td class="td-content-title">土地:  </td>  
			    <td class="td-content" colspan="3"><span name="ownerland"></span></td>
		 </tr>
		 <tr  class="tr-even">
			    <td class="td-content-title">其他:  </td>  
			    <td class="td-content" colspan="3"><span name="ownerother" ></span></td>
		 </tr>
		 <tr   class="tr-odd">
			    <td class="td-content-title">资产估价（总）:  </td>  
			    <td class="td-content" colspan="3"><span name="ownershiptotal"></span></td>
		</tr>
		<tr  class="tr-even">
			    <td class="td-content-title">备注:  </td>  
			    <td class="td-content" colspan="3"><span name="ceimemo"></span></td>
		</tr>
		<tr  class="tr-odd">
			    <td class="td-content-title">是否作废: </td>  
			    <td class="td-content"><span name="invalidname"></span><input name="invalid" id="invalid"  label="是否作废 " class="td-content-readonly" readonly="readonly"  type="hidden" /></td>
			    <td class="td-content-title">是否草稿: </td>  
			    <td class="td-content"><span name="draftname"></span></td>
		</tr>
		<tr  class="tr-even">
			    <td class="td-content-title">经销商:  </td>  
			    <td class="td-content"><span name="dealerorcompanyname"></span></td>
			     <td class="td-content-title">登记人部门:</td>  
			     <td class="td-content"><span name="creatordeptname"></span></td>
			    
		</tr>
		<tr  class="tr-odd">
			    <td class="td-content-title">登记人 :  </td>  
			    <td class="td-content"><span name="creatorname"></span></td>
			     <td class="td-content-title">登记时间: </td>  
			     <td class="td-content" colspan="3"><span name="createdate"></span></td>
		</tr>
		
		<tr  class="tr-even">
		        <td class="td-content-title">修改人 :</td>  
			    <td class="td-content"><span name="modificatorname"></span></td>
			    <td class="td-content-title">修改时间: </td>  
			    <td class="td-content" colspan="3"><span name="modifydate"></span></td>
		</tr>
	</table>
</form>

</body>
<script>
initCustInfo(cust_id);
</script>
</html>